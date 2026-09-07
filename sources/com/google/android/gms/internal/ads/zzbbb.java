package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
final class zzbbb implements BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzbzp zza;
    final /* synthetic */ zzbbc zzb;

    zzbbb(zzbbc zzbbcVar, zzbzp zzbzpVar) {
        this.zza = zzbzpVar;
        this.zzb = zzbbcVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        synchronized (this.zzb.zzd) {
            this.zza.zzd(new RuntimeException("Connection failed."));
        }
    }
}
