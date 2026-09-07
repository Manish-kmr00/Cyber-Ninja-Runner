package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzalx implements zzadc {
    private final zzaly zza = new zzaly(null, 0, "audio/ac3");
    private final zzek zzb = new zzek(2786);
    private boolean zzc;

    @Override // com.google.android.gms.internal.ads.zzadc
    public final int zzb(zzadd zzaddVar, zzady zzadyVar) throws IOException {
        zzek zzekVar = this.zzb;
        int iZza = zzaddVar.zza(zzekVar.zzN(), 0, 2786);
        if (iZza == -1) {
            return -1;
        }
        zzekVar.zzL(0);
        zzekVar.zzK(iZza);
        if (!this.zzc) {
            this.zza.zzd(0L, 4);
            this.zzc = true;
        }
        this.zza.zza(zzekVar);
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
        this.zza.zzb(zzadfVar, new zzanu(Integer.MIN_VALUE, 0, 1));
        zzadfVar.zzG();
        zzadfVar.zzP(new zzaea(-9223372036854775807L, 0L));
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final void zzf(long j, long j2) {
        this.zzc = false;
        this.zza.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final boolean zzi(zzadd zzaddVar) throws IOException {
        zzacr zzacrVar;
        zzek zzekVar = new zzek(10);
        int i = 0;
        while (true) {
            zzacrVar = (zzacr) zzaddVar;
            zzacrVar.zzm(zzekVar.zzN(), 0, 10, false);
            zzekVar.zzL(0);
            if (zzekVar.zzo() != 4801587) {
                break;
            }
            zzekVar.zzM(3);
            int iZzl = zzekVar.zzl();
            i += iZzl + 10;
            zzacrVar.zzl(iZzl, false);
        }
        zzaddVar.zzj();
        zzacrVar.zzl(i, false);
        int i2 = 0;
        int i3 = i;
        while (true) {
            zzacrVar.zzm(zzekVar.zzN(), 0, 6, false);
            zzekVar.zzL(0);
            if (zzekVar.zzq() != 2935) {
                zzaddVar.zzj();
                i3++;
                if (i3 - i >= 8192) {
                    return false;
                }
                zzacrVar.zzl(i3, false);
                i2 = 0;
            } else {
                i2++;
                if (i2 >= 4) {
                    return true;
                }
                int iZzb = zzacb.zzb(zzekVar.zzN());
                if (iZzb == -1) {
                    return false;
                }
                zzacrVar.zzl(iZzb - 6, false);
            }
        }
    }
}
