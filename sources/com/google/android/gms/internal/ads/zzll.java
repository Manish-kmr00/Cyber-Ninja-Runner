package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzll {
    private final zzoz zza;
    private final zzlk zze;
    private final zzmg zzh;
    private final zzdq zzi;
    private boolean zzj;
    private zzhe zzk;
    private zzwv zzl = new zzwv(0);
    private final IdentityHashMap zzc = new IdentityHashMap();
    private final Map zzd = new HashMap();
    private final List zzb = new ArrayList();
    private final HashMap zzf = new HashMap();
    private final Set zzg = new HashSet();

    public zzll(zzlk zzlkVar, zzmg zzmgVar, zzdq zzdqVar, zzoz zzozVar) {
        this.zza = zzozVar;
        this.zze = zzlkVar;
        this.zzh = zzmgVar;
        this.zzi = zzdqVar;
    }

    private final void zzr(int i, int i2) {
        while (true) {
            List list = this.zzb;
            if (i >= list.size()) {
                return;
            }
            ((zzlj) list.get(i)).zzd += i2;
            i++;
        }
    }

    private final void zzs(zzlj zzljVar) {
        zzli zzliVar = (zzli) this.zzf.get(zzljVar);
        if (zzliVar != null) {
            zzliVar.zza.zzi(zzliVar.zzb);
        }
    }

    private final void zzt() {
        Iterator it = this.zzg.iterator();
        while (it.hasNext()) {
            zzlj zzljVar = (zzlj) it.next();
            if (zzljVar.zzc.isEmpty()) {
                zzs(zzljVar);
                it.remove();
            }
        }
    }

    private final void zzu(zzlj zzljVar) {
        if (zzljVar.zze && zzljVar.zzc.isEmpty()) {
            zzli zzliVar = (zzli) this.zzf.remove(zzljVar);
            zzliVar.getClass();
            zzva zzvaVar = zzliVar.zza;
            zzvaVar.zzp(zzliVar.zzb);
            zzlh zzlhVar = zzliVar.zzc;
            zzvaVar.zzs(zzlhVar);
            zzvaVar.zzr(zzlhVar);
            this.zzg.remove(zzljVar);
        }
    }

    private final void zzv(zzlj zzljVar) {
        zzut zzutVar = zzljVar.zza;
        zzuz zzuzVar = new zzuz() { // from class: com.google.android.gms.internal.ads.zzlb
            @Override // com.google.android.gms.internal.ads.zzuz
            public final void zza(zzva zzvaVar, zzbl zzblVar) {
                this.zza.zze.zzk();
            }
        };
        zzlh zzlhVar = new zzlh(this, zzljVar);
        this.zzf.put(zzljVar, new zzli(zzutVar, zzuzVar, zzlhVar));
        zzutVar.zzh(new Handler(zzeu.zzz(), null), zzlhVar);
        zzutVar.zzg(new Handler(zzeu.zzz(), null), zzlhVar);
        zzutVar.zzm(zzuzVar, this.zzk, this.zza);
    }

    private final void zzw(int i, int i2) {
        while (true) {
            i2--;
            if (i2 < i) {
                return;
            }
            zzlj zzljVar = (zzlj) this.zzb.remove(i2);
            this.zzd.remove(zzljVar.zzb);
            zzr(i2, -zzljVar.zza.zzC().zzc());
            zzljVar.zze = true;
            if (this.zzj) {
                zzu(zzljVar);
            }
        }
    }

    public final int zza() {
        return this.zzb.size();
    }

    public final zzbl zzb() {
        List list = this.zzb;
        if (list.isEmpty()) {
            return zzbl.zza;
        }
        int iZzc = 0;
        for (int i = 0; i < list.size(); i++) {
            zzlj zzljVar = (zzlj) list.get(i);
            zzljVar.zzd = iZzc;
            iZzc += zzljVar.zza.zzC().zzc();
        }
        return new zzls(list, this.zzl);
    }

    public final zzbl zzc(int i, int i2, List list) {
        zzdc.zzd(i >= 0 && i <= i2 && i2 <= zza());
        zzdc.zzd(list.size() == i2 - i);
        for (int i3 = i; i3 < i2; i3++) {
            ((zzlj) this.zzb.get(i3)).zza.zzt((zzap) list.get(i3 - i));
        }
        return zzb();
    }

    public final void zzg(zzhe zzheVar) {
        zzdc.zzf(!this.zzj);
        this.zzk = zzheVar;
        int i = 0;
        while (true) {
            List list = this.zzb;
            if (i >= list.size()) {
                this.zzj = true;
                return;
            }
            zzlj zzljVar = (zzlj) list.get(i);
            zzv(zzljVar);
            this.zzg.add(zzljVar);
            i++;
        }
    }

    public final void zzh() {
        for (zzli zzliVar : this.zzf.values()) {
            try {
                zzliVar.zza.zzp(zzliVar.zzb);
            } catch (RuntimeException e) {
                zzdx.zzd("MediaSourceList", "Failed to release child source.", e);
            }
            zzva zzvaVar = zzliVar.zza;
            zzlh zzlhVar = zzliVar.zzc;
            zzvaVar.zzs(zzlhVar);
            zzvaVar.zzr(zzlhVar);
        }
        this.zzf.clear();
        this.zzg.clear();
        this.zzj = false;
    }

    public final void zzi(zzuw zzuwVar) {
        IdentityHashMap identityHashMap = this.zzc;
        zzlj zzljVar = (zzlj) identityHashMap.remove(zzuwVar);
        zzljVar.getClass();
        zzljVar.zza.zzG(zzuwVar);
        zzljVar.zzc.remove(((zzuq) zzuwVar).zza);
        if (!identityHashMap.isEmpty()) {
            zzt();
        }
        zzu(zzljVar);
    }

    public final boolean zzj() {
        return this.zzj;
    }

    public final zzbl zzk(int i, List list, zzwv zzwvVar) {
        if (!list.isEmpty()) {
            this.zzl = zzwvVar;
            for (int i2 = i; i2 < list.size() + i; i2++) {
                zzlj zzljVar = (zzlj) list.get(i2 - i);
                if (i2 > 0) {
                    zzlj zzljVar2 = (zzlj) this.zzb.get(i2 - 1);
                    zzljVar.zzc(zzljVar2.zzd + zzljVar2.zza.zzC().zzc());
                } else {
                    zzljVar.zzc(0);
                }
                zzr(i2, zzljVar.zza.zzC().zzc());
                this.zzb.add(i2, zzljVar);
                this.zzd.put(zzljVar.zzb, zzljVar);
                if (this.zzj) {
                    zzv(zzljVar);
                    if (this.zzc.isEmpty()) {
                        this.zzg.add(zzljVar);
                    } else {
                        zzs(zzljVar);
                    }
                }
            }
        }
        return zzb();
    }

    public final zzbl zzl(int i, int i2, int i3, zzwv zzwvVar) {
        zzdc.zzd(zza() >= 0);
        this.zzl = null;
        return zzb();
    }

    public final zzbl zzm(int i, int i2, zzwv zzwvVar) {
        boolean z = false;
        if (i >= 0 && i <= i2 && i2 <= zza()) {
            z = true;
        }
        zzdc.zzd(z);
        this.zzl = zzwvVar;
        zzw(i, i2);
        return zzb();
    }

    public final zzbl zzn(List list, zzwv zzwvVar) {
        List list2 = this.zzb;
        zzw(0, list2.size());
        return zzk(list2.size(), list, zzwvVar);
    }

    public final zzbl zzo(zzwv zzwvVar) {
        int iZza = zza();
        if (zzwvVar.zzc() != iZza) {
            zzwvVar = zzwvVar.zzf().zzg(0, iZza);
        }
        this.zzl = zzwvVar;
        return zzb();
    }

    public final zzuw zzp(zzuy zzuyVar, zzze zzzeVar, long j) {
        int i = zzls.zzb;
        Pair pair = (Pair) zzuyVar.zza;
        Object obj = pair.first;
        zzuy zzuyVarZza = zzuyVar.zza(pair.second);
        zzlj zzljVar = (zzlj) this.zzd.get(obj);
        zzljVar.getClass();
        this.zzg.add(zzljVar);
        zzli zzliVar = (zzli) this.zzf.get(zzljVar);
        if (zzliVar != null) {
            zzliVar.zza.zzk(zzliVar.zzb);
        }
        zzljVar.zzc.add(zzuyVarZza);
        zzuq zzuqVarZzI = zzljVar.zza.zzI(zzuyVarZza, zzzeVar, j);
        this.zzc.put(zzuqVarZzI, zzljVar);
        zzt();
        return zzuqVarZzI;
    }

    public final zzwv zzq() {
        return this.zzl;
    }
}
