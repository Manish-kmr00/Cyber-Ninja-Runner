package com.moloco.sdk.publisher;

import com.json.nu;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/moloco/sdk/publisher/AdShowListener;", "", nu.f, "", "molocoAd", "Lcom/moloco/sdk/publisher/MolocoAd;", "onAdHidden", nu.e, "molocoAdError", "Lcom/moloco/sdk/publisher/MolocoAdError;", "onAdShowSuccess", "moloco-sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface AdShowListener {
    void onAdClicked(MolocoAd molocoAd);

    void onAdHidden(MolocoAd molocoAd);

    void onAdShowFailed(MolocoAdError molocoAdError);

    void onAdShowSuccess(MolocoAd molocoAd);
}
