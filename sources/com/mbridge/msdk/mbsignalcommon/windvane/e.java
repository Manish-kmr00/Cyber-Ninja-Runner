package com.mbridge.msdk.mbsignalcommon.windvane;

import android.content.Context;
import com.mbridge.msdk.interstitial.signalcommon.interstitial;
import com.mbridge.msdk.mbsignalcommon.communication.BannerSignalPlugin;
import com.mbridge.msdk.mbsignalcommon.mraid.MraidSignalCommunication;
import com.mbridge.msdk.mbsignalcommon.webEnvCheck.WebGLCheckSignal;
import com.mbridge.msdk.splash.signal.SplashSignal;
import com.mbridge.msdk.video.signal.communication.RewardSignal;
import com.mbridge.msdk.video.signal.communication.VideoCommunication;
import java.util.HashMap;

/* JADX INFO: compiled from: WindVaneApiManager.java */
/* JADX INFO: loaded from: classes12.dex */
public class e {
    private static HashMap<String, Class> d = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f5261a;
    private Object b;
    private WindVaneWebView c;

    public e(Context context, WindVaneWebView windVaneWebView) {
        this.f5261a = context;
        this.c = windVaneWebView;
        a();
    }

    public void a(Context context) {
        this.f5261a = context;
    }

    public void a(Object obj) {
        this.b = obj;
    }

    private Object a(String str, WindVaneWebView windVaneWebView, Context context) {
        Class cls = d.get(str);
        if (cls == null) {
            return null;
        }
        try {
            if (!g.class.isAssignableFrom(cls)) {
                return null;
            }
            g gVar = (g) cls.newInstance();
            gVar.initialize(context, windVaneWebView);
            gVar.initialize(this.b, windVaneWebView);
            return gVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void a(String str, Class cls) {
        if (d == null) {
            d = new HashMap<>();
        }
        d.put(str, cls);
    }

    public Object a(String str) {
        if (d == null) {
            d = new HashMap<>();
        }
        return a(str, this.c, this.f5261a);
    }

    public void a() {
        try {
            int i = interstitial.i;
            a(com.mbridge.msdk.mbsignalcommon.base.e.f5227a, interstitial.class);
        } catch (ClassNotFoundException unused) {
        }
        try {
            int i2 = RewardSignal.i;
            a(com.mbridge.msdk.mbsignalcommon.base.e.b, RewardSignal.class);
        } catch (ClassNotFoundException unused2) {
        }
        try {
            int i3 = VideoCommunication.j;
            a(com.mbridge.msdk.mbsignalcommon.base.e.c, VideoCommunication.class);
        } catch (ClassNotFoundException unused3) {
        }
        try {
            int i4 = MraidSignalCommunication.h;
            a(com.mbridge.msdk.mbsignalcommon.base.e.e, MraidSignalCommunication.class);
        } catch (ClassNotFoundException unused4) {
        }
        try {
            int i5 = BannerSignalPlugin.i;
            a(com.mbridge.msdk.mbsignalcommon.base.e.f, BannerSignalPlugin.class);
        } catch (ClassNotFoundException unused5) {
        }
        try {
            int i6 = SplashSignal.i;
            a(com.mbridge.msdk.mbsignalcommon.base.e.g, SplashSignal.class);
        } catch (ClassNotFoundException unused6) {
        }
        try {
            int i7 = WebGLCheckSignal.g;
            a(com.mbridge.msdk.mbsignalcommon.base.e.h, WebGLCheckSignal.class);
        } catch (ClassNotFoundException unused7) {
        }
        try {
            if (com.mbridge.msdk.util.b.a()) {
                Class<?> cls = Class.forName("com.mbridge.msdk.mbsignalcommon.confirmation.bridge.ConfirmationJsBridgePlugin");
                a(cls.getSimpleName(), cls);
            }
        } catch (Exception unused8) {
        }
    }
}
