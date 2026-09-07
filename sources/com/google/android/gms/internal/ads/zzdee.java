package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public class zzdee {
    private final zzdfm zza;
    private final zzcel zzb;

    public zzdee(zzdfm zzdfmVar, zzcel zzcelVar) {
        this.zza = zzdfmVar;
        this.zzb = zzcelVar;
    }

    public final View zza() {
        zzcel zzcelVar = this.zzb;
        if (zzcelVar == null) {
            return null;
        }
        return zzcelVar.zzG();
    }

    public final View zzb() {
        zzcel zzcelVar = this.zzb;
        if (zzcelVar != null) {
            return zzcelVar.zzG();
        }
        return null;
    }

    public final zzcel zzc() {
        return this.zzb;
    }

    public final zzdcu zzd(Executor executor) {
        final zzcel zzcelVar = this.zzb;
        return new zzdcu(new zzczs() { // from class: com.google.android.gms.internal.ads.zzded
            @Override // com.google.android.gms.internal.ads.zzczs
            public final void zza() {
                com.google.android.gms.ads.internal.overlay.zzm zzmVarZzL;
                zzcel zzcelVar2 = zzcelVar;
                if (zzcelVar2 == null || (zzmVarZzL = zzcelVar2.zzL()) == null) {
                    return;
                }
                zzmVarZzL.zzb();
            }
        }, executor);
    }

    public final zzdfm zze() {
        return this.zza;
    }

    public Set zzf(zzctx zzctxVar) {
        return Collections.singleton(new zzdcu(zzctxVar, zzbzk.zzg));
    }

    public Set zzg(zzctx zzctxVar) {
        return Collections.singleton(new zzdcu(zzctxVar, zzbzk.zzg));
    }
}
