package sg.bigo.ads.ad.interstitial.c;

import android.graphics.Rect;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Collection;
import java.util.List;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.multi_img.view.IconListView;

/* JADX INFO: loaded from: classes14.dex */
public class l extends k {
    private TextView v;
    private TextView w;
    private IconListView x;

    public l(sg.bigo.ads.ad.b.c cVar, int i, sg.bigo.ads.api.a.m mVar, sg.bigo.ads.ad.interstitial.e.c cVar2) {
        super(cVar, i, mVar, cVar2);
    }

    @Override // sg.bigo.ads.ad.interstitial.c.k
    protected final void a(int i) {
        super.a(i);
        sg.bigo.ads.ad.interstitial.b.f12647a.a(this.u);
        if (this.k != null) {
            TextView textView = (TextView) this.k.findViewById(R.id.inter_company);
            this.v = textView;
            if (textView != null) {
                textView.setTextColor(i);
            }
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.c.k, sg.bigo.ads.ad.interstitial.c.a
    protected final void a(int i, boolean z, boolean z2) {
        sg.bigo.ads.ad.b.a.a(this.s, 5);
        sg.bigo.ads.ad.b.a.a(this.t, 5);
        if (z) {
            sg.bigo.ads.ad.b.a.a(this.j, this.s, 4, this.f, i);
            sg.bigo.ads.ad.b.a.a(this.j, this.t, 4, this.f, i);
        } else {
            sg.bigo.ads.ad.b.a.a(this.j, this.s, 4, sg.bigo.ads.ad.interstitial.a.F, 0);
            sg.bigo.ads.ad.b.a.a(this.j, this.t, 4, sg.bigo.ads.ad.interstitial.a.F, 0);
        }
        sg.bigo.ads.ad.b.a.a(this.k, 9);
        ViewGroup viewGroup = this.j;
        if (z2) {
            sg.bigo.ads.ad.b.a.a(viewGroup, this.k, 4, this.f, i);
        } else {
            sg.bigo.ads.ad.b.a.a(viewGroup, this.k, 4, sg.bigo.ads.ad.interstitial.a.F, 0);
        }
        boolean z3 = true;
        if (this.g != null && this.g.a("endpage.ad_component_clickable_switch") != 1) {
            z3 = false;
        }
        if (this.o != null) {
            sg.bigo.ads.ad.b.a.a(this.o, 18);
            ViewGroup viewGroup2 = this.j;
            if (z3) {
                sg.bigo.ads.ad.b.a.a(viewGroup2, this.o, 8, this.f, i);
            } else {
                sg.bigo.ads.ad.b.a.a(viewGroup2, this.o, 8, sg.bigo.ads.ad.interstitial.a.F, 0);
            }
        }
        IconListView iconListView = this.x;
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

    @Override // sg.bigo.ads.ad.interstitial.c.k
    protected final void a(sg.bigo.ads.ad.interstitial.q qVar, Rect rect) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.x.getLayoutParams();
        layoutParams.addRule(3, this.r.getId());
        layoutParams.addRule(2, 0);
        this.x.requestLayout();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.u.getLayoutParams();
        layoutParams2.addRule(12, 0);
        layoutParams2.addRule(3, sg.bigo.ads.common.utils.k.a((Collection) this.x.getItems()) ? this.r.getId() : this.x.getId());
        this.u.requestLayout();
        sg.bigo.ads.common.p pVarB = b(qVar);
        int iA = sg.bigo.ads.common.utils.e.a(this.r.getContext(), 16);
        int iWidth = rect.width();
        int iHeight = rect.height();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.r.getLayoutParams();
        layoutParams3.addRule(2, 0);
        sg.bigo.ads.common.p pVarB2 = sg.bigo.ads.common.p.b(pVarB.b, pVarB.c, iWidth);
        if (pVarB2.c <= iHeight) {
            layoutParams3.height = pVarB2.c;
        } else {
            int i = iA * 2;
            layoutParams3.height = sg.bigo.ads.common.p.a(pVarB.b, pVarB.c, iWidth - i, iHeight - i).c + i;
            ((ViewGroup.MarginLayoutParams) this.s.getLayoutParams()).setMargins(iA, iA, iA, iA);
            this.s.requestLayout();
        }
        this.r.requestLayout();
    }

    @Override // sg.bigo.ads.ad.interstitial.c.k, sg.bigo.ads.ad.interstitial.c.a
    protected final void d(sg.bigo.ads.ad.interstitial.q qVar) {
        IconListView iconListView;
        int i;
        super.d(qVar);
        if (this.k == null) {
            return;
        }
        this.w = (TextView) this.k.findViewById(R.id.inter_description);
        sg.bigo.ads.ad.interstitial.b.f12647a.a(null, this.w);
        IconListView iconListView2 = (IconListView) this.k.findViewById(R.id.inter_download_msg);
        this.x = iconListView2;
        iconListView2.a(this.i);
        if (sg.bigo.ads.common.utils.k.a((Collection) this.x.getItems())) {
            iconListView = this.x;
            i = 8;
        } else {
            iconListView = this.x;
            i = 0;
        }
        iconListView.setVisibility(i);
        int iA = sg.bigo.ads.common.utils.e.a(this.k.getContext(), 16);
        if (this.o != null) {
            float f = iA;
            this.o.setBackground(sg.bigo.ads.common.utils.d.a(f, f, f, f, (Rect) null, -1));
            sg.bigo.ads.ad.interstitial.b.f12647a.b(this.o);
        }
        a(qVar, this.t);
    }

    @Override // sg.bigo.ads.ad.interstitial.c.k, sg.bigo.ads.ad.interstitial.c.a
    protected final int h() {
        return R.layout.bigo_ad_activity_interstitial_rich_video_end_19;
    }

    @Override // sg.bigo.ads.ad.interstitial.c.k
    protected final sg.bigo.ads.ad.interstitial.b l() {
        return sg.bigo.ads.ad.interstitial.b.f12647a;
    }
}
