package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes14.dex */
public final class zzdis {
    private final zzdre zza;

    zzdis(zzdre zzdreVar) {
        this.zza = zzdreVar;
    }

    public final void zza(View view, zzfau zzfauVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzmU)).booleanValue() || view == null) {
            return;
        }
        String str = true != com.google.android.gms.ads.internal.util.zzac.zza(view) ? "0" : "1";
        zzdrd zzdrdVarZza = this.zza.zza();
        zzdrdVarZza.zzb("action", "hcp");
        zzdrdVarZza.zzb("hcp", str);
        zzdrdVarZza.zzc(zzfauVar);
        zzdrdVarZza.zzj();
    }
}
