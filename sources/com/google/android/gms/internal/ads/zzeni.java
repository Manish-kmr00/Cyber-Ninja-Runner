package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Strings;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzeni implements zzesv {
    private final zzexs zza;

    zzeni(zzexs zzexsVar) {
        this.zza = zzexsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final int zza() {
        return 15;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final ListenableFuture zzb() {
        zzexs zzexsVar = this.zza;
        if (zzexsVar == null) {
            return zzgbs.zzh(new zzenh(null));
        }
        String strZza = zzexsVar.zza();
        return Strings.isEmptyOrWhitespace(strZza) ? zzgbs.zzh(new zzenh(null)) : zzgbs.zzh(new zzenh(strZza));
    }
}
