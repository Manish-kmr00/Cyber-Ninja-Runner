package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzbya implements SharedPreferences.OnSharedPreferenceChangeListener {
    final /* synthetic */ zzbyb zza;
    private final String zzb;

    public zzbya(zzbyb zzbybVar, String str) {
        this.zza = zzbybVar;
        this.zzb = str;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        zzbyb zzbybVar = this.zza;
        synchronized (zzbybVar) {
            for (zzbxz zzbxzVar : zzbybVar.zzb) {
                zzbyb.zzb(zzbxzVar.zza, zzbxzVar.zzb, sharedPreferences, this.zzb, str);
            }
        }
    }
}
