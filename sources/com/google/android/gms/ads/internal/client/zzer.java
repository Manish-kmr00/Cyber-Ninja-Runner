package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.internal.ads.zzbln;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzer extends zzbln {
    final /* synthetic */ zzet zza;

    /* synthetic */ zzer(zzet zzetVar, zzes zzesVar) {
        this.zza = zzetVar;
    }

    @Override // com.google.android.gms.internal.ads.zzblo
    public final void zzb(List list) throws RemoteException {
        int i;
        ArrayList arrayList;
        zzet zzetVar = this.zza;
        synchronized (zzetVar.zzc) {
            zzetVar.zzf = false;
            zzetVar.zzg = true;
            arrayList = new ArrayList(zzetVar.zze);
            zzetVar.zze.clear();
        }
        InitializationStatus initializationStatusZzA = zzet.zzA(list);
        int size = arrayList.size();
        for (i = 0; i < size; i++) {
            ((OnInitializationCompleteListener) arrayList.get(i)).onInitializationComplete(initializationStatusZzA);
        }
    }
}
