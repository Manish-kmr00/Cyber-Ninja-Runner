package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaqp implements zzaqe {
    final /* synthetic */ Context zza;
    private File zzb = null;

    zzaqp(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzaqe
    public final File zza() {
        if (this.zzb == null) {
            this.zzb = new File(this.zza.getCacheDir(), "volley");
        }
        return this.zzb;
    }
}
