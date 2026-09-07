package com.mbridge.msdk.nativex.view;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.URLUtil;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.iab.omid.library.mmadbridge.adsession.AdEvents;
import com.iab.omid.library.mmadbridge.adsession.AdSession;
import com.iab.omid.library.mmadbridge.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.mmadbridge.adsession.media.InteractionType;
import com.iab.omid.library.mmadbridge.adsession.media.MediaEvents;
import com.iab.omid.library.mmadbridge.adsession.media.PlayerState;
import com.iab.omid.library.mmadbridge.adsession.media.Position;
import com.iab.omid.library.mmadbridge.adsession.media.VastProperties;
import com.json.cc;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.download.download.HTMLResourceManager;
import com.mbridge.msdk.foundation.download.download.ResourceManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.b1;
import com.mbridge.msdk.foundation.tools.g0;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.q0;
import com.mbridge.msdk.foundation.tools.s0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.tools.y0;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.nativex.view.mbfullview.BaseView;
import com.mbridge.msdk.nativex.view.mbfullview.MBridgeFullView;
import com.mbridge.msdk.nativex.view.mbfullview.MBridgeTopFullView;
import com.mbridge.msdk.out.BaseTrackingListener;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.out.OnMBMediaViewListener;
import com.mbridge.msdk.out.OnMBMediaViewListenerPlus;
import com.mbridge.msdk.playercommon.VideoPlayerStatusListener;
import com.mbridge.msdk.video.signal.communication.IRewardCommunication;
import com.mbridge.msdk.videocommon.view.MyImageView;
import com.mbridge.msdk.widget.MBAdChoice;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.internal.partials.MintegralNetworkBridge;
import com.safedk.android.utils.Logger;
import com.unity3d.mediation.LevelPlayAdError;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public abstract class BaseMBMediaView extends LinearLayout implements VideoPlayerStatusListener, IRewardCommunication {
    public static final int OPEN_FULLSCREEN_ON_VIDEO_TYPE_1_LANDING_PAGE = 1;
    public static final int OPEN_FULLSCREEN_ON_VIDEO_TYPE_2_NORMAL_FULLSCREEN = 2;
    public static final int OPEN_FULLSCREEN_ON_VIDEO_TYPE_3_NORMAL_FULLSCREEN_ENDCARD = 3;
    public static final int OPEN_FULLSCREEN_ON_VIDEO_TYPE_4_NORMAL_FULLSCREEN_LP = 4;
    public static final int OPEN_FULLSCREEN_ON_VIDEO_TYPE_6_SMALLVIDEO = 6;
    public static final String TAG = "BaseMBMediaView";
    public static final int WHAT_VIEW_FULL_SCREEN = 2;
    public static final int WHAT_VIEW_SMALL_SCREEN = 1;
    private static int n0 = 2;
    private static int o0 = 1;
    private WindVaneWebViewForNV A;
    private MyImageView B;
    private ProgressBar C;
    private View D;
    private BaseView E;
    private RelativeLayout F;
    private RelativeLayout G;
    private TextView H;
    private ProgressBar I;
    private RelativeLayout J;
    private int K;
    private Handler L;
    private CampaignEx M;
    private int N;
    private int O;
    private double P;
    private double Q;
    private int R;
    private int S;
    private w T;
    private SensorManager U;
    private Sensor V;
    private com.mbridge.msdk.videocommon.download.a W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5267a;
    private s a0;
    private boolean b;
    private OnMBMediaViewListener b0;
    private boolean c;
    private OnMBMediaViewListenerPlus c0;
    private boolean d;
    private int d0;
    private boolean e;
    private boolean e0;
    private boolean f;
    private boolean f0;
    private boolean g;
    private RelativeLayout g0;
    private boolean h;
    private ImageView h0;
    private volatile boolean i;
    private int i0;
    private volatile boolean j;
    private boolean j0;
    private boolean k;
    private Context k0;
    private boolean l;
    private boolean l0;
    private ArrayList<String> m;
    private Runnable m0;
    private ArrayList<String> n;
    private boolean o;
    private boolean p;
    private AdSession q;
    private AdEvents r;
    private MediaEvents s;
    private int t;
    protected boolean u;
    private MediaViewPlayerView v;
    private RelativeLayout w;
    private RelativeLayout x;
    private RelativeLayout y;
    private WindVaneWebViewForNV z;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseMBMediaView.this.l();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseMBMediaView.this.g();
        }
    }

    class c extends com.mbridge.msdk.widget.a {
        c() {
        }

        @Override // com.mbridge.msdk.widget.a
        protected void a(View view) {
            try {
                BaseMBMediaView.this.a(view.getContext());
                if (BaseMBMediaView.this.s != null) {
                    try {
                        BaseMBMediaView.this.s.adUserInteraction(InteractionType.CLICK);
                        o0.a("omsdk", "bmnv adUserInteraction click");
                    } catch (Exception e) {
                        o0.b("omsdk", e.getMessage());
                    }
                }
            } catch (Exception e2) {
                o0.b(BaseMBMediaView.TAG, e2.getMessage());
            }
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseMBMediaView.this.p = true;
            if (BaseMBMediaView.this.h) {
                TextView unused = BaseMBMediaView.this.H;
            }
        }
    }

    class e extends com.mbridge.msdk.nativex.listener.b {
        e() {
        }

        @Override // com.mbridge.msdk.nativex.listener.b
        public void a() {
            BaseMBMediaView.this.exitFullScreen();
        }
    }

    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.mbridge.msdk.nativex.view.mbfullview.a.a(BaseMBMediaView.this.getContext()).a(BaseMBMediaView.this.E, BaseMBMediaView.this.i);
                if (BaseMBMediaView.this.i0 == 0) {
                    BaseMBMediaView.this.O();
                } else {
                    BaseMBMediaView.this.P();
                }
                BaseMBMediaView.this.u();
                BaseMBMediaView.this.o();
                BaseMBMediaView.this.x();
                if (BaseMBMediaView.this.A != null) {
                    BaseMBMediaView.this.A.orientation(BaseMBMediaView.this.i);
                }
            } catch (Exception e) {
                o0.b(BaseMBMediaView.TAG, e.getMessage());
            }
        }
    }

    class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!BaseMBMediaView.this.h) {
                    BaseMBMediaView baseMBMediaView = BaseMBMediaView.this;
                    if (baseMBMediaView.a((View) baseMBMediaView)) {
                        BaseMBMediaView.this.a0();
                    } else {
                        BaseMBMediaView.this.A();
                    }
                }
                BaseMBMediaView.this.L.postDelayed(this, 300L);
            } catch (Exception e) {
                o0.b(BaseMBMediaView.TAG, e.getMessage());
            }
        }
    }

    static /* synthetic */ class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5275a;

        static {
            int[] iArr = new int[BaseView.a.values().length];
            f5275a = iArr;
            try {
                iArr[BaseView.a.FULL_MIDDLE_VIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5275a[BaseView.a.FULL_TOP_VIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    class j extends Handler {
        j() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object obj;
            if (message != null) {
                try {
                    int i = message.what;
                    if (i == 1) {
                        BaseMBMediaView.this.S();
                    } else if (i == 3 && (obj = message.obj) != null && (obj instanceof View)) {
                        if (BaseMBMediaView.this.a((View) obj)) {
                            BaseMBMediaView.this.E();
                        }
                    }
                } catch (Exception e) {
                    o0.b(BaseMBMediaView.TAG, e.getMessage());
                }
            }
        }
    }

    class k extends com.mbridge.msdk.widget.a {
        k() {
        }

        @Override // com.mbridge.msdk.widget.a
        protected void a(View view) {
            try {
                if (!BaseMBMediaView.this.h) {
                    BaseMBMediaView.this.L();
                }
                BaseMBMediaView.this.v.showSoundIndicator(true);
                BaseMBMediaView.this.v.showProgressView(true);
                if (BaseMBMediaView.this.d && !BaseMBMediaView.this.h && (BaseMBMediaView.this.D == null || BaseMBMediaView.this.D.getParent() == null)) {
                    if (!BaseMBMediaView.this.v.halfLoadingViewisVisible() && BaseMBMediaView.this.v.isPlaying()) {
                        BaseMBMediaView.this.a();
                        return;
                    }
                    o0.c(BaseMBMediaView.TAG, "is loading or no playing return;");
                    return;
                }
                if (BaseMBMediaView.this.h) {
                    o0.c(BaseMBMediaView.TAG, "fullScreenShowUI");
                    BaseMBMediaView.this.l();
                    return;
                }
                if (BaseMBMediaView.this.k0 != null) {
                    BaseMBMediaView baseMBMediaView = BaseMBMediaView.this;
                    baseMBMediaView.a(baseMBMediaView.k0);
                } else {
                    BaseMBMediaView.this.a(view.getContext());
                }
                if (BaseMBMediaView.this.s != null) {
                    try {
                        BaseMBMediaView.this.s.adUserInteraction(InteractionType.CLICK);
                        o0.a("omsdk", "mnv adUserInteraction click");
                    } catch (Exception e) {
                        o0.b("omsdk", e.getMessage());
                    }
                }
            } catch (Throwable th) {
                o0.b(BaseMBMediaView.TAG, th.getMessage(), th);
            }
        }
    }

    class l implements com.mbridge.msdk.foundation.same.image.c {

        class a extends com.mbridge.msdk.widget.a {
            a() {
            }

            @Override // com.mbridge.msdk.widget.a
            protected void a(View view) {
                if (BaseMBMediaView.this.k0 == null) {
                    BaseMBMediaView.this.a(view.getContext());
                } else {
                    BaseMBMediaView baseMBMediaView = BaseMBMediaView.this;
                    baseMBMediaView.a(baseMBMediaView.k0);
                }
            }
        }

        l() {
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            if (BaseMBMediaView.this.B == null || BaseMBMediaView.this.a0 != s.BIG_IMAGE) {
                return;
            }
            if (bitmap != null) {
                BaseMBMediaView.this.R = bitmap.getWidth();
                BaseMBMediaView.this.S = bitmap.getHeight();
                BaseMBMediaView.this.B.setImageUrl(str);
                BaseMBMediaView.this.B.setImageBitmap(bitmap);
            }
            BaseMBMediaView.this.B.setOnClickListener(new a());
        }
    }

    class m extends com.mbridge.msdk.widget.a {
        m() {
        }

        @Override // com.mbridge.msdk.widget.a
        protected void a(View view) {
            if (BaseMBMediaView.this.k0 != null) {
                BaseMBMediaView baseMBMediaView = BaseMBMediaView.this;
                baseMBMediaView.a(baseMBMediaView.k0);
            } else {
                BaseMBMediaView.this.a(view.getContext());
            }
            o0.c(BaseMBMediaView.TAG, "CLICK WEBVIEW LAYOUT ");
        }
    }

    class n implements NativeListener.NativeTrackingListener {
        n() {
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onDismissLoading(Campaign campaign) {
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onDownloadFinish(Campaign campaign) {
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onDownloadProgress(int i) {
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onDownloadStart(Campaign campaign) {
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onFinishRedirection(Campaign campaign, String str) {
            try {
                BaseMBMediaView.this.n();
                BaseMBMediaView.this.m();
                BaseMBMediaView.this.a(campaign, str);
            } catch (Exception e) {
                o0.b(BaseMBMediaView.TAG, e.getMessage());
            }
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public boolean onInterceptDefaultLoadingDialog() {
            return true;
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onRedirectionFailed(Campaign campaign, String str) {
            try {
                BaseMBMediaView.this.n();
                BaseMBMediaView.this.m();
                BaseMBMediaView.this.b(campaign, str);
            } catch (Exception e) {
                o0.b(BaseMBMediaView.TAG, e.getMessage());
            }
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onShowLoading(Campaign campaign) {
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onStartRedirection(Campaign campaign, String str) {
            try {
                BaseMBMediaView.this.Y();
                BaseMBMediaView.this.W();
                BaseMBMediaView.this.c(campaign, str);
            } catch (Exception e) {
                o0.b(BaseMBMediaView.TAG, e.getMessage());
            }
        }
    }

    class o implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5279a;

        o(String str) {
            this.f5279a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                BaseMBMediaView.this.I();
                BaseMBMediaView.this.c(this.f5279a);
                t0.a(BaseMBMediaView.this.M.getCampaignUnitId(), BaseMBMediaView.this.M, com.mbridge.msdk.foundation.same.a.x);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    o0.b(BaseMBMediaView.TAG, e.getMessage());
                }
            }
        }
    }

    class p extends MediaViewPlayerView.h {
        p(MediaViewPlayerView mediaViewPlayerView) {
            super(mediaViewPlayerView);
        }

        @Override // com.mbridge.msdk.nativex.view.MediaViewPlayerView.h
        public void a() {
            int nvT2 = BaseMBMediaView.this.M.getNvT2();
            if (!BaseMBMediaView.this.h || (nvT2 != 3 && nvT2 != 4)) {
                super.a();
                return;
            }
            WindVaneWebViewForNV endCardWebview = BaseMBMediaView.this.getEndCardWebview();
            if (endCardWebview == null) {
                super.a();
                return;
            }
            View viewQ = BaseMBMediaView.this.q();
            if (viewQ == null) {
                super.a();
                return;
            }
            if (nvT2 == 3 && BaseMBMediaView.this.e0) {
                com.mbridge.msdk.nativex.view.mbfullview.a.a(BaseMBMediaView.this.getContext()).a(viewQ, BaseMBMediaView.this.E);
                com.mbridge.msdk.mbnative.report.a.a(BaseMBMediaView.this.getContext(), BaseMBMediaView.this.M, BaseMBMediaView.this.M.getCampaignUnitId());
            } else {
                if (nvT2 != 4) {
                    super.a();
                    return;
                }
                com.mbridge.msdk.nativex.view.mbfullview.a.a(BaseMBMediaView.this.getContext()).a(viewQ, BaseMBMediaView.this.E);
                String clickURL = BaseMBMediaView.this.M.getClickURL();
                if (!TextUtils.isEmpty(clickURL)) {
                    com.mbridge.msdk.click.a.a(BaseMBMediaView.this.getContext(), BaseMBMediaView.this.M, BaseMBMediaView.this.getUnitId(), BaseMBMediaView.this.getAddNVT2ToNoticeURL(), true, false, com.mbridge.msdk.click.retry.a.o);
                    MintegralNetworkBridge.webviewLoadUrl(BaseMBMediaView.this.A, clickURL);
                }
            }
            endCardWebview.webViewShow(BaseMBMediaView.this.M, BaseMBMediaView.this.getUnitId());
            endCardWebview.orientation(BaseMBMediaView.this.i);
        }
    }

    class q implements View.OnClickListener {
        q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseMBMediaView.this.exitFullScreen();
        }
    }

    class r implements View.OnKeyListener {
        r() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            try {
                if (keyEvent.getKeyCode() != 4) {
                    return false;
                }
                BaseMBMediaView.this.g();
                return true;
            } catch (Throwable th) {
                o0.b(BaseMBMediaView.TAG, th.getMessage());
                return false;
            }
        }
    }

    private enum s {
        BIG_IMAGE,
        VIDEO,
        GIF
    }

    private static final class t implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        WeakReference<BaseMBMediaView> f5283a;

        public t(BaseMBMediaView baseMBMediaView) {
            this.f5283a = new WeakReference<>(baseMBMediaView);
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseMBMediaView baseMBMediaView = this.f5283a.get();
            if (baseMBMediaView != null) {
                try {
                    if (baseMBMediaView.a0 == null || baseMBMediaView.a0 != s.BIG_IMAGE) {
                        return;
                    }
                    baseMBMediaView.U();
                    baseMBMediaView.a0 = s.VIDEO;
                    baseMBMediaView.changeNoticeURL();
                } catch (Throwable th) {
                    o0.b(BaseMBMediaView.TAG, th.getMessage(), th);
                }
            }
        }
    }

    private static final class v implements com.mbridge.msdk.mbsignalcommon.base.a {
        private v() {
        }

        /* synthetic */ v(j jVar) {
            this();
        }

        @Override // com.mbridge.msdk.mbsignalcommon.base.a
        public boolean a(String str) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (s0.a.b(str)) {
                        s0.a(com.mbridge.msdk.foundation.controller.c.m().d(), str, (NativeListener.NativeTrackingListener) null);
                        return true;
                    }
                    if (URLUtil.isNetworkUrl(str)) {
                        return false;
                    }
                    s0.a(com.mbridge.msdk.foundation.controller.c.m().d(), str, (BaseTrackingListener) null);
                    return true;
                }
            } catch (Exception e) {
                o0.b(BaseMBMediaView.TAG, e.getMessage());
            }
            return false;
        }
    }

    private class w implements SensorEventListener {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.mbridge.msdk.nativex.view.mbfullview.a.a(BaseMBMediaView.this.getContext()).a(BaseMBMediaView.this.E, BaseMBMediaView.this.i);
                    BaseMBMediaView.this.O();
                    BaseMBMediaView.this.u();
                    BaseMBMediaView.this.o();
                    BaseMBMediaView.this.x();
                    if (BaseMBMediaView.this.A != null) {
                        BaseMBMediaView.this.A.orientation(BaseMBMediaView.this.i);
                    }
                } catch (Exception e) {
                    o0.b(BaseMBMediaView.TAG, e.getMessage());
                }
            }
        }

        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.mbridge.msdk.nativex.view.mbfullview.a.a(BaseMBMediaView.this.getContext()).a(BaseMBMediaView.this.E, BaseMBMediaView.this.i);
                    BaseMBMediaView.this.P();
                    BaseMBMediaView.this.u();
                    BaseMBMediaView.this.o();
                    BaseMBMediaView.this.x();
                    if (BaseMBMediaView.this.A != null) {
                        BaseMBMediaView.this.A.orientation(BaseMBMediaView.this.i);
                    }
                } catch (Exception e) {
                    o0.b(BaseMBMediaView.TAG, e.getMessage());
                }
            }
        }

        private w() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            int iRound;
            if (BaseMBMediaView.this.j0) {
                return;
            }
            try {
                float[] fArr = sensorEvent.values;
                float f = -fArr[0];
                float f2 = -fArr[1];
                float f3 = -fArr[2];
                if (((f * f) + (f2 * f2)) * 4.0f >= f3 * f3) {
                    iRound = 90 - Math.round(((float) Math.atan2(-f2, f)) * 57.29578f);
                    while (iRound >= 360) {
                        iRound -= 360;
                    }
                    while (iRound < 0) {
                        iRound += 360;
                    }
                } else {
                    iRound = -1;
                }
                float allScreenWidth = BaseMBMediaView.this.getAllScreenWidth();
                int iH = t0.h(BaseMBMediaView.this.getContext());
                if ((iRound > 45 && iRound < 135) || (iRound > 225 && iRound < 315)) {
                    if (allScreenWidth < iH || BaseMBMediaView.this.j) {
                        return;
                    }
                    BaseMBMediaView.this.i = true;
                    BaseMBMediaView.this.j = true;
                    BaseMBMediaView.this.L.postDelayed(new a(), 200L);
                    return;
                }
                if (((iRound <= 135 || iRound >= 225) && ((iRound <= 315 || iRound >= 360) && ((iRound < 0 || iRound > 45) && iRound != -1))) || allScreenWidth > iH || !BaseMBMediaView.this.j) {
                    return;
                }
                BaseMBMediaView.this.i = false;
                BaseMBMediaView.this.j = false;
                BaseMBMediaView.this.L.postDelayed(new b(), 200L);
            } catch (Throwable th) {
                o0.b(BaseMBMediaView.TAG, th.getMessage(), th);
            }
        }

        /* synthetic */ w(BaseMBMediaView baseMBMediaView, j jVar) {
            this();
        }
    }

    private static final class x implements com.mbridge.msdk.videocommon.listener.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        WeakReference<BaseMBMediaView> f5288a;

        public x(BaseMBMediaView baseMBMediaView) {
            this.f5288a = new WeakReference<>(baseMBMediaView);
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public void a(String str) {
            BaseMBMediaView baseMBMediaView = this.f5288a.get();
            if (baseMBMediaView != null) {
                baseMBMediaView.L.post(new t(baseMBMediaView));
            }
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public void a(String str, String str2) {
        }
    }

    private static final class y extends WebViewClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        WeakReference<BaseMBMediaView> f5289a;

        public y(BaseMBMediaView baseMBMediaView) {
            this.f5289a = new WeakReference<>(baseMBMediaView);
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
            CreativeInfoManager.onResourceLoaded(com.safedk.android.utils.h.o, view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Logger.d("Mintegral|SafeDK: Execution> Lcom/mbridge/msdk/nativex/view/BaseMBMediaView$y;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
            BrandSafetyUtils.onWebViewPageFinished(com.safedk.android.utils.h.o, webView, str);
            safedk_BaseMBMediaView$y_onPageFinished_2eb2e230506fece246ae55e6d8afe926(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            BrandSafetyUtils.onWebViewPageStarted(com.safedk.android.utils.h.o, view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            BrandSafetyUtils.onWebViewReceivedError(com.safedk.android.utils.h.o, view, errorCode, description, failingUrl);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            o0.b(BaseMBMediaView.TAG, "WebView called onRenderProcessGone");
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
                    o0.b(BaseMBMediaView.TAG, th.getMessage());
                }
            }
            return true;
        }

        public void safedk_BaseMBMediaView$y_onPageFinished_2eb2e230506fece246ae55e6d8afe926(WebView p0, String p1) {
            super.onPageFinished(p0, p1);
            try {
                BaseMBMediaView baseMBMediaView = this.f5289a.get();
                if (baseMBMediaView == null || baseMBMediaView.a0 == null || baseMBMediaView.a0 != s.BIG_IMAGE) {
                    return;
                }
                baseMBMediaView.R();
                baseMBMediaView.a0 = s.GIF;
                baseMBMediaView.changeNoticeURL();
            } catch (Exception e) {
                o0.b(BaseMBMediaView.TAG, e.getMessage());
            }
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

    public BaseMBMediaView(Context context) {
        super(context);
        this.f5267a = true;
        this.b = true;
        this.c = true;
        this.d = true;
        this.e = true;
        this.f = false;
        this.g = true;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = true;
        this.l = true;
        this.m = new ArrayList<>();
        this.n = new ArrayList<>();
        this.o = false;
        this.p = false;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = 0;
        this.u = false;
        this.W = null;
        this.a0 = null;
        this.e0 = false;
        this.f0 = false;
        this.j0 = false;
        this.l0 = false;
        this.m0 = new h();
        b(context);
    }

    private void T() {
        try {
            MediaViewPlayerView mediaViewPlayerView = this.v;
            if (mediaViewPlayerView == null) {
                return;
            }
            mediaViewPlayerView.setOnClickListener(new k());
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        v();
        Z();
    }

    private void V() {
        try {
            t0.a((ImageView) this.B);
            this.B.setVisibility(0);
            this.w.setVisibility(8);
            this.y.setVisibility(8);
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        try {
            ProgressBar progressBar = this.I;
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
        } catch (Exception e2) {
            o0.b(TAG, e2.getMessage());
        }
    }

    private void X() {
        try {
            this.w.setVisibility(8);
            this.B.setVisibility(8);
            this.y.setVisibility(0);
            this.z.setVisibility(0);
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        try {
            ProgressBar progressBar = this.C;
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
        } catch (Exception e2) {
            o0.b(TAG, e2.getMessage());
        }
    }

    private void Z() {
        try {
            this.w.setVisibility(0);
            this.B.setVisibility(8);
            this.y.setVisibility(8);
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        try {
            MediaViewPlayerView mediaViewPlayerView = this.v;
            if (mediaViewPlayerView == null || !mediaViewPlayerView.hasPrepare() || this.v.isPlaying() || this.v.isComplete() || !this.v.hasPrepare()) {
                return;
            }
            this.v.startOrPlayVideo();
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
        }
    }

    private void b0() {
        w wVar;
        try {
            SensorManager sensorManager = this.U;
            if (sensorManager == null || (wVar = this.T) == null) {
                return;
            }
            sensorManager.unregisterListener(wVar);
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
        }
    }

    private void c0() {
        com.mbridge.msdk.videocommon.download.a aVar = this.W;
        if (aVar != null) {
            aVar.b((com.mbridge.msdk.videocommon.listener.a) null);
        }
    }

    private float getAllScreenHeight() {
        try {
            float fH = t0.h(getContext());
            return !this.i ? fH + t0.c(getContext()) : fH;
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
            return 0.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getAllScreenWidth() {
        try {
            float fI = t0.i(getContext());
            return this.i ? fI + t0.c(getContext()) : fI;
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
            return 0.0f;
        }
    }

    private int getCDRate() {
        if (getUnitSetting() != null) {
            return getUnitSetting().i();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WindVaneWebViewForNV getEndCardWebview() {
        try {
            WindVaneWebViewForNV windVaneWebViewForNV = this.A;
            if (windVaneWebViewForNV != null && this.f0) {
                return windVaneWebViewForNV;
            }
            if (this.f0) {
                return null;
            }
            b(true);
            return null;
        } catch (Exception e2) {
            o0.b(TAG, e2.getMessage());
            return null;
        }
    }

    private String getPlayUrl() {
        try {
            if (this.M == null) {
                return null;
            }
            com.mbridge.msdk.videocommon.download.a aVar = this.W;
            if (aVar != null && aVar.j() == 5) {
                String strK = this.W.k();
                if (new File(strK).exists() && (this.W.q() || this.W.e() == t0.a(new File(strK)))) {
                    return strK;
                }
            }
            String videoUrlEncode = this.M.getVideoUrlEncode();
            if (y0.b(videoUrlEncode)) {
                return videoUrlEncode;
            }
        } catch (Exception e2) {
            o0.b(TAG, e2.getMessage());
        }
        return null;
    }

    private int getReadyRate() {
        if (getUnitSetting() != null) {
            return getUnitSetting().C();
        }
        return 100;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getUnitId() {
        try {
            CampaignEx campaignEx = this.M;
            if (campaignEx == null || !y0.b(campaignEx.getCampaignUnitId())) {
                return null;
            }
            return this.M.getCampaignUnitId();
        } catch (Exception e2) {
            o0.b(TAG, e2.getMessage());
            return null;
        }
    }

    private com.mbridge.msdk.setting.l getUnitSetting() {
        try {
            CampaignEx campaignEx = this.M;
            if (campaignEx != null && !y0.a(campaignEx.getCampaignUnitId())) {
                String campaignUnitId = this.M.getCampaignUnitId();
                String strB = com.mbridge.msdk.foundation.controller.c.m().b();
                if (!y0.a(campaignUnitId) && !y0.a(strB)) {
                    com.mbridge.msdk.setting.l lVarE = com.mbridge.msdk.setting.h.b().e(strB, campaignUnitId);
                    return lVarE != null ? lVarE : com.mbridge.msdk.setting.l.i(campaignUnitId);
                }
                return com.mbridge.msdk.setting.l.i(campaignUnitId);
            }
            return null;
        } catch (Exception e2) {
            o0.b(TAG, e2.getMessage());
            return null;
        }
    }

    private void setIsFrontDesk(boolean z) {
        MediaViewPlayerView mediaViewPlayerView = this.v;
        if (mediaViewPlayerView != null) {
            mediaViewPlayerView.setIsFrontDesk(z);
        }
    }

    private void setPlayViewParamsDefault(View view) {
        if (view == null) {
            return;
        }
        try {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams.width = -1;
            if (this.i) {
                layoutParams.height = -1;
            } else {
                layoutParams.height = (((int) getAllScreenWidth()) * 9) / 16;
                layoutParams.addRule(13);
            }
            view.setLayoutParams(layoutParams);
        } catch (Exception e2) {
            o0.b(TAG, e2.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void cai(Object obj, String str) {
        o0.a(TAG, "cai:" + str);
        if (TextUtils.isEmpty(str)) {
            com.mbridge.msdk.mbsignalcommon.communication.d.a(obj, "params is null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            try {
                String strOptString = MintegralNetworkBridge.jsonObjectInit(str).optString("packageName");
                if (TextUtils.isEmpty(strOptString)) {
                    com.mbridge.msdk.mbsignalcommon.communication.d.a(obj, "packageName is empty");
                }
                int i2 = t0.c(com.mbridge.msdk.foundation.controller.c.m().d(), strOptString) ? 1 : 2;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", com.mbridge.msdk.mbsignalcommon.communication.d.b);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", i2);
                    jSONObject.put("data", jSONObject2);
                    com.mbridge.msdk.mbsignalcommon.windvane.f.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e2) {
                    com.mbridge.msdk.mbsignalcommon.communication.d.a(obj, e2.getMessage());
                    o0.a(TAG, e2.getMessage());
                }
            } catch (JSONException e3) {
                com.mbridge.msdk.mbsignalcommon.communication.d.a(obj, "exception: " + e3.getLocalizedMessage());
                o0.b(TAG, "cai", e3);
            }
        } catch (Throwable th) {
            com.mbridge.msdk.mbsignalcommon.communication.d.a(obj, "exception: " + th.getLocalizedMessage());
            o0.b(TAG, "cai", th);
        }
    }

    public boolean canShowVideo() {
        return a(false) == s.VIDEO;
    }

    public void changeNoticeURL() {
        String str;
        CampaignEx campaignEx = this.M;
        if (campaignEx != null) {
            String noticeUrl = campaignEx.getNoticeUrl();
            if (TextUtils.isEmpty(noticeUrl)) {
                return;
            }
            if (noticeUrl.contains("is_video")) {
                s sVar = this.a0;
                if (sVar == s.VIDEO) {
                    if (noticeUrl.contains("is_video=2")) {
                        noticeUrl = noticeUrl.replace("is_video=2", "is_video=1");
                    }
                } else if (sVar == s.BIG_IMAGE && noticeUrl.contains("is_video=1")) {
                    noticeUrl = noticeUrl.replace("is_video=1", "is_video=2");
                }
            } else {
                s sVar2 = this.a0;
                if (sVar2 == s.VIDEO) {
                    str = "1";
                } else {
                    str = sVar2 == s.BIG_IMAGE ? "2" : "";
                }
                StringBuilder sb = new StringBuilder(noticeUrl);
                if (noticeUrl.contains("?")) {
                    sb.append("&is_video=").append(str);
                } else {
                    sb.append("?is_video=").append(str);
                }
                noticeUrl = sb.toString();
            }
            this.M.setNoticeUrl(noticeUrl);
        }
    }

    public void destory() {
        try {
            MediaViewPlayerView mediaViewPlayerView = this.v;
            if (mediaViewPlayerView != null) {
                mediaViewPlayerView.release();
            }
            c0();
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.o, this, me);
        return super.dispatchTouchEvent(me);
    }

    public void exitFullScreen() {
        try {
            g();
            if (this.b) {
                this.v.onClickPlayButton();
            }
        } catch (Exception e2) {
            o0.b(TAG, e2.getMessage());
        }
    }

    public String getAddNVT2ToNoticeURL() {
        CampaignEx campaignEx = this.M;
        if (campaignEx == null) {
            return null;
        }
        String noticeUrl = campaignEx.getNoticeUrl();
        if (TextUtils.isEmpty(noticeUrl) || noticeUrl.contains(CampaignEx.JSON_KEY_NV_T2)) {
            return noticeUrl;
        }
        StringBuilder sb = new StringBuilder(noticeUrl);
        sb.append("&nv_t2=").append(this.M.getNvT2());
        return sb.toString();
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void getEndScreenInfo(Object obj, String str) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.M);
            String strA = a(arrayList, getUnitId(), "MAL_16.9.61,3.0.1");
            String strEncodeToString = !TextUtils.isEmpty(strA) ? Base64.encodeToString(strA.getBytes(), 2) : "";
            o0.b(TAG, "getEndScreenInfo-mCampaign.name:" + this.M.getAppName());
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().b(obj, strEncodeToString);
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001e  */
    public BaseView getFullScreenViewByStyle(Context context, BaseView.a aVar) {
        BaseView mBridgeFullView;
        BaseView baseView;
        int i2 = i.f5275a[aVar.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                baseView = null;
            } else {
                mBridgeFullView = new MBridgeTopFullView(context);
            }
            if (baseView != null) {
                baseView.setStytle(aVar);
            }
            return baseView;
        }
        mBridgeFullView = new MBridgeFullView(context);
        baseView = mBridgeFullView;
        if (baseView != null) {
            baseView.setStytle(aVar);
        }
        return baseView;
    }

    public float getMediaContentAspectRatio() {
        float f2 = 0.0f;
        try {
            CampaignEx campaignEx = this.M;
            if (campaignEx != null) {
                String videoResolution = !TextUtils.isEmpty(campaignEx.getVideoUrlEncode()) ? this.M.getVideoResolution() : this.M.getImageSize();
                if (!TextUtils.isEmpty(videoResolution)) {
                    String[] strArrSplit = videoResolution.split(VastAttributes.HORIZONTAL_POSITION);
                    if (strArrSplit.length == 2) {
                        f2 = Integer.parseInt(strArrSplit[0]) / Integer.parseInt(strArrSplit[1]);
                    }
                }
                o0.b(TAG, "resource ratio is : " + f2);
            }
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
        }
        return f2;
    }

    public BaseView.a handleViewStyleResult(Context context) {
        int nvT2 = this.M.getNvT2();
        if (nvT2 == 1) {
            a(context);
        } else {
            if (nvT2 == 2 || nvT2 == 3 || nvT2 == 4) {
                return BaseView.a.FULL_MIDDLE_VIEW;
            }
            if (nvT2 == 6) {
                return BaseView.a.FULL_TOP_VIEW;
            }
        }
        return null;
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void handlerPlayableException(Object obj, String str) {
    }

    public void hideEndCardWebViewCloseBtn() {
        ImageView imageView = this.h0;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        this.h0.setVisibility(8);
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void install(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        try {
            Context context = this.k0;
            if (context != null) {
                a(context);
            } else {
                if (!(obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) || (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b) == null) {
                    return;
                }
                a(windVaneWebView.getContext());
            }
        } catch (Exception e2) {
            o0.b(TAG, e2.getMessage());
        }
    }

    public boolean ismCurIsFullScreen() {
        return this.h;
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void notifyCloseBtn(Object obj, String str) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            if (this.c) {
                B();
            }
            this.g = isHardwareAccelerated();
            this.i0 = getOrientation();
            N();
            this.L.postDelayed(this.m0, 300L);
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onBufferingEnd() {
        o0.c("omsdk", "base media end");
        MediaEvents mediaEvents = this.s;
        if (mediaEvents != null) {
            mediaEvents.bufferFinish();
        }
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onBufferingStart(String str) {
        o0.c("omsdk", "base media start");
        MediaEvents mediaEvents = this.s;
        if (mediaEvents != null) {
            mediaEvents.bufferStart();
        }
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onBufferingTimeOut(String str) {
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.j0) {
            int i2 = this.i0;
            int i3 = configuration.orientation;
            if (i2 == i3) {
                return;
            }
            this.i0 = i3;
            this.i = i3 == 0;
            this.j = this.i0 == 0;
            this.L.postDelayed(new g(), 200L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            if (this.q != null) {
                MediaViewPlayerView mediaViewPlayerView = this.v;
                if (mediaViewPlayerView != null) {
                    mediaViewPlayerView.unregisterView();
                }
                this.q.finish();
                this.q = null;
            }
            if (this.s != null) {
                this.s = null;
            }
            if (this.r != null) {
                this.r = null;
            }
            this.L.removeCallbacks(this.m0);
            C();
            b0();
            c0();
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        try {
            this.N = getHeight();
            int width = getWidth();
            this.O = width;
            if (width == 0) {
                this.O = getMeasuredWidth();
            }
            if (this.N == 0) {
                this.N = getMeasuredHeight();
            }
            if (this.O == 0 && this.N == 0) {
                this.O = (int) getAllScreenWidth();
            }
            s sVar = this.a0;
            if (sVar != s.VIDEO || this.h) {
                if (sVar == s.BIG_IMAGE && !this.h) {
                    o();
                    return;
                } else {
                    if (sVar != s.GIF || this.h) {
                        return;
                    }
                    x();
                    return;
                }
            }
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (this.N == 0 || ((layoutParams != null && layoutParams.height == -2) || (layoutParams != null && layoutParams.height == -1))) {
                this.N = (int) ((((double) this.O) * this.Q) / this.P);
            }
            u();
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayCompleted() {
        MediaEvents mediaEvents = this.s;
        if (mediaEvents != null) {
            mediaEvents.complete();
        }
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayError(String str) {
        try {
            o0.c("error", str);
            o oVar = new o(str);
            if (com.mbridge.msdk.foundation.controller.d.a().e()) {
                com.mbridge.msdk.foundation.same.threadpool.a.b().execute(oVar);
            } else {
                oVar.run();
            }
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayProgress(int i2, int i3) {
        int i4;
        b(i2);
        a(i2, i3);
        MediaEvents mediaEvents = this.s;
        if (mediaEvents != null) {
            int i5 = (i2 * 100) / i3;
            int i6 = ((i2 + 1) * 100) / i3;
            if (i5 <= 25 && 25 < i6) {
                mediaEvents.firstQuartile();
            } else if (i5 <= 50 && 50 < i6) {
                mediaEvents.midpoint();
            } else if (i5 <= 75 && 75 < i6) {
                mediaEvents.thirdQuartile();
            }
        }
        if (getReadyRate() == 100 || this.l0) {
            return;
        }
        int cDRate = getCDRate();
        int readyRate = getReadyRate();
        if (readyRate == 0) {
            return;
        }
        if (cDRate > readyRate) {
            cDRate = readyRate / 2;
        }
        if (cDRate < 0 || i2 < (i4 = (i3 * cDRate) / 100)) {
            return;
        }
        com.mbridge.msdk.videocommon.download.a aVarA = com.mbridge.msdk.videocommon.download.b.getInstance().a(getUnitId(), (this.M.getAdType() == 94 || this.M.getAdType() == 287) ? this.M.getRequestId() + this.M.getId() + this.M.getVideoUrlEncode() : this.M.getId() + this.M.getVideoUrlEncode() + this.M.getBidToken());
        if (aVarA != null) {
            aVarA.v();
            this.l0 = true;
            o0.b(TAG, "CDRate is : " + i4 + " and start download !");
        }
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayProgressMS(int i2, int i3) {
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlaySetDataSourceError(String str) {
        o0.c("errorstr", str);
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayStarted(int i2) {
        MediaEvents mediaEvents = this.s;
        if (mediaEvents != null) {
            try {
                mediaEvents.start(i2, this.f ? 1.0f : 0.0f);
            } catch (IllegalArgumentException e2) {
                o0.a("omsdk", e2.getMessage());
            }
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        try {
            this.e = z;
            if (this.a0 == s.VIDEO) {
                setIsFrontDesk(z);
            }
            r();
            requestLayout();
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void openURL(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        o0.b(TAG, "openURL:" + str);
        if (TextUtils.isEmpty(str)) {
            com.mbridge.msdk.mbsignalcommon.communication.d.a(obj, "params is null");
            return;
        }
        Context contextD = com.mbridge.msdk.foundation.controller.c.m().d();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (contextD == null) {
            try {
                if ((obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b) != null) {
                    contextD = windVaneWebView.getContext();
                }
            } catch (Exception e2) {
                o0.b(TAG, e2.getMessage());
            }
        }
        if (contextD == null) {
            return;
        }
        try {
            JSONObject jSONObjectJsonObjectInit = MintegralNetworkBridge.jsonObjectInit(str);
            String strOptString = jSONObjectJsonObjectInit.optString("url");
            int iOptInt = jSONObjectJsonObjectInit.optInt("type");
            if (iOptInt == 1) {
                com.mbridge.msdk.click.c.c(contextD, strOptString);
            } else if (iOptInt == 2) {
                com.mbridge.msdk.click.c.e(contextD, strOptString);
            }
        } catch (JSONException e3) {
            o0.b(TAG, e3.getMessage());
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
        }
    }

    public void setAllowLoopPlay(boolean z) {
        this.b = z;
    }

    public void setAllowScreenChange(boolean z) {
        this.c = z;
    }

    public void setAllowVideoRefresh(boolean z) {
        this.f5267a = z;
    }

    public void setFollowActivityOrientation(boolean z) {
        this.j0 = z;
    }

    public void setFullScreenViewBackgroundColor(int i2) {
        this.t = i2;
    }

    public void setIsAllowFullScreen(boolean z) {
        this.d = z;
    }

    public void setNativeAd(Campaign campaign) {
        if (campaign == null) {
            return;
        }
        try {
            CampaignEx campaignEx = this.M;
            if (campaignEx == null || campaignEx != campaign) {
                M();
                p();
                CampaignEx campaignEx2 = (CampaignEx) campaign;
                this.M = campaignEx2;
                if (campaignEx2.getMediaViewHolder() == null) {
                    CampaignEx.b bVar = new CampaignEx.b();
                    bVar.f4929a = this.M.getAdvImpList();
                    this.M.setMediaViewHolder(bVar);
                }
                this.W = com.mbridge.msdk.videocommon.download.b.getInstance().a(getUnitId(), (this.M.getAdType() == 94 || this.M.getAdType() == 287) ? this.M.getRequestId() + this.M.getId() + this.M.getVideoUrlEncode() : this.M.getId() + this.M.getVideoUrlEncode() + this.M.getBidToken());
                if (this.o) {
                    if (this.q != null) {
                        MediaViewPlayerView mediaViewPlayerView = this.v;
                        if (mediaViewPlayerView != null) {
                            mediaViewPlayerView.unregisterView();
                        }
                        this.q.finish();
                        this.q = null;
                    }
                    if (this.s != null) {
                        this.s = null;
                    }
                    if (this.r != null) {
                        this.r = null;
                    }
                }
                CampaignEx campaignEx3 = this.M;
                if (campaignEx3 != null && campaignEx3.isActiveOm()) {
                    this.q = com.mbridge.msdk.omsdk.b.a(getContext(), TextUtils.isEmpty(this.M.getVideoUrlEncode()), this.M.getOmid(), this.M.getRequestId(), this.M.getId(), getUnitId(), "", this.M.getRequestIdNotice());
                }
                if (this.o) {
                    N();
                }
            }
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
        }
    }

    public void setOnMediaViewListener(OnMBMediaViewListener onMBMediaViewListener) {
        this.b0 = onMBMediaViewListener;
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void setOrientation(Object obj, String str) {
    }

    public void setProgressVisibility(boolean z) {
        this.k = z;
        MediaViewPlayerView mediaViewPlayerView = this.v;
        if (mediaViewPlayerView != null) {
            mediaViewPlayerView.showProgressView(z);
        }
    }

    public void setSoundIndicatorVisibility(boolean z) {
        this.l = z;
        MediaViewPlayerView mediaViewPlayerView = this.v;
        if (mediaViewPlayerView != null) {
            mediaViewPlayerView.showSoundIndicator(z);
        }
    }

    public void setVideoSoundOnOff(boolean z) {
        this.f = z;
        MediaViewPlayerView mediaViewPlayerView = this.v;
        if (mediaViewPlayerView != null) {
            if (z) {
                mediaViewPlayerView.openSound();
            } else {
                mediaViewPlayerView.closeSound();
            }
        }
    }

    public void showEndCardWebViewCloseBtn() {
        ImageView imageView = this.h0;
        if (imageView == null || imageView.getVisibility() == 0) {
            return;
        }
        this.h0.setVisibility(0);
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void toggleCloseBtn(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                try {
                    MintegralNetworkBridge.jsonObjectInit(str).optInt("state", 1);
                } catch (Exception e2) {
                    o0.b(TAG, e2.getMessage());
                }
            }
            o0.b(TAG, "SHOW CLOSE BTN ");
            showEndCardWebViewCloseBtn();
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().b(obj, a(0));
        } catch (Exception e3) {
            o0.b(TAG, e3.getMessage());
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a(obj, a(1));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void triggerCloseBtn(Object obj, String str) {
        try {
            exitFullScreen();
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().b(obj, a(0));
        } catch (Exception e2) {
            o0.b(TAG, e2.getMessage());
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a(obj, a(1));
        }
    }

    public void updateViewManger(boolean z) {
        com.mbridge.msdk.nativex.view.mbfullview.a aVarA = com.mbridge.msdk.nativex.view.mbfullview.a.a(getContext());
        if (aVarA != null) {
            try {
                aVarA.a(this.E);
                aVarA.a(z, !this.v.isComplete(), this.E);
                aVarA.a(z, this.E, this.d0);
            } catch (NullPointerException e2) {
                e2.printStackTrace();
                return;
            }
        }
        BaseView baseView = this.E;
        if (!(baseView instanceof MBridgeTopFullView) || aVarA == null) {
            return;
        }
        aVarA.a(!z, baseView);
    }

    class f extends com.mbridge.msdk.mbsignalcommon.listener.b {
        f() {
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, String str) {
            super.a(webView, str);
            BaseMBMediaView.this.e0 = true;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i, String str, String str2) {
            super.a(webView, i, str, str2);
            BaseMBMediaView.this.e0 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        try {
            MediaViewPlayerView mediaViewPlayerView = this.v;
            if (mediaViewPlayerView != null && mediaViewPlayerView.hasPrepare() && this.v.isPlaying()) {
                z();
            }
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
        }
    }

    private void B() {
        try {
            SensorManager sensorManager = (SensorManager) getContext().getSystemService("sensor");
            this.U = sensorManager;
            this.V = sensorManager.getDefaultSensor(1);
            w wVar = new w(this, null);
            this.T = wVar;
            this.U.registerListener(wVar, this.V, 2);
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
        }
    }

    private void C() {
        Handler handler = this.L;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    private void D() {
        if (this.M.isReportClick()) {
            return;
        }
        this.M.setReportClick(true);
        CampaignEx campaignEx = this.M;
        if (campaignEx == null || campaignEx.getNativeVideoTracking() == null || this.M.getNativeVideoTracking().d() == null) {
            return;
        }
        Context context = getContext();
        CampaignEx campaignEx2 = this.M;
        com.mbridge.msdk.click.a.a(context, campaignEx2, campaignEx2.getCampaignUnitId(), this.M.getNativeVideoTracking().d(), false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        CampaignEx campaignEx = this.M;
        if (campaignEx == null || campaignEx.getMediaViewHolder() == null) {
            return;
        }
        com.mbridge.msdk.foundation.controller.c.m().a(getContext());
        com.mbridge.msdk.mbnative.report.b.a(this.M, getContext(), getUnitId(), (com.mbridge.msdk.mbnative.listener.a) null);
        CampaignEx.b mediaViewHolder = this.M.getMediaViewHolder();
        if (!mediaViewHolder.l && this.a0 == s.VIDEO && y0.b(this.M.getImpressionURL())) {
            mediaViewHolder.l = true;
            String impressionURL = this.M.getImpressionURL();
            if (!impressionURL.contains("is_video=1")) {
                StringBuilder sb = new StringBuilder(impressionURL);
                if (impressionURL.contains("?")) {
                    sb.append("&is_video=1");
                } else {
                    sb.append("?is_video=1");
                }
                impressionURL = sb.toString();
            }
            Context context = getContext();
            CampaignEx campaignEx2 = this.M;
            com.mbridge.msdk.click.a.a(context, campaignEx2, campaignEx2.getCampaignUnitId(), impressionURL, false, true, com.mbridge.msdk.click.retry.a.m);
        }
    }

    private void F() {
        CampaignEx campaignEx = this.M;
        if (campaignEx == null || campaignEx.getMediaViewHolder() == null || this.M.getMediaViewHolder().e || TextUtils.isEmpty(this.M.getCampaignUnitId()) || this.M.getNativeVideoTracking() == null || this.M.getNativeVideoTracking().c() == null) {
            return;
        }
        this.M.getMediaViewHolder().e = true;
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        CampaignEx.b mediaViewHolder;
        CampaignEx campaignEx = this.M;
        if (campaignEx == null || (mediaViewHolder = campaignEx.getMediaViewHolder()) == null || mediaViewHolder.f || this.M.getNativeVideoTracking() == null || this.M.getNativeVideoTracking().m() == null) {
            return;
        }
        mediaViewHolder.f = true;
        Context context = getContext();
        CampaignEx campaignEx2 = this.M;
        com.mbridge.msdk.click.a.a(context, campaignEx2, campaignEx2.getCampaignUnitId(), this.M.getNativeVideoTracking().m(), false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        CampaignEx.b mediaViewHolder;
        CampaignEx campaignEx = this.M;
        if (campaignEx == null || (mediaViewHolder = campaignEx.getMediaViewHolder()) == null || mediaViewHolder.g || this.M.getNativeVideoTracking() == null || this.M.getNativeVideoTracking().n() == null) {
            return;
        }
        mediaViewHolder.g = true;
        Context context = getContext();
        CampaignEx campaignEx2 = this.M;
        com.mbridge.msdk.click.a.a(context, campaignEx2, campaignEx2.getCampaignUnitId(), this.M.getNativeVideoTracking().n(), false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        CampaignEx campaignEx = this.M;
        if (campaignEx == null || campaignEx.getMediaViewHolder() == null || this.M.getMediaViewHolder().d || TextUtils.isEmpty(this.M.getCampaignUnitId()) || this.M.getNativeVideoTracking() == null || this.M.getNativeVideoTracking().i() == null) {
            return;
        }
        this.M.getMediaViewHolder().d = true;
        Context context = getContext();
        CampaignEx campaignEx2 = this.M;
        com.mbridge.msdk.click.a.a(context, campaignEx2, campaignEx2.getCampaignUnitId(), this.M.getNativeVideoTracking().i(), false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        CampaignEx.b mediaViewHolder;
        CampaignEx campaignEx = this.M;
        if (campaignEx == null || (mediaViewHolder = campaignEx.getMediaViewHolder()) == null || mediaViewHolder.i || this.M.getNativeVideoTracking() == null || this.M.getNativeVideoTracking().p() == null) {
            return;
        }
        mediaViewHolder.i = true;
        Context context = getContext();
        CampaignEx campaignEx2 = this.M;
        com.mbridge.msdk.click.a.a(context, campaignEx2, campaignEx2.getCampaignUnitId(), this.M.getNativeVideoTracking().p(), false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        CampaignEx.b mediaViewHolder;
        CampaignEx campaignEx = this.M;
        if (campaignEx == null || (mediaViewHolder = campaignEx.getMediaViewHolder()) == null || mediaViewHolder.j || this.M.getNativeVideoTracking() == null || this.M.getNativeVideoTracking().s() == null) {
            return;
        }
        mediaViewHolder.j = true;
        Context context = getContext();
        CampaignEx campaignEx2 = this.M;
        com.mbridge.msdk.click.a.a(context, campaignEx2, campaignEx2.getCampaignUnitId(), this.M.getNativeVideoTracking().s(), false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        CampaignEx.b mediaViewHolder;
        CampaignEx campaignEx = this.M;
        if (campaignEx == null || (mediaViewHolder = campaignEx.getMediaViewHolder()) == null || mediaViewHolder.k || this.M.getNativeVideoTracking() == null || this.M.getNativeVideoTracking().t() == null) {
            return;
        }
        mediaViewHolder.k = true;
        Context context = getContext();
        CampaignEx campaignEx2 = this.M;
        com.mbridge.msdk.click.a.a(context, campaignEx2, campaignEx2.getCampaignUnitId(), this.M.getNativeVideoTracking().t(), false, false);
    }

    private void M() {
        this.e = true;
        this.g = true;
        this.h = false;
        this.i = false;
        this.j = false;
        this.p = false;
    }

    private void N() {
        AdSession adSession;
        try {
            this.a0 = a(true);
            changeNoticeURL();
            s sVar = this.a0;
            if (sVar == s.BIG_IMAGE) {
                CampaignEx campaignEx = this.M;
                if (campaignEx != null && TextUtils.isEmpty(campaignEx.getVideoUrlEncode()) && (adSession = this.q) != null) {
                    try {
                        adSession.registerAdView(this.B);
                        this.r = AdEvents.createAdEvents(this.q);
                        this.q.start();
                        AdEvents adEvents = this.r;
                        if (adEvents != null) {
                            adEvents.impressionOccurred();
                        }
                    } catch (Exception e2) {
                        o0.a("omsdk", e2.getMessage());
                    }
                }
                V();
                i();
            } else if (sVar == s.VIDEO) {
                U();
            } else if (sVar == s.GIF) {
                j();
                R();
            }
            this.o = true;
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage(), th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        try {
            if (this.G == null && this.h0 == null) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(t0.a(getContext(), 30.0f), t0.a(getContext(), 30.0f));
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            if (this.d0 == 0 && com.mbridge.msdk.foundation.tools.e.a(getContext())) {
                layoutParams.rightMargin = t0.c(getContext()) + t0.a(getContext(), 8.0f);
            } else {
                layoutParams.rightMargin = t0.a(getContext(), 8.0f);
            }
            layoutParams.topMargin = t0.a(getContext(), 8.0f);
            RelativeLayout relativeLayout = this.G;
            if (relativeLayout != null) {
                relativeLayout.setLayoutParams(layoutParams);
            }
            ImageView imageView = this.h0;
            if (imageView != null) {
                imageView.setLayoutParams(layoutParams);
            }
            updateViewManger(true);
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        try {
            if (this.G == null && this.h0 == null) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(t0.a(getContext(), 30.0f), t0.a(getContext(), 30.0f));
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = t0.a(getContext(), 8.0f);
            layoutParams.rightMargin = t0.a(getContext(), 8.0f);
            RelativeLayout relativeLayout = this.G;
            if (relativeLayout != null) {
                relativeLayout.setLayoutParams(layoutParams);
            }
            ImageView imageView = this.h0;
            if (imageView != null) {
                imageView.setLayoutParams(layoutParams);
            }
            updateViewManger(false);
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
        }
    }

    private void Q() {
        try {
            this.D.setFocusableInTouchMode(true);
            this.D.requestFocus();
            this.D.setOnKeyListener(new r());
            this.D.setOnClickListener(new a());
            this.G.setOnClickListener(new b());
            this.H.setOnClickListener(new c());
        } catch (Exception e2) {
            o0.b(TAG, e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        X();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        try {
            if (getVisibility() != 0) {
                return;
            }
            if (a((View) this)) {
                com.mbridge.msdk.setting.l unitSetting = getUnitSetting();
                int i2 = 0;
                int iS = unitSetting != null ? unitSetting.s() : 0;
                CampaignEx campaignEx = this.M;
                if (campaignEx == null || campaignEx.getImpReportType() != 1) {
                    i2 = iS;
                }
                Message messageObtainMessage = this.L.obtainMessage();
                messageObtainMessage.what = 3;
                messageObtainMessage.obj = this;
                this.L.sendMessageDelayed(messageObtainMessage, (i2 == 0 ? 0L : ((long) i2) * 1000) + 300);
            }
            if (this.a0 == s.VIDEO) {
                MediaViewPlayerView mediaViewPlayerView = this.v;
                if (mediaViewPlayerView == null) {
                    b();
                    return;
                }
                if (this.M != mediaViewPlayerView.getCampaign()) {
                    this.v.release();
                    b();
                    if (getParent() != null) {
                        ((View) getParent()).invalidate();
                    }
                    requestLayout();
                }
            }
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
        }
    }

    private void e() {
        try {
            OnMBMediaViewListener onMBMediaViewListener = this.b0;
            if (onMBMediaViewListener != null) {
                onMBMediaViewListener.onVideoAdClicked(this.M);
            }
            OnMBMediaViewListenerPlus onMBMediaViewListenerPlus = this.c0;
            if (onMBMediaViewListenerPlus != null) {
                onMBMediaViewListenerPlus.onVideoAdClicked(this.M);
            }
        } catch (Exception e2) {
            o0.b(TAG, e2.getMessage());
        }
    }

    private void f() {
        try {
            CampaignEx campaignEx = this.M;
            if (campaignEx == null || campaignEx.getNativeVideoTracking() == null) {
                return;
            }
            String[] strArrC = this.M.getNativeVideoTracking().c();
            int i2 = this.i ? n0 : o0;
            for (String str : strArrC) {
                if (!TextUtils.isEmpty(str)) {
                    Context context = getContext();
                    CampaignEx campaignEx2 = this.M;
                    com.mbridge.msdk.click.a.a(context, campaignEx2, campaignEx2.getCampaignUnitId(), str + "&orienation=" + i2, false, false);
                }
            }
        } catch (Exception e2) {
            o0.b(TAG, e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        try {
            FrameLayout frameLayout = (FrameLayout) getRootView().findViewById(R.id.content);
            FrameLayout frameLayout2 = (FrameLayout) getRootView().findViewById(100);
            RelativeLayout relativeLayout = (RelativeLayout) getRootView().findViewById(101);
            RelativeLayout relativeLayout2 = (RelativeLayout) getRootView().findViewById(103);
            if (relativeLayout2 == null && relativeLayout != null) {
                relativeLayout2 = (RelativeLayout) relativeLayout.findViewById(103);
            }
            RelativeLayout relativeLayout3 = (RelativeLayout) getRootView().findViewById(g0.a(getContext(), "mbridge_full_rl_playcontainer", "id"));
            if (relativeLayout3 == null && relativeLayout2 != null) {
                relativeLayout3 = (RelativeLayout) relativeLayout2.findViewById(g0.a(getContext(), "mbridge_full_rl_playcontainer", "id"));
            }
            RelativeLayout relativeLayout4 = (RelativeLayout) getRootView().findViewById(g0.a(getContext(), "mbridge_full_player_parent", "id"));
            if (relativeLayout4 == null && relativeLayout3 != null) {
                relativeLayout4 = (RelativeLayout) relativeLayout3.findViewById(g0.a(getContext(), "mbridge_full_player_parent", "id"));
            }
            ProgressBar progressBar = (ProgressBar) getRootView().findViewById(g0.a(getContext(), "mbridge_full_pb_loading", "id"));
            RelativeLayout relativeLayout5 = (RelativeLayout) getRootView().findViewById(g0.a(getContext(), "mbridge_full_rl_install", "id"));
            LinearLayout linearLayout = (LinearLayout) getRootView().findViewById(g0.a(getContext(), "mbridge_full_ll_pro_dur", "id"));
            ViewGroup viewGroup = frameLayout2 != null ? (ViewGroup) frameLayout2.getParent() : null;
            if (relativeLayout2 != null) {
                relativeLayout2.removeView(linearLayout);
            } else if (linearLayout != null && linearLayout.getParent() != null) {
                ((ViewGroup) linearLayout.getParent()).removeView(linearLayout);
            }
            RelativeLayout relativeLayout6 = this.g0;
            if (relativeLayout6 != null) {
                if (relativeLayout2 != null) {
                    relativeLayout2.removeView(relativeLayout6);
                } else if (relativeLayout6.getParent() != null) {
                    ((ViewGroup) this.g0.getParent()).removeView(this.g0);
                }
                this.A.setBackListener(null);
                this.A.setObject(null);
                this.A = null;
                this.g0 = null;
            }
            if (relativeLayout2 != null) {
                relativeLayout2.removeView(relativeLayout5);
            } else if (relativeLayout5 != null && relativeLayout5.getParent() != null) {
                ((ViewGroup) relativeLayout5.getParent()).removeView(relativeLayout5);
            }
            if (relativeLayout2 != null) {
                relativeLayout2.removeView(progressBar);
            } else if (progressBar != null && progressBar.getParent() != null) {
                ((ViewGroup) progressBar.getParent()).removeView(progressBar);
            }
            if (relativeLayout4 != null) {
                relativeLayout4.removeView(this.v);
            }
            if (relativeLayout3 != null) {
                relativeLayout3.removeView(relativeLayout4);
            } else if (relativeLayout4 != null && relativeLayout4.getParent() != null) {
                ((ViewGroup) relativeLayout4.getParent()).removeView(relativeLayout4);
            }
            if (relativeLayout2 != null) {
                relativeLayout2.removeView(relativeLayout3);
            } else if (relativeLayout3 == null || relativeLayout3.getParent() == null) {
                BaseView baseView = this.E;
                if (baseView != null) {
                    baseView.removeView(this.F);
                }
            } else {
                ((ViewGroup) relativeLayout3.getParent()).removeView(relativeLayout3);
            }
            if (relativeLayout != null) {
                relativeLayout.removeView(relativeLayout2);
            } else if (relativeLayout2 == null || relativeLayout2.getParent() == null) {
                View view = this.D;
                if (view != null) {
                    ((ViewGroup) view).removeView(this.E);
                    ((ViewGroup) this.D.getParent()).removeView(this.D);
                }
            } else {
                ((ViewGroup) relativeLayout2.getParent()).removeView(relativeLayout2);
            }
            if (frameLayout != null) {
                if (relativeLayout != null) {
                    frameLayout.removeView(relativeLayout);
                } else {
                    frameLayout.removeView(this.D);
                    if (this.D.getParent() != null) {
                        ((ViewGroup) this.D.getParent()).removeView(this.D);
                        this.D.setVisibility(8);
                    }
                }
            }
            setVisibility(0);
            requestLayout();
            if (viewGroup != null) {
                if (this.v.getParent() != null && this.v.getParent() != viewGroup) {
                    ((ViewGroup) this.v.getParent()).removeView(this.v);
                }
                viewGroup.addView(this.v, this.K);
                viewGroup.removeView(frameLayout2);
                viewGroup.invalidate();
            }
            d();
            this.h = false;
            MediaViewPlayerView mediaViewPlayerView = this.v;
            if (mediaViewPlayerView != null) {
                mediaViewPlayerView.setExitFullScreen();
                if (this.f) {
                    this.v.openSound();
                } else {
                    this.v.closeSound();
                }
                this.v.gonePauseView();
            }
        } catch (Exception e2) {
            o0.b(TAG, e2.getMessage());
        }
    }

    private void h() {
        try {
            e();
            if (this.M != null && !y0.a(getUnitId())) {
                D();
                com.mbridge.msdk.click.a aVar = new com.mbridge.msdk.click.a(getContext(), getUnitId());
                aVar.a(new n());
                aVar.a(this.M);
            }
        } catch (Exception e2) {
            o0.b(TAG, e2.getMessage());
        }
    }

    private void i() {
        try {
            CampaignEx campaignEx = this.M;
            if (campaignEx == null) {
                return;
            }
            String imageUrl = campaignEx.getImageUrl();
            if (y0.a(imageUrl) || getContext() == null) {
                return;
            }
            com.mbridge.msdk.foundation.same.image.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(imageUrl, new l());
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
        }
    }

    private void j() {
        try {
            CampaignEx campaignEx = this.M;
            if (campaignEx == null) {
                return;
            }
            String gifUrl = campaignEx.getGifUrl();
            if (y0.a(gifUrl) || getContext() == null) {
                return;
            }
            MintegralNetworkBridge.webviewLoadDataWithBaseURL(this.z, null, "<!DOCTYPE html><html lang=\"en\"><head>  <meta charset=\"UTF-8\">  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"><meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">  <title>Document</title>  <style>  *{    margin: 0;    padding: 0;  }  html, body{    width: 100%;    height: 100%;  }  body{    background-image: url('gifUrl');    background-position: center;    background-size: contain;    background-repeat: no-repeat;  }  </style></head><body></body></html>".replace("gifUrl", gifUrl), POBCommonConstants.CONTENT_TYPE_HTML, cc.N, null);
            this.z.setInterceptTouch(true);
            this.y.setOnClickListener(new m());
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
        }
    }

    private boolean k() {
        try {
            this.F = this.E.getMBridgeFullPlayContainer();
            this.J = this.E.getMBridgeFullPlayerParent();
            this.G = this.E.getMBridgeFullClose();
            this.H = this.E.getMBridgeFullTvInstall();
            this.I = this.E.getMBridgeFullPb();
            return true;
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            MediaViewPlayerView mediaViewPlayerView = this.v;
            if (mediaViewPlayerView == null) {
                return;
            }
            mediaViewPlayerView.onClickPlayerView();
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        try {
            ProgressBar progressBar = this.I;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
        } catch (Exception e2) {
            o0.b(TAG, e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        try {
            ProgressBar progressBar = this.C;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
        } catch (Exception e2) {
            o0.b(TAG, e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        int i2;
        int i3;
        int i4;
        try {
            if (this.a0 != s.BIG_IMAGE || (i2 = this.O) == 0 || (i3 = this.S) == 0 || (i4 = this.R) == 0) {
                return;
            }
            int i5 = (i2 * i3) / i4;
            MyImageView myImageView = this.B;
            if (myImageView == null || i5 == 0) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) myImageView.getLayoutParams();
            layoutParams.width = this.O;
            layoutParams.height = i5;
            this.B.setLayoutParams(layoutParams);
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
        }
    }

    private void p() {
        try {
            this.i = t0.i(getContext()) >= t0.h(getContext());
            this.j = this.i;
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View q() {
        try {
            this.g0 = new RelativeLayout(getContext());
            this.g0.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            ImageView imageView = new ImageView(getContext());
            this.h0 = imageView;
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(t0.a(getContext(), 30.0f), t0.a(getContext(), 30.0f));
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = t0.a(getContext(), 8.0f);
            layoutParams.rightMargin = t0.a(getContext(), 8.0f);
            this.h0.setLayoutParams(layoutParams);
            this.h0.setBackgroundResource(g0.a(getContext(), "mbridge_nativex_close", "drawable"));
            this.h0.setOnClickListener(new q());
            this.A.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.g0.addView(this.A);
            this.g0.addView(this.h0);
            return this.g0;
        } catch (Exception e2) {
            o0.b(TAG, e2.getMessage());
            return null;
        }
    }

    private void r() {
        try {
            if (this.h) {
                MediaViewPlayerView mediaViewPlayerView = this.v;
                if (mediaViewPlayerView == null) {
                    o0.b(TAG, "fullscreen playerview is null return");
                } else if (!this.e) {
                    mediaViewPlayerView.pause();
                } else if (mediaViewPlayerView.isPlaying()) {
                    o0.c(TAG, "fullscreen windowfocuse true isPlaying do nothing return");
                } else {
                    MediaViewPlayerView mediaViewPlayerView2 = this.v;
                    if (mediaViewPlayerView2 != null && !mediaViewPlayerView2.isComplete() && !this.v.getIsActiviePause()) {
                        this.v.onClickPlayButton();
                    }
                }
            }
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
        }
    }

    private void s() {
        try {
            p();
            a(this.F, getAllScreenWidth(), getAllScreenHeight());
            com.mbridge.msdk.nativex.view.mbfullview.a.a(getContext()).a(this.E, this.i);
            if (this.i) {
                O();
            } else {
                P();
            }
            this.L.postDelayed(new d(), 3000L);
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
        }
    }

    private void t() {
        this.L = new j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        try {
            if (this.a0 != s.VIDEO || this.w == null) {
                return;
            }
            int allScreenWidth = (int) getAllScreenWidth();
            int iH = t0.h(getContext());
            if (this.h) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.F.getLayoutParams();
                layoutParams.width = allScreenWidth;
                layoutParams.height = iH;
                layoutParams.addRule(13);
                this.F.setLayoutParams(layoutParams);
            } else {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.w.getLayoutParams();
                layoutParams2.width = this.O;
                layoutParams2.height = this.N;
                layoutParams2.addRule(13);
                this.w.setLayoutParams(layoutParams2);
            }
            S();
            if (this.h) {
                a(this.v, allScreenWidth, iH);
            } else {
                a(this.v, this.O, this.N);
            }
        } catch (Exception e2) {
            o0.b(TAG, e2.getMessage());
        }
    }

    private void v() {
        String[] strArrSplit;
        try {
            CampaignEx campaignEx = this.M;
            if (campaignEx == null || y0.a(campaignEx.getVideoResolution()) || (strArrSplit = this.M.getVideoResolution().split(VastAttributes.HORIZONTAL_POSITION)) == null || strArrSplit.length != 2) {
                return;
            }
            String str = strArrSplit[0];
            String str2 = strArrSplit[1];
            double dM = t0.m(str);
            double dM2 = t0.m(str2);
            if (dM <= 0.0d || dM2 <= 0.0d) {
                return;
            }
            this.P = dM;
            this.Q = dM2;
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
        }
    }

    private void w() {
        int iA = g0.a(getContext(), "mbridge_nativex_mbmediaview", "layout");
        if (!g0.a(iA)) {
            o0.b(TAG, "can not find mediaview resource");
            return;
        }
        View viewInflate = LayoutInflater.from(getContext()).inflate(iA, (ViewGroup) null);
        this.x = (RelativeLayout) viewInflate.findViewById(g0.a(getContext(), "mbridge_rl_mediaview_root", "id"));
        this.w = (RelativeLayout) viewInflate.findViewById(g0.a(getContext(), "mbridge_ll_playerview_container", "id"));
        this.B = (MyImageView) viewInflate.findViewById(g0.a(getContext(), "mbridge_my_big_img", "id"));
        this.C = (ProgressBar) viewInflate.findViewById(g0.a(getContext(), "mbridge_native_pb", "id"));
        this.y = (RelativeLayout) viewInflate.findViewById(g0.a(getContext(), "mbridge_nativex_webview_layout", "id"));
        this.z = (WindVaneWebViewForNV) viewInflate.findViewById(g0.a(getContext(), "mbridge_nativex_webview_layout_webview", "id"));
        this.x.setClickable(true);
        addView(viewInflate, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        RelativeLayout relativeLayout;
        int i2;
        int i3;
        try {
            if (this.a0 == s.GIF) {
                int i4 = this.O;
                if (i4 != 0 && (i2 = this.S) != 0 && (i3 = this.R) != 0) {
                    int i5 = (i4 * i2) / i3;
                    RelativeLayout relativeLayout2 = this.y;
                    if (relativeLayout2 != null && i5 != 0) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout2.getLayoutParams();
                        layoutParams.width = this.O;
                        layoutParams.height = i5;
                        layoutParams.addRule(13);
                        this.y.setLayoutParams(layoutParams);
                    }
                } else if (i4 != 0 && (relativeLayout = this.y) != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                    int i6 = this.O;
                    layoutParams2.width = i6;
                    layoutParams2.height = (i6 * LevelPlayAdError.ERROR_CODE_LOAD_FAILED_ALREADY_CALLED) / 1200;
                    layoutParams2.addRule(13);
                    this.y.setLayoutParams(layoutParams2);
                }
            }
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
        }
    }

    private boolean y() {
        try {
            com.mbridge.msdk.setting.l unitSetting = getUnitSetting();
            if (unitSetting == null) {
                return false;
            }
            int iL = unitSetting.L();
            if (iL == 1) {
                return t0.n(getContext());
            }
            if (iL == 2) {
                return false;
            }
            if (iL == 3) {
                return !q0.a().a("s_a_w_n_c", true) || t0.l(getContext());
            }
            return t0.n(getContext());
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
        }
    }

    private void z() {
        try {
            MediaViewPlayerView mediaViewPlayerView = this.v;
            if (mediaViewPlayerView != null) {
                mediaViewPlayerView.pause();
            }
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
        }
    }

    public void setOnMediaViewListener(OnMBMediaViewListenerPlus onMBMediaViewListenerPlus) {
        this.c0 = onMBMediaViewListenerPlus;
    }

    private static final class u implements com.mbridge.msdk.nativex.listener.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        WeakReference<BaseMBMediaView> f5284a;

        public u(BaseMBMediaView baseMBMediaView) {
            this.f5284a = new WeakReference<>(baseMBMediaView);
        }

        @Override // com.mbridge.msdk.nativex.listener.a
        public void a() {
            BaseMBMediaView baseMBMediaView = this.f5284a.get();
            if (baseMBMediaView != null) {
                baseMBMediaView.K();
            }
        }

        @Override // com.mbridge.msdk.nativex.listener.a
        public void b() {
            BaseMBMediaView baseMBMediaView = this.f5284a.get();
            if (baseMBMediaView != null) {
                baseMBMediaView.G();
            }
        }

        @Override // com.mbridge.msdk.nativex.listener.a
        public void c() {
            BaseMBMediaView baseMBMediaView = this.f5284a.get();
            if (baseMBMediaView != null) {
                baseMBMediaView.H();
            }
        }

        @Override // com.mbridge.msdk.nativex.listener.a
        public void d() {
            BaseMBMediaView baseMBMediaView = this.f5284a.get();
            if (baseMBMediaView != null) {
                baseMBMediaView.J();
            }
        }

        @Override // com.mbridge.msdk.nativex.listener.a
        public void a(String str) {
            BaseMBMediaView baseMBMediaView = this.f5284a.get();
            if (baseMBMediaView != null) {
                baseMBMediaView.a(str);
            }
        }

        @Override // com.mbridge.msdk.nativex.listener.a
        public void b(String str) {
            BaseMBMediaView baseMBMediaView = this.f5284a.get();
            if (baseMBMediaView != null) {
                baseMBMediaView.b(str);
            }
        }
    }

    private void d() {
        try {
            this.v.showSoundIndicator(this.l);
            this.v.showProgressView(this.k);
            OnMBMediaViewListener onMBMediaViewListener = this.b0;
            if (onMBMediaViewListener != null) {
                onMBMediaViewListener.onExitFullscreen();
            }
            OnMBMediaViewListenerPlus onMBMediaViewListenerPlus = this.c0;
            if (onMBMediaViewListenerPlus != null) {
                onMBMediaViewListenerPlus.onExitFullscreen();
            }
            MediaEvents mediaEvents = this.s;
            if (mediaEvents != null) {
                mediaEvents.playerStateChange(PlayerState.NORMAL);
            }
        } catch (Exception e2) {
            o0.b(TAG, e2.getMessage());
        }
    }

    private void c() {
        try {
            OnMBMediaViewListener onMBMediaViewListener = this.b0;
            if (onMBMediaViewListener != null) {
                onMBMediaViewListener.onEnterFullscreen();
            }
            OnMBMediaViewListenerPlus onMBMediaViewListenerPlus = this.c0;
            if (onMBMediaViewListenerPlus != null) {
                onMBMediaViewListenerPlus.onEnterFullscreen();
            }
            MediaEvents mediaEvents = this.s;
            if (mediaEvents != null) {
                mediaEvents.playerStateChange(PlayerState.FULLSCREEN);
            }
        } catch (Exception e2) {
            o0.b(TAG, e2.getMessage());
        }
    }

    private void b(Context context) {
        try {
            t();
            w();
            this.k0 = context;
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Campaign campaign, String str) {
        try {
            OnMBMediaViewListener onMBMediaViewListener = this.b0;
            if (onMBMediaViewListener != null) {
                onMBMediaViewListener.onFinishRedirection(campaign, str);
            }
            OnMBMediaViewListenerPlus onMBMediaViewListenerPlus = this.c0;
            if (onMBMediaViewListenerPlus != null) {
                onMBMediaViewListenerPlus.onFinishRedirection(campaign, str);
            }
        } catch (Exception e2) {
            o0.b(TAG, e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Campaign campaign, String str) {
        try {
            OnMBMediaViewListener onMBMediaViewListener = this.b0;
            if (onMBMediaViewListener != null) {
                onMBMediaViewListener.onRedirectionFailed(campaign, str);
            }
            OnMBMediaViewListenerPlus onMBMediaViewListenerPlus = this.c0;
            if (onMBMediaViewListenerPlus != null) {
                onMBMediaViewListenerPlus.onRedirectionFailed(campaign, str);
            }
        } catch (Exception e2) {
            o0.b(TAG, e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Campaign campaign, String str) {
        try {
            OnMBMediaViewListener onMBMediaViewListener = this.b0;
            if (onMBMediaViewListener != null) {
                onMBMediaViewListener.onStartRedirection(campaign, str);
            }
            OnMBMediaViewListenerPlus onMBMediaViewListenerPlus = this.c0;
            if (onMBMediaViewListenerPlus != null) {
                onMBMediaViewListenerPlus.onStartRedirection(campaign, str);
            }
        } catch (Exception e2) {
            o0.b(TAG, e2.getMessage());
        }
    }

    protected void a(String str) {
        try {
            if (TextUtils.isEmpty(str) || this.n.contains(str)) {
                return;
            }
            this.n.add(str);
            OnMBMediaViewListenerPlus onMBMediaViewListenerPlus = this.c0;
            if (onMBMediaViewListenerPlus != null) {
                onMBMediaViewListenerPlus.onVideoComplete();
            }
        } catch (Exception e2) {
            o0.b(TAG, e2.getMessage());
        }
    }

    protected void b(String str) {
        try {
            if (TextUtils.isEmpty(str) || this.m.contains(str)) {
                return;
            }
            this.m.add(str);
            OnMBMediaViewListener onMBMediaViewListener = this.b0;
            if (onMBMediaViewListener != null) {
                onMBMediaViewListener.onVideoStart();
            }
            OnMBMediaViewListenerPlus onMBMediaViewListenerPlus = this.c0;
            if (onMBMediaViewListenerPlus != null) {
                onMBMediaViewListenerPlus.onVideoStart();
            }
        } catch (Exception e2) {
            o0.b(TAG, e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        com.mbridge.msdk.foundation.entity.m mVar;
        try {
            com.mbridge.msdk.foundation.db.n nVarA = com.mbridge.msdk.foundation.db.n.a(com.mbridge.msdk.foundation.db.g.a(getContext()));
            if (!TextUtils.isEmpty(this.M.getNoticeUrl())) {
                int iS = k0.s(getContext());
                mVar = new com.mbridge.msdk.foundation.entity.m("2000021", iS, this.M.getNoticeUrl(), str, k0.a(getContext(), iS));
            } else if (TextUtils.isEmpty(this.M.getClickURL())) {
                mVar = null;
            } else {
                int iS2 = k0.s(getContext());
                mVar = new com.mbridge.msdk.foundation.entity.m("2000021", iS2, this.M.getClickURL(), str, k0.a(getContext(), iS2));
            }
            if (mVar != null) {
                mVar.b(this.M.getId());
                mVar.v(this.M.getVideoUrlEncode());
                mVar.m(str);
                mVar.n(this.M.getRequestId());
                mVar.o(this.M.getRequestIdNotice());
                mVar.u(getUnitId());
                nVarA.a(mVar);
            }
        } catch (Exception e2) {
            o0.b(TAG, e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        h();
    }

    private s a(boolean z) {
        s sVar;
        try {
            CampaignEx campaignEx = this.M;
            if (campaignEx == null) {
                return null;
            }
            if (y0.a(campaignEx.getVideoUrlEncode())) {
                s sVar2 = y0.b(this.M.getImageUrl()) ? s.BIG_IMAGE : null;
                if (!y0.b(this.M.getGifUrl())) {
                    return sVar2;
                }
                if (y0.a(this.M.getImageUrl())) {
                    sVar2 = s.GIF;
                }
                this.z.setWebViewClient(new y(this));
                j();
                return sVar2;
            }
            if (this.g && this.W != null) {
                if (y0.b(this.M.getVideoUrlEncode()) && y0.a(this.M.getImageUrl())) {
                    sVar = s.VIDEO;
                } else {
                    if (!y0.b(this.M.getVideoUrlEncode()) || !y0.b(this.M.getImageUrl())) {
                        return null;
                    }
                    if (com.mbridge.msdk.videocommon.download.l.a(this.W, getReadyRate())) {
                        return s.VIDEO;
                    }
                    s sVar3 = s.BIG_IMAGE;
                    if (!z || !this.f5267a) {
                        return sVar3;
                    }
                    this.W.b(new x(this));
                    return sVar3;
                }
            } else {
                sVar = s.BIG_IMAGE;
            }
            return sVar;
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
            return s.BIG_IMAGE;
        }
    }

    private void b() {
        try {
            if (this.M == null) {
                o0.c(TAG, "campaign is null addPlayerView return");
            }
            MediaViewPlayerView mediaViewPlayerView = this.v;
            if (mediaViewPlayerView != null && mediaViewPlayerView.getParent() != null) {
                ((ViewGroup) this.v.getParent()).removeView(this.v);
            }
            Z();
            MediaViewPlayerView mediaViewPlayerView2 = new MediaViewPlayerView(getContext());
            this.v = mediaViewPlayerView2;
            mediaViewPlayerView2.showProgressView(this.k);
            this.v.showSoundIndicator(this.l);
            if (this.f) {
                this.v.openSound();
            } else {
                this.v.closeSound();
            }
            this.v.setAllowLoopPlay(this.b);
            this.v.initPlayerViewData(getPlayUrl(), this.M, y(), this, this.W, getUnitId());
            this.v.setOnMediaViewPlayerViewListener(new u(this));
            this.w.addView(this.v, -1, -1);
            T();
            AdSession adSession = this.q;
            if (adSession != null) {
                MediaViewPlayerView mediaViewPlayerView3 = this.v;
                if (mediaViewPlayerView3 != null) {
                    mediaViewPlayerView3.registerView(adSession);
                }
                this.r = AdEvents.createAdEvents(this.q);
                this.s = MediaEvents.createMediaEvents(this.q);
                this.q.start();
                this.r.loaded(VastProperties.createVastPropertiesForNonSkippableMedia(true, Position.STANDALONE));
                MediaViewPlayerView mediaViewPlayerView4 = this.v;
                if (mediaViewPlayerView4 != null) {
                    mediaViewPlayerView4.setVideoEvents(this.s);
                }
                try {
                    AdEvents adEvents = this.r;
                    if (adEvents != null) {
                        adEvents.impressionOccurred();
                    }
                } catch (Exception e2) {
                    o0.a("omsdk", e2.getMessage());
                }
            }
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
        }
    }

    private boolean c(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view) {
        try {
            CampaignEx campaignEx = this.M;
            return !b1.a(view, campaignEx == null ? 0 : campaignEx.getImpReportType());
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
            return false;
        }
    }

    private void b(int i2) {
        CampaignEx.b mediaViewHolder;
        Map<Integer, String> map;
        try {
            CampaignEx campaignEx = this.M;
            if (campaignEx == null || (mediaViewHolder = campaignEx.getMediaViewHolder()) == null || mediaViewHolder.b || (map = mediaViewHolder.f4929a) == null || map.size() <= 0) {
                return;
            }
            Map<Integer, String> map2 = mediaViewHolder.f4929a;
            Iterator<Map.Entry<Integer, String>> it = map2.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, String> next = it.next();
                Integer key = next.getKey();
                String value = next.getValue();
                if (i2 >= key.intValue() && !TextUtils.isEmpty(value)) {
                    Context context = getContext();
                    CampaignEx campaignEx2 = this.M;
                    com.mbridge.msdk.click.a.a(context, campaignEx2, campaignEx2.getCampaignUnitId(), value, false, false);
                    it.remove();
                }
            }
            if (map2.size() <= 0) {
                mediaViewHolder.b = true;
            }
        } catch (Exception e2) {
            o0.b(TAG, e2.getMessage());
        }
    }

    private void b(boolean z) {
        try {
            int nvT2 = this.M.getNvT2();
            if (this.A == null) {
                WindVaneWebViewForNV windVaneWebViewForNV = new WindVaneWebViewForNV(getContext());
                this.A = windVaneWebViewForNV;
                windVaneWebViewForNV.setObject(this);
                this.A.setBackListener(new e());
                this.A.setWebViewListener(new f());
            }
            if (nvT2 != 3) {
                if (nvT2 == 4) {
                    this.f0 = true;
                    CampaignEx campaignEx = this.M;
                    if (campaignEx != null) {
                        com.mbridge.msdk.foundation.same.webview.a aVar = new com.mbridge.msdk.foundation.same.webview.a(campaignEx);
                        aVar.a(this.M.getAppName());
                        this.A.setDownloadListener(aVar);
                        this.A.setFilter(new v(null));
                        return;
                    }
                    return;
                }
                return;
            }
            String str = this.M.getendcard_url();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.M.getMediaViewHolder();
            if (str.contains(".zip") && str.contains(ResourceManager.KEY_MD5FILENAME)) {
                String h5ResAddress = H5DownLoadManager.getInstance().getH5ResAddress(str);
                if (y0.b(h5ResAddress)) {
                    this.f0 = true;
                    MintegralNetworkBridge.webviewLoadUrl(this.A, h5ResAddress);
                    return;
                }
                return;
            }
            String htmlContentFromUrl = HTMLResourceManager.getInstance().getHtmlContentFromUrl(str);
            if (y0.b(htmlContentFromUrl)) {
                o0.a(TAG, "load html...");
                this.f0 = true;
                MintegralNetworkBridge.webviewLoadDataWithBaseURL(this.A, str, htmlContentFromUrl, POBCommonConstants.CONTENT_TYPE_HTML, "UTF-8", null);
            }
        } catch (Exception e2) {
            o0.b(TAG, e2.getMessage());
        }
    }

    protected void a() {
        WindowInsets rootWindowInsets;
        CampaignEx campaignEx;
        try {
            if (getRootView() != null && (getRootView() instanceof ViewGroup)) {
                BaseView.a aVarHandleViewStyleResult = handleViewStyleResult(getContext());
                if (aVarHandleViewStyleResult == null) {
                    return;
                }
                BaseView fullScreenViewByStyle = getFullScreenViewByStyle(getContext(), aVarHandleViewStyleResult);
                this.E = fullScreenViewByStyle;
                if (fullScreenViewByStyle != null && k()) {
                    com.mbridge.msdk.nativex.view.mbfullview.a aVarA = com.mbridge.msdk.nativex.view.mbfullview.a.a(getContext());
                    BaseView baseView = this.E;
                    aVarA.a(baseView.style, this.M, baseView);
                    this.h = true;
                    this.p = false;
                    MediaViewPlayerView mediaViewPlayerView = this.v;
                    if (mediaViewPlayerView != null) {
                        mediaViewPlayerView.setEnterFullScreen();
                        this.v.setIsActivePause(false);
                    }
                    c();
                    FrameLayout frameLayout = (FrameLayout) getRootView().findViewById(R.id.content);
                    RelativeLayout relativeLayout = new RelativeLayout(getContext());
                    this.D = relativeLayout;
                    relativeLayout.setClickable(true);
                    ViewGroup viewGroup = (ViewGroup) this.v.getParent();
                    int childCount = viewGroup.getChildCount();
                    int i2 = 0;
                    while (i2 < childCount && viewGroup.getChildAt(i2) != this.v) {
                        i2++;
                    }
                    this.K = i2;
                    FrameLayout frameLayout2 = new FrameLayout(getContext());
                    frameLayout2.setId(100);
                    viewGroup.addView(frameLayout2, i2, new ViewGroup.LayoutParams(getWidth(), getHeight()));
                    viewGroup.removeView(this.v);
                    ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    relativeLayout.setId(101);
                    new RelativeLayout.LayoutParams(-1, -1);
                    this.J.addView(this.v, new RelativeLayout.LayoutParams(-1, -1));
                    if (this.J != null && (campaignEx = this.M) != null && campaignEx.getPrivacyButtonTemplateVisibility() != 0) {
                        try {
                            MBAdChoice mBAdChoice = new MBAdChoice(com.mbridge.msdk.foundation.controller.c.m().d());
                            mBAdChoice.setCampaign(this.M);
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 12.0f), t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 12.0f));
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(12);
                            this.J.addView(mBAdChoice, layoutParams2);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (this.u) {
                        a(frameLayout);
                    }
                    frameLayout.addView(relativeLayout, layoutParams);
                    int i3 = i.f5275a[this.E.style.ordinal()] != 2 ? ViewCompat.MEASURED_STATE_MASK : -1;
                    int i4 = this.t;
                    if (i4 != 0) {
                        relativeLayout.setBackgroundColor(i4);
                    } else {
                        relativeLayout.setBackgroundColor(i3);
                    }
                    this.E.setId(103);
                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
                    int[] iArr = new int[2];
                    frameLayout.getLocationInWindow(iArr);
                    int i5 = iArr[1];
                    this.d0 = i5;
                    if (i5 == 0 && (rootWindowInsets = getRootWindowInsets()) != null) {
                        layoutParams3.setMargins(0, rootWindowInsets.getStableInsetTop(), 0, 0);
                    }
                    relativeLayout.addView(this.E, layoutParams3);
                    s();
                    Q();
                    MediaViewPlayerView mediaViewPlayerView2 = this.v;
                    if (mediaViewPlayerView2 != null) {
                        mediaViewPlayerView2.openSound();
                        MediaViewPlayerView mediaViewPlayerView3 = this.v;
                        mediaViewPlayerView3.setMediaViewPlayListener(new p(mediaViewPlayerView3));
                    }
                    b(false);
                    F();
                    return;
                }
                return;
            }
            o0.c(TAG, "rootView is null");
        } catch (Exception e3) {
            o0.b(TAG, e3.getMessage());
        }
    }

    private void a(FrameLayout frameLayout) {
        BitmapDrawable bitmapDrawableA;
        if (frameLayout == null || (bitmapDrawableA = com.mbridge.msdk.foundation.controller.c.m().a(getUnitId(), this.M.getAdType())) == null) {
            return;
        }
        ImageView imageView = new ImageView(com.mbridge.msdk.foundation.controller.c.m().d());
        t0.a(imageView, bitmapDrawableA, getResources().getDisplayMetrics());
        this.E.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
        AdSession adSession = this.q;
        if (adSession != null) {
            adSession.addFriendlyObstruction(imageView, FriendlyObstructionPurpose.OTHER, null);
        }
    }

    private void a(View view, float f2, float f3) {
        if (view == null) {
            return;
        }
        try {
            double d2 = this.P;
            double d3 = 0.0d;
            if (d2 > 0.0d) {
                double d4 = this.Q;
                if (d4 > 0.0d) {
                    double d5 = d2 / d4;
                    if (f2 > 0.0f && f3 > 0.0f) {
                        d3 = f2 / f3;
                    }
                    double dA = t0.a(Double.valueOf(d5));
                    double dA2 = t0.a(Double.valueOf(d3));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.w.getLayoutParams();
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    boolean z = c(getContext()) && this.i;
                    int i2 = -1;
                    if (dA > dA2) {
                        double d6 = (((double) f2) * this.Q) / this.P;
                        layoutParams2.width = -1;
                        if (!z) {
                            i2 = (int) d6;
                        }
                        layoutParams2.height = i2;
                        layoutParams2.addRule(13);
                        layoutParams.width = this.O;
                        layoutParams.height = (int) d6;
                        layoutParams.addRule(13);
                    } else if (dA < dA2) {
                        double d7 = ((double) f3) * d5;
                        layoutParams2.width = z ? -1 : (int) d7;
                        layoutParams2.height = -1;
                        layoutParams2.addRule(13);
                        layoutParams.width = (int) d7;
                        layoutParams.height = this.N;
                        layoutParams.addRule(13);
                    } else {
                        layoutParams2.width = -1;
                        layoutParams2.height = -1;
                        layoutParams.width = this.O;
                        layoutParams.height = this.N;
                        layoutParams.addRule(13);
                    }
                    if (!this.h) {
                        this.w.setLayoutParams(layoutParams);
                    }
                    view.setLayoutParams(layoutParams2);
                    return;
                }
            }
            setPlayViewParamsDefault(view);
        } catch (Throwable th) {
            o0.b(TAG, th.getMessage());
        }
    }

    private void a(int i2, int i3) {
        CampaignEx.b mediaViewHolder;
        try {
            CampaignEx campaignEx = this.M;
            if (campaignEx == null || (mediaViewHolder = campaignEx.getMediaViewHolder()) == null || mediaViewHolder.h || i3 == 0) {
                return;
            }
            List<Map<Integer, String>> listO = this.M.getNativeVideoTracking().o();
            int i4 = ((i2 + 1) * 100) / i3;
            if (listO != null) {
                int i5 = 0;
                while (i5 < listO.size()) {
                    Map<Integer, String> map = listO.get(i5);
                    if (map != null && map.size() > 0) {
                        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
                        while (it.hasNext()) {
                            Map.Entry<Integer, String> next = it.next();
                            int iIntValue = next.getKey().intValue();
                            String value = next.getValue();
                            if (iIntValue <= i4 && !TextUtils.isEmpty(value)) {
                                Context context = getContext();
                                CampaignEx campaignEx2 = this.M;
                                com.mbridge.msdk.click.a.a(context, campaignEx2, campaignEx2.getCampaignUnitId(), new String[]{value}, false, true);
                                it.remove();
                                listO.remove(i5);
                                i5--;
                            }
                        }
                    }
                    i5++;
                }
                if (listO.size() <= 0) {
                    mediaViewHolder.h = true;
                }
            }
        } catch (Throwable unused) {
            o0.b(TAG, "reportPlayPercentageData error");
        }
    }

    private String a(int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i2);
            String string = jSONObject.toString();
            if (!TextUtils.isEmpty(string)) {
                return Base64.encodeToString(string.getBytes(), 2);
            }
        } catch (Throwable unused) {
            o0.b(TAG, "code to string is error");
        }
        return "";
    }

    private String a(List<CampaignEx> list, String str, String str2) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    JSONArray camplistToJson = CampaignEx.parseCamplistToJson(list);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("campaignList", camplistToJson);
                    jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
                    jSONObject.put("sdk_info", str2);
                    return jSONObject.toString();
                }
            } catch (Exception e2) {
                o0.b(TAG, e2.getMessage());
            }
        }
        return null;
    }

    public BaseMBMediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5267a = true;
        this.b = true;
        this.c = true;
        this.d = true;
        this.e = true;
        this.f = false;
        this.g = true;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = true;
        this.l = true;
        this.m = new ArrayList<>();
        this.n = new ArrayList<>();
        this.o = false;
        this.p = false;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = 0;
        this.u = false;
        this.W = null;
        this.a0 = null;
        this.e0 = false;
        this.f0 = false;
        this.j0 = false;
        this.l0 = false;
        this.m0 = new h();
        b(context);
    }
}
