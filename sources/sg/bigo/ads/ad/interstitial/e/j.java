package sg.bigo.ads.ad.interstitial.e;

import android.graphics.Rect;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import java.util.ArrayList;
import java.util.List;
import sg.bigo.ads.R;
import sg.bigo.ads.api.NativeAd;

/* JADX INFO: loaded from: classes10.dex */
public final class j extends d {
    public final int i;
    private final b j;

    public j(sg.bigo.ads.ad.interstitial.e.b.a aVar, List<NativeAd> list, sg.bigo.ads.ad.interstitial.e.a.b bVar) {
        super(aVar, list, bVar);
        this.i = sg.bigo.ads.common.utils.e.a(this.d, 72);
        this.j = new b(sg.bigo.ads.common.utils.e.a(this.d, 8), this.h, this.g);
    }

    private List<View> a(View view, View view2, View view3, View view4, View view5, View view6) {
        c();
        this.f12810a.setOrientation(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(view);
        arrayList.add(view2);
        arrayList.add(view3);
        arrayList.add(view4);
        arrayList.add(view5);
        a(0, 0, 0, 16);
        LinearLayout linearLayout = new LinearLayout(this.d);
        linearLayout.setOrientation(0);
        this.f12810a.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(new Space(this.d), new LinearLayout.LayoutParams(0, 60, 1.0f));
        linearLayout.addView(view, new LinearLayout.LayoutParams(this.i, -2));
        linearLayout.addView(new Space(this.d), new LinearLayout.LayoutParams(0, 60, 1.0f));
        linearLayout.addView(view2, new LinearLayout.LayoutParams(this.i, -2));
        linearLayout.addView(new Space(this.d), new LinearLayout.LayoutParams(0, 60, 1.0f));
        linearLayout.addView(view3, new LinearLayout.LayoutParams(this.i, -2));
        linearLayout.addView(new Space(this.d), new LinearLayout.LayoutParams(0, 60, 1.0f));
        LinearLayout linearLayout2 = new LinearLayout(this.d);
        linearLayout2.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = sg.bigo.ads.common.utils.e.a(this.d, 12);
        this.f12810a.addView(linearLayout2, layoutParams);
        linearLayout2.addView(new Space(this.d), new LinearLayout.LayoutParams(0, 60, 1.0f));
        linearLayout2.addView(view4, new LinearLayout.LayoutParams(this.i, -2));
        linearLayout2.addView(new Space(this.d), new LinearLayout.LayoutParams(0, 60, 1.0f));
        linearLayout2.addView(view5, new LinearLayout.LayoutParams(this.i, -2));
        linearLayout2.addView(new Space(this.d), new LinearLayout.LayoutParams(0, 60, 1.0f));
        if (view6 != null) {
            arrayList.add(view6);
            linearLayout2.addView(view6, new LinearLayout.LayoutParams(this.i, -2));
        } else {
            linearLayout2.addView(new Space(this.d), new LinearLayout.LayoutParams(this.i, -2));
        }
        linearLayout2.addView(new Space(this.d), new LinearLayout.LayoutParams(0, 60, 1.0f));
        return arrayList;
    }

    @Override // sg.bigo.ads.ad.interstitial.e.d
    protected final b a() {
        float fA = sg.bigo.ads.common.utils.e.a(this.d, 8);
        return new b(fA, fA, fA, fA, new Rect(0, sg.bigo.ads.common.utils.e.a(this.d, 12), 0, 0), this.h, null, this.g);
    }

    @Override // sg.bigo.ads.ad.interstitial.e.d
    protected final List<View> b(a aVar) {
        ArrayList arrayList;
        View viewA;
        View viewA2;
        View viewA3;
        View viewA4;
        View viewA5;
        View viewA6;
        int size = this.b.size();
        if (size == 0) {
            return new ArrayList();
        }
        if (size == 1) {
            this.f = true;
            View viewA7 = sg.bigo.ads.common.utils.a.a(this.d, R.layout.bigo_ad_layout_interstitial_icon_item_cta_des_style1, this.f12810a, false);
            a(this.j);
            this.f12810a.setOrientation(0);
            arrayList = new ArrayList();
            arrayList.add(viewA7);
            a(20, 16, 20, 16);
            this.f12810a.addView(viewA7, new LinearLayout.LayoutParams(-1, sg.bigo.ads.common.utils.e.a(this.d, 60)));
        } else if (size == 2) {
            this.f = true;
            View viewA8 = sg.bigo.ads.common.utils.a.a(this.d, R.layout.bigo_ad_layout_interstitial_icon_item_cta_des_style1, this.f12810a, false);
            View viewA9 = sg.bigo.ads.common.utils.a.a(this.d, R.layout.bigo_ad_layout_interstitial_icon_item_cta_des_style1, this.f12810a, false);
            a(this.j);
            this.f12810a.setOrientation(1);
            arrayList = new ArrayList();
            arrayList.add(viewA8);
            arrayList.add(viewA9);
            a(20, 16, 20, 16);
            int iA = sg.bigo.ads.common.utils.e.a(this.d, 60);
            this.f12810a.addView(viewA8, new LinearLayout.LayoutParams(-1, iA));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, iA);
            layoutParams.topMargin = sg.bigo.ads.common.utils.e.a(this.d, 20);
            this.f12810a.addView(viewA9, layoutParams);
        } else if (size == 3) {
            View viewA10 = sg.bigo.ads.common.utils.a.a(this.d, R.layout.bigo_ad_layout_interstitial_icon_item_style, this.f12810a, false);
            View viewA11 = sg.bigo.ads.common.utils.a.a(this.d, R.layout.bigo_ad_layout_interstitial_icon_item_style, this.f12810a, false);
            View viewA12 = sg.bigo.ads.common.utils.a.a(this.d, R.layout.bigo_ad_layout_interstitial_icon_item_style, this.f12810a, false);
            c();
            this.f12810a.setOrientation(0);
            arrayList = new ArrayList();
            arrayList.add(viewA10);
            arrayList.add(viewA11);
            arrayList.add(viewA12);
            a(0, 0, 0, 16);
            this.f12810a.addView(new Space(this.d), new LinearLayout.LayoutParams(0, 60, 1.0f));
            this.f12810a.addView(viewA10, new LinearLayout.LayoutParams(this.i, -2));
            this.f12810a.addView(new Space(this.d), new LinearLayout.LayoutParams(0, 60, 1.0f));
            this.f12810a.addView(viewA11, new LinearLayout.LayoutParams(this.i, -2));
            this.f12810a.addView(new Space(this.d), new LinearLayout.LayoutParams(0, 60, 1.0f));
            this.f12810a.addView(viewA12, new LinearLayout.LayoutParams(this.i, -2));
            this.f12810a.addView(new Space(this.d), new LinearLayout.LayoutParams(0, 60, 1.0f));
        } else {
            if (size != 4) {
                if (size != 5) {
                    viewA = sg.bigo.ads.common.utils.a.a(this.d, R.layout.bigo_ad_layout_interstitial_icon_item_style, this.f12810a, false);
                    viewA2 = sg.bigo.ads.common.utils.a.a(this.d, R.layout.bigo_ad_layout_interstitial_icon_item_style, this.f12810a, false);
                    viewA3 = sg.bigo.ads.common.utils.a.a(this.d, R.layout.bigo_ad_layout_interstitial_icon_item_style, this.f12810a, false);
                    viewA4 = sg.bigo.ads.common.utils.a.a(this.d, R.layout.bigo_ad_layout_interstitial_icon_item_style, this.f12810a, false);
                    viewA5 = sg.bigo.ads.common.utils.a.a(this.d, R.layout.bigo_ad_layout_interstitial_icon_item_style, this.f12810a, false);
                    viewA6 = sg.bigo.ads.common.utils.a.a(this.d, R.layout.bigo_ad_layout_interstitial_icon_item_style, this.f12810a, false);
                } else {
                    viewA = sg.bigo.ads.common.utils.a.a(this.d, R.layout.bigo_ad_layout_interstitial_icon_item_style, this.f12810a, false);
                    viewA2 = sg.bigo.ads.common.utils.a.a(this.d, R.layout.bigo_ad_layout_interstitial_icon_item_style, this.f12810a, false);
                    viewA3 = sg.bigo.ads.common.utils.a.a(this.d, R.layout.bigo_ad_layout_interstitial_icon_item_style, this.f12810a, false);
                    viewA4 = sg.bigo.ads.common.utils.a.a(this.d, R.layout.bigo_ad_layout_interstitial_icon_item_style, this.f12810a, false);
                    viewA5 = sg.bigo.ads.common.utils.a.a(this.d, R.layout.bigo_ad_layout_interstitial_icon_item_style, this.f12810a, false);
                    viewA6 = null;
                }
                return a(viewA, viewA2, viewA3, viewA4, viewA5, viewA6);
            }
            View viewA13 = sg.bigo.ads.common.utils.a.a(this.d, R.layout.bigo_ad_layout_interstitial_icon_item_style, this.f12810a, false);
            View viewA14 = sg.bigo.ads.common.utils.a.a(this.d, R.layout.bigo_ad_layout_interstitial_icon_item_style, this.f12810a, false);
            View viewA15 = sg.bigo.ads.common.utils.a.a(this.d, R.layout.bigo_ad_layout_interstitial_icon_item_style, this.f12810a, false);
            View viewA16 = sg.bigo.ads.common.utils.a.a(this.d, R.layout.bigo_ad_layout_interstitial_icon_item_style, this.f12810a, false);
            c();
            this.f12810a.setOrientation(1);
            this.f12810a.setGravity(1);
            arrayList = new ArrayList();
            arrayList.add(viewA13);
            arrayList.add(viewA14);
            arrayList.add(viewA15);
            arrayList.add(viewA16);
            arrayList.add(viewA16);
            a(0, 0, 0, 16);
            LinearLayout linearLayout = new LinearLayout(this.d);
            linearLayout.setOrientation(0);
            this.f12810a.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
            linearLayout.addView(new Space(this.d), new LinearLayout.LayoutParams(0, 60, 1.0f));
            linearLayout.addView(viewA13, new LinearLayout.LayoutParams(this.i, -2));
            linearLayout.addView(new Space(this.d), new LinearLayout.LayoutParams(0, 60, 1.0f));
            linearLayout.addView(viewA14, new LinearLayout.LayoutParams(this.i, -2));
            linearLayout.addView(new Space(this.d), new LinearLayout.LayoutParams(0, 60, 1.0f));
            LinearLayout linearLayout2 = new LinearLayout(this.d);
            linearLayout2.setOrientation(0);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = sg.bigo.ads.common.utils.e.a(this.d, 12);
            this.f12810a.addView(linearLayout2, layoutParams2);
            linearLayout2.addView(new Space(this.d), new LinearLayout.LayoutParams(0, 60, 1.0f));
            linearLayout2.addView(viewA15, new LinearLayout.LayoutParams(this.i, -1));
            linearLayout2.addView(new Space(this.d), new LinearLayout.LayoutParams(0, 60, 1.0f));
            linearLayout2.addView(viewA16, new LinearLayout.LayoutParams(this.i, -2));
            linearLayout2.addView(new Space(this.d), new LinearLayout.LayoutParams(0, 60, 1.0f));
        }
        return arrayList;
    }
}
