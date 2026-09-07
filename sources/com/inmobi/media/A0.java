package com.inmobi.media;

import android.os.Handler;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class A0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0 f3025a;
    public final /* synthetic */ WeakReference b;

    public A0(C0 c0, WeakReference weakReference) {
        this.f3025a = c0;
        this.b = weakReference;
    }

    public static final void b(C0 this$0, WeakReference listenerWeakReference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(listenerWeakReference, "$listenerWeakReference");
        L4 l4 = this$0.j;
        if (l4 != null) {
            String strE = C0.e();
            Intrinsics.checkNotNullExpressionValue(strE, "<get-TAG>(...)");
            ((M4) l4).a(strE, "callback- onAdDisplayed");
        }
        this$0.b((AbstractC3520q0) listenerWeakReference.get());
    }

    public final void a() {
        L4 l4 = this.f3025a.j;
        if (l4 != null) {
            String strE = C0.e();
            ((M4) l4).a(strE, O5.a(strE, "<get-TAG>(...)", "Ad interaction for placement id: ").append(this.f3025a.I()).toString());
        }
        if (this.f3025a.Z()) {
            L4 l5 = this.f3025a.j;
            if (l5 != null) {
                String strE2 = C0.e();
                Intrinsics.checkNotNullExpressionValue(strE2, "<get-TAG>(...)");
                ((M4) l5).b(strE2, "ad unit is destroyed");
                return;
            }
            return;
        }
        AbstractC3520q0 abstractC3520q0 = (AbstractC3520q0) this.b.get();
        if (abstractC3520q0 != null) {
            L4 l6 = this.f3025a.j;
            if (l6 != null) {
                String strE3 = C0.e();
                Intrinsics.checkNotNullExpressionValue(strE3, "<get-TAG>(...)");
                ((M4) l6).a(strE3, "callback - onAdInteraction");
            }
            abstractC3520q0.a(new HashMap());
            return;
        }
        L4 l7 = this.f3025a.j;
        if (l7 != null) {
            String strE4 = C0.e();
            Intrinsics.checkNotNullExpressionValue(strE4, "<get-TAG>(...)");
            ((M4) l7).b(strE4, "Listener was garbage collected.Unable to give callback");
        }
    }

    public final void c() {
        L4 l4 = this.f3025a.j;
        if (l4 != null) {
            String strE = C0.e();
            Intrinsics.checkNotNullExpressionValue(strE, "<get-TAG>(...)");
            ((M4) l4).a(strE, "onAdDisplayFailed native interaction callback");
        }
        if (this.f3025a.Z()) {
            L4 l5 = this.f3025a.j;
            if (l5 != null) {
                String strE2 = C0.e();
                Intrinsics.checkNotNullExpressionValue(strE2, "<get-TAG>(...)");
                ((M4) l5).b(strE2, "callback onAdDisplayFailed failed. already destroyed.");
                return;
            }
            return;
        }
        AbstractC3520q0 abstractC3520q0 = (AbstractC3520q0) this.b.get();
        if (abstractC3520q0 != null) {
            L4 l6 = this.f3025a.j;
            if (l6 != null) {
                String strE3 = C0.e();
                Intrinsics.checkNotNullExpressionValue(strE3, "<get-TAG>(...)");
                ((M4) l6).a(strE3, "callback - onAdShowFailed");
            }
            this.f3025a.a(abstractC3520q0, (short) 91);
            return;
        }
        L4 l7 = this.f3025a.j;
        if (l7 != null) {
            String strE4 = C0.e();
            Intrinsics.checkNotNullExpressionValue(strE4, "<get-TAG>(...)");
            ((M4) l7).b(strE4, "Listener was garbage collected.Unable to give callback");
        }
    }

    public final void d() {
        L4 l4 = this.f3025a.j;
        if (l4 != null) {
            String strE = C0.e();
            Intrinsics.checkNotNullExpressionValue(strE, "<get-TAG>(...)");
            ((M4) l4).c(strE, "onAdDisplay ");
        }
        this.f3025a.b((byte) 4);
        if (this.f3025a.Z()) {
            L4 l5 = this.f3025a.j;
            if (l5 != null) {
                String strE2 = C0.e();
                Intrinsics.checkNotNullExpressionValue(strE2, "<get-TAG>(...)");
                ((M4) l5).b(strE2, "onAdDisplay callback failed. adunit destroyed.");
                return;
            }
            return;
        }
        Handler handlerD = this.f3025a.D();
        if (handlerD != null) {
            final C0 c0 = this.f3025a;
            final WeakReference weakReference = this.b;
            handlerD.post(new Runnable() { // from class: com.inmobi.media.A0$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    A0.b(c0, weakReference);
                }
            });
        }
    }

    public final void e() {
        L4 l4 = this.f3025a.j;
        if (l4 != null) {
            String strE = C0.e();
            Intrinsics.checkNotNullExpressionValue(strE, "<get-TAG>(...)");
            ((M4) l4).c(strE, "onAdFullScreenWillDisplay");
        }
        if (this.f3025a.Z()) {
            L4 l5 = this.f3025a.j;
            if (l5 != null) {
                String strE2 = C0.e();
                Intrinsics.checkNotNullExpressionValue(strE2, "<get-TAG>(...)");
                ((M4) l5).a(strE2, "onAdFullScreenWillDisplay callback failed. adunit destroyed");
                return;
            }
            return;
        }
        AbstractC3520q0 abstractC3520q0 = (AbstractC3520q0) this.b.get();
        if (abstractC3520q0 != null) {
            L4 l6 = this.f3025a.j;
            if (l6 != null) {
                String strE3 = C0.e();
                Intrinsics.checkNotNullExpressionValue(strE3, "<get-TAG>(...)");
                ((M4) l6).a(strE3, "callback - onAdScreenWillDisplay");
            }
            abstractC3520q0.e();
            return;
        }
        L4 l7 = this.f3025a.j;
        if (l7 != null) {
            String strE4 = C0.e();
            Intrinsics.checkNotNullExpressionValue(strE4, "<get-TAG>(...)");
            ((M4) l7).b(strE4, "Listener was garbage collected.Unable to give callback");
        }
    }

    public final void f() {
        L4 l4 = this.f3025a.j;
        if (l4 != null) {
            String strE = C0.e();
            ((M4) l4).a(strE, O5.a(strE, "<get-TAG>(...)", "Successfully impressed ad for placement id: ").append(this.f3025a.I()).toString());
        }
        if (this.f3025a.Z()) {
            L4 l5 = this.f3025a.j;
            if (l5 != null) {
                String strE2 = C0.e();
                Intrinsics.checkNotNullExpressionValue(strE2, "<get-TAG>(...)");
                ((M4) l5).b(strE2, "ad unit is destroyed");
                return;
            }
            return;
        }
        AbstractC3520q0 abstractC3520q0 = (AbstractC3520q0) this.b.get();
        if (abstractC3520q0 != null) {
            L4 l6 = this.f3025a.j;
            if (l6 != null) {
                String strE3 = C0.e();
                Intrinsics.checkNotNullExpressionValue(strE3, "<get-TAG>(...)");
                ((M4) l6).a(strE3, "callback - onAdImpressed");
            }
            abstractC3520q0.c();
            return;
        }
        L4 l7 = this.f3025a.j;
        if (l7 != null) {
            String strE4 = C0.e();
            Intrinsics.checkNotNullExpressionValue(strE4, "<get-TAG>(...)");
            ((M4) l7).b(strE4, "Listener was garbage collected.Unable to give callback");
        }
    }

    public final void g() {
        L4 l4 = this.f3025a.j;
        if (l4 != null) {
            String strE = C0.e();
            Intrinsics.checkNotNullExpressionValue(strE, "<get-TAG>(...)");
            ((M4) l4).a(strE, "onUserLeftApplication");
        }
        if (this.f3025a.Z()) {
            return;
        }
        AbstractC3520q0 abstractC3520q0 = (AbstractC3520q0) this.b.get();
        if (abstractC3520q0 != null) {
            abstractC3520q0.h();
            return;
        }
        L4 l5 = this.f3025a.j;
        if (l5 != null) {
            ((M4) l5).b("InMobi", "Listener was garbage collected.Unable to give callback");
        }
    }

    public final void h() {
        L4 l4 = this.f3025a.j;
        if (l4 != null) {
            String strE = C0.e();
            Intrinsics.checkNotNullExpressionValue(strE, "<get-TAG>(...)");
            ((M4) l4).a(strE, "onUserSkippedMedia");
        }
        if (this.f3025a.Z()) {
            return;
        }
        AbstractC3520q0 abstractC3520q0 = (AbstractC3520q0) this.b.get();
        if (abstractC3520q0 != null) {
            abstractC3520q0.i();
            return;
        }
        L4 l5 = this.f3025a.j;
        if (l5 != null) {
            ((M4) l5).b("InMobi", "Listener was garbage collected.Unable to give callback");
        }
    }

    public final void b() {
        L4 l4 = this.f3025a.j;
        if (l4 != null) {
            String strE = C0.e();
            Intrinsics.checkNotNullExpressionValue(strE, "<get-TAG>(...)");
            ((M4) l4).a(strE, "onAdDismissed");
        }
        if (this.f3025a.Z()) {
            return;
        }
        L4 l5 = this.f3025a.j;
        if (l5 != null) {
            ((M4) l5).a("InMobi", "Ad dismissed for placement id: " + this.f3025a.I());
        }
        Handler handlerD = this.f3025a.D();
        if (handlerD != null) {
            final C0 c0 = this.f3025a;
            final WeakReference weakReference = this.b;
            handlerD.post(new Runnable() { // from class: com.inmobi.media.A0$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    A0.a(c0, weakReference);
                }
            });
        }
    }

    public static final void a(C0 this$0, WeakReference listenerWeakReference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(listenerWeakReference, "$listenerWeakReference");
        this$0.a((AbstractC3520q0) listenerWeakReference.get());
    }
}
