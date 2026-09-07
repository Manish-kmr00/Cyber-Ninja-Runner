package com.google.android.gms.internal.play_billing;

import com.json.b9;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.1 */
/* JADX INFO: loaded from: classes11.dex */
final class zzt extends zzq {
    final /* synthetic */ zzu zzg;

    zzt(zzu zzuVar) {
        this.zzg = zzuVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzq
    protected final String zza() {
        zzr zzrVar = (zzr) this.zzg.zza.get();
        if (zzrVar == null) {
            return "Completer object has been garbage collected, future will fail soon";
        }
        return "tag=[" + String.valueOf(zzrVar.zza) + b9.i.e;
    }
}
