package sg.bigo.ads.ad.interstitial.c;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.TextView;
import sg.bigo.ads.R;

/* JADX INFO: loaded from: classes13.dex */
public abstract class a extends sg.bigo.ads.ad.interstitial.u {
    protected final int h;
    protected final sg.bigo.ads.ad.interstitial.f i;
    protected ViewGroup j;
    protected ViewGroup k;
    protected TextView l;
    protected final sg.bigo.ads.ad.interstitial.e.c m;
    protected final ValueCallback<Double> n;

    /* JADX WARN: Type inference failed for: r2v1, types: [sg.bigo.ads.api.core.c] */
    public a(sg.bigo.ads.ad.b.c cVar, int i, sg.bigo.ads.api.a.m mVar, sg.bigo.ads.ad.interstitial.e.c cVar2) {
        super(cVar, mVar);
        this.n = new ValueCallback<Double>() { // from class: sg.bigo.ads.ad.interstitial.c.a.1
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(Double d) {
                Double d2 = d;
                if (d2 != null) {
                    a.this.a(d2.doubleValue());
                }
            }
        };
        this.h = i;
        ?? F = cVar.f();
        this.i = new sg.bigo.ads.ad.interstitial.f(mVar.a("endpage.gp_element"), 0, F != 0 ? F.n() : "");
        this.m = cVar2;
    }

    public static int a(sg.bigo.ads.api.a.m mVar) {
        return sg.bigo.ads.ad.interstitial.d.a.a(mVar, "endpage.webview_layout");
    }

    public static a a(sg.bigo.ads.ad.b.c cVar, sg.bigo.ads.api.a.m mVar, sg.bigo.ads.ad.interstitial.multi_img.b bVar, sg.bigo.ads.ad.interstitial.e.c cVar2, boolean z) {
        if (mVar == null || z) {
            return null;
        }
        int iA = mVar.a("endpage.ad_component_layout");
        switch (iA) {
            case 6:
                if (bVar == null) {
                    return null;
                }
                return new s(cVar, iA, mVar, bVar, cVar2);
            case 7:
                if (bVar == null) {
                    return null;
                }
                return new t(cVar, iA, mVar, bVar, cVar2);
            case 8:
                if (bVar == null) {
                    return null;
                }
                return new u(cVar, iA, mVar, bVar, cVar2);
            case 9:
                if (bVar == null) {
                    return null;
                }
                return new v(cVar, iA, mVar, bVar, cVar2);
            case 10:
                if (bVar == null) {
                    return null;
                }
                return new c(cVar, iA, mVar, bVar, cVar2);
            case 11:
                if (bVar == null) {
                    return null;
                }
                return new d(cVar, iA, mVar, bVar, cVar2);
            case 12:
                if (bVar == null) {
                    return null;
                }
                return new e(cVar, iA, mVar, bVar, cVar2);
            case 13:
                if (bVar == null) {
                    return null;
                }
                return new f(cVar, iA, mVar, bVar, cVar2);
            case 14:
                return new g(cVar, iA, mVar, cVar2);
            case 15:
                return new h(cVar, iA, mVar, cVar2);
            case 16:
                return new i(cVar, iA, mVar, cVar2);
            case 17:
                return new j(cVar, iA, mVar, cVar2);
            case 18:
                return new k(cVar, iA, mVar, cVar2);
            case 19:
                return new l(cVar, iA, mVar, cVar2);
            case 20:
                return new m(cVar, iA, mVar, cVar2);
            case 21:
                return new n(cVar, iA, mVar, cVar2);
            case 22:
                return new o(cVar, iA, mVar, cVar2);
            case 23:
                return new p(cVar, iA, mVar, cVar2);
            case 24:
                return new q(cVar, iA, mVar, cVar2);
            case 25:
                return new r(cVar, iA, mVar, cVar2);
            default:
                return null;
        }
    }

    public static boolean a(a aVar, sg.bigo.ads.api.a.m mVar) {
        if (aVar != null && aVar.d()) {
            return true;
        }
        if (mVar == null) {
            return false;
        }
        int iA = mVar.a("endpage.ad_component_layout");
        return iA == 3 || iA == 4;
    }

