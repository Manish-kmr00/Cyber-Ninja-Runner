package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzfuh extends zzfuj {
    zzfuh(zzful zzfulVar, CharSequence charSequence, int i) {
        super(zzfulVar, charSequence);
    }

    @Override // com.google.android.gms.internal.ads.zzfuj
    public final int zzc(int i) {
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzfuj
    public final int zzd(int i) {
        int i2 = i + 4000;
        if (i2 < this.zzb.length()) {
            return i2;
        }
        return -1;
    }
}
