package com.yandex.mobile.ads.instream;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u000f\u0010\u0007\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\bR\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/yandex/mobile/ads/instream/InstreamAdBreakQueue;", "T", "", "count", "", "getCount", "()I", "poll", "()Ljava/lang/Object;", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface InstreamAdBreakQueue<T> {
    int getCount();

    T poll();
}
