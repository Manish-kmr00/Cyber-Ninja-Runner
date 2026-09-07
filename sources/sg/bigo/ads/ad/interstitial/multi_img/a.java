package sg.bigo.ads.ad.interstitial.multi_img;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.common.view.ViewFlow;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ViewGroup f12844a;
    final ViewFlow d;
    final int e;
    private final sg.bigo.ads.ad.interstitial.d h;
    int b = -1;
    int c = -1;
    public boolean f = true;
    float g = Float.MIN_VALUE;

    public a(ViewGroup viewGroup, ViewFlow viewFlow, sg.bigo.ads.ad.interstitial.d dVar, int i) {
        this.f12844a = viewGroup;
        this.d = viewFlow;
        this.h = dVar;
        this.e = i;
    }

    public static void a(ViewGroup viewGroup, BitmapDrawable bitmapDrawable, BitmapDrawable bitmapDrawable2) {
        a(viewGroup, "adview_background_main_tag", bitmapDrawable);
        a(viewGroup, "adview_background_second_tag", bitmapDrawable2);
    }

    public static void a(ViewGroup viewGroup, Object obj, BitmapDrawable bitmapDrawable) {
        ImageView imageView;
        View viewFindViewWithTag = viewGroup.findViewWithTag(obj);
        if (viewFindViewWithTag instanceof ImageView) {
            imageView = (ImageView) viewFindViewWithTag;
        } else {
            Context context = viewGroup.getContext();
            if (context != null) {
                ImageView imageView2 = new ImageView(context);
                imageView2.setTag(obj);
                imageView2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                u.a(imageView2, viewGroup, null, 0);
                imageView = imageView2;
            } else {
                imageView = null;
            }
        }
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageDrawable(bitmapDrawable);
        }
    }

    public final void a(final int i) {
        if (this.f) {
            sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.multi_img.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    a aVar = a.this;
                    int i2 = i;
                    if (i2 == aVar.b && i2 == aVar.c) {
                        aVar.b(i2);
                    }
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0042  */
    final void a(sg.bigo.ads.ad.interstitial.multi_img.view.d dVar, float f, int i) {
        Integer numValueOf;
        if (i != this.b) {
            return;
        }
        boolean zD = dVar.d(this.e);
        int i2 = zD ? dVar.n : dVar.o;
        this.g = f;
        this.c = f > 0.0f ? i - 1 : i + 1;
        View viewA = this.d.a(this.c);
        if (viewA != null) {
            Object tag = viewA.getTag(sg.bigo.ads.ad.interstitial.multi_img.view.d.e);
            if (tag instanceof sg.bigo.ads.ad.interstitial.multi_img.view.d) {
                sg.bigo.ads.ad.interstitial.multi_img.view.d dVar2 = (sg.bigo.ads.ad.interstitial.multi_img.view.d) tag;
                numValueOf = Integer.valueOf(zD ? dVar2.n : dVar2.o);
            } else {
                numValueOf = null;
            }
        } else {
            numValueOf = null;
        }
        int iA = this.h.a(sg.bigo.ads.common.w.b.a(Math.abs(f), i2, numValueOf == null ? i2 : numValueOf.intValue()));
        if (zD) {
            this.f12844a.setBackgroundColor(iA);
        }
    }

    public final void b(int i) {
        if (this.f) {
            View viewA = this.d.a(i);
            Object tag = viewA.getTag(sg.bigo.ads.ad.interstitial.multi_img.view.d.e);
            if (tag instanceof sg.bigo.ads.ad.interstitial.multi_img.view.d) {
                sg.bigo.ads.ad.interstitial.multi_img.view.d dVar = (sg.bigo.ads.ad.interstitial.multi_img.view.d) tag;
                this.b = i;
                this.g = Float.MIN_VALUE;
                this.c = i;
                if (dVar.d(this.e)) {
                    this.f12844a.setBackgroundColor(this.h.a(dVar.n));
                    return;
                }
                if (dVar.c(this.e)) {
                    this.h.a(dVar.o);
                    Bitmap bitmap = dVar.p;
                    int i2 = dVar.q;
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(viewA.getResources(), bitmap);
                    bitmapDrawable.setAlpha(i2);
                    ViewGroup viewGroup = this.f12844a;
                    if (bitmap == null) {
                        bitmapDrawable = null;
                    }
                    a(viewGroup, bitmapDrawable, (BitmapDrawable) null);
                }
            }
        }
    }
}
