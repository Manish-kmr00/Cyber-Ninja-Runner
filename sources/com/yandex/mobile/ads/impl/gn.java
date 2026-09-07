package com.yandex.mobile.ads.impl;

import java.io.IOException;
import java.io.InterruptedIOException;

/* JADX INFO: loaded from: classes3.dex */
public final class gn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final vm f9019a;
    private final rm b;
    private final uv c;
    private final String d;
    private final byte[] e = new byte[131072];
    private final a f;
    private long g;
    private long h;
    private long i;
    private volatile boolean j;

    public interface a {
        void a(long j, long j2, long j3);
    }

    public gn(vm vmVar, uv uvVar, a aVar) {
        this.f9019a = vmVar;
        this.b = vmVar.f();
        this.c = uvVar;
        this.f = aVar;
        this.d = vmVar.g().a(uvVar);
        this.g = uvVar.f;
    }

    public final void a() throws IOException {
        long jA;
        long j;
        if (this.j) {
            throw new InterruptedIOException();
        }
        rm rmVar = this.b;
        String str = this.d;
        uv uvVar = this.c;
        this.i = rmVar.b(str, uvVar.f, uvVar.g);
        uv uvVar2 = this.c;
        long j2 = uvVar2.g;
        long j3 = -1;
        if (j2 != -1) {
            this.h = uvVar2.f + j2;
        } else {
            long jB = this.b.b(this.d).b();
            if (jB == -1) {
                jB = -1;
            }
            this.h = jB;
        }
        a aVar = this.f;
        if (aVar != null) {
            long j4 = this.h;
            aVar.a(j4 == -1 ? -1L : j4 - this.c.f, this.i, 0L);
        }
        while (true) {
            long j5 = this.h;
            if (j5 != j3 && this.g >= j5) {
                return;
            }
            if (this.j) {
                throw new InterruptedIOException();
            }
            long j6 = this.h;
            long jD = this.b.d(this.d, this.g, j6 == j3 ? Long.MAX_VALUE : j6 - this.g);
            if (jD > 0) {
                this.g += jD;
            } else {
                long j7 = -jD;
                if (j7 == Long.MAX_VALUE) {
                    j7 = j3;
                }
                long j8 = this.g;
                boolean z = true;
                int i = 0;
                boolean z2 = j8 + j7 == this.h || j7 == j3;
                if (j7 != j3) {
                    try {
                        jA = this.f9019a.a(this.c.a().b(j8).a(j7).a());
                    } catch (IOException unused) {
                        tv.a(this.f9019a);
                        jA = j3;
                        z = false;
                    }
                } else {
                    jA = j3;
                    z = false;
                }
                if (!z) {
                    if (this.j) {
                        throw new InterruptedIOException();
                    }
                    try {
                        jA = this.f9019a.a(this.c.a().b(j8).a(j3).a());
                    } catch (IOException e) {
                        tv.a(this.f9019a);
                        throw e;
                    }
                }
                if (z2 && jA != j3) {
                    long j9 = jA + j8;
                    try {
                        if (this.h != j9) {
                            this.h = j9;
                            a aVar2 = this.f;
                            if (aVar2 != null) {
                                aVar2.a(j9 == j3 ? j3 : j9 - this.c.f, this.i, 0L);
                            }
                        }
                    } catch (IOException e2) {
                        tv.a(this.f9019a);
                        throw e2;
                    }
                }
                int i2 = 0;
                int i3 = 0;
                while (i2 != -1) {
                    if (this.j) {
                        throw new InterruptedIOException();
                    }
                    vm vmVar = this.f9019a;
                    byte[] bArr = this.e;
                    i2 = vmVar.read(bArr, i, bArr.length);
                    if (i2 != -1) {
                        long j10 = i2;
                        long j11 = this.i + j10;
                        this.i = j11;
                        a aVar3 = this.f;
                        if (aVar3 != null) {
                            long j12 = this.h;
                            if (j12 != j3) {
                                j3 = j12 - this.c.f;
                            }
                            aVar3.a(j3, j11, j10);
                        }
                        i3 += i2;
                        j3 = -1;
                        i = 0;
                    }
                }
                if (z2) {
                    long j13 = ((long) i3) + j8;
                    if (this.h != j13) {
                        this.h = j13;
                        a aVar4 = this.f;
                        if (aVar4 != null) {
                            j = -1;
                            aVar4.a(j13 == -1 ? -1L : j13 - this.c.f, this.i, 0L);
                        }
                    }
                    j = -1;
                } else {
                    j = -1;
                }
                this.f9019a.close();
                this.g = j8 + ((long) i3);
                j3 = j;
            }
        }
    }

    public final void b() {
        this.j = true;
    }
}
