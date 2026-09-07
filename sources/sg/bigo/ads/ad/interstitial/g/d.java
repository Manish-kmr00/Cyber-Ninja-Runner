package sg.bigo.ads.ad.interstitial.g;

import android.graphics.Rect;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Collection;
import java.util.List;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.multi_img.view.IconListView;
import sg.bigo.ads.ad.interstitial.q;
import sg.bigo.ads.api.a.m;
import sg.bigo.ads.common.p;
import sg.bigo.ads.common.utils.e;
import sg.bigo.ads.common.utils.k;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends c {
    private TextView w;
    private TextView x;
    private IconListView y;

    protected d(sg.bigo.ads.ad.b.c cVar, m mVar, p pVar) {
        super(cVar, mVar, pVar);
    }

    @Override // sg.bigo.ads.ad.interstitial.g.c, sg.bigo.ads.ad.interstitial.g.a
    protected final void a(int i, boolean z, boolean z2) {
        super.a(i, z, z2);
        boolean z3 = true;
        if (this.g != null && this.g.a("layer.ad_component_clickable_switch") != 1) {
            z3 = false;
        }
        if (this.s != null) {
            sg.bigo.ads.ad.b.a.a(this.s, 18);
            ViewGroup viewGroup = this.j;
            if (z3) {
                sg.bigo.ads.ad.b.a.a(viewGroup, this.s, 8, this.f, i);
            } else {
                sg.bigo.ads.ad.b.a.a(viewGroup, this.s, 8, sg.bigo.ads.ad.interstitial.a.F, 0);
            }
        }
        IconListView iconListView = this.y;
        if (iconListView != null) {
            List<IconListView.a> items = iconListView.getItems();
            for (int i2 = 0; items != null && i2 < items.size(); i2++) {
                IconListView.a aVar = items.get(i2);
                sg.bigo.ads.ad.b.a.a(aVar.d, 26);
                sg.bigo.ads.ad.b.a.a(this.j, aVar.d, 8, this.f, i);
                sg.bigo.ads.ad.b.a.a(aVar.g, 26);
                sg.bigo.ads.ad.b.a.a(this.j, aVar.g, 8, this.f, i);
            }
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.g.c
    protected final void a(q qVar, Rect rect) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.y.getLayoutParams();
        layoutParams.addRule(3, this.u.getId());
        layoutParams.addRule(2, 0);
        this.y.requestLayout();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.n.getLayoutParams();
        layoutParams2.addRule(12, 0);
        layoutParams2.addRule(3, k.a((Collection) this.y.getItems()) ? this.u.getId() : this.y.getId());
        this.n.requestLayout();
        p pVarB = b(qVar);
        int iA = e.a(this.u.getContext(), 16);
        int iWidth = rect.width();
        int iHeight = rect.height();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.u.getLayoutParams();
        layoutParams3.addRule(2, 0);
        p pVarB2 = p.b(pVarB.b, pVarB.c, iWidth);
        if (pVarB2.c <= iHeight) {
            layoutParams3.height = pVarB2.c;
        } else {
            int i = iA * 2;
            layoutParams3.height = p.a(pVarB.b, pVarB.c, iWidth - i, iHeight - i).c + i;
            ((ViewGroup.MarginLayoutParams) this.m.getLayoutParams()).setMargins(iA, iA, iA, iA);
            this.m.requestLayout();
        }
        this.u.requestLayout();
    }

    @Override // sg.bigo.ads.ad.interstitial.g.c, sg.bigo.ads.ad.interstitial.g.a
    protected final void d(q qVar) {
        IconListView iconListView;
        int i;
        super.d(qVar);
        if (this.k == null) {
            return;
        }
        this.x = (TextView) this.k.findViewById(R.id.inter_description);
        sg.bigo.ads.ad.interstitial.b.f12647a.a(null, this.x);
        IconListView iconListView2 = (IconListView) this.k.findViewById(R.id.inter_download_msg);
        this.y = iconListView2;
        iconListView2.a(this.i);
        if (k.a((Collection) this.y.getItems())) {
            iconListView = this.y;
            i = 8;
        } else {
            iconListView = this.y;
            i = 0;
        }
        iconListView.setVisibility(i);
        int iA = e.a(this.k.getContext(), 16);
        if (this.s != null) {
            float f = iA;
            this.s.setBackground(sg.bigo.ads.common.utils.d.a(f, f, f, f, (Rect) null, -1));
            sg.bigo.ads.ad.interstitial.b.f12647a.b(this.s);
        }
        a(qVar, this.v);
    }

    @Override // sg.bigo.ads.ad.interstitial.g.c, sg.bigo.ads.ad.interstitial.g.a
    protected final void f(q qVar) {
        super.f(qVar);
        if (this.k != null) {
            TextView textView = (TextView) this.k.findViewById(R.id.inter_company);
            this.w = textView;
            if (textView != null) {
                textView.setTextColor(g(qVar));
            }
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.g.c, sg.bigo.ads.ad.interstitial.g.a
    protected final int h() {
        return R.layout.bigo_ad_view_click_guide_3;
    }

    @Override // sg.bigo.ads.ad.interstitial.g.c
    protected final sg.bigo.ads.ad.interstitial.b l() {
        return sg.bigo.ads.ad.interstitial.b.f12647a;
    }
}
