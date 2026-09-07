package com.fyber.inneractive.sdk.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.webkit.WebView;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.activities.InneractiveRichMediaVideoPlayerActivityCore;
import com.fyber.inneractive.sdk.config.global.r;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.flow.x;
import com.fyber.inneractive.sdk.mraid.AbstractC3122e;
import com.fyber.inneractive.sdk.mraid.AbstractC3123f;
import com.fyber.inneractive.sdk.mraid.C3124g;
import com.fyber.inneractive.sdk.mraid.E;
import com.fyber.inneractive.sdk.mraid.k;
import com.fyber.inneractive.sdk.mraid.l;
import com.fyber.inneractive.sdk.mraid.m;
import com.fyber.inneractive.sdk.mraid.n;
import com.fyber.inneractive.sdk.mraid.o;
import com.fyber.inneractive.sdk.mraid.p;
import com.fyber.inneractive.sdk.mraid.q;
import com.fyber.inneractive.sdk.mraid.s;
import com.fyber.inneractive.sdk.mraid.t;
import com.fyber.inneractive.sdk.mraid.u;
import com.fyber.inneractive.sdk.mraid.v;
import com.fyber.inneractive.sdk.mraid.w;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.EnumC3143t;
import com.fyber.inneractive.sdk.network.EnumC3144u;
import com.fyber.inneractive.sdk.util.AbstractC3247k;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.h0;
import com.fyber.inneractive.sdk.web.B;
import com.fyber.inneractive.sdk.web.C;
import com.fyber.inneractive.sdk.web.C3274m;
import com.fyber.inneractive.sdk.web.D;
import com.fyber.inneractive.sdk.web.EnumC3286z;
import com.fyber.inneractive.sdk.web.F;
import com.fyber.inneractive.sdk.web.G;
import com.fyber.inneractive.sdk.web.I;
import com.fyber.inneractive.sdk.web.k0;
import java.net.URI;
import java.util.LinkedHashMap;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes8.dex */
public class IAmraidWebViewController extends I {
    public final f p0;

    public static class MraidVideoFailedToDisplayError extends InneractiveUnitController.AdDisplayError {
        public MraidVideoFailedToDisplayError() {
            super("an MRAID video has not started playing in a timely fashion");
        }
    }

    public IAmraidWebViewController(boolean z, C c, EnumC3286z enumC3286z, D d, boolean z2, com.fyber.inneractive.sdk.measurement.e eVar, r rVar) {
        super(z, c, enumC3286z, d, eVar, rVar);
        this.p0 = new f(this);
        this.F = z2;
        this.b.setId(R.id.ia_inneractive_webview_mraid);
    }

