package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes5.dex */
final class zzapw implements zzapi {
    private final Map zza = new HashMap();
    private final zzaov zzb;
    private final BlockingQueue zzc;
    private final zzapa zzd;

    zzapw(zzaov zzaovVar, BlockingQueue blockingQueue, zzapa zzapaVar) {
        this.zzd = zzapaVar;
        this.zzb = zzaovVar;
        this.zzc = blockingQueue;
    }

    @Override // com.google.android.gms.internal.ads.zzapi
    public final synchronized void zza(zzapj zzapjVar) {
        Map map = this.zza;
        String strZzj = zzapjVar.zzj();
        List list = (List) map.remove(strZzj);
        if (list == null || list.isEmpty()) {
            return;
        }
        if (zzapv.zzb) {
            zzapv.zzd("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(list.size()), strZzj);
        }
        zzapj zzapjVar2 = (zzapj) list.remove(0);
        map.put(strZzj, list);
        zzapjVar2.zzu(this);
        try {
            this.zzc.put(zzapjVar2);
        } catch (InterruptedException e) {
            zzapv.zzb("Couldn't add request to queue. %s", e.toString());
            Thread.currentThread().interrupt();
            this.zzb.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapi
    public final void zzb(zzapj zzapjVar, zzapp zzappVar) {
        List list;
        zzaos zzaosVar = zzappVar.zzb;
        if (zzaosVar == null || zzaosVar.zza(System.currentTimeMillis())) {
            zza(zzapjVar);
            return;
        }
        String strZzj = zzapjVar.zzj();
        synchronized (this) {
            list = (List) this.zza.remove(strZzj);
        }
        if (list != null) {
            if (zzapv.zzb) {
                zzapv.zzd("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(list.size()), strZzj);
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.zzd.zzb((zzapj) it.next(), zzappVar, null);
            }
        }
    }

    final synchronized boolean zzc(zzapj zzapjVar) {
        Map map = this.zza;
        String strZzj = zzapjVar.zzj();
        if (!map.containsKey(strZzj)) {
            map.put(strZzj, null);
            zzapjVar.zzu(this);
            if (zzapv.zzb) {
                zzapv.zza("new request, sending to network %s", strZzj);
            }
            return false;
        }
        List arrayList = (List) map.get(strZzj);
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        zzapjVar.zzm("waiting-for-response");
        arrayList.add(zzapjVar);
        map.put(strZzj, arrayList);
        if (zzapv.zzb) {
            zzapv.zza("Request for cacheKey=%s is in flight, putting on hold.", strZzj);
        }
        return true;
    }
}
