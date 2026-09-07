package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.l0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3446l0 implements InterfaceC3349e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3462m0 f3362a;

    public C3446l0(C3462m0 c3462m0) {
        this.f3362a = c3462m0;
    }

    public static final void a(C3462m0 this$0, byte b) {
        short s;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        C0 c0 = this$0.f3372a;
        J j = this$0.c;
        if (b == 1) {
            s = 78;
        } else if (b == 2) {
            s = 79;
        } else if (b == 3) {
            s = 80;
        } else if (b == 4) {
            s = 81;
        } else if (b == 5) {
            s = 5;
        } else if (b == 6) {
            s = 77;
        } else if (b == 7) {
            s = 31;
        } else {
            s = b == 8 ? (short) 27 : (short) 82;
        }
        c0.a(j, false, s);
    }

    public static final void a(C3462m0 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f3372a.a(this$0.c, true, (short) 0);
    }

    @Override // com.inmobi.media.InterfaceC3349e1
    public final void a(C3431k assetBatch, final byte b) {
        Intrinsics.checkNotNullParameter(assetBatch, "assetBatch");
        this.f3362a.h.a(assetBatch, b);
        C3462m0 c3462m0 = this.f3362a;
        L4 l4 = c3462m0.f;
        if (l4 != null) {
            String str = c3462m0.d;
            ((M4) l4).b(str, O5.a(str, "access$getTAG$p(...)", "Notifying failure  to ad unit with placement ID (").append(this.f3362a.c).append(')').toString());
        }
        Handler handler = new Handler(Looper.getMainLooper());
        final C3462m0 c3462m1 = this.f3362a;
        handler.post(new Runnable() { // from class: com.inmobi.media.l0$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C3446l0.a(c3462m1, b);
            }
        });
    }

    @Override // com.inmobi.media.InterfaceC3349e1
    public final void a(C3431k assetBatch) {
        Intrinsics.checkNotNullParameter(assetBatch, "assetBatch");
        this.f3362a.h.a(assetBatch);
        C3462m0 c3462m0 = this.f3362a;
        L4 l4 = c3462m0.f;
        if (l4 != null) {
            String str = c3462m0.d;
            ((M4) l4).a(str, O5.a(str, "access$getTAG$p(...)", "Notifying ad unit with placement ID (").append(this.f3362a.c).append(')').toString());
        }
        Handler handler = new Handler(Looper.getMainLooper());
        final C3462m0 c3462m1 = this.f3362a;
        handler.post(new Runnable() { // from class: com.inmobi.media.l0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C3446l0.a(c3462m1);
            }
        });
    }
}
