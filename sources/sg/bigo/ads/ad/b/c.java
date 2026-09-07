package sg.bigo.ads.ad.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import com.iab.omid.library.bigosg.adsession.media.InteractionType;
import com.json.mediationsdk.utils.IronSourceConstants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sg.bigo.ads.api.AdIconView;
import sg.bigo.ads.api.AdOptionsView;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.NativeAd;
import sg.bigo.ads.api.NativeAdView;
import sg.bigo.ads.api.VideoController;
import sg.bigo.ads.api.core.n;
import sg.bigo.ads.api.core.o;
import sg.bigo.ads.common.i;
import sg.bigo.ads.common.p;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.core.adview.h;

/* JADX INFO: loaded from: classes3.dex */
public class c extends e<NativeAd, sg.bigo.ads.core.a.a> implements NativeAd, h {
    protected final View.OnAttachStateChangeListener A;
    protected sg.bigo.ads.core.c.b B;
    protected ViewGroup C;
    public MediaView D;
    protected sg.bigo.ads.common.p.g E;
    protected a F;
    public int G;
    private WeakReference<Activity> H;
    private boolean I;
    private long v;
    private int w;
    private final Map<Integer, Integer> x;
    protected long y;
    protected b z;

    public interface a {
        void a();
    }

    public interface b {
        void a();

        void b();
    }

