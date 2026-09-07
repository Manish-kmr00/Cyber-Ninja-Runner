package com.google.android.gms.internal.ads;

import androidx.collection.SimpleArrayMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdhz {
    zzbgu zza;
    zzbgr zzb;
    zzbhh zzc;
    zzbhe zzd;
    zzbmc zze;
    final SimpleArrayMap zzf = new SimpleArrayMap();
    final SimpleArrayMap zzg = new SimpleArrayMap();

    public final zzdhz zza(zzbgr zzbgrVar) {
        this.zzb = zzbgrVar;
        return this;
    }

    public final zzdhz zzb(zzbgu zzbguVar) {
        this.zza = zzbguVar;
        return this;
    }

    public final zzdhz zzc(String str, zzbha zzbhaVar, zzbgx zzbgxVar) {
        this.zzf.put(str, zzbhaVar);
        if (zzbgxVar != null) {
            this.zzg.put(str, zzbgxVar);
        }
        return this;
    }

    public final zzdhz zzd(zzbmc zzbmcVar) {
        this.zze = zzbmcVar;
        return this;
    }

    public final zzdhz zze(zzbhe zzbheVar) {
        this.zzd = zzbheVar;
        return this;
    }

    public final zzdhz zzf(zzbhh zzbhhVar) {
        this.zzc = zzbhhVar;
        return this;
    }

    public final zzdib zzg() {
        return new zzdib(this);
    }
}
