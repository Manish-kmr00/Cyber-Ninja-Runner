package sg.bigo.ads.common.p;

import android.content.Context;
import java.io.File;
import sg.bigo.ads.common.o;

/* JADX INFO: loaded from: classes8.dex */
public final class h extends sg.bigo.ads.common.p.a {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final h f13258a = new h(0);
    }

    private h() {
        this.b = new sg.bigo.ads.common.h.a.a();
    }

    /* synthetic */ h(byte b) {
        this();
    }

    @Override // sg.bigo.ads.common.p.a
    protected final String a() {
        return "ImageLoader";
    }

    @Override // sg.bigo.ads.common.p.a
    protected final sg.bigo.ads.common.c a(Context context, String str) {
        return c.a(context).b.get(str);
    }

    @Override // sg.bigo.ads.common.p.a
    protected final void a(Context context) {
        c.a(context).b.evictAll();
    }

    @Override // sg.bigo.ads.common.p.a
    protected final void a(Context context, String str, sg.bigo.ads.common.c cVar) {
        c cVarA = c.a(context);
        if (cVar.f13132a.isRecycled()) {
            return;
        }
        cVarA.b.put(str, cVar);
        sg.bigo.ads.common.t.a.a(0, 3, "BitmapCacheManager", "The left cache size: " + (c.f13251a.get() - cVarA.b.size()));
    }

    @Override // sg.bigo.ads.common.p.a
    protected final int b() {
        return this.b.a();
    }

    @Override // sg.bigo.ads.common.p.a
    protected final String b(Context context) {
        return o.e(context);
    }

    @Override // sg.bigo.ads.common.p.a
    protected final void b(Context context, String str) {
        c.a(context).b.remove(str);
    }

    @Override // sg.bigo.ads.common.p.a
    protected final String c(Context context, String str) {
        return o.e(context) + File.separator + str;
    }
}
