package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzanf {
    private final zzamg zza;
    private final zzer zzb;
    private final zzej zzc = new zzej(new byte[64], 64);
    private boolean zzd;
    private boolean zze;
    private boolean zzf;

    public zzanf(zzamg zzamgVar, zzer zzerVar) {
        this.zza = zzamgVar;
        this.zzb = zzerVar;
    }

    public final void zza(zzek zzekVar) throws zzaz {
        long jZzb;
        zzej zzejVar = this.zzc;
        zzekVar.zzH(zzejVar.zza, 0, 3);
        zzejVar.zzl(0);
        zzejVar.zzn(8);
        this.zzd = zzejVar.zzp();
        this.zze = zzejVar.zzp();
        zzejVar.zzn(6);
        zzekVar.zzH(zzejVar.zza, 0, zzejVar.zzd(8));
        zzejVar.zzl(0);
        if (this.zzd) {
            zzejVar.zzn(4);
            long jZzd = zzejVar.zzd(3);
            zzejVar.zzn(1);
            int iZzd = zzejVar.zzd(15) << 15;
            zzejVar.zzn(1);
            long jZzd2 = zzejVar.zzd(15);
            zzejVar.zzn(1);
            if (!this.zzf && this.zze) {
                zzejVar.zzn(4);
                long jZzd3 = ((long) zzejVar.zzd(3)) << 30;
                zzejVar.zzn(1);
                int iZzd2 = zzejVar.zzd(15) << 15;
                zzejVar.zzn(1);
                long jZzd4 = zzejVar.zzd(15);
                zzejVar.zzn(1);
                this.zzb.zzb(jZzd3 | ((long) iZzd2) | jZzd4);
                this.zzf = true;
            }
            jZzb = this.zzb.zzb((jZzd << 30) | ((long) iZzd) | jZzd2);
        } else {
            jZzb = 0;
        }
        zzamg zzamgVar = this.zza;
        zzamgVar.zzd(jZzb, 4);
        zzamgVar.zza(zzekVar);
        zzamgVar.zzc(false);
    }

    public final void zzb() {
        this.zzf = false;
        this.zza.zze();
    }
}
