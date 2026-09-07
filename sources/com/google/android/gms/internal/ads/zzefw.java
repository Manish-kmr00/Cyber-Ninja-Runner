package com.google.android.gms.internal.ads;

import java.util.Iterator;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzefw {
    private final zzfch zza;
    private final zzdor zzb;
    private final zzdre zzc;

    public zzefw(zzfch zzfchVar, zzdor zzdorVar, zzdre zzdreVar) {
        this.zza = zzfchVar;
        this.zzb = zzdorVar;
        this.zzc = zzdreVar;
    }

    public final void zza(zzfax zzfaxVar, zzfau zzfauVar, int i, @Nullable zzecj zzecjVar, long j) {
        zzdoq zzdoqVarZza;
        zzdrd zzdrdVarZza = this.zzc.zza();
        zzdrdVarZza.zzd(zzfaxVar);
        zzdrdVarZza.zzc(zzfauVar);
        zzdrdVarZza.zzb("action", "adapter_status");
        zzdrdVarZza.zzb("adapter_l", String.valueOf(j));
        zzdrdVarZza.zzb("sc", Integer.toString(i));
        if (zzecjVar != null) {
            zzdrdVarZza.zzb("arec", Integer.toString(zzecjVar.zzb().zza));
            String strZza = this.zza.zza(zzecjVar.getMessage());
            if (strZza != null) {
                zzdrdVarZza.zzb("areec", strZza);
            }
        }
        zzdor zzdorVar = this.zzb;
        Iterator it = zzfauVar.zzt.iterator();
        do {
            if (!it.hasNext()) {
                zzdoqVarZza = null;
                break;
            }
            zzdoqVarZza = zzdorVar.zza((String) it.next());
        } while (zzdoqVarZza == null);
        if (zzdoqVarZza != null) {
            zzdrdVarZza.zzb("ancn", zzdoqVarZza.zza);
            zzbrm zzbrmVar = zzdoqVarZza.zzb;
            if (zzbrmVar != null) {
                zzdrdVarZza.zzb("adapter_v", zzbrmVar.toString());
            }
            zzbrm zzbrmVar2 = zzdoqVarZza.zzc;
            if (zzbrmVar2 != null) {
                zzdrdVarZza.zzb("adapter_sv", zzbrmVar2.toString());
            }
        }
        zzdrdVarZza.zzj();
    }
}
