package com.android.cuibg.androidthreadpool;

/**
 * 优先级的
 */
public class PriorityRunnable implements Runnable {
    private final Priority priority;

    public PriorityRunnable(Priority priority) {
        this.priority = priority;
    }
    @Override
    public void run() {
        //这里不要处理逻辑
    }

    public Priority getPriority() {
        return priority;
    }
}
