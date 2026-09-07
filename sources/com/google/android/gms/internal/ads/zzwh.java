package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzwh implements zzvl {
    public static final /* synthetic */ int zza = 0;
    private final zzgd zzc;
    private int zzd;
    private final zzwg zze;
    private final zzzi zzf;

    public zzwh(zzgd zzgdVar, zzwg zzwgVar) {
        zzzi zzziVar = new zzzi(-1);
        this.zzc = zzgdVar;
        this.zze = zzwgVar;
        this.zzf = zzziVar;
        this.zzd = 1048576;
    }

    public final zzwh zza(int i) {
        this.zzd = i;
        return this;
    }

    public final zzwj zzb(zzap zzapVar) {
        zzapVar.zzb.getClass();
        return new zzwj(zzapVar, this.zzc, this.zze, zzry.zza, this.zzf, this.zzd, 0, null, null, null);
    }
}
