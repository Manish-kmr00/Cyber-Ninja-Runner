package com.smaato.sdk.core.network;

import java.io.IOException;

/* JADX INFO: loaded from: classes12.dex */
public interface Call {

    public interface Factory {
        Call newCall(Request request);
    }

    void cancel();

    void enqueue(Callback callback);

    Response execute() throws IOException;

    Request request();
}
