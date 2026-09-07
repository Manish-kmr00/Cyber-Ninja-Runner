package com.pubmatic.sdk.openwrap.core;

import com.pubmatic.sdk.common.POBError;

/* JADX INFO: loaded from: classes9.dex */
public interface POBFullScreenAdInteractionListener {
    void trackAdDismissed();

    void trackAdFailed(POBError pOBError);

    void trackAdShown();

    void trackClick();

    void trackImpression();
}
