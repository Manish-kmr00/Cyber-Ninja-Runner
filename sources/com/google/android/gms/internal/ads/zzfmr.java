package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfmr {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzf = 1;
    private final Context zzb;
    private final Executor zzc;
    private final Task zzd;
    private final boolean zze;

    public zzfmr(Context context, Executor executor, Task task, boolean z) {
        this.zzb = context;
        this.zzc = executor;
        this.zzd = task;
        this.zze = z;
    }

    public static zzfmr zza(final Context context, Executor executor, boolean z) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (z) {
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfmp
                @Override // java.lang.Runnable
                public final void run() {
                    int i = zzfmr.zza;
                    taskCompletionSource.setResult(zzfor.zzb(context, "GLAS", null));
                }
            });
        } else {
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfmq
                @Override // java.lang.Runnable
                public final void run() {
                    int i = zzfmr.zza;
                    taskCompletionSource.setResult(zzfor.zzc());
                }
            });
        }
        return new zzfmr(context, executor, taskCompletionSource.getTask(), z);
    }

    static void zzg(int i) {
        zzf = i;
    }

    private final Task zzh(final int i, long j, Exception exc, String str, Map map, String str2) {
        if (!this.zze) {
            return this.zzd.continueWith(this.zzc, new Continuation() { // from class: com.google.android.gms.internal.ads.zzfmn
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return Boolean.valueOf(task.isSuccessful());
                }
            });
        }
        Context context = this.zzb;
        final zzarf zzarfVarZza = zzarj.zza();
        zzarfVarZza.zza(context.getPackageName());
        zzarfVarZza.zze(j);
        zzarfVarZza.zzg(zzf);
        if (exc != null) {
            int i2 = zzfut.zza;
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            zzarfVarZza.zzf(stringWriter.toString());
            zzarfVarZza.zzd(exc.getClass().getName());
        }
        if (str2 != null) {
            zzarfVarZza.zzb(str2);
        }
        if (str != null) {
            zzarfVarZza.zzc(str);
        }
        return this.zzd.continueWith(this.zzc, new Continuation() { // from class: com.google.android.gms.internal.ads.zzfmo
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                int i3 = zzfmr.zza;
                if (!task.isSuccessful()) {
                    return false;
                }
                int i4 = i;
                zzfop zzfopVarZza = ((zzfor) task.getResult()).zza(((zzarj) zzarfVarZza.zzbn()).zzaV());
                zzfopVarZza.zza(i4);
                zzfopVarZza.zzc();
                return true;
            }
        });
    }

    public final Task zzb(int i, String str) {
        return zzh(i, 0L, null, null, null, str);
    }

    public final Task zzc(int i, long j, Exception exc) {
        return zzh(i, j, exc, null, null, null);
    }

    public final Task zzd(int i, long j) {
        return zzh(i, j, null, null, null, null);
    }

    public final Task zze(int i, long j, String str) {
        return zzh(i, j, null, null, null, str);
    }

    public final Task zzf(int i, long j, String str, Map map) {
        return zzh(i, j, null, str, null, null);
    }
}
