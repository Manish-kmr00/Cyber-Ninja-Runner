package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzlm {
    private static final zzuy zzu = new zzuy(new Object(), -1);
    public final zzbl zza;
    public final zzuy zzb;
    public final long zzc;
    public final long zzd;
    public final int zze;
    public final zzii zzf;
    public final boolean zzg;
    public final zzxd zzh;
    public final zzyw zzi;
    public final List zzj;
    public final zzuy zzk;
    public final boolean zzl;
    public final int zzm;
    public final int zzn;
    public final zzbb zzo;
    public final boolean zzp = false;
    public volatile long zzq;
    public volatile long zzr;
    public volatile long zzs;
    public volatile long zzt;

    public zzlm(zzbl zzblVar, zzuy zzuyVar, long j, long j2, int i, zzii zziiVar, boolean z, zzxd zzxdVar, zzyw zzywVar, List list, zzuy zzuyVar2, boolean z2, int i2, int i3, zzbb zzbbVar, long j3, long j4, long j5, long j6, boolean z3) {
        this.zza = zzblVar;
        this.zzb = zzuyVar;
        this.zzc = j;
        this.zzd = j2;
        this.zze = i;
        this.zzf = zziiVar;
        this.zzg = z;
        this.zzh = zzxdVar;
        this.zzi = zzywVar;
        this.zzj = list;
        this.zzk = zzuyVar2;
        this.zzl = z2;
        this.zzm = i2;
        this.zzn = i3;
        this.zzo = zzbbVar;
        this.zzq = j3;
        this.zzr = j4;
        this.zzs = j5;
        this.zzt = j6;
    }

    public static zzlm zzh(zzyw zzywVar) {
        zzbl zzblVar = zzbl.zza;
        zzuy zzuyVar = zzu;
        return new zzlm(zzblVar, zzuyVar, -9223372036854775807L, 0L, 1, null, false, zzxd.zza, zzywVar, zzfww.zzn(), zzuyVar, false, 1, 0, zzbb.zza, 0L, 0L, 0L, 0L, false);
    }

    public static zzuy zzi() {
        return zzu;
    }

    public final zzlm zza(boolean z) {
        return new zzlm(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, z, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, false);
    }

    public final zzlm zzb(zzuy zzuyVar) {
        return new zzlm(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, zzuyVar, this.zzl, this.zzm, this.zzn, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, false);
    }

    public final zzlm zzc(zzuy zzuyVar, long j, long j2, long j3, long j4, zzxd zzxdVar, zzyw zzywVar, List list) {
        zzuy zzuyVar2 = this.zzk;
        boolean z = this.zzl;
        int i = this.zzm;
        int i2 = this.zzn;
        zzbb zzbbVar = this.zzo;
        long j5 = this.zzq;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        return new zzlm(this.zza, zzuyVar, j2, j3, this.zze, this.zzf, this.zzg, zzxdVar, zzywVar, list, zzuyVar2, z, i, i2, zzbbVar, j5, j4, j, jElapsedRealtime, false);
    }

    public final zzlm zzd(boolean z, int i, int i2) {
        return new zzlm(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, z, i, i2, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, false);
    }

    public final zzlm zze(zzii zziiVar) {
        return new zzlm(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zziiVar, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, false);
    }

    public final zzlm zzf(int i) {
        return new zzlm(this.zza, this.zzb, this.zzc, this.zzd, i, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, false);
    }

    public final zzlm zzg(zzbl zzblVar) {
        return new zzlm(zzblVar, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, false);
    }

    public final boolean zzj() {
        return this.zze == 3 && this.zzl && this.zzn == 0;
    }
}
