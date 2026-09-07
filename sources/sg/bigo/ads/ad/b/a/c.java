package sg.bigo.ads.ad.b.a;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import sg.bigo.ads.api.AdIconView;
import sg.bigo.ads.api.NativeAd;
import sg.bigo.ads.api.a.i;
import sg.bigo.ads.api.core.o;
import sg.bigo.ads.common.p.f;
import sg.bigo.ads.common.p.g;

/* JADX INFO: loaded from: classes13.dex */
public final class c extends sg.bigo.ads.ad.b.c implements g {
    public boolean v;
    public boolean w;

    public c(sg.bigo.ads.api.core.g gVar) {
        super(gVar);
        this.v = false;
        this.w = false;
    }

    @Override // sg.bigo.ads.common.p.g
    public final void a(int i, String str, String str2) {
        sg.bigo.ads.common.t.a.a(0, 3, "IconAds", "icon download fail, error=" + i + ", errorMsg=" + str);
        this.w = true;
    }

    @Override // sg.bigo.ads.common.p.g
    public final void a(Bitmap bitmap, f fVar) {
        sg.bigo.ads.common.t.a.a(0, 3, "IconAds", "icon download success, url = " + fVar.e);
        this.v = true;
    }

    @Override // sg.bigo.ads.ad.b.c
    public final void a(sg.bigo.ads.api.b.d.a<NativeAd> aVar, int i) {
        aVar.a(this);
    }

    @Override // sg.bigo.ads.ad.b.c
    public final boolean a(ViewGroup viewGroup, View view, int i) {
        sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) f();
        if (view != null && aVar != null) {
            view.setTag(1);
            if (a(viewGroup, view)) {
                o.a aVarAu = aVar.au();
                if (aVarAu != null) {
                    String strC = aVarAu != null ? aVarAu.c() : null;
                    if (i.f13093a.n().a(9) && URLUtil.isHttpUrl(strC)) {
                        sg.bigo.ads.core.d.b.a(aVar, 3000, 10220, "Invalid http url: ".concat(String.valueOf(strC)));
                    } else if (view instanceof ImageView) {
                        sg.bigo.ads.common.p.b bVar = new sg.bigo.ads.common.p.b((ImageView) view, (byte) 0);
                        bVar.a(this);
                        bVar.a(sg.bigo.ads.common.u.a.e.i(), aVarAu.c(), aVar.al());
                    } else if (view instanceof AdIconView) {
                        ((AdIconView) view).a(sg.bigo.ads.common.u.a.e.i(), aVarAu.c(), aVar.al(), this);
                    }
                }
                sg.bigo.ads.ad.b.a.a(viewGroup, view, i, this, this.G);
                return true;
            }
        }
        return false;
    }
}
