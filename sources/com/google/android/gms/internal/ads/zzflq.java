package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.IntentFilter;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzflq {
    private static int zza = 2;

    public static void zza(Context context) {
        context.registerReceiver(new zzflp(), new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
    }

    public static int zzb() {
        if (zzflm.zza() != zzfkb.CTV) {
            return 2;
        }
        return zza;
    }
}
