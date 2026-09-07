package com.google.android.gms.internal.play_billing;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.1 */
/* JADX INFO: loaded from: classes13.dex */
final class zzfg extends zzes {
    final /* synthetic */ zzfh zza;
    private final Callable zzb;

    zzfg(zzfh zzfhVar, Callable callable) {
        this.zza = zzfhVar;
        callable.getClass();
        this.zzb = callable;
    }

    @Override // com.google.android.gms.internal.play_billing.zzes
    final Object zza() throws Exception {
        return this.zzb.call();
    }

    @Override // com.google.android.gms.internal.play_billing.zzes
    final String zzb() {
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.play_billing.zzes
    final void zzc(Throwable th) {
        this.zza.zzo(th);
    }

    @Override // com.google.android.gms.internal.play_billing.zzes
    final void zzd(Object obj) {
        this.zza.zzn(obj);
    }

    @Override // com.google.android.gms.internal.play_billing.zzes
    final boolean zzf() {
        return this.zza.isDone();
    }
}
