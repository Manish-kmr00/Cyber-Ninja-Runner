package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.fc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3374fc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0 f3318a;
    public final HashMap b;

    public C3374fc(C0 timeOutInformer) {
        Intrinsics.checkNotNullParameter(timeOutInformer, "timeOutInformer");
        this.f3318a = timeOutInformer;
        this.b = new HashMap();
    }

    public final void a(final byte b) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.inmobi.media.fc$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C3374fc.a(this.f$0, b);
            }
        });
    }

    public static final void a(C3374fc this$0, byte b) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f3318a.a(b);
    }
}
