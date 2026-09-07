package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
final class zzgyt {
    zzgyt() {
    }

    public static final List zza(Object obj, long j) {
        zzgyh zzgyhVar = (zzgyh) zzhas.zzh(obj, j);
        if (zzgyhVar.zzc()) {
            return zzgyhVar;
        }
        int size = zzgyhVar.size();
        zzgyh zzgyhVarZzf = zzgyhVar.zzf(size == 0 ? 10 : size + size);
        zzhas.zzv(obj, j, zzgyhVarZzf);
        return zzgyhVarZzf;
    }
}
