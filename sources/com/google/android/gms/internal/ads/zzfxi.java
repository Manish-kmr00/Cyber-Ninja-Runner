package com.google.android.gms.internal.ads;

import java.util.ListIterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzfxi extends zzfzb {
    final /* synthetic */ zzfxj zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfxi(zzfxj zzfxjVar, ListIterator listIterator) {
        super(listIterator);
        this.zza = zzfxjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfza
    final Object zza(Object obj) {
        return this.zza.zzb.apply(obj);
    }
}
