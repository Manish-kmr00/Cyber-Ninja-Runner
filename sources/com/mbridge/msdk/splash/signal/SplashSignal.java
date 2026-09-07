package com.mbridge.msdk.splash.signal;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.mbsignalcommon.windvane.AbsFeedBackForH5;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.safedk.android.internal.partials.MintegralNetworkBridge;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import org.json.JSONException;

/* JADX INFO: loaded from: classes8.dex */
public class SplashSignal extends AbsFeedBackForH5 {
    private static String h = "SplashSignal";
    public static final /* synthetic */ int i = 0;
    private b g;

    public void getFileInfo(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            c.a(obj, MintegralNetworkBridge.jsonObjectInit(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void handlerH5Exception(Object obj, String str) {
        if (obj != null) {
            try {
                WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b;
                if (windVaneWebView == null || windVaneWebView.getWebViewListener() == null) {
                    return;
                }
                windVaneWebView.getWebViewListener().a(windVaneWebView, 0, str.toString(), windVaneWebView.getUrl());
            } catch (Throwable th) {
                o0.b(h, "handlerH5Exception", th);
            }
        }
    }

    public void increaseOfferFrequence(Object obj, String str) {
        try {
            c.b(obj, MintegralNetworkBridge.jsonObjectInit(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void init(Object obj, String str) {
        o0.b(h, MobileAdsBridgeBase.initializeMethodName + str);
        b bVar = this.g;
        if (bVar != null) {
            bVar.init(obj, str);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.g
    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        super.initialize(context, windVaneWebView);
        try {
            if (windVaneWebView.getObject() == null || !(windVaneWebView.getObject() instanceof b)) {
                return;
            }
            this.g = (b) windVaneWebView.getObject();
        } catch (Throwable th) {
            o0.b(h, MobileAdsBridgeBase.initializeMethodName, th);
        }
    }

    public void install(Object obj, String str) {
        b bVar = this.g;
        if (bVar != null) {
            bVar.install(obj, str);
        }
    }

    public void onSignalCommunication(Object obj, String str) {
        try {
            o0.b(h, "onSignalCommunication");
            b bVar = this.g;
            if (bVar != null) {
                bVar.c(obj, str);
            }
        } catch (Throwable th) {
            o0.b(h, "onSignalCommunication", th);
        }
    }

    public void openURL(Object obj, String str) {
        o0.b(h, "openURL" + str);
        b bVar = this.g;
        if (bVar != null) {
            bVar.openURL(obj, str);
        }
    }

    public void pauseCountDown(Object obj, String str) {
        try {
            o0.b(h, "pauseCountDown");
            b bVar = this.g;
            if (bVar != null) {
                bVar.e(obj, str);
            }
        } catch (Throwable th) {
            o0.b(h, "pauseCountDown", th);
        }
    }

    public void readyStatus(Object obj, String str) {
        if (obj != null) {
            try {
                int iOptInt = MintegralNetworkBridge.jsonObjectInit(str).optInt("isReady", 1);
                WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b;
                if (windVaneWebView == null || windVaneWebView.getWebViewListener() == null) {
                    return;
                }
                windVaneWebView.getWebViewListener().a(windVaneWebView, iOptInt);
            } catch (Throwable th) {
                o0.b(h, "readyStatus", th);
            }
        }
    }

    public void reportUrls(Object obj, String str) {
        try {
            o0.b(h, "reportUrls");
            b bVar = this.g;
            if (bVar != null) {
                bVar.reportUrls(obj, str);
            }
        } catch (Throwable th) {
            o0.b(h, "reportUrls", th);
        }
    }

    public void resetCountdown(Object obj, String str) {
        o0.b(h, "resetCountdown" + str);
        b bVar = this.g;
        if (bVar != null) {
            bVar.a(obj, str);
        }
    }

    public void resumeCountDown(Object obj, String str) {
        try {
            o0.b(h, "resumeCountDown");
            b bVar = this.g;
            if (bVar != null) {
                bVar.f(obj, str);
            }
        } catch (Throwable th) {
            o0.b(h, "resumeCountDown", th);
        }
    }

    public void sendImpressions(Object obj, String str) {
        try {
            o0.b(h, "sendImpressions");
            b bVar = this.g;
            if (bVar != null) {
                bVar.d(obj, str);
            }
        } catch (Throwable th) {
            o0.b(h, "sendImpressions", th);
        }
    }

    public void toggleCloseBtn(Object obj, String str) {
        o0.b(h, "toggleCloseBtn" + str);
        b bVar = this.g;
        if (bVar != null) {
            bVar.toggleCloseBtn(obj, str);
        }
    }

    public void triggerCloseBtn(Object obj, String str) {
        o0.b(h, "triggerCloseBtn" + str);
        b bVar = this.g;
        if (bVar != null) {
            bVar.triggerCloseBtn(obj, str);
        }
    }
}
