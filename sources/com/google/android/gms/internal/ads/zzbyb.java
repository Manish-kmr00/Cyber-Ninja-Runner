package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzbyb {
    private final Map zza = new HashMap();
    private final List zzb = new ArrayList();
    private final Context zzc;
    private final zzbxn zzd;

    zzbyb(Context context, zzbxn zzbxnVar) {
        this.zzc = context;
        this.zzd = zzbxnVar;
    }

    public static /* synthetic */ void zzb(zzbyb zzbybVar, Map map, SharedPreferences sharedPreferences, String str, String str2) {
        if (map.containsKey(str) && ((Set) map.get(str)).contains(str2)) {
            zzbybVar.zzd.zzd();
        }
    }

    final synchronized void zzc(String str) {
        Map map = this.zza;
        if (map.containsKey(str)) {
            return;
        }
        SharedPreferences defaultSharedPreferences = Objects.equals(str, "__default__") ? PreferenceManager.getDefaultSharedPreferences(this.zzc) : this.zzc.getSharedPreferences(str, 0);
        zzbya zzbyaVar = new zzbya(this, str);
        map.put(str, zzbyaVar);
        defaultSharedPreferences.registerOnSharedPreferenceChangeListener(zzbyaVar);
    }

    final synchronized void zzd(zzbxz zzbxzVar) {
        this.zzb.add(zzbxzVar);
    }
}
