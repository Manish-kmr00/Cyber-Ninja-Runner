package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
final class zzfpa extends zzfph {
    private final String zzb;
    private final int zzc;
    private final int zzd;

    /* synthetic */ zzfpa(String str, boolean z, int i, zzfow zzfowVar, zzfox zzfoxVar, int i2, zzfoz zzfozVar) {
        this.zzb = str;
        this.zzc = i;
        this.zzd = i2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfph) {
            zzfph zzfphVar = (zzfph) obj;
            if (this.zzb.equals(zzfphVar.zzc())) {
                zzfphVar.zzd();
                int i = this.zzc;
                int iZze = zzfphVar.zze();
                if (i == 0) {
                    throw null;
                }
                if (i == iZze) {
                    zzfphVar.zza();
                    zzfphVar.zzb();
                    int i2 = this.zzd;
                    int iZzf = zzfphVar.zzf();
                    if (i2 == 0) {
                        throw null;
                    }
                    if (iZzf == 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zzb.hashCode() ^ 1000003;
        int i = this.zzc;
        if (i == 0) {
            throw null;
        }
        int i2 = (((iHashCode * 1000003) ^ 1237) * 1000003) ^ i;
        if (this.zzd != 0) {
            return (i2 * 583896283) ^ 1;
        }
        throw null;
    }

    public final String toString() {
        String str;
        int i = this.zzc;
        if (i == 1) {
            str = "ALL_CHECKS";
        } else if (i == 2) {
            str = "SKIP_COMPLIANCE_CHECK";
        } else if (i != 3) {
            str = i != 4 ? "null" : "NO_CHECKS";
        } else {
            str = "SKIP_SECURITY_CHECK";
        }
        String str2 = this.zzd == 1 ? "READ_AND_WRITE" : "null";
        return "FileComplianceOptions{fileOwner=" + this.zzb + ", hasDifferentDmaOwner=false, fileChecks=" + str + ", dataForwardingNotAllowedResolver=null, multipleProductIdGroupsResolver=null, filePurpose=" + str2 + "}";
    }

    @Override // com.google.android.gms.internal.ads.zzfph
    public final zzfow zza() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzfph
    public final zzfox zzb() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzfph
    public final String zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfph
    public final boolean zzd() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzfph
    public final int zze() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzfph
    public final int zzf() {
        return this.zzd;
    }
}
