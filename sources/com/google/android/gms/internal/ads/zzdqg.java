package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzdqg implements zzffu {
    private final Map zza;
    private final zzbbg zzb;

    zzdqg(zzbbg zzbbgVar, Map map) {
        this.zza = map;
        this.zzb = zzbbgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzffu
    public final void zzd(zzffn zzffnVar, String str) {
        Map map = this.zza;
        if (map.containsKey(zzffnVar)) {
            this.zzb.zzc(((zzdqf) map.get(zzffnVar)).zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzffu
    public final void zzdA(zzffn zzffnVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzffu
    public final void zzdB(zzffn zzffnVar, String str, Throwable th) {
        Map map = this.zza;
        if (map.containsKey(zzffnVar)) {
            this.zzb.zzc(((zzdqf) map.get(zzffnVar)).zzc);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzffu
    public final void zzdC(zzffn zzffnVar, String str) {
        Map map = this.zza;
        if (map.containsKey(zzffnVar)) {
            this.zzb.zzc(((zzdqf) map.get(zzffnVar)).zza);
        }
    }
}
