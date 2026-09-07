package com.iab.omid.library.ogury.internal;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.ogury.walking.TreeWalker;
import java.util.Iterator;

/* JADX INFO: loaded from: classes13.dex */
public class h implements d.a, com.iab.omid.library.ogury.devicevolume.c {
    private static h f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f2808a = 0.0f;
    private final com.iab.omid.library.ogury.devicevolume.e b;
    private final com.iab.omid.library.ogury.devicevolume.b c;
    private com.iab.omid.library.ogury.devicevolume.d d;
    private c e;

    public h(com.iab.omid.library.ogury.devicevolume.e eVar, com.iab.omid.library.ogury.devicevolume.b bVar) {
        this.b = eVar;
        this.c = bVar;
    }

    private c a() {
        if (this.e == null) {
            this.e = c.c();
        }
        return this.e;
    }

    public static h c() {
        if (f == null) {
            f = new h(new com.iab.omid.library.ogury.devicevolume.e(), new com.iab.omid.library.ogury.devicevolume.b());
        }
        return f;
    }

    @Override // com.iab.omid.library.ogury.devicevolume.c
    public void a(float f2) {
        this.f2808a = f2;
        Iterator<com.iab.omid.library.ogury.adsession.a> it = a().a().iterator();
        while (it.hasNext()) {
            it.next().getAdSessionStatePublisher().a(f2);
        }
    }

    public void a(Context context) {
        this.d = this.b.a(new Handler(), context, this.c.a(), this);
    }

    @Override // com.iab.omid.library.ogury.internal.d.a
    public void a(boolean z) {
        if (z) {
            TreeWalker.getInstance().h();
        } else {
            TreeWalker.getInstance().g();
        }
    }

    public float b() {
        return this.f2808a;
    }

    public void d() {
        b.g().a(this);
        b.g().e();
        TreeWalker.getInstance().h();
        this.d.c();
    }

    public void e() {
        TreeWalker.getInstance().j();
        b.g().f();
        this.d.d();
    }
}
