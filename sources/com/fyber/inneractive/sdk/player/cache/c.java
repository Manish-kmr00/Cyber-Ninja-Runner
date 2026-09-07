package com.fyber.inneractive.sdk.player.cache;

import java.io.BufferedWriter;
import java.io.File;

/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f1940a;
    public final /* synthetic */ f b;

    public c(f fVar, d dVar) {
        this.b = fVar;
        this.f1940a = dVar;
        if (dVar.c) {
            return;
        }
        boolean[] zArr = new boolean[fVar.g];
    }

    public final void a() {
        int i;
        f fVar = this.b;
        synchronized (fVar) {
            d dVar = this.f1940a;
            if (dVar.d != this) {
                throw new IllegalStateException();
            }
            for (int i2 = 0; i2 < fVar.g; i2++) {
                f.a(new File(dVar.e.f1942a, dVar.f1941a + "." + i2 + ".tmp"));
            }
            fVar.k++;
            dVar.d = null;
            if (dVar.c) {
                dVar.c = true;
                BufferedWriter bufferedWriter = fVar.i;
                StringBuilder sbAppend = new StringBuilder("CLEAN ").append(dVar.f1941a);
                StringBuilder sb = new StringBuilder();
                for (long j : dVar.b) {
                    sb.append(' ').append(j);
                }
                bufferedWriter.write(sbAppend.append(sb.toString()).append('\n').toString());
            } else {
                fVar.j.remove(dVar.f1941a);
                fVar.i.write("REMOVE " + dVar.f1941a + '\n');
            }
            fVar.i.flush();
            if (fVar.h > fVar.f || ((i = fVar.k) >= 2000 && i >= fVar.j.size())) {
                fVar.m.submit(fVar.n);
            }
        }
    }
}
