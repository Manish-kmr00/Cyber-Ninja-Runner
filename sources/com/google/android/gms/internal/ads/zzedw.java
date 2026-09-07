package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzedw extends zzbpd implements zzcwm {
    private zzbpe zza;
    private zzcwl zzb;

    @Override // com.google.android.gms.internal.ads.zzcwm
    public final synchronized void zza(zzcwl zzcwlVar) {
        this.zzb = zzcwlVar;
    }

    public final synchronized void zzc(zzbpe zzbpeVar) {
        this.zza = zzbpeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpe
    public final synchronized void zze() throws RemoteException {
        zzbpe zzbpeVar = this.zza;
        if (zzbpeVar != null) {
            zzbpeVar.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpe
    public final synchronized void zzf() throws RemoteException {
        zzbpe zzbpeVar = this.zza;
        if (zzbpeVar != null) {
            zzbpeVar.zzf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpe
    public final synchronized void zzg(int i) throws RemoteException {
        zzcwl zzcwlVar = this.zzb;
        if (zzcwlVar != null) {
            zzcwlVar.zza(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpe
    public final synchronized void zzh(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        zzcwl zzcwlVar = this.zzb;
        if (zzcwlVar != null) {
            zzcwlVar.zzb(zzeVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpe
    public final synchronized void zzi(int i, String str) throws RemoteException {
        zzcwl zzcwlVar = this.zzb;
        if (zzcwlVar != null) {
            zzcwlVar.zzc(i, str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpe
    public final synchronized void zzj(int i) throws RemoteException {
        zzbpe zzbpeVar = this.zza;
        if (zzbpeVar != null) {
            zzbpeVar.zzj(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpe
    public final synchronized void zzk(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        zzbpe zzbpeVar = this.zza;
        if (zzbpeVar != null) {
            zzbpeVar.zzk(zzeVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpe
    public final synchronized void zzl(String str) throws RemoteException {
        zzbpe zzbpeVar = this.zza;
        if (zzbpeVar != null) {
            zzbpeVar.zzl(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpe
    public final synchronized void zzm() throws RemoteException {
        zzbpe zzbpeVar = this.zza;
        if (zzbpeVar != null) {
            zzbpeVar.zzm();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpe
    public final synchronized void zzn() throws RemoteException {
        zzbpe zzbpeVar = this.zza;
        if (zzbpeVar != null) {
            zzbpeVar.zzn();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpe
    public final synchronized void zzo() throws RemoteException {
        zzbpe zzbpeVar = this.zza;
        if (zzbpeVar != null) {
            zzbpeVar.zzo();
        }
        zzcwl zzcwlVar = this.zzb;
        if (zzcwlVar != null) {
            zzcwlVar.zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpe
    public final synchronized void zzp() throws RemoteException {
        zzbpe zzbpeVar = this.zza;
        if (zzbpeVar != null) {
            zzbpeVar.zzp();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpe
    public final synchronized void zzq(String str, String str2) throws RemoteException {
        zzbpe zzbpeVar = this.zza;
        if (zzbpeVar != null) {
            zzbpeVar.zzq(str, str2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpe
    public final synchronized void zzr(zzbgn zzbgnVar, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbpe
    public final synchronized void zzs(zzbvw zzbvwVar) throws RemoteException {
        zzbpe zzbpeVar = this.zza;
        if (zzbpeVar != null) {
            zzbpeVar.zzs(zzbvwVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpe
    public final synchronized void zzt(zzbwa zzbwaVar) throws RemoteException {
        zzbpe zzbpeVar = this.zza;
        if (zzbpeVar != null) {
            zzbpeVar.zzt(zzbwaVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpe
    public final synchronized void zzu() throws RemoteException {
        zzbpe zzbpeVar = this.zza;
        if (zzbpeVar != null) {
            zzbpeVar.zzu();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpe
    public final synchronized void zzv() throws RemoteException {
        zzbpe zzbpeVar = this.zza;
        if (zzbpeVar != null) {
            zzbpeVar.zzv();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpe
    public final synchronized void zzw() throws RemoteException {
        zzbpe zzbpeVar = this.zza;
        if (zzbpeVar != null) {
            zzbpeVar.zzw();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpe
    public final synchronized void zzx() throws RemoteException {
        zzbpe zzbpeVar = this.zza;
        if (zzbpeVar != null) {
            zzbpeVar.zzx();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpe
    public final synchronized void zzy() throws RemoteException {
        zzbpe zzbpeVar = this.zza;
        if (zzbpeVar != null) {
            zzbpeVar.zzy();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpe
    public final synchronized void zzz() throws RemoteException {
        zzbpe zzbpeVar = this.zza;
        if (zzbpeVar != null) {
            zzbpeVar.zzz();
        }
    }
}
