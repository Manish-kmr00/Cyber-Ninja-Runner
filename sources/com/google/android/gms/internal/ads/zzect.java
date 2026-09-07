package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
final class zzect implements zzdfm {
    final /* synthetic */ zzeci zza;
    final /* synthetic */ zzfau zzb;

    zzect(zzecu zzecuVar, zzeci zzeciVar, zzfau zzfauVar) {
        this.zza = zzeciVar;
        this.zzb = zzfauVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdfm
    public final zzfau zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzdfm
    public final void zzb(boolean z, Context context, zzcvp zzcvpVar) throws zzdfl {
        try {
            zzfcn zzfcnVar = (zzfcn) this.zza.zzb;
            zzfcnVar.zzv(z);
            zzfcnVar.zzw(context);
        } catch (zzfbw e) {
            throw new zzdfl(e.getCause());
        }
    }
}
