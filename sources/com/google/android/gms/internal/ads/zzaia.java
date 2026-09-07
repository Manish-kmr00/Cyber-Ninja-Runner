package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaia implements zzahx {
    private final int zza;
    private final int zzb;
    private final zzek zzc;

    public zzaia(zzey zzeyVar, zzz zzzVar) {
        zzek zzekVar = zzeyVar.zza;
        this.zzc = zzekVar;
        zzekVar.zzL(12);
        int iZzp = zzekVar.zzp();
        if ("audio/raw".equals(zzzVar.zzo)) {
            int iZzk = zzeu.zzk(zzzVar.zzG) * zzzVar.zzE;
            if (iZzp == 0 || iZzp % iZzk != 0) {
                zzdx.zzf("BoxParsers", "Audio sample size mismatch. stsd sample size: " + iZzk + ", stsz sample size: " + iZzp);
                iZzp = iZzk;
            }
        }
        this.zza = iZzp == 0 ? -1 : iZzp;
        this.zzb = zzekVar.zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzahx
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzahx
    public final int zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzahx
    public final int zzc() {
        int i = this.zza;
        return i == -1 ? this.zzc.zzp() : i;
    }
}
