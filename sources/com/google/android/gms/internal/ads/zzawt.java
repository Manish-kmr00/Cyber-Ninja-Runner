package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzawt implements Callable {
    private final zzawb zza;
    private final zzarz zzb;

    public zzawt(zzawb zzawbVar, zzarz zzarzVar) {
        this.zza = zzawbVar;
        this.zzb = zzarzVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzawb zzawbVar = this.zza;
        if (zzawbVar.zzk() != null) {
            zzawbVar.zzk().get();
        }
        zzasu zzasuVarZzc = zzawbVar.zzc();
        if (zzasuVarZzc == null) {
            return null;
        }
        try {
            zzarz zzarzVar = this.zzb;
            synchronized (zzarzVar) {
                try {
                    zzarzVar.zzaY(zzasuVarZzc.zzaV(), zzgxf.zza());
                } catch (Throwable th) {
                    throw th;
                }
            }
            return null;
        } catch (zzgyk | NullPointerException unused) {
            return null;
        }
    }
}
