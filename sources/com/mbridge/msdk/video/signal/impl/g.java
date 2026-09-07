package com.mbridge.msdk.video.signal.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.mbridge.msdk.foundation.tools.o0;
import com.pubmatic.sdk.openwrap.core.POBConstants;

/* JADX INFO: compiled from: DefaultJSRewardVideoV1.java */
/* JADX INFO: loaded from: classes11.dex */
public class g implements com.mbridge.msdk.video.signal.i {
    @Override // com.mbridge.msdk.video.signal.i
    public void a(String str) {
        o0.a(POBConstants.KEY_JS, "setOrientation,landscape=" + str);
    }

    @Override // com.mbridge.msdk.video.signal.i
    public String b() {
        o0.a(POBConstants.KEY_JS, "getEndScreenInfo");
        return JsonUtils.EMPTY_JSON;
    }

    @Override // com.mbridge.msdk.video.signal.i
    public void handlerPlayableException(String str) {
        o0.a(POBConstants.KEY_JS, "handlerPlayableException，msg=" + str);
    }

    @Override // com.mbridge.msdk.video.signal.h
    public void notifyCloseBtn(int i) {
        o0.a(POBConstants.KEY_JS, "notifyCloseBtn,state=" + i);
    }

    @Override // com.mbridge.msdk.video.signal.h
    public void toggleCloseBtn(int i) {
        o0.a(POBConstants.KEY_JS, "toggleCloseBtn,state=" + i);
    }

    @Override // com.mbridge.msdk.video.signal.i
    public void triggerCloseBtn(String str) {
        o0.a(POBConstants.KEY_JS, "triggerCloseBtn,state=" + str);
    }
}
