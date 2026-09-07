package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaod {
    public final int zza;
    public final long zzb;

    private zzaod(int i, long j) {
        this.zza = i;
        this.zzb = j;
    }

    public static zzaod zza(zzadd zzaddVar, zzek zzekVar) throws IOException {
        zzaddVar.zzh(zzekVar.zzN(), 0, 8);
        zzekVar.zzL(0);
        return new zzaod(zzekVar.zzg(), zzekVar.zzs());
    }
}
