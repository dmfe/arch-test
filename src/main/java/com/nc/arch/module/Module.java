package com.nc.arch.module;

import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Module {

    public static final String DEFAULT_CONFIG_NAME = "config.xml";

    public Module() throws IOException, ParserConfigurationException, SAXException {
        this(DEFAULT_CONFIG_NAME);
    }

    public Module(String configName) throws IOException, ParserConfigurationException, SAXException {
        this(new FileInputStream(configName));
    }

    public Module(InputStream is) throws IOException, ParserConfigurationException, SAXException {
        this(DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is));
    }

    public Module(Node configNode) throws IOException, ParserConfigurationException, SAXException {
        Configuration configuration = new Configuration();
        // working with configNode to get configuration...
        init(configuration);
    }

    private void init(Configuration configuration) {
        // initialization code...
    }

    private static class Configuration {
        // some fields...
    }
}