package org.xmlcml.cml.base;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.validation.ValidatorHandler;

import nu.xom.Nodes;
import nu.xom.converters.SAXConverter;

import org.xml.sax.SAXException;

/**
 * Validates against CML schema. Uses singleton pattern, since loading schema
 * is time consuming, and only needs doing once.
 * @author sea36
 *
 */
public class CMLSchemaValidator {

    private static final String SCHEMA_FILE = "schema.xsd";

    private static CMLSchemaValidator instance;

    private Schema schema;


    /**
     * Fetches instance of schema validator.
     * @return validator
     * @throws IOException - if schema file is not found.
     * @throws CMLException - if schema cannot be parsed.
     */
    public static CMLSchemaValidator getInstance() throws IOException {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }

    private static synchronized void createInstance() throws IOException {
        if (instance == null) {
            instance = new CMLSchemaValidator();
        }
    }

    private CMLSchemaValidator() throws IOException {

        // Load schema
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        // load a WXS schema, represented by a Schema instance
        InputStream is = getClass().getResourceAsStream(SCHEMA_FILE);
        if (is == null) {
            throw new IOException("Cannot find schema file: " + SCHEMA_FILE);
        }
        try {
            Source schemaFile = new StreamSource(is);
            schema = factory.newSchema(schemaFile);
        } catch (SAXException e) {
            throw new RuntimeException("invalid schema", e);
        } finally {
            is.close();
        }
    }


    /**
     * Validates XML from javax.xml.transform.Source against CML schema.
     * Throws exception if validation fails.
     * @param source
     * @throws IOException - if problem reading xml.
     * @throws CMLException - if xml does not validate against CML schema.
     */
    public void validateCML(Source source) throws IOException {
        Validator validator = schema.newValidator();
        try {
            validator.validate(source);
        } catch (SAXException e) {
            throw new RuntimeException("not valid CML", e);
        }
    }

    /**
     * Validates XML from java.io.InputStream against CML schema.
     * Throws exception if validation fails.
     * @param in
     * @throws IOException
     * @throws CMLException
     */
    public void validateCML(InputStream in) throws IOException {
        validateCML(new StreamSource(in));
    }

    /**
     * Validates XML from java.io.Reader against CML schema.
     * Throws exception if validation fails.
     * @param in
     * @throws IOException
     * @throws CMLException
     */
    public void validateCML(Reader in) throws IOException {
        validateCML(new StreamSource(in));
    }


    /**
     * Validates XML from nu.xom.Document against CML schema.
     * Throws exception if validation fails.
     * @param d
     * @throws IOException
     * @throws CMLException
     */
    public void validateCML(nu.xom.Document d) throws IOException {
        ValidatorHandler handler = schema.newValidatorHandler();
        SAXConverter converter = new SAXConverter(handler);
        try {
            converter.convert(d);
        } catch (SAXException e) {
            throw new RuntimeException("not valid CML", e);
        }
    }

    /**
     * Validates XML from nu.xom.Node against CML schema.
     * Throws exception if validation fails.
     * @param node
     * @throws IOException
     * @throws CMLException
     */
    public void validateCML(nu.xom.Node node) throws IOException {
        ValidatorHandler handler = schema.newValidatorHandler();
        SAXConverter converter = new SAXConverter(handler);
        try {
            converter.convert(new Nodes(node));
        } catch (SAXException e) {
            throw new RuntimeException("not valid CML", e);
        }
    }

    /**
     * Validates XML from org.w3c.dom.Node against CML schema.
     * Throws exception if validation fails.
     * @param node
     * @throws IOException
     * @throws CMLException
     */
    public void validateCML(org.w3c.dom.Node node) throws IOException {
        DOMSource source = new DOMSource(node);
        validateCML(source);
    }

}
