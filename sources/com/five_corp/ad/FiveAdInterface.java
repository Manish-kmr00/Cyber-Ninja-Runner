package com.five_corp.ad;

/* JADX INFO: loaded from: classes13.dex */
public interface FiveAdInterface {
    void enableSound(boolean z);

    CreativeType getCreativeType();

    String getFiveAdTag();

    String getSlotId();

    @Deprecated
    FiveAdState getState();

    boolean isSoundEnabled();

    void setFiveAdTag(String str);

    void setLoadListener(FiveAdLoadListener fiveAdLoadListener);

    @Deprecated
    void setViewEventListener(FiveAdViewEventListener fiveAdViewEventListener);
}
