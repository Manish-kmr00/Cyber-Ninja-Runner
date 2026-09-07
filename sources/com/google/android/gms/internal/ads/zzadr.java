package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzadr {
    public final List zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final float zzj;
    public final int zzk;
    public final String zzl;
    public final zzfn zzm;

    private zzadr(List list, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, float f, int i11, String str, zzfn zzfnVar) {
        this.zza = list;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i5;
        this.zze = i6;
        this.zzf = i7;
        this.zzg = i8;
        this.zzh = i9;
        this.zzi = i10;
        this.zzj = f;
        this.zzk = i11;
        this.zzl = str;
        this.zzm = zzfnVar;
    }

    public static zzadr zza(zzek zzekVar) throws zzaz {
        return zzc(zzekVar, false, null);
    }

    public static zzadr zzb(zzek zzekVar, zzfn zzfnVar) throws zzaz {
        return zzc(zzekVar, true, zzfnVar);
    }

    /* JADX WARN: Code duplicated, block: B:114:0x0298  */
    /* JADX WARN: Code duplicated, block: B:115:0x029b  */
    private static zzadr zzc(zzek zzekVar, boolean z, zzfn zzfnVar) throws zzaz {
        boolean z2;
        String str;
        int i;
        int i2;
        zzfj zzfjVar;
        int i3;
        int i4 = 4;
        if (z) {
            try {
                zzekVar.zzM(4);
            } catch (ArrayIndexOutOfBoundsException e) {
                e = e;
                z2 = true;
                if (z2 != z) {
                    str = "HEVC config";
                } else {
                    str = "L-HEVC config";
                }
                throw zzaz.zza("Error parsing".concat(str), e);
            }
        } else {
            try {
                zzekVar.zzM(21);
            } catch (ArrayIndexOutOfBoundsException e2) {
                e = e2;
                z2 = true;
                if (z2 != z) {
                    str = "HEVC config";
                } else {
                    str = "L-HEVC config";
                }
                throw zzaz.zza("Error parsing".concat(str), e);
            }
        }
        int iZzm = zzekVar.zzm() & 3;
        int iZzm2 = zzekVar.zzm();
        int iZzc = zzekVar.zzc();
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < iZzm2; i7++) {
            zzekVar.zzM(1);
            int iZzq = zzekVar.zzq();
            for (int i8 = 0; i8 < iZzq; i8++) {
                int iZzq2 = zzekVar.zzq();
                i6 += iZzq2 + 4;
                zzekVar.zzM(iZzq2);
            }
        }
        zzekVar.zzL(iZzc);
        byte[] bArr = new byte[i6];
        zzfn zzfnVar2 = zzfnVar;
        int i9 = 0;
        float f = 1.0f;
        int i10 = -1;
        int i11 = -1;
        int i12 = -1;
        int i13 = -1;
        int i14 = -1;
        int i15 = -1;
        int i16 = -1;
        int i17 = -1;
        int i18 = -1;
        int i19 = -1;
        String strZzd = null;
        int i20 = 0;
        while (i20 < iZzm2) {
            int iZzm3 = zzekVar.zzm() & 63;
            int iZzq3 = zzekVar.zzq();
            int i21 = i5;
            zzfn zzfnVarZze = zzfnVar2;
            while (i21 < iZzq3) {
                int iZzq4 = zzekVar.zzq();
                int i22 = iZzm2;
                System.arraycopy(zzfq.zza, i5, bArr, i9, i4);
                int i23 = i9 + 4;
                System.arraycopy(zzekVar.zzN(), zzekVar.zzc(), bArr, i23, iZzq4);
                int i24 = 32;
                if (iZzm3 == 32) {
                    if (i21 == 0) {
                        zzfnVarZze = zzfq.zze(bArr, i23, i23 + iZzq4);
                        i = iZzq3;
                        iZzm3 = iZzm3;
                        i3 = 0;
                        i21 = 0;
                    }
                    i9 = i23 + iZzq4;
                    zzekVar.zzM(iZzq4);
                    i21++;
                    i5 = i3;
                    iZzm2 = i22;
                    iZzq3 = i;
                    iZzm3 = iZzm3;
                    i4 = 4;
                } else {
                    i24 = iZzm3;
                }
                i = iZzq3;
                int i25 = 8;
                if (i24 != 33) {
                    iZzm3 = iZzm3;
                    if (i24 == 39 && i21 == 0) {
                        int i26 = i9 + 6;
                        int i27 = (i23 + iZzq4) - 1;
                        while (true) {
                            byte b = bArr[i27];
                            if (b != 0) {
                                if (b != 0 && i27 > i26) {
                                    zzfr zzfrVar = new zzfr(bArr, i26, i27 + 1);
                                    while (true) {
                                        if (zzfrVar.zzg(16)) {
                                            int iZza = zzfrVar.zza(i25);
                                            int i28 = 0;
                                            while (iZza == 255) {
                                                i28 += 255;
                                                iZza = zzfrVar.zza(i25);
                                            }
                                            int i29 = i28 + iZza;
                                            int iZza2 = zzfrVar.zza(i25);
                                            int i30 = 0;
                                            while (iZza2 == 255) {
                                                i30 += 255;
                                                iZza2 = zzfrVar.zza(8);
                                            }
                                            int i31 = i30 + iZza2;
                                            if (i31 != 0 && zzfrVar.zzg(i31)) {
                                                if (i29 == 176) {
                                                    int iZzc2 = zzfrVar.zzc();
                                                    boolean zZzh = zzfrVar.zzh();
                                                    int iZzc3 = zZzh ? zzfrVar.zzc() : 0;
                                                    int iZzc4 = zzfrVar.zzc();
                                                    int i32 = 0;
                                                    int iZzc5 = -1;
                                                    int iZzc6 = -1;
                                                    int i33 = -1;
                                                    int iZza3 = -1;
                                                    int i34 = -1;
                                                    int iZza4 = -1;
                                                    while (true) {
                                                        if (i32 <= iZzc4) {
                                                            iZzc5 = zzfrVar.zzc();
                                                            iZzc6 = zzfrVar.zzc();
                                                            i2 = i21;
                                                            int iZza5 = zzfrVar.zza(6);
                                                            if (iZza5 != 63) {
                                                                iZza3 = zzfrVar.zza(iZza5 == 0 ? Math.max(0, iZzc2 - 30) : Math.max(0, (iZza5 + iZzc2) - 31));
                                                                if (zZzh) {
                                                                    int iZza6 = zzfrVar.zza(6);
                                                                    if (iZza6 != 63) {
                                                                        iZza4 = zzfrVar.zza(iZza6 == 0 ? Math.max(0, iZzc3 - 30) : Math.max(0, (iZza6 + iZzc3) - 31));
                                                                        i34 = iZza6;
                                                                    }
                                                                } else {
                                                                    zZzh = zZzh;
                                                                }
                                                                if (zzfrVar.zzh()) {
                                                                    zzfrVar.zzf(10);
                                                                }
                                                                i32++;
                                                                i33 = iZza5;
                                                                i21 = i2;
                                                                zZzh = zZzh;
                                                                i10 = i10;
                                                            }
                                                            zzfjVar = null;
                                                        } else {
                                                            i2 = i21;
                                                            i10 = i10;
                                                            zzfjVar = new zzfj(iZzc2, iZzc3, iZzc4 + 1, iZzc5, iZzc6, i33, iZza3, i34, iZza4);
                                                        }
                                                    }
                                                } else {
                                                    i25 = 8;
                                                }
                                            }
                                            i10 = i10;
                                            zzfjVar = null;
                                        }
                                    }
                                }
                                if (zzfjVar == null && zzfnVarZze != null) {
                                    i3 = 0;
                                    if (zzfjVar.zza == ((zzfd) zzfnVarZze.zza.get(0)).zzb) {
                                        i21 = i2;
                                        i10 = i10;
                                        i18 = 4;
                                    } else {
                                        i18 = 5;
                                    }
                                }
                                i21 = i2;
                                i10 = i10;
                            } else if (i27 > i26) {
                                i27--;
                            }
                            i2 = i21;
                            i10 = i10;
                            zzfjVar = null;
                            if (zzfjVar == null) {
                            }
                        }
                    } else {
                        i2 = i21;
                        i10 = i10;
                    }
                    i3 = 0;
                    i21 = i2;
                    i10 = i10;
                } else if (i21 == 0) {
                    zzfk zzfkVarZzd = zzfq.zzd(bArr, i23, i23 + iZzq4, zzfnVarZze);
                    int i35 = zzfkVarZzd.zza + 1;
                    int i36 = zzfkVarZzd.zze;
                    int i37 = zzfkVarZzd.zzf;
                    int i38 = zzfkVarZzd.zzc + 8;
                    int i39 = zzfkVarZzd.zzd + 8;
                    int i40 = zzfkVarZzd.zzi;
                    int i41 = zzfkVarZzd.zzj;
                    int i42 = zzfkVarZzd.zzk;
                    float f2 = zzfkVarZzd.zzg;
                    int i43 = zzfkVarZzd.zzh;
                    zzff zzffVar = zzfkVarZzd.zzb;
                    if (zzffVar != null) {
                        strZzd = zzdh.zzd(zzffVar.zza, zzffVar.zzb, zzffVar.zzc, zzffVar.zzd, zzffVar.zze, zzffVar.zzf);
                    }
                    i10 = i35;
                    i11 = i36;
                    i3 = 0;
                    i19 = i43;
                    i17 = i42;
                    i15 = i40;
                    f = f2;
                    i16 = i41;
                    i14 = i39;
                    i13 = i38;
                    i12 = i37;
                } else {
                    iZzm3 = iZzm3;
                    i2 = i21;
                    i10 = i10;
                    i3 = 0;
                    i21 = i2;
                    i10 = i10;
                }
                i9 = i23 + iZzq4;
                zzekVar.zzM(iZzq4);
                i21++;
                i5 = i3;
                iZzm2 = i22;
                iZzq3 = i;
                iZzm3 = iZzm3;
                i4 = 4;
            }
            i20++;
            zzfnVar2 = zzfnVarZze;
            i4 = 4;
        }
        return new zzadr(i6 == 0 ? Collections.emptyList() : Collections.singletonList(bArr), iZzm + 1, i10, i11, i12, i13, i14, i15, i16, i17, i18, f, i19, strZzd, zzfnVar2);
    }
}
