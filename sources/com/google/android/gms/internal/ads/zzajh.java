package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzajh {
    private final zzaji zza = new zzaji();
    private final zzek zzb = new zzek(new byte[65025], 0);
    private int zzc = -1;
    private int zzd;
    private boolean zze;

    zzajh() {
    }

    private final int zzf(int i) {
        int i2;
        int i3 = 0;
        this.zzd = 0;
        do {
            int i4 = this.zzd;
            int i5 = i + i4;
            zzaji zzajiVar = this.zza;
            if (i5 >= zzajiVar.zzc) {
                break;
            }
            this.zzd = i4 + 1;
            i2 = zzajiVar.zzf[i5];
            i3 += i2;
        } while (i2 == 255);
        return i3;
    }

    public final zzek zza() {
        return this.zzb;
    }

    public final zzaji zzb() {
        return this.zza;
    }

    public final void zzc() {
        this.zza.zza();
        this.zzb.zzI(0);
        this.zzc = -1;
        this.zze = false;
    }

    public final void zzd() {
        zzek zzekVar = this.zzb;
        if (zzekVar.zzN().length == 65025) {
            return;
        }
        zzekVar.zzJ(Arrays.copyOf(zzekVar.zzN(), Math.max(65025, zzekVar.zzd())), zzekVar.zzd());
    }

    public final boolean zze(zzadd zzaddVar) throws IOException {
        if (this.zze) {
            this.zze = false;
            this.zzb.zzI(0);
        }
        while (true) {
            if (this.zze) {
                return true;
            }
            int i = this.zzc;
            if (i < 0) {
                zzaji zzajiVar = this.zza;
                if (!zzajiVar.zzc(zzaddVar, -1L) || !zzajiVar.zzb(zzaddVar, true)) {
                    return false;
                }
                int iZzf = zzajiVar.zzd;
                if ((zzajiVar.zza & 1) == 1 && this.zzb.zzd() == 0) {
                    iZzf += zzf(0);
                    i = this.zzd;
                } else {
                    i = 0;
                }
                if (!zzadg.zze(zzaddVar, iZzf)) {
                    return false;
                }
                this.zzc = i;
            }
            int iZzf2 = zzf(i);
            int i2 = this.zzc + this.zzd;
            if (iZzf2 > 0) {
                zzek zzekVar = this.zzb;
                zzekVar.zzF(zzekVar.zzd() + iZzf2);
                if (!zzadg.zzd(zzaddVar, zzekVar.zzN(), zzekVar.zzd(), iZzf2)) {
                    return false;
                }
                zzekVar.zzK(zzekVar.zzd() + iZzf2);
                this.zze = this.zza.zzf[i2 + (-1)] != 255;
            }
            if (i2 == this.zza.zzc) {
                i2 = -1;
            }
            this.zzc = i2;
        }
    }
}
