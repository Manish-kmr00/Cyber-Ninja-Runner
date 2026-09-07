package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzedu implements zzecf {
    private final Context zza;
    private final zzdfe zzb;
    private final Executor zzc;
    private final zzfat zzd;
    private final zzdre zze;

    public zzedu(Context context, Executor executor, zzdfe zzdfeVar, zzfat zzfatVar, zzdre zzdreVar) {
        this.zza = context;
        this.zzb = zzdfeVar;
        this.zzc = executor;
        this.zzd = zzfatVar;
        this.zze = zzdreVar;
    }

    public static /* synthetic */ ListenableFuture zzd(zzedu zzeduVar, Uri uri, zzfbg zzfbgVar, zzfau zzfauVar, zzfax zzfaxVar, Object obj) {
        try {
            CustomTabsIntent customTabsIntentBuild = new CustomTabsIntent.Builder().build();
            customTabsIntentBuild.intent.setData(uri);
            com.google.android.gms.ads.internal.overlay.zzc zzcVar = new com.google.android.gms.ads.internal.overlay.zzc(customTabsIntentBuild.intent, null);
            zzbzp zzbzpVar = new zzbzp();
            zzdeb zzdebVarZzd = zzeduVar.zzb.zzd(new zzcqw(zzfbgVar, zzfauVar, null), new zzdee(new zzedt(zzeduVar, zzbzpVar, zzfauVar), null));
            zzbzpVar.zzc(new AdOverlayInfoParcel(zzcVar, null, zzdebVarZzd.zza(), null, new VersionInfoParcel(0, 0, false), null, null, zzfaxVar.zzb));
            zzeduVar.zzd.zza();
            return zzgbs.zzh(zzdebVarZzd.zzg());
        } catch (Throwable th) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error in CustomTabsAdRenderer", th);
            throw th;
        }
    }

    private static String zze(zzfau zzfauVar) {
        try {
            return zzfauVar.zzv.getString("tab_url");
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzecf
    public final ListenableFuture zza(final zzfbg zzfbgVar, final zzfau zzfauVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zznd)).booleanValue()) {
            zzdrd zzdrdVarZza = this.zze.zza();
            zzdrdVarZza.zzb("action", "cstm_tbs_rndr");
            zzdrdVarZza.zzj();
        }
        String strZze = zze(zzfauVar);
        final Uri uri = strZze != null ? Uri.parse(strZze) : null;
        final zzfax zzfaxVar = zzfbgVar.zzb.zzb;
        return zzgbs.zzn(zzgbs.zzh(null), new zzgaz() { // from class: com.google.android.gms.internal.ads.zzeds
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                return zzedu.zzd(this.zza, uri, zzfbgVar, zzfauVar, zzfaxVar, obj);
            }
        }, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzecf
    public final boolean zzb(zzfbg zzfbgVar, zzfau zzfauVar) {
        Context context = this.zza;
        return (context instanceof Activity) && zzbdj.zzg(context) && !TextUtils.isEmpty(zze(zzfauVar));
    }
}
