package com.mbridge.msdk.advanced.middle;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedView;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedWebview;
import com.mbridge.msdk.advanced.view.MBOutNativeAdvancedViewGroup;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.b1;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.NativeAdvancedAdListener;
import com.mbridge.msdk.setting.h;
import com.mbridge.msdk.setting.j;
import com.mbridge.msdk.setting.l;
import org.json.JSONObject;

/* JADX INFO: compiled from: NativeAdvancedProvider.java */
/* JADX INFO: loaded from: classes6.dex */
public class c {
    private static String G = "NativeAdvancedProvider";
    private boolean A;
    private boolean B;
    private boolean C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4706a;
    private String b;
    private MBridgeIds c;
    private com.mbridge.msdk.advanced.manager.b d;
    private com.mbridge.msdk.advanced.manager.c e;
    private b f;
    private NativeAdvancedAdListener g;
    private d h;
    private MBNativeAdvancedView i;
    private MBNativeAdvancedWebview j;
    private com.mbridge.msdk.advanced.view.a k;
    private l l;
    private boolean m;
    private j n;
    private JSONObject x;
    private MBOutNativeAdvancedViewGroup z;
    private int o = -1;
    private boolean p = false;
    private int q = 0;
    private boolean r = false;
    private int s = 0;
    private boolean t = false;
    private int u = 0;
    private int v = 0;
    private Object w = new Object();
    private boolean y = false;
    private boolean D = true;
    public boolean E = false;
    private ViewTreeObserver.OnScrollChangedListener F = new a();

    /* JADX INFO: compiled from: NativeAdvancedProvider.java */
    class a implements ViewTreeObserver.OnScrollChangedListener {

        /* JADX INFO: renamed from: com.mbridge.msdk.advanced.middle.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: NativeAdvancedProvider.java */
        class RunnableC0420a implements Runnable {
            RunnableC0420a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.D = true;
            }
        }

