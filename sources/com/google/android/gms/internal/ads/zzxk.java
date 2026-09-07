package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzxk extends zzxm {
    protected zzxk(zzbm zzbmVar, int[] iArr, int i, zzzd zzzdVar, long j, long j2, long j3, int i2, int i3, float f, float f2, List list, zzdg zzdgVar) {
        super(zzbmVar, iArr, 0);
        zzfww.zzl(list);
    }

    static /* bridge */ /* synthetic */ zzfww zzh(zzyo[] zzyoVarArr) {
        int i;
        int i2;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i = 2;
            i2 = 1;
            if (i4 >= 2) {
                break;
            }
            zzyo zzyoVar = zzyoVarArr[i4];
            if (zzyoVar == null || zzyoVar.zzb.length <= 1) {
                arrayList.add(null);
            } else {
                int i5 = zzfww.zzd;
                zzfwt zzfwtVar = new zzfwt();
                zzfwtVar.zzf(new zzxi(0L, 0L));
                arrayList.add(zzfwtVar);
            }
            i4++;
        }
        long[][] jArr = new long[2][];
        for (int i6 = 0; i6 < 2; i6++) {
            zzyo zzyoVar2 = zzyoVarArr[i6];
            if (zzyoVar2 == null) {
                jArr[i6] = new long[0];
            } else {
                int[] iArr = zzyoVar2.zzb;
                jArr[i6] = new long[iArr.length];
                for (int i7 = 0; i7 < iArr.length; i7++) {
                    long j = zzyoVar2.zza.zzb(iArr[i7]).zzj;
                    long[] jArr2 = jArr[i6];
                    if (j == -1) {
                        j = 0;
                    }
                    jArr2[i7] = j;
                }
                Arrays.sort(jArr[i6]);
            }
        }
        int[] iArr2 = new int[2];
        long[] jArr3 = new long[2];
        for (int i8 = 0; i8 < 2; i8++) {
            long[] jArr4 = jArr[i8];
            jArr3[i8] = jArr4.length == 0 ? 0L : jArr4[0];
        }
        zzi(arrayList, jArr3);
        zzfxh zzfxhVarZza = zzfyc.zzc(zzfyh.zzc()).zzb(2).zza();
        int i9 = 0;
        while (i9 < i) {
            int length = jArr[i9].length;
            if (length > i2) {
                double[] dArr = new double[length];
                int i10 = i3;
                while (true) {
                    long[] jArr5 = jArr[i9];
                    double dLog = 0.0d;
                    if (i10 >= jArr5.length) {
                        break;
                    }
                    long j2 = jArr5[i10];
                    if (j2 != -1) {
                        dLog = Math.log(j2);
                    }
                    dArr[i10] = dLog;
                    i10++;
                }
                int i11 = length - 1;
                double d = dArr[i11] - dArr[i3];
                int i12 = i3;
                while (i12 < i11) {
                    double d2 = dArr[i12];
                    i12++;
                    zzfxhVarZza.zzq(Double.valueOf(d == 0.0d ? 1.0d : (((d2 + dArr[i12]) * 0.5d) - dArr[i3]) / d), Integer.valueOf(i9));
                    i3 = 0;
                }
            }
            i9++;
            i3 = 0;
            i = 2;
            i2 = 1;
        }
        zzfww zzfwwVarZzl = zzfww.zzl(zzfxhVarZza.zzr());
        for (int i13 = 0; i13 < zzfwwVarZzl.size(); i13++) {
            int iIntValue = ((Integer) zzfwwVarZzl.get(i13)).intValue();
            int i14 = iArr2[iIntValue] + 1;
            iArr2[iIntValue] = i14;
            jArr3[iIntValue] = jArr[iIntValue][i14];
            zzi(arrayList, jArr3);
        }
        for (int i15 = 0; i15 < 2; i15++) {
            if (arrayList.get(i15) != null) {
                long j3 = jArr3[i15];
                jArr3[i15] = j3 + j3;
            }
        }
        zzi(arrayList, jArr3);
        zzfwt zzfwtVar2 = new zzfwt();
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            zzfwt zzfwtVar3 = (zzfwt) arrayList.get(i16);
            zzfwtVar2.zzf(zzfwtVar3 == null ? zzfww.zzn() : zzfwtVar3.zzi());
        }
        return zzfwtVar2.zzi();
    }

    private static void zzi(List list, long[] jArr) {
        long j = 0;
        for (int i = 0; i < 2; i++) {
            j += jArr[i];
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzfwt zzfwtVar = (zzfwt) list.get(i2);
            if (zzfwtVar != null) {
                zzfwtVar.zzf(new zzxi(j, jArr[i2]));
            }
        }
    }
}
