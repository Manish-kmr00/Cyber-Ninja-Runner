package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
final class zzgxe {
    private final Object zza;
    private final int zzb;

    zzgxe(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgxe)) {
            return false;
        }
        zzgxe zzgxeVar = (zzgxe) obj;
        return this.zza == zzgxeVar.zza && this.zzb == zzgxeVar.zzb;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
