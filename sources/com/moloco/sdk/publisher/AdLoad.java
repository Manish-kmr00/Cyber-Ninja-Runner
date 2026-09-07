package com.moloco.sdk.publisher;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.json.nu;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u000bJ\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/moloco/sdk/publisher/AdLoad;", "", "isLoaded", "", "()Z", "load", "", "bidResponseJson", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/moloco/sdk/publisher/AdLoad$Listener;", "Listener", "moloco-sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface AdLoad {

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/moloco/sdk/publisher/AdLoad$Listener;", "", nu.b, "", "molocoAdError", "Lcom/moloco/sdk/publisher/MolocoAdError;", "onAdLoadSuccess", "molocoAd", "Lcom/moloco/sdk/publisher/MolocoAd;", "moloco-sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Listener {
        void onAdLoadFailed(MolocoAdError molocoAdError);

        void onAdLoadSuccess(MolocoAd molocoAd);
    }

    boolean isLoaded();

    void load(String bidResponseJson, Listener listener);
}
