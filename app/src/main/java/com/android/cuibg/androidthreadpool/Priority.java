package com.android.cuibg.androidthreadpool;

/**
 * 优先级别
 * @author cuibg
 */
public enum Priority {
    /**
     * 注意：任何情况下都不要改变常量的顺序
     */

    /**
     * 低等级
     */
    LOW,

    /**
     * 中间等级
     */
    MEDIUM,

    /**
     * 高等级
     */
    HIGH,

    /**
     * 超高等级.
     */
    IMMEDIATE;

}
