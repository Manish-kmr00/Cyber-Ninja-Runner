package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzacx implements zzaei {
    private final byte[] zza = new byte[4096];

    @Override // com.google.android.gms.internal.ads.zzaei
    public final /* synthetic */ int zzf(zzl zzlVar, int i, boolean z) {
        return zzaeg.zza(this, zzlVar, i, z);
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final int zzg(zzl zzlVar, int i, boolean z, int i2) throws IOException {
        int iZza = zzlVar.zza(this.zza, 0, Math.min(4096, i));
        if (iZza != -1) {
            return iZza;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final /* synthetic */ void zzl(long j) {
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final void zzm(zzz zzzVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final /* synthetic */ void zzr(zzek zzekVar, int i) {
        zzaeg.zzb(this, zzekVar, i);
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final void zzs(zzek zzekVar, int i, int i2) {
        zzekVar.zzM(i);
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final void zzt(long j, int i, int i2, int i3, zzaeh zzaehVar) {
    }
}
