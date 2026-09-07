package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public class zzbds {
    private final String zza;
    private final Object zzb;
    private final int zzc;

    protected zzbds(String str, Object obj, int i) {
        this.zza = str;
        this.zzb = obj;
        this.zzc = i;
    }

    public static zzbds zza(String str, double d) {
        return new zzbds(str, Double.valueOf(d), 3);
    }

    public static zzbds zzb(String str, long j) {
        return new zzbds(str, Long.valueOf(j), 2);
    }

    public static zzbds zzc(String str, String str2) {
        return new zzbds("gad:dynamite_module:experiment_id", "", 4);
    }

    public static zzbds zzd(String str, boolean z) {
        return new zzbds(str, Boolean.valueOf(z), 1);
    }

    public final Object zze() {
        zzbex zzbexVarZza = zzbez.zza();
        if (zzbexVarZza == null) {
            if (zzbez.zzb() != null) {
                zzbez.zzb().zza();
            }
            return this.zzb;
        }
        int i = this.zzc - 1;
        if (i == 0) {
            return zzbexVarZza.zza(this.zza, ((Boolean) this.zzb).booleanValue());
        }
        if (i != 1) {
            return i != 2 ? zzbexVarZza.zzd(this.zza, (String) this.zzb) : zzbexVarZza.zzb(this.zza, ((Double) this.zzb).doubleValue());
        }
        return zzbexVarZza.zzc(this.zza, ((Long) this.zzb).longValue());
    }
}
