package sg.bigo.ads.ad.b.a;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import sg.bigo.ads.api.AdOptionsView;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.core.g;
import sg.bigo.ads.common.utils.u;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends sg.bigo.ads.ad.b.c {
    public a(g gVar) {
        super(gVar);
    }

    @Override // sg.bigo.ads.ad.b.c
    public final void a(ViewGroup viewGroup, MediaView mediaView, View view, AdOptionsView adOptionsView, List<View> list, int i, View... viewArr) {
        super.a(viewGroup, mediaView, view, adOptionsView, list, i, viewArr);
        u.a(this.c, this.A);
    }

    @Override // sg.bigo.ads.ad.b.c
    public final void a(MediaView mediaView) {
        super.a(mediaView);
    }

    @Override // sg.bigo.ads.ad.b.c
    public final boolean a(ViewGroup viewGroup, View view, int i) {
        sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) f();
        if (view == null || aVar == null) {
            return false;
        }
        view.setTag(1);
        a(viewGroup, view);
        sg.bigo.ads.ad.b.a.a(viewGroup, view, i, this, this.G);
        return true;
    }

    @Override // sg.bigo.ads.ad.b.c, sg.bigo.ads.ad.c
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
}
