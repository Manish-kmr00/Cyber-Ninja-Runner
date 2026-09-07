package com.mbridge.msdk.video.dynview.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.foundation.same.report.metrics.e;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.setting.h;
import com.mbridge.msdk.video.bt.module.orglistener.f;
import com.mbridge.msdk.video.module.MBridgeBaseView;
import com.mbridge.msdk.widget.FeedBackButton;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class MBridgeOrderCampView extends MBridgeBaseView {
    private MBridgeOrderCampView m;
    private List<CampaignEx> n;
    private int o;
    private int p;
    private int q;
    private int r;
    private String s;
    private FeedBackButton t;
    private ImageView u;
    private boolean v;
    private com.mbridge.msdk.video.dynview.listener.c w;
    private com.mbridge.msdk.video.dynview.listener.b x;
    private boolean y;

    class a implements com.mbridge.msdk.video.dynview.listener.c {
        a() {
        }

        @Override // com.mbridge.msdk.video.dynview.listener.c
        public void a(CampaignEx campaignEx, int i) {
            if (campaignEx != null) {
                try {
                    MBridgeOrderCampView.this.setCampaign(campaignEx);
                    campaignEx.setClickTempSource(2);
                    campaignEx.setTriggerClickSource(2);
                    MBridgeOrderCampView.this.a(campaignEx, 0, i);
                } catch (Exception e) {
                    o0.b(MBridgeBaseView.TAG, e.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.video.dynview.listener.c
        public void close() {
            MBridgeOrderCampView.this.g();
        }
    }

    class c implements com.mbridge.msdk.foundation.feedback.a {
        c() {
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a() {
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a(String str) {
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void close() {
        }
    }

    class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5763a;

        d(String str) {
            this.f5763a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.mbridge.msdk.click.c.e(((MBridgeBaseView) MBridgeOrderCampView.this).f5779a, this.f5763a);
        }
    }

    public MBridgeOrderCampView(Context context) {
        super(context);
        this.v = false;
        this.w = new a();
        this.y = false;
    }

    private void f() {
        if (this.u == null) {
            return;
        }
        g gVarD = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
        if (gVarD == null) {
            this.u.setVisibility(8);
            return;
        }
        String strC = gVarD.c();
        if (TextUtils.isEmpty(strC)) {
            this.u.setVisibility(8);
        }
        this.u.setOnClickListener(new d(strC));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        try {
            e eVar = new e();
            eVar.a("type", 2);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000152", eVar);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000134", this.b);
        } catch (Throwable th) {
            o0.a(MBridgeBaseView.TAG, th.getMessage());
        }
        try {
            com.mbridge.msdk.video.dynview.moffer.a.a().b();
        } catch (Exception e) {
            o0.b(MBridgeBaseView.TAG, e.getMessage());
        }
        com.mbridge.msdk.video.module.listener.a aVar = this.notifyListener;
        if (aVar != null) {
            aVar.a(104, "");
        }
    }

    public void createView(ViewGroup viewGroup) {
        if (this.n == null) {
            com.mbridge.msdk.video.dynview.listener.b bVar = this.x;
            if (bVar != null) {
                bVar.b();
                return;
            }
            return;
        }
        HashMap map = new HashMap();
        map.put("order_view_callback", this.w);
        com.mbridge.msdk.video.dynview.b.a().a(new com.mbridge.msdk.video.dynview.wrapper.c().b(com.mbridge.msdk.foundation.controller.c.m().d(), this.n), new b(viewGroup), map);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.o, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void init(Context context) {
        this.m = this;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        JSONException e;
        JSONObject jSONObject;
        super.onAttachedToWindow();
        if (this.n == null) {
            return;
        }
        for (int i = 0; i < this.n.size(); i++) {
            try {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("camp_position", i);
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                }
            } catch (JSONException e3) {
                e = e3;
                jSONObject = null;
            }
            com.mbridge.msdk.video.module.listener.a aVar = this.notifyListener;
            if (aVar != null) {
                aVar.a(110, jSONObject);
            }
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView, android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public void setCampOrderViewBuildCallback(com.mbridge.msdk.video.dynview.listener.b bVar) {
        this.x = bVar;
    }

    public void setCampaignExes(List<CampaignEx> list) {
        this.n = list;
    }

    public void setNotchPadding(int i, int i2, int i3, int i4) {
        this.o = i;
        this.p = i2;
        this.q = i3;
        this.r = i4;
        setViewStatus();
    }

    public void setRewarded(boolean z) {
        this.y = z;
    }

    public void setViewStatus() {
        MBridgeOrderCampView mBridgeOrderCampView = this.m;
        if (mBridgeOrderCampView == null || !this.y) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) mBridgeOrderCampView.findViewById(filterFindViewId(this.v, "mbridge_native_order_camp_controller"));
        this.t = (FeedBackButton) this.m.findViewById(filterFindViewId(this.v, "mbridge_native_order_camp_feed_btn"));
        this.u = (ImageView) this.m.findViewById(filterFindViewId(this.v, "mbridge_iv_link"));
        if (relativeLayout != null) {
            relativeLayout.setPadding(this.o, this.q, this.p, this.r);
        }
        if (this.t != null) {
            try {
                e();
            } catch (Exception e) {
                o0.b(MBridgeBaseView.TAG, e.getMessage());
            }
        }
        if (this.u != null) {
            try {
                f();
            } catch (Exception e2) {
                o0.b(MBridgeBaseView.TAG, e2.getMessage());
            }
        }
    }

    public void startAlphaAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500L);
        this.m.startAnimation(alphaAnimation);
    }

    public void startTranslateAnimation() {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 1.0f, 2, 0.0f, 2, 0.0f, 2, 0.0f);
        translateAnimation.setDuration(500L);
        this.m.startAnimation(translateAnimation);
    }

    private void e() {
        List<CampaignEx> list = this.n;
        if (list == null || list.get(0) == null) {
            FeedBackButton feedBackButton = this.t;
            if (feedBackButton != null) {
                feedBackButton.setVisibility(8);
                return;
            }
            return;
        }
        this.s = this.n.get(0).getCampaignUnitId();
        this.b = this.n.get(0);
        com.mbridge.msdk.foundation.feedback.b.b().a(this.s + "_2", this.b);
        if (this.t == null) {
            return;
        }
        if (!com.mbridge.msdk.foundation.feedback.b.b().a()) {
            this.t.setVisibility(8);
        } else {
            com.mbridge.msdk.foundation.feedback.b.b().a(this.s + "_2", new c());
            com.mbridge.msdk.foundation.feedback.b.b().a(this.s + "_2", this.t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CampaignEx campaignEx, int i, int i2) {
        JSONException e;
        JSONObject jSONObject;
        if (campaignEx != null && campaignEx.isDynamicView()) {
            try {
                CampaignEx.c rewardTemplateMode = campaignEx.getRewardTemplateMode();
                String str = rewardTemplateMode != null ? rewardTemplateMode.f() + "" : "";
                j.a(com.mbridge.msdk.foundation.controller.c.m().d(), "order_view_click" + str, campaignEx.getCampaignUnitId(), campaignEx.isBidCampaign(), campaignEx.getRequestId(), campaignEx.getRequestIdNotice(), campaignEx.getId(), str);
            } catch (Exception e2) {
                o0.b(MBridgeBaseView.TAG, e2.getMessage());
            }
        }
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put(com.mbridge.msdk.foundation.same.a.j, a(i));
                jSONObject.put("camp_position", i2);
            } catch (JSONException e3) {
                e = e3;
                e.printStackTrace();
            }
        } catch (JSONException e4) {
            e = e4;
            jSONObject = null;
        }
        com.mbridge.msdk.video.module.listener.a aVar = this.notifyListener;
        if (aVar != null) {
            aVar.a(105, jSONObject);
        }
    }

    class b implements com.mbridge.msdk.video.dynview.listener.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f5761a;

        b(ViewGroup viewGroup) {
            this.f5761a = viewGroup;
        }

        @Override // com.mbridge.msdk.video.dynview.listener.h
        public void a(com.mbridge.msdk.video.dynview.a aVar) {
            if (aVar != null) {
                try {
                    MBridgeOrderCampView.this.m.addView(aVar.b());
                    MBridgeOrderCampView.this.v = aVar.c();
                    this.f5761a.removeAllViews();
                    this.f5761a.addView(MBridgeOrderCampView.this.m);
                    f.a(com.mbridge.msdk.foundation.controller.c.m().d(), (List<CampaignEx>) MBridgeOrderCampView.this.n, ((CampaignEx) MBridgeOrderCampView.this.n.get(0)).getCampaignUnitId());
                    MBridgeOrderCampView.this.setViewStatus();
                    if (MBridgeOrderCampView.this.x != null) {
                        MBridgeOrderCampView.this.x.a();
                    }
                } catch (Exception e) {
                    o0.b(MBridgeBaseView.TAG, e.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.video.dynview.listener.h
        public void a(com.mbridge.msdk.video.dynview.error.a aVar) {
            try {
                f.a(com.mbridge.msdk.foundation.controller.c.m().d(), (List<CampaignEx>) MBridgeOrderCampView.this.n, ((CampaignEx) MBridgeOrderCampView.this.n.get(0)).getCampaignUnitId(), aVar.b());
                if (MBridgeOrderCampView.this.x != null) {
                    MBridgeOrderCampView.this.x.b();
                }
            } catch (Exception e) {
                o0.b(MBridgeBaseView.TAG, e.getMessage());
            }
        }
    }

    public MBridgeOrderCampView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.v = false;
        this.w = new a();
        this.y = false;
    }
}
