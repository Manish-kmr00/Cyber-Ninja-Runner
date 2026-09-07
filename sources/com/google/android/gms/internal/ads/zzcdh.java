package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzcdh implements zzge {
    private final zzge zza;
    private final long zzb;
    private final zzge zzc;
    private long zzd;
    private Uri zze;

    zzcdh(zzge zzgeVar, int i, zzge zzgeVar2) {
        this.zza = zzgeVar;
        this.zzb = i;
        this.zzc = zzgeVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzl
    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        long j = this.zzd;
        long j2 = this.zzb;
        if (j < j2) {
            int iZza = this.zza.zza(bArr, i, (int) Math.min(i2, j2 - j));
            long j3 = this.zzd + ((long) iZza);
            this.zzd = j3;
            i3 = iZza;
            j = j3;
        } else {
            i3 = 0;
        }
        if (j < j2) {
            return i3;
        }
        int iZza2 = this.zzc.zza(bArr, i + i3, i2 - i3);
        int i4 = i3 + iZza2;
        this.zzd += (long) iZza2;
        return i4;
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final long zzb(zzgj zzgjVar) throws IOException {
        zzgj zzgjVar2;
        Uri uri = zzgjVar.zza;
        this.zze = uri;
        long j = zzgjVar.zze;
        long j2 = this.zzb;
        zzgj zzgjVar3 = null;
        if (j >= j2) {
            zzgjVar2 = null;
        } else {
            long j3 = zzgjVar.zzf;
            long j4 = j2 - j;
            zzgjVar2 = new zzgj(uri, j, j3 != -1 ? Math.min(j3, j4) : j4, null);
        }
        long j5 = zzgjVar.zzf;
        if (j5 == -1 || j + j5 > j2) {
            zzgjVar3 = new zzgj(uri, Math.max(j2, j), j5 != -1 ? Math.min(j5, (j + j5) - j2) : -1L, null);
        }
        long jZzb = zzgjVar2 != null ? this.zza.zzb(zzgjVar2) : 0L;
        long jZzb2 = zzgjVar3 != null ? this.zzc.zzb(zzgjVar3) : 0L;
        this.zzd = j;
        if (jZzb == -1 || jZzb2 == -1) {
            return -1L;
        }
        return jZzb + jZzb2;
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final Uri zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void zzd() throws IOException {
        this.zza.zzd();
        this.zzc.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final Map zze() {
        return zzfwz.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void zzf(zzhe zzheVar) {
    }
}
