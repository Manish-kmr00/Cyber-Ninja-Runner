package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdrd {
    final /* synthetic */ zzdre zza;
    private final Map zzb = new ConcurrentHashMap();

    zzdrd(zzdre zzdreVar) {
        this.zza = zzdreVar;
    }

    static /* bridge */ /* synthetic */ zzdrd zza(zzdrd zzdrdVar) {
        zzdrdVar.zzb.putAll(zzdrdVar.zza.zzc);
        return zzdrdVar;
    }

    public final zzdrd zzb(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.zzb.put(str, str2);
        }
        return this;
    }

    public final zzdrd zzc(zzfau zzfauVar) {
        zzb("aai", zzfauVar.zzw);
        zzb("request_id", zzfauVar.zzan);
        zzb("ad_format", zzfau.zza(zzfauVar.zzb));
        return this;
    }

    public final zzdrd zzd(zzfax zzfaxVar) {
        zzb("gqi", zzfaxVar.zzb);
        return this;
    }

    public final String zze() {
        return this.zza.zza.zzb(this.zzb);
    }

    public final void zzi() {
        this.zza.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdrc
            @Override // java.lang.Runnable
            public final void run() {
                zzdrd zzdrdVar = this.zza;
                zzdrdVar.zza.zza.zze(zzdrdVar.zzb);
            }
        });
    }

    public final void zzj() {
        this.zza.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdra
            @Override // java.lang.Runnable
            public final void run() {
                zzdrd zzdrdVar = this.zza;
                zzdrdVar.zza.zza.zzg(zzdrdVar.zzb);
            }
        });
    }

    public final void zzk() {
        this.zza.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdrb
            @Override // java.lang.Runnable
            public final void run() {
                zzdrd zzdrdVar = this.zza;
                zzdrdVar.zza.zza.zzf(zzdrdVar.zzb);
            }
        });
    }
}
