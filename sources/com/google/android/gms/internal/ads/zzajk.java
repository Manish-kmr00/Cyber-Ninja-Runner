package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzajk extends zzajo {
    private static final byte[] zza = {79, 112, 117, 115, 72, 101, 97, 100};
    private static final byte[] zzb = {79, 112, 117, 115, 84, 97, 103, 115};
    private boolean zzc;

    zzajk() {
    }

    public static boolean zzd(zzek zzekVar) {
        return zzk(zzekVar, zza);
    }

    private static boolean zzk(zzek zzekVar, byte[] bArr) {
        if (zzekVar.zza() < 8) {
            return false;
        }
        int iZzc = zzekVar.zzc();
        byte[] bArr2 = new byte[8];
        zzekVar.zzH(bArr2, 0, 8);
        zzekVar.zzL(iZzc);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // com.google.android.gms.internal.ads.zzajo
    protected final long zza(zzek zzekVar) {
        return zzg(zzadx.zzd(zzekVar.zzN()));
    }

    @Override // com.google.android.gms.internal.ads.zzajo
    protected final void zzb(boolean z) {
        super.zzb(z);
        if (z) {
            this.zzc = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzajo
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected final boolean zzc(zzek zzekVar, long j, zzajl zzajlVar) throws zzaz {
        if (zzk(zzekVar, zza)) {
            byte[] bArrCopyOf = Arrays.copyOf(zzekVar.zzN(), zzekVar.zzd());
            int i = bArrCopyOf[9] & 255;
            List listZze = zzadx.zze(bArrCopyOf);
            if (zzajlVar.zza == null) {
                zzx zzxVar = new zzx();
                zzxVar.zzE("audio/ogg");
                zzxVar.zzad("audio/opus");
                zzxVar.zzB(i);
                zzxVar.zzae(48000);
                zzxVar.zzP(listZze);
                zzajlVar.zza = zzxVar.zzaj();
                return true;
            }
        } else {
            if (!zzk(zzekVar, zzb)) {
                zzdc.zzb(zzajlVar.zza);
                return false;
            }
            zzdc.zzb(zzajlVar.zza);
            if (!this.zzc) {
                this.zzc = true;
                zzekVar.zzM(8);
                zzav zzavVarZzb = zzaeo.zzb(zzfww.zzm(zzaeo.zzc(zzekVar, false, false).zza));
                if (zzavVarZzb != null) {
                    zzx zzxVarZzb = zzajlVar.zza.zzb();
                    zzxVarZzb.zzW(zzavVarZzb.zzd(zzajlVar.zza.zzl));
                    zzajlVar.zza = zzxVarZzb.zzaj();
                }
            }
        }
        return true;
    }
}
