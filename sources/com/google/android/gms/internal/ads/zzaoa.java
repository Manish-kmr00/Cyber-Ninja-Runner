package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.math.RoundingMode;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaoa implements zzanz {
    private final zzadf zza;
    private final zzaei zzb;
    private final zzaoc zzc;
    private final zzz zzd;
    private final int zze;
    private long zzf;
    private int zzg;
    private long zzh;

    public zzaoa(zzadf zzadfVar, zzaei zzaeiVar, zzaoc zzaocVar, String str, int i) throws zzaz {
        this.zza = zzadfVar;
        this.zzb = zzaeiVar;
        this.zzc = zzaocVar;
        int i2 = zzaocVar.zzb * zzaocVar.zze;
        int i3 = zzaocVar.zzd;
        int i4 = i2 / 8;
        if (i3 != i4) {
            throw zzaz.zza("Expected block size: " + i4 + "; got: " + i3, null);
        }
        int i5 = zzaocVar.zzc * i4;
        int i6 = i5 * 8;
        int iMax = Math.max(i4, i5 / 10);
        this.zze = iMax;
        zzx zzxVar = new zzx();
        zzxVar.zzE("audio/wav");
        zzxVar.zzad(str);
        zzxVar.zzA(i6);
        zzxVar.zzY(i6);
        zzxVar.zzT(iMax);
        zzxVar.zzB(zzaocVar.zzb);
        zzxVar.zzae(zzaocVar.zzc);
        zzxVar.zzX(i);
        this.zzd = zzxVar.zzaj();
    }

    @Override // com.google.android.gms.internal.ads.zzanz
    public final void zza(int i, long j) {
        zzaof zzaofVar = new zzaof(this.zzc, 1, i, j);
        this.zza.zzP(zzaofVar);
        zzaei zzaeiVar = this.zzb;
        zzaeiVar.zzm(this.zzd);
        zzaeiVar.zzl(zzaofVar.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzanz
    public final void zzb(long j) {
        this.zzf = j;
        this.zzg = 0;
        this.zzh = 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzanz
    public final boolean zzc(zzadd zzaddVar, long j) throws IOException {
        int i;
        int i2;
        long j2 = j;
        while (j2 > 0 && (i = this.zzg) < (i2 = this.zze)) {
            int iZzf = this.zzb.zzf(zzaddVar, (int) Math.min(i2 - i, j2), true);
            if (iZzf == -1) {
                j2 = 0;
            } else {
                this.zzg += iZzf;
                j2 -= (long) iZzf;
            }
        }
        zzaoc zzaocVar = this.zzc;
        int i3 = this.zzg;
        int i4 = zzaocVar.zzd;
        int i5 = i3 / i4;
        if (i5 > 0) {
            long jZzu = this.zzf + zzeu.zzu(this.zzh, 1000000L, zzaocVar.zzc, RoundingMode.DOWN);
            int i6 = i5 * i4;
            int i7 = this.zzg - i6;
            this.zzb.zzt(jZzu, 1, i6, i7, null);
            this.zzh += (long) i5;
            this.zzg = i7;
        }
        return j2 <= 0;
    }
}
