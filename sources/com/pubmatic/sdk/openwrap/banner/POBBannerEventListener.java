package com.pubmatic.sdk.openwrap.banner;

import android.view.View;
import com.pubmatic.sdk.common.POBError;
import com.pubmatic.sdk.openwrap.core.POBAdEventListener;

/* JADX INFO: loaded from: classes8.dex */
public interface POBBannerEventListener extends POBAdEventListener {
    void onAdExecutionComplete();

    void onAdServerWin(View view);

    void onFailed(POBError pOBError);

    void onOpenWrapPartnerWin(String str);
}
