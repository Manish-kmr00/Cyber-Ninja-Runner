package com.yandex.mobile.ads.impl;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes11.dex */
final class ct1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final cd f8639a;
    private final int b;
    private final wf1 c;
    private a d;
    private a e;
    private a f;
    private long g;

    private static final class a implements cd.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f8640a;
        public long b;
        public bd c;
        public a d;

        public a(int i, long j) {
            a(i, j);
        }

        @Override // com.yandex.mobile.ads.impl.cd.a
        public final bd a() {
            bd bdVar = this.c;
            bdVar.getClass();
            return bdVar;
        }

        public final void a(int i, long j) {
            if (this.c == null) {
                this.f8640a = j;
                this.b = j + ((long) i);
                return;
            }
            throw new IllegalStateException();
        }

        @Override // com.yandex.mobile.ads.impl.cd.a
        public final cd.a next() {
            a aVar = this.d;
            if (aVar == null || aVar.c == null) {
                return null;
            }
            return aVar;
        }
    }

    public ct1(cd cdVar) {
        this.f8639a = cdVar;
        int iB = ((az) cdVar).b();
        this.b = iB;
        this.c = new wf1(32);
        a aVar = new a(iB, 0L);
        this.d = aVar;
        this.e = aVar;
        this.f = aVar;
    }

    public final void c() {
        this.e = this.d;
    }

    public final void b(oy oyVar, dt1.a aVar) {
        this.e = a(this.e, oyVar, aVar, this.c);
    }

    public final void a(long j) {
        a aVar;
        if (j == -1) {
            return;
        }
        while (true) {
            aVar = this.d;
            if (j < aVar.b) {
                break;
            }
            ((az) this.f8639a).a(aVar.c);
            a aVar2 = this.d;
            aVar2.c = null;
            a aVar3 = aVar2.d;
            aVar2.d = null;
            this.d = aVar3;
        }
        if (this.e.f8640a < aVar.f8640a) {
            this.e = aVar;
        }
    }

    public final void b() {
        a aVar = this.d;
        if (aVar.c != null) {
            ((az) this.f8639a).a(aVar);
            aVar.c = null;
            aVar.d = null;
        }
        this.d.a(this.b, 0L);
        a aVar2 = this.d;
        this.e = aVar2;
        this.f = aVar2;
        this.g = 0L;
        ((az) this.f8639a).e();
    }

    public final long a() {
        return this.g;
    }

    public final void a(oy oyVar, dt1.a aVar) {
        a(this.e, oyVar, aVar, this.c);
    }

    private static a a(a aVar, long j, ByteBuffer byteBuffer, int i) {
        while (j >= aVar.b) {
            aVar = aVar.d;
        }
        while (i > 0) {
            int iMin = Math.min(i, (int) (aVar.b - j));
            bd bdVar = aVar.c;
            byteBuffer.put(bdVar.f8494a, ((int) (j - aVar.f8640a)) + bdVar.b, iMin);
            i -= iMin;
            j += (long) iMin;
            if (j == aVar.b) {
                aVar = aVar.d;
            }
        }
        return aVar;
    }

    private static a a(a aVar, long j, byte[] bArr, int i) {
        while (j >= aVar.b) {
            aVar = aVar.d;
        }
        int i2 = i;
        while (i2 > 0) {
            int iMin = Math.min(i2, (int) (aVar.b - j));
            bd bdVar = aVar.c;
            System.arraycopy(bdVar.f8494a, ((int) (j - aVar.f8640a)) + bdVar.b, bArr, i - i2, iMin);
            i2 -= iMin;
            j += (long) iMin;
            if (j == aVar.b) {
                aVar = aVar.d;
            }
        }
        return aVar;
    }

    private static a a(a aVar, oy oyVar, dt1.a aVar2, wf1 wf1Var) {
        a aVarA;
        if (oyVar.i()) {
            long j = aVar2.b;
            int iZ = 1;
            wf1Var.c(1);
            a aVarA2 = a(aVar, j, wf1Var.c(), 1);
            long j2 = j + 1;
            byte b = wf1Var.c()[0];
            boolean z = (b & 128) != 0;
            int i = b & 127;
            dv dvVar = oyVar.c;
            byte[] bArr = dvVar.f8735a;
            if (bArr == null) {
                dvVar.f8735a = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            aVarA = a(aVarA2, j2, dvVar.f8735a, i);
            long j3 = j2 + ((long) i);
            if (z) {
                wf1Var.c(2);
                aVarA = a(aVarA, j3, wf1Var.c(), 2);
                j3 += 2;
                iZ = wf1Var.z();
            }
            int i2 = iZ;
            int[] iArr = dvVar.d;
            if (iArr == null || iArr.length < i2) {
                iArr = new int[i2];
            }
            int[] iArr2 = iArr;
            int[] iArr3 = dvVar.e;
            if (iArr3 == null || iArr3.length < i2) {
                iArr3 = new int[i2];
            }
            int[] iArr4 = iArr3;
            if (z) {
                int i3 = i2 * 6;
                wf1Var.c(i3);
                aVarA = a(aVarA, j3, wf1Var.c(), i3);
                j3 += (long) i3;
                wf1Var.e(0);
                for (int i4 = 0; i4 < i2; i4++) {
                    iArr2[i4] = wf1Var.z();
                    iArr4[i4] = wf1Var.x();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = aVar2.f8732a - ((int) (j3 - aVar2.b));
            }
            t52.a aVar3 = aVar2.c;
            int i5 = x82.f10629a;
            dvVar.a(i2, iArr2, iArr4, aVar3.b, dvVar.f8735a, aVar3.f10270a, aVar3.c, aVar3.d);
            long j4 = aVar2.b;
            int i6 = (int) (j3 - j4);
            aVar2.b = j4 + ((long) i6);
            aVar2.f8732a -= i6;
        } else {
            aVarA = aVar;
        }
        if (oyVar.d()) {
            wf1Var.c(4);
            a aVarA3 = a(aVarA, aVar2.b, wf1Var.c(), 4);
            int iX = wf1Var.x();
            aVar2.b += 4;
            aVar2.f8732a -= 4;
            oyVar.e(iX);
            a aVarA4 = a(aVarA3, aVar2.b, oyVar.d, iX);
            aVar2.b += (long) iX;
            int i7 = aVar2.f8732a - iX;
            aVar2.f8732a = i7;
            ByteBuffer byteBuffer = oyVar.g;
            if (byteBuffer != null && byteBuffer.capacity() >= i7) {
                oyVar.g.clear();
            } else {
                oyVar.g = ByteBuffer.allocate(i7);
            }
            return a(aVarA4, aVar2.b, oyVar.g, aVar2.f8732a);
        }
        oyVar.e(aVar2.f8732a);
        return a(aVarA, aVar2.b, oyVar.d, aVar2.f8732a);
    }

    public final int a(nv nvVar, int i, boolean z) throws IOException {
        a aVar = this.f;
        if (aVar.c == null) {
            bd bdVarA = ((az) this.f8639a).a();
            a aVar2 = new a(this.b, this.f.b);
            aVar.c = bdVarA;
            aVar.d = aVar2;
        }
        int iMin = Math.min(i, (int) (this.f.b - this.g));
        a aVar3 = this.f;
        bd bdVar = aVar3.c;
        int i2 = nvVar.read(bdVar.f8494a, ((int) (this.g - aVar3.f8640a)) + bdVar.b, iMin);
        if (i2 == -1) {
            if (z) {
                return -1;
            }
            throw new EOFException();
        }
        long j = this.g + ((long) i2);
        this.g = j;
        a aVar4 = this.f;
        if (j == aVar4.b) {
            this.f = aVar4.d;
        }
        return i2;
    }

    public final void a(int i, wf1 wf1Var) {
        while (i > 0) {
            a aVar = this.f;
            if (aVar.c == null) {
                bd bdVarA = ((az) this.f8639a).a();
                a aVar2 = new a(this.b, this.f.b);
                aVar.c = bdVarA;
                aVar.d = aVar2;
            }
            int iMin = Math.min(i, (int) (this.f.b - this.g));
            a aVar3 = this.f;
            bd bdVar = aVar3.c;
            wf1Var.a(bdVar.f8494a, ((int) (this.g - aVar3.f8640a)) + bdVar.b, iMin);
            i -= iMin;
            long j = this.g + ((long) iMin);
            this.g = j;
            a aVar4 = this.f;
            if (j == aVar4.b) {
                this.f = aVar4.d;
            }
        }
    }
}
