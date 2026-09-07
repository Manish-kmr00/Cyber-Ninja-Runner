package com.five_corp.ad.internal.movie.partialcache.audio;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.HandlerThread;
import com.five_corp.ad.internal.o;

/* JADX INFO: loaded from: classes7.dex */
public final class k {
    public static final g g = new g();
    public final f b;
    public Handler c;
    public HandlerThread d;
    public AudioTrack e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1474a = k.class.getName() + System.identityHashCode(this);
    public int f = 1;

    public k(f fVar) {
        this.b = fVar;
    }

    public static void a(k kVar, o oVar) {
        int i = kVar.f;
        if (i == 3 || i == 4) {
            return;
        }
        kVar.f = 3;
        f fVar = kVar.b;
        int i2 = fVar.d;
        if (i2 == 5 || i2 == 6) {
            return;
        }
        fVar.d = 5;
        fVar.b.c.a(oVar);
    }
}
