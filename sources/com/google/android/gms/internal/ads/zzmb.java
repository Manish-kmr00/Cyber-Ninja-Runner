package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
@Deprecated
public final class zzmb {
    private final zzir zza;

    @Deprecated
    public zzmb(Context context, zzcdr zzcdrVar) {
        this.zza = new zzir(context, zzcdrVar);
    }

    @Deprecated
    public final zzmb zza(final zzkr zzkrVar) {
        zzir zzirVar = this.zza;
        zzdc.zzf(!zzirVar.zzr);
        zzkrVar.getClass();
        zzirVar.zzf = new zzfuo() { // from class: com.google.android.gms.internal.ads.zzij
            @Override // com.google.android.gms.internal.ads.zzfuo
            public final Object zza() {
                return zzkrVar;
            }
        };
        return this;
    }

    @Deprecated
    public final zzmb zzb(final zzyv zzyvVar) {
        zzir zzirVar = this.zza;
        zzdc.zzf(!zzirVar.zzr);
        zzyvVar.getClass();
        zzirVar.zze = new zzfuo() { // from class: com.google.android.gms.internal.ads.zziq
            @Override // com.google.android.gms.internal.ads.zzfuo
            public final Object zza() {
                return zzyvVar;
            }
        };
        return this;
    }

    @Deprecated
    public final zzmc zzc() {
        zzir zzirVar = this.zza;
        zzdc.zzf(!zzirVar.zzr);
        zzirVar.zzr = true;
        return new zzmc(zzirVar);
    }
}
