package com.self.javalearn.designpattern.observerpattern;

import com.self.javalearn.designpattern.observerpattern.impl.BinaryObserver;
import com.self.javalearn.designpattern.observerpattern.impl.HexaObserver;
import com.self.javalearn.designpattern.observerpattern.impl.OctalObserver;

/**
 * 观察者模式的中心思想
 */
public class Main {
   public static void main(String[] args) {
      Subject subject = new Subject();
 
      new HexaObserver(subject);
      new OctalObserver(subject);
      new BinaryObserver(subject);
 
      System.out.println("First state change: 15");   
      subject.setState(15);
      System.out.println("Second state change: 10");  
      subject.setState(10);
   }
}