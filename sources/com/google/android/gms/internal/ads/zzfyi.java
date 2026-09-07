package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzfyi extends zzfww {
    static final zzfww zza = new zzfyi(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    zzfyi(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzftw.zza(i, this.zzc, "index");
        return Objects.requireNonNull(this.zzb[i]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzfww, com.google.android.gms.internal.ads.zzfwr
    final int zza(Object[] objArr, int i) {
        Object[] objArr2 = this.zzb;
        int i2 = this.zzc;
        System.arraycopy(objArr2, 0, objArr, i, i2);
        return i + i2;
    }

    @Override // com.google.android.gms.internal.ads.zzfwr
    final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzfwr
    final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzfwr
    final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzfwr
    final Object[] zzg() {
        return this.zzb;
    }
}
