package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcul {
    private final Context zza;
    private final zzfbp zzb;
    private final Bundle zzc;
    private final zzfbh zzd;
    private final zzcuc zze;
    private final zzeck zzf;
    private final int zzg;

    /* synthetic */ zzcul(zzcuj zzcujVar, zzcuk zzcukVar) {
        this.zza = zzcujVar.zza;
        this.zzb = zzcujVar.zzb;
        this.zzc = zzcujVar.zzc;
        this.zzd = zzcujVar.zzd;
        this.zze = zzcujVar.zze;
        this.zzf = zzcujVar.zzf;
        this.zzg = zzcujVar.zzg;
    }

    final int zza() {
        return this.zzg;
    }

    final Context zzb(Context context) {
        return this.zza;
    }

    final Bundle zzc() {
        return this.zzc;
    }

    final zzcuc zzd() {
        return this.zze;
    }

    final zzcuj zze() {
        zzcuj zzcujVar = new zzcuj();
        zzcujVar.zzf(this.zza);
        zzcujVar.zzk(this.zzb);
        zzcujVar.zzg(this.zzc);
        zzcujVar.zzh(this.zze);
        zzcujVar.zze(this.zzf);
        return zzcujVar;
    }

    final zzeck zzf(String str) {
        zzeck zzeckVar = this.zzf;
        return zzeckVar != null ? zzeckVar : new zzeck(str);
    }

    final zzfbh zzg() {
        return this.zzd;
    }

    final zzfbp zzh() {
        return this.zzb;
    }
}