        a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            if (c.this.D) {
                c.this.D = false;
                if (c.this.z != null) {
                    c.this.z.postDelayed(new RunnableC0420a(), 1000L);
                }
                try {
                    c.this.i();
                } catch (Exception e) {
                    o0.b(c.G, e.getMessage());
                }
            }
        }
    }

    public c(String str, String str2, Activity activity) {
        this.b = TextUtils.isEmpty(str) ? "" : str;
        this.f4706a = str2;
        this.c = new MBridgeIds(str, str2);
        a(activity);
    }

    private void e(int i) {
        MBNativeAdvancedWebview mBNativeAdvancedWebview = this.j;
        if (mBNativeAdvancedWebview == null || mBNativeAdvancedWebview.isDestoryed()) {
            return;
        }
        try {
            if (this.j != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("netstat", i);
                f.a().a((WebView) this.j, "onNetstatChanged", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            }
        } catch (Throwable th) {
            o0.a(G, th.getMessage());
        }
    }

    private void j() {
        a(this.o);
        c(this.q);
        g(this.s);
        a(this.x);
        e(k0.s(com.mbridge.msdk.foundation.controller.c.m().d()));
    }

    public MBOutNativeAdvancedViewGroup d() {
        return this.z;
    }

    public int f() {
        return this.o;
    }

    public boolean g() {
        return this.m;
    }

    public void h(int i) {
        this.t = true;
        g(i);
    }

    public void i(int i) {
        if (i == 1) {
            this.A = true;
        } else if (i == 2) {
            this.B = true;
        } else if (i == 3) {
            this.C = true;
        }
        try {
            i();
        } catch (Exception e) {
            o0.b(G, e.getMessage());
        }
    }

    private void g(int i) {
        if (this.t) {
            this.s = i;
            MBNativeAdvancedWebview mBNativeAdvancedWebview = this.j;
            if (mBNativeAdvancedWebview == null || mBNativeAdvancedWebview.isDestoryed()) {
                return;
            }
            com.mbridge.msdk.advanced.signal.a.a(this.j, "setVideoPlayMode", "autoPlay", Integer.valueOf(i));
        }
    }

    public void b(JSONObject jSONObject) {
        this.y = true;
        a(jSONObject);
    }

    public void c(String str) throws Throwable {
        b bVar = new b(this, this.c);
        this.f = bVar;
        bVar.a(this.g);
        this.f.a(str);
        a(str, 2);
    }

    public void d(String str) throws Throwable {
        if (!TextUtils.isEmpty(str)) {
            c(str);
            return;
        }
        NativeAdvancedAdListener nativeAdvancedAdListener = this.g;
        if (nativeAdvancedAdListener != null) {
            nativeAdvancedAdListener.onLoadFailed(this.c, "bid  token is null or empty");
        }
    }

    public void f(int i) {
        if (i == 1) {
            this.A = false;
        } else if (i == 2) {
            this.B = false;
        } else if (i == 3) {
            this.C = false;
        }
        h();
    }

    private void h() {
        com.mbridge.msdk.advanced.manager.c cVar = this.e;
        if (cVar != null) {
            cVar.e();
        }
    }

    public void a(boolean z) {
        this.m = z;
    }

    public boolean b(String str) {
        return (this.z == null || com.mbridge.msdk.advanced.manager.d.a(this.i, this.b, this.f4706a, str, this.o, false, true) == null) ? false : true;
    }

    private void a(JSONObject jSONObject) {
        if (this.y) {
            this.x = jSONObject;
            MBNativeAdvancedWebview mBNativeAdvancedWebview = this.j;
            if (mBNativeAdvancedWebview == null || mBNativeAdvancedWebview.isDestoryed()) {
                return;
            }
            com.mbridge.msdk.advanced.signal.a.a(this.j, "setStyleList", "", jSONObject);
        }
    }

    public void b(int i) {
        this.p = true;
        a(i);
    }

    private void c(int i) {
        if (this.r) {
            this.q = i;
            MBNativeAdvancedWebview mBNativeAdvancedWebview = this.j;
            if (mBNativeAdvancedWebview == null || mBNativeAdvancedWebview.isDestoryed()) {
                return;
            }
            com.mbridge.msdk.advanced.signal.a.a(this.j, "setVolume", "mute", Integer.valueOf(i));
        }
    }

    public void b(int i, int i2) {
        a(i, i2);
    }

    public void b(CampaignEx campaignEx) {
        if (campaignEx != null) {
            if (this.l == null) {
                this.l = h.b().c(com.mbridge.msdk.foundation.controller.c.m().b(), this.f4706a);
            }
            this.h = new d(this, this.g, campaignEx);
            o0.a(G, "show start");
            if (this.u != 0 && this.v != 0) {
                a(campaignEx, false);
                return;
            }
            d dVar = this.h;
            if (dVar != null) {
                dVar.a(this.c, "width or height is 0  or width or height is too small");
            }
        }
    }

    public void d(int i) {
        this.r = true;
        c(i);
    }

    public void a(NativeAdvancedAdListener nativeAdvancedAdListener) {
        this.g = nativeAdvancedAdListener;
    }

    private void a(int i) {
        if (this.p) {
            this.o = i;
            MBNativeAdvancedWebview mBNativeAdvancedWebview = this.j;
            if (mBNativeAdvancedWebview == null || mBNativeAdvancedWebview.isDestoryed()) {
                return;
            }
            int i2 = this.o;
            if (i2 == 1) {
                this.e.a(true);
                com.mbridge.msdk.advanced.signal.a.a(this.j, "showCloseButton", "", null);
            } else if (i2 == 0) {
                this.e.a(false);
                com.mbridge.msdk.advanced.signal.a.a(this.j, "hideCloseButton", "", null);
            }
        }
    }

    public String c() {
        if (this.E) {
            com.mbridge.msdk.advanced.manager.c cVar = this.e;
            if (cVar != null) {
                return cVar.a();
            }
            return "";
        }
        com.mbridge.msdk.advanced.manager.b bVar = this.d;
        if (bVar != null) {
            return bVar.c();
        }
        return "";
    }

    public String e() {
        if (this.E) {
            com.mbridge.msdk.advanced.manager.c cVar = this.e;
            if (cVar != null) {
                return cVar.c();
            }
            return "";
        }
        com.mbridge.msdk.advanced.manager.b bVar = this.d;
        if (bVar != null) {
            return bVar.d();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.A && this.B && this.C) {
            CampaignEx campaignExA = com.mbridge.msdk.advanced.manager.d.a(this.i, this.b, this.f4706a, "", this.o, true, true);
            if (campaignExA != null) {
                campaignExA.getImpReportType();
            }
            if (b1.a(this.i.getAdvancedNativeWebview(), 0) || this.z.getAlpha() < 0.5f || this.z.getVisibility() != 0) {
                return;
            }
            com.mbridge.msdk.advanced.manager.c cVar = this.e;
            if (cVar != null) {
                cVar.f();
            }
            b(campaignExA);
        }
    }

    void a(CampaignEx campaignEx, boolean z) {
        j();
        MBOutNativeAdvancedViewGroup mBOutNativeAdvancedViewGroup = this.z;
        if (mBOutNativeAdvancedViewGroup == null || mBOutNativeAdvancedViewGroup.getParent() == null) {
            return;
        }
        if (campaignEx != null && z) {
            if (this.l == null) {
                this.l = h.b().c(com.mbridge.msdk.foundation.controller.c.m().b(), this.f4706a);
            }
            this.h = new d(this, this.g, campaignEx);
        }
        if (this.e == null) {
            com.mbridge.msdk.advanced.manager.c cVar = new com.mbridge.msdk.advanced.manager.c(com.mbridge.msdk.foundation.controller.c.m().d(), this.b, this.f4706a);
            this.e = cVar;
            cVar.a(this);
        }
        a(campaignEx);
    }

    public void b() {
        if (this.g != null) {
            this.g = null;
        }
        if (this.f != null) {
            this.f = null;
        }
        if (this.h != null) {
            this.h = null;
        }
        com.mbridge.msdk.advanced.manager.b bVar = this.d;
        if (bVar != null) {
            bVar.a((MBNativeAdvancedView) null);
            this.d.e();
        }
        com.mbridge.msdk.advanced.manager.c cVar = this.e;
        if (cVar != null) {
            cVar.g();
        }
        MBNativeAdvancedView mBNativeAdvancedView = this.i;
        if (mBNativeAdvancedView != null) {
            mBNativeAdvancedView.destroy();
        }
        com.mbridge.msdk.advanced.common.c.b(this.b + this.f4706a + e());
        com.mbridge.msdk.advanced.view.a aVar = this.k;
        if (aVar != null) {
            aVar.b();
        }
        MBOutNativeAdvancedViewGroup mBOutNativeAdvancedViewGroup = this.z;
        if (mBOutNativeAdvancedViewGroup != null) {
            mBOutNativeAdvancedViewGroup.getViewTreeObserver().removeOnScrollChangedListener(this.F);
            this.z.removeAllViews();
            this.z = null;
        }
    }

    private void a(CampaignEx campaignEx) {
        if (com.mbridge.msdk.advanced.manager.d.a(this.i, campaignEx, this.b, this.f4706a)) {
            this.e.a(this.h);
            o0.b(G, "start show process");
            this.e.a(campaignEx, this.i, true);
        }
    }

    private void a(String str, int i) throws Throwable {
        boolean zB;
        this.D = true;
        synchronized (this.w) {
            if (this.m) {
                if (this.f != null) {
                    this.f.a(new com.mbridge.msdk.foundation.error.b(880016, "current unit is loading"), i);
                    this.m = true;
                }
                return;
            }
            this.m = true;
            if (this.u != 0 && this.v != 0) {
                if (this.i == null) {
                    if (this.f != null) {
                        this.f.a(new com.mbridge.msdk.foundation.error.b(880030), i);
                        return;
                    }
                    return;
                }
                try {
                    zB = com.mbridge.msdk.mbsignalcommon.webEnvCheck.a.b(com.mbridge.msdk.foundation.controller.c.m().d());
                } catch (Exception e) {
                    o0.b(G, e.getMessage());
                    zB = false;
                }
                if (!zB) {
                    if (this.f != null) {
                        this.f.a(new com.mbridge.msdk.foundation.error.b(880029), i);
                        return;
                    }
                    return;
                }
                this.i.clearResStateAndRemoveClose();
                l lVarA = h.b().a(com.mbridge.msdk.foundation.controller.c.m().b(), this.f4706a);
                this.l = lVarA;
                if (lVarA == null) {
                    this.l = l.k(this.f4706a);
                }
                if (this.d == null) {
                    this.d = new com.mbridge.msdk.advanced.manager.b(this.b, this.f4706a, 0L);
                }
                b bVar = this.f;
                if (bVar != null) {
                    bVar.a(str);
                    this.d.a(this.f);
                }
                this.i.resetLoadState();
                this.d.a(this.i);
                this.d.a(this.l);
                this.d.a(this.u, this.v);
                this.d.a(this.o);
                this.d.b(str, i);
                return;
            }
            if (this.f != null) {
                this.f.a(new com.mbridge.msdk.foundation.error.b(880028), i);
            }
        }
    }

    private void a(Activity activity) {
        com.mbridge.msdk.advanced.view.a aVar;
        ViewGroup.LayoutParams layoutParams;
        Context context;
        if (this.e == null) {
            com.mbridge.msdk.advanced.manager.c cVar = new com.mbridge.msdk.advanced.manager.c(com.mbridge.msdk.foundation.controller.c.m().d(), this.b, this.f4706a);
            this.e = cVar;
            cVar.a(this);
        }
        if (this.j == null) {
            try {
                this.j = new MBNativeAdvancedWebview(com.mbridge.msdk.foundation.controller.c.m().d());
            } catch (Exception e) {
                o0.b(G, e.getMessage());
            }
            if (this.k == null) {
                try {
                    this.k = new com.mbridge.msdk.advanced.view.a(this.f4706a, this.e.b(), this);
                } catch (Exception e2) {
                    o0.b(G, e2.getMessage());
                }
            }
            MBNativeAdvancedWebview mBNativeAdvancedWebview = this.j;
            if (mBNativeAdvancedWebview != null && (aVar = this.k) != null) {
                mBNativeAdvancedWebview.setWebViewClient(aVar);
            }
        }
        if (this.i == null) {
            Context contextD = com.mbridge.msdk.foundation.controller.c.m().d();
            if (activity == null) {
                context = activity;
                context = contextD;
            }
            context = activity;
            MBNativeAdvancedView mBNativeAdvancedView = new MBNativeAdvancedView(context);
            this.i = mBNativeAdvancedView;
            mBNativeAdvancedView.setAdvancedNativeWebview(this.j);
            MBNativeAdvancedWebview mBNativeAdvancedWebview2 = this.j;
            if (mBNativeAdvancedWebview2 != null && mBNativeAdvancedWebview2.getParent() == null) {
                this.i.addView(this.j, new ViewGroup.LayoutParams(-1, -1));
            }
        }
        if (this.z == null) {
            this.z = new MBOutNativeAdvancedViewGroup(com.mbridge.msdk.foundation.controller.c.m().d());
            if (this.u != 0 && this.v != 0) {
                layoutParams = new ViewGroup.LayoutParams(this.u, this.v);
            } else {
                layoutParams = new ViewGroup.LayoutParams(-1, -1);
            }
            this.z.setLayoutParams(layoutParams);
            this.z.setProvider(this);
            this.z.addView(this.i);
            this.z.getViewTreeObserver().addOnScrollChangedListener(this.F);
        }
        if (this.n == null) {
            this.n = new j();
        }
        this.n.a(com.mbridge.msdk.foundation.controller.c.m().d(), com.mbridge.msdk.foundation.controller.c.m().b(), com.mbridge.msdk.foundation.controller.c.m().c(), this.f4706a);
    }

    public String a(String str) {
        com.mbridge.msdk.advanced.manager.b bVar = this.d;
        if (bVar != null) {
            return bVar.a(str);
        }
        return "";
    }

    private void a(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.v = i;
        this.u = i2;
        this.z.setLayoutParams(new ViewGroup.LayoutParams(i2, i));
    }
}
