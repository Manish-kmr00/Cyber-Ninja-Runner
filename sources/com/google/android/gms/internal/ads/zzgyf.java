package com.google.android.gms.internal.ads;

import java.util.AbstractList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzgyf extends AbstractList {
    private final zzgyd zza;
    private final zzgye zzb;

    public zzgyf(zzgyd zzgydVar, zzgye zzgyeVar) {
        this.zza = zzgydVar;
        this.zzb = zzgyeVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return this.zzb.zzb(this.zza.zzd(i));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }
}