    public static int b(sg.bigo.ads.api.a.m mVar) {
        return sg.bigo.ads.ad.interstitial.d.a.b(mVar, "endpage.webview_force_time");
    }

    public final View a(sg.bigo.ads.ad.interstitial.q qVar, ViewGroup viewGroup, int i) {
        if (viewGroup == null) {
            return this.j;
        }
        this.j = viewGroup;
        if (this.k == null) {
            ViewGroup viewGroup2 = (ViewGroup) sg.bigo.ads.common.utils.a.a(viewGroup.getContext(), h(), null, false);
            this.k = viewGroup2;
            this.j.addView(viewGroup2, new ViewGroup.LayoutParams(-1, -1));
        }
        this.l = (TextView) this.k.findViewById(R.id.inter_warning);
        d(qVar);
        a(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.c.a.2
            @Override // java.lang.Runnable
            public final void run() {
                if (a.this.m != null) {
                    a.this.m.a(a.this.k);
                }
            }
        });
        a(qVar, 1);
        a(qVar, this.j, this.k, null, i, 4, this.g == null ? 0 : this.g.a("endpage.click_type"), this.k);
        i();
        a(this.g != null ? this.g.a("endpage.click_type") : 0, this.g == null || this.g.a("endpage.media_view_clickable_switch") == 1, this.g == null || this.g.a("endpage.other_space_clickable_switch") == 1);
        a(qVar).e().a(this.n);
        return this.k;
    }

    protected abstract void a(double d);

    protected abstract void a(int i, boolean z, boolean z2);

    protected void a(Runnable runnable) {
        sg.bigo.ads.ad.interstitial.c.a(this.k, this.j, runnable);
    }

    protected void a(sg.bigo.ads.ad.interstitial.q qVar, int i) {
    }

    protected abstract void d(sg.bigo.ads.ad.interstitial.q qVar);

    @Override // sg.bigo.ads.ad.interstitial.u
    public final int e() {
        return sg.bigo.ads.ad.interstitial.multi_img.e.a(this.g != null ? this.g.a("endpage.mediaview_colour") : 3);
    }

    protected final Pair<Integer, Boolean> e(sg.bigo.ads.ad.interstitial.q qVar) {
        return Pair.create(Integer.valueOf(f(qVar)), Boolean.valueOf(j()));
    }

    protected final int f(sg.bigo.ads.ad.interstitial.q qVar) {
        int i;
        if (this.g == null) {
            return -16736769;
        }
        int iA = this.g.a("endpage.cta_color");
        return (iA == 3 && d() && (i = a(qVar).i) != 0) ? i : sg.bigo.ads.ad.interstitial.r.a(this.f, iA, null);
    }

    public boolean g() {
        return false;
    }

    protected abstract int h();

    protected void i() {
        String strI = ((sg.bigo.ads.core.a.a) this.f.f()).i();
        TextView textView = (TextView) this.k.findViewById(R.id.inter_advertiser);
        TextView textView2 = (TextView) this.k.findViewById(R.id.inter_ad_label);
        if (TextUtils.isEmpty(strI)) {
            textView.setVisibility(8);
        } else if (textView2 != null) {
            textView.setText(strI);
            textView.setPadding(sg.bigo.ads.common.utils.e.a(this.k.getContext(), 4), sg.bigo.ads.common.utils.e.a(textView.getContext(), 1), sg.bigo.ads.common.utils.e.a(textView.getContext(), 4), sg.bigo.ads.common.utils.e.a(textView.getContext(), 1));
            textView2.setText(R.string.bigo_ad_tag);
        }
    }

    protected final boolean j() {
        return this.g != null && this.g.c("endpage.is_cta_show_animation");
    }

    protected final int k() {
        return sg.bigo.ads.ad.interstitial.multi_img.e.a(this.g != null ? this.g.a("endpage.background_colour") : 1);
    }
}
