package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzajg implements zzadc {
    private zzadf zza;
    private zzajo zzb;
    private boolean zzc;

    @EnsuresNonNullIf(expression = {"streamReader"}, result = true)
    private final boolean zza(zzadd zzaddVar) throws IOException {
        zzaji zzajiVar = new zzaji();
        if (zzajiVar.zzb(zzaddVar, true) && (zzajiVar.zza & 2) == 2) {
            int iMin = Math.min(zzajiVar.zze, 8);
            zzek zzekVar = new zzek(iMin);
            zzaddVar.zzh(zzekVar.zzN(), 0, iMin);
            zzekVar.zzL(0);
            if (zzekVar.zza() >= 5 && zzekVar.zzm() == 127 && zzekVar.zzu() == 1179402563) {
                this.zzb = new zzajf();
            } else {
                zzekVar.zzL(0);
                try {
                    if (zzaeo.zzd(1, zzekVar, true)) {
                        this.zzb = new zzajq();
                    } else {
                        zzekVar.zzL(0);
                        if (zzajk.zzd(zzekVar)) {
                            this.zzb = new zzajk();
                        }
                    }
                } catch (zzaz unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final int zzb(zzadd zzaddVar, zzady zzadyVar) throws IOException {
        zzdc.zzb(this.zza);
        if (this.zzb == null) {
            if (!zza(zzaddVar)) {
                throw zzaz.zza("Failed to determine bitstream type", null);
            }
            zzaddVar.zzj();
        }
        if (!this.zzc) {
            zzaei zzaeiVarZzw = this.zza.zzw(0, 1);
            this.zza.zzG();
            this.zzb.zzh(this.zza, zzaeiVarZzw);
            this.zzc = true;
        }
        return this.zzb.zze(zzaddVar, zzadyVar);
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
        this.zza = zzadfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final void zzf(long j, long j2) {
        zzajo zzajoVar = this.zzb;
        if (zzajoVar != null) {
            zzajoVar.zzj(j, j2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final boolean zzi(zzadd zzaddVar) throws IOException {
        try {
            return zza(zzaddVar);
        } catch (zzaz unused) {
            return false;
        }
    }
}
