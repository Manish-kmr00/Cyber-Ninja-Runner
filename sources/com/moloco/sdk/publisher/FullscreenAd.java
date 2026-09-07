package com.moloco.sdk.publisher;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.json.m5;
import com.moloco.sdk.publisher.AdShowListener;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\n\b\u0000\u0010\u0001 \u0000*\u00020\u00022\u00020\u00032\u00020\u0004J\u0017\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/moloco/sdk/publisher/FullscreenAd;", "T", "Lcom/moloco/sdk/publisher/AdShowListener;", "Lcom/moloco/sdk/publisher/AdLoad;", "Lcom/moloco/sdk/publisher/Destroyable;", m5.v, "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "(Lcom/moloco/sdk/publisher/AdShowListener;)V", "moloco-sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface FullscreenAd<T extends AdShowListener> extends AdLoad, Destroyable {
    void show(T listener);
}
