package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdxh extends zzdxb {
    private String zzg;
    private int zzh = 1;

    zzdxh(Context context) {
        this.zzf = new zzbud(context, com.google.android.gms.ads.internal.zzv.zzu().zzb(), this, this);
    }

    @Override // com.google.android.gms.internal.ads.zzdxb, com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zze("Cannot connect to remote service, fallback to local instance.");
        this.zza.zzd(new zzdxq(1));
    }

    public final ListenableFuture zza(zzbuy zzbuyVar) {
        synchronized (this.zzb) {
            int i = this.zzh;
            if (i != 1 && i != 2) {
                return zzgbs.zzg(new zzdxq(2));
            }
            if (this.zzc) {
                return this.zza;
            }
            this.zzh = 2;
            this.zzc = true;
            this.zze = zzbuyVar;
            this.zzf.checkAvailabilityAndConnect();
            zzbzp zzbzpVar = this.zza;
            zzbzpVar.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdxf
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzb();
                }
            }, zzbzk.zzg);
            return zzbzpVar;
        }
    }

    public final ListenableFuture zzd(String str) {
        synchronized (this.zzb) {
            int i = this.zzh;
            if (i != 1 && i != 3) {
                return zzgbs.zzg(new zzdxq(2));
            }
            if (this.zzc) {
                return this.zza;
            }
            this.zzh = 3;
            this.zzc = true;
            this.zzg = str;
            this.zzf.checkAvailabilityAndConnect();
            zzbzp zzbzpVar = this.zza;
            zzbzpVar.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdxg
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzb();
                }
            }, zzbzk.zzg);
            return zzbzpVar;
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.zzb) {
            if (!this.zzd) {
                this.zzd = true;
                try {
                    int i = this.zzh;
                    if (i == 2) {
                        this.zzf.zzp().zze(this.zze, ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzmW)).booleanValue() ? new zzdxa(this.zza, this.zze) : new zzdwz(this));
                    } else if (i == 3) {
                        this.zzf.zzp().zzh(this.zzg, ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzmW)).booleanValue() ? new zzdxa(this.zza, this.zze) : new zzdwz(this));
                    } else {
                        this.zza.zzd(new zzdxq(1));
                    }
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zza.zzd(new zzdxq(1));
                } catch (Throwable th) {
                    com.google.android.gms.ads.internal.zzv.zzp().zzw(th, "RemoteUrlAndCacheKeyClientTask.onConnected");
                    this.zza.zzd(new zzdxq(1));
                }
            }
        }
    }
}
