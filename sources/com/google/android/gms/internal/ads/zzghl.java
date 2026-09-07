package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzghl extends zzgen {
    private final zzghj zza;
    private final String zzb;
    private final zzghi zzc;
    private final zzgen zzd;

    /* synthetic */ zzghl(zzghj zzghjVar, String str, zzghi zzghiVar, zzgen zzgenVar, zzghk zzghkVar) {
        this.zza = zzghjVar;
        this.zzb = str;
        this.zzc = zzghiVar;
        this.zzd = zzgenVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzghl)) {
            return false;
        }
        zzghl zzghlVar = (zzghl) obj;
        return zzghlVar.zzc.equals(this.zzc) && zzghlVar.zzd.equals(this.zzd) && zzghlVar.zzb.equals(this.zzb) && zzghlVar.zza.equals(this.zza);
    }

    public final int hashCode() {
        return Objects.hash(zzghl.class, this.zzb, this.zzc, this.zzd, this.zza);
    }

    public final String toString() {
        zzghj zzghjVar = this.zza;
        zzgen zzgenVar = this.zzd;
        return "LegacyKmsEnvelopeAead Parameters (kekUri: " + this.zzb + ", dekParsingStrategy: " + String.valueOf(this.zzc) + ", dekParametersForNewKeys: " + String.valueOf(zzgenVar) + ", variant: " + String.valueOf(zzghjVar) + ")";
    }

    @Override // com.google.android.gms.internal.ads.zzgdv
    public final boolean zza() {
        return this.zza != zzghj.zzb;
    }

    public final zzgen zzb() {
        return this.zzd;
    }

    public final zzghj zzc() {
        return this.zza;
    }

    public final String zzd() {
        return this.zzb;
    }
}
