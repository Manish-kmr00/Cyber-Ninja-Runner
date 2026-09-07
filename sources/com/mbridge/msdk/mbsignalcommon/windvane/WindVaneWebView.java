package com.mbridge.msdk.mbsignalcommon.windvane;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.mbsignalcommon.base.BaseWebView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.internal.partials.MintegralNetworkBridge;
import com.unity3d.ads.adplayer.AndroidWebViewClient;

/* JADX INFO: loaded from: classes7.dex */
public class WindVaneWebView extends BaseWebView {
    protected j d;
    protected b e;
    protected e f;
    private Object g;
    private Object h;
    private String i;
    private c j;
    private String k;
    private String l;
    private CampaignEx m;
    private int n;
    private boolean o;
    private float p;
    private float q;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            WindVaneWebView.this.o = true;
            WindVaneWebView.this.destroy();
        }
    }

    public WindVaneWebView(Context context) {
        super(context);
        this.o = false;
        this.p = 0.0f;
        this.q = 0.0f;
    }

    public void clearWebView() {
        if (this.o) {
            return;
        }
        MintegralNetworkBridge.webviewLoadUrl(this, AndroidWebViewClient.BLANK_PAGE);
    }

    @Override // com.mbridge.msdk.mbsignalcommon.base.BaseWebView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.o, this, me);
        return super.dispatchTouchEvent(me);
    }

    public CampaignEx getCampaignEx() {
        return this.m;
    }

    public String getCampaignId() {
        return this.i;
    }

    public Object getJsObject(String str) {
        e eVar = this.f;
        if (eVar == null) {
            return null;
        }
        return eVar.a(str);
    }

    public String getLocalRequestId() {
        return this.l;
    }

    public Object getMraidObject() {
        return this.h;
    }

    public Object getObject() {
        return this.g;
    }

    public String getRid() {
        return this.k;
    }

    public b getSignalCommunication() {
        return this.e;
    }

    public c getWebViewListener() {
        return this.j;
    }

    public boolean isDestoryed() {
        return this.o;
    }

    @Override // com.mbridge.msdk.mbsignalcommon.base.BaseWebView, android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.mbridge.msdk.mbsignalcommon.base.b bVar = this.mWebViewClient;
        if (bVar != null && (bVar.a() instanceof IntentFilter)) {
            String url = getUrl();
            if (!TextUtils.isEmpty(url) && url.contains("https://play.google.com")) {
                if (motionEvent.getAction() == 0) {
                    this.p = motionEvent.getRawX();
                    this.q = motionEvent.getRawY();
                } else {
                    float rawX = motionEvent.getRawX() - this.p;
                    float y = motionEvent.getY() - this.q;
                    if ((rawX >= 0.0f || rawX * (-1.0f) <= 48) && ((rawX <= 0.0f || rawX <= 48) && ((y >= 0.0f || (-1.0f) * y <= 48) && (y <= 0.0f || y <= 48)))) {
                        setClickable(false);
                        return true;
                    }
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void registerWindVanePlugin(Class cls) {
        e eVar = this.f;
        if (eVar == null) {
            return;
        }
        eVar.a(cls.getSimpleName(), cls);
    }

    public void release() {
        try {
            if (!this.o) {
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("type", Integer.valueOf(this.n));
                if (this.m != null) {
                    com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000135", this.m, eVar);
                }
            }
        } catch (Exception unused) {
        }
        try {
            setVisibility(8);
            removeAllViews();
            setDownloadListener(null);
            this.g = null;
            int iB = t0.b(getContext());
            if (iB == 0) {
                this.o = true;
                destroy();
            } else {
                new Handler().postDelayed(new a(), iB * 1000);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setApiManagerContext(Context context) {
        e eVar = this.f;
        if (eVar != null) {
            eVar.a(context);
        }
    }

    public void setApiManagerJSFactory(Object obj) {
        e eVar = this.f;
        if (eVar != null) {
            eVar.a(obj);
        }
    }

    public void setCampaignEx(CampaignEx campaignEx) {
        this.m = campaignEx;
    }

    public void setCampaignId(String str) {
        this.i = str;
    }

    public void setLocalRequestId(String str) {
        this.l = str;
    }

    public void setMraidObject(Object obj) {
        this.h = obj;
    }

    public void setObject(Object obj) {
        this.g = obj;
    }

    public void setRid(String str) {
        this.k = str;
    }

    public void setSignalCommunication(b bVar) {
        this.e = bVar;
        bVar.a(this);
    }

    public void setTempTypeForMetrics(int i) {
        this.n = i;
    }

    public void setWebViewChromeClient(j jVar) {
        this.d = jVar;
        MintegralNetworkBridge.webviewSetWebChromeClient(this, jVar);
    }

    public void setWebViewListener(c cVar) {
        this.j = cVar;
        j jVar = this.d;
        if (jVar != null) {
            jVar.a(cVar);
        }
        com.mbridge.msdk.mbsignalcommon.base.b bVar = this.mWebViewClient;
        if (bVar != null) {
            bVar.a(cVar);
        }
    }

    public void setWebViewTransparent() {
        super.setTransparent();
    }

    @Override // com.mbridge.msdk.mbsignalcommon.base.BaseWebView
    protected void a() {
        super.a();
        getSettings().setSavePassword(false);
        getSettings().setUserAgentString(getSettings().getUserAgentString() + " WindVane/3.0.2");
        if (this.d == null) {
            this.d = new j(this);
        }
        setWebViewChromeClient(this.d);
        k kVar = new k();
        this.mWebViewClient = kVar;
        setWebViewClient(kVar);
        if (this.e == null) {
            b hVar = new h(this.f5223a);
            this.e = hVar;
            setSignalCommunication(hVar);
        }
        this.f = new e(this.f5223a, this);
    }

    public WindVaneWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.o = false;
        this.p = 0.0f;
        this.q = 0.0f;
    }

    public WindVaneWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.o = false;
        this.p = 0.0f;
        this.q = 0.0f;
    }
}
