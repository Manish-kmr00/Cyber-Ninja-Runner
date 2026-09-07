package com.google.android.gms.measurement.internal;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
/* JADX INFO: loaded from: classes12.dex */
final class zzgy implements com.google.android.gms.internal.measurement.zzv {
    private final /* synthetic */ zzgt zza;

    zzgy(zzgt zzgtVar) {
        this.zza = zzgtVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void zza(com.google.android.gms.internal.measurement.zzs zzsVar, String str, List<String> list, boolean z, boolean z2) {
        zzfy zzfyVarZzc;
        int i = zzha.zza[zzsVar.ordinal()];
        if (i == 1) {
            zzfyVarZzc = this.zza.zzj().zzc();
        } else if (i != 2) {
            if (i != 3) {
                zzfyVarZzc = i != 4 ? this.zza.zzj().zzn() : this.zza.zzj().zzp();
            } else if (z) {
                zzfyVarZzc = this.zza.zzj().zzw();
            } else {
                zzfyVarZzc = !z2 ? this.zza.zzj().zzv() : this.zza.zzj().zzu();
            }
        } else if (z) {
            zzfyVarZzc = this.zza.zzj().zzm();
        } else {
            zzfyVarZzc = !z2 ? this.zza.zzj().zzh() : this.zza.zzj().zzg();
        }
        int size = list.size();
        if (size == 1) {
            zzfyVarZzc.zza(str, list.get(0));
            return;
        }
        if (size == 2) {
            zzfyVarZzc.zza(str, list.get(0), list.get(1));
        } else if (size != 3) {
            zzfyVarZzc.zza(str);
        } else {
            zzfyVarZzc.zza(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
