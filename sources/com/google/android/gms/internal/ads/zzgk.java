package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzgk implements zzgd {
    private final Context zza;
    private final zzgd zzb;

    public zzgk(Context context) {
        zzgm zzgmVar = new zzgm();
        this.zza = context.getApplicationContext();
        this.zzb = zzgmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgd
    public final /* bridge */ /* synthetic */ zzge zza() {
        return new zzgl(this.zza, this.zzb.zza());
    }
}
