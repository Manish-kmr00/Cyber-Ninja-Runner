package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzgnr {
    private final Class zza;
    private final zzgvs zzb;

    /* synthetic */ zzgnr(Class cls, zzgvs zzgvsVar, zzgnt zzgntVar) {
        this.zza = cls;
        this.zzb = zzgvsVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgnr)) {
            return false;
        }
        zzgnr zzgnrVar = (zzgnr) obj;
        return zzgnrVar.zza.equals(this.zza) && zzgnrVar.zzb.equals(this.zzb);
    }

    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb);
    }

    public final String toString() {
        zzgvs zzgvsVar = this.zzb;
        return this.zza.getSimpleName() + ", object identifier: " + String.valueOf(zzgvsVar);
    }
}
