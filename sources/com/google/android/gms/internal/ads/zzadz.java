package com.google.android.gms.internal.ads;

import com.json.b9;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzadz {
    public final zzaec zza;
    public final zzaec zzb;

    public zzadz(zzaec zzaecVar, zzaec zzaecVar2) {
        this.zza = zzaecVar;
        this.zzb = zzaecVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzadz zzadzVar = (zzadz) obj;
            if (this.zza.equals(zzadzVar.zza) && this.zzb.equals(zzadzVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.zza.hashCode() * 31) + this.zzb.hashCode();
    }

    public final String toString() {
        zzaec zzaecVar = this.zza;
        zzaec zzaecVar2 = this.zzb;
        return b9.i.d + zzaecVar.toString() + (zzaecVar.equals(zzaecVar2) ? "" : ", ".concat(zzaecVar2.toString())) + b9.i.e;
    }
}
