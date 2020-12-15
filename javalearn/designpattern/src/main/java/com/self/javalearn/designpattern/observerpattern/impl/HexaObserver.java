package com.self.javalearn.designpattern.observerpattern.impl;

import com.self.javalearn.designpattern.observerpattern.Observer;
import com.self.javalearn.designpattern.observerpattern.Subject;

public class HexaObserver extends Observer {
 
   public HexaObserver(Subject subject){
      this.subject = subject;
      this.subject.attach(this);
   }
 
   @Override
   public void update() {
      System.out.println( "Hex String: " 
      + Integer.toHexString( subject.getState() ).toUpperCase() ); 
   }
}