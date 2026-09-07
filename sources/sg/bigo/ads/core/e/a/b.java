package sg.bigo.ads.core.e.a;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import com.pubmatic.sdk.common.POBCommonConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import sg.bigo.ads.api.core.r;

/* JADX INFO: loaded from: classes7.dex */
public abstract class b {
    protected r e;
    protected e f;
    public CopyOnWriteArrayList<d> k;
    public CopyOnWriteArrayList<d> l;
    public CopyOnWriteArrayList<d> m;
    public CopyOnWriteArrayList<d> n;
    private final Map<String, String> o;
    private int p;
    public long g = 0;
    public long h = 0;
    public long i = 0;
    public long j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CopyOnWriteArrayList<d> f13558a = new CopyOnWriteArrayList<>();
    public CopyOnWriteArrayList<d> b = new CopyOnWriteArrayList<>();
    public CopyOnWriteArrayList<d> c = new CopyOnWriteArrayList<>();
    public CopyOnWriteArrayList<d> d = new CopyOnWriteArrayList<>();

    public b(r rVar) {
        this.e = rVar;
        HashMap map = new HashMap();
        this.o = map;
        this.f = new e(this.e, map);
    }

    private void a(Context context, final String str, final d dVar, final boolean z) {
        String str2 = dVar.b;
        sg.bigo.ads.common.u.a aVarD = dVar.d();
        dVar.a();
        sg.bigo.ads.core.e.b.a(context, str, aVarD, str2, this.p, this.o, new sg.bigo.ads.core.e.b.a() { // from class: sg.bigo.ads.core.e.a.b.5
            @Override // sg.bigo.ads.core.e.b.a
            public final void a() {
                if (dVar.c == 1) {
                    b.a(b.this, str, dVar, true);
                }
                c.a().b(b.this.f);
            }

            @Override // sg.bigo.ads.core.e.b.a
            public final boolean a(int i) {
                return b.this.e.a(i);
            }

            @Override // sg.bigo.ads.core.e.b.a
            public final void b() {
                b.a(b.this, str, dVar, z);
                c.a().b(b.this.f);
            }
        });
    }

    static /* synthetic */ void a(b bVar, Context context, final String str, d dVar) {
        String strA = dVar.d().a();
        final String str2 = dVar.b;
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        if ("sizmek".equals(str2)) {
            strA = strA.replaceAll("\\?", "%3f");
        }
        bVar.a(str, "start", new sg.bigo.ads.common.u.b.d(strA), str2);
        final sg.bigo.ads.core.h.e eVarA = sg.bigo.ads.core.h.e.a(context);
        if (eVarA != null) {
            eVarA.setWebViewClient(new sg.bigo.ads.core.h.d() { // from class: sg.bigo.ads.core.e.a.b.6
                @Override // sg.bigo.ads.core.h.d
                public final void a(RenderProcessGoneDetail renderProcessGoneDetail) {
                    eVarA.destroy();
                }

                @Override // sg.bigo.ads.core.h.d, android.webkit.WebViewClient
                public final void onPageFinished(WebView webView, String str3) {
                    super.onPageFinished(webView, str3);
                    b.this.a(str, "success", new sg.bigo.ads.common.u.b.d(str3), str2);
                }

                @Override // android.webkit.WebViewClient
                public final boolean shouldOverrideUrlLoading(WebView webView, String str3) {
                    return false;
                }
            });
            try {
                if (dVar.f13569a == 1) {
                    eVarA.loadUrl(strA);
                } else if (dVar.f13569a == 2) {
                    eVarA.loadData(strA, POBCommonConstants.CONTENT_TYPE_HTML, "UTF-8");
                }
            } catch (Exception e) {
                sg.bigo.ads.core.d.b.a(3002, 10106, e.getMessage());
            }
        }
    }

    static /* synthetic */ void a(b bVar, String str, d dVar, boolean z) {
        CopyOnWriteArrayList<d> copyOnWriteArrayList;
        CopyOnWriteArrayList<d> copyOnWriteArrayList2;
        CopyOnWriteArrayList<d> copyOnWriteArrayList3;
        CopyOnWriteArrayList<d> copyOnWriteArrayList4;
        if ("impl_track".equals(str)) {
            if (!z || (copyOnWriteArrayList4 = bVar.k) == null) {
                return;
            }
            copyOnWriteArrayList4.remove(dVar);
            return;
        }
        if ("click_track".equals(str)) {
            if (!z || (copyOnWriteArrayList3 = bVar.l) == null) {
                return;
            }
            copyOnWriteArrayList3.remove(dVar);
            return;
        }
        if ("nurl_track".equals(str)) {
            if (!z || (copyOnWriteArrayList2 = bVar.m) == null) {
                return;
            }
            copyOnWriteArrayList2.remove(dVar);
            return;
        }
        if ("lurl_track".equals(str) && z && (copyOnWriteArrayList = bVar.n) != null) {
            copyOnWriteArrayList.remove(dVar);
        }
    }

    public final void a(int i) {
        this.p = i;
        e eVar = this.f;
        if (eVar != null) {
            eVar.r = i;
        }
    }

    public final void a(Context context, String str, String str2, String str3) {
        g gVarA = g.a(this.o, this.e, this.p, str, str2, str3);
        gVarA.a(context, gVarA.f13572a);
    }

