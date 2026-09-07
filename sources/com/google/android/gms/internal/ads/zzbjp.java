package com.google.android.gms.internal.ads;

import android.content.Context;
import com.json.b9;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzbjp implements zzbjj {
    private final Context zza;
    private final Map zzb;

    public zzbjp(Context context, Map map) {
        this.zza = context;
        this.zzb = map;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0051  */
    @Override // com.google.android.gms.internal.ads.zzbjj
    public final void zza(Object obj, Map map) {
        byte b;
        zzbxw zzbxwVarZzo = com.google.android.gms.ads.internal.zzv.zzo();
        Context context = this.zza;
        if (zzbxwVarZzo.zzp(context)) {
            String str = (String) map.get(b9.h.j0);
            String str2 = (String) map.get("eventId");
            int iHashCode = str.hashCode();
            if (iHashCode != 94399) {
                if (iHashCode != 94401) {
                    if (iHashCode == 94407 && str.equals("_ai")) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                } else if (str.equals("_ac")) {
                    b = 0;
                } else {
                    b = -1;
                }
            } else if (str.equals("_aa")) {
                b = 2;
            } else {
                b = -1;
            }
            if (b == 0) {
                com.google.android.gms.ads.internal.zzv.zzo().zzj(context, str2, (Map) this.zzb.get("_ac"));
            } else if (b == 1) {
                com.google.android.gms.ads.internal.zzv.zzo().zzk(context, str2, (Map) this.zzb.get("_ai"));
            } else if (b == 2) {
                com.google.android.gms.ads.internal.zzv.zzo().zzh(context, str2);
            } else {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("logScionEvent gmsg contained unsupported eventName");
            }
        }
    }
}
