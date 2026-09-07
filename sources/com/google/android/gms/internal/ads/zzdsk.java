package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.json.nu;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdsk {
    private final zzbki zza;

    zzdsk(zzbki zzbkiVar) {
        this.zza = zzbkiVar;
    }

    private final void zzs(zzdsi zzdsiVar) throws RemoteException {
        String strZza = zzdsi.zza(zzdsiVar);
        String strConcat = "Dispatching AFMA event on publisher webview: ".concat(strZza);
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi(strConcat);
        this.zza.zzb(strZza);
    }

    public final void zza() throws RemoteException {
        zzs(new zzdsi(MobileAdsBridgeBase.initializeMethodName, null));
    }

    public final void zzb(long j) throws RemoteException {
        zzdsi zzdsiVar = new zzdsi("interstitial", null);
        zzdsiVar.zza = Long.valueOf(j);
        zzdsiVar.zzc = nu.f;
        this.zza.zzb(zzdsi.zza(zzdsiVar));
    }

    public final void zzc(long j) throws RemoteException {
        zzdsi zzdsiVar = new zzdsi("interstitial", null);
        zzdsiVar.zza = Long.valueOf(j);
        zzdsiVar.zzc = nu.g;
        zzs(zzdsiVar);
    }

    public final void zzd(long j, int i) throws RemoteException {
        zzdsi zzdsiVar = new zzdsi("interstitial", null);
        zzdsiVar.zza = Long.valueOf(j);
        zzdsiVar.zzc = "onAdFailedToLoad";
        zzdsiVar.zzd = Integer.valueOf(i);
        zzs(zzdsiVar);
    }

    public final void zze(long j) throws RemoteException {
        zzdsi zzdsiVar = new zzdsi("interstitial", null);
        zzdsiVar.zza = Long.valueOf(j);
        zzdsiVar.zzc = "onAdLoaded";
        zzs(zzdsiVar);
    }

    public final void zzf(long j) throws RemoteException {
        zzdsi zzdsiVar = new zzdsi("interstitial", null);
        zzdsiVar.zza = Long.valueOf(j);
        zzdsiVar.zzc = "onNativeAdObjectNotAvailable";
        zzs(zzdsiVar);
    }

    public final void zzg(long j) throws RemoteException {
        zzdsi zzdsiVar = new zzdsi("interstitial", null);
        zzdsiVar.zza = Long.valueOf(j);
        zzdsiVar.zzc = nu.c;
        zzs(zzdsiVar);
    }

    public final void zzh(long j) throws RemoteException {
        zzdsi zzdsiVar = new zzdsi("creation", null);
        zzdsiVar.zza = Long.valueOf(j);
        zzdsiVar.zzc = "nativeObjectCreated";
        zzs(zzdsiVar);
    }

    public final void zzi(long j) throws RemoteException {
        zzdsi zzdsiVar = new zzdsi("creation", null);
        zzdsiVar.zza = Long.valueOf(j);
        zzdsiVar.zzc = "nativeObjectNotCreated";
        zzs(zzdsiVar);
    }

    public final void zzj(long j) throws RemoteException {
        zzdsi zzdsiVar = new zzdsi("rewarded", null);
        zzdsiVar.zza = Long.valueOf(j);
        zzdsiVar.zzc = nu.f;
        zzs(zzdsiVar);
    }

    public final void zzk(long j) throws RemoteException {
        zzdsi zzdsiVar = new zzdsi("rewarded", null);
        zzdsiVar.zza = Long.valueOf(j);
        zzdsiVar.zzc = "onRewardedAdClosed";
        zzs(zzdsiVar);
    }

    public final void zzl(long j, zzbwa zzbwaVar) throws RemoteException {
        zzdsi zzdsiVar = new zzdsi("rewarded", null);
        zzdsiVar.zza = Long.valueOf(j);
        zzdsiVar.zzc = "onUserEarnedReward";
        zzdsiVar.zze = zzbwaVar.zzf();
        zzdsiVar.zzf = Integer.valueOf(zzbwaVar.zze());
        zzs(zzdsiVar);
    }

    public final void zzm(long j, int i) throws RemoteException {
        zzdsi zzdsiVar = new zzdsi("rewarded", null);
        zzdsiVar.zza = Long.valueOf(j);
        zzdsiVar.zzc = "onRewardedAdFailedToLoad";
        zzdsiVar.zzd = Integer.valueOf(i);
        zzs(zzdsiVar);
    }

    public final void zzn(long j, int i) throws RemoteException {
        zzdsi zzdsiVar = new zzdsi("rewarded", null);
        zzdsiVar.zza = Long.valueOf(j);
        zzdsiVar.zzc = "onRewardedAdFailedToShow";
        zzdsiVar.zzd = Integer.valueOf(i);
        zzs(zzdsiVar);
    }

    public final void zzo(long j) throws RemoteException {
        zzdsi zzdsiVar = new zzdsi("rewarded", null);
        zzdsiVar.zza = Long.valueOf(j);
        zzdsiVar.zzc = "onAdImpression";
        zzs(zzdsiVar);
    }

    public final void zzp(long j) throws RemoteException {
        zzdsi zzdsiVar = new zzdsi("rewarded", null);
        zzdsiVar.zza = Long.valueOf(j);
        zzdsiVar.zzc = "onRewardedAdLoaded";
        zzs(zzdsiVar);
    }

    public final void zzq(long j) throws RemoteException {
        zzdsi zzdsiVar = new zzdsi("rewarded", null);
        zzdsiVar.zza = Long.valueOf(j);
        zzdsiVar.zzc = "onNativeAdObjectNotAvailable";
        zzs(zzdsiVar);
    }

    public final void zzr(long j) throws RemoteException {
        zzdsi zzdsiVar = new zzdsi("rewarded", null);
        zzdsiVar.zza = Long.valueOf(j);
        zzdsiVar.zzc = "onRewardedAdOpened";
        zzs(zzdsiVar);
    }
}
