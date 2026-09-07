package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzex extends zzfa {
    public final long zza;
    public final List zzb;
    public final List zzc;

    public zzex(int i, long j) {
        super(i, null);
        this.zza = j;
        this.zzb = new ArrayList();
        this.zzc = new ArrayList();
    }

    @Override // com.google.android.gms.internal.ads.zzfa
    public final String toString() {
        List list = this.zzb;
        return zze(this.zzd) + " leaves: " + Arrays.toString(list.toArray()) + " containers: " + Arrays.toString(this.zzc.toArray());
    }

    public final zzex zza(int i) {
        List list = this.zzc;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzex zzexVar = (zzex) list.get(i2);
            if (zzexVar.zzd == i) {
                return zzexVar;
            }
        }
        return null;
    }

    public final zzey zzb(int i) {
        List list = this.zzb;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzey zzeyVar = (zzey) list.get(i2);
            if (zzeyVar.zzd == i) {
                return zzeyVar;
            }
        }
        return null;
    }

    public final void zzc(zzex zzexVar) {
        this.zzc.add(zzexVar);
    }

    public final void zzd(zzey zzeyVar) {
        this.zzb.add(zzeyVar);
    }
}
