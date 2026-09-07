package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzub implements zzws {
    public final zzws zza;
    final /* synthetic */ zzuc zzb;
    private boolean zzc;

    public zzub(zzuc zzucVar, zzws zzwsVar) {
        this.zzb = zzucVar;
        this.zza = zzwsVar;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003c  */
    @Override // com.google.android.gms.internal.ads.zzws
    public final int zza(zzkp zzkpVar, zzhn zzhnVar, int i) {
        zzuc zzucVar = this.zzb;
        if (zzucVar.zzq()) {
            return -3;
        }
        if (this.zzc) {
            zzhnVar.zzc(4);
            return -4;
        }
        long jZzb = zzucVar.zzb();
        int iZza = this.zza.zza(zzkpVar, zzhnVar, i);
        if (iZza != -5) {
            long j = zzucVar.zzb;
            if (j == Long.MIN_VALUE || ((iZza != -4 || zzhnVar.zze < j) && !(iZza == -3 && jZzb == Long.MIN_VALUE && !zzhnVar.zzd))) {
                return iZza;
            }
            zzhnVar.zzb();
            zzhnVar.zzc(4);
            this.zzc = true;
            return -4;
        }
        zzz zzzVar = zzkpVar.zza;
        zzzVar.getClass();
        int i2 = zzzVar.zzH;
        if (i2 != 0) {
            int i3 = zzucVar.zzb == Long.MIN_VALUE ? zzzVar.zzI : 0;
            zzx zzxVarZzb = zzzVar.zzb();
            zzxVarZzb.zzI(i2);
            zzxVarZzb.zzJ(i3);
            zzkpVar.zza = zzxVarZzb.zzaj();
        } else if (zzzVar.zzI != 0) {
            i2 = 0;
            if (zzucVar.zzb == Long.MIN_VALUE) {
            }
            zzx zzxVarZzb2 = zzzVar.zzb();
            zzxVarZzb2.zzI(i2);
            zzxVarZzb2.zzJ(i3);
            zzkpVar.zza = zzxVarZzb2.zzaj();
        }
        return -5;
    }

    @Override // com.google.android.gms.internal.ads.zzws
    public final int zzb(long j) {
        if (this.zzb.zzq()) {
            return -3;
        }
        return this.zza.zzb(j);
    }

    public final void zzc() {
        this.zzc = false;
    }

    @Override // com.google.android.gms.internal.ads.zzws
    public final void zzd() throws IOException {
        this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzws
    public final boolean zze() {
        return !this.zzb.zzq() && this.zza.zze();
    }
}
