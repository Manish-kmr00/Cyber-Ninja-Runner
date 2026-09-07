package sg.bigo.ads.ad.interstitial.c;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import sg.bigo.ads.R;

/* JADX INFO: loaded from: classes4.dex */
public class t extends s {
    public t(sg.bigo.ads.ad.b.c cVar, int i, sg.bigo.ads.api.a.m mVar, sg.bigo.ads.ad.interstitial.multi_img.b bVar, sg.bigo.ads.ad.interstitial.e.c cVar2) {
        super(cVar, i, mVar, bVar, cVar2);
    }

    @Override // sg.bigo.ads.ad.interstitial.c.s, sg.bigo.ads.ad.interstitial.c.a
    protected final void a(sg.bigo.ads.ad.interstitial.q qVar, int i) {
        super.a(qVar, i);
        if (this.g == null) {
            return;
        }
        final View viewFindViewById = this.k.findViewById(R.id.inter_btn_cta_layout);
        final Button button = (Button) this.k.findViewById(R.id.inter_btn_cta);
        if (button == null) {
            return;
        }
        int iMax = Math.max(1, i);
        final Pair<Integer, Boolean> pairE = e(qVar);
        button.postDelayed(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.c.t.1
            @Override // java.lang.Runnable
            public final void run() {
                if (sg.bigo.ads.ad.c.a((sg.bigo.ads.ad.c) t.this.f)) {
                    return;
                }
                sg.bigo.ads.ad.interstitial.d.a(button, ((Integer) pairE.first).intValue(), new sg.bigo.ads.common.w.b.a() { // from class: sg.bigo.ads.ad.interstitial.c.t.1.1
                    @Override // sg.bigo.ads.common.w.b.a
                    public final void b(int i2) {
                        if (viewFindViewById == null || !((Boolean) pairE.second).booleanValue()) {
                            return;
                        }
                        sg.bigo.ads.ad.interstitial.c.e(viewFindViewById);
                    }
                });
            }
        }, ((long) iMax) * 1000);
    }

    @Override // sg.bigo.ads.ad.interstitial.c.s, sg.bigo.ads.ad.interstitial.c.b
    protected final void g(sg.bigo.ads.ad.interstitial.q qVar) {
        super.g(qVar);
        this.r.setVisibility(4);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.l.getLayoutParams();
        marginLayoutParams.topMargin = sg.bigo.ads.common.utils.e.a(this.l.getContext(), 0);
        this.l.setLayoutParams(marginLayoutParams);
    }

    @Override // sg.bigo.ads.ad.interstitial.c.s, sg.bigo.ads.ad.interstitial.c.a
    protected final int h() {
        return R.layout.bigo_ad_activity_interstitial_rich_video_end_7;
    }
}
