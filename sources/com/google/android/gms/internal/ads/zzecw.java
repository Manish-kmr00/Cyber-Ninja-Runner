package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
final class zzecw extends zzbqh {
    private final zzeci zza;

    @Override // com.google.android.gms.internal.ads.zzbqi
    public final void zze(String str) throws RemoteException {
        ((zzedw) this.zza.zzc).zzi(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbqi
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        ((zzedw) this.zza.zzc).zzh(zzeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbqi
    public final void zzg() throws RemoteException {
        ((zzedw) this.zza.zzc).zzo();
    }
}
