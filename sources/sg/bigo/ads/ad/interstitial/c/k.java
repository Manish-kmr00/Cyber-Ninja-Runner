package sg.bigo.ads.ad.interstitial.c;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import sg.bigo.ads.R;
import sg.bigo.ads.common.view.RoundedImageView;

/* JADX INFO: loaded from: classes5.dex */
public class k extends a {
    protected View o;
    protected RoundedImageView p;
    protected TextView q;
    protected View r;
    protected RoundedImageView s;
    protected RoundedImageView t;
    protected Button u;

    public k(sg.bigo.ads.ad.b.c cVar, int i, sg.bigo.ads.api.a.m mVar, sg.bigo.ads.ad.interstitial.e.c cVar2) {
        super(cVar, i, mVar, cVar2);
    }

    @Override // sg.bigo.ads.ad.interstitial.c.a
    protected final void a(double d) {
        if (d <= 3.0d) {
            if (this.l != null) {
                this.l.setTextColor(sg.bigo.ads.common.w.b.a(sg.bigo.ads.ad.interstitial.d.b, 0.6f));
            }
        } else if (this.l != null) {
            this.l.setTextColor(sg.bigo.ads.common.w.b.a(sg.bigo.ads.ad.interstitial.d.f12709a, 0.6f));
        }
    }

    protected void a(int i) {
        Button button = (Button) this.k.findViewById(R.id.inter_btn_cta);
        this.u = button;
        if (button != null) {
            float fA = sg.bigo.ads.common.utils.e.a(this.k.getContext(), 8);
            this.u.setBackground(sg.bigo.ads.common.utils.d.a(fA, fA, fA, fA, (Rect) null, i));
            sg.bigo.ads.ad.interstitial.d.a(this.u, sg.bigo.ads.common.w.b.a(i));
            l().a(this.u);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.c.a
    protected void a(int i, boolean z, boolean z2) {
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
        if (z2) {
            sg.bigo.ads.ad.b.a.a(this.j, this.k, 4, this.f, i);
        } else {
            sg.bigo.ads.ad.b.a.a(this.j, this.k, 4, sg.bigo.ads.ad.interstitial.a.F, 0);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.c.a
    protected final void a(final Runnable runnable) {
        super.a(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.c.k.2
            @Override // java.lang.Runnable
            public final void run() {
                k.this.m();
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        });
    }

    protected void a(sg.bigo.ads.ad.interstitial.q qVar, Rect rect) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.u.getLayoutParams();
        layoutParams.addRule(12, 0);
        layoutParams.addRule(3, this.r.getId());
        this.u.requestLayout();
        sg.bigo.ads.common.p pVarB = b(qVar);
        int iA = sg.bigo.ads.common.utils.e.a(this.r.getContext(), 16);
        int iWidth = rect.width();
        int iHeight = rect.height();
        int i = iA * 2;
        int i2 = iWidth - i;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.r.getLayoutParams();
        layoutParams2.addRule(2, 0);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.s.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.t.getLayoutParams();
        sg.bigo.ads.common.p pVarA = sg.bigo.ads.common.p.a(pVarB.b, pVarB.c, iWidth, iHeight - i);
        sg.bigo.ads.common.p pVarA2 = sg.bigo.ads.common.p.a(pVarB.b, pVarB.c, i2, iHeight);
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
        this.r.requestLayout();
        this.s.requestLayout();
        this.t.requestLayout();
    }

    @Override // sg.bigo.ads.ad.interstitial.c.a
    protected void d(final sg.bigo.ads.ad.interstitial.q qVar) {
        if (this.k == null) {
            return;
        }
        this.o = this.k.findViewById(R.id.inter_end_page);
        this.p = (RoundedImageView) this.k.findViewById(R.id.inter_icon);
        this.q = (TextView) this.k.findViewById(R.id.inter_title);
        l().a(this.p);
        l().a(this.q, null);
        this.r = this.k.findViewById(R.id.inter_end_page_image_layout);
        this.s = (RoundedImageView) this.k.findViewById(R.id.inter_end_page_image);
        this.t = (RoundedImageView) this.k.findViewById(R.id.inter_end_page_image_background);
        float fA = sg.bigo.ads.common.utils.e.a(this.s.getContext(), 8);
        this.s.setCornerRadius(fA);
        this.t.setCornerRadius(fA);
        this.t.setBackgroundColor(654311423);
        sg.bigo.ads.common.utils.u.a(this.r, new sg.bigo.ads.common.utils.u.a() { // from class: sg.bigo.ads.ad.interstitial.c.k.1
            @Override // sg.bigo.ads.common.utils.u.a
            public final void a(Rect rect) {
                k.this.a(qVar, rect);
            }
        });
        a(f(qVar));
    }

    @Override // sg.bigo.ads.ad.interstitial.u
    public final boolean d() {
        sg.bigo.ads.core.a.a aVar;
        if (this.f == null || (aVar = (sg.bigo.ads.core.a.a) this.f.f()) == null) {
            return true;
        }
        return aVar.aQ();
    }

    @Override // sg.bigo.ads.ad.interstitial.u
    public final boolean f() {
        return true;
    }

    @Override // sg.bigo.ads.ad.interstitial.c.a
    protected int h() {
        return R.layout.bigo_ad_activity_interstitial_rich_video_end_18;
    }

    @Override // sg.bigo.ads.ad.interstitial.c.a
    protected final void i() {
        String strI = ((sg.bigo.ads.core.a.a) this.f.f()).i();
        TextView textView = (TextView) this.k.findViewById(R.id.inter_advertiser);
        if (TextUtils.isEmpty(strI)) {
            textView.setVisibility(8);
        } else {
            textView.setText(strI);
        }
    }

    protected sg.bigo.ads.ad.interstitial.b l() {
        return sg.bigo.ads.ad.interstitial.b.d;
    }

    protected final void m() {
        if (this.u == null || !j()) {
            return;
        }
        sg.bigo.ads.ad.interstitial.c.e(this.u);
    }
}
