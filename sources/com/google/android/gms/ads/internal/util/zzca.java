package com.google.android.gms.ads.internal.util;

import android.content.SharedPreferences;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzca implements SharedPreferences.OnSharedPreferenceChangeListener {
    final /* synthetic */ zzcb zza;
    private final String zzb;

    public zzca(zzcb zzcbVar, String str) {
        this.zza = zzcbVar;
        this.zzb = str;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        zzcb zzcbVar = this.zza;
        synchronized (zzcbVar) {
            for (zzbz zzbzVar : zzcbVar.zzb) {
                String str2 = this.zzb;
                Map map = zzbzVar.zza;
                if (map.containsKey(str2) && ((Set) map.get(str2)).contains(str)) {
                    com.google.android.gms.ads.internal.zzv.zzp().zzi().zzE(false);
                }
            }
        }
    }
}
