package sg.bigo.ads.ad.interstitial.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.ValueCallback;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import java.util.Iterator;
import java.util.WeakHashMap;
import sg.bigo.ads.R;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.NativeAd;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a extends sg.bigo.ads.ad.interstitial.t {
    public static long k = sg.bigo.ads.ad.interstitial.u.c;
    public static long l = sg.bigo.ads.ad.interstitial.u.d;
    public static int m = sg.bigo.ads.ad.interstitial.u.e;
    protected final WeakHashMap<Object, ValueCallback<Bitmap>> n;
    protected final sg.bigo.ads.ad.interstitial.d o;
    protected sg.bigo.ads.ad.interstitial.q p;
    protected ViewGroup q;
    protected ViewGroup r;
    protected sg.bigo.ads.ad.interstitial.w s;
    protected sg.bigo.ads.api.a.m t;
    protected sg.bigo.ads.ad.interstitial.f u;
    protected TextView v;
    boolean w;
    private final ValueCallback<Double> x;
    private long y;

    /* JADX INFO: renamed from: sg.bigo.ads.ad.interstitial.d.a$a, reason: collision with other inner class name */
    protected static class C0838a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f12723a;
        public final boolean b;

        private C0838a(int i, boolean z) {
            this.f12723a = i;
            this.b = z;
        }

        /* synthetic */ C0838a(int i, boolean z, byte b) {
            this(i, z);
        }
    }

    public a(sg.bigo.ads.ad.b.c cVar) {
        super(cVar);
        this.n = new WeakHashMap<>();
        this.x = new ValueCallback<Double>() { // from class: sg.bigo.ads.ad.interstitial.d.a.1
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(Double d) {
                Double d2 = d;
                if (d2 != null) {
                    a.this.a(d2.doubleValue());
                }
            }
        };
        this.y = 0L;
        this.o = new sg.bigo.ads.ad.interstitial.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int a(sg.bigo.ads.ad.interstitial.t tVar, sg.bigo.ads.api.a.m mVar) {
        return tVar instanceof sg.bigo.ads.ad.interstitial.f.b ? ((sg.bigo.ads.ad.interstitial.f.b) tVar).H() : a(mVar, "video_play_page.webview_layout");
    }

    public static int a(sg.bigo.ads.api.a.m mVar, String str) {
        int iA = (mVar == null || sg.bigo.ads.common.utils.q.a((CharSequence) str)) ? 0 : mVar.a(str);
        if (iA == 1 || iA == 2 || iA == 3 || iA == 4) {
            return iA;
        }
        return 0;
    }

    public static w a(sg.bigo.ads.ad.b.c cVar, sg.bigo.ads.api.a.m mVar, int i) {
        if (i == 2) {
            return new y(cVar, mVar);
        }
        if (i == 3) {
            return new z(cVar, mVar);
        }
        if (i == 4) {
            return new aa(cVar, mVar);
        }
        if (i != 5) {
            return i != 6 ? new x(cVar, mVar) : new ac(cVar, mVar);
        }
        return new ab(cVar, mVar);
    }

    public static sg.bigo.ads.ad.interstitial.t a(sg.bigo.ads.ad.b.c cVar) {
        return new sg.bigo.ads.ad.interstitial.t(cVar);
    }

    public static sg.bigo.ads.ad.interstitial.t a(sg.bigo.ads.ad.b.c cVar, int i) {
        switch (i) {
            case 13:
                return new n(cVar);
            case 14:
                return new o(cVar);
            case 15:
                return new p(cVar);
            case 16:
                return new q(cVar);
            case 17:
                return new r(cVar);
            case 18:
                return new s(cVar);
            case 19:
                return new b(cVar);
            case 20:
                return new c(cVar);
            case 21:
                return new d(cVar);
            case 22:
                return new e(cVar);
            case 23:
                return new f(cVar);
            case 24:
                return new g(cVar);
            case 25:
                return new h(cVar);
            case 26:
                return new i(cVar);
            case 27:
                return new j(cVar);
            case 28:
                return new k(cVar);
            case 29:
                return new l(cVar);
            case 30:
            default:
                return new sg.bigo.ads.ad.interstitial.t(cVar);
            case 31:
            case 32:
                sg.bigo.ads.common.p pVarA = sg.bigo.ads.ad.interstitial.r.a(cVar);
                sg.bigo.ads.common.t.a.a(0, 3, "interNo6", "GetRenender-layoutStyle:" + i + "...materialSize:" + pVarA);
                if ((31 != i && 32 != i) || !pVarA.a()) {
                    return new sg.bigo.ads.ad.interstitial.t(cVar);
                }
                if (pVarA.getWidth() / pVarA.getHeight() > 0) {
                    return new u(cVar);
                }
                return 31 == i ? new t(cVar) : new v(cVar);
        }
    }

    static /* synthetic */ boolean a(a aVar) {
        return (aVar.y != 0 ? SystemClock.elapsedRealtime() - aVar.y : 0L) > k;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean a(sg.bigo.ads.ad.interstitial.t tVar) {
        if (tVar instanceof sg.bigo.ads.ad.interstitial.f.b) {
            return ((sg.bigo.ads.ad.interstitial.f.b) tVar).J();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int b(sg.bigo.ads.ad.interstitial.t tVar, sg.bigo.ads.api.a.m mVar) {
        return tVar instanceof sg.bigo.ads.ad.interstitial.f.b ? ((sg.bigo.ads.ad.interstitial.f.b) tVar).I() : b(mVar, "video_play_page.webview_force_time");
    }

    public static int b(sg.bigo.ads.api.a.m mVar, String str) {
        int iA = (mVar == null || sg.bigo.ads.common.utils.q.a((CharSequence) str)) ? 0 : mVar.a(str, -1);
        switch (iA) {
            case -1:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return iA;
            case 0:
            default:
                return 0;
        }
    }

    public static sg.bigo.ads.ad.interstitial.c.w b(sg.bigo.ads.ad.b.c cVar, sg.bigo.ads.api.a.m mVar, int i) {
        if (i == 3) {
            return new sg.bigo.ads.ad.interstitial.c.x(cVar, mVar);
        }
        if (i != 5) {
            return i != 6 ? new sg.bigo.ads.ad.interstitial.c.w(cVar, mVar) : new sg.bigo.ads.ad.interstitial.c.z(cVar, mVar);
        }
        return new sg.bigo.ads.ad.interstitial.c.y(cVar, mVar);
    }

    protected abstract void a(double d);

    protected void a(int i) {
        ViewGroup viewGroup = this.q;
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(this.o.a(i));
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.t
    public final void a(ViewGroup viewGroup) {
    }

    protected final void a(final TextView textView, final sg.bigo.ads.common.w.b.a aVar) {
        if (textView == null) {
            return;
        }
        Integer numA = sg.bigo.ads.ad.interstitial.r.a((NativeAd) this.c);
        if (numA == null) {
            a(new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.interstitial.d.a.6
                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(Bitmap bitmap) {
                    Bitmap bitmap2 = bitmap;
                    if (bitmap2 != null) {
                        final int iA = sg.bigo.ads.common.w.b.a(bitmap2, -16736769);
                        textView.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.a.6.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                sg.bigo.ads.ad.interstitial.d.a(textView, iA, aVar);
                            }
                        });
                    } else {
                        synchronized (a.this.n) {
                            a.this.n.put(textView, this);
                        }
                    }
                }
            });
        } else {
            sg.bigo.ads.ad.interstitial.d.a(textView, numA.intValue(), aVar);
        }
    }

    public final boolean a(sg.bigo.ads.ad.interstitial.q qVar, ViewGroup viewGroup, sg.bigo.ads.ad.interstitial.w wVar, sg.bigo.ads.api.a.m mVar, sg.bigo.ads.ad.interstitial.f fVar) {
        ViewGroup viewGroup2;
        if (qVar == null) {
            return false;
        }
        this.p = qVar;
        this.q = viewGroup;
        if (viewGroup != null) {
            ViewGroup viewGroup3 = (ViewGroup) viewGroup.findViewById(R.id.inter_media_container);
            this.r = viewGroup3;
            viewGroup2 = viewGroup3 == null ? this.q : null;
            this.s = wVar;
            this.t = mVar;
            this.u = fVar;
            this.v = (TextView) this.q.findViewById(R.id.inter_warning);
            sg.bigo.ads.common.utils.u.a(this.q, new ViewTreeObserver.OnGlobalLayoutListener() { // from class: sg.bigo.ads.ad.interstitial.d.a.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    a.this.y = SystemClock.elapsedRealtime();
                }
            });
            o();
            t();
            q();
            this.o.a(this.x);
            return true;
        }
        this.r = viewGroup2;
        this.s = wVar;
        this.t = mVar;
        this.u = fVar;
        this.v = (TextView) this.q.findViewById(R.id.inter_warning);
        sg.bigo.ads.common.utils.u.a(this.q, new ViewTreeObserver.OnGlobalLayoutListener() { // from class: sg.bigo.ads.ad.interstitial.d.a.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                a.this.y = SystemClock.elapsedRealtime();
            }
        });
        o();
        t();
        q();
        this.o.a(this.x);
        return true;
    }

    @Override // sg.bigo.ads.ad.interstitial.t
    public final sg.bigo.ads.ad.interstitial.d e() {
        return this.o;
    }

    @Override // sg.bigo.ads.ad.interstitial.t
    public void f() {
        super.f();
        this.w = true;
    }

    protected final Context j() {
        ViewGroup viewGroup = this.q;
        return viewGroup != null ? viewGroup.getContext() : this.c.b.e;
    }

    public abstract ViewGroup k();

    public abstract MediaView l();

    public abstract Button m();

    public boolean n() {
        return false;
    }

    protected void o() {
        int iX = x();
        if (iX == 2) {
            a(ViewCompat.MEASURED_STATE_MASK);
            return;
        }
        if (iX == 3) {
            a(ViewCompat.MEASURED_STATE_MASK);
            r();
        } else if (iX != 4) {
            a(-1);
        } else {
            a(ViewCompat.MEASURED_STATE_MASK);
            s();
        }
    }

    public void p() {
        if (this.n.isEmpty()) {
            return;
        }
        a(new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.interstitial.d.a.3
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(Bitmap bitmap) {
                Bitmap bitmap2 = bitmap;
                if (bitmap2 != null) {
                    synchronized (a.this.n) {
                        Iterator<ValueCallback<Bitmap>> it = a.this.n.values().iterator();
                        while (it.hasNext()) {
                            it.next().onReceiveValue(bitmap2);
                        }
                        a.this.n.clear();
                    }
                }
            }
        });
    }

    protected void q() {
        String strI = ((sg.bigo.ads.core.a.a) this.c.f()).i();
        TextView textView = (TextView) this.q.findViewById(R.id.inter_advertiser);
        TextView textView2 = (TextView) this.q.findViewById(R.id.inter_ad_label);
        if (textView != null) {
            if (TextUtils.isEmpty(strI)) {
                textView.setVisibility(8);
                return;
            }
            textView.setText(strI);
            textView.setPadding(sg.bigo.ads.common.utils.e.a(this.q.getContext(), 4), sg.bigo.ads.common.utils.e.a(textView.getContext(), 1), sg.bigo.ads.common.utils.e.a(textView.getContext(), 4), sg.bigo.ads.common.utils.e.a(textView.getContext(), 1));
            textView2.setText(R.string.bigo_ad_tag);
        }
    }

    protected void r() {
        Integer numA = sg.bigo.ads.ad.interstitial.r.a((NativeAd) this.c);
        if (numA != null) {
            a(numA.intValue());
        } else {
            a(new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.interstitial.d.a.4
                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(Bitmap bitmap) {
                    Bitmap bitmap2 = bitmap;
                    if (bitmap2 == null) {
                        synchronized (a.this.n) {
                            a.this.n.put(a.this.q, this);
                        }
                        return;
                    }
                    final long j = a.a(a.this) ? a.l : 0L;
                    final Integer numA2 = sg.bigo.ads.common.w.b.a(bitmap2);
                    if (numA2 != null) {
                        a.this.q.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.a.4.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                sg.bigo.ads.common.w.b.a(a.this.q, a.this.o.a(numA2.intValue()), new sg.bigo.ads.common.w.b.a() { // from class: sg.bigo.ads.ad.interstitial.d.a.4.1.1
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

    protected void s() {
        a(new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.interstitial.d.a.5
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(Bitmap bitmap) {
                Bitmap bitmap2 = bitmap;
                if (bitmap2 == null) {
                    synchronized (a.this.n) {
                        a.this.n.put(a.this.q, this);
                    }
                } else {
                    final long j = a.a(a.this) ? a.l : 0L;
                    final Bitmap bitmapB = sg.bigo.ads.common.utils.d.b(a.this.q.getContext(), bitmap2);
                    final Integer numA = sg.bigo.ads.common.w.b.a(bitmapB);
                    a.this.q.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.a.5.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            final BitmapDrawable bitmapDrawable = new BitmapDrawable(a.this.q.getResources(), bitmapB);
                            bitmapDrawable.setAlpha(0);
                            sg.bigo.ads.ad.interstitial.multi_img.a.a(a.this.q, "adview_background_main_tag", bitmapDrawable);
                            sg.bigo.ads.ad.interstitial.c.a(0, a.m, j, new ValueCallback<Integer>() { // from class: sg.bigo.ads.ad.interstitial.d.a.5.1.1
                                @Override // android.webkit.ValueCallback
                                public final /* synthetic */ void onReceiveValue(Integer num) {
                                    Integer num2 = num;
                                    if (num2 != null) {
                                        bitmapDrawable.setAlpha(num2.intValue());
                                    }
                                }
                            }, new ValueCallback<Void>() { // from class: sg.bigo.ads.ad.interstitial.d.a.5.1.2
                                @Override // android.webkit.ValueCallback
                                public final /* bridge */ /* synthetic */ void onReceiveValue(Void r1) {
                                }
                            });
                            if (numA != null) {
                                a.this.o.a(numA.intValue());
                            }
                        }
                    });
                }
            }
        });
    }

    protected void t() {
    }

    protected final C0838a u() {
        sg.bigo.ads.api.a.m mVar = this.t;
        boolean z = false;
        byte b = 0;
        byte b2 = 0;
        if (mVar == null) {
            return new C0838a(-16736769, z, b2 == true ? 1 : 0);
        }
        boolean[] zArr = new boolean[1];
        return new C0838a(sg.bigo.ads.ad.interstitial.r.a(this.c, mVar.a("video_play_page.cta_color"), zArr), true ^ zArr[0], b == true ? 1 : 0);
    }

    protected final boolean v() {
        sg.bigo.ads.api.a.m mVar = this.t;
        if (mVar != null) {
            return mVar.c("video_play_page.is_cta_show_animation");
        }
        return false;
    }

    protected final int w() {
        sg.bigo.ads.api.a.m mVar = this.t;
        return sg.bigo.ads.ad.interstitial.multi_img.e.a(mVar != null ? mVar.a("video_play_page.mediaview_colour") : 3);
    }

    protected int x() {
        sg.bigo.ads.api.a.m mVar = this.t;
        return sg.bigo.ads.ad.interstitial.multi_img.e.a(mVar != null ? mVar.a("video_play_page.background_colour") : 1);
    }

    protected int y() {
        sg.bigo.ads.api.a.m mVar = this.t;
        if (mVar != null) {
            return mVar.a("video_play_page.ad_component_show_time");
        }
        return -1;
    }
}
