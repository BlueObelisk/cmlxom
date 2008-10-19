package org.xmlcml.cml.command;

import org.xmlcml.cml.base.CMLBuilder;

public class JumboCommand {

	protected final static CMLBuilder CML_BUILDER = new CMLBuilder();
	protected Handle handle;
	
	protected JumboCommand() {
		handle = new Handle();
	}
	public Handle getHandle() {
		return handle;
	}
}
