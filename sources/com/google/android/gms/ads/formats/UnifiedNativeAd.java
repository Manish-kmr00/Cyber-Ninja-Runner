package com.google.android.gms.ads.formats;

import android.os.Bundle;
import com.google.android.gms.ads.VideoController;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
@Deprecated
public abstract class UnifiedNativeAd {
    public abstract void performClick(Bundle bundle);

    public abstract boolean recordImpression(Bundle bundle);

    public abstract void reportTouchEvent(Bundle bundle);

    @Deprecated
    public abstract VideoController zza();

    public abstract NativeAd.Image zzb();

    public abstract Double zzc();

    public abstract Object zzd();

    public abstract String zze();

    public abstract String zzf();

    public abstract String zzg();

    public abstract String zzh();

    public abstract String zzi();

    public abstract String zzj();

    public abstract List zzk();
}
