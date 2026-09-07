package com.google.android.gms.internal.play_billing;

import java.io.Serializable;
import java.util.Set;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.1 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzct extends zzbi implements Serializable {
    private static final zzct zza;
    private static final zzct zzb;
    private final transient zzco zzc;

    static {
        int i = zzco.zzd;
        zza = new zzct(zzdk.zza);
        zzb = new zzct(zzco.zzm(zzdh.zza()));
    }

    zzct(zzco zzcoVar) {
        this.zzc = zzcoVar;
    }

    static zzct zza() {
        return zzb;
    }

    public static zzct zzb() {
        return zza;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdj
    public final /* bridge */ /* synthetic */ Set zzc() {
        return this.zzc.isEmpty() ? zzdq.zza : new zzdr(this.zzc, zzdg.zza);
    }
}
