package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzgms implements Iterable {
    final /* synthetic */ List zza;
    final /* synthetic */ List zzb;

    zzgms(zzgmw zzgmwVar, List list, List list2) {
        this.zza = list;
        this.zzb = list2;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new zzgmu(this.zza.iterator(), this.zzb.iterator(), null);
    }
}
