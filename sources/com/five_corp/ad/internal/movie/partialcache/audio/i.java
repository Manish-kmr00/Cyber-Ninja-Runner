package com.five_corp.ad.internal.movie.partialcache.audio;

import android.media.AudioTrack;
import com.five_corp.ad.internal.o;
import com.five_corp.ad.internal.p;

/* JADX INFO: loaded from: classes7.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ byte[] f1472a;
    public final /* synthetic */ k b;

    public i(k kVar, byte[] bArr) {
        this.b = kVar;
        this.f1472a = bArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioTrack audioTrack;
        k kVar;
        o oVar;
        k kVar2 = this.b;
        if (kVar2.f != 2 || (audioTrack = kVar2.e) == null) {
            return;
        }
        byte[] bArr = this.f1472a;
        int iWrite = audioTrack.write(bArr, 0, bArr.length);
        if (iWrite == -6) {
            kVar = this.b;
            oVar = new o(p.i5, null, null, null);
        } else if (iWrite == -3) {
            kVar = this.b;
            oVar = new o(p.h5, null, null, null);
        } else if (iWrite == -2) {
            kVar = this.b;
            oVar = new o(p.j5, null, null, null);
        } else {
            if (iWrite != -1) {
                return;
            }
            kVar = this.b;
            oVar = new o(p.k5, null, null, null);
        }
        k.a(kVar, oVar);
    }
}
