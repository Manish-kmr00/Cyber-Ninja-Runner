package com.fyber.inneractive.sdk.player.cache;

import com.fyber.inneractive.sdk.network.AbstractC3149z;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.File;

/* JADX INFO: loaded from: classes6.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f1947a;

    public l(m mVar) {
        this.f1947a = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long j;
        File fileA = m.a(this.f1947a.f1948a, "fyb.vamp.vid.cache");
        if (fileA != null) {
            try {
                IAlog.a("VideoCache opening the cache in directory - %s", fileA);
                this.f1947a.b = f.b(fileA);
                f fVar = this.f1947a.b;
                fVar.getClass();
                IAlog.e("DiskLruCache delete cache", new Object[0]);
                fVar.close();
                k.a(fVar.f1942a);
                this.f1947a.b = f.b(fileA);
                f fVar2 = this.f1947a.b;
                synchronized (fVar2) {
                    j = fVar2.h;
                }
                IAlog.a("VideoCache opened the cache in directory - %s current size is %d", fileA, Long.valueOf(j));
                m mVar = this.f1947a;
                mVar.b.l = mVar;
                mVar.c = true;
            } catch (Throwable th) {
                AbstractC3149z.a("Failed to open cache directory", th.getMessage(), null, null);
                IAlog.a("Failed to open cache directory", th, new Object[0]);
            }
        }
    }
}
