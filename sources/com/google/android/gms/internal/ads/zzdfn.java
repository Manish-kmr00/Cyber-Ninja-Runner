package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdfn implements zzcwq, com.google.android.gms.ads.internal.overlay.zzr, zzcvw {
    zzeca zza;
    private final Context zzb;
    private final zzcel zzc;
    private final zzfau zzd;
    private final VersionInfoParcel zze;
    private final zzeby zzf;

    public zzdfn(Context context, zzcel zzcelVar, zzfau zzfauVar, VersionInfoParcel versionInfoParcel, zzeby zzebyVar) {
        this.zzb = context;
        this.zzc = zzcelVar;
        this.zzd = zzfauVar;
        this.zze = versionInfoParcel;
        this.zzf = zzebyVar;
    }

    private final boolean zzg() {
        return ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfp)).booleanValue() && this.zzf.zzd();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdE() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdi() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdo() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdp() {
        zzcel zzcelVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfs)).booleanValue() || (zzcelVar = this.zzc) == null) {
            return;
        }
        if (this.zza != null || zzg()) {
            if (this.zza != null) {
                zzcelVar.zzd("onSdkImpression", new ArrayMap());
            } else {
                this.zzf.zzb();
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdr() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzds(int i) {
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzcvw
    public final void zzs() {
        zzcel zzcelVar;
        if (zzg()) {
            this.zzf.zzb();
        } else {
            if (this.zza == null || (zzcelVar = this.zzc) == null) {
                return;
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfs)).booleanValue()) {
                zzcelVar.zzd("onSdkImpression", new ArrayMap());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zzt() {
        zzcel zzcelVar;
        zzebx zzebxVar;
        zzebw zzebwVar;
        zzfau zzfauVar = this.zzd;
        if (!zzfauVar.zzT || (zzcelVar = this.zzc) == null) {
            return;
        }
        if (com.google.android.gms.ads.internal.zzv.zzB().zzl(this.zzb)) {
            if (zzg()) {
                this.zzf.zzc();
                return;
            }
            VersionInfoParcel versionInfoParcel = this.zze;
            String str = versionInfoParcel.buddyApkVersion + "." + versionInfoParcel.clientJarVersion;
            zzfbs zzfbsVar = zzfauVar.zzV;
            String strZza = zzfbsVar.zza();
            if (zzfbsVar.zzc() == 1) {
                zzebwVar = zzebw.VIDEO;
                zzebxVar = zzebx.DEFINED_BY_JAVASCRIPT;
            } else {
                zzebxVar = zzfauVar.zzY == 2 ? zzebx.UNSPECIFIED : zzebx.BEGIN_TO_RENDER;
                zzebwVar = zzebw.HTML_DISPLAY;
            }
            zzeca zzecaVarZza = com.google.android.gms.ads.internal.zzv.zzB().zza(str, zzcelVar.zzG(), "", "javascript", strZza, zzebxVar, zzebwVar, zzfauVar.zzal);
            this.zza = zzecaVarZza;
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
                zzcelVar.zzat(this.zza);
                com.google.android.gms.ads.internal.zzv.zzB().zzk(zzfjvVarZza);
                zzcelVar.zzd("onSdkLoaded", new ArrayMap());
            }
        }
    }
}
