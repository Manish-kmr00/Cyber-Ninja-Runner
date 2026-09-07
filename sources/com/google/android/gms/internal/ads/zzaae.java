package com.google.android.gms.internal.ads;

import android.media.MediaFormat;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzaae implements zzabv {
    private final zzabb zza;
    private final zzabg zzb;
    private final Queue zzc;
    private zzz zzd;
    private long zze;
    private zzaay zzf;

    public zzaae(zzabb zzabbVar, zzdg zzdgVar) {
        this.zza = zzabbVar;
        zzabbVar.zzi(zzdgVar);
        this.zzb = new zzabg(new zzaac(this, null), zzabbVar);
        this.zzc = new ArrayDeque();
        this.zzd = new zzx().zzaj();
        this.zze = -9223372036854775807L;
        this.zzf = new zzaay() { // from class: com.google.android.gms.internal.ads.zzaab
            @Override // com.google.android.gms.internal.ads.zzaay
            public final void zza(long j, long j2, zzz zzzVar, MediaFormat mediaFormat) {
            }
        };
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final void zzc(boolean z) {
        if (z) {
            this.zza.zzg();
        }
        this.zzb.zza();
        this.zzc.clear();
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final void zzd(boolean z) {
        this.zza.zzc(z);
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final void zze(int i, zzz zzzVar, long j, int i2, List list) {
        zzdc.zzf(list.isEmpty());
        zzz zzzVar2 = this.zzd;
        int i3 = zzzVar2.zzv;
        int i4 = zzzVar.zzv;
        if (i4 != i3 || zzzVar.zzw != zzzVar2.zzw) {
            this.zzb.zzc(i4, zzzVar.zzw);
        }
        float f = zzzVar.zzx;
        if (f != this.zzd.zzx) {
            this.zza.zzj(f);
        }
        this.zzd = zzzVar;
        if (j != this.zze) {
            this.zzb.zzb(i2, j);
            this.zze = j;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final void zzf() {
        this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final void zzg() {
        this.zza.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final void zzi(int i) {
        this.zza.zzh(i);
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final void zzj(float f) {
        this.zza.zzl(f);
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final void zzk(List list) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final void zzl(zzaay zzaayVar) {
        this.zzf = zzaayVar;
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final void zzm() {
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final boolean zzn(boolean z) {
        return this.zza.zzm(false);
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final void zzh(long j, long j2) throws zzabu {
        try {
            this.zzb.zzd(j, j2);
        } catch (zzii e) {
            throw new zzabu(e, this.zzd);
        }
    }
}
