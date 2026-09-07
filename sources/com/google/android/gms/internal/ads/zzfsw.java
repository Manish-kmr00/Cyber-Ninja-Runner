package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzfsw {
    private final zzfuo zza;
    private final Context zzb;
    private final zzfsx zzc;
    private boolean zzf;
    private final Intent zzg;
    private ServiceConnection zzi;
    private IInterface zzj;
    private final List zze = new ArrayList();
    private final String zzd = "OverlayDisplayService";
    private final IBinder.DeathRecipient zzh = new IBinder.DeathRecipient() { // from class: com.google.android.gms.internal.ads.zzfso
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            zzfsw.zzh(this.zza);
        }
    };

    zzfsw(Context context, zzfsx zzfsxVar, String str, Intent intent, zzfsb zzfsbVar) {
        this.zzb = context;
        this.zzc = zzfsxVar;
        final String str2 = "OverlayDisplayService";
        this.zzg = intent;
        this.zza = zzfus.zza(new zzfuo(str2) { // from class: com.google.android.gms.internal.ads.zzfsn
            public final /* synthetic */ String zza = "OverlayDisplayService";

            @Override // com.google.android.gms.internal.ads.zzfuo
            public final Object zza() {
                HandlerThread handlerThread = new HandlerThread(this.zza, 10);
                handlerThread.start();
                return new Handler(handlerThread.getLooper());
            }
        });
    }

    public static /* synthetic */ void zzf(zzfsw zzfswVar, Runnable runnable) {
        try {
            runnable.run();
        } catch (RuntimeException e) {
            zzfswVar.zzc.zza("error caused by ", e);
        }
    }

    public static /* synthetic */ void zzh(zzfsw zzfswVar) {
        zzfswVar.zzc.zzc("%s : Binder has died.", zzfswVar.zzd);
        List list = zzfswVar.zze;
        synchronized (list) {
            list.clear();
        }
    }

    public static /* synthetic */ void zzi(zzfsw zzfswVar) {
        if (zzfswVar.zzj != null) {
            zzfswVar.zzc.zzc("Unbind from service.", new Object[0]);
            Context context = zzfswVar.zzb;
            ServiceConnection serviceConnection = zzfswVar.zzi;
            serviceConnection.getClass();
            context.unbindService(serviceConnection);
            zzfswVar.zzf = false;
            zzfswVar.zzj = null;
            zzfswVar.zzi = null;
            List list = zzfswVar.zze;
            synchronized (list) {
                list.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzo(final Runnable runnable) {
        ((Handler) this.zza.zza()).post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfsp
            @Override // java.lang.Runnable
            public final void run() {
                zzfsw.zzf(this.zza, runnable);
            }
        });
    }

    public final IInterface zzc() {
        return this.zzj;
    }

    public final void zzm(final Runnable runnable) {
        zzo(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfsq
            @Override // java.lang.Runnable
            public final void run() {
                zzfsw.zzg(this.zza, runnable);
            }
        });
    }

    public final void zzn() {
        zzo(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfsr
            @Override // java.lang.Runnable
            public final void run() {
                zzfsw.zzi(this.zza);
            }
        });
    }

    public static /* synthetic */ void zzg(zzfsw zzfswVar, Runnable runnable) {
        if (zzfswVar.zzj != null || zzfswVar.zzf) {
            if (!zzfswVar.zzf) {
                runnable.run();
                return;
            }
            zzfswVar.zzc.zzc("Waiting to bind to the service.", new Object[0]);
            List list = zzfswVar.zze;
            synchronized (list) {
                list.add(runnable);
            }
            return;
        }
        zzfswVar.zzc.zzc("Initiate binding to the service.", new Object[0]);
        List list2 = zzfswVar.zze;
        synchronized (list2) {
            list2.add(runnable);
        }
        zzfsu zzfsuVar = new zzfsu(zzfswVar, null);
        zzfswVar.zzi = zzfsuVar;
        zzfswVar.zzf = true;
        if (zzfswVar.zzb.bindService(zzfswVar.zzg, zzfsuVar, 1)) {
            return;
        }
        zzfswVar.zzc.zzc("Failed to bind to the service.", new Object[0]);
        zzfswVar.zzf = false;
        List list3 = zzfswVar.zze;
        synchronized (list3) {
            list3.clear();
        }
    }
}
