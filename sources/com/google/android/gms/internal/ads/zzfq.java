package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.lang.reflect.Array;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzfq {
    public static final byte[] zza = {0, 0, 0, 1};
    public static final float[] zzb = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object zzc = new Object();
    private static int[] zzd = new int[10];

    public static int zza(byte[] bArr, int i, int i2, boolean[] zArr) {
        int i3 = i2 - i;
        zzdc.zzf(i3 >= 0);
        if (i3 == 0) {
            return i2;
        }
        if (zArr[0]) {
            zzi(zArr);
            return i - 3;
        }
        if (i3 > 1 && zArr[1] && bArr[i] == 1) {
            zzi(zArr);
            return i - 2;
        }
        if (i3 > 2 && zArr[2] && bArr[i] == 0 && bArr[i + 1] == 1) {
            zzi(zArr);
            return i - 1;
        }
        int i4 = i2 - 1;
        int i5 = i + 2;
        while (i5 < i4) {
            byte b = bArr[i5];
            if ((b & 254) == 0) {
                int i6 = i5 - 2;
                if (bArr[i6] == 0 && bArr[i5 - 1] == 0 && b == 1) {
                    zzi(zArr);
                    return i6;
                }
                i5 = i6;
            }
            i5 += 3;
        }
        zArr[0] = i3 <= 2 ? !(i3 != 2 ? !(zArr[1] && bArr[i4] == 1) : !(zArr[2] && bArr[i2 + (-2)] == 0 && bArr[i4] == 1)) : bArr[i2 + (-3)] == 0 && bArr[i2 + (-2)] == 0 && bArr[i4] == 1;
        zArr[1] = i3 <= 1 ? zArr[2] && bArr[i4] == 0 : bArr[i2 + (-2)] == 0 && bArr[i4] == 0;
        zArr[2] = bArr[i4] == 0;
        return i2;
    }

    public static int zzb(zzz zzzVar) {
        String str = zzzVar.zzo;
        if (Objects.equals(str, "video/avc")) {
            return 1;
        }
        return (Objects.equals(str, "video/hevc") || zzay.zzg(zzzVar.zzk, "video/hevc")) ? 2 : 0;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x004a  */
    /* JADX WARN: Code duplicated, block: B:36:0x00ad  */
    public static zzfk zzd(byte[] bArr, int i, int i2, zzfn zzfnVar) {
        boolean z;
        int i3;
        int i4;
        int iZzc;
        int iZzc2;
        int i5;
        int i6;
        int iZzc3;
        int i7;
        int i8;
        float f;
        int i9;
        int i10;
        int i11;
        int iZzb;
        int i12;
        zzfm zzfmVar;
        int iZza;
        int i13;
        zzfi zzfiVar;
        zzfe zzfeVarZzm = zzm(new zzfr(bArr, i, i2));
        zzfr zzfrVar = new zzfr(bArr, i + 2, i2);
        zzfrVar.zzf(4);
        int iZza2 = zzfrVar.zza(3);
        int i14 = zzfeVarZzm.zzb;
        if (i14 == 0 || iZza2 != 7) {
            z = false;
        } else {
            iZza2 = 7;
            z = true;
        }
        if (zzfnVar != null) {
            zzfww zzfwwVar = zzfnVar.zza;
            if (zzfwwVar.isEmpty()) {
                i3 = 0;
            } else {
                i3 = ((zzfd) zzfwwVar.get(Math.min(i14, zzfwwVar.size() - 1))).zza;
            }
        } else {
            i3 = 0;
        }
        zzff zzffVarZzn = null;
        if (!z) {
            zzfrVar.zze();
            zzffVarZzn = zzn(zzfrVar, true, iZza2, null);
        } else if (zzfnVar != null) {
            zzfg zzfgVar = zzfnVar.zzb;
            int i15 = zzfgVar.zzb[i3];
            zzfww zzfwwVar2 = zzfgVar.zza;
            if (zzfwwVar2.size() > i15) {
                zzffVarZzn = (zzff) zzfwwVar2.get(i15);
            }
        }
        int iZzc4 = zzfrVar.zzc();
        if (z) {
            int iZza3 = zzfrVar.zzh() ? zzfrVar.zza(8) : -1;
            if (zzfnVar == null || (zzfiVar = zzfnVar.zzc) == null) {
                iZzc2 = 0;
                i5 = 0;
                iZzc3 = 0;
                iZzc = 0;
                i6 = 0;
            } else {
                if (iZza3 == -1) {
                    iZza3 = zzfiVar.zzb[i3];
                }
                if (iZza3 != -1) {
                    zzfww zzfwwVar3 = zzfiVar.zza;
                    if (zzfwwVar3.size() > iZza3) {
                        zzfh zzfhVar = (zzfh) zzfwwVar3.get(iZza3);
                        int i16 = zzfhVar.zza;
                        i6 = zzfhVar.zzd;
                        iZzc = zzfhVar.zze;
                        iZzc2 = zzfhVar.zzb;
                        iZzc3 = zzfhVar.zzc;
                        i5 = i16;
                    } else {
                        iZzc2 = 0;
                        i5 = 0;
                        iZzc3 = 0;
                        iZzc = 0;
                        i6 = 0;
                    }
                } else {
                    iZzc2 = 0;
                    i5 = 0;
                    iZzc3 = 0;
                    iZzc = 0;
                    i6 = 0;
                }
            }
        } else {
            int iZzc5 = zzfrVar.zzc();
            if (iZzc5 == 3) {
                zzfrVar.zze();
                i4 = 3;
            } else {
                i4 = iZzc5;
            }
            int iZzc6 = zzfrVar.zzc();
            iZzc = zzfrVar.zzc();
            if (zzfrVar.zzh()) {
                int iZzc7 = zzfrVar.zzc();
                int iZzc8 = zzfrVar.zzc();
                int iZzc9 = zzfrVar.zzc();
                int iZzc10 = zzfrVar.zzc();
                iZzc6 = zzl(iZzc6, i4, iZzc7, iZzc8);
                iZzc = zzk(iZzc, i4, iZzc9, iZzc10);
            }
            iZzc2 = zzfrVar.zzc();
            i5 = iZzc5;
            i6 = iZzc6;
            iZzc3 = zzfrVar.zzc();
        }
        int iZzc11 = zzfrVar.zzc();
        if (z) {
            i7 = i6;
            i8 = -1;
        } else {
            int i17 = true != zzfrVar.zzh() ? iZza2 : 0;
            int iMax = -1;
            while (i17 <= iZza2) {
                zzfrVar.zzc();
                iMax = Math.max(zzfrVar.zzc(), iMax);
                zzfrVar.zzc();
                i17++;
                i6 = i6;
            }
            i7 = i6;
            i8 = iMax;
        }
        zzfrVar.zzc();
        zzfrVar.zzc();
        zzfrVar.zzc();
        zzfrVar.zzc();
        zzfrVar.zzc();
        zzfrVar.zzc();
        if (zzfrVar.zzh()) {
            int i18 = 6;
            if (z && zzfrVar.zzh()) {
                zzfrVar.zzf(6);
            } else if (zzfrVar.zzh()) {
                int i19 = 0;
                while (i19 < 4) {
                    int i20 = 0;
                    while (i20 < i18) {
                        if (zzfrVar.zzh()) {
                            int iMin = Math.min(64, 1 << ((i19 + i19) + 4));
                            if (i19 > 1) {
                                zzfrVar.zzb();
                            }
                            for (int i21 = 0; i21 < iMin; i21++) {
                                zzfrVar.zzb();
                            }
                        } else {
                            zzfrVar.zzc();
                        }
                        i20 += i19 == 3 ? 3 : 1;
                        iZzc4 = iZzc4;
                        i18 = 6;
                    }
                    i19++;
                    i18 = 6;
                }
            }
        }
        int i22 = iZzc4;
        zzfrVar.zzf(2);
        if (zzfrVar.zzh()) {
            zzfrVar.zzf(8);
            zzfrVar.zzc();
            zzfrVar.zzc();
            zzfrVar.zze();
        }
        int iZzc12 = zzfrVar.zzc();
        int[] iArr = new int[0];
        int[] iArrCopyOf = new int[0];
        int i23 = 0;
        int i24 = iZzc3;
        int i25 = -1;
        int i26 = -1;
        while (i23 < iZzc12) {
            if (i23 == 0 || !zzfrVar.zzh()) {
                int iZzc13 = zzfrVar.zzc();
                int iZzc14 = zzfrVar.zzc();
                int[] iArr2 = new int[iZzc13];
                int i27 = 0;
                while (i27 < iZzc13) {
                    iArr2[i27] = (i27 > 0 ? iArr2[i27 - 1] : 0) - (zzfrVar.zzc() + 1);
                    zzfrVar.zze();
                    i27++;
                }
                int[] iArr3 = new int[iZzc14];
                int i28 = 0;
                while (i28 < iZzc14) {
                    iArr3[i28] = (i28 > 0 ? iArr3[i28 - 1] : 0) + zzfrVar.zzc() + 1;
                    zzfrVar.zze();
                    i28++;
                }
                i25 = iZzc13;
                i26 = iZzc14;
                iArr = iArr2;
                iArrCopyOf = iArr3;
            } else {
                int i29 = i25 + i26;
                boolean zZzh = zzfrVar.zzh();
                boolean z2 = true;
                int iZzc15 = zzfrVar.zzc() + 1;
                int i30 = 1 - ((zZzh ? 1 : 0) + (zZzh ? 1 : 0));
                int i31 = i29 + 1;
                boolean[] zArr = new boolean[i31];
                int i32 = 0;
                while (i32 <= i29) {
                    if (zzfrVar.zzh()) {
                        zArr[i32] = z2;
                    } else {
                        zArr[i32] = zzfrVar.zzh();
                    }
                    i32++;
                    z2 = true;
                }
                int i33 = i26 - 1;
                int[] iArr4 = new int[i31];
                int[] iArr5 = new int[i31];
                int i34 = 0;
                while (true) {
                    i13 = i30 * iZzc15;
                    if (i33 < 0) {
                        break;
                    }
                    int i35 = iArrCopyOf[i33] + i13;
                    if (i35 < 0 && zArr[i25 + i33]) {
                        iArr4[i34] = i35;
                        i34++;
                    }
                    i33--;
                }
                if (i13 < 0 && zArr[i29]) {
                    iArr4[i34] = i13;
                    i34++;
                }
                int i36 = i34;
                for (int i37 = 0; i37 < i25; i37++) {
                    int i38 = iArr[i37] + i13;
                    if (i38 < 0 && zArr[i37]) {
                        iArr4[i36] = i38;
                        i36++;
                    }
                }
                int[] iArrCopyOf2 = Arrays.copyOf(iArr4, i36);
                int i39 = 0;
                for (int i40 = i25 - 1; i40 >= 0; i40--) {
                    int i41 = iArr[i40] + i13;
                    if (i41 > 0 && zArr[i40]) {
                        iArr5[i39] = i41;
                        i39++;
                    }
                }
                if (i13 > 0 && zArr[i29]) {
                    iArr5[i39] = i13;
                    i39++;
                }
                int i42 = i39;
                for (int i43 = 0; i43 < i26; i43++) {
                    int i44 = iArrCopyOf[i43] + i13;
                    if (i44 > 0 && zArr[i25 + i43]) {
                        iArr5[i42] = i44;
                        i42++;
                    }
                }
                iArrCopyOf = Arrays.copyOf(iArr5, i42);
                i25 = i36;
                i26 = i42;
                iArr = iArrCopyOf2;
            }
            i23++;
            iZzc12 = iZzc12;
            iZza2 = iZza2;
            zzfeVarZzm = zzfeVarZzm;
            iZzc2 = iZzc2;
            i5 = i5;
            zzffVarZzn = zzffVarZzn;
        }
        int i45 = iZzc2;
        int i46 = iZza2;
        zzfe zzfeVar = zzfeVarZzm;
        int i47 = i5;
        zzff zzffVar = zzffVarZzn;
        if (zzfrVar.zzh()) {
            int iZzc16 = zzfrVar.zzc();
            for (int i48 = 0; i48 < iZzc16; i48++) {
                zzfrVar.zzf(iZzc11 + 5);
            }
        }
        zzfrVar.zzf(2);
        float f2 = 1.0f;
        if (zzfrVar.zzh()) {
            if (zzfrVar.zzh()) {
                int iZza4 = zzfrVar.zza(8);
                if (iZza4 == 255) {
                    int iZza5 = zzfrVar.zza(16);
                    int iZza6 = zzfrVar.zza(16);
                    if (iZza5 != 0 && iZza6 != 0) {
                        f2 = iZza5 / iZza6;
                    }
                } else if (iZza4 < 17) {
                    f2 = zzb[iZza4];
                } else {
                    zzdx.zzf("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + iZza4);
                }
            }
            if (zzfrVar.zzh()) {
                zzfrVar.zze();
            }
            if (zzfrVar.zzh()) {
                zzfrVar.zzf(3);
                i12 = true != zzfrVar.zzh() ? 2 : 1;
                if (zzfrVar.zzh()) {
                    int iZza7 = zzfrVar.zza(8);
                    int iZza8 = zzfrVar.zza(8);
                    zzfrVar.zzf(8);
                    iZza = zzk.zza(iZza7);
                    iZzb = zzk.zzb(iZza8);
                } else {
                    iZzb = -1;
                    iZza = -1;
                }
            } else {
                if (zzfnVar != null && (zzfmVar = zzfnVar.zzd) != null) {
                    int i49 = zzfmVar.zzb[i3];
                    zzfww zzfwwVar4 = zzfmVar.zza;
                    if (zzfwwVar4.size() > i49) {
                        zzfl zzflVar = (zzfl) zzfwwVar4.get(i49);
                        iZza = zzflVar.zza;
                        int i50 = zzflVar.zzb;
                        iZzb = zzflVar.zzc;
                        i12 = i50;
                    }
                }
                iZzb = -1;
                i12 = -1;
                iZza = -1;
            }
            if (zzfrVar.zzh()) {
                zzfrVar.zzc();
                zzfrVar.zzc();
            }
            zzfrVar.zze();
            if (zzfrVar.zzh()) {
                iZzc += iZzc;
            }
            i11 = iZzb;
            f = f2;
            i9 = i12;
            i10 = iZza;
        } else {
            f = 1.0f;
            i9 = -1;
            i10 = -1;
            i11 = -1;
        }
        return new zzfk(zzfeVar, i46, zzffVar, i47, i45, i24, i22, i7, iZzc, f, i8, i10, i9, i11);
    }

    /* JADX WARN: Code duplicated, block: B:442:0x0148 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x0108  */
    /* JADX WARN: Code duplicated, block: B:65:0x0121  */
    /* JADX WARN: Code duplicated, block: B:69:0x0135  */
    /* JADX WARN: Code duplicated, block: B:71:0x013a  */
    /* JADX WARN: Code duplicated, block: B:73:0x0142  */
    /* JADX WARN: Multi-variable type inference failed */
    public static zzfn zze(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int[] iArr;
        int i5;
        zzfm zzfmVar;
        boolean z;
        int iZza;
        int iZza2;
        int iZza3;
        int iZza4;
        int i6;
        int i7;
        int i8;
        int[] iArr2;
        int i9;
        boolean[][] zArr;
        int i10;
        boolean[][] zArr2;
        int[] iArr3;
        int i11;
        int i12;
        boolean z2;
        boolean zZzh;
        int i13;
        int i14;
        int i15;
        int iZzc;
        int i16;
        int i17;
        int i18;
        boolean z3;
        boolean z4;
        zzfr zzfrVar = new zzfr(bArr, i, i2);
        zzfe zzfeVarZzm = zzm(zzfrVar);
        zzfrVar.zzf(4);
        boolean zZzh2 = zzfrVar.zzh();
        boolean zZzh3 = zzfrVar.zzh();
        int iZza5 = zzfrVar.zza(6);
        int i19 = iZza5 + 1;
        int iZza6 = zzfrVar.zza(3);
        zzfrVar.zzf(17);
        int i20 = 1;
        zzff zzffVarZzn = zzn(zzfrVar, true, iZza6, null);
        int i21 = 0;
        for (int i22 = true != zzfrVar.zzh() ? iZza6 : 0; i22 <= iZza6; i22++) {
            zzfrVar.zzc();
            zzfrVar.zzc();
            zzfrVar.zzc();
        }
        int iZza7 = zzfrVar.zza(6);
        int iZzc2 = zzfrVar.zzc() + 1;
        zzfg zzfgVar = new zzfg(zzfww.zzo(zzffVarZzn), new int[1]);
        boolean z5 = i19 >= 2 && iZzc2 >= 2;
        boolean z6 = zZzh2 && zZzh3;
        int i23 = iZza7 + 1;
        if (!z5 || !z6 || i23 < i19) {
            return new zzfn(zzfeVarZzm, null, zzfgVar, null, null);
        }
        int[][] iArr4 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, iZzc2, i23);
        int[] iArr5 = new int[iZzc2];
        int[] iArr6 = new int[iZzc2];
        iArr4[0][0] = 0;
        iArr5[0] = 1;
        iArr6[0] = 0;
        while (i20 < iZzc2) {
            int i24 = i21;
            while (i21 <= iZza7) {
                if (zzfrVar.zzh()) {
                    iArr4[i20][i24] = i21;
                    iArr6[i20] = i21;
                    i24++;
                }
                iArr5[i20] = i24;
                i21++;
            }
            i20++;
            i21 = 0;
        }
        if (zzfrVar.zzh()) {
            zzfrVar.zzf(64);
            if (zzfrVar.zzh()) {
                zzfrVar.zzc();
            }
            int iZzc3 = zzfrVar.zzc();
            for (int i25 = 0; i25 < iZzc3; i25++) {
                zzfrVar.zzc();
                if (i25 == 0 || zzfrVar.zzh()) {
                    boolean zZzh4 = zzfrVar.zzh();
                    boolean zZzh5 = zzfrVar.zzh();
                    z4 = zZzh4;
                    z3 = zZzh5;
                    if (zZzh4 || zZzh5) {
                        zZzh = zzfrVar.zzh();
                        if (zZzh) {
                            zzfrVar.zzf(19);
                        }
                        zzfrVar.zzf(8);
                        if (zZzh) {
                            zzfrVar.zzf(4);
                        }
                        zzfrVar.zzf(15);
                        i14 = zZzh4;
                        i13 = zZzh5;
                    }
                    i15 = 0;
                    while (i15 <= iZza6) {
                        if (!zzfrVar.zzh() || zzfrVar.zzh()) {
                            zzfrVar.zzc();
                        } else {
                            if (zzfrVar.zzh()) {
                                iZzc = 0;
                            }
                            i16 = i14 + i13;
                            int[][] iArr7 = iArr4;
                            i17 = 0;
                            while (i17 < i16) {
                                int i26 = i16;
                                for (i18 = 0; i18 <= iZzc; i18++) {
                                    zzfrVar.zzc();
                                    zzfrVar.zzc();
                                    if (zZzh) {
                                        zzfrVar.zzc();
                                        zzfrVar.zzc();
                                    }
                                    zzfrVar.zze();
                                }
                                i17++;
                                i16 = i26;
                            }
                            i15++;
                            iArr6 = iArr6;
                            iZzc3 = iZzc3;
                            iArr4 = iArr7;
                        }
                        iZzc = zzfrVar.zzc();
                        i16 = i14 + i13;
                        int[][] iArr8 = iArr4;
                        i17 = 0;
                        while (i17 < i16) {
                            int i27 = i16;
                            while (i18 <= iZzc) {
                                zzfrVar.zzc();
                                zzfrVar.zzc();
                                if (zZzh) {
                                    zzfrVar.zzc();
                                    zzfrVar.zzc();
                                }
                                zzfrVar.zze();
                            }
                            i17++;
                            i16 = i27;
                        }
                        i15++;
                        iArr6 = iArr6;
                        iZzc3 = iZzc3;
                        iArr4 = iArr8;
                    }
                } else {
                    z4 = false;
                    z3 = false;
                }
                zZzh = false;
                i14 = z4;
                i13 = z3;
                i15 = 0;
                while (i15 <= iZza6) {
                    if (zzfrVar.zzh()) {
                        zzfrVar.zzc();
                        iZzc = zzfrVar.zzc();
                    } else {
                        zzfrVar.zzc();
                        iZzc = zzfrVar.zzc();
                    }
                    i16 = i14 + i13;
                    int[][] iArr9 = iArr4;
                    i17 = 0;
                    while (i17 < i16) {
                        int i28 = i16;
                        while (i18 <= iZzc) {
                            zzfrVar.zzc();
                            zzfrVar.zzc();
                            if (zZzh) {
                                zzfrVar.zzc();
                                zzfrVar.zzc();
                            }
                            zzfrVar.zze();
                        }
                        i17++;
                        i16 = i28;
                    }
                    i15++;
                    iArr6 = iArr6;
                    iZzc3 = iZzc3;
                    iArr4 = iArr9;
                }
            }
        }
        int[][] iArr10 = iArr4;
        int[] iArr11 = iArr6;
        if (!zzfrVar.zzh()) {
            return new zzfn(zzfeVarZzm, null, zzfgVar, null, null);
        }
        zzfrVar.zzd();
        zzff zzffVarZzn2 = zzn(zzfrVar, false, iZza6, zzffVarZzn);
        boolean zZzh6 = zzfrVar.zzh();
        boolean[] zArr3 = new boolean[16];
        int i29 = 0;
        for (int i30 = 0; i30 < 16; i30++) {
            boolean zZzh7 = zzfrVar.zzh();
            zArr3[i30] = zZzh7;
            if (zZzh7) {
                i29++;
            }
        }
        if (i29 == 0 || !zArr3[1]) {
            return new zzfn(zzfeVarZzm, null, zzfgVar, null, null);
        }
        int i31 = i29 + 1;
        int[] iArr12 = new int[i29];
        for (int i32 = 0; i32 < i29 - (zZzh6 ? 1 : 0); i32++) {
            iArr12[i32] = zzfrVar.zza(3);
        }
        int[] iArr13 = new int[i31];
        if (zZzh6) {
            for (int i33 = 1; i33 < i29; i33++) {
                for (int i34 = 0; i34 < i33; i34++) {
                    iArr13[i33] = iArr13[i33] + iArr12[i34] + 1;
                }
            }
            iArr13[i29] = 6;
        }
        int[][] iArr14 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i19, i29);
        int[] iArr15 = new int[i19];
        iArr15[0] = 0;
        boolean zZzh8 = zzfrVar.zzh();
        int i35 = 1;
        while (i35 < i19) {
            if (zZzh8) {
                iArr15[i35] = zzfrVar.zza(6);
            } else {
                iArr15[i35] = i35;
            }
            if (zZzh6) {
                z2 = zZzh6 ? 1 : 0;
                int i36 = 0;
                while (i36 < i29) {
                    int i37 = i36 + 1;
                    iArr14[i35][i36] = (iArr15[i35] & ((1 << iArr13[i37]) - 1)) >> iArr13[i36];
                    i36 = i37;
                }
            } else {
                int i38 = 0;
                while (i38 < i29) {
                    iArr14[i35][i38] = zzfrVar.zza(iArr12[i38] + 1);
                    i38++;
                    zZzh6 = zZzh6 ? 1 : 0;
                }
                z2 = zZzh6;
            }
            i35++;
            zZzh6 = z2;
        }
        int[] iArr16 = new int[i23];
        int i39 = 1;
        for (int i40 = 0; i40 < i19; i40++) {
            iArr16[iArr15[i40]] = -1;
            int i41 = 0;
            int i42 = 0;
            while (i41 < 16) {
                if (zArr3[i41]) {
                    i11 = 1;
                    if (i41 == 1) {
                        iArr16[iArr15[i40]] = iArr14[i40][i42];
                        i12 = 1;
                    } else {
                        i12 = i41;
                    }
                    i42++;
                    i41 = i12;
                } else {
                    i11 = 1;
                }
                i41 += i11;
            }
            if (i40 > 0) {
                int i43 = 0;
                while (true) {
                    if (i43 >= i40) {
                        i39++;
                        break;
                    }
                    if (iArr16[iArr15[i40]] == iArr16[iArr15[i43]]) {
                        break;
                    }
                    i43++;
                }
            }
        }
        int iZza8 = zzfrVar.zza(4);
        if (i39 < 2 || iZza8 == 0) {
            return new zzfn(zzfeVarZzm, null, zzfgVar, null, null);
        }
        int[] iArr17 = new int[i39];
        for (int i44 = 0; i44 < i39; i44++) {
            iArr17[i44] = zzfrVar.zza(iZza8);
        }
        int[] iArr18 = new int[i23];
        for (int i45 = 0; i45 < i19; i45++) {
            iArr18[Math.min(iArr15[i45], iZza7)] = i45;
        }
        zzfwt zzfwtVar = new zzfwt();
        int i46 = 0;
        while (i46 <= iZza7) {
            int[] iArr19 = iArr16;
            int iMin = Math.min(iArr16[i46], i39 - 1);
            zzfwtVar.zzf(new zzfd(iArr18[i46], iMin >= 0 ? iArr17[iMin] : -1));
            i46++;
            iArr16 = iArr19;
        }
        zzfww zzfwwVarZzi = zzfwtVar.zzi();
        if (((zzfd) zzfwwVarZzi.get(0)).zzb == -1) {
            return new zzfn(zzfeVarZzm, null, zzfgVar, null, null);
        }
        int i47 = 1;
        while (true) {
            if (i47 > iZza7) {
                i3 = -1;
                i47 = -1;
                break;
            }
            i3 = -1;
            if (((zzfd) zzfwwVarZzi.get(i47)).zzb != -1) {
                break;
            }
            i47++;
        }
        if (i47 == i3) {
            return new zzfn(zzfeVarZzm, null, zzfgVar, null, null);
        }
        boolean[][] zArr4 = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, i19, i19);
        boolean[][] zArr5 = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, i19, i19);
        for (int i48 = 1; i48 < i19; i48++) {
            for (int i49 = 0; i49 < i48; i49++) {
                boolean[] zArr6 = zArr4[i48];
                boolean[] zArr7 = zArr5[i48];
                boolean zZzh9 = zzfrVar.zzh();
                zArr7[i49] = zZzh9;
                zArr6[i49] = zZzh9;
            }
        }
        for (int i50 = 1; i50 < i19; i50++) {
            for (int i51 = 0; i51 < iZza5; i51++) {
                for (int i52 = 0; i52 < i50; i52++) {
                    boolean[] zArr8 = zArr5[i50];
                    if (zArr8[i52] && zArr5[i52][i51]) {
                        zArr8[i51] = true;
                        break;
                    }
                }
            }
        }
        int[] iArr20 = new int[i23];
        for (int i53 = 0; i53 < i19; i53++) {
            int i54 = 0;
            for (int i55 = 0; i55 < i53; i55++) {
                i54 += zArr4[i53][i55] ? 1 : 0;
            }
            iArr20[iArr15[i53]] = i54;
        }
        int i56 = 0;
        for (int i57 = 0; i57 < i19; i57++) {
            if (iArr20[iArr15[i57]] == 0) {
                i56++;
            }
        }
        if (i56 > 1) {
            return new zzfn(zzfeVarZzm, null, zzfgVar, null, null);
        }
        int[] iArr21 = new int[i19];
        int[] iArr22 = new int[i4];
        if (zzfrVar.zzh()) {
            int i58 = 0;
            while (i58 < i19) {
                i4 = iZzc2;
                iArr21[i58] = zzfrVar.zza(3);
                i58++;
                iArr15 = iArr15;
            }
            i4 = iZzc2;
            iArr = iArr15;
            i5 = iZza6;
        } else {
            i4 = iZzc2;
            iArr = iArr15;
            i5 = iZza6;
            Arrays.fill(iArr21, 0, i19, i5);
        }
        int i59 = 0;
        while (i59 < i4) {
            int i60 = i47;
            boolean[][] zArr9 = zArr5;
            int[] iArr23 = iArr20;
            int iMax = 0;
            for (int i61 = 0; i61 < iArr5[i59]; i61++) {
                iMax = Math.max(iMax, iArr21[((zzfd) zzfwwVarZzi.get(iArr10[i59][i61])).zza]);
            }
            iArr22[i59] = iMax + 1;
            i59++;
            zArr5 = zArr9;
            iArr20 = iArr23;
            i47 = i60;
        }
        int i62 = i47;
        boolean[][] zArr10 = zArr5;
        int[] iArr24 = iArr20;
        if (zzfrVar.zzh()) {
            int i63 = 0;
            while (i63 < iZza5) {
                int i64 = i63 + 1;
                for (int i65 = i64; i65 < i19; i65++) {
                    if (zArr4[i65][i63]) {
                        zzfrVar.zzf(3);
                    }
                }
                i63 = i64;
            }
        }
        zzfrVar.zze();
        int iZzc4 = zzfrVar.zzc() + 1;
        zzfwt zzfwtVar2 = new zzfwt();
        zzfwtVar2.zzf(zzffVarZzn);
        if (iZzc4 > 1) {
            zzff zzffVarZzn3 = zzffVarZzn2;
            zzfwtVar2.zzf(zzffVarZzn3);
            for (int i66 = 2; i66 < iZzc4; i66++) {
                zzffVarZzn3 = zzn(zzfrVar, zzfrVar.zzh(), i5, zzffVarZzn3);
                zzfwtVar2.zzf(zzffVarZzn3);
            }
        }
        zzfww zzfwwVarZzi2 = zzfwtVar2.zzi();
        int iZzc5 = zzfrVar.zzc() + i4;
        if (iZzc5 > i4) {
            return new zzfn(zzfeVarZzm, null, zzfgVar, null, null);
        }
        int iZza9 = zzfrVar.zza(2);
        boolean[][] zArr11 = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, iZzc5, i23);
        int[] iArr25 = new int[iZzc5];
        int[] iArr26 = new int[iZzc5];
        int i67 = 0;
        while (i67 < i4) {
            int i68 = i4;
            iArr25[i67] = 0;
            int i69 = iArr11[i67];
            iArr26[i67] = i69;
            if (iZza9 == 0) {
                zArr2 = zArr4;
                i10 = i19;
                iArr3 = iArr22;
                Arrays.fill(zArr11[i67], 0, iArr5[i67], true);
                iArr25[i67] = iArr5[i67];
            } else {
                i10 = i19;
                zArr2 = zArr4;
                iArr3 = iArr22;
                if (iZza9 == 1) {
                    for (int i70 = 0; i70 < iArr5[i67]; i70++) {
                        zArr11[i67][i70] = iArr10[i67][i70] == i69;
                    }
                    iArr25[i67] = 1;
                } else {
                    zArr11[0][0] = true;
                    iArr25[0] = 1;
                }
                i67++;
                i4 = i68;
                zArr4 = zArr2;
                iArr22 = iArr3;
                i19 = i10;
            }
            i67++;
            i4 = i68;
            zArr4 = zArr2;
            iArr22 = iArr3;
            i19 = i10;
        }
        int i71 = i19;
        boolean[][] zArr12 = zArr4;
        int[] iArr27 = iArr22;
        int i72 = i4;
        int[] iArr28 = new int[i23];
        int i73 = 2;
        boolean[][] zArr13 = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, iZzc5, i23);
        int i74 = 0;
        int i75 = 1;
        while (i75 < iZzc5) {
            if (iZza9 == i73) {
                for (int i76 = 0; i76 < iArr5[i75]; i76++) {
                    zArr11[i75][i76] = zzfrVar.zzh();
                    int i77 = iArr25[i75];
                    boolean z7 = zArr11[i75][i76];
                    iArr25[i75] = i77 + (z7 ? 1 : 0);
                    if (z7) {
                        iArr26[i75] = iArr10[i75][i76];
                    }
                }
            }
            if (i74 != 0) {
                i6 = iZza9;
                i7 = i62;
            } else if (iArr10[i75][0] == 0 && zArr11[i75][0]) {
                i74 = 0;
                int i78 = 1;
                while (i78 < iArr5[i75]) {
                    int i79 = iZza9;
                    int i80 = i62;
                    if (iArr10[i75][i78] == i80 && zArr11[i75][i80]) {
                        i74 = i75;
                    }
                    i78++;
                    i62 = i80;
                    iZza9 = i79;
                }
                i6 = iZza9;
                i7 = i62;
            } else {
                i6 = iZza9;
                i7 = i62;
                i74 = 0;
            }
            int i81 = 0;
            while (i81 < iArr5[i75]) {
                if (iZzc4 > 1) {
                    zArr13[i75][i81] = zArr11[i75][i81];
                    iArr2 = iArr26;
                    i9 = i7;
                    i8 = iZzc4;
                    int iZza10 = zzfzp.zza(iZzc4, RoundingMode.CEILING);
                    if (zArr13[i75][i81]) {
                        zArr = zArr11;
                        break;
                    }
                    int i82 = ((zzfd) zzfwwVarZzi.get(iArr10[i75][i81])).zza;
                    int i83 = 0;
                    while (true) {
                        if (i83 >= i81) {
                            zArr = zArr11;
                            break;
                        }
                        zArr = zArr11;
                        if (zArr10[i82][((zzfd) zzfwwVarZzi.get(iArr10[i75][i83])).zza]) {
                            zArr13[i75][i81] = true;
                            break;
                        }
                        i83++;
                        zArr11 = zArr;
                    }
                    if (zArr13[i75][i81]) {
                        if (i74 <= 0 || i75 != i74) {
                            zzfrVar.zzf(iZza10);
                        } else {
                            iArr28[i81] = zzfrVar.zza(iZza10);
                        }
                    }
                } else {
                    i8 = iZzc4;
                    iArr2 = iArr26;
                    i9 = i7;
                    zArr = zArr11;
                }
                i81++;
                iArr26 = iArr2;
                i7 = i9;
                iZzc4 = i8;
                zArr11 = zArr;
            }
            int i84 = iZzc4;
            int[] iArr29 = iArr26;
            i62 = i7;
            boolean[][] zArr14 = zArr11;
            if (iArr25[i75] == 1 && iArr24[iArr29[i75]] > 0) {
                zzfrVar.zze();
            }
            i75++;
            iArr26 = iArr29;
            iZza9 = i6;
            iZzc4 = i84;
            zArr11 = zArr14;
            i73 = 2;
        }
        if (i74 == 0) {
            return new zzfn(zzfeVarZzm, null, zzfgVar, null, null);
        }
        int iZzc6 = zzfrVar.zzc();
        int i85 = iZzc6 + 1;
        zzfwt zzfwtVarZzi = zzfww.zzi(i85);
        int[] iArr30 = new int[i71];
        int i86 = 0;
        while (i86 < i85) {
            int iZza11 = zzfrVar.zza(16);
            int iZza12 = zzfrVar.zza(16);
            if (zzfrVar.zzh()) {
                iZza2 = zzfrVar.zza(2);
                if (iZza2 == 3) {
                    zzfrVar.zze();
                }
                iZza3 = zzfrVar.zza(4);
                iZza4 = zzfrVar.zza(4);
            } else {
                iZza2 = 0;
                iZza3 = 0;
                iZza4 = 0;
            }
            if (zzfrVar.zzh()) {
                int iZzc7 = zzfrVar.zzc();
                int iZzc8 = zzfrVar.zzc();
                int iZzc9 = zzfrVar.zzc();
                int iZzc10 = zzfrVar.zzc();
                iZza11 = zzl(iZza11, iZza2, iZzc7, iZzc8);
                iZza12 = zzk(iZza12, iZza2, iZzc9, iZzc10);
            }
            zzfwtVarZzi.zzf(new zzfh(iZza2, iZza3, iZza4, iZza11, iZza12));
            i86++;
            zzfwwVarZzi = zzfwwVarZzi;
            zzfeVarZzm = zzfeVarZzm;
            iArr28 = iArr28;
        }
        zzfe zzfeVar = zzfeVarZzm;
        zzfww zzfwwVar = zzfwwVarZzi;
        int[] iArr31 = iArr28;
        if (i85 <= 1 || !zzfrVar.zzh()) {
            for (int i87 = 1; i87 < i71; i87++) {
                iArr30[i87] = Math.min(i87, iZzc6);
            }
        } else {
            int iZza13 = zzfzp.zza(i85, RoundingMode.CEILING);
            for (int i88 = 1; i88 < i71; i88++) {
                iArr30[i88] = zzfrVar.zza(iZza13);
            }
        }
        zzfi zzfiVar = new zzfi(zzfwtVarZzi.zzi(), iArr30);
        zzfrVar.zzf(2);
        for (int i89 = 1; i89 < i71; i89++) {
            if (iArr24[iArr[i89]] == 0) {
                zzfrVar.zze();
            }
        }
        for (int i90 = 1; i90 < iZzc5; i90++) {
            boolean zZzh10 = zzfrVar.zzh();
            int i91 = 0;
            while (i91 < iArr27[i90]) {
                if ((i91 <= 0 || !zZzh10) ? i91 == 0 : zzfrVar.zzh()) {
                    for (int i92 = 0; i92 < iArr5[i90]; i92++) {
                        if (zArr13[i90][i92]) {
                            zzfrVar.zzc();
                        }
                    }
                    zzfrVar.zzc();
                    zzfrVar.zzc();
                }
                i91++;
            }
        }
        int iZzc11 = zzfrVar.zzc() + 2;
        if (zzfrVar.zzh()) {
            zzfrVar.zzf(iZzc11);
        } else {
            for (int i93 = 1; i93 < i71; i93++) {
                for (int i94 = 0; i94 < i93; i94++) {
                    if (zArr12[i93][i94]) {
                        zzfrVar.zzf(iZzc11);
                    }
                }
            }
        }
        int iZzc12 = zzfrVar.zzc();
        for (int i95 = 1; i95 <= iZzc12; i95++) {
            zzfrVar.zzf(8);
        }
        if (zzfrVar.zzh()) {
            zzfrVar.zzd();
            if (zzfrVar.zzh() || zzfrVar.zzh()) {
                zzfrVar.zze();
            }
            boolean zZzh11 = zzfrVar.zzh();
            boolean zZzh12 = zzfrVar.zzh();
            if (zZzh11 || zZzh12) {
                for (int i96 = 0; i96 < i72; i96++) {
                    for (int i97 = 0; i97 < iArr27[i96]; i97++) {
                        boolean zZzh13 = zZzh11 ? zzfrVar.zzh() : false;
                        boolean zZzh14 = zZzh12 ? zzfrVar.zzh() : false;
                        if (zZzh13) {
                            zzfrVar.zzf(32);
                        }
                        if (zZzh14) {
                            zzfrVar.zzf(18);
                        }
                    }
                }
            }
            boolean zZzh15 = zzfrVar.zzh();
            if (zZzh15) {
                z = true;
                iZza = zzfrVar.zza(4) + 1;
            } else {
                z = true;
                iZza = i71;
            }
            zzfwt zzfwtVarZzi2 = zzfww.zzi(iZza);
            int[] iArr32 = new int[i71];
            int i98 = 0;
            while (i98 < iZza) {
                zzfrVar.zzf(3);
                int i99 = z != zzfrVar.zzh() ? 2 : 1;
                int iZza14 = zzk.zza(zzfrVar.zza(8));
                int iZzb = zzk.zzb(zzfrVar.zza(8));
                zzfrVar.zzf(8);
                zzfwtVarZzi2.zzf(new zzfl(iZza14, i99, iZzb));
                i98++;
                z = true;
            }
            if (zZzh15 && iZza > 1) {
                for (int i100 = 0; i100 < i71; i100++) {
                    iArr32[i100] = zzfrVar.zza(4);
                }
            }
            zzfmVar = new zzfm(zzfwtVarZzi2.zzi(), iArr32);
        } else {
            zzfmVar = null;
        }
        return new zzfn(zzfeVar, zzfwwVar, new zzfg(zzfwwVarZzi2, iArr31), zzfiVar, zzfmVar);
    }

    public static zzfo zzf(byte[] bArr, int i, int i2) {
        zzfr zzfrVar = new zzfr(bArr, 4, i2);
        int iZzc = zzfrVar.zzc();
        int iZzc2 = zzfrVar.zzc();
        zzfrVar.zze();
        return new zzfo(iZzc, iZzc2, zzfrVar.zzh());
    }

    /* JADX WARN: Code duplicated, block: B:100:0x019c  */
    /* JADX WARN: Code duplicated, block: B:101:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:102:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:105:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:108:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:110:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:113:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:114:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:116:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:119:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:122:0x020a  */
    /* JADX WARN: Code duplicated, block: B:125:0x0215  */
    /* JADX WARN: Code duplicated, block: B:128:0x021e  */
    /* JADX WARN: Code duplicated, block: B:131:0x0225  */
    /* JADX WARN: Code duplicated, block: B:134:0x0231  */
    /* JADX WARN: Code duplicated, block: B:135:0x024e  */
    /* JADX WARN: Code duplicated, block: B:137:0x0258  */
    /* JADX WARN: Code duplicated, block: B:142:0x00a8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:145:0x00a3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:21:0x0059  */
    /* JADX WARN: Code duplicated, block: B:22:0x005f  */
    /* JADX WARN: Code duplicated, block: B:25:0x0073 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:26:0x0075  */
    /* JADX WARN: Code duplicated, block: B:27:0x0078  */
    /* JADX WARN: Code duplicated, block: B:30:0x007d  */
    /* JADX WARN: Code duplicated, block: B:32:0x0083  */
    /* JADX WARN: Code duplicated, block: B:34:0x0086  */
    /* JADX WARN: Code duplicated, block: B:35:0x0088  */
    /* JADX WARN: Code duplicated, block: B:38:0x0091 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x0093  */
    /* JADX WARN: Code duplicated, block: B:41:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:57:0x010c  */
    /* JADX WARN: Code duplicated, block: B:60:0x011d  */
    /* JADX WARN: Code duplicated, block: B:62:0x012f  */
    /* JADX WARN: Code duplicated, block: B:63:0x0132 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:64:0x0134  */
    /* JADX WARN: Code duplicated, block: B:65:0x0137  */
    /* JADX WARN: Code duplicated, block: B:67:0x013b  */
    /* JADX WARN: Code duplicated, block: B:68:0x013e  */
    /* JADX WARN: Code duplicated, block: B:84:0x0166 A[PHI: r2
  0x0166: PHI (r2v4 int) = (r2v3 int), (r2v3 int), (r2v3 int), (r2v3 int), (r2v3 int), (r2v27 int) binds: [B:72:0x014f, B:74:0x0153, B:76:0x0157, B:78:0x015b, B:80:0x015f, B:83:0x0165] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:86:0x016a  */
    /* JADX WARN: Code duplicated, block: B:87:0x016d A[PHI: r2
  0x016d: PHI (r2v26 int) = (r2v4 int), (r2v3 int) binds: [B:85:0x0168, B:82:0x0163] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:90:0x0177  */
    /* JADX WARN: Code duplicated, block: B:92:0x017d  */
    /* JADX WARN: Code duplicated, block: B:94:0x0187  */
    /* JADX WARN: Code duplicated, block: B:98:0x0198  */
    /* JADX WARN: Instruction removed from duplicated block: B:101:0x01a1, please report this as an issue */
    public static zzfp zzg(byte[] bArr, int i, int i2) {
        int iZzc;
        int i3;
        boolean zZzh;
        int iZzc2;
        int iZzc3;
        int i4;
        int i5;
        int i6;
        int i7;
        int iZzb;
        int i8;
        int iZzc4;
        boolean z;
        boolean zZzh2;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int iZzb2;
        float f;
        float f2;
        boolean zZzh3;
        boolean zZzh4;
        int iZza;
        int iZza2;
        int i18;
        int i19;
        zzfr zzfrVar = new zzfr(bArr, i, i2);
        int iZza3 = zzfrVar.zza(8);
        int iZza4 = zzfrVar.zza(8);
        int iZza5 = zzfrVar.zza(8);
        int iZzc5 = zzfrVar.zzc();
        if (iZza3 == 100 || iZza3 == 110 || iZza3 == 122 || iZza3 == 244 || iZza3 == 44 || iZza3 == 83 || iZza3 == 86 || iZza3 == 118 || iZza3 == 128) {
            iZzc = zzfrVar.zzc();
            if (iZzc == 3) {
                zZzh = zzfrVar.zzh();
                i3 = 3;
            } else {
                i3 = iZzc;
                zZzh = false;
            }
            iZzc2 = zzfrVar.zzc();
            iZzc3 = zzfrVar.zzc();
            zzfrVar.zze();
            if (zzfrVar.zzh()) {
                if (i3 != 3) {
                    i4 = 8;
                } else {
                    i4 = 12;
                }
                for (i5 = 0; i5 < i4; i5++) {
                    if (!zzfrVar.zzh()) {
                        if (i5 < 6) {
                            i6 = 16;
                        } else {
                            i6 = 64;
                        }
                        iZzb = 8;
                        i8 = 8;
                        for (i7 = 0; i7 < i6; i7++) {
                            if (iZzb != 0) {
                                iZzb = ((i8 + zzfrVar.zzb()) + 256) % 256;
                            }
                            if (iZzb != 0) {
                                i8 = iZzb;
                            }
                        }
                    }
                }
            }
        } else if (iZza3 == 138) {
            iZza3 = 138;
            iZzc = zzfrVar.zzc();
            if (iZzc == 3) {
                zZzh = zzfrVar.zzh();
                i3 = 3;
            } else {
                i3 = iZzc;
                zZzh = false;
            }
            iZzc2 = zzfrVar.zzc();
            iZzc3 = zzfrVar.zzc();
            zzfrVar.zze();
            if (zzfrVar.zzh()) {
                if (i3 != 3) {
                    i4 = 8;
                } else {
                    i4 = 12;
                }
                while (i5 < i4) {
                    if (!zzfrVar.zzh()) {
                        if (i5 < 6) {
                            i6 = 16;
                        } else {
                            i6 = 64;
                        }
                        iZzb = 8;
                        i8 = 8;
                        while (i7 < i6) {
                            if (iZzb != 0) {
                                iZzb = ((i8 + zzfrVar.zzb()) + 256) % 256;
                            }
                            if (iZzb != 0) {
                                i8 = iZzb;
                            }
                        }
                    }
                }
            }
        } else {
            iZzc = 1;
            zZzh = false;
            iZzc2 = 0;
            iZzc3 = 0;
        }
        int iZzc6 = zzfrVar.zzc() + 4;
        int iZzc7 = zzfrVar.zzc();
        if (iZzc7 != 0) {
            if (iZzc7 == 1) {
                boolean zZzh5 = zzfrVar.zzh();
                zzfrVar.zzb();
                zzfrVar.zzb();
                long jZzc = zzfrVar.zzc();
                for (int i20 = 0; i20 < jZzc; i20++) {
                    zzfrVar.zzc();
                }
                z = zZzh5;
                iZzc7 = 1;
                iZzc4 = 0;
            } else {
                iZzc4 = 0;
            }
            int iZzc8 = zzfrVar.zzc();
            zzfrVar.zze();
            int iZzc9 = zzfrVar.zzc() + 1;
            int iZzc10 = zzfrVar.zzc() + 1;
            zZzh2 = zzfrVar.zzh();
            i9 = 2 - (zZzh2 ? 1 : 0);
            if (!zZzh2) {
                zzfrVar.zze();
            }
            zzfrVar.zze();
            i10 = iZzc9 * 16;
            i11 = iZzc10 * i9 * 16;
            if (zzfrVar.zzh()) {
                int iZzc11 = zzfrVar.zzc();
                int iZzc12 = zzfrVar.zzc();
                int iZzc13 = zzfrVar.zzc();
                int iZzc14 = zzfrVar.zzc();
                if (iZzc == 0) {
                    i18 = 1;
                } else {
                    if (iZzc == 3) {
                        i18 = 1;
                    } else {
                        i18 = 2;
                    }
                    if (iZzc == 1) {
                        i19 = 2;
                    } else {
                        i19 = 1;
                    }
                    i9 *= i19;
                }
                i10 -= (iZzc11 + iZzc12) * i18;
                i11 -= (iZzc13 + iZzc14) * i9;
            }
            int i21 = i10;
            int i22 = i11;
            if (iZza3 != 44 || iZza3 == 86 || iZza3 == 100 || iZza3 == 110 || iZza3 == 122) {
                if ((iZza4 & 16) != 0) {
                    i12 = iZza3;
                    i13 = 0;
                } else {
                    i12 = iZza3;
                    i13 = 16;
                }
            } else if (iZza3 == 244) {
                iZza3 = 244;
                if ((iZza4 & 16) != 0) {
                    i12 = iZza3;
                    i13 = 0;
                } else {
                    i12 = iZza3;
                    i13 = 16;
                }
            } else {
                i12 = iZza3;
                i13 = 16;
            }
            i14 = -1;
            if (zzfrVar.zzh()) {
                if (zzfrVar.zzh()) {
                    iZza = zzfrVar.zza(8);
                    if (iZza == 255) {
                        iZza2 = zzfrVar.zza(16);
                        int iZza6 = zzfrVar.zza(16);
                        if (iZza2 != 0 || iZza6 == 0) {
                            f2 = 1.0f;
                        } else {
                            f2 = iZza2 / iZza6;
                        }
                    } else if (iZza < 17) {
                        f2 = zzb[iZza];
                    } else {
                        zzdx.zzf("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + iZza);
                        f2 = 1.0f;
                    }
                } else {
                    f2 = 1.0f;
                }
                if (zzfrVar.zzh()) {
                    zzfrVar.zze();
                }
                if (zzfrVar.zzh()) {
                    zzfrVar.zzf(3);
                    int i23 = true != zzfrVar.zzh() ? 2 : 1;
                    if (zzfrVar.zzh()) {
                        int iZza7 = zzfrVar.zza(8);
                        int iZza8 = zzfrVar.zza(8);
                        zzfrVar.zzf(8);
                        int iZza9 = zzk.zza(iZza7);
                        iZzb2 = zzk.zzb(iZza8);
                        i16 = iZza9;
                    } else {
                        i16 = -1;
                        iZzb2 = -1;
                    }
                    i14 = i23;
                } else {
                    i16 = -1;
                    iZzb2 = -1;
                }
                if (zzfrVar.zzh()) {
                    zzfrVar.zzc();
                    zzfrVar.zzc();
                }
                if (zzfrVar.zzh()) {
                    zzfrVar.zzf(65);
                }
                zZzh3 = zzfrVar.zzh();
                if (zZzh3) {
                    zzo(zzfrVar);
                }
                zZzh4 = zzfrVar.zzh();
                if (zZzh4) {
                    zzo(zzfrVar);
                }
                if (zZzh3 || zZzh4) {
                    zzfrVar.zze();
                }
                zzfrVar.zze();
                if (zzfrVar.zzh()) {
                    zzfrVar.zze();
                    zzfrVar.zzc();
                    zzfrVar.zzc();
                    zzfrVar.zzc();
                    zzfrVar.zzc();
                    int iZzc15 = zzfrVar.zzc();
                    zzfrVar.zzc();
                    i15 = iZzc15;
                } else {
                    i15 = i13;
                }
                i17 = i14;
                f = f2;
            } else {
                i15 = i13;
                i16 = -1;
                i17 = -1;
                iZzb2 = -1;
                f = 1.0f;
            }
            return new zzfp(i12, iZza4, iZza5, iZzc5, iZzc8, i21, i22, f, iZzc2, iZzc3, zZzh, zZzh2, iZzc6, iZzc7, iZzc4, z, i16, i17, iZzb2, i15);
        }
        iZzc4 = zzfrVar.zzc() + 4;
        z = false;
        int iZzc16 = zzfrVar.zzc();
        zzfrVar.zze();
        int iZzc17 = zzfrVar.zzc() + 1;
        int iZzc18 = zzfrVar.zzc() + 1;
        zZzh2 = zzfrVar.zzh();
        i9 = 2 - (zZzh2 ? 1 : 0);
        if (!zZzh2) {
            zzfrVar.zze();
        }
        zzfrVar.zze();
        i10 = iZzc17 * 16;
        i11 = iZzc18 * i9 * 16;
        if (zzfrVar.zzh()) {
            int iZzc19 = zzfrVar.zzc();
            int iZzc110 = zzfrVar.zzc();
            int iZzc111 = zzfrVar.zzc();
            int iZzc112 = zzfrVar.zzc();
            if (iZzc == 0) {
                i18 = 1;
            } else {
                if (iZzc == 3) {
                    i18 = 1;
                } else {
                    i18 = 2;
                }
                if (iZzc == 1) {
                    i19 = 2;
                } else {
                    i19 = 1;
                }
                i9 *= i19;
            }
            i10 -= (iZzc19 + iZzc110) * i18;
            i11 -= (iZzc111 + iZzc112) * i9;
        }
        int i24 = i10;
        int i25 = i11;
        if (iZza3 != 44) {
            if ((iZza4 & 16) != 0) {
                i12 = iZza3;
                i13 = 0;
            } else {
                i12 = iZza3;
                i13 = 16;
            }
        } else if ((iZza4 & 16) != 0) {
            i12 = iZza3;
            i13 = 0;
        } else {
            i12 = iZza3;
            i13 = 16;
        }
        i14 = -1;
        if (zzfrVar.zzh()) {
            if (zzfrVar.zzh()) {
                f2 = 1.0f;
            } else {
                iZza = zzfrVar.zza(8);
                if (iZza == 255) {
                    iZza2 = zzfrVar.zza(16);
                    int iZza10 = zzfrVar.zza(16);
                    if (iZza2 != 0) {
                        f2 = 1.0f;
                    } else {
                        f2 = 1.0f;
                    }
                } else if (iZza < 17) {
                    f2 = zzb[iZza];
                } else {
                    zzdx.zzf("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + iZza);
                    f2 = 1.0f;
                }
            }
            if (zzfrVar.zzh()) {
                zzfrVar.zze();
            }
            if (zzfrVar.zzh()) {
                zzfrVar.zzf(3);
                if (true != zzfrVar.zzh()) {
                }
                if (zzfrVar.zzh()) {
                    int iZza11 = zzfrVar.zza(8);
                    int iZza12 = zzfrVar.zza(8);
                    zzfrVar.zzf(8);
                    int iZza13 = zzk.zza(iZza11);
                    iZzb2 = zzk.zzb(iZza12);
                    i16 = iZza13;
                } else {
                    i16 = -1;
                    iZzb2 = -1;
                }
                i14 = i23;
            } else {
                i16 = -1;
                iZzb2 = -1;
            }
            if (zzfrVar.zzh()) {
                zzfrVar.zzc();
                zzfrVar.zzc();
            }
            if (zzfrVar.zzh()) {
                zzfrVar.zzf(65);
            }
            zZzh3 = zzfrVar.zzh();
            if (zZzh3) {
                zzo(zzfrVar);
            }
            zZzh4 = zzfrVar.zzh();
            if (zZzh4) {
                zzo(zzfrVar);
            }
            if (zZzh3) {
                zzfrVar.zze();
            } else {
                zzfrVar.zze();
            }
            zzfrVar.zze();
            if (zzfrVar.zzh()) {
                zzfrVar.zze();
                zzfrVar.zzc();
                zzfrVar.zzc();
                zzfrVar.zzc();
                zzfrVar.zzc();
                int iZzc113 = zzfrVar.zzc();
                zzfrVar.zzc();
                i15 = iZzc113;
            } else {
                i15 = i13;
            }
            i17 = i14;
            f = f2;
        } else {
            i15 = i13;
            i16 = -1;
            i17 = -1;
            iZzb2 = -1;
            f = 1.0f;
        }
        return new zzfp(i12, iZza4, iZza5, iZzc5, iZzc16, i24, i25, f, iZzc2, iZzc3, zZzh, zZzh2, iZzc6, iZzc7, iZzc4, z, i16, i17, iZzb2, i15);
    }

    public static String zzh(List list) {
        for (int i = 0; i < list.size(); i++) {
            byte[] bArr = (byte[]) list.get(i);
            int length = bArr.length;
            if (length > 3) {
                boolean[] zArr = new boolean[3];
                int i2 = zzfww.zzd;
                zzfwt zzfwtVar = new zzfwt();
                int i3 = 0;
                while (true) {
                    int length2 = bArr.length;
                    if (i3 >= length2) {
                        break;
                    }
                    int iZza = zza(bArr, i3, length2, zArr);
                    if (iZza != length2) {
                        zzfwtVar.zzf(Integer.valueOf(iZza));
                    }
                    i3 = iZza + 3;
                }
                zzfww zzfwwVarZzi = zzfwtVar.zzi();
                for (int i4 = 0; i4 < zzfwwVarZzi.size(); i4++) {
                    if (((Integer) zzfwwVarZzi.get(i4)).intValue() + 3 < length) {
                        zzfr zzfrVar = new zzfr(bArr, ((Integer) zzfwwVarZzi.get(i4)).intValue() + 3, length);
                        zzfe zzfeVarZzm = zzm(zzfrVar);
                        if (zzfeVarZzm.zza == 33 && zzfeVarZzm.zzb == 0) {
                            zzfrVar.zzf(4);
                            int iZza2 = zzfrVar.zza(3);
                            zzfrVar.zze();
                            zzff zzffVarZzn = zzn(zzfrVar, true, iZza2, null);
                            return zzdh.zzd(zzffVarZzn.zza, zzffVarZzn.zzb, zzffVarZzn.zzc, zzffVarZzn.zzd, zzffVarZzn.zze, zzffVarZzn.zzf);
                        }
                    }
                }
            }
        }
        return null;
    }

    public static void zzi(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static boolean zzj(byte[] bArr, int i, int i2, zzz zzzVar) {
        int i3;
        String str = zzzVar.zzo;
        if (Objects.equals(str, "video/avc")) {
            byte b = bArr[4];
            if (((b & 96) >> 5) == 0 && ((i3 = b & Ascii.US) == 1 || i3 == 9 || i3 == 14)) {
                return false;
            }
        } else if (Objects.equals(str, "video/hevc")) {
            zzfe zzfeVarZzm = zzm(new zzfr(bArr, 4, i2 + 4));
            int i4 = zzfeVarZzm.zza;
            if (i4 == 35) {
                return false;
            }
            if (i4 <= 14 && i4 % 2 == 0 && zzfeVarZzm.zzc == zzzVar.zzD - 1) {
                return false;
            }
        }
        return true;
    }

    private static int zzk(int i, int i2, int i3, int i4) {
        return i - ((i2 == 1 ? 2 : 1) * (i3 + i4));
    }

    private static int zzl(int i, int i2, int i3, int i4) {
        int i5 = 2;
        if (i2 != 1 && i2 != 2) {
            i5 = 1;
        }
        return i - (i5 * (i3 + i4));
    }

    private static zzfe zzm(zzfr zzfrVar) {
        zzfrVar.zze();
        return new zzfe(zzfrVar.zza(6), zzfrVar.zza(6), zzfrVar.zza(3) - 1);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x005c  */
    /* JADX WARN: Code duplicated, block: B:23:0x0062  */
    /* JADX WARN: Code duplicated, block: B:26:0x006a  */
    /* JADX WARN: Code duplicated, block: B:30:0x0074  */
    /* JADX WARN: Code duplicated, block: B:39:0x006c A[SYNTHETIC] */
    private static zzff zzn(zzfr zzfrVar, boolean z, int i, zzff zzffVar) {
        int[] iArr;
        int i2;
        boolean z2;
        int i3;
        int i4;
        boolean zZzh;
        int iZza;
        int i5;
        int i6;
        int[] iArr2 = new int[6];
        if (!z) {
            if (zzffVar != null) {
                int i7 = zzffVar.zza;
                zZzh = zzffVar.zzb;
                iZza = zzffVar.zzc;
                i5 = zzffVar.zzd;
                iArr2 = zzffVar.zze;
                i2 = i7;
            } else {
                iArr = iArr2;
                i2 = 0;
                z2 = false;
                i3 = 0;
                i4 = 0;
            }
            int iZza2 = zzfrVar.zza(8);
            i6 = 0;
            for (int i8 = 0; i8 < i; i8++) {
                if (zzfrVar.zzh()) {
                    i6 += 88;
                }
                if (zzfrVar.zzh()) {
                    i6 += 8;
                }
            }
            zzfrVar.zzf(i6);
            if (i > 0) {
                int i9 = 8 - i;
                zzfrVar.zzf(i9 + i9);
            }
            return new zzff(i2, z2, i3, i4, iArr, iZza2);
        }
        int iZza3 = zzfrVar.zza(2);
        zZzh = zzfrVar.zzh();
        iZza = zzfrVar.zza(5);
        i5 = 0;
        for (int i10 = 0; i10 < 32; i10++) {
            if (zzfrVar.zzh()) {
                i5 |= 1 << i10;
            }
        }
        for (int i11 = 0; i11 < 6; i11++) {
            iArr2[i11] = zzfrVar.zza(8);
        }
        i2 = iZza3;
        iArr = iArr2;
        z2 = zZzh;
        i3 = iZza;
        i4 = i5;
        int iZza4 = zzfrVar.zza(8);
        i6 = 0;
        while (i8 < i) {
            if (zzfrVar.zzh()) {
                i6 += 88;
            }
            if (zzfrVar.zzh()) {
                i6 += 8;
            }
        }
        zzfrVar.zzf(i6);
        if (i > 0) {
            int i12 = 8 - i;
            zzfrVar.zzf(i12 + i12);
        }
        return new zzff(i2, z2, i3, i4, iArr, iZza4);
    }

    private static void zzo(zzfr zzfrVar) {
        int iZzc = zzfrVar.zzc() + 1;
        zzfrVar.zzf(8);
        for (int i = 0; i < iZzc; i++) {
            zzfrVar.zzc();
            zzfrVar.zzc();
            zzfrVar.zze();
        }
        zzfrVar.zzf(20);
    }

    public static int zzc(byte[] bArr, int i) {
        int i2;
        synchronized (zzc) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                while (true) {
                    try {
                        if (i3 >= i - 2) {
                            i3 = i;
                            break;
                        }
                        int i5 = i3 + 1;
                        if (bArr[i3] == 0 && bArr[i5] == 0 && bArr[i3 + 2] == 3) {
                            break;
                        }
                        i3 = i5;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (i3 < i) {
                    int[] iArr = zzd;
                    int length = iArr.length;
                    if (length <= i4) {
                        zzd = Arrays.copyOf(iArr, length + length);
                    }
                    zzd[i4] = i3;
                    i3 += 3;
                    i4++;
                }
            }
            i2 = i - i4;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < i4; i8++) {
                int i9 = zzd[i8] - i6;
                System.arraycopy(bArr, i6, bArr, i7, i9);
                int i10 = i7 + i9;
                int i11 = i10 + 1;
                bArr[i10] = 0;
                i7 = i10 + 2;
                bArr[i11] = 0;
                i6 += i9 + 3;
            }
            System.arraycopy(bArr, i6, bArr, i7, i2 - i7);
        }
        return i2;
    }
}
