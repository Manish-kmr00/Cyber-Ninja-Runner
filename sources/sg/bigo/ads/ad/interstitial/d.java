package sg.bigo.ads.ad.interstitial;

import android.webkit.ValueCallback;
import android.widget.TextView;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes8.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f12709a = -1;
    public static int b = -14671580;
    private final WeakHashMap<TextView, d> d = new WeakHashMap<>();
    private final WeakHashMap<ValueCallback<Double>, d> e = new WeakHashMap<>();
    private double f = Double.NaN;
    int c = b;

    public interface a {
        int a();
    }

    public static void a(TextView textView, double d) {
        if (textView == null) {
            return;
        }
        textView.setTextColor(d <= 3.0d ? b : f12709a);
    }

    public static void a(TextView textView, int i) {
        if (textView == null) {
            return;
        }
        a(textView, sg.bigo.ads.common.w.b.a(i));
    }

    public static void a(final TextView textView, int i, final sg.bigo.ads.common.w.b.a aVar) {
        if (textView == null) {
            return;
        }
        sg.bigo.ads.common.w.b.a(textView, i, new sg.bigo.ads.common.w.b.a() { // from class: sg.bigo.ads.ad.interstitial.d.1
            @Override // sg.bigo.ads.common.w.b.a
            public final long a() {
                sg.bigo.ads.common.w.b.a aVar2 = aVar;
                if (aVar2 != null) {
                    return aVar2.a();
                }
                return 0L;
            }

            @Override // sg.bigo.ads.common.w.b.a
            public final boolean a(int i2) {
                d.a(textView, sg.bigo.ads.common.w.b.a(i2));
                sg.bigo.ads.common.w.b.a aVar2 = aVar;
                if (aVar2 == null) {
                    return false;
                }
                aVar2.a(i2);
                return false;
            }

            @Override // sg.bigo.ads.common.w.b.a
            public final void b(int i2) {
                sg.bigo.ads.common.w.b.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.b(i2);
                }
            }
        });
    }

    public static void b(TextView textView, int i) {
        a(textView, i, null);
    }

    public final int a(int i) {
        int iB = sg.bigo.ads.common.w.b.b(i);
        this.f = sg.bigo.ads.common.w.b.a(iB);
        Iterator<Map.Entry<TextView, d>> it = this.d.entrySet().iterator();
        while (it.hasNext()) {
            TextView key = it.next().getKey();
            if (key != null) {
                a(key, this.f);
                this.c = this.f <= 3.0d ? b : f12709a;
            }
        }
        Iterator<Map.Entry<ValueCallback<Double>, d>> it2 = this.e.entrySet().iterator();
        while (it2.hasNext()) {
            ValueCallback<Double> key2 = it2.next().getKey();
            if (key2 != null) {
                key2.onReceiveValue(Double.valueOf(this.f));
            }
        }
        return iB;
    }

    public final void a(ValueCallback<Double> valueCallback) {
        if (valueCallback == null) {
            return;
        }
        this.e.put(valueCallback, this);
        double d = this.f;
        if (d != Double.MIN_VALUE) {
            valueCallback.onReceiveValue(Double.valueOf(d));
        }
    }

    public final void a(TextView textView) {
        if (textView == null) {
            return;
        }
        this.d.remove(textView);
    }

    public final void b(TextView textView) {
        if (textView == null) {
            return;
        }
        this.d.put(textView, this);
        double d = this.f;
        if (d != Double.NaN) {
            a(textView, d);
        }
    }
}
