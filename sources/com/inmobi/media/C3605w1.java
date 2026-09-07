package com.inmobi.media;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import com.inmobi.ads.InMobiAdRequestStatus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.w1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public class C3605w1 extends C0 implements Application.ActivityLifecycleCallbacks {
    public final String M;
    public final String N;
    public boolean O;
    public int P;
    public final C3619x1 Q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3605w1(Context context, J placement, AbstractC3520q0 abstractC3520q0) {
        super(context, placement, abstractC3520q0);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(placement, "placement");
        this.M = "w1";
        this.N = "InMobi";
        this.Q = new C3619x1();
        Intrinsics.checkNotNullExpressionValue("w1", "TAG");
        placement.l();
        a(context, placement, abstractC3520q0);
    }

    public static final void c(C3605w1 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        L4 l4 = this$0.j;
        if (l4 != null) {
            String TAG = this$0.M;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "start loading html ad");
        }
        this$0.s0();
    }

    public static final void e(C3605w1 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            if (this$0.Q() != 6) {
                if (this$0.Q() == 7) {
                    this$0.P++;
                    return;
                }
                return;
            }
            this$0.P++;
            this$0.d((byte) 7);
            L4 l4 = this$0.j;
            if (l4 != null) {
                String TAG = this$0.M;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((M4) l4).d(TAG, "AdUnit " + this$0 + " state - ACTIVE");
            }
            L4 l5 = this$0.j;
            if (l5 != null) {
                ((M4) l5).c(this$0.N, "Successfully displayed banner ad for placement Id : " + this$0.I());
            }
            AbstractC3520q0 abstractC3520q0R = this$0.r();
            if (abstractC3520q0R != null) {
                this$0.d(abstractC3520q0R);
            }
        } catch (Exception e) {
            L4 l6 = this$0.j;
            if (l6 != null) {
                String str = this$0.M;
                ((M4) l6).b(str, ld.a(e, O5.a(str, "TAG", "BannerAdUnit.onAdScreenDisplayed threw unexpected error: ")));
            }
        }
    }

    public static final void f(C3605w1 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            if (this$0.Q() == 4) {
                this$0.d((byte) 6);
                L4 l4 = this$0.j;
                if (l4 != null) {
                    String TAG = this$0.M;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((M4) l4).d(TAG, "AdUnit " + this$0 + " state - RENDERED");
                }
            }
        } catch (Exception e) {
            L4 l5 = this$0.j;
            if (l5 != null) {
                String str = this$0.M;
                ((M4) l5).b(str, ld.a(e, O5.a(str, "TAG", "BannerAdUnit.onRenderViewVisible threw unexpected error: ")));
            }
        }
    }

    public static final void g(C3605w1 this$0) {
        LinkedList<C3389h> linkedListF;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.b0()) {
            this$0.a(System.currentTimeMillis());
            C3418j0 c3418j0Y = this$0.y();
            if (c3418j0Y != null && (linkedListF = c3418j0Y.f()) != null) {
                int i = 0;
                for (Object obj : linkedListF) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    this$0.B().add(Integer.valueOf(i));
                    i = i2;
                }
            }
        }
        this$0.s0();
    }

    public boolean C0() {
        L4 l4 = this.j;
        if (l4 != null) {
            String str = this.M;
            ((M4) l4).c(str, AbstractC3563t1.a(str, "TAG", "canProceedToLoad ", this));
        }
        if (f0()) {
            L4 l5 = this.j;
            if (l5 != null) {
                String TAG = this.M;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((M4) l5).b(TAG, "Some of the dependency libraries for Banner not found");
            }
            b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.MISSING_REQUIRED_DEPENDENCIES), true, (short) 2007);
            return false;
        }
        if (1 == Q() || 2 == Q()) {
            AbstractC3498o6.a((byte) 1, this.N, "An ad load is already in progress. Please wait for the load to complete before requesting for another ad");
            L4 l6 = this.j;
            if (l6 != null) {
                String TAG2 = this.M;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((M4) l6).b(TAG2, "An ad load is already in progress. Please wait for the load to complete before requesting for another ad");
            }
            if (1 == Q()) {
                a((short) 2008);
            } else {
                a((short) 2011);
            }
            return false;
        }
        if (7 != Q()) {
            L4 l7 = this.j;
            if (l7 != null) {
                ((M4) l7).c(this.N, "Fetching a Banner ad for placement id: " + I());
            }
            e0();
            return true;
        }
        b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.AD_ACTIVE), false, (short) 2010);
        L4 l8 = this.j;
        if (l8 != null) {
            String str2 = this.M;
            ((M4) l8).b(str2, O5.a(str2, "TAG", AbstractC3574tc.j).append(I().l()).toString());
        }
        return false;
    }

    public final boolean D0() {
        return Q() == 7;
    }

    public final void E0() {
        Tc viewableAd;
        L4 l4 = this.j;
        if (l4 != null) {
            String str = this.M;
            ((M4) l4).a(str, AbstractC3563t1.a(str, "TAG", "onPause ", this));
        }
        byte bQ = Q();
        if (bQ == 4 || bQ == 6 || bQ == 7) {
            r rVarK = k();
            Context contextT = t();
            if (rVarK == null || contextT == null || (viewableAd = rVarK.getViewableAd()) == null) {
                return;
            }
            viewableAd.a(contextT, (byte) 1);
        }
    }

    public final void F0() {
        Tc viewableAd;
        L4 l4 = this.j;
        if (l4 != null) {
            String str = this.M;
            ((M4) l4).a(str, AbstractC3563t1.a(str, "TAG", "onResume ", this));
        }
        byte bQ = Q();
        if (bQ == 4 || bQ == 6 || bQ == 7) {
            r rVarK = k();
            Context contextT = t();
            if (rVarK == null || contextT == null || (viewableAd = rVarK.getViewableAd()) == null) {
                return;
            }
            viewableAd.a(contextT, (byte) 0);
        }
    }

    public final void G0() {
        L4 l4 = this.j;
        if (l4 != null) {
            String str = this.M;
            ((M4) l4).c(str, AbstractC3563t1.a(str, "TAG", "registerLifeCycleCallbacks ", this));
        }
        Context contextT = t();
        if (contextT != null) {
            C3517pb.a(contextT, this);
        }
    }

    public final void H0() {
        L4 l4 = this.j;
        if (l4 != null) {
            String TAG = this.M;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "renderAdPostInternetCheck");
        }
        try {
            if (o0()) {
                return;
            }
            E0 e0S = s();
            e0S.getClass();
            e0S.g = SystemClock.elapsedRealtime();
            d0();
            Handler handlerD = D();
            if (handlerD != null) {
                handlerD.post(new Runnable() { // from class: com.inmobi.media.w1$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        C3605w1.g(this.f$0);
                    }
                });
            }
        } catch (IllegalStateException e) {
            L4 l5 = this.j;
            if (l5 != null) {
                String TAG2 = this.M;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((M4) l5).a(TAG2, "Exception while loading ad.", e);
            }
            b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, (short) 2134);
        }
    }

    public final void I0() {
        Application application;
        L4 l4 = this.j;
        if (l4 != null) {
            String str = this.M;
            ((M4) l4).c(str, AbstractC3563t1.a(str, "TAG", "unregisterLifeCycleCallbacks ", this));
        }
        Context contextT = t();
        Activity activity = contextT instanceof Activity ? (Activity) contextT : null;
        if (activity == null || (application = activity.getApplication()) == null) {
            return;
        }
        application.unregisterActivityLifecycleCallbacks(this);
    }

    @Override // com.inmobi.media.C0
    public final byte J() {
        return (byte) 0;
    }

    @Override // com.inmobi.media.C0
    public void c0() {
        L4 l4 = this.j;
        if (l4 != null) {
            String str = this.M;
            ((M4) l4).a(str, AbstractC3563t1.a(str, "TAG", "load ", this));
        }
        if (C0()) {
            super.c0();
        }
    }

    public final void d(boolean z) {
        L4 l4;
        L4 l5 = this.j;
        if (l5 != null) {
            String str = this.M;
            ((M4) l5).a(str, AbstractC3563t1.a(str, "TAG", "load ", this));
        }
        if (z && (l4 = this.j) != null) {
            ((M4) l4).c(this.N, "Initiating Banner refresh for placement id: " + I());
        }
        this.O = z;
        c0();
    }

    @Override // com.inmobi.media.C0
    public boolean f0() {
        L4 l4 = this.j;
        if (l4 == null) {
            return false;
        }
        String str = this.M;
        ((M4) l4).c(str, AbstractC3563t1.a(str, "TAG", "missingPrerequisitesForAd ", this));
        return false;
    }

    @Override // com.inmobi.media.C0, com.inmobi.media.Da
    public void i(Ba renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        L4 l4 = this.j;
        if (l4 != null) {
            String str = this.M;
            ((M4) l4).c(str, AbstractC3563t1.a(str, "TAG", "onRenderViewVisible ", this));
        }
        super.i(renderView);
        Handler handlerD = D();
        if (handlerD != null) {
            handlerD.post(new Runnable() { // from class: com.inmobi.media.w1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C3605w1.f(this.f$0);
                }
            });
        }
    }

    @Override // com.inmobi.media.C0
    public void j0() {
        if (p0()) {
            L4 l4 = this.j;
            if (l4 != null) {
                String TAG = this.M;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((M4) l4).a(TAG, "renderAd without internet check");
            }
            H0();
            return;
        }
        L4 l5 = this.j;
        if (l5 != null) {
            String TAG2 = this.M;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((M4) l5).a(TAG2, "renderAd");
        }
        a(new C3577u1(this), new C3591v1(this));
    }

    @Override // com.inmobi.media.C0
    public final void l(Ba ba) {
        L4 l4 = this.j;
        if (l4 != null) {
            String str = this.M;
            ((M4) l4).a(str, AbstractC3563t1.a(str, "TAG", "handleRenderViewSignaledAdReady ", this));
        }
        super.l(ba);
        if (b0() && this.g.indexOf(ba) > 0 && Q() == 6) {
            b((byte) 1);
            Ba ba2 = (Ba) this.g.get(A());
            if (ba2 != null) {
                ba2.a(true);
                return;
            }
            return;
        }
        if (Q() != 2) {
            L4 l5 = this.j;
            if (l5 != null) {
                String str2 = this.M;
                ((M4) l5).a(str2, O5.a(str2, "TAG", "AdUnit is not in available state, ignoring the ad ready signal - ").append((int) Q()).toString());
                return;
            }
            return;
        }
        b((byte) 1);
        d((byte) 4);
        L4 l6 = this.j;
        if (l6 != null) {
            String TAG = this.M;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l6).d(TAG, "AdUnit " + this + " state - READY");
        }
        E0 e0S = s();
        e0S.getClass();
        e0S.i = SystemClock.elapsedRealtime();
        u0();
        z0();
        L4 l7 = this.j;
        if (l7 != null) {
            ((M4) l7).c(this.N, "Successfully loaded Banner ad markup in the WebView for placement id: " + I());
        }
        AbstractC3520q0 abstractC3520q0R = r();
        if (abstractC3520q0R != null) {
            f(abstractC3520q0R);
        } else {
            L4 l8 = this.j;
            if (l8 != null) {
                String TAG2 = this.M;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((M4) l8).b(TAG2, "AdUnit listener is null");
            }
        }
        i();
    }

    @Override // com.inmobi.media.C0
    public final HashMap o() {
        L4 l4 = this.j;
        if (l4 != null) {
            String str = this.M;
            ((M4) l4).c(str, AbstractC3563t1.a(str, "TAG", "adSpecificRequestParams getter ", this));
        }
        HashMap map = new HashMap();
        map.put("u-rt", this.O ? "1" : "0");
        map.put("mk-ad-slot", I().a());
        return map;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        L4 l4 = this.j;
        if (l4 != null) {
            String str = this.M;
            ((M4) l4).c(str, AbstractC3563t1.a(str, "TAG", "onActivityCreated ", this));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        L4 l4 = this.j;
        if (l4 != null) {
            String str = this.M;
            ((M4) l4).c(str, AbstractC3563t1.a(str, "TAG", "onActivityDestroyed ", this));
        }
        Context contextT = t();
        if (Intrinsics.areEqual(contextT, activity)) {
            Intrinsics.checkNotNull(contextT, "null cannot be cast to non-null type android.app.Activity");
            ((Activity) contextT).getApplication().unregisterActivityLifecycleCallbacks(this);
            g();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        L4 l4 = this.j;
        if (l4 != null) {
            String str = this.M;
            ((M4) l4).c(str, AbstractC3563t1.a(str, "TAG", "onActivityPaused ", this));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        L4 l4 = this.j;
        if (l4 != null) {
            String str = this.M;
            ((M4) l4).c(str, AbstractC3563t1.a(str, "TAG", "onActivityResumed ", this));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
        L4 l4 = this.j;
        if (l4 != null) {
            String str = this.M;
            ((M4) l4).c(str, AbstractC3563t1.a(str, "TAG", "onActivitySaveInstanceState ", this));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        L4 l4 = this.j;
        if (l4 != null) {
            String str = this.M;
            ((M4) l4).c(str, AbstractC3563t1.a(str, "TAG", "onActivityStarted ", this));
        }
        if (Intrinsics.areEqual(t(), activity)) {
            F0();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        L4 l4 = this.j;
        if (l4 != null) {
            String str = this.M;
            ((M4) l4).c(str, AbstractC3563t1.a(str, "TAG", "onActivityStopped ", this));
        }
        if (Intrinsics.areEqual(t(), activity)) {
            E0();
        }
    }

    @Override // com.inmobi.media.C0
    public String q() {
        return "banner";
    }

    @Override // com.inmobi.media.C0
    public Ba w() {
        L4 l4 = this.j;
        if (l4 != null) {
            String str = this.M;
            ((M4) l4).c(str, AbstractC3563t1.a(str, "TAG", "htmlAdContainer getter ", this));
        }
        Ba baW = super.w();
        if (I().p() && baW != null) {
            baW.e();
        }
        return baW;
    }

    @Override // com.inmobi.media.C0
    public void a(boolean z, InMobiAdRequestStatus status) {
        AbstractC3520q0 abstractC3520q0R;
        Intrinsics.checkNotNullParameter(status, "status");
        super.a(z, status);
        L4 l4 = this.j;
        if (l4 != null) {
            String str = this.M;
            ((M4) l4).c(str, AbstractC3563t1.a(str, "TAG", "onDidParseAfterFetch ", this));
        }
        L4 l5 = this.j;
        if (l5 != null) {
            ((M4) l5).c(this.N, "Banner ad fetch successful for placement id: " + I());
        }
        if (Q() != 2 || (abstractC3520q0R = r()) == null) {
            return;
        }
        e(abstractC3520q0R);
    }

    @Override // com.inmobi.media.C0, com.inmobi.media.K
    public void b() {
        L4 l4 = this.j;
        if (l4 != null) {
            String str = this.M;
            ((M4) l4).a(str, AbstractC3563t1.a(str, "TAG", "closeAll ", this));
        }
    }

    @Override // com.inmobi.media.Da
    public synchronized void d(Ba renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        L4 l4 = this.j;
        if (l4 != null) {
            String str = this.M;
            ((M4) l4).a(str, AbstractC3563t1.a(str, "TAG", "onAdScreenDismissed ", this));
        }
        super.d(renderView);
        Handler handlerD = D();
        if (handlerD != null) {
            handlerD.post(new Runnable() { // from class: com.inmobi.media.w1$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    C3605w1.d(this.f$0);
                }
            });
        }
    }

    public static final void a(C3605w1 this$0, Ba renderView, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(renderView, "$renderView");
        int iIndexOf = this$0.g.indexOf(renderView);
        try {
            AbstractC3520q0 abstractC3520q0R = this$0.r();
            L4 l4 = this$0.j;
            if (l4 != null) {
                String TAG = this$0.M;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((M4) l4).c(TAG, "callback onShowNextPodAd");
            }
            if (abstractC3520q0R != null) {
                abstractC3520q0R.a(i, iIndexOf, renderView);
            }
        } catch (Exception unused) {
            this$0.b(iIndexOf, false);
            this$0.f(iIndexOf);
        }
    }

    @Override // com.inmobi.media.C0, com.inmobi.media.K
    public void a(int i, Ba renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        L4 l4 = this.j;
        if (l4 != null) {
            String str = this.M;
            ((M4) l4).a(str, AbstractC3563t1.a(str, "TAG", "loadPodAd ", this));
        }
        if (B().contains(Integer.valueOf(i)) && i > this.g.indexOf(renderView)) {
            g(i);
            Handler handlerD = D();
            if (handlerD != null) {
                handlerD.post(new Runnable() { // from class: com.inmobi.media.w1$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        C3605w1.c(this.f$0);
                    }
                });
                return;
            }
            return;
        }
        L4 l5 = this.j;
        if (l5 != null) {
            String TAG = this.M;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l5).a(TAG, "No more ads present in pod adSet or current adSet is not pod adSet");
        }
        ArrayList arrayList = this.g;
        Ba ba = (Ba) arrayList.get(arrayList.indexOf(renderView));
        if (ba != null) {
            ba.a(false);
        }
    }

    @Override // com.inmobi.media.C0
    public void g() {
        this.Q.f3470a = false;
        super.g();
    }

    @Override // com.inmobi.media.Da
    public synchronized void e(Ba renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        L4 l4 = this.j;
        if (l4 != null) {
            String str = this.M;
            ((M4) l4).a(str, AbstractC3563t1.a(str, "TAG", "onAdScreenDisplayed ", this));
        }
        super.e(renderView);
        Handler handlerD = D();
        if (handlerD != null) {
            handlerD.post(new Runnable() { // from class: com.inmobi.media.w1$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    C3605w1.e(this.f$0);
                }
            });
        }
    }

    public static final void d(C3605w1 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            if (this$0.Q() == 7) {
                int i = this$0.P - 1;
                this$0.P = i;
                if (i == 0) {
                    this$0.d((byte) 6);
                    AbstractC3520q0 abstractC3520q0R = this$0.r();
                    if (abstractC3520q0R != null) {
                        abstractC3520q0R.b();
                    }
                }
            }
        } catch (Exception e) {
            L4 l4 = this$0.j;
            if (l4 != null) {
                String str = this$0.M;
                ((M4) l4).b(str, ld.a(e, O5.a(str, "TAG", "BannerAdUnit.onAdScreenDismissed threw unexpected error: ")));
            }
        }
    }

    @Override // com.inmobi.media.C0
    public final void b(Ba ba, short s) {
        L4 l4 = this.j;
        if (l4 != null) {
            String str = this.M;
            ((M4) l4).a(str, AbstractC3563t1.a(str, "TAG", "handleRenderViewSignaledAdFailed ", this));
        }
        super.b(ba, s);
        if (b0()) {
            int iIndexOf = this.g.indexOf(ba);
            C0.a(this, iIndexOf, false, 2, null);
            if (iIndexOf > 0 && Q() == 6) {
                b((byte) 1);
                Ba ba2 = (Ba) this.g.get(A());
                if (ba2 != null) {
                    ba2.a(false);
                }
            }
        }
        if (Q() == 2) {
            L4 l5 = this.j;
            if (l5 != null) {
                ((M4) l5).c(this.N, "Failed to load the Banner markup in the WebView for placement id: " + I());
            }
            b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, s);
        }
    }

    @Override // com.inmobi.media.C0, com.inmobi.media.K
    public void a(final int i, final Ba renderView, Context context) {
        Ba ba;
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        L4 l4 = this.j;
        if (l4 != null) {
            String TAG = this.M;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "showPodAdAtIndex " + this + " index - " + i);
        }
        if (!b0()) {
            L4 l5 = this.j;
            if (l5 != null) {
                String TAG2 = this.M;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((M4) l5).b(TAG2, "Cannot show an pod ad as isPod is not set.");
            }
            ArrayList arrayList = this.g;
            Ba ba2 = (Ba) arrayList.get(arrayList.indexOf(renderView));
            if (ba2 != null) {
                ba2.b(false);
                return;
            }
            return;
        }
        L4 l6 = this.j;
        if (l6 != null) {
            String str = this.M;
            ((M4) l6).c(str, AbstractC3563t1.a(str, "TAG", "isInValidShowPodIndex ", this));
        }
        if (B().contains(Integer.valueOf(i)) && i > this.g.indexOf(renderView) && this.g.get(i) != null && ((ba = (Ba) this.g.get(i)) == null || ba.p0)) {
            super.a(i, renderView, context);
            Handler handlerD = D();
            if (handlerD != null) {
                handlerD.post(new Runnable() { // from class: com.inmobi.media.w1$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        C3605w1.a(this.f$0, renderView, i);
                    }
                });
                return;
            }
            return;
        }
        L4 l7 = this.j;
        if (l7 != null) {
            String TAG3 = this.M;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            ((M4) l7).b(TAG3, "Cannot show an pod ad with invalid index passed");
        }
        ArrayList arrayList2 = this.g;
        Ba ba3 = (Ba) arrayList2.get(arrayList2.indexOf(renderView));
        if (ba3 != null) {
            ba3.b(false);
        }
    }

    public final void e(String str) {
        L4 l4 = this.j;
        if (l4 != null) {
            String str2 = this.M;
            ((M4) l4).c(str2, AbstractC3563t1.a(str2, "TAG", "setAdSize ", this));
        }
        J jI = I();
        Intrinsics.checkNotNull(str);
        jI.a(str);
    }

    @Override // com.inmobi.media.Da
    public void a(EnumC3479n1 audioStatusInternal) {
        Intrinsics.checkNotNullParameter(audioStatusInternal, "audioStatusInternal");
        AbstractC3520q0 abstractC3520q0R = r();
        if (abstractC3520q0R != null) {
            abstractC3520q0R.a(audioStatusInternal);
        }
        C3619x1 c3619x1 = this.Q;
        c3619x1.getClass();
        Intrinsics.checkNotNullParameter(audioStatusInternal, "audioStatusInternal");
        if (!c3619x1.f3470a && audioStatusInternal == EnumC3479n1.e) {
            c3619x1.f3470a = true;
            H4 h4 = H4.c;
            h4.f3037a = System.currentTimeMillis();
            h4.b++;
        }
    }

    @Override // com.inmobi.media.Da
    public void a(boolean z) {
        H4 h4 = H4.c;
        Context contextD = C3517pb.d();
        if (contextD == null) {
            return;
        }
        ConcurrentHashMap concurrentHashMap = K5.b;
        K5 k5A = J5.a(contextD, "banner_audio_pref_file");
        Intrinsics.checkNotNullParameter("user_mute_count", "key");
        int i = k5A.f3112a.getInt("user_mute_count", 0);
        k5A.a("user_mute_count", z ? Math.max(0, i - 1) : i + 1);
    }

    @Override // com.inmobi.media.C0, com.inmobi.media.Da
    public void a(Ba renderView, boolean z) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        super.a(renderView, z);
        byte bQ = Q();
        short s = 2227;
        if (bQ != 4 && bQ != 6) {
            if (bQ == 7) {
                if (Q() == 7) {
                    s = z ? (short) 2224 : (short) 2223;
                }
                renderView.a(z, s);
                return;
            }
            return;
        }
        byte bQ2 = Q();
        if (bQ2 == 4) {
            s = z ? (short) 2220 : (short) 2219;
        } else if (bQ2 == 6) {
            s = z ? (short) 2222 : (short) 2221;
        }
        m0();
        renderView.a(z, s);
    }
}
