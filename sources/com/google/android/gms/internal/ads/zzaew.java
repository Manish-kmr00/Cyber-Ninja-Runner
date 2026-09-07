package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaew implements zzaeq {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;

    private zzaew(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.zza = i;
        this.zzb = i3;
        this.zzc = i4;
        this.zzd = i5;
        this.zze = i6;
        this.zzf = i7;
    }

    public static zzaew zzd(zzek zzekVar) {
        int iZzi = zzekVar.zzi();
        zzekVar.zzM(12);
        int iZzi2 = zzekVar.zzi();
        int iZzi3 = zzekVar.zzi();
        int iZzi4 = zzekVar.zzi();
        zzekVar.zzM(4);
        int iZzi5 = zzekVar.zzi();
        int iZzi6 = zzekVar.zzi();
        zzekVar.zzM(4);
        return new zzaew(iZzi, iZzi2, iZzi3, iZzi4, iZzi5, iZzi6, zzekVar.zzi());
    }

    @Override // com.google.android.gms.internal.ads.zzaeq
    public final int zza() {
        return 1752331379;
    }

    public final int zzb() {
        int i = this.zza;
        if (i == 1935960438) {
            return 2;
        }
        if (i == 1935963489) {
            return 1;
        }
        if (i == 1937012852) {
            return 3;
        }
        zzdx.zzf("AviStreamHeaderChunk", "Found unsupported streamType fourCC: ".concat(String.valueOf(Integer.toHexString(i))));
        return -1;
    }

    public final long zzc() {
        return zzeu.zzu(this.zzd, ((long) this.zzb) * 1000000, this.zzc, RoundingMode.DOWN);
    }
}
