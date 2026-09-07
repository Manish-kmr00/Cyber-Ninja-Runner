package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzfsu implements ServiceConnection {
    final /* synthetic */ zzfsw zza;

    /* synthetic */ zzfsu(zzfsw zzfswVar, zzfsv zzfsvVar) {
        this.zza = zzfswVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        zzfsw zzfswVar = this.zza;
        zzfswVar.zzc.zzc("LmdServiceConnectionManager.onServiceConnected(%s)", componentName);
        zzfswVar.zzo(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfss
            @Override // java.lang.Runnable
            public final void run() {
                zzfqw zzfqwVarZzb = zzfqv.zzb(iBinder);
                zzfsu zzfsuVar = this.zza;
                zzfsw zzfswVar2 = zzfsuVar.zza;
                zzfswVar2.zzj = zzfqwVarZzb;
                zzfswVar2.zzc.zzc("linkToDeath", new Object[0]);
                try {
                    IInterface iInterface = zzfswVar2.zzj;
                    if (iInterface == null) {
                        throw null;
                    }
                    iInterface.asBinder().linkToDeath(zzfswVar2.zzh, 0);
                    zzfsw zzfswVar3 = zzfsuVar.zza;
                    zzfswVar3.zzf = false;
                    synchronized (zzfswVar3.zze) {
                        Iterator it = zzfswVar3.zze.iterator();
                        while (it.hasNext()) {
                            ((Runnable) it.next()).run();
                        }
                        zzfswVar3.zze.clear();
                    }
                } catch (RemoteException e) {
                    zzfsuVar.zza.zzc.zzb(e, "linkToDeath failed", new Object[0]);
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzfsw zzfswVar = this.zza;
        zzfswVar.zzc.zzc("LmdServiceConnectionManager.onServiceDisconnected(%s)", componentName);
        zzfswVar.zzo(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfst
            @Override // java.lang.Runnable
            public final void run() {
                zzfsw zzfswVar2 = this.zza.zza;
                zzfswVar2.zzc.zzc("unlinkToDeath", new Object[0]);
                IInterface iInterface = zzfswVar2.zzj;
                iInterface.getClass();
                iInterface.asBinder().unlinkToDeath(zzfswVar2.zzh, 0);
                zzfswVar2.zzj = null;
                zzfswVar2.zzf = false;
            }
        });
    }
}
