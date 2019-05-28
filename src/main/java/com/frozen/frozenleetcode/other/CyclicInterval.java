package com.frozen.frozenleetcode.other;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: Frozen
 * @create: 2019-05-28 15:35
 * @description: 循环间隔
 **/
public class CyclicInterval {
    public static void main(String[] args) {
        CyclicInterval cyclicInterval = new CyclicInterval();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MICROSECONDS, new LinkedBlockingQueue<>(), new ThreadPoolExecutor.DiscardPolicy());
        int number = 0;
        while (true) {
            try {
                //检查文件的结果
                if (cyclicInterval.inspect()) {
                    number = 0;
                } else {
                    if (cyclicInterval.isGiveAnAlarm(number)) {
                        poolExecutor.execute(new GiveAnAlarm(number));
                    }
                    number++;
                }
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 检查文件的结果
     *
     * @return
     */
    public boolean inspect() {
        Random r = new Random();
        boolean b1 = r.nextBoolean();
        System.out.println("lxcfs文件结果是：" + b1);
        return false;
    }

    /**
     * @param number
     * @return
     */
    public boolean isGiveAnAlarm(int number) {
        if (number == 0) {
            return true;
        }
        if (number == 10) {
            return true;
        }
        return false;
    }


    /**
     * 异步告警
     */
    static class GiveAnAlarm implements Runnable {
        private int number;

        public GiveAnAlarm(int number) {
            this.number = number;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(number);
                System.out.println("异常告警时间：" + number);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
