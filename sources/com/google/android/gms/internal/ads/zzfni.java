package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfni {
    private final Context zza;
    private final Executor zzb;
    private final zzfmr zzc;
    private final zzfnh zzd;
    private Task zze;

    zzfni(Context context, Executor executor, zzfmr zzfmrVar, zzfmt zzfmtVar, zzfng zzfngVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzfmrVar;
        this.zzd = zzfngVar;
    }

    public static /* synthetic */ zzasu zza(zzfni zzfniVar) throws PackageManager.NameNotFoundException {
        Context context = zzfniVar.zza;
        return zzfmz.zza(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
    }

    public static zzfni zzc(Context context, Executor executor, zzfmr zzfmrVar, zzfmt zzfmtVar) {
        final zzfni zzfniVar = new zzfni(context, executor, zzfmrVar, zzfmtVar, new zzfng());
        Callable callable = new Callable() { // from class: com.google.android.gms.internal.ads.zzfne
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzfni.zza(this.zza);
            }
        };
        Executor executor2 = zzfniVar.zzb;
        zzfniVar.zze = Tasks.call(executor2, callable).addOnFailureListener(executor2, new OnFailureListener() { // from class: com.google.android.gms.internal.ads.zzfnf
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                zzfni.zzd(this.zza, exc);
            }
        });
        return zzfniVar;
    }

    public static /* synthetic */ void zzd(zzfni zzfniVar, Exception exc) {
        if (exc instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
        zzfniVar.zzc.zzc(2025, -1L, exc);
    }

    public final zzasu zzb() {
        zzfnh zzfnhVar = this.zzd;
        Task task = this.zze;
        return !task.isSuccessful() ? zzfnhVar.zza() : (zzasu) task.getResult();
    }
}
