package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.unity3d.ads.gatewayclient.CommonGatewayClient;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfgq implements Runnable {
    public static Boolean zzb;
    private final Context zze;
    private final VersionInfoParcel zzf;
    private int zzi;
    private final zzdor zzj;
    private final List zzk;
    private final zzbvg zzm;
    public static final Object zza = new Object();
    private static final Object zzc = new Object();
    private static final Object zzd = new Object();
    private final zzfgv zzg = zzfgz.zzb();
    private String zzh = "";
    private boolean zzl = false;

    public zzfgq(Context context, VersionInfoParcel versionInfoParcel, zzdor zzdorVar, zzdyz zzdyzVar, zzbvg zzbvgVar) {
        this.zze = context;
        this.zzf = versionInfoParcel;
        this.zzj = zzdorVar;
        this.zzm = zzbvgVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zziU)).booleanValue()) {
            this.zzk = com.google.android.gms.ads.internal.util.zzs.zzd();
        } else {
            this.zzk = zzfww.zzn();
        }
    }

    public static boolean zza() {
        boolean zBooleanValue;
        synchronized (zza) {
            if (zzb == null) {
                if (((Boolean) zzbeb.zzb.zze()).booleanValue()) {
                    zzb = Boolean.valueOf(Math.random() < ((Double) zzbeb.zza.zze()).doubleValue());
                } else {
                    zzb = false;
                }
            }
            zBooleanValue = zzb.booleanValue();
        }
        return zBooleanValue;
    }

    public static /* synthetic */ void zzb(zzfgq zzfgqVar, zzfgg zzfggVar) {
        synchronized (zzd) {
            if (!zzfgqVar.zzl) {
                zzfgqVar.zzl = true;
                if (zza()) {
                    try {
                        com.google.android.gms.ads.internal.zzv.zzq();
                        zzfgqVar.zzh = com.google.android.gms.ads.internal.util.zzs.zzq(zzfgqVar.zze);
                    } catch (RemoteException | RuntimeException e) {
                        com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "CuiMonitor.gettingAppIdFromManifest");
                    }
                    zzfgqVar.zzi = GoogleApiAvailabilityLight.getInstance().getApkVersion(zzfgqVar.zze);
                    int iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zziP)).intValue();
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzlW)).booleanValue()) {
                        long j = iIntValue;
                        zzbzk.zzd.scheduleWithFixedDelay(zzfgqVar, j, j, TimeUnit.MILLISECONDS);
                    } else {
                        long j2 = iIntValue;
                        zzbzk.zzd.scheduleAtFixedRate(zzfgqVar, j2, j2, TimeUnit.MILLISECONDS);
                    }
                }
            }
        }
        if (zza() && zzfggVar != null) {
            synchronized (zzc) {
                zzfgv zzfgvVar = zzfgqVar.zzg;
                if (zzfgvVar.zza() >= ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zziQ)).intValue()) {
                    return;
                }
                zzfgr zzfgrVarZza = zzfgu.zza();
                zzfgrVarZza.zzu(zzfggVar.zzm());
                zzfgrVarZza.zzq(zzfggVar.zzl());
                zzfgrVarZza.zzg(zzfggVar.zzb());
                zzfgrVarZza.zzw(3);
                zzfgrVarZza.zzn(zzfgqVar.zzf.afmaVersion);
                zzfgrVarZza.zzb(zzfgqVar.zzh);
                zzfgrVarZza.zzk(Build.VERSION.RELEASE);
                zzfgrVarZza.zzr(Build.VERSION.SDK_INT);
                zzfgrVarZza.zzv(zzfggVar.zzo());
                zzfgrVarZza.zzj(zzfggVar.zza());
                zzfgrVarZza.zze(zzfgqVar.zzi);
                zzfgrVarZza.zzt(zzfggVar.zzn());
                zzfgrVarZza.zzc(zzfggVar.zze());
                zzfgrVarZza.zzf(zzfggVar.zzg());
                zzfgrVarZza.zzh(zzfggVar.zzh());
                zzfgrVarZza.zzi(zzfgqVar.zzj.zzb(zzfggVar.zzh()));
                zzfgrVarZza.zzl(zzfggVar.zzi());
                zzfgrVarZza.zzm(zzfggVar.zzd());
                zzfgrVarZza.zzd(zzfggVar.zzf());
                zzfgrVarZza.zzs(zzfggVar.zzk());
                zzfgrVarZza.zzo(zzfggVar.zzj());
                zzfgrVarZza.zzp(zzfggVar.zzc());
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zziU)).booleanValue()) {
                    zzfgrVarZza.zza(zzfgqVar.zzk);
                }
                zzfgw zzfgwVarZza = zzfgx.zza();
                zzfgwVarZza.zza(zzfgrVarZza);
                zzfgvVar.zzb(zzfgwVarZza);
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte[] bArrZzaV;
        if (zza()) {
            Object obj = zzc;
            synchronized (obj) {
                if (this.zzg.zza() == 0) {
                    return;
                }
                try {
                    synchronized (obj) {
                        zzfgv zzfgvVar = this.zzg;
                        bArrZzaV = ((zzfgz) zzfgvVar.zzbr()).zzaV();
                        zzfgvVar.zzc();
                    }
                    zzdyw zzdywVar = new zzdyw((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zziO), 60000, new HashMap(), bArrZzaV, CommonGatewayClient.HEADER_PROTOBUF, false);
                    new zzdyy(this.zze, this.zzf.afmaVersion, this.zzm, Binder.getCallingUid()).zza(zzdywVar);
                } catch (Exception e) {
                    if ((e instanceof zzdvg) && ((zzdvg) e).zza() == 3) {
                        return;
                    }
                    com.google.android.gms.ads.internal.zzv.zzp().zzv(e, "CuiMonitor.sendCuiPing");
                }
            }
        }
    }

    public final void zzc(final zzfgg zzfggVar) {
        zzbzk.zza.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfgp
            @Override // java.lang.Runnable
            public final void run() {
                zzfgq.zzb(this.zza, zzfggVar);
            }
        });
    }
}
