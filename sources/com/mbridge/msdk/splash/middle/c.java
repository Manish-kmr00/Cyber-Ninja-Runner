package com.mbridge.msdk.splash.middle;

import android.R;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.c1;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.out.MBSplashLoadListener;
import com.mbridge.msdk.out.MBSplashShowListener;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.ZoomOutTypeEnum;
import com.mbridge.msdk.setting.h;
import com.mbridge.msdk.setting.j;
import com.mbridge.msdk.setting.l;
import com.mbridge.msdk.splash.manager.e;
import com.mbridge.msdk.splash.manager.f;
import com.mbridge.msdk.splash.view.BaseSplashPopView;
import com.mbridge.msdk.splash.view.MBSplashPopView;
import com.mbridge.msdk.splash.view.MBSplashView;

/* JADX INFO: compiled from: SplashProvider.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {
    private static String D = "SplashProvider";
    private CampaignEx A;
    private MBSplashPopView B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5445a;
    private String b;
    private MBridgeIds c;
    private long e;
    private e f;
    private f g;
    private b h;
    private MBSplashShowListener i;
    private d j;
    private MBSplashView k;
    private ViewGroup l;
    private View m;
    private l n;
    private boolean o;
    private ViewGroup p;
    private j q;
    private boolean r;
    private Activity y;
    private boolean z;
    private int d = 5;
    private int s = 1;
    private int t = k0.n(com.mbridge.msdk.foundation.controller.c.m().d());
    private int u = k0.m(com.mbridge.msdk.foundation.controller.c.m().d());
    private Object v = new Object();
    private Object w = new Object();
    public boolean x = false;
    private boolean C = false;

    /* JADX INFO: compiled from: SplashProvider.java */
    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f5446a;
        final /* synthetic */ int b;
        final /* synthetic */ boolean c;

        a(CampaignEx campaignEx, int i, boolean z) {
            this.f5446a = campaignEx;
            this.b = i;
            this.c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.a(this.f5446a, this.b - 1, this.c);
        }
    }

    public c(Activity activity, String str, String str2) {
        this.b = TextUtils.isEmpty(str) ? "" : str;
        this.f5445a = str2;
        this.c = new MBridgeIds(str, str2);
        this.y = activity;
        b(activity);
    }

    public void b(boolean z) {
        this.o = z;
    }

    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            b(str);
        } else if (this.h != null) {
            this.h.a(new com.mbridge.msdk.foundation.error.b(880035), 1);
        }
    }

    public int d() {
        return this.d;
    }

    public long e() {
        return this.e;
    }

    public boolean f() {
        return this.r;
    }

    public boolean g() {
        return this.o;
    }

    public void h() {
        f fVar = this.g;
        if (fVar != null) {
            fVar.f();
        }
        MBSplashPopView mBSplashPopView = this.B;
        if (mBSplashPopView == null || !this.C) {
            return;
        }
        mBSplashPopView.pauseCountDown();
    }

    public void i() {
        f fVar = this.g;
        if (fVar != null) {
            fVar.g();
        }
        MBSplashPopView mBSplashPopView = this.B;
        if (mBSplashPopView == null || !this.C) {
            return;
        }
        mBSplashPopView.reStartCountDown();
    }

    public void j() {
        this.C = true;
        MBSplashPopView mBSplashPopView = this.B;
        if (mBSplashPopView != null) {
            mBSplashPopView.startCountDown();
        }
    }

    public void k() {
        this.C = false;
        MBSplashShowListener mBSplashShowListener = this.i;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onZoomOutPlayFinish(new MBridgeIds(this.b, this.f5445a));
        }
        MBSplashPopView mBSplashPopView = this.B;
        if (mBSplashPopView != null) {
            mBSplashPopView.release();
        }
    }

    public void a(ViewGroup viewGroup) {
        this.p = viewGroup;
    }

    public void b(String str) {
        a(str, 1);
    }

    public void d(String str, Activity activity) {
        ViewGroup viewGroupA = a(activity);
        if (viewGroupA != null) {
            d(str, viewGroupA);
            return;
        }
        MBSplashShowListener mBSplashShowListener = this.i;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onShowFailed(this.c, "activity is except,please check it");
        }
    }

    public void a(int i) {
        this.s = i;
    }

    public void b(String str, Activity activity) {
        ViewGroup viewGroupA = a(activity);
        if (viewGroupA == null) {
            if (this.h != null) {
                this.h.a(new com.mbridge.msdk.foundation.error.b(880036), 1);
                return;
            }
            return;
        }
        b(str, viewGroupA);
    }

    public void a(long j) {
        this.e = j;
    }

    public void a(MBSplashLoadListener mBSplashLoadListener) {
        if (this.h == null) {
            this.h = new b(this, this.c);
        }
        this.h.a(mBSplashLoadListener);
    }

    public void c(boolean z) {
        this.r = z;
    }

    public void a(MBSplashShowListener mBSplashShowListener) {
        this.i = mBSplashShowListener;
    }

    public String c() {
        if (!this.x) {
            e eVar = this.f;
            if (eVar != null) {
                return eVar.d();
            }
            return "";
        }
        f fVar = this.g;
        if (fVar != null) {
            return fVar.d();
        }
        return "";
    }

    public void a(String str, Activity activity) {
        ViewGroup viewGroupA = a(activity);
        if (viewGroupA == null) {
            if (this.h != null) {
                this.h.a(new com.mbridge.msdk.foundation.error.b(880036), 1);
                return;
            }
            return;
        }
        a(str, viewGroupA);
    }

    public void d(String str, ViewGroup viewGroup) {
        if (TextUtils.isEmpty(str)) {
            MBSplashShowListener mBSplashShowListener = this.i;
            if (mBSplashShowListener != null) {
                mBSplashShowListener.onShowFailed(this.c, "token is null or empty");
                return;
            }
            return;
        }
        c(str, viewGroup);
    }

    public void b(String str, ViewGroup viewGroup) {
        if (TextUtils.isEmpty(str)) {
            if (this.h != null) {
                this.h.a(new com.mbridge.msdk.foundation.error.b(880035), 1);
                return;
            }
            return;
        }
        a(str, viewGroup);
    }

    public void d(boolean z) {
        this.z = z;
    }

    public void a(String str, ViewGroup viewGroup) {
        this.l = viewGroup;
        MBSplashView mBSplashView = this.k;
        if (mBSplashView != null) {
            mBSplashView.setDevContainer(viewGroup);
        }
        a(str, 2);
    }

    public void b(int i) {
        this.d = i;
    }

    public void c(String str, Activity activity) {
        ViewGroup viewGroupA = a(activity);
        if (viewGroupA == null) {
            MBSplashShowListener mBSplashShowListener = this.i;
            if (mBSplashShowListener != null) {
                mBSplashShowListener.onShowFailed(this.c, "activity is except,please check it");
                return;
            }
            return;
        }
        c(str, viewGroupA);
    }

    public void b(int i, int i2) {
        a(i2, i);
    }

    public String b() {
        if (!this.x) {
            e eVar = this.f;
            if (eVar != null) {
                return eVar.c();
            }
            return "";
        }
        f fVar = this.g;
        if (fVar != null) {
            return fVar.c();
        }
        return "";
    }

    public boolean a(String str) {
        return com.mbridge.msdk.splash.manager.d.a(this.k, this.b, this.f5445a, str, this.r, this.d, false, true) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CampaignEx campaignEx, int i, boolean z) {
        if (!com.mbridge.msdk.splash.manager.d.a(this.k, campaignEx)) {
            if (i > 0) {
                this.g.y.postDelayed(new a(campaignEx, i, z), 1L);
                return;
            }
            d dVar = this.j;
            if (dVar != null) {
                dVar.a(this.c, "campaignEx is not ready");
                return;
            }
            return;
        }
        a(true);
        ViewGroup.LayoutParams layoutParams = this.l.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        } else {
            layoutParams.height = -1;
            layoutParams.width = -1;
        }
        this.l.setLayoutParams(layoutParams);
        this.l.removeAllViews();
        this.g.c(this.d);
        this.g.a(this.p);
        this.g.a(this.j);
        o0.b(D, "start show process");
        ViewGroup viewGroup = this.l;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            c1.a(this.k);
            this.l.addView(this.k);
        }
        this.g.a(this.r);
        this.g.a(campaignEx, this.k);
    }

    public void c(String str, ViewGroup viewGroup) {
        this.l = viewGroup;
        MBSplashView mBSplashView = this.k;
        if (mBSplashView != null) {
            mBSplashView.setDevContainer(viewGroup);
        }
        CampaignEx campaignExA = com.mbridge.msdk.splash.manager.d.a(this.k, this.b, this.f5445a, str, this.r, this.d, true, false);
        if (campaignExA != null) {
            if (this.n == null) {
                this.n = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b(), this.f5445a);
            }
            d dVar = new d(this, this.i, campaignExA);
            this.j = dVar;
            if (this.t != 0 && this.u != 0) {
                int i = this.d;
                if (i >= 2 && i <= 10) {
                    b(campaignExA, this.n.E(), false);
                    return;
                } else {
                    dVar.a(this.c, "countDownTime must in 2 - 10 ,but now is " + this.d);
                    return;
                }
            }
            dVar.a(this.c, "width or height is 0  or width or height is too small");
            return;
        }
        MBSplashShowListener mBSplashShowListener = this.i;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onShowFailed(this.c, "campaignEx is vali");
        }
    }

    void b(CampaignEx campaignEx, int i, boolean z) {
        if (campaignEx != null && z) {
            if (this.n == null) {
                this.n = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b(), this.f5445a);
            }
            this.j = new d(this, this.i, campaignEx);
        }
        ViewGroup viewGroup = this.l;
        if (viewGroup == null) {
            d dVar = this.j;
            if (dVar != null) {
                dVar.a(this.c, "container is null");
                return;
            }
            return;
        }
        if (this.g == null) {
            this.g = new f(viewGroup.getContext(), this.b, this.f5445a);
        }
        this.A = campaignEx;
        a(campaignEx, i, z);
    }

    private void b(Activity activity) {
        if (this.g == null) {
            if (activity != null) {
                this.g = new f(activity, this.b, this.f5445a);
            } else {
                this.g = new f(com.mbridge.msdk.foundation.controller.c.m().d(), this.b, this.f5445a);
            }
        }
        if (this.k == null) {
            if (activity != null) {
                this.k = new MBSplashView(activity);
            } else {
                this.k = new MBSplashView(com.mbridge.msdk.foundation.controller.c.m().d());
            }
        }
        if (this.q == null) {
            this.q = new j();
        }
        this.q.a(com.mbridge.msdk.foundation.controller.c.m().d(), com.mbridge.msdk.foundation.controller.c.m().b(), com.mbridge.msdk.foundation.controller.c.m().c(), this.f5445a);
    }

    private void a(String str, int i) {
        boolean zB;
        synchronized (this.v) {
            if (this.o) {
                if (this.h != null) {
                    this.h.a(new com.mbridge.msdk.foundation.error.b(880016, "current unit is loading"), i);
                    this.o = true;
                }
                return;
            }
            this.o = true;
            int i2 = this.d;
            if (i2 >= 2 && i2 <= 10) {
                if (this.t != 0 && this.u != 0) {
                    try {
                        zB = com.mbridge.msdk.mbsignalcommon.webEnvCheck.a.b(com.mbridge.msdk.foundation.controller.c.m().d());
                    } catch (Exception unused) {
                        zB = false;
                    }
                    if (!zB) {
                        if (this.h != null) {
                            this.h.a(new com.mbridge.msdk.foundation.error.b(880029), i);
                            return;
                        }
                        return;
                    }
                    this.k.clearResState();
                    this.n = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b(), this.f5445a);
                    if (this.f == null) {
                        this.f = new e(this.b, this.f5445a, this.e * 1000);
                    }
                    b bVar = this.h;
                    if (bVar != null) {
                        bVar.a(str);
                        this.f.a(this.h);
                    }
                    this.k.resetLoadState();
                    this.f.a(this.d);
                    this.f.a(this.k);
                    this.f.a(this.n);
                    this.f.a(this.t, this.u);
                    this.f.a(this.r);
                    this.f.b(this.s);
                    this.f.a(str, i);
                    return;
                }
                if (this.h != null) {
                    this.h.a(new com.mbridge.msdk.foundation.error.b(880028), i);
                    return;
                }
                return;
            }
            if (this.h != null) {
                com.mbridge.msdk.foundation.error.b bVar2 = new com.mbridge.msdk.foundation.error.b(880037);
                bVar2.c("countDownTime must in 2 - 10");
                this.h.a(bVar2, i);
            }
        }
    }

    public void a(View view, RelativeLayout.LayoutParams layoutParams) {
        this.m = view;
        if (view != null) {
            a(layoutParams.width, layoutParams.height);
            MBSplashView mBSplashView = this.k;
            if (mBSplashView != null) {
                mBSplashView.setIconVg(view, layoutParams);
            }
        }
    }

    public ViewGroup a(ZoomOutTypeEnum zoomOutTypeEnum) {
        MBSplashPopView mBSplashPopView = new MBSplashPopView(com.mbridge.msdk.foundation.controller.c.m().d(), new BaseSplashPopView.i(this.b, this.f5445a, zoomOutTypeEnum.getIndex(), this.A), this.j);
        this.B = mBSplashPopView;
        return mBSplashPopView;
    }

    private void a(int i, int i2) {
        int iN = k0.n(com.mbridge.msdk.foundation.controller.c.m().d());
        int iM = k0.m(com.mbridge.msdk.foundation.controller.c.m().d());
        int i3 = this.s;
        if (i3 == 1) {
            if (iM >= i2 * 4) {
                this.u = iM - i2;
                this.t = iN;
                return;
            } else {
                this.u = 0;
                this.t = 0;
                return;
            }
        }
        if (i3 == 2) {
            if (iN >= i * 4) {
                this.t = iN - i;
                this.u = iM;
            } else {
                this.u = 0;
                this.t = 0;
            }
        }
    }

    public void a(boolean z) {
        MBSplashView mBSplashView = this.k;
        if (mBSplashView != null) {
            mBSplashView.setAllowClickSplash(z);
        }
    }

    private ViewGroup a(Activity activity) {
        Throwable th;
        ViewGroup viewGroup;
        if (activity != null && activity.isFinishing()) {
            activity = null;
        }
        if (activity == null) {
            o0.d(D, "splash can't show because, activity is null or activity is finishing");
            return null;
        }
        try {
            viewGroup = (ViewGroup) activity.getWindow().getDecorView().findViewById(R.id.content);
            try {
                try {
                    return (ViewGroup) viewGroup.getChildAt(0);
                } catch (Exception e) {
                    e.printStackTrace();
                    return viewGroup;
                }
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                return viewGroup;
            }
        } catch (Throwable th3) {
            th = th3;
            viewGroup = null;
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        try {
            MBSplashView mBSplashView = this.k;
            if (mBSplashView != null) {
                mBSplashView.setNotchPadding(i, i2, i3, i4);
            }
        } catch (Throwable th) {
            o0.b(D, th.getMessage());
        }
    }

    public void a() {
        this.A = null;
        if (this.i != null) {
            this.i = null;
        }
        if (this.h != null) {
            this.h = null;
        }
        if (this.j != null) {
            this.j = null;
        }
        e eVar = this.f;
        if (eVar != null) {
            eVar.e();
        }
        f fVar = this.g;
        if (fVar != null) {
            fVar.h();
        }
        if (this.y != null) {
            this.y = null;
        }
    }
}
