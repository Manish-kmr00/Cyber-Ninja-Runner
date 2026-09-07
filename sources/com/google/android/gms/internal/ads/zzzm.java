package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.Trace;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzzm extends Handler implements Runnable {
    final /* synthetic */ zzzs zza;
    private final zzzn zzb;
    private final long zzc;
    private zzzk zzd;
    private IOException zze;
    private int zzf;
    private Thread zzg;
    private boolean zzh;
    private volatile boolean zzi;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzzm(zzzs zzzsVar, Looper looper, zzzn zzznVar, zzzk zzzkVar, int i, long j) {
        super(looper);
        this.zza = zzzsVar;
        this.zzb = zzznVar;
        this.zzd = zzzkVar;
        this.zzc = j;
    }

    private final void zzd() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.zzc;
        zzzk zzzkVar = this.zzd;
        zzzkVar.getClass();
        zzzkVar.zzL(this.zzb, jElapsedRealtime, j, this.zzf);
        this.zze = null;
        zzzs zzzsVar = this.zza;
        zzaaa zzaaaVar = zzzsVar.zzc;
        zzzm zzzmVar = zzzsVar.zzd;
        zzzmVar.getClass();
        zzaaaVar.execute(zzzmVar);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.zzi) {
            return;
        }
        if (message.what == 1) {
            zzd();
            return;
        }
        if (message.what == 4) {
            throw ((Error) message.obj);
        }
        zzzs zzzsVar = this.zza;
        zzzsVar.zzd = null;
        long j = this.zzc;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = jElapsedRealtime - j;
        zzzk zzzkVar = this.zzd;
        zzzkVar.getClass();
        if (this.zzh) {
            zzzkVar.zzJ(this.zzb, jElapsedRealtime, j2, false);
            return;
        }
        int i = message.what;
        if (i == 2) {
            try {
                zzzkVar.zzK(this.zzb, jElapsedRealtime, j2);
                return;
            } catch (RuntimeException e) {
                zzdx.zzd("LoadTask", "Unexpected exception handling load completed", e);
                this.zza.zze = new zzzq(e);
                return;
            }
        }
        if (i != 3) {
            return;
        }
        IOException iOException = (IOException) message.obj;
        this.zze = iOException;
        int i2 = this.zzf + 1;
        this.zzf = i2;
        zzzl zzzlVarZzu = zzzkVar.zzu(this.zzb, jElapsedRealtime, j2, iOException, i2);
        if (zzzlVarZzu.zza == 3) {
            zzzsVar.zze = this.zze;
        } else if (zzzlVarZzu.zza != 2) {
            if (zzzlVarZzu.zza == 1) {
                this.zzf = 1;
            }
            zzc(zzzlVarZzu.zzb != -9223372036854775807L ? zzzlVarZzu.zzb : Math.min((this.zzf - 1) * 1000, 5000));
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        try {
            synchronized (this) {
                z = this.zzh;
                this.zzg = Thread.currentThread();
            }
            if (!z) {
                zzzn zzznVar = this.zzb;
                Trace.beginSection("load:" + zzznVar.getClass().getSimpleName());
                try {
                    zzznVar.zzh();
                    Trace.endSection();
                } catch (Throwable th) {
                    Trace.endSection();
                    throw th;
                }
            }
            synchronized (this) {
                this.zzg = null;
                Thread.interrupted();
            }
            if (this.zzi) {
                return;
            }
            sendEmptyMessage(2);
        } catch (IOException e) {
            if (this.zzi) {
                return;
            }
            obtainMessage(3, e).sendToTarget();
        } catch (Error e2) {
            if (!this.zzi) {
                zzdx.zzd("LoadTask", "Unexpected error loading stream", e2);
                obtainMessage(4, e2).sendToTarget();
            }
            throw e2;
        } catch (Exception e3) {
            if (this.zzi) {
                return;
            }
            zzdx.zzd("LoadTask", "Unexpected exception loading stream", e3);
            obtainMessage(3, new zzzq(e3)).sendToTarget();
        } catch (OutOfMemoryError e4) {
            if (this.zzi) {
                return;
            }
            zzdx.zzd("LoadTask", "OutOfMemory error loading stream", e4);
            obtainMessage(3, new zzzq(e4)).sendToTarget();
        }
    }

    public final void zza(boolean z) {
        this.zzi = z;
        this.zze = null;
        if (hasMessages(1)) {
            this.zzh = true;
            removeMessages(1);
            if (!z) {
                sendEmptyMessage(2);
            }
        } else {
            synchronized (this) {
                this.zzh = true;
                this.zzb.zzg();
                Thread thread = this.zzg;
                if (thread != null) {
                    thread.interrupt();
                }
            }
        }
        if (z) {
            this.zza.zzd = null;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            zzzk zzzkVar = this.zzd;
            zzzkVar.getClass();
            zzzkVar.zzJ(this.zzb, jElapsedRealtime, jElapsedRealtime - this.zzc, true);
            this.zzd = null;
        }
    }

    public final void zzb(int i) throws IOException {
        IOException iOException = this.zze;
        if (iOException != null && this.zzf > i) {
            throw iOException;
        }
    }

    public final void zzc(long j) {
        zzzs zzzsVar = this.zza;
        zzdc.zzf(zzzsVar.zzd == null);
        zzzsVar.zzd = this;
        if (j > 0) {
            sendEmptyMessageDelayed(1, j);
        } else {
            zzd();
        }
    }
}
