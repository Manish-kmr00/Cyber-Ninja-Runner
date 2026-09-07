package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.internal.ads.zzauv;
import com.google.android.gms.internal.ads.zzaux;
import com.google.android.gms.internal.ads.zzauy;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzq implements Callable {
    final /* synthetic */ zzu zza;

    zzq(zzu zzuVar) {
        this.zza = zzuVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzu zzuVar = this.zza;
        String str = zzuVar.zza.afmaVersion;
        Context context = zzuVar.zzd;
        int i = zzaux.zzw;
        return new zzauy(zzaux.zzt(context, new zzauv(str, false)));
    }
}
