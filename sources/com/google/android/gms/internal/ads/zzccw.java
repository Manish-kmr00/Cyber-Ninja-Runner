package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzccw extends zzccs {
    public zzccw(zzcbg zzcbgVar) {
        super(zzcbgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final boolean zzt(String str) {
        String strZzg = com.google.android.gms.ads.internal.util.client.zzf.zzg(str);
        zzcbg zzcbgVar = (zzcbg) this.zzc.get();
        if (zzcbgVar != null && strZzg != null) {
            zzcbgVar.zzt(strZzg, this);
        }
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("VideoStreamNoopCache is doing nothing.");
        zzg(str, strZzg, "noop", "Noop cache is a noop.");
        return false;
    }
}
