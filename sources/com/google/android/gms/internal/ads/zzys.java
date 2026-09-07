package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public abstract class zzys extends zzyv {
    protected abstract Pair zzd(zzyr zzyrVar, int[][][] iArr, int[] iArr2, zzuy zzuyVar, zzbl zzblVar) throws zzii;

    @Override // com.google.android.gms.internal.ads.zzyv
    public final zzyw zzo(zzlx[] zzlxVarArr, zzxd zzxdVar, zzuy zzuyVar, zzbl zzblVar) throws zzii {
        List[] listArr;
        boolean z;
        int[] iArr;
        int[] iArr2 = new int[3];
        zzbm[][] zzbmVarArr = new zzbm[3][];
        int[][][] iArr3 = new int[3][][];
        for (int i = 0; i < 3; i++) {
            int i2 = zzxdVar.zzb;
            zzbmVarArr[i] = new zzbm[i2];
            iArr3[i] = new int[i2][];
        }
        int i3 = 2;
        int[] iArr4 = new int[2];
        for (int i4 = 0; i4 < 2; i4++) {
            iArr4[i4] = zzlxVarArr[i4].zze();
        }
        int i5 = 0;
        while (i5 < zzxdVar.zzb) {
            zzbm zzbmVarZzb = zzxdVar.zzb(i5);
            int i6 = zzbmVarZzb.zzc;
            int i7 = i3;
            int i8 = 0;
            int i9 = 0;
            boolean z2 = true;
            while (i8 < i3) {
                zzlx zzlxVar = zzlxVarArr[i8];
                int iMax = 0;
                for (int i10 = 0; i10 < zzbmVarZzb.zza; i10++) {
                    iMax = Math.max(iMax, zzlxVar.zzY(zzbmVarZzb.zzb(i10)) & 7);
                }
                boolean z3 = iArr2[i8] == 0;
                if (iMax > i9) {
                    z2 = z3;
                    i7 = i8;
                    i9 = iMax;
                } else if (iMax == i9 && i6 == 5 && !z2 && z3) {
                    i7 = i8;
                    i9 = iMax;
                    z2 = true;
                }
                i8++;
                i3 = 2;
            }
            if (i7 == i3) {
                iArr = new int[zzbmVarZzb.zza];
            } else {
                zzlx zzlxVar2 = zzlxVarArr[i7];
                int i11 = zzbmVarZzb.zza;
                int[] iArr5 = new int[i11];
                for (int i12 = 0; i12 < i11; i12++) {
                    iArr5[i12] = zzlxVar2.zzY(zzbmVarZzb.zzb(i12));
                }
                iArr = iArr5;
            }
            int i13 = iArr2[i7];
            zzbmVarArr[i7][i13] = zzbmVarZzb;
            iArr3[i7][i13] = iArr;
            iArr2[i7] = i13 + 1;
            i5++;
            i3 = 2;
        }
        int i14 = i3;
        boolean z4 = true;
        zzxd[] zzxdVarArr = new zzxd[i14];
        String[] strArr = new String[i14];
        int[] iArr6 = new int[i14];
        int i15 = 0;
        while (i15 < i14) {
            int i16 = iArr2[i15];
            zzxdVarArr[i15] = new zzxd((zzbm[]) zzeu.zzQ(zzbmVarArr[i15], i16));
            iArr3[i15] = (int[][]) zzeu.zzQ(iArr3[i15], i16);
            strArr[i15] = zzlxVarArr[i15].zzU();
            iArr6[i15] = zzlxVarArr[i15].zzb();
            i15++;
            i14 = 2;
        }
        int i17 = i14;
        zzyr zzyrVar = new zzyr(strArr, iArr6, zzxdVarArr, iArr4, iArr3, new zzxd((zzbm[]) zzeu.zzQ(zzbmVarArr[i17], iArr2[i17])));
        Pair pairZzd = zzd(zzyrVar, iArr3, iArr4, zzuyVar, zzblVar);
        zzyt[] zzytVarArr = (zzyt[]) pairZzd.second;
        List[] listArr2 = new List[zzytVarArr.length];
        for (int i18 = 0; i18 < zzytVarArr.length; i18++) {
            zzyt zzytVar = zzytVarArr[i18];
            listArr2[i18] = zzytVar != null ? zzfww.zzo(zzytVar) : zzfww.zzn();
        }
        zzfwt zzfwtVar = new zzfwt();
        int i19 = 0;
        while (i19 < 2) {
            zzxd zzxdVarZzd = zzyrVar.zzd(i19);
            List list = listArr2[i19];
            int i20 = 0;
            while (i20 < zzxdVarZzd.zzb) {
                zzbm zzbmVarZzb2 = zzxdVarZzd.zzb(i20);
                boolean z5 = zzyrVar.zza(i19, i20, false) != 0 ? z4 : false;
                int i21 = zzbmVarZzb2.zza;
                int[] iArr7 = new int[i21];
                boolean[] zArr = new boolean[i21];
                int i22 = 0;
                while (i22 < i21) {
                    iArr7[i22] = zzyrVar.zzb(i19, i20, i22) & 7;
                    int i23 = 0;
                    while (true) {
                        if (i23 >= list.size()) {
                            listArr = listArr2;
                            z = false;
                            break;
                        }
                        zzyt zzytVar2 = (zzyt) list.get(i23);
                        listArr = listArr2;
                        if (zzytVar2.zzg().equals(zzbmVarZzb2) && zzytVar2.zzc(i22) != -1) {
                            z = true;
                            break;
                        }
                        i23++;
                        listArr2 = listArr;
                    }
                    zArr[i22] = z;
                    i22++;
                    listArr2 = listArr;
                }
                zzfwtVar.zzf(new zzbs(zzbmVarZzb2, z5, iArr7, zArr));
                i20++;
                z4 = true;
            }
            i19++;
            z4 = true;
        }
        zzxd zzxdVarZze = zzyrVar.zze();
        for (int i24 = 0; i24 < zzxdVarZze.zzb; i24++) {
            zzbm zzbmVarZzb3 = zzxdVarZze.zzb(i24);
            int i25 = zzbmVarZzb3.zza;
            int[] iArr8 = new int[i25];
            Arrays.fill(iArr8, 0);
            zzfwtVar.zzf(new zzbs(zzbmVarZzb3, false, iArr8, new boolean[i25]));
        }
        return new zzyw((zzly[]) pairZzd.first, (zzyp[]) pairZzd.second, new zzbt(zzfwtVar.zzi()), zzyrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzyv
    public final void zzp(Object obj) {
    }
}
