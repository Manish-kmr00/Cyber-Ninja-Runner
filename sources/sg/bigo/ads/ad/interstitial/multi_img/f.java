package sg.bigo.ads.ad.interstitial.multi_img;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.webkit.ValueCallback;
import sg.bigo.ads.common.view.Indicator;
import sg.bigo.ads.common.view.ViewFlow;

/* JADX INFO: loaded from: classes.dex */
public final class f implements ViewFlow.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f12853a;
    private final Indicator b;
    private final a c;
    private ValueCallback<Integer> d;
    private boolean e = false;
    private int f;

    public f(d dVar, Indicator indicator, a aVar) {
        this.f12853a = dVar;
        this.b = indicator;
        this.c = aVar;
    }

    public static void a(ViewFlow viewFlow, ValueCallback<Integer> valueCallback) {
        if (viewFlow == null || valueCallback == null) {
            return;
        }
        ViewFlow.c onItemChangeListener = viewFlow.getOnItemChangeListener();
        if (onItemChangeListener instanceof f) {
            ((f) onItemChangeListener).d = valueCallback;
        }
    }

    public static boolean a(ViewFlow viewFlow) {
        ViewFlow.c onItemChangeListener = viewFlow != null ? viewFlow.getOnItemChangeListener() : null;
        if (onItemChangeListener == null || !(onItemChangeListener instanceof f)) {
            return false;
        }
        return ((f) onItemChangeListener).e;
    }

    @Override // sg.bigo.ads.common.view.ViewFlow.c
    public final void a(int i) {
        Indicator indicator = this.b;
        if (indicator == null || i <= 1) {
            return;
        }
        if (indicator.getType() != 1) {
            this.b.setNum(i);
        } else {
            Indicator indicator2 = this.b;
            indicator2.setLineLength(Indicator.a(i, indicator2.getDistance(), this.b.getRadius(), this.b.getLengthSelected()));
        }
        this.b.setVisibility(0);
    }

    @Override // sg.bigo.ads.common.view.ViewFlow.c
    public final void a(int i, int i2) {
        Indicator indicator = this.b;
        if (indicator == null || indicator.getType() != 1) {
            return;
        }
        float fMin = Math.min(1.0f, Math.max(0.0f, (i * 1.0f) / i2));
        Indicator indicator2 = this.b;
        if (indicator2.f13316a != fMin) {
            indicator2.f13316a = Math.max(0.0f, Math.min(1.0f, fMin));
            indicator2.invalidate();
        }
    }

    @Override // sg.bigo.ads.common.view.ViewFlow.c
    public final void a(View view, int i) {
        Indicator indicator = this.b;
        if (indicator != null && indicator.getType() != 1) {
            this.b.a(i);
        }
        this.f = i;
        a aVar = this.c;
        if (aVar != null) {
            aVar.b(i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00d5  */
    @Override // sg.bigo.ads.common.view.ViewFlow.c
    public final void a(View view, int i, float f) {
        ValueCallback<Integer> valueCallback;
        Bitmap bitmap;
        int i2;
        float f2 = this.f12853a.h;
        float f3 = ((f < 0.0f ? 1.0f - f2 : f2 - 1.0f) * f) + 1.0f;
        float f4 = this.f12853a.g;
        float f5 = ((f < 0.0f ? 1.0f - f4 : f4 - 1.0f) * f) + 1.0f;
        if (f < 0.0f) {
            view.setPivotX(view.getWidth());
        } else {
            view.setPivotX(0.0f);
        }
        view.setPivotY(view.getHeight() / 2);
        view.setScaleX(f3);
        view.setScaleY(f3);
        view.setAlpha(Math.abs(f5));
        Indicator indicator = this.b;
        if (indicator != null && indicator.getType() != 1) {
            this.b.a(f, i);
        }
        a aVar = this.c;
        if (aVar != null && aVar.f) {
            if (f == 0.0f) {
                aVar.b(i);
            } else {
                Object tag = aVar.d.a(i).getTag(sg.bigo.ads.ad.interstitial.multi_img.view.d.e);
                if (tag instanceof sg.bigo.ads.ad.interstitial.multi_img.view.d) {
                    sg.bigo.ads.ad.interstitial.multi_img.view.d dVar = (sg.bigo.ads.ad.interstitial.multi_img.view.d) tag;
                    if (dVar.d(aVar.e)) {
                        aVar.a(dVar, f, i);
                    } else if (dVar.c(aVar.e)) {
                        if (i == aVar.b) {
                            aVar.g = f;
                            float fMax = Math.max(Math.min(Math.abs(f), 1.0f), 0.0f);
                            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.d.getResources(), dVar.p);
                            bitmapDrawable.setAlpha((int) (dVar.q * (1.0f - fMax)));
                            aVar.c = f > 0.0f ? i - 1 : i + 1;
                            View viewA = aVar.d.a(aVar.c);
                            if (viewA != null) {
                                Object tag2 = viewA.getTag(sg.bigo.ads.ad.interstitial.multi_img.view.d.e);
                                if (tag2 instanceof sg.bigo.ads.ad.interstitial.multi_img.view.d) {
                                    sg.bigo.ads.ad.interstitial.multi_img.view.d dVar2 = (sg.bigo.ads.ad.interstitial.multi_img.view.d) tag2;
                                    bitmap = dVar2.p;
                                    i2 = (int) (dVar2.q * fMax);
                                } else {
                                    bitmap = null;
                                    i2 = 0;
                                }
                            } else {
                                bitmap = null;
                                i2 = 0;
                            }
                            BitmapDrawable bitmapDrawable2 = new BitmapDrawable(aVar.d.getResources(), bitmap);
                            bitmapDrawable2.setAlpha(i2);
                            a.a(aVar.f12844a, bitmapDrawable, bitmapDrawable2);
                        }
                        aVar.a(dVar, f, i);
                    }
                }
            }
        }
        this.e = this.f == i && f != 0.0f;
        if (f != 0.0f || (valueCallback = this.d) == null) {
            return;
        }
        valueCallback.onReceiveValue(Integer.valueOf(i));
    }
}
