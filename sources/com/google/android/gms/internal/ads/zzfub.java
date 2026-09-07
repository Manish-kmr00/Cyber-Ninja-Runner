package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzfub extends zzftu {
    private final Object zza;

    zzfub(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzfub) {
            return this.zza.equals(((zzfub) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 1502476572;
    }

    public final String toString() {
        return "Optional.of(" + this.zza.toString() + ")";
    }

    @Override // com.google.android.gms.internal.ads.zzftu
    public final zzftu zza(zzftl zzftlVar) {
        Object objApply = zzftlVar.apply(this.zza);
        zzftw.zzc(objApply, "the Function passed to Optional.transform() must not return null.");
        return new zzfub(objApply);
    }

    @Override // com.google.android.gms.internal.ads.zzftu
    public final Object zzb(Object obj) {
        return this.zza;
    }
}
