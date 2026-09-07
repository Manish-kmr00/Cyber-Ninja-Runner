package com.pubmatic.sdk.openwrap.core;

import com.pubmatic.sdk.common.base.POBBidsProvider;

/* JADX INFO: loaded from: classes4.dex */
public interface POBAdEventListener {
    POBBidsProvider getBidsProvider();

    void onAdClick();

    void onAdClosed();

    void onAdImpression();

    void onAdLeftApplication();

    void onAdOpened();
}
