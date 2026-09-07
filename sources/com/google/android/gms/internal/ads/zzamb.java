package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzamb implements zzadc {
    private final zzamc zza;
    private final zzek zzb;
    private final zzek zzc;
    private final zzej zzd;
    private zzadf zze;
    private long zzf;
    private long zzg;
    private boolean zzh;
    private boolean zzi;

    public zzamb() {
        throw null;
    }

    public zzamb(int i) {
        this.zza = new zzamc(true, null, 0, "audio/mp4a-latm");
        this.zzb = new zzek(2048);
        this.zzg = -1L;
        zzek zzekVar = new zzek(10);
        this.zzc = zzekVar;
        byte[] bArrZzN = zzekVar.zzN();
        this.zzd = new zzej(bArrZzN, bArrZzN.length);
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final int zzb(zzadd zzaddVar, zzady zzadyVar) throws IOException {
        zzdc.zzb(this.zze);
        zzek zzekVar = this.zzb;
        int iZza = zzaddVar.zza(zzekVar.zzN(), 0, 2048);
        if (!this.zzi) {
            this.zze.zzP(new zzaea(-9223372036854775807L, 0L));
            this.zzi = true;
        }
        if (iZza == -1) {
            return -1;
        }
        zzekVar.zzL(0);
        zzekVar.zzK(iZza);
        if (!this.zzh) {
            this.zza.zzd(this.zzf, 4);
            this.zzh = true;
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
        this.zze = zzadfVar;
        this.zza.zzb(zzadfVar, new zzanu(Integer.MIN_VALUE, 0, 1));
        zzadfVar.zzG();
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final void zzf(long j, long j2) {
        this.zzh = false;
        this.zza.zze();
        this.zzf = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final boolean zzi(zzadd zzaddVar) throws IOException {
        zzek zzekVar;
        zzacr zzacrVar;
        int i = 0;
        while (true) {
            zzekVar = this.zzc;
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
        if (this.zzg == -1) {
            this.zzg = i;
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = i;
        do {
            zzacrVar.zzm(zzekVar.zzN(), 0, 2, false);
            zzekVar.zzL(0);
            if (zzamc.zzf(zzekVar.zzq())) {
                i2++;
                if (i2 >= 4 && i3 > 188) {
                    return true;
                }
                zzacrVar.zzm(zzekVar.zzN(), 0, 4, false);
                zzej zzejVar = this.zzd;
                zzejVar.zzl(14);
                int iZzd = zzejVar.zzd(13);
                if (iZzd <= 6) {
                    i4++;
                    zzaddVar.zzj();
                    zzacrVar.zzl(i4, false);
                } else {
                    zzacrVar.zzl(iZzd - 6, false);
                    i3 += iZzd;
                }
            } else {
                i4++;
                zzaddVar.zzj();
                zzacrVar.zzl(i4, false);
            }
            i2 = 0;
            i3 = 0;
        } while (i4 - i < 8192);
        return false;
    }
}
