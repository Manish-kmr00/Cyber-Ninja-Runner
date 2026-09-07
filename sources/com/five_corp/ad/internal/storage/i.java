package com.five_corp.ad.internal.storage;

import android.os.Handler;
import com.five_corp.ad.internal.movie.partialcache.C3000e;
import com.five_corp.ad.internal.movie.partialcache.q1;
import com.five_corp.ad.internal.movie.partialcache.s1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public final class i {
    public static final byte[] i = new byte[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1533a;
    public final String b;
    public final b c;
    public final Handler d;
    public final C3000e e;
    public boolean f = false;
    public int g = 0;
    public InputStream h = null;

    public i(int i2, String str, b bVar, Handler handler, C3000e c3000e) {
        this.f1533a = i2;
        this.b = str;
        this.c = bVar;
        this.d = handler;
        this.e = c3000e;
    }

    public static void a(i iVar, int i2) {
        com.five_corp.ad.internal.util.f fVar;
        long j;
        com.five_corp.ad.internal.util.f fVar2;
        int i3;
        if (i2 < 0) {
            iVar.getClass();
            com.five_corp.ad.internal.o oVar = new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.B2, "Request length: " + i2, null, null);
            s1 s1Var = (s1) iVar.e.d;
            s1Var.getClass();
            s1Var.b(new q1(s1Var, oVar));
        } else {
            InputStream inputStream = iVar.h;
            if (inputStream != null) {
                fVar2 = new com.five_corp.ad.internal.util.f(true, null, inputStream);
            } else if (iVar.f) {
                fVar2 = new com.five_corp.ad.internal.util.f(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.C2, null, null, null), null);
            } else {
                b bVar = iVar.c;
                String str = iVar.b;
                bVar.getClass();
                try {
                    fVar = new com.five_corp.ad.internal.util.f(true, null, new FileInputStream(new File(bVar.f1526a, str)));
                } catch (FileNotFoundException e) {
                    fVar = new com.five_corp.ad.internal.util.f(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.l3, null, e, null), null);
                }
                if (fVar.f1560a) {
                    iVar.h = (InputStream) fVar.c;
                    long jSkip = 0;
                    int i4 = 0;
                    while (true) {
                        j = iVar.f1533a;
                        if (jSkip >= j || i4 >= 16) {
                            break;
                        }
                        try {
                            jSkip += iVar.h.skip(j - jSkip);
                            i4++;
                        } catch (IOException e2) {
                            fVar2 = new com.five_corp.ad.internal.util.f(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.w2, null, e2, null), null);
                        }
                    }
                    fVar2 = jSkip < j ? new com.five_corp.ad.internal.util.f(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.x2, null, null, null), null) : new com.five_corp.ad.internal.util.f(true, null, iVar.h);
                } else {
                    fVar2 = new com.five_corp.ad.internal.util.f(false, fVar.b, null);
                }
            }
            if (fVar2.f1560a) {
                byte[] bArr = new byte[i2];
                try {
                    int i5 = ((InputStream) fVar2.c).read(bArr);
                    if (i5 > 0) {
                        iVar.e.a(iVar, bArr, i5);
                    } else {
                        iVar.e.a(iVar, i, 0);
                    }
                    return;
                } catch (IOException unused) {
                    com.five_corp.ad.internal.o oVar2 = new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.y2, null, null, null);
                    s1 s1Var2 = (s1) iVar.e.d;
                    s1Var2.getClass();
                    s1Var2.b(new q1(s1Var2, oVar2));
                }
            } else {
                com.five_corp.ad.internal.o oVar3 = fVar2.b;
                if (oVar3.f1517a == com.five_corp.ad.internal.p.l3 && (i3 = iVar.g) < 3) {
                    iVar.g = i3 + 1;
                    iVar.d.postDelayed(new g(iVar, i2), 50 << i3);
                    return;
                } else {
                    s1 s1Var3 = (s1) iVar.e.d;
                    s1Var3.getClass();
                    s1Var3.b(new q1(s1Var3, oVar3));
                }
            }
        }
        iVar.a();
    }

    public final void a() {
        if (this.f) {
            return;
        }
        this.f = true;
        InputStream inputStream = this.h;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                C3000e c3000e = this.e;
                com.five_corp.ad.internal.o oVar = new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.A2, "fail to close file input stream", e, null);
                s1 s1Var = (s1) c3000e.d;
                s1Var.getClass();
                s1Var.b(new q1(s1Var, oVar));
            }
            this.h = null;
        }
    }
}
