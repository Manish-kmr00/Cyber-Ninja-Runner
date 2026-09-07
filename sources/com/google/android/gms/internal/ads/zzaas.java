package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzaas implements zzabv {
    final /* synthetic */ zzaax zza;
    private zzfww zzb;
    private zzz zzc;
    private long zzd;

    public zzaas(zzaax zzaaxVar, Context context, int i) {
        this.zza = zzaaxVar;
        zzeu.zzL(context);
        this.zzb = zzfww.zzn();
        this.zzd = -9223372036854775807L;
    }

    private final void zza(List list) {
        zzfwt zzfwtVar = new zzfwt();
        zzfwtVar.zzh(list);
        zzfwtVar.zzh(this.zza.zze);
        this.zzb = zzfwtVar.zzi();
    }

    private static final void zzb(zzz zzzVar) {
        zzx zzxVarZzb = zzzVar.zzb();
        zzxVarZzb.zzD(zzaax.zzu(zzzVar.zzC));
        zzxVarZzb.zzaj();
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final void zzc(boolean z) {
        this.zzd = -9223372036854775807L;
        zzaax.zzj(this.zza, z);
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final void zzd(boolean z) {
        this.zza.zzg.zzd(z);
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final void zze(int i, zzz zzzVar, long j, int i2, List list) {
        zzdc.zzf(false);
        zza(list);
        this.zzc = zzzVar;
        zzaax zzaaxVar = this.zza;
        zzaaxVar.zzq = -9223372036854775807L;
        zzb(zzzVar);
        zzeq zzeqVar = zzaaxVar.zzb;
        long j2 = this.zzd;
        zzeqVar.zzd(j2 == -9223372036854775807L ? 0L : 1 + j2, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final void zzf() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final void zzg() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final void zzh(long j, long j2) throws zzabu {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final void zzi(int i) {
        this.zza.zzg.zzi(i);
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final void zzj(float f) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final void zzk(List list) {
        if (this.zzb.equals(list)) {
            return;
        }
        zza(list);
        zzz zzzVar = this.zzc;
        if (zzzVar != null) {
            zzb(zzzVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final void zzl(zzaay zzaayVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final void zzm() {
        this.zza.zzq = this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final boolean zzn(boolean z) {
        throw null;
    }
}
