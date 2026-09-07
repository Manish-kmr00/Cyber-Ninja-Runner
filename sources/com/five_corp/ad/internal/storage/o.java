package com.five_corp.ad.internal.storage;

import android.os.Handler;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1538a;
    public final String b;
    public final b c;
    public final Handler d;
    public final Object e;
    public final com.five_corp.ad.internal.logger.a f;
    public boolean g = false;
    public FileOutputStream h = null;

    public o(int i, String str, b bVar, Handler handler, n nVar, com.five_corp.ad.internal.logger.a aVar) {
        this.f1538a = i;
        this.b = str;
        this.c = bVar;
        this.d = handler;
        this.e = nVar;
        this.f = aVar;
    }

    public final void a() {
        if (this.g) {
            return;
        }
        this.g = true;
        FileOutputStream fileOutputStream = this.h;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                this.f.a(e);
            }
            this.h = null;
        }
    }
}
