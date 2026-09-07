package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.function.Consumer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
final class zzdkw implements zzgbo {
    final /* synthetic */ zzbzp zza;

    zzdkw(zzdkx zzdkxVar, zzbzp zzbzpVar) {
        this.zza = zzbzpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final void zza(Throwable th) {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzg("Failed to load media data due to video view load failure.");
        this.zza.zzd(th);
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcel zzcelVar = (zzcel) obj;
        if (zzcelVar == null) {
            this.zza.zzd(new zzefy(1, "Missing webview from video view future."));
            return;
        }
        final zzbzp zzbzpVar = this.zza;
        zzcelVar.zzag("/video", new zzcce(new Consumer() { // from class: com.google.android.gms.internal.ads.zzdkv
            @Override // java.util.function.Consumer
            public final void accept(Object obj2) {
                Bundle bundle = new Bundle();
                bundle.putString("mediaUrl", (String) obj2);
                zzbzpVar.zzc(bundle);
            }
        }));
        zzcelVar.zzaa();
    }
}
