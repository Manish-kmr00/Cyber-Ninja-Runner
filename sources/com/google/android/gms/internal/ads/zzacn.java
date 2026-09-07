package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public class zzacn {
    protected final zzach zza;
    protected final zzacm zzb;
    protected zzacj zzc;
    private final int zzd;

    protected zzacn(zzack zzackVar, zzacm zzacmVar, long j, long j2, long j3, long j4, long j5, long j6, int i) {
        this.zzb = zzacmVar;
        this.zzd = i;
        this.zza = new zzach(zzackVar, j, 0L, j3, j4, j5, j6);
    }

    protected static final int zzf(zzadd zzaddVar, long j, zzady zzadyVar) {
        if (j == zzaddVar.zzf()) {
            return 0;
        }
        zzadyVar.zza = j;
        return 1;
    }

    protected static final boolean zzg(zzadd zzaddVar, long j) throws IOException {
        long jZzf = j - zzaddVar.zzf();
        if (jZzf < 0 || jZzf > PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            return false;
        }
        zzaddVar.zzk((int) jZzf);
        return true;
    }

    public final int zza(zzadd zzaddVar, zzady zzadyVar) throws IOException {
        while (true) {
            zzacj zzacjVar = this.zzc;
            zzdc.zzb(zzacjVar);
            long j = zzacjVar.zzf;
            long j2 = zzacjVar.zzg;
            long j3 = zzacjVar.zzh;
            if (j2 - j <= this.zzd) {
                zzc(false, j);
                return zzf(zzaddVar, j, zzadyVar);
            }
            if (!zzg(zzaddVar, j3)) {
                return zzf(zzaddVar, j3, zzadyVar);
            }
            zzaddVar.zzj();
            zzacl zzaclVarZza = this.zzb.zza(zzaddVar, zzacjVar.zzb);
            int i = zzaclVarZza.zzb;
            if (i == -3) {
                zzc(false, j3);
                return zzf(zzaddVar, j3, zzadyVar);
            }
            if (i == -2) {
                zzacj.zzh(zzacjVar, zzaclVarZza.zzc, zzaclVarZza.zzd);
            } else {
                if (i != -1) {
                    zzg(zzaddVar, zzaclVarZza.zzd);
                    zzc(true, zzaclVarZza.zzd);
                    return zzf(zzaddVar, zzaclVarZza.zzd, zzadyVar);
                }
                zzacj.zzg(zzacjVar, zzaclVarZza.zzc, zzaclVarZza.zzd);
            }
        }
    }

    public final zzaeb zzb() {
        return this.zza;
    }

    protected final void zzc(boolean z, long j) {
        this.zzc = null;
        this.zzb.zzb();
    }

    public final void zzd(long j) {
        zzacj zzacjVar = this.zzc;
        if (zzacjVar == null || zzacjVar.zza != j) {
            zzach zzachVar = this.zza;
            this.zzc = new zzacj(j, zzachVar.zzf(j), 0L, zzachVar.zzc, zzachVar.zzd, zzachVar.zze, zzachVar.zzf);
        }
    }

    public final boolean zze() {
        return this.zzc != null;
    }
}
