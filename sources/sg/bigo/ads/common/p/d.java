package sg.bigo.ads.common.p;

import android.content.Context;
import java.io.File;
import sg.bigo.ads.common.o;

/* JADX INFO: loaded from: classes7.dex */
public final class d extends sg.bigo.ads.common.p.a {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f13255a = new d(0);
    }

    private d() {
        this.b = new sg.bigo.ads.common.h.a.a();
    }

    /* synthetic */ d(byte b) {
        this();
    }

    @Override // sg.bigo.ads.common.p.a
    protected final String a() {
        return "IconLoader";
    }

    @Override // sg.bigo.ads.common.p.a
    protected final sg.bigo.ads.common.c a(Context context, String str) {
        return c.a(context).c.get(str);
    }

    @Override // sg.bigo.ads.common.p.a
    protected final void a(Context context) {
        c.a(context).c.evictAll();
    }

    @Override // sg.bigo.ads.common.p.a
    protected final void a(Context context, String str, sg.bigo.ads.common.c cVar) {
        c cVarA = c.a(context);
        if (cVar.f13132a.isRecycled()) {
            return;
        }
        cVarA.c.put(str, cVar);
        sg.bigo.ads.common.t.a.a(0, 3, "BitmapCacheManager", "The left cache size: " + (c.f13251a.get() - cVarA.b.size()));
    }

    @Override // sg.bigo.ads.common.p.a
    protected final int b() {
        sg.bigo.ads.common.h.a.a aVar = this.b;
        if (aVar.b == 0) {
            return Integer.MAX_VALUE;
        }
        return aVar.c;
    }

    @Override // sg.bigo.ads.common.p.a
    protected final String b(Context context) {
        return o.f(context);
    }

    @Override // sg.bigo.ads.common.p.a
    protected final void b(Context context, String str) {
        c.a(context).c.remove(str);
    }

    @Override // sg.bigo.ads.common.p.a
    protected final String c(Context context, String str) {
        return o.f(context) + File.separator + str;
    }
}
