package com.mbridge.msdk.splash.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.mbridge.msdk.dycreator.listener.DyCountDownListener;
import com.mbridge.msdk.foundation.tools.b0;
import com.mbridge.msdk.foundation.tools.c1;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class MBSplashView extends RelativeLayout {
    private static String r = "MBSplashView";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5482a;
    private MBSplashWebview b;
    private com.mbridge.msdk.splash.view.a c;
    private ViewGroup d;
    private View e;
    private View f;
    private int g;
    private boolean h;
    private boolean i;
    private boolean j;
    private ViewGroup k;
    private View l;
    private boolean m;
    private boolean n;
    private RelativeLayout.LayoutParams o;
    private com.mbridge.msdk.splash.signal.b p;
    private DyCountDownListener q;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                o0.a(MBSplashView.r, "webviewshow");
                String string = "";
                try {
                    int[] iArr = new int[2];
                    MBSplashView.this.b.getLocationOnScreen(iArr);
                    o0.b(MBSplashView.r, "coordinate:" + iArr[0] + "--" + iArr[1]);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("startX", t0.b(com.mbridge.msdk.foundation.controller.c.m().d(), iArr[0]));
                    jSONObject.put("startY", t0.b(com.mbridge.msdk.foundation.controller.c.m().d(), iArr[1]));
                    string = jSONObject.toString();
                } catch (Throwable th) {
                    o0.b(MBSplashView.r, th.getMessage(), th);
                }
                int[] iArr2 = new int[2];
                MBSplashView.this.b.getLocationInWindow(iArr2);
                MBSplashView.transInfoForMraid(MBSplashView.this.b, iArr2[0], iArr2[1], MBSplashView.this.b.getWidth(), MBSplashView.this.b.getHeight());
                f.a().a((WebView) MBSplashView.this.b, "webviewshow", Base64.encodeToString(string.toString().getBytes(), 2));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class b implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f5484a;

        b(boolean z) {
            this.f5484a = z;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return !this.f5484a;
        }
    }

    class c implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f5485a;

        c(boolean z) {
            this.f5485a = z;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return !this.f5485a;
        }
    }

    public MBSplashView(Context context) {
        this(context, null);
    }

    private void b() {
        setBackgroundColor(0);
        this.f5482a = getResources().getConfiguration().orientation;
    }

    private void c() {
        View view;
        View view2;
        View view3;
        if (this.f != null) {
            if (this.d == null) {
                RelativeLayout relativeLayout = new RelativeLayout(getContext());
                this.d = relativeLayout;
                relativeLayout.setId(2147482647);
            }
            if (this.f5482a == 2) {
                this.g = t0.g(getContext());
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(0, this.d.getId());
                if (!this.m || (view2 = this.l) == null) {
                    MBSplashWebview mBSplashWebview = this.b;
                    if (mBSplashWebview != null && mBSplashWebview.getParent() == null) {
                        addView(this.b, layoutParams);
                    }
                    d();
                } else {
                    if (view2.getParent() != null) {
                        c1.a(this.l);
                    }
                    addView(this.l, layoutParams);
                }
                ViewGroup viewGroup = this.d;
                if (viewGroup != null && viewGroup.getParent() == null) {
                    int i = this.o.width;
                    c1.a(this.f);
                    int i2 = this.g / 4;
                    if (i > i2) {
                        this.d.addView(this.f, i2, -1);
                        i = i2;
                    } else {
                        this.d.addView(this.f, i, -1);
                    }
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, -1);
                    layoutParams2.addRule(11);
                    layoutParams2.addRule(13);
                    addView(this.d, layoutParams2);
                }
            } else {
                this.g = t0.f(getContext());
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams3.addRule(2, this.d.getId());
                if (!this.m || (view = this.l) == null) {
                    MBSplashWebview mBSplashWebview2 = this.b;
                    if (mBSplashWebview2 != null && mBSplashWebview2.getParent() == null) {
                        addView(this.b, layoutParams3);
                    }
                    d();
                } else {
                    if (view.getParent() != null) {
                        c1.a(this.l);
                    }
                    addView(this.l, layoutParams3);
                }
                ViewGroup viewGroup2 = this.d;
                if (viewGroup2 != null && viewGroup2.getParent() == null) {
                    int i3 = this.o.height;
                    int i4 = this.g / 4;
                    if (i3 > i4) {
                        i3 = i4;
                    }
                    c1.a(this.f);
                    this.d.addView(this.f, -1, i3);
                    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, i3);
                    layoutParams4.addRule(12);
                    addView(this.d, layoutParams4);
                }
            }
        } else if (!this.m || (view3 = this.l) == null) {
            MBSplashWebview mBSplashWebview3 = this.b;
            if (mBSplashWebview3 != null && mBSplashWebview3.getParent() == null) {
                addView(this.b, new ViewGroup.LayoutParams(-1, -1));
            }
            d();
        } else {
            if (view3.getParent() != null) {
                c1.a(this.l);
            }
            addView(this.l, new ViewGroup.LayoutParams(-1, -1));
        }
        View view4 = this.e;
        if (view4 != null) {
            if (view4.getParent() != null) {
                bringChildToFront(this.e);
                return;
            }
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(t0.a(getContext(), 100.0f), t0.a(getContext(), 30.0f));
            layoutParams5.addRule(10);
            layoutParams5.addRule(11);
            layoutParams5.rightMargin = t0.a(getContext(), 10.0f);
            layoutParams5.topMargin = t0.a(getContext(), 10.0f);
            addView(this.e, layoutParams5);
        }
    }

    private void d() {
        MBSplashWebview mBSplashWebview = this.b;
        if (mBSplashWebview != null) {
            mBSplashWebview.setObject(this.p);
            this.b.post(new a());
        }
    }

    public static void transInfoForMraid(WebView webView, int i, int i2, int i3, int i4) {
        String str;
        o0.b(r, "transInfoForMraid");
        try {
            int i5 = com.mbridge.msdk.foundation.controller.c.m().d().getResources().getConfiguration().orientation;
            JSONObject jSONObject = new JSONObject();
            if (i5 == 2) {
                str = "landscape";
            } else {
                str = i5 == 1 ? "portrait" : "undefined";
            }
            jSONObject.put("orientation", str);
            jSONObject.put("locked", "true");
            float fN = k0.n(com.mbridge.msdk.foundation.controller.c.m().d());
            float fM = k0.m(com.mbridge.msdk.foundation.controller.c.m().d());
            HashMap mapV = k0.v(com.mbridge.msdk.foundation.controller.c.m().d());
            int iIntValue = ((Integer) mapV.get("width")).intValue();
            int iIntValue2 = ((Integer) mapV.get("height")).intValue();
            HashMap map = new HashMap();
            map.put("placementType", "Interstitial");
            map.put("state", "default");
            map.put("viewable", "true");
            map.put("currentAppOrientation", jSONObject);
            float f = i;
            float f2 = i2;
            float f3 = i3;
            float f4 = i4;
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(webView, f, f2, f3, f4);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(webView, f, f2, f3, f4);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(webView, fN, fM);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(webView, iIntValue, iIntValue2);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(webView, map);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(webView);
        } catch (Throwable th) {
            o0.b(r, "transInfoForMraid", th);
        }
    }

    public void changeCloseBtnState(int i) {
        View view = this.e;
        if (view != null) {
            if (i == 2) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
        }
    }

    public void clearResState() {
        this.j = false;
        this.i = false;
        this.h = false;
    }

    public void destroy() {
        removeAllViews();
        ViewGroup viewGroup = this.k;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        MBSplashWebview mBSplashWebview = this.b;
        if (mBSplashWebview == null || mBSplashWebview.isDestoryed()) {
            return;
        }
        this.b.finishAdSession();
        com.mbridge.msdk.splash.signal.c.a(this.b, "onSystemDestory", "");
        this.b.release();
        this.b = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.o, this, me);
        return super.dispatchTouchEvent(me);
    }

    public View getCloseView() {
        return this.e;
    }

    public ViewGroup getDevContainer() {
        return this.k;
    }

    public View getIconVg() {
        return this.f;
    }

    public com.mbridge.msdk.splash.signal.b getSplashSignalCommunicationImpl() {
        return this.p;
    }

    public MBSplashWebview getSplashWebview() {
        return this.b;
    }

    public boolean isAttach() {
        return this.n;
    }

    public boolean isDynamicView() {
        return this.m;
    }

    public boolean isH5Ready() {
        return this.h;
    }

    public boolean isImageReady() {
        return this.j;
    }

    public boolean isVideoReady() {
        return this.i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.n = true;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        b();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public void onPause() {
        View view = this.l;
        if (view == null || !(view instanceof MBSplashNativeView)) {
            return;
        }
        ((MBSplashNativeView) view).setIsPause(true);
    }

    public void onResume() {
        View view = this.l;
        if (view == null || !(view instanceof MBSplashNativeView)) {
            return;
        }
        ((MBSplashNativeView) view).setIsPause(false);
    }

    public void resetLoadState() {
        this.i = false;
        this.h = false;
    }

    public void setAllowClickSplash(boolean z) {
        MBSplashWebview mBSplashWebview = this.b;
        if (mBSplashWebview != null) {
            mBSplashWebview.setOnTouchListener(new b(z));
        }
        setOnTouchListener(new c(z));
    }

    public void setCloseView(View view) {
        this.e = view;
        if (view != null) {
            view.setContentDescription("closeButton");
        }
    }

    public void setDevContainer(ViewGroup viewGroup) {
        this.k = viewGroup;
    }

    public void setDyCountDownListener(DyCountDownListener dyCountDownListener) {
        this.q = dyCountDownListener;
    }

    public void setDynamicView(boolean z) {
        this.m = z;
    }

    public void setH5Ready(boolean z) {
        this.h = z;
    }

    public void setIconVg(View view, RelativeLayout.LayoutParams layoutParams) {
        this.f = view;
        this.o = layoutParams;
    }

    public void setImageReady(boolean z) {
        this.j = z;
    }

    public void setNotchPadding(int i, int i2, int i3, int i4) {
        View view = this.l;
        if (view != null && (view instanceof MBSplashNativeView)) {
            ((MBSplashNativeView) view).setNotchPadding(i, i2, i3, i4);
        }
        if (this.b != null) {
            f.a().a((WebView) this.b, "oncutoutfetched", Base64.encodeToString(b0.a(-999, i, i2, i3, i4).getBytes(), 0));
        }
    }

    public void setSplashNativeView(View view) {
        if (view != null) {
            this.l = view;
        }
    }

    public void setSplashSignalCommunicationImpl(com.mbridge.msdk.splash.signal.b bVar) {
        this.p = bVar;
        MBSplashWebview mBSplashWebview = this.b;
        if (mBSplashWebview != null) {
            mBSplashWebview.setObject(bVar);
        }
    }

    public void setSplashWebView() {
        if (this.b == null) {
            try {
                MBSplashWebview mBSplashWebview = new MBSplashWebview(getContext());
                this.b = mBSplashWebview;
                com.mbridge.msdk.splash.signal.b bVar = this.p;
                if (bVar != null) {
                    mBSplashWebview.setObject(bVar);
                }
                com.mbridge.msdk.splash.view.a aVar = this.c;
                if (aVar != null) {
                    this.b.setWebViewClient(aVar);
                    return;
                }
                com.mbridge.msdk.splash.view.a aVar2 = new com.mbridge.msdk.splash.view.a();
                this.c = aVar2;
                this.b.setWebViewClient(aVar2);
            } catch (Throwable th) {
                o0.b(r, th.getMessage());
            }
        }
    }

    public void setVideoReady(boolean z) {
        this.i = z;
    }

    public void show() {
        ViewGroup viewGroup;
        if (this.p != null && (viewGroup = this.k) != null && (viewGroup.getContext() instanceof Activity)) {
            this.p.a(this.k.getContext());
            com.mbridge.msdk.splash.view.a aVar = this.c;
            if (aVar != null) {
                aVar.a(this.p.a());
            }
        }
        c();
        clearResState();
    }

    public void updateCountdown(int i) {
        DyCountDownListener dyCountDownListener;
        View view;
        if (this.b != null && !this.m) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("countdown", i);
                f.a().a((WebView) this.b, "updateCountdown", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (this.m && (view = this.l) != null && (view instanceof MBSplashNativeView)) {
            ((MBSplashNativeView) view).updateCountDown(i);
        }
        if (!this.m || (dyCountDownListener = this.q) == null) {
            return;
        }
        dyCountDownListener.getCountDownValue(i);
    }

    public MBSplashView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MBSplashView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }
}
