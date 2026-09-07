package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
final class zzhae implements Iterator {
    final /* synthetic */ zzhah zza;
    private int zzb = -1;
    private boolean zzc;
    private Iterator zzd;

    /* synthetic */ zzhae(zzhah zzhahVar, zzhag zzhagVar) {
        this.zza = zzhahVar;
    }

    private final Iterator zza() {
        if (this.zzd == null) {
            this.zzd = this.zza.zzc.entrySet().iterator();
        }
        return this.zzd;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.zzb + 1;
        zzhah zzhahVar = this.zza;
        if (i >= zzhahVar.zzb) {
            return !zzhahVar.zzc.isEmpty() && zza().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i = this.zzb + 1;
        this.zzb = i;
        zzhah zzhahVar = this.zza;
        return i < zzhahVar.zzb ? (zzhad) zzhahVar.zza[i] : (Map.Entry) zza().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        zzhah zzhahVar = this.zza;
        zzhahVar.zzo();
        int i = this.zzb;
        if (i >= zzhahVar.zzb) {
            zza().remove();
        } else {
            this.zzb = i - 1;
            zzhahVar.zzm(i);
        }
    }
}
