package com.mbridge.msdk.splash.manager;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.iab.omid.library.mmadbridge.adsession.AdEvents;
import com.iab.omid.library.mmadbridge.adsession.AdSession;
import com.iab.omid.library.mmadbridge.adsession.FriendlyObstructionPurpose;
import com.mbridge.msdk.click.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.g0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.s0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.splash.view.MBSplashView;
import com.mbridge.msdk.splash.view.MBSplashWebview;
import com.mbridge.msdk.widget.FeedBackButton;
import com.pubmatic.sdk.omsdk.POBOMSDKUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: BaseSplashShowManager.java */
/* JADX INFO: loaded from: classes8.dex */
public class b {
    private CampaignEx b;
    protected MBSplashView c;
    protected com.mbridge.msdk.splash.middle.d d;
    protected com.mbridge.msdk.click.a e;
    private boolean f;
    private TextView g;
    private View h;
    protected String i;
    private String j;
    protected MBridgeIds k;
    protected boolean q;
    private boolean r;
    protected Context s;
    private ImageView u;
    private h v;
    private AdSession w;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final String f5413a = "SplashShowManager";
    protected int l = 5;
    protected String m = "点击跳过|";
    protected String n = "点击跳过|";
    protected String o = "秒";
    protected String p = "秒后自动关闭";
    protected boolean t = true;
    private View.OnClickListener x = new a();
    public Handler y = new HandlerC0490b(Looper.getMainLooper());
    protected j z = new d();

