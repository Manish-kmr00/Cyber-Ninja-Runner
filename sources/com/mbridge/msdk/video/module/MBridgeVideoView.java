package com.mbridge.msdk.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.iab.omid.library.mmadbridge.adsession.AdSession;
import com.iab.omid.library.mmadbridge.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.mmadbridge.adsession.media.InteractionType;
import com.iab.omid.library.mmadbridge.adsession.media.MediaEvents;
import com.json.b9;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeSegmentsProgressBar;
import com.mbridge.msdk.dycreator.baseview.cusview.SoundImageView;
import com.mbridge.msdk.dycreator.baseview.rewardpopview.AcquireRewardPopViewBehaviourListener;
import com.mbridge.msdk.dycreator.baseview.rewardpopview.AcquireRewardPopViewParameters;
import com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.g0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.q0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.tools.y;
import com.mbridge.msdk.foundation.tools.y0;
import com.mbridge.msdk.foundation.tools.z0;
import com.mbridge.msdk.mbsignalcommon.commonwebview.CollapsibleWebView;
import com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener;
import com.mbridge.msdk.playercommon.PlayerView;
import com.mbridge.msdk.widget.FeedBackButton;
import com.mbridge.msdk.widget.dialog.MBAlertDialog;
import com.pubmatic.sdk.omsdk.POBOMSDKUtil;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.internal.special.SpecialsBridge;
import com.safedk.android.utils.Logger;
import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class MBridgeVideoView extends MBridgeBaseView implements com.mbridge.msdk.video.signal.j {
    private static int R0;
    private static int S0;
    private static int T0;
    private static int U0;
    private static int V0;
    private static boolean W0;
    private static long X0;
    private boolean A;
    private int A0;
    private FrameLayout B;
    private int B0;
    private MBridgeClickCTAView C;
    private int C0;
    private com.mbridge.msdk.video.signal.factory.b D;
    private AcquireRewardPopViewParameters D0;
    private int E;
    private MBAcquireRewardPopView E0;
    private int F;
    private boolean F0;
    private RelativeLayout G;
    private RelativeLayout G0;
    private boolean H;
    private CollapsibleWebView H0;
    private boolean I;
    private RelativeLayout I0;
    private boolean J;
    private boolean J0;
    private String K;
    private int K0;
    private int L;
    private boolean L0;
    private int M;
    private boolean M0;
    private int N;
    private w N0;
    private MBAlertDialog O;
    private boolean O0;
    private com.mbridge.msdk.widget.dialog.b P;
    private Runnable P0;
    private String Q;
    private final Runnable Q0;
    private double R;
    private double S;
    private boolean T;
    private boolean U;
    private boolean V;
    private boolean W;
    private boolean a0;
    private boolean b0;
    private boolean c0;
    private boolean d0;
    private boolean e0;
    private int f0;
    private boolean g0;
    private int h0;
    private AdSession i0;
    private MediaEvents j0;
    private String k0;
    private int l0;
    private TextView m;
    private int m0;
    public List<CampaignEx> mCampOrderViewData;
    public int mCampaignSize;
    public int mCurrPlayNum;
    public int mCurrentPlayProgressTime;
    public int mMuteSwitch;
    public PlayerView mPlayerView;
    public SoundImageView mSoundImageView;
    private View n;
    private int n0;
    private RelativeLayout o;
    private boolean o0;
    private ImageView p;
    private boolean p0;
    private ProgressBar q;
    private boolean q0;
    private FeedBackButton r;
    private boolean r0;
    private ImageView s;
    private boolean s0;
    private MBridgeSegmentsProgressBar t;
    private boolean t0;
    public TextView tvFlag;
    private com.mbridge.msdk.video.module.listener.a u;
    private boolean u0;
    private u v;
    private boolean v0;
    private boolean w;
    private boolean w0;
    private com.mbridge.msdk.video.dynview.listener.a x;
    private AlphaAnimation x0;
    private com.mbridge.msdk.video.dynview.listener.f y;
    private MBridgeBaitClickView y0;
    private int z;
    private int z0;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MBridgeVideoView.this.d0 = true;
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5816a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ int d;

        b(int i, int i2, int i3, int i4) {
            this.f5816a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MBridgeVideoView.this.o == null) {
                return;
            }
            MBridgeVideoView.this.o.setVisibility(0);
            CampaignEx campaignEx = MBridgeVideoView.this.b;
            if (campaignEx == null || campaignEx.getAdSpaceT() == 2) {
                return;
            }
            MBridgeVideoView.this.o.setPadding(this.f5816a, this.b, this.c, this.d);
            MBridgeVideoView.this.o.startAnimation(MBridgeVideoView.this.x0);
        }
    }

    class c implements com.mbridge.msdk.foundation.same.image.c {

        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Bitmap f5818a;

            /* JADX INFO: renamed from: com.mbridge.msdk.video.module.MBridgeVideoView$c$a$a, reason: collision with other inner class name */
            class RunnableC0517a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ Bitmap f5819a;

                RunnableC0517a(Bitmap bitmap) {
                    this.f5819a = bitmap;
                }

                @Override // java.lang.Runnable
                public void run() {
                    MBridgeVideoView.this.p.setVisibility(0);
                    MBridgeVideoView.this.p.setImageBitmap(this.f5819a);
                }
            }

            a(Bitmap bitmap) {
                this.f5818a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    MBridgeVideoView.this.p.post(new RunnableC0517a(y.a(this.f5818a, 10)));
                } catch (Exception e) {
                    o0.b(MBridgeBaseView.TAG, e.getMessage());
                }
            }
        }

        c() {
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
            o0.b(MBridgeBaseView.TAG, str);
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            if (bitmap != null) {
                try {
                    if (bitmap.isRecycled() || MBridgeVideoView.this.p == null) {
                        return;
                    }
                    com.mbridge.msdk.foundation.same.threadpool.a.a().execute(new a(bitmap));
                } catch (Throwable th) {
                    o0.b(MBridgeBaseView.TAG, th.getMessage());
                }
            }
        }
    }

    class d implements CollapsibleWebView.e {
        d() {
        }

        @Override // com.mbridge.msdk.mbsignalcommon.commonwebview.CollapsibleWebView.e
        public void a(View view, String str) {
            JSONObject jSONObject;
            if (MBridgeVideoView.this.J0) {
                return;
            }
            MBridgeVideoView.this.J0 = true;
            if (MBridgeVideoView.this.G0 != null && MBridgeVideoView.this.G0.getVisibility() != 0) {
                MBridgeVideoView.this.G0.setVisibility(0);
            }
            Context context = MBridgeVideoView.this.getContext();
            MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
            com.mbridge.msdk.click.a.a(context, mBridgeVideoView.b, mBridgeVideoView.getUnitId(), MBridgeVideoView.this.b.getNoticeUrl(), true, false, com.mbridge.msdk.click.retry.a.o);
            com.mbridge.msdk.video.module.report.b.a(com.mbridge.msdk.foundation.controller.c.m().d().getApplicationContext(), MBridgeVideoView.this.b);
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            eVar.a("result", 1);
            if (MBridgeVideoView.this.u != null) {
                try {
                    jSONObject = new JSONObject();
                    try {
                        jSONObject.put(com.mbridge.msdk.foundation.same.a.j, MBridgeVideoView.this.a(0));
                    } catch (JSONException e) {
                        e = e;
                        e.printStackTrace();
                    }
                } catch (JSONException e2) {
                    e = e2;
                    jSONObject = null;
                }
                MBridgeVideoView.this.u.a(Sdk.SDKError.Reason.MRAID_JS_WRITE_FAILED_VALUE, jSONObject);
                MBridgeVideoView.this.b.setClickType(1);
                MBridgeVideoView.this.b.setClickTempSource(1);
                MBridgeVideoView.this.b.setTriggerClickSource(2);
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000149", MBridgeVideoView.this.b);
                eVar.a("type", 9);
                ArrayList arrayList = new ArrayList();
                arrayList.add("web_view");
                eVar.a("click_path", arrayList.toString());
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000150", MBridgeVideoView.this.b, eVar);
            }
            eVar.a("url", str);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_webview_render", MBridgeVideoView.this.b, eVar);
        }

        @Override // com.mbridge.msdk.mbsignalcommon.commonwebview.CollapsibleWebView.e
        public void a(View view, Map<String, String> map) {
        }

        @Override // com.mbridge.msdk.mbsignalcommon.commonwebview.CollapsibleWebView.e
        public void b(View view, Map<String, String> map) {
            String str;
            String str2 = "";
            if (map != null) {
                String str3 = map.get("url");
                str2 = str3 != null ? str3 : "";
                str = map.get("description");
            } else {
                str = "";
            }
            a(str2, str);
        }

        @Override // com.mbridge.msdk.mbsignalcommon.commonwebview.CollapsibleWebView.e
        public void b(View view, String str) {
            a(str, "timeout");
        }

        private void a(String str, String str2) {
            if (MBridgeVideoView.this.J0) {
                return;
            }
            MBridgeVideoView.this.J0 = true;
            if (str == null) {
                str = "";
            }
            if (MBridgeVideoView.this.G0 != null && MBridgeVideoView.this.G0.getVisibility() == 0) {
                MBridgeVideoView.this.G0.setVisibility(8);
            }
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            eVar.a("result", 2);
            eVar.a("url", str);
            eVar.a("reason", str2);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_webview_render", MBridgeVideoView.this.b, eVar);
        }
    }

    class e extends WebViewClient {
        e() {
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
            CreativeInfoManager.onResourceLoaded(com.safedk.android.utils.h.o, view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Logger.d("Mintegral|SafeDK: Execution> Lcom/mbridge/msdk/video/module/MBridgeVideoView$e;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
            BrandSafetyUtils.onWebViewPageFinished(com.safedk.android.utils.h.o, webView, str);
            safedk_MBridgeVideoView$e_onPageFinished_19d5df63618c79b0a6cffa7cb499639a(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            BrandSafetyUtils.onWebViewPageStarted(com.safedk.android.utils.h.o, view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            Logger.d("Mintegral|SafeDK: Execution> Lcom/mbridge/msdk/video/module/MBridgeVideoView$e;->onReceivedError(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceError;)V");
            BrandSafetyUtils.onWebViewReceivedError(com.safedk.android.utils.h.o, webView, webResourceRequest, webResourceError);
            safedk_MBridgeVideoView$e_onReceivedError_5caba785ec9cb3cc2968be802d77a559(webView, webResourceRequest, webResourceError);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            o0.b(MBridgeBaseView.TAG, "WebView called onRenderProcessGone");
            if (webView != null) {
                try {
                    ViewGroup viewGroup = (ViewGroup) webView.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(webView);
                    }
                    if (webView instanceof WindVaneWebView) {
                        ((WindVaneWebView) webView).release();
                    } else {
                        webView.destroy();
                    }
                } catch (Throwable th) {
                    o0.b(MBridgeBaseView.TAG, th.getMessage());
                }
            }
            return true;
        }

        public void safedk_MBridgeVideoView$e_onPageFinished_19d5df63618c79b0a6cffa7cb499639a(WebView p0, String p1) {
        }

        public void safedk_MBridgeVideoView$e_onReceivedError_5caba785ec9cb3cc2968be802d77a559(WebView p0, WebResourceRequest p1, WebResourceError p2) {
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
            return CreativeInfoManager.onWebViewResponseWithHeaders(com.safedk.android.utils.h.o, view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            boolean zShouldOverrideUrlLoading = super.shouldOverrideUrlLoading(view, url);
            BrandSafetyUtils.onShouldOverrideUrlLoading(com.safedk.android.utils.h.o, view, url, zShouldOverrideUrlLoading);
            return zShouldOverrideUrlLoading;
        }
    }

    class f implements CommonWebView.h {
        f() {
        }

        @Override // com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView.h
        public void a() {
            if (MBridgeVideoView.this.I0 != null) {
                MBridgeVideoView.this.I0.setVisibility(0);
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("status", 1);
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_webview_zoom", MBridgeVideoView.this.b, eVar);
            }
            if (MBridgeVideoView.this.H0 != null) {
                MBridgeVideoView.this.H0.setCustomizedToolBarMarginWidthPixel(0, 0, 0, 0);
            }
            MBridgeVideoView.this.p();
        }
    }

    class g implements CommonWebView.h {
        g() {
        }

        @Override // com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView.h
        public void a() {
            if (MBridgeVideoView.this.I0 != null) {
                MBridgeVideoView.this.I0.setVisibility(8);
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("status", 2);
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_webview_zoom", MBridgeVideoView.this.b, eVar);
            }
            if (MBridgeVideoView.this.H0 != null) {
                MBridgeVideoView.this.H0.setCustomizedToolBarMarginWidthPixel(0, MBridgeVideoView.this.K0, 0, 0);
            }
            MBridgeVideoView.this.o();
        }
    }

    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MBridgeVideoView.this.I0 != null) {
                MBridgeVideoView.this.I0.setVisibility(0);
            }
            if (MBridgeVideoView.this.G0 != null) {
                MBridgeVideoView.this.G0.setVisibility(8);
            }
            if (MBridgeVideoView.this.s0) {
                return;
            }
            MBridgeVideoView.this.p();
        }
    }

    class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
            if (mBridgeVideoView.notifyListener != null) {
                mBridgeVideoView.b.setTriggerClickSource(2);
                MBridgeVideoView.this.b("bait_click_clicked");
            }
        }
    }

    class j implements AcquireRewardPopViewBehaviourListener {
        j() {
        }

        @Override // com.mbridge.msdk.dycreator.baseview.rewardpopview.AcquireRewardPopViewBehaviourListener
        public void onOutOfContentClicked(float f, float f2) {
            if (MBridgeVideoView.this.u != null) {
                MBridgeVideoView.this.u.a(105, "");
            }
        }

        @Override // com.mbridge.msdk.dycreator.baseview.rewardpopview.AcquireRewardPopViewBehaviourListener
        public void onReceivedFail(String str) {
            MBridgeVideoView.this.J = false;
            if (com.mbridge.msdk.util.b.b()) {
                MBridgeVideoView.this.setCover(false);
            }
            MBridgeVideoView.this.p();
            MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
            com.mbridge.msdk.foundation.same.report.j.a(mBridgeVideoView.b, mBridgeVideoView.Q, MBridgeVideoView.this.z0, 2, str);
        }

        @Override // com.mbridge.msdk.dycreator.baseview.rewardpopview.AcquireRewardPopViewBehaviourListener
        public void onReceivedSuccess(int i) {
            MBridgeVideoView.this.J = false;
            if (com.mbridge.msdk.util.b.b()) {
                MBridgeVideoView.this.setCover(false);
            }
            int videoCompleteTime = MBridgeVideoView.this.getVideoCompleteTime() - i;
            MBridgeVideoView.this.b.setVideoCompleteTime(videoCompleteTime);
            MBridgeVideoView.this.p();
            com.mbridge.msdk.video.module.listener.a aVar = MBridgeVideoView.this.notifyListener;
            if (aVar != null) {
                aVar.a(130, Integer.valueOf(videoCompleteTime));
            }
            MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
            com.mbridge.msdk.foundation.same.report.j.a(mBridgeVideoView.b, mBridgeVideoView.Q, MBridgeVideoView.this.z0, 1, "");
        }
    }

    class k implements Runnable {
        k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MBridgeVideoView.this.B != null) {
                MBridgeVideoView.this.B.setVisibility(8);
            }
        }
    }

    class m implements Runnable {
        m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MBridgeVideoView.this.A0 <= 0) {
                MBridgeVideoView.this.showRewardPopView();
                MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                mBridgeVideoView.removeCallbacks(mBridgeVideoView.Q0);
            } else {
                MBridgeVideoView.W(MBridgeVideoView.this);
                MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
                mBridgeVideoView2.postDelayed(mBridgeVideoView2.Q0, 1000L);
            }
        }
    }

    class n implements PlayerView.OnPlayerViewVisibleListener {
        n() {
        }

        @Override // com.mbridge.msdk.playercommon.PlayerView.OnPlayerViewVisibleListener
        public void playerViewVisibleCallback() {
            if (MBridgeVideoView.this.w) {
                return;
            }
            MBridgeVideoView.this.w = true;
            MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
            if (mBridgeVideoView.notifyListener == null || mBridgeVideoView.v == null) {
                return;
            }
            MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
            mBridgeVideoView2.notifyListener.a(20, mBridgeVideoView2.v);
        }
    }

    class o implements View.OnClickListener {
        o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MBridgeVideoView.this.notifyListener != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(com.mbridge.msdk.foundation.same.a.j, MBridgeVideoView.this.mPlayerView.buildH5JsonObject(0));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                MBridgeVideoView.this.b.setClickTempSource(1);
                MBridgeVideoView.this.b.setTriggerClickSource(2);
                MBridgeVideoView.this.notifyListener.a(1, jSONObject);
            }
            if (MBridgeVideoView.this.j0 != null) {
                try {
                    MBridgeVideoView.this.j0.adUserInteraction(InteractionType.CLICK);
                    o0.a("omsdk", "play video view:  click");
                } catch (Exception e2) {
                    o0.b("omsdk", e2.getMessage());
                }
            }
            MBridgeVideoView.this.setCTALayoutVisibleOrGone();
        }
    }

    class p implements View.OnClickListener {
        p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MBridgeVideoView.this.b.setClickTempSource(1);
            MBridgeVideoView.this.b.setTriggerClickSource(2);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_player_click", MBridgeVideoView.this.b);
            if (MBridgeVideoView.this.notifyListener != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(com.mbridge.msdk.foundation.same.a.j, MBridgeVideoView.this.mPlayerView.buildH5JsonObject(0));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                MBridgeVideoView.this.notifyListener.a(1, jSONObject);
            }
        }
    }

    class q implements View.OnClickListener {
        q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            Integer num = 2;
            PlayerView playerView = MBridgeVideoView.this.mPlayerView;
            if (playerView != null) {
                eVar.a("mute_state", Boolean.valueOf(playerView.isSilent()));
                if (MBridgeVideoView.this.mPlayerView.isSilent()) {
                    num = 1;
                }
            }
            if (num.intValue() == 1) {
                MBridgeVideoView.this.mMuteSwitch = 2;
            } else {
                MBridgeVideoView.this.mMuteSwitch = 1;
            }
            com.mbridge.msdk.video.module.listener.a aVar = MBridgeVideoView.this.notifyListener;
            if (aVar != null) {
                aVar.a(5, num);
            }
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_sound_click", MBridgeVideoView.this.b, eVar);
        }
    }

    class r implements View.OnClickListener {
        r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("type", 1);
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000152", eVar);
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000148", MBridgeVideoView.this.b, eVar);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
            if (!MBridgeVideoView.this.g0) {
                CampaignEx campaignEx = MBridgeVideoView.this.b;
                if (campaignEx == null || campaignEx.getRewardTemplateMode() == null || MBridgeVideoView.this.b.getRewardTemplateMode().f() != 5002010 || !MBridgeVideoView.this.s0) {
                    MBridgeVideoView.this.y();
                    return;
                }
                MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                if (mBridgeVideoView.notifyListener != null) {
                    mBridgeVideoView.L0 = true;
                    MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
                    mBridgeVideoView2.notifyListener.a(2, mBridgeVideoView2.c(mBridgeVideoView2.s0));
                    return;
                }
                return;
            }
            MBridgeVideoView.this.v0 = true;
            CampaignEx campaignEx2 = MBridgeVideoView.this.b;
            if (campaignEx2 != null && campaignEx2.getRewardTemplateMode() != null && MBridgeVideoView.this.b.getRewardTemplateMode().f() == 5002010 && MBridgeVideoView.this.s0) {
                MBridgeVideoView mBridgeVideoView3 = MBridgeVideoView.this;
                if (mBridgeVideoView3.notifyListener != null) {
                    mBridgeVideoView3.L0 = true;
                    MBridgeVideoView mBridgeVideoView4 = MBridgeVideoView.this;
                    mBridgeVideoView4.notifyListener.a(2, mBridgeVideoView4.c(mBridgeVideoView4.s0));
                    return;
                }
                return;
            }
            if (MBridgeVideoView.this.r0) {
                MBridgeVideoView.this.y();
                return;
            }
            com.mbridge.msdk.video.module.listener.a aVar = MBridgeVideoView.this.notifyListener;
            if (aVar != null) {
                aVar.a(Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE, "");
            }
        }
    }

    class s implements com.mbridge.msdk.widget.dialog.b {
        s() {
        }

        @Override // com.mbridge.msdk.widget.dialog.b
        public void a() {
            MBridgeVideoView.this.I = false;
            MBridgeVideoView.this.q0 = true;
            MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
            mBridgeVideoView.setShowingAlertViewCover(mBridgeVideoView.I);
            MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
            com.mbridge.msdk.foundation.same.report.j.a(mBridgeVideoView2.f5779a, mBridgeVideoView2.b, mBridgeVideoView2.k0, MBridgeVideoView.this.Q, 1, 1, 1);
            if (MBridgeVideoView.this.g0 && MBridgeVideoView.this.l0 == com.mbridge.msdk.foundation.same.a.H) {
                MBridgeVideoView mBridgeVideoView3 = MBridgeVideoView.this;
                if (mBridgeVideoView3.notifyListener != null) {
                    mBridgeVideoView3.L0 = true;
                    MBridgeVideoView mBridgeVideoView4 = MBridgeVideoView.this;
                    mBridgeVideoView4.notifyListener.a(2, mBridgeVideoView4.c(mBridgeVideoView4.s0));
                    return;
                }
                return;
            }
            if (MBridgeVideoView.this.g0 && MBridgeVideoView.this.l0 == com.mbridge.msdk.foundation.same.a.I) {
                MBridgeVideoView.this.p();
                return;
            }
            MBridgeVideoView mBridgeVideoView5 = MBridgeVideoView.this;
            if (mBridgeVideoView5.notifyListener != null) {
                mBridgeVideoView5.L0 = true;
                MBridgeVideoView.this.notifyListener.a(2, "");
            }
        }

        @Override // com.mbridge.msdk.widget.dialog.b
        public void b() {
            MBridgeVideoView.this.I = false;
            MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
            mBridgeVideoView.setShowingAlertViewCover(mBridgeVideoView.I);
            if (MBridgeVideoView.this.g0 && (MBridgeVideoView.this.l0 == com.mbridge.msdk.foundation.same.a.I || MBridgeVideoView.this.l0 == com.mbridge.msdk.foundation.same.a.H)) {
                MBridgeVideoView.this.p0 = true;
                com.mbridge.msdk.video.module.listener.a aVar = MBridgeVideoView.this.notifyListener;
                if (aVar != null) {
                    aVar.a(Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE, "");
                }
                MBridgeVideoView.this.u0 = true;
                MBridgeVideoView.this.gonePlayingCloseView();
            }
            MBridgeVideoView.this.p();
            MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
            com.mbridge.msdk.foundation.same.report.j.a(mBridgeVideoView2.f5779a, mBridgeVideoView2.b, mBridgeVideoView2.k0, MBridgeVideoView.this.Q, 1, 0, 1);
        }

        @Override // com.mbridge.msdk.widget.dialog.b
        public void c() {
        }
    }

    class t implements com.mbridge.msdk.foundation.feedback.a {
        t() {
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a() {
            MBridgeVideoView.this.o();
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void close() {
            MBridgeVideoView.this.p();
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a(String str) {
            MBridgeVideoView.this.p();
        }
    }

    public interface u {
        void a();
    }

    public static class v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5837a;
        public int b;
        public boolean c;

        public String toString() {
            return "ProgressData{curPlayPosition=" + this.f5837a + ", allDuration=" + this.b + AbstractJsonLexerKt.END_OBJ;
        }
    }

    private static final class w extends DefaultVideoPlayerStatusListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private MBridgeVideoView f5838a;
        private int b;
        private int c;
        private int d;
        private boolean e;
        private MediaEvents f;
        private boolean k;
        private String l;
        private CampaignEx m;
        private int n;
        private int o;
        private v g = new v();
        private boolean h = false;
        private boolean i = false;
        private boolean j = false;
        private boolean p = false;

        public w(MBridgeVideoView mBridgeVideoView) {
            this.f5838a = mBridgeVideoView;
            if (mBridgeVideoView != null) {
                this.l = mBridgeVideoView.getUnitId();
                this.m = mBridgeVideoView.getCampaign();
            }
        }

        private void c() {
            int i;
            CampaignEx campaignEx;
            if (!q0.a().a("h_c_r_w_p_c", false) || (i = this.n) == 100 || this.o != 0 || this.p || i == 0 || (campaignEx = this.m) == null) {
                return;
            }
            try {
                com.mbridge.msdk.videocommon.download.a aVarA = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.l, (campaignEx.getAdType() == 94 || this.m.getAdType() == 287) ? this.m.getRequestId() + this.m.getId() + this.m.getVideoUrlEncode() : this.m.getId() + this.m.getVideoUrlEncode() + this.m.getBidToken());
                if (aVarA != null) {
                    aVarA.v();
                    this.p = true;
                    if (MBridgeConstans.DEBUG) {
                        o0.b("DefaultVideoPlayerStatusListener", "CDRate is : 0  and start download when player create!");
                    }
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("DefaultVideoPlayerStatusListener", e.getMessage());
                }
            }
        }

        private void e() {
            MBridgeVideoView mBridgeVideoView = this.f5838a;
            if (mBridgeVideoView == null) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mBridgeVideoView.m.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = -2;
                layoutParams.height = t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 25.0f);
                this.f5838a.m.setLayoutParams(layoutParams);
            }
            int iA = t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 5.0f);
            this.f5838a.m.setPadding(iA, 0, iA, 0);
        }

        public int b() {
            return this.d;
        }

        public void d() {
            this.f5838a = null;
            boolean unused = MBridgeVideoView.W0 = false;
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public void onBufferingEnd() {
            try {
                super.onBufferingEnd();
                MediaEvents mediaEvents = this.f;
                if (mediaEvents != null) {
                    mediaEvents.bufferFinish();
                    o0.a("omsdk", "play:  videoEvents.bufferFinish()");
                }
                this.f5838a.notifyListener.a(14, "");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public void onBufferingStart(String str) {
            try {
                super.onBufferingStart(str);
                if (this.f != null) {
                    o0.a("omsdk", "play:  videoEvents.bufferStart()");
                    this.f.bufferStart();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public void onBufferingTimeOut(String str) {
            try {
                this.f5838a.notifyListener.a(13, "");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public void onPlayCompleted() {
            MBridgeVideoView mBridgeVideoView;
            super.onPlayCompleted();
            this.f5838a.s0 = true;
            CampaignEx campaignEx = this.m;
            if (campaignEx != null) {
                if (this.k && campaignEx.getRewardTemplateMode() != null && this.m.getRewardTemplateMode().f() == 5002010) {
                    this.f5838a.m.setText("0");
                } else {
                    this.f5838a.m.setText(g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_reward_video_view_reward_time_complete", "string"));
                }
                this.m.setVideoPlayProgress(100);
                if (this.m.getAdSpaceT() == 2) {
                    this.f5838a.n.setVisibility(4);
                    if (this.f5838a.r != null) {
                        this.f5838a.r.setClickable(false);
                    }
                    SoundImageView soundImageView = this.f5838a.mSoundImageView;
                    if (soundImageView != null) {
                        soundImageView.setClickable(false);
                    }
                }
            } else {
                this.f5838a.m.setText("0");
            }
            MediaEvents mediaEvents = this.f;
            if (mediaEvents != null) {
                mediaEvents.complete();
                o0.a("omsdk", "play:  videoEvents.complete()");
            }
            this.f5838a.mPlayerView.setClickable(false);
            String strC = this.f5838a.c(true);
            CampaignEx campaignEx2 = this.m;
            if (campaignEx2 != null && campaignEx2.getRewardTemplateMode() != null && this.m.getRewardTemplateMode().f() == 5002010) {
                this.f5838a.x();
            }
            CampaignEx campaignEx3 = this.m;
            if (campaignEx3 != null && campaignEx3.getDynamicTempCode() == 5 && (mBridgeVideoView = this.f5838a) != null && mBridgeVideoView.x != null) {
                MBridgeVideoView mBridgeVideoView2 = this.f5838a;
                if (mBridgeVideoView2.mCampaignSize > mBridgeVideoView2.mCurrPlayNum) {
                    HashMap map = new HashMap();
                    map.put(b9.h.L, Integer.valueOf(this.f5838a.mCurrPlayNum));
                    int i = this.f5838a.mMuteSwitch;
                    if (i != 0) {
                        map.put("mute", Integer.valueOf(i));
                    }
                    this.f5838a.x.a(map);
                    return;
                }
            }
            MBridgeVideoView mBridgeVideoView3 = this.f5838a;
            if (mBridgeVideoView3 != null) {
                mBridgeVideoView3.notifyListener.a(Sdk.SDKError.Reason.TPAT_ERROR_VALUE, "");
                this.f5838a.notifyListener.a(11, strC);
            }
            int i2 = this.c;
            this.b = i2;
            this.f5838a.mCurrentPlayProgressTime = i2;
            boolean unused = MBridgeVideoView.W0 = true;
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public void onPlayError(String str) {
            o0.b("DefaultVideoPlayerStatusListener", "errorStr" + str);
            super.onPlayError(str);
            MBridgeVideoView mBridgeVideoView = this.f5838a;
            if (mBridgeVideoView != null) {
                mBridgeVideoView.notifyListener.a(12, str);
            }
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public void onPlayProgress(int i, int i2) {
            CampaignEx campaignEx;
            int videoCompleteTime;
            super.onPlayProgress(i, i2);
            if (MBridgeVideoView.X0 == 0) {
                long unused = MBridgeVideoView.X0 = System.currentTimeMillis();
            }
            if (!this.f5838a.M0 && this.f5838a.y != null) {
                this.f5838a.M0 = true;
                this.f5838a.y.a();
            }
            if (this.f5838a.e) {
                CampaignEx campaignEx2 = this.m;
                if (campaignEx2 != null) {
                    videoCompleteTime = campaignEx2.getVideoCompleteTime();
                    if (videoCompleteTime <= 0) {
                        videoCompleteTime = i2;
                    }
                    com.mbridge.msdk.foundation.feedback.b.b().b(this.m.getCampaignUnitId() + "_1", i);
                } else {
                    videoCompleteTime = 0;
                }
                CampaignEx campaignEx3 = this.m;
                if (campaignEx3 != null && campaignEx3.isDynamicView() && this.m.getDynamicTempCode() == 5) {
                    try {
                        b(videoCompleteTime, this.f5838a.z, i);
                    } catch (Exception e) {
                        o0.b("DefaultVideoPlayerStatusListener", e.getMessage());
                    }
                } else {
                    a(videoCompleteTime, i2, i);
                    this.g.f5837a = i;
                }
            }
            this.c = i2;
            v vVar = this.g;
            vVar.b = i2;
            vVar.c = this.f5838a.u0;
            this.b = i;
            if (this.f5838a.s != null) {
                this.f5838a.s.setTag("" + this.b);
            }
            MBridgeVideoView mBridgeVideoView = this.f5838a;
            mBridgeVideoView.mCurrentPlayProgressTime = i;
            mBridgeVideoView.notifyListener.a(15, this.g);
            MediaEvents mediaEvents = this.f;
            if (mediaEvents != null) {
                int i3 = (i * 100) / i2;
                int i4 = ((i + 1) * 100) / i2;
                if (i3 <= 25 && 25 < i4 && !this.h) {
                    this.h = true;
                    mediaEvents.firstQuartile();
                    o0.a("omsdk", "play:  videoEvents.firstQuartile()");
                } else if (i3 <= 50 && 50 < i4 && !this.i) {
                    this.i = true;
                    mediaEvents.midpoint();
                    o0.a("omsdk", "play:  videoEvents.midpoint()");
                } else if (i3 <= 75 && 75 < i4 && !this.j) {
                    this.j = true;
                    mediaEvents.thirdQuartile();
                    o0.a("omsdk", "play:  videoEvents.thirdQuartile()");
                }
            }
            if (this.f5838a.g0 && !this.f5838a.o0 && this.f5838a.l0 == com.mbridge.msdk.foundation.same.a.I) {
                this.f5838a.y();
            }
            try {
                MBridgeVideoView mBridgeVideoView2 = this.f5838a;
                if (mBridgeVideoView2 != null && mBridgeVideoView2.t != null) {
                    int i5 = (i * 100) / i2;
                    this.f5838a.t.setProgress(i5, this.f5838a.mCurrPlayNum - 1);
                    this.m.setVideoPlayProgress(i5);
                }
                MBridgeVideoView mBridgeVideoView3 = this.f5838a;
                if (mBridgeVideoView3 != null) {
                    int i6 = mBridgeVideoView3.F != -5 ? this.f5838a.F : this.f5838a.E;
                    if (i6 != -1 && i == i6 && (campaignEx = this.f5838a.b) != null && campaignEx.isDynamicView()) {
                        this.f5838a.setCTALayoutVisibleOrGone();
                    }
                }
            } catch (Throwable th) {
                o0.b("DefaultVideoPlayerStatusListener", th.getMessage());
            }
            a(i, i2);
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public void onPlaySetDataSourceError(String str) {
            super.onPlaySetDataSourceError(str);
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public void onPlayStarted(int i) {
            PlayerView playerView;
            CampaignEx campaignEx;
            super.onPlayStarted(i);
            MBridgeVideoView mBridgeVideoView = this.f5838a;
            if (mBridgeVideoView != null) {
                mBridgeVideoView.g();
            }
            if (!this.e) {
                MBridgeVideoView mBridgeVideoView2 = this.f5838a;
                if (mBridgeVideoView2 != null) {
                    mBridgeVideoView2.A = true;
                    this.f5838a.notifyListener.a(10, this.g);
                }
                this.e = true;
            }
            this.d = i;
            CampaignEx campaignEx2 = this.m;
            if (campaignEx2 != null) {
                int videoCompleteTime = campaignEx2.getVideoCompleteTime();
                if (videoCompleteTime <= 0) {
                    videoCompleteTime = i;
                }
                if (this.m.isDynamicView()) {
                    b(videoCompleteTime);
                } else {
                    a(videoCompleteTime);
                }
            }
            MBridgeVideoView mBridgeVideoView3 = this.f5838a;
            if (mBridgeVideoView3 != null && mBridgeVideoView3.q != null) {
                this.f5838a.q.setMax(i);
            }
            MBridgeVideoView mBridgeVideoView4 = this.f5838a;
            if (mBridgeVideoView4 != null && mBridgeVideoView4.o != null && (campaignEx = this.m) != null && campaignEx.getAdSpaceT() == 2) {
                this.f5838a.o.setVisibility(0);
            }
            MBridgeVideoView mBridgeVideoView5 = this.f5838a;
            if (mBridgeVideoView5 != null && mBridgeVideoView5.m != null && this.f5838a.m.getVisibility() == 0) {
                this.f5838a.f();
            }
            boolean unused = MBridgeVideoView.W0 = false;
            if (this.f5838a != null && this.m.isDynamicView()) {
                if (this.f5838a.F != -5) {
                    if (this.f5838a.F == 0) {
                        this.f5838a.setCTALayoutVisibleOrGone();
                    }
                } else if (this.f5838a.E == 0) {
                    this.f5838a.setCTALayoutVisibleOrGone();
                }
            }
            MBridgeVideoView mBridgeVideoView6 = this.f5838a;
            if (mBridgeVideoView6 != null) {
                mBridgeVideoView6.showMoreOfferInPlayTemplate();
                this.f5838a.showBaitClickView();
                this.f5838a.q();
            }
            if (this.f != null) {
                try {
                    MBridgeVideoView mBridgeVideoView7 = this.f5838a;
                    this.f.start(i, (mBridgeVideoView7 == null || (playerView = mBridgeVideoView7.mPlayerView) == null) ? 0.0f : playerView.getVolume());
                    o0.a("omsdk", "play video view:  videoEvents.start");
                } catch (Exception e) {
                    o0.b("omsdk", e.getMessage());
                }
            }
        }

        public void a(CampaignEx campaignEx) {
            this.m = campaignEx;
        }

        public void b(int i, int i2) {
            this.n = i;
            this.o = i2;
            c();
        }

        public void a(boolean z) {
            this.k = z;
        }

        public void a(String str) {
            this.l = str;
        }

        public int a() {
            return this.b;
        }

        private void a(int i) {
            if (i > 0) {
                this.f5838a.m.setBackgroundResource(g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_reward_video_time_count_num_bg", "drawable"));
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 30.0f));
                int iA = t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 5.0f);
                layoutParams.addRule(1, g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_native_endcard_feed_btn", "id"));
                layoutParams.setMargins(iA, 0, 0, 0);
                this.f5838a.m.setPadding(iA, 0, iA, 0);
                this.f5838a.m.setLayoutParams(layoutParams);
                return;
            }
            this.f5838a.m.setBackgroundResource(g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_reward_shape_progress", "drawable"));
        }

        private void b(int i) {
            MBridgeVideoView mBridgeVideoView = this.f5838a;
            if (mBridgeVideoView == null || mBridgeVideoView.m == null) {
                return;
            }
            String str = "mbridge_reward_video_time_count_num_bg";
            if (this.m.getDynamicTempCode() == 5) {
                MBridgeVideoView mBridgeVideoView2 = this.f5838a;
                if (mBridgeVideoView2.mCurrPlayNum > 1 && i <= 0) {
                    mBridgeVideoView2.m.setBackgroundResource(g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_reward_video_time_count_num_bg", "drawable"));
                    e();
                    return;
                }
            }
            if (i > 0) {
                if (!this.k || this.m.getDynamicTempCode() == 5) {
                    e();
                }
            } else {
                str = "mbridge_reward_shape_progress";
            }
            CampaignEx campaignEx = this.m;
            if (campaignEx != null && campaignEx.getUseSkipTime() == 1 && this.k) {
                e();
            }
            this.f5838a.m.setBackgroundResource(g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), str, "drawable"));
        }

        private void a(int i, int i2) {
            int i3;
            String str;
            int i4 = this.n;
            if (i4 == 100 || this.p || i4 == 0) {
                return;
            }
            if (this.o > i4) {
                this.o = i4 / 2;
            }
            int i5 = this.o;
            if (i5 < 0 || i < (i3 = (i2 * i5) / 100)) {
                return;
            }
            if (this.m.getAdType() != 94 && this.m.getAdType() != 287) {
                str = this.m.getId() + this.m.getVideoUrlEncode() + this.m.getBidToken();
            } else {
                str = this.m.getRequestId() + this.m.getId() + this.m.getVideoUrlEncode();
            }
            com.mbridge.msdk.videocommon.download.a aVarA = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.l, str);
            if (aVarA != null) {
                aVarA.v();
                this.p = true;
                o0.b("DefaultVideoPlayerStatusListener", "CDRate is : " + i3 + " and start download !");
            }
        }

        private void b(int i, int i2, int i3) {
            int i4;
            MBridgeVideoView mBridgeVideoView = this.f5838a;
            if (mBridgeVideoView == null) {
                return;
            }
            String string = (String) mBridgeVideoView.getContext().getResources().getText(g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_reward_video_view_reward_time_complete", "string"));
            String str = (String) this.f5838a.getContext().getResources().getText(g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_reward_video_view_reward_time_left", "string"));
            if (i >= 0) {
                if (this.m.getUseSkipTime() == 1) {
                    int iMin = Math.min(this.f5838a.L, i);
                    if (iMin >= i || iMin <= 0) {
                        i4 = i - i3;
                        if (this.k) {
                            if (i4 <= 0) {
                                this.f5838a.m.setVisibility(4);
                            } else {
                                str = (String) this.f5838a.getContext().getResources().getText(g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_reward_video_view_reward_time_left_skip_time", "string"));
                            }
                        }
                    } else {
                        i4 = iMin - i3;
                        if (i4 <= 0) {
                            i4 = i - i3;
                            if (this.k) {
                                this.f5838a.m.setVisibility(4);
                            }
                        } else {
                            str = (String) this.f5838a.getContext().getResources().getText(g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_reward_video_view_reward_time_left_skip_time", "string"));
                        }
                    }
                } else {
                    i4 = i - i3;
                }
                if (i4 > 0) {
                    string = i4 + str;
                }
            } else {
                i4 = i2 - i3;
                if (i4 > 0) {
                    string = (i <= 0 ? new StringBuilder().append(i4).append("") : new StringBuilder().append(i4).append(str)).toString();
                } else if (i <= 0) {
                    string = "0";
                }
            }
            this.g.f5837a = i3;
            this.f5838a.m.setText(string);
            if (this.f5838a.q != null && this.f5838a.q.getVisibility() == 0) {
                this.f5838a.q.setProgress(i3);
            }
            if (i4 >= this.f5838a.C0 || this.f5838a.E0 == null || !this.f5838a.J) {
                return;
            }
            this.f5838a.E0.onTimeLessThanReduce(i4);
        }

        private void a(int i, int i2, int i3) {
            StringBuilder sbAppend;
            String str;
            String string;
            MBridgeVideoView mBridgeVideoView = this.f5838a;
            if (mBridgeVideoView == null) {
                return;
            }
            if (!this.k) {
                if (i > i2) {
                    i = i2;
                }
                int i4 = i <= 0 ? i2 - i3 : i - i3;
                if (i4 <= 0) {
                    i4 = 0;
                    string = i <= 0 ? "0" : (String) mBridgeVideoView.getContext().getResources().getText(g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_reward_video_view_reward_time_complete", "string"));
                } else {
                    if (i <= 0) {
                        sbAppend = new StringBuilder().append(i4);
                        str = "";
                    } else {
                        sbAppend = new StringBuilder().append(i4);
                        str = (String) this.f5838a.getContext().getResources().getText(g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_reward_video_view_reward_time_left", "string"));
                    }
                    string = sbAppend.append(str).toString();
                }
                if (i4 < this.f5838a.C0 && this.f5838a.E0 != null && this.f5838a.J) {
                    this.f5838a.E0.onTimeLessThanReduce(i4);
                }
            } else {
                string = String.format("%s", Integer.valueOf(i2 - i3));
            }
            CampaignEx campaignEx = this.m;
            if (campaignEx != null && campaignEx.getUseSkipTime() == 1) {
                int iMin = Math.min(this.f5838a.L, i2);
                if (iMin >= i || iMin < 0) {
                    int i5 = i - i3;
                    if (this.k) {
                        if (i5 > 0) {
                            string = i5 + ((String) this.f5838a.getContext().getResources().getText(g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_reward_video_view_reward_time_left_skip_time", "string")));
                        } else if (i5 == 0) {
                            this.f5838a.m.setVisibility(4);
                        }
                    }
                } else {
                    int i6 = iMin - i3;
                    if (i6 > 0) {
                        string = i6 + ((String) this.f5838a.getContext().getResources().getText(g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_reward_video_view_reward_time_left_skip_time", "string")));
                    } else if (this.k && i6 == 0) {
                        this.f5838a.m.setVisibility(4);
                    }
                }
            }
            this.f5838a.m.setText(string);
            if (this.f5838a.q == null || this.f5838a.q.getVisibility() != 0) {
                return;
            }
            this.f5838a.q.setProgress(i3);
        }
    }

    public MBridgeVideoView(Context context) {
        super(context);
        this.mCampaignSize = 1;
        this.mCurrPlayNum = 1;
        this.mCurrentPlayProgressTime = 0;
        this.mMuteSwitch = 0;
        this.w = false;
        this.z = 0;
        this.H = false;
        this.I = false;
        this.J = false;
        this.Q = "";
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.a0 = false;
        this.b0 = false;
        this.c0 = false;
        this.d0 = false;
        this.e0 = false;
        this.g0 = false;
        this.h0 = 2;
        this.o0 = false;
        this.p0 = false;
        this.q0 = false;
        this.r0 = true;
        this.s0 = false;
        this.t0 = false;
        this.u0 = false;
        this.v0 = false;
        this.w0 = false;
        this.z0 = 0;
        this.A0 = 5;
        this.B0 = 5;
        this.C0 = 5;
        this.F0 = false;
        this.J0 = false;
        this.K0 = 0;
        this.L0 = false;
        this.M0 = false;
        this.N0 = new w(this);
        this.O0 = false;
        this.P0 = new k();
        this.Q0 = new m();
    }

    static /* synthetic */ int W(MBridgeVideoView mBridgeVideoView) {
        int i2 = mBridgeVideoView.A0;
        mBridgeVideoView.A0 = i2 - 1;
        return i2;
    }

    private int getCDRate() {
        return com.mbridge.msdk.videocommon.setting.b.b().a(com.mbridge.msdk.foundation.controller.c.m().b(), this.Q, false).g();
    }

    private int getVideoAllDuration() {
        try {
            w wVar = this.N0;
            int iB = wVar != null ? wVar.b() : 0;
            return iB == 0 ? this.b.getVideoLength() : iB;
        } catch (Throwable th) {
            o0.b(MBridgeBaseView.TAG, th.getMessage());
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getVideoCompleteTime() {
        int videoCompleteTime = 0;
        try {
            int videoAllDuration = getVideoAllDuration();
            CampaignEx campaignEx = this.b;
            if (campaignEx == null) {
                return videoAllDuration;
            }
            videoCompleteTime = campaignEx.getVideoCompleteTime();
            if (this.b.getDynamicTempCode() != 5 && videoCompleteTime > videoAllDuration) {
                videoCompleteTime = videoAllDuration;
            }
            if (videoCompleteTime <= 0) {
                return videoAllDuration;
            }
        } catch (Throwable th) {
            o0.b(MBridgeBaseView.TAG, th.getMessage());
        }
        return videoCompleteTime;
    }

    private void setBlurBackgroundImage(String str) {
        com.mbridge.msdk.foundation.same.image.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(str, new c());
    }

    private void setPlayerViewRadius(int i2) {
        if (i2 > 0) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(t0.a(getContext(), i2));
            gradientDrawable.setColor(-1);
            gradientDrawable.setStroke(1, 0);
            setBackground(gradientDrawable);
            this.mPlayerView.setBackground(gradientDrawable);
            setClipToOutline(true);
            this.mPlayerView.setClipToOutline(true);
        }
    }

    private void t() {
    }

    public void addCTAView() {
        if (this.B == null) {
            return;
        }
        if (this.C == null) {
            MBridgeClickCTAView mBridgeClickCTAView = new MBridgeClickCTAView(getContext());
            this.C = mBridgeClickCTAView;
            mBridgeClickCTAView.setCampaign(this.b);
            this.C.setUnitId(this.Q);
            com.mbridge.msdk.video.module.listener.a aVar = this.u;
            if (aVar != null) {
                this.C.setNotifyListener(new com.mbridge.msdk.video.module.listener.impl.i(aVar));
            }
            this.C.preLoadData(this.D);
        }
        this.B.addView(this.C);
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void alertWebViewShowed() {
        this.I = true;
        setShowingAlertViewCover(true);
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void closeVideoOperate(int i2, int i3) {
        if (i2 == 1) {
            this.v0 = true;
            if (getVisibility() == 0) {
                y();
            }
            try {
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("type", 1);
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000152", eVar);
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000148", this.b, eVar);
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000134", this.b);
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    th.printStackTrace();
                }
            }
        }
        if (i3 == 1) {
            gonePlayingCloseView();
        } else if (i3 == 2) {
            if (this.u0 && getVisibility() == 0) {
                return;
            }
            x();
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void defaultShow() {
        super.defaultShow();
        this.T = true;
        showVideoLocation(0, 0, t0.g(this.f5779a), t0.f(this.f5779a), 0, 0, 0, 0, 0);
        SpecialsBridge.MBridgeVideoView_videoOperate(this, 1);
        if (this.L == 0) {
            closeVideoOperate(-1, 2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void dismissAllAlert() {
        MBAlertDialog mBAlertDialog = this.O;
        if (mBAlertDialog != null) {
            mBAlertDialog.dismiss();
        }
        com.mbridge.msdk.video.module.listener.a aVar = this.notifyListener;
        if (aVar != null) {
            aVar.a(Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE, "");
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.o, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.mbridge.msdk.video.signal.j
    public int getBorderViewHeight() {
        return V0;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public int getBorderViewLeft() {
        return T0;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public int getBorderViewRadius() {
        return R0;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public int getBorderViewTop() {
        return S0;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public int getBorderViewWidth() {
        return U0;
    }

    public int getBufferTimeout() {
        return this.M;
    }

    public int getCloseAlert() {
        return this.N;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public String getCurrentProgress() {
        try {
            int iA = this.N0.a();
            CampaignEx campaignEx = this.b;
            int videoLength = campaignEx != null ? campaignEx.getVideoLength() : 0;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("progress", a(iA, videoLength));
            jSONObject.put("time", iA);
            jSONObject.put("duration", videoLength + "");
            return jSONObject.toString();
        } catch (Throwable th) {
            o0.b(MBridgeBaseView.TAG, th.getMessage(), th);
            return JsonUtils.EMPTY_JSON;
        }
    }

    public int getMute() {
        return this.h0;
    }

    public String getPlayURL() {
        return this.K;
    }

    public String getUnitId() {
        return this.Q;
    }

    public int getVideoSkipTime() {
        return this.L;
    }

    public void gonePlayingCloseView() {
        if (this.e && this.n.getVisibility() != 8) {
            this.n.setVisibility(8);
            this.a0 = false;
        }
        i();
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void hideAlertView(int i2) {
        if (this.I) {
            this.I = false;
            this.o0 = true;
            setShowingAlertViewCover(false);
            com.mbridge.msdk.foundation.same.report.j.a(this.f5779a, this.b, com.mbridge.msdk.videocommon.setting.b.b().a(com.mbridge.msdk.foundation.controller.c.m().b(), this.Q, false).c(), this.Q, 1, i2, 1);
            if (i2 == 0) {
                p();
                if (this.g0) {
                    int i3 = this.l0;
                    if (i3 == com.mbridge.msdk.foundation.same.a.I || i3 == com.mbridge.msdk.foundation.same.a.H) {
                        this.p0 = true;
                        com.mbridge.msdk.video.module.listener.a aVar = this.notifyListener;
                        if (aVar != null) {
                            aVar.a(Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE, "");
                        }
                        CampaignEx campaignEx = this.b;
                        if (campaignEx != null && campaignEx.getRewardTemplateMode() != null && this.b.getRewardTemplateMode().f() == 5002010) {
                            x();
                            return;
                        } else {
                            this.u0 = true;
                            gonePlayingCloseView();
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            this.q0 = true;
            boolean z = this.g0;
            if (z && this.l0 == com.mbridge.msdk.foundation.same.a.I) {
                p();
                return;
            }
            if (z && this.l0 == com.mbridge.msdk.foundation.same.a.H) {
                com.mbridge.msdk.video.module.listener.a aVar2 = this.notifyListener;
                if (aVar2 != null) {
                    this.L0 = true;
                    aVar2.a(2, c(this.s0));
                    return;
                }
                return;
            }
            com.mbridge.msdk.video.module.listener.a aVar3 = this.notifyListener;
            if (aVar3 != null) {
                this.L0 = true;
                aVar3.a(2, "");
            }
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void init(Context context) {
    }

    @Override // com.mbridge.msdk.video.signal.j
    public boolean isH5Canvas() {
        return getLayoutParams().height < t0.f(this.f5779a.getApplicationContext());
    }

    public boolean isInstDialogShowing() {
        return this.F0;
    }

    public boolean isMiniCardShowing() {
        return this.W;
    }

    public boolean isRewardPopViewShowing() {
        return this.J;
    }

    public boolean isShowingAlertView() {
        return this.I;
    }

    public boolean isShowingTransparent() {
        return this.e0;
    }

    public boolean isfront() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup == null) {
            return false;
        }
        int iIndexOfChild = viewGroup.indexOfChild(this);
        int childCount = viewGroup.getChildCount();
        int i2 = iIndexOfChild + 1;
        boolean z = false;
        while (i2 <= childCount - 1) {
            if (viewGroup.getChildAt(i2).getVisibility() == 0 && this.W) {
                return false;
            }
            i2++;
            z = true;
        }
        return z;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void notifyCloseBtn(int i2) {
        if (i2 == 0) {
            this.b0 = true;
            this.d0 = false;
        } else if (i2 == 1) {
            this.c0 = true;
        }
    }

    public void notifyVideoClose() {
        this.L0 = true;
        this.notifyListener.a(2, "");
    }

    public void onActivityPause() {
        try {
            MBAcquireRewardPopView mBAcquireRewardPopView = this.E0;
            if (mBAcquireRewardPopView != null) {
                mBAcquireRewardPopView.onPause();
            }
        } catch (Throwable th) {
            o0.b(MBridgeBaseView.TAG, th.getMessage());
        }
    }

    public void onActivityResume() {
        try {
            MBAcquireRewardPopView mBAcquireRewardPopView = this.E0;
            if (mBAcquireRewardPopView != null) {
                mBAcquireRewardPopView.onResume();
            }
        } catch (Throwable th) {
            o0.b(MBridgeBaseView.TAG, th.getMessage());
        }
    }

    public void onActivityStop() {
        try {
            MBAcquireRewardPopView mBAcquireRewardPopView = this.E0;
            if (mBAcquireRewardPopView != null) {
                mBAcquireRewardPopView.onStop();
            }
        } catch (Throwable th) {
            o0.b(MBridgeBaseView.TAG, th.getMessage());
        }
    }

    public void onBackPress() {
        boolean z;
        if (this.W || this.I || this.p0) {
            return;
        }
        CampaignEx campaignEx = this.b;
        if (campaignEx != null && campaignEx.getRewardTemplateMode() != null && this.b.getRewardTemplateMode().f() == 5002010 && (z = this.s0)) {
            com.mbridge.msdk.video.module.listener.a aVar = this.notifyListener;
            if (aVar != null) {
                this.L0 = true;
                aVar.a(2, c(z));
                return;
            }
            return;
        }
        if (this.a0) {
            y();
            return;
        }
        boolean z2 = this.b0;
        if (z2 && this.c0) {
            y();
        } else {
            if (z2 || !this.d0) {
                return;
            }
            y();
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        CampaignEx campaignEx = this.b;
        if ((campaignEx == null || !campaignEx.isDynamicView()) && this.e && this.T) {
            u();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            if (this.P0 != null) {
                getHandler().removeCallbacks(this.P0);
            }
            if (this.z0 != 0) {
                removeCallbacks(this.Q0);
            }
        } catch (Throwable th) {
            o0.b(MBridgeBaseView.TAG, th.getMessage());
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

    public void preLoadData(com.mbridge.msdk.video.signal.factory.b bVar) {
        this.D = bVar;
        if (!this.e) {
            com.mbridge.msdk.video.module.listener.a aVar = this.notifyListener;
            if (aVar != null) {
                aVar.a(12, "MBridgeVideoView initSuccess false");
            }
        } else if (!TextUtils.isEmpty(this.K) && this.b != null) {
            AdSession adSession = this.i0;
            if (adSession != null) {
                adSession.registerAdView(this.mPlayerView);
                SoundImageView soundImageView = this.mSoundImageView;
                if (soundImageView != null) {
                    this.i0.addFriendlyObstruction(soundImageView, FriendlyObstructionPurpose.OTHER, null);
                }
                this.i0.addFriendlyObstruction(this.m, FriendlyObstructionPurpose.OTHER, null);
                this.i0.addFriendlyObstruction(this.n, FriendlyObstructionPurpose.VIDEO_CONTROLS, null);
            }
            k();
            this.mPlayerView.initBufferIngParam(this.M);
            this.mPlayerView.initVFPData(this.K, this.b.getVideoUrlEncode(), this.N0);
            soundOperate(this.h0, -1, null);
        }
        W0 = false;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void progressBarOperate(int i2) {
        ProgressBar progressBar;
        if (this.e) {
            if (i2 == 1) {
                ProgressBar progressBar2 = this.q;
                if (progressBar2 != null) {
                    progressBar2.setVisibility(8);
                    return;
                }
                return;
            }
            if (i2 != 2 || (progressBar = this.q) == null) {
                return;
            }
            progressBar.setVisibility(0);
        }
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void progressOperate(int i2, int i3) {
        if (this.e) {
            o0.c(MBridgeBaseView.TAG, "progressOperate progress:" + i2);
            CampaignEx campaignEx = this.b;
            int videoLength = campaignEx != null ? campaignEx.getVideoLength() : 0;
            if (i2 > 0 && i2 <= videoLength && this.mPlayerView != null) {
                o0.c(MBridgeBaseView.TAG, "progressOperate progress:" + i2);
                this.mPlayerView.seekTo(i2 * 1000);
            }
            if (i3 == 1) {
                this.m.setVisibility(8);
            } else if (i3 == 2) {
                this.m.setVisibility(0);
            }
            if (this.m.getVisibility() == 0) {
                f();
            }
        }
    }

    public void releasePlayer() {
        try {
            PlayerView playerView = this.mPlayerView;
            if (playerView != null && !this.V) {
                playerView.release();
                if (!TextUtils.isEmpty(this.K)) {
                    com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                    long jCurrentTimeMillis = X0;
                    if (jCurrentTimeMillis != 0) {
                        jCurrentTimeMillis = System.currentTimeMillis() - X0;
                    }
                    eVar.a("duration", Long.valueOf(jCurrentTimeMillis));
                    com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000146", this.b, eVar);
                }
            }
            w wVar = this.N0;
            if (wVar != null) {
                wVar.d();
            }
            if (this.u != null) {
                this.u = null;
            }
        } catch (Exception e2) {
            o0.b(MBridgeBaseView.TAG, e2.getMessage());
        }
    }

    public void setAdSession(AdSession adSession) {
        this.i0 = adSession;
    }

    public void setBufferTimeout(int i2) {
        this.M = i2;
    }

    public void setCTALayoutVisibleOrGone() {
        CampaignEx campaignEx = this.b;
        if (campaignEx == null || this.B == null) {
            return;
        }
        if (campaignEx.getRewardTemplateMode() == null || this.b.getRewardTemplateMode().f() != 902) {
            int i2 = this.F;
            if (i2 != -5) {
                if (i2 == -3) {
                    return;
                }
                if (this.C == null) {
                    addCTAView();
                }
                if (this.F == -1) {
                    if (this.B.getVisibility() != 0) {
                        this.B.setVisibility(0);
                        postDelayed(this.P0, 3000L);
                    } else {
                        this.B.setVisibility(8);
                        getHandler().removeCallbacks(this.P0);
                    }
                }
                if (this.F >= 0) {
                    this.B.setVisibility(0);
                    return;
                }
                return;
            }
            if (this.E < -1) {
                return;
            }
            if (this.C == null) {
                addCTAView();
            }
            int i3 = this.E;
            if (i3 >= 0) {
                this.B.setVisibility(0);
                return;
            }
            if (i3 == -1) {
                if (this.B.getVisibility() != 0) {
                    this.B.setVisibility(0);
                    postDelayed(this.P0, 3000L);
                } else {
                    this.B.setVisibility(8);
                    getHandler().removeCallbacks(this.P0);
                }
            }
        }
    }

    public void setCamPlayOrderCallback(com.mbridge.msdk.video.dynview.listener.a aVar, List<CampaignEx> list, int i2, int i3) {
        MBridgeSegmentsProgressBar mBridgeSegmentsProgressBar;
        this.x = aVar;
        this.mCampaignSize = list.size();
        this.mCurrPlayNum = i2;
        this.z = i3;
        this.mCampOrderViewData = list;
        CampaignEx campaignEx = this.b;
        if (campaignEx == null || campaignEx.getDynamicTempCode() != 5) {
            CampaignEx campaignEx2 = this.b;
            if (campaignEx2 == null || campaignEx2.getProgressBarShow() != 1 || (mBridgeSegmentsProgressBar = this.t) == null) {
                return;
            }
            mBridgeSegmentsProgressBar.init(1, 3);
            this.t.setVisibility(0);
            return;
        }
        MBridgeSegmentsProgressBar mBridgeSegmentsProgressBar2 = this.t;
        if (mBridgeSegmentsProgressBar2 == null || this.mCampOrderViewData == null) {
            return;
        }
        if (this.mCampaignSize > 1) {
            mBridgeSegmentsProgressBar2.setVisibility(0);
            this.t.init(this.mCampaignSize, 2);
            for (int i4 = 0; i4 < this.mCampOrderViewData.size(); i4++) {
                int videoPlayProgress = this.mCampOrderViewData.get(i4).getVideoPlayProgress();
                if (videoPlayProgress > 0) {
                    this.t.setProgress(videoPlayProgress, i4);
                }
                if (this.mCampOrderViewData.get(i4).isRewardPopViewShowed) {
                    this.H = true;
                }
            }
            return;
        }
        CampaignEx campaignEx3 = this.b;
        if (campaignEx3 == null || campaignEx3.getProgressBarShow() != 1) {
            this.t.setVisibility(8);
            return;
        }
        MBridgeSegmentsProgressBar mBridgeSegmentsProgressBar3 = this.t;
        if (mBridgeSegmentsProgressBar3 != null) {
            mBridgeSegmentsProgressBar3.init(1, 3);
            this.t.setVisibility(0);
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void setCampaign(CampaignEx campaignEx) {
        super.setCampaign(campaignEx);
        w wVar = this.N0;
        if (wVar != null) {
            wVar.a(campaignEx);
            this.N0.b(a(campaignEx), getCDRate());
        }
    }

    public void setCloseAlert(int i2) {
        this.N = i2;
    }

    public void setContainerViewOnNotifyListener(com.mbridge.msdk.video.module.listener.a aVar) {
        this.u = aVar;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void setCover(boolean z) {
        if (this.e) {
            this.mPlayerView.setIsCovered(z);
        }
    }

    public void setDialogRole(int i2) {
        this.r0 = i2 == 1;
        o0.b(MBridgeBaseView.TAG, i2 + " " + this.r0);
    }

    public void setIPlayVideoViewLayoutCallBack(com.mbridge.msdk.video.dynview.listener.f fVar) {
        this.y = fVar;
    }

    public void setIVRewardEnable(int i2, int i3, int i4) {
        this.l0 = i2;
        this.m0 = i3;
        this.n0 = i4;
    }

    public void setInstDialogState(boolean z) {
        PlayerView playerView;
        this.F0 = z;
        if (!com.mbridge.msdk.util.b.a() || (playerView = this.mPlayerView) == null) {
            return;
        }
        playerView.setIsCovered(z);
    }

    public void setIsIV(boolean z) {
        this.g0 = z;
        w wVar = this.N0;
        if (wVar != null) {
            wVar.a(z);
        }
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void setMiniEndCardState(boolean z) {
        this.W = z;
    }

    public void setNotchPadding(int i2, int i3, int i4, int i5) {
        RelativeLayout relativeLayout;
        try {
            o0.b(MBridgeBaseView.TAG, "NOTCH VideoView " + String.format("%1s-%2s-%3s-%4s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            int i6 = layoutParams.leftMargin;
            int i7 = layoutParams.rightMargin;
            int i8 = layoutParams.topMargin;
            int i9 = layoutParams.bottomMargin;
            this.K0 = i4;
            if (Math.max(Math.max(i6, i7), Math.max(i8, i9)) <= Math.max(Math.max(i2, i3), Math.max(i4, i5)) && (relativeLayout = this.o) != null) {
                relativeLayout.postDelayed(new b(i2, i4, i3, i5), 200L);
            }
            if (this.m.getVisibility() == 0) {
                f();
            }
        } catch (Exception e2) {
            o0.b(MBridgeBaseView.TAG, e2.getMessage());
        }
    }

    public void setPlayURL(String str) {
        this.K = str;
    }

    public void setPlayerViewAttachListener(u uVar) {
        this.v = uVar;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void setScaleFitXY(int i2) {
        this.f0 = i2;
    }

    public void setShowingAlertViewCover(boolean z) {
        MBAcquireRewardPopView mBAcquireRewardPopView;
        if (z && (mBAcquireRewardPopView = this.E0) != null && this.J && this.I) {
            mBAcquireRewardPopView.onPause();
        }
        this.mPlayerView.setIsCovered(z);
    }

    public void setShowingTransparent(boolean z) {
        this.e0 = z;
    }

    public void setSoundState(int i2) {
        this.h0 = i2;
    }

    public void setUnitId(String str) {
        this.Q = str;
        w wVar = this.N0;
        if (wVar != null) {
            wVar.a(str);
        }
    }

    public void setVideoEvents(MediaEvents mediaEvents) {
        this.j0 = mediaEvents;
        w wVar = this.N0;
        if (wVar != null) {
            wVar.f = mediaEvents;
        }
        PlayerView playerView = this.mPlayerView;
        if (playerView != null) {
            playerView.setVideoEvents(mediaEvents);
        }
    }

    public void setVideoLayout(CampaignEx campaignEx) {
        if (campaignEx != null) {
            this.b = campaignEx;
            this.h = campaignEx.isDynamicView();
        }
        if (this.h) {
            a(this, campaignEx);
        } else {
            h();
        }
    }

    public void setVideoSkipTime(int i2) {
        this.L = i2;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void setVisible(int i2) {
        setVisibility(i2);
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void showAlertView() {
        CampaignEx campaignEx;
        if (this.W) {
            return;
        }
        if (this.P == null) {
            this.P = new s();
        }
        if (this.O == null) {
            MBAlertDialog mBAlertDialog = new MBAlertDialog(getContext(), this.P);
            this.O = mBAlertDialog;
            AdSession adSession = this.i0;
            if (adSession != null) {
                adSession.addFriendlyObstruction(mBAlertDialog.getWindow().getDecorView(), FriendlyObstructionPurpose.NOT_VISIBLE, null);
            }
        }
        if (this.g0) {
            this.O.makeIVAlertView(this.l0, this.Q);
        } else {
            this.O.makeRVAlertView(this.Q);
        }
        PlayerView playerView = this.mPlayerView;
        if (playerView != null) {
            if (playerView.isComplete() && ((campaignEx = this.b) == null || campaignEx.getRewardTemplateMode() == null || this.b.getRewardTemplateMode().f() != 5002010)) {
                return;
            }
            this.O.show();
            this.o0 = true;
            this.I = true;
            setShowingAlertViewCover(true);
            String strC = com.mbridge.msdk.videocommon.setting.b.b().a(com.mbridge.msdk.foundation.controller.c.m().b(), this.Q, false).c();
            this.k0 = strC;
            com.mbridge.msdk.foundation.same.report.j.a(this.f5779a, this.b, strC, this.Q, 1, 1);
        }
    }

    public void showBaitClickView() {
        int i2;
        MBridgeBaitClickView mBridgeBaitClickView;
        CampaignEx campaignEx = this.b;
        if (campaignEx == null || !campaignEx.isDynamicView() || this.b.getRewardTemplateMode() == null) {
            return;
        }
        String strE = this.b.getRewardTemplateMode().e();
        if (TextUtils.isEmpty(strE)) {
            return;
        }
        try {
            String strA = z0.a(strE, "bait_click");
            if (TextUtils.isEmpty(strA) || (i2 = Integer.parseInt(strA)) == 0 || (mBridgeBaitClickView = this.y0) == null) {
                return;
            }
            mBridgeBaitClickView.setVisibility(0);
            this.y0.init(i2);
            this.y0.startAnimation();
            this.y0.setOnClickListener(new i());
        } catch (Exception e2) {
            o0.b(MBridgeBaseView.TAG, e2.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void showIVRewardAlertView(String str) {
        this.notifyListener.a(8, "");
    }

    public void showMoreOfferInPlayTemplate() {
        CampaignEx campaignEx = this.b;
        if (campaignEx == null || this.G == null || !campaignEx.isDynamicView() || this.b.getRewardTemplateMode() == null) {
            return;
        }
        String strE = this.b.getRewardTemplateMode().e();
        if (TextUtils.isEmpty(strE)) {
            return;
        }
        try {
            String strA = z0.a(strE, "mof");
            if (TextUtils.isEmpty(strA) || Integer.parseInt(strA) != 1) {
                return;
            }
            com.mbridge.msdk.video.dynview.moffer.a.a().a(this.b, this, new com.mbridge.msdk.video.module.listener.impl.i(this.u), 1);
        } catch (Exception e2) {
            o0.b(MBridgeBaseView.TAG, e2.getMessage());
        }
    }

    public void showRewardPopView() {
        AcquireRewardPopViewParameters acquireRewardPopViewParameters;
        MBAcquireRewardPopView mBAcquireRewardPopView = this.E0;
        if (mBAcquireRewardPopView == null || (acquireRewardPopViewParameters = this.D0) == null) {
            return;
        }
        try {
            mBAcquireRewardPopView.init(acquireRewardPopViewParameters);
            this.E0.setVisibility(0);
            setCover(true);
            o();
            this.J = true;
            CampaignEx campaignEx = this.b;
            if (campaignEx != null) {
                campaignEx.isRewardPopViewShowed = true;
            }
        } catch (Exception e2) {
            o0.b(MBridgeBaseView.TAG, e2.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void showVideoLocation(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        float f2;
        if (this.e) {
            this.o.setPadding(0, 0, 0, 0);
            setVisibility(0);
            if (this.o.getVisibility() != 0) {
                this.o.setVisibility(0);
            }
            if (this.m.getVisibility() == 0) {
                f();
            }
            if (!b(i4, i5) || this.T) {
                u();
                return;
            }
            S0 = i7;
            T0 = i8;
            U0 = i9 + 4;
            V0 = i10 + 4;
            float f3 = i4 / i5;
            try {
                f2 = (float) (this.R / this.S);
            } catch (Throwable th) {
                o0.b(MBridgeBaseView.TAG, th.getMessage(), th);
                f2 = 0.0f;
            }
            if (i6 > 0) {
                R0 = i6;
                setPlayerViewRadius(i6);
            }
            if (Math.abs(f3 - f2) > 0.1f && this.f0 != 1) {
                u();
                SpecialsBridge.MBridgeVideoView_videoOperate(this, 1);
                return;
            }
            u();
            if (!this.e0) {
                setLayoutParam(i3, i2, i4, i5);
                return;
            }
            setLayoutCenter(i4, i5);
            if (W0) {
                this.notifyListener.a(114, "");
            } else {
                this.notifyListener.a(116, "");
            }
        }
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void soundOperate(int i2, int i3) {
        soundOperate(i2, i3, "2");
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void videoOperate(int i2) {
        o0.a(MBridgeBaseView.TAG, "VideoView videoOperate:" + i2);
        if (this.e) {
            if (i2 == 1) {
                if (getVisibility() == 0 && isfront()) {
                    o0.a(MBridgeBaseView.TAG, "VideoView videoOperate:play");
                    RelativeLayout relativeLayout = this.I0;
                    if ((relativeLayout != null && relativeLayout.getVisibility() != 0) || this.I || com.mbridge.msdk.foundation.feedback.b.f) {
                        return;
                    }
                    if (!com.mbridge.msdk.util.b.a()) {
                        p();
                        return;
                    } else {
                        if (this.W || this.F0) {
                            return;
                        }
                        p();
                        return;
                    }
                }
                return;
            }
            if (i2 == 2) {
                if (getVisibility() == 0 && isfront()) {
                    o0.a(MBridgeBaseView.TAG, "VideoView videoOperate:pause");
                    o();
                    return;
                }
                return;
            }
            if (i2 == 3) {
                if (this.V) {
                    return;
                }
                this.mPlayerView.stop();
                CampaignEx campaignEx = this.b;
                if (campaignEx == null || campaignEx.getRewardTemplateMode() == null || this.b.getRewardTemplateMode().f() != 5002010) {
                    this.mPlayerView.release();
                    this.V = true;
                    if (TextUtils.isEmpty(this.K)) {
                        return;
                    }
                    com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                    long jCurrentTimeMillis = X0;
                    if (jCurrentTimeMillis != 0) {
                        jCurrentTimeMillis = System.currentTimeMillis() - X0;
                    }
                    eVar.a("duration", Long.valueOf(jCurrentTimeMillis));
                    com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000146", this.b, eVar);
                    return;
                }
                return;
            }
            if (i2 == 5) {
                if (com.mbridge.msdk.util.b.a()) {
                    this.F0 = true;
                    if (this.V) {
                        return;
                    }
                    o();
                    return;
                }
                return;
            }
            if (i2 == 4) {
                if (com.mbridge.msdk.util.b.a()) {
                    this.F0 = false;
                    if (this.V || isMiniCardShowing()) {
                        return;
                    }
                    p();
                    return;
                }
                return;
            }
            if (i2 != 6 || this.V) {
                return;
            }
            this.mPlayerView.release();
            this.V = true;
            if (TextUtils.isEmpty(this.K)) {
                return;
            }
            com.mbridge.msdk.foundation.same.report.metrics.e eVar2 = new com.mbridge.msdk.foundation.same.report.metrics.e();
            long jCurrentTimeMillis2 = X0;
            if (jCurrentTimeMillis2 != 0) {
                jCurrentTimeMillis2 = System.currentTimeMillis() - X0;
            }
            eVar2.a("duration", Long.valueOf(jCurrentTimeMillis2));
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000146", this.b, eVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        w wVar;
        RelativeLayout relativeLayout;
        try {
            CampaignEx campaignEx = this.b;
            if (campaignEx == null || campaignEx.getRewardTemplateMode() == null || this.b.getRewardTemplateMode().f() != 5002010 || (relativeLayout = this.I0) == null || relativeLayout.getVisibility() == 0) {
                if (!this.U) {
                    boolean zPlayVideo = this.mPlayerView.playVideo();
                    CampaignEx campaignEx2 = this.b;
                    if (campaignEx2 != null && campaignEx2.getPlayable_ads_without_video() != 2 && !zPlayVideo && (wVar = this.N0) != null) {
                        wVar.onPlayError("play video failed");
                    }
                    this.U = true;
                    return;
                }
                MBAcquireRewardPopView mBAcquireRewardPopView = this.E0;
                if (mBAcquireRewardPopView != null && this.J) {
                    mBAcquireRewardPopView.onResume();
                }
                if (this.J) {
                    return;
                }
                if (!com.mbridge.msdk.util.b.a()) {
                    w();
                } else {
                    if (this.F0 || this.I) {
                        return;
                    }
                    this.mPlayerView.setIsCovered(false);
                    w();
                }
            }
        } catch (Exception e2) {
            o0.b(MBridgeBaseView.TAG, e2.getMessage(), e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        String strE;
        CampaignEx campaignEx = this.b;
        if (campaignEx == null || !campaignEx.isDynamicView() || this.H) {
            return;
        }
        if (!TextUtils.isEmpty(this.b.getMof_template_url())) {
            strE = this.b.getMof_template_url();
        } else if (this.b.getRewardTemplateMode() == null) {
            return;
        } else {
            strE = this.b.getRewardTemplateMode().e();
        }
        if (TextUtils.isEmpty(strE)) {
            return;
        }
        try {
            String strA = z0.a(strE, "guideShow");
            String strA2 = z0.a(strE, "guideDelay");
            String strA3 = z0.a(strE, "guideTime");
            String strA4 = z0.a(strE, "guideRewardTime");
            if (!TextUtils.isEmpty(strA)) {
                this.z0 = Integer.parseInt(strA);
            }
            if (!TextUtils.isEmpty(strA2)) {
                int i2 = Integer.parseInt(strA2);
                this.A0 = i2;
                if (i2 > 10 || i2 < 3) {
                    this.A0 = 5;
                }
            }
            if (!TextUtils.isEmpty(strA3)) {
                int i3 = Integer.parseInt(strA3);
                this.B0 = i3;
                if (i3 > 10 || i3 < 3) {
                    this.B0 = 5;
                }
            }
            if (!TextUtils.isEmpty(strA4)) {
                int i4 = Integer.parseInt(strA4);
                this.C0 = i4;
                if (i4 > 10 || i4 < 5) {
                    this.C0 = 5;
                }
            }
            int i5 = this.z0;
            if (i5 > 0 && i5 <= 2) {
                int videoCompleteTime = getVideoCompleteTime();
                if (videoCompleteTime == 0 || videoCompleteTime > this.A0) {
                    int i6 = videoCompleteTime - this.A0;
                    if (i6 >= 0 && this.C0 > i6) {
                        this.C0 = i6;
                    }
                    int videoAllDuration = getVideoAllDuration();
                    if (this.C0 >= videoAllDuration) {
                        this.C0 = videoAllDuration - this.A0;
                    }
                    if (this.A0 >= videoAllDuration) {
                        return;
                    }
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(this.b.getAppName());
                    com.mbridge.msdk.setting.g gVarB = com.mbridge.msdk.setting.h.b().b(com.mbridge.msdk.foundation.controller.c.m().b());
                    this.D0 = new AcquireRewardPopViewParameters.Builder("", this.Q, this.z0, gVarB != null ? gVarB.k() : "US").setAutoDismissTime(this.B0).setReduceTime(this.C0).setBehaviourListener(new j()).setRightAnswerList(arrayList).build();
                    postDelayed(this.Q0, 1000L);
                }
            }
        } catch (Throwable th) {
            o0.b(MBridgeBaseView.TAG, th.getMessage());
        }
    }

    private void r() {
        CampaignEx campaignEx = this.b;
        if (campaignEx == null || campaignEx.getAdSpaceT() != 2 || this.tvFlag == null) {
            return;
        }
        String language = Locale.getDefault().getLanguage();
        if (TextUtils.isEmpty(language) || !language.equals("zh")) {
            this.tvFlag.setText("AD");
        } else {
            this.tvFlag.setText("广告");
        }
    }

    private void s() {
        int iB;
        int iF;
        float fG = t0.g(this.f5779a);
        float f2 = t0.f(this.f5779a);
        double d2 = this.R;
        if (d2 > 0.0d) {
            double d3 = this.S;
            if (d3 > 0.0d && fG > 0.0f && f2 > 0.0f) {
                double d4 = d2 / d3;
                double d5 = fG / f2;
                o0.c(MBridgeBaseView.TAG, "videoWHDivide:" + d4 + "  screenWHDivide:" + d5);
                double dA = t0.a(Double.valueOf(d4));
                double dA2 = t0.a(Double.valueOf(d5));
                o0.c(MBridgeBaseView.TAG, "videoWHDivideFinal:" + dA + "  screenWHDivideFinal:" + dA2);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mPlayerView.getLayoutParams();
                if (dA > dA2) {
                    double d6 = (((double) fG) * this.S) / this.R;
                    layoutParams.width = -1;
                    layoutParams.height = (int) d6;
                    layoutParams.gravity = 17;
                } else if (dA < dA2) {
                    layoutParams.width = (int) (((double) f2) * d4);
                    layoutParams.height = -1;
                    layoutParams.gravity = 17;
                } else {
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                }
                try {
                    CampaignEx campaignEx = this.b;
                    if (campaignEx != null && campaignEx.isDynamicView()) {
                        if (this.b.getRewardTemplateMode() != null) {
                            iF = this.b.getRewardTemplateMode().f();
                            iB = this.b.getRewardTemplateMode().b();
                        } else {
                            iB = this.f5779a.getResources().getConfiguration().orientation;
                            iF = 904;
                        }
                        if (iF == 102 || iF == 202) {
                            if (iB == 1) {
                                layoutParams.width = -1;
                                layoutParams.gravity = 17;
                                layoutParams.height = (int) (this.S / (this.R / ((double) fG)));
                            } else {
                                layoutParams.height = -1;
                                layoutParams.gravity = 17;
                                layoutParams.width = (int) (((double) f2) * d4);
                            }
                        }
                        if (iF == 202 && !TextUtils.isEmpty(this.b.getImageUrl())) {
                            setBlurBackgroundImage(this.b.getImageUrl());
                        }
                        if (iF == 302 || iF == 802 || iF == 5002010) {
                            double d7 = this.R;
                            double d8 = this.S;
                            if (d7 / d8 > 1.0d) {
                                layoutParams.width = -1;
                                layoutParams.height = (int) ((d8 * ((double) fG)) / d7);
                            } else {
                                int iA = t0.a(getContext(), 220.0f);
                                layoutParams.width = (int) ((this.R * ((double) iA)) / this.S);
                                layoutParams.height = iA;
                            }
                        }
                    }
                } catch (Throwable th) {
                    o0.b(MBridgeBaseView.TAG, th.getMessage());
                }
                this.mPlayerView.setLayoutParams(layoutParams);
                setMatchParent();
                return;
            }
        }
        v();
    }

    private void u() {
        CampaignEx campaignEx = this.b;
        if (campaignEx == null) {
            return;
        }
        if (campaignEx.getAdSpaceT() == 2) {
            t();
        } else {
            s();
        }
    }

    private void v() {
        try {
            setLayoutParam(0, 0, -1, -1);
            if (isLandscape() || !this.e) {
                return;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mPlayerView.getLayoutParams();
            int iG = t0.g(this.f5779a);
            layoutParams.width = -1;
            layoutParams.height = (iG * 9) / 16;
            layoutParams.gravity = 17;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void w() {
        if (this.s0) {
            if (!this.t0) {
                this.mPlayerView.seekToEndFrame();
            }
            this.t0 = true;
        } else {
            this.mPlayerView.onResume();
        }
        CampaignEx campaignEx = this.b;
        if (campaignEx == null || campaignEx.isRewardPopViewShowed) {
            return;
        }
        post(this.Q0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (!this.e || this.n.getVisibility() == 0) {
            return;
        }
        if (!this.h || this.A) {
            this.n.setVisibility(0);
        }
        this.a0 = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        int i2;
        com.mbridge.msdk.video.module.listener.a aVar;
        boolean z;
        try {
            CampaignEx campaignEx = this.b;
            if (campaignEx != null && campaignEx.getRewardTemplateMode() != null && this.b.getRewardTemplateMode().f() == 5002010 && this.L0 && !(z = this.s0)) {
                com.mbridge.msdk.video.module.listener.a aVar2 = this.notifyListener;
                if (aVar2 != null) {
                    this.L0 = true;
                    aVar2.a(2, c(z));
                    return;
                }
                return;
            }
            if (!this.g0 || ((i2 = this.l0) != com.mbridge.msdk.foundation.same.a.H && i2 != com.mbridge.msdk.foundation.same.a.I)) {
                CampaignEx campaignEx2 = this.b;
                if (campaignEx2 == null || campaignEx2.getAdSpaceT() == 2) {
                    com.mbridge.msdk.video.module.listener.a aVar3 = this.notifyListener;
                    if (aVar3 != null) {
                        this.L0 = true;
                        aVar3.a(2, "");
                        return;
                    }
                    return;
                }
                boolean zM = m();
                if (zM && this.N == 1 && !this.e0) {
                    o();
                    com.mbridge.msdk.video.module.listener.a aVar4 = this.notifyListener;
                    if (aVar4 != null) {
                        aVar4.a(8, "");
                        return;
                    }
                    return;
                }
                if (this.notifyListener != null) {
                    this.L0 = true;
                    if (this.b.getAdType() == 94 && !zM) {
                        this.notifyListener.a(17, "");
                    }
                    this.notifyListener.a(2, c(!zM));
                    return;
                }
                return;
            }
            if (this.o0) {
                if (i2 != com.mbridge.msdk.foundation.same.a.I || (aVar = this.notifyListener) == null) {
                    return;
                }
                this.L0 = true;
                aVar.a(2, c(this.s0));
                return;
            }
            if (i2 == com.mbridge.msdk.foundation.same.a.I && this.v0) {
                com.mbridge.msdk.video.module.listener.a aVar5 = this.notifyListener;
                if (aVar5 != null) {
                    this.L0 = true;
                    aVar5.a(2, c(this.s0));
                    return;
                }
                return;
            }
            if (this.r0) {
                int curPosition = this.mPlayerView.getCurPosition() / 1000;
                int videoLength = (int) ((curPosition / (this.mPlayerView.getDuration() == 0 ? this.b.getVideoLength() : this.mPlayerView.getDuration())) * 100.0f);
                if (this.l0 == com.mbridge.msdk.foundation.same.a.H) {
                    o();
                    int i3 = this.m0;
                    if (i3 == com.mbridge.msdk.foundation.same.a.J && videoLength >= this.n0) {
                        com.mbridge.msdk.video.module.listener.a aVar6 = this.notifyListener;
                        if (aVar6 != null) {
                            this.L0 = true;
                            aVar6.a(2, c(this.s0));
                            return;
                        }
                        return;
                    }
                    if (i3 == com.mbridge.msdk.foundation.same.a.K && curPosition >= this.n0) {
                        com.mbridge.msdk.video.module.listener.a aVar7 = this.notifyListener;
                        if (aVar7 != null) {
                            this.L0 = true;
                            aVar7.a(2, c(this.s0));
                            return;
                        }
                        return;
                    }
                    com.mbridge.msdk.video.module.listener.a aVar8 = this.notifyListener;
                    if (aVar8 != null) {
                        aVar8.a(8, "");
                    }
                }
                if (this.l0 == com.mbridge.msdk.foundation.same.a.I) {
                    int i4 = this.m0;
                    if (i4 == com.mbridge.msdk.foundation.same.a.J && videoLength >= this.n0) {
                        o();
                        com.mbridge.msdk.video.module.listener.a aVar9 = this.notifyListener;
                        if (aVar9 != null) {
                            aVar9.a(8, "");
                            return;
                        }
                        return;
                    }
                    if (i4 != com.mbridge.msdk.foundation.same.a.K || curPosition < this.n0) {
                        return;
                    }
                    o();
                    com.mbridge.msdk.video.module.listener.a aVar10 = this.notifyListener;
                    if (aVar10 != null) {
                        aVar10.a(8, "");
                    }
                }
            }
        } catch (Exception e2) {
            o0.b(MBridgeBaseView.TAG, e2.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void soundOperate(int i2, int i3, String str) {
        com.mbridge.msdk.video.module.listener.a aVar;
        SoundImageView soundImageView;
        if (this.e) {
            this.h0 = i2;
            if (i2 == 1) {
                this.D.getJSCommon().g(i2);
                SoundImageView soundImageView2 = this.mSoundImageView;
                if (soundImageView2 != null) {
                    soundImageView2.setSoundStatus(false);
                }
                this.mPlayerView.closeSound();
                try {
                    MediaEvents mediaEvents = this.j0;
                    if (mediaEvents != null) {
                        mediaEvents.volumeChange(0.0f);
                        o0.a("omsdk", "play video view:  mute");
                    }
                } catch (Exception e2) {
                    o0.a(POBOMSDKUtil.TAG, e2.getMessage());
                }
            } else if (i2 == 2) {
                this.D.getJSCommon().g(i2);
                SoundImageView soundImageView3 = this.mSoundImageView;
                if (soundImageView3 != null) {
                    soundImageView3.setSoundStatus(true);
                }
                this.mPlayerView.openSound();
                try {
                    MediaEvents mediaEvents2 = this.j0;
                    if (mediaEvents2 != null) {
                        mediaEvents2.volumeChange(1.0f);
                        o0.a("omsdk", "play video view:  unmute");
                    }
                } catch (Exception e3) {
                    o0.a(POBOMSDKUtil.TAG, e3.getMessage());
                }
            }
            CampaignEx campaignEx = this.b;
            if (campaignEx != null && campaignEx.isDynamicView()) {
                SoundImageView soundImageView4 = this.mSoundImageView;
                if (soundImageView4 != null) {
                    soundImageView4.setVisibility(0);
                }
            } else if (i3 == 1) {
                SoundImageView soundImageView5 = this.mSoundImageView;
                if (soundImageView5 != null) {
                    soundImageView5.setVisibility(8);
                }
            } else if (i3 == 2 && (soundImageView = this.mSoundImageView) != null) {
                soundImageView.setVisibility(0);
            }
        }
        if (str == null || !str.equals("2") || (aVar = this.notifyListener) == null) {
            return;
        }
        aVar.a(7, Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(boolean z) {
        if (!this.g0) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (!this.o0) {
                jSONObject.put("Alert_window_status", com.mbridge.msdk.foundation.same.a.F);
            }
            if (this.q0) {
                jSONObject.put("Alert_window_status", com.mbridge.msdk.foundation.same.a.D);
            }
            if (this.p0) {
                jSONObject.put("Alert_window_status", com.mbridge.msdk.foundation.same.a.E);
            }
            jSONObject.put("complete_info", z ? 1 : 2);
            return jSONObject.toString();
        } catch (Exception unused) {
            o0.b(MBridgeBaseView.TAG, "getIVRewardStatusString ERROR");
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        CampaignEx campaignEx = this.b;
        if (campaignEx != null) {
            campaignEx.setCampaignUnitId(this.Q);
            com.mbridge.msdk.foundation.feedback.b.b().a(this.Q + "_1", this.b);
        }
        if (com.mbridge.msdk.foundation.feedback.b.b().a()) {
            if (this.r != null) {
                com.mbridge.msdk.foundation.feedback.b.b().a(this.Q + "_1", this.r);
            }
        } else {
            FeedBackButton feedBackButton = this.r;
            if (feedBackButton != null) {
                feedBackButton.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        CollapsibleWebView collapsibleWebView = this.H0;
        if (collapsibleWebView == null || this.b == null || !TextUtils.isEmpty(collapsibleWebView.getUrl())) {
            return;
        }
        this.H0.loadUrl(this.b.getClickURL());
        this.H0.setToolBarTitle(this.b.getAppName());
        com.mbridge.msdk.setting.g gVarD = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
        if (gVarD == null) {
            gVarD = com.mbridge.msdk.setting.h.b().a();
        }
        this.H0.setPageLoadTimtout((int) gVarD.o0());
        this.H0.setPageLoadListener(new d());
        this.H0.setWebViewClient(new e());
        this.H0.setCollapseListener(new f());
        this.H0.setExpandListener(new g());
        this.H0.setExitsClickListener(new h());
    }

    private void h() {
        int iFindLayout = findLayout("mbridge_reward_videoview_item");
        if (g0.a(iFindLayout)) {
            this.c.inflate(iFindLayout, this);
            n();
        }
        W0 = false;
        r();
    }

    private void i() {
        if (this.O0 || this.d0 || this.b0) {
            return;
        }
        this.O0 = true;
        int i2 = this.L;
        if (i2 < 0) {
            return;
        }
        if (i2 == 0) {
            this.d0 = true;
        } else {
            new Handler().postDelayed(new a(), this.L * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        CampaignEx campaignEx = this.b;
        if (campaignEx == null || !campaignEx.isDynamicView() || this.B == null) {
            return;
        }
        if (this.C == null) {
            addCTAView();
        }
        if (this.B.getVisibility() != 0) {
            this.B.setVisibility(0);
            postDelayed(this.P0, 3000L);
        } else {
            this.B.setVisibility(8);
            getHandler().removeCallbacks(this.P0);
        }
    }

    private void k() {
        CampaignEx campaignEx = this.b;
        if (campaignEx == null || !y0.b(campaignEx.getVideoResolution())) {
            return;
        }
        String videoResolution = this.b.getVideoResolution();
        o0.c(MBridgeBaseView.TAG, "MBridgeBaseView videoResolution:" + videoResolution);
        String[] strArrSplit = videoResolution.split(VastAttributes.HORIZONTAL_POSITION);
        if (strArrSplit.length == 2) {
            if (t0.m(strArrSplit[0]) > 0.0d) {
                this.R = t0.m(strArrSplit[0]);
            }
            if (t0.m(strArrSplit[1]) > 0.0d) {
                this.S = t0.m(strArrSplit[1]);
            }
            o0.c(MBridgeBaseView.TAG, "MBridgeBaseView mVideoW:" + this.R + "  mVideoH:" + this.S);
        }
        if (this.R <= 0.0d) {
            this.R = 1280.0d;
        }
        if (this.S <= 0.0d) {
            this.S = 720.0d;
        }
    }

    private boolean l() {
        try {
            this.mPlayerView = (PlayerView) findViewById(filterFindViewId(this.w0, "mbridge_vfpv"));
            this.mSoundImageView = (SoundImageView) findViewById(filterFindViewId(this.w0, "mbridge_sound_switch"));
            this.m = (TextView) findViewById(filterFindViewId(this.w0, "mbridge_tv_count"));
            View viewFindViewById = findViewById(filterFindViewId(this.w0, "mbridge_rl_playing_close"));
            this.n = viewFindViewById;
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(4);
            }
            this.o = (RelativeLayout) findViewById(filterFindViewId(this.w0, "mbridge_top_control"));
            this.p = (ImageView) findViewById(filterFindViewId(this.w0, "mbridge_videoview_bg"));
            this.q = (ProgressBar) findViewById(filterFindViewId(this.w0, "mbridge_video_progress_bar"));
            this.r = (FeedBackButton) findViewById(filterFindViewId(this.w0, "mbridge_native_endcard_feed_btn"));
            this.s = (ImageView) findViewById(filterFindViewId(this.w0, "mbridge_iv_link"));
            this.G0 = (RelativeLayout) findViewById(filterFindViewId(this.w0, "mbridge_reward_scale_webview_layout"));
            this.I0 = (RelativeLayout) findViewById(filterFindViewId(this.w0, "mbridge_reward_header_layout"));
            if (this.G0 != null) {
                CollapsibleWebView collapsibleWebView = new CollapsibleWebView(getContext());
                this.H0 = collapsibleWebView;
                this.G0.addView(collapsibleWebView, new RelativeLayout.LayoutParams(-1, -1));
            }
            t0.a(1, this.s, this.b, this.f5779a, false, new t());
            this.t = (MBridgeSegmentsProgressBar) findViewById(filterFindViewId(this.w0, "mbridge_reward_segment_progressbar"));
            this.B = (FrameLayout) findViewById(filterFindViewId(this.w0, "mbridge_reward_cta_layout"));
            this.y0 = (MBridgeBaitClickView) findViewById(filterFindViewId(this.w0, "mbridge_animation_click_view"));
            this.G = (RelativeLayout) findViewById(filterFindViewId(this.w0, "mbridge_reward_moreoffer_layout"));
            this.E0 = (MBAcquireRewardPopView) findViewById(filterFindViewId(this.w0, "mbridge_reward_popview"));
            this.tvFlag = (TextView) findViewById(filterFindViewId(this.w0, "mbridge_tv_flag"));
            return isNotNULL(this.mPlayerView, this.mSoundImageView, this.m, this.n);
        } catch (Throwable th) {
            o0.b(MBridgeBaseView.TAG, th.getMessage(), th);
            return false;
        }
    }

    private boolean m() {
        int videoCompleteTime = getVideoCompleteTime();
        int curPosition = (this.mPlayerView.getCurPosition() / 1000) + 1;
        if (this.b.getDynamicTempCode() != 5 || this.mCurrPlayNum <= 1) {
            if ((videoCompleteTime > 0 && curPosition < videoCompleteTime) || videoCompleteTime == 0) {
                return true;
            }
        } else if (videoCompleteTime != 0 && videoCompleteTime > 0 && curPosition < videoCompleteTime) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        PlayerView playerView;
        boolean zL = l();
        this.e = zL;
        if (!zL) {
            o0.b(MBridgeBaseView.TAG, "MBridgeVideoView init fail");
        }
        if (q0.a().a("i_l_s_t_r_i", false) && (playerView = this.mPlayerView) != null) {
            playerView.setNotifyListener(new n());
        }
        d();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 100.0f);
        this.x0 = alphaAnimation;
        alphaAnimation.setDuration(200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        try {
            PlayerView playerView = this.mPlayerView;
            if (playerView != null) {
                playerView.onPause();
                CampaignEx campaignEx = this.b;
                if (campaignEx != null && !campaignEx.isRewardPopViewShowed) {
                    removeCallbacks(this.Q0);
                }
                if (com.mbridge.msdk.util.b.a()) {
                    this.mPlayerView.setIsCovered(this.F0 || this.I || this.J);
                }
                CampaignEx campaignEx2 = this.b;
                if (campaignEx2 == null || campaignEx2.getNativeVideoTracking() == null || this.b.isHasReportAdTrackPause()) {
                    return;
                }
                this.b.setHasReportAdTrackPause(true);
                Context contextD = com.mbridge.msdk.foundation.controller.c.m().d();
                CampaignEx campaignEx3 = this.b;
                com.mbridge.msdk.click.a.a(contextD, campaignEx3, this.Q, campaignEx3.getNativeVideoTracking().n(), false, false);
            }
        } catch (Throwable th) {
            o0.b(MBridgeBaseView.TAG, th.getMessage(), th);
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    protected void d() {
        super.d();
        if (this.e) {
            if (this.h) {
                if (com.mbridge.msdk.video.dynview.util.a.b(this.b) == -1 || com.mbridge.msdk.video.dynview.util.a.b(this.b) == 100) {
                    this.mPlayerView.setOnClickListener(new o());
                }
            } else {
                this.mPlayerView.setOnClickListener(new p());
            }
            SoundImageView soundImageView = this.mSoundImageView;
            if (soundImageView != null) {
                soundImageView.setOnClickListener(new q());
            }
            this.n.setOnClickListener(new r());
        }
    }

    private boolean b(int i2, int i3) {
        return i2 > 0 && i3 > 0 && t0.g(this.f5779a) >= i2 && t0.f(this.f5779a) >= i3;
    }

    private void a(ViewGroup viewGroup, CampaignEx campaignEx) {
        com.mbridge.msdk.video.dynview.c cVarB = new com.mbridge.msdk.video.dynview.wrapper.c().b(viewGroup, campaignEx);
        com.mbridge.msdk.video.dynview.b.a().a(cVarB, new l(viewGroup, cVarB));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        JSONException e2;
        JSONObject jSONObject;
        if (this.u != null) {
            CampaignEx campaignEx = this.b;
            if (campaignEx != null) {
                campaignEx.setClickTempSource(1);
                try {
                    CampaignEx.c rewardTemplateMode = this.b.getRewardTemplateMode();
                    com.mbridge.msdk.foundation.same.report.j.a(this.f5779a, str, this.b.getCampaignUnitId(), this.b.isBidCampaign(), this.b.getRequestId(), this.b.getRequestIdNotice(), this.b.getId(), rewardTemplateMode != null ? rewardTemplateMode.f() + "" : "");
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            try {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put(com.mbridge.msdk.foundation.same.a.j, a(0));
                } catch (JSONException e4) {
                    e2 = e4;
                    e2.printStackTrace();
                }
            } catch (JSONException e5) {
                e2 = e5;
                jSONObject = null;
            }
            this.u.a(105, jSONObject);
            if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                try {
                    com.mbridge.msdk.video.module.report.b.a(com.mbridge.msdk.foundation.controller.c.m().d().getApplicationContext(), this.b);
                } catch (Exception e6) {
                    o0.b(MBridgeBaseView.TAG, e6.getMessage());
                }
            }
        }
    }

    private String a(int i2, int i3) {
        if (i3 != 0) {
            try {
                return t0.a(Double.valueOf(i2 / i3)) + "";
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return i3 + "";
    }

    private int a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            if (campaignEx.getReady_rate() != -1) {
                return campaignEx.getReady_rate();
            }
            return com.mbridge.msdk.videocommon.setting.b.b().a(com.mbridge.msdk.foundation.controller.c.m().b(), this.Q, false).w();
        }
        return com.mbridge.msdk.videocommon.setting.b.b().a(com.mbridge.msdk.foundation.controller.c.m().b(), this.Q, false).w();
    }

    class l implements com.mbridge.msdk.video.dynview.listener.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f5828a;
        final /* synthetic */ com.mbridge.msdk.video.dynview.c b;

        class a extends com.mbridge.msdk.widget.a {
            a() {
            }

            @Override // com.mbridge.msdk.widget.a
            protected void a(View view) {
                if (view instanceof TextView) {
                    MBridgeVideoView.this.b.setTriggerClickSource(1);
                } else {
                    MBridgeVideoView.this.b.setTriggerClickSource(2);
                }
                if (MBridgeVideoView.this.b.getRewardTemplateMode() == null || MBridgeVideoView.this.b.getRewardTemplateMode().f() != 902) {
                    MBridgeVideoView.this.b("video_play_click");
                } else {
                    MBridgeVideoView.this.j();
                }
            }
        }

        l(ViewGroup viewGroup, com.mbridge.msdk.video.dynview.c cVar) {
            this.f5828a = viewGroup;
            this.b = cVar;
        }

        @Override // com.mbridge.msdk.video.dynview.listener.h
        public void a(com.mbridge.msdk.video.dynview.a aVar) {
            if (aVar != null) {
                if (this.f5828a != null && aVar.b() != null) {
                    aVar.b().setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                    this.f5828a.addView(aVar.b());
                }
                if (aVar.a() != null) {
                    Iterator<View> it = aVar.a().iterator();
                    while (it.hasNext()) {
                        it.next().setOnClickListener(new a());
                    }
                }
                MBridgeVideoView.this.w0 = aVar.c();
                MBridgeVideoView.this.n();
                boolean unused = MBridgeVideoView.W0 = false;
                MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                CampaignEx campaignEx = mBridgeVideoView.b;
                if (campaignEx != null) {
                    campaignEx.setTemplateRenderSucc(mBridgeVideoView.w0);
                }
                MBridgeVideoView.this.E = this.b.j();
                MBridgeVideoView.this.F = this.b.e();
            }
        }

        @Override // com.mbridge.msdk.video.dynview.listener.h
        public void a(com.mbridge.msdk.video.dynview.error.a aVar) {
            o0.b(MBridgeBaseView.TAG, "errorMsg：" + aVar.b());
        }
    }

    public MBridgeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCampaignSize = 1;
        this.mCurrPlayNum = 1;
        this.mCurrentPlayProgressTime = 0;
        this.mMuteSwitch = 0;
        this.w = false;
        this.z = 0;
        this.H = false;
        this.I = false;
        this.J = false;
        this.Q = "";
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.a0 = false;
        this.b0 = false;
        this.c0 = false;
        this.d0 = false;
        this.e0 = false;
        this.g0 = false;
        this.h0 = 2;
        this.o0 = false;
        this.p0 = false;
        this.q0 = false;
        this.r0 = true;
        this.s0 = false;
        this.t0 = false;
        this.u0 = false;
        this.v0 = false;
        this.w0 = false;
        this.z0 = 0;
        this.A0 = 5;
        this.B0 = 5;
        this.C0 = 5;
        this.F0 = false;
        this.J0 = false;
        this.K0 = 0;
        this.L0 = false;
        this.M0 = false;
        this.N0 = new w(this);
        this.O0 = false;
        this.P0 = new k();
        this.Q0 = new m();
    }
}
