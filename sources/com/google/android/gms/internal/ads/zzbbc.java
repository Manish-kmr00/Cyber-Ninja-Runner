package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzbbc {
    private zzbar zza;
    private boolean zzb;
    private final Context zzc;
    private final Object zzd = new Object();

    zzbbc(Context context) {
        this.zzc = context;
    }

    final Future zzc(zzbas zzbasVar) {
        zzbaw zzbawVar = new zzbaw(this);
        zzbba zzbbaVar = new zzbba(this, zzbasVar, zzbawVar);
        zzbbb zzbbbVar = new zzbbb(this, zzbawVar);
        synchronized (this.zzd) {
            zzbar zzbarVar = new zzbar(this.zzc, com.google.android.gms.ads.internal.zzv.zzu().zzb(), zzbbaVar, zzbbbVar);
            this.zza = zzbarVar;
            zzbarVar.checkAvailabilityAndConnect();
        }
        return zzbawVar;
    }

    static /* bridge */ /* synthetic */ void zze(zzbbc zzbbcVar) {
        synchronized (zzbbcVar.zzd) {
            zzbar zzbarVar = zzbbcVar.zza;
            if (zzbarVar == null) {
                return;
            }
            zzbarVar.disconnect();
            zzbbcVar.zza = null;
            Binder.flushPendingCommands();
        }
    }
}
