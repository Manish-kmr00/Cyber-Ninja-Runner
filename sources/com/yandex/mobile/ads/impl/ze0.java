package com.yandex.mobile.ads.impl;

import android.util.Pair;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: classes12.dex */
public final class ze0 implements y40 {
    private static final double[] q = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10812a;
    private t52 b;
    private final w82 c;
    private final wf1 d;
    private final z31 e;
    private final boolean[] f = new boolean[4];
    private final a g = new a();
    private long h;
    private boolean i;
    private boolean j;
    private long k;
    private long l;
    private long m;
    private long n;
    private boolean o;
    private boolean p;

    @Override // com.yandex.mobile.ads.impl.y40
    public final void b() {
    }

    ze0(w82 w82Var) {
        this.c = w82Var;
        if (w82Var != null) {
            this.e = new z31(178);
            this.d = new wf1();
        } else {
            this.e = null;
            this.d = null;
        }
        this.l = -9223372036854775807L;
        this.n = -9223372036854775807L;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:42:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:44:0x010a  */
    /* JADX WARN: Code duplicated, block: B:46:0x011b  */
    /* JADX WARN: Code duplicated, block: B:80:0x01d3  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.yandex.mobile.ads.impl.y40
    public final void a(wf1 wf1Var) {
        long j;
        boolean z;
        boolean z2;
        int i;
        float f;
        int i2;
        float f2;
        int i3;
        long j2;
        double[] dArr;
        double d;
        int i4;
        int i5;
        if (this.b != null) {
            int iD = wf1Var.d();
            int iE = wf1Var.e();
            byte[] bArrC = wf1Var.c();
            this.h += (long) wf1Var.a();
            this.b.a(wf1Var.a(), wf1Var);
            while (true) {
                int iA = a41.a(bArrC, iD, iE, this.f);
                if (iA == iE) {
                    break;
                }
                int i6 = iA + 3;
                int i7 = wf1Var.c()[i6] & 255;
                int i8 = iA - iD;
                if (!this.j) {
                    if (i8 > 0) {
                        this.g.a(bArrC, iD, iA);
                    }
                    int i9 = i8 < 0 ? -i8 : 0;
                    a aVar = this.g;
                    if (aVar.f10813a) {
                        int i10 = aVar.b - i9;
                        aVar.b = i10;
                        if (aVar.c == 0 && i7 == 181) {
                            aVar.c = i10;
                        } else {
                            aVar.f10813a = false;
                            String str = this.f10812a;
                            str.getClass();
                            byte[] bArrCopyOf = Arrays.copyOf(aVar.d, aVar.b);
                            int i11 = bArrCopyOf[4] & 255;
                            byte b = bArrCopyOf[5];
                            int i12 = (i11 << 4) | ((b & 255) >> 4);
                            int i13 = (bArrCopyOf[6] & 255) | ((b & Ascii.SI) << 8);
                            int i14 = (bArrCopyOf[7] & 240) >> 4;
                            if (i14 == 2) {
                                f = i13 * 4;
                                i2 = i12 * 3;
                            } else if (i14 != 3) {
                                if (i14 != 4) {
                                    f2 = 1.0f;
                                } else {
                                    f = i13 * Sdk.SDKError.Reason.TPAT_ERROR_VALUE;
                                    i2 = i12 * 100;
                                }
                                gc0 gc0VarA = new gc0.a().b(str).e("video/mpeg2").o(i12).f(i13).b(f2).a(Collections.singletonList(bArrCopyOf)).a();
                                i3 = (bArrCopyOf[7] & Ascii.SI) - 1;
                                if (i3 >= 0) {
                                    dArr = q;
                                    if (i3 < 8) {
                                        d = dArr[i3];
                                        byte b2 = bArrCopyOf[aVar.c + 9];
                                        i4 = (b2 & 96) >> 5;
                                        i5 = b2 & Ascii.US;
                                        if (i4 != i5) {
                                            d *= (((double) i4) + 1.0d) / ((double) (i5 + 1));
                                        }
                                        j2 = (long) (1000000.0d / d);
                                    } else {
                                        j2 = 0;
                                    }
                                } else {
                                    j2 = 0;
                                }
                                Pair pairCreate = Pair.create(gc0VarA, Long.valueOf(j2));
                                this.b.a((gc0) pairCreate.first);
                                this.k = ((Long) pairCreate.second).longValue();
                                this.j = true;
                            } else {
                                f = i13 * 16;
                                i2 = i12 * 9;
                            }
                            f2 = f / i2;
                            gc0 gc0VarA2 = new gc0.a().b(str).e("video/mpeg2").o(i12).f(i13).b(f2).a(Collections.singletonList(bArrCopyOf)).a();
                            i3 = (bArrCopyOf[7] & Ascii.SI) - 1;
                            if (i3 >= 0) {
                                dArr = q;
                                if (i3 < 8) {
                                    d = dArr[i3];
                                    byte b3 = bArrCopyOf[aVar.c + 9];
                                    i4 = (b3 & 96) >> 5;
                                    i5 = b3 & Ascii.US;
                                    if (i4 != i5) {
                                        d *= (((double) i4) + 1.0d) / ((double) (i5 + 1));
                                    }
                                    j2 = (long) (1000000.0d / d);
                                } else {
                                    j2 = 0;
                                }
                            } else {
                                j2 = 0;
                            }
                            Pair pairCreate2 = Pair.create(gc0VarA2, Long.valueOf(j2));
                            this.b.a((gc0) pairCreate2.first);
                            this.k = ((Long) pairCreate2.second).longValue();
                            this.j = true;
                        }
                    } else if (i7 == 179) {
                        aVar.f10813a = true;
                    }
                    aVar.a(a.e, 0, 3);
                }
                z31 z31Var = this.e;
                if (z31Var != null) {
                    if (i8 > 0) {
                        z31Var.a(bArrC, iD, iA);
                        i = 0;
                    } else {
                        i = -i8;
                    }
                    if (this.e.a(i)) {
                        z31 z31Var2 = this.e;
                        int iA2 = a41.a(z31Var2.e, z31Var2.d);
                        wf1 wf1Var2 = this.d;
                        int i15 = x82.f10629a;
                        wf1Var2.a(iA2, this.e.d);
                        this.c.a(this.n, this.d);
                    }
                    if (i7 == 178 && wf1Var.c()[iA + 2] == 1) {
                        this.e.b(i7);
                    }
                }
                if (i7 == 0 || i7 == 179) {
                    int i16 = iE - iA;
                    if (this.p && this.j) {
                        long j3 = this.n;
                        if (j3 != -9223372036854775807L) {
                            j = -9223372036854775807L;
                            this.b.a(j3, this.o ? 1 : 0, ((int) (this.h - this.m)) - i16, i16, null);
                        } else {
                            j = -9223372036854775807L;
                        }
                    } else {
                        j = -9223372036854775807L;
                    }
                    if (!this.i || this.p) {
                        this.m = this.h - ((long) i16);
                        long j4 = this.l;
                        if (j4 == j) {
                            long j5 = this.n;
                            j4 = j5 != j ? j5 + this.k : j;
                        }
                        this.n = j4;
                        z = false;
                        this.o = false;
                        this.l = j;
                        z2 = true;
                        this.i = true;
                    } else {
                        z = false;
                        z2 = true;
                    }
                    this.p = i7 == 0 ? z2 : z;
                } else {
                    if (i7 == 184) {
                        this.o = true;
                    }
                    iE = iE;
                    bArrC = bArrC;
                }
                iE = iE;
                bArrC = bArrC;
                iD = i6;
            }
            if (!this.j) {
                this.g.a(bArrC, iD, iE);
            }
            z31 z31Var3 = this.e;
            if (z31Var3 != null) {
                z31Var3.a(bArrC, iD, iE);
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    private static final class a {
        private static final byte[] e = {0, 0, 1};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f10813a;
        public int b;
        public int c;
        public byte[] d = new byte[128];

        public final void a(byte[] bArr, int i, int i2) {
            if (this.f10813a) {
                int i3 = i2 - i;
                byte[] bArr2 = this.d;
                int length = bArr2.length;
                int i4 = this.b + i3;
                if (length < i4) {
                    this.d = Arrays.copyOf(bArr2, i4 * 2);
                }
                System.arraycopy(bArr, i, this.d, this.b, i3);
                this.b += i3;
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a(y70 y70Var, i72.d dVar) {
        dVar.a();
        this.f10812a = dVar.b();
        this.b = y70Var.a(dVar.c(), 2);
        w82 w82Var = this.c;
        if (w82Var != null) {
            w82Var.a(y70Var, dVar);
        }
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a(int i, long j) {
        this.l = j;
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a() {
        a41.a(this.f);
        a aVar = this.g;
        aVar.f10813a = false;
        aVar.b = 0;
        aVar.c = 0;
        z31 z31Var = this.e;
        if (z31Var != null) {
            z31Var.b();
        }
        this.h = 0L;
        this.i = false;
        this.l = -9223372036854775807L;
        this.n = -9223372036854775807L;
    }
}
