package sg.bigo.ads.ad.interstitial.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import sg.bigo.ads.R;
import sg.bigo.ads.api.AdOptionsView;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.NativeAd;
import sg.bigo.ads.common.utils.k;
import sg.bigo.ads.common.view.RoundedFrameLayout;

/* JADX INFO: loaded from: classes10.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final sg.bigo.ads.ad.interstitial.e.b.a f12810a;
    protected final List<NativeAd> b;
    protected final sg.bigo.ads.ad.interstitial.e.a.b c;
    protected final Context d;
    protected final b e;
    protected boolean f = false;
    protected final sg.bigo.ads.ad.interstitial.e.a.b.a g;
    protected final float h;
    private final float i;

    public d(sg.bigo.ads.ad.interstitial.e.b.a aVar, List<NativeAd> list, sg.bigo.ads.ad.interstitial.e.a.b bVar) {
        this.f12810a = aVar;
        this.b = list;
        this.c = bVar;
        Context context = aVar.getContext();
        this.d = context;
        this.g = bVar.a();
        this.h = sg.bigo.ads.common.utils.e.a(context, 1);
        this.i = sg.bigo.ads.common.utils.e.a(context, 4);
        this.e = a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(View view, b bVar) {
        if (bVar == null) {
            bVar = this.e;
        }
        if (bVar == null || view == 0) {
            return;
        }
        Drawable drawableA = bVar.a();
        if (drawableA != null) {
            view.setBackground(drawableA);
            view.setPadding(0, 0, 0, 0);
        } else if (view instanceof sg.bigo.ads.common.view.a.c) {
            ((sg.bigo.ads.common.view.a.c) view).setBlurStyle(bVar);
        }
    }

    protected abstract b a();

    protected final void a(int i, int i2, int i3, int i4) {
        this.f12810a.setPadding(sg.bigo.ads.common.utils.e.a(this.d, i), sg.bigo.ads.common.utils.e.a(this.d, i2), sg.bigo.ads.common.utils.e.a(this.d, i3), sg.bigo.ads.common.utils.e.a(this.d, i4));
    }

    protected final void a(View view) {
        a(view, null);
    }

    public final void a(a aVar) {
        this.f12810a.removeAllViews();
        List<View> listB = b(aVar);
        if (k.a((Collection) listB)) {
            return;
        }
        for (int i = 0; i < listB.size() && i < this.b.size(); i++) {
            View view = listB.get(i);
            NativeAd nativeAd = this.b.get(i);
            if (view != null && nativeAd != null) {
                ArrayList arrayList = new ArrayList();
                RoundedFrameLayout roundedFrameLayout = (RoundedFrameLayout) view.findViewById(R.id.inter_icon_ads_icon_item_layout);
                if (roundedFrameLayout != null) {
                    roundedFrameLayout.setStrokeWidth(this.h);
                    roundedFrameLayout.setStrokeColor(this.g.j);
                }
                ImageView imageView = (ImageView) view.findViewById(R.id.inter_icon_ads_item_icon);
                if (imageView != null) {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    imageView.setTag(1);
                    arrayList.add(imageView);
                    imageView.setBackgroundColor(this.g.i);
                    imageView.setImageDrawable(sg.bigo.ads.common.utils.a.a(imageView.getContext(), R.drawable.bigo_ad_icon_default));
                }
                TextView textView = (TextView) view.findViewById(R.id.inter_icon_ads_item_title);
                if (textView != null) {
                    textView.setTextColor(this.g.d);
                    textView.setText(nativeAd.getTitle());
                    textView.setTag(2);
                    arrayList.add(textView);
                }
                TextView textView2 = (TextView) view.findViewById(R.id.inter_icon_ads_item_desc);
                if (textView2 != null) {
                    textView2.setTextColor(this.g.d);
                    textView2.setText(nativeAd.getDescription());
                    textView2.setTag(6);
                    arrayList.add(textView2);
                }
                Button button = (Button) view.findViewById(R.id.inter_icon_ads_item_btn_cta);
                if (button != null) {
                    button.setText(nativeAd.getCallToAction());
                    button.setTag(7);
                    arrayList.add(button);
                    float f = this.i;
                    button.setBackground(sg.bigo.ads.common.utils.d.a(f, f, f, f, this.g.k, this.g.l, this.h));
                }
                ViewGroup viewGroup = listB.size() == 1 ? this.f12810a : (ViewGroup) view;
                if (nativeAd instanceof sg.bigo.ads.ad.b.c) {
                    sg.bigo.ads.ad.b.c cVar = (sg.bigo.ads.ad.b.c) nativeAd;
                    cVar.G = this.c.i();
                    if (this.f) {
                        sg.bigo.ads.ad.b.a.a(viewGroup, viewGroup, 1, cVar, this.c.i());
                    }
                }
                nativeAd.registerViewForInteraction(viewGroup, (MediaView) null, imageView, (AdOptionsView) null, arrayList);
            }
        }
    }

    protected final void a(b bVar) {
        a(this.f12810a, bVar);
    }

    public final int b() {
        return this.b.size();
    }

    protected abstract List<View> b(a aVar);

    protected final void b(View view) {
        view.setPadding(sg.bigo.ads.common.utils.e.a(this.d, 12), sg.bigo.ads.common.utils.e.a(this.d, 0), sg.bigo.ads.common.utils.e.a(this.d, 12), sg.bigo.ads.common.utils.e.a(this.d, 12));
    }

    protected final void c() {
        a(this.f12810a, null);
    }
}
