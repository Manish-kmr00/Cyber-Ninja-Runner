package com.fyber.inneractive.sdk.player.exoplayer2.trackselection;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.fyber.inneractive.sdk.player.exoplayer2.o;
import com.fyber.inneractive.sdk.player.exoplayer2.source.y;
import com.fyber.inneractive.sdk.player.exoplayer2.source.z;
import com.fyber.inneractive.sdk.player.exoplayer2.t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public abstract class g extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray f2142a = new SparseArray();
    public final SparseBooleanArray b = new SparseBooleanArray();

    /* JADX WARN: Code duplicated, block: B:100:0x01c9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:101:0x01cb A[PHI: r26
  0x01cb: PHI (r26v4 int) = (r26v2 int), (r26v7 int) binds: [B:100:0x01c9, B:93:0x01ba] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:102:0x01cd A[PHI: r10 r26
  0x01cd: PHI (r10v31 int) = (r10v30 int), (r10v32 int) binds: [B:100:0x01c9, B:93:0x01ba] A[DONT_GENERATE, DONT_INLINE]
  0x01cd: PHI (r26v6 int) = (r26v2 int), (r26v7 int) binds: [B:100:0x01c9, B:93:0x01ba] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:103:0x01cf A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:104:0x01d1 A[PHI: r26
  0x01d1: PHI (r26v3 int) = (r26v2 int), (r26v7 int) binds: [B:103:0x01cf, B:95:0x01bd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:105:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:113:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:115:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:191:0x0320  */
    /* JADX WARN: Code duplicated, block: B:284:0x01fa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x0194  */
    /* JADX WARN: Code duplicated, block: B:81:0x0196  */
    /* JADX WARN: Code duplicated, block: B:84:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:86:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:87:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:89:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:91:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:93:0x01ba A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:95:0x01bd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:97:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:98:0x01c2  */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.trackselection.i
    public final j a(com.fyber.inneractive.sdk.player.exoplayer2.a[] aVarArr, z zVar) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        int i;
        boolean z;
        int[][] iArr;
        int i2;
        boolean z2;
        int[][] iArr2;
        int i3;
        y yVar;
        c cVar;
        int[] iArr3;
        y yVar2;
        ArrayList arrayList;
        boolean z3;
        int i4;
        boolean zA;
        boolean z4;
        int i5;
        int i6;
        int i7;
        int i8;
        int iB;
        int i9;
        int i10;
        int[] iArr4;
        int[] iArr5 = new int[aVarArr.length + 1];
        int length = aVarArr.length + 1;
        y[][] yVarArr = new y[length][];
        int[][][] iArr6 = new int[aVarArr.length + 1][][];
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = zVar.f2137a;
            yVarArr[i11] = new y[i12];
            iArr6[i11] = new int[i12][];
        }
        int length2 = aVarArr.length;
        int[] iArr7 = new int[length2];
        for (int i13 = 0; i13 < length2; i13++) {
            aVarArr[i13].getClass();
            iArr7[i13] = 4;
        }
        for (int i14 = 0; i14 < zVar.f2137a; i14++) {
            y yVar3 = zVar.b[i14];
            int length3 = aVarArr.length;
            int i15 = 0;
            for (int i16 = 0; i16 < aVarArr.length; i16++) {
                com.fyber.inneractive.sdk.player.exoplayer2.a aVar = aVarArr[i16];
                for (int i17 = 0; i17 < yVar3.f2136a; i17++) {
                    o oVar = yVar3.b[i17];
                    com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c cVar2 = (com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c) aVar;
                    cVar2.getClass();
                    try {
                        int iB2 = cVar2.b(cVar2.h, oVar) & 3;
                        if (iB2 > i15) {
                            if (iB2 == 3) {
                                length3 = i16;
                                break;
                            }
                            i15 = iB2;
                            length3 = i16;
                        }
                    } catch (com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.f e) {
                        throw new com.fyber.inneractive.sdk.player.exoplayer2.d(e);
                    }
                }
            }
            if (length3 == aVarArr.length) {
                iArr4 = new int[yVar3.f2136a];
            } else {
                com.fyber.inneractive.sdk.player.exoplayer2.a aVar2 = aVarArr[length3];
                int[] iArr8 = new int[yVar3.f2136a];
                for (int i18 = 0; i18 < yVar3.f2136a; i18++) {
                    o oVar2 = yVar3.b[i18];
                    com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c cVar3 = (com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c) aVar2;
                    cVar3.getClass();
                    try {
                        iArr8[i18] = cVar3.b(cVar3.h, oVar2);
                    } catch (com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.f e2) {
                        throw new com.fyber.inneractive.sdk.player.exoplayer2.d(e2);
                    }
                }
                iArr4 = iArr8;
            }
            int i19 = iArr5[length3];
            yVarArr[length3][i19] = yVar3;
            iArr6[length3][i19] = iArr4;
            iArr5[length3] = i19 + 1;
        }
        z[] zVarArr = new z[aVarArr.length];
        int[] iArr9 = new int[aVarArr.length];
        for (int i20 = 0; i20 < aVarArr.length; i20++) {
            int i21 = iArr5[i20];
            zVarArr[i20] = new z((y[]) Arrays.copyOf(yVarArr[i20], i21));
            iArr6[i20] = (int[][]) Arrays.copyOf(iArr6[i20], i21);
            iArr9[i20] = aVarArr[i20].f1973a;
        }
        new z((y[]) Arrays.copyOf(yVarArr[aVarArr.length], iArr5[aVarArr.length]));
        int length4 = aVarArr.length;
        b[] bVarArr = new b[length4];
        c cVar4 = (c) ((d) this).c.get();
        int i22 = 0;
        boolean z5 = false;
        while (i22 < length4) {
            if (2 == aVarArr[i22].f1973a) {
                if (z5) {
                    cVar = cVar4;
                } else {
                    z zVar2 = zVarArr[i22];
                    int[][] iArr10 = iArr6[i22];
                    cVar4.getClass();
                    y yVar4 = null;
                    int i23 = 0;
                    int i24 = 0;
                    int i25 = 0;
                    int i26 = -1;
                    int i27 = -1;
                    while (i23 < zVar2.f2137a) {
                        y yVar5 = zVar2.b[i23];
                        z zVar3 = zVar2;
                        ArrayList arrayList2 = new ArrayList(yVar5.f2136a);
                        for (int i28 = 0; i28 < yVar5.f2136a; i28++) {
                            arrayList2.add(Integer.valueOf(i28));
                        }
                        int[] iArr11 = iArr10[i23];
                        int i29 = 0;
                        int i30 = i25;
                        y yVar6 = yVar4;
                        int i31 = i30;
                        int i32 = i26;
                        int[][] iArr12 = iArr10;
                        int iB3 = i32;
                        int i33 = i27;
                        int i34 = i24;
                        int i35 = i33;
                        while (i29 < yVar5.f2136a) {
                            c cVar5 = cVar4;
                            if (d.a(iArr11[i29], true)) {
                                o oVar3 = yVar5.b[i29];
                                if (arrayList2.contains(Integer.valueOf(i29))) {
                                    int i36 = oVar3.j;
                                    yVar2 = yVar5;
                                    arrayList = arrayList2;
                                    z3 = (i36 == -1 || i36 <= Integer.MAX_VALUE) && ((i9 = oVar3.k) == -1 || i9 <= Integer.MAX_VALUE) && ((i10 = oVar3.b) == -1 || i10 <= Integer.MAX_VALUE);
                                    if (z3) {
                                        i4 = 2;
                                    } else {
                                        i4 = 1;
                                    }
                                    iArr3 = iArr11;
                                    zA = d.a(iArr11[i29], false);
                                    if (zA) {
                                        i4 += 1000;
                                    }
                                    if (i4 > i31) {
                                        z4 = true;
                                    } else {
                                        z4 = false;
                                    }
                                    if (i4 == i31) {
                                        if (oVar3.b() != iB3) {
                                            iB = oVar3.b();
                                            i5 = i4;
                                            i6 = -1;
                                            if (iB == -1) {
                                                if (iB3 == -1) {
                                                    i8 = 0;
                                                } else {
                                                    i8 = i6;
                                                }
                                            } else if (iB3 == -1) {
                                                i8 = 1;
                                            } else {
                                                i8 = iB - iB3;
                                            }
                                        } else {
                                            i5 = i4;
                                            i6 = -1;
                                            i7 = oVar3.b;
                                            if (i7 == -1) {
                                                if (i35 == -1) {
                                                    i8 = 0;
                                                } else {
                                                    i8 = i6;
                                                }
                                            } else if (i35 == -1) {
                                                i8 = 1;
                                            } else {
                                                i8 = i7 - i35;
                                            }
                                        }
                                        z4 = zA || !z3 ? i8 < 0 : i8 > 0;
                                    } else {
                                        i5 = i4;
                                    }
                                    if (z4) {
                                        int i37 = oVar3.b;
                                        iB3 = oVar3.b();
                                        i35 = i37;
                                        i34 = i29;
                                        yVar6 = yVar2;
                                        i31 = i5;
                                    }
                                } else {
                                    yVar2 = yVar5;
                                    arrayList = arrayList2;
                                }
                                if (z3) {
                                    i4 = 2;
                                } else {
                                    i4 = 1;
                                }
                                iArr3 = iArr11;
                                zA = d.a(iArr11[i29], false);
                                if (zA) {
                                    i4 += 1000;
                                }
                                if (i4 > i31) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                if (i4 == i31) {
                                    if (oVar3.b() != iB3) {
                                        iB = oVar3.b();
                                        i5 = i4;
                                        i6 = -1;
                                        if (iB == -1) {
                                            if (iB3 == -1) {
                                                i8 = 0;
                                            } else {
                                                i8 = i6;
                                            }
                                        } else if (iB3 == -1) {
                                            i8 = 1;
                                        } else {
                                            i8 = iB - iB3;
                                        }
                                    } else {
                                        i5 = i4;
                                        i6 = -1;
                                        i7 = oVar3.b;
                                        if (i7 == -1) {
                                            if (i35 == -1) {
                                                i8 = 0;
                                            } else {
                                                i8 = i6;
                                            }
                                        } else if (i35 == -1) {
                                            i8 = 1;
                                        } else {
                                            i8 = i7 - i35;
                                        }
                                    }
                                    if (zA) {
                                    }
                                } else {
                                    i5 = i4;
                                }
                                if (z4) {
                                    int i38 = oVar3.b;
                                    iB3 = oVar3.b();
                                    i35 = i38;
                                    i34 = i29;
                                    yVar6 = yVar2;
                                    i31 = i5;
                                }
                            } else {
                                iArr3 = iArr11;
                                yVar2 = yVar5;
                                arrayList = arrayList2;
                            }
                            i29++;
                            cVar4 = cVar5;
                            yVar5 = yVar2;
                            arrayList2 = arrayList;
                            iArr11 = iArr3;
                        }
                        i23++;
                        zVar2 = zVar3;
                        y yVar7 = yVar6;
                        i25 = i31;
                        yVar4 = yVar7;
                        i26 = iB3;
                        iArr10 = iArr12;
                        int i39 = i34;
                        i27 = i35;
                        i24 = i39;
                    }
                    cVar = cVar4;
                    e eVar = yVar4 == null ? null : new e(yVar4, i24);
                    bVarArr[i22] = eVar;
                    z5 = eVar != null;
                }
                int i40 = zVarArr[i22].f2137a;
            } else {
                cVar = cVar4;
            }
            i22++;
            cVar4 = cVar;
        }
        c cVar6 = cVar4;
        boolean z6 = false;
        int i41 = 0;
        boolean z7 = false;
        while (i41 < length4) {
            int i42 = aVarArr[i41].f1973a;
            if (i42 != 1) {
                if (i42 == 2) {
                    i = length4;
                } else if (i42 != 3) {
                    z zVar4 = zVarArr[i41];
                    int[][] iArr13 = iArr6[i41];
                    cVar6.getClass();
                    int i43 = 0;
                    int i44 = 0;
                    int i45 = 0;
                    y yVar8 = null;
                    while (i43 < zVar4.f2137a) {
                        y yVar9 = zVar4.b[i43];
                        int[] iArr14 = iArr13[i43];
                        int i46 = length4;
                        int i47 = 0;
                        while (i47 < yVar9.f2136a) {
                            z zVar5 = zVar4;
                            if (d.a(iArr14[i47], true)) {
                                int i48 = (yVar9.b[i47].x & 1) != 0 ? 2 : 1;
                                yVar = yVar9;
                                if (d.a(iArr14[i47], false)) {
                                    i48 += 1000;
                                }
                                if (i48 > i45) {
                                    i45 = i48;
                                    i44 = i47;
                                    yVar8 = yVar;
                                }
                            } else {
                                yVar = yVar9;
                            }
                            i47++;
                            zVar4 = zVar5;
                            yVar9 = yVar;
                        }
                        i43++;
                        length4 = i46;
                    }
                    i = length4;
                    bVarArr[i41] = yVar8 == null ? null : new e(yVar8, i44);
                } else {
                    i = length4;
                    if (!z7) {
                        z zVar6 = zVarArr[i41];
                        int[][] iArr15 = iArr6[i41];
                        cVar6.getClass();
                        int i49 = 0;
                        int i50 = 0;
                        int i51 = 0;
                        y yVar10 = null;
                        while (i49 < zVar6.f2137a) {
                            y yVar11 = zVar6.b[i49];
                            int[] iArr16 = iArr15[i49];
                            y yVar12 = yVar10;
                            int i52 = i51;
                            int i53 = i50;
                            int i54 = 0;
                            while (i54 < yVar11.f2136a) {
                                z zVar7 = zVar6;
                                if (d.a(iArr16[i54], true)) {
                                    int i55 = yVar11.b[i54].x;
                                    boolean z8 = (i55 & 1) != 0;
                                    boolean z9 = (i55 & 2) != 0;
                                    if (z8) {
                                        i3 = 3;
                                    } else if (z9) {
                                        i3 = 1;
                                    } else {
                                        iArr2 = iArr15;
                                    }
                                    iArr2 = iArr15;
                                    if (d.a(iArr16[i54], false)) {
                                        i3 += 1000;
                                    }
                                    if (i3 > i52) {
                                        i52 = i3;
                                        i53 = i54;
                                        yVar12 = yVar11;
                                    }
                                } else {
                                    iArr2 = iArr15;
                                }
                                i54++;
                                zVar6 = zVar7;
                                iArr15 = iArr2;
                            }
                            i49++;
                            i50 = i53;
                            i51 = i52;
                            yVar10 = yVar12;
                        }
                        e eVar2 = yVar10 == null ? null : new e(yVar10, i50);
                        bVarArr[i41] = eVar2;
                        z = eVar2 != null;
                    }
                }
                z = z7;
            } else {
                i = length4;
                if (z6) {
                    z = z7;
                } else {
                    z zVar8 = zVarArr[i41];
                    int[][] iArr17 = iArr6[i41];
                    cVar6.getClass();
                    int i56 = 0;
                    int i57 = 0;
                    int i58 = -1;
                    int i59 = -1;
                    while (i56 < zVar8.f2137a) {
                        y yVar13 = zVar8.b[i56];
                        int[] iArr18 = iArr17[i56];
                        int i60 = i59;
                        int i61 = i58;
                        int i62 = i57;
                        int i63 = 0;
                        while (i63 < yVar13.f2136a) {
                            boolean z10 = z7;
                            if (d.a(iArr18[i63], true)) {
                                o oVar4 = yVar13.b[i63];
                                iArr = iArr17;
                                int i64 = iArr18[i63];
                                if ((oVar4.x & 1) != 0) {
                                    z2 = false;
                                    i2 = 2;
                                } else {
                                    i2 = 1;
                                    z2 = false;
                                }
                                if (d.a(i64, z2)) {
                                    i2 += 1000;
                                }
                                if (i2 > i62) {
                                    i60 = i56;
                                    i61 = i63;
                                    i62 = i2;
                                }
                            } else {
                                iArr = iArr17;
                            }
                            i63++;
                            iArr17 = iArr;
                            z7 = z10;
                        }
                        i56++;
                        i57 = i62;
                        i58 = i61;
                        i59 = i60;
                        z7 = z7;
                    }
                    z = z7;
                    e eVar3 = i59 == -1 ? null : new e(zVar8.b[i59], i58);
                    bVarArr[i41] = eVar3;
                    z6 = eVar3 != null;
                }
            }
            i41++;
            z7 = z;
            length4 = i;
        }
        for (int i65 = 0; i65 < aVarArr.length; i65++) {
            if (this.b.get(i65)) {
                bVarArr[i65] = null;
            } else {
                z zVar9 = zVarArr[i65];
                Map map = (Map) this.f2142a.get(i65);
                if (map != null && map.containsKey(zVar9)) {
                    if (((Map) this.f2142a.get(i65)).get(zVar9) != null) {
                        throw new ClassCastException();
                    }
                    bVarArr[i65] = null;
                }
            }
        }
        f fVar = new f(zVarArr);
        t[] tVarArr = new t[aVarArr.length];
        for (int i66 = 0; i66 < aVarArr.length; i66++) {
            tVarArr[i66] = bVarArr[i66] != null ? t.b : null;
        }
        return new j(zVar, new h(bVarArr), fVar, tVarArr);
    }
}
