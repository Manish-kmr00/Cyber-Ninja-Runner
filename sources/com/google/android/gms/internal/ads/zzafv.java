package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzafv implements zzadf {
    private final long zzb;
    private final zzadf zzc;

    public zzafv(long j, zzadf zzadfVar) {
        this.zzb = j;
        this.zzc = zzadfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadf
    public final void zzG() {
        this.zzc.zzG();
    }

    @Override // com.google.android.gms.internal.ads.zzadf
    public final void zzP(zzaeb zzaebVar) {
        this.zzc.zzP(new zzafu(this, zzaebVar, zzaebVar));
    }

    @Override // com.google.android.gms.internal.ads.zzadf
    public final zzaei zzw(int i, int i2) {
        return this.zzc.zzw(i, i2);
    }
}
