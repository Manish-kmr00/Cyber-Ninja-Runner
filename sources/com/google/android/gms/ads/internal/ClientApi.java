package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzbt;
import com.google.android.gms.ads.internal.client.zzbx;
import com.google.android.gms.ads.internal.client.zzch;
import com.google.android.gms.ads.internal.client.zzcn;
import com.google.android.gms.ads.internal.client.zzcy;
import com.google.android.gms.ads.internal.client.zzdt;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzab;
import com.google.android.gms.ads.internal.overlay.zzaf;
import com.google.android.gms.ads.internal.overlay.zzah;
import com.google.android.gms.ads.internal.overlay.zzai;
import com.google.android.gms.ads.internal.overlay.zzw;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbfx;
import com.google.android.gms.internal.ads.zzbgd;
import com.google.android.gms.internal.ads.zzbki;
import com.google.android.gms.internal.ads.zzbkl;
import com.google.android.gms.internal.ads.zzboy;
import com.google.android.gms.internal.ads.zzbsr;
import com.google.android.gms.internal.ads.zzbsy;
import com.google.android.gms.internal.ads.zzbvn;
import com.google.android.gms.internal.ads.zzbwd;
import com.google.android.gms.internal.ads.zzbyi;
import com.google.android.gms.internal.ads.zzcgl;
import com.google.android.gms.internal.ads.zzdik;
import com.google.android.gms.internal.ads.zzdim;
import com.google.android.gms.internal.ads.zzdso;
import com.google.android.gms.internal.ads.zzeiu;
import com.google.android.gms.internal.ads.zzevu;
import com.google.android.gms.internal.ads.zzexi;
import com.google.android.gms.internal.ads.zzeyz;
import com.google.android.gms.internal.ads.zzfan;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public class ClientApi extends zzcn {
    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbt zzb(IObjectWrapper iObjectWrapper, String str, zzboy zzboyVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzeiu(zzcgl.zza(context, zzboyVar, i), context, str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbx zzc(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, zzboy zzboyVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzevu zzevuVarZzs = zzcgl.zza(context, zzboyVar, i).zzs();
        zzevuVarZzs.zza(str);
        zzevuVarZzs.zzb(context);
        return zzevuVarZzs.zzc().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbx zzd(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, zzboy zzboyVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzexi zzexiVarZzt = zzcgl.zza(context, zzboyVar, i).zzt();
        zzexiVarZzt.zzc(context);
        zzexiVarZzt.zza(zzrVar);
        zzexiVarZzt.zzb(str);
        return zzexiVarZzt.zzd().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbx zze(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, zzboy zzboyVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzeyz zzeyzVarZzu = zzcgl.zza(context, zzboyVar, i).zzu();
        zzeyzVarZzu.zzc(context);
        zzeyzVarZzu.zza(zzrVar);
        zzeyzVarZzu.zzb(str);
        return zzeyzVarZzu.zzd().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbx zzf(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, int i) {
        return new zzu((Context) ObjectWrapper.unwrap(iObjectWrapper), zzrVar, str, new VersionInfoParcel(251410000, i, true, false));
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzch zzg(IObjectWrapper iObjectWrapper, zzboy zzboyVar, int i) {
        return zzcgl.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzboyVar, i).zzz();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzcy zzh(IObjectWrapper iObjectWrapper, int i) {
        return zzcgl.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), null, i).zzb();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzdt zzi(IObjectWrapper iObjectWrapper, zzboy zzboyVar, int i) {
        return zzcgl.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzboyVar, i).zzl();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbfx zzj(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new zzdim((FrameLayout) ObjectWrapper.unwrap(iObjectWrapper), (FrameLayout) ObjectWrapper.unwrap(iObjectWrapper2), 251410000);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbgd zzk(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return new zzdik((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbkl zzl(IObjectWrapper iObjectWrapper, zzboy zzboyVar, int i, zzbki zzbkiVar) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzdso zzdsoVarZzj = zzcgl.zza(context, zzboyVar, i).zzj();
        zzdsoVarZzj.zzb(context);
        zzdsoVarZzj.zza(zzbkiVar);
        return zzdsoVarZzj.zzc().zzd();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbsr zzm(IObjectWrapper iObjectWrapper, zzboy zzboyVar, int i) {
        return zzcgl.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzboyVar, i).zzm();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbsy zzn(IObjectWrapper iObjectWrapper) {
        Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        AdOverlayInfoParcel adOverlayInfoParcelZza = AdOverlayInfoParcel.zza(activity.getIntent());
        if (adOverlayInfoParcelZza == null) {
            return new zzw(activity);
        }
        int i = adOverlayInfoParcelZza.zzk;
        if (i == 1) {
            return new com.google.android.gms.ads.internal.overlay.zzv(activity);
        }
        if (i == 2) {
            return new zzah(activity);
        }
        if (i == 3) {
            return new zzai(activity);
        }
        if (i != 4) {
            return i != 5 ? new zzw(activity) : new zzaf(activity);
        }
        return new zzab(activity, adOverlayInfoParcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbvn zzo(IObjectWrapper iObjectWrapper, zzboy zzboyVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfan zzfanVarZzv = zzcgl.zza(context, zzboyVar, i).zzv();
        zzfanVarZzv.zzb(context);
        return zzfanVarZzv.zzc().zzb();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbwd zzp(IObjectWrapper iObjectWrapper, String str, zzboy zzboyVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfan zzfanVarZzv = zzcgl.zza(context, zzboyVar, i).zzv();
        zzfanVarZzv.zzb(context);
        zzfanVarZzv.zza(str);
        return zzfanVarZzv.zzc().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbyi zzq(IObjectWrapper iObjectWrapper, zzboy zzboyVar, int i) {
        return zzcgl.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzboyVar, i).zzp();
    }
}
