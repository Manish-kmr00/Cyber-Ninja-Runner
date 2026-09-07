package com.json.sdk.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.json.a3;
import com.json.b9;
import com.json.bh;
import com.json.cc;
import com.json.er;
import com.json.gh;
import com.json.kw;
import com.json.l;
import com.json.lh;
import com.json.m;
import com.json.mediationsdk.logger.IronLog;
import com.json.mm;
import com.json.nf;
import com.json.nv;
import com.json.o9;
import com.json.sdk.utils.Logger;
import com.json.sdk.utils.SDKUtils;
import com.json.so;
import com.json.u5;
import com.json.vj;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes12.dex */
public class ControllerActivity extends Activity implements so, nv {
    private static final String n = "ControllerActivity";
    private static final int o = 1;
    private static String p = "removeWebViewContainerView | mContainer is null";
    private static String q = "removeWebViewContainerView | view is null";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4273a;
    private v b;
    private RelativeLayout c;
    private FrameLayout d;
    private nf e;
    private String g;
    private a3 k;
    private boolean l;
    private boolean m;
    public int currentRequestedRotation = -1;
    private boolean f = false;
    private Handler h = new Handler();
    private final Runnable i = new a();
    final RelativeLayout.LayoutParams j = new RelativeLayout.LayoutParams(-1, -1);

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ControllerActivity.this.getWindow().getDecorView().setSystemUiVisibility(SDKUtils.getActivityUIFlags(ControllerActivity.this.f));
        }
    }

    class b implements View.OnSystemUiVisibilityChangeListener {
        b() {
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i) {
            if ((i & 4098) == 0) {
                ControllerActivity.this.h.removeCallbacks(ControllerActivity.this.i);
                ControllerActivity.this.h.postDelayed(ControllerActivity.this.i, 500L);
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ControllerActivity.this.getWindow().addFlags(128);
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ControllerActivity.this.getWindow().clearFlags(128);
        }
    }

    private View a(ViewGroup viewGroup) {
        return d() ? viewGroup.findViewById(1) : bh.a().a(this.f4273a).getPresentingView();
    }

    private FrameLayout a(String str) {
        return !b(str) ? this.b.s() : kw.a(getApplicationContext(), bh.a().a(str).getPresentingView());
    }

    private void a() {
        runOnUiThread(new d());
    }

    private void a(String str, int i) {
        int i2;
        if (str != null) {
            if ("landscape".equalsIgnoreCase(str)) {
                g();
                return;
            }
            if ("portrait".equalsIgnoreCase(str)) {
                h();
                return;
            }
            if ("device".equalsIgnoreCase(str)) {
                if (!this.e.E(this)) {
                    return;
                } else {
                    i2 = 1;
                }
            } else if (getRequestedOrientation() != -1) {
                return;
            } else {
                i2 = 4;
            }
            setRequestedOrientation(i2);
        }
    }

    private void b() {
        String str = n;
        Logger.i(str, "clearWebviewController");
        v vVar = this.b;
        if (vVar == null) {
            Logger.i(str, "clearWebviewController, null");
            return;
        }
        vVar.a(v.u.Gone);
        this.b.C();
        this.b.D();
        this.b.g(this.g, "onDestroy");
    }

    private boolean b(String str) {
        return (TextUtils.isEmpty(str) || str.equals(Integer.toString(1))) ? false : true;
    }

    private void c() {
        Intent intent = getIntent();
        a(intent.getStringExtra(b9.h.A), intent.getIntExtra(b9.h.B, 0));
    }

    private boolean d() {
        return this.f4273a == null;
    }

    private void e() {
        runOnUiThread(new c());
    }

    private void f() {
        ViewGroup viewGroup;
        try {
            if (this.c == null) {
                throw new Exception(p);
            }
            ViewGroup viewGroup2 = (ViewGroup) this.d.getParent();
            View viewA = a(viewGroup2);
            if (viewA == null) {
                throw new Exception(q);
            }
            if (isFinishing() && (viewGroup = (ViewGroup) viewA.getParent()) != null) {
                viewGroup.removeView(viewA);
            }
            viewGroup2.removeView(this.d);
        } catch (Exception e) {
            o9.d().a(e);
            lh.a(er.s, new gh().a(cc.A, e.getMessage()).a());
            Logger.i(n, "removeWebViewContainerView fail " + e.getMessage());
        }
    }

    private void g() {
        String str;
        String str2;
        int iL = this.e.L(this);
        String str3 = n;
        Logger.i(str3, "setInitiateLandscapeOrientation");
        if (iL != 0) {
            if (iL == 2) {
                str2 = "ROTATION_180";
            } else if (iL == 3) {
                str2 = "ROTATION_270 Right Landscape";
            } else {
                if (iL != 1) {
                    Logger.i(str3, "No Rotation");
                    return;
                }
                str = "ROTATION_90 Left Landscape";
            }
            Logger.i(str3, str2);
            setRequestedOrientation(8);
            return;
        }
        str = "ROTATION_0";
        Logger.i(str3, str);
        setRequestedOrientation(0);
    }

    private void h() {
        String str;
        int iL = this.e.L(this);
        String str2 = n;
        Logger.i(str2, "setInitiatePortraitOrientation");
        if (iL == 0) {
            str = "ROTATION_0";
        } else if (iL == 2) {
            Logger.i(str2, "ROTATION_180");
            setRequestedOrientation(9);
            return;
        } else if (iL == 1) {
            str = "ROTATION_270 Right Landscape";
        } else {
            if (iL != 3) {
                Logger.i(str2, "No Rotation");
                return;
            }
            str = "ROTATION_90 Left Landscape";
        }
        Logger.i(str2, str);
        setRequestedOrientation(1);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.f, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.json.so
    public boolean onBackButtonPressed() {
        onBackPressed();
        return true;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Logger.i(n, "onBackPressed");
        if (u5.a().a(this)) {
            return;
        }
        super.onBackPressed();
    }

    @Override // com.json.so
    public void onCloseRequested() {
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.e = mm.S().f();
        try {
            new m(this).a();
            new l(this).a();
            v vVar = (v) vj.b((Context) this).a().j();
            this.b = vVar;
            vVar.s().setId(1);
            this.b.a((so) this);
            this.b.a((nv) this);
            Intent intent = getIntent();
            this.g = intent.getStringExtra(b9.h.m);
            this.f = intent.getBooleanExtra(b9.h.v, false);
            this.f4273a = intent.getStringExtra("adViewId");
            this.l = false;
            this.m = intent.getBooleanExtra(b9.h.z0, false);
            if (this.f) {
                getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new b());
                runOnUiThread(this.i);
            }
            RelativeLayout relativeLayout = new RelativeLayout(this);
            this.c = relativeLayout;
            setContentView(relativeLayout, this.j);
            this.d = a(this.f4273a);
            if (this.c.findViewById(1) == null && this.d.getParent() != null) {
                finish();
            }
            c();
            this.c.addView(this.d, this.j);
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        String str = n;
        Logger.i(str, "onDestroy");
        f();
        if (this.l) {
            return;
        }
        Logger.i(str, "onDestroy | destroyedFromBackground");
        b();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.b.y()) {
            this.b.x();
            return true;
        }
        if (this.f && (i == 25 || i == 24)) {
            this.h.removeCallbacks(this.i);
            this.h.postDelayed(this.i, 500L);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.json.so
    public void onOrientationChanged(String str, int i) {
        a(str, i);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        Logger.i(n, "onPause, isFinishing=" + isFinishing());
        t.a(this);
        v vVar = this.b;
        if (vVar != null) {
            vVar.a((Context) this);
            if (!this.m) {
                this.b.B();
            }
            this.b.a(false, b9.h.Z);
            this.b.g(this.g, b9.h.t0);
        }
        if (isFinishing()) {
            this.l = true;
            b();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        Logger.i(n, b9.h.u0);
        v vVar = this.b;
        if (vVar != null) {
            vVar.b(this);
            if (!this.m) {
                this.b.F();
            }
            this.b.a(true, b9.h.Z);
            this.b.g(this.g, b9.h.u0);
        }
        t.b(this);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        Logger.i(n, "onStart");
        v vVar = this.b;
        if (vVar != null) {
            vVar.g(this.g, "onStart");
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        Logger.i(n, "onStop");
        v vVar = this.b;
        if (vVar != null) {
            vVar.g(this.g, "onStop");
        }
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        Logger.i(n, "onUserLeaveHint");
        v vVar = this.b;
        if (vVar != null) {
            vVar.g(this.g, "onUserLeaveHint");
        }
    }

    @Override // com.json.nv
    public void onVideoEnded() {
        toggleKeepScreen(false);
    }

    @Override // com.json.nv
    public void onVideoPaused() {
        toggleKeepScreen(false);
    }

    @Override // com.json.nv
    public void onVideoResumed() {
        toggleKeepScreen(true);
    }

    @Override // com.json.nv
    public void onVideoStarted() {
        toggleKeepScreen(true);
    }

    @Override // com.json.nv
    public void onVideoStopped() {
        toggleKeepScreen(false);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.f && z) {
            runOnUiThread(this.i);
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        if (this.currentRequestedRotation != i) {
            Logger.i(n, "Rotation: Req = " + i + " Curr = " + this.currentRequestedRotation);
            this.currentRequestedRotation = i;
            super.setRequestedOrientation(i);
        }
    }

    public void toggleKeepScreen(boolean z) {
        if (z) {
            e();
        } else {
            a();
        }
    }
}
