package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzok {
    private final zzbj zza;
    private zzfww zzb = zzfww.zzn();
    private zzfwz zzc = zzfwz.zzd();
    private zzuy zzd;
    private zzuy zze;
    private zzuy zzf;

    public zzok(zzbj zzbjVar) {
        this.zza = zzbjVar;
    }

    private static zzuy zzj(zzbh zzbhVar, zzfww zzfwwVar, zzuy zzuyVar, zzbj zzbjVar) {
        zzbl zzblVarZzo = zzbhVar.zzo();
        int iZzf = zzbhVar.zzf();
        Object objZzf = zzblVarZzo.zzo() ? null : zzblVarZzo.zzf(iZzf);
        int iZzc = (zzbhVar.zzx() || zzblVarZzo.zzo()) ? -1 : zzblVarZzo.zzd(iZzf, zzbjVar, false).zzc(zzeu.zzs(zzbhVar.zzl()));
        for (int i = 0; i < zzfwwVar.size(); i++) {
            zzuy zzuyVar2 = (zzuy) zzfwwVar.get(i);
            if (zzm(zzuyVar2, objZzf, zzbhVar.zzx(), zzbhVar.zzc(), zzbhVar.zzd(), iZzc)) {
                return zzuyVar2;
            }
        }
        if (zzfwwVar.isEmpty() && zzuyVar != null) {
            if (zzm(zzuyVar, objZzf, zzbhVar.zzx(), zzbhVar.zzc(), zzbhVar.zzd(), iZzc)) {
                return zzuyVar;
            }
        }
        return null;
    }

    private final void zzk(zzfwy zzfwyVar, zzuy zzuyVar, zzbl zzblVar) {
        if (zzuyVar == null) {
            return;
        }
        if (zzblVar.zza(zzuyVar.zza) != -1) {
            zzfwyVar.zza(zzuyVar, zzblVar);
            return;
        }
        zzbl zzblVar2 = (zzbl) this.zzc.get(zzuyVar);
        if (zzblVar2 != null) {
            zzfwyVar.zza(zzuyVar, zzblVar2);
        }
    }

    private final void zzl(zzbl zzblVar) {
        zzfwy zzfwyVar = new zzfwy();
        if (this.zzb.isEmpty()) {
            zzk(zzfwyVar, this.zze, zzblVar);
            if (!Objects.equals(this.zzf, this.zze)) {
                zzk(zzfwyVar, this.zzf, zzblVar);
            }
            if (!Objects.equals(this.zzd, this.zze) && !Objects.equals(this.zzd, this.zzf)) {
                zzk(zzfwyVar, this.zzd, zzblVar);
            }
        } else {
            for (int i = 0; i < this.zzb.size(); i++) {
                zzk(zzfwyVar, (zzuy) this.zzb.get(i), zzblVar);
            }
            if (!this.zzb.contains(this.zzd)) {
                zzk(zzfwyVar, this.zzd, zzblVar);
            }
        }
        this.zzc = zzfwyVar.zzc();
    }

    private static boolean zzm(zzuy zzuyVar, Object obj, boolean z, int i, int i2, int i3) {
        if (!zzuyVar.zza.equals(obj)) {
            return false;
        }
        if (z) {
            if (zzuyVar.zzb != i || zzuyVar.zzc != i2) {
                return false;
            }
        } else if (zzuyVar.zzb != -1 || zzuyVar.zze != i3) {
            return false;
        }
        return true;
    }

    public final zzbl zza(zzuy zzuyVar) {
        return (zzbl) this.zzc.get(zzuyVar);
    }

    public final zzuy zzb() {
        return this.zzd;
    }

    public final zzuy zzc() {
        Object next;
        Object obj;
        if (this.zzb.isEmpty()) {
            return null;
        }
        zzfww zzfwwVar = this.zzb;
        if (zzfwwVar instanceof List) {
            zzfww zzfwwVar2 = zzfwwVar;
            if (zzfwwVar2.isEmpty()) {
                throw new NoSuchElementException();
            }
            obj = zzfwwVar2.get(zzfwwVar2.size() - 1);
        } else {
            Iterator<E> it = zzfwwVar.iterator();
            do {
                next = it.next();
            } while (it.hasNext());
            obj = next;
        }
        return (zzuy) obj;
    }

    public final zzuy zzd() {
        return this.zze;
    }

    public final zzuy zze() {
        return this.zzf;
    }

    public final void zzg(zzbh zzbhVar) {
        this.zzd = zzj(zzbhVar, this.zzb, this.zze, this.zza);
    }

    public final void zzh(List list, zzuy zzuyVar, zzbh zzbhVar) {
        this.zzb = zzfww.zzl(list);
        if (!list.isEmpty()) {
            this.zze = (zzuy) list.get(0);
            zzuyVar.getClass();
            this.zzf = zzuyVar;
        }
        if (this.zzd == null) {
            this.zzd = zzj(zzbhVar, this.zzb, this.zze, this.zza);
        }
        zzl(zzbhVar.zzo());
    }

    public final void zzi(zzbh zzbhVar) {
        this.zzd = zzj(zzbhVar, this.zzb, this.zze, this.zza);
        zzl(zzbhVar.zzo());
    }
}
