package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzgnh implements zzglh {
    private final List zza;
    private final zzglg zzb;

    public zzgnh(List list, zzglg zzglgVar) {
        this.zza = list;
        this.zzb = zzglgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzglh
    public final int zza() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.ads.zzglh
    public final zzglg zzd(int i) {
        return (zzglg) this.zza.get(i);
    }

    @Override // com.google.android.gms.internal.ads.zzglh
    public final zzglg zze() {
        return this.zzb;
    }
}
