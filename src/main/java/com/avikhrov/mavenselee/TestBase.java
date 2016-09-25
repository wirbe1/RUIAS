/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avikhrov.mavenselee;

/**
 *
 * @author wirbel
 */
public class TestBase implements TestInt{
    
     String testID = "";
     String refNumber = "";
     Boolean isExecuted = false;
     Boolean isSuccessfull = false;
     
    public TestBase(String testID, String refNumber){
        this.testID = testID;
        this.refNumber = refNumber;
    }
    
    @Override
    public int executeTest(String testId, String refNumber){
        
        
        return 0;
    }
    
    
}
