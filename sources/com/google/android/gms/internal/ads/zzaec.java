package com.google.android.gms.internal.ads;

import com.json.b9;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaec {
    public static final zzaec zza = new zzaec(0, 0);
    public final long zzb;
    public final long zzc;

    public zzaec(long j, long j2) {
        this.zzb = j;
        this.zzc = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzaec zzaecVar = (zzaec) obj;
            if (this.zzb == zzaecVar.zzb && this.zzc == zzaecVar.zzc) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.zzb) * 31) + ((int) this.zzc);
    }

    public final String toString() {
        return "[timeUs=" + this.zzb + ", position=" + this.zzc + b9.i.e;
    }
}
