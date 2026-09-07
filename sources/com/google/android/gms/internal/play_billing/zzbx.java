package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.1 */
/* JADX INFO: loaded from: classes12.dex */
final class zzbx extends zzca {
    zzbx() {
        super(null);
    }

    @Override // com.google.android.gms.internal.play_billing.zzca
    public final int zza() {
        return 0;
    }

    @Override // com.google.android.gms.internal.play_billing.zzca
    public final zzca zzb(Comparable comparable, Comparable comparable2) {
        int iCompareTo = comparable.compareTo(comparable2);
        if (iCompareTo < 0) {
            return zzca.zzb;
        }
        return iCompareTo > 0 ? zzca.zzc : zzca.zza;
    }
}
