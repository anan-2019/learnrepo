package com.self.learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import java.util.Collections;

/**
 * @Classname Schedulelearn
 * @Date 2021/4/15 12:19 上午
 * @Created by anan
 * @Description description here
 */
public class Schedulelearn {
    public static  final Logger logger = LoggerFactory.getLogger(Schedulelearn.class);
    public static void main(String[] args) {
        Subscription subscribe = Observable
                .create(new Observable.OnSubscribe<Integer>() {
                    @Override
                    public void call(Subscriber<? super Integer> subscriber) {
                        System.out.println("create" + " "  + Thread.currentThread().getName());
                        subscriber.onNext(1);
                        subscriber.onCompleted();
                    }
                })
                .map(new Func1<Integer, Integer>() {
                    @Override
                    public Integer call(Integer integer) {
                        System.out.println("map1" + " "  + Thread.currentThread().getName());
                        return integer;
                    }
                })
                .flatMap(new Func1<Integer, Observable<Integer>>() {
                    @Override
                    public Observable<Integer> call(Integer integer) {
                        System.out.println("flatMap" + " "  + Thread.currentThread().getName());
                        return Observable.from(Collections.singleton(integer));
                    }
                })
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("运行结束" + " "  + Thread.currentThread().getName());
                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onNext(Integer r) {
                        System.out.println("输出结果为：" + r + " " + Thread.currentThread().getName());
                    }
                });
        subscribe.unsubscribe();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
