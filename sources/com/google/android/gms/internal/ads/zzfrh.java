package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
final class zzfrh extends zzfsj {
    private final int zza;
    private final String zzb;

    /* synthetic */ zzfrh(int i, String str, zzfrg zzfrgVar) {
        this.zza = i;
        this.zzb = str;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfsj) {
            zzfsj zzfsjVar = (zzfsj) obj;
            if (this.zza == zzfsjVar.zza() && ((str = this.zzb) != null ? str.equals(zzfsjVar.zzb()) : zzfsjVar.zzb() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zzb;
        return (str == null ? 0 : str.hashCode()) ^ ((this.zza ^ 1000003) * 1000003);
    }

    public final String toString() {
        return "OverlayDisplayState{statusCode=" + this.zza + ", sessionToken=" + this.zzb + "}";
    }

    @Override // com.google.android.gms.internal.ads.zzfsj
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzfsj
    public final String zzb() {
        return this.zzb;
    }
}
