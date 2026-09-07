package com.five_corp.ad.internal.movie.partialcache;

import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.nio.BufferUnderflowException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes12.dex */
public abstract class B {
    public static final byte[] e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1459a;
    public byte[] b = new byte[4];
    public final ArrayList c = new ArrayList();
    public int d = 0;

    static {
        HashMap map = h1.f1479a;
        e = CommonUrlParts.UUID.getBytes();
    }

    public final long a(com.five_corp.ad.internal.util.c cVar) {
        return (((long) this.d) + this.f1459a) - ((long) cVar.h);
    }

    public final void a(com.five_corp.ad.internal.util.c cVar, int i, com.five_corp.ad.internal.logger.a aVar) throws C3036w0 {
        while (cVar.h < i) {
            HashMap map = h1.f1479a;
            try {
                int iB = cVar.b();
                long jC = iB < 0 ? ((long) iB) + 4294967296L : iB;
                byte[] bArr = new byte[4];
                int i2 = 16;
                byte[] bArr2 = new byte[16];
                cVar.a(bArr);
                if (jC == 1) {
                    jC = cVar.c();
                } else {
                    if (jC == 0) {
                        throw new RuntimeException("Box size = 0 is defined in ISO specification, but we do not support");
                    }
                    i2 = 8;
                }
                long j = jC;
                if (Arrays.equals(bArr, e)) {
                    cVar.a(bArr2);
                    i2 += 16;
                }
                B bA = h1.a(cVar, j, bArr, bArr2, i2, aVar);
                if (bA != null) {
                    this.c.add(bA);
                }
            } catch (BufferUnderflowException e2) {
                throw new C3036w0("buffer is insufficient", e2);
            }
        }
    }

    public void a(com.five_corp.ad.internal.util.c cVar, com.five_corp.ad.internal.logger.a aVar) {
        if (!Arrays.equals(this.b, (byte[]) h1.f1479a.get(getClass()))) {
            throw new C3036w0("Box type mismatch");
        }
    }
}
