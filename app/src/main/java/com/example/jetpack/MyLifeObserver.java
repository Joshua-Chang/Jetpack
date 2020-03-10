package com.example.jetpack;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import static com.example.jetpack.Cons.TAG;

/**
 * todo Lifecycle使用
 * 我们用这个观查者来盯好需要感知生命周期的对象
 */
public class MyLifeObserver implements LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private void myOnStart(){
        Log.e(TAG,"onStart");
    }
}
