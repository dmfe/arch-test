package com.nc.arch.reusemodule.config;

import com.nc.arch.reusemodule.config.exceptions.BadXMLConfigurationException;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

public class XMLConfiguration extends AbstractConfiguration {

    public XMLConfiguration(Node xmlNode) {
        init(xmlNode);
    }

    public XMLConfiguration(InputStream src) throws BadXMLConfigurationException {
        if(src == null)
            throw new IllegalArgumentException("Configuration input stream can't be null!");
        try {
            init(DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(src));
        } catch(Exception ex) {
            // SAXException
            // IOException
            throw new BadXMLConfigurationException(ex);
        }
    }

    private void init(Node xmlNode) {
        // ...Initializing config
    }
}