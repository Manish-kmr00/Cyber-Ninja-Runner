package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfdo implements zzfdm {
    private final String zza;

    public zzfdo(String str) {
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.ads.zzfdm
    public final boolean equals(Object obj) {
        if (obj instanceof zzfdo) {
            return this.zza.equals(((zzfdo) obj).zza);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzfdm
    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return this.zza;
    }
}
