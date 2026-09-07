package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
final class zzeah extends zzeal {
    private final String zza;
    private final String zzb;
    private final Drawable zzc;

    zzeah(String str, String str2, Drawable drawable) {
        this.zza = str;
        if (str2 == null) {
            throw new NullPointerException("Null imageUrl");
        }
        this.zzb = str2;
        this.zzc = drawable;
    }

    public final boolean equals(Object obj) {
        Drawable drawable;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzeal) {
            zzeal zzealVar = (zzeal) obj;
            String str = this.zza;
            if (str != null ? str.equals(zzealVar.zzb()) : zzealVar.zzb() == null) {
                if (this.zzb.equals(zzealVar.zzc()) && ((drawable = this.zzc) != null ? drawable.equals(zzealVar.zza()) : zzealVar.zza() == null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String toString() {
        return "OfflineAdAssets{advertiserName=" + this.zza + ", imageUrl=" + this.zzb + ", icon=" + String.valueOf(this.zzc) + "}";
    }

    @Override // com.google.android.gms.internal.ads.zzeal
    final Drawable zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzeal
    final String zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzeal
    final String zzc() {
        return this.zzb;
    }

    public final int hashCode() {
        String str = this.zza;
        int iHashCode = (((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.zzb.hashCode();
        Drawable drawable = this.zzc;
        return (iHashCode * 1000003) ^ (drawable != null ? drawable.hashCode() : 0);
    }
}
