package com.five_corp.ad.internal.movie;

import android.media.MediaFormat;
import android.os.Handler;
import com.five_corp.ad.internal.movie.partialcache.C2994b;
import com.five_corp.ad.internal.movie.partialcache.u1;

/* JADX INFO: renamed from: com.five_corp.ad.internal.movie.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes5.dex */
public final class C2985g implements u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaFormat f1449a;
    public final /* synthetic */ MediaFormat b;
    public final /* synthetic */ x c;

    public C2985g(x xVar, MediaFormat mediaFormat, MediaFormat mediaFormat2) {
        this.c = xVar;
        this.f1449a = mediaFormat;
        this.b = mediaFormat2;
    }

    @Override // com.five_corp.ad.internal.movie.partialcache.u1
    public final void a(Object obj) {
        C2994b c2994b = (C2994b) obj;
        x xVar = this.c;
        int i = xVar.o;
        if (i != 2) {
            w.a(i);
            return;
        }
        xVar.o = 3;
        com.five_corp.ad.internal.movie.partialcache.video.c cVar = xVar.k;
        MediaFormat mediaFormat = this.f1449a;
        cVar.getClass();
        c2994b.e = new com.five_corp.ad.internal.movie.partialcache.video.e(mediaFormat, new Handler(cVar.f1502a.getLooper()), cVar);
        this.c.f.b();
        x xVar2 = this.c;
        com.five_corp.ad.internal.movie.partialcache.audio.d dVar = xVar2.j;
        MediaFormat mediaFormat2 = this.b;
        dVar.c = mediaFormat2 != null;
        if (mediaFormat2 != null) {
            com.five_corp.ad.internal.movie.partialcache.audio.c cVar2 = xVar2.i;
            if (cVar2.d == 1) {
                cVar2.d = c2994b.f1475a ? 3 : 7;
                c2994b.c = new com.five_corp.ad.internal.movie.partialcache.audio.f(mediaFormat2, cVar2.f1467a.getLooper(), cVar2);
            }
        }
        x xVar3 = this.c;
        xVar3.a(c2994b.b + xVar3.c);
    }
}
