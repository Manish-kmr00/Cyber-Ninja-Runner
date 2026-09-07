package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzdor {
    private final Map zza = new HashMap();

    zzdor() {
    }

    @Nullable
    public final synchronized zzdoq zza(String str) {
        return (zzdoq) this.zza.get(str);
    }

    public final String zzb(String str) {
        zzbrm zzbrmVar;
        zzdoq zzdoqVarZza = zza(str);
        return (zzdoqVarZza == null || (zzbrmVar = zzdoqVarZza.zzb) == null) ? "" : zzbrmVar.toString();
    }

    final synchronized void zzc(String str, @Nullable zzfcn zzfcnVar) {
        zzbrm zzbrmVarZze;
        if (this.zza.containsKey(str)) {
            return;
        }
        zzbrm zzbrmVarZzf = null;
        if (zzfcnVar == null) {
            zzbrmVarZze = null;
        } else {
            try {
                zzbrmVarZze = zzfcnVar.zze();
            } catch (zzfbw unused) {
                zzbrmVarZze = null;
            }
        }
        if (zzfcnVar != null) {
            try {
                zzbrmVarZzf = zzfcnVar.zzf();
            } catch (zzfbw unused2) {
            }
        }
        boolean z = true;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzjv)).booleanValue()) {
            if (zzfcnVar == null) {
                z = false;
            } else {
                try {
                    zzfcnVar.zzC();
                } catch (zzfbw unused3) {
                    z = false;
                }
            }
        }
        this.zza.put(str, new zzdoq(str, zzbrmVarZze, zzbrmVarZzf, z));
    }

    final synchronized void zzd(String str, zzbqx zzbqxVar) {
        if (this.zza.containsKey(str)) {
            return;
        }
        try {
            this.zza.put(str, new zzdoq(str, zzbqxVar.zzf(), zzbqxVar.zzg(), true));
        } catch (Throwable unused) {
        }
    }
}
