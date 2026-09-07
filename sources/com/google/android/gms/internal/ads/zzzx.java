package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzzx {
    private static final Comparator zza = new Comparator() { // from class: com.google.android.gms.internal.ads.zzzt
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return ((zzzv) obj).zza - ((zzzv) obj2).zza;
        }
    };
    private static final Comparator zzb = new Comparator() { // from class: com.google.android.gms.internal.ads.zzzu
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return Float.compare(((zzzv) obj).zzc, ((zzzv) obj2).zzc);
        }
    };
    private int zzf;
    private int zzg;
    private int zzh;
    private final zzzv[] zzd = new zzzv[5];
    private final ArrayList zzc = new ArrayList();
    private int zze = -1;

    public zzzx(int i) {
    }

    public final float zza(float f) {
        int i = 0;
        if (this.zze != 0) {
            Collections.sort(this.zzc, zzb);
            this.zze = 0;
        }
        float f2 = this.zzg;
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.zzc;
            if (i >= arrayList.size()) {
                if (arrayList.isEmpty()) {
                    return Float.NaN;
                }
                return ((zzzv) arrayList.get(arrayList.size() - 1)).zzc;
            }
            float f3 = 0.5f * f2;
            zzzv zzzvVar = (zzzv) arrayList.get(i);
            i2 += zzzvVar.zzb;
            if (i2 >= f3) {
                return zzzvVar.zzc;
            }
            i++;
        }
    }

    public final void zzb(int i, float f) {
        zzzv zzzvVar;
        if (this.zze != 1) {
            Collections.sort(this.zzc, zza);
            this.zze = 1;
        }
        int i2 = this.zzh;
        if (i2 > 0) {
            zzzv[] zzzvVarArr = this.zzd;
            int i3 = i2 - 1;
            this.zzh = i3;
            zzzvVar = zzzvVarArr[i3];
        } else {
            zzzvVar = new zzzv(null);
        }
        int i4 = this.zzf;
        this.zzf = i4 + 1;
        zzzvVar.zza = i4;
        zzzvVar.zzb = i;
        zzzvVar.zzc = f;
        ArrayList arrayList = this.zzc;
        arrayList.add(zzzvVar);
        this.zzg += i;
        while (true) {
            int i5 = this.zzg;
            if (i5 <= 2000) {
                return;
            }
            int i6 = i5 - 2000;
            zzzv zzzvVar2 = (zzzv) arrayList.get(0);
            int i7 = zzzvVar2.zzb;
            if (i7 <= i6) {
                this.zzg -= i7;
                arrayList.remove(0);
                int i8 = this.zzh;
                if (i8 < 5) {
                    zzzv[] zzzvVarArr2 = this.zzd;
                    this.zzh = i8 + 1;
                    zzzvVarArr2[i8] = zzzvVar2;
                }
            } else {
                zzzvVar2.zzb = i7 - i6;
                this.zzg -= i6;
            }
        }
    }

    public final void zzc() {
        this.zzc.clear();
        this.zze = -1;
        this.zzf = 0;
        this.zzg = 0;
    }
}
