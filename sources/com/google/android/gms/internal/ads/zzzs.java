package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzzs {
    public static final zzzl zza = new zzzl(2, -9223372036854775807L, null);
    public static final zzzl zzb = new zzzl(3, -9223372036854775807L, null);
    private final zzaaa zzc = zzzy.zza(zzeu.zzF("ExoPlayer:Loader:ProgressiveMediaPeriod"), new zzdk() { // from class: com.google.android.gms.internal.ads.zzzj
        @Override // com.google.android.gms.internal.ads.zzdk
        public final void zza(Object obj) {
            ((ExecutorService) obj).shutdown();
        }
    });
    private zzzm zzd;
    private IOException zze;

    public zzzs(String str) {
    }

    public static zzzl zzb(boolean z, long j) {
        return new zzzl(z ? 1 : 0, j, null);
    }

    public final long zza(zzzn zzznVar, zzzk zzzkVar, int i) {
        Looper looperMyLooper = Looper.myLooper();
        zzdc.zzb(looperMyLooper);
        this.zze = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new zzzm(this, looperMyLooper, zzznVar, zzzkVar, i, jElapsedRealtime).zzc(0L);
        return jElapsedRealtime;
    }

    public final void zzg() {
        zzzm zzzmVar = this.zzd;
        zzdc.zzb(zzzmVar);
        zzzmVar.zza(false);
    }

    public final void zzh() {
        this.zze = null;
    }

    public final void zzi(int i) throws IOException {
        IOException iOException = this.zze;
        if (iOException != null) {
            throw iOException;
        }
        zzzm zzzmVar = this.zzd;
        if (zzzmVar != null) {
            zzzmVar.zzb(i);
        }
    }

    public final void zzj(zzzo zzzoVar) {
        zzzm zzzmVar = this.zzd;
        if (zzzmVar != null) {
            zzzmVar.zza(true);
        }
        zzaaa zzaaaVar = this.zzc;
        zzaaaVar.execute(new zzzp(zzzoVar));
        zzaaaVar.zza();
    }

    public final boolean zzk() {
        return this.zze != null;
    }

    public final boolean zzl() {
        return this.zzd != null;
    }
}
