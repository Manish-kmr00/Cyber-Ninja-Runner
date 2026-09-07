package com.google.android.gms.internal.ads;

import android.os.Looper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzlq {
    private final zzlp zza;
    private final zzlo zzb;
    private final zzbl zzc;
    private int zzd;
    private Object zze;
    private final Looper zzf;
    private final int zzg;
    private boolean zzh;
    private boolean zzi;

    public zzlq(zzlo zzloVar, zzlp zzlpVar, zzbl zzblVar, int i, zzdg zzdgVar, Looper looper) {
        this.zzb = zzloVar;
        this.zza = zzlpVar;
        this.zzc = zzblVar;
        this.zzf = looper;
        this.zzg = i;
    }

    public final int zza() {
        return this.zzd;
    }

    public final Looper zzb() {
        return this.zzf;
    }

    public final zzlp zzc() {
        return this.zza;
    }

    public final zzlq zzd() {
        zzdc.zzf(!this.zzh);
        this.zzh = true;
        this.zzb.zzp(this);
        return this;
    }

    public final zzlq zze(Object obj) {
        zzdc.zzf(!this.zzh);
        this.zze = obj;
        return this;
    }

    public final zzlq zzf(int i) {
        zzdc.zzf(!this.zzh);
        this.zzd = i;
        return this;
    }

    public final Object zzg() {
        return this.zze;
    }

    public final synchronized void zzh(boolean z) {
        this.zzi = z | this.zzi;
        notifyAll();
    }

    public final synchronized boolean zzi() {
        return false;
    }
}
