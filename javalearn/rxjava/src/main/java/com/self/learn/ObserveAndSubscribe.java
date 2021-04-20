package com.self.learn;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.schedulers.Schedulers;

import java.util.concurrent.Executors;

/**
 * @Classname ObserveAndSubscribe
 * @Date 2021/4/15 10:33 上午
 * @Created by anan
 * @Description description here
 */
public class ObserveAndSubscribe {
    public static void main(String[] args) {
        Observable
                .create(new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        threadInfo("OnSubscribe.call()");
                        subscriber.onNext("RxJava1");
                    }
                })
                .subscribeOn(getNamedScheduler("create之后的subscribeOn"))
                .doOnSubscribe(() -> threadInfo(".doOnSubscribe()-1"))
                .subscribeOn(getNamedScheduler("doOnSubscribe1之后的subscribeOn"))
                .doOnSubscribe(() -> threadInfo(".doOnSubscribe()-2"))
                .subscribeOn(getNamedScheduler("xxxxn"))
//                .observeOn(getNamedScheduler("test"))
                .subscribe(s -> {
                    threadInfo(".onNext()");
                    System.out.println(s + "-onNext " + Thread.currentThread().getName());
                });
    }

    public static Scheduler getNamedScheduler(String name) {
        return Schedulers.from(Executors.newCachedThreadPool(r -> new Thread(r, name)));
    }

    public static void threadInfo(String caller) {
        System.out.println(caller + " => " + Thread.currentThread().getName());
    }
}
