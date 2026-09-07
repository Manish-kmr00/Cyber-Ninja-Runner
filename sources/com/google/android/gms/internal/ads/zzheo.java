package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzheo implements Iterator {
    int zza = 0;
    final /* synthetic */ zzhep zzb;

    zzheo(zzhep zzhepVar) {
        this.zzb = zzhepVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.zza;
        zzhep zzhepVar = this.zzb;
        return i < zzhepVar.zza.size() || zzhepVar.zzb.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.zza;
        zzhep zzhepVar = this.zzb;
        List list = zzhepVar.zza;
        if (i >= list.size()) {
            list.add(zzhepVar.zzb.next());
            return next();
        }
        int i2 = this.zza;
        this.zza = i2 + 1;
        return list.get(i2);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
