package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
final class zzfjh implements Comparator {
    final /* synthetic */ zzfjn zza;

    zzfjh(zzfjn zzfjnVar) {
        this.zza = zzfjnVar;
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzfjf zzfjfVar = (zzfjf) obj;
        zzfjf zzfjfVar2 = (zzfjf) obj2;
        Object objZzc = zzfjfVar2.zzc();
        zzfjn zzfjnVar = this.zza;
        int iCompare = Double.compare(zzfjn.zzc(zzfjnVar, zzfjnVar.zza(objZzc)), zzfjn.zzc(zzfjnVar, zzfjnVar.zza(zzfjfVar.zzc())));
        return iCompare == 0 ? Long.compare(zzfjfVar.zzb(), zzfjfVar2.zzb()) : iCompare;
    }
}
