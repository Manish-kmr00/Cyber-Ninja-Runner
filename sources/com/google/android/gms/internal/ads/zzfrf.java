package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
final class zzfrf extends zzfsi {
    private int zza;
    private String zzb;
    private byte zzc;

    zzfrf() {
    }

    @Override // com.google.android.gms.internal.ads.zzfsi
    public final zzfsi zza(String str) {
        this.zzb = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfsi
    public final zzfsi zzb(int i) {
        this.zza = i;
        this.zzc = (byte) 1;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfsi
    public final zzfsj zzc() {
        if (this.zzc == 1) {
            return new zzfrh(this.zza, this.zzb, null);
        }
        throw new IllegalStateException("Missing required properties: statusCode");
    }
}
