package io.bidmachine;

/* JADX INFO: loaded from: classes12.dex */
public interface InternalNetworkInitializationCallback {
    void onFail(NetworkAdapter networkAdapter, String str);

    void onSuccess(NetworkAdapter networkAdapter);
}
