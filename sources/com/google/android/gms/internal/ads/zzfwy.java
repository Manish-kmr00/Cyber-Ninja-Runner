package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzfwy {
    Object[] zza;
    int zzb;
    zzfwx zzc;

    public zzfwy() {
        this(4);
    }

    private final void zzd(int i) {
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i2 = i + i;
        if (i2 > length) {
            this.zza = Arrays.copyOf(objArr, zzfwq.zze(length, i2));
        }
    }

    public final zzfwy zza(Object obj, Object obj2) {
        zzd(this.zzb + 1);
        zzfvt.zzb(obj, obj2);
        Object[] objArr = this.zza;
        int i = this.zzb;
        int i2 = i + i;
        objArr[i2] = obj;
        objArr[i2 + 1] = obj2;
        this.zzb = i + 1;
        return this;
    }

    public final zzfwy zzb(Iterable iterable) {
        if (iterable instanceof Collection) {
            zzd(this.zzb + ((Collection) iterable).size());
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            zza(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public final zzfwz zzc() {
        zzfwx zzfwxVar = this.zzc;
        if (zzfwxVar != null) {
            throw zzfwxVar.zza();
        }
        zzfyn zzfynVarZzj = zzfyn.zzj(this.zzb, this.zza, this);
        zzfwx zzfwxVar2 = this.zzc;
        if (zzfwxVar2 == null) {
            return zzfynVarZzj;
        }
        throw zzfwxVar2.zza();
    }

    zzfwy(int i) {
        this.zza = new Object[i + i];
        this.zzb = 0;
    }
}
