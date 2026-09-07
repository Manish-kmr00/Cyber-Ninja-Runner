package com.mbridge.msdk.mbsignalcommon.webEnvCheck;

import com.mbridge.msdk.foundation.controller.c;
import com.safedk.android.internal.partials.MintegralNetworkBridge;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class WebGLCheckSignal extends BaseWebGLCheckSignal {
    public static final /* synthetic */ int g = 0;

    public void webglState(Object obj, String str) {
        try {
            JSONObject jSONObjectJsonObjectInit = MintegralNetworkBridge.jsonObjectInit(str);
            c.m().c(jSONObjectJsonObjectInit.optInt("webgl"));
            c.m().a(jSONObjectJsonObjectInit);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
