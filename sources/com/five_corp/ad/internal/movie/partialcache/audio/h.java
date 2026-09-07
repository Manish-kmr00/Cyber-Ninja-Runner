package com.five_corp.ad.internal.movie.partialcache.audio;

import android.media.AudioTrack;
import android.media.MediaFormat;
import com.five_corp.ad.internal.o;
import com.five_corp.ad.internal.p;

/* JADX INFO: loaded from: classes7.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaFormat f1471a;
    public final /* synthetic */ k b;

    public h(k kVar, MediaFormat mediaFormat) {
        this.b = kVar;
        this.f1471a = mediaFormat;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        k kVar = this.b;
        if (kVar.f != 2) {
            return;
        }
        AudioTrack audioTrack = kVar.e;
        if (audioTrack != null) {
            try {
                audioTrack.stop();
            } catch (Exception e) {
                f fVar = kVar.b;
                o oVar = new o(p.g5, null, e, null);
                int i2 = fVar.d;
                if (i2 != 5 && i2 != 6) {
                    fVar.d = 5;
                    fVar.b.c.a(oVar);
                }
            }
            kVar.e.release();
            kVar.e = null;
        }
        int integer = this.f1471a.containsKey("pcm-encoding") ? this.f1471a.getInteger("pcm-encoding") : 2;
        int integer2 = this.f1471a.getInteger("channel-count");
        if (integer2 == 1) {
            i = 4;
        } else if (integer2 == 2) {
            i = 12;
        } else {
            String str = this.b.f1474a;
            i = 4;
        }
        int i3 = i;
        int integer3 = this.f1471a.getInteger("sample-rate");
        int minBufferSize = AudioTrack.getMinBufferSize(integer3, i3, integer);
        if (minBufferSize == -2) {
            k.a(this.b, new o(p.m5, null, null, null));
            return;
        }
        if (minBufferSize == -1) {
            k.a(this.b, new o(p.l5, null, null, null));
            return;
        }
        try {
            k kVar2 = this.b;
            kVar2.getClass();
            kVar2.e = new AudioTrack(3, integer3, i3, integer, minBufferSize, 1);
            if (this.b.e.setPositionNotificationPeriod(integer3) == -3) {
                k.a(this.b, new o(p.n5, null, null, null));
                return;
            }
            this.b.e.setPlaybackPositionUpdateListener(k.g);
            try {
                this.b.e.play();
            } catch (Exception e2) {
                k.a(this.b, new o(p.f5, null, e2, null));
            }
        } catch (Exception e3) {
            k.a(this.b, new o(p.e5, null, e3, null));
        }
    }
}
