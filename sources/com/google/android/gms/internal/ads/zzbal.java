package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
final class zzbal implements zzaza {
    final /* synthetic */ zzbao zza;

    zzbal(zzbao zzbaoVar) {
        this.zza = zzbaoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaza
    public final void zza(boolean z) {
        if (z) {
            this.zza.zzl();
        } else {
            zzbao.zzh(this.zza);
        }
    }
}
