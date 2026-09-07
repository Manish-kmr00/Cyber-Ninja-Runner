package sg.bigo.ads.ad.interstitial.d;

import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes12.dex */
public final class v extends t {
    public v(sg.bigo.ads.ad.b.c cVar) {
        super(cVar);
    }

    @Override // sg.bigo.ads.ad.interstitial.d.t
    protected final boolean B() {
        return false;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.t
    protected final int[] z() {
        int i;
        int i2;
        if (x() == 1) {
            i = ViewCompat.MEASURED_SIZE_MASK;
            i2 = -1;
        } else {
            i = 2105636;
            i2 = ViewCompat.MEASURED_STATE_MASK;
        }
        return new int[]{i, i2};
    }
}
