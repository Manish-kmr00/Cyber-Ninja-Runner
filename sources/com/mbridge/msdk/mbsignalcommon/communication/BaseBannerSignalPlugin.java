package com.mbridge.msdk.mbsignalcommon.communication;

import android.content.Context;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BaseBannerSignalPlugin extends BannerSignalPluginDiff {
    private final String g = "BannerSignalPlugin";
    public e h;

    public void click(Object obj, String str) {
        try {
            o0.b("BannerSignalPlugin", "click");
            e eVar = this.h;
            if (eVar != null) {
                eVar.click(obj, str);
            }
        } catch (Throwable th) {
            o0.b("BannerSignalPlugin", "click", th);
        }
    }

    public void getFileInfo(Object obj, String str) {
        try {
            o0.b("BannerSignalPlugin", "getFileInfo");
            e eVar = this.h;
            if (eVar != null) {
                eVar.getFileInfo(obj, str);
            }
        } catch (Throwable th) {
            o0.b("BannerSignalPlugin", "getFileInfo", th);
        }
    }

    public void getNetstat(Object obj, String str) {
        try {
            o0.b("BannerSignalPlugin", "getNetstat");
            e eVar = this.h;
            if (eVar != null) {
                eVar.b(obj, str);
            }
        } catch (Throwable th) {
            o0.b("BannerSignalPlugin", "getNetstat", th);
        }
    }

    public void handlerH5Exception(Object obj, String str) {
        try {
            o0.b("BannerSignalPlugin", "handlerH5Exception");
            e eVar = this.h;
            if (eVar != null) {
                eVar.handlerH5Exception(obj, str);
            }
        } catch (Throwable th) {
            o0.b("BannerSignalPlugin", "handlerH5Exception", th);
        }
    }

    public void increaseOfferFrequence(Object obj, String str) {
        try {
            o0.b("BannerSignalPlugin", "increaseOfferFrequence");
            e eVar = this.h;
            if (eVar != null) {
                eVar.increaseOfferFrequence(obj, str);
            }
        } catch (Throwable th) {
            o0.b("BannerSignalPlugin", "increaseOfferFrequence", th);
        }
    }

    public void init(Object obj, String str) {
        try {
            o0.b("BannerSignalPlugin", "init");
            e eVar = this.h;
            if (eVar != null) {
                eVar.init(obj, str);
            }
        } catch (Throwable th) {
            o0.b("BannerSignalPlugin", "init", th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.mbridge.msdk.mbsignalcommon.windvane.g
    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        super.initialize(context, windVaneWebView);
        try {
            if (context instanceof e) {
                this.h = (e) context;
            } else if (windVaneWebView.getObject() != null && (windVaneWebView.getObject() instanceof e)) {
                this.h = (e) windVaneWebView.getObject();
            }
        } catch (Throwable th) {
            o0.b("BannerSignalPlugin", MobileAdsBridgeBase.initializeMethodName, th);
        }
    }

    public void install(Object obj, String str) {
        try {
            o0.b("BannerSignalPlugin", "install");
            e eVar = this.h;
            if (eVar != null) {
                eVar.install(obj, str);
            }
        } catch (Throwable th) {
            o0.b("BannerSignalPlugin", "install", th);
        }
    }

    public void onSignalCommunication(Object obj, String str) {
        try {
            o0.b("BannerSignalPlugin", "onSignalCommunication");
            e eVar = this.h;
            if (eVar != null) {
                eVar.c(obj, str);
            }
        } catch (Throwable th) {
            o0.b("BannerSignalPlugin", "onSignalCommunication", th);
        }
    }

    public void openURL(Object obj, String str) {
        try {
            o0.b("BannerSignalPlugin", "openURL");
            e eVar = this.h;
            if (eVar != null) {
                eVar.openURL(obj, str);
            }
        } catch (Throwable th) {
            o0.b("BannerSignalPlugin", "openURL", th);
        }
    }

    public void readyStatus(Object obj, String str) {
        try {
            o0.b("BannerSignalPlugin", "readyStatus");
            e eVar = this.h;
            if (eVar != null) {
                eVar.readyStatus(obj, str);
            }
        } catch (Throwable th) {
            o0.b("BannerSignalPlugin", "readyStatus", th);
        }
    }

    public void reportUrls(Object obj, String str) {
        try {
            o0.b("BannerSignalPlugin", "reportUrls");
            e eVar = this.h;
            if (eVar != null) {
                eVar.reportUrls(obj, str);
            }
        } catch (Throwable th) {
            o0.b("BannerSignalPlugin", "reportUrls", th);
        }
    }

    public void resetCountdown(Object obj, String str) {
        try {
            o0.b("BannerSignalPlugin", "resetCountdown");
            e eVar = this.h;
            if (eVar != null) {
                eVar.a(obj, str);
            }
        } catch (Throwable th) {
            o0.b("BannerSignalPlugin", "resetCountdown", th);
        }
    }

    public void sendImpressions(Object obj, String str) {
        try {
            o0.b("BannerSignalPlugin", "sendImpressions");
            e eVar = this.h;
            if (eVar != null) {
                eVar.d(obj, str);
            }
        } catch (Throwable th) {
            o0.b("BannerSignalPlugin", "sendImpressions", th);
        }
    }

    public void toggleCloseBtn(Object obj, String str) {
        try {
            o0.b("BannerSignalPlugin", "toggleCloseBtn");
            e eVar = this.h;
            if (eVar != null) {
                eVar.toggleCloseBtn(obj, str);
            }
        } catch (Throwable th) {
            o0.b("BannerSignalPlugin", "toggleCloseBtn", th);
        }
    }

    public void triggerCloseBtn(Object obj, String str) {
        try {
            o0.b("BannerSignalPlugin", "triggerCloseBtn");
            e eVar = this.h;
            if (eVar != null) {
                eVar.triggerCloseBtn(obj, str);
            }
        } catch (Throwable th) {
            o0.b("BannerSignalPlugin", "triggerCloseBtn", th);
        }
    }
}
