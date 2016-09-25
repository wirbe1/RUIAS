package com.avikhrov.mavenselee;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Enterprise Application Client main class.
 *
 */
public class Main {
    
    public static void main( String[] args ) throws InterruptedException {
        System.out.println( "Hello World Enterprise Application Client!" );
        
                       System.setProperty("webdriver.chrome.driver", "C:\\server\\selenium\\chromedriver.exe"); 
       WebDriver webDriver = new ChromeDriver();
       webDriver.get("http://ya.ru");
       
       System.out.println(webDriver.getTitle());
       
       Thread.sleep(1000);
       
       webDriver.quit();
       
        
        
    }
}
