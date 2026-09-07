package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public abstract class zzfjv {
    public static zzfjv zza(zzfjw zzfjwVar, zzfjx zzfjxVar) {
        zzflr.zza();
        return new zzfjz(zzfjwVar, zzfjxVar, UUID.randomUUID().toString());
    }

    public abstract void zzb(View view, zzfkc zzfkcVar, String str);

    public abstract void zzc();

    public abstract void zzd(View view);

    public abstract void zze();
}
