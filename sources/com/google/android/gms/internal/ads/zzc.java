package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzc {
    public final AudioAttributes zza;

    /* synthetic */ zzc(zze zzeVar, zzd zzdVar) {
        AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(0).setFlags(0).setUsage(1);
        if (zzeu.zza >= 29) {
            usage.setAllowedCapturePolicy(1);
        }
        if (zzeu.zza >= 32) {
            usage.setSpatializationBehavior(0);
        }
        this.zza = usage.build();
    }
}
