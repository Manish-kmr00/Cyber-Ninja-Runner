package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfcl {
    private static zzfcl zza;
    private final Context zzb;
    private final com.google.android.gms.ads.internal.client.zzcv zzc;
    private final AtomicReference zzd = new AtomicReference();

    zzfcl(Context context, com.google.android.gms.ads.internal.client.zzcv zzcvVar) {
        this.zzb = context;
        this.zzc = zzcvVar;
    }

    static com.google.android.gms.ads.internal.client.zzcv zza(Context context) {
        try {
            return com.google.android.gms.ads.internal.client.zzcu.asInterface((IBinder) context.getClassLoader().loadClass("com.google.android.gms.ads.internal.client.LiteSdkInfo").getConstructor(Context.class).newInstance(context));
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Failed to retrieve lite SDK info.", e);
            return null;
        }
    }

    public static zzfcl zzd(Context context) {
        synchronized (zzfcl.class) {
            zzfcl zzfclVar = zza;
            if (zzfclVar != null) {
                return zzfclVar;
            }
            Context applicationContext = context.getApplicationContext();
            long jLongValue = ((Long) zzbej.zzb.zze()).longValue();
            com.google.android.gms.ads.internal.client.zzcv zzcvVarZza = null;
            if (jLongValue > 0 && jLongValue <= 251310000) {
                zzcvVarZza = zza(applicationContext);
            }
            zzfcl zzfclVar2 = new zzfcl(applicationContext, zzcvVarZza);
            zza = zzfclVar2;
            return zzfclVar2;
        }
    }

    private final com.google.android.gms.ads.internal.client.zzex zzg() {
        com.google.android.gms.ads.internal.client.zzcv zzcvVar = this.zzc;
        if (zzcvVar != null) {
            try {
                return zzcvVar.getLiteSdkVersion();
            } catch (RemoteException unused) {
            }
        }
        return null;
    }

    public final zzboy zzb() {
        return (zzboy) this.zzd.get();
    }

    public final VersionInfoParcel zzc(int i, boolean z, int i2) {
        com.google.android.gms.ads.internal.client.zzex zzexVarZzg;
        com.google.android.gms.ads.internal.zzv.zzq();
        boolean zZzF = com.google.android.gms.ads.internal.util.zzs.zzF(this.zzb);
        VersionInfoParcel versionInfoParcel = new VersionInfoParcel(251410000, i2, true, zZzF);
        return (((Boolean) zzbej.zzc.zze()).booleanValue() && (zzexVarZzg = zzg()) != null) ? new VersionInfoParcel(251410000, zzexVarZzg.zza(), true, zZzF) : versionInfoParcel;
    }

    public final String zze() {
        com.google.android.gms.ads.internal.client.zzex zzexVarZzg = zzg();
        if (zzexVarZzg != null) {
            return zzexVarZzg.zzb();
        }
        return null;
    }

    public final void zzf(zzboy zzboyVar) {
        zzboy adapterCreator;
        if (!((Boolean) zzbej.zza.zze()).booleanValue()) {
            zzfck.zza(this.zzd, null, zzboyVar);
            return;
        }
        com.google.android.gms.ads.internal.client.zzcv zzcvVar = this.zzc;
        if (zzcvVar == null) {
            adapterCreator = null;
        } else {
            try {
                adapterCreator = zzcvVar.getAdapterCreator();
            } catch (RemoteException unused) {
                adapterCreator = null;
            }
        }
        AtomicReference atomicReference = this.zzd;
        if (adapterCreator != null) {
            zzboyVar = adapterCreator;
        }
        zzfck.zza(atomicReference, null, zzboyVar);
    }
}
