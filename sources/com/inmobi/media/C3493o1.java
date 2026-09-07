package com.inmobi.media;

import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.inmobi.ads.AdMetaInfo;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiAudio;
import com.inmobi.ads.controllers.PublisherCallbacks;
import com.json.nu;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.o1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3493o1 extends AbstractC3574tc {
    public C3419j1 o;
    public C3419j1 p;
    public C3419j1 q;
    public C3419j1 r;

    public C3493o1(InMobiAudio.a callbacks) {
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        b(callbacks);
    }

    @Override // com.inmobi.media.AbstractC3574tc
    public final void a(byte[] bArr, PublisherCallbacks callbacks) {
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
    }

    @Override // com.inmobi.media.AbstractC3574tc, com.inmobi.media.AbstractC3520q0
    public final void b(final AdMetaInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        L4 l4P = p();
        if (l4P != null) {
            String str = AbstractC3507p1.f3395a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((M4) l4P).c(str, "onAdFetchSuccess " + this);
        }
        C3419j1 c3419j1 = this.r;
        if ((c3419j1 != null ? c3419j1.m() : null) == null) {
            L4 l4P2 = p();
            if (l4P2 != null) {
                String str2 = AbstractC3507p1.f3395a;
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
                ((M4) l4P2).b(str2, "adObject is null, fetch failed");
            }
            a((C0) null, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
            return;
        }
        L4 l4P3 = p();
        if (l4P3 != null) {
            String str3 = AbstractC3507p1.f3395a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((M4) l4P3).a(str3, "Ad fetch successful, calling loadIntoView()");
        }
        super.b(info);
        s().post(new Runnable() { // from class: com.inmobi.media.o1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C3493o1.a(this.f$0, info);
            }
        });
    }

    @Override // com.inmobi.media.AbstractC3574tc, com.inmobi.media.AbstractC3520q0
    public final void c(final AdMetaInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        L4 l4P = p();
        if (l4P != null) {
            String str = AbstractC3507p1.f3395a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((M4) l4P).c(str, "onAdLoadSucceeded " + this);
        }
        super.c(info);
        a((byte) 0);
        L4 l4P2 = p();
        if (l4P2 != null) {
            String str2 = AbstractC3507p1.f3395a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4P2).d(str2, "AdManager state - CREATED");
        }
        L4 l4P3 = p();
        if (l4P3 != null) {
            String str3 = AbstractC3507p1.f3395a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((M4) l4P3).a(str3, "Ad load successful, providing callback");
        }
        s().post(new Runnable() { // from class: com.inmobi.media.o1$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                C3493o1.b(this.f$0, info);
            }
        });
    }

    @Override // com.inmobi.media.AbstractC3520q0
    public final void d() {
        L4 l4P = p();
        if (l4P != null) {
            String str = AbstractC3507p1.f3395a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((M4) l4P).a(str, "onAdShowFailed " + this);
        }
        s().post(new Runnable() { // from class: com.inmobi.media.o1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C3493o1.a(this.f$0);
            }
        });
    }

    @Override // com.inmobi.media.AbstractC3574tc
    public final C0 j() {
        L4 l4P = p();
        if (l4P != null) {
            String str = AbstractC3507p1.f3395a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((M4) l4P).c(str, "shouldUseForegroundUnit " + this);
        }
        C3419j1 c3419j1 = this.q;
        Byte bValueOf = c3419j1 != null ? Byte.valueOf(c3419j1.Q()) : null;
        L4 l4P2 = p();
        if (l4P2 != null) {
            String str2 = AbstractC3507p1.f3395a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4P2).d(str2, "State - " + bValueOf);
        }
        return ((bValueOf == null || bValueOf.byteValue() != 4) && (bValueOf == null || bValueOf.byteValue() != 7) && (bValueOf == null || bValueOf.byteValue() != 6)) ? this.r : this.q;
    }

    @Override // com.inmobi.media.AbstractC3574tc
    public final void w() {
        L4 l4P = p();
        if (l4P != null) {
            String str = AbstractC3507p1.f3395a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((M4) l4P).a(str, "submitAdLoadCalled " + this);
        }
        C3419j1 c3419j1 = this.r;
        if (c3419j1 != null) {
            c3419j1.t0();
        }
    }

    public final void x() {
        L4 l4P = p();
        if (l4P != null) {
            String str = AbstractC3507p1.f3395a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((M4) l4P).c(str, "registerLifeCycleCallbacks " + this);
        }
        C3419j1 c3419j1 = this.o;
        if (c3419j1 != null) {
            c3419j1.G0();
        }
        C3419j1 c3419j2 = this.p;
        if (c3419j2 != null) {
            c3419j2.G0();
        }
    }

    public final void y() {
        L4 l4P = p();
        if (l4P != null) {
            String str = AbstractC3507p1.f3395a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((M4) l4P).a(str, "loadIntoView " + this);
        }
        C3419j1 c3419j1 = this.r;
        if (c3419j1 == null) {
            throw new IllegalStateException(AbstractC3574tc.m);
        }
        if (c3419j1 == null || !a("InMobi", c3419j1.I().toString())) {
            return;
        }
        a((byte) 8);
        L4 l4P2 = p();
        if (l4P2 != null) {
            String str2 = AbstractC3507p1.f3395a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4P2).d(str2, "AdManager state - LOADING_INTO_VIEW");
        }
        c3419j1.j0();
    }

    public static final void a(C3493o1 this$0, AdMetaInfo info) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        PublisherCallbacks publisherCallbacksL = this$0.l();
        if (publisherCallbacksL != null) {
            publisherCallbacksL.onAdFetchSuccessful(info);
        }
    }

    @Override // com.inmobi.media.AbstractC3574tc, com.inmobi.media.AbstractC3520q0
    public final void a(C0 c0, InMobiAdRequestStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        L4 l4P = p();
        if (l4P != null) {
            String str = AbstractC3507p1.f3395a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((M4) l4P).b(str, nu.b);
        }
        L4 l4P2 = p();
        if (l4P2 != null) {
            ((M4) l4P2).a();
        }
    }

    public static final void a(C3493o1 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        L4 l4P = this$0.p();
        if (l4P != null) {
            String str = AbstractC3507p1.f3395a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((M4) l4P).a(str, "callback - onAdDisplayFailed");
        }
        PublisherCallbacks publisherCallbacksL = this$0.l();
        if (publisherCallbacksL != null) {
            publisherCallbacksL.onAdDisplayFailed();
        }
        L4 l4P2 = this$0.p();
        if (l4P2 != null) {
            ((M4) l4P2).a();
        }
    }

    @Override // com.inmobi.media.AbstractC3574tc, com.inmobi.media.AbstractC3520q0
    public final void a(AdMetaInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        L4 l4P = p();
        if (l4P != null) {
            String str = AbstractC3507p1.f3395a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((M4) l4P).a(str, "onAdDisplayed");
        }
        super.a(info);
        C0 c0J = j();
        if (c0J != null) {
            c0J.x0();
        }
    }

    public final void a(final InMobiAudio audio) {
        Intrinsics.checkNotNullParameter(audio, "audio");
        L4 l4P = p();
        if (l4P != null) {
            String str = AbstractC3507p1.f3395a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((M4) l4P).a(str, "show called");
        }
        try {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                a((RelativeLayout) audio);
            } else {
                s().post(new Runnable() { // from class: com.inmobi.media.o1$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        C3493o1.a(this.f$0, audio);
                    }
                });
            }
        } catch (Exception e) {
            C3419j1 c3419j1 = this.r;
            if (c3419j1 != null) {
                c3419j1.d((short) 26);
            }
            String str2 = AbstractC3507p1.f3395a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            AbstractC3498o6.a((byte) 1, str2, "Unable to show ad; SDK encountered an unexpected error");
            L4 l4P2 = p();
            if (l4P2 != null) {
                ((M4) l4P2).b(str2, ld.a(e, O5.a(str2, "access$getTAG$p(...)", "Show failed with unexpected error: ")));
            }
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
        }
    }

    public static final void b(C3493o1 this$0, AdMetaInfo info) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        PublisherCallbacks publisherCallbacksL = this$0.l();
        if (publisherCallbacksL != null) {
            publisherCallbacksL.onAdLoadSucceeded(info);
        }
    }

    @Override // com.inmobi.media.AbstractC3574tc, com.inmobi.media.AbstractC3520q0
    public final void b() {
        L4 l4P = p();
        if (l4P != null) {
            String str = AbstractC3507p1.f3395a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((M4) l4P).a(str, "onAdDismissed " + this);
        }
        a((byte) 0);
        L4 l4P2 = p();
        if (l4P2 != null) {
            String str2 = AbstractC3507p1.f3395a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((M4) l4P2).d(str2, "AdManager state - CREATED");
        }
        L4 l4P3 = p();
        if (l4P3 != null) {
            ((M4) l4P3).a();
        }
        super.b();
    }

    public final void b(String adSize) {
        Intrinsics.checkNotNullParameter(adSize, "adSize");
        L4 l4P = p();
        if (l4P != null) {
            String str = AbstractC3507p1.f3395a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((M4) l4P).a(str, "load 1 " + this);
        }
        C3419j1 c3419j1 = this.r;
        if (c3419j1 != null && a("InMobi", c3419j1.I().toString(), l()) && c3419j1.e((byte) 1)) {
            a((byte) 1);
            L4 l4P2 = p();
            if (l4P2 != null) {
                String str2 = AbstractC3507p1.f3395a;
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
                ((M4) l4P2).d(str2, "AdManager state - LOADING");
            }
            d(null);
            c3419j1.e(adSize);
            c3419j1.d(false);
        }
    }

    public static final void a(C3493o1 this$0, RelativeLayout audio) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(audio, "$audio");
        this$0.a(audio);
    }

    public final void a(RelativeLayout relativeLayout) {
        r rVarK;
        J jI;
        L4 l4P = p();
        if (l4P != null) {
            String str = AbstractC3507p1.f3395a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((M4) l4P).a(str, "showAudioAd");
        }
        C3419j1 c3419j1 = this.q;
        if (c3419j1 != null ? c3419j1.D0() : false) {
            String str2 = AbstractC3507p1.f3395a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            AbstractC3498o6.a((byte) 1, str2, "An ad is currently being viewed by the user. Please wait for the user to close the ad before showing another ad.");
            L4 l4P2 = p();
            if (l4P2 != null) {
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
                ((M4) l4P2).b(str2, "ad is active");
            }
            C3419j1 c3419j2 = this.r;
            if (c3419j2 != null) {
                c3419j2.d((short) 15);
                return;
            }
            return;
        }
        C3419j1 c3419j3 = this.r;
        if (c3419j3 != null) {
            L4 l4 = c3419j3.j;
            if (l4 != null) {
                String strE = C0.e();
                Intrinsics.checkNotNullExpressionValue(strE, "<get-TAG>(...)");
                ((M4) l4).c(strE, "canProceedToShow");
            }
            if (c3419j3.W()) {
                String strE2 = C0.e();
                Intrinsics.checkNotNullExpressionValue(strE2, "<get-TAG>(...)");
                AbstractC3498o6.a((byte) 1, strE2, "Ad Show has failed because current ad is expired. Please call load() again.");
                L4 l5 = c3419j3.j;
                if (l5 != null) {
                    String strE3 = C0.e();
                    Intrinsics.checkNotNullExpressionValue(strE3, "<get-TAG>(...)");
                    ((M4) l5).b(strE3, "ad is expired");
                }
                L4 l6 = c3419j3.j;
                if (l6 != null) {
                    String strE4 = C0.e();
                    Intrinsics.checkNotNullExpressionValue(strE4, "<get-TAG>(...)");
                    ((M4) l6).d(strE4, "AdUnit " + c3419j3 + " state - CREATED");
                }
                c3419j3.d((byte) 0);
                c3419j3.d((short) 2153);
                return;
            }
            byte bQ = c3419j3.Q();
            if (bQ == 1 || bQ == 2) {
                AbstractC3498o6.a((byte) 1, "InMobi", "Ad Load is not complete. Please wait for the Ad to be in a ready state before calling show.");
                L4 l7 = c3419j3.j;
                if (l7 != null) {
                    String strE5 = C0.e();
                    Intrinsics.checkNotNullExpressionValue(strE5, "<get-TAG>(...)");
                    ((M4) l7).b(strE5, "ad is not ready");
                }
                L4 l8 = c3419j3.j;
                if (l8 != null) {
                    String strE6 = C0.e();
                    Intrinsics.checkNotNullExpressionValue(strE6, "<get-TAG>(...)");
                    ((M4) l8).a(strE6, "callback - onShowFailure");
                }
                c3419j3.d((short) 2152);
                return;
            }
            if (bQ == 3) {
                AbstractC3498o6.a((byte) 1, "InMobi", "Ad Load has Failed. Please call load() again.");
                c3419j3.d((short) 0);
                L4 l9 = c3419j3.j;
                if (l9 != null) {
                    String strE7 = C0.e();
                    Intrinsics.checkNotNullExpressionValue(strE7, "<get-TAG>(...)");
                    ((M4) l9).a(strE7, "callback - onShowFailure");
                }
                L4 l10 = c3419j3.j;
                if (l10 != null) {
                    String strE8 = C0.e();
                    Intrinsics.checkNotNullExpressionValue(strE8, "<get-TAG>(...)");
                    ((M4) l10).b(strE8, "ad is failed");
                    return;
                }
                return;
            }
            if (bQ == 0) {
                AbstractC3498o6.a((byte) 1, "InMobi", "Ad Show has Failed. Please call load() before calling show().");
                c3419j3.d((short) 0);
                L4 l11 = c3419j3.j;
                if (l11 != null) {
                    String strE9 = C0.e();
                    Intrinsics.checkNotNullExpressionValue(strE9, "<get-TAG>(...)");
                    ((M4) l11).a(strE9, "callback - onShowFailure");
                }
                L4 l12 = c3419j3.j;
                if (l12 != null) {
                    String strE10 = C0.e();
                    Intrinsics.checkNotNullExpressionValue(strE10, "<get-TAG>(...)");
                    ((M4) l12).b(strE10, "show called before load");
                    return;
                }
                return;
            }
            L4 l4P3 = p();
            if (l4P3 != null) {
                String str3 = AbstractC3507p1.f3395a;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
                ((M4) l4P3).a(str3, "swapAdUnits " + this);
            }
            C3419j1 c3419j4 = this.q;
            if (Intrinsics.areEqual(c3419j4, this.o)) {
                this.q = this.p;
                this.r = this.o;
            } else if (Intrinsics.areEqual(c3419j4, this.p) || c3419j4 == null) {
                this.q = this.o;
                this.r = this.p;
            }
            L4 l4P4 = p();
            if (l4P4 != null) {
                String str4 = AbstractC3507p1.f3395a;
                Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
                ((M4) l4P4).a(str4, "displayAd " + this);
            }
            C3419j1 c3419j5 = this.q;
            if (c3419j5 == null || (rVarK = c3419j5.k()) == null) {
                return;
            }
            Ba ba = (Ba) rVarK;
            Tc viewableAd = ba.getViewableAd();
            C3419j1 c3419j6 = this.q;
            if (c3419j6 != null && (jI = c3419j6.I()) != null && jI.p()) {
                ba.e();
            }
            ViewParent parent = ba.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            View viewD = viewableAd.d();
            viewableAd.a((HashMap) null);
            C3419j1 c3419j7 = this.r;
            if (c3419j7 != null) {
                c3419j7.E0();
            }
            if (viewGroup == null) {
                relativeLayout.addView(viewD, layoutParams);
            } else {
                viewGroup.removeAllViews();
                viewGroup.addView(viewD, layoutParams);
            }
            C3419j1 c3419j8 = this.r;
            if (c3419j8 != null) {
                c3419j8.g();
            }
        }
    }

    @Override // com.inmobi.media.AbstractC3574tc
    public final void a(short s) {
        L4 l4P = p();
        if (l4P != null) {
            String str = AbstractC3507p1.f3395a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((M4) l4P).b(str, "submitAdLoadDroppedAtSDK " + this);
        }
        C3419j1 c3419j1 = this.r;
        if (c3419j1 != null) {
            c3419j1.a(s);
        }
    }
}
