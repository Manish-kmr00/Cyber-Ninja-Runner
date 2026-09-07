package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfdy {
    private final zzfdc zza;
    private final zzfdw zzb;
    private final zzfcy zzc;
    private zzfee zze;
    private int zzf = 1;
    private final ArrayDeque zzd = new ArrayDeque();

    public zzfdy(zzfdc zzfdcVar, zzfcy zzfcyVar, zzfdw zzfdwVar) {
        this.zza = zzfdcVar;
        this.zzc = zzfcyVar;
        this.zzb = zzfdwVar;
        zzfcyVar.zzb(new zzfdt(this));
    }

    public static /* synthetic */ void zzc(zzfdy zzfdyVar) {
        synchronized (zzfdyVar) {
            zzfdyVar.zzf = 1;
            zzfdyVar.zzh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzh() {
        zzfdx zzfdxVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgl)).booleanValue() && !com.google.android.gms.ads.internal.zzv.zzp().zzi().zzg().zzh()) {
            this.zzd.clear();
            return;
        }
        if (zzi()) {
            while (true) {
                ArrayDeque arrayDeque = this.zzd;
                if (!arrayDeque.isEmpty()) {
                    zzfdxVar = (zzfdx) arrayDeque.pollFirst();
                    if (zzfdxVar == null || (zzfdxVar.zza() != null && this.zza.zze(zzfdxVar.zza()))) {
                        break;
                    }
                }
            }
            zzfee zzfeeVar = new zzfee(this.zza, this.zzb, zzfdxVar);
            this.zze = zzfeeVar;
            zzfeeVar.zzd(new zzfdu(this, zzfdxVar));
        }
    }

    private final synchronized boolean zzi() {
        return this.zze == null;
    }

    public final synchronized ListenableFuture zza(zzfdx zzfdxVar) {
        this.zzf = 2;
        if (zzi()) {
            return null;
        }
        return this.zze.zzc(zzfdxVar);
    }

    public final synchronized void zzf(zzfdx zzfdxVar) {
        this.zzd.add(zzfdxVar);
    }
}