    protected final void a(final Context context, boolean z) {
        if (sg.bigo.ads.common.x.a.p()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z2 = this.e.f13115a;
        Iterator<d> it = this.f13558a.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
        if (z2) {
            this.g = jCurrentTimeMillis;
            this.k = new CopyOnWriteArrayList<>();
            for (d dVar : this.f13558a) {
                if (!z || dVar.a()) {
                    if (dVar.c()) {
                        this.k.add(dVar);
                    }
                }
            }
            if (this.k.size() > 0) {
                this.f.s = this.k;
                this.f.j = jCurrentTimeMillis;
                this.f.i = 0;
                c.a().a(this.f);
            }
        } else {
            sg.bigo.ads.common.t.a.a(0, 3, "AdTracker", "trackThirdImpression not need retry");
        }
        for (final d dVar2 : this.f13558a) {
            if (!z || dVar2.a()) {
                if (dVar2.c()) {
                    a(context, "impl_track", dVar2, z2);
                } else {
                    sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.core.e.a.b.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            b.a(b.this, context, "impl_track", dVar2);
                        }
                    });
                }
            }
        }
    }

    protected final void a(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.o.put(str, str2);
    }

    final void a(String str, String str2, sg.bigo.ads.common.u.a aVar, String str3) {
        HashMap map = new HashMap(this.o);
        if (TextUtils.isEmpty(str)) {
            str = "unknown";
        }
        map.put("action", str);
        map.put("track_url", aVar.a());
        map.put("domain_front", aVar.e() ? aVar.d() : "");
        map.put("track_name", str3);
        map.put("states", str2);
        map.put("retry", "0");
        map.put("out_ad", String.valueOf(this.p));
        if ("impl_track".equals(str)) {
            sg.bigo.ads.core.d.b.a(map);
        } else if ("click_track".equals(str)) {
            sg.bigo.ads.core.d.b.b(map);
        }
    }

    protected final void b(final Context context, boolean z) {
        if (sg.bigo.ads.common.x.a.p()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z2 = this.e.f13115a;
        Iterator<d> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
        if (z2) {
            this.h = jCurrentTimeMillis;
            this.l = new CopyOnWriteArrayList<>();
            for (d dVar : this.b) {
                if (!z || dVar.a()) {
                    if (dVar.c()) {
                        this.l.add(dVar);
                    }
                }
            }
            if (this.l.size() > 0) {
                this.f.t = this.l;
                this.f.l = jCurrentTimeMillis;
                this.f.k = 0;
                c.a().a(this.f);
            }
        } else {
            sg.bigo.ads.common.t.a.a(0, 3, "AdTracker", "trackThirdClick not need retry");
        }
        for (final d dVar2 : this.b) {
            if (!z || dVar2.a()) {
                if (dVar2.c()) {
                    a(context, "click_track", dVar2, z2);
                } else {
                    sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.core.e.a.b.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            b.a(b.this, context, "click_track", dVar2);
                        }
                    });
                }
            }
        }
    }

    public final void b(String str, String str2) {
        for (d dVar : this.f13558a) {
            if (dVar.c()) {
                dVar.a(str, str2);
            }
        }
        for (d dVar2 : this.b) {
            if (dVar2.c()) {
                dVar2.a(str, str2);
            }
        }
        for (d dVar3 : this.c) {
            if (dVar3.c()) {
                dVar3.a(str, str2);
            }
        }
        for (d dVar4 : this.d) {
            if (dVar4.c()) {
                dVar4.a(str, str2);
            }
        }
    }

    protected final void c(final Context context, boolean z) {
        if (sg.bigo.ads.common.x.a.p()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z2 = this.e.f13115a;
        Iterator<d> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
        if (z2) {
            this.i = jCurrentTimeMillis;
            this.m = new CopyOnWriteArrayList<>();
            for (d dVar : this.c) {
                if (!z || dVar.a()) {
                    if (dVar.c()) {
                        this.m.add(dVar);
                    }
                }
            }
            if (this.m.size() > 0) {
                this.f.u = this.m;
                this.f.n = jCurrentTimeMillis;
                this.f.m = 0;
                c.a().a(this.f);
            }
        } else {
            sg.bigo.ads.common.t.a.a(0, 3, "AdTracker", "trackThirdNUrl not need retry");
        }
        for (final d dVar2 : this.c) {
            if (!z || dVar2.a()) {
                if (dVar2.c()) {
                    a(context, "nurl_track", dVar2, z2);
                } else {
                    sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.core.e.a.b.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            b.a(b.this, context, "nurl_track", dVar2);
                        }
                    });
                }
            }
        }
    }

    protected final void d(final Context context, boolean z) {
        if (sg.bigo.ads.common.x.a.p()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z2 = this.e.f13115a;
        Iterator<d> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
        if (z2) {
            this.j = jCurrentTimeMillis;
            this.n = new CopyOnWriteArrayList<>();
            for (d dVar : this.d) {
                if (!z || dVar.a()) {
                    if (dVar.c()) {
                        this.n.add(dVar);
                    }
                }
            }
            if (this.n.size() > 0) {
                this.f.v = this.n;
                this.f.p = jCurrentTimeMillis;
                this.f.o = 0;
                c.a().a(this.f);
            }
        } else {
            sg.bigo.ads.common.t.a.a(0, 3, "AdTracker", "trackThirdLUrl not need retry");
        }
        for (final d dVar2 : this.d) {
            if (!z || dVar2.a()) {
                if (dVar2.c()) {
                    a(context, "lurl_track", dVar2, z2);
                } else {
                    sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.core.e.a.b.4
                        @Override // java.lang.Runnable
                        public final void run() {
                            b.a(b.this, context, "lurl_track", dVar2);
                        }
                    });
                }
            }
        }
    }
}
