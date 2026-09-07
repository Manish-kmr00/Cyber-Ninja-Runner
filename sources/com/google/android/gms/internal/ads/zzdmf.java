package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzdmf implements zzbjj {
    private final zzbgx zza;
    private final zzdmt zzb;
    private final zzhes zzc;

    public zzdmf(zzdib zzdibVar, zzdhq zzdhqVar, zzdmt zzdmtVar, zzhes zzhesVar) {
        this.zza = zzdibVar.zzc(zzdhqVar.zzA());
        this.zzb = zzdmtVar;
        this.zzc = zzhesVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final void zza(Object obj, Map map) {
        String str = (String) map.get("asset");
        try {
            this.zza.zze((zzbgn) this.zzc.zzb(), str);
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to call onCustomClick for asset " + str + ".", e);
        }
    }

    public final void zzb() {
        if (this.zza == null) {
            return;
        }
        this.zzb.zzl("/nativeAdCustomClick", this);
    }
}
