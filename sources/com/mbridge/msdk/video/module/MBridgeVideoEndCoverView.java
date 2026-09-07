package com.mbridge.msdk.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.g0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.video.module.listener.impl.j;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class MBridgeVideoEndCoverView extends MBridgeBaseView {
    private final String m;
    private View n;
    private ImageView o;
    private ImageView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private com.mbridge.msdk.video.signal.factory.b t;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MBridgeVideoEndCoverView.this.notifyListener.a(104, "");
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MBridgeVideoEndCoverView.this.g();
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MBridgeVideoEndCoverView.this.g();
        }
    }

    public MBridgeVideoEndCoverView(Context context) {
        super(context);
        this.m = "MBridgeVideoEndCoverView";
    }

    private boolean a(View view) {
        if (view == null) {
            return true;
        }
        try {
            this.o = (ImageView) view.findViewById(findID("mbridge_vec_iv_icon"));
            this.p = (ImageView) view.findViewById(findID("mbridge_vec_iv_close"));
            this.q = (TextView) view.findViewById(findID("mbridge_vec_tv_title"));
            this.r = (TextView) view.findViewById(findID("mbridge_vec_tv_desc"));
            this.s = (TextView) view.findViewById(findID("mbridge_vec_btn"));
            return true;
        } catch (Throwable th) {
            o0.b("MBridgeVideoEndCoverView", th.getMessage());
            return false;
        }
    }

    private void e() {
        ImageView imageView;
        CampaignEx campaignEx = this.b;
        if (campaignEx != null) {
            if (!TextUtils.isEmpty(campaignEx.getIconUrl()) && (imageView = this.o) != null) {
                com.mbridge.msdk.foundation.same.image.b.a(this.f5779a.getApplicationContext()).a(this.b.getIconUrl(), new j(imageView, t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 8.0f)));
            }
            TextView textView = this.q;
            if (textView != null) {
                textView.setText(this.b.getAppName());
            }
            TextView textView2 = this.s;
            if (textView2 != null) {
                textView2.setText(this.b.getAdCall());
            }
            TextView textView3 = this.r;
            if (textView3 != null) {
                textView3.setText(this.b.getAppDesc());
            }
        }
    }

    private void f() {
        View view = this.n;
        if (view == null) {
            init(this.f5779a);
            preLoadData(this.t);
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) this.n.getParent()).removeView(this.n);
        }
        addView(this.n);
        a(this.n);
        d();
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    protected void d() {
        super.d();
        this.p.setOnClickListener(new a());
        this.o.setOnClickListener(new b());
        this.s.setOnClickListener(new c());
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.o, this, me);
        return super.dispatchTouchEvent(me);
    }

    protected void g() {
        JSONException e;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONException e2;
        try {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(com.mbridge.msdk.foundation.same.a.h, t0.b(com.mbridge.msdk.foundation.controller.c.m().d(), this.f));
                    jSONObject2.put(com.mbridge.msdk.foundation.same.a.i, t0.b(com.mbridge.msdk.foundation.controller.c.m().d(), this.g));
                    jSONObject2.put(com.mbridge.msdk.foundation.same.a.m, 0);
                    try {
                        this.d = getContext().getResources().getConfiguration().orientation;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    jSONObject2.put(com.mbridge.msdk.foundation.same.a.k, this.d);
                    jSONObject2.put(com.mbridge.msdk.foundation.same.a.l, t0.d(getContext()));
                } catch (JSONException e4) {
                    e2 = e4;
                    o0.b("MBridgeVideoEndCoverView", e2.getMessage());
                }
            } catch (JSONException e5) {
                jSONObject2 = jSONObject3;
                e2 = e5;
            }
            jSONObject = new JSONObject();
            try {
                jSONObject.put(com.mbridge.msdk.foundation.same.a.j, jSONObject2);
            } catch (JSONException e6) {
                e = e6;
                e.printStackTrace();
            }
        } catch (JSONException e7) {
            e = e7;
            jSONObject = null;
        }
        this.notifyListener.a(105, jSONObject);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void init(Context context) {
        int iFindLayout = findLayout("mbridge_reward_videoend_cover");
        if (g0.a(iFindLayout)) {
            View viewInflate = this.c.inflate(iFindLayout, (ViewGroup) null);
            this.n = viewInflate;
            if (viewInflate != null) {
                this.e = a(viewInflate);
                addView(this.n, -1, -1);
                d();
            }
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f = motionEvent.getRawX();
        this.g = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView, android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        this.d = configuration.orientation;
        removeView(this.n);
        f();
    }

    public void preLoadData(com.mbridge.msdk.video.signal.factory.b bVar) {
        this.t = bVar;
        try {
            if (this.b == null || !this.e) {
                return;
            }
            e();
        } catch (Throwable th) {
            o0.a("MBridgeVideoEndCoverView", th.getMessage());
        }
    }

    public MBridgeVideoEndCoverView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m = "MBridgeVideoEndCoverView";
    }
}
