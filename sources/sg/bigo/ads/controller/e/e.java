package sg.bigo.ads.controller.e;

import android.content.Context;
import android.os.SystemClock;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.BigoAdSdk;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes12.dex */
public final class e extends sg.bigo.ads.controller.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final sg.bigo.ads.common.g f13455a;
    final sg.bigo.ads.controller.b.d b;
    final sg.bigo.ads.controller.b.h c;
    int g;
    final Context h;
    private final sg.bigo.ads.controller.a.b i;
    private int l;
    long d = -1;
    boolean e = false;
    private final List<b> j = new ArrayList();
    private final AtomicReference<sg.bigo.ads.controller.g.h> k = new AtomicReference<>();
    final AtomicInteger f = new AtomicInteger(0);

    public interface a {
        void a(int i);

        void a(int i, int i2, String str);
    }

    static class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f13458a;
        private final a b;

        public b(String str, a aVar) {
            this.f13458a = str;
            this.b = aVar;
            if (c.a().b.compareAndSet(-1, 0)) {
                sg.bigo.ads.common.t.a.a(0, 3, "ConfigInitProcessor", "reinit config and set status.");
            }
        }

        @Override // sg.bigo.ads.controller.e.e.a
        public final void a(int i) {
            c.a().b();
            a aVar = this.b;
            if (aVar != null) {
                aVar.a(i);
            }
        }

        @Override // sg.bigo.ads.controller.e.e.a
        public final void a(int i, int i2, String str) {
            c cVarA = c.a();
            String str2 = this.f13458a;
            if (1101 == i2 || 1105 == i2) {
                Map concurrentHashMap = cVarA.f13453a;
                if (concurrentHashMap == null) {
                    concurrentHashMap = new ConcurrentHashMap();
                    cVarA.f13453a = concurrentHashMap;
                }
                if (str2 != null && c.a(concurrentHashMap, str2)) {
                    concurrentHashMap.put(str2, Long.valueOf(SystemClock.elapsedRealtime()));
                }
                if (cVarA.b.compareAndSet(0, -1)) {
                    sg.bigo.ads.common.t.a.a(0, "ConfigInitProcessor", "Failed to init config and set status.");
                }
            }
            a aVar = this.b;
            if (aVar != null) {
                aVar.a(i, i2, str);
            }
        }
    }

    public e(Context context, sg.bigo.ads.controller.b.d dVar, sg.bigo.ads.controller.b.h hVar, sg.bigo.ads.common.g gVar, sg.bigo.ads.controller.a.b bVar) {
        this.h = context;
        this.f13455a = gVar;
        this.b = dVar;
        this.c = hVar;
        this.i = bVar;
    }

    private void a(int i, int i2) {
        if (this.k.get() != null) {
            return;
        }
        this.k.set(new sg.bigo.ads.controller.g.h(this.f13455a, this.i, sg.bigo.ads.controller.b.d.y(), this));
        this.g = i;
        this.d = SystemClock.elapsedRealtime();
        this.e = sg.bigo.ads.common.f.b.d();
        this.f.incrementAndGet();
        this.l = i2;
        String strA = this.f13455a.a();
        if (q.a((CharSequence) strA)) {
            b(1100, "App id cannot be empty, please pass the id when initializing bigo sdk");
        } else if (c.a().a(strA)) {
            this.k.get().b();
        } else {
            b(1101, "The slot id is invalid, please make sure the id is aligned with app id.");
        }
    }

    static /* synthetic */ void a(e eVar) {
        eVar.k.set(null);
        Iterator<b> it = eVar.j.iterator();
        while (it.hasNext()) {
            it.next().a(eVar.l);
        }
        eVar.j.clear();
    }

    @Override // sg.bigo.ads.controller.e
    public final void a(final int i, final int i2, final int i3, final String str, Object obj) {
        sg.bigo.ads.common.n.d.a(3, new Runnable() { // from class: sg.bigo.ads.controller.e.e.2
            @Override // java.lang.Runnable
            public final void run() {
                e eVar;
                int i4;
                sg.bigo.ads.common.t.a.a(0, "GlobalConfig", "request error, seq=" + i + ", error=" + i2 + ", message=" + str);
                String str2 = "Error from server: " + str;
                if (i3 == -9) {
                    eVar = e.this;
                    i4 = 1105;
                } else {
                    eVar = e.this;
                    i4 = IronSourceConstants.RV_CHECK_PLACEMENT_CAPPED;
                }
                eVar.b(i4, str2);
                sg.bigo.ads.core.d.b.a(SystemClock.elapsedRealtime() - e.this.d, i2, i3, str, e.this.g, e.this.e, e.this.f.get(), e.this.f13455a == null ? null : e.this.f13455a.X());
            }
        });
    }

    @Override // sg.bigo.ads.controller.b
    public final void a(final int i, final String str) {
        sg.bigo.ads.common.n.d.a(3, new Runnable() { // from class: sg.bigo.ads.controller.e.e.1
            @Override // java.lang.Runnable
            public final void run() {
                sg.bigo.ads.common.t.a.a(0, 3, "GlobalConfig", "request success, seq=" + i + ", result=" + str);
                try {
                    boolean zH = e.this.b.H();
                    JSONObject jSONObject = new JSONObject(str);
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("global");
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("slots");
                    if (jSONObjectOptJSONObject != null && jSONArrayOptJSONArray != null) {
                        e.this.b.e(jSONObjectOptJSONObject);
                        e.this.b.c(e.this.h);
                        e.this.c.a(jSONArrayOptJSONArray);
                        e.this.c.c(e.this.h);
                        sg.bigo.ads.a aVarA = BigoAdSdk.a(e.this.h);
                        aVarA.f12462a = e.this.f13455a.a();
                        aVarA.c(e.this.h);
                        e.a(e.this);
                        sg.bigo.ads.core.d.b.a(e.this.b.i(), SystemClock.elapsedRealtime() - e.this.d, zH, e.this.g, e.this.e, e.this.f.getAndSet(0), e.this.f13455a == null ? null : e.this.f13455a.X());
                        h.a().a(e.this.b.D());
                        return;
                    }
                    e.this.b(IronSourceConstants.RV_API_HAS_AVAILABILITY_FALSE, "Missing `global` or `slots` params.");
                    sg.bigo.ads.core.d.b.a(SystemClock.elapsedRealtime() - e.this.d, IronSourceConstants.RV_API_HAS_AVAILABILITY_FALSE, Sdk.SDKError.Reason.AD_LOAD_TOO_FREQUENTLY_VALUE, "Missing `global` or `slots` params.", e.this.g, e.this.e, e.this.f.get(), e.this.f13455a == null ? null : e.this.f13455a.X());
                } catch (JSONException unused) {
                    e.this.b(1103, "Failed to parse global config.");
                    sg.bigo.ads.core.d.b.a(SystemClock.elapsedRealtime() - e.this.d, 1103, Sdk.SDKError.Reason.AD_LOAD_TOO_FREQUENTLY_VALUE, "Failed to parse global config.", e.this.g, e.this.e, e.this.f.get(), e.this.f13455a != null ? e.this.f13455a.X() : null);
                }
            }
        });
    }

    public final void a(a aVar, int i) {
        b bVar = new b(this.f13455a.a(), aVar);
        int iW = this.b.w();
        if (iW != 2) {
            if (iW == 3) {
                this.j.add(bVar);
                a(i, iW);
                return;
            } else if (iW == 4) {
                bVar.a(iW);
                a(i, iW);
                return;
            } else if (iW != 5) {
                return;
            }
        }
        bVar.a(iW);
    }

    final void b(int i, String str) {
        this.k.set(null);
        if (this.j.isEmpty()) {
            return;
        }
        this.j.remove(0).a(this.l, i, str);
        if (this.j.isEmpty()) {
            return;
        }
        a(this.g, this.l);
    }
}
