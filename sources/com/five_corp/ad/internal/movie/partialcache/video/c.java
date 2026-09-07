package com.five_corp.ad.internal.movie.partialcache.video;

import android.os.Handler;
import android.os.Looper;
import com.five_corp.ad.internal.movie.partialcache.C2994b;
import com.five_corp.ad.internal.movie.x;

/* JADX INFO: loaded from: classes10.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f1502a;
    public final C2994b b;
    public final x c;

    public c(Looper looper, C2994b c2994b, x xVar) {
        System.identityHashCode(this);
        this.f1502a = new Handler(looper);
        this.b = c2994b;
        this.c = xVar;
    }

    public static void a(C2994b c2994b) {
        e eVar = c2994b.e;
        if (eVar != null) {
            eVar.a();
        }
    }
}
