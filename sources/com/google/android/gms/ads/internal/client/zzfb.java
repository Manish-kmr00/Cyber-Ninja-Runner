package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzfb implements Runnable {
    final /* synthetic */ zzfc zza;

    zzfb(zzfc zzfcVar) {
        this.zza = zzfcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfe zzfeVar = this.zza.zza;
        if (zzfeVar.zza != null) {
            try {
                zzfeVar.zza.zze(1);
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzk("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
