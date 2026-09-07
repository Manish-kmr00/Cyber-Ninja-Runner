package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzaxo implements Callable {
    protected final zzawb zza;
    protected final String zzb;
    protected final String zzc;
    protected final zzarz zzd;
    protected Method zze;
    protected final int zzf;
    protected final int zzg;

    public zzaxo(zzawb zzawbVar, String str, String str2, zzarz zzarzVar, int i, int i2) {
        getClass().getSimpleName();
        this.zza = zzawbVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzarzVar;
        this.zzf = i;
        this.zzg = i2;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        int i;
        try {
            long jNanoTime = System.nanoTime();
            zzawb zzawbVar = this.zza;
            Method methodZzi = zzawbVar.zzi(this.zzb, this.zzc);
            this.zze = methodZzi;
            if (methodZzi == null) {
                return null;
            }
            zza();
            zzaus zzausVarZzd = zzawbVar.zzd();
            if (zzausVarZzd == null || (i = this.zzf) == Integer.MIN_VALUE) {
                return null;
            }
            zzausVarZzd.zzc(this.zzg, i, (System.nanoTime() - jNanoTime) / 1000, null, null);
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    protected abstract void zza() throws IllegalAccessException, InvocationTargetException;
}
