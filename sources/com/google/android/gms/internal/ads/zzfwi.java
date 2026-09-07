package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzfwi extends zzfwl {
    zzfwi() {
        super(null);
    }

    static final zzfwl zzf(int i) {
        if (i < 0) {
            return zzfwl.zzb;
        }
        return i > 0 ? zzfwl.zzc : zzfwl.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzfwl
    public final int zza() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzfwl
    public final zzfwl zzb(int i, int i2) {
        return zzf(Integer.compare(i, i2));
    }

    @Override // com.google.android.gms.internal.ads.zzfwl
    public final zzfwl zzc(Object obj, Object obj2, Comparator comparator) {
        return zzf(comparator.compare(obj, obj2));
    }

    @Override // com.google.android.gms.internal.ads.zzfwl
    public final zzfwl zzd(boolean z, boolean z2) {
        return zzf(Boolean.compare(z, z2));
    }

    @Override // com.google.android.gms.internal.ads.zzfwl
    public final zzfwl zze(boolean z, boolean z2) {
        return zzf(Boolean.compare(z2, z));
    }
}
