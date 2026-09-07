package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzedt implements zzdfm {
    final /* synthetic */ zzbzp zza;
    final /* synthetic */ zzfau zzb;
    final /* synthetic */ zzedu zzc;

    zzedt(zzedu zzeduVar, zzbzp zzbzpVar, zzfau zzfauVar) {
        this.zza = zzbzpVar;
        this.zzb = zzfauVar;
        this.zzc = zzeduVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdfm
    public final zzfau zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzdfm
    public final void zzb(boolean z, Context context, zzcvp zzcvpVar) {
        try {
            com.google.android.gms.ads.internal.zzv.zzj();
            com.google.android.gms.ads.internal.overlay.zzn.zza(context, (AdOverlayInfoParcel) this.zza.get(), true, this.zzc.zze);
        } catch (Exception unused) {
        }
    }
}
