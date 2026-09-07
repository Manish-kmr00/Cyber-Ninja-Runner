package com.five_corp.ad.internal.movie.partialcache.audio;

import android.os.Handler;
import android.os.Looper;
import com.five_corp.ad.internal.movie.partialcache.C2994b;
import com.five_corp.ad.internal.movie.x;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f1467a;
    public final C2994b b;
    public final x c;
    public int d = 1;

    public c(Looper looper, C2994b c2994b, x xVar) {
        this.f1467a = new Handler(looper);
        this.b = c2994b;
        this.c = xVar;
    }

    public final void a(C2994b c2994b) {
        int iA = com.five_corp.ad.e.a(this.d);
        int i = 1;
        if (iA != 1) {
            i = 7;
            if (iA != 7) {
                i = 3;
                if (iA != 3 && iA != 4 && iA != 5) {
                    return;
                } else {
                    c2994b.c.b();
                }
            }
        }
        this.d = i;
    }
}
