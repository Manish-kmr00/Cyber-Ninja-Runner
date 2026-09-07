package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzefu {
    private final Clock zza;
    private final zzefw zzb;
    private final zzfio zzc;
    private final LinkedHashMap zzd = new LinkedHashMap();
    private final boolean zze = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgN)).booleanValue();
    private final zzeck zzf;
    private boolean zzg;
    private long zzh;
    private long zzi;

    public zzefu(Clock clock, zzefw zzefwVar, zzeck zzeckVar, zzfio zzfioVar) {
        this.zza = clock;
        this.zzb = zzefwVar;
        this.zzf = zzeckVar;
        this.zzc = zzfioVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized boolean zzq(zzfau zzfauVar) {
        zzeft zzeftVar = (zzeft) this.zzd.get(zzfauVar);
        if (zzeftVar == null) {
            return false;
        }
        return zzeftVar.zzc == 8;
    }

    public final synchronized long zza() {
        return this.zzh;
    }

    final synchronized ListenableFuture zzf(zzfbg zzfbgVar, zzfau zzfauVar, ListenableFuture listenableFuture, zzfik zzfikVar) {
        zzfax zzfaxVar = zzfbgVar.zzb.zzb;
        long jElapsedRealtime = this.zza.elapsedRealtime();
        String str = zzfauVar.zzw;
        if (str != null) {
            this.zzd.put(zzfauVar, new zzeft(str, zzfauVar.zzaf, 9, 0L, null));
            zzgbs.zzr(listenableFuture, new zzefs(this, jElapsedRealtime, zzfaxVar, zzfauVar, str, zzfikVar, zzfbgVar), zzbzk.zzg);
        }
        return listenableFuture;
    }

    public final synchronized String zzg() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = this.zzd.entrySet().iterator();
        while (it.hasNext()) {
            zzeft zzeftVar = (zzeft) ((Map.Entry) it.next()).getValue();
            if (zzeftVar.zzc != Integer.MAX_VALUE) {
                arrayList.add(zzeftVar.toString());
            }
        }
        return TextUtils.join("_", arrayList);
    }

    public final synchronized void zzi(zzfau zzfauVar) {
        this.zzh = this.zza.elapsedRealtime() - this.zzi;
        if (zzfauVar != null) {
            this.zzf.zze(zzfauVar);
        }
        this.zzg = true;
    }

    public final synchronized void zzj() {
        this.zzh = this.zza.elapsedRealtime() - this.zzi;
    }

    public final synchronized void zzk(List list) {
        this.zzi = this.zza.elapsedRealtime();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzfau zzfauVar = (zzfau) it.next();
            String str = zzfauVar.zzw;
            if (!TextUtils.isEmpty(str)) {
                this.zzd.put(zzfauVar, new zzeft(str, zzfauVar.zzaf, Integer.MAX_VALUE, 0L, null));
            }
        }
    }

    public final synchronized void zzl() {
        this.zzi = this.zza.elapsedRealtime();
    }

    public final synchronized void zzm(zzfau zzfauVar) {
        zzeft zzeftVar = (zzeft) this.zzd.get(zzfauVar);
        if (zzeftVar == null || this.zzg) {
            return;
        }
        zzeftVar.zzc = 8;
    }
}
