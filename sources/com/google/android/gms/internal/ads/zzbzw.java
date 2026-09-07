package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
@Deprecated
public class zzbzw {
    private final zzbzp zza;
    private final AtomicInteger zzb;

    public zzbzw() {
        zzbzp zzbzpVar = new zzbzp();
        this.zza = zzbzpVar;
        this.zzb = new AtomicInteger(0);
        zzgbs.zzr(zzbzpVar, new zzbzu(this), zzbzk.zzg);
    }

    @Deprecated
    public final int zze() {
        return this.zzb.get();
    }

    @Deprecated
    public final void zzg() {
        this.zza.zzd(new Exception());
    }

    @Deprecated
    public final void zzh(Throwable th, String str) {
        this.zza.zzd(th);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzhL)).booleanValue()) {
            com.google.android.gms.ads.internal.zzv.zzp().zzv(th, str);
        }
    }

    @Deprecated
    public final void zzi(Object obj) {
        this.zza.zzc(obj);
    }

    @Deprecated
    public final void zzj(zzbzt zzbztVar, zzbzr zzbzrVar) {
        zzgbs.zzr(this.zza, new zzbzv(this, zzbztVar, zzbzrVar), zzbzk.zzg);
    }
}
