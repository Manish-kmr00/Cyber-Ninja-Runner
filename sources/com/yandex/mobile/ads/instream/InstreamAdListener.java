package com.yandex.mobile.ads.instream;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/yandex/mobile/ads/instream/InstreamAdListener;", "", "onError", "", "reason", "", "onInstreamAdCompleted", "onInstreamAdPrepared", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface InstreamAdListener {
    void onError(String reason);

    void onInstreamAdCompleted();

    void onInstreamAdPrepared();
}
