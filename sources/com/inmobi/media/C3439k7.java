package com.inmobi.media;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.pubmatic.sdk.common.log.POBLogConstants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.k7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3439k7 extends C0 {
    public static final /* synthetic */ int P = 0;
    public WeakReference M;
    public boolean N;
    public int O;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3439k7(Context context, J placement, C3342d8 c3342d8) {
        super(context, placement, c3342d8);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(placement, "placement");
        Intrinsics.checkNotNullExpressionValue("k7", "TAG");
        placement.l();
        a(context, placement, c3342d8);
    }

    public final void C0() {
        try {
            super.g();
        } catch (Exception e) {
            L4 l4 = this.j;
            if (l4 != null) {
                ((M4) l4).b("k7", ld.a(e, O5.a("k7", "TAG", "SDK encountered unexpected error in destroying native ad unit; ")));
            }
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
        }
    }

    public final void D0() {
        L4 l4 = this.j;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("k7", "TAG");
            ((M4) l4).a("k7", "renderAdPostInternetCheck");
        }
        k0();
        try {
            if (!o0()) {
                E0 e0S = s();
                e0S.getClass();
                e0S.g = SystemClock.elapsedRealtime();
                d0();
                return;
            }
            L4 l5 = this.j;
            if (l5 != null) {
                Intrinsics.checkNotNullExpressionValue("k7", "TAG");
                ((M4) l5).b("k7", "render ad is blocked");
            }
        } catch (IllegalStateException e) {
            L4 l6 = this.j;
            if (l6 != null) {
                Intrinsics.checkNotNullExpressionValue("k7", "TAG");
                ((M4) l6).a("k7", "Exception while loading ad.", e);
            }
            b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, (short) 2134);
        }
    }

    @Override // com.inmobi.media.C0
    public final byte J() {
        return (byte) 0;
    }

    @Override // com.inmobi.media.C0, com.inmobi.media.K
    public final void a(int i, Ba renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
    }

    @Override // com.inmobi.media.C0, com.inmobi.media.K
    public final void b() {
    }

    @Override // com.inmobi.media.C0
    public final void b(AbstractC3520q0 abstractC3520q0) {
        L4 l4 = this.j;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("k7", "TAG");
            ((M4) l4).c("k7", "handleAdScreenDisplayed");
        }
        if (Q() == 4) {
            L4 l5 = this.j;
            if (l5 != null) {
                Intrinsics.checkNotNullExpressionValue("k7", "TAG");
                ((M4) l5).d("k7", "AdUnit " + this + " state change - RENDERED");
            }
            d((byte) 6);
        } else if (Q() == 6) {
            this.O++;
        }
        L4 l6 = this.j;
        if (l6 != null) {
            ((M4) l6).a("InMobi", "Successfully displayed fullscreen for placement id: " + I());
        }
        if (this.O == 0) {
            if (abstractC3520q0 != null) {
                L4 l7 = this.j;
                if (l7 != null) {
                    Intrinsics.checkNotNullExpressionValue("k7", "TAG");
                    ((M4) l7).a("k7", "callback - onAdDisplayed");
                }
                d(abstractC3520q0);
                return;
            }
            L4 l8 = this.j;
            if (l8 != null) {
                Intrinsics.checkNotNullExpressionValue("k7", "TAG");
                ((M4) l8).b("k7", "listener is null. cannot give AdDisplayed callback");
            }
        }
    }

    @Override // com.inmobi.media.C0
    public final void c0() {
        if (Z()) {
            L4 l4 = this.j;
            if (l4 != null) {
                Intrinsics.checkNotNullExpressionValue("k7", "TAG");
                ((M4) l4).b("k7", "Ad unit is already destroyed! Returning ...");
                return;
            }
            return;
        }
        AbstractC3520q0 abstractC3520q0R = r();
        if (f0()) {
            L4 l5 = this.j;
            if (l5 != null) {
                Intrinsics.checkNotNullExpressionValue("k7", "TAG");
                ((M4) l5).b("k7", "Some of the dependency libraries for InMobiNative not found");
            }
            if (abstractC3520q0R != null) {
                abstractC3520q0R.a(this, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.MISSING_REQUIRED_DEPENDENCIES));
                return;
            }
            return;
        }
        if (1 == Q() || 2 == Q()) {
            L4 l6 = this.j;
            if (l6 != null) {
                Intrinsics.checkNotNullExpressionValue("k7", "TAG");
                ((M4) l6).b("k7", "An ad load is already in progress");
                return;
            }
            return;
        }
        L4 l7 = this.j;
        if (l7 != null) {
            ((M4) l7).a("k7", O5.a("k7", "TAG", "Fetching a Native ad for placement id: ").append(I()).toString());
        }
        if (4 == Q()) {
            if (!W()) {
                L4 l8 = this.j;
                if (l8 != null) {
                    Intrinsics.checkNotNullExpressionValue("k7", "TAG");
                    ((M4) l8).a("k7", "An ad is ready with the ad unit. Signaling ad load success ...");
                }
                if (abstractC3520q0R != null) {
                    Context contextT = t();
                    L4 l9 = this.j;
                    if (l9 != null) {
                        Intrinsics.checkNotNullExpressionValue("k7", "TAG");
                        ((M4) l9).c("k7", "setContainerContext");
                    }
                    r rVarK = k();
                    if (rVarK instanceof C3313b7) {
                        ((C3313b7) rVarK).a(contextT);
                    }
                    L4 l10 = this.j;
                    if (l10 != null) {
                        Intrinsics.checkNotNullExpressionValue("k7", "TAG");
                        ((M4) l10).a("k7", "callback - onFetchSuccess");
                    }
                    L4 l11 = this.j;
                    if (l11 != null) {
                        Intrinsics.checkNotNullExpressionValue("k7", "TAG");
                        ((M4) l11).a("k7", "callback - onLoadSuccess");
                    }
                    e(abstractC3520q0R);
                    f(abstractC3520q0R);
                    return;
                }
                return;
            }
            L4 l12 = this.j;
            if (l12 != null) {
                Intrinsics.checkNotNullExpressionValue("k7", "TAG");
                ((M4) l12).b("k7", "ad is expired - destroy");
            }
            C0();
        }
        e0();
        super.c0();
    }

    @Override // com.inmobi.media.C0
    public final void j0() {
        if (p0()) {
            L4 l4 = this.j;
            if (l4 != null) {
                Intrinsics.checkNotNullExpressionValue("k7", "TAG");
                ((M4) l4).a("k7", "renderAd without internet check");
            }
            D0();
            return;
        }
        L4 l5 = this.j;
        if (l5 != null) {
            Intrinsics.checkNotNullExpressionValue("k7", "TAG");
            ((M4) l5).a("k7", "renderAd");
        }
        a(new C3411i7(this), new C3425j7(this));
    }

    @Override // com.inmobi.media.C0
    public final HashMap o() {
        HashMap map = new HashMap();
        map.put("a-parentViewWidth", String.valueOf(AbstractC3565t3.d().f3441a));
        map.put("a-productVersion", "NS-1.0.0-20160411");
        map.put("trackerType", "url_ping");
        return map;
    }

    @Override // com.inmobi.media.C0
    public final String q() {
        return "native";
    }

    @Override // com.inmobi.media.C0
    public final void r0() {
        L4 l4 = this.j;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("k7", "TAG");
            ((M4) l4).c("k7", "signalSuccess");
        }
        C3575u c3575uV = v();
        int iHashCode = hashCode();
        M7 m7 = new M7(this);
        c3575uV.getClass();
        C3575u.a(iHashCode, m7);
    }

    @Override // com.inmobi.media.C0
    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.a(context);
        L4 l4 = this.j;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("k7", "TAG");
            ((M4) l4).c("k7", "setContainerContext");
        }
        r rVarK = k();
        if (rVarK instanceof C3313b7) {
            ((C3313b7) rVarK).a(context);
        }
    }

    public final View a(View view, ViewGroup parent, int i) {
        View view2;
        Intrinsics.checkNotNullParameter(parent, "parent");
        L4 l4 = this.j;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("k7", "TAG");
            ((M4) l4).c("k7", "getAdView");
        }
        View viewA = null;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            if (!X3.f3234a.a()) {
                C0();
                L4 l5 = this.j;
                if (l5 != null) {
                    Intrinsics.checkNotNullExpressionValue("k7", "TAG");
                    ((M4) l5).b("k7", "dropping because of GDPR");
                }
                return null;
            }
            if (W()) {
                L4 l6 = this.j;
                if (l6 != null) {
                    Intrinsics.checkNotNullExpressionValue("k7", "TAG");
                    ((M4) l6).a("k7", POBLogConstants.MSG_AD_EXPIRED_ERROR);
                }
                C0();
                return null;
            }
            if (Q() != 4 && Q() != 6) {
                L4 l7 = this.j;
                if (l7 != null) {
                    Intrinsics.checkNotNullExpressionValue("k7", "TAG");
                    ((M4) l7).b("k7", "Ad Load is not complete. Please wait for the Ad to be in a ready state before calling getPrimaryView().");
                }
                AbstractC3498o6.a((byte) 1, "InMobi", "Ad Load is not complete. Please wait for the Ad to be in a ready state before calling getPrimaryView().");
                L4 l8 = this.j;
                if (l8 != null) {
                    Intrinsics.checkNotNullExpressionValue("k7", "TAG");
                    ((M4) l8).b("k7", "Ad Load is not complete");
                }
                WeakReference weakReference = this.M;
                if (weakReference == null || (view2 = (View) weakReference.get()) == null) {
                    return null;
                }
                View view3 = new View(C3517pb.d());
                view3.setLayoutParams(view2.getLayoutParams());
                return view3;
            }
            C3313b7 c3313b7G = G();
            if (c3313b7G != null) {
                boolean z = this.N;
                L4 l9 = c3313b7G.j;
                if (l9 != null) {
                    String TAG = c3313b7G.m;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((M4) l9).c(TAG, "showOnLockScreen - " + z);
                }
                c3313b7G.D = z;
                c3313b7G.B = i;
                final Tc viewableAd = c3313b7G.getViewableAd();
                viewA = viewableAd != null ? viewableAd.a(view, parent, true) : null;
                this.M = new WeakReference(viewA);
                Handler handlerD = D();
                if (handlerD != null) {
                    handlerD.post(new Runnable() { // from class: com.inmobi.media.k7$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            C3439k7.a(this.f$0, viewableAd);
                        }
                    });
                }
            }
            return viewA;
        }
        L4 l10 = this.j;
        if (l10 != null) {
            Intrinsics.checkNotNullExpressionValue("k7", "TAG");
            ((M4) l10).b("k7", "getPrimaryView called on background thread");
        }
        b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.CALLED_FROM_WRONG_THREAD), false, (short) 2150);
        return null;
    }

    public static final void a(C3439k7 this$0, Tc tc) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        L4 l4 = this$0.j;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("k7", "TAG");
            ((M4) l4).a("k7", "start tracking for impression");
        }
        if (tc != null) {
            tc.a((HashMap) null);
        }
    }

    @Override // com.inmobi.media.C0
    public final void a(C3418j0 adSet) {
        Intrinsics.checkNotNullParameter(adSet, "adSet");
        L4 l4 = this.j;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("k7", "TAG");
            ((M4) l4).c("k7", "handleAdFetchSuccessful");
        }
        if (Q() == 1) {
            e(adSet);
        }
        if (!Intrinsics.areEqual("html", E()) && !Intrinsics.areEqual("htmlUrl", E()) && !Intrinsics.areEqual("unknown", E())) {
            super.a(adSet);
            return;
        }
        a(I(), new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), (short) 57);
        L4 l5 = this.j;
        if (l5 != null) {
            Intrinsics.checkNotNullExpressionValue("k7", "TAG");
            ((M4) l5).b("k7", "invalid markup. fetch failed");
        }
    }

    @Override // com.inmobi.media.C0
    public final void a(AbstractC3520q0 abstractC3520q0) {
        L4 l4 = this.j;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("k7", "TAG");
            ((M4) l4).c("k7", "handleAdScreenDismissed");
        }
        if (Q() == 6) {
            int i = this.O;
            if (i > 0) {
                this.O = i - 1;
            } else {
                L4 l5 = this.j;
                if (l5 != null) {
                    Intrinsics.checkNotNullExpressionValue("k7", "TAG");
                    ((M4) l5).d("k7", "AdUnit " + this + " state - READY");
                }
                d((byte) 4);
            }
        }
        L4 l6 = this.j;
        if (l6 != null) {
            ((M4) l6).a("InMobi", "Successfully dismissed fullscreen for placement id: " + I());
        }
        if (this.O == 0 && Q() == 4) {
            if (abstractC3520q0 != null) {
                L4 l7 = this.j;
                if (l7 != null) {
                    Intrinsics.checkNotNullExpressionValue("k7", "TAG");
                    ((M4) l7).a("k7", "callback - onAdDismissed");
                }
                abstractC3520q0.b();
            } else {
                L4 l8 = this.j;
                if (l8 != null) {
                    Intrinsics.checkNotNullExpressionValue("k7", "TAG");
                    ((M4) l8).b("k7", "Listener was garbage collected. Unable to give callback");
                }
            }
            L4 l9 = this.j;
            if (l9 != null) {
                ((M4) l9).a();
            }
        }
    }

    @Override // com.inmobi.media.C0
    public final void a(J placement, boolean z) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        L4 l4 = this.j;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("k7", "TAG");
            ((M4) l4).c("k7", "handleAssetAvailabilityChanged");
        }
        super.a(placement, z);
        if (!z) {
            if (Intrinsics.areEqual(I(), placement)) {
                if (2 == Q() || 4 == Q()) {
                    d((byte) 0);
                    L4 l5 = this.j;
                    if (l5 != null) {
                        Intrinsics.checkNotNullExpressionValue("k7", "TAG");
                        ((M4) l5).d("k7", "AdUnit " + this + " state - CREATED");
                    }
                    AbstractC3520q0 abstractC3520q0R = r();
                    if (abstractC3520q0R != null) {
                        abstractC3520q0R.a(this, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.AD_NO_LONGER_AVAILABLE));
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (!Intrinsics.areEqual(I(), placement) || 2 != Q() || r() == null || t() == null) {
            return;
        }
        if (a0()) {
            c(true);
            f();
        } else {
            r0();
        }
    }

    @Override // com.inmobi.media.C0
    public final void a(boolean z, InMobiAdRequestStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        L4 l4 = this.j;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("k7", "TAG");
            ((M4) l4).c("k7", "onDidParseAfterFetch");
        }
        super.a(z, status);
        if (Q() == 2) {
            AbstractC3520q0 abstractC3520q0R = r();
            if (abstractC3520q0R != null) {
                L4 l5 = this.j;
                if (l5 != null) {
                    Intrinsics.checkNotNullExpressionValue("k7", "TAG");
                    ((M4) l5).a("k7", "callback - onFetchSuccess");
                }
                e(abstractC3520q0R);
                return;
            }
            return;
        }
        L4 l6 = this.j;
        if (l6 != null) {
            Intrinsics.checkNotNullExpressionValue("k7", "TAG");
            ((M4) l6).b("k7", "invalid state - ignore parse callback");
        }
    }

    @Override // com.inmobi.media.C0, com.inmobi.media.Pc
    public final void a(C3389h ad, boolean z, short s) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        L4 l4 = this.j;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("k7", "TAG");
            ((M4) l4).c("k7", "onVastProcessCompleted");
        }
        try {
            if (!z) {
                L4 l5 = this.j;
                if (l5 != null) {
                    Intrinsics.checkNotNullExpressionValue("k7", "TAG");
                    ((M4) l5).b("k7", "VAST processing failed - " + ((int) s));
                }
                b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, s);
                return;
            }
            try {
                super.a(ad, z, s);
            } catch (IllegalStateException e) {
                L4 l6 = this.j;
                if (l6 != null) {
                    Intrinsics.checkNotNullExpressionValue("k7", "TAG");
                    ((M4) l6).b("k7", "Exception while onVastProcessCompleted : " + e.getMessage());
                }
            }
            C3389h c3389hM = m();
            if (c3389hM == null) {
                L4 l7 = this.j;
                if (l7 != null) {
                    Intrinsics.checkNotNullExpressionValue("k7", "TAG");
                    ((M4) l7).b("k7", "current ad is null. failing");
                }
                b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, (short) 55);
                return;
            }
            if (T() == 0) {
                if (!c3389hM.G()) {
                    L4 l8 = this.j;
                    if (l8 != null) {
                        Intrinsics.checkNotNullExpressionValue("k7", "TAG");
                        ((M4) l8).c("k7", "start OMID session for HTML ad");
                    }
                    a(true, (Ba) null);
                }
            } else {
                L4 l9 = this.j;
                if (l9 != null) {
                    Intrinsics.checkNotNullExpressionValue("k7", "TAG");
                    ((M4) l9).c("k7", "start OMID session for current AD");
                }
                a(c3389hM);
            }
            if (c3389hM.G()) {
                b(true);
                L4 l10 = this.j;
                if (l10 != null) {
                    Intrinsics.checkNotNullExpressionValue("k7", "TAG");
                    ((M4) l10).c("k7", "handleInterActive");
                }
                V();
            }
        } catch (Exception e2) {
            L4 l11 = this.j;
            if (l11 != null) {
                Intrinsics.checkNotNullExpressionValue("k7", "TAG");
                ((M4) l11).a("k7", "Exception while loading ad.", e2);
            }
            b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, (short) 13);
        }
    }
}
