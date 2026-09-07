package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.TrafficStats;
import android.os.StrictMode;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
@ParametersAreNonnullByDefault
public final class zzcey {
    public static final zzcel zza(final Context context, final zzcgf zzcgfVar, final String str, final boolean z, final boolean z2, final zzauy zzauyVar, final zzbdp zzbdpVar, final VersionInfoParcel versionInfoParcel, zzbcx zzbcxVar, final com.google.android.gms.ads.internal.zzn zznVar, final com.google.android.gms.ads.internal.zza zzaVar, final zzbbg zzbbgVar, final zzfau zzfauVar, final zzfax zzfaxVar, final zzebe zzebeVar, final zzfbt zzfbtVar, final zzdre zzdreVar) throws zzcex {
        zzbci.zza(context);
        try {
            final zzbcx zzbcxVar2 = null;
            zzfuo zzfuoVar = new zzfuo(context, zzcgfVar, str, z, z2, zzauyVar, zzbdpVar, versionInfoParcel, zzbcxVar2, zznVar, zzaVar, zzbbgVar, zzfauVar, zzfaxVar, zzfbtVar, zzdreVar, zzebeVar) { // from class: com.google.android.gms.internal.ads.zzcew
                public final /* synthetic */ Context zza;
                public final /* synthetic */ zzcgf zzb;
                public final /* synthetic */ String zzc;
                public final /* synthetic */ boolean zzd;
                public final /* synthetic */ boolean zze;
                public final /* synthetic */ zzauy zzf;
                public final /* synthetic */ zzbdp zzg;
                public final /* synthetic */ VersionInfoParcel zzh;
                public final /* synthetic */ com.google.android.gms.ads.internal.zzn zzi;
                public final /* synthetic */ com.google.android.gms.ads.internal.zza zzj;
                public final /* synthetic */ zzbbg zzk;
                public final /* synthetic */ zzfau zzl;
                public final /* synthetic */ zzfax zzm;
                public final /* synthetic */ zzfbt zzn;
                public final /* synthetic */ zzdre zzo;
                public final /* synthetic */ zzebe zzp;

                {
                    this.zzi = zznVar;
                    this.zzj = zzaVar;
                    this.zzk = zzbbgVar;
                    this.zzl = zzfauVar;
                    this.zzm = zzfaxVar;
                    this.zzn = zzfbtVar;
                    this.zzo = zzdreVar;
                    this.zzp = zzebeVar;
                }

                @Override // com.google.android.gms.internal.ads.zzfuo
                public final Object zza() {
                    zzcgf zzcgfVar2 = this.zzb;
                    String str2 = this.zzc;
                    boolean z3 = this.zzd;
                    zzbbg zzbbgVar2 = this.zzk;
                    boolean z4 = this.zze;
                    zzauy zzauyVar2 = this.zzf;
                    zzfau zzfauVar2 = this.zzl;
                    zzbdp zzbdpVar2 = this.zzg;
                    com.google.android.gms.ads.internal.zzn zznVar2 = this.zzi;
                    zzfax zzfaxVar2 = this.zzm;
                    Context context2 = this.zza;
                    VersionInfoParcel versionInfoParcel2 = this.zzh;
                    com.google.android.gms.ads.internal.zza zzaVar2 = this.zzj;
                    zzfbt zzfbtVar2 = this.zzn;
                    zzdre zzdreVar2 = this.zzo;
                    zzebe zzebeVar2 = this.zzp;
                    try {
                        TrafficStats.setThreadStatsTag(264);
                        int i = zzcfk.zza;
                        zzcfd zzcfdVar = new zzcfd(new zzcfk(new zzcge(context2), zzcgfVar2, str2, z3, z4, zzauyVar2, zzbdpVar2, versionInfoParcel2, null, zznVar2, zzaVar2, zzbbgVar2, zzfauVar2, zzfaxVar2, zzfbtVar2), zzdreVar2);
                        zzcfdVar.setWebViewClient(com.google.android.gms.ads.internal.zzv.zzr().zzc(zzcfdVar, zzbbgVar2, z4, zzebeVar2));
                        zzcfdVar.setWebChromeClient(new zzcek(zzcfdVar));
                        return zzcfdVar;
                    } finally {
                        TrafficStats.clearThreadStatsTag();
                    }
                }
            };
            StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
            try {
                StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
                return (zzcel) zzfuoVar.zza();
            } finally {
                StrictMode.setThreadPolicy(threadPolicy);
            }
        } catch (Throwable th) {
            throw new zzcex("Webview initialization failed.", th);
        }
    }
}
