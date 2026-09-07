package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzeye implements zzftl {
    final /* synthetic */ zzeyh zza;

    zzeye(zzeyh zzeyhVar) {
        this.zza = zzeyhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzftl
    @NullableDecl
    public final /* bridge */ /* synthetic */ Object apply(@NullableDecl Object obj) {
        zzbuy zzbuyVar = (zzbuy) obj;
        zzeyf zzeyfVar = new zzeyf(zzbuyVar, new zzfdo(zzbuyVar.zzj), null);
        zzeyh zzeyhVar = this.zza;
        zzeyhVar.zzd = zzeyfVar;
        return zzeyhVar.zzd;
    }
}
