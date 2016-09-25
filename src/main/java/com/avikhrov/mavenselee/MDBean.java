/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avikhrov.mavenselee;

import java.beans.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.xml.parsers.ParserConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author wirbel
 */
@MessageDriven(
        //имя topic, на который подписан бин
        mappedName="jms/ExecuteTestIn_local",
        name = "MDBean")
public class MDBean implements MessageListener {
    
    
    public void onMessage(Message msg) {
        try {
            TextMessage message = (TextMessage)msg;
            //считываем свойство из соответствующего поля, заданное вручную в consumer
           // System.out.println("FROM MDB - client type IS " + message.getStringProperty("clientType"));
            //считываем  само сообщение
            System.out.println("Message received:  " + message.getText());
            
            String req = message.getText();
            
            RequestParser requestParser = new RequestParser();
            String testID = requestParser.getTestId(req);
            String refNumber = requestParser.getTestId(req);
            
            
            
            TestBase testCase = new TestLibrary().getTestById(testID, refNumber); //Geting testcase from tests package using ID from request
            
            testCase.executeTest(testCase.testID, testCase.refNumber); //Running testCase
            
            
                    
                    
                    
                    

       
            
            
            
             System.out.println("Test ID is: ------->  ");      
            
            
            
        } catch (JMSException ex) {
            ex.printStackTrace();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MDBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MDBean.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
    
    private String sampleProperty;
    
    private PropertyChangeSupport propertySupport;
    
    public MDBean() {
        propertySupport = new PropertyChangeSupport(this);
    }
    
    public String getSampleProperty() {
        return sampleProperty;
    }
    
    public void setSampleProperty(String value) {
        String oldValue = sampleProperty;
        sampleProperty = value;
        propertySupport.firePropertyChange(PROP_SAMPLE_PROPERTY, oldValue, sampleProperty);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
    
}
