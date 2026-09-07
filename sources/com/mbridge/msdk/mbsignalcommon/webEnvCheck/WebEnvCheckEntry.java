package com.mbridge.msdk.mbsignalcommon.webEnvCheck;

import android.content.Context;
import com.json.cc;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.setting.util.b;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.safedk.android.internal.partials.MintegralNetworkBridge;

/* JADX INFO: loaded from: classes12.dex */
public class WebEnvCheckEntry {
    public void check(Context context) {
        MintegralNetworkBridge.webviewLoadDataWithBaseURL(new WindVaneWebView(context), null, "<html><script>" + b.c().d() + "</script></html>", POBCommonConstants.CONTENT_TYPE_HTML, cc.N, null);
    }
}
