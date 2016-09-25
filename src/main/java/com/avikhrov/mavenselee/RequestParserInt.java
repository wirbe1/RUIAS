/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avikhrov.mavenselee;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
//import jdk.internal.org.xml.sax.SAXException;

/**
 *
 * @author wirbel
 */
public interface RequestParserInt {
    
    final String TEST_ID_FIELD = "TestID";
    
    String getTestId(String req)  throws ParserConfigurationException, IOException;
    
    String getCRMNumber(String req);
    
    
}
