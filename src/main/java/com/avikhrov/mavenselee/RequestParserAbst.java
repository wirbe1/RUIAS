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
public abstract class RequestParserAbst implements RequestParserInt {
    
    private String testId;
    private String cRMNumber;
    
@Override
public String getTestId(String req) throws ParserConfigurationException, IOException{
    return testId;
}    

@Override
public String getCRMNumber(String req){
    return cRMNumber;
}
}