    @Override // com.fyber.inneractive.sdk.web.AbstractC3270i
    public final boolean a(String str, h0 h0Var) {
        AbstractC3123f c3124g;
        C3274m c3274m;
        Uri uri = Uri.parse(str);
        String string = uri.toString();
        uri.getScheme();
        if (string.startsWith("iaadfinishedloading")) {
            if (string.endsWith("success")) {
                IAlog.e("received iaadfinishedloading success", new Object[0]);
                if (!this.f2412a && this.f != null && (c3274m = this.b) != null) {
                    c3274m.a();
                    this.f2412a = true;
                    q();
                }
            }
            return true;
        }
        String scheme = Uri.parse(str).getScheme();
        C3274m c3274m2 = this.b;
        if (c3274m2 != null && c3274m2.isShown()) {
            if (!"mraid".equals(scheme)) {
                return false;
            }
            URI uriCreate = URI.create(str);
            String host = uriCreate.getHost();
            try {
                LinkedHashMap linkedHashMapA = I.a(uriCreate);
                switch (com.fyber.inneractive.sdk.mraid.j.f1900a[k.a(host).ordinal()]) {
                    case 1:
                        c3124g = new C3124g(linkedHashMapA, this, h0Var);
                        break;
                    case 2:
                        c3124g = new com.fyber.inneractive.sdk.mraid.i(linkedHashMapA, this, h0Var);
                        break;
                    case 3:
                        c3124g = new w(linkedHashMapA, this, h0Var);
                        break;
                    case 4:
                        c3124g = new q(linkedHashMapA, this, h0Var);
                        break;
                    case 5:
                        c3124g = new s(linkedHashMapA, this, h0Var);
                        break;
                    case 6:
                        c3124g = new o(linkedHashMapA, this, h0Var);
                        break;
                    case 7:
                        c3124g = new u(linkedHashMapA, this, h0Var);
                        break;
                    case 8:
                        c3124g = new t(linkedHashMapA, this, h0Var);
                        break;
                    case 9:
                        c3124g = new com.fyber.inneractive.sdk.mraid.r(linkedHashMapA, this, h0Var);
                        break;
                    case 10:
                        c3124g = new v(linkedHashMapA, this, h0Var);
                        break;
                    case 11:
                        c3124g = new l(linkedHashMapA, this, h0Var);
                        break;
                    case 12:
                        c3124g = new m(linkedHashMapA, this, h0Var);
                        break;
                    case 13:
                        c3124g = new n(linkedHashMapA, this, h0Var);
                        break;
                    case 14:
                        c3124g = new p(linkedHashMapA, this, h0Var);
                        break;
                    case 15:
                        c3124g = new com.fyber.inneractive.sdk.mraid.h(linkedHashMapA, this, h0Var);
                        break;
                    default:
                        c3124g = null;
                        break;
                }
                if (c3124g == null || ((c3124g instanceof com.fyber.inneractive.sdk.mraid.i) && this.Q == C.INTERSTITIAL)) {
                    C3274m c3274m3 = this.b;
                    if (c3274m3 != null) {
                        c3274m3.a("window.mraidbridge.nativeCallComplete('" + host + "');");
                    }
                } else {
                    c3124g.f1899a = host;
                    IAlog.e("Processing MRaid command: %s", host);
                    if (c3124g instanceof AbstractC3122e) {
                        a(new F(this, (AbstractC3122e) c3124g));
                    } else {
                        if (c3124g.b()) {
                            i();
                        }
                        c3124g.a();
                    }
                    C3274m c3274m4 = this.b;
                    if (c3274m4 != null) {
                        c3274m4.a("window.mraidbridge.nativeCallComplete('" + host + "');");
                    }
                }
            } catch (Exception unused) {
            }
        }
        return true;
    }

    @Override // com.fyber.inneractive.sdk.web.AbstractC3270i
    public final void e() {
        b(false);
        Handler handler = com.fyber.inneractive.sdk.util.r.b;
        handler.removeCallbacks(this.p0);
        handler.removeCallbacks(this.J);
    }

