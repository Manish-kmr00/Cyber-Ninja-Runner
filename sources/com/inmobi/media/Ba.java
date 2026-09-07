package com.inmobi.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Base64;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.webkit.CookieManager;
import android.webkit.JsResult;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.webkit.Profile;
import com.iab.omid.library.inmobi.Omid;
import com.iab.omid.library.inmobi.adsession.AdSessionContext;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import com.inmobi.adquality.models.AdQualityControl;
import com.inmobi.ads.WatermarkData;
import com.inmobi.ads.rendering.InMobiAdActivity;
import com.inmobi.commons.core.configs.AdConfig;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.internal.partials.InMobiNetworkBridge;
import com.smaato.sdk.richmedia.mraid.bridge.MraidJsMethods;
import com.yandex.div.core.DivActionHandler;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class Ba extends H1 implements r, M1, GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, InterfaceC3542r9, xd, InterfaceC3386ga {
    public static final C3516pa M0 = new C3516pa();
    public static final C3488na N0 = new C3488na();
    public static final String O0 = "Ba";
    public static final C3391h1 P0 = new C3391h1((Object) Boolean.FALSE, (Function0) C3502oa.f3391a, false, true);
    public boolean A;
    public Map A0;
    public boolean B;
    public final C3543ra B0;
    public boolean C;
    public String C0;
    public boolean D;
    public final C3614wa D0;
    public Xc E;
    public final C3600va E0;
    public boolean F;
    public final C3530qa F0;
    public boolean G;
    public boolean G0;
    public String H;
    public J2 H0;
    public final AtomicBoolean I;
    public final C3628xa I0;
    public final Object J;
    public final C3656za J0;
    public final Object K;
    public final C3642ya K0;
    public boolean L;
    public yd L0;
    public final boolean M;
    public View N;
    public WebChromeClient.CustomViewCallback O;
    public int P;
    public long Q;
    public String R;
    public final AtomicBoolean S;
    public final Ia T;
    public String U;
    public Map V;
    public L1 W;
    public r a0;
    public final byte b;
    public boolean b0;
    public final Set c;
    public boolean c0;
    public String d;
    public K d0;
    public final boolean e;
    public Tc e0;
    public String f;
    public final boolean f0;
    public long g;
    public int g0;
    public final Ea h;
    public String h0;
    public final L4 i;
    public int[] i0;
    public byte j;
    public long j0;
    public Ba k;
    public int k0;
    public WeakReference l;
    public int l0;
    public WeakReference m;
    public int m0;
    public Da n;
    public final F6 n0;
    public final Aa o;
    public final GestureDetector o0;
    public String p;
    public boolean p0;
    public G6 q;
    public A3 q0;
    public N6 r;
    public InterfaceC3635y3 r0;
    public M6 s;
    public String s0;
    public AdConfig t;
    public C3529q9 t0;
    public boolean u;
    public Z u0;
    public boolean v;
    public final AtomicBoolean v0;
    public T3 w;
    public boolean w0;
    public Ua x;
    public String x0;
    public JSONObject y;
    public boolean y0;
    public JSONObject z;
    public Ad z0;

    /* JADX WARN: Illegal instructions before constructor call */
    public Ba(Context context, byte b, Set set, String str, boolean z, String landingScheme, long j, Ea ea, L4 l4, int i) {
        set = (i & 4) != 0 ? null : set;
        str = (i & 8) != 0 ? null : str;
        z = (i & 16) != 0 ? false : z;
        landingScheme = (i & 32) != 0 ? "DEFAULT" : landingScheme;
        j = (i & 64) != 0 ? -1L : j;
        ea = (i & 128) != 0 ? null : ea;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(landingScheme, "landingScheme");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        super(applicationContext);
        this.b = b;
        this.c = set;
        this.d = str;
        this.e = z;
        this.f = landingScheme;
        this.g = j;
        this.h = ea;
        this.i = l4;
        this.l = new WeakReference(null);
        this.o = new Aa();
        this.p = Profile.DEFAULT_PROFILE_NAME;
        this.A = true;
        this.B = true;
        this.D = true;
        this.E = Xc.UNKNOWN;
        this.I = new AtomicBoolean(false);
        this.J = new Object();
        this.K = new Object();
        this.M = true;
        this.P = -1;
        this.Q = Long.MIN_VALUE;
        this.S = new AtomicBoolean(false);
        this.l0 = Integer.MIN_VALUE;
        this.m0 = Integer.MIN_VALUE;
        this.v0 = new AtomicBoolean(true);
        this.B0 = new C3543ra(this);
        this.C0 = "html";
        this.D0 = new C3614wa(this);
        this.E0 = new C3600va(this);
        this.F0 = new C3530qa(this);
        String TAG = O0;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        toString();
        M0.getClass();
        P0.a();
        this.a0 = this;
        this.f0 = true;
        this.t0 = new C3529q9();
        this.n0 = new F6(this);
        GestureDetector gestureDetector = new GestureDetector(context, this);
        gestureDetector.setOnDoubleTapListener(this);
        gestureDetector.setIsLongpressEnabled(b == 1);
        this.o0 = gestureDetector;
        if (ea != null) {
            this.T = new Ia(ea);
        }
        EnumC3396h6 enumC3396h6 = C3442ka.f3360a;
        C3442ka.a(this, l4);
        this.I0 = new C3628xa(this);
        this.J0 = new C3656za(this);
        this.K0 = new C3642ya(this);
        this.L0 = (this.G0 || AbstractC3420j2.a(context)) ? new yd(0, 44, 44, 0) : new yd(0, 0, 0, 0);
    }

    public static final void a(Ba renderView, byte[] overlayBytes, WatermarkData watermarkData) {
        Intrinsics.checkNotNullParameter(renderView, "this$0");
        Intrinsics.checkNotNullParameter(overlayBytes, "$overlayBytes");
        Intrinsics.checkNotNullParameter(watermarkData, "$watermarkData");
        if (renderView.S.get()) {
            return;
        }
        L4 l4 = renderView.i;
        if (l4 != null) {
            String TAG = O0;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "adding overlay to renderview");
        }
        Context context = renderView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        FrameLayout overlayLayout = hd.a(context, overlayBytes, watermarkData.getAlpha());
        Intrinsics.checkNotNullParameter(overlayLayout, "overlayLayout");
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        if (renderView.getParent() != null) {
            ViewParent parent = renderView.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).addView(overlayLayout, 0);
        }
        renderView.getViewableAd().a(overlayLayout, FriendlyObstructionPurpose.NOT_VISIBLE);
        renderView.S.set(true);
    }

    public static /* synthetic */ void getAdType$annotations() {
    }

    public static /* synthetic */ void getCloseAssetArea$annotations() {
    }

    public static /* synthetic */ void getImpressionType$annotations() {
    }

    public static /* synthetic */ void getMarkupType$annotations() {
    }

    public static /* synthetic */ void getMarkupTypeAdUnit$annotations() {
    }

    private final AdConfig.MraidConfig getMraidConfig() {
        AdConfig adConfig = this.t;
        if (adConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdConfig");
            adConfig = null;
        }
        return adConfig.getMraid();
    }

    public static /* synthetic */ void getPlacementType$annotations() {
    }

    public static /* synthetic */ void getViewState$annotations() {
    }

    private final int getVisibilityTrackingMinPercentage() {
        AdConfig adConfig = null;
        if (Intrinsics.areEqual("audio", getAdType())) {
            AdConfig adConfig2 = this.t;
            if (adConfig2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdConfig");
            } else {
                adConfig = adConfig2;
            }
            return adConfig.getViewability().getAudioImpressionMinPercentageViewed();
        }
        AdConfig adConfig3 = this.t;
        if (adConfig3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdConfig");
        } else {
            adConfig = adConfig3;
        }
        return adConfig.getViewability().getWebImpressionMinPercentageViewed();
    }

    @Override // com.inmobi.media.r
    public final void b() {
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).a(str, AbstractC3474ma.a(this, str, "TAG", "destroyContainer "));
        }
        if (this.I.get()) {
            return;
        }
        if (!this.D) {
            this.D = true;
            return;
        }
        this.I.set(true);
        Ad ad = this.z0;
        if (ad != null) {
            ad.a();
        }
        J2 j2 = this.H0;
        if (j2 != null) {
            j2.b();
        }
        this.L = true;
        this.P = -1;
        removeJavascriptInterface("sdkController");
        M6 m6 = this.s;
        AdConfig adConfig = null;
        if (m6 != null) {
            C3638y6 c3638y6 = m6.d;
            if (c3638y6 != null) {
                c3638y6.a();
            }
            m6.d = null;
            C3638y6 c3638y7 = m6.e;
            if (c3638y7 != null) {
                c3638y7.a();
            }
            m6.e = null;
            C3638y6 c3638y8 = m6.f;
            if (c3638y8 != null) {
                c3638y8.a();
            }
            m6.f = null;
        }
        this.l.clear();
        WeakReference weakReference = this.m;
        if (weakReference != null) {
            weakReference.clear();
        }
        Tc tc = this.e0;
        if (tc != null) {
            tc.e();
        }
        Tc tc2 = this.e0;
        if (tc2 != null) {
            tc2.a();
        }
        setFriendlyViews(null);
        this.r0 = null;
        this.n = null;
        this.a0 = null;
        this.d0 = null;
        ViewParent parent = getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(this);
            removeAllViews();
        }
        AdConfig adConfig2 = this.t;
        if (adConfig2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdConfig");
        } else {
            adConfig = adConfig2;
        }
        AdConfig.OmidConfig omidConfig = adConfig.getViewability().getOmidConfig();
        if (this.f0 && omidConfig.isOmidEnabled()) {
            AbstractC3473m9.f3376a.getClass();
            if (Omid.isActive()) {
                new Fa(this, omidConfig.getWebViewRetainTime()).a();
                return;
            }
        }
        destroy();
    }

    public final void c(boolean z) {
        Z z2;
        AdQualityControl adQualityControl;
        Activity activity;
        Z z3;
        AdQualityControl adQualityControl2;
        Xc xc = z ? Xc.VISIBLE : Xc.HIDDEN;
        if (this.E != xc) {
            L4 l4 = this.i;
            if (l4 != null) {
                String TAG = O0;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((M4) l4).a(TAG, "handleVisibilityChange " + xc + ' ' + this);
            }
            if (this.L) {
                return;
            }
            this.E = xc;
            if (z) {
                getListener().i(this);
            }
            L4 l5 = this.i;
            if (l5 != null) {
                String TAG2 = O0;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((M4) l5).a(TAG2, "fireViewableChange " + this + ' ' + z);
            }
            b("window.mraidview.broadcastEvent('viewableChange'," + z + ");");
            Z z4 = this.u0;
            if (z4 != null) {
                Xc adViewableStatus = this.E;
                Intrinsics.checkNotNullParameter(adViewableStatus, "adViewableStatus");
                z4.h = adViewableStatus;
            }
            L4 l6 = this.i;
            if (l6 != null) {
                String str = O0;
                ((M4) l6).a(str, O5.a(str, "TAG", "fireAQSession - ").append(getAdType()).append(" type - sdk - ").append(Build.VERSION.SDK_INT).toString());
            }
            if (!Intrinsics.areEqual(getAdType(), com.safedk.android.analytics.brandsafety.l.w) || Build.VERSION.SDK_INT < 29 || (activity = (Activity) this.l.get()) == null) {
                Z z5 = this.u0;
                if (z5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adQualityManager");
                    z2 = null;
                } else {
                    z2 = z5;
                }
                z2.getClass();
                Intrinsics.checkNotNullParameter(this, "adView");
                if (!z2.a()) {
                    z2.a("session state invalid");
                    return;
                }
                z2.a("session start trigger...");
                z2.c.set(true);
                AdQualityControl adQualityControl3 = z2.g;
                if (adQualityControl3 == null || !adQualityControl3.getTakeScreenshot() || (adQualityControl = z2.g) == null) {
                    return;
                }
                z2.a(this, (long) (adQualityControl.getScreenshotDelayInSeconds() * 1000), false, (C3543ra) null);
                return;
            }
            Z z6 = this.u0;
            if (z6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adQualityManager");
                z3 = null;
            } else {
                z3 = z6;
            }
            z3.getClass();
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (!z3.a()) {
                z3.a("session state invalid");
                return;
            }
            z3.a("session start trigger...");
            z3.c.set(true);
            AdQualityControl adQualityControl4 = z3.g;
            if (adQualityControl4 == null || !adQualityControl4.getTakeScreenshot() || (adQualityControl2 = z3.g) == null) {
                return;
            }
            z3.a(activity, (long) (adQualityControl2.getScreenshotDelayInSeconds() * 1000), false, (C3543ra) null);
        }
    }

    public final void d(String str) {
        Ia ia = this.T;
        if (ia != null) {
            ia.b();
        }
        L4 l4 = this.i;
        if (l4 != null) {
            String str2 = O0;
            ((M4) l4).a(str2, AbstractC3474ma.a(this, str2, "TAG", "loadUrlInWebView "));
        }
        this.L = false;
        if (this.I.get() || str == null) {
            return;
        }
        InMobiNetworkBridge.webviewLoadUrl(this, str);
    }

    @Override // com.inmobi.media.H1, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.i, this, me);
        return super.dispatchTouchEvent(me);
    }

    public final void e(String str) {
        int iHashCode;
        L4 l4 = this.i;
        if (l4 != null) {
            String str2 = O0;
            ((M4) l4).c(str2, AbstractC3474ma.a(this, str2, "TAG", "processExpandRequest "));
        }
        if (!Intrinsics.areEqual(Profile.DEFAULT_PROFILE_NAME, this.p) && !Intrinsics.areEqual("Resized", this.p)) {
            L4 l5 = this.i;
            if (l5 != null) {
                String str3 = O0;
                ((M4) l5).b(str3, O5.a(str3, "TAG", "Render view state must be either DEFAULT or RESIZED to admit the expand request. Current state:").append(this.p).toString());
                return;
            }
            return;
        }
        this.L = true;
        G6 g6 = this.q;
        if (g6 != null) {
            L4 l6 = g6.c;
            if (l6 != null) {
                String TAG = g6.d;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((M4) l6).c(TAG, "doExpand");
            }
            if (g6.e == null) {
                ViewParent parent = g6.f3079a.getParent();
                ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                g6.e = viewGroup;
                if (viewGroup != null) {
                    g6.f = viewGroup.indexOfChild(g6.f3079a);
                }
            }
            T3 expandProperties = g6.f3079a.getExpandProperties();
            if (URLUtil.isValidUrl(str)) {
                try {
                    Ba container = new Ba(g6.f3079a.getContainerContext(), (byte) 0, null, g6.f3079a.getImpressionId(), false, null, 0L, null, g6.c, 244);
                    container.a(g6.f3079a.getListener(), g6.f3079a.getAdConfig());
                    container.setOriginalRenderView(g6.f3079a);
                    Intrinsics.checkNotNull(str);
                    InMobiNetworkBridge.webviewLoadUrl(container, str);
                    container.setPlacementId(g6.f3079a.getPlacementId());
                    container.setAllowAutoRedirection(g6.f3079a.getAllowAutoRedirection());
                    container.setCreativeId(g6.f3079a.getCreativeId());
                    SparseArray sparseArray = InMobiAdActivity.k;
                    Intrinsics.checkNotNullParameter(container, "container");
                    iHashCode = container.hashCode();
                    InMobiAdActivity.k.put(iHashCode, container);
                    if (expandProperties != null) {
                        container.setUseCustomClose(g6.f3079a.C);
                    }
                } catch (Exception e) {
                    L4 l7 = g6.c;
                    if (l7 != null) {
                        String TAG2 = g6.d;
                        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                        ((M4) l7).a(TAG2, "Exception while initializing Expanded browser", e);
                    }
                    C3339d5 c3339d5 = C3339d5.f3292a;
                    C3339d5.c.a(I4.a(e, "event"));
                    g6.f3079a.getListener().a(g6.f3079a, (short) 2176);
                }
            } else {
                ViewGroup viewGroup2 = g6.e;
                if (viewGroup2 != null) {
                    L4 l8 = g6.c;
                    if (l8 != null) {
                        String TAG3 = g6.d;
                        Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                        ((M4) l8).c(TAG3, "replaceRenderViewWithPlaceholder");
                    }
                    FrameLayout frameLayout = new FrameLayout(g6.f3079a.getContainerContext());
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(g6.f3079a.getWidth(), g6.f3079a.getHeight());
                    frameLayout.setId(65535);
                    viewGroup2.addView(frameLayout, g6.f, layoutParams);
                    viewGroup2.removeView(g6.f3079a);
                }
                SparseArray sparseArray2 = InMobiAdActivity.k;
                Ba container2 = g6.f3079a;
                Intrinsics.checkNotNullParameter(container2, "container");
                iHashCode = container2.hashCode();
                InMobiAdActivity.k.put(iHashCode, container2);
            }
            g6.f3079a.getListener().d();
            Intent intent = new Intent(g6.f3079a.getContainerContext(), (Class<?>) InMobiAdActivity.class);
            intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 102);
            intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_INDEX", iHashCode);
            intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_TYPE", Intrinsics.areEqual(g6.b, "htmlUrl") ? 202 : 200);
            C3517pb.f3400a.a(g6.f3079a.getContainerContext(), intent);
        }
        requestLayout();
        invalidate();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:57:? A[RETURN, SYNTHETIC] */
    public final boolean f(String str) {
        L4 l4;
        L4 l5 = this.i;
        if (l5 != null) {
            String TAG = O0;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l5).c(TAG, "supports " + this + ' ' + str);
        }
        boolean z = false;
        if (str == null) {
            return false;
        }
        switch (str.hashCode()) {
            case -1886160473:
                if (!str.equals(MraidJsMethods.PLAY_VIDEO)) {
                    return false;
                }
                return true;
            case -1647691422:
                if (!str.equals("inlineVideo")) {
                    return false;
                }
                if (this.u && this.M) {
                    z = true;
                }
                l4 = this.i;
                if (l4 != null) {
                    return z;
                }
                String TAG2 = O0;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((M4) l4).c(TAG2, "HTML5 video supported:" + z);
                return z;
            case -168584769:
                if (!str.equals("edge-to-edge")) {
                    return false;
                }
                if (getPlacementType() != 1) {
                    L4 l6 = this.i;
                    if (l6 != null) {
                        String TAG3 = O0;
                        Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                        ((M4) l6).b(TAG3, "EDGE_TO_EDGE is only supported for fullscreen ads. supports(edge-to-edge) = false");
                    }
                    return false;
                }
                if (!this.G0) {
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    return AbstractC3420j2.a(context);
                }
                L4 l7 = this.i;
                if (l7 != null) {
                    String TAG4 = O0;
                    Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
                    ((M4) l7).b(TAG4, "Ad is in Immersive mode. supports(edge-to-edge) = false");
                }
                return false;
            case 1137617595:
                if (str.equals(com.ironsource.b9.h.v)) {
                    return this.G0;
                }
                return false;
            case 1509574865:
                if (!str.equals("html5video")) {
                    return false;
                }
                if (this.u) {
                    z = true;
                }
                l4 = this.i;
                if (l4 != null) {
                    return z;
                }
                String TAG5 = O0;
                Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
                ((M4) l4).c(TAG5, "HTML5 video supported:" + z);
                return z;
            case 1642189884:
                if (!str.equals("saveContent")) {
                    return false;
                }
                return true;
            case 1772979069:
                str.equals("redirectFraudDetection");
                return false;
            default:
                return false;
        }
    }

    @Override // com.inmobi.media.H1
    public final U5 g() {
        C3297a6 c3297a6;
        String str;
        J j;
        String strB;
        J j2;
        String strM;
        J j3;
        L4 l4 = this.i;
        if (l4 != null) {
            String str2 = O0;
            ((M4) l4).a(str2, AbstractC3474ma.a(this, str2, "TAG", "initLandingPageHandler "));
        }
        V5 v5 = new V5(this.e, this.f, getAdConfig().getCctEnabled());
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        C3600va c3600va = this.E0;
        C3614wa c3614wa = this.D0;
        if (this.e) {
            c3297a6 = null;
        } else {
            Ea ea = this.h;
            long jL = (ea == null || (j3 = ea.f3060a) == null) ? 0L : j3.l();
            String impressionId = getImpressionId();
            String str3 = impressionId == null ? "" : impressionId;
            Ea ea2 = this.h;
            String str4 = (ea2 == null || (j2 = ea2.f3060a) == null || (strM = j2.m()) == null) ? "" : strM;
            Ea ea3 = this.h;
            String str5 = (ea3 == null || (j = ea3.f3060a) == null || (strB = j.b()) == null) ? "" : strB;
            Ea ea4 = this.h;
            c3297a6 = new C3297a6(jL, str3, str4, str5, (ea4 == null || (str = ea4.b) == null) ? "" : str, ea4 != null ? ea4.e : "", ea4 != null ? ea4.c : "", ea4 != null ? ea4.g : false, this.f);
        }
        return new U5(context, v5, c3600va, c3614wa, this, c3297a6, this.i);
    }

    @Override // com.inmobi.media.r
    public AdConfig getAdConfig() {
        AdConfig adConfig = this.t;
        if (adConfig != null) {
            return adConfig;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mAdConfig");
        return null;
    }

    public final K getAdPodHandler() {
        return this.d0;
    }

    public final Z getAdQualityManager() {
        Z z = this.u0;
        if (z != null) {
            return z;
        }
        Intrinsics.throwUninitializedPropertyAccessException("adQualityManager");
        return null;
    }

    @Override // com.inmobi.media.r
    public String getAdType() {
        return this.U;
    }

    public final boolean getAllowAutoRedirection() {
        return this.c0;
    }

    public final int getArea() {
        return getHeight() * getWidth();
    }

    public final String getBeaconUrl() {
        return this.x0;
    }

    public final yd getCloseAssetArea() {
        return this.L0;
    }

    public final long getConfiguredArea() {
        return this.j0;
    }

    public Context getContainerContext() {
        Activity activity = (Activity) this.l.get();
        if (activity != null) {
            return activity;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return context;
    }

    public final String getContentURL() {
        return this.h0;
    }

    public final String getCreativeID() {
        String creativeId = getCreativeId();
        return creativeId == null ? "" : creativeId;
    }

    @Override // com.inmobi.media.r
    public String getCreativeId() {
        return this.R;
    }

    public final String getCurrentPosition() {
        JSONObject jSONObject = this.z;
        String string = jSONObject != null ? jSONObject.toString() : null;
        return string == null ? "" : string;
    }

    public final Object getCurrentPositionMonitor() {
        return this.K;
    }

    public final int getCurrentRenderingPodAdIndex() {
        K k = this.d0;
        if (k != null) {
            return ((C0) k).k(this);
        }
        return 0;
    }

    @Override // com.inmobi.media.r
    public Object getDataModel() {
        return null;
    }

    public final String getDefaultPosition() {
        JSONObject jSONObject = this.y;
        String string = jSONObject != null ? jSONObject.toString() : null;
        return string == null ? "" : string;
    }

    public final Object getDefaultPositionMonitor() {
        return this.J;
    }

    public final InterfaceC3635y3 getEmbeddedBrowserJSCallbacks() {
        return this.r0;
    }

    public final T3 getExpandProperties() {
        return this.w;
    }

    public Map<View, FriendlyObstructionPurpose> getFriendlyViews() {
        return this.V;
    }

    public final Activity getFullScreenActivity() {
        return (Activity) this.l.get();
    }

    @Override // com.inmobi.media.r
    public InterfaceC3519q getFullScreenEventsListener() {
        return this.I0;
    }

    @Override // com.inmobi.media.r
    public String getImpressionId() {
        return this.d;
    }

    public final byte getImpressionType() {
        return this.j;
    }

    public final String getLandingScheme() {
        return this.f;
    }

    public final Da getListener() {
        Da da = this.n;
        if (da != null) {
            return da;
        }
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).c(str, AbstractC3474ma.a(this, str, "TAG", "listener getter "));
        }
        C3488na c3488na = N0;
        this.n = c3488na;
        return c3488na;
    }

    @Override // com.inmobi.media.r
    public String getMarkupType() {
        return this.C0;
    }

    public final String getMarkupTypeAdUnit() {
        return this.C0;
    }

    public final M6 getMediaProcessor() {
        return this.s;
    }

    public final int getMinimumPixelsPainted() {
        return this.k0;
    }

    public final String getMraidJsString() {
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).c(str, AbstractC3474ma.a(this, str, "TAG", "mraidJsString getter "));
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        String strA = new A9(context, "mraid_js_store").a("mraid_js_string");
        if (strA == null) {
            L4 l5 = this.i;
            if (l5 != null) {
                String TAG = O0;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((M4) l5).a(TAG, "Returning default Mraid Js string.");
            }
            return "var imIsObjValid=function(a){return\"undefined\"!=typeof a&&null!=a?!0:!1},EventListeners=function(a){this.event=a;this.count=0;var b=[];this.add=function(a){b.push(a);++this.count};this.remove=function(a){var f=!1,d=this;b=b.filter(function(b){if(b=b===a)--d.count,f=!0;return!b});return f};this.removeAll=function(){b=[];this.count=0};this.broadcast=function(a){b.forEach(function(f){try{f.apply({},a)}catch(b){}})};this.toString=function(){var c=[a,\":\"];b.forEach(function(a){c.push(\"|\",String(a),\"|\")});\nreturn c.join(\"\")}},InmobiObj=function(){this.listeners=[];this.addEventListener=function(a,b){try{if(imIsObjValid(b)&&imIsObjValid(a)){var c=this.listeners;c[a]||(c[a]=new EventListeners);c[a].add(b);\"micIntensityChange\"==a&&window.imraidview.startListeningMicIntensity();\"deviceMuted\"==a&&window.imraidview.startListeningDeviceMuteEvents();\"deviceVolumeChange\"==a&&window.imraidview.startListeningDeviceVolumeChange();\"volumeChange\"==a&&window.imraidview.startListeningVolumeChange();\"headphones\"==a&&\nwindow.imraidview.startListeningHeadphonePluggedEvents();\"backButtonPressed\"==a&&window.imraidview.startListeningForBackButtonPressedEvent();\"downloadStatusChanged\"==a&&window.imraidview.registerDownloaderCallbacks()}}catch(f){this.log(f)}};this.removeEventListener=function(a,b){if(imIsObjValid(a)){var c=this.listeners;imIsObjValid(c[a])&&(imIsObjValid(b)?c[a].remove(b):c[a].removeAll());\"micIntensityChange\"==a&&0==c[a].count&&window.imraidview.stopListeningMicIntensity();\"deviceMuted\"==a&&0==c[a].count&&\nwindow.imraidview.stopListeningDeviceMuteEvents();\"deviceVolumeChange\"==a&&0==c[a].count&&window.imraidview.stopListeningDeviceVolumeChange();\"volumeChange\"==a&&0==c[a].count&&window.imraidview.stopListeningVolumeChange();\"headphones\"==a&&0==c[a].count&&window.imraidview.stopListeningHeadphonePluggedEvents();\"backButtonPressed\"==a&&0==c[a].count&&window.imraidview.stopListeningForBackButtonPressedEvent();\"downloadStatusChanged\"==a&&0==c[a].count&&window.imraidview.unregisterDownloaderCallbacks()}};\nthis.broadcastEvent=function(a){if(imIsObjValid(a)){for(var b=Array(arguments.length),c=0;c<arguments.length;c++)b[c]=arguments[c];c=b.shift();try{this.listeners[c]&&this.listeners[c].broadcast(b)}catch(f){}}};this.sendSaveContentResult=function(a){if(imIsObjValid(a)){for(var b=Array(arguments.length),c=0;c<arguments.length;c++)if(2==c){var f=arguments[c],f=JSON.parse(f);b[c]=f}else b[c]=arguments[c];f=b[1];\"success\"!=f&&(c=b[0].substring(b[0].indexOf(\"_\")+1),imraid.saveContentIDMap[c]&&delete imraid.saveContentIDMap[c]);\nwindow.imraid.broadcastEvent(b[0],b[1],b[2])}}},__im__iosNativeMessageHandler=void 0;window.webkit&&(window.webkit.messageHandlers&&window.webkit.messageHandlers.nativeMessageHandler)&&(__im__iosNativeMessageHandler=window.webkit.messageHandlers.nativeMessageHandler);\nvar __im__iosNativeCall={nativeCallInFlight:!1,nativeCallQueue:[],executeNativeCall:function(a){this.nativeCallInFlight?this.nativeCallQueue.push(a):(this.nativeCallInFlight=!0,imIsObjValid(__im__iosNativeMessageHandler)?__im__iosNativeMessageHandler.postMessage(a):window.location=a)},nativeCallComplete:function(a){0==this.nativeCallQueue.length?this.nativeCallInFlight=!1:(a=this.nativeCallQueue.shift(),imIsObjValid(__im__iosNativeMessageHandler)?__im__iosNativeMessageHandler.postMessage(a):window.location=\na)}},IOSNativeCall=function(){this.urlScheme=\"\";this.executeNativeCall=function(a){if(imIsObjValid(__im__iosNativeMessageHandler)){f={};f.command=a;f.scheme=this.urlScheme;for(var b={},c=1;c<arguments.length;c+=2)d=arguments[c+1],null!=d&&(b[arguments[c]]=\"\"+d);f.params=b}else for(var f=this.urlScheme+\"://\"+a,d,b=!0,c=1;c<arguments.length;c+=2)d=arguments[c+1],null!=d&&(b?(f+=\"?\",b=!1):f+=\"&\",f+=arguments[c]+\"=\"+escape(d));__im__iosNativeCall.executeNativeCall(f);return\"OK\"};this.nativeCallComplete=\nfunction(a){__im__iosNativeCall.nativeCallComplete(a);return\"OK\"};this.updateKV=function(a,b){this[a]=b;var c=this.broadcastMap[a];c&&this.broadcastEvent(c,b)}};\n(function(){var a=window.mraidview={};a.orientationProperties={allowOrientationChange:!0,forceOrientation:\"none\",direction:\"right\"};var b=[],c=!1;a.detectAndBlockFraud=function(f){a.isPossibleFraud()&&a.fireRedirectFraudBeacon(f);return!1};a.popupBlocked=function(f){a.firePopupBlockedBeacon(f)};a.zeroPad=function(a){var c=\"\";10>a&&(c+=\"0\");return c+a};a.supports=function(a){console.log(\"bridge: supports (MRAID)\");if(\"string\"!=typeof a)window.mraid.broadcastEvent(\"error\",\"Supports method expects string parameter\",\n\"supports\");else return\"false\"!=sdkController.supports(\"window.mraidview\",a)};a.useCustomClose=function(a){try{sdkController.useCustomClose(\"window.mraidview\",a)}catch(c){imraidview.showAlert(\"use CustomClose: \"+c)}};a.close=function(){try{sdkController.close(\"window.mraidview\")}catch(a){imraidview.showAlert(\"close: \"+a)}};a.stackCommands=function(a,d){c?b.push(a):(eval(a),d&&(c=!0))};a.expand=function(a){try{\"undefined\"==typeof a&&(a=null),sdkController.expand(\"window.mraidview\",a)}catch(c){imraidview.showAlert(\"executeNativeExpand: \"+\nc+\", URL = \"+a)}};a.setExpandProperties=function(f){try{f?this.props=f:f=null;if(\"undefined\"!=typeof f.lockOrientation&&null!=f.lockOrientation&&\"undefined\"!=typeof f.orientation&&null!=f.orientation){var c={};c.allowOrientationChange=!f.lockOrientation;c.forceOrientation=f.orientation;a.setOrientationProperties(c)}sdkController.setExpandProperties(\"window.mraidview\",a.stringify(f))}catch(b){imraidview.showAlert(\"executeNativesetExpandProperties: \"+b+\", props = \"+f)}};a.getExpandProperties=function(){try{return eval(\"(\"+\nsdkController.getExpandProperties(\"window.mraidview\")+\")\")}catch(a){imraidview.showAlert(\"getExpandProperties: \"+a)}};a.setOrientationProperties=function(c){try{c?(\"undefined\"!=typeof c.allowOrientationChange&&(a.orientationProperties.allowOrientationChange=c.allowOrientationChange),\"undefined\"!=typeof c.forceOrientation&&(a.orientationProperties.forceOrientation=c.forceOrientation)):c=null,sdkController.setOrientationProperties(\"window.mraidview\",a.stringify(a.orientationProperties))}catch(b){imraidview.showAlert(\"setOrientationProperties: \"+\nb+\", props = \"+c)}};a.getOrientationProperties=function(){return{forceOrientation:a.orientationProperties.forceOrientation,allowOrientationChange:a.orientationProperties.allowOrientationChange}};a.resizeProps=null;a.setResizeProperties=function(c){var b,e;try{b=parseInt(c.width);e=parseInt(c.height);if(isNaN(b)||isNaN(e)||1>b||1>e)throw\"Invalid\";c.width=b;c.height=e;a.resizeProps=c;sdkController.setResizeProperties(\"window.mraidview\",a.stringify(c))}catch(g){window.mraid.broadcastEvent(\"error\",\"Invalid properties.\",\n\"setResizeProperties\")}};a.getResizeProperties=function(){try{return eval(\"(\"+sdkController.getResizeProperties(\"window.mraidview\")+\")\")}catch(a){imraidview.showAlert(\"getResizeProperties: \"+a)}};a.open=function(a){\"undefined\"==typeof a&&(a=null);try{sdkController.open(\"window.mraidview\",a)}catch(c){imraidview.showAlert(\"open: \"+c)}};a.getScreenSize=function(){try{return eval(\"(\"+sdkController.getScreenSize(\"window.mraidview\")+\")\")}catch(a){imraidview.showAlert(\"getScreenSize: \"+a)}};a.getMaxSize=\nfunction(){try{return eval(\"(\"+sdkController.getMaxSize(\"window.mraidview\")+\")\")}catch(a){imraidview.showAlert(\"getMaxSize: \"+a)}};a.getCurrentPosition=function(){try{return eval(\"(\"+sdkController.getCurrentPosition(\"window.mraidview\")+\")\")}catch(a){imraidview.showAlert(\"getCurrentPosition: \"+a)}};a.getDefaultPosition=function(){try{return eval(\"(\"+sdkController.getDefaultPosition(\"window.mraidview\")+\")\")}catch(a){imraidview.showAlert(\"getDefaultPosition: \"+a)}};a.getState=function(){try{return String(sdkController.getState(\"window.mraidview\"))}catch(a){imraidview.showAlert(\"getState: \"+\na)}};a.isViewable=function(){if(imraidview.fallbackViewabilityEnabled())return imraidview.checkFallbackViewable();try{return sdkController.isViewable(\"window.mraidview\")}catch(a){imraidview.showAlert(\"isViewable: \"+a)}};a.getPlacementType=function(){return sdkController.getPlacementType(\"window.mraidview\")};a.close=function(){try{sdkController.close(\"window.mraidview\")}catch(a){imraidview.showAlert(\"close: \"+a)}};\"function\"!=typeof String.prototype.startsWith&&(String.prototype.startsWith=function(a){return 0==\nthis.indexOf(a)});a.playVideo=function(a){var c=\"\";null!=a&&(c=a);try{sdkController.playVideo(\"window.mraidview\",c)}catch(b){imraidview.showAlert(\"playVideo: \"+b)}};a.stringify=function(c){if(\"undefined\"===typeof JSON){var b=\"\",e;if(\"undefined\"==typeof c.length)return a.stringifyArg(c);for(e=0;e<c.length;e++)0<e&&(b+=\",\"),b+=a.stringifyArg(c[e]);return b+\"]\"}return JSON.stringify(c)};a.stringifyArg=function(a){var c,b,g;b=typeof a;c=\"\";if(\"number\"===b||\"boolean\"===b)c+=args;else if(a instanceof Array)c=\nc+\"[\"+a+\"]\";else if(a instanceof Object){b=!0;c+=\"{\";for(g in a)null!==a[g]&&(b||(c+=\",\"),c=c+'\"'+g+'\":',b=typeof a[g],c=\"number\"===b||\"boolean\"===b?c+a[g]:\"function\"===typeof a[g]?c+'\"\"':a[g]instanceof Object?c+this.stringify(args[i][g]):c+'\"'+a[g]+'\"',b=!1);c+=\"}\"}else a=a.replace(/\\\\/g,\"\\\\\\\\\"),a=a.replace(/\"/g,'\\\\\"'),c=c+'\"'+a+'\"';imraidview.showAlert(\"json:\"+c);return c};getPID=function(a){var c=\"\";null!=a&&(\"undefined\"!=typeof a.id&&null!=a.id)&&(c=a.id);return c};a.resize=function(){if(null==\na.resizeProps)window.mraid.broadcastEvent(\"error\",\"Valid resize dimensions must be provided before calling resize\",\"resize\");else try{sdkController.resize(\"window.mraidview\")}catch(c){imraidview.showAlert(\"resize called in bridge\")}};a.storePicture=function(c){console.log(\"bridge: storePicture\");if(\"string\"!=typeof c)window.mraid.broadcastEvent(\"error\",\"storePicture method expects url as string parameter\",\"storePicture\");else{if(a.supports(\"storePicture\"))return!window.confirm(\"Do you want to download the file?\")?\n(window.mraid.broadcastEvent(\"error\",\"Store picture on \"+c+\" was cancelled by user.\",\"storePicture\"),!1):sdkController.storePicture(\"window.mraidview\",c);window.mraid.broadcastEvent(\"error\",\"Store picture on \"+c+\" was cancelled because it is unsupported in this device/app.\",\"storePicture\")}};a.fireMediaTrackingEvent=function(a,c){};a.fireMediaErrorEvent=function(a,c){};a.fireMediaTimeUpdateEvent=function(a,c,b){};a.fireMediaCloseEvent=function(a,c,b){};a.fireMediaVolumeChangeEvent=function(a,c,b){};\na.broadcastEvent=function(){window.mraid.broadcastEvent.apply(window.mraid,arguments)}})();\n(function(){var a=window.mraid=new InmobiObj,b=window.mraidview,c=!1;b.isAdShownToUser=!1;b.onUserInteraction=function(){imraidview.onUserInteraction();c=!0};b.isPossibleFraud=function(){return a.supports(\"redirectFraudDetection\")&&(!b.isAdShownToUser||!c)};b.fireRedirectFraudBeacon=function(a){if(\"undefined\"!=typeof inmobi&&inmobi.recordEvent){var c={};c.trigger=a;c.isAdShown=b.isAdShownToUser.toString();inmobi.recordEvent(135,c)}};b.firePopupBlockedBeacon=function(a){if(\"undefined\"!=typeof inmobi&&\ninmobi.recordEvent){var c={};c.trigger=a;inmobi.recordEvent(136,c)}};window.onbeforeunload=function(){b.detectAndBlockFraud(\"redirect\")};a.addEventListener(\"viewableChange\",function(a){a&&!b.isAdShownToUser&&(b.isAdShownToUser=!0)});a.useCustomClose=b.useCustomClose;a.close=b.close;a.getExpandProperties=b.getExpandProperties;a.setExpandProperties=function(c){\"undefined\"!=typeof c&&(\"useCustomClose\"in c&&\"undefined\"!=typeof a.getState()&&\"expanded\"!=a.getState())&&a.useCustomClose(c.useCustomClose);\nb.setExpandProperties(c)};a.getResizeProperties=b.getResizeProperties;a.setResizeProperties=b.setResizeProperties;a.getOrientationProperties=b.getOrientationProperties;a.setOrientationProperties=b.setOrientationProperties;a.expand=b.expand;a.getMaxSize=b.getMaxSize;a.getState=b.getState;a.isViewable=b.isViewable;a.createCalendarEvent=function(a){window.mraid.broadcastEvent(\"error\",\"Method not supported\",\"createCalendarEvent\")};a.open=function(c){b.detectAndBlockFraud(\"mraid.open\")||(\"string\"!=typeof c?\na.broadcastEvent(\"error\",\"URL is required.\",\"open\"):b.open(c))};a.resize=b.resize;a.getVersion=function(){return\"2.0\"};a.getPlacementType=b.getPlacementType;a.playVideo=function(a){b.playVideo(a)};a.getScreenSize=b.getScreenSize;a.getCurrentPosition=b.getCurrentPosition;a.getDefaultPosition=b.getDefaultPosition;a.supports=function(a){return b.supports(a)};a.storePicture=function(c){\"string\"!=typeof c?a.broadcastEvent(\"error\",\"Request must specify a valid URL\",\"storePicture\"):b.storePicture(c)}})();\n(function(){var a=window.imraidview={},b=!1;a.setOrientationProperties=function(c){try{c?(\"undefined\"!=typeof c.allowOrientationChange&&(mraidview.orientationProperties.allowOrientationChange=c.allowOrientationChange),\"undefined\"!=typeof c.forceOrientation&&(mraidview.orientationProperties.forceOrientation=c.forceOrientation),\"undefined\"!=typeof c.direction&&(mraidview.orientationProperties.direction=c.direction)):c=null,sdkController.setOrientationProperties(\"window.imraidview\",mraidview.stringify(mraidview.orientationProperties))}catch(b){a.showAlert(\"setOrientationProperties: \"+\nb+\", props = \"+c)}};a.getOrientationProperties=function(){return mraidview.orientationProperties};a.firePostStatusEvent=function(a){window.imraid.broadcastEvent(\"postStatus\",a)};a.fireMediaTrackingEvent=function(a,b){var d={};d.name=a;var e=\"inmobi_media_\"+a;\"undefined\"!=typeof b&&(null!=b&&\"\"!=b)&&(e=e+\"_\"+b);window.imraid.broadcastEvent(e,d)};a.fireMediaErrorEvent=function(a,b){var d={name:\"error\"};d.code=b;var e=\"inmobi_media_\"+d.name;\"undefined\"!=typeof a&&(null!=a&&\"\"!=a)&&(e=e+\"_\"+a);window.imraid.broadcastEvent(e,\nd)};a.fireMediaTimeUpdateEvent=function(a,b,d){var e={name:\"timeupdate\",target:{}};e.target.currentTime=b;e.target.duration=d;b=\"inmobi_media_\"+e.name;\"undefined\"!=typeof a&&(null!=a&&\"\"!=a)&&(b=b+\"_\"+a);window.imraid.broadcastEvent(b,e)};a.saveContent=function(a,b,d){window.imraid.addEventListener(\"saveContent_\"+a,d);sdkController.saveContent(\"window.imraidview\",a,b)};a.cancelSaveContent=function(a){sdkController.cancelSaveContent(\"window.imraidview\",a)};a.disableCloseRegion=function(a){sdkController.disableCloseRegion(\"window.imraidview\",\na)};a.fireGalleryImageSelectedEvent=function(a,b,d){var e=new Image;e.src=\"data:image/jpeg;base64,\"+a;e.width=b;e.height=d;window.imraid.broadcastEvent(\"galleryImageSelected\",e)};a.fireCameraPictureCatpturedEvent=function(a,b,d){var e=new Image;e.src=\"data:image/jpeg;base64,\"+a;e.width=b;e.height=d;window.imraid.broadcastEvent(\"cameraPictureCaptured\",e)};a.fireMediaCloseEvent=function(a,b,d){var e={name:\"close\"};e.viaUserInteraction=b;e.target={};e.target.currentTime=d;b=\"inmobi_media_\"+e.name;\"undefined\"!=\ntypeof a&&(null!=a&&\"\"!=a)&&(b=b+\"_\"+a);window.imraid.broadcastEvent(b,e)};a.fireMediaVolumeChangeEvent=function(a,b,d){var e={name:\"volumechange\",target:{}};e.target.volume=b;e.target.muted=d;b=\"inmobi_media_\"+e.name;\"undefined\"!=typeof a&&(null!=a&&\"\"!=a)&&(b=b+\"_\"+a);window.imraid.broadcastEvent(b,e)};a.fireDeviceMuteChangeEvent=function(a){window.imraid.broadcastEvent(\"deviceMuted\",a)};a.fireDeviceVolumeChangeEvent=function(a){window.imraid.broadcastEvent(\"deviceVolumeChange\",a)};a.fireHeadphonePluggedEvent=\nfunction(a){window.imraid.broadcastEvent(\"headphones\",a)};a.showAlert=function(a){sdkController.showAlert(\"window.imraidview\",a)};a.openExternal=function(c,b){try{600<=getSdkVersionInt()?sdkController.openExternal(\"window.imraidview\",c,b):sdkController.openExternal(\"window.imraidview\",c)}catch(d){a.showAlert(\"openExternal: \"+d)}};a.log=function(c){try{sdkController.log(\"window.imraidview\",c)}catch(b){a.showAlert(\"log: \"+b)}};a.getPlatform=function(){return\"android\"};a.asyncPing=function(c){try{sdkController.asyncPing(\"window.imraidview\",\nc)}catch(b){a.showAlert(\"asyncPing: \"+b)}};a.startListeningDeviceMuteEvents=function(){sdkController.registerDeviceMuteEventListener(\"window.imraidview\")};a.stopListeningDeviceMuteEvents=function(){sdkController.unregisterDeviceMuteEventListener(\"window.imraidview\")};a.startListeningDeviceVolumeChange=function(){sdkController.registerDeviceVolumeChangeEventListener(\"window.imraidview\")};a.stopListeningDeviceVolumeChange=function(){sdkController.unregisterDeviceVolumeChangeEventListener(\"window.imraidview\")};\na.startListeningHeadphonePluggedEvents=function(){sdkController.registerHeadphonePluggedEventListener(\"window.imraidview\")};a.stopListeningHeadphonePluggedEvents=function(){sdkController.unregisterHeadphonePluggedEventListener(\"window.imraidview\")};getSdkVersionInt=function(){for(var c=a.getSdkVersion().split(\".\"),b=c.length,d=\"\",e=0;e<b;e++)d+=c[e];return parseInt(d)};a.getSdkVersionInt=getSdkVersionInt;a.getSdkVersion=function(){return window._im_imaiview.getSdkVersion()};a.supports=function(a){console.log(\"bridge: supports (IMRAID)\");\nif(\"string\"!=typeof a)window.imraid.broadcastEvent(\"error\",\"Supports method expects string parameter\",\"supports\");else return\"false\"!=sdkController.supports(\"window.imraidview\",a)};a.postToSocial=function(c,b,d,e){window.imraid.broadcastEvent(\"error\",\"Method not supported\",\"postToSocial\");a.log(\"Method postToSocial not supported\")};a.incentCompleted=function(a){if(\"object\"!=typeof a||null==a)sdkController.incentCompleted(\"window.imraidview\",null);else try{sdkController.incentCompleted(\"window.imraidview\",\nJSON.stringify(a))}catch(b){sdkController.incentCompleted(\"window.imraidview\",null)}};a.getOrientation=function(){try{return String(sdkController.getOrientation(\"window.imraidview\"))}catch(c){a.showAlert(\"getOrientation: \"+c)}};a.acceptAction=function(c){try{sdkController.acceptAction(\"window.imraidview\",mraidview.stringify(c))}catch(b){a.showAlert(\"acceptAction: \"+b+\", params = \"+c)}};a.rejectAction=function(c){try{sdkController.rejectAction(\"window.imraidview\",mraidview.stringify(c))}catch(b){a.showAlert(\"rejectAction: \"+\nb+\", params = \"+c)}};a.updateToPassbook=function(c){window.imraid.broadcastEvent(\"error\",\"Method not supported\",\"updateToPassbook\");a.log(\"Method not supported\")};a.isDeviceMuted=function(){return\"false\"!=sdkController.isDeviceMuted(\"window.imraidview\")};a.getDeviceVolume=function(){return 603>=getSdkVersionInt()?-1:sdkController.getDeviceVolume(\"window.imraidview\")};a.isHeadPhonesPlugged=function(){return\"false\"!=sdkController.isHeadphonePlugged(\"window.imraidview\")};a.sendSaveContentResult=function(){window.imraid.sendSaveContentResult.apply(window.imraid,\narguments)};a.broadcastEvent=function(){window.imraid.broadcastEvent.apply(window.imraid,arguments)};a.disableBackButton=function(a){void 0==a||\"boolean\"!=typeof a?console.log(\"disableBackButton called with invalid params\"):sdkController.disableBackButton(\"window.imraidview\",a)};a.isBackButtonDisabled=function(){return sdkController.isBackButtonDisabled(\"window.imraidview\")};a.startListeningForBackButtonPressedEvent=function(){sdkController.registerBackButtonPressedEventListener(\"window.imraidview\")};\na.stopListeningForBackButtonPressedEvent=function(){sdkController.unregisterBackButtonPressedEventListener(\"window.imraidview\")};a.hideStatusBar=function(){};a.setOpaqueBackground=function(){};a.startDownloader=function(a,b,d){682<=getSdkVersionInt()&&sdkController.startDownloader(\"window.imraidview\",a,b,d)};a.registerDownloaderCallbacks=function(){682<=getSdkVersionInt()&&sdkController.registerDownloaderCallbacks(\"window.imraidview\")};a.unregisterDownloaderCallbacks=function(){682<=getSdkVersionInt()&&\nsdkController.unregisterDownloaderCallbacks(\"window.imraidview\")};a.getDownloadProgress=function(){return 682<=getSdkVersionInt()?sdkController.getDownloadProgress(\"window.imraidview\"):-1};a.getDownloadStatus=function(){return 682<=getSdkVersionInt()?sdkController.getDownloadStatus(\"window.imraidview\"):-1};a.fireEvent=function(a){700<=getSdkVersionInt()&&(\"fireSkip\"===a?sdkController.fireSkip(\"window.imraidview\"):\"fireComplete\"===a?sdkController.fireComplete(\"window.imraidview\"):\"showEndCard\"===a&&\nsdkController.showEndCard(\"window.imraidview\"))};a.saveBlob=function(a){700<=getSdkVersionInt()&&sdkController.saveBlob(\"window.imraidview\",a)};a.getBlob=function(a,b){700<=getSdkVersionInt()&&sdkController.getBlob(a,b)};a.setCloseEndCardTracker=function(a){700<=getSdkVersionInt()&&sdkController.setCloseEndCardTracker(\"window.imraidview\",a)};a.getRenderableAdIndexes=function(){try{if(917<=getSdkVersionInt())return sdkController.getRenderableAdIndexes(\"window.imraidview\")}catch(a){}return\"[]\"};a.getCurrentRenderingIndex=\nfunction(){try{if(917<=getSdkVersionInt())return sdkController.getCurrentRenderingIndex(\"window.imraidview\")}catch(a){}return-1};a.showAd=function(a){try{917<=getSdkVersionInt()&&sdkController.showAd(\"window.imraidview\",a)}catch(b){}};a.timeSinceShow=function(){try{if(917<=getSdkVersionInt())return sdkController.timeSinceShow(\"window.imraidview\")}catch(a){}return-1};a.getShowTimeStamp=function(){try{if(917<=getSdkVersionInt())return sdkController.getShowTimeStamp(\"window.imraidview\")}catch(a){}return-1};\na.closeAll=function(){try{917<=getSdkVersionInt()&&sdkController.closeAll(\"window.imraidview\")}catch(a){}};a.loadAd=function(a){try{917<=getSdkVersionInt()&&sdkController.loadAd(\"window.imraidview\",a)}catch(b){}};a.setAdContext=function(a){try{917<=getSdkVersionInt()&&sdkController.setAdContext(\"window.imraidview\",a)}catch(b){}};a.getAdContext=function(){try{if(917<=getSdkVersionInt())return sdkController.getAdContext(\"window.imraidview\")}catch(a){}return\"\"};a.openWithoutTracker=function(a){try{\"undefined\"==\ntypeof a&&(a=null),sdkController.openWithoutTracker(\"window.imraidview\",a)}catch(b){}};a.impressionRendered=function(){window.imraid.broadcastEvent(\"impressionRendered\")};a.customExpand=function(b,f,d,e,g){try{void 0==d||\"number\"!=typeof d?console.log(\"screenPercentage called with invalid params\"):void 0==f||\"number\"!=typeof f?console.log(\"inputType called with invalid params\"):void 0==e||\"boolean\"!=typeof e?console.log(\"topNavBarVisible called with invalid params\"):void 0==g||\"boolean\"!=typeof g?\nconsole.log(\"bottomNavBarVisible called with invalid params\"):sdkController.customExpand(\"window.imraidview\",b,f,d,e,g)}catch(h){a.showAlert(\"executeNativeCustomExpand: \"+h+\", input = \"+b+\", inputType = \"+f+\", screenPercentage = \"+d+\", bottomNavBarVisible = \"+g+\", topNavBarVisible = \"+e)}};a.closeCustomExpand=function(){try{sdkController.closeCustomExpand(\"window.imraidview\")}catch(a){}};a.onGestureDetected=function(a,b){window.imraid.broadcastEvent(\"onGestureDetected\",a,b)};a.onUserLandingCompleted=\nfunction(){window.imraid.broadcastEvent(\"onUserLandingCompleted\")};a.onUserInteraction=function(){window.imraid.broadcastEvent(\"onUserInteraction\")};a.impressionFired=function(){try{sdkController.impressionFired(\"window.imraidview\")}catch(a){}};a.getMaxDeviceVolume=function(){try{return sdkController.getMaxDeviceVolume(\"window.imraidview\")}catch(a){return 15}};a.zoom=function(a){try{sdkController.zoom(\"window.imraidview\",a)}catch(b){}};a.onAudioStateChanged=function(a){try{sdkController.onAudioStateChanged(\"window.imraidview\",\na)}catch(b){}};a.submitAdReport=function(a){try{sdkController.submitAdReport(\"window.imraidview\",void 0!=a.adQualityUrl?a.adQualityUrl:null,void 0!=a.enableUserAdReportScreenshot?a.enableUserAdReportScreenshot:null,void 0!=a.templateInfo?a.templateInfo:null)}catch(b){}};a.logTelemetryEvent=function(a){try{var b=void 0!=a.eventType?a.eventType:null,d=void 0!=a.payload?a.payload:null;a=null;null!=d&&(a=mraidview.stringify(d));sdkController.logTelemetryEvent(\"window.imraidview\",b,a)}catch(e){}};a.onUserAudioMuteInteraction=\nfunction(a){try{sdkController.onUserAudioMuteInteraction(\"window.imraidview\",a)}catch(b){}};a.enableFallbackViewabilityFunctionality=function(){b=!0;a.checkFallbackViewable()&&window.mraid.broadcastEvent(\"viewableChange\",!0);mraid.addEventListener(\"sizeChange\",function(){window.mraid.broadcastEvent(\"viewableChange\",a.checkFallbackViewable())})};a.checkFallbackViewable=function(){try{var b=mraidview.getCurrentPosition(),f=b.height;return 40<=b.width&&40<=f?!0:!1}catch(d){a.showAlert(\"checkFallbackViewable: \"+\nd)}};a.fallbackViewabilityEnabled=function(){return b};a.getSafeArea=function(){try{return JSON.parse(sdkController.getSafeArea(\"window.imraidview\"))}catch(a){return null}}})();\n(function(){var a=window.imraid=new InmobiObj,b=window.imraidview;a.getOrientation=b.getOrientation;a.setOrientationProperties=b.setOrientationProperties;a.getOrientationProperties=b.getOrientationProperties;a.saveContentIDMap={};a.saveContent=function(c,d,e){var g=arguments.length,h,k=null;if(3>g){if(\"function\"===typeof arguments[g-1])h=arguments[g-1];else return;k={reason:1}}else a.saveContentIDMap[c]&&(h=arguments[2],k={reason:11,url:arguments[1]});\"function\"!==!h&&(k?(window.imraid.addEventListener(\"saveContent_failed_\"+\nc,h),window.imraid.sendSaveContentResult(\"saveContent_failed_\"+c,\"failed\",JSON.stringify(k))):(a.removeEventListener(\"saveContent_\"+c),a.saveContentIDMap[c]=!0,b.saveContent(c,d,e)))};a.cancelSaveContent=function(a){b.cancelSaveContent(a)};a.asyncPing=function(c){\"string\"!=typeof c?a.broadcastEvent(\"error\",\"URL is required.\",\"asyncPing\"):b.asyncPing(c)};a.disableCloseRegion=b.disableCloseRegion;a.getSdkVersion=b.getSdkVersion;a.log=function(c){\"undefined\"==typeof c?a.broadcastEvent(\"error\",\"message is required.\",\n\"log\"):\"string\"==typeof c?b.log(c):b.log(JSON.stringify(c))};a.getInMobiAIVersion=function(){return\"2.0\"};a.getVendorName=function(){return\"inmobi\"};a.openExternal=function(a,c){console.log(\"openExternal is deprecated, will be removed in future version\");mraidview.detectAndBlockFraud(\"imraid.openExternal\")||b.openExternal(a,c)};a.updateToPassbook=function(c){mraidview.detectAndBlockFraud(\"imraid.updateToPassbook\")||(\"string\"!=typeof c?a.broadcastEvent(\"error\",\"Request must specify a valid URL\",\"updateToPassbook\"):\nb.updateToPassbook(c))};a.postToSocial=function(a,c,e,g){mraidview.detectAndBlockFraud(\"imraid.postToSocial\")||b.postToSocial(a,c,e,g)};a.getPlatform=b.getPlatform;a.incentCompleted=b.incentCompleted;a.loadSKStore=b.loadSKStore;a.showSKStore=function(a){mraidview.detectAndBlockFraud(\"imraid.showSKStore\")||b.showSKStore(a)};a.skoverlay=b.skoverlay;a.skoverlayWithSkan=b.skoverlayWithSkan;a.zoom=b.zoom;a.dismissSKOverlay=b.dismissSKOverlay;a.supports=function(a){return b.supports(a)};a.isDeviceMuted=\nfunction(){return!imIsObjValid(a.listeners.deviceMuted)?-1:b.isDeviceMuted()};a.isHeadPhonesPlugged=function(){return!imIsObjValid(a.listeners.headphones)?!1:b.isHeadPhonesPlugged()};a.getDeviceVolume=function(){return b.getDeviceVolume()};a.setDeviceVolume=function(a){b.setDeviceVolume(a)};a.hideStatusBar=function(){b.hideStatusBar()};a.setOpaqueBackground=function(){b.setOpaqueBackground()};a.getRenderableAdIndexes=b.getRenderableAdIndexes;a.getCurrentRenderingIndex=b.getCurrentRenderingIndex;a.showAd=\nb.showAd;a.timeSinceShow=b.timeSinceShow;a.closeAll=b.closeAll;a.loadAd=b.loadAd;a.setAdContext=b.setAdContext;a.getAdContext=b.getAdContext;a.getShowTimeStamp=b.getShowTimeStamp;a.disableBackButton=b.disableBackButton;a.isBackButtonDisabled=b.isBackButtonDisabled;a.startDownloader=b.startDownloader;a.getDownloadProgress=b.getDownloadProgress;a.getDownloadStatus=b.getDownloadStatus;a.fireEvent=b.fireEvent;a.saveBlob=b.saveBlob;a.getBlob=b.getBlob;a.setCloseEndCardTracker=b.setCloseEndCardTracker;\na.openWithoutTracker=b.openWithoutTracker;a.impressionRendered=b.impressionRendered;a.onGestureDetected=b.onGestureDetected;a.onUserLandingCompleted=b.onUserLandingCompleted;a.customExpand=b.customExpand;a.closeCustomExpand=b.closeCustomExpand;a.impressionFired=b.impressionFired;a.getImraidVersion=b.getImraidVersion;a.getMaxDeviceVolume=b.getMaxDeviceVolume;a.onAudioStateChanged=b.onAudioStateChanged;a.onUserAudioMuteInteraction=b.onUserAudioMuteInteraction;a.submitAdReport=b.submitAdReport;a.enableFallbackViewabilityFunctionality=\nb.enableFallbackViewabilityFunctionality;a.logTelemetryEvent=b.logTelemetryEvent;a.getSafeArea=b.getSafeArea;a.onReceviedSKANCallback=b.onReceviedSKANCallback;a.getOpenMode=b.getOpenMode;try{a.addEventListener(\"onUserLandingCompleted\",function(){1080>b.getSdkVersionInt()&&a.broadcastEvent(\"onUserLandingInitialized\")})}catch(c){}})();\n(function(){var a=window._im_imaiview={ios:{}};window.imaiview=a;a.broadcastEvent=function(){for(var a=Array(arguments.length),c=0;c<arguments.length;c++)a[c]=arguments[c];c=a.shift();try{window.mraid.broadcastEvent(c,a)}catch(f){}};a.getPlatform=function(){return\"android\"};a.getPlatformVersion=function(){return sdkController.getPlatformVersion(\"window.imaiview\")};a.log=function(a){sdkController.log(\"window.imaiview\",a)};a.openEmbedded=function(a){sdkController.openEmbedded(\"window.imaiview\",a)};\na.openExternal=function(a,c){600<=getSdkVersionInt()?sdkController.openExternal(\"window.imaiview\",a,c):sdkController.openExternal(\"window.imaiview\",a)};a.ping=function(a,c){sdkController.ping(\"window.imaiview\",a,c)};a.pingInWebView=function(a,c){sdkController.pingInWebView(\"window.imaiview\",a,c)};a.getSdkVersion=function(){try{var a=sdkController.getSdkVersion(\"window.imaiview\");if(\"string\"==typeof a&&null!=a)return a}catch(c){return\"3.7.0\"}};a.onUserInteraction=function(a){if(\"object\"!=typeof a||\nnull==a)sdkController.onUserInteraction(\"window.imaiview\",null);else try{sdkController.onUserInteraction(\"window.imaiview\",JSON.stringify(a))}catch(c){sdkController.onUserInteraction(\"window.imaiview\",null)}};a.fireAdReady=function(){sdkController.fireAdReady(\"window.imaiview\")};a.fireAdFailed=function(){sdkController.fireAdFailed(\"window.imaiview\")};a.broadcastEvent=function(){window.imai.broadcastEvent.apply(window.imai,arguments)}})();\n(function(){var a=window._im_imaiview;window._im_imai=new InmobiObj;window._im_imai.ios=new InmobiObj;var b=window._im_imai;window.imai=window._im_imai;b.matchString=function(a,b){if(\"string\"!=typeof a||null==a||null==b)return-1;var d=-1;try{d=a.indexOf(b)}catch(e){}return d};b.isHttpUrl=function(a){return\"string\"!=typeof a||null==a?!1:0==b.matchString(a,\"http://\")?!0:0==b.matchString(a,\"https://\")?!0:!1};b.appendTapParams=function(a,f,d){if(!imIsObjValid(f)||!imIsObjValid(d))return a;b.isHttpUrl(a)&&\n(a=-1==b.matchString(a,\"?\")?a+(\"?u-tap-o=\"+f+\",\"+d):a+(\"&u-tap-o=\"+f+\",\"+d));return a};b.performAdClick=function(a,f){f=f||event;if(imIsObjValid(a)){var d=a.clickConfig,e=a.landingConfig;if(!imIsObjValid(d)&&!imIsObjValid(e))b.log(\"click/landing config are invalid, Nothing to process .\"),this.broadcastEvent(\"error\",\"click/landing config are invalid, Nothing to process .\");else{var g=null,h=null,k=null,m=null,n=null,l=null,q=null,p=null;if(imIsObjValid(f))try{m=f.changedTouches[0].pageX,n=f.changedTouches[0].pageY}catch(r){n=\nm=0}imIsObjValid(e)?imIsObjValid(d)?(l=e.url,q=e.fallbackUrl,p=e.urlType,g=d.url,h=d.pingWV,k=d.fr):(l=e.url,p=e.urlType):(l=d.url,p=d.urlType);d=b.getPlatform();try{if(\"boolean\"!=typeof k&&\"number\"!=typeof k||null==k)k=!0;if(0>k||1<k)k=!0;if(\"boolean\"!=typeof h&&\"number\"!=typeof h||null==h)h=!0;if(0>h||1<h)h=!0;if(\"number\"!=typeof p||null==p)p=0;g=b.appendTapParams(g,m,n);imIsObjValid(g)?!0==h?b.pingInWebView(g,k):b.ping(g,k):b.log(\"clickurl provided is null.\");if(imIsObjValid(l))switch(imIsObjValid(g)||\n(l=b.appendTapParams(l,m,n)),p){case 1:b.openEmbedded(l);break;case 2:\"ios\"==d?b.ios.openItunesProductView(l):this.broadcastEvent(\"error\",\"Cannot process openItunesProductView for os\"+d);break;default:b.openExternal(l,q)}else b.log(\"Landing url provided is null.\")}catch(s){}}}else b.log(\" invalid config, nothing to process .\"),this.broadcastEvent(\"error\",\"invalid config, nothing to process .\")};b.performActionClick=function(a,f){f=f||event;if(imIsObjValid(a)){var d=a.clickConfig,e=a.landingConfig;\nif(!imIsObjValid(d)&&!imIsObjValid(e))b.log(\"click/landing config are invalid, Nothing to process .\"),this.broadcastEvent(\"error\",\"click/landing config are invalid, Nothing to process .\");else{var g=null,h=null,k=null,m=null,n=null;if(imIsObjValid(f))try{m=f.changedTouches[0].pageX,n=f.changedTouches[0].pageY}catch(l){n=m=0}imIsObjValid(d)&&(g=d.url,h=d.pingWV,k=d.fr);try{if(\"boolean\"!=typeof k&&\"number\"!=typeof k||null==k)k=!0;if(0>k||1<k)k=!0;if(\"boolean\"!=typeof h&&\"number\"!=typeof h||null==h)h=\n!0;if(0>h||1<h)h=!0;g=b.appendTapParams(g,m,n);imIsObjValid(g)?!0==h?b.pingInWebView(g,k):b.ping(g,k):b.log(\"clickurl provided is null.\");b.onUserInteraction(e)}catch(q){}}}else b.log(\" invalid config, nothing to process .\"),this.broadcastEvent(\"error\",\"invalid config, nothing to process .\")};b.getVersion=function(){return\"1.0\"};b.getPlatform=a.getPlatform;b.getPlatformVersion=a.getPlatformVersion;b.log=a.log;b.openEmbedded=function(b){console.log(\"openEmbedded is deprecated, will be removed in future version\");\nmraidview.detectAndBlockFraud(\"imai.openEmbedded\")||a.openEmbedded(b)};b.openExternal=function(b,f){console.log(\"openExternal is deprecated, will be removed in future version\");mraidview.detectAndBlockFraud(\"imai.openExternal\")||a.openExternal(b,f)};b.ping=a.ping;b.pingInWebView=a.pingInWebView;b.onUserInteraction=a.onUserInteraction;b.getSdkVersion=a.getSdkVersion;b.loadSKStore=a.loadSKStore;b.showSKStore=function(b){mraidview.detectAndBlockFraud(\"imai.showSKStore\")||a.showSKStore(b)};b.ios.openItunesProductView=\nfunction(b){mraidview.detectAndBlockFraud(\"imai.ios.openItunesProductView\")||a.ios.openItunesProductView(b)};b.fireAdReady=a.fireAdReady;b.fireAdFailed=a.fireAdFailed})();";
        }
        L4 l6 = this.i;
        if (l6 == null) {
            return strA;
        }
        String TAG2 = O0;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        ((M4) l6).a(TAG2, "Returning fetched Mraid Js string.");
        return strA;
    }

    public final C3529q9 getOrientationProperties() {
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).a(str, AbstractC3474ma.a(this, str, "TAG", "getOrientationProperties "));
        }
        return this.t0;
    }

    public final Ba getOriginalRenderView() {
        return this.k;
    }

    public final long getPlacementId() {
        return this.Q;
    }

    @Override // com.inmobi.media.r
    public byte getPlacementType() {
        return this.b;
    }

    public r getReferenceContainer() {
        return this.a0;
    }

    public final JSONArray getRenderableAdIndexes() {
        JSONArray jSONArrayN;
        K k = this.d0;
        return (k == null || (jSONArrayN = ((C0) k).N()) == null) ? new JSONArray() : jSONArrayN;
    }

    public final AdConfig.RenderingConfig getRenderingConfig() {
        AdConfig adConfig = this.t;
        if (adConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdConfig");
            adConfig = null;
        }
        return adConfig.getRendering();
    }

    public final Ua getResizeProperties() {
        return this.x;
    }

    public final JSONObject getSafeArea() {
        Ad ad = this.z0;
        if (ad == null) {
            return null;
        }
        Integer numF = AbstractC3565t3.f();
        zd zdVar = (numF == null && (numF = AbstractC3565t3.g) == null) ? null : (zd) ad.c.get(Integer.valueOf(numF.intValue()));
        if (zdVar != null) {
            return zdVar.a();
        }
        return null;
    }

    public final boolean getShouldFireLandingPageBeacons() {
        return this.y0;
    }

    public final long getShowTimeStamp() {
        K k = this.d0;
        if (k != null) {
            return ((C0) k).O();
        }
        return 0L;
    }

    public Map<String, E0> getTelemetryManagerMap() {
        return this.A0;
    }

    public Yb getTelemetryOnAdImpression() {
        Map<String, E0> telemetryManagerMap = getTelemetryManagerMap();
        return new Yb(telemetryManagerMap != null ? telemetryManagerMap.get("AdImpressionSuccessful") : null, this.s0, getCreativeId(), getMarkupType());
    }

    public final Yc getVISIBILITY_CHANGE_LISTENER() {
        return this.F0;
    }

    @Override // com.inmobi.media.r
    public View getVideoContainerView() {
        return null;
    }

    public final String getViewState() {
        return this.p;
    }

    @Override // com.inmobi.media.InterfaceC3386ga
    public long getViewTouchTimestamp() {
        return this.g;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0083  */
    @Override // com.inmobi.media.r
    public Tc getViewableAd() {
        boolean z;
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).a(str, AbstractC3474ma.a(this, str, "TAG", "viewableAd getter "));
        }
        if (this.e0 == null) {
            this.e0 = new W4(this, new Uc(this), new C3380g4(this.j, this.s0, this.l0, this.m0, getVisibilityTrackingMinPercentage(), this.i), this.i);
            Set<C3504oc> set = this.c;
            if (set != null) {
                for (C3504oc c3504oc : set) {
                    try {
                        if (c3504oc.f3393a == 3) {
                            Object obj = c3504oc.b.get("omidAdSession");
                            C3371f9 c3371f9 = obj instanceof C3371f9 ? (C3371f9) obj : null;
                            if (c3504oc.b.containsKey("deferred")) {
                                Object obj2 = c3504oc.b.get("deferred");
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                                if (((Boolean) obj2).booleanValue()) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                            } else {
                                z = false;
                            }
                            Object obj3 = c3504oc.b.get("customReferenceData");
                            String str2 = obj3 instanceof String ? (String) obj3 : null;
                            if (z && c3371f9 != null) {
                                String str3 = this.h0;
                                C3487n9 c3487n9 = AbstractC3473m9.f3376a;
                                c3487n9.getClass();
                                Intrinsics.checkNotNullParameter(this, "webView");
                                AdSessionContext adSessionContextCreateHtmlAdSessionContext = AdSessionContext.createHtmlAdSessionContext(c3487n9.b, this, str3, str2);
                                Intrinsics.checkNotNullExpressionValue(adSessionContextCreateHtmlAdSessionContext, "createHtmlAdSessionContext(...)");
                                if (adSessionContextCreateHtmlAdSessionContext != null) {
                                    c3371f9.c = adSessionContextCreateHtmlAdSessionContext;
                                }
                            }
                            if (c3371f9 != null) {
                                Tc tc = this.e0;
                                Intrinsics.checkNotNull(tc);
                                this.e0 = new C3427j9(this, tc, c3371f9, this.i);
                            } else {
                                L4 l5 = this.i;
                                if (l5 != null) {
                                    String TAG = O0;
                                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                                    ((M4) l5).b(TAG, "Did not find a OMID ad session; the IAB decorator will not be applied.");
                                }
                            }
                        }
                    } catch (Exception e) {
                        L4 l6 = this.i;
                        if (l6 != null) {
                            String str4 = O0;
                            ((M4) l6).b(str4, ld.a(e, O5.a(str4, "TAG", "Exception occurred while creating the HTML viewable ad : ")));
                        }
                    }
                }
            }
        }
        Tc tc2 = this.e0;
        Intrinsics.checkNotNull(tc2);
        return tc2;
    }

    public final int[] getViewableFrameArray() {
        return this.i0;
    }

    public final void h() {
        Activity fullScreenActivity;
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).a(str, AbstractC3474ma.a(this, str, "TAG", "finishFullScreenActivity "));
        }
        SparseArray sparseArray = InMobiAdActivity.k;
        Intrinsics.checkNotNullParameter(this, "container");
        InMobiAdActivity.k.remove(hashCode());
        if (getFullScreenActivity() == null) {
            if (this.b == 0) {
                setAndUpdateViewState(Profile.DEFAULT_PROFILE_NAME);
                Ba ba = this.k;
                if (ba != null) {
                    ba.setAndUpdateViewState(Profile.DEFAULT_PROFILE_NAME);
                }
            } else if (Intrinsics.areEqual(Profile.DEFAULT_PROFILE_NAME, this.p)) {
                setAndUpdateViewState("Hidden");
            }
            v();
            return;
        }
        K k = this.d0;
        if (k == null || !k.a(this)) {
            Activity fullScreenActivity2 = getFullScreenActivity();
            Intrinsics.checkNotNull(fullScreenActivity2, "null cannot be cast to non-null type com.inmobi.ads.rendering.InMobiAdActivity");
            ((InMobiAdActivity) fullScreenActivity2).e = true;
            Activity fullScreenActivity3 = getFullScreenActivity();
            if (fullScreenActivity3 != null) {
                fullScreenActivity3.finish();
            }
            if (this.P == -1 || (fullScreenActivity = getFullScreenActivity()) == null) {
                return;
            }
            fullScreenActivity.overridePendingTransition(0, this.P);
        }
    }

    public final void i() {
        Ia ia = this.T;
        if (ia != null) {
            Map mapA = ia.a();
            long j = ia.b;
            ScheduledExecutorService scheduledExecutorService = Ec.f3062a;
            mapA.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - j));
            Ob ob = Ob.f3160a;
            Ob.b("FireAdReady", mapA, Sb.SDK);
        }
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).a(str, AbstractC3474ma.a(this, str, "TAG", "fireAdReady "));
        }
        this.p0 = true;
        if (this.j == 0) {
            k();
        }
        x();
        getListener().h(this);
    }

    public final void j() {
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).a(str, AbstractC3474ma.a(this, str, "TAG", "fireClickTrackers "));
        }
        J2 j2 = this.H0;
        if (j2 != null && !j2.g.get()) {
            j2.d.g = 1;
            Intrinsics.checkNotNull(j2.c);
        }
        L4 l5 = this.i;
        if (l5 != null) {
            String str2 = O0;
            ((M4) l5).a(str2, AbstractC3474ma.a(this, str2, "TAG", "fireOnUserInteraction "));
        }
        b("window.imraidview.onUserInteraction();");
        getListener().b(this);
    }

    public final void k() {
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).a(str, AbstractC3474ma.a(this, str, "TAG", "fireImpression "));
        }
        if (Intrinsics.areEqual("video", this.s0) || Intrinsics.areEqual("audio", this.s0)) {
            return;
        }
        L4 l5 = this.i;
        if (l5 != null) {
            String str2 = O0;
            ((M4) l5).a(str2, AbstractC3474ma.a(this, str2, "TAG", "recordContextualData "));
        }
        J2 j2 = this.H0;
        if (j2 != null) {
            j2.a();
        }
        b("window.imraidview.impressionRendered();");
        getListener().c(this);
    }

    public final boolean l() {
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).a(str, O5.a(str, "TAG", "hasUserInteracted ").append(getViewTouchTimestamp()).append(' ').append(getRenderingConfig().getUserTouchResetTime()).toString());
        }
        return !getRenderingConfig().getAutoRedirectionEnforcement() || this.c0 || (getViewTouchTimestamp() != -1 && SystemClock.elapsedRealtime() - getViewTouchTimestamp() < getRenderingConfig().getUserTouchResetTime());
    }

    public final void m() {
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).a(str, AbstractC3474ma.a(this, str, "TAG", "onUserLandingCompleted "));
        }
        b("window.imraid.broadcastEvent('onUserLandingCompleted');");
    }

    public final void n() {
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).a(str, AbstractC3474ma.a(this, str, "TAG", "processResizeRequest "));
        }
        if (!Intrinsics.areEqual(Profile.DEFAULT_PROFILE_NAME, this.p) && !Intrinsics.areEqual("Resized", this.p)) {
            L4 l5 = this.i;
            if (l5 != null) {
                String TAG = O0;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((M4) l5).b(TAG, "Render view state must be either DEFAULT or RESIZED to admit the resize request");
                return;
            }
            return;
        }
        if (this.x == null) {
            L4 l6 = this.i;
            if (l6 != null) {
                String TAG2 = O0;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((M4) l6).b(TAG2, "Render view state can not resize with invalid resize properties");
                return;
            }
            return;
        }
        this.L = true;
        N6 n6 = this.r;
        if (n6 != null) {
            n6.a();
        }
        requestLayout();
        invalidate();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        setAndUpdateViewState("Resized");
        getListener().e(this);
        this.L = false;
    }

    public final void o() {
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).c(str, AbstractC3474ma.a(this, str, "TAG", "setCurrentPosition "));
        }
        this.z = new JSONObject();
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        try {
            JSONObject jSONObject = this.z;
            if (jSONObject != null) {
                jSONObject.put(VastAttributes.HORIZONTAL_POSITION, AbstractC3565t3.a(iArr[0]));
            }
            JSONObject jSONObject2 = this.z;
            if (jSONObject2 != null) {
                jSONObject2.put(VastAttributes.VERTICAL_POSITION, AbstractC3565t3.a(iArr[1]));
            }
            int iA = AbstractC3565t3.a(getWidth());
            int iA2 = AbstractC3565t3.a(getHeight());
            JSONObject jSONObject3 = this.z;
            if (jSONObject3 != null) {
                jSONObject3.put("width", iA);
            }
            JSONObject jSONObject4 = this.z;
            if (jSONObject4 != null) {
                jSONObject4.put("height", iA2);
            }
        } catch (JSONException unused) {
        }
        synchronized (this.K) {
            this.B = false;
            this.K.notifyAll();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).a(str, AbstractC3474ma.a(this, str, "TAG", "onAttachedToWindow "));
        }
        super.onAttachedToWindow();
        M6 m6 = this.s;
        if (m6 != null) {
            C3638y6 c3638y6 = m6.d;
            if (c3638y6 != null) {
                c3638y6.b();
            }
            C3638y6 c3638y7 = m6.e;
            if (c3638y7 != null) {
                c3638y7.b();
            }
            C3638y6 c3638y8 = m6.f;
            if (c3638y8 != null) {
                c3638y8.b();
            }
        }
        L4 l5 = this.i;
        if (l5 != null) {
            String str2 = O0;
            ((M4) l5).c(str2, AbstractC3474ma.a(this, str2, "TAG", "setIsViewHardwareAccelerated "));
        }
        this.u = isHardwareAccelerated();
        if (this.m == null) {
            ViewParent parent = getParent();
            this.m = new WeakReference(parent instanceof ViewGroup ? (ViewGroup) parent : null);
        }
        u();
        L4 l6 = this.i;
        if (l6 != null) {
            String TAG = O0;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l6).a(TAG, "==== CHECKPOINT REACHED - VISIBLE ====");
        }
        L4 l7 = this.i;
        if (l7 != null) {
            ((M4) l7).b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).a(str, AbstractC3474ma.a(this, str, "TAG", "onDetachedFromWindow "));
        }
        A3 a3 = this.q0;
        Z z = null;
        if (a3 != null) {
            A3.a(a3, 8, true, null, 12);
        }
        M6 m6 = this.s;
        if (m6 != null) {
            C3638y6 c3638y6 = m6.d;
            if (c3638y6 != null) {
                c3638y6.a();
            }
            C3638y6 c3638y7 = m6.e;
            if (c3638y7 != null) {
                c3638y7.a();
            }
            C3638y6 c3638y8 = m6.f;
            if (c3638y8 != null) {
                c3638y8.a();
            }
        }
        L4 l5 = this.i;
        if (l5 != null) {
            String TAG = O0;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l5).a(TAG, "Detached from window");
        }
        Z z2 = this.u0;
        if (z2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adQualityManager");
        } else {
            z = z2;
        }
        if (z.d.get()) {
            z.a("session end is already triggered");
        } else if (!z.f3249a.getEnabled()) {
            z.a("config kill switch - false. ad quality will skip");
        } else if (z.g == null) {
            z.a("setup not done. ignore trigger");
        } else {
            z.d.set(true);
            z.a(false);
        }
        if (this.v0.get()) {
            ((ScheduledThreadPoolExecutor) S3.b.getValue()).schedule(new Runnable() { // from class: com.inmobi.media.Ba$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    Ba.a(this.f$0);
                }
            }, 1L, TimeUnit.SECONDS);
        }
        u();
        try {
            super.onDetachedFromWindow();
        } catch (IllegalArgumentException e) {
            L4 l6 = this.i;
            if (l6 != null) {
                String str2 = O0;
                ((M4) l6).b(str2, O5.a(str2, "TAG", "Detaching WebView from window encountered an error ( ").append(e.getMessage()).append(" )").toString());
            }
        }
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (!getRenderingConfig().getSupportedGestures().contains(1)) {
            L4 l4 = this.i;
            if (l4 != null) {
                String TAG = O0;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((M4) l4).c(TAG, "Double tap gesture is disabled from config");
            }
            return false;
        }
        L4 l5 = this.i;
        if (l5 != null) {
            String TAG2 = O0;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((M4) l5).a(TAG2, "onDoubleTapEvent detected \n " + e);
        }
        setViewTouchTimestamp(SystemClock.elapsedRealtime());
        if (e.getAction() == 1) {
            JSONArray jSONArray = new JSONArray();
            try {
                jSONArray.put(AbstractC3420j2.a(e.getX()));
                jSONArray.put(AbstractC3420j2.a(e.getY()));
            } catch (JSONException e2) {
                L4 l6 = this.i;
                if (l6 != null) {
                    String TAG3 = O0;
                    Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                    ((M4) l6).a(TAG3, "Exception in onDoubleTap", e2);
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(jSONArray);
            b("window.imraidview.onGestureDetected('1', '" + jSONArray2 + "');");
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTapEvent(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent e2, float f, float f2) {
        Intrinsics.checkNotNullParameter(e2, "e2");
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (!getRenderingConfig().getSupportedGestures().contains(5)) {
            L4 l4 = this.i;
            if (l4 != null) {
                String TAG = O0;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((M4) l4).c(TAG, "LongPress gesture is disabled from config");
                return;
            }
            return;
        }
        L4 l5 = this.i;
        if (l5 != null) {
            String TAG2 = O0;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((M4) l5).a(TAG2, "onLongPress detected \n " + e);
        }
        JSONArray jSONArray = new JSONArray();
        try {
            jSONArray.put(AbstractC3420j2.a(e.getX()));
            jSONArray.put(AbstractC3420j2.a(e.getY()));
        } catch (JSONException e2) {
            L4 l6 = this.i;
            if (l6 != null) {
                String TAG3 = O0;
                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                ((M4) l6).a(TAG3, "Exception in onLongPress", e2);
            }
        }
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(jSONArray);
        b("window.imraidview.onGestureDetected('5', '" + jSONArray2 + "');");
    }

    @Override // com.inmobi.media.H1, android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent e2, float f, float f2) {
        Intrinsics.checkNotNullParameter(e2, "e2");
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (!getRenderingConfig().getSupportedGestures().contains(0)) {
            L4 l4 = this.i;
            if (l4 != null) {
                String TAG = O0;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((M4) l4).c(TAG, "Click gesture is disabled from config");
            }
            return false;
        }
        L4 l5 = this.i;
        if (l5 != null) {
            String TAG2 = O0;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((M4) l5).a(TAG2, "onSingleTapConfirmed detected \n " + e);
        }
        JSONArray jSONArray = new JSONArray();
        try {
            jSONArray.put(AbstractC3420j2.a(e.getX()));
            jSONArray.put(AbstractC3420j2.a(e.getY()));
        } catch (JSONException e2) {
            L4 l6 = this.i;
            if (l6 != null) {
                String TAG3 = O0;
                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                ((M4) l6).a(TAG3, "Exception in onSingleTapConfirmed", e2);
            }
        }
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(jSONArray);
        b("window.imraidview.onGestureDetected('0', '" + jSONArray2 + "');");
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        L4 l4 = this.i;
        if (l4 != null) {
            String TAG = O0;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "onSingleTapUp detected \n " + e);
        }
        setViewTouchTimestamp(SystemClock.elapsedRealtime());
        return false;
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).c(str, AbstractC3474ma.a(this, str, "TAG", "onSizeChanged "));
        }
        super.onSizeChanged(i, i2, i3, i4);
        L4 l5 = this.i;
        if (l5 != null) {
            String TAG = O0;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l5).a(TAG, "onSizeChanged (" + i + ", " + i2 + ')');
        }
        if (i == 0 || i2 == 0) {
            return;
        }
        int iA = AbstractC3565t3.a(i);
        int iA2 = AbstractC3565t3.a(i2);
        L4 l6 = this.i;
        if (l6 != null) {
            String TAG2 = O0;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((M4) l6).a(TAG2, "fireSizeChanged " + this + " w-" + iA + " h-" + iA2);
        }
        b("window.mraidview.broadcastEvent('sizeChange'," + iA + AbstractJsonLexerKt.COMMA + iA2 + ");");
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Float.isNaN(event.getX()) || Float.isNaN(event.getY())) {
            if (!this.w0) {
                L4 l4 = this.i;
                if (l4 != null) {
                    String TAG = O0;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((M4) l4).b(TAG, "onTouchEvent Invalid Coordinates " + event);
                }
                this.w0 = true;
            }
            return super.onTouchEvent(event);
        }
        L4 l5 = this.i;
        if (l5 != null) {
            String str = O0;
            ((M4) l5).a(str, AbstractC3474ma.a(this, str, "TAG", "onTouchEvent "));
        }
        if (this.b == 1) {
            this.n0.a(event);
        }
        this.o0.onTouchEvent(event);
        setViewTouchTimestamp(SystemClock.elapsedRealtime());
        return super.onTouchEvent(event);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x004a  */
    @Override // android.webkit.WebView, android.view.View
    public final void onWindowFocusChanged(boolean z) {
        L4 l4 = this.i;
        if (l4 != null) {
            String TAG = O0;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "onWindowFocusChanged " + this + " - " + z);
        }
        super.onWindowFocusChanged(z);
        if (z) {
            if (isShown()) {
                C3338d4 c3338d4 = C3380g4.k;
                if (c3338d4.a(this, this, this.m0, null) && c3338d4.a(this, this, this.m0)) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
        }
        Activity fullScreenActivity = getFullScreenActivity();
        if (fullScreenActivity == null || !fullScreenActivity.isInMultiWindowMode()) {
            c(z);
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004f  */
    @Override // android.webkit.WebView, android.view.View
    public final void onWindowVisibilityChanged(int i) {
        L4 l4 = this.i;
        if (l4 != null) {
            String TAG = O0;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "onWindowVisibilityChanged " + this + ' ' + i);
        }
        super.onWindowVisibilityChanged(i);
        boolean z = true;
        boolean z2 = i == 0;
        if (z2) {
            int visibilityTrackingMinPercentage = getVisibilityTrackingMinPercentage();
            if (isShown()) {
                C3338d4 c3338d4 = C3380g4.k;
                if (!c3338d4.a(this, this, visibilityTrackingMinPercentage, null) || !c3338d4.a(this, this, visibilityTrackingMinPercentage)) {
                    z = false;
                }
            } else {
                z = false;
            }
        } else {
            z = z2;
        }
        c(z);
    }

    public final void p() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).c(str, AbstractC3474ma.a(this, str, "TAG", "setDefaultPosition "));
        }
        int[] iArr = new int[2];
        this.y = new JSONObject();
        if (this.m == null) {
            ViewParent parent = getParent();
            this.m = new WeakReference(parent instanceof ViewGroup ? (ViewGroup) parent : null);
        }
        WeakReference weakReference = this.m;
        try {
            if ((weakReference != null ? (ViewGroup) weakReference.get() : null) != null) {
                WeakReference weakReference2 = this.m;
                if (weakReference2 != null && (viewGroup3 = (ViewGroup) weakReference2.get()) != null) {
                    viewGroup3.getLocationOnScreen(iArr);
                }
                JSONObject jSONObject = this.y;
                if (jSONObject != null) {
                    jSONObject.put(VastAttributes.HORIZONTAL_POSITION, AbstractC3565t3.a(iArr[0]));
                }
                JSONObject jSONObject2 = this.y;
                if (jSONObject2 != null) {
                    jSONObject2.put(VastAttributes.VERTICAL_POSITION, AbstractC3565t3.a(iArr[1]));
                }
                WeakReference weakReference3 = this.m;
                int iA = AbstractC3565t3.a((weakReference3 == null || (viewGroup2 = (ViewGroup) weakReference3.get()) == null) ? 0 : viewGroup2.getWidth());
                WeakReference weakReference4 = this.m;
                int iA2 = AbstractC3565t3.a((weakReference4 == null || (viewGroup = (ViewGroup) weakReference4.get()) == null) ? 0 : viewGroup.getHeight());
                JSONObject jSONObject3 = this.y;
                if (jSONObject3 != null) {
                    jSONObject3.put("width", iA);
                }
                JSONObject jSONObject4 = this.y;
                if (jSONObject4 != null) {
                    jSONObject4.put("height", iA2);
                }
            } else {
                JSONObject jSONObject5 = this.y;
                if (jSONObject5 != null) {
                    jSONObject5.put(VastAttributes.HORIZONTAL_POSITION, 0);
                }
                JSONObject jSONObject6 = this.y;
                if (jSONObject6 != null) {
                    jSONObject6.put(VastAttributes.VERTICAL_POSITION, 0);
                }
                JSONObject jSONObject7 = this.y;
                if (jSONObject7 != null) {
                    jSONObject7.put("width", 0);
                }
                JSONObject jSONObject8 = this.y;
                if (jSONObject8 != null) {
                    jSONObject8.put("height", 0);
                }
            }
        } catch (JSONException unused) {
        }
        synchronized (this.J) {
            this.A = false;
            this.J.notifyAll();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void q() {
        int webImpressionMinPercentageViewed;
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).a(str, AbstractC3474ma.a(this, str, "TAG", "setFallbackImpressionMinPercentageViewed "));
        }
        AdConfig adConfig = null;
        if (Intrinsics.areEqual("video", this.s0)) {
            AdConfig adConfig2 = this.t;
            if (adConfig2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdConfig");
            } else {
                adConfig = adConfig2;
            }
            webImpressionMinPercentageViewed = adConfig.getViewability().getVideoImpressionMinPercentageViewed();
        } else if (!Intrinsics.areEqual("audio", this.s0)) {
            AdConfig adConfig3 = this.t;
            if (adConfig3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdConfig");
            } else {
                adConfig = adConfig3;
            }
            webImpressionMinPercentageViewed = adConfig.getViewability().getWebImpressionMinPercentageViewed();
        } else if (Intrinsics.areEqual("audio", getAdType())) {
            AdConfig adConfig4 = this.t;
            if (adConfig4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdConfig");
            } else {
                adConfig = adConfig4;
            }
            webImpressionMinPercentageViewed = adConfig.getViewability().getAudioImpressionMinPercentageViewed();
        } else {
            AdConfig adConfig5 = this.t;
            if (adConfig5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdConfig");
            } else {
                adConfig = adConfig5;
            }
            webImpressionMinPercentageViewed = adConfig.getViewability().getWebImpressionMinPercentageViewed();
        }
        this.m0 = webImpressionMinPercentageViewed;
    }

    public final void r() {
        int webImpressionMinTimeViewed;
        AdConfig adConfig = null;
        if (Intrinsics.areEqual("video", this.s0)) {
            AdConfig adConfig2 = this.t;
            if (adConfig2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdConfig");
            } else {
                adConfig = adConfig2;
            }
            webImpressionMinTimeViewed = adConfig.getViewability().getVideoImpressionMinTimeViewed();
        } else if (!Intrinsics.areEqual("audio", this.s0)) {
            AdConfig adConfig3 = this.t;
            if (adConfig3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdConfig");
            } else {
                adConfig = adConfig3;
            }
            webImpressionMinTimeViewed = adConfig.getViewability().getWebImpressionMinTimeViewed();
        } else if (Intrinsics.areEqual("audio", getAdType())) {
            AdConfig adConfig4 = this.t;
            if (adConfig4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdConfig");
            } else {
                adConfig = adConfig4;
            }
            webImpressionMinTimeViewed = adConfig.getViewability().getAudioImpressionMinTimeViewed();
        } else {
            AdConfig adConfig5 = this.t;
            if (adConfig5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdConfig");
            } else {
                adConfig = adConfig5;
            }
            webImpressionMinTimeViewed = adConfig.getViewability().getWebImpressionMinTimeViewed();
        }
        this.l0 = webImpressionMinTimeViewed;
    }

    public final void s() {
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).a(str, AbstractC3474ma.a(this, str, "TAG", "setFallbackImpressionParams "));
        }
        r();
        q();
        t();
    }

    public final void setAdPodHandler(K k) {
        this.d0 = k;
    }

    public final void setAdSize(String adSize) {
        Intrinsics.checkNotNullParameter(adSize, "adSize");
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).a(str, AbstractC3474ma.a(this, str, "TAG", "setAdSize "));
        }
        C3579u3 c3579u3 = AbstractC3565t3.f3431a;
        this.g0 = (int) (AbstractC3565t3.b() * Integer.parseInt(((String[]) new Regex(VastAttributes.HORIZONTAL_POSITION).split(adSize, 0).toArray(new String[0]))[0]));
        this.j0 = ((int) (AbstractC3565t3.b() * Integer.parseInt(((String[]) new Regex(VastAttributes.HORIZONTAL_POSITION).split(adSize, 0).toArray(new String[0]))[1]))) * this.g0;
    }

    public void setAdType(String str) {
        this.U = str;
    }

    public final void setAllowAutoRedirection(boolean z) {
        this.c0 = z;
    }

    public final void setAndUpdateViewState(String state) {
        Intrinsics.checkNotNullParameter(state, "state");
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).c(str, AbstractC3474ma.a(this, str, "TAG", "setAndUpdateViewState "));
        }
        this.p = state;
        L4 l5 = this.i;
        if (l5 != null) {
            String str2 = O0;
            ((M4) l5).a(str2, O5.a(str2, "TAG", "set state:").append(this.p).toString());
        }
        Locale ENGLISH = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
        String lowerCase = state.toLowerCase(ENGLISH);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        L4 l6 = this.i;
        if (l6 != null) {
            String TAG = O0;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l6).a(TAG, "fireStateChange " + this + ' ' + lowerCase);
        }
        b("window.mraidview.broadcastEvent('stateChange','" + lowerCase + "');");
    }

    public final void setBeaconUrl(String str) {
        this.x0 = str;
    }

    public final void setBlobProvider(L1 l1) {
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).c(str, AbstractC3474ma.a(this, str, "TAG", "setBlobProvider "));
        }
        this.W = l1;
    }

    public final void setCloseAssetArea(yd value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (!this.G0) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            if (!AbstractC3420j2.a(context)) {
                return;
            }
        }
        this.L0 = new yd(0, value.b, value.c, 0);
    }

    public final void setCloseEndCardTracker(String url) {
        Rc rcD;
        Hc hc;
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).a(str, AbstractC3474ma.a(this, str, "TAG", "setCloseEndCardTracker "));
        }
        r referenceContainer = getReferenceContainer();
        if (!(referenceContainer instanceof C3398h8) || url == null) {
            return;
        }
        C3398h8 c3398h8 = (C3398h8) referenceContainer;
        c3398h8.getClass();
        Intrinsics.checkNotNullParameter(url, "url");
        L4 l5 = c3398h8.W;
        if (l5 != null) {
            String str2 = c3398h8.X;
            ((M4) l5).c(str2, P5.a(str2, "TAG", "Setting close end tracker with URL : ", url));
        }
        View videoContainerView = c3398h8.getVideoContainerView();
        if (videoContainerView instanceof C3570t8) {
            Object tag = ((C3570t8) videoContainerView).getVideoView().getTag();
            C3426j8 c3426j8 = tag instanceof C3426j8 ? (C3426j8) tag : null;
            if (c3426j8 == null || (rcD = c3426j8.d()) == null || (hc = ((Qc) rcD).j) == null) {
                return;
            }
            C3328c8 tracker = new C3328c8(url, 0, "closeEndCard", null);
            Intrinsics.checkNotNullParameter(tracker, "tracker");
            hc.f.add(tracker);
        }
    }

    public final void setConfiguredArea(long j) {
        this.j0 = ((long) getWidth()) * ((long) getHeight());
    }

    public final void setContentURL(String str) {
        this.h0 = str;
    }

    public void setCreativeId(String str) {
        this.R = str;
    }

    public final void setDisableBackButton(boolean z) {
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).a(str, AbstractC3474ma.a(this, str, "TAG", "setDisableBackButton "));
        }
        this.G = z;
    }

    public final void setEmbeddedBrowserJSCallbacks(InterfaceC3635y3 interfaceC3635y3) {
        this.r0 = interfaceC3635y3;
    }

    public void setExitAnimation(int i) {
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).c(str, AbstractC3474ma.a(this, str, "TAG", "setExitAnimation "));
        }
        this.P = i;
    }

    public final void setExpandProperties(T3 expandProperties) {
        Intrinsics.checkNotNullParameter(expandProperties, "expandProperties");
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).a(str, AbstractC3474ma.a(this, str, "TAG", "setExpandProperties "));
        }
        if (expandProperties.c) {
            setUseCustomClose(expandProperties.b);
        }
        this.w = expandProperties;
    }

    public void setFriendlyViews(Map<View, ? extends FriendlyObstructionPurpose> map) {
        this.V = map;
    }

    @Override // com.inmobi.media.r
    public void setFullScreenActivityContext(Activity activity) {
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).a(str, AbstractC3474ma.a(this, str, "TAG", "setFullScreenActivityContext "));
        }
        this.l = new WeakReference(activity);
        w();
        if (this.e || activity == null) {
            return;
        }
        Ad ad = this.z0;
        if (ad != null) {
            ad.a();
        }
        this.z0 = new Ad(activity, this, this.i);
    }

    public final void setImmersiveMode(boolean z) {
        this.G0 = z;
    }

    public void setImpressionId(String str) {
        this.d = str;
    }

    public final void setLandingPageTelemetryControlInfoOnWebViewClient(Z5 z5) {
        A3 a3 = this.q0;
        if (a3 == null) {
            return;
        }
        a3.i = z5;
        a3.j = new W5(z5, a3);
    }

    public final void setLandingScheme(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f = str;
    }

    public final void setMarkupTypeAdUnit(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.C0 = str;
    }

    public final void setOrientationProperties(C3529q9 orientationProperties) {
        Intrinsics.checkNotNullParameter(orientationProperties, "orientationProperties");
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).a(str, AbstractC3474ma.a(this, str, "TAG", "setOrientationProperties "));
        }
        this.t0 = orientationProperties;
        w();
    }

    public final void setOriginalRenderView(Ba ba) {
        this.k = ba;
    }

    public final void setPlacementId(long j) {
        this.Q = j;
    }

    public final void setPreloadView(boolean z) {
        this.b0 = z;
    }

    public void setReferenceContainer(r rVar) {
        this.a0 = rVar;
    }

    public final void setRenderViewEventListener(Da da) {
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).c(str, AbstractC3474ma.a(this, str, "TAG", "setRenderViewEventListener "));
        }
        this.n = da;
    }

    public final void setResizeProperties(Ua ua) {
        this.x = ua;
    }

    public final void setScrollable(boolean z) {
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).c(str, AbstractC3474ma.a(this, str, "TAG", "setScrollable "));
        }
        setScrollContainer(z);
        setVerticalScrollBarEnabled(z);
        setHorizontalScrollBarEnabled(z);
    }

    public final void setShouldFireLandingPageBeacons(boolean z) {
        this.y0 = z;
    }

    public void setTelemetryManagerMap(Map<String, E0> map) {
        this.A0 = map;
    }

    public final void setUseCustomClose(boolean z) {
        L4 l4 = this.i;
        if (l4 != null) {
            String TAG = O0;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "setUseCustomClose " + this + ' ' + z);
        }
        this.C = z;
    }

    public void setViewTouchTimestamp(long j) {
        this.g = j;
    }

    public final void setWatermark(final WatermarkData watermarkData) {
        Intrinsics.checkNotNullParameter(watermarkData, "watermarkData");
        if (getAdConfig().getWatermarkEnabled()) {
            final byte[] bArrDecode = Base64.decode(watermarkData.getWatermarkBase64EncodedString(), 0);
            Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.inmobi.media.Ba$$ExternalSyntheticLambda3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    Ba.a(this.f$0, bArrDecode, watermarkData);
                }
            });
        } else {
            L4 l4 = this.i;
            if (l4 != null) {
                String TAG = O0;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((M4) l4).c(TAG, "Watermark disabled from config. ignoring...");
            }
        }
    }

    @Override // android.webkit.WebView
    public final void stopLoading() {
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).a(str, AbstractC3474ma.a(this, str, "TAG", "stopLoading "));
        }
        if (this.I.get()) {
            return;
        }
        super.stopLoading();
    }

    public final void t() {
        byte interstitialImpressionType;
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).a(str, AbstractC3474ma.a(this, str, "TAG", "setFallbackImpressionType "));
        }
        String adType = getAdType();
        AdConfig adConfig = null;
        if (Intrinsics.areEqual(adType, "banner")) {
            AdConfig adConfig2 = this.t;
            if (adConfig2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdConfig");
            } else {
                adConfig = adConfig2;
            }
            interstitialImpressionType = adConfig.getViewability().getBannerImpressionType();
        } else if (Intrinsics.areEqual(adType, "audio")) {
            AdConfig adConfig3 = this.t;
            if (adConfig3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdConfig");
            } else {
                adConfig = adConfig3;
            }
            interstitialImpressionType = adConfig.getViewability().getAudioImpressionType();
        } else {
            AdConfig adConfig4 = this.t;
            if (adConfig4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdConfig");
            } else {
                adConfig = adConfig4;
            }
            interstitialImpressionType = adConfig.getViewability().getInterstitialImpressionType();
        }
        this.j = interstitialImpressionType;
    }

    public final void u() {
        new C3406i2(this, !this.C, !this.F, this.i).a(this.L0);
    }

    public final void v() {
        getListener().d(this);
        L4 l4 = this.i;
        if (l4 != null) {
            String TAG = O0;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "ad dismissed");
        }
        L4 l5 = this.i;
        if (l5 != null) {
            ((M4) l5).a();
        }
        Z z = this.u0;
        if (z == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adQualityManager");
            z = null;
        }
        if (z.d.get()) {
            z.a("session end is already triggered");
            return;
        }
        if (!z.f3249a.getEnabled()) {
            z.a("config kill switch - false. ad quality will skip");
        } else if (z.g == null) {
            z.a("setup not done. ignore trigger");
        } else {
            z.d.set(true);
            z.a(false);
        }
    }

    public final void w() {
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).a(str, AbstractC3474ma.a(this, str, "TAG", "updateActivitiesOrientationProperties "));
        }
        Activity activity = (Activity) this.l.get();
        if (activity == null || !(activity instanceof InMobiAdActivity)) {
            return;
        }
        C3529q9 orientationProperties = this.t0;
        Intrinsics.checkNotNullParameter(orientationProperties, "orientationProperties");
        C3622x4 c3622x4 = ((InMobiAdActivity) activity).f3023a;
        if (c3622x4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orientationHandler");
            c3622x4 = null;
        }
        c3622x4.a(orientationProperties);
    }

    public final void x() {
        int i = S3.f3188a;
        ((ScheduledThreadPoolExecutor) S3.b.getValue()).execute(new Runnable() { // from class: com.inmobi.media.Ba$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Ba.b(this.f$0);
            }
        });
    }

    @Override // com.inmobi.media.xd
    public final boolean f() {
        return !Intrinsics.areEqual("Hidden", this.p);
    }

    public final void a(String url, String templateInfoStr, boolean z) {
        Activity activity;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(templateInfoStr, "templateInfoStr");
        try {
            JSONObject jSONObject = new JSONObject(templateInfoStr);
            L4 l4 = this.i;
            if (l4 != null) {
                String TAG = O0;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((M4) l4).a(TAG, "report - " + getAdType() + " type - sdk - " + Build.VERSION.SDK_INT);
            }
            if (Intrinsics.areEqual(getAdType(), com.safedk.android.analytics.brandsafety.l.w) && Build.VERSION.SDK_INT >= 29 && (activity = (Activity) this.l.get()) != null) {
                ScheduledExecutorService scheduledExecutorService = P.f3162a;
                P.a(activity, this, url, z, jSONObject, this.B0);
            } else {
                ScheduledExecutorService scheduledExecutorService2 = P.f3162a;
                P.a(this, this, url, z, jSONObject, this.B0);
            }
        } catch (Exception e) {
            L4 l5 = this.i;
            if (l5 != null) {
                String TAG2 = O0;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((M4) l5).a(TAG2, "issue wile reporting ad", e);
            }
        }
    }

    public static final void a(Ba this$0) {
        L4 l4;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isAttachedToWindow() || (l4 = this$0.i) == null) {
            return;
        }
        ((M4) l4).a();
    }

    public final void a(Da da, AdConfig adConfig) {
        AdConfig adConfig2;
        int otherNetworkLoadsLimit;
        AdConfig adConfig3;
        AdConfig adConfig4;
        WebViewClient webViewClient;
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).c(str, AbstractC3474ma.a(this, str, "TAG", "initialize "));
        }
        if (Intrinsics.areEqual(this.C0, "htmlUrl")) {
            getSettings().setMixedContentMode(2);
        }
        this.t = adConfig;
        L4 l5 = this.i;
        if (l5 != null) {
            String str2 = O0;
            ((M4) l5).a(str2, AbstractC3474ma.a(this, str2, "TAG", "setImpressionParams "));
        }
        if (this.c == null) {
            s();
        } else {
            try {
                s();
                for (C3504oc c3504oc : this.c) {
                    if (c3504oc.f3393a == 2) {
                        if (c3504oc.b.containsKey("type")) {
                            Object obj = c3504oc.b.get("type");
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                            this.j = (byte) ((Integer) obj).intValue();
                        } else {
                            t();
                        }
                        if (c3504oc.b.containsKey("time")) {
                            Object obj2 = c3504oc.b.get("time");
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                            this.l0 = ((Integer) obj2).intValue();
                        } else {
                            r();
                        }
                        if (c3504oc.b.containsKey("view")) {
                            Object obj3 = c3504oc.b.get("view");
                            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Int");
                            this.m0 = ((Integer) obj3).intValue();
                        } else {
                            q();
                        }
                        if (this.j == 2) {
                            if (c3504oc.b.containsKey("pixel")) {
                                Object obj4 = c3504oc.b.get("pixel");
                                Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Int");
                                this.k0 = ((Integer) obj4).intValue();
                            } else {
                                t();
                            }
                            if (c3504oc.b.containsKey(TypedValues.AttributesType.S_FRAME)) {
                                Object obj5 = c3504oc.b.get(TypedValues.AttributesType.S_FRAME);
                                JSONArray jSONArray = obj5 instanceof JSONArray ? (JSONArray) obj5 : null;
                                if (jSONArray != null) {
                                    this.i0 = new int[jSONArray.length()];
                                    int length = jSONArray.length();
                                    for (int i = 0; i < length; i++) {
                                        int[] iArr = this.i0;
                                        if (iArr != null) {
                                            Object obj6 = jSONArray.get(i);
                                            Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.Int");
                                            iArr[i] = ((Integer) obj6).intValue();
                                        }
                                    }
                                }
                            } else {
                                t();
                            }
                        }
                    }
                }
            } catch (JSONException unused) {
                L4 l6 = this.i;
                if (l6 != null) {
                    String TAG = O0;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((M4) l6).b(TAG, "Exception in parsing the impressionType and pixel frame");
                }
                s();
            } catch (Exception unused2) {
                L4 l7 = this.i;
                if (l7 != null) {
                    String TAG2 = O0;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    ((M4) l7).b(TAG2, "SDK encountered an unexpected error in parsing impression parameters");
                }
                s();
            }
        }
        this.n = da;
        ViewParent parent = getParent();
        this.m = new WeakReference(parent instanceof ViewGroup ? (ViewGroup) parent : null);
        setBackgroundColor(getRenderingConfig().getWebviewBackgroundColor());
        new H6(getMraidConfig().getUrl(), getMraidConfig().getMaxRetries(), getMraidConfig().getRetryInterval(), getMraidConfig().getExpiry(), this.i).a();
        setImportantForAccessibility(2);
        setScrollable(false);
        int i2 = Build.VERSION.SDK_INT;
        getSettings().setMediaPlaybackRequiresUserGesture(false);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(getAdConfig().getRendering().getEnableDomStorage());
        getSettings().setGeolocationEnabled(true);
        if (this.e) {
            L4 l8 = this.i;
            if (l8 != null) {
                String TAG3 = O0;
                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                ((M4) l8).c(TAG3, "view is in-app browser. Using EmbeddedBrowserViewClient.");
            }
            A3 a3 = new A3("IN_CUSTOM_BROWSER", C3558sa.f3429a, C3572ta.f3435a, this.i);
            this.q0 = a3;
            webViewClient = a3;
        } else {
            L4 l9 = this.i;
            if (l9 != null) {
                String TAG4 = O0;
                Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
                ((M4) l9).c(TAG4, "view is ad. Using RenderViewClient");
            }
            Ca ca = new Ca(this.T, this.i, new C3586ua(this));
            String adType = getAdType();
            if (Intrinsics.areEqual(adType, "banner")) {
                AdConfig adConfig5 = this.t;
                if (adConfig5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAdConfig");
                    adConfig4 = null;
                } else {
                    adConfig4 = adConfig5;
                }
                otherNetworkLoadsLimit = adConfig4.getRendering().getBannerNetworkLoadsLimit();
            } else if (Intrinsics.areEqual(adType, "audio")) {
                AdConfig adConfig6 = this.t;
                if (adConfig6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAdConfig");
                    adConfig3 = null;
                } else {
                    adConfig3 = adConfig6;
                }
                otherNetworkLoadsLimit = adConfig3.getRendering().getAudioNetworkLoadsLimit();
            } else {
                AdConfig adConfig7 = this.t;
                if (adConfig7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAdConfig");
                    adConfig2 = null;
                } else {
                    adConfig2 = adConfig7;
                }
                otherNetworkLoadsLimit = adConfig2.getRendering().getOtherNetworkLoadsLimit();
            }
            ca.b = otherNetworkLoadsLimit;
            webViewClient = ca;
        }
        setWebViewClient(webViewClient);
        if (this.e && getAdConfig().getEnableCookiesOnInAppBrowser()) {
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            cookieManager.setAcceptThirdPartyCookies(this, true);
        }
        setWebChromeClient(this.J0);
        if (!this.e) {
            D5 d5 = new D5(this.b, this);
            L4 logger = this.i;
            if (logger != null) {
                Intrinsics.checkNotNullParameter(logger, "logger");
                d5.d = logger;
            }
            InMobiNetworkBridge.onAddedJavascriptInterface(this, d5, "sdkController");
        }
        this.q = new G6(this, getMarkupType(), this.i);
        this.r = new N6(this, this.i);
        this.s = new M6(this, this.i);
        this.w = new T3();
        this.x = new Ua("top-right", true);
        this.u0 = new Z(adConfig.getAdQuality(), this.i);
        if (i2 >= 29) {
            setWebViewRenderProcessClient((ScheduledThreadPoolExecutor) S3.b.getValue(), new Ga(this.i, this.T));
        }
    }

    @Override // com.inmobi.media.r
    public final boolean c() {
        return this.I.get();
    }

    public final void c(String str) {
        Ia ia = this.T;
        if (ia != null) {
            ia.b();
        }
        L4 l4 = this.i;
        if (l4 != null) {
            String str2 = O0;
            ((M4) l4).a(str2, AbstractC3474ma.a(this, str2, "TAG", "loadDataInWebView "));
        }
        this.L = false;
        if (this.I.get()) {
            return;
        }
        Intrinsics.checkNotNull(str);
        InMobiNetworkBridge.webviewLoadDataWithBaseURL(this, "", str, POBCommonConstants.CONTENT_TYPE_HTML, "UTF-8", null);
    }

    public final void b(final String value) {
        Intrinsics.checkNotNullParameter(value, "js");
        L4 l4 = this.i;
        if (l4 != null) {
            String TAG = O0;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "injectJavaScript " + this + " - " + value);
        }
        Intrinsics.checkNotNullParameter(value, "value");
        new Handler(getContainerContext().getMainLooper()).postAtFrontOfQueue(new Runnable() { // from class: com.inmobi.media.Ba$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                Ba.a(this.f$0, value);
            }
        });
    }

    public final void b(String str, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        L4 l4 = this.i;
        if (l4 != null) {
            String str2 = O0;
            ((M4) l4).a(str2, AbstractC3474ma.a(this, str2, "TAG", "processMediaPlaybackRequest "));
        }
        if (1 != this.b && !Intrinsics.areEqual("Expanded", this.p)) {
            L4 l5 = this.i;
            if (l5 != null) {
                String TAG = O0;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((M4) l5).b(TAG, "Media playback is only supported on full screen ads! Ignoring request ...");
                return;
            }
            return;
        }
        Activity activity = (Activity) this.l.get();
        if (activity == null) {
            L4 l6 = this.i;
            if (l6 != null) {
                String TAG2 = O0;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((M4) l6).b(TAG2, "Media playback is  not allowed before it is visible! Ignoring request ...");
            }
            a(str, "Media playback is  not allowed before it is visible! Ignoring request ...", MraidJsMethods.PLAY_VIDEO);
            return;
        }
        M6 m6 = this.s;
        if (m6 != null) {
            m6.a(url, activity);
        }
    }

    public final void d(boolean z) {
        L4 l4 = this.i;
        if (l4 != null) {
            String TAG = O0;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "processDisableCloseRegionRequest " + this + ' ' + z);
        }
        this.F = z;
        u();
    }

    @Override // com.inmobi.media.InterfaceC3386ga
    public final boolean d() {
        L4 l4 = this.i;
        if (l4 != null) {
            String TAG = O0;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "canRedirectExternally Called");
        }
        return !getRenderingConfig().getAutoRedirectionEnforcement() || (getViewTouchTimestamp() != -1 && SystemClock.elapsedRealtime() - getViewTouchTimestamp() < getRenderingConfig().getUserTouchResetTime());
    }

    @Override // com.inmobi.media.r
    public final void a(byte b, Map map) {
        L4 l4 = this.i;
        if (l4 != null) {
            String TAG = O0;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "fireEvent " + this + " 2");
        }
    }

    @Override // com.inmobi.media.InterfaceC3386ga
    public final void a(String mraidApi) {
        Intrinsics.checkNotNullParameter(mraidApi, "mraidApi");
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).a(str, AbstractC3474ma.a(this, str, "TAG", "sendFraudBeaconAndTelemetryEvent "));
        }
        L4 l5 = this.i;
        if (l5 != null) {
            String TAG = O0;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l5).a(TAG, "fireDetectAutoRedirectFraud " + this + ' ' + mraidApi);
        }
        b("window.mraidview.fireRedirectFraudBeacon('" + mraidApi + "')");
        String adType = getAdType();
        if (adType == null) {
            adType = "banner";
        }
        L4 l6 = this.i;
        if (l6 != null) {
            String TAG2 = O0;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((M4) l6).c(TAG2, "sendTelemetryForAutoRedirectFraud " + this + ' ' + mraidApi + ' ' + adType);
        }
        HashMap map = new HashMap();
        String creativeId = getCreativeId();
        if (creativeId != null) {
            map.put("creativeId", creativeId);
        }
        map.put(DivActionHandler.DivActionReason.TRIGGER, mraidApi);
        String impressionId = getImpressionId();
        if (impressionId != null) {
            map.put("impressionId", impressionId);
        }
        map.put(com.smaato.sdk.video.vast.model.Ad.AD_TYPE, adType);
        L4 l7 = this.i;
        if (l7 != null) {
            String str2 = O0;
            ((M4) l7).a(str2, AbstractC3474ma.a(this, str2, "TAG", "processTelemetryEvent "));
        }
        getListener().a("BlockAutoRedirection", map);
    }

    public final void a(boolean z) {
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).a(str, AbstractC3474ma.a(this, str, "TAG", "fireNextAdLoadComplete "));
        }
        String str2 = "window.imraidview.broadcastEvent('adLoadSuccess'," + z + ");";
        L4 l5 = this.i;
        if (l5 != null) {
            String TAG = O0;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l5).c(TAG, str2 + " Index: " + getCurrentRenderingPodAdIndex());
        }
        b(str2);
    }

    public final void b(String str, String contentId, String url) {
        Intrinsics.checkNotNullParameter(contentId, "contentId");
        Intrinsics.checkNotNullParameter(url, "url");
        L4 l4 = this.i;
        if (l4 != null) {
            String str2 = O0;
            ((M4) l4).c(str2, AbstractC3474ma.a(this, str2, "TAG", "processSaveContentRequest "));
        }
        L4 l5 = this.i;
        if (l5 != null) {
            String TAG = O0;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l5).a(TAG, "saveContent called: content ID: " + contentId + "; URL: " + url);
        }
        if (!f("saveContent")) {
            L4 l6 = this.i;
            if (l6 != null) {
                String TAG2 = O0;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((M4) l6).b(TAG2, "saveContent called despite the fact that it is not supported");
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", url);
                jSONObject.put("reason", 7);
            } catch (JSONException unused) {
            }
            String string = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            a(str, "sendSaveContentResult(\"saveContent_" + contentId + "\", 'failed', \"" + StringsKt.replace$default(string, "\"", "\\\"", false, 4, (Object) null) + "\");");
            return;
        }
        HashSet hashSet = new HashSet();
        hashSet.add(new C3372fa((byte) -1, url));
        String string2 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        C3431k c3431k = new C3431k(string2, hashSet, this.K0, contentId, 2);
        c3431k.c = str;
        C3335d1 c3335d1 = C3335d1.f3289a;
        C3335d1.a(c3431k);
    }

    public final void e(boolean z) {
        L4 l4 = this.i;
        if (l4 != null) {
            String TAG = O0;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "processUseCustomCloseRequest " + this + ' ' + z);
        }
        setUseCustomClose(z);
        u();
    }

    @Override // com.inmobi.media.r
    public final void e() {
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).c(str, AbstractC3474ma.a(this, str, "TAG", "disableHardwareAcceleration called. "));
        }
        try {
            setLayerType(1, null);
        } catch (Exception e) {
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
        }
    }

    public final void a(String str, String message, String str2) {
        Intrinsics.checkNotNullParameter(message, "message");
        L4 l4 = this.i;
        if (l4 != null) {
            String TAG = O0;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "fireError " + this + " - " + message + " - " + str2);
        }
        if (str == null || str2 == null) {
            return;
        }
        a(str, "broadcastEvent('error',\"" + message + "\", \"" + str2 + "\")");
    }

    public final void a(String str, String callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        L4 l4 = this.i;
        if (l4 != null) {
            String str2 = O0;
            ((M4) l4).a(str2, AbstractC3474ma.a(this, str2, "TAG", "fireJavaScriptCallback "));
        }
        if (str == null) {
            return;
        }
        b(str + '.' + callback);
    }

    public static final void b(Ba this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        synchronized (this$0.o) {
            if (Intrinsics.areEqual("Loading", this$0.p)) {
                L4 l4 = this$0.i;
                if (l4 != null) {
                    String TAG = O0;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((M4) l4).a(TAG, "updateWebViewLoaded " + this$0);
                }
                this$0.getListener().f(this$0);
                this$0.setAndUpdateViewState(this$0.k == null ? Profile.DEFAULT_PROFILE_NAME : "Expanded");
                L4 l5 = this$0.i;
                if (l5 != null) {
                    String TAG2 = O0;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    ((M4) l5).a(TAG2, "updateWebViewLoaded state changed to " + this$0.p);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void b(boolean z) {
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).c(str, AbstractC3474ma.a(this, str, "TAG", "fireNextAdShowComplete "));
        }
        String str2 = "window.imraidview.broadcastEvent('adShowSuccess'," + z + ");";
        L4 l5 = this.i;
        if (l5 != null) {
            String TAG = O0;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l5).a(TAG, str2 + " Index: " + getCurrentRenderingPodAdIndex());
        }
        b(str2);
    }

    public static final void a(Ba this$0, String js) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(js, "$js");
        try {
            if (this$0.I.get()) {
                return;
            }
            String str = "javascript:try{" + js + "}catch(e){}";
            L4 l4 = this$0.i;
            if (l4 != null) {
                String TAG = O0;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((M4) l4).a(TAG, "Injecting javascript");
            }
            L4 l5 = this$0.i;
            if (l5 != null) {
                String TAG2 = O0;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((M4) l5).c(TAG2, "evaluateScript " + this$0);
            }
            this$0.evaluateJavascript(str, null);
        } catch (Exception e) {
            L4 l6 = this$0.i;
            if (l6 != null) {
                String str2 = O0;
                ((M4) l6).b(str2, ld.a(e, O5.a(str2, "TAG", "SDK encountered an unexpected error injecting JavaScript in the Ad container; ")));
            }
        }
    }

    @Override // com.inmobi.media.r
    public final void a() {
        ViewGroup viewGroup;
        K k;
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).a(str, AbstractC3474ma.a(this, str, "TAG", "dismissCurrentViewContainer "));
        }
        M6 m6 = this.s;
        if (m6 != null) {
            B6 b6 = m6.c;
            if (b6 != null) {
                b6.b();
            }
            m6.c = null;
        }
        if (Intrinsics.areEqual("Expanded", this.p)) {
            L4 l5 = this.i;
            if (l5 != null) {
                String str2 = O0;
                ((M4) l5).a(str2, AbstractC3474ma.a(this, str2, "TAG", "processCloseRequestOnExpandedRenderView "));
            }
            if (!Intrinsics.areEqual(Profile.DEFAULT_PROFILE_NAME, this.p)) {
                this.L = true;
                G6 g6 = this.q;
                if (g6 != null) {
                    L4 l6 = g6.c;
                    if (l6 != null) {
                        String TAG = g6.d;
                        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                        ((M4) l6).c(TAG, "closeExpandedView");
                    }
                    if (g6.f3079a.getOriginalRenderView() == null) {
                        ViewGroup viewGroup2 = g6.e;
                        View rootView = viewGroup2 != null ? viewGroup2.getRootView() : null;
                        if (rootView != null) {
                            View viewFindViewById = rootView.findViewById(65535);
                            ViewParent parent = g6.f3079a.getParent();
                            ViewGroup viewGroup3 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                            if (viewGroup3 != null) {
                                viewGroup3.removeView(g6.f3079a);
                            }
                            ViewParent parent2 = viewFindViewById != null ? viewFindViewById.getParent() : null;
                            viewGroup = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
                            if (viewGroup != null) {
                                viewGroup.removeView(viewFindViewById);
                            }
                            ViewGroup viewGroup4 = g6.e;
                            if (viewGroup4 != null) {
                                viewGroup4.addView(g6.f3079a, g6.f, new RelativeLayout.LayoutParams(viewGroup4.getWidth(), viewGroup4.getHeight()));
                            }
                            Ba ba = g6.f3079a;
                            L4 l7 = ba.i;
                            if (l7 != null) {
                                String str3 = O0;
                                ((M4) l7).a(str3, AbstractC3474ma.a(ba, str3, "TAG", "resetLayout "));
                            }
                            ba.setVisibility(0);
                            ba.requestLayout();
                        }
                    }
                }
                h();
                this.L = false;
            }
            this.D = false;
        } else if (Intrinsics.areEqual("Resized", this.p)) {
            L4 l8 = this.i;
            if (l8 != null) {
                String str4 = O0;
                ((M4) l8).a(str4, AbstractC3474ma.a(this, str4, "TAG", "processCloseRequestOnResizedRenderView "));
            }
            if (!Intrinsics.areEqual(Profile.DEFAULT_PROFILE_NAME, this.p)) {
                this.L = true;
                N6 n6 = this.r;
                if (n6 != null) {
                    L4 l9 = n6.b;
                    if (l9 != null) {
                        ((M4) l9).c("MraidResizeProcession", "closeResizedView()");
                    }
                    ViewParent parent3 = n6.f3146a.getParent();
                    ViewGroup viewGroup5 = parent3 instanceof ViewGroup ? (ViewGroup) parent3 : null;
                    View rootView2 = viewGroup5 != null ? viewGroup5.getRootView() : null;
                    View viewFindViewById2 = rootView2 != null ? rootView2.findViewById(65534) : null;
                    ViewGroup viewGroup6 = n6.c;
                    View rootView3 = viewGroup6 != null ? viewGroup6.getRootView() : null;
                    View viewFindViewById3 = rootView3 != null ? rootView3.findViewById(65535) : null;
                    ViewParent parent4 = viewFindViewById3 != null ? viewFindViewById3.getParent() : null;
                    ViewGroup viewGroup7 = parent4 instanceof ViewGroup ? (ViewGroup) parent4 : null;
                    ViewParent parent5 = viewFindViewById2 != null ? viewFindViewById2.getParent() : null;
                    viewGroup = parent5 instanceof ViewGroup ? (ViewGroup) parent5 : null;
                    if (viewGroup != null) {
                        viewGroup.removeView(viewFindViewById2);
                    }
                    if (viewGroup7 != null) {
                        viewGroup7.removeView(viewFindViewById3);
                    }
                    if (viewGroup5 != null) {
                        viewGroup5.removeView(n6.f3146a);
                    }
                    ViewGroup viewGroup8 = n6.c;
                    if (viewGroup8 != null) {
                        viewGroup8.addView(n6.f3146a, n6.d, new RelativeLayout.LayoutParams(viewGroup8.getWidth(), viewGroup8.getHeight()));
                    }
                    Ba ba2 = n6.f3146a;
                    L4 l10 = ba2.i;
                    if (l10 != null) {
                        String str5 = O0;
                        ((M4) l10).a(str5, AbstractC3474ma.a(ba2, str5, "TAG", "resetLayout "));
                    }
                    ba2.setVisibility(0);
                    ba2.requestLayout();
                }
                setAndUpdateViewState(Profile.DEFAULT_PROFILE_NAME);
                v();
                this.L = false;
            }
        } else if (Intrinsics.areEqual(Profile.DEFAULT_PROFILE_NAME, this.p)) {
            setAndUpdateViewState("Hidden");
            ViewParent parent6 = getParent();
            if (1 == this.b) {
                h();
            } else if (parent6 instanceof ViewGroup) {
                ((ViewGroup) parent6).removeAllViews();
            }
        }
        if (this.E != Xc.VISIBLE || (k = this.d0) == null) {
            return;
        }
        k.a(this, getFullScreenActivity());
    }

    @Override // com.inmobi.media.InterfaceC3542r9
    public final void a(EnumC3501o9 orientation) {
        N6 n6;
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).a(str, AbstractC3474ma.a(this, str, "TAG", "onOrientationUpdate "));
        }
        if (!Intrinsics.areEqual("Resized", this.p) || this.x == null || (n6 = this.r) == null) {
            return;
        }
        n6.a();
    }

    @Override // com.inmobi.media.xd
    public final void a(EnumC3501o9 orientation, zd finalInsets) {
        JSONObject jSONObjectA;
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(finalInsets, "finalInsets");
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).c(str, AbstractC3474ma.a(this, str, "TAG", "fireOnSafeAreaChanged "));
        }
        StringBuilder sb = new StringBuilder("window.imraid.broadcastEvent('onSafeAreaChange', ");
        Intrinsics.checkNotNullParameter(finalInsets, "<this>");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        try {
            finalInsets.getClass();
            Intrinsics.checkNotNullParameter(orientation, "orientation");
            yd ydVar = (yd) finalInsets.f3497a.get(orientation);
            if (ydVar != null) {
                jSONObjectA = ydVar.a();
                jSONObjectA.put("orientation", AbstractC3515p9.a(orientation));
            } else {
                jSONObjectA = null;
            }
        } catch (Exception unused) {
        }
        b(sb.append(jSONObjectA).append(')').toString());
        finalInsets.getClass();
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        yd ydVar2 = (yd) finalInsets.f3497a.get(orientation);
        if (ydVar2 == null) {
            return;
        }
        if (ydVar2.b == 0 && ydVar2.c == 0) {
            return;
        }
        setCloseAssetArea(ydVar2);
        Intrinsics.checkNotNullParameter(this, "renderView");
        yd insets = this.L0;
        Intrinsics.checkNotNullParameter(insets, "insets");
        View viewFindViewById = getRootView().findViewById(65531);
        Z2 z2 = viewFindViewById instanceof Z2 ? (Z2) viewFindViewById : null;
        if (z2 == null) {
            return;
        }
        View viewFindViewById2 = getRootView().findViewById(65531);
        Z2 z3 = viewFindViewById2 instanceof Z2 ? (Z2) viewFindViewById2 : null;
        if (z3 == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = z2.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams3 = z3.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams4 = layoutParams3 instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams3 : null;
        if (layoutParams4 == null) {
            return;
        }
        layoutParams2.setMargins(0, insets.b, insets.c, 0);
        layoutParams4.setMargins(0, insets.b, insets.c, 0);
    }

    public static final boolean a(Ba ba, JsResult jsResult) {
        L4 l4 = ba.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).a(str, AbstractC3474ma.a(ba, str, "TAG", "shouldRenderPopup "));
        }
        if (ba.getRenderingConfig().getShouldRenderPopup()) {
            return true;
        }
        jsResult.cancel();
        L4 l5 = ba.i;
        if (l5 != null) {
            String str2 = O0;
            ((M4) l5).a(str2, AbstractC3474ma.a(ba, str2, "TAG", "firePopupBlockedEvent "));
        }
        ba.b("window.mraidview.popupBlocked('popupBlocked')");
        return false;
    }

    public static final void a(Ba ba, String str, String str2, String str3) {
        L4 l4 = ba.i;
        if (l4 != null) {
            String TAG = O0;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "onUserLandingInitialized " + ba + " isInAppBrowser: " + ba.e);
        }
        ba.b("window.imraid.broadcastEvent('onUserLandingInitialized');");
        if (str2 == null) {
            return;
        }
        ba.a(str2, "broadcastEvent('" + str + "Successful','" + str3 + "');");
    }

    public final void a(String trackerName, Map macros) {
        Intrinsics.checkNotNullParameter(trackerName, "trackerName");
        Intrinsics.checkNotNullParameter(macros, "macros");
        L4 l4 = this.i;
        if (l4 != null) {
            String str = O0;
            ((M4) l4).a(str, AbstractC3474ma.a(this, str, "TAG", "fireLandingPageTracker "));
        }
        getListener().a(this, trackerName, macros);
    }

    public final void a(boolean z, short s) {
        L4 l4 = this.i;
        if (l4 != null) {
            String TAG = O0;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "fireRenderProcessGoneTelemetry");
        }
        Ia ia = this.T;
        if (ia != null) {
            Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("source", "render_view_" + ia.f3098a.f3060a.b()), TuplesKt.to("isCrashed", Boolean.valueOf(z)), TuplesKt.to("creativeId", ia.f3098a.f), TuplesKt.to("errorCode", Short.valueOf(s)));
            Ob ob = Ob.f3160a;
            Ob.b("WebViewRenderProcessGoneEvent", mapMutableMapOf, Sb.SDK);
        }
    }
}
