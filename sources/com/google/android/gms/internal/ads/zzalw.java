package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzalw implements zzajv {
    private final List zza;
    private final long[] zzb;
    private final long[] zzc;

    public zzalw(List list) {
        this.zza = Collections.unmodifiableList(new ArrayList(list));
        int size = list.size();
        this.zzb = new long[size + size];
        for (int i = 0; i < list.size(); i++) {
            zzall zzallVar = (zzall) list.get(i);
            long[] jArr = this.zzb;
            int i2 = i + i;
            jArr[i2] = zzallVar.zzb;
            jArr[i2 + 1] = zzallVar.zzc;
        }
        long[] jArr2 = this.zzb;
        long[] jArrCopyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.zzc = jArrCopyOf;
        Arrays.sort(jArrCopyOf);
    }

    @Override // com.google.android.gms.internal.ads.zzajv
    public final int zza() {
        return this.zzc.length;
    }

    @Override // com.google.android.gms.internal.ads.zzajv
    public final long zzb(int i) {
        zzdc.zzd(i >= 0);
        long[] jArr = this.zzc;
        zzdc.zzd(i < jArr.length);
        return jArr[i];
    }

    @Override // com.google.android.gms.internal.ads.zzajv
    public final List zzc(long j) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        while (true) {
            List list = this.zza;
            if (i >= list.size()) {
                break;
            }
            long[] jArr = this.zzb;
            int i2 = i + i;
            if (jArr[i2] <= j && j < jArr[i2 + 1]) {
                zzall zzallVar = (zzall) list.get(i);
                zzcu zzcuVar = zzallVar.zza;
                if (zzcuVar.zze == -3.4028235E38f) {
                    arrayList2.add(zzallVar);
                } else {
                    arrayList.add(zzcuVar);
                }
            }
            i++;
        }
        Collections.sort(arrayList2, new Comparator() { // from class: com.google.android.gms.internal.ads.zzalv
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Long.compare(((zzall) obj).zzb, ((zzall) obj2).zzb);
            }
        });
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            zzcs zzcsVarZzb = ((zzall) arrayList2.get(i3)).zza.zzb();
            zzcsVarZzb.zze((-1) - i3, 1);
            arrayList.add(zzcsVarZzb.zzp());
        }
        return arrayList;
    }
}
