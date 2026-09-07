package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzapd extends Thread {
    private final BlockingQueue zza;
    private final zzapc zzb;
    private final zzaot zzc;
    private volatile boolean zzd = false;
    private final zzapa zze;

    public zzapd(BlockingQueue blockingQueue, zzapc zzapcVar, zzaot zzaotVar, zzapa zzapaVar) {
        this.zza = blockingQueue;
        this.zzb = zzapcVar;
        this.zzc = zzaotVar;
        this.zze = zzapaVar;
    }

    private void zzb() throws InterruptedException {
        zzapj zzapjVar = (zzapj) this.zza.take();
        SystemClock.elapsedRealtime();
        zzapjVar.zzt(3);
        try {
            try {
                try {
                    zzapjVar.zzm("network-queue-take");
                    zzapjVar.zzw();
                    TrafficStats.setThreadStatsTag(zzapjVar.zzc());
                    zzapf zzapfVarZza = this.zzb.zza(zzapjVar);
                    zzapjVar.zzm("network-http-complete");
                    if (zzapfVarZza.zze && zzapjVar.zzv()) {
                        zzapjVar.zzp("not-modified");
                        zzapjVar.zzr();
                    } else {
                        zzapp zzappVarZzh = zzapjVar.zzh(zzapfVarZza);
                        zzapjVar.zzm("network-parse-complete");
                        zzaos zzaosVar = zzappVarZzh.zzb;
                        if (zzaosVar != null) {
                            this.zzc.zzd(zzapjVar.zzj(), zzaosVar);
                            zzapjVar.zzm("network-cache-written");
                        }
                        zzapjVar.zzq();
                        this.zze.zzb(zzapjVar, zzappVarZzh, null);
                        zzapjVar.zzs(zzappVarZzh);
                    }
                } catch (Exception e) {
                    zzapv.zzc(e, "Unhandled exception %s", e.toString());
                    zzaps zzapsVar = new zzaps(e);
                    SystemClock.elapsedRealtime();
                    this.zze.zza(zzapjVar, zzapsVar);
                    zzapjVar.zzr();
                }
            } catch (zzaps e2) {
                SystemClock.elapsedRealtime();
                this.zze.zza(zzapjVar, e2);
                zzapjVar.zzr();
            }
        } finally {
            zzapjVar.zzt(4);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                zzb();
            } catch (InterruptedException unused) {
                if (this.zzd) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzapv.zzb("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    public final void zza() {
        this.zzd = true;
        interrupt();
    }
}
