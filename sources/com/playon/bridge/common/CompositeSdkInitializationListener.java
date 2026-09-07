package com.playon.bridge.common;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes6.dex */
public class CompositeSdkInitializationListener implements SdkInitializationListener {
    private SdkInitializationListener mSdkInitializationListener;
    private int mTimes;

    public CompositeSdkInitializationListener(SdkInitializationListener sdkInitializationListener, int i) {
        this.mSdkInitializationListener = sdkInitializationListener;
        this.mTimes = i;
    }

    @Override // com.playon.bridge.common.SdkInitializationListener
    public void onInitializationFinished() {
        int i = this.mTimes - 1;
        this.mTimes = i;
        if (i <= 0) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.playon.bridge.common.CompositeSdkInitializationListener$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5491xfbcccd49();
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$onInitializationFinished$0$com-playon-bridge-common-CompositeSdkInitializationListener, reason: not valid java name */
    /* synthetic */ void m5491xfbcccd49() {
        SdkInitializationListener sdkInitializationListener = this.mSdkInitializationListener;
        if (sdkInitializationListener != null) {
            sdkInitializationListener.onInitializationFinished();
            this.mSdkInitializationListener = null;
        }
    }
}
