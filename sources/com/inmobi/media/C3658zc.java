package com.inmobi.media;

/* JADX INFO: renamed from: com.inmobi.media.zc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3658zc implements S0 {
    public static final void b(boolean z) {
        if (z) {
            Ac.a(Ac.f3028a);
        } else {
            Ac.a();
        }
    }

    public final void a(final boolean z) {
        C3517pb.a(z);
        C3517pb.a(new Runnable() { // from class: com.inmobi.media.zc$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C3658zc.b(z);
            }
        });
    }
}
