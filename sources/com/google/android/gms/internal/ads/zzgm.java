package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzgm implements zzgd {
    private zzhe zzb;
    private String zzc;
    private boolean zzf;
    private final zzgy zza = new zzgy();
    private int zzd = 8000;
    private int zze = 8000;

    public final zzgm zzb(boolean z) {
        this.zzf = true;
        return this;
    }

    public final zzgm zzc(int i) {
        this.zzd = i;
        return this;
    }

    public final zzgm zzd(int i) {
        this.zze = i;
        return this;
    }

    public final zzgm zze(zzhe zzheVar) {
        this.zzb = zzheVar;
        return this;
    }

    public final zzgm zzf(String str) {
        this.zzc = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgd
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final zzgr zza() {
        zzgr zzgrVar = new zzgr(this.zzc, this.zzd, this.zze, this.zzf, false, this.zza, null, false, null);
        zzhe zzheVar = this.zzb;
        if (zzheVar != null) {
            zzgrVar.zzf(zzheVar);
        }
        return zzgrVar;
    }
}
