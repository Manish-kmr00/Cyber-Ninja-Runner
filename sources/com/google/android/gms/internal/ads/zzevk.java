package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzevk implements zzhey {
    public static zzesy zza(Context context, zzbyo zzbyoVar, zzbyp zzbypVar, Object obj, zzeub zzeubVar, zzeuv zzeuvVar, zzhes zzhesVar, zzhes zzhesVar2, zzhes zzhesVar3, zzhes zzhesVar4, zzhes zzhesVar5, zzhes zzhesVar6, zzhes zzhesVar7, Executor executor, zzfgn zzfgnVar, zzdre zzdreVar) {
        HashSet hashSet = new HashSet();
        hashSet.add((zzeuo) obj);
        hashSet.add(zzeubVar);
        hashSet.add(zzeuvVar);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfO)).booleanValue()) {
            hashSet.add((zzesv) zzhesVar.zzb());
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfP)).booleanValue()) {
            hashSet.add((zzesv) zzhesVar2.zzb());
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfR)).booleanValue()) {
            hashSet.add((zzesv) zzhesVar4.zzb());
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfS)).booleanValue()) {
            hashSet.add((zzesv) zzhesVar5.zzb());
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdk)).booleanValue()) {
            hashSet.add((zzesv) zzhesVar7.zzb());
        }
        return new zzesy(context, executor, hashSet, zzfgnVar, zzdreVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* bridge */ /* synthetic */ Object zzb() {
        throw null;
    }
}
