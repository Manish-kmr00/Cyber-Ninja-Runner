package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import android.util.Pair;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: classes8.dex */
public final class j implements h {
    public static final double[] n = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2081a;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.r b;
    public boolean c;
    public long d;
    public final boolean[] e = new boolean[4];
    public final i f = new i();
    public boolean g;
    public long h;
    public long i;
    public boolean j;
    public boolean k;
    public long l;
    public long m;

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a() {
        com.fyber.inneractive.sdk.player.exoplayer2.util.l.a(this.e);
        i iVar = this.f;
        iVar.f2080a = false;
        iVar.b = 0;
        iVar.c = 0;
        this.j = false;
        this.g = false;
        this.h = 0L;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void b() {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar, E e) {
        e.a();
        e.b();
        this.f2081a = e.e;
        e.b();
        this.b = jVar.a(e.d, 2);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(boolean z, long j) {
        boolean z2 = j != -9223372036854775807L;
        this.j = z2;
        if (z2) {
            this.i = j;
        }
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0105  */
    /* JADX WARN: Code duplicated, block: B:50:0x0109  */
    /* JADX WARN: Code duplicated, block: B:52:0x0119  */
    /* JADX WARN: Code duplicated, block: B:54:0x012a  */
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
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        boolean z;
        float f;
        int i;
        float f2;
        int i2;
        long j;
        double[] dArr;
        double d;
        int i3;
        int i4;
        int i5 = nVar.b;
        int i6 = nVar.c;
        byte[] bArr = nVar.f2184a;
        int i7 = i6 - i5;
        this.h += (long) i7;
        this.b.a(i7, nVar);
        int i8 = i5;
        while (true) {
            int iA = com.fyber.inneractive.sdk.player.exoplayer2.util.l.a(bArr, i5, i6, this.e);
            if (iA == i6) {
                break;
            }
            int i9 = iA + 3;
            int i10 = nVar.f2184a[i9] & 255;
            if (!this.c) {
                int i11 = iA - i8;
                if (i11 > 0) {
                    i iVar = this.f;
                    if (iVar.f2080a) {
                        byte[] bArr2 = iVar.d;
                        int length = bArr2.length;
                        int i12 = iVar.b + i11;
                        if (length < i12) {
                            iVar.d = Arrays.copyOf(bArr2, i12 * 2);
                        }
                        System.arraycopy(bArr, i8, iVar.d, iVar.b, i11);
                        iVar.b += i11;
                    }
                }
                int i13 = i11 < 0 ? -i11 : 0;
                i iVar2 = this.f;
                if (iVar2.f2080a) {
                    if (iVar2.c == 0 && i10 == 181) {
                        iVar2.c = iVar2.b;
                    } else {
                        int i14 = iVar2.b - i13;
                        iVar2.b = i14;
                        iVar2.f2080a = false;
                        String str = this.f2081a;
                        byte[] bArrCopyOf = Arrays.copyOf(iVar2.d, i14);
                        int i15 = bArrCopyOf[4] & 255;
                        byte b = bArrCopyOf[5];
                        int i16 = (i15 << 4) | ((b & 255) >> 4);
                        int i17 = ((b & Ascii.SI) << 8) | (bArrCopyOf[6] & 255);
                        int i18 = (bArrCopyOf[7] & 240) >> 4;
                        if (i18 == 2) {
                            f = i17 * 4;
                            i = i16 * 3;
                        } else if (i18 != 3) {
                            if (i18 != 4) {
                                f2 = 1.0f;
                            } else {
                                f = i17 * Sdk.SDKError.Reason.TPAT_ERROR_VALUE;
                                i = i16 * 100;
                            }
                            com.fyber.inneractive.sdk.player.exoplayer2.o oVarA = com.fyber.inneractive.sdk.player.exoplayer2.o.a(str, "video/mpeg2", -1, i16, i17, Collections.singletonList(bArrCopyOf), -1, f2, null, -1, null, null);
                            i2 = (bArrCopyOf[7] & Ascii.SI) - 1;
                            if (i2 >= 0) {
                                dArr = n;
                                if (i2 < 8) {
                                    d = dArr[i2];
                                    byte b2 = bArrCopyOf[iVar2.c + 9];
                                    i3 = (b2 & 96) >> 5;
                                    i4 = b2 & Ascii.US;
                                    if (i3 != i4) {
                                        d *= (((double) i3) + 1.0d) / ((double) (i4 + 1));
                                    }
                                    j = (long) (1000000.0d / d);
                                } else {
                                    j = 0;
                                }
                            } else {
                                j = 0;
                            }
                            Pair pairCreate = Pair.create(oVarA, Long.valueOf(j));
                            this.b.a((com.fyber.inneractive.sdk.player.exoplayer2.o) pairCreate.first);
                            this.d = ((Long) pairCreate.second).longValue();
                            this.c = true;
                        } else {
                            f = i17 * 16;
                            i = i16 * 9;
                        }
                        f2 = f / i;
                        com.fyber.inneractive.sdk.player.exoplayer2.o oVarA2 = com.fyber.inneractive.sdk.player.exoplayer2.o.a(str, "video/mpeg2", -1, i16, i17, Collections.singletonList(bArrCopyOf), -1, f2, null, -1, null, null);
                        i2 = (bArrCopyOf[7] & Ascii.SI) - 1;
                        if (i2 >= 0) {
                            dArr = n;
                            if (i2 < 8) {
                                d = dArr[i2];
                                byte b3 = bArrCopyOf[iVar2.c + 9];
                                i3 = (b3 & 96) >> 5;
                                i4 = b3 & Ascii.US;
                                if (i3 != i4) {
                                    d *= (((double) i3) + 1.0d) / ((double) (i4 + 1));
                                }
                                j = (long) (1000000.0d / d);
                            } else {
                                j = 0;
                            }
                        } else {
                            j = 0;
                        }
                        Pair pairCreate2 = Pair.create(oVarA2, Long.valueOf(j));
                        this.b.a((com.fyber.inneractive.sdk.player.exoplayer2.o) pairCreate2.first);
                        this.d = ((Long) pairCreate2.second).longValue();
                        this.c = true;
                    }
                } else if (i10 == 179) {
                    iVar2.f2080a = true;
                }
            }
            if (this.c && (i10 == 184 || i10 == 0)) {
                int i19 = i6 - iA;
                if (this.g) {
                    this.b.a(this.m, this.k ? 1 : 0, ((int) (this.h - this.l)) - i19, i19, null);
                    z = false;
                    this.k = false;
                } else {
                    z = false;
                }
                if (i10 == 184) {
                    this.g = z;
                    this.k = true;
                } else {
                    this.m = this.j ? this.i : this.m + this.d;
                    this.l = this.h - ((long) i19);
                    this.j = false;
                    this.g = true;
                }
            }
            i8 = iA;
            i5 = i9;
        }
        if (this.c) {
            return;
        }
        i iVar3 = this.f;
        if (iVar3.f2080a) {
            int i20 = i6 - i8;
            byte[] bArr3 = iVar3.d;
            int length2 = bArr3.length;
            int i21 = iVar3.b + i20;
            if (length2 < i21) {
                iVar3.d = Arrays.copyOf(bArr3, i21 * 2);
            }
            System.arraycopy(bArr, i8, iVar3.d, iVar3.b, i20);
            iVar3.b += i20;
        }
    }
}
