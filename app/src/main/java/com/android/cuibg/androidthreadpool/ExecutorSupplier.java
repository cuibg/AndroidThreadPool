package com.android.cuibg.androidthreadpool;

import android.os.Process;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 * 线程池提供者
 * @author cuibg
 * @Email cuibenguang@gmail.com
 */
public class ExecutorSupplier {
    /*
     * 核心线程的个数
     */
    public static final int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();

    /*
     * 后台的线程池执行者
     */
    private ThreadPoolExecutor mBackgroundTasksExecutor;
    /*
     * 轻任务线程执行器
     */
    private ThreadPoolExecutor mLightWeightBackgroundTasksExecutor;
    /*
     * 主线程执行器
     */
    private Executor mMainThreadExecutor;
    /*
     * 执行器提供者实例
     */
    private static ExecutorSupplier sInstance;

    /*
     * 返回实例
     */
    public static ExecutorSupplier getInstance() {
        if (sInstance == null) {
            synchronized (ExecutorSupplier.class) {
                sInstance = new ExecutorSupplier();
            }
        }
        return sInstance;
    }


    private ExecutorSupplier() {
        // 设置线程工厂
        ThreadFactory backgroundPriorityThreadFactory = new
                PriorityThreadFactory(Process.THREAD_PRIORITY_BACKGROUND);

        mBackgroundTasksExecutor = new PriorityThreadPoolExecutor(
                NUMBER_OF_CORES * 2,
                NUMBER_OF_CORES * 2,
                60L,
                TimeUnit.SECONDS,
                backgroundPriorityThreadFactory
        );

        mLightWeightBackgroundTasksExecutor = new PriorityThreadPoolExecutor(
                NUMBER_OF_CORES * 2,
                NUMBER_OF_CORES * 2,
                60L,
                TimeUnit.SECONDS,
                backgroundPriorityThreadFactory
        );

        mMainThreadExecutor = new MainThreadExecutor();
    }

    public ThreadPoolExecutor getBackgroundTasksExecutor() {
        return mBackgroundTasksExecutor;
    }

    public ThreadPoolExecutor getLightWeightBackgroundTasksExecutor() {
        return mLightWeightBackgroundTasksExecutor;
    }

    public Executor getMainThreadExecutor() {
        return mMainThreadExecutor;
    }
}