package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class zzfgb {
    public static zzfgc zza(Context context, int i) {
        boolean zBooleanValue;
        if (zzfgq.zza()) {
            int i2 = i - 2;
            if (i2 != 20 && i2 != 21) {
                switch (i2) {
                    case 2:
                    case 3:
                    case 6:
                    case 7:
                    case 8:
                        zBooleanValue = ((Boolean) zzbeb.zzc.zze()).booleanValue();
                        break;
                    case 4:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        zBooleanValue = ((Boolean) zzbeb.zzd.zze()).booleanValue();
                        break;
                    case 5:
                        zBooleanValue = ((Boolean) zzbeb.zzb.zze()).booleanValue();
                        break;
                }
            } else {
                zBooleanValue = ((Boolean) zzbeb.zze.zze()).booleanValue();
            }
            if (zBooleanValue) {
                return new zzfge(context, i);
            }
        }
        return new zzfhj();
    }

    public static zzfgc zzb(Context context, int i, int i2, com.google.android.gms.ads.internal.client.zzm zzmVar) {
        zzfgc zzfgcVarZza = zza(context, i);
        if (zzfgcVarZza instanceof zzfge) {
            zzfgcVarZza.zzi();
            zzfgcVarZza.zzn(i2);
            zzfgcVarZza.zzf(com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zza(zzmVar.zzm));
            String str = zzmVar.zzp;
            if (zzfgm.zze(str)) {
                zzfgcVarZza.zze(str);
            }
        }
        return zzfgcVarZza;
    }
}
