package com.pubmatic.sdk.nativead;

import android.view.View;
import com.pubmatic.sdk.common.POBAdServerSignalingEventListener;
import com.pubmatic.sdk.openwrap.core.POBBaseEvent;

/* JADX INFO: loaded from: classes7.dex */
public abstract class POBNativeAdEventBridge extends POBBaseEvent {
    public abstract View getAdServerView();

    public abstract void setNativeAdEventListener(POBNativeAdEventListener pOBNativeAdEventListener);

    public abstract void setSignalingEventListener(POBAdServerSignalingEventListener pOBAdServerSignalingEventListener);

    public abstract void trackClick();

    public abstract void trackImpression();
}
