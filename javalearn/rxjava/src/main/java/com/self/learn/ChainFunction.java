package com.self.learn;

import com.netflix.hystrix.*;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Observable;
import rx.Subscriber;

import java.util.Collections;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Classname ChainFunction
 * @Date 2021/4/20 11:02 上午
 * @Created by anan
 * @Description description here
 */
public class ChainFunction {
    private static Function<Integer, Integer> a = value -> value + 10;
    private static Function<Integer, Function<Function<Integer, Integer>, Function<Integer, Observable>>> test = key1 -> key2 -> key3 -> {
//        return Observable.from(test(key1, key2, key3));
        Supplier supplier = ()->{
            System.out.println("组装完成");
            return test(key1, key2, key3);
        };
        MyHystrixCommand myHystrixCommand = new MyHystrixCommand("","",supplier,"","");

        return myHystrixCommand.observe();
    };

    public static void main(String[] args) throws InterruptedException {
        Function<Function<Integer, Integer>, Function<Integer, Observable>> apply1 = test.apply(2);
        Function<Integer, Observable> apply = test.apply(2).apply(a);


//        Observable apply = test.apply(1).apply(a).apply(2);
        Thread.sleep(1000);
        System.out.println("创建完成");

//        apply.subscribe(System.out::println);
    }

    public static Integer test(Integer key1, Function<Integer, Integer> key2, Integer key3) {
        System.out.println("开始计算");
        return key2.apply(key1) + key3;
    }

}

class MyHystrixCommand<R> extends HystrixCommand<R> {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyHystrixCommand.class);

    private final String desc;
    private final Supplier<R> f;
    private final String logEventType;
    private final String logRequest;

    public MyHystrixCommand(String name, String desc, Supplier<R> f, String logEventType, String logRequest) {
//        super(com.netflix.hystrix.HystrixCommand.Setter.withGroupKey(
//                HystrixCommandGroupKey.Factory.asKey("")).andCommandPropertiesDefaults(
//                HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(5000)));
        super(HystrixCommandGroupKey.Factory.asKey(name));
        this.desc = desc;
        this.f = f;
        this.logEventType = logEventType;
        this.logRequest = logRequest;
    }

    @Override
    public R run() throws Exception {
        long start = System.currentTimeMillis();
        LOGGER.info("{}", desc);

        try {
            return f.get();
        } catch (Exception e) {
            LOGGER.error(desc, e);
            throw e;
        } finally {
            long end = System.currentTimeMillis();

            long ms = (end - start);

//                Integer.valueOf("s");
            LOGGER.info("takes {}ms {}", ms, desc);
        }
    }

    @Override
    protected R getFallback() {
        return super.getFallback();
    }
};

