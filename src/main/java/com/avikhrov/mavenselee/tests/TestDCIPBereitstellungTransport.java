/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avikhrov.mavenselee.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author wirbel
 */
public class TestDCIPBereitstellungTransport extends com.avikhrov.mavenselee.TestBase{

    public TestDCIPBereitstellungTransport(String testID, String refNumber) {
        super(testID, refNumber);
    }
    
        @Override
    public int executeTest(String testId, String refNumber){
        
                    
       System.setProperty("webdriver.chrome.driver", "C:\\server\\selenium\\chromedriver.exe"); 
       WebDriver webDriver = new ChromeDriver();
       webDriver.get("http://ya.ru");
       
       System.out.println(webDriver.getTitle());
        
        
        return 0;
    }
    
 
    
}
