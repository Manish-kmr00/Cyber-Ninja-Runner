package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzku {
    public final long zza;
    public final float zzb;
    public final long zzc;

    /* synthetic */ zzku(zzks zzksVar, zzkt zzktVar) {
        this.zza = zzksVar.zza;
        this.zzb = zzksVar.zzb;
        this.zzc = zzksVar.zzc;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzku)) {
            return false;
        }
        zzku zzkuVar = (zzku) obj;
        return this.zza == zzkuVar.zza && this.zzb == zzkuVar.zzb && this.zzc == zzkuVar.zzc;
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.zza), Float.valueOf(this.zzb), Long.valueOf(this.zzc));
    }

    public final zzks zza() {
        return new zzks(this, null);
    }
}
