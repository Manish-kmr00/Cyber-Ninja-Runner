package sg.bigo.ads.ad.b;

import android.graphics.Bitmap;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.core.c;

/* JADX INFO: loaded from: classes12.dex */
public abstract class e<T extends Ad, U extends sg.bigo.ads.api.core.c> extends sg.bigo.ads.ad.d<T, U> {
    boolean K;
    public Integer L;
    private boolean v;
    private Integer w;

    public e(sg.bigo.ads.api.core.g gVar) {
        super(gVar);
        this.v = false;
        this.K = false;
    }

    public final Integer F() {
        if (G()) {
            return null;
        }
        return this.w;
    }

    public final boolean G() {
        return !this.v;
    }

    public final void a(final Bitmap bitmap, final int i) {
        if (G() || this.K || bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.K = true;
        sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.ad.b.e.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (i == 1) {
                        e.this.L = sg.bigo.ads.common.w.b.a(bitmap);
                    } else {
                        e.this.w = sg.bigo.ads.common.w.b.a(bitmap);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    public void b(boolean z) {
        this.v = z;
    }
}
