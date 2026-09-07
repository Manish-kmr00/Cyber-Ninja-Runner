package com.json;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.json.mediationsdk.logger.IronLog;
import com.json.sdk.utils.Logger;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import com.safedk.android.utils.h;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class vg extends FrameLayout implements vh {
    private static final String b = "IronSourceAdContainer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ah f4524a;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4525a;
        final /* synthetic */ String b;

        a(String str, String str2) {
            this.f4525a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            vg vgVar = vg.this;
            vgVar.removeView(vgVar.f4524a.getPresentingView());
            vg.this.f4524a.a(this.f4525a, this.b);
            vg.this.f4524a = null;
        }
    }

    public vg(Context context) {
        super(context);
    }

    public vg(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public vg(ah ahVar, Context context) {
        super(context);
        setLayoutParams(new FrameLayout.LayoutParams(ahVar.d().c(), ahVar.d().a()));
        this.f4524a = ahVar;
        addView(ahVar.getPresentingView());
    }

    private void b() throws Exception {
        JSONObject jSONObjectJsonObjectInit;
        try {
            jSONObjectJsonObjectInit = this.f4524a.c().a().getJSONObject(ug.p).getJSONObject(ug.s);
        } catch (Exception e) {
            o9.d().a(e);
            jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
        }
        jSONObjectJsonObjectInit.put("adViewId", this.f4524a.b());
        this.f4524a.c().a(b9.g.S, jSONObjectJsonObjectInit);
    }

    public void a() throws Exception {
        ah ahVar = this.f4524a;
        if (ahVar == null || ahVar.c() == null) {
            throw new Exception("mAdPresenter or mAdPresenter.getAdViewLogic() are null");
        }
        b();
    }

    @Override // com.json.vh
    public synchronized void a(String str, String str2) {
        ah ahVar = this.f4524a;
        if (ahVar != null && ahVar.c() != null && this.f4524a.getPresentingView() != null) {
            this.f4524a.c().e();
            hg.f3748a.d(new a(str, str2));
        }
    }

    @Override // com.json.vh
    public void a(String str, String str2, String str3) {
        ah ahVar = this.f4524a;
        if (ahVar == null) {
            return;
        }
        ahVar.a(str, str2, str3);
    }

    @Override // com.json.vh
    public void a(JSONObject jSONObject, String str, String str2) {
        this.f4524a.a(jSONObject, str, str2);
    }

    @Override // com.json.vh
    public void b(JSONObject jSONObject, String str, String str2) {
        this.f4524a.b(jSONObject, str, str2);
    }

    @Override // com.json.vh
    public void c(JSONObject jSONObject, String str, String str2) throws JSONException {
        this.f4524a.c(jSONObject, str, str2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.f, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.json.vh
    public WebView getPresentingView() {
        return this.f4524a.getPresentingView();
    }

    public tg getSize() {
        ah ahVar = this.f4524a;
        return ahVar != null ? ahVar.d() : new tg();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        Logger.i(b, "onVisibilityChanged: " + i);
        ah ahVar = this.f4524a;
        if (ahVar == null) {
            return;
        }
        try {
            ahVar.c().a(ug.k, i, isShown());
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        Logger.i(b, "onWindowVisibilityChanged: " + i);
        ah ahVar = this.f4524a;
        if (ahVar == null) {
            return;
        }
        try {
            ahVar.c().a(ug.l, i, isShown());
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }
}
