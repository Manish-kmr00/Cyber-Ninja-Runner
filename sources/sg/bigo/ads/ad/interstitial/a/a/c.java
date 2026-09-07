package sg.bigo.ads.ad.interstitial.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.vungle.ads.internal.model.AdPayload;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sg.bigo.ads.ad.interstitial.s;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.common.i;
import sg.bigo.ads.common.n.d;
import sg.bigo.ads.common.p.e;
import sg.bigo.ads.common.p.f;
import sg.bigo.ads.common.p.g;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.common.view.AdImageView;
import sg.bigo.ads.core.f.a.p;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements sg.bigo.ads.ad.interstitial.a.b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final sg.bigo.ads.api.core.c f12638a;
    final sg.bigo.ads.ad.interstitial.a.b.c.b b;
    View c;
    WebView d;
    View e;
    public sg.bigo.ads.ad.interstitial.a.b.c.a f;
    long h;
    boolean i;
    sg.bigo.ads.core.f.a.a.C0894a k;
    private final boolean l;
    private final sg.bigo.ads.core.player.c n;
    private final p o;
    private final Ad p;
    boolean g = false;
    boolean j = false;
    private final List<sg.bigo.ads.core.f.a.a.C0894a> m = new ArrayList();

    class a extends FrameLayout {
        private i b;

        public a(Context context) {
            super(context);
            this.b = new i();
        }

        @Override // android.view.View
        public final boolean onTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() == 1) {
                this.b.b = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
            }
            if (motionEvent.getActionMasked() == 0) {
                this.b.f13209a = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
            }
            return super.onTouchEvent(motionEvent);
        }
    }

    class b implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final sg.bigo.ads.core.f.a.a.C0894a f12643a;
        final ViewConfiguration b;
        final int c;
        float e;
        float f;
        boolean d = false;
        i g = new i();

        public b(Context context, sg.bigo.ads.core.f.a.a.C0894a c0894a) {
            this.f12643a = c0894a;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.b = viewConfiguration;
            this.c = viewConfiguration.getScaledTouchSlop();
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() == 0) {
                this.d = true;
                this.e = motionEvent.getX();
                this.f = motionEvent.getY();
                this.g.f13209a = new Point((int) this.e, (int) this.f);
            } else if (motionEvent.getActionMasked() == 1) {
                if (this.d) {
                    this.d = false;
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    this.g.b = new Point((int) x, (int) y);
                    if (Math.abs(this.e - x) < this.c && Math.abs(this.f - y) < this.c) {
                        c cVar = c.this;
                        cVar.a(cVar.g().b.e, this.g);
                    }
                }
            } else if (motionEvent.getAction() == 3) {
                this.d = false;
            }
            return true;
        }
    }

    public c(Ad ad, sg.bigo.ads.api.core.c cVar, sg.bigo.ads.core.player.c cVar2, p pVar, sg.bigo.ads.ad.interstitial.a.b.c.b bVar) {
        this.n = cVar2;
        this.o = pVar;
        this.p = ad;
        this.f12638a = cVar;
        this.b = bVar;
        if (pVar != null) {
            Iterator<sg.bigo.ads.core.f.a.a> it = pVar.A.iterator();
            while (it.hasNext()) {
                List<sg.bigo.ads.core.f.a.a.C0894a> list = it.next().b;
                if (list != null) {
                    for (sg.bigo.ads.core.f.a.a.C0894a c0894a : list) {
                        if (c0894a.a() && c0894a.b()) {
                            this.m.add(c0894a);
                        }
                    }
                    for (sg.bigo.ads.core.f.a.a.C0894a c0894a2 : list) {
                        if (c0894a2.a() && c0894a2.c()) {
                            this.m.add(c0894a2);
                        }
                    }
                }
            }
        }
        this.l = !this.m.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final List<sg.bigo.ads.core.f.a.a.C0894a> list, final sg.bigo.ads.core.f.a.a.C0894a c0894a, final int i) {
        d.b(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.a.a.c.1
            @Override // java.lang.Runnable
            public final void run() {
                if (c.this.g) {
                    sg.bigo.ads.common.t.a.a(0, 3, "StaticVastCompanion", "static vast companion destroyed, stop preload.");
                    return;
                }
                if (!list.isEmpty()) {
                    c.this.k = (sg.bigo.ads.core.f.a.a.C0894a) list.remove(0);
                    String str = c.this.k.b;
                    sg.bigo.ads.common.t.a.a(0, 3, "StaticVastCompanion", "try to preload image: ".concat(String.valueOf(str)));
                    if (URLUtil.isNetworkUrl(str)) {
                        e.a(context, str, c.this.f12638a.al(), new g() { // from class: sg.bigo.ads.ad.interstitial.a.a.c.1.1
                            @Override // sg.bigo.ads.common.p.g
                            public final void a(int i2, String str2, String str3) {
                                sg.bigo.ads.common.t.a.a(0, 3, "StaticVastCompanion", "image load failed: " + str2 + ", try to preload next image.");
                                c.this.a(context, list, c.this.k, i + 1);
                            }

                            @Override // sg.bigo.ads.common.p.g
                            public final void a(Bitmap bitmap, f fVar) {
                                String string;
                                sg.bigo.ads.common.t.a.a(0, 3, "StaticVastCompanion", "image load success.");
                                final c cVar = c.this;
                                final Context context2 = context;
                                sg.bigo.ads.core.f.a.a.C0894a c0894a2 = c.this.k;
                                int i2 = i;
                                sg.bigo.ads.common.t.a.a(0, 3, "StaticVastCompanion", "try to handle image.");
                                View view = null;
                                if (c0894a2.b()) {
                                    sg.bigo.ads.common.t.a.a(0, 3, "StaticVastCompanion", "handle jpg/png image.");
                                    AdImageView adImageView = new AdImageView(context2);
                                    adImageView.setImageBitmap(bitmap);
                                    adImageView.setOnTouchListener(cVar.new b(context2, c0894a2));
                                    string = null;
                                    view = adImageView;
                                } else if (c0894a2.c()) {
                                    sg.bigo.ads.common.t.a.a(0, 3, "StaticVastCompanion", "handle gif image.");
                                    try {
                                        File file = new File(fVar.d);
                                        if (file.exists()) {
                                            URI uri = file.toURI();
                                            WebView webView = new WebView(context2);
                                            webView.getSettings().setAllowFileAccess(true);
                                            webView.getSettings().setAllowFileAccessFromFileURLs(false);
                                            webView.getSettings().setAllowUniversalAccessFromFileURLs(false);
                                            if (uri.toString().startsWith(AdPayload.FILE_SCHEME)) {
                                                webView.getSettings().setJavaScriptEnabled(false);
                                            } else {
                                                webView.getSettings().setJavaScriptEnabled(true);
                                            }
                                            webView.loadUrl(uri.toString());
                                            webView.getSettings().setLoadWithOverviewMode(true);
                                            webView.getSettings().setUseWideViewPort(true);
                                            webView.setOnTouchListener(cVar.new b(context2, c0894a2));
                                            cVar.d = webView;
                                            string = null;
                                            view = webView;
                                        } else {
                                            sg.bigo.ads.common.t.a.a(0, 3, "StaticVastCompanion", "gif image file is not exists.");
                                            string = "git file not exists";
                                        }
                                    } catch (Exception e) {
                                        string = e.toString();
                                    }
                                } else {
                                    string = null;
                                }
                                if (view == null) {
                                    if (cVar.b != null) {
                                        cVar.j = true;
                                        cVar.b.a(cVar.f12638a, SystemClock.elapsedRealtime() - cVar.h, c0894a2.b, i2, c0894a2.e, string);
                                        return;
                                    }
                                    return;
                                }
                                int width = bitmap.getWidth();
                                int height = bitmap.getHeight();
                                if (width <= 0 || height <= 0) {
                                    width = sg.bigo.ads.common.utils.e.a(context2, c0894a2.c);
                                    height = sg.bigo.ads.common.utils.e.a(context2, c0894a2.d);
                                }
                                float f = context2.getResources().getDisplayMetrics().widthPixels;
                                float fC = sg.bigo.ads.common.utils.e.c(context2);
                                if (f > 0.0f && fC > 0.0f) {
                                    float f2 = height;
                                    float f3 = width;
                                    float f4 = (f2 * f) / f3;
                                    if (f4 > fC) {
                                        f = (f3 * fC) / f2;
                                    } else {
                                        fC = f4;
                                    }
                                    width = (int) f;
                                    height = (int) fC;
                                }
                                FrameLayout.LayoutParams layoutParams = (width <= 0 || height <= 0) ? new FrameLayout.LayoutParams(-1, -1) : new FrameLayout.LayoutParams(width, height, 17);
                                final a aVar = cVar.new a(context2);
                                aVar.setOnClickListener(new View.OnClickListener() { // from class: sg.bigo.ads.ad.interstitial.a.a.c.2
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        c.this.a(context2, aVar.b);
                                    }
                                });
                                cVar.e = view;
                                aVar.addView(view, layoutParams);
                                cVar.c = aVar;
                                if (cVar.b != null) {
                                    cVar.i = true;
                                    cVar.b.a(cVar.f12638a, SystemClock.elapsedRealtime() - cVar.h, c0894a2.b, i2, c0894a2.e);
                                }
                            }
                        });
                        return;
                    }
                    sg.bigo.ads.common.t.a.a(0, 3, "StaticVastCompanion", "image url is invalid: " + str + ", try to preload next image.");
                    c cVar = c.this;
                    cVar.a(context, list, cVar.k, i + 1);
                    return;
                }
                sg.bigo.ads.common.t.a.a(0, 3, "StaticVastCompanion", "image list empty, stop preload.");
                if (c.this.b != null) {
                    sg.bigo.ads.ad.interstitial.a.b.c.b bVar = c.this.b;
                    sg.bigo.ads.api.core.c cVar2 = c.this.f12638a;
                    long jElapsedRealtime = SystemClock.elapsedRealtime() - c.this.h;
                    sg.bigo.ads.core.f.a.a.C0894a c0894a2 = c0894a;
                    String str2 = c0894a2 == null ? null : c0894a2.b;
                    int i2 = i - 1;
                    sg.bigo.ads.core.f.a.a.C0894a c0894a3 = c0894a;
                    bVar.a(cVar2, jElapsedRealtime, str2, i2, c0894a3 != null ? c0894a3.e : null, "load failed");
                }
            }
        });
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final View a() {
        return this.c;
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void a(int i) {
        sg.bigo.ads.core.player.c cVar;
        if (i != 1 || (cVar = this.n) == null) {
            return;
        }
        cVar.b();
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void a(int i, int i2) {
        ViewGroup.LayoutParams layoutParams;
        View view = this.e;
        if (view == null || (layoutParams = view.getLayoutParams()) == null || layoutParams.width == -1) {
            return;
        }
        int i3 = layoutParams.width;
        int i4 = layoutParams.height;
        if (i4 == 0 || i3 == 0) {
            return;
        }
        if (i > 0 && i2 > 0) {
            float f = i;
            float f2 = i4;
            float f3 = i3;
            float f4 = (f2 * f) / f3;
            float f5 = i2;
            if (f4 > f5) {
                f = (f3 * f5) / f2;
                f4 = f5;
            }
            i3 = (int) f;
            i4 = (int) f4;
        }
        layoutParams.width = i3;
        layoutParams.height = i4;
        this.e = null;
    }

    public final void a(Context context, i iVar) {
        sg.bigo.ads.api.core.e eVarA;
        sg.bigo.ads.common.t.a.a(0, 3, "StaticVastCompanion", "handle ad click.");
        if (this.f12638a.f().c() == 0 || !(this.p instanceof sg.bigo.ads.ad.c)) {
            eVarA = sg.bigo.ads.ad.interstitial.a.a.a.a(context, this.p, this.f12638a, null, this.o, this.k);
            eVarA.g = 0;
        } else {
            sg.bigo.ads.controller.landing.d.a(this.c.getContext(), g());
            eVarA = new sg.bigo.ads.api.core.e();
            eVarA.g = 1;
        }
        sg.bigo.ads.core.player.c cVar = this.n;
        if (cVar != null && !cVar.c()) {
            this.n.a();
        }
        sg.bigo.ads.ad.interstitial.a.b.c.a aVar = this.f;
        if (aVar != null) {
            aVar.a(iVar, eVarA);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final boolean a(Context context) {
        String str;
        if (!this.l) {
            str = "image resource is disable.";
        } else if (this.g) {
            str = "static vast companion destroyed, stop preload.";
        } else {
            if (!this.m.isEmpty()) {
                this.h = SystemClock.elapsedRealtime();
                sg.bigo.ads.ad.interstitial.a.b.c.b bVar = this.b;
                if (bVar != null) {
                    bVar.a(this.f12638a);
                }
                a(context, this.m, null, 0);
                return true;
            }
            str = "image list empty, stop preload.";
        }
        sg.bigo.ads.common.t.a.a(0, 3, "StaticVastCompanion", str);
        return false;
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final boolean b() {
        return (this.g || this.c == null) ? false : true;
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void c() {
        View view = this.c;
        if (view instanceof WebView) {
            ((WebView) view).onResume();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void d() {
        View view = this.c;
        if (view instanceof WebView) {
            ((WebView) view).onPause();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void e() {
        sg.bigo.ads.common.t.a.a(0, 3, "StaticVastCompanion", "release");
        WebView webView = this.d;
        if (webView != null) {
            webView.setOnTouchListener(null);
            this.d.destroy();
            this.d = null;
        }
        View view = this.c;
        if (view != null) {
            u.b(view);
            this.c = null;
        }
        this.g = true;
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void f() {
        sg.bigo.ads.ad.interstitial.a.b.c.b bVar;
        if (this.j || this.i || (bVar = this.b) == null || this.h <= 0) {
            return;
        }
        bVar.a(this.f12638a, SystemClock.elapsedRealtime() - this.h);
    }

    final sg.bigo.ads.ad.c<?, ?> g() {
        Ad ad = this.p;
        return ad instanceof s ? ((s) ad).w : (sg.bigo.ads.ad.c) ad;
    }
}
