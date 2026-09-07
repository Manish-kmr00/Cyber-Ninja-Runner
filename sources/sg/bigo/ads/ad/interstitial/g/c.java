package sg.bigo.ads.ad.interstitial.g;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.q;
import sg.bigo.ads.api.a.m;
import sg.bigo.ads.common.p;
import sg.bigo.ads.common.utils.e;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.common.view.RoundedImageView;

/* JADX INFO: loaded from: classes2.dex */
public class c extends a {
    protected View s;
    protected TextView t;
    protected View u;
    protected RoundedImageView v;

    protected c(sg.bigo.ads.ad.b.c cVar, m mVar, p pVar) {
        super(cVar, mVar, pVar);
    }

    @Override // sg.bigo.ads.ad.interstitial.g.a
    protected void a(int i, boolean z, boolean z2) {
        super.a(i, z, z2);
        sg.bigo.ads.ad.b.a.a(this.v, 5);
        if (this.v != null) {
            if (z) {
                sg.bigo.ads.ad.b.a.a(this.j, this.v, 10, this.f, i);
            } else {
                sg.bigo.ads.ad.b.a.a(this.j, this.v, 10, sg.bigo.ads.ad.interstitial.a.F, 0);
            }
        }
    }

    protected void a(q qVar, Rect rect) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.n.getLayoutParams();
        layoutParams.addRule(12, 0);
        layoutParams.addRule(3, this.u.getId());
        this.n.requestLayout();
        p pVarB = b(qVar);
        int iA = e.a(this.u.getContext(), 16);
        int iWidth = rect.width();
        int iHeight = rect.height();
        int i = iA * 2;
        int i2 = iWidth - i;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.u.getLayoutParams();
        layoutParams2.addRule(2, 0);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.m.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.v.getLayoutParams();
        p pVarA = p.a(pVarB.b, pVarB.c, iWidth, iHeight - i);
        p pVarA2 = p.a(pVarB.b, pVarB.c, i2, iHeight);
        if (pVarA.a(pVarA2)) {
            layoutParams2.width = pVarA.b;
            layoutParams2.height = pVarA.c + i;
            marginLayoutParams.topMargin = iA;
            marginLayoutParams.bottomMargin = iA;
            marginLayoutParams2.leftMargin = iA;
            marginLayoutParams2.rightMargin = iA;
        } else {
            layoutParams2.width = pVarA2.b + i;
            layoutParams2.height = pVarA2.c;
            marginLayoutParams.leftMargin = iA;
            marginLayoutParams.rightMargin = iA;
            marginLayoutParams2.topMargin = iA;
            marginLayoutParams2.bottomMargin = iA;
        }
        this.m.requestLayout();
        this.v.requestLayout();
        this.u.requestLayout();
    }

    @Override // sg.bigo.ads.ad.interstitial.g.a
    protected void d(final q qVar) {
        if (this.k == null) {
            return;
        }
        this.s = this.k.findViewById(R.id.inter_click_guide_container);
        this.u = this.k.findViewById(R.id.inter_click_guide_image_layout);
        this.v = (RoundedImageView) this.k.findViewById(R.id.inter_click_guide_image_background);
        this.v.setCornerRadius(e.a(this.k.getContext(), 8));
        this.v.setBackgroundColor(654311423);
        u.a(this.u, new u.a() { // from class: sg.bigo.ads.ad.interstitial.g.c.1
            @Override // sg.bigo.ads.common.utils.u.a
            public final void a(Rect rect) {
                c.this.a(qVar, rect);
            }
        });
        l().a(this.t, null);
    }

    @Override // sg.bigo.ads.ad.interstitial.u
    public final boolean d() {
        sg.bigo.ads.core.a.a aVar;
        if (this.f == null || (aVar = (sg.bigo.ads.core.a.a) this.f.f()) == null) {
            return true;
        }
        return aVar.aQ();
    }

    @Override // sg.bigo.ads.ad.interstitial.g.a
    protected final void e(q qVar) {
        super.e(qVar);
        if (this.m != null) {
            this.m.setCornerRadius(e.a(this.m.getContext(), 8));
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.g.a
    protected void f(q qVar) {
        super.f(qVar);
        l().a(this.n);
    }

    @Override // sg.bigo.ads.ad.interstitial.g.a
    public final boolean g() {
        return false;
    }

    @Override // sg.bigo.ads.ad.interstitial.g.a
    protected int h() {
        return R.layout.bigo_ad_view_click_guide_2;
    }

    @Override // sg.bigo.ads.ad.interstitial.g.a
    protected final void k() {
        super.k();
        l().a(this.l);
    }

    protected sg.bigo.ads.ad.interstitial.b l() {
        return sg.bigo.ads.ad.interstitial.b.d;
    }
}
