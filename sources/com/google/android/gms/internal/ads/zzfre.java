package com.google.android.gms.internal.ads;

import android.os.IBinder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
final class zzfre extends zzfsh {
    private final IBinder zza;
    private final String zzb;
    private final int zzc;
    private final float zzd;
    private final int zze;
    private final String zzf;

    /* synthetic */ zzfre(IBinder iBinder, String str, int i, float f, int i2, int i3, String str2, int i4, String str3, String str4, String str5, zzfrd zzfrdVar) {
        this.zza = iBinder;
        this.zzb = str;
        this.zzc = i;
        this.zzd = f;
        this.zze = i4;
        this.zzf = str4;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfsh) {
            zzfsh zzfshVar = (zzfsh) obj;
            if (this.zza.equals(zzfshVar.zzf()) && ((str = this.zzb) != null ? str.equals(zzfshVar.zzh()) : zzfshVar.zzh() == null) && this.zzc == zzfshVar.zzc() && Float.floatToIntBits(this.zzd) == Float.floatToIntBits(zzfshVar.zza())) {
                zzfshVar.zzb();
                zzfshVar.zzd();
                zzfshVar.zzj();
                if (this.zze == zzfshVar.zze()) {
                    zzfshVar.zzi();
                    String str2 = this.zzf;
                    if (str2 != null ? str2.equals(zzfshVar.zzg()) : zzfshVar.zzg() == null) {
                        zzfshVar.zzk();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zza.hashCode() ^ 1000003;
        String str = this.zzb;
        int iHashCode2 = (((((iHashCode * 1000003) ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.zzc) * 1000003) ^ Float.floatToIntBits(this.zzd);
        int i = this.zze;
        String str2 = this.zzf;
        return ((((iHashCode2 * 1525764945) ^ i) * (-721379959)) ^ (str2 != null ? str2.hashCode() : 0)) * 1000003;
    }

    public final String toString() {
        return "OverlayDisplayShowRequest{windowToken=" + this.zza.toString() + ", appId=" + this.zzb + ", layoutGravity=" + this.zzc + ", layoutVerticalMargin=" + this.zzd + ", displayMode=0, triggerMode=0, sessionToken=null, windowWidthPx=" + this.zze + ", deeplinkUrl=null, adFieldEnifd=" + this.zzf + ", thirdPartyAuthCallerId=null}";
    }

    @Override // com.google.android.gms.internal.ads.zzfsh
    public final float zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzfsh
    public final int zzb() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzfsh
    public final int zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzfsh
    public final int zzd() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzfsh
    public final int zze() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzfsh
    public final IBinder zzf() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzfsh
    public final String zzg() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzfsh
    public final String zzh() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfsh
    public final String zzi() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzfsh
    public final String zzj() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzfsh
    public final String zzk() {
        return null;
    }
}
