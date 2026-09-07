package com.pubmatic.sdk.rewardedad;

import android.content.Context;
import com.pubmatic.sdk.common.ui.POBRewardedAdRendering;
import com.pubmatic.sdk.openwrap.core.rewarded.POBRewardedAdRenderer;
import com.pubmatic.sdk.openwrap.core.rewarded.POBSkipConfirmationInfo;

/* JADX INFO: loaded from: classes9.dex */
public final class POBRewardedUtil {
    public static POBRewardedAdRendering getRewardedRenderer(Context context, int i, POBSkipConfirmationInfo pOBSkipConfirmationInfo) {
        return new POBRewardedAdRenderer(context, i, pOBSkipConfirmationInfo);
    }
}
