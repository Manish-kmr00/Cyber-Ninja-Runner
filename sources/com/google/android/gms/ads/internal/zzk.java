package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.ads.zzarb;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzaum;
import com.google.android.gms.internal.ads.zzauq;
import com.google.android.gms.internal.ads.zzaut;
import com.google.android.gms.internal.ads.zzauv;
import com.google.android.gms.internal.ads.zzaux;
import com.google.android.gms.internal.ads.zzbci;
import com.google.android.gms.internal.ads.zzbzk;
import com.google.android.gms.internal.ads.zzfmr;
import com.google.android.gms.internal.ads.zzfnr;
import com.google.android.gms.internal.ads.zzfol;
import com.google.android.gms.internal.ads.zzgbs;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzk implements Runnable, zzaut {
    private static final long zzc = System.currentTimeMillis();
    protected boolean zza;
    private final boolean zzg;
    private final boolean zzh;
    private final Executor zzi;
    private final zzfmr zzj;
    private Context zzk;
    private final Context zzl;
    private VersionInfoParcel zzm;
    private final VersionInfoParcel zzn;
    private final boolean zzo;
    private int zzp;
    private final List zzd = new Vector();
    private final AtomicReference zze = new AtomicReference();
    private final AtomicReference zzf = new AtomicReference();
    final CountDownLatch zzb = new CountDownLatch(1);

    public zzk(Context context, VersionInfoParcel versionInfoParcel) {
        this.zzk = context;
        this.zzl = context;
        this.zzm = versionInfoParcel;
        this.zzn = versionInfoParcel;
        ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool();
        this.zzi = executorServiceNewCachedThreadPool;
        boolean zBooleanValue = ((Boolean) zzbd.zzc().zzb(zzbci.zzcE)).booleanValue();
        this.zzo = zBooleanValue;
        this.zzj = zzfmr.zza(context, executorServiceNewCachedThreadPool, zBooleanValue);
        this.zzg = ((Boolean) zzbd.zzc().zzb(zzbci.zzcB)).booleanValue();
        this.zzh = ((Boolean) zzbd.zzc().zzb(zzbci.zzcF)).booleanValue();
        if (((Boolean) zzbd.zzc().zzb(zzbci.zzcD)).booleanValue()) {
            this.zzp = 2;
        } else {
            this.zzp = 1;
        }
        if (!((Boolean) zzbd.zzc().zzb(zzbci.zzdH)).booleanValue()) {
            this.zza = zzi();
        }
        if (((Boolean) zzbd.zzc().zzb(zzbci.zzdB)).booleanValue()) {
            zzbzk.zza.execute(this);
            return;
        }
        zzbb.zzb();
        if (com.google.android.gms.ads.internal.util.client.zzf.zzv()) {
            zzbzk.zza.execute(this);
        } else {
            run();
        }
    }

    public static /* synthetic */ void zzc(zzk zzkVar, boolean z) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            zzu(zzkVar.zzl, zzkVar.zzn, z, zzkVar.zzo).zzp();
        } catch (NullPointerException e) {
            zzkVar.zzj.zzc(2027, System.currentTimeMillis() - jCurrentTimeMillis, e);
        }
    }

    private final zzaut zzq() {
        return zzm() == 2 ? (zzaut) this.zzf.get() : (zzaut) this.zze.get();
    }

    private final void zzr() {
        List<Object[]> list = this.zzd;
        zzaut zzautVarZzq = zzq();
        if (list.isEmpty() || zzautVarZzq == null) {
            return;
        }
        for (Object[] objArr : list) {
            int length = objArr.length;
            if (length == 1) {
                zzautVarZzq.zzk((MotionEvent) objArr[0]);
            } else if (length == 3) {
                zzautVarZzq.zzl(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
            }
        }
        list.clear();
    }

    private final void zzs(boolean z) {
        String str = this.zzm.afmaVersion;
        Context contextZzt = zzt(this.zzk);
        zzarb zzarbVarZza = zzard.zza();
        zzarbVarZza.zza(z);
        zzarbVarZza.zzb(str);
        zzard zzardVar = (zzard) zzarbVarZza.zzbr();
        int i = zzaux.zzw;
        this.zze.set(zzaux.zzt(contextZzt, new zzauv(zzardVar)));
    }

    private static final Context zzt(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    private static final zzauq zzu(Context context, VersionInfoParcel versionInfoParcel, boolean z, boolean z2) {
        zzarb zzarbVarZza = zzard.zza();
        zzarbVarZza.zza(z);
        zzarbVarZza.zzb(versionInfoParcel.afmaVersion);
        return zzauq.zza(zzt(context), (zzard) zzarbVarZza.zzbr(), z2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (((Boolean) zzbd.zzc().zzb(zzbci.zzdH)).booleanValue()) {
                this.zza = zzi();
            }
            boolean z = this.zzm.isClientJar;
            final boolean z2 = false;
            if (!((Boolean) zzbd.zzc().zzb(zzbci.zzbj)).booleanValue() && z) {
                z2 = true;
            }
            if (zzm() == 1) {
                zzs(z2);
                if (this.zzp == 2) {
                    this.zzi.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.zzi
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzk.zzc(this.zza, z2);
                        }
                    });
                }
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                try {
                    zzauq zzauqVarZzu = zzu(this.zzk, this.zzm, z2, this.zzo);
                    this.zzf.set(zzauqVarZzu);
                    if (this.zzh && !zzauqVarZzu.zzr()) {
                        this.zzp = 1;
                        zzs(z2);
                    }
                } catch (NullPointerException e) {
                    this.zzp = 1;
                    zzs(z2);
                    this.zzj.zzc(2031, System.currentTimeMillis() - jCurrentTimeMillis, e);
                }
            }
            this.zzb.countDown();
            this.zzk = null;
            this.zzm = null;
        } catch (Throwable th) {
            this.zzb.countDown();
            this.zzk = null;
            this.zzm = null;
            throw th;
        }
    }

    public final String zzb(Context context, byte[] bArr) {
        zzaut zzautVarZzq;
        if (!zzj() || (zzautVarZzq = zzq()) == null) {
            return "";
        }
        zzr();
        return zzautVarZzq.zzf(zzt(context));
    }

    @Override // com.google.android.gms.internal.ads.zzaut
    public final String zzd(Context context, String str, View view) {
        return zze(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzaut
    public final String zze(Context context, String str, View view, Activity activity) {
        if (!zzj()) {
            return "";
        }
        zzaut zzautVarZzq = zzq();
        if (((Boolean) zzbd.zzc().zzb(zzbci.zzkL)).booleanValue()) {
            zzv.zzq();
            com.google.android.gms.ads.internal.util.zzs.zzK(view, 4, null);
        }
        if (zzautVarZzq == null) {
            return "";
        }
        zzr();
        return zzautVarZzq.zze(zzt(context), str, view, activity);
    }

    @Override // com.google.android.gms.internal.ads.zzaut
    public final String zzf(Context context) {
        return zzb(context, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzaut
    public final String zzg(final Context context) {
        try {
            return (String) zzgbs.zzj(new Callable() { // from class: com.google.android.gms.ads.internal.zzh
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.zzb(context, null);
                }
            }, this.zzi).get(((Integer) zzbd.zzc().zzb(zzbci.zzcV)).intValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException unused) {
            return Integer.toString(17);
        } catch (TimeoutException unused2) {
            return zzaum.zza(context, this.zzn.afmaVersion, zzc, true);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaut
    public final String zzh(Context context, View view, Activity activity) {
        if (!((Boolean) zzbd.zzc().zzb(zzbci.zzkK)).booleanValue()) {
            zzaut zzautVarZzq = zzq();
            if (((Boolean) zzbd.zzc().zzb(zzbci.zzkL)).booleanValue()) {
                zzv.zzq();
                com.google.android.gms.ads.internal.util.zzs.zzK(view, 2, null);
            }
            return zzautVarZzq != null ? zzautVarZzq.zzh(context, view, activity) : "";
        }
        if (!zzj()) {
            return "";
        }
        zzaut zzautVarZzq2 = zzq();
        if (((Boolean) zzbd.zzc().zzb(zzbci.zzkL)).booleanValue()) {
            zzv.zzq();
            com.google.android.gms.ads.internal.util.zzs.zzK(view, 2, null);
        }
        return zzautVarZzq2 != null ? zzautVarZzq2.zzh(context, view, activity) : "";
    }

    protected final boolean zzi() {
        Context context = this.zzk;
        zzj zzjVar = new zzj(this);
        zzfmr zzfmrVar = this.zzj;
        return new zzfol(this.zzk, zzfnr.zzb(context, zzfmrVar), zzjVar, ((Boolean) zzbd.zzc().zzb(zzbci.zzcC)).booleanValue()).zzd(1);
    }

    public final boolean zzj() {
        try {
            this.zzb.await();
            return true;
        } catch (InterruptedException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Interrupted during GADSignals creation.", e);
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaut
    public final void zzk(MotionEvent motionEvent) {
        zzaut zzautVarZzq = zzq();
        if (zzautVarZzq == null) {
            this.zzd.add(new Object[]{motionEvent});
        } else {
            zzr();
            zzautVarZzq.zzk(motionEvent);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaut
    public final void zzl(int i, int i2, int i3) {
        zzaut zzautVarZzq = zzq();
        if (zzautVarZzq == null) {
            this.zzd.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        } else {
            zzr();
            zzautVarZzq.zzl(i, i2, i3);
        }
    }

    protected final int zzm() {
        if (!this.zzg || this.zza) {
            return this.zzp;
        }
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzaut
    public final void zzn(StackTraceElement[] stackTraceElementArr) {
        zzaut zzautVarZzq;
        zzaut zzautVarZzq2;
        if (((Boolean) zzbd.zzc().zzb(zzbci.zzdb)).booleanValue()) {
            if (this.zzb.getCount() != 0 || (zzautVarZzq2 = zzq()) == null) {
                return;
            }
            zzautVarZzq2.zzn(stackTraceElementArr);
            return;
        }
        if (!zzj() || (zzautVarZzq = zzq()) == null) {
            return;
        }
        zzautVarZzq.zzn(stackTraceElementArr);
    }

    @Override // com.google.android.gms.internal.ads.zzaut
    public final void zzo(View view) {
        zzaut zzautVarZzq = zzq();
        if (zzautVarZzq != null) {
            zzautVarZzq.zzo(view);
        }
    }

    public final int zzp() {
        return this.zzp;
    }
}
