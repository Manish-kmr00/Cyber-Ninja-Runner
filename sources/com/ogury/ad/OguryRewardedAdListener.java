package com.ogury.ad;

import com.json.nu;
import com.ogury.ad.internal.t5;
import com.ogury.ad.internal.v5;
import kotlin.Metadata;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/ogury/ad/OguryRewardedAdListener;", "Lcom/ogury/ad/internal/v5;", "Lcom/ogury/ad/OguryRewardedAd;", Reporting.Key.CLICK_SOURCE_TYPE_AD, "Lcom/ogury/ad/OguryReward;", "reward", "", nu.i, "(Lcom/ogury/ad/OguryRewardedAd;Lcom/ogury/ad/OguryReward;)V", "sdk-ads_prodRelease"}, k = 1, mv = {2, 0, 0})
public interface OguryRewardedAdListener extends v5<OguryRewardedAd> {
    @Override // com.ogury.ad.internal.v5
    /* synthetic */ void onAdClicked(t5 t5Var);

    @Override // com.ogury.ad.internal.v5
    /* synthetic */ void onAdClosed(t5 t5Var);

    @Override // com.ogury.ad.internal.v5
    /* synthetic */ void onAdError(t5 t5Var, OguryAdError oguryAdError);

    @Override // com.ogury.ad.internal.v5
    /* synthetic */ void onAdImpression(t5 t5Var);

    @Override // com.ogury.ad.internal.v5
    /* synthetic */ void onAdLoaded(t5 t5Var);

    void onAdRewarded(OguryRewardedAd ad, OguryReward reward);
}
