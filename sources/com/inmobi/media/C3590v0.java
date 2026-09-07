package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import com.inmobi.ads.InMobiAdRequestStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.v0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C3590v0 extends Da {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0 f3450a;

    public C3590v0(C0 c0) {
        this.f3450a = c0;
    }

    public static final void a(C0 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, (short) 43);
    }

    public static final void b(C0 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q = true;
        this$0.f();
    }

    @Override // com.inmobi.media.Da
    public final void f(Ba renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        if (2 == this.f3450a.Q()) {
            this.f3450a.q0();
        }
    }

    @Override // com.inmobi.media.Da
    public final void g(Ba renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        Handler handler = new Handler(Looper.getMainLooper());
        final C0 c0 = this.f3450a;
        handler.post(new Runnable() { // from class: com.inmobi.media.v0$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C3590v0.a(c0);
            }
        });
    }

    @Override // com.inmobi.media.Da
    public final void h(Ba renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        if (2 == this.f3450a.Q()) {
            Handler handler = new Handler(Looper.getMainLooper());
            final C0 c0 = this.f3450a;
            handler.post(new Runnable() { // from class: com.inmobi.media.v0$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C3590v0.b(c0);
                }
            });
        }
    }

    @Override // com.inmobi.media.Da
    public final void a(Ba renderView, short s) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        if (2 == this.f3450a.Q()) {
            this.f3450a.b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, (short) 2176);
        }
    }

    @Override // com.inmobi.media.Da
    public final void a(Yb telemetryOnAdImpression) {
        Intrinsics.checkNotNullParameter(telemetryOnAdImpression, "telemetryOnAdImpression");
        this.f3450a.a(telemetryOnAdImpression);
    }
}
