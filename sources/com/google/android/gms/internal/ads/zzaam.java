package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzaam extends HandlerThread implements Handler.Callback {
    private zzdm zza;
    private Handler zzb;
    private Error zzc;
    private RuntimeException zzd;
    private zzaao zze;

    public zzaam() {
        super("ExoPlayer:PlaceholderSurface");
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        try {
            if (i == 1) {
                try {
                    try {
                        int i2 = message.arg1;
                        zzdm zzdmVar = this.zza;
                        if (zzdmVar == null) {
                            throw null;
                        }
                        zzdmVar.zzb(i2);
                        this.zze = new zzaao(this, this.zza.zza(), i2 != 0, null);
                        synchronized (this) {
                            notify();
                        }
                    } catch (Error e) {
                        zzdx.zzd("PlaceholderSurface", "Failed to initialize placeholder surface", e);
                        this.zzc = e;
                        synchronized (this) {
                            notify();
                        }
                    } catch (RuntimeException e2) {
                        zzdx.zzd("PlaceholderSurface", "Failed to initialize placeholder surface", e2);
                        this.zzd = e2;
                        synchronized (this) {
                            notify();
                        }
                    }
                } catch (zzdn e3) {
                    zzdx.zzd("PlaceholderSurface", "Failed to initialize placeholder surface", e3);
                    this.zzd = new IllegalStateException(e3);
                    synchronized (this) {
                        notify();
                    }
                }
            } else if (i == 2) {
                try {
                    zzdm zzdmVar2 = this.zza;
                    if (zzdmVar2 == null) {
                        throw null;
                    }
                    zzdmVar2.zzc();
                    return true;
                } catch (Throwable th) {
                    try {
                        zzdx.zzd("PlaceholderSurface", "Failed to release placeholder surface", th);
                    } finally {
                        quit();
                    }
                }
            }
            return true;
        } catch (Throwable th2) {
            synchronized (this) {
                notify();
                throw th2;
            }
        }
    }

    public final zzaao zza(int i) {
        boolean z;
        start();
        this.zzb = new Handler(getLooper(), this);
        this.zza = new zzdm(this.zzb, null);
        synchronized (this) {
            z = false;
            this.zzb.obtainMessage(1, i, 0).sendToTarget();
            while (this.zze == null && this.zzd == null && this.zzc == null) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    z = true;
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        RuntimeException runtimeException = this.zzd;
        if (runtimeException != null) {
            throw runtimeException;
        }
        Error error = this.zzc;
        if (error != null) {
            throw error;
        }
        zzaao zzaaoVar = this.zze;
        zzaaoVar.getClass();
        return zzaaoVar;
    }

    public final void zzb() {
        Handler handler = this.zzb;
        handler.getClass();
        handler.sendEmptyMessage(2);
    }
}
