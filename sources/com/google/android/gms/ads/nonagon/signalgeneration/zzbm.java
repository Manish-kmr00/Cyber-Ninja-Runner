package com.google.android.gms.ads.nonagon.signalgeneration;

import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzddo;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzbm implements zzddo {
    private final zzb zza;
    private final int zzb;
    private final String zzc;

    public zzbm(zzb zzbVar, int i, String str) {
        this.zza = zzbVar;
        this.zzb = i;
        this.zzc = str;
    }

    @Override // com.google.android.gms.internal.ads.zzddo
    public final void zze(final zzbk zzbkVar) {
        if (zzbkVar == null || this.zzb != 2 || TextUtils.isEmpty(this.zzc)) {
            return;
        }
        com.google.android.gms.ads.internal.util.zzs.zzh(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzbl
            @Override // java.lang.Runnable
            public final void run() {
                zzbm zzbmVar = this.zza;
                zzbmVar.zza.zzd(zzbmVar.zzc, zzbkVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzddo
    public final void zzf(String str) {
    }
}
