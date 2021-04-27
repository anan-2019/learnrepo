package com.self.learn;


import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * @Classname Main
 * @Date 2021/4/14 9:10 下午
 * @Created by anan
 * @Description description here
 */
public class Observablebase {
    public static void main(String[] args) {
        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello");
                subscriber.onNext("Hi");
                subscriber.onNext("Aloha");
                subscriber.onCompleted();
            }
        });

        observable = Observable.just("Hello","HI","Aloha1");

        String[] string = {"Hello","HI","Aloha2"};
        observable = Observable.from(string).observeOn(Schedulers.immediate()).map(x->{
            System.out.println("创建完成");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return x+"测试";
        });

        Action0 action0 = new Action0() {
            @Override
            public void call() {
                System.out.println("我是自定义的");
            }
        };

        Action1<String> action1 = new Action1<String>() {
            @Override
            public void call(String o) {
                System.out.println("删除"+o);
            }
        };

        observable.subscribe(action1);


//
//
//        observable.subscribe(new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//                System.out.println("结束");
//            }
//
//            @Override
//            public void onError(Throwable throwable) {
//                throwable.printStackTrace();
//                System.out.println("2334");
//            }
//
//            @Override
//            public void onNext(String o) {
//                System.out.println(o);
//            }
//        });

//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("主线程结束");

    }
}
