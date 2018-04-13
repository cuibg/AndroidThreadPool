package com.android.cuibg.androidthreadpool;

import android.os.Process;
import android.support.annotation.NonNull;

import java.util.concurrent.ThreadFactory;

/**
 * @author cuibg
 *
 */
public class PriorityThreadFactory implements ThreadFactory {

    private final int mThreadPriority;

    public PriorityThreadFactory(int threadPriority) {
        mThreadPriority = threadPriority;
    }

    @Override
    public Thread newThread(@NonNull Runnable r) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Process.setThreadPriority(mThreadPriority);
            }
        };
        return new Thread(runnable);
    }
}
