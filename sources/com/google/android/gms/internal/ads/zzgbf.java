package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgbf extends zzgas {
    private zzgbe zzb;

    zzgbf(zzfwr zzfwrVar, boolean z, Executor executor, Callable callable) {
        super(zzfwrVar, z, false);
        this.zzb = new zzgbd(this, callable, executor);
        zzH();
    }

    @Override // com.google.android.gms.internal.ads.zzgas
    final void zzF(int i, Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzgas
    final void zzG() {
        zzgbe zzgbeVar = this.zzb;
        if (zzgbeVar != null) {
            zzgbeVar.zzf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgas
    final void zzI(int i) {
        super.zzI(i);
        if (i == 1) {
            this.zzb = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgag
    protected final void zzk() {
        zzgbe zzgbeVar = this.zzb;
        if (zzgbeVar != null) {
            zzgbeVar.zzh();
        }
    }
}
