package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzeyd implements zzftl {
    final /* synthetic */ zzeyh zza;

    zzeyd(zzeyh zzeyhVar) {
        this.zza = zzeyhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzftl
    @NullableDecl
    public final /* bridge */ /* synthetic */ Object apply(@NullableDecl Object obj) {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzh("", (zzdxq) obj);
        com.google.android.gms.ads.internal.util.zze.zza("Failed to get a cache key, reverting to legacy flow.");
        zzeyh zzeyhVar = this.zza;
        zzeyhVar.zzd = new zzeyf(null, zzeyhVar.zze(), null);
        return zzeyhVar.zzd;
    }
}
