package com.json.mediationsdk.sdk;

import com.json.mediationsdk.adunit.adapter.utility.AdInfo;
import com.json.mediationsdk.logger.IronSourceError;

/* JADX INFO: loaded from: classes12.dex */
public interface LevelPlayRewardedVideoManualListener extends LevelPlayRewardedVideoBaseListener {
    void onAdLoadFailed(IronSourceError ironSourceError);

    void onAdReady(AdInfo adInfo);
}
