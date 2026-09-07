package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaed implements zzadc {
    private final int zza;
    private final int zzb;
    private final String zzc;
    private int zzd;
    private int zze;
    private zzadf zzf;
    private zzaei zzg;

    public zzaed(int i, int i2, String str) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = str;
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final int zzb(zzadd zzaddVar, zzady zzadyVar) throws IOException {
        int i = this.zze;
        if (i != 1) {
            if (i == 2) {
                return -1;
            }
            throw new IllegalStateException();
        }
        zzaei zzaeiVar = this.zzg;
        zzaeiVar.getClass();
        int iZzf = zzaeiVar.zzf(zzaddVar, 1024, true);
        if (iZzf == -1) {
            this.zze = 2;
            this.zzg.zzt(0L, 1, this.zzd, 0, null);
            this.zzd = 0;
        } else {
            this.zzd += iZzf;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final /* synthetic */ zzadc zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final /* synthetic */ List zzd() {
        return zzfww.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final void zze(zzadf zzadfVar) {
        this.zzf = zzadfVar;
        zzaei zzaeiVarZzw = zzadfVar.zzw(1024, 4);
        this.zzg = zzaeiVarZzw;
        zzx zzxVar = new zzx();
        String str = this.zzc;
        zzxVar.zzE(str);
        zzxVar.zzad(str);
        zzaeiVarZzw.zzm(zzxVar.zzaj());
        this.zzf.zzG();
        this.zzf.zzP(new zzaee(-9223372036854775807L));
        this.zze = 1;
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final void zzf(long j, long j2) {
        if (j == 0 || this.zze == 1) {
            this.zze = 1;
            this.zzd = 0;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final boolean zzi(zzadd zzaddVar) throws IOException {
        int i = this.zza;
        zzdc.zzf((i == -1 || this.zzb == -1) ? false : true);
        int i2 = this.zzb;
        zzek zzekVar = new zzek(i2);
        ((zzacr) zzaddVar).zzm(zzekVar.zzN(), 0, i2, false);
        return zzekVar.zzq() == i;
    }
}
