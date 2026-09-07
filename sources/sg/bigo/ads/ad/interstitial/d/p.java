package sg.bigo.ads.ad.interstitial.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import sg.bigo.ads.R;

/* JADX INFO: loaded from: classes10.dex */
public final class p extends o {
    public p(sg.bigo.ads.ad.b.c cVar) {
        super(cVar);
    }

    @Override // sg.bigo.ads.ad.interstitial.d.o
    protected final boolean L() {
        return false;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.o, sg.bigo.ads.ad.interstitial.d.m
    protected final void a(sg.bigo.ads.ad.interstitial.q qVar) {
        super.a(qVar);
        this.y.setVisibility(4);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.v.getLayoutParams();
        marginLayoutParams.topMargin = sg.bigo.ads.common.utils.e.a(this.v.getContext(), 0);
        this.v.setLayoutParams(marginLayoutParams);
    }

    @Override // sg.bigo.ads.ad.interstitial.d.o, sg.bigo.ads.ad.interstitial.d.m
    protected final void b(int i) {
        super.b(i);
        if (B() == null) {
            return;
        }
        final View viewFindViewById = this.q.findViewById(R.id.inter_btn_cta_layout);
        final Button button = (Button) this.q.findViewById(R.id.inter_btn_cta);
        if (button == null) {
            return;
        }
        button.postDelayed(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.p.1
            @Override // java.lang.Runnable
            public final void run() {
                if (sg.bigo.ads.ad.c.a((sg.bigo.ads.ad.c) p.this.c)) {
                    return;
                }
                a.C0838a c0838aU = p.this.u();
                sg.bigo.ads.common.w.b.a aVar = new sg.bigo.ads.common.w.b.a() { // from class: sg.bigo.ads.ad.interstitial.d.p.1.1
                    @Override // sg.bigo.ads.common.w.b.a
                    public final void b(int i2) {
                        if (viewFindViewById == null || !p.this.v()) {
                            return;
                        }
                        sg.bigo.ads.ad.interstitial.c.e(viewFindViewById);
                    }
                };
                if (c0838aU.b) {
                    p.this.a(button, aVar);
                } else {
                    sg.bigo.ads.ad.interstitial.d.a(button, c0838aU.f12723a, aVar);
                }
            }
        }, ((long) Math.max(1, i)) * 1000);
    }
}