    /* JADX INFO: compiled from: BaseSplashShowManager.java */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f) {
                b.this.b(1);
                b.this.d(-1);
            }
        }
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.splash.manager.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BaseSplashShowManager.java */
    class HandlerC0490b extends Handler {
        HandlerC0490b(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Code duplicated, block: B:35:0x00d8  */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            MBSplashView mBSplashView;
            MBSplashWebview splashWebview;
            super.handleMessage(message);
            int i = message.what;
            if (i != 1) {
                if (i != 2 || b.this.b == null || !b.this.b.isActiveOm() || (mBSplashView = b.this.c) == null || (splashWebview = mBSplashView.getSplashWebview()) == null) {
                    return;
                }
                try {
                    b.this.w = splashWebview.getAdSession();
                    if (b.this.w != null) {
                        AdEvents adEventsCreateAdEvents = AdEvents.createAdEvents(b.this.w);
                        adEventsCreateAdEvents.loaded();
                        adEventsCreateAdEvents.impressionOccurred();
                    }
                    o0.a(POBOMSDKUtil.TAG, "adSession.impressionOccurred()");
                    return;
                } catch (Throwable th) {
                    o0.a(POBOMSDKUtil.TAG, th.getMessage());
                    if (b.this.b != null) {
                        new com.mbridge.msdk.foundation.same.report.h(splashWebview.getContext()).a(b.this.b.getRequestId(), b.this.b.getRequestIdNotice(), b.this.b.getId(), b.this.i, "fetch OM failed, exception" + th.getMessage());
                        return;
                    }
                    return;
                }
            }
            if (!b.this.r) {
                b.this.i();
            }
            b bVar = b.this;
            if (bVar.l <= 0) {
                bVar.b(2);
                return;
            }
            if (com.mbridge.msdk.foundation.feedback.b.f) {
                b.this.f();
            } else {
                b bVar2 = b.this;
                if (bVar2.q) {
                    b.this.f();
                } else {
                    int i2 = bVar2.l - 1;
                    bVar2.l = i2;
                    bVar2.d(i2);
                    b bVar3 = b.this;
                    if (!bVar3.t) {
                        bVar3.g();
                    }
                }
            }
            b.this.y.removeMessages(1);
            sendEmptyMessageDelayed(1, 1000L);
        }
    }

    /* JADX INFO: compiled from: BaseSplashShowManager.java */
    class d implements j {
        d() {
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onFinishRedirection(Campaign campaign, String str) {
            if (campaign == null) {
                return;
            }
            s0.a(campaign, b.this.c);
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onRedirectionFailed(Campaign campaign, String str) {
            if (campaign == null) {
                return;
            }
            s0.a(campaign, b.this.c);
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onStartRedirection(Campaign campaign, String str) {
            s0.b(campaign, b.this.c);
        }
    }

    /* JADX INFO: compiled from: BaseSplashShowManager.java */
    class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5418a;

        e(int i) {
            this.f5418a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.f5418a);
        }
    }

    /* JADX INFO: compiled from: BaseSplashShowManager.java */
    class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f5419a;
        final /* synthetic */ CampaignEx b;

        f(Context context, CampaignEx campaignEx) {
            this.f5419a = context;
            this.b = campaignEx;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.mbridge.msdk.foundation.db.j.a(com.mbridge.msdk.foundation.db.g.a(this.f5419a)).b(this.b.getId());
            } catch (Exception unused) {
                o0.b("SplashShowManager", "campain can't insert db");
            }
        }
    }

    /* JADX INFO: compiled from: BaseSplashShowManager.java */
    class g implements com.mbridge.msdk.foundation.feedback.a {
        g() {
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a() {
            b.this.f();
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void close() {
            b.this.g();
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a(String str) {
            b.this.g();
        }
    }

    /* JADX INFO: compiled from: BaseSplashShowManager.java */
    private class h implements com.mbridge.msdk.splash.middle.a {
        private h() {
        }

        @Override // com.mbridge.msdk.splash.middle.a
        public void a(CampaignEx campaignEx) {
            b.this.b(campaignEx, false, "");
        }

        @Override // com.mbridge.msdk.splash.middle.a
        public void close() {
            b.this.b(1);
        }

        @Override // com.mbridge.msdk.splash.middle.a
        public void toggleCloseBtn(int i) {
            MBSplashView mBSplashView = b.this.c;
            if (mBSplashView != null) {
                mBSplashView.changeCloseBtnState(i);
            }
        }

        @Override // com.mbridge.msdk.splash.middle.a
        public void triggerCloseBtn(Object obj, String str) {
            b.this.b(1);
        }

        /* synthetic */ h(b bVar, a aVar) {
            this();
        }

        @Override // com.mbridge.msdk.splash.middle.a
        public void a(int i) {
            o0.b("SplashShowManager", "resetCountdown" + i);
            b bVar = b.this;
            bVar.l = i;
            bVar.y.removeMessages(1);
            b.this.y.sendEmptyMessageDelayed(1, 1000L);
        }

        @Override // com.mbridge.msdk.splash.middle.a
        public void a(boolean z) {
            if (z) {
                b.this.y.removeMessages(1);
            }
        }

        @Override // com.mbridge.msdk.splash.middle.a
        public void a(boolean z, String str) {
            try {
                if (b.this.d != null) {
                    if (TextUtils.isEmpty(str)) {
                        b bVar = b.this;
                        bVar.d.a(bVar.k);
                    } else {
                        CampaignEx campaignWithBackData = CampaignEx.parseCampaignWithBackData(CampaignEx.campaignToJsonObject(b.this.b));
                        campaignWithBackData.setClickTempSource(2);
                        campaignWithBackData.setClickType(2);
                        campaignWithBackData.setTriggerClickSource(2);
                        campaignWithBackData.setClickURL(str);
                        b.this.b(campaignWithBackData, true, str);
                    }
                }
            } catch (Exception e) {
                o0.b("SplashShowManager", e.getMessage());
            }
        }

        @Override // com.mbridge.msdk.splash.middle.a
        public void a(int i, int i2) {
            if (i == 1) {
                b.this.y.removeMessages(1);
            }
            if (i == 2) {
                b bVar = b.this;
                bVar.l = i2;
                bVar.y.removeMessages(1);
                b.this.y.sendEmptyMessageDelayed(1, 1000L);
            }
        }
    }

    public b(Context context, String str, String str2) {
        this.i = str2;
        this.j = str;
        this.k = new MBridgeIds(str, str2);
        this.s = context;
        if (this.g == null) {
            TextView textView = new TextView(context);
            this.g = textView;
            textView.setGravity(1);
            this.g.setTextIsSelectable(false);
            this.g.setPadding(t0.a(context, 5.0f), t0.a(context, 5.0f), t0.a(context, 5.0f), t0.a(context, 5.0f));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.g.getLayoutParams();
            this.g.setLayoutParams(layoutParams == null ? new RelativeLayout.LayoutParams(t0.a(context, 100.0f), t0.a(context, 50.0f)) : layoutParams);
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void i() {
        MBSplashView mBSplashView;
        if (this.b == null) {
            return;
        }
        this.r = true;
        if (this.d != null && (mBSplashView = this.c) != null) {
            if (mBSplashView.getContext() != null && (this.c.getContext() instanceof Activity) && ((Activity) this.c.getContext()).isFinishing()) {
                o0.a("SplashShowManager", "Activity is finishing");
            }
            if (this.c.isShown()) {
                this.d.b(this.k);
            } else {
                this.d.a(this.k, "SplashView or container is not visibility");
            }
        }
        if (!this.b.isReport()) {
            MBSplashView mBSplashView2 = this.c;
            if (mBSplashView2 == null || mBSplashView2.isDynamicView()) {
                a(this.b);
            } else {
                b(this.b);
            }
            com.mbridge.msdk.splash.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.b, this.i);
        }
    }

    private void j() {
        this.g.setText(this.f ? this.n + this.l + this.o : this.l + this.p);
    }

    public void b(CampaignEx campaignEx, boolean z, String str) {
        throw null;
    }

    public void f() {
        Handler handler;
        this.t = false;
        if (this.c != null && this.l > 0 && (handler = this.y) != null) {
            handler.removeMessages(1);
        }
        MBSplashView mBSplashView = this.c;
        if (mBSplashView != null) {
            mBSplashView.onPause();
            MBSplashWebview splashWebview = this.c.getSplashWebview();
            if (splashWebview == null || splashWebview.isDestoryed()) {
                return;
            }
            com.mbridge.msdk.splash.signal.c.a(splashWebview, "onSystemPause", "");
        }
    }

    public void g() {
        MBSplashView mBSplashView;
        Handler handler;
        this.t = true;
        if (this.c != null && this.l > 0 && (handler = this.y) != null) {
            handler.removeMessages(1);
            this.y.sendEmptyMessageDelayed(1, 1000L);
        }
        if (com.mbridge.msdk.foundation.feedback.b.f || (mBSplashView = this.c) == null) {
            return;
        }
        mBSplashView.onResume();
        MBSplashWebview splashWebview = this.c.getSplashWebview();
        if (splashWebview == null || splashWebview.isDestoryed()) {
            return;
        }
        com.mbridge.msdk.splash.signal.c.a(splashWebview, "onSystemPause", "");
    }

    public void h() {
        if (this.d != null) {
            this.d = null;
        }
        if (this.v != null) {
            this.v = null;
        }
        if (this.x != null) {
            this.x = null;
        }
        MBSplashView mBSplashView = this.c;
        if (mBSplashView != null) {
            mBSplashView.destroy();
        }
        com.mbridge.msdk.foundation.feedback.b.b().d(this.i);
    }

    private void e() {
        Context contextD = com.mbridge.msdk.foundation.controller.c.m().d();
        if (contextD != null) {
            String strH = com.mbridge.msdk.foundation.controller.c.m().h();
            int identifier = contextD.getResources().getIdentifier("mbridge_splash_count_time_can_skip", "string", strH);
            int identifier2 = contextD.getResources().getIdentifier("mbridge_splash_count_time_can_skip_not", "string", strH);
            int identifier3 = contextD.getResources().getIdentifier("mbridge_splash_count_time_can_skip_s", "string", strH);
            this.n = contextD.getResources().getString(identifier);
            String string = contextD.getResources().getString(identifier2);
            this.p = string;
            this.m = string;
            this.o = contextD.getResources().getString(identifier3);
            this.g.setBackgroundResource(contextD.getResources().getIdentifier("mbridge_splash_close_bg", "drawable", com.mbridge.msdk.foundation.controller.c.m().h()));
            this.g.setTextColor(contextD.getResources().getColor(contextD.getResources().getIdentifier("mbridge_splash_count_time_skip_text_color", "color", strH)));
        }
    }

    public void c(int i) {
        this.l = i;
    }

    public String d() {
        CampaignEx campaignEx = this.b;
        return (campaignEx == null || campaignEx.getRequestId() == null) ? "" : this.b.getRequestId();
    }

    private void b(CampaignEx campaignEx) {
        if (campaignEx.isHasMBTplMark()) {
            return;
        }
        a(campaignEx, com.mbridge.msdk.foundation.controller.c.m().d(), this.i);
        campaignEx.setReport(true);
        com.mbridge.msdk.foundation.same.buffer.b.a(this.i, campaignEx, "splash");
        b(campaignEx, com.mbridge.msdk.foundation.controller.c.m().d(), this.i);
        c(campaignEx, com.mbridge.msdk.foundation.controller.c.m().d(), this.i);
    }

    public String c() {
        ArrayList arrayList = new ArrayList();
        CampaignEx campaignEx = this.b;
        if (campaignEx != null) {
            arrayList.add(campaignEx);
        }
        return com.mbridge.msdk.foundation.same.c.b(arrayList);
    }

    public void a(com.mbridge.msdk.splash.middle.d dVar) {
        this.d = dVar;
    }

    public void a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.setOnClickListener(this.x);
        }
        this.h = viewGroup;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        MBSplashView mBSplashView = this.c;
        if (mBSplashView != null) {
            mBSplashView.updateCountdown(i);
            if (this.c.getSplashSignalCommunicationImpl() != null) {
                this.c.getSplashSignalCommunicationImpl().c(i);
            }
        }
        if (i < 0) {
            this.l = i;
            return;
        }
        com.mbridge.msdk.splash.middle.d dVar = this.d;
        if (dVar != null) {
            dVar.a(this.k, i * 1000);
        }
        if (this.h == null) {
            j();
        }
    }

    public void a(CampaignEx campaignEx, MBSplashView mBSplashView) {
        MBSplashWebview splashWebview;
        a(this.f);
        this.b = campaignEx;
        this.c = mBSplashView;
        com.mbridge.msdk.splash.signal.b splashSignalCommunicationImpl = mBSplashView.getSplashSignalCommunicationImpl();
        if (splashSignalCommunicationImpl == null) {
            splashSignalCommunicationImpl = new com.mbridge.msdk.splash.signal.b(mBSplashView.getContext(), this.j, this.i);
            ArrayList arrayList = new ArrayList();
            arrayList.add(campaignEx);
            splashSignalCommunicationImpl.a(arrayList);
        }
        splashSignalCommunicationImpl.b(this.l);
        splashSignalCommunicationImpl.a(this.f ? 1 : 0);
        a aVar = null;
        if (this.v == null) {
            this.v = new h(this, aVar);
        }
        splashSignalCommunicationImpl.a(this.v);
        mBSplashView.setSplashSignalCommunicationImpl(splashSignalCommunicationImpl);
        boolean zIsHasMBTplMark = campaignEx.isHasMBTplMark();
        View view = this.h;
        if (view == null) {
            if (zIsHasMBTplMark) {
                this.g.setVisibility(8);
            }
            j();
            a(this.g);
            mBSplashView.setCloseView(this.g);
        } else {
            if (zIsHasMBTplMark) {
                view.setVisibility(8);
            }
            a(this.h);
            mBSplashView.setCloseView(this.h);
        }
        mBSplashView.show();
        CampaignEx campaignEx2 = this.b;
        if (campaignEx2 != null && campaignEx2.isActiveOm() && (splashWebview = mBSplashView.getSplashWebview()) != null) {
            try {
                AdSession adSessionA = com.mbridge.msdk.omsdk.b.a(com.mbridge.msdk.foundation.controller.c.m().d(), splashWebview, splashWebview.getUrl(), this.b);
                this.w = adSessionA;
                if (adSessionA != null) {
                    splashWebview.setAdSession(adSessionA);
                    this.w.registerAdView(splashWebview);
                    this.w.start();
                }
                o0.a(POBOMSDKUtil.TAG, "adSession.start()");
            } catch (Throwable th) {
                o0.a(POBOMSDKUtil.TAG, th.getMessage());
                CampaignEx campaignEx3 = this.b;
                if (campaignEx3 != null) {
                    new com.mbridge.msdk.foundation.same.report.h(splashWebview.getContext()).a(campaignEx3.getRequestId(), this.b.getRequestIdNotice(), this.b.getId(), this.i, "fetch OM failed, exception" + th.getMessage());
                }
            }
        }
        com.mbridge.msdk.splash.manager.d.b(this.i);
        this.y.removeMessages(1);
        this.y.sendEmptyMessageDelayed(1, 1000L);
        this.y.sendEmptyMessageDelayed(2, 1000L);
        b();
        if (!this.b.isMraid()) {
            a();
        }
        com.mbridge.msdk.click.c.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.b.getMaitve(), this.b.getMaitve_src());
        try {
            BitmapDrawable bitmapDrawableA = com.mbridge.msdk.foundation.controller.c.m().a(this.i, this.b.getAdType());
            if (bitmapDrawableA != null) {
                if (this.u == null) {
                    this.u = new ImageView(com.mbridge.msdk.foundation.controller.c.m().d());
                }
                if (this.u.getVisibility() != 0) {
                    this.u.setVisibility(0);
                }
                t0.a(this.u, bitmapDrawableA, mBSplashView.getResources().getDisplayMetrics());
                if (this.u.getParent() == null) {
                    mBSplashView.addView(this.u, new ViewGroup.LayoutParams(-1, -1));
                }
                AdSession adSession = this.w;
                if (adSession != null) {
                    adSession.addFriendlyObstruction(this.u, FriendlyObstructionPurpose.OTHER, null);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void c(CampaignEx campaignEx, Context context, String str) {
        if (campaignEx != null) {
            try {
                List<String> pv_urls = campaignEx.getPv_urls();
                if (pv_urls == null || pv_urls.size() <= 0) {
                    return;
                }
                Iterator<String> it = pv_urls.iterator();
                while (it.hasNext()) {
                    com.mbridge.msdk.click.a.a(context, campaignEx, str, it.next(), false, true);
                }
            } catch (Throwable th) {
                o0.b("SplashShowManager", th.getMessage());
            }
        }
    }

    /* JADX INFO: compiled from: BaseSplashShowManager.java */
    class c implements com.mbridge.msdk.foundation.feedback.a {
        c() {
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a() {
            String string;
            b.this.f();
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put("status", 1);
                }
                string = jSONObject.toString();
            } catch (Throwable th) {
                o0.b("SplashShowManager", th.getMessage(), th);
                string = "";
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) b.this.c.getSplashWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void close() {
            String string;
            b.this.g();
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put("status", 2);
                }
                string = jSONObject.toString();
            } catch (Throwable th) {
                o0.b("SplashShowManager", th.getMessage(), th);
                string = "";
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) b.this.c.getSplashWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a(String str) {
            String string;
            b.this.g();
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put("status", 2);
                }
                string = jSONObject.toString();
            } catch (Throwable th) {
                o0.b("SplashShowManager", th.getMessage(), th);
                string = "";
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) b.this.c.getSplashWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
        }
    }

    protected void b(int i) {
        CampaignEx campaignEx;
        MBSplashWebview splashWebview;
        MBSplashView mBSplashView = this.c;
        if (mBSplashView != null && (splashWebview = mBSplashView.getSplashWebview()) != null) {
            splashWebview.finishAdSession();
        }
        if (this.y != null && (campaignEx = this.b) != null && campaignEx.isActiveOm()) {
            this.y.postDelayed(new e(i), 1500L);
        } else {
            a(i);
        }
    }

    private void b(CampaignEx campaignEx, Context context, String str) {
        if (campaignEx != null) {
            try {
                if (TextUtils.isEmpty(campaignEx.getOnlyImpressionURL())) {
                    return;
                }
                com.mbridge.msdk.click.a.a(context, campaignEx, str, campaignEx.getOnlyImpressionURL(), false, true, com.mbridge.msdk.click.retry.a.n);
            } catch (Throwable th) {
                o0.b("SplashShowManager", th.getMessage());
            }
        }
    }

    public void b() {
        MBSplashView mBSplashView;
        Context context;
        CampaignEx campaignEx = this.b;
        if (campaignEx == null || campaignEx.getPrivacyButtonTemplateVisibility() != 1 || (mBSplashView = this.c) == null || mBSplashView.getSplashWebview() == null || this.c.isDynamicView() || !this.b.isMraid() || (context = this.c.getContext()) == null) {
            return;
        }
        try {
            int iA = g0.a(context, "mbridge_splash_notice", "drawable");
            int iA2 = t0.a(context, 35.0f);
            int iA3 = t0.a(context, 9.0f);
            ImageView imageView = new ImageView(context);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA2, iA2);
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.setMargins(iA3, iA3, iA3, iA3);
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setBackgroundResource(iA);
            t0.a(3, imageView, this.b, context, true, new g());
            this.c.addView(imageView);
        } catch (Throwable th) {
            o0.b("SplashShowManager", th.getMessage());
        }
    }

    private void a() {
        RelativeLayout.LayoutParams layoutParams;
        CampaignEx campaignEx = this.b;
        if (campaignEx != null) {
            campaignEx.setCampaignUnitId(this.i);
            com.mbridge.msdk.foundation.feedback.b.b().a(this.i, 3);
            com.mbridge.msdk.foundation.feedback.b.b().a(this.i, this.b);
        }
        if (com.mbridge.msdk.foundation.feedback.b.b().a()) {
            MBSplashView mBSplashView = this.c;
            if (mBSplashView == null || !mBSplashView.isDynamicView()) {
                com.mbridge.msdk.foundation.feedback.b.b().a(this.i, new c());
                FeedBackButton feedBackButtonA = com.mbridge.msdk.foundation.feedback.b.b().a(this.i);
                if (feedBackButtonA != null) {
                    try {
                        layoutParams = (RelativeLayout.LayoutParams) feedBackButtonA.getLayoutParams();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        layoutParams = null;
                    }
                    if (layoutParams == null) {
                        layoutParams = new RelativeLayout.LayoutParams(com.mbridge.msdk.foundation.feedback.b.e, com.mbridge.msdk.foundation.feedback.b.d);
                    }
                    layoutParams.topMargin = t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 10.0f);
                    layoutParams.leftMargin = t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 10.0f);
                    ViewGroup viewGroup = (ViewGroup) feedBackButtonA.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(feedBackButtonA);
                    }
                    MBSplashView mBSplashView2 = this.c;
                    if (mBSplashView2 != null) {
                        mBSplashView2.addView(feedBackButtonA, layoutParams);
                    }
                }
            }
        }
    }

    private void a(CampaignEx campaignEx) {
        b(campaignEx, com.mbridge.msdk.foundation.controller.c.m().d(), this.i);
        a(campaignEx, com.mbridge.msdk.foundation.controller.c.m().d(), this.i);
        c(campaignEx, com.mbridge.msdk.foundation.controller.c.m().d(), this.i);
        campaignEx.setReport(true);
        com.mbridge.msdk.foundation.same.buffer.b.a(this.i, campaignEx, "splash");
    }

    public void a(boolean z) {
        this.f = z;
        if (z) {
            this.m = this.n;
        } else {
            this.m = this.p;
        }
    }

    protected void a(CampaignEx campaignEx, boolean z, String str) {
        if (this.e == null) {
            com.mbridge.msdk.click.a aVar = new com.mbridge.msdk.click.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.i);
            this.e = aVar;
            aVar.a(this.z);
        }
        campaignEx.setCampaignUnitId(this.i);
        this.e.a(campaignEx);
        if (!this.b.isReportClick()) {
            this.b.setReportClick(true);
            com.mbridge.msdk.splash.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), campaignEx);
        }
        com.mbridge.msdk.splash.middle.d dVar = this.d;
        if (dVar != null) {
            dVar.a(this.k);
            b(3);
        }
        if (!z || TextUtils.isEmpty(str)) {
            return;
        }
        com.mbridge.msdk.splash.report.a.a(campaignEx, this.i, str);
    }

    private void a(View view) {
        if (view != null) {
            view.setOnClickListener(this.x);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        MBSplashView mBSplashView;
        try {
            com.mbridge.msdk.splash.middle.d dVar = this.d;
            if (dVar != null) {
                dVar.a(this.k, i);
                this.d = null;
                com.mbridge.msdk.splash.report.a.a(this.i, this.b);
            }
            ImageView imageView = this.u;
            if (imageView != null && imageView.getParent() != null && (mBSplashView = this.c) != null) {
                mBSplashView.removeView(this.u);
                this.u.setVisibility(8);
            }
            this.r = false;
            com.mbridge.msdk.splash.report.a.a(this.i, i, this.b);
            Handler handler = this.y;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Exception e2) {
            o0.b("SplashShowManager", e2.getMessage());
        }
    }

    private void a(CampaignEx campaignEx, Context context, String str) {
        com.mbridge.msdk.foundation.controller.c.m().a(context);
        if (!TextUtils.isEmpty(campaignEx.getImpressionURL())) {
            new Thread(new f(context, campaignEx)).start();
            com.mbridge.msdk.click.a.a(context, campaignEx, str, campaignEx.getImpressionURL(), false, true, com.mbridge.msdk.click.retry.a.m);
        }
        if (TextUtils.isEmpty(str) || campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().k() == null) {
            return;
        }
        com.mbridge.msdk.click.a.a(context, campaignEx, str, campaignEx.getNativeVideoTracking().k(), false, false);
    }
}
