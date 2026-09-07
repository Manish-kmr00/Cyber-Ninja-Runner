package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzcgt implements zzhey {
    private final zzcgo zza;

    public zzcgt(zzcgo zzcgoVar) {
        this.zza = zzcgoVar;
    }

    public static WeakReference zzc(zzcgo zzcgoVar) {
        WeakReference weakReferenceZzg = zzcgoVar.zzg();
        zzhfg.zzb(weakReferenceZzg);
        return weakReferenceZzg;
    }

    public final WeakReference zza() {
        return zzc(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* synthetic */ Object zzb() {
        return zzc(this.zza);
    }
}