    public c(sg.bigo.ads.api.core.g gVar) {
        super(gVar);
        this.y = -1L;
        this.v = -1L;
        this.A = new View.OnAttachStateChangeListener() { // from class: sg.bigo.ads.ad.b.c.1
            @Override // android.view.View.OnAttachStateChangeListener
            public final void onViewAttachedToWindow(View view) {
                c.this.y = SystemClock.elapsedRealtime();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public final void onViewDetachedFromWindow(View view) {
                c.this.v = SystemClock.elapsedRealtime();
                view.removeOnAttachStateChangeListener(this);
            }
        };
        this.E = null;
        this.F = null;
        this.G = 0;
        this.x = new HashMap();
        this.I = false;
    }

    private boolean a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            a(2001, "NativeAdView cannot be null.");
            return false;
        }
        if (isExpired()) {
            a(2000, "The ad is expired.");
            return false;
        }
        if (!this.h) {
            return true;
        }
        a(2000, "The ad is destroyed.");
        return false;
    }

    protected static boolean a(ViewGroup viewGroup, View view) {
        Object tag = view.getTag();
        return (tag == null || viewGroup.findViewWithTag(tag) == null) ? false : true;
    }

    protected List<sg.bigo.ads.core.c.a> A() {
        return sg.bigo.ads.ad.b.a.a(((sg.bigo.ads.core.a.a) f()).G());
    }

    protected boolean C() {
        return false;
    }

    public final void a(int i, int i2) {
        a((i) null, i, i2);
    }

    @Override // sg.bigo.ads.core.adview.h
    public final void a(int i, int i2, int i3, int i4, int i5, int i6) {
        i iVar = new i();
        iVar.b = new Point(i, i2);
        iVar.f13209a = new Point(i3, i4);
        a(iVar, i5, i6);
    }

    @Override // sg.bigo.ads.ad.c
    public void a(Point point, int i, int i2, sg.bigo.ads.api.core.e eVar) {
        super.a(point, i, i2, eVar);
        a aVar = this.F;
        if (aVar != null) {
            aVar.a();
        }
    }

    protected void a(ViewGroup viewGroup, MediaView mediaView, View view, AdOptionsView adOptionsView, List<View> list, int i, View... viewArr) {
        this.C = viewGroup;
        viewGroup.setTag(11);
        sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) f();
        int i2 = a(viewGroup, view, i) ? 5 : 1;
        if (adOptionsView != null) {
            adOptionsView.setTag(4);
            if (a(viewGroup, adOptionsView)) {
                adOptionsView.a(aVar, aVar.l());
                i2 |= 8;
            }
        }
        if (mediaView != null) {
            mediaView.setTag(5);
            if (a(viewGroup, mediaView)) {
                a(mediaView);
                sg.bigo.ads.ad.b.a.a(viewGroup, mediaView, i, this, this.G);
                i2 |= 2;
                this.D = mediaView;
            }
        }
        for (View view2 : sg.bigo.ads.ad.b.a.b(list)) {
            if (view2 != null) {
                sg.bigo.ads.ad.b.a.a(viewGroup, view2, i, this, this.G);
            }
        }
        this.B = sg.bigo.ads.core.c.c.a.f13533a.a(A(), C(), this.C, viewArr);
        a("render_style", Integer.valueOf(i2));
        t();
        this.c = viewGroup;
        w();
    }

    public void a(ViewGroup viewGroup, MediaView mediaView, ImageView imageView, AdOptionsView adOptionsView, List<View> list, int i, View... viewArr) {
        a(viewGroup, mediaView, (View) imageView, adOptionsView, list, i, viewArr);
    }

    public final void a(a aVar) {
        this.F = aVar;
    }

    public final void a(b bVar) {
        this.z = bVar;
    }

    protected void a(MediaView mediaView) {
        if (mediaView == null) {
            return;
        }
        final sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) f();
        if (this.b.b.e() == 2) {
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.E = new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.b.c.4
                @Override // sg.bigo.ads.common.p.g
                public final void a(int i, String str, String str2) {
                    sg.bigo.ads.core.a.a aVar2 = aVar;
                    sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) aVar2, aVar2.aS(), str, SystemClock.elapsedRealtime() - jElapsedRealtime, 0L, 1, str2, false);
                }

                @Override // sg.bigo.ads.common.p.g
                public final void a(Bitmap bitmap, sg.bigo.ads.common.p.f fVar) {
                    sg.bigo.ads.core.a.a aVar2 = aVar;
                    sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) aVar2, aVar2.aS(), fVar.f13257a, SystemClock.elapsedRealtime() - jElapsedRealtime, fVar.c, 0, 1, fVar.b, false);
                }
            };
        }
        mediaView.a(aVar, this.E);
    }

    @Override // sg.bigo.ads.ad.c, sg.bigo.ads.api.b.d
    public final void a(sg.bigo.ads.api.b.d.a<NativeAd> aVar) {
        super.a(aVar);
        a(aVar, this.b.b.e());
    }

    public void a(final sg.bigo.ads.api.b.d.a<NativeAd> aVar, int i) {
        y();
        final sg.bigo.ads.core.a.a aVar2 = (sg.bigo.ads.core.a.a) f();
        final String strAS = aVar2.aS();
        if (q.a((CharSequence) strAS)) {
            aVar.a(this, 1027, IronSourceConstants.RV_AUCTION_REQUEST, "Missing media image.");
            return;
        }
        if (sg.bigo.ads.api.a.i.f13093a.n().a(9) && URLUtil.isHttpUrl(strAS)) {
            aVar.a(this, 1028, 1305, "Invalid http url");
            sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) aVar2, strAS, "Invalid http url", 0L, 0L, 1, "", false);
            return;
        }
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (i == 0) {
            sg.bigo.ads.common.p.e.a(this.b.e, strAS, aVar2.al(), new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.b.c.2
                @Override // sg.bigo.ads.common.p.g
                public final void a(int i2, String str, String str2) {
                    aVar2.d(str2);
                    aVar.a(c.this, 1029, i2, "Failed to download media image: ".concat(String.valueOf(str)));
                    sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) aVar2, strAS, str, SystemClock.elapsedRealtime() - jElapsedRealtime, 0L, 1, str2, false);
                }

                @Override // sg.bigo.ads.common.p.g
                public final void a(Bitmap bitmap, sg.bigo.ads.common.p.f fVar) {
                    aVar2.d(fVar.b);
                    n nVar = new n();
                    nVar.f13112a = bitmap.getWidth();
                    nVar.b = bitmap.getHeight();
                    nVar.d = fVar.c;
                    aVar2.a(nVar);
                    c.this.a(bitmap, 2);
                    c.this.a("is_cache", Boolean.valueOf(fVar.f13257a != 1));
                    aVar.a(c.this);
                    sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) aVar2, strAS, fVar.f13257a, SystemClock.elapsedRealtime() - jElapsedRealtime, fVar.c, 0, 1, fVar.b, false);
                }
            });
            return;
        }
        if (i == 1) {
            sg.bigo.ads.common.p.e.a(this.b.e, strAS, aVar2.al(), new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.b.c.3
                @Override // sg.bigo.ads.common.p.g
                public final void a(int i2, String str, String str2) {
                    aVar2.d(str2);
                    sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) aVar2, strAS, str, SystemClock.elapsedRealtime() - jElapsedRealtime, 0L, 1, str2, false);
                }

                @Override // sg.bigo.ads.common.p.g
                public final void a(Bitmap bitmap, sg.bigo.ads.common.p.f fVar) {
                    aVar2.d(fVar.b);
                    n nVar = new n();
                    nVar.f13112a = bitmap.getWidth();
                    nVar.b = bitmap.getHeight();
                    nVar.d = fVar.c;
                    aVar2.a(nVar);
                    c.this.a(bitmap, 2);
                    sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) aVar2, strAS, fVar.f13257a, SystemClock.elapsedRealtime() - jElapsedRealtime, fVar.c, 0, 1, fVar.b, false);
                }
            });
        }
        aVar.a(this);
    }

    protected final void a(i iVar, int i, int i2) {
        Activity activityB;
        sg.bigo.ads.api.core.e eVarA;
        String str;
        String str2;
        if (v()) {
            sg.bigo.ads.common.t.a.a(0, "NativeStaticAdImpl", "Styleable landing page is opened, ignore the click action.");
            return;
        }
        sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) f();
        WeakReference<Activity> weakReference = this.H;
        if (weakReference == null || (activityB = weakReference.get()) == null) {
            activityB = null;
        } else {
            sg.bigo.ads.common.t.a.a(0, 3, "NativeStaticAdImpl", "Interstitial/Reward Video/Splash native ad get activity context from show(Activity activity).");
            b(1);
        }
        if (activityB == null) {
            sg.bigo.ads.api.a.h hVar = sg.bigo.ads.api.a.i.f13093a;
            if (this.I) {
                if (hVar != null && hVar.n().a(16)) {
                    activityB = sg.bigo.ads.common.f.b.b();
                    if (activityB == null) {
                        str2 = "Interstitial/Reward Video/Splash native ad failed to get activity context.";
                        sg.bigo.ads.common.t.a.a(0, "NativeStaticAdImpl", str2);
                    } else {
                        str = "Interstitial/Reward Video/Splash native ad get activity context from current activity.";
                        sg.bigo.ads.common.t.a.a(0, 3, "NativeStaticAdImpl", str);
                        b(2);
                    }
                }
            } else if (hVar != null && hVar.n().a(17)) {
                try {
                    Activity activityA = sg.bigo.ads.common.utils.c.a(this.C);
                    if (activityA != null) {
                        try {
                            sg.bigo.ads.common.t.a.a(0, 3, "NativeStaticAdImpl", "Native ad get activity context from view.");
                            b(3);
                        } catch (Exception unused) {
                        }
                        activityB = activityA;
                    }
                } catch (Exception unused2) {
                }
                if (activityB == null) {
                    activityB = sg.bigo.ads.common.f.b.b();
                    if (activityB == null) {
                        str2 = "Native ad failed to get activity context.";
                        sg.bigo.ads.common.t.a.a(0, "NativeStaticAdImpl", str2);
                    } else {
                        str = "Native ad get activity context from current activity.";
                        sg.bigo.ads.common.t.a.a(0, 3, "NativeStaticAdImpl", str);
                        b(2);
                    }
                }
            }
        }
        Context context = activityB == null ? this.b.e : activityB;
        if (aVar.f().c() != 0) {
            sg.bigo.ads.controller.landing.d.a(context, this);
            eVarA = new sg.bigo.ads.api.core.e();
            eVarA.g = 1;
        } else {
            sg.bigo.ads.api.core.c.b bVarN = aVar.N();
            eVarA = sg.bigo.ads.controller.landing.d.a(context, bVarN.b(), bVarN.a(), bVarN.g(), aVar.a(2), bVarN.c(), bVarN.d(), this, aVar.ar());
            eVarA.g = 0;
        }
        a(iVar, i2, i, eVarA);
        sg.bigo.ads.core.c.b bVar = this.B;
        if (bVar != null) {
            bVar.a(InteractionType.CLICK);
        }
    }

    public void a(boolean z) {
        this.I = z;
    }

    protected boolean a(ViewGroup viewGroup, View view, int i) {
        sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) f();
        if (view != null && aVar != null) {
            view.setTag(1);
            if (a(viewGroup, view)) {
                o.a aVarAu = aVar.au();
                if (aVarAu != null) {
                    String strC = aVarAu != null ? aVarAu.c() : null;
                    if (sg.bigo.ads.api.a.i.f13093a.n().a(9) && URLUtil.isHttpUrl(strC)) {
                        sg.bigo.ads.core.d.b.a(aVar, 3000, 10220, "Invalid http url: ".concat(String.valueOf(strC)));
                    } else if (view instanceof ImageView) {
                        new sg.bigo.ads.common.p.b((ImageView) view, (byte) 0).a(null, aVarAu.c(), aVar.al());
                    } else if (view instanceof AdIconView) {
                        ((AdIconView) view).a(aVarAu.c(), aVar.al());
                    }
                }
                sg.bigo.ads.ad.b.a.a(viewGroup, view, i, this, this.G);
                return true;
            }
        }
        return false;
    }

    public void b(Activity activity) {
        this.H = new WeakReference<>(activity);
    }

    public final void d(int i) {
        ((sg.bigo.ads.core.a.a) f()).f(i);
    }

    @Override // sg.bigo.ads.ad.d, sg.bigo.ads.ad.c
    public void destroyInMainThread() {
        super.destroyInMainThread();
        sg.bigo.ads.core.c.b bVar = this.B;
        if (bVar != null) {
            bVar.b();
        }
        this.c = null;
        this.C = null;
        MediaView mediaView = this.D;
        if (mediaView != null) {
            mediaView.c();
            this.D = null;
        }
        this.E = null;
        this.F = null;
    }

    public final void e(int i) {
        this.x.put(Integer.valueOf(this.w), Integer.valueOf(this.n));
        this.w = i;
        Integer num = this.x.get(Integer.valueOf(i));
        if (num == null) {
            num = 0;
        }
        this.n = num.intValue();
    }

    @Override // sg.bigo.ads.api.NativeAd
    public String getAdvertiser() {
        return ((sg.bigo.ads.core.a.a) f()).i();
    }

    @Override // sg.bigo.ads.api.NativeAd
    public String getCallToAction() {
        return ((sg.bigo.ads.core.a.a) f()).u();
    }

    @Override // sg.bigo.ads.api.Ad
    public String getCreativeId() {
        sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) f();
        return aVar != null ? aVar.z() : "";
    }

    @Override // sg.bigo.ads.api.NativeAd
    public NativeAd.CreativeType getCreativeType() {
        return NativeAd.CreativeType.IMAGE;
    }

    @Override // sg.bigo.ads.api.NativeAd
    public String getDescription() {
        return ((sg.bigo.ads.core.a.a) f()).t();
    }

    @Override // sg.bigo.ads.api.NativeAd
    public float getMediaContentAspectRatio() {
        p pVarA = sg.bigo.ads.ad.b.a.a(this);
        if (pVarA.a()) {
            return (pVarA.getWidth() * 1.0f) / pVarA.getHeight();
        }
        return 0.0f;
    }

    @Override // sg.bigo.ads.api.NativeAd
    public sg.bigo.ads.api.core.c.d getPopPage() {
        return ((sg.bigo.ads.core.a.a) f()).q();
    }

    @Override // sg.bigo.ads.api.NativeAd
    public String getTitle() {
        return ((sg.bigo.ads.core.a.a) f()).s();
    }

    @Override // sg.bigo.ads.api.NativeAd
    public VideoController getVideoController() {
        return null;
    }

    @Override // sg.bigo.ads.api.NativeAd
    public String getWarning() {
        sg.bigo.ads.api.core.c.e eVarB = ((sg.bigo.ads.core.a.a) f()).B();
        return eVarB != null ? eVarB.c() : "";
    }

    @Override // sg.bigo.ads.ad.c
    public void h() {
        super.h();
        sg.bigo.ads.core.c.b bVar = this.B;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // sg.bigo.ads.api.NativeAd
    public boolean hasIcon() {
        o.a aVarAu = ((sg.bigo.ads.core.a.a) f()).au();
        return (aVarAu == null || q.a((CharSequence) aVarAu.c())) ? false : true;
    }

    @Override // sg.bigo.ads.api.NativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, MediaView mediaView, ImageView imageView, AdOptionsView adOptionsView, List<View> list) {
        if (a(viewGroup)) {
            a(viewGroup, mediaView, (View) imageView, adOptionsView, list, 1, null);
        }
    }

    @Override // sg.bigo.ads.api.NativeAd
    public void registerViewForInteraction(NativeAdView nativeAdView, MediaView mediaView, AdIconView adIconView, AdOptionsView adOptionsView, List<View> list) {
        if (a(nativeAdView)) {
            a(nativeAdView, mediaView, adIconView, adOptionsView, list, 1, null);
        }
    }

    protected void y() {
        b bVar = this.z;
        if (bVar != null) {
            bVar.a();
        }
    }

    protected final void z() {
        b bVar = this.z;
        if (bVar != null) {
            bVar.b();
        }
    }
}
