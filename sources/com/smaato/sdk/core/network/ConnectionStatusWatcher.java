package com.smaato.sdk.core.network;

/* JADX INFO: loaded from: classes9.dex */
public interface ConnectionStatusWatcher {

    public interface Callback {
        void onConnectionStateChanged();
    }

    boolean isCallbackRegistered();

    void registerCallback(Callback callback);

    void unregisterCallback();
}
