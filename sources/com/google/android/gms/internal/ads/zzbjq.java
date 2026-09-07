package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.CollectionUtils;
import com.smaato.sdk.richmedia.mraid.bridge.MraidJsMethods;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzbjq implements zzbjj {
    static final Map zza = CollectionUtils.mapOfKeyValueArrays(new String[]{"resize", MraidJsMethods.PLAY_VIDEO, "storePicture", "createCalendarEvent", "setOrientationProperties", "closeResizedAd", MraidJsMethods.UNLOAD}, new Integer[]{1, 2, 3, 4, 5, 6, 7});
    private final com.google.android.gms.ads.internal.zzb zzb;
    private final zzbrw zzc;
    private final zzbsd zzd;

    public zzbjq(com.google.android.gms.ads.internal.zzb zzbVar, zzbrw zzbrwVar, zzbsd zzbsdVar) {
        this.zzb = zzbVar;
        this.zzc = zzbrwVar;
        this.zzd = zzbsdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcel zzcelVar = (zzcel) obj;
        int iIntValue = ((Integer) zza.get((String) map.get("a"))).intValue();
        int i = 6;
        if (iIntValue != 5) {
            if (iIntValue != 7) {
                com.google.android.gms.ads.internal.zzb zzbVar = this.zzb;
                if (!zzbVar.zzc()) {
                    zzbVar.zzb(null);
                    return;
                }
                if (iIntValue == 1) {
                    this.zzc.zzc(map);
                    return;
                }
                if (iIntValue == 3) {
                    new zzbrz(zzcelVar, map).zzb();
                    return;
                }
                if (iIntValue == 4) {
                    new zzbrt(zzcelVar, map).zzc();
                    return;
                }
                if (iIntValue != 5) {
                    if (iIntValue == 6) {
                        this.zzc.zzb(true);
                        return;
                    } else if (iIntValue != 7) {
                        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzi("Unknown MRAID command called.");
                        return;
                    }
                }
            }
            this.zzd.zzc();
            return;
        }
        String str = (String) map.get("forceOrientation");
        boolean z = map.containsKey("allowOrientationChange") ? Boolean.parseBoolean((String) map.get("allowOrientationChange")) : true;
        if (zzcelVar == null) {
            int i3 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("AdWebView is null");
            return;
        }
        if ("portrait".equalsIgnoreCase(str)) {
            i = 7;
        } else if (!"landscape".equalsIgnoreCase(str)) {
            i = z ? -1 : 14;
        }
        zzcelVar.zzau(i);
    }
}
