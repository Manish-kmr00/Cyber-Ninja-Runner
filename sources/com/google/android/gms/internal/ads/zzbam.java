package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
final class zzbam implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zzbao zza;

    zzbam(zzbao zzbaoVar) {
        this.zza = zzbaoVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzbao zzbaoVar = this.zza;
        synchronized (zzbaoVar.zzc) {
            try {
                if (zzbaoVar.zzd != null) {
                    zzbaoVar.zzf = zzbaoVar.zzd.zzq();
                }
            } catch (DeadObjectException e) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to obtain a cache service instance.", e);
                zzbao.zzh(this.zza);
            }
            this.zza.zzc.notifyAll();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        zzbao zzbaoVar = this.zza;
        synchronized (zzbaoVar.zzc) {
            zzbaoVar.zzf = null;
            zzbaoVar.zzc.notifyAll();
        }
    }
}
