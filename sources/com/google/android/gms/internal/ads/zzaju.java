package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaju {
    public static void zza(zzajv zzajvVar, zzajz zzajzVar, zzdk zzdkVar) {
        for (int i = 0; i < zzajvVar.zza(); i++) {
            long jZzb = zzajvVar.zzb(i);
            List listZzc = zzajvVar.zzc(jZzb);
            if (!listZzc.isEmpty()) {
                if (i == zzajvVar.zza() - 1) {
                    throw new IllegalStateException();
                }
                long jZzb2 = zzajvVar.zzb(i + 1) - zzajvVar.zzb(i);
                if (jZzb2 > 0) {
                    zzdkVar.zza(new zzajs(listZzc, jZzb, jZzb2));
                }
            }
        }
    }
}
