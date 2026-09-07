package com.ogury.ad;

import com.ogury.ad.internal.t5;
import com.ogury.ad.internal.v5;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/ogury/ad/OguryBannerAdViewListener;", "Lcom/ogury/ad/internal/v5;", "Lcom/ogury/ad/OguryBannerAdView;", "sdk-ads_prodRelease"}, k = 1, mv = {2, 0, 0})
public interface OguryBannerAdViewListener extends v5<OguryBannerAdView> {
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
}
