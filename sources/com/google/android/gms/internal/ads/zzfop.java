package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.util.Log;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzfop {
    final /* synthetic */ zzfor zza;
    private final byte[] zzb;
    private int zzc;
    private int zzd;

    /* synthetic */ zzfop(zzfor zzforVar, byte[] bArr, zzfoq zzfoqVar) {
        this.zza = zzforVar;
        this.zzb = bArr;
    }

    public final zzfop zza(int i) {
        this.zzd = i;
        return this;
    }

    public final zzfop zzb(int i) {
        this.zzc = i;
        return this;
    }

    public final synchronized void zzc() {
        try {
            zzfor zzforVar = this.zza;
            if (zzforVar.zzb) {
                zzfou zzfouVar = zzforVar.zza;
                zzfouVar.zzj(this.zzb);
                zzfouVar.zzi(this.zzc);
                zzfouVar.zzg(this.zzd);
                zzfouVar.zzh(null);
                zzfouVar.zzf();
            }
        } catch (RemoteException e) {
            Log.d("GASS", "Clearcut log failed", e);
        }
    }
}
