package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public final class Hf implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f11177a;
    public final Consumer b;
    public final C4138ga c;

    public Hf(File file, G1 g1, C4138ga c4138ga) {
        this.f11177a = file;
        this.b = g1;
        this.c = c4138ga;
    }

    @Override // java.lang.Runnable
    public final void run() {
        File[] fileArrListFiles;
        if (this.f11177a.exists() && this.f11177a.isDirectory() && (fileArrListFiles = this.f11177a.listFiles()) != null) {
            for (File file : fileArrListFiles) {
                D9 d9A = this.c.a(file.getName());
                try {
                    d9A.f11102a.lock();
                    d9A.b.a();
                    this.b.consume(file);
                    d9A.c();
                } catch (Throwable unused) {
                    d9A.c();
                }
            }
        }
    }
}
