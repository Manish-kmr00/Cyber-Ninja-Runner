package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzcig {
    private zzcgo zza;
    private zzcja zzb;
    private zzffx zzc;
    private zzcjn zzd;
    private zzfcr zze;

    private zzcig() {
        throw null;
    }

    /* synthetic */ zzcig(zzciz zzcizVar) {
    }

    public final zzcgl zza() {
        zzhfg.zzc(this.zza, zzcgo.class);
        zzhfg.zzc(this.zzb, zzcja.class);
        if (this.zzc == null) {
            this.zzc = new zzffx();
        }
        if (this.zzd == null) {
            this.zzd = new zzcjn();
        }
        if (this.zze == null) {
            this.zze = new zzfcr();
        }
        return new zzchv(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }

    public final zzcig zzb(zzcgo zzcgoVar) {
        this.zza = zzcgoVar;
        return this;
    }

    public final zzcig zzc(zzcja zzcjaVar) {
        this.zzb = zzcjaVar;
        return this;
    }
}
