package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzanl implements zzacm {
    private final zzer zza;
    private final zzek zzb = new zzek();
    private final int zzc;

    public zzanl(int i, zzer zzerVar, int i2) {
        this.zzc = i;
        this.zza = zzerVar;
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final zzacl zza(zzadd zzaddVar, long j) throws IOException {
        int iZza;
        int iZza2;
        long jZzf = zzaddVar.zzf();
        int iMin = (int) Math.min(112800L, zzaddVar.zzd() - jZzf);
        zzek zzekVar = this.zzb;
        zzekVar.zzI(iMin);
        zzaddVar.zzh(zzekVar.zzN(), 0, iMin);
        int iZzd = zzekVar.zzd();
        long j2 = -1;
        long j3 = -9223372036854775807L;
        long j4 = -1;
        while (zzekVar.zza() >= 188 && (iZza2 = (iZza = zzanw.zza(zzekVar.zzN(), zzekVar.zzc(), iZzd)) + 188) <= iZzd) {
            long jZzb = zzanw.zzb(zzekVar, iZza, this.zzc);
            if (jZzb != -9223372036854775807L) {
                long jZzb2 = this.zza.zzb(jZzb);
                if (jZzb2 <= j) {
                    j4 = iZza;
                    if (100000 + jZzb2 <= j) {
                        j3 = jZzb2;
                    }
                } else if (j3 == -9223372036854775807L) {
                    return zzacl.zzd(jZzb2, jZzf);
                }
                return zzacl.zze(jZzf + j4);
            }
            zzekVar.zzL(iZza2);
            j2 = iZza2;
        }
        return j3 != -9223372036854775807L ? zzacl.zzf(j3, jZzf + j2) : zzacl.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final void zzb() {
        byte[] bArr = zzeu.zzc;
        int length = bArr.length;
        this.zzb.zzJ(bArr, 0);
    }
}
