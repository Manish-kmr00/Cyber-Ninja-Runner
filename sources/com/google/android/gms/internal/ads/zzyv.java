package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public abstract class zzyv {
    private zzyu zza;
    private zzzd zzb;

    public zzlw zze() {
        throw null;
    }

    public void zzj() {
        this.zza = null;
        this.zzb = null;
    }

    public void zzk(zze zzeVar) {
        throw null;
    }

    public boolean zzn() {
        throw null;
    }

    public abstract zzyw zzo(zzlx[] zzlxVarArr, zzxd zzxdVar, zzuy zzuyVar, zzbl zzblVar) throws zzii;

    public abstract void zzp(Object obj);

    protected final zzzd zzq() {
        zzzd zzzdVar = this.zzb;
        zzdc.zzb(zzzdVar);
        return zzzdVar;
    }

    public final void zzr(zzyu zzyuVar, zzzd zzzdVar) {
        this.zza = zzyuVar;
        this.zzb = zzzdVar;
    }

    protected final void zzs() {
        zzyu zzyuVar = this.zza;
        if (zzyuVar != null) {
            zzyuVar.zzm();
        }
    }
}
