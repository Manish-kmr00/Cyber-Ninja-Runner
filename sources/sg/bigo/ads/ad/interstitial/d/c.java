package sg.bigo.ads.ad.interstitial.d;

import android.view.ViewGroup;
import sg.bigo.ads.R;

/* JADX INFO: loaded from: classes12.dex */
public class c extends b {
    public c(sg.bigo.ads.ad.b.c cVar) {
        super(cVar);
    }

    @Override // sg.bigo.ads.ad.interstitial.d.b
    protected final void E() {
        super.E();
        if (this.y != null) {
            ViewGroup.LayoutParams layoutParams = this.y.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += -sg.bigo.ads.common.utils.e.a(this.y.getContext(), 60);
                this.y.requestLayout();
            }
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.d.b
    protected int z() {
        return R.id.inter_component_20;
    }
}
