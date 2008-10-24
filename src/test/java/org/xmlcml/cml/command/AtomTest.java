package org.xmlcml.cml.command;

import nu.xom.Attribute;
import nu.xom.Element;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.xmlcml.cml.base.CMLUtil;

public class AtomTest {
	private static Logger LOG = Logger.getLogger(AtomTest.class);
	static {
		LOG.setLevel(Level.DEBUG);
	}
	
	//
	@Test
	public void createFromXML() {
		Handle atomHandle = new ElementCommand().readCML(
			"<atom id='b1' xmlns='http://www.xml-cml.org/schema'/>");
		TestUtils.testValidContent(atomHandle);
	}

	/**
	  <pattern id="atom.checks">
	    <title>atom element checks</title>
	    <p><h:p>Describe what further limitations we have put on the atom element</h:p></p>
	    <rule context="cml:atom">
	      <p>
	      Check that the id of this atom is unique within the eldest containing molecule
	      The schema validation specifies that each atom must have an id, this check tests
	      the uniqueness
	      </p>
	      <assert test="count(ancestor::cml:molecule[1]//cml:atom[@id = current()/@id]) = 1">the id of a atom must be unique within the eldest containing molecule (duplicate found: <value-of select="@id" />)</assert>
	      <p>
	      If x2 is present the y2 must be present
	      </p>
	      <assert test="not(@x2) or (@x2 and @y2)">if atom has @x2 then it must have @y2</assert>
	      <p>
	      If y2 is present the x2 must be present
	      </p>
	      <assert test="not(@y2) or (@x2 and @y2)">if atom has @y2 then it must have @x2</assert>
	      <p>
	      If x3 is present then y3 and z3 must be present
	      </p>
	      <assert test="not(@x3) or (@x3 and @y3 and @z3)">if atom has @x3 then it must have @y3 and @z3</assert>
	      <p>
	      If y3 is present then x3 and z3 must be present
	      </p>
	      <assert test="not(@y3) or (@x3 and @y3 and @z3)">if atom has @32 then it must have @x3 and @z3</assert>
	      <p>
	      If x3 is present then y3 and z3 must be present
	      </p>
	      <assert test="not(@z3) or (@x3 and @y3 and @z3)">if atom has @z3 then it must have @x3 and @y3</assert>
	    </rule>    
	  </pattern>
	 */		
	@Test
	public void testAtomAssertions() {
		// ok
		Handle handle = new ElementCommand().createElement("atom");
		// invalid at level of assertions
		TestUtils.testInvalidAssertions(handle, 
			"fails assertion: count(ancestor::cml:molecule[1]//cml:atom[@id = current()/@id]) = 1");
		// now valid - has id and ancestor molecule
		handle = new ElementCommand().readCML(
				"<molecule xmlns='http://www.xml-cml.org/schema'><atomArray><atom id='a1'/></atomArray></molecule> ");
		TestUtils.testValidAssertions(handle.getElement()); 
	}
	
	@Test
	public void testCoordinates() {
//	      <assert test="not(@x2) or (@x2 and @y2)">if atom has @x2 then it must have @y2</assert>
		Handle handle = new ElementCommand().readCML(
				"<molecule xmlns='http://www.xml-cml.org/schema'>" +
				"<atomArray><atom x2='1.0' y2='1.0' id='a1'/></atomArray></molecule> ");
		Element atom = getGrandchild(handle);
		System.out.println("AT "+atom.getAttributeValue("id"));
// FIXME		TestUtils.testValidAssertions(atom); 
		handle = new ElementCommand().readCML(
				"<molecule xmlns='http://www.xml-cml.org/schema'>" +
				"<atomArray><atom y2='1.0' id='a1'/></atomArray></molecule> ");
// FIXME		TestUtils.testValidAssertions(atom); 
	}

	/**
	 * @param handle
	 * @return
	 */
	private Element getGrandchild(Handle handle) {
		Element atom = (Element) ((Element)handle.getElement().getChild(0)).getChild(0);
		return atom;
	}
	
	@Test
	public void testDupicateId() {
		Handle handle = new ElementCommand().readCML("<molecule xmlns='http://www.xml-cml.org/schema'><atomArray><atom id='a1'/></atomArray></molecule> ");
		TestUtils.testValidAssertions(handle); 
		// invalid - has duplicate id (picked up by JUMBO)
		try {
			handle = new ElementCommand().readCML(
				"<molecule xmlns='http://www.xml-cml.org/schema'>" +
				"  <atomArray>" +
				"    <atom id='a1'/>" +
				"    <atom id='a1'/>" +
				"  </atomArray>" +
				"</molecule> ");
			Assert.fail("should fail on duplicate id");
		} catch (RuntimeException e) {
			
		}
		// create in 2 stages
		// ok
		try {
			handle = new ElementCommand().readCML(
				"<molecule xmlns='http://www.xml-cml.org/schema'>" +
				"  <atomArray>" +
				"    <atom id='a1'/>" +
				"    <atom id='a2'/>" +
				"  </atomArray>" +
				"</molecule> ");
		} catch (RuntimeException e) {
			throw new RuntimeException("should not fail on valid CML");
		}
		// now change the attribute sneakily to create a duplicate
		Element atomArray = handle.getElement().getChildElements().get(0);
		Element atom1 = atomArray.getChildElements().get(0);
		atom1.getAttribute("id").detach();
		atom1.addAttribute(new Attribute("id", "a2"));
		String message = CMLUtil.equalsCanonically(
				"<molecule xmlns='http://www.xml-cml.org/schema'>" +
				"  <atomArray>" +
				"    <atom id='a2'/>" +
				"    <atom id='a2'/>" +
				"  </atomArray>" +
				"</molecule> "
				, handle.getElement(), true);
		// it's now invalid but we have tricked the system
		// now test it
//		TestUtils.testInvalidAssertions(handle, "");
	}
	
	/**
  ( label* & 
    name* & 
    atomParity? 
  ) 
	 */
	@Test
	public void testContentModel() {
		// empty content is valid
		Handle atomHandle = new ElementCommand().createElement("atom");
		TestUtils.testValidContent(atomHandle);
		// single atomParity is ok
		Handle atomParityHandle = new ElementCommand().createElement("atomParity");
		atomHandle.appendChild(atomParityHandle);
		TestUtils.testValidContent(atomHandle);
		// add label and name
		Handle nameParityHandle = new ElementCommand().createElement("name");
		atomHandle.appendChild(nameParityHandle);
		Handle labelParityHandle = new ElementCommand().createElement("label");
		atomHandle.appendChild(labelParityHandle);
		TestUtils.testValidContent(atomHandle);
		// repeat label and name
		nameParityHandle = new ElementCommand().createElement("name");
		atomHandle.appendChild(nameParityHandle);
		labelParityHandle = new ElementCommand().createElement("label");
		atomHandle.appendChild(labelParityHandle);
		TestUtils.testValidContent(atomHandle);
		// invalid content - 2 atomParities
		atomParityHandle = new ElementCommand().createElement("atomParity");
		atomHandle.appendChild(atomParityHandle);
		TestUtils.testInvalidContent(atomHandle);
	}
}
