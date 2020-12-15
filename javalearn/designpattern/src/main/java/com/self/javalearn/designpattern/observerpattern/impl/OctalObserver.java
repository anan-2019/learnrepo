package com.self.javalearn.designpattern.observerpattern.impl;

import com.self.javalearn.designpattern.observerpattern.Observer;
import com.self.javalearn.designpattern.observerpattern.Subject;

public class OctalObserver extends Observer {
 
   public OctalObserver(Subject subject){
      this.subject = subject;
      this.subject.attach(this);
   }
 
   @Override
   public void update() {
     System.out.println( "Octal String: " 
     + Integer.toOctalString( subject.getState() ) ); 
   }
}