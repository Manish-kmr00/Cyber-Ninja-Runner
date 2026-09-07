package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzafe implements zzacm {
    private final zzadn zza;
    private final int zzb;
    private final zzadi zzc = new zzadi();

    /* synthetic */ zzafe(zzadn zzadnVar, int i, zzaff zzaffVar) {
        this.zza = zzadnVar;
        this.zzb = i;
    }

    private final long zzc(zzadd zzaddVar) throws IOException {
        while (zzaddVar.zze() < zzaddVar.zzd() - 6) {
            zzadn zzadnVar = this.zza;
            int i = this.zzb;
            zzadi zzadiVar = this.zzc;
            long jZze = zzaddVar.zze();
            byte[] bArr = new byte[2];
            zzaddVar.zzh(bArr, 0, 2);
            if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i) {
                zzaddVar.zzj();
                zzaddVar.zzg((int) (jZze - zzaddVar.zzf()));
            } else {
                zzek zzekVar = new zzek(16);
                System.arraycopy(bArr, 0, zzekVar.zzN(), 0, 2);
                zzekVar.zzK(zzadg.zza(zzaddVar, zzekVar.zzN(), 2, 14));
                zzaddVar.zzj();
                zzaddVar.zzg((int) (jZze - zzaddVar.zzf()));
                if (zzadj.zzc(zzekVar, zzadnVar, i, zzadiVar)) {
                    break;
                }
            }
            zzaddVar.zzg(1);
        }
        if (zzaddVar.zze() < zzaddVar.zzd() - 6) {
            return this.zzc.zza;
        }
        zzaddVar.zzg((int) (zzaddVar.zzd() - zzaddVar.zze()));
        return this.zza.zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final zzacl zza(zzadd zzaddVar, long j) throws IOException {
        long jZzf = zzaddVar.zzf();
        long jZzc = zzc(zzaddVar);
        long jZze = zzaddVar.zze();
        zzaddVar.zzg(Math.max(6, this.zza.zzc));
        long jZzc2 = zzc(zzaddVar);
        long jZze2 = zzaddVar.zze();
        if (jZzc > j || jZzc2 <= j) {
            return jZzc2 <= j ? zzacl.zzf(jZzc2, jZze2) : zzacl.zzd(jZzc, jZzf);
        }
        return zzacl.zze(jZze);
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final /* synthetic */ void zzb() {
    }
}
