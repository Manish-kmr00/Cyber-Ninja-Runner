package sg.bigo.ads.ad.interstitial;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.ValueCallback;
import androidx.core.view.ViewCompat;
import java.util.Iterator;
import java.util.WeakHashMap;
import sg.bigo.ads.api.NativeAd;

/* JADX INFO: loaded from: classes4.dex */
public abstract class u extends e {
    public static long c = 15;
    public static long d = 300;
    public static int e = 255;
    public final sg.bigo.ads.ad.b.c f;
    protected final sg.bigo.ads.api.a.m g;
    private long h = 0;
    private final WeakHashMap<Object, ValueCallback<Bitmap>> i = new WeakHashMap<>();

    public interface a {
        void a(View view);
    }

    public u(sg.bigo.ads.ad.b.c cVar, sg.bigo.ads.api.a.m mVar) {
        this.f = cVar;
        this.g = mVar;
    }

    protected static t a(q qVar) {
        if (qVar != null) {
            return qVar.Z();
        }
        return null;
    }

    private static void a(View view, int i) {
        if (view == null) {
            return;
        }
        view.setBackgroundColor(i);
    }

    public static void a(q qVar, ValueCallback<Bitmap> valueCallback) {
        if (valueCallback == null) {
            return;
        }
        t tVarA = a(qVar);
        if (tVarA == null) {
            valueCallback.onReceiveValue(sg.bigo.ads.common.utils.d.a(1, 1, Bitmap.Config.ARGB_8888));
        } else {
            tVarA.a(valueCallback);
        }
    }

    static /* synthetic */ boolean a(u uVar) {
        return (uVar.h != 0 ? SystemClock.elapsedRealtime() - uVar.h : 0L) > c;
    }

    private void b(q qVar, final View view) {
        int i;
        if (qVar == null || view == null) {
            return;
        }
        if (d() && (i = a(qVar).i) != 0) {
            a(view, i);
            return;
        }
        Integer numA = r.a((NativeAd) this.f);
        if (numA != null) {
            a(view, numA.intValue());
        } else {
            a(qVar, new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.interstitial.u.2
                final /* synthetic */ d.a b = null;

                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(Bitmap bitmap) {
                    final int iIntValue;
                    Bitmap bitmap2 = bitmap;
                    if (bitmap2 == null) {
                        u.this.a(view, this);
                        return;
                    }
                    Integer numA2 = sg.bigo.ads.common.w.b.a(bitmap2);
                    if (numA2 != null) {
                        d.a aVar = this.b;
                        if (aVar != null) {
                            numA2.intValue();
                            iIntValue = aVar.a();
                        } else {
                            iIntValue = numA2.intValue();
                        }
                        view.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.u.2.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                final long j = u.a(u.this) ? u.d : 0L;
                                sg.bigo.ads.common.w.b.a(view, iIntValue, new sg.bigo.ads.common.w.b.a() { // from class: sg.bigo.ads.ad.interstitial.u.2.1.1
                                    @Override // sg.bigo.ads.common.w.b.a
                                    public final long a() {
                                        return j;
                                    }
                                });
                            }
                        });
                    }
                }
            });
        }
    }

    protected final void a(View view, ValueCallback<Bitmap> valueCallback) {
        if (view != null) {
            synchronized (this.i) {
                this.i.put(view, valueCallback);
            }
        }
    }

    protected void a(q qVar, final View view) {
        int i;
        Bitmap bitmapG;
        if (qVar == null || view == null) {
            return;
        }
        int iE = e();
        if (iE == 2) {
            i = ViewCompat.MEASURED_STATE_MASK;
        } else {
            if (iE == 3) {
                b(qVar, view);
                return;
            }
            if (iE == 4) {
                if (qVar == null || view == null) {
                    return;
                }
                ValueCallback<Bitmap> valueCallback = new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.interstitial.u.3
                    final /* synthetic */ d.a b = null;

                    @Override // android.webkit.ValueCallback
                    public final /* synthetic */ void onReceiveValue(Bitmap bitmap) {
                        final Bitmap bitmap2 = bitmap;
                        u uVar = u.this;
                        if (bitmap2 == null) {
                            uVar.a(view, this);
                            return;
                        }
                        final long j = u.a(uVar) ? u.d : 0L;
                        final Bitmap bitmapB = sg.bigo.ads.common.utils.d.b(view.getContext(), bitmap2);
                        view.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.u.3.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                Integer numA;
                                sg.bigo.ads.common.w.b.a(view, new BitmapDrawable(view.getResources(), bitmapB), j);
                                if (AnonymousClass3.this.b == null || (numA = sg.bigo.ads.common.w.b.a(bitmap2)) == null) {
                                    return;
                                }
                                numA.intValue();
                            }
                        });
                    }
                };
                if (!d() || (bitmapG = a(qVar).g()) == null) {
                    a(qVar, valueCallback);
                    return;
                } else {
                    valueCallback.onReceiveValue(bitmapG);
                    return;
                }
            }
            i = -1;
        }
        a(view, i);
    }

    protected boolean a(q qVar, ViewGroup viewGroup, View view, t.a aVar, int i, int i2, int i3, View... viewArr) {
        t tVarA = a(qVar);
        if (tVarA == null) {
            return false;
        }
        tVarA.a(viewGroup, view, aVar, i, i2, i3, viewArr);
        sg.bigo.ads.common.utils.u.a(view, new ViewTreeObserver.OnGlobalLayoutListener() { // from class: sg.bigo.ads.ad.interstitial.u.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                u.this.h = SystemClock.elapsedRealtime();
            }
        });
        if (!f()) {
            return true;
        }
        t.a(view);
        return true;
    }

    public final sg.bigo.ads.common.p b(q qVar) {
        if (d()) {
            sg.bigo.ads.common.p pVarH = a(qVar).h();
            if (pVarH.a()) {
                return pVarH;
            }
        }
        return r.a(this.f);
    }

    public final void c(q qVar) {
        if (this.i.isEmpty()) {
            return;
        }
        a(qVar, new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.interstitial.u.4
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(Bitmap bitmap) {
                Bitmap bitmap2 = bitmap;
                if (bitmap2 != null) {
                    synchronized (u.this.i) {
                        Iterator it = u.this.i.values().iterator();
                        while (it.hasNext()) {
                            ((ValueCallback) it.next()).onReceiveValue(bitmap2);
                        }
                        u.this.i.clear();
                    }
                }
            }
        });
    }

    public boolean d() {
        return false;
    }

    protected abstract int e();

    protected boolean f() {
        return false;
    }
}
