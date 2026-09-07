package sg.bigo.ads.ad.interstitial.c;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import sg.bigo.ads.R;
import sg.bigo.ads.common.view.RoundedImageView;

/* JADX INFO: loaded from: classes11.dex */
public class i extends g {
    private View t;
    private RoundedImageView u;

    public i(sg.bigo.ads.ad.b.c cVar, int i, sg.bigo.ads.api.a.m mVar, sg.bigo.ads.ad.interstitial.e.c cVar2) {
        super(cVar, i, mVar, cVar2);
    }

    @Override // sg.bigo.ads.ad.interstitial.c.g, sg.bigo.ads.ad.interstitial.c.a
    protected final void a(double d) {
    }

    @Override // sg.bigo.ads.ad.interstitial.c.g, sg.bigo.ads.ad.interstitial.c.a
    protected final void a(int i, boolean z, boolean z2) {
        sg.bigo.ads.ad.b.a.a(this.u, 5);
        if (z) {
            sg.bigo.ads.ad.b.a.a(this.j, this.u, 4, this.f, i);
        } else {
            sg.bigo.ads.ad.b.a.a(this.j, this.u, 4, sg.bigo.ads.ad.interstitial.a.F, 0);
        }
        sg.bigo.ads.ad.b.a.a(this.t, 9);
        ViewGroup viewGroup = this.j;
        if (z2) {
            sg.bigo.ads.ad.b.a.a(viewGroup, this.t, 4, this.f, i);
        } else {
            sg.bigo.ads.ad.b.a.a(viewGroup, this.t, 4, sg.bigo.ads.ad.interstitial.a.F, 0);
        }
        boolean z3 = true;
        if (this.g != null && this.g.a("endpage.ad_component_clickable_switch") != 1) {
            z3 = false;
        }
        if (this.o != null) {
            sg.bigo.ads.ad.b.a.a(this.o, 18);
            if (z3) {
                sg.bigo.ads.ad.b.a.a(this.j, this.o, 8, this.f, i);
            } else {
                sg.bigo.ads.ad.b.a.a(this.j, this.o, 8, sg.bigo.ads.ad.interstitial.a.F, 0);
            }
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.c.g, sg.bigo.ads.ad.interstitial.c.a
    protected final void a(final Runnable runnable) {
        b(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.c.i.2
            @Override // java.lang.Runnable
            public final void run() {
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
                i.this.m();
            }
        });
    }

    @Override // sg.bigo.ads.ad.interstitial.c.g, sg.bigo.ads.ad.interstitial.c.a
    protected final void d(final sg.bigo.ads.ad.interstitial.q qVar) {
        super.d(qVar);
        if (this.k == null) {
            return;
        }
        this.t = this.k.findViewById(R.id.inter_end_page_image_layout);
        this.u = (RoundedImageView) this.k.findViewById(R.id.inter_end_page_image);
        sg.bigo.ads.common.utils.u.a(this.t, new sg.bigo.ads.common.utils.u.a() { // from class: sg.bigo.ads.ad.interstitial.c.i.1
            @Override // sg.bigo.ads.common.utils.u.a
            public final void a(Rect rect) {
                int iA;
                float fA;
                int i;
                int i2;
                sg.bigo.ads.common.p pVarB = i.this.b(qVar);
                if (pVarB.a(rect.width(), rect.height())) {
                    i2 = -1;
                    fA = 0.0f;
                    iA = 0;
                    i = -1;
                } else {
                    iA = sg.bigo.ads.common.utils.e.a(i.this.u.getContext(), 20);
                    int i3 = iA * 2;
                    sg.bigo.ads.common.p pVarA = sg.bigo.ads.common.p.a(pVarB.b, pVarB.c, rect.width() - i3, rect.height() - i3);
                    int i4 = pVarA.b;
                    int i5 = pVarA.c;
                    fA = sg.bigo.ads.common.utils.e.a(i.this.u.getContext(), 8);
                    i = i5;
                    i2 = i4;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) i.this.u.getLayoutParams();
                marginLayoutParams.setMargins(iA, iA, iA, iA);
                marginLayoutParams.width = i2;
                marginLayoutParams.height = i;
                i.this.u.requestLayout();
                i.this.u.setCornerRadius(fA);
            }
        });
        if (this.l != null) {
            sg.bigo.ads.ad.interstitial.d.a(this.l, -1);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.u
    public final boolean d() {
        sg.bigo.ads.core.a.a aVar;
        if (this.f == null || (aVar = (sg.bigo.ads.core.a.a) this.f.f()) == null) {
            return true;
        }
        return aVar.aQ();
    }

    @Override // sg.bigo.ads.ad.interstitial.c.g, sg.bigo.ads.ad.interstitial.c.a
    protected final int h() {
        return R.layout.bigo_ad_activity_interstitial_rich_video_end_16_17;
    }

    @Override // sg.bigo.ads.ad.interstitial.c.g
    protected final void l() {
        if (this.o != null) {
            this.o.setBackgroundColor(-1);
        }
    }
}
