/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avikhrov.mavenselee;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
//import jdk.internal.org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author wirbel
 */




public class RequestParser extends RequestParserAbst{
    
    private String testId;
    private String cRMNumber;
    
  
    @Override
    public String getTestId(String req) throws ParserConfigurationException, IOException{
        
        
        
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        StringBuilder xmlStringBuilder = new StringBuilder();
        xmlStringBuilder.append(req);

        ByteArrayInputStream input =  new ByteArrayInputStream(
                xmlStringBuilder.toString().getBytes("UTF-8"));

        Document doc = null;
        try {
            doc = dBuilder.parse(input);
        } catch (org.xml.sax.SAXException ex) {
            Logger.getLogger(RequestParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        doc.getDocumentElement().normalize();
        Node node = null;
        node =  doc.getDocumentElement();

        if (doc.getDocumentElement().getNodeName().equals("geschaeftsfall-ausloesen-fault")) return null;  // If fault root element is found return null
        else {

            NodeList methodNodes = node.getChildNodes();

            NodeList children = node.getChildNodes(); // find parameter in first chierarchy level
            for (int i = 0; i < children.getLength(); i++) {
                Node nodeCh = children.item(i);
               // System.out.println(nodeCh.getTextContent());
                if (nodeCh.getNodeName().equals(TEST_ID_FIELD)) return nodeCh.getTextContent();

                if(nodeCh.hasChildNodes() == true) { //if sub levels exist - find parameter in second chierarchy level

                    NodeList subChildren = nodeCh.getChildNodes();
                    for (int j = 0; j < subChildren.getLength(); j++) {
                        Node nodeSubCh = subChildren.item(j);
                       // System.out.println(nodeSubCh.getTextContent());
                        if (nodeSubCh.getNodeName().equals(TEST_ID_FIELD)) return nodeSubCh.getTextContent();


                    }

                }

            }



        }
        
        
        
        
        
        
    return testId;
}    

    @Override
    public String getCRMNumber(String req){
    return cRMNumber;
}
    
}
