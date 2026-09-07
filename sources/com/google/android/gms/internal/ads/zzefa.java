package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzefa implements zzecl {
    private final Context zza;
    private final zzdga zzb;
    private zzbpn zzc;
    private final VersionInfoParcel zzd;

    public zzefa(Context context, zzdga zzdgaVar, VersionInfoParcel versionInfoParcel) {
        this.zza = context;
        this.zzb = zzdgaVar;
        this.zzd = versionInfoParcel;
    }

    @Override // com.google.android.gms.internal.ads.zzecl
    public final /* bridge */ /* synthetic */ Object zza(zzfbg zzfbgVar, zzfau zzfauVar, zzeci zzeciVar) throws zzefy, zzfbw {
        ArrayList arrayList = zzfbgVar.zza.zza.zzg;
        if (!arrayList.contains(Integer.toString(6))) {
            throw new zzefy(2, "Unified must be used for RTB.");
        }
        zzdhq zzdhqVarZzt = zzdhq.zzt(this.zzc);
        if (!arrayList.contains(Integer.toString(zzdhqVarZzt.zzc()))) {
            throw new zzefy(1, "No corresponding native ad listener");
        }
        zzdhs zzdhsVarZze = this.zzb.zze(new zzcqw(zzfbgVar, zzfauVar, zzeciVar.zza), new zzdic(zzdhqVarZzt), new zzdjv(null, null, this.zzc));
        ((zzedw) zzeciVar.zzc).zzc(zzdhsVarZze.zzj());
        return zzdhsVarZze.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzecl
    public final void zzb(zzfbg zzfbgVar, zzfau zzfauVar, zzeci zzeciVar) throws zzfbw {
        try {
            zzbqx zzbqxVar = (zzbqx) zzeciVar.zzb;
            zzbqxVar.zzq(zzfauVar.zzZ);
            zzeez zzeezVar = null;
            if (this.zzd.clientJarVersion < ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbT)).intValue()) {
                zzbqxVar.zzm(zzfauVar.zzU, zzfauVar.zzv.toString(), zzfbgVar.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzeey(this, zzeciVar, zzeezVar), (zzbpe) zzeciVar.zzc);
                return;
            }
            String str = zzfauVar.zzU;
            String string = zzfauVar.zzv.toString();
            zzfbp zzfbpVar = zzfbgVar.zza.zza;
            zzbqxVar.zzn(str, string, zzfbpVar.zzd, ObjectWrapper.wrap(this.zza), new zzeey(this, zzeciVar, zzeezVar), (zzbpe) zzeciVar.zzc, zzfbpVar.zzi);
        } catch (RemoteException e) {
            throw new zzfbw(e);
        }
    }
}
