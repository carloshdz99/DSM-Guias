package sv.udb.edu.guia03app;

import android.util.Log;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.LifecycleEventObserver;

public class MyLifeCycleObserver implements LifecycleObserver {
    private static final String TAG = "MylifeCycleObserver";

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void OnCreate(){
        Log.i(TAG, "OnCreate");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void OnStart(){
        Log.i(TAG, "OnStart");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void OnPause(){
        Log.i(TAG, "OnPause");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void OnResume(){
        Log.i(TAG, "OnResume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void OnStop(){
        Log.i(TAG, "OnStop");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void OnDestroy(){
        Log.i(TAG, "OnDestroy");
    }
}
