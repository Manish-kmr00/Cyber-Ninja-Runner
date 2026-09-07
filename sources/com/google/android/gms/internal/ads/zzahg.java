package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzahg {
    private final zzek zza = new zzek(8);
    private int zzb;

    private final long zzb(zzadd zzaddVar) throws IOException {
        int i;
        zzek zzekVar = this.zza;
        zzacr zzacrVar = (zzacr) zzaddVar;
        int i2 = 0;
        zzacrVar.zzm(zzekVar.zzN(), 0, 1, false);
        int i3 = zzekVar.zzN()[0] & 255;
        if (i3 == 0) {
            return Long.MIN_VALUE;
        }
        int i4 = 128;
        int i5 = 0;
        while (true) {
            i = i5 + 1;
            if ((i3 & i4) != 0) {
                break;
            }
            i4 >>= 1;
            i5 = i;
        }
        int i6 = i3 & (~i4);
        zzacrVar.zzm(zzekVar.zzN(), 1, i5, false);
        while (i2 < i5) {
            i2++;
            i6 = (zzekVar.zzN()[i2] & 255) + (i6 << 8);
        }
        this.zzb += i;
        return i6;
    }

    public final boolean zza(zzadd zzaddVar) throws IOException {
        long jZzd = zzaddVar.zzd();
        long j = 1024;
        if (jZzd != -1 && jZzd <= 1024) {
            j = jZzd;
        }
        zzek zzekVar = this.zza;
        zzacr zzacrVar = (zzacr) zzaddVar;
        zzacrVar.zzm(zzekVar.zzN(), 0, 4, false);
        this.zzb = 4;
        for (long jZzu = zzekVar.zzu(); jZzu != 440786851; jZzu = ((jZzu << 8) & (-256)) | ((long) (zzekVar.zzN()[0] & 255))) {
            int i = (int) j;
            int i2 = this.zzb + 1;
            this.zzb = i2;
            if (i2 == i) {
                return false;
            }
            zzacrVar.zzm(zzekVar.zzN(), 0, 1, false);
        }
        long jZzb = zzb(zzaddVar);
        long j2 = this.zzb;
        if (jZzb != Long.MIN_VALUE) {
            long j3 = j2 + jZzb;
            if (jZzd == -1 || j3 < jZzd) {
                while (true) {
                    long j4 = this.zzb;
                    if (j4 < j3) {
                        if (zzb(zzaddVar) == Long.MIN_VALUE) {
                            return false;
                        }
                        long jZzb2 = zzb(zzaddVar);
                        if (jZzb2 < 0) {
                            return false;
                        }
                        if (jZzb2 != 0) {
                            int i3 = (int) jZzb2;
                            zzacrVar.zzl(i3, false);
                            this.zzb += i3;
                        }
                    } else if (j4 == j3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
