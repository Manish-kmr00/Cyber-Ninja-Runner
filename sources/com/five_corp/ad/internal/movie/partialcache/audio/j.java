package com.five_corp.ad.internal.movie.partialcache.audio;

import android.media.AudioTrack;
import android.os.HandlerThread;
import com.five_corp.ad.internal.o;
import com.five_corp.ad.internal.p;

/* JADX INFO: loaded from: classes7.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f1473a;

    public j(k kVar) {
        this.f1473a = kVar;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0050 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x0051  */
    /* JADX WARN: Code duplicated, block: B:31:0x0023 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    public final void run() {
        k kVar;
        k kVar2;
        AudioTrack audioTrack;
        HandlerThread handlerThread;
        int iA = com.five_corp.ad.e.a(this.f1473a.f);
        if (iA != 0) {
            int i = 1;
            if (iA != 1) {
                if (iA == 2) {
                    kVar = this.f1473a;
                    i = 4;
                } else if (iA == 3) {
                    return;
                }
                kVar2 = this.f1473a;
                audioTrack = kVar2.e;
                if (audioTrack != null) {
                    try {
                        audioTrack.stop();
                    } catch (Exception e) {
                        f fVar = kVar2.b;
                        o oVar = new o(p.g5, null, e, null);
                        int i2 = fVar.d;
                        if (i2 != 5 && i2 != 6) {
                            fVar.d = 5;
                            fVar.b.c.a(oVar);
                        }
                    }
                    kVar2.e.release();
                    kVar2.e = null;
                }
                handlerThread = this.f1473a.d;
                if (handlerThread == null) {
                    return;
                }
                handlerThread.quit();
                k kVar3 = this.f1473a;
                kVar3.d = null;
                kVar3.c = null;
            }
            kVar = this.f1473a;
            kVar.f = i;
            kVar2 = this.f1473a;
            audioTrack = kVar2.e;
            if (audioTrack != null) {
                audioTrack.stop();
                kVar2.e.release();
                kVar2.e = null;
            }
            handlerThread = this.f1473a.d;
            if (handlerThread == null) {
                return;
            }
            handlerThread.quit();
            k kVar4 = this.f1473a;
            kVar4.d = null;
            kVar4.c = null;
        }
    }
}
