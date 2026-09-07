package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes14.dex */
public final class zzdmb extends zzbgm {
    private final Context zza;
    private final zzdhq zzb;
    private zzdiq zzc;
    private zzdhl zzd;

    public zzdmb(Context context, zzdhq zzdhqVar, zzdiq zzdiqVar, zzdhl zzdhlVar) {
        this.zza = context;
        this.zzb = zzdhqVar;
        this.zzc = zzdiqVar;
        this.zzd = zzdhlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbgn
    public final com.google.android.gms.ads.internal.client.zzea zze() {
        return this.zzb.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbgn
    public final zzbfq zzf() throws RemoteException {
        try {
            return this.zzd.zzc().zza();
        } catch (NullPointerException e) {
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "InternalNativeCustomTemplateAdShim.getMediaContent");
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgn
    public final zzbft zzg(String str) {
        return (zzbft) this.zzb.zzh().get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbgn
    public final IObjectWrapper zzh() {
        return ObjectWrapper.wrap(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbgn
    public final String zzi() {
        return this.zzb.zzA();
    }

    @Override // com.google.android.gms.internal.ads.zzbgn
    public final String zzj(String str) {
        return (String) this.zzb.zzi().get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbgn
    public final List zzk() {
        try {
            zzdhq zzdhqVar = this.zzb;
            SimpleArrayMap simpleArrayMapZzh = zzdhqVar.zzh();
            SimpleArrayMap simpleArrayMapZzi = zzdhqVar.zzi();
            String[] strArr = new String[simpleArrayMapZzh.size() + simpleArrayMapZzi.size()];
            int i = 0;
            for (int i2 = 0; i2 < simpleArrayMapZzh.size(); i2++) {
                strArr[i] = (String) simpleArrayMapZzh.keyAt(i2);
                i++;
            }
            for (int i3 = 0; i3 < simpleArrayMapZzi.size(); i3++) {
                strArr[i] = (String) simpleArrayMapZzi.keyAt(i3);
                i++;
            }
            return Arrays.asList(strArr);
        } catch (NullPointerException e) {
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "InternalNativeCustomTemplateAdShim.getAvailableAssetNames");
            return new ArrayList();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgn
    public final void zzl() {
        zzdhl zzdhlVar = this.zzd;
        if (zzdhlVar != null) {
            zzdhlVar.zzb();
        }
        this.zzd = null;
        this.zzc = null;
    }

    @Override // com.google.android.gms.internal.ads.zzbgn
    public final void zzm() {
        try {
            String strZzC = this.zzb.zzC();
            if (Objects.equals(strZzC, "Google")) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Illegal argument specified for omid partner name.");
            } else if (TextUtils.isEmpty(strZzC)) {
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Not starting OMID session. OM partner name has not been configured.");
            } else {
                zzdhl zzdhlVar = this.zzd;
                if (zzdhlVar != null) {
                    zzdhlVar.zzf(strZzC, false);
                }
            }
        } catch (NullPointerException e) {
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "InternalNativeCustomTemplateAdShim.initializeDisplayOpenMeasurement");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgn
    public final void zzn(String str) {
        zzdhl zzdhlVar = this.zzd;
        if (zzdhlVar != null) {
            zzdhlVar.zzF(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgn
    public final void zzo() {
        zzdhl zzdhlVar = this.zzd;
        if (zzdhlVar != null) {
            zzdhlVar.zzJ();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgn
    public final void zzp(IObjectWrapper iObjectWrapper) {
        zzdhl zzdhlVar;
        Object objUnwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(objUnwrap instanceof View) || this.zzb.zzu() == null || (zzdhlVar = this.zzd) == null) {
            return;
        }
        zzdhlVar.zzK((View) objUnwrap);
    }

    @Override // com.google.android.gms.internal.ads.zzbgn
    public final boolean zzq() {
        zzdhl zzdhlVar = this.zzd;
        if (zzdhlVar != null && !zzdhlVar.zzX()) {
            return false;
        }
        zzdhq zzdhqVar = this.zzb;
        return zzdhqVar.zzr() != null && zzdhqVar.zzs() == null;
    }

    @Override // com.google.android.gms.internal.ads.zzbgn
    public final boolean zzr(IObjectWrapper iObjectWrapper) {
        zzdiq zzdiqVar;
        Object objUnwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(objUnwrap instanceof ViewGroup) || (zzdiqVar = this.zzc) == null || !zzdiqVar.zzf((ViewGroup) objUnwrap)) {
            return false;
        }
        this.zzb.zzq().zzar(new zzdma(this, NativeCustomFormatAd.ASSET_NAME_VIDEO));
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbgn
    public final boolean zzs(IObjectWrapper iObjectWrapper) {
        zzdiq zzdiqVar;
        Object objUnwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(objUnwrap instanceof ViewGroup) || (zzdiqVar = this.zzc) == null || !zzdiqVar.zzg((ViewGroup) objUnwrap)) {
            return false;
        }
        this.zzb.zzs().zzar(new zzdma(this, NativeCustomFormatAd.ASSET_NAME_VIDEO));
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbgn
    public final boolean zzt() {
        zzdhq zzdhqVar = this.zzb;
        zzeca zzecaVarZzu = zzdhqVar.zzu();
        if (zzecaVarZzu == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Trying to start OMID session before creation.");
            return false;
        }
        com.google.android.gms.ads.internal.zzv.zzB().zzk(zzecaVarZzu.zza());
        if (zzdhqVar.zzr() == null) {
            return true;
        }
        zzdhqVar.zzr().zzd("onSdkLoaded", new ArrayMap());
        return true;
    }
}
