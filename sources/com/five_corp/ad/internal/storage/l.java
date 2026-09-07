package com.five_corp.ad.internal.storage;

import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f1536a;

    public l(o oVar) {
        this.f1536a = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FileOutputStream fileOutputStream;
        o oVar = this.f1536a;
        if (oVar.g || (fileOutputStream = oVar.h) == null) {
            return;
        }
        try {
            fileOutputStream.flush();
            oVar.h.getFD().sync();
        } catch (IOException e) {
            oVar.f.a(e);
        }
    }
}
