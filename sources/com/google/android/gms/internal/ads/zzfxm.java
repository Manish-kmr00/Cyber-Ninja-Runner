package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzfxm {
    public static ArrayList zza(int i) {
        zzfvt.zza(i, "initialArraySize");
        return new ArrayList(i);
    }

    public static List zzb(List list, zzftl zzftlVar) {
        return list instanceof RandomAccess ? new zzfxj(list, zzftlVar) : new zzfxl(list, zzftlVar);
    }
}
