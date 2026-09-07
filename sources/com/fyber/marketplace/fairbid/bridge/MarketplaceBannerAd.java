package com.fyber.marketplace.fairbid.bridge;

import android.view.ViewGroup;

/* JADX INFO: loaded from: classes2.dex */
public interface MarketplaceBannerAd extends MarketplaceBridgeAd {
    boolean canRefresh();

    int getAdHeight();

    int getAdWidth();

    boolean isUsingFullWidth();

    void showInView(ViewGroup viewGroup, MarketplaceBannerDisplayEventsListener marketplaceBannerDisplayEventsListener);
}
