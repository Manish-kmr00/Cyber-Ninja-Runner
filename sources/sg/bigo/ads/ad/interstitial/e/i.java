package sg.bigo.ads.ad.interstitial.e;

import android.graphics.Rect;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;
import sg.bigo.ads.R;
import sg.bigo.ads.api.NativeAd;

/* JADX INFO: loaded from: classes10.dex */
public final class i extends d {
    public i(sg.bigo.ads.ad.interstitial.e.b.a aVar, List<NativeAd> list, sg.bigo.ads.ad.interstitial.e.a.b bVar) {
        super(aVar, list, bVar);
        this.f = true;
    }

    @Override // sg.bigo.ads.ad.interstitial.e.d
    protected final b a() {
        float fA = sg.bigo.ads.common.utils.e.a(this.d, 8);
        return new b(fA, fA, fA, fA, new Rect(0, sg.bigo.ads.common.utils.e.a(this.d, 10), 0, 0), this.h, null, this.g);
    }

    @Override // sg.bigo.ads.ad.interstitial.e.d
    protected final List<View> b(a aVar) {
        ArrayList arrayList;
        LinearLayout linearLayout;
        int size = this.b.size();
        if (size == 0) {
            return new ArrayList();
        }
        if (size == 1) {
            View viewA = sg.bigo.ads.common.utils.a.a(this.d, R.layout.bigo_ad_layout_interstitial_icon_item_cta_des_style2, this.f12810a, false);
            c();
            this.f12810a.setOrientation(0);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(viewA);
            a(12, 0, 12, 12);
            this.f12810a.addView(viewA, new LinearLayout.LayoutParams(-1, sg.bigo.ads.common.utils.e.a(this.d, 60)));
            return arrayList2;
        }
        if (size != 2) {
            View viewA2 = sg.bigo.ads.common.utils.a.a(this.d, R.layout.bigo_ad_layout_interstitial_icon_item_cta_des_style2, this.f12810a, false);
            View viewA3 = sg.bigo.ads.common.utils.a.a(this.d, R.layout.bigo_ad_layout_interstitial_icon_item_cta_des_style2, this.f12810a, false);
            View viewA4 = sg.bigo.ads.common.utils.a.a(this.d, R.layout.bigo_ad_layout_interstitial_icon_item_cta_des_style2, this.f12810a, false);
            this.f12810a.setOrientation(1);
            arrayList = new ArrayList();
            int iA = sg.bigo.ads.common.utils.e.a(this.d, 60);
            LinearLayout linearLayout2 = new LinearLayout(this.d);
            linearLayout2.setOrientation(0);
            a(linearLayout2);
            b(linearLayout2);
            this.f12810a.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
            linearLayout2.addView(viewA2, new LinearLayout.LayoutParams(-1, iA));
            arrayList.add(linearLayout2);
            LinearLayout linearLayout3 = new LinearLayout(this.d);
            linearLayout3.setOrientation(0);
            a(linearLayout3);
            b(linearLayout3);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = sg.bigo.ads.common.utils.e.a(this.d, 8);
            layoutParams.bottomMargin = sg.bigo.ads.common.utils.e.a(this.d, 8);
            this.f12810a.addView(linearLayout3, layoutParams);
            linearLayout3.addView(viewA3, new LinearLayout.LayoutParams(-1, iA));
            arrayList.add(linearLayout3);
            linearLayout = new LinearLayout(this.d);
            linearLayout.setOrientation(0);
            a(linearLayout);
            b(linearLayout);
            this.f12810a.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
            linearLayout.addView(viewA4, new LinearLayout.LayoutParams(-1, iA));
        } else {
            View viewA5 = sg.bigo.ads.common.utils.a.a(this.d, R.layout.bigo_ad_layout_interstitial_icon_item_cta_des_style2, this.f12810a, false);
            View viewA6 = sg.bigo.ads.common.utils.a.a(this.d, R.layout.bigo_ad_layout_interstitial_icon_item_cta_des_style2, this.f12810a, false);
            this.f12810a.setOrientation(1);
            arrayList = new ArrayList();
            int iA2 = sg.bigo.ads.common.utils.e.a(this.d, 60);
            LinearLayout linearLayout4 = new LinearLayout(this.d);
            linearLayout4.setOrientation(0);
            a(linearLayout4);
            b(linearLayout4);
            this.f12810a.addView(linearLayout4, new LinearLayout.LayoutParams(-1, -2));
            linearLayout4.addView(viewA5, new LinearLayout.LayoutParams(-1, iA2));
            arrayList.add(linearLayout4);
            linearLayout = new LinearLayout(this.d);
            linearLayout.setOrientation(0);
            a(linearLayout);
            b(linearLayout);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = sg.bigo.ads.common.utils.e.a(this.d, 8);
            this.f12810a.addView(linearLayout, layoutParams2);
            linearLayout.addView(viewA6, new LinearLayout.LayoutParams(-1, iA2));
        }
        arrayList.add(linearLayout);
        return arrayList;
    }
}
