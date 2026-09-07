package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
@ParametersAreNonnullByDefault
public final class zzbnr {
    private final Object zza = new Object();
    private final Object zzb = new Object();
    private zzboa zzc;
    private zzboa zzd;

    private static final Context zzc(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    public final zzboa zza(Context context, VersionInfoParcel versionInfoParcel, zzfgq zzfgqVar) {
        zzboa zzboaVar;
        String str;
        synchronized (this.zza) {
            if (this.zzc == null) {
                if (((Boolean) zzbeo.zzf.zze()).booleanValue()) {
                    str = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zza);
                } else {
                    str = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzb);
                }
                this.zzc = new zzboa(zzc(context), versionInfoParcel, str, zzfgqVar);
            }
            zzboaVar = this.zzc;
        }
        return zzboaVar;
    }

    public final zzboa zzb(Context context, VersionInfoParcel versionInfoParcel, zzfgq zzfgqVar) {
        zzboa zzboaVar;
        synchronized (this.zzb) {
            if (this.zzd == null) {
                this.zzd = new zzboa(zzc(context), versionInfoParcel, (String) zzbes.zza.zze(), zzfgqVar);
            }
            zzboaVar = this.zzd;
        }
        return zzboaVar;
    }
}
