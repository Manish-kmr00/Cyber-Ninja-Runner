package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.pc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractC3518pc extends AbstractRunnableC3521q1 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC3518pc(C0 obj, byte b) {
        super(obj);
        Intrinsics.checkNotNullParameter(obj, "obj");
    }

    public static final void a(AbstractC3518pc this$0, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a(obj);
    }

    public abstract void a(Object obj);

    public final void b(final Object obj) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.inmobi.media.pc$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC3518pc.a(this.f$0, obj);
            }
        });
    }
}
