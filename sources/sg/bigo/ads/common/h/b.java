package sg.bigo.ads.common.h;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.json.b9;
import com.pubmatic.sdk.common.POBCommonConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import sg.bigo.ads.common.h.b.e;
import sg.bigo.ads.common.utils.f;
import sg.bigo.ads.common.utils.k;
import sg.bigo.ads.common.utils.p;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<sg.bigo.ads.common.h.a> f13192a;
    public final CopyOnWriteArrayList<sg.bigo.ads.common.h.a> b;
    public final CopyOnWriteArrayList<sg.bigo.ads.common.h.a> c;
    public final CopyOnWriteArrayList<sg.bigo.ads.common.h.a> d;
    final a e;
    private final sg.bigo.ads.common.h.a.a f;
    private final Context g;

    public interface a {
        void a(sg.bigo.ads.common.h.a aVar);

        void a(sg.bigo.ads.common.h.a aVar, int i, long j);

        void a(sg.bigo.ads.common.h.a aVar, String str, long j, long j2);
    }

    public b(Context context, sg.bigo.ads.common.h.a.a aVar, boolean z, a aVar2) {
        this.g = context;
        this.e = aVar2;
        sg.bigo.ads.common.h.b.b.a(z);
        this.f = aVar;
        this.f13192a = new CopyOnWriteArrayList<>();
        this.b = new CopyOnWriteArrayList<>();
        this.c = new CopyOnWriteArrayList<>();
        this.d = new CopyOnWriteArrayList<>();
    }

    private static sg.bigo.ads.common.h.a a(List<sg.bigo.ads.common.h.a> list, String str, String str2) {
        if (q.a((CharSequence) str) || q.a((CharSequence) str2)) {
            return null;
        }
        for (sg.bigo.ads.common.h.a aVar : list) {
            if (TextUtils.equals(str, aVar.c) && TextUtils.equals(str2, aVar.d)) {
                return aVar;
            }
        }
        return null;
    }

    private static sg.bigo.ads.common.h.a a(List<sg.bigo.ads.common.h.a> list, sg.bigo.ads.common.h.a aVar) {
        int iIndexOf = list.indexOf(aVar);
        if (iIndexOf < 0) {
            return null;
        }
        try {
            return list.get(iIndexOf);
        } catch (Exception e) {
            a("getExistDownloadInfo e=" + e.getMessage(), (sg.bigo.ads.common.h.a) null);
            return null;
        }
    }

    private static sg.bigo.ads.common.h.a a(List<sg.bigo.ads.common.h.a> list, boolean z) {
        for (sg.bigo.ads.common.h.a aVar : list) {
            if (!z) {
                return aVar;
            }
            int i = aVar.k >= 3 ? Constants.THIRTY_MINUTES : POBCommonConstants.BANNER_BID_EXPIRE_TIME_IN_MILLIS;
            if (aVar.l > 0 && System.currentTimeMillis() - aVar.l > i) {
                return aVar;
            }
            a("no download info execute.", aVar);
        }
        return null;
    }

    private void a(Context context, sg.bigo.ads.common.h.a aVar) {
        aVar.m = SystemClock.elapsedRealtime();
        a("execute download start", aVar);
        if (f.b(aVar.c, aVar.d)) {
            a("executeDownload use local file", aVar);
            f.c(aVar.c, aVar.d);
            aVar.j = 3;
            aVar.i = f.a(aVar.a(), 1);
            this.f13192a.remove(aVar);
            this.b.add(aVar);
            this.e.a(aVar, 0, 0L);
            a();
            return;
        }
        if (!p.b()) {
            this.f13192a.remove(aVar);
            this.e.a(aVar, "internal storage is not enough", SystemClock.elapsedRealtime() - aVar.m, 0L);
            a();
        } else {
            sg.bigo.ads.common.h.b.b.a(context, aVar);
            sg.bigo.ads.common.h.b.b.a(aVar.f13189a, this);
            a("execute downloader", aVar);
            sg.bigo.ads.common.h.b.b.b(aVar.f13189a);
        }
    }

    public static void a(String str, sg.bigo.ads.common.h.a aVar) {
        sg.bigo.ads.common.t.a.a(0, 3, "DownloadManager", str + ", download info = " + (aVar != null ? aVar.toString() : null));
    }

    public static boolean a(List<sg.bigo.ads.common.h.a> list, String str) {
        if (!q.a((CharSequence) str) && !k.a((Collection) list)) {
            Iterator<sg.bigo.ads.common.h.a> it = list.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(str, it.next().b)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean b() {
        return this.f13192a.size() < this.f.f13191a;
    }

    public final sg.bigo.ads.common.h.a a(String str, String str2) {
        if (q.a((CharSequence) str) || q.a((CharSequence) str2)) {
            return null;
        }
        sg.bigo.ads.common.h.a aVarA = a(this.f13192a, str, str2);
        if (aVarA == null) {
            aVarA = a(this.b, str, str2);
        }
        if (aVarA == null) {
            aVarA = a(this.c, str, str2);
        }
        return aVarA == null ? a(this.d, str, str2) : aVarA;
    }

    final void a() {
        if (sg.bigo.ads.common.x.a.p()) {
            return;
        }
        a("continue to execute download task", (sg.bigo.ads.common.h.a) null);
        if (!b()) {
            a("no idle download thread", (sg.bigo.ads.common.h.a) null);
            return;
        }
        sg.bigo.ads.common.h.a aVarA = a((List<sg.bigo.ads.common.h.a>) this.c, false);
        if (aVarA != null) {
            a("waiting to downloading", aVarA);
            this.c.remove(aVarA);
        }
        if (aVarA == null && (aVarA = a((List<sg.bigo.ads.common.h.a>) this.d, true)) != null) {
            a("failed to downloading", aVarA);
            this.d.remove(aVarA);
        }
        if (aVarA == null) {
            a("no download info execute.", (sg.bigo.ads.common.h.a) null);
        } else {
            this.f13192a.add(aVarA);
            a(this.g, aVarA);
        }
    }

    @Override // sg.bigo.ads.common.h.b.e
    public final void a(String str) {
        final sg.bigo.ads.common.h.a aVarA = sg.bigo.ads.common.h.b.b.a(str);
        if (aVarA == null) {
            a("onStart info is null.", (sg.bigo.ads.common.h.a) null);
        } else {
            sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.common.h.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.e.a(aVarA);
                }
            });
        }
    }

    @Override // sg.bigo.ads.common.h.b.e
    public final void a(final String str, final String str2, final long j) {
        sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.common.h.b.4
            @Override // java.lang.Runnable
            public final void run() {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                sg.bigo.ads.common.h.a aVarA = sg.bigo.ads.common.h.b.b.a(str);
                if (aVarA == null) {
                    return;
                }
                b.a("download failed", aVarA);
                aVarA.j = 4;
                if (!aVarA.n) {
                    aVarA.k++;
                }
                aVarA.l = System.currentTimeMillis();
                b.this.e.a(aVarA, str2, jElapsedRealtime - aVarA.m, j);
                b.a("download failed update fail count", aVarA);
                b.this.f13192a.remove(aVarA);
                b.this.d.add(aVarA);
                b.a("downloading to failed", aVarA);
                b.this.a();
            }
        });
    }

    public final void a(sg.bigo.ads.common.h.a aVar, boolean z) {
        a("start the download, force=".concat(String.valueOf(z)), aVar);
        if (f.b(aVar.a())) {
            a("downloaded and exist local file", aVar);
            f.c(aVar.c, aVar.d);
            this.e.a(aVar, 0, 0L);
            return;
        }
        if (a(this.f13192a, aVar) != null) {
            a("downloading", aVar);
            return;
        }
        if (this.f.b()) {
            this.e.a(aVar, "Unable to download media file.", 0L, 0L);
            return;
        }
        sg.bigo.ads.common.h.a aVarA = a(this.c, aVar);
        if (aVarA != null) {
            a("waiting", aVar);
            aVarA.b = aVar.b;
            if (!z && !b()) {
                a("waiting not executing", aVar);
                return;
            }
        }
        sg.bigo.ads.common.h.a aVarA2 = a(this.d, aVar);
        if (aVarA2 != null) {
            a(b9.h.t, aVar);
            this.d.remove(aVarA2);
            aVarA2.b = aVar.b;
            aVarA2.j = 0;
            aVar = aVarA2;
        }
        if (!b() && !z) {
            a("join download waiting queue", aVar);
            this.c.add(aVar);
        } else {
            a("execute download", aVar);
            aVar.n = z;
            this.f13192a.add(aVar);
            a(this.g, aVar);
        }
    }

    @Override // sg.bigo.ads.common.h.b.e
    public final void b(String str) {
        final sg.bigo.ads.common.h.a aVarA = sg.bigo.ads.common.h.b.b.a(str);
        if (aVarA == null) {
            a("onLoading info is null.", (sg.bigo.ads.common.h.a) null);
            return;
        }
        if (aVarA.j != 1) {
            a("onLoading", aVarA);
            aVarA.j = 1;
        }
        if (aVarA.i <= 0 || (aVarA.g - aVarA.h) * 100 <= aVarA.i * 10) {
            return;
        }
        aVarA.h = aVarA.g;
        if (aVarA.h()) {
            int iA = sg.bigo.ads.common.aa.c.a(this.g);
            if (iA == 3 || iA == 4 || iA == 5) {
                final long jElapsedRealtime = SystemClock.elapsedRealtime() - aVarA.m;
                a("partial download callback", aVarA);
                sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.common.h.b.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.this.e.a(aVarA, 2, jElapsedRealtime);
                    }
                });
            }
        }
    }

    @Override // sg.bigo.ads.common.h.b.e
    public final void c(String str) {
        sg.bigo.ads.common.h.a aVarA = sg.bigo.ads.common.h.b.b.a(str);
        if (aVarA != null) {
            aVarA.j = 2;
        }
    }

    @Override // sg.bigo.ads.common.h.b.e
    public final void d(final String str) {
        sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.common.h.b.3
            @Override // java.lang.Runnable
            public final void run() {
                sg.bigo.ads.common.h.a aVarA = sg.bigo.ads.common.h.b.b.a(str);
                if (aVarA == null) {
                    return;
                }
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                b.a("download succeed", aVarA);
                aVarA.j = 3;
                b.this.f13192a.remove(aVarA);
                b.this.b.add(aVarA);
                b.this.e.a(aVarA, 1, jElapsedRealtime - aVarA.m);
                b.a("downloading to downloaded", aVarA);
                sg.bigo.ads.common.h.b.b.a(aVarA.f13189a);
                b.this.a();
            }
        });
    }
}
