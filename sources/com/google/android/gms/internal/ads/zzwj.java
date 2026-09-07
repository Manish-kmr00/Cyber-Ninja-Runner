package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Looper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzwj extends zztx implements zzwa {
    private final zzgd zza;
    private final zzry zzb;
    private final int zzc;
    private boolean zzd = true;
    private long zze = -9223372036854775807L;
    private boolean zzf;
    private boolean zzg;
    private zzhe zzh;
    private zzap zzi;
    private final zzwg zzj;
    private final zzzi zzk;

    /* synthetic */ zzwj(zzap zzapVar, zzgd zzgdVar, zzwg zzwgVar, zzry zzryVar, zzzi zzziVar, int i, int i2, zzz zzzVar, zzfuo zzfuoVar, zzwi zzwiVar) {
        this.zzi = zzapVar;
        this.zza = zzgdVar;
        this.zzj = zzwgVar;
        this.zzb = zzryVar;
        this.zzk = zzziVar;
        this.zzc = i;
    }

    private final void zzw() {
        long j = this.zze;
        boolean z = this.zzf;
        boolean z2 = this.zzg;
        zzap zzapVarZzJ = zzJ();
        zzww zzwwVar = new zzww(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, j, j, 0L, 0L, z, false, false, null, zzapVarZzJ, z2 ? zzapVarZzJ.zzc : null);
        zzo(this.zzd ? new zzwf(this, zzwwVar) : zzwwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzva
    public final void zzG(zzuw zzuwVar) {
        ((zzwe) zzuwVar).zzO();
    }

    @Override // com.google.android.gms.internal.ads.zzva
    public final zzuw zzI(zzuy zzuyVar, zzze zzzeVar, long j) {
        zzge zzgeVarZza = this.zza.zza();
        zzhe zzheVar = this.zzh;
        if (zzheVar != null) {
            zzgeVarZza.zzf(zzheVar);
        }
        zzak zzakVar = zzJ().zzb;
        zzakVar.getClass();
        Uri uri = zzakVar.zza;
        zzwg zzwgVar = this.zzj;
        zzb();
        int i = zzwh.zza;
        return new zzwe(uri, zzgeVarZza, new zzua(zzwgVar.zza), this.zzb, zzc(zzuyVar), this.zzk, zze(zzuyVar), this, zzzeVar, null, this.zzc, 0, null, zzeu.zzs(-9223372036854775807L), null);
    }

    @Override // com.google.android.gms.internal.ads.zzva
    public final synchronized zzap zzJ() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzwa
    public final void zza(long j, zzaeb zzaebVar, boolean z) {
        if (j == -9223372036854775807L) {
            j = this.zze;
        }
        boolean zZzh = zzaebVar.zzh();
        if (!this.zzd && this.zze == j && this.zzf == zZzh && this.zzg == z) {
            return;
        }
        this.zze = j;
        this.zzf = zZzh;
        this.zzg = z;
        this.zzd = false;
        zzw();
    }

    @Override // com.google.android.gms.internal.ads.zztx
    protected final void zzn(zzhe zzheVar) {
        this.zzh = zzheVar;
        Looper.myLooper().getClass();
        zzb();
        zzw();
    }

    @Override // com.google.android.gms.internal.ads.zztx
    protected final void zzq() {
    }

    @Override // com.google.android.gms.internal.ads.zztx, com.google.android.gms.internal.ads.zzva
    public final synchronized void zzt(zzap zzapVar) {
        this.zzi = zzapVar;
    }

    @Override // com.google.android.gms.internal.ads.zzva
    public final void zzz() {
    }
}
