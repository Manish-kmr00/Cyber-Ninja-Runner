package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzapp {
    public final Object zza;
    public final zzaos zzb;
    public final zzaps zzc;
    public boolean zzd;

    private zzapp(zzaps zzapsVar) {
        this.zzd = false;
        this.zza = null;
        this.zzb = null;
        this.zzc = zzapsVar;
    }

    private zzapp(Object obj, zzaos zzaosVar) {
        this.zzd = false;
        this.zza = obj;
        this.zzb = zzaosVar;
        this.zzc = null;
    }

    public static zzapp zza(zzaps zzapsVar) {
        return new zzapp(zzapsVar);
    }

    public static zzapp zzb(Object obj, zzaos zzaosVar) {
        return new zzapp(obj, zzaosVar);
    }

    public final boolean zzc() {
        return this.zzc == null;
    }
}
