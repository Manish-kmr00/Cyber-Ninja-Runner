package com.google.android.gms.internal.ads;

import android.net.Uri;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzvz implements zzzn, zzun {
    final /* synthetic */ zzwe zza;
    private final Uri zzc;
    private final zzhd zzd;
    private final zzvt zze;
    private final zzadf zzf;
    private final zzdj zzg;
    private volatile boolean zzi;
    private long zzk;
    private zzaei zzm;
    private boolean zzn;
    private final zzady zzh = new zzady();
    private boolean zzj = true;
    private final long zzb = zzup.zza();
    private zzgj zzl = zzi(0);

    public zzvz(zzwe zzweVar, Uri uri, zzge zzgeVar, zzvt zzvtVar, zzadf zzadfVar, zzdj zzdjVar) {
        this.zza = zzweVar;
        this.zzc = uri;
        this.zzd = new zzhd(zzgeVar);
        this.zze = zzvtVar;
        this.zzf = zzadfVar;
        this.zzg = zzdjVar;
    }

    static /* bridge */ /* synthetic */ void zzf(zzvz zzvzVar, long j, long j2) {
        zzvzVar.zzh.zza = j;
        zzvzVar.zzk = j2;
        zzvzVar.zzj = true;
        zzvzVar.zzn = false;
    }

    private final zzgj zzi(long j) {
        zzgh zzghVar = new zzgh();
        zzghVar.zzd(this.zzc);
        zzghVar.zzc(j);
        zzghVar.zza(6);
        zzghVar.zzb(zzwe.zzb);
        return zzghVar.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzzn
    public final void zzg() {
        this.zzi = true;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x01ce */
    @Override // com.google.android.gms.internal.ads.zzzn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzh() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 531
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvz.zzh():void");
    }

    @Override // com.google.android.gms.internal.ads.zzun
    public final void zza(zzek zzekVar) {
        long jMax = !this.zzn ? this.zzk : Math.max(zzwe.zzr(this.zza, true), this.zzk);
        int iZza = zzekVar.zza();
        zzaei zzaeiVar = this.zzm;
        zzaeiVar.getClass();
        zzaeiVar.zzr(zzekVar, iZza);
        zzaeiVar.zzt(jMax, 1, iZza, 0, null);
        this.zzn = true;
    }
}
