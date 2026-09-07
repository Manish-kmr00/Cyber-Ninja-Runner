package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzbbn;
import com.google.android.gms.internal.ads.zzbym;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzaz {
    private final String zza;
    private final String zzb;
    private final zzbym zzc;

    /* synthetic */ zzaz(zzax zzaxVar, zzay zzayVar) {
        this.zza = zzaxVar.zza;
        this.zzb = zzaxVar.zzb;
        this.zzc = zzaxVar.zzc;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x0035  */
    public final zzbbn.zza.EnumC0270zza zza() {
        byte b;
        switch (this.zza) {
            case "NATIVE":
                b = 2;
                break;
            case "INTERSTITIAL":
                b = 1;
                break;
            case "REWARDED":
                b = 3;
                break;
            case "BANNER":
                b = 0;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            return zzbbn.zza.EnumC0270zza.BANNER;
        }
        if (b == 1) {
            return zzbbn.zza.EnumC0270zza.INTERSTITIAL;
        }
        if (b != 2) {
            return b != 3 ? zzbbn.zza.EnumC0270zza.AD_INITIATER_UNSPECIFIED : zzbbn.zza.EnumC0270zza.REWARD_BASED_VIDEO_AD;
        }
        return zzbbn.zza.EnumC0270zza.AD_LOADER;
    }

    final zzbym zzb() {
        return this.zzc;
    }

    public final String zzc() {
        return this.zza.toLowerCase(Locale.ROOT);
    }

    final String zzd() {
        return this.zzb;
    }

    public final Set zze() {
        HashSet hashSet = new HashSet();
        hashSet.add(this.zza.toLowerCase(Locale.ROOT));
        return hashSet;
    }
}
