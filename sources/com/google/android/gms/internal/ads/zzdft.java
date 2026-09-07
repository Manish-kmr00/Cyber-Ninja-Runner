package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
final class zzdft implements zzcqj {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;
    private final zzhfn zzd;
    private final zzdib zze;

    zzdft(Map map, Map map2, Map map3, zzhfn zzhfnVar, zzdib zzdibVar) {
        this.zza = map;
        this.zzb = map2;
        this.zzc = map3;
        this.zzd = zzhfnVar;
        this.zze = zzdibVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcqj
    public final zzecf zza(int i, String str) {
        zzecf zzecfVarZza;
        zzecf zzecfVar = (zzecf) this.zza.get(str);
        if (zzecfVar != null) {
            return zzecfVar;
        }
        if (i != 1) {
            if (i != 4) {
                return null;
            }
            zzeeo zzeeoVar = (zzeeo) this.zzc.get(str);
            if (zzeeoVar != null) {
                return new zzecg(zzeeoVar, new zzftl() { // from class: com.google.android.gms.internal.ads.zzcql
                    @Override // com.google.android.gms.internal.ads.zzftl
                    public final Object apply(Object obj) {
                        return new zzcqo((List) obj);
                    }
                });
            }
            zzecfVarZza = (zzecf) this.zzb.get(str);
            if (zzecfVarZza == null) {
                return null;
            }
        } else if (this.zze.zze() == null || (zzecfVarZza = ((zzcqj) this.zzd.zzb()).zza(i, str)) == null) {
            return null;
        }
        return new zzecg(zzecfVarZza, new zzftl() { // from class: com.google.android.gms.internal.ads.zzcqm
            @Override // com.google.android.gms.internal.ads.zzftl
            public final Object apply(Object obj) {
                return new zzcqo((zzcqg) obj);
            }
        });
    }
}
