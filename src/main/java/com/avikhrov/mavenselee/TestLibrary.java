/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avikhrov.mavenselee;

import com.avikhrov.mavenselee.tests.TestDCIPBereitstellungTransport;

/**
 *
 * @author wirbel
 */
public class TestLibrary {
    
    public TestBase getTestById(String testID, String refNumber){
        
        switch(testID) {
    case "001": 
	    
        return new TestDCIPBereitstellungTransport(testID, refNumber);
		
    case "002": 
	    ;
		break;
    default: 
        ;
                break;

}
        
        
        
        return null;
    }


    
}
