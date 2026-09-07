package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbci;
import com.google.android.gms.internal.ads.zzbtn;
import com.google.android.gms.internal.ads.zzgbo;
import java.util.ArrayList;
import javax.annotation.Nonnull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
final class zzar implements zzgbo {
    final /* synthetic */ zzbtn zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzau zzc;

    zzar(zzau zzauVar, zzbtn zzbtnVar, boolean z) {
        this.zza = zzbtnVar;
        this.zzb = z;
        this.zzc = zzauVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final void zza(Throwable th) {
        try {
            this.zza.zze("Internal error: " + th.getMessage());
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final /* bridge */ /* synthetic */ void zzb(@Nonnull Object obj) {
        ArrayList<Uri> arrayList = (ArrayList) obj;
        try {
            this.zza.zzf(arrayList);
            zzau zzauVar = this.zzc;
            if (zzauVar.zzr || this.zzb) {
                for (Uri uri : arrayList) {
                    if (zzauVar.zzQ(uri)) {
                        zzauVar.zzq.zzd(zzau.zzaa(uri, zzauVar.zzA, "1").toString(), null, null, null);
                    } else {
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzhv)).booleanValue()) {
                            zzauVar.zzq.zzd(uri.toString(), null, null, null);
                        }
                    }
                }
            }
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
    }
}
