package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzapm {
    private final AtomicInteger zza;
    private final Set zzb;
    private final PriorityBlockingQueue zzc;
    private final PriorityBlockingQueue zzd;
    private final zzaot zze;
    private final zzapc zzf;
    private final zzapd[] zzg;
    private zzaov zzh;
    private final List zzi;
    private final List zzj;
    private final zzapa zzk;

    public zzapm(zzaot zzaotVar, zzapc zzapcVar, int i) {
        zzapa zzapaVar = new zzapa(new Handler(Looper.getMainLooper()));
        this.zza = new AtomicInteger();
        this.zzb = new HashSet();
        this.zzc = new PriorityBlockingQueue();
        this.zzd = new PriorityBlockingQueue();
        this.zzi = new ArrayList();
        this.zzj = new ArrayList();
        this.zze = zzaotVar;
        this.zzf = zzapcVar;
        this.zzg = new zzapd[4];
        this.zzk = zzapaVar;
    }

    public final zzapj zza(zzapj zzapjVar) {
        zzapjVar.zzf(this);
        Set set = this.zzb;
        synchronized (set) {
            set.add(zzapjVar);
        }
        zzapjVar.zzg(this.zza.incrementAndGet());
        zzapjVar.zzm("add-to-queue");
        zzc(zzapjVar, 0);
        this.zzc.add(zzapjVar);
        return zzapjVar;
    }

    final void zzb(zzapj zzapjVar) {
        Set set = this.zzb;
        synchronized (set) {
            set.remove(zzapjVar);
        }
        List list = this.zzi;
        synchronized (list) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((zzapl) it.next()).zza();
            }
        }
        zzc(zzapjVar, 5);
    }

    final void zzc(zzapj zzapjVar, int i) {
        List list = this.zzj;
        synchronized (list) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((zzapk) it.next()).zza();
            }
        }
    }

    public final void zzd() {
        zzaov zzaovVar = this.zzh;
        if (zzaovVar != null) {
            zzaovVar.zzb();
        }
        zzapd[] zzapdVarArr = this.zzg;
        for (int i = 0; i < 4; i++) {
            zzapd zzapdVar = zzapdVarArr[i];
            if (zzapdVar != null) {
                zzapdVar.zza();
            }
        }
        PriorityBlockingQueue priorityBlockingQueue = this.zzc;
        PriorityBlockingQueue priorityBlockingQueue2 = this.zzd;
        zzaot zzaotVar = this.zze;
        zzapa zzapaVar = this.zzk;
        zzaov zzaovVar2 = new zzaov(priorityBlockingQueue, priorityBlockingQueue2, zzaotVar, zzapaVar);
        this.zzh = zzaovVar2;
        zzaovVar2.start();
        for (int i2 = 0; i2 < 4; i2++) {
            zzapd zzapdVar2 = new zzapd(priorityBlockingQueue2, this.zzf, zzaotVar, zzapaVar);
            zzapdVarArr[i2] = zzapdVar2;
            zzapdVar2.start();
        }
    }
}
