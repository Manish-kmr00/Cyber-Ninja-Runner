package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzakn {
    private final zzek zza = new zzek();
    private final int[] zzb = new int[256];
    private boolean zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;

    static /* bridge */ /* synthetic */ void zzb(zzakn zzaknVar, zzek zzekVar, int i) {
        int iZzo;
        if (i < 4) {
            return;
        }
        zzekVar.zzM(3);
        int i2 = i - 4;
        if ((zzekVar.zzm() & 128) != 0) {
            if (i2 < 7 || (iZzo = zzekVar.zzo()) < 4) {
                return;
            }
            zzaknVar.zzh = zzekVar.zzq();
            zzaknVar.zzi = zzekVar.zzq();
            zzaknVar.zza.zzI(iZzo - 4);
            i2 = i - 11;
        }
        zzek zzekVar2 = zzaknVar.zza;
        int iZzc = zzekVar2.zzc();
        int iZzd = zzekVar2.zzd();
        if (iZzc >= iZzd || i2 <= 0) {
            return;
        }
        int iMin = Math.min(i2, iZzd - iZzc);
        zzekVar.zzH(zzekVar2.zzN(), iZzc, iMin);
        zzekVar2.zzL(iZzc + iMin);
    }

    static /* bridge */ /* synthetic */ void zzc(zzakn zzaknVar, zzek zzekVar, int i) {
        if (i < 19) {
            return;
        }
        zzaknVar.zzd = zzekVar.zzq();
        zzaknVar.zze = zzekVar.zzq();
        zzekVar.zzM(11);
        zzaknVar.zzf = zzekVar.zzq();
        zzaknVar.zzg = zzekVar.zzq();
    }

    static /* bridge */ /* synthetic */ void zzd(zzakn zzaknVar, zzek zzekVar, int i) {
        if (i % 5 != 2) {
            return;
        }
        zzekVar.zzM(2);
        int[] iArr = zzaknVar.zzb;
        Arrays.fill(iArr, 0);
        int i2 = 0;
        for (int i3 = i / 5; i2 < i3; i3 = i3) {
            int iZzm = zzekVar.zzm();
            int iZzm2 = zzekVar.zzm();
            int iZzm3 = zzekVar.zzm();
            int iZzm4 = zzekVar.zzm();
            double d = iZzm2;
            int iZzm5 = zzekVar.zzm() << 24;
            int i4 = zzeu.zza;
            double d2 = iZzm3 - 128;
            double d3 = iZzm4 - 128;
            iArr[iZzm] = (Math.max(0, Math.min((int) (d + (1.402d * d2)), 255)) << 16) | iZzm5 | (Math.max(0, Math.min((int) ((d - (0.34414d * d3)) - (d2 * 0.71414d)), 255)) << 8) | Math.max(0, Math.min((int) (d + (d3 * 1.772d)), 255));
            i2++;
        }
        zzaknVar.zzc = true;
    }

    public final zzcu zza() {
        int i;
        if (this.zzd == 0 || this.zze == 0 || this.zzh == 0 || this.zzi == 0) {
            return null;
        }
        zzek zzekVar = this.zza;
        if (zzekVar.zzd() == 0 || zzekVar.zzc() != zzekVar.zzd() || !this.zzc) {
            return null;
        }
        zzekVar.zzL(0);
        int i2 = this.zzh * this.zzi;
        int[] iArr = new int[i2];
        int i3 = 0;
        while (i3 < i2) {
            int iZzm = zzekVar.zzm();
            if (iZzm != 0) {
                i = i3 + 1;
                iArr[i3] = this.zzb[iZzm];
            } else {
                int iZzm2 = zzekVar.zzm();
                if (iZzm2 != 0) {
                    int iZzm3 = iZzm2 & 63;
                    if ((iZzm2 & 64) != 0) {
                        iZzm3 = (iZzm3 << 8) | zzekVar.zzm();
                    }
                    i = iZzm3 + i3;
                    Arrays.fill(iArr, i3, i, (iZzm2 & 128) == 0 ? this.zzb[0] : this.zzb[zzekVar.zzm()]);
                }
            }
            i3 = i;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr, this.zzh, this.zzi, Bitmap.Config.ARGB_8888);
        zzcs zzcsVar = new zzcs();
        zzcsVar.zzc(bitmapCreateBitmap);
        zzcsVar.zzh(this.zzf / this.zzd);
        zzcsVar.zzi(0);
        zzcsVar.zze(this.zzg / this.zze, 0);
        zzcsVar.zzf(0);
        zzcsVar.zzk(this.zzh / this.zzd);
        zzcsVar.zzd(this.zzi / this.zze);
        return zzcsVar.zzp();
    }

    public final void zze() {
        this.zzd = 0;
        this.zze = 0;
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = 0;
        this.zzi = 0;
        this.zza.zzI(0);
        this.zzc = false;
    }
}
