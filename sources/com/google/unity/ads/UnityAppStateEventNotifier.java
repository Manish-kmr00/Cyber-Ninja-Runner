package com.google.unity.ads;

import android.app.Activity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;

/* JADX INFO: loaded from: classes4.dex */
public class UnityAppStateEventNotifier implements DefaultLifecycleObserver {
    private final Activity activity;
    private final UnityAppStateEventCallback callback;

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onCreate(LifecycleOwner owner) {
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(LifecycleOwner owner) {
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onPause(LifecycleOwner owner) {
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(LifecycleOwner owner) {
    }

    public UnityAppStateEventNotifier(Activity activity, UnityAppStateEventCallback callback) {
        this.activity = activity;
        this.callback = callback;
    }

    public void startListening() {
        this.activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.UnityAppStateEventNotifier.1
            @Override // java.lang.Runnable
            public void run() {
                ProcessLifecycleOwner.get().getLifecycle().addObserver(UnityAppStateEventNotifier.this);
            }
        });
    }

    public void stopListening() {
        this.activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.UnityAppStateEventNotifier.2
            @Override // java.lang.Runnable
            public void run() {
                ProcessLifecycleOwner.get().getLifecycle().removeObserver(UnityAppStateEventNotifier.this);
            }
        });
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStart(LifecycleOwner owner) {
        this.callback.onAppStateChanged(false);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(LifecycleOwner owner) {
        this.callback.onAppStateChanged(true);
    }
}
