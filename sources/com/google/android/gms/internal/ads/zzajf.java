package com.google.android.gms.internal.ads;

import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzajf extends zzajo {
    private zzadn zza;
    private zzaje zzb;

    zzajf() {
    }

    private static boolean zzd(byte[] bArr) {
        return bArr[0] == -1;
    }

    @Override // com.google.android.gms.internal.ads.zzajo
    protected final long zza(zzek zzekVar) {
        if (!zzd(zzekVar.zzN())) {
            return -1L;
        }
        int i = (zzekVar.zzN()[2] & 255) >> 4;
        if (i == 6) {
            zzekVar.zzM(4);
            zzekVar.zzx();
        } else if (i == 7) {
            i = 7;
            zzekVar.zzM(4);
            zzekVar.zzx();
        }
        int iZza = zzadj.zza(zzekVar, i);
        zzekVar.zzL(0);
        return iZza;
    }

    @Override // com.google.android.gms.internal.ads.zzajo
    protected final void zzb(boolean z) {
        super.zzb(z);
        if (z) {
            this.zza = null;
            this.zzb = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzajo
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected final boolean zzc(zzek zzekVar, long j, zzajl zzajlVar) {
        byte[] bArrZzN = zzekVar.zzN();
        zzadn zzadnVar = this.zza;
        if (zzadnVar == null) {
            zzadn zzadnVar2 = new zzadn(bArrZzN, 17);
            this.zza = zzadnVar2;
            zzx zzxVarZzb = zzadnVar2.zzc(Arrays.copyOfRange(bArrZzN, 9, zzekVar.zzd()), null).zzb();
            zzxVarZzb.zzE("audio/ogg");
            zzajlVar.zza = zzxVarZzb.zzaj();
            return true;
        }
        if ((bArrZzN[0] & 127) == 3) {
            zzadm zzadmVarZzb = zzadk.zzb(zzekVar);
            zzadn zzadnVarZzf = zzadnVar.zzf(zzadmVarZzb);
            this.zza = zzadnVarZzf;
            this.zzb = new zzaje(zzadnVarZzf, zzadmVarZzb);
            return true;
        }
        if (!zzd(bArrZzN)) {
            return true;
        }
        zzaje zzajeVar = this.zzb;
        if (zzajeVar != null) {
            zzajeVar.zza(j);
            zzajlVar.zzb = this.zzb;
        }
        zzajlVar.zza.getClass();
        return false;
    }
}