    @Override // com.fyber.inneractive.sdk.web.AbstractC3270i
    public final com.fyber.inneractive.sdk.measurement.tracker.f f() {
        return this.I;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0030  */
    @Override // com.fyber.inneractive.sdk.web.I, com.fyber.inneractive.sdk.web.j0
    public final void k() {
        boolean z;
        String externalStorageState;
        int size;
        super.k();
        C3274m c3274m = this.b;
        if (c3274m == null || c3274m.getContext() == null) {
            z = false;
        } else {
            try {
                size = AbstractC3251o.f2370a.getPackageManager().queryIntentActivities(new Intent(this.b.getContext(), (Class<?>) InneractiveRichMediaVideoPlayerActivityCore.class), 0).size();
            } catch (Throwable unused) {
                size = 0;
            }
            if (size > 0) {
                z = true;
            } else {
                z = false;
            }
        }
        E e = new E();
        e.b = AbstractC3247k.o();
        e.f1895a = AbstractC3247k.o();
        e.c = true;
        e.e = z;
        try {
            externalStorageState = Environment.getExternalStorageState();
        } catch (Throwable unused2) {
            externalStorageState = "";
        }
        e.d = "mounted".equals(externalStorageState) && AbstractC3251o.f2370a.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
        a(e);
    }

    @Override // com.fyber.inneractive.sdk.web.j0
    public final void n() {
        C3274m c3274m;
        if (this.C && this.D && this.A && (c3274m = this.b) != null) {
            c3274m.a("FyberMraidVideoController.play()");
            f fVar = this.p0;
            if (fVar != null) {
                com.fyber.inneractive.sdk.util.r.b.postDelayed(fVar, 5000L);
            }
            if (this.E) {
                this.b.a("FyberMraidVideoController.mute(true)");
            }
        }
    }

    public void setMuteMraidVideo(boolean z) {
        this.E = z;
    }

    @Override // com.fyber.inneractive.sdk.web.I, com.fyber.inneractive.sdk.web.AbstractC3270i, com.fyber.inneractive.sdk.web.InterfaceC3271j
    public final boolean a(WebView webView, String str) {
        r rVar;
        IAlog.a("IAmraidWebViewController: handleUrl = %s", str);
        if (this.b == null) {
            IAlog.a("handleUrl: web view already destroyed. Cannot handle url", new Object[0]);
            return false;
        }
        if (str != null && str.toLowerCase().startsWith("FyMraidVideo".toLowerCase())) {
            if (str.toLowerCase().endsWith("fyMraidVideoAd".toLowerCase())) {
                IAlog.e("Dispatching MRAID Video detection event", new Object[0]);
                com.fyber.inneractive.sdk.response.e eVarC = this.t;
                if (eVarC == null) {
                    x xVar = this.s;
                    eVarC = xVar == null ? null : xVar.c();
                }
                EnumC3144u enumC3144u = EnumC3144u.MRAID_VIDEO_DETECTED;
                InneractiveAdRequest inneractiveAdRequest = this.r;
                x xVar2 = this.s;
                JSONArray jSONArrayB = (xVar2 == null || (rVar = xVar2.c) == null) ? null : rVar.b();
                C3146w c3146w = new C3146w(eVarC);
                c3146w.c = enumC3144u;
                c3146w.f1934a = inneractiveAdRequest;
                c3146w.d = jSONArrayB;
                c3146w.a((String) null);
                this.D = true;
                n();
            } else if (str.toLowerCase().endsWith("fyMraidVideoAdPlaybackFailure".toLowerCase())) {
                IAlog.b("MRAID Video has not started in a timely fashion, showing close button", new Object[0]);
                k0 k0Var = this.g;
                if (k0Var != null) {
                    this.X = false;
                    if (k0Var != null) {
                        ((B) k0Var).b(false);
                    }
                    EnumC3143t enumC3143t = EnumC3143t.MRAID_VIDEO_HAS_NOT_STARTED_PLAYING_IN_A_TIMELY_FASHION;
                    InneractiveAdRequest inneractiveAdRequest2 = this.r;
                    x xVar3 = this.s;
                    com.fyber.inneractive.sdk.response.e eVarC2 = xVar3 == null ? null : xVar3.c();
                    x xVar4 = this.s;
                    JSONArray jSONArrayB2 = xVar4 == null ? null : xVar4.c.b();
                    C3146w c3146w2 = new C3146w(eVarC2);
                    c3146w2.b = enumC3143t;
                    c3146w2.f1934a = inneractiveAdRequest2;
                    c3146w2.d = jSONArrayB2;
                    c3146w2.a("video_timeout_in_msecs", String.valueOf(5000)).a((String) null);
                }
                k0 k0Var2 = this.g;
                if (k0Var2 != null) {
                    ((B) k0Var2).a(new MraidVideoFailedToDisplayError());
                }
            } else if (str.toLowerCase().endsWith("fyMraidVideoAdCompleted".toLowerCase())) {
                k0 k0Var3 = this.g;
                if (k0Var3 instanceof G) {
                    ((com.fyber.inneractive.sdk.renderers.r) ((G) k0Var3)).f2317a.F();
                }
            }
            return true;
        }
        return super.a(webView, str);
    }

    @Override // com.fyber.inneractive.sdk.web.I, com.fyber.inneractive.sdk.web.AbstractC3270i, com.fyber.inneractive.sdk.web.InterfaceC3273l
    public final void a(boolean z) {
        C3274m c3274m;
        super.a(z);
        if (this.D && this.C && this.A && (c3274m = this.b) != null) {
            c3274m.a("FyberMraidVideoController." + (z ? "play" : "pause") + "();");
        }
        if (this.b == null || !z) {
            return;
        }
        Handler handler = com.fyber.inneractive.sdk.util.r.b;
        handler.postDelayed(new g(this), 1L);
        handler.postDelayed(new g(this), 100L);
        handler.postDelayed(new g(this), 250L);
        handler.postDelayed(new g(this), 1000L);
    }
}
