package com.pubmatic.sdk.common;

import com.pubmatic.sdk.common.base.POBBidsProvider;

/* JADX INFO: loaded from: classes7.dex */
public interface POBAdServerSignalingEventListener {
    POBBidsProvider getBidsProvider();

    void onAdServerWin();

    void onFailed(POBError pOBError);

    void onOpenWrapPartnerWin(String str);
}
