package com.google.android.gms.internal.ads;

import android.media.metrics.LogSessionId;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzoz {
    public final String zza;
    private final zzoy zzb;
    private final Object zzc;

    static {
        new zzoz("");
    }

    public zzoz(String str) {
        this.zza = str;
        this.zzb = zzeu.zza >= 31 ? new zzoy() : null;
        this.zzc = new Object();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzoz)) {
            return false;
        }
        zzoz zzozVar = (zzoz) obj;
        return Objects.equals(this.zza, zzozVar.zza) && Objects.equals(this.zzb, zzozVar.zzb) && Objects.equals(this.zzc, zzozVar.zzc);
    }

    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb, this.zzc);
    }

    public final synchronized LogSessionId zza() {
        zzoy zzoyVar;
        zzoyVar = this.zzb;
        if (zzoyVar == null) {
            throw null;
        }
        return zzoyVar.zza;
    }

    public final synchronized void zzb(LogSessionId logSessionId) {
        zzoy zzoyVar = this.zzb;
        if (zzoyVar == null) {
            throw null;
        }
        zzdc.zzf(zzoyVar.zza.equals(LogSessionId.LOG_SESSION_ID_NONE));
        zzoyVar.zza = logSessionId;
    }
}
