package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
final class zzban implements BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzbao zza;

    zzban(zzbao zzbaoVar) {
        this.zza = zzbaoVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zzbao zzbaoVar = this.zza;
        synchronized (zzbaoVar.zzc) {
            zzbaoVar.zzf = null;
            if (zzbaoVar.zzd != null) {
                zzbaoVar.zzd = null;
            }
            zzbaoVar.zzc.notifyAll();
        }
    }
}
