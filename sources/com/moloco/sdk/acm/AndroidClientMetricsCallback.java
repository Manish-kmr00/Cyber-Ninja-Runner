package com.moloco.sdk.acm;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/moloco/sdk/acm/AndroidClientMetricsCallback;", "", "onInitializationFailure", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onInitializationSuccess", "moloco-android-client-metrics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface AndroidClientMetricsCallback {
    void onInitializationFailure(Exception e);

    void onInitializationSuccess();
}
