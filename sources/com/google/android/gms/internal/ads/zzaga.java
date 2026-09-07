package com.google.android.gms.internal.ads;

import com.json.mediationsdk.logger.IronSourceError;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaga implements zzau {
    public final int zza;
    public final String zzb;
    public final String zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final byte[] zzh;

    public zzaga(int i, String str, String str2, int i2, int i3, int i4, int i5, byte[] bArr) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = i2;
        this.zze = i3;
        this.zzf = i4;
        this.zzg = i5;
        this.zzh = bArr;
    }

    public static zzaga zzb(zzek zzekVar) {
        int iZzg = zzekVar.zzg();
        String strZze = zzay.zze(zzekVar.zzB(zzekVar.zzg(), StandardCharsets.US_ASCII));
        String strZzB = zzekVar.zzB(zzekVar.zzg(), StandardCharsets.UTF_8);
        int iZzg2 = zzekVar.zzg();
        int iZzg3 = zzekVar.zzg();
        int iZzg4 = zzekVar.zzg();
        int iZzg5 = zzekVar.zzg();
        int iZzg6 = zzekVar.zzg();
        byte[] bArr = new byte[iZzg6];
        zzekVar.zzH(bArr, 0, iZzg6);
        return new zzaga(iZzg, strZze, strZzB, iZzg2, iZzg3, iZzg4, iZzg5, bArr);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzaga zzagaVar = (zzaga) obj;
            if (this.zza == zzagaVar.zza && this.zzb.equals(zzagaVar.zzb) && this.zzc.equals(zzagaVar.zzc) && this.zzd == zzagaVar.zzd && this.zze == zzagaVar.zze && this.zzf == zzagaVar.zzf && this.zzg == zzagaVar.zzg && Arrays.equals(this.zzh, zzagaVar.zzh)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((((((this.zza + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + this.zzb.hashCode()) * 31) + this.zzc.hashCode()) * 31) + this.zzd) * 31) + this.zze) * 31) + this.zzf) * 31) + this.zzg) * 31) + Arrays.hashCode(this.zzh);
    }

    public final String toString() {
        return "Picture: mimeType=" + this.zzb + ", description=" + this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzau
    public final void zza(zzar zzarVar) {
        zzarVar.zza(this.zzh, this.zza);
    }
}
