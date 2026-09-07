package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcpt implements zzcwq, zzcvw {
    private final Context zza;
    private final zzcel zzb;
    private final zzfau zzc;
    private final VersionInfoParcel zzd;
    private zzeca zze;
    private boolean zzf;
    private final zzeby zzg;

    public zzcpt(Context context, zzcel zzcelVar, zzfau zzfauVar, VersionInfoParcel versionInfoParcel, zzeby zzebyVar) {
        this.zza = context;
        this.zzb = zzcelVar;
        this.zzc = zzfauVar;
        this.zzd = versionInfoParcel;
        this.zzg = zzebyVar;
    }

    private final synchronized void zza() {
        zzcel zzcelVar;
        zzebx zzebxVar;
        zzebw zzebwVar;
        zzfau zzfauVar = this.zzc;
        if (zzfauVar.zzT && (zzcelVar = this.zzb) != null) {
            if (com.google.android.gms.ads.internal.zzv.zzB().zzl(this.zza)) {
                VersionInfoParcel versionInfoParcel = this.zzd;
                String str = versionInfoParcel.buddyApkVersion + "." + versionInfoParcel.clientJarVersion;
                zzfbs zzfbsVar = zzfauVar.zzV;
                String strZza = zzfbsVar.zza();
                if (zzfbsVar.zzc() == 1) {
                    zzebwVar = zzebw.VIDEO;
                    zzebxVar = zzebx.DEFINED_BY_JAVASCRIPT;
                } else {
                    int i = zzfauVar.zze;
                    zzebw zzebwVar2 = zzebw.HTML_DISPLAY;
                    zzebxVar = i == 1 ? zzebx.ONE_PIXEL : zzebx.BEGIN_TO_RENDER;
                    zzebwVar = zzebwVar2;
                }
                zzeca zzecaVarZza = com.google.android.gms.ads.internal.zzv.zzB().zza(str, zzcelVar.zzG(), "", "javascript", strZza, zzebxVar, zzebwVar, zzfauVar.zzal);
                this.zze = zzecaVarZza;
                if (zzecaVarZza != null) {
                    zzfjv zzfjvVarZza = zzecaVarZza.zza();
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfo)).booleanValue()) {
                        com.google.android.gms.ads.internal.zzv.zzB().zzj(zzfjvVarZza, zzcelVar.zzG());
                        Iterator it = zzcelVar.zzV().iterator();
                        while (it.hasNext()) {
                            com.google.android.gms.ads.internal.zzv.zzB().zzg(zzfjvVarZza, (View) it.next());
                        }
                    } else {
                        com.google.android.gms.ads.internal.zzv.zzB().zzj(zzfjvVarZza, zzcelVar.zzF());
                    }
                    zzcelVar.zzat(this.zze);
                    com.google.android.gms.ads.internal.zzv.zzB().zzk(zzfjvVarZza);
                    this.zzf = true;
                    zzcelVar.zzd("onSdkLoaded", new ArrayMap());
                }
            }
        }
    }

    private final boolean zzb() {
        return ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfp)).booleanValue() && this.zzg.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzcvw
    public final synchronized void zzs() {
        zzcel zzcelVar;
        if (zzb()) {
            this.zzg.zzb();
            return;
        }
        if (!this.zzf) {
            zza();
        }
        if (!this.zzc.zzT || this.zze == null || (zzcelVar = this.zzb) == null) {
            return;
        }
        zzcelVar.zzd("onSdkImpression", new ArrayMap());
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final synchronized void zzt() {
        if (zzb()) {
            this.zzg.zzc();
        } else {
            if (this.zzf) {
                return;
            }
            zza();
        }
    }
}
