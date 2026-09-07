package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzbbk {
    final /* synthetic */ zzbbm zza;
    private final byte[] zzb;
    private int zzc;

    /* synthetic */ zzbbk(zzbbm zzbbmVar, byte[] bArr, zzbbl zzbblVar) {
        this.zza = zzbbmVar;
        this.zzb = bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzd() {
        try {
            zzbbm zzbbmVar = this.zza;
            if (zzbbmVar.zzb) {
                zzbbmVar.zza.zzj(this.zzb);
                zzbbmVar.zza.zzi(0);
                zzbbmVar.zza.zzg(this.zzc);
                zzbbmVar.zza.zzh(null);
                zzbbmVar.zza.zzf();
                return;
            }
            return;
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzf("Clearcut log failed", e);
            return;
        }
        throw th;
    }

    public final zzbbk zza(int i) {
        this.zzc = i;
        return this;
    }

    public final synchronized void zzc() {
        this.zza.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbbj
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzd();
            }
        });
    }
}
