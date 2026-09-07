package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaoe {
    public static Pair zza(zzadd zzaddVar) throws IOException {
        zzaddVar.zzj();
        zzaod zzaodVarZzd = zzd(1684108385, zzaddVar, new zzek(8));
        zzaddVar.zzk(8);
        return Pair.create(Long.valueOf(zzaddVar.zzf()), Long.valueOf(zzaodVarZzd.zzb));
    }

    public static zzaoc zzb(zzadd zzaddVar) throws IOException {
        byte[] bArr;
        zzek zzekVar = new zzek(16);
        long j = zzd(1718449184, zzaddVar, zzekVar).zzb;
        zzdc.zzf(j >= 16);
        zzaddVar.zzh(zzekVar.zzN(), 0, 16);
        zzekVar.zzL(0);
        int iZzk = zzekVar.zzk();
        int iZzk2 = zzekVar.zzk();
        int iZzj = zzekVar.zzj();
        int iZzj2 = zzekVar.zzj();
        int iZzk3 = zzekVar.zzk();
        int iZzk4 = zzekVar.zzk();
        int i = ((int) j) - 16;
        if (i > 0) {
            byte[] bArr2 = new byte[i];
            zzaddVar.zzh(bArr2, 0, i);
            bArr = bArr2;
        } else {
            bArr = zzeu.zzc;
        }
        zzaddVar.zzk((int) (zzaddVar.zze() - zzaddVar.zzf()));
        return new zzaoc(iZzk, iZzk2, iZzj, iZzj2, iZzk3, iZzk4, bArr);
    }

    public static boolean zzc(zzadd zzaddVar) throws IOException {
        zzek zzekVar = new zzek(8);
        int i = zzaod.zza(zzaddVar, zzekVar).zza;
        if (i != 1380533830 && i != 1380333108) {
            return false;
        }
        zzaddVar.zzh(zzekVar.zzN(), 0, 4);
        zzekVar.zzL(0);
        int iZzg = zzekVar.zzg();
        if (iZzg == 1463899717) {
            return true;
        }
        zzdx.zzc("WavHeaderReader", "Unsupported form type: " + iZzg);
        return false;
    }

    private static zzaod zzd(int i, zzadd zzaddVar, zzek zzekVar) throws IOException {
        zzaod zzaodVarZza = zzaod.zza(zzaddVar, zzekVar);
        while (true) {
            int i2 = zzaodVarZza.zza;
            if (i2 == i) {
                return zzaodVarZza;
            }
            zzdx.zzf("WavHeaderReader", "Ignoring unknown WAV chunk: " + i2);
            long j = zzaodVarZza.zzb;
            long j2 = 8 + j;
            if ((1 & j) != 0) {
                j2 = 9 + j;
            }
            if (j2 > 2147483647L) {
                throw zzaz.zzc("Chunk is too large (~2GB+) to skip; id: " + i2);
            }
            zzaddVar.zzk((int) j2);
            zzaodVarZza = zzaod.zza(zzaddVar, zzekVar);
        }
    }
}
