package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.ClientApi;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfiw extends zzfjn {
    public zzfiw(ClientApi clientApi, Context context, int i, zzboy zzboyVar, com.google.android.gms.ads.internal.client.zzfp zzfpVar, com.google.android.gms.ads.internal.client.zzce zzceVar, ScheduledExecutorService scheduledExecutorService, zzfiu zzfiuVar, Clock clock) {
        super(clientApi, context, i, zzboyVar, zzfpVar, zzceVar, scheduledExecutorService, zzfiuVar, clock);
    }

    @Override // com.google.android.gms.internal.ads.zzfjn
    protected final /* bridge */ /* synthetic */ com.google.android.gms.ads.internal.client.zzdx zza(Object obj) {
        try {
            return ((com.google.android.gms.ads.internal.client.zzbx) obj).zzk();
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzf("Failed to get response info for  the interstitial ad.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfjn
    protected final ListenableFuture zzb(Context context) {
        zzgcm zzgcmVarZze = zzgcm.zze();
        com.google.android.gms.ads.internal.client.zzbx zzbxVarZze = this.zza.zze(ObjectWrapper.wrap(context), new com.google.android.gms.ads.internal.client.zzr(), this.zze.zza, this.zzd, this.zzc);
        if (zzbxVarZze != null) {
            try {
                zzbxVarZze.zzy(this.zze.zzc, new zzfiv(this, zzgcmVarZze, zzbxVarZze));
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to load interstitial ad.", e);
                zzgcmVarZze.zzd(new zzfiq(1, "remote exception"));
            }
        } else {
            zzgcmVarZze.zzd(new zzfiq(1, "Failed to create an interstitial ad manager."));
        }
        return zzgcmVarZze;
    }
}
