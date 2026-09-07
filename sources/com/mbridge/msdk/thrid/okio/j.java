package com.mbridge.msdk.thrid.okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: GzipSource.java */
/* JADX INFO: loaded from: classes11.dex */
public final class j implements s {
    private final e b;
    private final Inflater c;
    private final k d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5595a = 0;
    private final CRC32 e = new CRC32();

    public j(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        Inflater inflater = new Inflater(true);
        this.c = inflater;
        e eVarA = l.a(sVar);
        this.b = eVarA;
        this.d = new k(eVarA, inflater);
    }

    private void a(c cVar, long j, long j2) {
        o oVar = cVar.f5590a;
        while (true) {
            long j3 = oVar.c - oVar.b;
            if (j < j3) {
                break;
            }
            j -= j3;
            oVar = oVar.f;
        }
        while (j2 > 0) {
            int i = (int) (((long) oVar.b) + j);
            int iMin = (int) Math.min(oVar.c - i, j2);
            this.e.update(oVar.f5603a, i, iMin);
            j2 -= (long) iMin;
            oVar = oVar.f;
            j = 0;
        }
    }

    private void d() throws IOException {
        this.b.e(10L);
        byte bF = this.b.a().f(3L);
        boolean z = ((bF >> 1) & 1) == 1;
        if (z) {
            a(this.b.a(), 0L, 10L);
        }
        a("ID1ID2", 8075, this.b.readShort());
        this.b.skip(8L);
        if (((bF >> 2) & 1) == 1) {
            this.b.e(2L);
            if (z) {
                a(this.b.a(), 0L, 2L);
            }
            long jG = this.b.a().g();
            this.b.e(jG);
            if (z) {
                a(this.b.a(), 0L, jG);
            }
            this.b.skip(jG);
        }
        if (((bF >> 3) & 1) == 1) {
            long jA = this.b.a((byte) 0);
            if (jA == -1) {
                throw new EOFException();
            }
            if (z) {
                a(this.b.a(), 0L, jA + 1);
            }
            this.b.skip(jA + 1);
        }
        if (((bF >> 4) & 1) == 1) {
            long jA2 = this.b.a((byte) 0);
            if (jA2 == -1) {
                throw new EOFException();
            }
            if (z) {
                a(this.b.a(), 0L, jA2 + 1);
            }
            this.b.skip(jA2 + 1);
        }
        if (z) {
            a("FHCRC", this.b.g(), (short) this.e.getValue());
            this.e.reset();
        }
    }

    private void h() throws IOException {
        a("CRC", this.b.e(), (int) this.e.getValue());
        a("ISIZE", this.b.e(), (int) this.c.getBytesWritten());
    }

    @Override // com.mbridge.msdk.thrid.okio.s
    public long b(c cVar, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (j == 0) {
            return 0L;
        }
        if (this.f5595a == 0) {
            d();
            this.f5595a = 1;
        }
        if (this.f5595a == 1) {
            long j2 = cVar.b;
            long jB = this.d.b(cVar, j);
            if (jB != -1) {
                a(cVar, j2, jB);
                return jB;
            }
            this.f5595a = 2;
        }
        if (this.f5595a == 2) {
            h();
            this.f5595a = 3;
            if (!this.b.f()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // com.mbridge.msdk.thrid.okio.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.d.close();
    }

    private void a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.s
    public t b() {
        return this.b.b();
    }
}
