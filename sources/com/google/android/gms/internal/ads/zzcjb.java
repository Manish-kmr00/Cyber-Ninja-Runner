package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcjb implements zzhey {
    private final zzcja zza;

    public zzcjb(zzcja zzcjaVar) {
        this.zza = zzcjaVar;
    }

    public static com.google.android.gms.ads.internal.zza zzc(zzcja zzcjaVar) {
        return new com.google.android.gms.ads.internal.zza(new zzccd(), new zzcay());
    }

    public final com.google.android.gms.ads.internal.zza zza() {
        return zzc(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* synthetic */ Object zzb() {
        return zzc(this.zza);
    }
}
