package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzgns {
    private final Class zza;
    private final Class zzb;

    /* synthetic */ zzgns(Class cls, Class cls2, zzgnt zzgntVar) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgns)) {
            return false;
        }
        zzgns zzgnsVar = (zzgns) obj;
        return zzgnsVar.zza.equals(this.zza) && zzgnsVar.zzb.equals(this.zzb);
    }

    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb);
    }

    public final String toString() {
        Class cls = this.zzb;
        return this.zza.getSimpleName() + " with serialization type: " + cls.getSimpleName();
    }
}
