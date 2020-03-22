package com.stem.lifecycles01;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.Chronometer;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 *技术总结:
 * 1. 获取系统时间的两种方式和总结
 * 2. Chronometer 的 使用
 * 3. LifeCycleObserver 和 getLifecycle().addObserver()的配对使用
 * 4. OnLifecycleEvent 注解事件的用法
 * 5. 自定义类中static变量对activity 重新创建的影响
 */
public class MyChronometer extends Chronometer implements LifecycleObserver {
    private static long elapsedTime ;
    public MyChronometer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void pauseMeter(){
        elapsedTime = SystemClock.elapsedRealtime()-getBase();
        stop();
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void resumeMeter(){
        setBase(SystemClock.elapsedRealtime()-elapsedTime);
        start();
    }
}
