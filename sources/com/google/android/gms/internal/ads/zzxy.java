package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzxy extends zzyi implements Comparable {
    private final int zze;
    private final int zzf;

    public zzxy(int i, zzbm zzbmVar, int i2, zzyb zzybVar, int i3) {
        super(i, zzbmVar, i2);
        this.zze = zzlv.zza(i3, zzybVar.zzR) ? 1 : 0;
        this.zzf = this.zzd.zza();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzxy zzxyVar) {
        return Integer.compare(this.zzf, zzxyVar.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final int zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final /* bridge */ /* synthetic */ boolean zzc(zzyi zzyiVar) {
        return false;
    }
}
