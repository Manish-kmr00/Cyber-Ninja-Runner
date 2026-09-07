package com.inmobi.media;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.a7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C3298a7 extends Da {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3313b7 f3267a;

    public C3298a7(C3313b7 c3313b7) {
        this.f3267a = c3313b7;
    }

    @Override // com.inmobi.media.Da
    public final void a(HashMap params) {
        Intrinsics.checkNotNullParameter(params, "params");
        A0 a0 = this.f3267a.w;
        if (a0 != null) {
            a0.a();
        }
    }

    @Override // com.inmobi.media.Da
    public final void c() {
        A0 a0 = this.f3267a.w;
        if (a0 != null) {
            a0.c();
        }
    }

    @Override // com.inmobi.media.Da
    public final void d(Ba renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        A0 a0 = this.f3267a.w;
        if (a0 != null) {
            a0.b();
        }
    }

    @Override // com.inmobi.media.Da
    public final void e(Ba renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        A0 a0 = this.f3267a.w;
        if (a0 != null) {
            a0.d();
        }
    }

    @Override // com.inmobi.media.Da, com.inmobi.media.Cc
    public final void a() {
        A0 a0 = this.f3267a.w;
        if (a0 != null) {
            a0.g();
        }
    }

    @Override // com.inmobi.media.Da
    public final void d() {
        A0 a0;
        C3313b7 c3313b7 = this.f3267a;
        if (c3313b7.f3274a != 0 || (a0 = c3313b7.w) == null) {
            return;
        }
        a0.e();
    }

    @Override // com.inmobi.media.Da
    public final void a(Yb telemetryOnAdImpression) {
        Intrinsics.checkNotNullParameter(telemetryOnAdImpression, "telemetryOnAdImpression");
        A0 a0 = this.f3267a.w;
        if (a0 != null) {
            Intrinsics.checkNotNullParameter(telemetryOnAdImpression, "telemetryOnAdImpression");
            telemetryOnAdImpression.getClass();
            Intrinsics.checkNotNullParameter("nativeBeacon", "<set-?>");
            telemetryOnAdImpression.e = "nativeBeacon";
            if (a0.f3025a.Z()) {
                telemetryOnAdImpression.b();
            } else {
                a0.f3025a.D.a(telemetryOnAdImpression);
            }
        }
    }

    @Override // com.inmobi.media.Da
    public final void a(String log) {
        Intrinsics.checkNotNullParameter(log, "log");
        A0 a0 = this.f3267a.w;
        if (a0 != null) {
            Intrinsics.checkNotNullParameter(log, "log");
            L4 l4 = a0.f3025a.j;
            if (l4 != null) {
                String strE = C0.e();
                Intrinsics.checkNotNullExpressionValue(strE, "<get-TAG>(...)");
                ((M4) l4).a(strE, "onImraidLog");
            }
            if (a0.f3025a.Z()) {
                return;
            }
            AbstractC3520q0 abstractC3520q0 = (AbstractC3520q0) a0.b.get();
            if (abstractC3520q0 != null) {
                abstractC3520q0.a(log);
                return;
            }
            L4 l5 = a0.f3025a.j;
            if (l5 != null) {
                String strE2 = C0.e();
                Intrinsics.checkNotNullExpressionValue(strE2, "<get-TAG>(...)");
                ((M4) l5).b(strE2, "listener is null");
            }
        }
    }
}
