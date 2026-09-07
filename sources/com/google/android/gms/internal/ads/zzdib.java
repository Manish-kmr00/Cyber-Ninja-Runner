package com.google.android.gms.internal.ads;

import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes14.dex */
public final class zzdib {
    public static final zzdib zza = new zzdib(new zzdhz());
    private final zzbgu zzb;
    private final zzbgr zzc;
    private final zzbhh zzd;
    private final zzbhe zze;
    private final zzbmc zzf;
    private final SimpleArrayMap zzg;
    private final SimpleArrayMap zzh;

    private zzdib(zzdhz zzdhzVar) {
        this.zzb = zzdhzVar.zza;
        this.zzc = zzdhzVar.zzb;
        this.zzd = zzdhzVar.zzc;
        this.zzg = new SimpleArrayMap(zzdhzVar.zzf);
        this.zzh = new SimpleArrayMap(zzdhzVar.zzg);
        this.zze = zzdhzVar.zzd;
        this.zzf = zzdhzVar.zze;
    }

    public final zzbgr zza() {
        return this.zzc;
    }

    public final zzbgu zzb() {
        return this.zzb;
    }

    public final zzbgx zzc(String str) {
        return (zzbgx) this.zzh.get(str);
    }

    public final zzbha zzd(String str) {
        if (str == null) {
            return null;
        }
        return (zzbha) this.zzg.get(str);
    }

    public final zzbhe zze() {
        return this.zze;
    }

    public final zzbhh zzf() {
        return this.zzd;
    }

    public final zzbmc zzg() {
        return this.zzf;
    }

    public final ArrayList zzh() {
        SimpleArrayMap simpleArrayMap = this.zzg;
        ArrayList arrayList = new ArrayList(simpleArrayMap.size());
        for (int i = 0; i < simpleArrayMap.size(); i++) {
            arrayList.add((String) simpleArrayMap.keyAt(i));
        }
        return arrayList;
    }

    public final ArrayList zzi() {
        ArrayList arrayList = new ArrayList();
        if (this.zzd != null) {
            arrayList.add(Integer.toString(6));
        }
        if (this.zzb != null) {
            arrayList.add(Integer.toString(1));
        }
        if (this.zzc != null) {
            arrayList.add(Integer.toString(2));
        }
        if (!this.zzg.isEmpty()) {
            arrayList.add(Integer.toString(3));
        }
        if (this.zzf != null) {
            arrayList.add(Integer.toString(7));
        }
        return arrayList;
    }
}
