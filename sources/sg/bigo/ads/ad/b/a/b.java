package sg.bigo.ads.ad.b.a;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.AdOptionsView;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.NativeAd;
import sg.bigo.ads.api.core.g;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.core.f.a.k;

/* JADX INFO: loaded from: classes13.dex */
public final class b extends sg.bigo.ads.ad.b.d {
    private boolean V;
    private boolean W;
    private a v;
    private sg.bigo.ads.api.b.d.a<NativeAd> w;
    private boolean x;

    public b(g gVar) {
        super(gVar);
        this.x = false;
        this.V = false;
        this.W = false;
        this.v = new a(gVar);
    }

    static /* synthetic */ void a(b bVar) {
        bVar.x = true;
        if (!bVar.W || bVar.V || bVar.h) {
            return;
        }
        sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.b.a.b.2
            @Override // java.lang.Runnable
            public final void run() {
                if (b.this.D != null) {
                    b.d(b.this);
                    b.this.v.a(b.this.D);
                }
            }
        });
    }

    static /* synthetic */ void b(b bVar) {
        bVar.V = true;
        if (!bVar.W || bVar.h) {
            return;
        }
        sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.b.a.b.3
            @Override // java.lang.Runnable
            public final void run() {
                b.d(b.this);
                if (b.this.I == null || b.this.D == null) {
                    return;
                }
                b bVar2 = b.this;
                b.super.a(bVar2.D);
            }
        });
    }

    static /* synthetic */ void d(b bVar) {
        if (bVar.D != null) {
            View viewFindViewWithTag = bVar.D.findViewWithTag("blur_image_view");
            bVar.D.removeAllViews();
            if (viewFindViewWithTag != null) {
                u.a(viewFindViewWithTag, bVar.D, null, 0);
            }
        }
    }

    @Override // sg.bigo.ads.ad.b.d
    public final k E() {
        return new k(0, 1);
    }

    @Override // sg.bigo.ads.ad.d, sg.bigo.ads.ad.c
    public final void a() {
        super.a();
        this.v.a();
    }

    @Override // sg.bigo.ads.ad.b.c
    public final void a(ViewGroup viewGroup, MediaView mediaView, View view, AdOptionsView adOptionsView, List<View> list, int i, View... viewArr) {
        super.a(viewGroup, mediaView, view, adOptionsView, list, i, viewArr);
        this.W = true;
        mediaView.setMediaAreaClickable(true);
        mediaView.b().a(false);
        u.a(this.c, this.A);
    }

    @Override // sg.bigo.ads.ad.b.d, sg.bigo.ads.ad.b.c
    public final void a(final MediaView mediaView) {
        if (mediaView == null) {
            return;
        }
        if (this.V && this.I != null) {
            sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.b.a.b.4
                @Override // java.lang.Runnable
                public final void run() {
                    mediaView.removeAllViews();
                    b.super.a(mediaView);
                }
            });
        } else if (this.x) {
            sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.b.a.b.5
                @Override // java.lang.Runnable
                public final void run() {
                    mediaView.removeAllViews();
                    b.this.v.a(mediaView);
                }
            });
        }
    }

    @Override // sg.bigo.ads.ad.b.d, sg.bigo.ads.ad.b.c
    public final void a(final sg.bigo.ads.api.b.d.a<NativeAd> aVar, int i) {
        sg.bigo.ads.api.b.d.a<NativeAd> aVar2 = new sg.bigo.ads.api.b.d.a<NativeAd>() { // from class: sg.bigo.ads.ad.b.a.b.1
            @Override // sg.bigo.ads.api.b.d.a
            public final /* synthetic */ void a(Ad ad) {
                NativeAd nativeAd = (NativeAd) ad;
                aVar.a(nativeAd);
                if (nativeAd instanceof a) {
                    b.a(b.this);
                } else if (nativeAd instanceof b) {
                    b.b(b.this);
                }
            }

            @Override // sg.bigo.ads.api.b.d.a
            public final /* bridge */ /* synthetic */ void a(Ad ad, int i2, int i3, String str) {
                aVar.a((NativeAd) ad, i2, i3, str);
            }

            @Override // sg.bigo.ads.api.b.d.a
            public final /* bridge */ /* synthetic */ void a(Ad ad, boolean z, int i2, int i3, String str, boolean z2) {
            }
        };
        this.w = aVar2;
        super.a(aVar2, i);
    }

    @Override // sg.bigo.ads.ad.b.d, sg.bigo.ads.ad.b.c, sg.bigo.ads.ad.c
    public final void h() {
        if (this.y > 0) {
            a("attach_render_cost", Long.valueOf(SystemClock.elapsedRealtime() - this.y));
        }
        super.h();
    }

    @Override // sg.bigo.ads.ad.c
    public final String i() {
        if (this.c == null) {
            return "";
        }
        return this.c.getWidth() > this.c.getHeight() * 2 ? "320x50" : "300x250";
    }

    @Override // sg.bigo.ads.ad.b.c
    public final void y() {
        this.v.a(this.w, 0);
        if (this.z != null) {
            this.z.a();
        }
    }
}
