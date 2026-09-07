package com.google.android.gms.internal.ads;

import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzafa implements zzaeq {
    public final String zza;

    private zzafa(String str) {
        this.zza = str;
    }

    public static zzafa zzb(zzek zzekVar) {
        return new zzafa(zzekVar.zzB(zzekVar.zza(), StandardCharsets.UTF_8));
    }

    @Override // com.google.android.gms.internal.ads.zzaeq
    public final int zza() {
        return 1852994675;
    }
}
