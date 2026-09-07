package com.pubmatic.sdk.video.player;

import com.pubmatic.sdk.common.POBError;
import com.pubmatic.sdk.video.vastmodels.POBVastAd;
import com.pubmatic.sdk.video.vastmodels.POBVastCreative;

/* JADX INFO: loaded from: classes10.dex */
public interface POBVastPlayerListener {

    public interface POBAutoClickEventListener {
        void onAutoClickEvent();
    }

    void onClose();

    void onDsaInfoIconClick();

    void onEndCardWillLeaveApp();

    void onFailedToPlay(POBError pOBError);

    void onIndustryIconClick(String str);

    void onOpenLandingPage(String str);

    void onPlaybackCompleted(float f);

    void onReadyToPlay(POBVastAd pOBVastAd, float f);

    void onSkip();

    void onVideoEventOccurred(POBVastCreative.POBEventTypes pOBEventTypes);

    void onVideoStarted(float f, float f2);

    void shouldForwardClickEvent();
}
