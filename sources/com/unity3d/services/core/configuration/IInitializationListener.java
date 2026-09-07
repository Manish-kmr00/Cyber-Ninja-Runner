package com.unity3d.services.core.configuration;

/* JADX INFO: loaded from: classes11.dex */
public interface IInitializationListener {
    void onSdkInitializationFailed(String str, ErrorState errorState, int i);

    void onSdkInitialized();
}
