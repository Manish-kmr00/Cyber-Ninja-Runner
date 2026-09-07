package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzapn;
import com.google.android.gms.internal.ads.zzaps;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzbi implements zzapn {
    final /* synthetic */ String zza;
    final /* synthetic */ zzbk zzb;

    zzbi(zzbo zzboVar, String str, zzbk zzbkVar) {
        this.zza = str;
        this.zzb = zzbkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzapn
    public final void zza(zzaps zzapsVar) {
        String str = "Failed to load URL: " + this.zza + "\n" + zzapsVar.toString();
        int i = zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzj(str);
        this.zzb.zza((Object) null);
    }
}
