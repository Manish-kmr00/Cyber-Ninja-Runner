package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
final class zzbba implements BaseGmsClient.BaseConnectionCallbacks {
    public static final /* synthetic */ int zzd = 0;
    final /* synthetic */ zzbas zza;
    final /* synthetic */ zzbzp zzb;
    final /* synthetic */ zzbbc zzc;

    zzbba(zzbbc zzbbcVar, zzbas zzbasVar, zzbzp zzbzpVar) {
        this.zza = zzbasVar;
        this.zzb = zzbzpVar;
        this.zzc = zzbbcVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzbbc zzbbcVar = this.zzc;
        synchronized (zzbbcVar.zzd) {
            if (zzbbcVar.zzb) {
                return;
            }
            zzbbcVar.zzb = true;
            final zzbar zzbarVar = zzbbcVar.zza;
            if (zzbarVar == null) {
                return;
            }
            zzgcd zzgcdVar = zzbzk.zza;
            final zzbas zzbasVar = this.zza;
            final zzbzp zzbzpVar = this.zzb;
            final ListenableFuture listenableFutureZza = zzgcdVar.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbax
                @Override // java.lang.Runnable
                public final void run() {
                    zzbba zzbbaVar = this.zza;
                    zzbar zzbarVar2 = zzbarVar;
                    zzbzp zzbzpVar2 = zzbzpVar;
                    try {
                        zzbau zzbauVarZzq = zzbarVar2.zzq();
                        boolean zZzp = zzbarVar2.zzp();
                        zzbas zzbasVar2 = zzbasVar;
                        zzbap zzbapVarZzg = zZzp ? zzbauVarZzq.zzg(zzbasVar2) : zzbauVarZzq.zzf(zzbasVar2);
                        if (!zzbapVarZzg.zze()) {
                            zzbzpVar2.zzd(new RuntimeException("No entry contents."));
                            zzbbc.zze(zzbbaVar.zzc);
                            return;
                        }
                        zzbaz zzbazVar = new zzbaz(zzbbaVar, zzbapVarZzg.zzc(), 1);
                        int i = zzbazVar.read();
                        if (i == -1) {
                            throw new IOException("Unable to read from cache.");
                        }
                        zzbazVar.unread(i);
                        zzbzpVar2.zzc(zzbbe.zzb(zzbazVar, zzbapVarZzg.zzd(), zzbapVarZzg.zzg(), zzbapVarZzg.zza(), zzbapVarZzg.zzf()));
                    } catch (RemoteException | IOException e) {
                        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to obtain a cache service instance.", e);
                        zzbzpVar2.zzd(e);
                        zzbbc.zze(zzbbaVar.zzc);
                    }
                }
            });
            zzbzpVar.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbay
                @Override // java.lang.Runnable
                public final void run() {
                    int i = zzbba.zzd;
                    if (zzbzpVar.isCancelled()) {
                        listenableFutureZza.cancel(true);
                    }
                }
            }, zzbzk.zzg);
        }
    }
}
