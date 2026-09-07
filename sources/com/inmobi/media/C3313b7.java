package com.inmobi.media;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.browser.customtabs.CustomTabsClient;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.facebook.share.internal.ShareConstants;
import com.inmobi.ads.rendering.InMobiAdActivity;
import com.inmobi.commons.core.configs.AdConfig;
import com.inmobi.commons.core.configs.TelemetryConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: renamed from: com.inmobi.media.b7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public class C3313b7 implements r, Application.ActivityLifecycleCallbacks {
    public boolean A;
    public int B;
    public C3313b7 C;
    public boolean D;
    public C3455l7 E;
    public String F;
    public Intent G;
    public Ba H;
    public Ba I;
    public C3313b7 J;
    public byte K;
    public C3298a7 L;
    public final C3575u M;
    public final X6 N;
    public final T6 O;
    public final Y6 P;
    public final S6 Q;
    public LinkedHashMap R;
    public final String S;
    public final W6 T;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f3274a;
    public final C3625x7 b;
    public final String c;
    public final Set d;
    public final long e;
    public final boolean f;
    public final String g;
    public final J2 h;
    public final C3297a6 i;
    public final L4 j;
    public final Lazy k;
    public final Z6 l;
    public final String m;
    public final HashSet n;
    public final ArrayList o;
    public Sc p;
    public L7 q;
    public boolean r;
    public final AdConfig s;
    public boolean t;
    public boolean u;
    public C3313b7 v;
    public A0 w;
    public WeakReference x;
    public int y;
    public WeakReference z;

    public C3313b7(Context context, byte b, C3625x7 mNativeDataModel, String impressionId, Set set, AdConfig adConfig, long j, boolean z, String creativeId, J2 j2, C3297a6 c3297a6, L4 l4) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mNativeDataModel, "mNativeDataModel");
        Intrinsics.checkNotNullParameter(impressionId, "impressionId");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        Intrinsics.checkNotNullParameter(creativeId, "creativeId");
        this.f3274a = b;
        this.b = mNativeDataModel;
        this.c = impressionId;
        this.d = set;
        this.e = j;
        this.f = z;
        this.g = creativeId;
        this.h = j2;
        this.i = c3297a6;
        this.j = l4;
        this.k = LazyKt.lazy(V6.f3219a);
        this.l = new Z6(this);
        this.m = "b7";
        this.n = new HashSet();
        this.o = new ArrayList();
        this.s = adConfig;
        this.v = this;
        this.x = new WeakReference(null);
        this.y = -1;
        this.N = new X6(this);
        this.O = new T6(this);
        this.P = new Y6(this);
        this.Q = new S6(this);
        this.x = new WeakReference(context);
        C3517pb.a(context, this);
        C3513p7 c3513p7 = mNativeDataModel.e;
        if (c3513p7 != null) {
            c3513p7.y = System.currentTimeMillis();
        }
        this.K = (byte) -1;
        this.M = C3575u.f3438a;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.inmobi.media.b7$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                C3313b7.a(this.f$0);
            }
        });
        this.S = "native";
        this.T = new W6(this);
    }

    public final C3455l7 a(C3625x7 c3625x7, C3455l7 asset) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        if (c3625x7 == null) {
            return null;
        }
        String str = asset.h;
        if (str.length() == 0) {
            asset.k = (byte) 0;
            return asset;
        }
        String[] strArr = (String[]) new Regex("\\|").split(str, 0).toArray(new String[0]);
        if (strArr.length == 1) {
            asset.k = a(strArr[0]);
            return asset;
        }
        C3455l7 c3455l7M = c3625x7.m(strArr[0]);
        if (c3455l7M == null) {
            return a(c3625x7.g, asset);
        }
        if (Intrinsics.areEqual(c3455l7M, asset)) {
            return null;
        }
        c3455l7M.k = a(strArr[1]);
        L4 l4 = this.j;
        if (l4 != null) {
            String str2 = this.m;
            ((M4) l4).a(str2, O5.a(str2, "TAG", "Referenced asset (").append(c3455l7M.b).append(')').toString());
        }
        return c3455l7M;
    }

    public final C3455l7 b(C3625x7 c3625x7, C3455l7 c3455l7) {
        L4 l4;
        if (c3625x7 == null) {
            return null;
        }
        String str = c3455l7.p;
        String str2 = c3455l7.q;
        C3455l7 c3455l7A = a(c3455l7, c3625x7, str);
        if (c3455l7A == null) {
            c3455l7A = a(c3455l7, c3625x7, str2);
        }
        if (c3455l7A != null && (l4 = this.j) != null) {
            String str3 = this.m;
            ((M4) l4).a(str3, O5.a(str3, "TAG", "Referenced asset (").append(c3455l7A.b).append(')').toString());
        }
        return c3455l7A;
    }

    @Override // com.inmobi.media.r
    public final boolean c() {
        return this.t;
    }

    public final Context d() {
        Activity activityF = f();
        return activityF != null ? activityF : (Context) this.x.get();
    }

    @Override // com.inmobi.media.r
    public final void e() {
    }

    public final Activity f() {
        WeakReference weakReference = this.z;
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }

    public final View g() {
        Sc sc = this.p;
        if (sc != null) {
            return sc.b();
        }
        return null;
    }

    @Override // com.inmobi.media.r
    public final AdConfig getAdConfig() {
        return this.s;
    }

    @Override // com.inmobi.media.r
    public final String getAdType() {
        return this.S;
    }

    @Override // com.inmobi.media.r
    public String getCreativeId() {
        return this.g;
    }

    @Override // com.inmobi.media.r
    public final Object getDataModel() {
        return this.b;
    }

    @Override // com.inmobi.media.r
    public InterfaceC3519q getFullScreenEventsListener() {
        return this.N;
    }

    @Override // com.inmobi.media.r
    public String getImpressionId() {
        return this.c;
    }

    @Override // com.inmobi.media.r
    public final String getMarkupType() {
        return "inmobiJson";
    }

    @Override // com.inmobi.media.r
    public final byte getPlacementType() {
        return this.f3274a;
    }

    @Override // com.inmobi.media.r
    public View getVideoContainerView() {
        return null;
    }

    @Override // com.inmobi.media.r
    public Tc getViewableAd() {
        Context contextJ = j();
        if (this.p == null && contextJ != null) {
            L4 l4 = this.j;
            if (l4 != null) {
                String TAG = this.m;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((M4) l4).c(TAG, "fireLoadedAndServedBeacons");
            }
            C3513p7 c3513p7 = this.b.e;
            if (c3513p7 != null) {
                HashMap mapA = a(c3513p7);
                a((byte) 1, mapA);
                a((byte) 2, mapA);
            }
            this.p = new X4(contextJ, this, new Vc(this, this.H, this.j), this.j);
            Set<C3504oc> set = this.d;
            if (set != null) {
                for (C3504oc c3504oc : set) {
                    try {
                        if (c3504oc.f3393a == 3) {
                            L4 l5 = this.j;
                            if (l5 != null) {
                                String TAG2 = this.m;
                                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                                ((M4) l5).a(TAG2, "OMID tracker");
                            }
                            Object obj = c3504oc.b.get("omidAdSession");
                            C3371f9 c3371f9 = obj instanceof C3371f9 ? (C3371f9) obj : null;
                            Sc sc = this.p;
                            if (c3371f9 == null || sc == null) {
                                L4 l6 = this.j;
                                if (l6 != null) {
                                    String TAG3 = this.m;
                                    Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                                    ((M4) l6).b(TAG3, "Did not find a OMID ad session; the OMID decorator will not be applied.");
                                }
                            } else {
                                this.p = this.K == 0 ? new C3427j9(this, sc, c3371f9, this.j) : new C3441k9(this, sc, c3371f9, this.j);
                            }
                        }
                    } catch (Exception e) {
                        L4 l7 = this.j;
                        if (l7 != null) {
                            String str = this.m;
                            ((M4) l7).b(str, ld.a(e, O5.a(str, "TAG", "Exception occurred while creating the Display viewable ad : ")));
                        }
                        C3339d5 c3339d5 = C3339d5.f3292a;
                        C3339d5.c.a(I4.a(e, "event"));
                    }
                }
            }
        }
        return this.p;
    }

    public final L7 h() {
        Sc sc = this.p;
        F7 f7C = sc != null ? sc.c() : null;
        F7 f7 = f7C instanceof F7 ? f7C : null;
        if (f7 != null) {
            this.q = f7.e;
        }
        return this.q;
    }

    public Yc i() {
        return this.T;
    }

    public final Context j() {
        return (1 == this.f3274a || k()) ? f() : (Context) this.x.get();
    }

    public boolean k() {
        return this.f3274a == 0 && f() != null;
    }

    public void l() {
        Sc sc;
        L0 l0;
        L4 l4 = this.j;
        if (l4 != null) {
            String TAG = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, com.ironsource.b9.h.t0);
        }
        this.u = true;
        C3314b8 c3314b8A = a(g());
        if (c3314b8A != null) {
            c3314b8A.b();
        }
        L7 l7H = h();
        if (l7H != null && (l0 = l7H.l) != null) {
            l0.a();
        }
        Context contextD = d();
        if (contextD == null || (sc = this.p) == null) {
            return;
        }
        sc.a(contextD, (byte) 1);
    }

    public final void m() {
        L4 l4 = this.j;
        if (l4 != null) {
            String TAG = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "reportFirstPageRendered");
        }
        C3513p7 c3513p7B = this.b.b(0);
        if (this.n.contains(0) || c3513p7B == null || this.t) {
            return;
        }
        this.n.add(0);
        c3513p7B.y = System.currentTimeMillis();
        if (!this.r) {
            this.o.add(c3513p7B);
            return;
        }
        HashMap mapA = a(c3513p7B);
        L4 l5 = this.j;
        if (l5 != null) {
            String TAG2 = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((M4) l5).a(TAG2, "Page-view impression record request");
        }
        c3513p7B.a("page_view", mapA, (T6) null, this.j);
    }

    public boolean n() {
        return false;
    }

    public final void o() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.inmobi.media.b7$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C3313b7.d(this.f$0);
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        L4 l4 = this.j;
        if (l4 != null) {
            String TAG = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "onActivityDestroyed");
        }
        Sc sc = this.p;
        if (sc != null) {
            sc.a(activity, (byte) 2);
        }
        J2 j2 = this.h;
        if (j2 != null) {
            j2.b();
        }
        Context context = (Context) this.x.get();
        if (context instanceof Activity) {
            ((Activity) context).getApplication().unregisterActivityLifecycleCallbacks(this);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        Sc sc;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (Intrinsics.areEqual(d(), activity)) {
            L4 l4 = this.j;
            if (l4 != null) {
                String TAG = this.m;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((M4) l4).c(TAG, com.ironsource.b9.h.u0);
            }
            this.u = false;
            C3314b8 c3314b8A = a(g());
            if (c3314b8A != null) {
                c3314b8A.c();
            }
            p();
            Context contextD = d();
            if (contextD == null || (sc = this.p) == null) {
                return;
            }
            sc.a(contextD, (byte) 0);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (Intrinsics.areEqual(d(), activity)) {
            l();
        }
    }

    public final void p() {
        L0 l0;
        L7 l7H = h();
        if (l7H == null || (l0 = l7H.l) == null || l0.c) {
            return;
        }
        l0.c = true;
        l0.a(l0.b);
    }

    public final void q() {
        A0 a0;
        L4 l4 = this.j;
        if (l4 != null) {
            String TAG = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "unlockRewards");
        }
        if (n()) {
            this.A = true;
            HashMap rewards = this.b.h;
            if (rewards == null || (a0 = this.w) == null) {
                return;
            }
            Intrinsics.checkNotNullParameter(rewards, "rewards");
            L4 l5 = a0.f3025a.j;
            if (l5 != null) {
                String strE = C0.e();
                Intrinsics.checkNotNullExpressionValue(strE, "<get-TAG>(...)");
                ((M4) l5).a(strE, "onAdRewardsUnlocked");
            }
            if (a0.f3025a.Z()) {
                return;
            }
            AbstractC3520q0 abstractC3520q0 = (AbstractC3520q0) a0.b.get();
            if (abstractC3520q0 != null) {
                abstractC3520q0.b(new HashMap(rewards));
                return;
            }
            L4 l6 = a0.f3025a.j;
            if (l6 != null) {
                ((M4) l6).b("InMobi", "Listener was garbage collected.Unable to give callback");
            }
        }
    }

    @Override // com.inmobi.media.r
    public final void setFullScreenActivityContext(Activity activity) {
        this.z = new WeakReference(activity);
    }

    public static final void d(C3313b7 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.A = true;
        this$0.b((C3455l7) null);
    }

    public void c(C3455l7 asset) {
        C3314b8 c3314b8A;
        ValueAnimator valueAnimator;
        Intrinsics.checkNotNullParameter(asset, "asset");
        L4 l4 = this.j;
        if (l4 != null) {
            String TAG = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "triggerAssetAction");
        }
        byte b = asset.k;
        if (b == 0 || b == 5) {
            return;
        }
        if (b == 2) {
            this.A = true;
            Ba ba = this.H;
            if (ba != null && ba != null) {
                L4 l5 = ba.i;
                if (l5 != null) {
                    String TAG2 = Ba.O0;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    ((M4) l5).a(TAG2, "skipToInterActive");
                }
                ba.b("window.imraid.broadcastEvent('skip');");
            }
            C3314b8 c3314b8A2 = a(g());
            if (c3314b8A2 != null) {
                c3314b8A2.b();
            }
            b(asset);
            J2 j2 = this.h;
            if (j2 == null || j2.g.get()) {
                return;
            }
            j2.d.h = 1;
            Intrinsics.checkNotNull(j2.c);
            return;
        }
        if (b == 3) {
            try {
                Ba ba2 = this.H;
                if (ba2 != null) {
                    L4 l6 = ba2.i;
                    if (l6 != null) {
                        String TAG3 = Ba.O0;
                        Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                        ((M4) l6).a(TAG3, "replayToInterActive");
                    }
                    ba2.b("window.imraid.broadcastEvent('replay');");
                }
                View viewG = g();
                if (viewG != null) {
                    ViewParent parent = viewG.getParent();
                    ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                    if (viewGroup != null) {
                        viewGroup.removeView(viewG);
                    }
                }
                C3313b7 c3313b7 = this.v;
                C3313b7 c3313b8 = c3313b7 instanceof C3313b7 ? c3313b7 : null;
                if (c3313b8 != null && (c3314b8A = a(c3313b8.g())) != null && (valueAnimator = c3314b8A.n) != null && valueAnimator.isRunning()) {
                    valueAnimator.setCurrentPlayTime(c3314b8A.f * ((long) 1000));
                    c3314b8A.l = 360 * 1.0f;
                    c3314b8A.invalidate();
                }
                if (!Intrinsics.areEqual(ShareConstants.VIDEO_URL, asset.c)) {
                    L4 l7 = this.j;
                    if (l7 != null) {
                        String TAG4 = this.m;
                        Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
                        ((M4) l7).b(TAG4, "Action 3 not valid for asset of type: " + asset.c);
                        return;
                    }
                    return;
                }
                if (c3313b7 instanceof C3398h8) {
                    View videoContainerView = ((C3398h8) c3313b7).getVideoContainerView();
                    C3570t8 c3570t8 = videoContainerView instanceof C3570t8 ? (C3570t8) videoContainerView : null;
                    if (c3570t8 != null) {
                        C3556s8 videoView = c3570t8.getVideoView();
                        Object tag = videoView.getTag();
                        C3426j8 c3426j8 = tag instanceof C3426j8 ? (C3426j8) tag : null;
                        if (c3426j8 != null) {
                            if (c3426j8.c()) {
                                videoView.k();
                            } else {
                                videoView.c();
                            }
                        } else if (1 == this.f3274a) {
                            videoView.k();
                        } else {
                            videoView.c();
                        }
                        if (c3426j8 != null) {
                            a(c3426j8);
                        }
                        videoView.start();
                        return;
                    }
                    return;
                }
                return;
            } catch (Exception e) {
                L4 l8 = this.j;
                if (l8 != null) {
                    String str = this.m;
                    ((M4) l8).b(str, ld.a(e, O5.a(str, "TAG", "Encountered unexpected error in handling replay action on video: ")));
                }
                AbstractC3498o6.a((byte) 2, "InMobi", "SDK encountered unexpected error in replaying video");
                C3339d5 c3339d5 = C3339d5.f3292a;
                C3339d5.c.a(I4.a(e, "event"));
                return;
            }
        }
        if (b == 1) {
            try {
                Ba ba3 = this.H;
                if (ba3 != null) {
                    L4 l9 = ba3.i;
                    if (l9 != null) {
                        String TAG5 = Ba.O0;
                        Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
                        ((M4) l9).a(TAG5, "closeToInterActive");
                    }
                    ba3.b("window.imraid.broadcastEvent('close');");
                }
                a();
                return;
            } catch (Exception e2) {
                L4 l10 = this.j;
                if (l10 != null) {
                    String str2 = this.m;
                    ((M4) l10).b(str2, ld.a(e2, O5.a(str2, "TAG", "Encountered unexpected error in handling exit action on video: ")));
                }
                AbstractC3498o6.a((byte) 2, "InMobi", "SDK encountered unexpected error in exiting video");
                C3339d5 c3339d6 = C3339d5.f3292a;
                C3339d5.c.a(I4.a(e2, "event"));
                return;
            }
        }
        if (b != 4) {
            this.A = true;
            Ba ba4 = this.H;
            if (ba4 != null && ba4 != null) {
                L4 l11 = ba4.i;
                if (l11 != null) {
                    String TAG6 = Ba.O0;
                    Intrinsics.checkNotNullExpressionValue(TAG6, "TAG");
                    ((M4) l11).a(TAG6, "skipToInterActive");
                }
                ba4.b("window.imraid.broadcastEvent('skip');");
            }
            C3314b8 c3314b8A3 = a(g());
            if (c3314b8A3 != null) {
                c3314b8A3.b();
            }
            b(asset);
            return;
        }
        try {
            if (this.f3274a == 0) {
                L4 l12 = this.j;
                if (l12 != null) {
                    String TAG7 = this.m;
                    Intrinsics.checkNotNullExpressionValue(TAG7, "TAG");
                    ((M4) l12).c(TAG7, "launchFullscreen");
                }
                C3313b7 c3313b7C = c(this);
                if (c3313b7C == null) {
                    return;
                }
                A0 a0 = c3313b7C.w;
                if (a0 != null) {
                    a0.e();
                }
                C3575u c3575u = this.M;
                int iHashCode = hashCode();
                U6 u6 = new U6(this, c3313b7C);
                c3575u.getClass();
                C3575u.a(iHashCode, u6);
            }
        } catch (Exception e3) {
            L4 l13 = this.j;
            if (l13 != null) {
                String str3 = this.m;
                ((M4) l13).b(str3, ld.a(e3, O5.a(str3, "TAG", "Encountered unexpected error in handling fullscreen action ")));
            }
            AbstractC3498o6.a((byte) 2, "InMobi", "SDK encountered unexpected error in launching fullscreen ad");
            C3339d5 c3339d7 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e3, "event"));
        }
    }

    public void b(View view) {
        A0 a0;
        if (this.r || this.t) {
            return;
        }
        this.r = true;
        J2 j2 = this.h;
        if (j2 != null) {
            j2.a();
        }
        L4 l4 = this.j;
        if (l4 != null) {
            String TAG = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "A viewable impression is reported on ad view.");
        }
        C3513p7 c3513p7 = this.b.e;
        if (c3513p7 != null) {
            c3513p7.a("Impression", a(c3513p7), this.O, this.j);
        }
        m();
        for (C3455l7 c3455l7 : this.o) {
            HashMap mapA = a(c3455l7);
            L4 l5 = this.j;
            if (l5 != null) {
                String TAG2 = this.m;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((M4) l5).a(TAG2, "Page-view impression record request");
            }
            c3455l7.a("page_view", mapA, (T6) null, this.j);
        }
        this.o.clear();
        Sc sc = this.p;
        if (sc != null) {
            sc.a((byte) 0);
        }
        C3313b7 c3313b7C = c(this);
        if (c3313b7C == null || (a0 = c3313b7C.w) == null) {
            return;
        }
        a0.f();
    }

    public static final void b(C3313b7 it) {
        Intrinsics.checkNotNullParameter(it, "$it");
        C3575u c3575u = it.M;
        int iHashCode = it.hashCode();
        Y6 y6 = it.P;
        c3575u.getClass();
        C3575u.a(iHashCode, y6);
    }

    public final void b(C3455l7 c3455l7) {
        Tc viewableAd;
        L4 l4 = this.j;
        if (l4 != null) {
            String TAG = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "showEndCard");
        }
        C3313b7 c3313b7 = this.J;
        if (c3313b7 != null && g() != null) {
            try {
                View viewG = g();
                ViewGroup viewGroup = viewG instanceof ViewGroup ? (ViewGroup) viewG : null;
                View viewA = (viewGroup == null || (viewableAd = c3313b7.getViewableAd()) == null) ? null : viewableAd.a(null, viewGroup, false);
                if (viewA != null) {
                    if (viewGroup != null) {
                        viewGroup.addView(viewA);
                    }
                    viewA.setClickable(true);
                    c3313b7.p();
                    if (c3455l7 instanceof C3426j8) {
                        Rc rcD = ((C3426j8) c3455l7).d();
                        Hc hc = rcD != null ? ((Qc) rcD).j : null;
                        if (hc == null) {
                            return;
                        }
                        hc.g = true;
                        return;
                    }
                    return;
                }
                L4 l5 = this.j;
                if (l5 != null) {
                    String TAG2 = this.m;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    ((M4) l5).b(TAG2, "Could not inflate the end card. Closing the ad");
                }
                a();
                return;
            } catch (Exception e) {
                L4 l6 = this.j;
                if (l6 != null) {
                    String TAG3 = this.m;
                    Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                    ((M4) l6).a(TAG3, "Failed to show end card Exception", e);
                }
                a();
                C3339d5 c3339d5 = C3339d5.f3292a;
                C3339d5.c.a(I4.a(e, "event"));
                return;
            }
        }
        L4 l7 = this.j;
        if (l7 != null) {
            String TAG4 = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
            ((M4) l7).b(TAG4, "End card container is null; end card will not be shown");
        }
        AbstractC3498o6.a((byte) 2, "InMobi", "Failed to show end card");
        a();
    }

    @Override // com.inmobi.media.r
    public void b() {
        L4 l4 = this.j;
        if (l4 != null) {
            String TAG = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "destroyContainer");
        }
        if (this.t) {
            return;
        }
        this.t = true;
        J2 j2 = this.h;
        if (j2 != null) {
            j2.b();
        }
        this.y = -1;
        C3313b7 c3313b7 = this.C;
        if (c3313b7 != null) {
            c3313b7.a();
        }
        this.w = null;
        L7 l7H = h();
        if (l7H != null) {
            L0 l0 = l7H.l;
            Iterator it = l0.b.iterator();
            while (it.hasNext()) {
                ((K0) it.next()).f3109a.cancel();
            }
            l0.b.clear();
            l7H.n = true;
            l7H.i.clear();
            l7H.p = null;
            T7 t7 = l7H.j;
            if (t7 != null) {
                t7.destroy();
            }
            l7H.j = null;
        }
        this.q = null;
        this.o.clear();
        Sc sc = this.p;
        if (sc != null) {
            sc.e();
        }
        Sc sc2 = this.p;
        if (sc2 != null) {
            sc2.a();
        }
        Context context = (Context) this.x.get();
        if (context instanceof Activity) {
            ((Activity) context).getApplication().unregisterActivityLifecycleCallbacks(this);
        }
        this.x.clear();
        WeakReference weakReference = this.z;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.H = null;
        C3313b7 c3313b8 = this.J;
        if (c3313b8 != null) {
            c3313b8.b();
        }
        this.J = null;
        C3575u c3575u = this.M;
        int iHashCode = hashCode();
        c3575u.getClass();
        SparseArray sparseArray = C3575u.b;
        sparseArray.remove(iHashCode);
        Intrinsics.checkNotNullExpressionValue(ApsMetricsDataMap.APSMETRICS_FIELD_URL, "TAG");
        sparseArray.size();
    }

    public final void a(Context context) {
        this.x = new WeakReference(context);
        C3517pb.a(context, this);
    }

    public static final void a(C3313b7 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        C3575u c3575u = this$0.M;
        int iHashCode = this$0.hashCode();
        Y6 y6 = this$0.P;
        c3575u.getClass();
        C3575u.a(iHashCode, y6);
    }

    @Override // com.inmobi.media.r
    public final void a(byte b, Map map) {
        C3513p7 c3513p7;
        if (this.t || b == 0 || b == 3) {
            return;
        }
        if (b == 1) {
            C3513p7 c3513p8 = this.b.e;
            if (c3513p8 != null) {
                L4 l4 = this.j;
                if (l4 != null) {
                    String TAG = this.m;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((M4) l4).a(TAG, "reportAdLoad");
                }
                c3513p8.a("load", (HashMap) map, (T6) null, this.j);
                return;
            }
            return;
        }
        if (b != 2 || (c3513p7 = this.b.e) == null) {
            return;
        }
        L4 l5 = this.j;
        if (l5 != null) {
            String TAG2 = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((M4) l5).a(TAG2, "reportAdServed");
        }
        c3513p7.a("client_fill", (HashMap) map, (T6) null, this.j);
    }

    public final void a(View view, C3455l7 asset) {
        String strA;
        A0 a0;
        Intrinsics.checkNotNullParameter(asset, "asset");
        if (this.t) {
            return;
        }
        m();
        C3455l7 c3455l7B = b(this.b, asset);
        if (c3455l7B != null) {
            HashMap mapA = a(c3455l7B);
            a(c3455l7B, mapA);
            if (!Intrinsics.areEqual(c3455l7B, asset)) {
                a(asset, mapA);
            }
        } else {
            L4 l4 = this.j;
            if (l4 != null) {
                String TAG = this.m;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((M4) l4).b(TAG, "Couldn't find an asset reference for this asset click URL");
            }
            a(asset, a(asset));
        }
        C3313b7 c3313b7C = c(this);
        if (c3313b7C == null) {
            return;
        }
        String str = asset.p;
        if (str != null) {
            int length = str.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z2) {
                    i++;
                } else {
                    z = true;
                }
            }
            strA = Q6.a(length, 1, str, i);
        } else {
            strA = null;
        }
        if (AbstractC3420j2.a(strA) && (a0 = c3313b7C.w) != null) {
            a0.a();
        }
        C3455l7 c3455l7A = a(this.b, asset);
        if (c3455l7A != null) {
            if (view != null && Intrinsics.areEqual(ShareConstants.VIDEO_URL, c3455l7A.c) && 5 == c3455l7A.k) {
                view.setVisibility(4);
                asset.v = 4;
            }
            c(c3455l7A);
            return;
        }
        L4 l5 = this.j;
        if (l5 != null) {
            String TAG2 = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((M4) l5).b(TAG2, "Couldn't find an asset reference for this asset action! Ignoring the asset action ...");
        }
    }

    public final C3455l7 a(C3455l7 c3455l7, C3625x7 c3625x7, String str) {
        if (AbstractC3392h2.a((Context) this.x.get(), str) || str == null || str.length() == 0) {
            return c3455l7;
        }
        String[] strArr = (String[]) new Regex("\\|").split(str, 0).toArray(new String[0]);
        C3455l7 c3455l7M = c3625x7.m(strArr[0]);
        if (c3455l7M == null) {
            return b(c3625x7.g, c3455l7);
        }
        if (Intrinsics.areEqual(c3455l7M, c3455l7)) {
            return null;
        }
        if (strArr.length <= 2) {
            c3455l7M.l = (byte) 1;
        } else {
            c3455l7M.l = AbstractC3583u7.a(strArr[2]);
        }
        return c3455l7M;
    }

    public static C3313b7 c(C3313b7 c3313b7) {
        if (c3313b7 == null) {
            return null;
        }
        if (c3313b7.f() != null || Intrinsics.areEqual(c3313b7, c3313b7.v)) {
            return c3313b7;
        }
        C3313b7 c3313b8 = c3313b7.v;
        return c(c3313b8 instanceof C3313b7 ? c3313b8 : null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0080, code lost:
    
        if (r7.equals("replay") == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0089, code lost:
    
        if (r7.equals("reload") == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008c, code lost:
    
        return 3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte a(java.lang.String r7) {
        /*
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r1 = "US"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.String r7 = r7.toLowerCase(r0)
            java.lang.String r0 = "this as java.lang.String).toLowerCase(locale)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            int r0 = r7.length()
            r1 = 1
            int r0 = r0 - r1
            r2 = 0
            r3 = r2
            r4 = r3
        L19:
            if (r3 > r0) goto L3e
            if (r4 != 0) goto L1f
            r5 = r3
            goto L20
        L1f:
            r5 = r0
        L20:
            char r5 = r7.charAt(r5)
            r6 = 32
            int r5 = kotlin.jvm.internal.Intrinsics.compare(r5, r6)
            if (r5 > 0) goto L2e
            r5 = r1
            goto L2f
        L2e:
            r5 = r2
        L2f:
            if (r4 != 0) goto L38
            if (r5 != 0) goto L35
            r4 = r1
            goto L19
        L35:
            int r3 = r3 + 1
            goto L19
        L38:
            if (r5 != 0) goto L3b
            goto L3e
        L3b:
            int r0 = r0 + (-1)
            goto L19
        L3e:
            java.lang.String r7 = com.inmobi.media.Q6.a(r0, r1, r7, r3)
            int r0 = r7.hashCode()
            switch(r0) {
                case -934641255: goto L83;
                case -934524953: goto L7a;
                case 0: goto L74;
                case 3127582: goto L6b;
                case 3443508: goto L60;
                case 3532159: goto L55;
                case 110066619: goto L4a;
                default: goto L49;
            }
        L49:
            goto L8e
        L4a:
            java.lang.String r0 = "fullscreen"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L53
            goto L8e
        L53:
            r1 = 4
            goto L8f
        L55:
            java.lang.String r0 = "skip"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L5e
            goto L8e
        L5e:
            r1 = 2
            goto L8f
        L60:
            java.lang.String r0 = "play"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L69
            goto L8e
        L69:
            r1 = 5
            goto L8f
        L6b:
            java.lang.String r0 = "exit"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L8f
            goto L8e
        L74:
            java.lang.String r0 = ""
            r7.equals(r0)
            goto L8e
        L7a:
            java.lang.String r0 = "replay"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L8c
            goto L8e
        L83:
            java.lang.String r0 = "reload"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L8c
            goto L8e
        L8c:
            r1 = 3
            goto L8f
        L8e:
            r1 = r2
        L8f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C3313b7.a(java.lang.String):byte");
    }

    public final void a(C3455l7 asset, boolean z) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        C3625x7 c3625x7 = this.b;
        if (!c3625x7.q || this.t) {
            return;
        }
        C3455l7 c3455l7B = b(c3625x7, asset);
        if (c3455l7B != null) {
            HashMap mapA = a(c3455l7B);
            String str = asset.g;
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            c3455l7B.g = str;
            String strA = null;
            Z5 z5 = ((TelemetryConfig.LandingPageConfig) this.k.getValue()).getNativeEnabled() ? new Z5(this.i, R5.a(c3455l7B.p), 0, 12) : null;
            R5.a(N5.LPClickStart, z5, (Integer) null, 12);
            if (Intrinsics.areEqual(ShareConstants.VIDEO_URL, c3455l7B.c) || c3455l7B.f) {
                L4 l4 = this.j;
                if (l4 != null) {
                    String TAG = this.m;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((M4) l4).a(TAG, "Asset interaction requested");
                }
                String str2 = c3455l7B.g;
                Sc sc = this.p;
                if (sc != null) {
                    sc.a((byte) 4);
                }
                if (Intrinsics.areEqual("NO_ACTION", str2)) {
                    R5.a(N5.LPStartFailed, z5, (Integer) 10, 8);
                    return;
                }
                String str3 = c3455l7B.p;
                if (2 == c3455l7B.l) {
                    Intrinsics.checkNotNull(c3455l7B, "null cannot be cast to non-null type com.inmobi.ads.modelsv2.NativeVideoAsset");
                    Rc rcD = ((C3426j8) c3455l7B).d();
                    Hc hc = rcD != null ? ((Qc) rcD).j : null;
                    String str4 = hc != null ? hc.c : null;
                    if (str4 != null) {
                        int length = str4.length() - 1;
                        int i = 0;
                        boolean z2 = false;
                        while (i <= length) {
                            boolean z3 = Intrinsics.compare((int) str4.charAt(!z2 ? i : length), 32) <= 0;
                            if (z2) {
                                if (!z3) {
                                    break;
                                } else {
                                    length--;
                                }
                            } else if (z3) {
                                i++;
                            } else {
                                z2 = true;
                            }
                        }
                        strA = Q6.a(length, 1, str4, i);
                    }
                    if (AbstractC3420j2.a(strA)) {
                        str3 = str4;
                    }
                }
                if (!AbstractC3392h2.a(d(), str3)) {
                    L4 l5 = this.j;
                    if (l5 != null) {
                        String TAG2 = this.m;
                        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                        ((M4) l5).b(TAG2, "Invalid url:" + str3 + " will use fallback");
                    }
                    str3 = c3455l7B.q;
                    if (!AbstractC3392h2.a(d(), str3)) {
                        L4 l6 = this.j;
                        if (l6 != null) {
                            String str5 = this.m;
                            ((M4) l6).b(str5, P5.a(str5, "TAG", "Invalid fallback url:", str3));
                        }
                        R5.a(N5.LPStartFailed, z5, (Integer) 3, 8);
                        return;
                    }
                }
                boolean z4 = W8.f3228a;
                Intrinsics.checkNotNull(str3);
                String strA2 = W8.a(str3, mapA);
                J2 j2 = this.h;
                if (j2 != null && !j2.g.get()) {
                    j2.d.g = 1;
                    Intrinsics.checkNotNull(j2.c);
                }
                if (this.D && !z) {
                    C3313b7 c3313b7C = c(this);
                    if (c3313b7C == null) {
                        return;
                    }
                    A0 a0 = c3313b7C.w;
                    if (a0 != null) {
                        if (Intrinsics.areEqual("INAPP", str2) && AbstractC3392h2.a(strA2)) {
                            a0.e();
                        } else {
                            a0.g();
                        }
                    }
                    this.E = c3455l7B;
                    this.F = strA2;
                    return;
                }
                a(c3455l7B, str2, strA2, z5);
                return;
            }
            return;
        }
        L4 l7 = this.j;
        if (l7 != null) {
            String TAG3 = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            ((M4) l7).b(TAG3, "Couldn't find an asset reference for this asset click URL");
        }
    }

    public final void a(C3455l7 c3455l7, HashMap map) {
        L4 l4 = this.j;
        if (l4 != null) {
            String TAG = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "Click impression record requested");
        }
        if (2 == c3455l7.l) {
            C3426j8 c3426j8 = c3455l7 instanceof C3426j8 ? (C3426j8) c3455l7 : null;
            Rc rcD = c3426j8 != null ? c3426j8.d() : null;
            Hc hc = rcD != null ? ((Qc) rcD).j : null;
            if ((hc != null ? hc.c : null) != null && c3455l7.p != null) {
                if (hc.f.isEmpty()) {
                    return;
                }
                Iterator it = hc.a("click").iterator();
                while (it.hasNext()) {
                    C3455l7.a((C3328c8) it.next(), map, (T6) null, this.j);
                }
                return;
            }
            L4 l5 = this.j;
            if (l5 != null) {
                String TAG2 = this.m;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((M4) l5).a(TAG2, "reportAdClick");
            }
            c3455l7.a("click", map, (T6) null, this.j);
            return;
        }
        L4 l6 = this.j;
        if (l6 != null) {
            String TAG3 = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            ((M4) l6).a(TAG3, "reportAdClick");
        }
        c3455l7.a("click", map, (T6) null, this.j);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0028  */
    /* JADX WARN: Code duplicated, block: B:12:0x002f  */
    /* JADX WARN: Code duplicated, block: B:13:0x0031  */
    /* JADX WARN: Code duplicated, block: B:15:0x0034  */
    /* JADX WARN: Code duplicated, block: B:18:0x003d  */
    /* JADX WARN: Code duplicated, block: B:36:0x0045 A[EDGE_INSN: B:36:0x0045->B:22:0x0045 BREAK  A[LOOP:0: B:14:0x0032->B:39:0x0032], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0031 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x0044 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x0032 A[SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0032, code lost:
    
        r1 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.HashMap a(com.inmobi.media.C3455l7 r9) {
        /*
            r8 = this;
            java.lang.String r0 = "asset"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.util.HashMap r0 = new java.util.HashMap
            r1 = 4
            r0.<init>(r1)
            boolean r1 = r8.t
            if (r1 == 0) goto L10
            return r0
        L10:
            java.lang.String r1 = "child"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r1)
            boolean r1 = r9 instanceof com.inmobi.media.C3513p7
            r2 = 1
            java.lang.String r3 = "card_scrollable"
            if (r1 == 0) goto L28
            r1 = r9
            com.inmobi.media.p7 r1 = (com.inmobi.media.C3513p7) r1
            java.lang.String r4 = r1.b
            boolean r4 = kotlin.text.StringsKt.equals(r3, r4, r2)
            if (r4 == 0) goto L28
            goto L45
        L28:
            com.inmobi.media.p7 r9 = r9.r
            boolean r1 = r9 instanceof com.inmobi.media.C3513p7
            r4 = 0
            if (r1 == 0) goto L31
            r1 = r9
            goto L32
        L31:
            r1 = r4
        L32:
            if (r1 == 0) goto L44
            java.lang.String r9 = r1.b
            boolean r9 = kotlin.text.StringsKt.equals(r3, r9, r2)
            if (r9 == 0) goto L3d
            goto L45
        L3d:
            com.inmobi.media.p7 r1 = r1.r
            boolean r9 = r1 instanceof com.inmobi.media.C3513p7
            if (r9 == 0) goto L31
            goto L32
        L44:
            r1 = r4
        L45:
            long r2 = java.lang.System.currentTimeMillis()
            r4 = 0
            if (r1 == 0) goto L54
            long r6 = r1.y
            int r9 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r9 == 0) goto L54
            r2 = r6
        L54:
            com.inmobi.media.x7 r9 = r8.b
            com.inmobi.media.p7 r9 = r9.e
            if (r9 == 0) goto L5c
            long r4 = r9.y
        L5c:
            java.lang.String r9 = java.lang.String.valueOf(r4)
            java.lang.String r1 = "$LTS"
            r0.put(r1, r9)
            java.lang.String r9 = java.lang.String.valueOf(r2)
            java.lang.String r1 = "$STS"
            r0.put(r1, r9)
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.String r9 = java.lang.String.valueOf(r1)
            java.lang.String r1 = "$TS"
            r0.put(r1, r9)
            com.inmobi.media.x7 r9 = r8.b
            java.util.Map r9 = r9.t
            if (r9 != 0) goto L86
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
        L86:
            r0.putAll(r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C3313b7.a(com.inmobi.media.l7):java.util.HashMap");
    }

    public static C3314b8 a(View view) {
        View viewFindViewWithTag = view != null ? view.findViewWithTag("timerView") : null;
        if (viewFindViewWithTag instanceof C3314b8) {
            return (C3314b8) viewFindViewWithTag;
        }
        return null;
    }

    public final void a(C3426j8 c3426j8) {
        Rc rcD = c3426j8.d();
        Hc hc = rcD != null ? ((Qc) rcD).j : null;
        if (hc == null || !hc.g) {
            return;
        }
        L4 l4 = this.j;
        if (l4 != null) {
            String TAG = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "Invoking close end card trackers.");
        }
        Iterator it = hc.a("closeEndCard").iterator();
        while (it.hasNext()) {
            C3455l7.a((C3328c8) it.next(), a((C3455l7) c3426j8), (T6) null, this.j);
        }
        hc.g = false;
    }

    @Override // com.inmobi.media.r
    public final void a() {
        L4 l4 = this.j;
        if (l4 != null) {
            String TAG = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "dismissCurrentViewContainer");
        }
        if (this.t) {
            return;
        }
        try {
            C3313b7 container = c(this);
            if (container == null) {
                return;
            }
            container.q();
            SparseArray sparseArray = InMobiAdActivity.k;
            Intrinsics.checkNotNullParameter(container, "container");
            InMobiAdActivity.k.remove(container.hashCode());
            if (container instanceof C3398h8) {
                View videoContainerView = container.getVideoContainerView();
                C3570t8 c3570t8 = videoContainerView instanceof C3570t8 ? (C3570t8) videoContainerView : null;
                if (c3570t8 != null) {
                    C3556s8 videoView = c3570t8.getVideoView();
                    Object tag = videoView.getTag();
                    if (tag instanceof C3426j8) {
                        HashMap map = ((C3426j8) tag).t;
                        map.put("seekPosition", Integer.valueOf(videoView.getCurrentPosition()));
                        map.put("lastMediaVolume", Integer.valueOf(videoView.getVolume()));
                        C3455l7 c3455l7 = ((C3426j8) tag).w;
                        if (c3455l7 instanceof C3426j8) {
                            ((C3426j8) c3455l7).a((C3426j8) tag);
                        }
                        a((C3426j8) tag);
                    }
                }
            }
            WeakReference weakReference = container.z;
            Activity activity = weakReference != null ? (Activity) weakReference.get() : null;
            if (activity instanceof InMobiAdActivity) {
                ((InMobiAdActivity) activity).e = true;
                ((InMobiAdActivity) activity).finish();
                int i = this.y;
                if (i != -1) {
                    ((InMobiAdActivity) activity).overridePendingTransition(0, i);
                }
            }
            final C3313b7 c3313b7 = this.v;
            if (!(c3313b7 instanceof C3313b7)) {
                c3313b7 = null;
            }
            if (c3313b7 != null) {
                c3313b7.C = null;
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.inmobi.media.b7$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        C3313b7.b(this.f$0);
                    }
                });
            }
        } catch (Exception e) {
            L4 l5 = this.j;
            if (l5 != null) {
                String str = this.m;
                ((M4) l5).b(str, ld.a(e, O5.a(str, "TAG", "Encountered unexpected error in handling exit action on video: ")));
            }
            AbstractC3498o6.a((byte) 2, "InMobi", "SDK encountered unexpected error in exiting video");
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
        }
    }

    public final void a(C3455l7 asset, String interactionMode, String url, Z5 z5) {
        Unit unit;
        String strA;
        A0 a0;
        Unit unit2;
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(interactionMode, "interactionMode");
        Intrinsics.checkNotNullParameter(url, "url");
        L4 l4 = this.j;
        if (l4 != null) {
            String TAG = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "openUrl");
        }
        if (Intrinsics.areEqual("EMBEDDED", interactionMode)) {
            if (z5 != null) {
                z5.g = "IN_CUSTOM";
            }
            Integer numA = a(url, asset, z5);
            if (numA != null) {
                R5.a(N5.LPBrowserOpenFailed, z5, Integer.valueOf(numA.intValue()), 8);
                unit2 = Unit.INSTANCE;
            } else {
                unit2 = null;
            }
            if (unit2 == null) {
                R5.a(N5.LPStartSuccess, z5, (Integer) null, 12);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual("INAPP", interactionMode)) {
            L4 l5 = this.j;
            if (l5 != null) {
                String TAG2 = this.m;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((M4) l5).c(TAG2, "openUrlInCCT");
            }
            Context context = (Context) this.x.get();
            if (context == null) {
                return;
            }
            if (f() == null && (a0 = this.w) != null) {
                a0.e();
            }
            String strA2 = Y2.a(context);
            try {
                boolean zIsCCTEnabled = this.s.getCctEnabled();
                try {
                    if (strA2 != null && zIsCCTEnabled) {
                        S1 s1 = new S1(url, context, this.Q, this.l, z5, "NATIVE");
                        W2 w2 = s1.f;
                        Context context2 = s1.g;
                        if (w2.f3223a == null && context2 != null && (strA = Y2.a(context2)) != null) {
                            U2 u2 = new U2(w2);
                            w2.b = u2;
                            CustomTabsClient.bindCustomTabsService(context2, strA, u2);
                            return;
                        }
                        return;
                    }
                    L4 l6 = this.j;
                    if (l6 != null) {
                        String TAG3 = this.m;
                        Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                        ((M4) l6).a(TAG3, "ChromeCustomTab fallback to Embedded");
                    }
                    if (z5 != null) {
                        z5.g = "IN_CUSTOM";
                    }
                    Integer numA2 = a(url, asset, z5);
                    if (numA2 != null) {
                        R5.a(N5.LPBrowserOpenFailed, z5, Integer.valueOf(numA2.intValue()), 8);
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        R5.a(N5.LPStartSuccess, z5, (Integer) null, 12);
                    }
                } catch (Exception e) {
                    e = e;
                    Exception exc = e;
                    try {
                        AbstractC3392h2.a(context, url, this.l, "NATIVE");
                        if (z5 != null) {
                            z5.g = "EX_NATIVE";
                        }
                        R5.a(N5.LPStartSuccess, z5, (Integer) null, 12);
                    } catch (Exception e2) {
                        L4 l7 = this.j;
                        if (l7 != null) {
                            String TAG4 = this.m;
                            Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
                            ((M4) l7).a(TAG4, "Exception occurred while opening External ", e2);
                        }
                        R5.a(N5.LPBrowserOpenFailed, z5, (Integer) 9, 8);
                    }
                    L4 l8 = this.j;
                    if (l8 != null) {
                        String TAG5 = this.m;
                        Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
                        ((M4) l8).a(TAG5, "Fallback to External while opening cct", exc);
                    }
                }
            } catch (Exception e3) {
                e = e3;
            }
        } else {
            String str = asset.q;
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(asset, "asset");
            L4 l9 = this.j;
            if (l9 != null) {
                String TAG6 = this.m;
                Intrinsics.checkNotNullExpressionValue(TAG6, "TAG");
                ((M4) l9).c(TAG6, "openUrlUsingExternalBrowser");
            }
            if (this.x.get() == null) {
                return;
            }
            if (z5 != null) {
                z5.g = "EX_NATIVE";
            }
            String strA3 = AbstractC3392h2.a((Context) this.x.get(), this.l, url, str);
            if (strA3 != null) {
                C3313b7 c3313b7C = c(this);
                if (c3313b7C == null) {
                    return;
                }
                A0 a1 = c3313b7C.w;
                if (!this.D && a1 != null) {
                    a1.g();
                }
                if (Intrinsics.areEqual(strA3, str)) {
                    asset.a("TRACKER_EVENT_TYPE_FALLBACK_URL", a(asset), (T6) null, this.j);
                }
                R5.a(N5.LPStartSuccess, z5, (Integer) null, 12);
                return;
            }
            R5.a(N5.LPBrowserOpenFailed, z5, (Integer) 6, 8);
        }
    }

    public final Integer a(String url, C3455l7 asset, Z5 z5) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(asset, "asset");
        try {
            Context context = (Context) this.x.get();
            if (context == null) {
                return 7;
            }
            if (AbstractC3392h2.a(url)) {
                L4 l4 = this.j;
                if (l4 != null) {
                    String TAG = this.m;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((M4) l4).c(TAG, "openUrlUsingEmbeddedBrowser");
                }
                InMobiAdActivity.l = null;
                C3298a7 c3298a7 = this.L;
                if (c3298a7 == null) {
                    c3298a7 = new C3298a7(this);
                    this.L = c3298a7;
                }
                InMobiAdActivity.m = c3298a7;
                Intent intent = new Intent(context, (Class<?>) InMobiAdActivity.class);
                intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 100);
                intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.IN_APP_BROWSER_URL", url);
                intent.putExtra("placementId", this.e);
                intent.putExtra("creativeId", getCreativeId());
                intent.putExtra("impressionId", getImpressionId());
                intent.putExtra("allowAutoRedirection", this.f);
                if (z5 != null) {
                    intent.putExtra("lpTelemetryControlInfo", z5);
                }
                if (asset.i) {
                    intent.putExtra("supportLockScreen", true);
                }
                C3517pb.f3400a.a(context, intent);
                return null;
            }
            return 10;
        } catch (Exception e) {
            L4 l5 = this.j;
            if (l5 != null) {
                String TAG2 = this.m;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((M4) l5).a(TAG2, "Error while opening Embedded Browser", e);
            }
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
            return 9;
        }
    }
}
