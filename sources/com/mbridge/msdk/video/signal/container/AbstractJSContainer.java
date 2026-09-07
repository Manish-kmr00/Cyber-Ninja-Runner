package com.mbridge.msdk.video.signal.container;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import com.mbridge.msdk.video.signal.b;
import com.mbridge.msdk.video.signal.d;
import com.mbridge.msdk.video.signal.factory.IJSFactory;
import com.mbridge.msdk.video.signal.factory.a;
import com.mbridge.msdk.video.signal.g;
import com.mbridge.msdk.video.signal.i;
import com.mbridge.msdk.video.signal.impl.k;
import com.mbridge.msdk.video.signal.j;
import com.mbridge.msdk.videocommon.setting.c;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractJSContainer extends FrameLayout implements IJSFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5944a;
    private int b;
    protected Activity c;
    protected String d;
    protected String e;
    protected c f;
    protected String g;
    protected com.mbridge.msdk.videocommon.entity.c h;
    protected String i;
    protected int j;
    protected boolean k;
    protected boolean l;
    protected int m;
    protected int n;
    protected int o;
    protected boolean p;
    protected IJSFactory q;

    public AbstractJSContainer(Context context) {
        super(context);
        this.f5944a = 0;
        this.b = 1;
        this.j = 2;
        this.k = false;
        this.l = false;
        this.p = false;
        this.q = new a();
    }

    protected void a(Object obj) {
        f.a().b(obj, h(this.f5944a));
    }

    protected void b(Object obj, String str) {
        f.a().b(obj, Base64.encodeToString(str.getBytes(), 2));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.o, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public b getActivityProxy() {
        return this.q.getActivityProxy();
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public i getIJSRewardVideoV1() {
        return this.q.getIJSRewardVideoV1();
    }

    protected String getInnerPlacementId() {
        c cVar;
        return (!TextUtils.isEmpty(this.e) || (cVar = this.f) == null || TextUtils.isEmpty(cVar.t())) ? this.e : this.f.t();
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public com.mbridge.msdk.video.signal.c getJSBTModule() {
        return this.q.getJSBTModule();
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public d getJSCommon() {
        return this.q.getJSCommon();
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public com.mbridge.msdk.video.signal.f getJSContainerModule() {
        return this.q.getJSContainerModule();
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public g getJSNotifyProxy() {
        return this.q.getJSNotifyProxy();
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public j getJSVideoModule() {
        return this.q.getJSVideoModule();
    }

    public String getPlacementId() {
        return this.e;
    }

    public String getUnitId() {
        return this.d;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        if (getJSCommon().a()) {
            getActivityProxy().a(configuration);
        }
    }

    public void onDestroy() {
        if (getJSCommon().a()) {
            getActivityProxy().b();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public void onPause() {
        if (getJSCommon().a()) {
            getActivityProxy().g();
        }
        getActivityProxy().a(1);
    }

    public void onRestart() {
        if (getJSCommon().a()) {
            getActivityProxy().f();
        }
        getActivityProxy().a(4);
    }

    public void onResume() {
        if (com.mbridge.msdk.foundation.feedback.b.f) {
            return;
        }
        if (getJSCommon().a()) {
            getActivityProxy().d();
        }
        getActivityProxy().a(0);
    }

    public void onStart() {
        if (getJSCommon().a()) {
            getActivityProxy().h();
        }
        getActivityProxy().a(2);
    }

    public void onStop() {
        if (getJSCommon().a()) {
            getActivityProxy().c();
        }
        getActivityProxy().a(3);
    }

    public void registerJsFactory(IJSFactory iJSFactory) {
        this.q = iJSFactory;
    }

    public void setActivity(Activity activity) {
        this.c = activity;
    }

    public void setBidCampaign(boolean z) {
        this.l = z;
    }

    public void setBigOffer(boolean z) {
        this.p = z;
    }

    public void setIV(boolean z) {
        this.k = z;
    }

    public void setIVRewardEnable(int i, int i2, int i3) {
        this.m = i;
        this.n = i2;
        this.o = i3;
    }

    public void setMute(int i) {
        this.j = i;
    }

    public void setPlacementId(String str) {
        this.e = str;
    }

    public void setReward(com.mbridge.msdk.videocommon.entity.c cVar) {
        this.h = cVar;
    }

    public void setRewardId(String str) {
        this.i = str;
    }

    public void setRewardUnitSetting(c cVar) {
        this.f = cVar;
    }

    public void setUnitId(String str) {
        this.d = str;
    }

    public void setUserId(String str) {
        this.g = str;
    }

    private boolean i(int i) {
        try {
            if (i != 1) {
                if (i == 2) {
                    this.c.setRequestedOrientation(11);
                }
                return false;
            }
            this.c.setRequestedOrientation(12);
            return true;
        } catch (Throwable th) {
            o0.b("AbstractJSContainer", th.getMessage(), th);
        }
    }

    protected void a(Object obj, String str) {
        f.a().a(obj, Base64.encodeToString(str.getBytes(), 2));
    }

    protected void b(String str) {
        o0.b("AbstractJSContainer", str);
        Activity activity = this.c;
        if (activity != null) {
            activity.finish();
        }
    }

    protected int a(CampaignEx campaignEx) {
        k kVarB = b(campaignEx);
        if (kVarB != null) {
            return kVarB.n();
        }
        return 0;
    }

    protected String h(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            String string = jSONObject.toString();
            if (!TextUtils.isEmpty(string)) {
                return Base64.encodeToString(string.getBytes(), 2);
            }
        } catch (Throwable unused) {
            o0.b("AbstractJSContainer", "code to string is error");
        }
        return "";
    }

    protected k b(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return null;
        }
        com.mbridge.msdk.videocommon.a.C0521a c0521aA = com.mbridge.msdk.videocommon.a.a(this.k ? 287 : 94, campaignEx);
        if (c0521aA != null && c0521aA.c()) {
            WindVaneWebView windVaneWebViewB = c0521aA.b();
            if (windVaneWebViewB.getObject() instanceof k) {
                return (k) windVaneWebViewB.getObject();
            }
        }
        return null;
    }

    protected void a(c cVar, CampaignEx campaignEx) {
        CampaignEx.c rewardTemplateMode;
        if (a(campaignEx) == 1) {
            return;
        }
        if (((campaignEx == null || (rewardTemplateMode = campaignEx.getRewardTemplateMode()) == null) ? false : i(rewardTemplateMode.b())) || cVar == null) {
            return;
        }
        i(this.f.y());
    }

    public AbstractJSContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5944a = 0;
        this.b = 1;
        this.j = 2;
        this.k = false;
        this.l = false;
        this.p = false;
        this.q = new a();
    }
}
