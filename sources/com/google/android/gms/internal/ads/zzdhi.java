package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
final class zzdhi implements zzayh {
    final /* synthetic */ String zza;
    final /* synthetic */ zzdhl zzb;

    zzdhi(zzdhl zzdhlVar, String str) {
        this.zza = str;
        this.zzb = zzdhlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzayh
    public final void zzdn(zzayg zzaygVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbV)).booleanValue()) {
            synchronized (this) {
                if (zzaygVar.zzj) {
                    zzdhl zzdhlVar = this.zzb;
                    if (zzdhlVar.zzo != null) {
                        zzdhlVar.zzy.put(this.zza, true);
                        if (zzdhlVar.zzo == null) {
                            return;
                        } else {
                            zzdhlVar.zzB(zzdhlVar.zzo.zzf(), zzdhlVar.zzo.zzl(), zzdhlVar.zzo.zzm(), true);
                        }
                    }
                }
                return;
            }
        }
        if (zzaygVar.zzj) {
            zzdhl zzdhlVar2 = this.zzb;
            if (zzdhlVar2.zzo != null) {
                zzdhlVar2.zzy.put(this.zza, true);
                if (zzdhlVar2.zzo == null) {
                    return;
                }
                zzdhlVar2.zzB(zzdhlVar2.zzo.zzf(), zzdhlVar2.zzo.zzl(), zzdhlVar2.zzo.zzm(), true);
            }
        }
    }
}
