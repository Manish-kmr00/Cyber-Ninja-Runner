package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdfr implements zzcvc, zzdch {
    private final zzbxs zza;
    private final Context zzb;
    private final zzbxw zzc;
    private final View zzd;
    private String zze;
    private final zzbbn.zza.EnumC0270zza zzf;

    public zzdfr(zzbxs zzbxsVar, Context context, zzbxw zzbxwVar, View view, zzbbn.zza.EnumC0270zza enumC0270zza) {
        this.zza = zzbxsVar;
        this.zzb = context;
        this.zzc = zzbxwVar;
        this.zzd = view;
        this.zzf = enumC0270zza;
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zza() {
        this.zza.zzb(false);
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zzb() {
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zzc() {
        View view = this.zzd;
        if (view != null && this.zze != null) {
            this.zzc.zzo(view.getContext(), this.zze);
        }
        this.zza.zzb(true);
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    @ParametersAreNonnullByDefault
    public final void zzdq(zzbvk zzbvkVar, String str, String str2) {
        zzbxw zzbxwVar = this.zzc;
        Context context = this.zzb;
        if (zzbxwVar.zzp(context)) {
            try {
                zzbxwVar.zzl(context, zzbxwVar.zzb(context), this.zza.zza(), zzbvkVar.zzc(), zzbvkVar.zzb());
            } catch (RemoteException e) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzk("Remote Exception to get reward item.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zze() {
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzdch
    public final void zzu() {
    }

    @Override // com.google.android.gms.internal.ads.zzdch
    public final void zzv() {
        zzbbn.zza.EnumC0270zza enumC0270zza = this.zzf;
        if (enumC0270zza == zzbbn.zza.EnumC0270zza.APP_OPEN) {
            return;
        }
        String strZzd = this.zzc.zzd(this.zzb);
        this.zze = strZzd;
        this.zze = String.valueOf(strZzd).concat(enumC0270zza == zzbbn.zza.EnumC0270zza.REWARD_BASED_VIDEO_AD ? "/Rewarded" : "/Interstitial");
    }
}
