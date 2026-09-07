package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzalz implements zzadc {
    private final zzama zza = new zzama(null, 0, "audio/ac4");
    private final zzek zzb = new zzek(16384);
    private boolean zzc;

    @Override // com.google.android.gms.internal.ads.zzadc
    public final int zzb(zzadd zzaddVar, zzady zzadyVar) throws IOException {
        zzek zzekVar = this.zzb;
        int iZza = zzaddVar.zza(zzekVar.zzN(), 0, 16384);
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
        int i;
        zzek zzekVar = new zzek(10);
        int i2 = 0;
        while (true) {
            zzacrVar = (zzacr) zzaddVar;
            zzacrVar.zzm(zzekVar.zzN(), 0, 10, false);
            zzekVar.zzL(0);
            if (zzekVar.zzo() != 4801587) {
                break;
            }
            zzekVar.zzM(3);
            int iZzl = zzekVar.zzl();
            i2 += iZzl + 10;
            zzacrVar.zzl(iZzl, false);
        }
        zzaddVar.zzj();
        zzacrVar.zzl(i2, false);
        int i3 = 0;
        int i4 = i2;
        while (true) {
            int i5 = 7;
            zzacrVar.zzm(zzekVar.zzN(), 0, 7, false);
            zzekVar.zzL(0);
            int iZzq = zzekVar.zzq();
            if (iZzq == 44096 || iZzq == 44097) {
                i3++;
                if (i3 >= 4) {
                    return true;
                }
                byte[] bArrZzN = zzekVar.zzN();
                int i6 = zzacf.zza;
                if (bArrZzN.length < 7) {
                    i = -1;
                } else {
                    int i7 = ((bArrZzN[2] & 255) << 8) | (bArrZzN[3] & 255);
                    if (i7 == 65535) {
                        i7 = ((bArrZzN[4] & 255) << 16) | ((bArrZzN[5] & 255) << 8) | (bArrZzN[6] & 255);
                    } else {
                        i5 = 4;
                    }
                    if (iZzq == 44097) {
                        i5 += 2;
                    }
                    i = i7 + i5;
                }
                if (i == -1) {
                    return false;
                }
                zzacrVar.zzl(i - 7, false);
            } else {
                zzaddVar.zzj();
                i4++;
                if (i4 - i2 >= 8192) {
                    return false;
                }
                zzacrVar.zzl(i4, false);
                i3 = 0;
            }
        }
    }
}
