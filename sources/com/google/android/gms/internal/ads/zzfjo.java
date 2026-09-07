package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.ClientApi;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfjo {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private final ScheduledExecutorService zzc;
    private final ClientApi zzd = new ClientApi();
    private zzboy zze;
    private final Clock zzf;

    zzfjo(Context context, VersionInfoParcel versionInfoParcel, ScheduledExecutorService scheduledExecutorService, Clock clock) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = scheduledExecutorService;
        this.zzf = clock;
    }

    private static zzfiu zzc() {
        return new zzfiu(((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzz)).longValue(), 2.0d, ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzA)).longValue(), 0.2d);
    }

    public final zzfjn zza(com.google.android.gms.ads.internal.client.zzfp zzfpVar, com.google.android.gms.ads.internal.client.zzce zzceVar) {
        AdFormat adFormat = AdFormat.getAdFormat(zzfpVar.zzb);
        if (adFormat == null) {
            return null;
        }
        int iOrdinal = adFormat.ordinal();
        if (iOrdinal == 1) {
            return new zzfiw(this.zzd, this.zza, this.zzb.clientJarVersion, this.zze, zzfpVar, zzceVar, this.zzc, zzc(), this.zzf);
        }
        if (iOrdinal == 2) {
            return new zzfjr(this.zzd, this.zza, this.zzb.clientJarVersion, this.zze, zzfpVar, zzceVar, this.zzc, zzc(), this.zzf);
        }
        if (iOrdinal != 5) {
            return null;
        }
        return new zzfit(this.zzd, this.zza, this.zzb.clientJarVersion, this.zze, zzfpVar, zzceVar, this.zzc, zzc(), this.zzf);
    }

    public final void zzb(zzboy zzboyVar) {
        this.zze = zzboyVar;
    }
}
