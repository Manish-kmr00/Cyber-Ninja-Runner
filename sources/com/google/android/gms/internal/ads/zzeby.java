package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzeby {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private final zzfau zzc;
    private final zzcel zzd;
    private final zzdre zze;
    private zzfkg zzf;

    zzeby(Context context, VersionInfoParcel versionInfoParcel, zzfau zzfauVar, zzcel zzcelVar, zzdre zzdreVar) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = zzfauVar;
        this.zzd = zzcelVar;
        this.zze = zzdreVar;
    }

    public final synchronized void zza(View view) {
        zzfkg zzfkgVar = this.zzf;
        if (zzfkgVar != null) {
            com.google.android.gms.ads.internal.zzv.zzB().zzh(zzfkgVar, view);
        }
    }

    public final synchronized void zzb() {
        zzcel zzcelVar;
        if (this.zzf == null || (zzcelVar = this.zzd) == null) {
            return;
        }
        zzcelVar.zzd("onSdkImpression", zzfwz.zzd());
    }

    public final synchronized void zzc() {
        zzcel zzcelVar;
        zzfkg zzfkgVar = this.zzf;
        if (zzfkgVar == null || (zzcelVar = this.zzd) == null) {
            return;
        }
        Iterator it = zzcelVar.zzV().iterator();
        while (it.hasNext()) {
            com.google.android.gms.ads.internal.zzv.zzB().zzh(zzfkgVar, (View) it.next());
        }
        zzcelVar.zzd("onSdkLoaded", zzfwz.zzd());
    }

    public final synchronized boolean zzd() {
        return this.zzf != null;
    }

    public final synchronized boolean zze(boolean z) {
        zzcel zzcelVar;
        zzfau zzfauVar = this.zzc;
        if (zzfauVar.zzT) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfm)).booleanValue()) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfp)).booleanValue() && (zzcelVar = this.zzd) != null) {
                    if (this.zzf != null) {
                        int i = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzj("Omid javascript session service already started for ad.");
                        return false;
                    }
                    if (!com.google.android.gms.ads.internal.zzv.zzB().zzl(this.zza)) {
                        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzj("Unable to initialize omid.");
                        return false;
                    }
                    if (zzfauVar.zzV.zzb()) {
                        zzfkg zzfkgVarZze = com.google.android.gms.ads.internal.zzv.zzB().zze(this.zzb, zzcelVar.zzG(), true);
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfq)).booleanValue()) {
                            zzdre zzdreVar = this.zze;
                            String str = zzfkgVarZze != null ? "1" : "0";
                            zzdrd zzdrdVarZza = zzdreVar.zza();
                            zzdrdVarZza.zzb("omid_js_session_success", str);
                            zzdrdVarZza.zzj();
                        }
                        if (zzfkgVarZze == null) {
                            int i3 = com.google.android.gms.ads.internal.util.zze.zza;
                            com.google.android.gms.ads.internal.util.client.zzo.zzj("Unable to create javascript session service.");
                            return false;
                        }
                        int i4 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzi("Created omid javascript session service.");
                        this.zzf = zzfkgVarZze;
                        zzcelVar.zzas(this);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final synchronized void zzf(zzcfc zzcfcVar) {
        zzcel zzcelVar;
        zzfkg zzfkgVar = this.zzf;
        if (zzfkgVar == null || (zzcelVar = this.zzd) == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzv.zzB().zzm(zzfkgVar, zzcfcVar);
        this.zzf = null;
        zzcelVar.zzas(null);
    }
}
