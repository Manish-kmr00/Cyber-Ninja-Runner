package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzbao {
    private ScheduledFuture zza = null;
    private final Runnable zzb = new zzbak(this);
    private final Object zzc = new Object();
    private zzbar zzd;
    private Context zze;
    private zzbau zzf;

    static /* bridge */ /* synthetic */ void zzh(zzbao zzbaoVar) {
        synchronized (zzbaoVar.zzc) {
            zzbar zzbarVar = zzbaoVar.zzd;
            if (zzbarVar == null) {
                return;
            }
            if (zzbarVar.isConnected() || zzbaoVar.zzd.isConnecting()) {
                zzbaoVar.zzd.disconnect();
            }
            zzbaoVar.zzd = null;
            zzbaoVar.zzf = null;
            Binder.flushPendingCommands();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzl() {
        synchronized (this.zzc) {
            if (this.zze != null && this.zzd == null) {
                zzbar zzbarVarZzd = zzd(new zzbam(this), new zzban(this));
                this.zzd = zzbarVarZzd;
                zzbarVarZzd.checkAvailabilityAndConnect();
            }
        }
    }

    public final long zza(zzbas zzbasVar) {
        synchronized (this.zzc) {
            if (this.zzf == null) {
                return -2L;
            }
            if (this.zzd.zzp()) {
                try {
                    return this.zzf.zze(zzbasVar);
                } catch (RemoteException e) {
                    int i = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to call into cache service.", e);
                }
            }
            return -2L;
        }
    }

    public final zzbap zzb(zzbas zzbasVar) {
        synchronized (this.zzc) {
            if (this.zzf == null) {
                return new zzbap();
            }
            try {
                if (this.zzd.zzp()) {
                    return this.zzf.zzg(zzbasVar);
                }
                return this.zzf.zzf(zzbasVar);
            } catch (RemoteException e) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to call into cache service.", e);
                return new zzbap();
            }
        }
    }

    protected final synchronized zzbar zzd(BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        return new zzbar(this.zze, com.google.android.gms.ads.internal.zzv.zzu().zzb(), baseConnectionCallbacks, baseOnConnectionFailedListener);
    }

    public final void zzi(Context context) {
        if (context == null) {
            return;
        }
        synchronized (this.zzc) {
            if (this.zze != null) {
                return;
            }
            this.zze = context.getApplicationContext();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzet)).booleanValue()) {
                zzl();
            } else {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzes)).booleanValue()) {
                    com.google.android.gms.ads.internal.zzv.zzb().zzc(new zzbal(this));
                }
            }
        }
    }

    public final void zzj() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzeu)).booleanValue()) {
            synchronized (this.zzc) {
                zzl();
                ScheduledFuture scheduledFuture = this.zza;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                this.zza = zzbzk.zzd.schedule(this.zzb, ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzev)).longValue(), TimeUnit.MILLISECONDS);
            }
        }
    }
}
