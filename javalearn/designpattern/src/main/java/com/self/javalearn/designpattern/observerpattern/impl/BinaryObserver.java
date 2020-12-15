package com.self.javalearn.designpattern.observerpattern.impl;

import com.self.javalearn.designpattern.observerpattern.Observer;
import com.self.javalearn.designpattern.observerpattern.Subject;

public class BinaryObserver extends Observer {
 
   public BinaryObserver(Subject subject){
      this.subject = subject;
      this.subject.attach(this);
   }
 
   @Override
   public void update() {
      System.out.println( "Binary String: " 
      + Integer.toBinaryString( subject.getState() ) ); 
   }
}