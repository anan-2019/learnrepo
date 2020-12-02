package com.self.javalearn.baselearn.limit.locallimit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName TokenLimiter
 * @Author 51205 TRN
 * @Date 2020/12/2 13:42
 * @Version 1.0
 * @Description Class Function Description Here
 */
public class TokenLimiter {
    private static Logger logger = LoggerFactory.getLogger(TokenLimiter.class);

    private ArrayBlockingQueue<String> blockingQueue;
    private int limit;
    private TimeUnit timeUnit;
    private int period;

    public TokenLimiter(int limit, TimeUnit timeUnit, int period) {
        this.blockingQueue = new ArrayBlockingQueue<>(limit);
        this.limit = limit;
        this.timeUnit = timeUnit;
        this.period = period;
        init();
        start();
    }

    public boolean getToken(){
        return blockingQueue.poll() != null;
    }

    private void addToken(){
        blockingQueue.offer("1");
    }

    private void start() {
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(this::addToken,10,period,timeUnit);
    }

    private void init() {
        for (int i = 0; i < limit; i++) {
            blockingQueue.add("1");
        }
    }
}
