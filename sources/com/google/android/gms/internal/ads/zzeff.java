package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
final class zzeff {
    private final zzgcm zzc;
    private zzefv zzf;
    private final String zzh;
    private final int zzi;
    private final zzefu zzj;
    private zzfau zzk;
    private final Map zza = new HashMap();
    private final List zzb = new ArrayList();
    private final List zzd = new ArrayList();
    private final Set zze = new HashSet();
    private int zzg = Integer.MAX_VALUE;
    private boolean zzl = false;

    zzeff(zzfbg zzfbgVar, zzefu zzefuVar, zzgcm zzgcmVar) {
        this.zzi = zzfbgVar.zzb.zzb.zzr;
        this.zzj = zzefuVar;
        this.zzc = zzgcmVar;
        this.zzh = zzegb.zzc(zzfbgVar);
        List list = zzfbgVar.zzb.zza;
        for (int i = 0; i < list.size(); i++) {
            this.zza.put((zzfau) list.get(i), Integer.valueOf(i));
        }
        this.zzb.addAll(list);
    }

    private final synchronized void zze() {
        this.zzj.zzi(this.zzk);
        zzefv zzefvVar = this.zzf;
        if (zzefvVar != null) {
            this.zzc.zzc(zzefvVar);
        } else {
            this.zzc.zzd(new zzefy(3, this.zzh));
        }
    }

    private final synchronized boolean zzf(boolean z) {
        for (zzfau zzfauVar : this.zzb) {
            Integer num = (Integer) this.zza.get(zzfauVar);
            Integer numValueOf = Integer.valueOf(num != null ? num.intValue() : Integer.MAX_VALUE);
            if (z || !this.zze.contains(zzfauVar.zzat)) {
                if (numValueOf.intValue() < this.zzg) {
                    return true;
                }
                if (numValueOf.intValue() > this.zzg) {
                    break;
                }
            }
        }
        return false;
    }

    private final synchronized boolean zzg() {
        Iterator it = this.zzd.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) this.zza.get((zzfau) it.next());
            if (Integer.valueOf(num != null ? num.intValue() : Integer.MAX_VALUE).intValue() < this.zzg) {
                return true;
            }
        }
        return false;
    }

    private final synchronized boolean zzh() {
        return zzf(true) || zzg();
    }

    private final synchronized boolean zzi() {
        if (this.zzl) {
            return false;
        }
        List list = this.zzb;
        if (!list.isEmpty() && ((zzfau) list.get(0)).zzav && !this.zzd.isEmpty()) {
            return false;
        }
        if (!zzd()) {
            List list2 = this.zzd;
            if (list2.size() < this.zzi && zzf(false)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    final synchronized zzfau zza() {
        if (zzi()) {
            int i = 0;
            while (true) {
                List list = this.zzb;
                if (i >= list.size()) {
                    break;
                }
                zzfau zzfauVar = (zzfau) list.get(i);
                String str = zzfauVar.zzat;
                Set set = this.zze;
                if (!set.contains(str)) {
                    if (zzfauVar.zzav) {
                        this.zzl = true;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        set.add(str);
                    }
                    this.zzd.add(zzfauVar);
                    return (zzfau) list.remove(i);
                }
                i++;
            }
        }
        return null;
    }

    final synchronized void zzb(Throwable th, zzfau zzfauVar) {
        this.zzl = false;
        this.zzd.remove(zzfauVar);
        this.zze.remove(zzfauVar.zzat);
        if (zzd() || zzh()) {
            return;
        }
        zze();
    }

    final synchronized void zzc(zzefv zzefvVar, zzfau zzfauVar) {
        this.zzl = false;
        this.zzd.remove(zzfauVar);
        if (zzd()) {
            zzefvVar.zzq();
            return;
        }
        Integer num = (Integer) this.zza.get(zzfauVar);
        Integer numValueOf = Integer.valueOf(num != null ? num.intValue() : Integer.MAX_VALUE);
        if (numValueOf.intValue() > this.zzg) {
            this.zzj.zzm(zzfauVar);
            return;
        }
        if (this.zzf != null) {
            this.zzj.zzm(this.zzk);
        }
        this.zzg = numValueOf.intValue();
        this.zzf = zzefvVar;
        this.zzk = zzfauVar;
        if (zzh()) {
            return;
        }
        zze();
    }

    final synchronized boolean zzd() {
        return this.zzc.isDone();
    }
}
