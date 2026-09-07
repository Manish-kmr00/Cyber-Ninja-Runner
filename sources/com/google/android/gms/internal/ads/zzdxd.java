package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdxd extends zzdxb {
    private final Context zzg;
    private final Executor zzh;

    zzdxd(Context context, Executor executor) {
        this.zzg = context;
        this.zzh = executor;
        this.zzf = new zzbud(context, com.google.android.gms.ads.internal.zzv.zzu().zzb(), this, this);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.zzb) {
            if (!this.zzd) {
                this.zzd = true;
                try {
                    this.zzf.zzp().zzf(this.zze, ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzmW)).booleanValue() ? new zzdxa(this.zza, this.zze) : new zzdwz(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zza.zzd(new zzdxq(1));
                } catch (Throwable th) {
                    com.google.android.gms.ads.internal.zzv.zzp().zzw(th, "RemoteSignalsClientTask.onConnected");
                    this.zza.zzd(new zzdxq(1));
                }
            }
        }
    }

    public final ListenableFuture zza(zzbuy zzbuyVar) {
        synchronized (this.zzb) {
            if (this.zzc) {
                return this.zza;
            }
            this.zzc = true;
            this.zze = zzbuyVar;
            this.zzf.checkAvailabilityAndConnect();
            zzbzp zzbzpVar = this.zza;
            zzbzpVar.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdxc
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzb();
                }
            }, zzbzk.zzg);
            zzc(this.zzg, zzbzpVar, this.zzh);
            return zzbzpVar;
        }
    }
}
