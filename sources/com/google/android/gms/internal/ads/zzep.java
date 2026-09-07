package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzep implements zzdq {
    private static final List zza = new ArrayList(50);
    private final Handler zzb;

    public zzep(Handler handler) {
        this.zzb = handler;
    }

    static /* bridge */ /* synthetic */ void zzm(zzen zzenVar) {
        List list = zza;
        synchronized (list) {
            if (list.size() < 50) {
                list.add(zzenVar);
            }
        }
    }

    private static zzen zzn() {
        zzen zzenVar;
        List list = zza;
        synchronized (list) {
            zzenVar = list.isEmpty() ? new zzen(null) : (zzen) list.remove(list.size() - 1);
        }
        return zzenVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdq
    public final Looper zza() {
        return this.zzb.getLooper();
    }

    @Override // com.google.android.gms.internal.ads.zzdq
    public final zzdp zzb(int i) {
        Handler handler = this.zzb;
        zzen zzenVarZzn = zzn();
        zzenVarZzn.zzb(handler.obtainMessage(i), this);
        return zzenVarZzn;
    }

    @Override // com.google.android.gms.internal.ads.zzdq
    public final zzdp zzc(int i, Object obj) {
        Handler handler = this.zzb;
        zzen zzenVarZzn = zzn();
        zzenVarZzn.zzb(handler.obtainMessage(i, obj), this);
        return zzenVarZzn;
    }

    @Override // com.google.android.gms.internal.ads.zzdq
    public final zzdp zzd(int i, int i2, int i3) {
        Handler handler = this.zzb;
        zzen zzenVarZzn = zzn();
        zzenVarZzn.zzb(handler.obtainMessage(i, i2, i3), this);
        return zzenVarZzn;
    }

    @Override // com.google.android.gms.internal.ads.zzdq
    public final zzdp zze(int i, int i2, int i3, Object obj) {
        Handler handler = this.zzb;
        zzen zzenVarZzn = zzn();
        zzenVarZzn.zzb(handler.obtainMessage(31, 0, 0, obj), this);
        return zzenVarZzn;
    }

    @Override // com.google.android.gms.internal.ads.zzdq
    public final void zzf(Object obj) {
        this.zzb.removeCallbacksAndMessages(null);
    }

    @Override // com.google.android.gms.internal.ads.zzdq
    public final void zzg(int i) {
        this.zzb.removeMessages(i);
    }

    @Override // com.google.android.gms.internal.ads.zzdq
    public final boolean zzh(int i) {
        return this.zzb.hasMessages(1);
    }

    @Override // com.google.android.gms.internal.ads.zzdq
    public final boolean zzi(Runnable runnable) {
        return this.zzb.post(runnable);
    }

    @Override // com.google.android.gms.internal.ads.zzdq
    public final boolean zzj(int i) {
        return this.zzb.sendEmptyMessage(i);
    }

    @Override // com.google.android.gms.internal.ads.zzdq
    public final boolean zzk(int i, long j) {
        return this.zzb.sendEmptyMessageAtTime(2, j);
    }

    @Override // com.google.android.gms.internal.ads.zzdq
    public final boolean zzl(zzdp zzdpVar) {
        return ((zzen) zzdpVar).zzc(this.zzb);
    }
}
