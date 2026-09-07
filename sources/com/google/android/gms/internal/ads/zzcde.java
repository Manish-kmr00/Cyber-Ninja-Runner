package com.google.android.gms.internal.ads;

import io.bidmachine.media3.exoplayer.dash.DashMediaSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzcde implements zzkr {
    private final zzze zza = new zzze(true, 65536);
    private long zzb = 15000000;
    private long zzc = 30000000;
    private long zzd = 2500000;
    private long zze = DashMediaSource.MIN_LIVE_DEFAULT_START_POSITION_US;
    private int zzf;
    private boolean zzg;

    zzcde() {
    }

    final void zza(boolean z) {
        this.zzf = 0;
        this.zzg = false;
        if (z) {
            this.zza.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkr
    public final long zzb(zzoz zzozVar) {
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzkr
    public final void zzc(zzoz zzozVar) {
        zza(false);
    }

    @Override // com.google.android.gms.internal.ads.zzkr
    public final void zzd(zzoz zzozVar) {
        zza(true);
    }

    @Override // com.google.android.gms.internal.ads.zzkr
    public final void zze(zzoz zzozVar) {
        zza(true);
    }

    @Override // com.google.android.gms.internal.ads.zzkr
    public final void zzf(zzkq zzkqVar, zzxd zzxdVar, zzyp[] zzypVarArr) {
        int i;
        this.zzf = 0;
        for (zzyp zzypVar : zzypVarArr) {
            if (zzypVar != null) {
                int i2 = this.zzf;
                int i3 = zzypVar.zzg().zzc;
                if (i3 == 0) {
                    i = 144310272;
                } else if (i3 == 1) {
                    i = 13107200;
                } else if (i3 != 2) {
                    i = 131072;
                    if (i3 != 3 && i3 != 5 && i3 != 6) {
                        throw new IllegalArgumentException();
                    }
                } else {
                    i = 131072000;
                }
                this.zzf = i2 + i;
            }
        }
        this.zza.zzf(this.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzkr
    public final boolean zzg(zzoz zzozVar) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzkr
    public final boolean zzh(zzkq zzkqVar) {
        char c;
        long j = zzkqVar.zzb;
        boolean z = true;
        if (j > this.zzc) {
            c = 0;
        } else {
            c = j < this.zzb ? (char) 2 : (char) 1;
        }
        int iZza = this.zza.zza();
        int i = this.zzf;
        if (c != 2 && (c != 1 || !this.zzg || iZza >= i)) {
            z = false;
        }
        this.zzg = z;
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzkr
    public final /* synthetic */ boolean zzi(zzbl zzblVar, zzuy zzuyVar, long j) {
        zzdx.zzf("LoadControl", "shouldContinuePreloading needs to be implemented when playlist preloading is enabled");
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzkr
    public final boolean zzj(zzkq zzkqVar) {
        long j = zzkqVar.zzd ? this.zze : this.zzd;
        return j <= 0 || zzkqVar.zzb >= j;
    }

    @Override // com.google.android.gms.internal.ads.zzkr
    public final zzze zzk() {
        return this.zza;
    }

    public final synchronized void zzl(int i) {
        this.zzd = ((long) i) * 1000;
    }

    public final synchronized void zzm(int i) {
        this.zze = ((long) i) * 1000;
    }

    public final synchronized void zzn(int i) {
        this.zzc = ((long) i) * 1000;
    }

    public final synchronized void zzo(int i) {
        this.zzb = ((long) i) * 1000;
    }
}
