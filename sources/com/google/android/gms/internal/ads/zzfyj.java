package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzfyj extends zzfww {
    final /* synthetic */ zzfyk zza;

    zzfyj(zzfyk zzfykVar) {
        this.zza = zzfykVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        zzfyk zzfykVar = this.zza;
        zzftw.zza(i, zzfykVar.zzc, "index");
        int i2 = i + i;
        return new AbstractMap.SimpleImmutableEntry(Objects.requireNonNull(zzfykVar.zzb[i2]), Objects.requireNonNull(zzfykVar.zzb[i2 + 1]));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzfwr
    public final boolean zzf() {
        return true;
    }
}
