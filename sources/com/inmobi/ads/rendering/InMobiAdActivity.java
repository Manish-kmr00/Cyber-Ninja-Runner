package com.inmobi.ads.rendering;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import com.inmobi.commons.core.configs.AdConfig;
import com.inmobi.commons.core.configs.Config;
import com.inmobi.media.A3;
import com.inmobi.media.AbstractC3351e3;
import com.inmobi.media.AbstractC3420j2;
import com.inmobi.media.AbstractC3498o6;
import com.inmobi.media.AbstractC3565t3;
import com.inmobi.media.AbstractC3636y4;
import com.inmobi.media.Ad;
import com.inmobi.media.B;
import com.inmobi.media.Ba;
import com.inmobi.media.C3339d5;
import com.inmobi.media.C3435k3;
import com.inmobi.media.C3517pb;
import com.inmobi.media.C3529q9;
import com.inmobi.media.C3594v4;
import com.inmobi.media.C3607w3;
import com.inmobi.media.C3622x4;
import com.inmobi.media.C3650z4;
import com.inmobi.media.Da;
import com.inmobi.media.E3;
import com.inmobi.media.I4;
import com.inmobi.media.InterfaceC3519q;
import com.inmobi.media.L4;
import com.inmobi.media.M4;
import com.inmobi.media.Z2;
import com.inmobi.media.Z5;
import com.inmobi.media.r;
import com.json.b9;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/inmobi/ads/rendering/InMobiAdActivity;", "Landroid/app/Activity;", "<init>", "()V", "com/inmobi/media/y4", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class InMobiAdActivity extends Activity {
    public static final SparseArray k = new SparseArray();
    public static Ba l;
    public static Da m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C3622x4 f3023a;
    public C3594v4 b;
    public Ba c;
    public int d;
    public boolean e;
    public boolean f;
    public boolean g;
    public L4 h;
    public Ad i;
    public OnBackInvokedCallback j;

    public static final void a(InMobiAdActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a();
    }

    public static final boolean b(InMobiAdActivity this$0, View view, MotionEvent motionEvent) {
        A3 a3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent.getAction() != 1) {
            if (motionEvent.getAction() == 0) {
                view.setBackgroundColor(-16711681);
            }
            return true;
        }
        view.setBackgroundColor(-7829368);
        Ba ba = this$0.c;
        if (ba != null && (a3 = ba.q0) != null) {
            A3.a(a3, 6, true, null, 12);
        }
        Ba ba2 = this$0.c;
        if (ba2 != null) {
            ba2.reload();
        }
        return true;
    }

    public static final boolean c(InMobiAdActivity this$0, View view, MotionEvent motionEvent) {
        A3 a3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent.getAction() != 1) {
            if (motionEvent.getAction() == 0) {
                view.setBackgroundColor(-16711681);
            }
            return true;
        }
        view.setBackgroundColor(-7829368);
        Ba ba = this$0.c;
        if (ba == null || !ba.canGoBack()) {
            Ba ba2 = this$0.c;
            if (ba2 != null && (a3 = ba2.q0) != null) {
                A3.a(a3, 5, true, null, 12);
            }
            this$0.e = true;
            this$0.finish();
        } else {
            Ba ba3 = this$0.c;
            if (ba3 != null) {
                ba3.goBack();
            }
        }
        return true;
    }

    public static final boolean d(InMobiAdActivity this$0, View view, MotionEvent motionEvent) {
        Ba ba;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent.getAction() != 1) {
            if (motionEvent.getAction() == 0) {
                view.setBackgroundColor(-16711681);
            }
            return true;
        }
        view.setBackgroundColor(-7829368);
        Ba ba2 = this$0.c;
        if (ba2 != null && ba2.canGoForward() && (ba = this$0.c) != null) {
            ba.goForward();
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.i, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        a();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        L4 l4 = this.h;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("InMobiAdActivity", "TAG");
            ((M4) l4).c("InMobiAdActivity", "onConfigChanged");
        }
        super.onConfigurationChanged(newConfig);
        C3622x4 c3622x4 = this.f3023a;
        if (c3622x4 != null) {
            if (c3622x4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("orientationHandler");
                c3622x4 = null;
            }
            c3622x4.b();
        }
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0140  */
    /* JADX WARN: Code duplicated, block: B:50:0x0153  */
    /* JADX WARN: Code duplicated, block: B:51:0x0157  */
    /* JADX WARN: Code duplicated, block: B:54:0x0166  */
    /* JADX WARN: Code duplicated, block: B:55:0x0171  */
    /* JADX WARN: Code duplicated, block: B:57:0x0176  */
    /* JADX WARN: Code duplicated, block: B:59:0x018d  */
    /* JADX WARN: Code duplicated, block: B:60:0x0191 A[PHI: r3
  0x0191: PHI (r3v10 com.inmobi.commons.core.configs.AdConfig) = (r3v9 com.inmobi.commons.core.configs.AdConfig), (r3v20 com.inmobi.commons.core.configs.AdConfig) binds: [B:56:0x0174, B:58:0x018b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:66:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:67:0x01e1 A[Catch: Exception -> 0x0264, TryCatch #2 {Exception -> 0x0264, blocks: (B:64:0x01d0, B:68:0x01e6, B:72:0x01f0, B:75:0x01f6, B:71:0x01eb, B:67:0x01e1), top: B:110:0x01d0 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:71:0x01eb A[Catch: Exception -> 0x0264, TryCatch #2 {Exception -> 0x0264, blocks: (B:64:0x01d0, B:68:0x01e6, B:72:0x01f0, B:75:0x01f6, B:71:0x01eb, B:67:0x01e1), top: B:110:0x01d0 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x01f4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:75:0x01f6 A[Catch: Exception -> 0x0264, TRY_LEAVE, TryCatch #2 {Exception -> 0x0264, blocks: (B:64:0x01d0, B:68:0x01e6, B:72:0x01f0, B:75:0x01f6, B:71:0x01eb, B:67:0x01e1), top: B:110:0x01d0 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x0203  */
    /* JADX WARN: Code duplicated, block: B:82:0x0209 A[Catch: Exception -> 0x0262, TryCatch #3 {Exception -> 0x0262, blocks: (B:78:0x01ff, B:80:0x0205, B:82:0x0209, B:83:0x020c, B:85:0x0234, B:86:0x023c, B:88:0x0240, B:89:0x0243, B:91:0x0247, B:92:0x024c), top: B:112:0x01ff }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0234 A[Catch: Exception -> 0x0262, TryCatch #3 {Exception -> 0x0262, blocks: (B:78:0x01ff, B:80:0x0205, B:82:0x0209, B:83:0x020c, B:85:0x0234, B:86:0x023c, B:88:0x0240, B:89:0x0243, B:91:0x0247, B:92:0x024c), top: B:112:0x01ff }] */
    /* JADX WARN: Code duplicated, block: B:88:0x0240 A[Catch: Exception -> 0x0262, TryCatch #3 {Exception -> 0x0262, blocks: (B:78:0x01ff, B:80:0x0205, B:82:0x0209, B:83:0x020c, B:85:0x0234, B:86:0x023c, B:88:0x0240, B:89:0x0243, B:91:0x0247, B:92:0x024c), top: B:112:0x01ff }] */
    /* JADX WARN: Code duplicated, block: B:91:0x0247 A[Catch: Exception -> 0x0262, TryCatch #3 {Exception -> 0x0262, blocks: (B:78:0x01ff, B:80:0x0205, B:82:0x0209, B:83:0x020c, B:85:0x0234, B:86:0x023c, B:88:0x0240, B:89:0x0243, B:91:0x0247, B:92:0x024c), top: B:112:0x01ff }] */
    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        Z5 z5;
        Da listener;
        Ba ba;
        AdConfig adConfig;
        Unit unit;
        Da da;
        AdConfig adConfig2;
        String str;
        String str2;
        Da da2;
        Z5 z6;
        Ba ba2;
        Ba ba3;
        Ba ba4;
        Ba ba5;
        Ba ba6;
        Ba ba7;
        C3622x4 c3622x4;
        Z5 z7;
        Object obj;
        super.onCreate(bundle);
        L4 l4 = this.h;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("InMobiAdActivity", "TAG");
            ((M4) l4).a("InMobiAdActivity", "onCreate called");
        }
        if (!C3517pb.q()) {
            finish();
            L4 l5 = this.h;
            if (l5 != null) {
                Intrinsics.checkNotNullExpressionValue("InMobiAdActivity", "TAG");
                ((M4) l5).b("InMobiAdActivity", "session not found. close");
            }
            AbstractC3498o6.a((byte) 2, "InMobi", "Session not found, AdActivity will be closed");
            return;
        }
        this.f = false;
        if (Build.VERSION.SDK_INT >= 29) {
            AbstractC3565t3.b(this);
        }
        this.d = getIntent().getIntExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 102);
        this.f3023a = new C3622x4(this);
        String key = getIntent().getStringExtra("loggerCacheKey");
        if (key != null) {
            HashMap map = AbstractC3636y4.f3484a;
            Intrinsics.checkNotNullParameter(key, "key");
            try {
                WeakReference weakReference = (WeakReference) AbstractC3636y4.f3484a.get(key);
                obj = weakReference != null ? weakReference.get() : null;
                if (obj == null) {
                    obj = null;
                }
            } catch (ClassCastException unused) {
            }
            this.h = (L4) obj;
        }
        int i = this.d;
        if (i != 100) {
            if (i != 102) {
                return;
            }
            C3594v4 orientationListener = new C3594v4(this);
            L4 logger = this.h;
            if (logger != null) {
                Intrinsics.checkNotNullParameter(logger, "logger");
                orientationListener.h = logger;
            }
            C3622x4 c3622x5 = this.f3023a;
            if (c3622x5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("orientationHandler");
                c3622x5 = null;
            }
            c3622x5.getClass();
            Intrinsics.checkNotNullParameter(orientationListener, "orientationListener");
            c3622x5.b.add(orientationListener);
            c3622x5.a();
            this.b = orientationListener;
            Intent intent = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
            orientationListener.a(intent, k);
            return;
        }
        String stringExtra = getIntent().getStringExtra("com.inmobi.ads.rendering.InMobiAdActivity.IN_APP_BROWSER_URL");
        long longExtra = getIntent().getLongExtra("placementId", Long.MIN_VALUE);
        long longExtra2 = getIntent().getLongExtra("viewTouchTimestamp", -1L);
        boolean booleanExtra = getIntent().getBooleanExtra("allowAutoRedirection", false);
        String stringExtra2 = getIntent().getStringExtra("impressionId");
        String stringExtra3 = getIntent().getStringExtra("creativeId");
        boolean booleanExtra2 = getIntent().getBooleanExtra("supportLockScreen", false);
        try {
            try {
                try {
                    if (Build.VERSION.SDK_INT < 33) {
                        Parcelable parcelableExtra = getIntent().getParcelableExtra("lpTelemetryControlInfo");
                        if (parcelableExtra instanceof Z5) {
                            z7 = (Z5) parcelableExtra;
                        } else {
                            z5 = null;
                        }
                        if (booleanExtra2) {
                            Intrinsics.checkNotNullExpressionValue("InMobiAdActivity", "TAG");
                            getWindow().requestFeature(1);
                            if (C3435k3.f3355a.w()) {
                                setShowWhenLocked(true);
                            } else {
                                getWindow().addFlags(524288);
                            }
                        }
                        listener = Ba.N0;
                        ba = l;
                        if (ba != null) {
                            listener = ba.getListener();
                            adConfig = ba.getAdConfig();
                            unit = Unit.INSTANCE;
                        } else {
                            adConfig = null;
                            unit = null;
                        }
                        if (unit == null) {
                            HashMap map2 = AbstractC3351e3.f3298a;
                            Config configA = AbstractC3351e3.a(C3517pb.b(), "ads");
                            Intrinsics.checkNotNull(configA, "null cannot be cast to non-null type com.inmobi.commons.core.configs.AdConfig");
                            adConfig = (AdConfig) configA;
                            da = m;
                            if (da != null) {
                                Intrinsics.checkNotNull(da);
                            } else {
                                da = listener;
                            }
                        } else {
                            da = listener;
                        }
                        adConfig2 = adConfig;
                        da2 = da;
                        str = "TAG";
                        str2 = "InMobiAdActivity";
                        z6 = z5;
                        Ba ba8 = new Ba(this, (byte) 1, null, stringExtra2, true, null, longExtra2 + 4, null, this.h, 164);
                        this.c = ba8;
                        ba8.setPlacementId(longExtra);
                        ba2 = this.c;
                        if (ba2 == null) {
                            ba2.setCreativeId(stringExtra3);
                        }
                        ba3 = this.c;
                        if (ba3 == null) {
                            ba3.setAllowAutoRedirection(booleanExtra);
                        }
                        ba4 = this.c;
                        if (ba4 != null) {
                            if (adConfig2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adConfig");
                                adConfig2 = null;
                            }
                            da = da2;
                            try {
                                ba4.a(da, adConfig2);
                            } catch (Exception e) {
                                e = e;
                                L4 l6 = this.h;
                                if (l6 != null) {
                                    String str3 = str2;
                                    Intrinsics.checkNotNullExpressionValue(str3, str);
                                    ((M4) l6).a(str3, "Exception while initializing In-App browser", e);
                                }
                                C3339d5 c3339d5 = C3339d5.f3292a;
                                C3339d5.c.a(I4.a(e, "event"));
                                da.c();
                                finish();
                                return;
                            }
                        } else {
                            da = da2;
                        }
                        ba5 = this.c;
                        if (ba5 != null) {
                            ba5.setLandingPageTelemetryControlInfoOnWebViewClient(z6);
                        }
                        RelativeLayout relativeLayout = new RelativeLayout(this);
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                        layoutParams.addRule(10);
                        layoutParams.addRule(2, 65533);
                        relativeLayout.setBackgroundColor(-1);
                        relativeLayout.addView(this.c, layoutParams);
                        a(relativeLayout);
                        setContentView(relativeLayout);
                        ba6 = this.c;
                        if (ba6 != null) {
                            Intrinsics.checkNotNull(stringExtra);
                            ba6.loadUrl(stringExtra);
                        }
                        ba7 = this.c;
                        if (ba7 != null) {
                            ba7.setFullScreenActivityContext(this);
                        }
                        c3622x4 = this.f3023a;
                        if (c3622x4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("orientationHandler");
                            c3622x4 = null;
                        }
                        Ba orientationListener2 = this.c;
                        Intrinsics.checkNotNull(orientationListener2);
                        c3622x4.getClass();
                        Intrinsics.checkNotNullParameter(orientationListener2, "orientationListener");
                        c3622x4.b.add(orientationListener2);
                        c3622x4.a();
                        return;
                    }
                    z7 = (Z5) getIntent().getParcelableExtra("lpTelemetryControlInfo", Z5.class);
                    z5 = z7;
                } catch (Exception unused2) {
                }
                Ba ba9 = new Ba(this, (byte) 1, null, stringExtra2, true, null, longExtra2 + 4, null, this.h, 164);
                this.c = ba9;
                ba9.setPlacementId(longExtra);
                ba2 = this.c;
                if (ba2 == null) {
                    ba2.setCreativeId(stringExtra3);
                }
                ba3 = this.c;
                if (ba3 == null) {
                    ba3.setAllowAutoRedirection(booleanExtra);
                }
                ba4 = this.c;
                if (ba4 != null) {
                    if (adConfig2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adConfig");
                        adConfig2 = null;
                    }
                    da = da2;
                    ba4.a(da, adConfig2);
                } else {
                    da = da2;
                }
                ba5 = this.c;
                if (ba5 != null) {
                    ba5.setLandingPageTelemetryControlInfoOnWebViewClient(z6);
                }
                RelativeLayout relativeLayout2 = new RelativeLayout(this);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams2.addRule(10);
                layoutParams2.addRule(2, 65533);
                relativeLayout2.setBackgroundColor(-1);
                relativeLayout2.addView(this.c, layoutParams2);
                a(relativeLayout2);
                setContentView(relativeLayout2);
                ba6 = this.c;
                if (ba6 != null) {
                    Intrinsics.checkNotNull(stringExtra);
                    ba6.loadUrl(stringExtra);
                }
                ba7 = this.c;
                if (ba7 != null) {
                    ba7.setFullScreenActivityContext(this);
                }
                c3622x4 = this.f3023a;
                if (c3622x4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("orientationHandler");
                    c3622x4 = null;
                }
                Ba orientationListener3 = this.c;
                Intrinsics.checkNotNull(orientationListener3);
                c3622x4.getClass();
                Intrinsics.checkNotNullParameter(orientationListener3, "orientationListener");
                c3622x4.b.add(orientationListener3);
                c3622x4.a();
                return;
            } catch (Exception e2) {
                e = e2;
                da = da2;
            }
            da2 = da;
            str = "TAG";
            str2 = "InMobiAdActivity";
            z6 = z5;
        } catch (Exception e3) {
            e = e3;
            str = "TAG";
            str2 = "InMobiAdActivity";
        }
        if (booleanExtra2) {
            Intrinsics.checkNotNullExpressionValue("InMobiAdActivity", "TAG");
            getWindow().requestFeature(1);
            if (C3435k3.f3355a.w()) {
                setShowWhenLocked(true);
            } else {
                getWindow().addFlags(524288);
            }
        }
        listener = Ba.N0;
        ba = l;
        if (ba != null) {
            listener = ba.getListener();
            adConfig = ba.getAdConfig();
            unit = Unit.INSTANCE;
        } else {
            adConfig = null;
            unit = null;
        }
        if (unit == null) {
            HashMap map3 = AbstractC3351e3.f3298a;
            Config configA2 = AbstractC3351e3.a(C3517pb.b(), "ads");
            Intrinsics.checkNotNull(configA2, "null cannot be cast to non-null type com.inmobi.commons.core.configs.AdConfig");
            adConfig = (AdConfig) configA2;
            da = m;
            if (da != null) {
                Intrinsics.checkNotNull(da);
            } else {
                da = listener;
            }
        } else {
            da = listener;
        }
        adConfig2 = adConfig;
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        Ba ba;
        A3 a3;
        InterfaceC3519q fullScreenEventsListener;
        L4 l4 = this.h;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("InMobiAdActivity", "TAG");
            ((M4) l4).c("InMobiAdActivity", "onDestroy");
        }
        if (this.e) {
            int i = this.d;
            if (100 == i) {
                Ba ba2 = this.c;
                if (ba2 != null && (fullScreenEventsListener = ba2.getFullScreenEventsListener()) != null) {
                    try {
                        fullScreenEventsListener.b(this.c);
                        Ba ba3 = this.c;
                        Intrinsics.checkNotNull(ba3);
                        ba3.b();
                        C3622x4 c3622x4 = this.f3023a;
                        if (c3622x4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("orientationHandler");
                            c3622x4 = null;
                        }
                        Ba orientationListener = this.c;
                        Intrinsics.checkNotNull(orientationListener);
                        c3622x4.getClass();
                        Intrinsics.checkNotNullParameter(orientationListener, "orientationListener");
                        c3622x4.b.remove(orientationListener);
                        c3622x4.a();
                        this.c = null;
                    } catch (Exception unused) {
                    }
                }
            } else if (102 == i) {
                C3594v4 orientationListener2 = this.b;
                if (orientationListener2 != null) {
                    C3622x4 c3622x5 = this.f3023a;
                    if (c3622x5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("orientationHandler");
                        c3622x5 = null;
                    }
                    c3622x5.getClass();
                    Intrinsics.checkNotNullParameter(orientationListener2, "orientationListener");
                    c3622x5.b.remove(orientationListener2);
                    c3622x5.a();
                    B b = orientationListener2.c;
                    if (b != null) {
                        b.b();
                    }
                    RelativeLayout relativeLayout = orientationListener2.d;
                    if (relativeLayout != null) {
                        relativeLayout.removeAllViews();
                    }
                    C3607w3 c3607w3 = orientationListener2.e;
                    if (c3607w3 != null) {
                        E3 e3 = c3607w3.c;
                        if (e3 != null) {
                            e3.destroy();
                        }
                        c3607w3.c = null;
                        c3607w3.d = null;
                        c3607w3.e = null;
                        Ad ad = c3607w3.g;
                        if (ad != null) {
                            ad.a();
                        }
                        c3607w3.removeAllViews();
                    }
                    orientationListener2.f3454a.clear();
                    orientationListener2.b = null;
                    orientationListener2.c = null;
                    orientationListener2.d = null;
                    orientationListener2.e = null;
                }
                this.b = null;
            }
        } else {
            int i2 = this.d;
            if (100 != i2 && 102 == i2) {
                C3594v4 orientationListener3 = this.b;
                if (orientationListener3 != null) {
                    C3622x4 c3622x6 = this.f3023a;
                    if (c3622x6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("orientationHandler");
                        c3622x6 = null;
                    }
                    c3622x6.getClass();
                    Intrinsics.checkNotNullParameter(orientationListener3, "orientationListener");
                    c3622x6.b.remove(orientationListener3);
                    c3622x6.a();
                    B b2 = orientationListener3.c;
                    if (b2 != null) {
                        b2.b();
                    }
                    RelativeLayout relativeLayout2 = orientationListener3.d;
                    if (relativeLayout2 != null) {
                        relativeLayout2.removeAllViews();
                    }
                    C3607w3 c3607w4 = orientationListener3.e;
                    if (c3607w4 != null) {
                        E3 e4 = c3607w4.c;
                        if (e4 != null) {
                            e4.destroy();
                        }
                        c3607w4.c = null;
                        c3607w4.d = null;
                        c3607w4.e = null;
                        Ad ad2 = c3607w4.g;
                        if (ad2 != null) {
                            ad2.a();
                        }
                        c3607w4.removeAllViews();
                    }
                    orientationListener3.f3454a.clear();
                    orientationListener3.b = null;
                    orientationListener3.c = null;
                    orientationListener3.d = null;
                    orientationListener3.e = null;
                }
                this.b = null;
            }
            if (100 == this.d && (ba = this.c) != null && (a3 = ba.q0) != null) {
                A3.a(a3, 9, true, null, 12);
            }
        }
        Ad ad3 = this.i;
        if (ad3 != null) {
            ad3.a();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public final void onMultiWindowModeChanged(boolean z) {
        C3594v4 c3594v4;
        C3622x4 c3622x4;
        L4 l4 = this.h;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("InMobiAdActivity", "TAG");
            ((M4) l4).c("InMobiAdActivity", "multiWindow mode - " + z);
        }
        super.onMultiWindowModeChanged(z);
        if (z || (c3594v4 = this.b) == null) {
            return;
        }
        r rVar = c3594v4.b;
        C3622x4 c3622x5 = null;
        C3529q9 orientationProperties = (rVar == null || !(rVar instanceof Ba)) ? null : ((Ba) rVar).getOrientationProperties();
        if (orientationProperties == null || (c3622x4 = this.f3023a) == null) {
            return;
        }
        if (c3622x4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orientationHandler");
        } else {
            c3622x5 = c3622x4;
        }
        c3622x5.a(orientationProperties);
    }

    @Override // android.app.Activity
    public final void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        L4 l4 = this.h;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("InMobiAdActivity", "TAG");
            ((M4) l4).c("InMobiAdActivity", "onNewIntent");
        }
        super.onNewIntent(intent);
        this.f = false;
        this.c = null;
        setIntent(intent);
        C3594v4 c3594v4 = this.b;
        if (c3594v4 != null) {
            SparseArray adContainers = k;
            Intrinsics.checkNotNullParameter(intent, "intent");
            Intrinsics.checkNotNullParameter(adContainers, "adContainers");
            c3594v4.a(intent, adContainers);
            B b = c3594v4.c;
            if (b != null) {
                b.g();
            }
        }
    }

    @Override // android.app.Activity
    public final void onResume() {
        C3594v4 c3594v4;
        B b;
        InterfaceC3519q fullScreenEventsListener;
        L4 l4 = this.h;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("InMobiAdActivity", "TAG");
            ((M4) l4).c("InMobiAdActivity", b9.h.u0);
        }
        super.onResume();
        if (this.e) {
            return;
        }
        int i = this.d;
        if (100 != i) {
            if (102 != i || (c3594v4 = this.b) == null || (b = c3594v4.c) == null) {
                return;
            }
            b.c();
            return;
        }
        Ba ba = this.c;
        if (ba == null || (fullScreenEventsListener = ba.getFullScreenEventsListener()) == null) {
            return;
        }
        try {
            if (this.f) {
                return;
            }
            this.f = true;
            fullScreenEventsListener.a(this.c);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    public final void onStart() {
        C3594v4 c3594v4;
        Window window;
        L4 l4 = this.h;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("InMobiAdActivity", "TAG");
            ((M4) l4).c("InMobiAdActivity", "onStart");
        }
        super.onStart();
        C3435k3 c3435k3 = C3435k3.f3355a;
        if (c3435k3.B()) {
            if (this.j == null) {
                this.j = new OnBackInvokedCallback() { // from class: com.inmobi.ads.rendering.InMobiAdActivity$$ExternalSyntheticLambda4
                    @Override // android.window.OnBackInvokedCallback
                    public final void onBackInvoked() {
                        InMobiAdActivity.a(this.f$0);
                    }
                };
            }
            OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            OnBackInvokedCallback onBackInvokedCallback = this.j;
            if (onBackInvokedCallback == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backInvokedCallback");
                onBackInvokedCallback = null;
            }
            onBackInvokedDispatcher.registerOnBackInvokedCallback(0, onBackInvokedCallback);
        }
        if (this.e || 102 != this.d || (c3594v4 = this.b) == null) {
            return;
        }
        B b = c3594v4.c;
        if (b != null) {
            b.g();
        }
        r rVar = c3594v4.b;
        if (rVar != null) {
            if ((rVar instanceof Ba ? ((Ba) rVar).G0 : false) && !c3435k3.z() && c3435k3.F()) {
                Object obj = c3594v4.f3454a.get();
                InMobiAdActivity inMobiAdActivity = obj instanceof InMobiAdActivity ? (InMobiAdActivity) obj : null;
                if (inMobiAdActivity == null || (window = inMobiAdActivity.getWindow()) == null) {
                    return;
                }
                window.getDecorView().setSystemUiVisibility(5638);
            }
        }
    }

    @Override // android.app.Activity
    public final void onStop() {
        C3594v4 c3594v4;
        B b;
        L4 l4 = this.h;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("InMobiAdActivity", "TAG");
            ((M4) l4).c("InMobiAdActivity", "onStop");
        }
        super.onStop();
        if (C3435k3.f3355a.B() && this.j != null) {
            OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            OnBackInvokedCallback onBackInvokedCallback = this.j;
            if (onBackInvokedCallback == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backInvokedCallback");
                onBackInvokedCallback = null;
            }
            onBackInvokedDispatcher.unregisterOnBackInvokedCallback(onBackInvokedCallback);
        }
        if (this.e || (c3594v4 = this.b) == null || (b = c3594v4.c) == null) {
            return;
        }
        b.d();
    }

    public final void a(RelativeLayout relativeLayout) {
        float f = AbstractC3565t3.d().c;
        LinearLayout linearLayout = new LinearLayout(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) (48 * f));
        linearLayout.setOrientation(0);
        linearLayout.setId(65533);
        linearLayout.setWeightSum(100.0f);
        linearLayout.setBackgroundResource(R.drawable.bottom_bar);
        linearLayout.setBackgroundColor(-7829368);
        relativeLayout.setBackgroundColor(-7829368);
        layoutParams.addRule(12);
        if (AbstractC3420j2.a(this)) {
            Ad ad = this.i;
            if (ad != null) {
                ad.a();
            }
            this.i = new Ad(this, new C3650z4(this, layoutParams), this.h);
        }
        relativeLayout.addView(linearLayout, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.weight = 25.0f;
        Z2 z2 = new Z2(this, (byte) 2, this.h);
        z2.setOnTouchListener(new View.OnTouchListener() { // from class: com.inmobi.ads.rendering.InMobiAdActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return InMobiAdActivity.a(this.f$0, view, motionEvent);
            }
        });
        linearLayout.addView(z2, layoutParams2);
        Z2 z3 = new Z2(this, (byte) 3, this.h);
        z3.setOnTouchListener(new View.OnTouchListener() { // from class: com.inmobi.ads.rendering.InMobiAdActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return InMobiAdActivity.b(this.f$0, view, motionEvent);
            }
        });
        linearLayout.addView(z3, layoutParams2);
        Z2 z4 = new Z2(this, (byte) 4, this.h);
        z4.setOnTouchListener(new View.OnTouchListener() { // from class: com.inmobi.ads.rendering.InMobiAdActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return InMobiAdActivity.c(this.f$0, view, motionEvent);
            }
        });
        linearLayout.addView(z4, layoutParams2);
        Z2 z5 = new Z2(this, (byte) 6, this.h);
        z5.setOnTouchListener(new View.OnTouchListener() { // from class: com.inmobi.ads.rendering.InMobiAdActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return InMobiAdActivity.d(this.f$0, view, motionEvent);
            }
        });
        linearLayout.addView(z5, layoutParams2);
    }

    @Override // android.app.Activity
    public final void onMultiWindowModeChanged(boolean z, Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onMultiWindowModeChanged(z, newConfig);
        onMultiWindowModeChanged(z);
    }

    public static final boolean a(InMobiAdActivity this$0, View view, MotionEvent motionEvent) {
        A3 a3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent.getAction() == 1) {
            view.setBackgroundColor(-7829368);
            Ba ba = this$0.c;
            if (ba != null && (a3 = ba.q0) != null) {
                A3.a(a3, 5, true, null, 12);
            }
            this$0.e = true;
            this$0.finish();
            return true;
        }
        if (motionEvent.getAction() == 0) {
            view.setBackgroundColor(-16711681);
        }
        return true;
    }

    public final void a() {
        A3 a3;
        B b;
        L4 l4 = this.h;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("InMobiAdActivity", "TAG");
            ((M4) l4).c("InMobiAdActivity", "onBackPressed");
        }
        int i = this.d;
        if (i == 102) {
            L4 l5 = this.h;
            if (l5 != null) {
                Intrinsics.checkNotNullExpressionValue("InMobiAdActivity", "TAG");
                ((M4) l5).c("InMobiAdActivity", "back pressed on ad");
            }
            C3594v4 c3594v4 = this.b;
            if (c3594v4 == null || (b = c3594v4.c) == null) {
                return;
            }
            b.a();
            return;
        }
        if (i == 100) {
            L4 l6 = this.h;
            if (l6 != null) {
                Intrinsics.checkNotNullExpressionValue("InMobiAdActivity", "TAG");
                ((M4) l6).c("InMobiAdActivity", "back pressed in browser");
            }
            Ba ba = this.c;
            if (ba != null && (a3 = ba.q0) != null) {
                A3.a(a3, 7, true, null, 12);
            }
            this.e = true;
            finish();
        }
    }
}
