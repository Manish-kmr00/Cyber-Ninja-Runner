package com.inmobi.media;

import android.content.Context;
import com.inmobi.ads.InMobiAdRequestStatus;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.j1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3419j1 extends C3605w1 {
    public final C3449l1 R;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3419j1(Context context, J placement, AbstractC3520q0 abstractC3520q0) {
        super(context, placement, abstractC3520q0);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(placement, "placement");
        this.R = new C3449l1();
    }

    @Override // com.inmobi.media.C3605w1
    public final boolean C0() {
        L4 l4 = this.j;
        if (l4 != null) {
            String strE = C0.e();
            Intrinsics.checkNotNullExpressionValue(strE, "<get-TAG>(...)");
            ((M4) l4).c(strE, "canProceedToLoad");
        }
        if (f0()) {
            L4 l5 = this.j;
            if (l5 != null) {
                String strE2 = C0.e();
                Intrinsics.checkNotNullExpressionValue(strE2, "<get-TAG>(...)");
                ((M4) l5).b(strE2, "Some of the dependency libraries for Banner not found");
            }
            b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.MISSING_REQUIRED_DEPENDENCIES), true, (short) 2007);
            return false;
        }
        if (1 == Q() || 2 == Q()) {
            String strE3 = C0.e();
            Intrinsics.checkNotNullExpressionValue(strE3, "<get-TAG>(...)");
            AbstractC3498o6.a((byte) 1, strE3, "An ad load is already in progress. Please wait for the load to complete before requesting for another ad");
            L4 l6 = this.j;
            if (l6 != null) {
                String strE4 = C0.e();
                Intrinsics.checkNotNullExpressionValue(strE4, "<get-TAG>(...)");
                ((M4) l6).b(strE4, "ad load in progress. ignore load");
            }
            a((short) 53);
            return false;
        }
        if (7 == Q()) {
            b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.AD_ACTIVE), false, (short) 15);
            AbstractC3498o6.a((byte) 1, "InMobi", AbstractC3574tc.j + I().l());
            L4 l7 = this.j;
            if (l7 != null) {
                String strE5 = C0.e();
                Intrinsics.checkNotNullExpressionValue(strE5, "<get-TAG>(...)");
                ((M4) l7).b(strE5, "Ad is active. ignore load");
            }
            return false;
        }
        if (Q() == 4) {
            if (!W()) {
                L4 l8 = this.j;
                if (l8 != null) {
                    String strE6 = C0.e();
                    Intrinsics.checkNotNullExpressionValue(strE6, "<get-TAG>(...)");
                    ((M4) l8).c(strE6, "signalCanShowForStateReady");
                }
                L4 l9 = this.j;
                if (l9 != null) {
                    String strE7 = C0.e();
                    Intrinsics.checkNotNullExpressionValue(strE7, "<get-TAG>(...)");
                    ((M4) l9).a(strE7, "An ad is ready with the ad unit. Signaling ad load success ...");
                }
                AbstractC3520q0 abstractC3520q0R = r();
                if (abstractC3520q0R == null) {
                    AbstractC3498o6.a((byte) 2, "InMobi", "Listener was garbage collected. Unable to give callback");
                    L4 l10 = this.j;
                    if (l10 != null) {
                        String strE8 = C0.e();
                        Intrinsics.checkNotNullExpressionValue(strE8, "<get-TAG>(...)");
                        ((M4) l10).b(strE8, "listener is null. load show callback missed");
                    }
                } else {
                    L4 l11 = this.j;
                    if (l11 != null) {
                        String strE9 = C0.e();
                        Intrinsics.checkNotNullExpressionValue(strE9, "<get-TAG>(...)");
                        ((M4) l11).a(strE9, "callback - onLoadSuccess");
                    }
                    f(abstractC3520q0R);
                }
                return false;
            }
            L4 l12 = this.j;
            if (l12 != null) {
                String strE10 = C0.e();
                Intrinsics.checkNotNullExpressionValue(strE10, "<get-TAG>(...)");
                ((M4) l12).b(strE10, "ad is expired, clearing");
            }
            g();
        }
        e0();
        return true;
    }

    @Override // com.inmobi.media.C3605w1, com.inmobi.media.Da
    public final void a(EnumC3479n1 audioStatusInternal) {
        Intrinsics.checkNotNullParameter(audioStatusInternal, "audioStatusInternal");
        AbstractC3520q0 abstractC3520q0R = r();
        if (abstractC3520q0R != null) {
            abstractC3520q0R.a(audioStatusInternal);
        }
        C3449l1 c3449l1 = this.R;
        c3449l1.getClass();
        Intrinsics.checkNotNullParameter(audioStatusInternal, "audioStatusInternal");
        if (!c3449l1.f3363a && audioStatusInternal == EnumC3479n1.e) {
            c3449l1.f3363a = true;
            D4 d4 = D4.c;
            d4.f3037a = System.currentTimeMillis();
            d4.b++;
        }
    }

    public final void d(short s) {
        L4 l4 = this.j;
        if (l4 != null) {
            String strE = C0.e();
            Intrinsics.checkNotNullExpressionValue(strE, "<get-TAG>(...)");
            ((M4) l4).c(strE, "onShowFailure");
        }
        AbstractC3520q0 abstractC3520q0R = r();
        if (abstractC3520q0R == null) {
            AbstractC3498o6.a((byte) 2, "InMobi", "Listener was garbage collected. Unable to give callback");
            L4 l5 = this.j;
            if (l5 != null) {
                String strE2 = C0.e();
                Intrinsics.checkNotNullExpressionValue(strE2, "<get-TAG>(...)");
                ((M4) l5).b(strE2, "listener is null. show fail callback missed. ");
            }
        } else {
            L4 l6 = this.j;
            if (l6 != null) {
                String strE3 = C0.e();
                Intrinsics.checkNotNullExpressionValue(strE3, "<get-TAG>(...)");
                ((M4) l6).b(strE3, "callback - onAdShowFailed");
            }
            abstractC3520q0R.d();
        }
        if (s != 0) {
            L4 l7 = this.j;
            if (l7 != null) {
                String strE4 = C0.e();
                Intrinsics.checkNotNullExpressionValue(strE4, "<get-TAG>(...)");
                ((M4) l7).b(strE4, "show failed - " + ((int) s));
            }
            c(s);
        }
    }

    @Override // com.inmobi.media.C3605w1, com.inmobi.media.C0, com.inmobi.media.Da
    public final void i(Ba renderView) {
        AbstractC3520q0 abstractC3520q0R;
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        L4 l4 = this.j;
        if (l4 != null) {
            String strE = C0.e();
            Intrinsics.checkNotNullExpressionValue(strE, "<get-TAG>(...)");
            ((M4) l4).c(strE, "onRenderViewVisible");
        }
        if (Q() == 4 && (abstractC3520q0R = r()) != null) {
            L4 l5 = this.j;
            if (l5 != null) {
                String strE2 = C0.e();
                Intrinsics.checkNotNullExpressionValue(strE2, "<get-TAG>(...)");
                ((M4) l5).a(strE2, "callback - onAdDisplayed");
            }
            d(abstractC3520q0R);
        }
        super.i(renderView);
    }

    @Override // com.inmobi.media.C3605w1, com.inmobi.media.C0
    public final String q() {
        return "audio";
    }

    @Override // com.inmobi.media.C3605w1, com.inmobi.media.Da
    public final void a(boolean z) {
        Context contextD = C3517pb.d();
        if (contextD == null) {
            return;
        }
        ConcurrentHashMap concurrentHashMap = K5.b;
        K5 k5A = J5.a(contextD, "audio_pref_file");
        Intrinsics.checkNotNullParameter("user_mute_count", "key");
        int i = k5A.f3112a.getInt("user_mute_count", 0);
        k5A.a("user_mute_count", z ? Math.max(0, i - 1) : i + 1);
    }
}
