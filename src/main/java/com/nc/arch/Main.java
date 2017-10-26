package com.nc.arch;

import com.nc.arch.module.Module;
import com.nc.arch.reusemodule.ReuseModule;
import com.nc.arch.reusemodule.config.Configuration;
import com.nc.arch.reusemodule.config.XMLConfiguration;
import com.nc.arch.reusemodule.config.exceptions.BadXMLConfigurationException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;


public class Main {
    private static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        PropertyConfigurator.configure(Main.class.getClassLoader().getResourceAsStream("log4j.properties"));
        Main inst = new Main();
        inst.startModule();
        inst.startReusableModule();
    }

    private void startModule() {
        log.info("Module started...");
        Node moduleConfigNode = null;
        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                    .parse(Module.class.getClassLoader().getResourceAsStream("application-config.xml"));
            moduleConfigNode = (Node) XPathFactory.newInstance().newXPath()
                    .evaluate("/module-config", document, XPathConstants.NODE);
            if(moduleConfigNode != null) {
                new Module(moduleConfigNode);
            }
        } catch (IOException | XPathExpressionException | ParserConfigurationException | SAXException ex) {
            // handle exception here ...
        }
    }

    private void startReusableModule() {
        log.info("Reusable module started...");
        Configuration config = null;
        try {
            config = new XMLConfiguration(ReuseModule.class.getClassLoader().getResourceAsStream("xml-config.xml"));

        } catch (BadXMLConfigurationException ex) {
            // handling exception
        }
        if(config != null) {
            ReuseModule module = new ReuseModule(config);
        }

    }
}