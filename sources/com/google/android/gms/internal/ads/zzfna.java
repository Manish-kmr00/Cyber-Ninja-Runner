package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.unity3d.services.core.di.ServiceProvider;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
final class zzfna implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    protected final zzfnw zza;
    private final String zzb;
    private final String zzc;
    private final LinkedBlockingQueue zzd;
    private final HandlerThread zze;
    private final zzfmr zzf;
    private final long zzg;
    private final int zzh;

    public zzfna(Context context, int i, int i2, String str, String str2, String str3, zzfmr zzfmrVar) {
        this.zzb = str;
        this.zzh = i2;
        this.zzc = str2;
        this.zzf = zzfmrVar;
        HandlerThread handlerThread = new HandlerThread("GassDGClient");
        this.zze = handlerThread;
        handlerThread.start();
        this.zzg = System.currentTimeMillis();
        zzfnw zzfnwVar = new zzfnw(context, handlerThread.getLooper(), this, this, 19621000);
        this.zza = zzfnwVar;
        this.zzd = new LinkedBlockingQueue();
        zzfnwVar.checkAvailabilityAndConnect();
    }

    private final void zzd(int i, long j, Exception exc) {
        this.zzf.zzc(i, System.currentTimeMillis() - j, exc);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzfob zzfobVarZzc = zzc();
        if (zzfobVarZzc != null) {
            try {
                zzfoi zzfoiVarZzf = zzfobVarZzc.zzf(new zzfog(1, this.zzh, this.zzb, this.zzc));
                zzd(IronSourceConstants.errorCode_internal, this.zzg, null);
                this.zzd.put(zzfoiVarZzf);
            } catch (Throwable th) {
                try {
                    zzd(2010, this.zzg, new Exception(th));
                } finally {
                    zzb();
                    this.zze.quit();
                }
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            zzd(4012, this.zzg, null);
            this.zzd.put(new zzfoi(null, 1));
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        try {
            zzd(4011, this.zzg, null);
            this.zzd.put(new zzfoi(null, 1));
        } catch (InterruptedException unused) {
        }
    }

    public final zzfoi zza(int i) {
        zzfoi zzfoiVar;
        try {
            zzfoiVar = (zzfoi) this.zzd.poll(ServiceProvider.SCAR_SIGNALS_FETCH_TIMEOUT, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            zzd(2009, this.zzg, e);
            zzfoiVar = null;
        }
        zzd(3004, this.zzg, null);
        if (zzfoiVar != null) {
            if (zzfoiVar.zzc == 7) {
                zzfmr.zzg(3);
            } else {
                zzfmr.zzg(2);
            }
        }
        return zzfoiVar == null ? new zzfoi(null, 1) : zzfoiVar;
    }

    public final void zzb() {
        zzfnw zzfnwVar = this.zza;
        if (zzfnwVar != null) {
            if (zzfnwVar.isConnected() || zzfnwVar.isConnecting()) {
                zzfnwVar.disconnect();
            }
        }
    }

    protected final zzfob zzc() {
        try {
            return this.zza.zzp();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }
}
