package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdsr implements zzdsf {
    private final long zza;
    private final zzejz zzb;

    zzdsr(long j, Context context, zzdsk zzdskVar, zzcgl zzcglVar, String str) {
        this.zza = j;
        zzeyz zzeyzVarZzu = zzcglVar.zzu();
        zzeyzVarZzu.zzc(context);
        zzeyzVarZzu.zza(new com.google.android.gms.ads.internal.client.zzr());
        zzeyzVarZzu.zzb(str);
        zzejz zzejzVarZza = zzeyzVarZzu.zzd().zza();
        this.zzb = zzejzVarZza;
        zzejzVarZza.zzD(new zzdsq(this, zzdskVar));
    }

    @Override // com.google.android.gms.internal.ads.zzdsf
    public final void zza() {
        this.zzb.zzx();
    }

    @Override // com.google.android.gms.internal.ads.zzdsf
    public final void zzb(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        this.zzb.zzab(zzmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdsf
    public final void zzc() {
        this.zzb.zzW(ObjectWrapper.wrap(null));
    }
}
