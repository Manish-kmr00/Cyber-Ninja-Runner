package com.google.android.gms.internal.ads;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaov extends Thread {
    private static final boolean zza = zzapv.zzb;
    private final BlockingQueue zzb;
    private final BlockingQueue zzc;
    private final zzaot zzd;
    private volatile boolean zze = false;
    private final zzapw zzf;
    private final zzapa zzg;

    public zzaov(BlockingQueue blockingQueue, BlockingQueue blockingQueue2, zzaot zzaotVar, zzapa zzapaVar) {
        this.zzb = blockingQueue;
        this.zzc = blockingQueue2;
        this.zzd = zzaotVar;
        this.zzg = zzapaVar;
        this.zzf = new zzapw(this, blockingQueue2, zzapaVar);
    }

    private void zzc() throws InterruptedException {
        zzapj zzapjVar = (zzapj) this.zzb.take();
        zzapjVar.zzm("cache-queue-take");
        zzapjVar.zzt(1);
        try {
            zzapjVar.zzw();
            zzaot zzaotVar = this.zzd;
            zzaos zzaosVarZza = zzaotVar.zza(zzapjVar.zzj());
            if (zzaosVarZza == null) {
                zzapjVar.zzm("cache-miss");
                if (!this.zzf.zzc(zzapjVar)) {
                    this.zzc.put(zzapjVar);
                }
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (zzaosVarZza.zza(jCurrentTimeMillis)) {
                    zzapjVar.zzm("cache-hit-expired");
                    zzapjVar.zze(zzaosVarZza);
                    if (!this.zzf.zzc(zzapjVar)) {
                        this.zzc.put(zzapjVar);
                    }
                } else {
                    zzapjVar.zzm("cache-hit");
                    zzapp zzappVarZzh = zzapjVar.zzh(new zzapf(zzaosVarZza.zza, zzaosVarZza.zzg));
                    zzapjVar.zzm("cache-hit-parsed");
                    if (!zzappVarZzh.zzc()) {
                        zzapjVar.zzm("cache-parsing-failed");
                        zzaotVar.zzc(zzapjVar.zzj(), true);
                        zzapjVar.zze(null);
                        if (!this.zzf.zzc(zzapjVar)) {
                            this.zzc.put(zzapjVar);
                        }
                    } else if (zzaosVarZza.zzf < jCurrentTimeMillis) {
                        zzapjVar.zzm("cache-hit-refresh-needed");
                        zzapjVar.zze(zzaosVarZza);
                        zzappVarZzh.zzd = true;
                        if (this.zzf.zzc(zzapjVar)) {
                            this.zzg.zzb(zzapjVar, zzappVarZzh, null);
                        } else {
                            this.zzg.zzb(zzapjVar, zzappVarZzh, new zzaou(this, zzapjVar));
                        }
                    } else {
                        this.zzg.zzb(zzapjVar, zzappVarZzh, null);
                    }
                }
            }
        } finally {
            zzapjVar.zzt(2);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        if (zza) {
            zzapv.zzd("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.zzd.zzb();
        while (true) {
            try {
                zzc();
            } catch (InterruptedException unused) {
                if (this.zze) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzapv.zzb("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    public final void zzb() {
        this.zze = true;
        interrupt();
    }
}
