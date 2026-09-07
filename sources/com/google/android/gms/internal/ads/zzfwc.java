package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzfwc extends zzfvq {
    final /* synthetic */ zzfwf zza;
    private final Object zzb;
    private int zzc;

    zzfwc(zzfwf zzfwfVar, int i) {
        this.zza = zzfwfVar;
        this.zzb = zzfwf.zzg(zzfwfVar, i);
        this.zzc = i;
    }

    private final void zza() {
        int i = this.zzc;
        if (i != -1) {
            zzfwf zzfwfVar = this.zza;
            if (i < zzfwfVar.size() && zzftt.zza(this.zzb, zzfwf.zzg(zzfwfVar, this.zzc))) {
                return;
            }
        }
        this.zzc = this.zza.zzw(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzfvq, java.util.Map.Entry
    public final Object getKey() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfvq, java.util.Map.Entry
    public final Object getValue() {
        zzfwf zzfwfVar = this.zza;
        Map mapZzl = zzfwfVar.zzl();
        if (mapZzl != null) {
            return mapZzl.get(this.zzb);
        }
        zza();
        int i = this.zzc;
        if (i == -1) {
            return null;
        }
        return zzfwf.zzj(zzfwfVar, i);
    }

    @Override // com.google.android.gms.internal.ads.zzfvq, java.util.Map.Entry
    public final Object setValue(Object obj) {
        zzfwf zzfwfVar = this.zza;
        Map mapZzl = zzfwfVar.zzl();
        if (mapZzl != null) {
            return mapZzl.put(this.zzb, obj);
        }
        zza();
        int i = this.zzc;
        if (i == -1) {
            zzfwfVar.put(this.zzb, obj);
            return null;
        }
        Object objZzj = zzfwf.zzj(zzfwfVar, i);
        zzfwf.zzn(zzfwfVar, this.zzc, obj);
        return objZzj;
    }
}
