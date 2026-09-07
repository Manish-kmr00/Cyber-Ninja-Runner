package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzadk {
    public static zzadm zzb(zzek zzekVar) {
        zzekVar.zzM(1);
        int iZzo = zzekVar.zzo();
        long jZzc = zzekVar.zzc();
        long j = iZzo;
        int i = iZzo / 18;
        long[] jArrCopyOf = new long[i];
        long[] jArrCopyOf2 = new long[i];
        for (int i2 = 0; i2 < i; i2++) {
            long jZzt = zzekVar.zzt();
            if (jZzt == -1) {
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i2);
                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i2);
                break;
            }
            jArrCopyOf[i2] = jZzt;
            jArrCopyOf2[i2] = zzekVar.zzt();
            zzekVar.zzM(2);
        }
        zzekVar.zzM((int) ((jZzc + j) - ((long) zzekVar.zzc())));
        return new zzadm(jArrCopyOf, jArrCopyOf2);
    }

    public static zzav zza(zzadd zzaddVar, boolean z) throws IOException {
        zzav zzavVarZza = new zzads().zza(zzaddVar, z ? null : zzagl.zza);
        if (zzavVarZza == null || zzavVarZza.zza() == 0) {
            return null;
        }
        return zzavVarZza;
    }
}
