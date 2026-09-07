package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.1 */
/* JADX INFO: loaded from: classes13.dex */
final class zzkm implements zzhm {
    static final zzhm zza = new zzkm();

    private zzkm() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzhm
    public final boolean zza(int i) {
        zzkn zzknVar;
        if (i == 0) {
            zzknVar = zzkn.BROADCAST_ACTION_UNSPECIFIED;
        } else if (i == 1) {
            zzknVar = zzkn.PURCHASES_UPDATED_ACTION;
        } else if (i != 2) {
            zzknVar = i != 3 ? null : zzkn.ALTERNATIVE_BILLING_ACTION;
        } else {
            zzknVar = zzkn.LOCAL_PURCHASES_UPDATED_ACTION;
        }
        return zzknVar != null;
    }
}
