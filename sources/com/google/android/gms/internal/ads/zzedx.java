package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzedx extends zzbvu implements zzcwm {
    private zzbvv zza;
    private zzcwl zzb;
    private zzddn zzc;

    @Override // com.google.android.gms.internal.ads.zzcwm
    public final synchronized void zza(zzcwl zzcwlVar) {
        this.zzb = zzcwlVar;
    }

    public final synchronized void zzc(zzbvv zzbvvVar) {
        this.zza = zzbvvVar;
    }

    public final synchronized void zzd(zzddn zzddnVar) {
        this.zzc = zzddnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbvv
    public final synchronized void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbvv zzbvvVar = this.zza;
        if (zzbvvVar != null) {
            ((zzehc) zzbvvVar).zzb.onAdClicked();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvv
    public final synchronized void zzf(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbvv zzbvvVar = this.zza;
        if (zzbvvVar != null) {
            zzbvvVar.zzf(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvv
    public final synchronized void zzg(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        zzcwl zzcwlVar = this.zzb;
        if (zzcwlVar != null) {
            zzcwlVar.zza(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvv
    public final synchronized void zzh(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbvv zzbvvVar = this.zza;
        if (zzbvvVar != null) {
            ((zzehc) zzbvvVar).zzc.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvv
    public final synchronized void zzi(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzcwl zzcwlVar = this.zzb;
        if (zzcwlVar != null) {
            zzcwlVar.zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvv
    public final synchronized void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbvv zzbvvVar = this.zza;
        if (zzbvvVar != null) {
            ((zzehc) zzbvvVar).zza.zzdp();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvv
    public final synchronized void zzk(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        zzddn zzddnVar = this.zzc;
        if (zzddnVar != null) {
            zzeci zzeciVar = ((zzeha) zzddnVar).zzc;
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Fail to initialize adapter ".concat(String.valueOf(zzeciVar.zza)));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvv
    public final synchronized void zzl(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzddn zzddnVar = this.zzc;
        if (zzddnVar != null) {
            Executor executor = ((zzeha) zzddnVar).zzd.zzb;
            final zzeci zzeciVar = ((zzeha) zzddnVar).zzc;
            final zzfau zzfauVar = ((zzeha) zzddnVar).zzb;
            final zzfbg zzfbgVar = ((zzeha) zzddnVar).zza;
            final zzeha zzehaVar = (zzeha) zzddnVar;
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzegz
                @Override // java.lang.Runnable
                public final void run() {
                    zzehd zzehdVar = zzehaVar.zzd;
                    zzehd.zze(zzfbgVar, zzfauVar, zzeciVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvv
    public final synchronized void zzm(IObjectWrapper iObjectWrapper, zzbvw zzbvwVar) throws RemoteException {
        zzbvv zzbvvVar = this.zza;
        if (zzbvvVar != null) {
            ((zzehc) zzbvvVar).zzd.zza(zzbvwVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvv
    public final synchronized void zzn(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbvv zzbvvVar = this.zza;
        if (zzbvvVar != null) {
            ((zzehc) zzbvvVar).zzd.zza(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvv
    public final synchronized void zzo(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbvv zzbvvVar = this.zza;
        if (zzbvvVar != null) {
            ((zzehc) zzbvvVar).zzc.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvv
    public final synchronized void zzp(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbvv zzbvvVar = this.zza;
        if (zzbvvVar != null) {
            ((zzehc) zzbvvVar).zzd.zzc();
        }
    }
}
