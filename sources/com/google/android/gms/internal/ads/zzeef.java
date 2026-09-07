package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
final class zzeef implements zzdfm {
    private final zzfau zza;
    private final zzbqx zzb;
    private final AdFormat zzc;
    private zzcvu zzd = null;

    zzeef(zzfau zzfauVar, zzbqx zzbqxVar, AdFormat adFormat) {
        this.zza = zzfauVar;
        this.zzb = zzbqxVar;
        this.zzc = adFormat;
    }

    @Override // com.google.android.gms.internal.ads.zzdfm
    public final zzfau zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzdfm
    public final void zzb(boolean z, Context context, zzcvp zzcvpVar) throws zzdfl {
        boolean zZzs;
        try {
            AdFormat adFormat = AdFormat.BANNER;
            int iOrdinal = this.zzc.ordinal();
            if (iOrdinal == 1) {
                zZzs = this.zzb.zzs(ObjectWrapper.wrap(context));
            } else {
                if (iOrdinal != 2) {
                    if (iOrdinal == 5) {
                        zZzs = this.zzb.zzr(ObjectWrapper.wrap(context));
                    }
                    throw new zzdfl("Adapter failed to show.");
                }
                zZzs = this.zzb.zzt(ObjectWrapper.wrap(context));
            }
            if (zZzs) {
                zzcvu zzcvuVar = this.zzd;
                if (zzcvuVar == null) {
                    return;
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbI)).booleanValue() || this.zza.zzY != 2) {
                    return;
                }
                zzcvuVar.zza();
                return;
            }
            throw new zzdfl("Adapter failed to show.");
        } catch (Throwable th) {
            throw new zzdfl(th);
        }
    }

    public final void zzc(zzcvu zzcvuVar) {
        this.zzd = zzcvuVar;
    }
}
