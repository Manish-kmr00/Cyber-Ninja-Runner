package com.mbridge.msdk.mbsignalcommon.mraid;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.internal.partials.MintegralNetworkBridge;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import com.smaato.sdk.richmedia.mraid.bridge.MraidJsMethods;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class MraidSignalCommunication extends BaseMraidSignalCommunication {
    public static final /* synthetic */ int h = 0;
    private b g;

    public void close(Object obj, String str) {
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            a.a().b(((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b, "close");
        }
        try {
            o0.b("MraidSignalCommunication", "MRAID close");
            b bVar = this.g;
            if (bVar != null) {
                bVar.close();
            }
        } catch (Throwable th) {
            o0.b("MraidSignalCommunication", "MRAID close", th);
        }
    }

    public void expand(Object obj, String str) {
        Logger.d("Mintegral|SafeDK: Execution> Lcom/mbridge/msdk/mbsignalcommon/mraid/MraidSignalCommunication;->expand(Ljava/lang/Object;Ljava/lang/String;)V");
        safedk_MraidSignalCommunication_expand_f6c906bf2840fad81e07cacdbd952ac0(obj, str);
        BrandSafetyUtils.onMraidExpand(h.o, str, obj, "mraid.expand");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.mbridge.msdk.mbsignalcommon.windvane.g
    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        super.initialize(context, windVaneWebView);
        try {
            if (context instanceof b) {
                this.g = (b) context;
                return;
            }
            if (windVaneWebView.getObject() != null && (windVaneWebView.getObject() instanceof b)) {
                this.g = (b) windVaneWebView.getObject();
            }
            if (windVaneWebView.getMraidObject() == null || !(windVaneWebView.getMraidObject() instanceof b)) {
                return;
            }
            this.g = (b) windVaneWebView.getMraidObject();
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void open(Object obj, String str) {
        Logger.d("Mintegral|SafeDK: Execution> Lcom/mbridge/msdk/mbsignalcommon/mraid/MraidSignalCommunication;->open(Ljava/lang/Object;Ljava/lang/String;)V");
        safedk_MraidSignalCommunication_open_95b49e4c97dac868f09b5d1bd1efddc2(obj, str);
        BrandSafetyUtils.onMraidOpen(h.o, str, obj, "mraid.open");
    }

    public void safedk_MraidSignalCommunication_expand_f6c906bf2840fad81e07cacdbd952ac0(Object p0, String p1) {
        if (p0 instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            a.a().b(((com.mbridge.msdk.mbsignalcommon.windvane.a) p0).b, "expand");
        }
        try {
            JSONObject jSONObjectJsonObjectInit = MintegralNetworkBridge.jsonObjectInit(p1);
            String p2 = jSONObjectJsonObjectInit.optString("url");
            String strOptString = jSONObjectJsonObjectInit.optString("shouldUseCustomClose");
            o0.b("MraidSignalCommunication", "MRAID expand " + p2 + " " + strOptString);
            if (TextUtils.isEmpty(p2) || TextUtils.isEmpty(strOptString) || this.g == null) {
                return;
            }
            this.g.expand(p2, strOptString.toLowerCase().equals("true"));
        } catch (Throwable th) {
            o0.b("MraidSignalCommunication", "MRAID expand", th);
        }
    }

    public void safedk_MraidSignalCommunication_open_95b49e4c97dac868f09b5d1bd1efddc2(Object p0, String p1) {
        WindVaneWebView windVaneWebView;
        if (p0 instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) p0;
            windVaneWebView = aVar.b;
            a.a().b(aVar.b, "open");
        } else {
            windVaneWebView = null;
        }
        try {
            String strOptString = MintegralNetworkBridge.jsonObjectInit(p1).optString("url");
            String p2 = "MRAID Open " + strOptString;
            o0.b("MraidSignalCommunication", p2);
            if (this.g == null || TextUtils.isEmpty(strOptString)) {
                return;
            }
            if (windVaneWebView == null || System.currentTimeMillis() - windVaneWebView.lastTouchTime <= com.mbridge.msdk.click.utils.a.c || !com.mbridge.msdk.click.utils.a.a(this.g.getMraidCampaign(), windVaneWebView.getUrl(), com.mbridge.msdk.click.utils.a.f4757a)) {
                this.g.open(strOptString);
            }
        } catch (Throwable th) {
            o0.b("MraidSignalCommunication", "MRAID Open", th);
        }
    }

    public void setOrientationProperties(Object obj, String str) {
        String str2;
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            a.a().b(((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b, "setOrientationProperties");
        }
        try {
            JSONObject jSONObjectJsonObjectInit = MintegralNetworkBridge.jsonObjectInit(str);
            String strOptString = jSONObjectJsonObjectInit.optString("allowOrientationChange");
            String strOptString2 = jSONObjectJsonObjectInit.optString("forceOrientation");
            o0.b("MraidSignalCommunication", "MRAID setOrientationProperties");
            if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2) || this.g == null) {
                return;
            }
            strOptString.toLowerCase().equals("true");
            String lowerCase = strOptString2.toLowerCase();
            int iHashCode = lowerCase.hashCode();
            if (iHashCode == 729267099) {
                str2 = "portrait";
            } else if (iHashCode != 1430647483) {
                return;
            } else {
                str2 = "landscape";
            }
            lowerCase.equals(str2);
        } catch (Throwable th) {
            o0.b("MraidSignalCommunication", "MRAID setOrientationProperties", th);
        }
    }

    public void unload(Object obj, String str) {
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            a.a().b(((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b, MraidJsMethods.UNLOAD);
        }
        try {
            o0.b("MraidSignalCommunication", "MRAID unload");
            b bVar = this.g;
            if (bVar != null) {
                bVar.unload();
            }
        } catch (Throwable th) {
            o0.b("MraidSignalCommunication", "MRAID unload", th);
        }
    }

    public void useCustomClose(Object obj, String str) {
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            a.a().b(((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b, MraidJsMethods.USE_CUSTOM_CLOSE);
        }
        try {
            String strOptString = MintegralNetworkBridge.jsonObjectInit(str).optString("shouldUseCustomClose");
            o0.b("MraidSignalCommunication", "MRAID useCustomClose " + strOptString);
            if (TextUtils.isEmpty(strOptString) || this.g == null) {
                return;
            }
            this.g.useCustomClose(strOptString.toLowerCase().equals("true"));
        } catch (Throwable th) {
            o0.b("MraidSignalCommunication", "MRAID useCustomClose", th);
        }
    }
}
