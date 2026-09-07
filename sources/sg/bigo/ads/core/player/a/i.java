package sg.bigo.ads.core.player.a;

import android.support.v4.media.session.PlaybackStateCompat;

/* JADX INFO: loaded from: classes12.dex */
public class i {
    a b;
    volatile boolean d;
    public sg.bigo.ads.common.h.a e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f13691a = new Object();
    final Object c = new Object();

    public final int a(byte[] bArr, long j) throws j {
        if (j < 0) {
            sg.bigo.ads.common.t.a.a(0, "ProxyCache", "buffer or offset or length is wrong");
            return 0;
        }
        int i = 0;
        while (!this.b.c() && this.b.a() < PlaybackStateCompat.ACTION_PLAY_FROM_URI + j && !this.d) {
            i++;
            synchronized (this.f13691a) {
                try {
                    sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "wait for downloading. thread=" + Thread.currentThread().getName() + ",url=" + this.e.b + ",count=" + i);
                    this.f13691a.wait(1000L);
                } catch (InterruptedException e) {
                    sg.bigo.ads.common.t.a.a(0, "ProxyCache", "Waiting source data is interrupted!" + e.toString());
                }
            }
            if (i >= 15) {
                sg.bigo.ads.common.t.a.a(0, "ProxyCache", "wait for downloading more than 15s.");
                throw new j("Error reading source " + i + " times");
            }
        }
        int iA = this.b.a(bArr, j);
        if (iA <= 0) {
            sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "read end, size = ".concat(String.valueOf(iA)));
        }
        return iA;
    }
}
