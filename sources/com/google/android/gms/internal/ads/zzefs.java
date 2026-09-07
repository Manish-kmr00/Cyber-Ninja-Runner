package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.MobileAds;
import java.util.LinkedHashMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
final class zzefs implements zzgbo {
    final /* synthetic */ long zza;
    final /* synthetic */ zzfax zzb;
    final /* synthetic */ zzfau zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzfik zze;
    final /* synthetic */ zzfbg zzf;
    final /* synthetic */ zzefu zzg;

    zzefs(zzefu zzefuVar, long j, zzfax zzfaxVar, zzfau zzfauVar, String str, zzfik zzfikVar, zzfbg zzfbgVar) {
        this.zza = j;
        this.zzb = zzfaxVar;
        this.zzc = zzfauVar;
        this.zzd = str;
        this.zze = zzfikVar;
        this.zzf = zzfbgVar;
        this.zzg = zzefuVar;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0061 A[PHI: r8
  0x0061: PHI (r8v1 int) = (r8v0 int), (r8v3 int), (r8v3 int), (r8v3 int) binds: [B:16:0x002f, B:21:0x004a, B:23:0x004e, B:25:0x0057] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:32:0x006a A[Catch: all -> 0x00f8, TryCatch #0 {, blocks: (B:30:0x0064, B:32:0x006a, B:34:0x0076, B:35:0x0079, B:36:0x0082, B:38:0x0094, B:39:0x00a9, B:41:0x00af, B:43:0x00b1, B:51:0x00ef, B:52:0x00f6, B:46:0x00d4, B:48:0x00d8, B:50:0x00e2), top: B:57:0x0064 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0076 A[Catch: all -> 0x00f8, TryCatch #0 {, blocks: (B:30:0x0064, B:32:0x006a, B:34:0x0076, B:35:0x0079, B:36:0x0082, B:38:0x0094, B:39:0x00a9, B:41:0x00af, B:43:0x00b1, B:51:0x00ef, B:52:0x00f6, B:46:0x00d4, B:48:0x00d8, B:50:0x00e2), top: B:57:0x0064 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x0094 A[Catch: all -> 0x00f8, TryCatch #0 {, blocks: (B:30:0x0064, B:32:0x006a, B:34:0x0076, B:35:0x0079, B:36:0x0082, B:38:0x0094, B:39:0x00a9, B:41:0x00af, B:43:0x00b1, B:51:0x00ef, B:52:0x00f6, B:46:0x00d4, B:48:0x00d8, B:50:0x00e2), top: B:57:0x0064 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00af A[Catch: all -> 0x00f8, DONT_GENERATE, TryCatch #0 {, blocks: (B:30:0x0064, B:32:0x006a, B:34:0x0076, B:35:0x0079, B:36:0x0082, B:38:0x0094, B:39:0x00a9, B:41:0x00af, B:43:0x00b1, B:51:0x00ef, B:52:0x00f6, B:46:0x00d4, B:48:0x00d8, B:50:0x00e2), top: B:57:0x0064 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00b1 A[Catch: all -> 0x00f8, TryCatch #0 {, blocks: (B:30:0x0064, B:32:0x006a, B:34:0x0076, B:35:0x0079, B:36:0x0082, B:38:0x0094, B:39:0x00a9, B:41:0x00af, B:43:0x00b1, B:51:0x00ef, B:52:0x00f6, B:46:0x00d4, B:48:0x00d8, B:50:0x00e2), top: B:57:0x0064 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzgbo
    public final void zza(Throwable th) {
        Integer numValueOf;
        int i;
        com.google.android.gms.ads.internal.client.zze zzeVarZzb;
        com.google.android.gms.ads.internal.client.zze zzeVarZza;
        int i2;
        com.google.android.gms.ads.internal.client.zze zzeVar;
        zzefu zzefuVar = this.zzg;
        long jElapsedRealtime = zzefuVar.zza.elapsedRealtime() - this.zza;
        if (th instanceof TimeoutException) {
            i = 2;
        } else if (th instanceof zzefc) {
            i = 3;
        } else {
            if (!(th instanceof CancellationException)) {
                if (th instanceof zzfbw) {
                    i = 5;
                } else {
                    int i3 = 6;
                    if (th instanceof zzdvg) {
                        i3 = zzfcq.zza(th).zza == 3 ? 1 : 6;
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbO)).booleanValue() && (th instanceof zzecj) && (zzeVarZzb = ((zzecj) th).zzb()) != null) {
                            numValueOf = Integer.valueOf(zzeVarZzb.zza);
                        } else {
                            numValueOf = null;
                        }
                    } else {
                        numValueOf = null;
                    }
                    i = i3;
                }
                synchronized (zzefuVar) {
                    if (zzefuVar.zze) {
                        zzefuVar.zzb.zza(this.zzb, this.zzc, i, th instanceof zzecj ? (zzecj) th : null, jElapsedRealtime);
                    }
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zziu)).booleanValue()) {
                        zzfio zzfioVar = zzefuVar.zzc;
                        zzfik zzfikVar = this.zze;
                        zzfbg zzfbgVar = this.zzf;
                        zzfau zzfauVar = this.zzc;
                        zzfioVar.zze(zzfikVar.zzd(zzfbgVar, zzfauVar, zzfauVar.zzn), zzfauVar.zzax);
                    }
                    if (zzefuVar.zzg) {
                        return;
                    }
                    LinkedHashMap linkedHashMap = zzefuVar.zzd;
                    zzfau zzfauVar2 = this.zzc;
                    linkedHashMap.put(zzfauVar2, new zzeft(this.zzd, zzfauVar2.zzaf, i, jElapsedRealtime, numValueOf));
                    zzeVarZza = zzfcq.zza(th);
                    i2 = zzeVarZza.zza;
                    if ((i2 != 3 || i2 == 0) && (zzeVar = zzeVarZza.zzd) != null && !zzeVar.zzc.equals(MobileAds.ERROR_DOMAIN)) {
                    }
                    zzefuVar.zzf.zzf(zzfauVar2, jElapsedRealtime, zzeVarZza);
                }
            }
            i = 4;
        }
        numValueOf = null;
        synchronized (zzefuVar) {
            if (zzefuVar.zze) {
                zzefuVar.zzb.zza(this.zzb, this.zzc, i, th instanceof zzecj ? (zzecj) th : null, jElapsedRealtime);
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zziu)).booleanValue()) {
                zzfio zzfioVar2 = zzefuVar.zzc;
                zzfik zzfikVar2 = this.zze;
                zzfbg zzfbgVar2 = this.zzf;
                zzfau zzfauVar3 = this.zzc;
                zzfioVar2.zze(zzfikVar2.zzd(zzfbgVar2, zzfauVar3, zzfauVar3.zzn), zzfauVar3.zzax);
            }
            if (zzefuVar.zzg) {
                return;
            }
            LinkedHashMap linkedHashMap2 = zzefuVar.zzd;
            zzfau zzfauVar4 = this.zzc;
            linkedHashMap2.put(zzfauVar4, new zzeft(this.zzd, zzfauVar4.zzaf, i, jElapsedRealtime, numValueOf));
            zzeVarZza = zzfcq.zza(th);
            i2 = zzeVarZza.zza;
            zzeVarZza = i2 != 3 ? zzfcq.zza(new zzecj(13, zzeVarZza.zzd)) : zzfcq.zza(new zzecj(13, zzeVarZza.zzd));
            zzefuVar.zzf.zzf(zzfauVar4, jElapsedRealtime, zzeVarZza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final void zzb(Object obj) {
        zzefu zzefuVar = this.zzg;
        long jElapsedRealtime = zzefuVar.zza.elapsedRealtime() - this.zza;
        synchronized (zzefuVar) {
            if (zzefuVar.zze) {
                zzefuVar.zzb.zza(this.zzb, this.zzc, 0, null, jElapsedRealtime);
            }
            if (zzefuVar.zzg) {
                return;
            }
            zzfau zzfauVar = this.zzc;
            if (zzefuVar.zzq(zzfauVar)) {
                ((zzeft) zzefuVar.zzd.get(zzfauVar)).zzd = jElapsedRealtime;
            } else {
                zzefuVar.zzd.put(zzfauVar, new zzeft(this.zzd, zzfauVar.zzaf, 0, jElapsedRealtime, null));
            }
            zzefuVar.zzf.zzg(zzfauVar, jElapsedRealtime, null);
        }
    }
}
