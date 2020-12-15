package com.self.javalearn.designpattern.observerpattern;

public abstract class Observer {
   protected Subject subject;
   public abstract void update();
}