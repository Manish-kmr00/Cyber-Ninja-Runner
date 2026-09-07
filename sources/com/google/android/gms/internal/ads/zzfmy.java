package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
final class zzfmy implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    protected final zzfnw zza;
    private final String zzb;
    private final String zzc;
    private final LinkedBlockingQueue zzd;
    private final HandlerThread zze;

    public zzfmy(Context context, String str, String str2) {
        this.zzb = str;
        this.zzc = str2;
        HandlerThread handlerThread = new HandlerThread("GassClient");
        this.zze = handlerThread;
        handlerThread.start();
        zzfnw zzfnwVar = new zzfnw(context, handlerThread.getLooper(), this, this, 9200000);
        this.zza = zzfnwVar;
        this.zzd = new LinkedBlockingQueue();
        zzfnwVar.checkAvailabilityAndConnect();
    }

    static zzasu zza() {
        zzarz zzarzVarZza = zzasu.zza();
        zzarzVarZza.zzB(PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID);
        return (zzasu) zzarzVarZza.zzbr();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzfob zzfobVarZzd = zzd();
        if (zzfobVarZzd != null) {
            try {
                try {
                    this.zzd.put(zzfobVarZzd.zze(new zzfnx(this.zzb, this.zzc)).zza());
                } catch (InterruptedException unused) {
                } finally {
                    zzc();
                    this.zze.quit();
                }
            } catch (Throwable unused2) {
                this.zzd.put(zza());
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            this.zzd.put(zza());
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        try {
            this.zzd.put(zza());
        } catch (InterruptedException unused) {
        }
    }

    public final zzasu zzb(int i) {
        zzasu zzasuVar;
        try {
            zzasuVar = (zzasu) this.zzd.poll(5000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            zzasuVar = null;
        }
        return zzasuVar == null ? zza() : zzasuVar;
    }

    public final void zzc() {
        zzfnw zzfnwVar = this.zza;
        if (zzfnwVar != null) {
            if (zzfnwVar.isConnected() || zzfnwVar.isConnecting()) {
                zzfnwVar.disconnect();
            }
        }
    }

    protected final zzfob zzd() {
        try {
            return this.zza.zzp();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }
}
