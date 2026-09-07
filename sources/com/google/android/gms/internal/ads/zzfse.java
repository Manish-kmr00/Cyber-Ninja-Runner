package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
final class zzfse extends zzfqx {
    final /* synthetic */ zzfsf zza;
    private final zzfsk zzb;

    zzfse(zzfsf zzfsfVar, zzfsk zzfskVar) {
        this.zza = zzfsfVar;
        this.zzb = zzfskVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfqy
    public final void zzb(Bundle bundle) {
        int i = bundle.getInt("statusCode", 8150);
        String string = bundle.getString("sessionToken");
        zzfsi zzfsiVarZzc = zzfsj.zzc();
        zzfsiVarZzc.zzb(i);
        if (string != null) {
            zzfsiVarZzc.zza(string);
        }
        this.zzb.zza(zzfsiVarZzc.zzc());
        if (i == 8157) {
            this.zza.zzd();
        }
    }
}
