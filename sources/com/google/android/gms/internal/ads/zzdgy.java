package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdgy extends zzbfp {
    private final zzdhq zza;
    private IObjectWrapper zzb;

    public zzdgy(zzdhq zzdhqVar) {
        this.zza = zzdhqVar;
    }

    private static float zzb(IObjectWrapper iObjectWrapper) {
        Drawable drawable;
        if (iObjectWrapper == null || (drawable = (Drawable) ObjectWrapper.unwrap(iObjectWrapper)) == null || drawable.getIntrinsicWidth() == -1 || drawable.getIntrinsicHeight() == -1) {
            return 0.0f;
        }
        return drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final float zze() throws RemoteException {
        zzdhq zzdhqVar = this.zza;
        if (zzdhqVar.zzb() != 0.0f) {
            return zzdhqVar.zzb();
        }
        if (zzdhqVar.zzj() != null) {
            try {
                return zzdhqVar.zzj().zze();
            } catch (RemoteException e) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Remote exception getting video controller aspect ratio.", e);
                return 0.0f;
            }
        }
        IObjectWrapper iObjectWrapper = this.zzb;
        if (iObjectWrapper != null) {
            return zzb(iObjectWrapper);
        }
        zzbft zzbftVarZzm = zzdhqVar.zzm();
        if (zzbftVarZzm == null) {
            return 0.0f;
        }
        float fZzd = (zzbftVarZzm.zzd() == -1 || zzbftVarZzm.zzc() == -1) ? 0.0f : zzbftVarZzm.zzd() / zzbftVarZzm.zzc();
        return fZzd == 0.0f ? zzb(zzbftVarZzm.zzf()) : fZzd;
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final float zzf() throws RemoteException {
        zzdhq zzdhqVar = this.zza;
        if (zzdhqVar.zzj() != null) {
            return zzdhqVar.zzj().zzf();
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final float zzg() throws RemoteException {
        zzdhq zzdhqVar = this.zza;
        if (zzdhqVar.zzj() != null) {
            return zzdhqVar.zzj().zzg();
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final com.google.android.gms.ads.internal.client.zzea zzh() throws RemoteException {
        return this.zza.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final IObjectWrapper zzi() throws RemoteException {
        IObjectWrapper iObjectWrapper = this.zzb;
        if (iObjectWrapper != null) {
            return iObjectWrapper;
        }
        zzbft zzbftVarZzm = this.zza.zzm();
        if (zzbftVarZzm == null) {
            return null;
        }
        return zzbftVarZzm.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final void zzj(IObjectWrapper iObjectWrapper) {
        this.zzb = iObjectWrapper;
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final boolean zzk() throws RemoteException {
        return this.zza.zzaf();
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final boolean zzl() throws RemoteException {
        return this.zza.zzj() != null;
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final void zzm(zzbhb zzbhbVar) {
        zzdhq zzdhqVar = this.zza;
        if (zzdhqVar.zzj() instanceof zzcfn) {
            ((zzcfn) zzdhqVar.zzj()).zzv(zzbhbVar);
        }
    }
}
