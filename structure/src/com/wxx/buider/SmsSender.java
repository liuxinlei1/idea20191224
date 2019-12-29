package com.wxx.buider;

public class SmsSender implements Sender {  
    @Override  
     public void Send() {  
         System.out.println("this is sms sender!");  
     }  
}