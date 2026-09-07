package com.mbridge.msdk.video.signal.communication;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.mbsignalcommon.communication.d;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import com.mbridge.msdk.video.signal.factory.IJSFactory;
import com.safedk.android.internal.partials.MintegralNetworkBridge;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class BaseRewardSignalH5 extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected IJSFactory f5852a;

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void cai(Object obj, String str) {
        o0.a("JS-Reward-Communication", "cai:" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            try {
                String strOptString = MintegralNetworkBridge.jsonObjectInit(str).optString("packageName");
                if (TextUtils.isEmpty(strOptString)) {
                    d.a(obj, "packageName is empty");
                }
                int i = t0.c(c.m().d(), strOptString) ? 1 : 2;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", d.b);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", i);
                    jSONObject.put("data", jSONObject2);
                    f.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e) {
                    d.a(obj, e.getMessage());
                    o0.a("JS-Reward-Communication", e.getMessage());
                }
            } catch (JSONException e2) {
                d.a(obj, "exception: " + e2.getLocalizedMessage());
                o0.b("JS-Reward-Communication", "cai", e2);
            }
        } catch (Throwable th) {
            d.a(obj, "exception: " + th.getLocalizedMessage());
            o0.b("JS-Reward-Communication", "cai", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void getEndScreenInfo(Object obj, String str) {
        String strEncodeToString;
        try {
            IJSFactory iJSFactory = this.f5852a;
            if (iJSFactory != null) {
                String strB = iJSFactory.getIJSRewardVideoV1().b();
                if (TextUtils.isEmpty(strB)) {
                    strEncodeToString = "";
                    o0.a("JS-Reward-Communication", "getEndScreenInfo failed");
                } else {
                    strEncodeToString = Base64.encodeToString(strB.getBytes(), 2);
                    o0.a("JS-Reward-Communication", "getEndScreenInfo success");
                }
                f.a().b(obj, strEncodeToString);
            }
        } catch (Throwable th) {
            o0.b("JS-Reward-Communication", "getEndScreenInfo", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void handlerPlayableException(Object obj, String str) {
        try {
            if (this.f5852a == null || TextUtils.isEmpty(str)) {
                return;
            }
            String strOptString = MintegralNetworkBridge.jsonObjectInit(str).optString("msg");
            o0.a("JS-Reward-Communication", "handlerPlayableException,msg:" + str);
            this.f5852a.getIJSRewardVideoV1().handlerPlayableException(strOptString);
        } catch (Throwable th) {
            o0.b("JS-Reward-Communication", "setOrientation", th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        if (context instanceof IJSFactory) {
            this.f5852a = (IJSFactory) context;
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void install(Object obj, String str) {
        try {
            if (this.f5852a != null) {
                o0.a("JS-Reward-Communication", "install:" + str);
                if (this.f5852a.getJSContainerModule().endCardShowing()) {
                    this.f5852a.getJSCommon().click(3, str);
                } else {
                    this.f5852a.getJSCommon().click(1, str);
                }
            }
        } catch (Throwable th) {
            o0.b("JS-Reward-Communication", "install", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void notifyCloseBtn(Object obj, String str) {
        try {
            if (this.f5852a == null || TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = MintegralNetworkBridge.jsonObjectInit(str).optInt("state");
            o0.a("JS-Reward-Communication", "notifyCloseBtn,state:" + str);
            this.f5852a.getIJSRewardVideoV1().notifyCloseBtn(iOptInt);
        } catch (Throwable th) {
            o0.b("JS-Reward-Communication", "notifyCloseBtn", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void openURL(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        o0.b("JS-Reward-Communication", "openURL:" + str);
        Context contextD = c.m().d();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (contextD == null) {
            try {
                if ((obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b) != null) {
                    contextD = windVaneWebView.getContext();
                }
            } catch (Exception e) {
                o0.b("JS-Reward-Communication", e.getMessage());
            }
        }
        if (contextD == null) {
            return;
        }
        try {
            JSONObject jSONObjectJsonObjectInit = MintegralNetworkBridge.jsonObjectInit(str);
            String strOptString = jSONObjectJsonObjectInit.optString("url");
            int iOptInt = jSONObjectJsonObjectInit.optInt("type");
            if (iOptInt == 1) {
                com.mbridge.msdk.click.c.c(contextD, strOptString);
            } else if (iOptInt == 2) {
                com.mbridge.msdk.click.c.e(contextD, strOptString);
            }
        } catch (JSONException e2) {
            o0.b("JS-Reward-Communication", e2.getMessage());
        } catch (Throwable th) {
            o0.b("JS-Reward-Communication", th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void setOrientation(Object obj, String str) {
        try {
            if (this.f5852a == null || TextUtils.isEmpty(str)) {
                return;
            }
            String strOptString = MintegralNetworkBridge.jsonObjectInit(str).optString("state");
            o0.a("JS-Reward-Communication", "setOrientation,state:" + str);
            this.f5852a.getIJSRewardVideoV1().a(strOptString);
        } catch (Throwable th) {
            o0.b("JS-Reward-Communication", "setOrientation", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void toggleCloseBtn(Object obj, String str) {
        try {
            if (this.f5852a == null || TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = MintegralNetworkBridge.jsonObjectInit(str).optInt("state");
            o0.a("JS-Reward-Communication", "toggleCloseBtn,state:" + str);
            this.f5852a.getIJSRewardVideoV1().toggleCloseBtn(iOptInt);
        } catch (Throwable th) {
            o0.b("JS-Reward-Communication", "toggleCloseBtn", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void triggerCloseBtn(Object obj, String str) {
        try {
            if (this.f5852a == null || TextUtils.isEmpty(str)) {
                return;
            }
            f.a().b(obj, a(0));
            this.f5852a.getIJSRewardVideoV1().triggerCloseBtn(MintegralNetworkBridge.jsonObjectInit(str).optString("state"));
            o0.a("JS-Reward-Communication", "triggerCloseBtn,state:" + str);
        } catch (Throwable th) {
            o0.b("JS-Reward-Communication", "triggerCloseBtn", th);
            f.a().b(obj, a(-1));
        }
    }

    private String a(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            String string = jSONObject.toString();
            if (!TextUtils.isEmpty(string)) {
                return Base64.encodeToString(string.getBytes(), 2);
            }
        } catch (Throwable unused) {
            o0.b("JS-Reward-Communication", "code to string is error");
        }
        return "";
    }

    public void initialize(Object obj, WindVaneWebView windVaneWebView) {
        if (obj instanceof IJSFactory) {
            this.f5852a = (IJSFactory) obj;
        }
    }
}
