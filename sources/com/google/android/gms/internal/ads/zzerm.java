package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzerm implements zzesu {
    private final Bundle zza;

    public zzerm(Bundle bundle) {
        this.zza = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzesu
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = this.zza;
        zzcue zzcueVar = (zzcue) obj;
        if (bundle != null) {
            zzcueVar.zzb.putAll(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzesu
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Bundle bundle = this.zza;
        zzcue zzcueVar = (zzcue) obj;
        if (bundle != null) {
            zzcueVar.zza.putAll(bundle);
        }
    }
}
