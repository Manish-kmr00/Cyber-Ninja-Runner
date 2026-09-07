package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzfxb extends zzfwr implements Set {
    private transient zzfww zza;

    zzfxb() {
    }

    static int zzh(int i) {
        int iMax = Math.max(i, 2);
        if (iMax >= 751619276) {
            zzftw.zzf(iMax < 1073741824, "collection too large");
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1);
        do {
            iHighestOneBit += iHighestOneBit;
        } while (((double) iHighestOneBit) * 0.7d < iMax);
        return iHighestOneBit;
    }

    public static zzfxa zzj(int i) {
        return new zzfxa(i, true);
    }

    public static zzfxb zzl(Collection collection) {
        if ((collection instanceof zzfxb) && !(collection instanceof SortedSet)) {
            zzfxb zzfxbVar = (zzfxb) collection;
            if (!zzfxbVar.zzf()) {
                return zzfxbVar;
            }
        }
        Object[] array = collection.toArray();
        return zzv(array.length, array);
    }

    public static zzfxb zzm(Object[] objArr) {
        int length = objArr.length;
        if (length != 0) {
            return length != 1 ? zzv(length, (Object[]) objArr.clone()) : new zzfyz(objArr[0]);
        }
        return zzfyo.zza;
    }

    public static zzfxb zzn() {
        return zzfyo.zza;
    }

    public static zzfxb zzo(Object obj) {
        return new zzfyz(obj);
    }

    public static zzfxb zzp(Object obj, Object obj2) {
        return zzv(2, obj, obj2);
    }

    public static zzfxb zzq(Object obj, Object obj2, Object obj3) {
        return zzv(3, obj, obj2, obj3);
    }

    public static zzfxb zzr(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return zzv(5, obj, obj2, obj3, obj4, obj5);
    }

    @SafeVarargs
    public static zzfxb zzs(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object... objArr) {
        Object[] objArr2 = new Object[9];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        System.arraycopy(objArr, 0, objArr2, 6, 3);
        return zzv(9, objArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzw(int i, int i2) {
        return i < (i2 >> 1) + (i2 >> 2);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzfxb) && zzu() && ((zzfxb) obj).zzu() && hashCode() != obj.hashCode()) {
            return false;
        }
        return zzfyy.zzd(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return zzfyy.zza(this);
    }

    @Override // com.google.android.gms.internal.ads.zzfwr
    public zzfww zzd() {
        zzfww zzfwwVar = this.zza;
        if (zzfwwVar != null) {
            return zzfwwVar;
        }
        zzfww zzfwwVarZzi = zzi();
        this.zza = zzfwwVarZzi;
        return zzfwwVarZzi;
    }

    @Override // com.google.android.gms.internal.ads.zzfwr, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zze */
    public abstract zzfzc iterator();

    zzfww zzi() {
        Object[] array = toArray();
        int i = zzfww.zzd;
        return zzfww.zzj(array, array.length);
    }

    boolean zzu() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzfxb zzv(int i, Object... objArr) {
        if (i == 0) {
            return zzfyo.zza;
        }
        if (i == 1) {
            return new zzfyz(Objects.requireNonNull(objArr[0]));
        }
        int iZzh = zzh(i);
        Object[] objArr2 = new Object[iZzh];
        int i2 = iZzh - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object obj = objArr[i5];
            zzfyg.zza(obj, i5);
            int iHashCode = obj.hashCode();
            int iZza = zzfwo.zza(iHashCode);
            while (true) {
                int i6 = iZza & i2;
                Object obj2 = objArr2[i6];
                if (obj2 == null) {
                    objArr[i4] = obj;
                    objArr2[i6] = obj;
                    i3 += iHashCode;
                    i4++;
                    break;
                }
                if (obj2.equals(obj)) {
                    break;
                }
                iZza++;
            }
        }
        Arrays.fill(objArr, i4, i, (Object) null);
        if (i4 == 1) {
            return new zzfyz(Objects.requireNonNull(objArr[0]));
        }
        if (zzh(i4) < iZzh / 2) {
            return zzv(i4, objArr);
        }
        if (zzw(i4, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new zzfyo(objArr, i3, objArr2, i2, i4);
    }
}
