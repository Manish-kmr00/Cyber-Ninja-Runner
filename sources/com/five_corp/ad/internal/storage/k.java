package com.five_corp.ad.internal.storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ byte[] f1535a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ o d;

    public k(o oVar, byte[] bArr, int i, int i2) {
        this.d = oVar;
        this.f1535a = bArr;
        this.b = i;
        this.c = i2;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.five_corp.ad.internal.storage.n, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.five_corp.ad.internal.storage.n, java.lang.Object] */
    @Override // java.lang.Runnable
    public final void run() {
        com.five_corp.ad.internal.util.f fVar;
        com.five_corp.ad.internal.util.f fVar2;
        com.five_corp.ad.internal.util.f fVar3;
        o oVar = this.d;
        FileOutputStream fileOutputStream = oVar.h;
        if (fileOutputStream != null) {
            fVar2 = new com.five_corp.ad.internal.util.f(true, null, fileOutputStream);
        } else {
            if (oVar.g) {
                fVar3 = new com.five_corp.ad.internal.util.f(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.I2, null, null, null), null);
            } else {
                b bVar = oVar.c;
                String str = oVar.b;
                bVar.getClass();
                try {
                    fVar = new com.five_corp.ad.internal.util.f(true, null, new FileOutputStream(new File(bVar.f1526a, str), true));
                } catch (FileNotFoundException e) {
                    fVar = new com.five_corp.ad.internal.util.f(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.m3, null, e, null), null);
                }
                if (fVar.f1560a) {
                    FileOutputStream fileOutputStream2 = (FileOutputStream) fVar.c;
                    oVar.h = fileOutputStream2;
                    try {
                        fileOutputStream2.getChannel().truncate(oVar.f1538a);
                        fVar3 = new com.five_corp.ad.internal.util.f(true, null, oVar.h);
                    } catch (IOException e2) {
                        fVar2 = new com.five_corp.ad.internal.util.f(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.F2, null, e2, null), null);
                    }
                } else {
                    fVar3 = new com.five_corp.ad.internal.util.f(false, fVar.b, null);
                }
            }
            fVar2 = fVar3;
        }
        if (!fVar2.f1560a) {
            o oVar2 = this.d;
            oVar2.e.b(fVar2.b);
            oVar2.a();
            return;
        }
        try {
            ((FileOutputStream) fVar2.c).write(this.f1535a, this.b, this.c);
            Object obj = this.d.e;
        } catch (IOException unused) {
            o oVar3 = this.d;
            oVar3.e.b(new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.G2, null, null, null));
            oVar3.a();
        }
    }
}
