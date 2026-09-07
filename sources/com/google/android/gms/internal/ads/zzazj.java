package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
final class zzazj implements Comparator {
    zzazj(zzazl zzazlVar) {
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzazp zzazpVar = (zzazp) obj;
        zzazp zzazpVar2 = (zzazp) obj2;
        int i = zzazpVar.zzc - zzazpVar2.zzc;
        return i != 0 ? i : Long.compare(zzazpVar.zza, zzazpVar2.zza);
    }
}
