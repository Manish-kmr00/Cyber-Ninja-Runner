package com.smaato.sdk.core.network;

/* JADX INFO: loaded from: classes14.dex */
public interface Callback {
    void onFailure(Call call, Exception exc);

    void onResponse(Call call, Response response);
}
