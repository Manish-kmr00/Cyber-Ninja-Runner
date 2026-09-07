package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzon {
    final /* synthetic */ zzoo zza;
    private final String zzb;
    private int zzc;
    private long zzd;
    private zzuy zze;
    private boolean zzf;
    private boolean zzg;

    public zzon(zzoo zzooVar, String str, int i, zzuy zzuyVar) {
        this.zza = zzooVar;
        this.zzb = str;
        this.zzc = i;
        this.zzd = zzuyVar == null ? -1L : zzuyVar.zzd;
        if (zzuyVar == null || !zzuyVar.zzb()) {
            return;
        }
        this.zze = zzuyVar;
    }

    public final void zzg(int i, zzuy zzuyVar) {
        if (this.zzd == -1 && i == this.zzc && zzuyVar != null) {
            zzoo zzooVar = this.zza;
            long j = zzuyVar.zzd;
            if (j >= zzooVar.zzl()) {
                this.zzd = j;
            }
        }
    }

    public final boolean zzj(int i, zzuy zzuyVar) {
        if (zzuyVar == null) {
            return i == this.zzc;
        }
        zzuy zzuyVar2 = this.zze;
        if (zzuyVar2 == null) {
            return !zzuyVar.zzb() && zzuyVar.zzd == this.zzd;
        }
        return zzuyVar.zzd == zzuyVar2.zzd && zzuyVar.zzb == zzuyVar2.zzb && zzuyVar.zzc == zzuyVar2.zzc;
    }

    public final boolean zzk(zzmh zzmhVar) {
        zzuy zzuyVar = zzmhVar.zzd;
        if (zzuyVar == null) {
            return this.zzc != zzmhVar.zzc;
        }
        long j = this.zzd;
        if (j == -1) {
            return false;
        }
        long j2 = zzuyVar.zzd;
        if (j2 > j) {
            return true;
        }
        if (this.zze == null) {
            return false;
        }
        zzbl zzblVar = zzmhVar.zzb;
        int iZza = zzblVar.zza(zzuyVar.zza);
        int iZza2 = zzblVar.zza(this.zze.zza);
        zzuy zzuyVar2 = this.zze;
        if (j2 < zzuyVar2.zzd || iZza < iZza2) {
            return false;
        }
        if (iZza > iZza2) {
            return true;
        }
        if (!zzuyVar.zzb()) {
            int i = zzuyVar.zze;
            return i == -1 || i > zzuyVar2.zzb;
        }
        int i2 = zzuyVar.zzb;
        int i3 = zzuyVar.zzc;
        int i4 = zzuyVar2.zzb;
        if (i2 <= i4) {
            return i2 == i4 && i3 > zzuyVar2.zzc;
        }
        return true;
    }

    public final boolean zzl(zzbl zzblVar, zzbl zzblVar2) {
        int i = this.zzc;
        if (i < zzblVar.zzc()) {
            zzoo zzooVar = this.zza;
            zzblVar.zze(i, zzooVar.zzc, 0L);
            int i2 = zzooVar.zzc.zzn;
            while (true) {
                if (i2 > zzooVar.zzc.zzo) {
                    i = -1;
                    break;
                }
                int iZza = zzblVar2.zza(zzblVar.zzf(i2));
                if (iZza != -1) {
                    i = zzblVar2.zzd(iZza, zzooVar.zzd, false).zzc;
                    break;
                }
                i2++;
            }
        } else if (i >= zzblVar2.zzc()) {
            i = -1;
            break;
        }
        this.zzc = i;
        if (i == -1) {
            return false;
        }
        zzuy zzuyVar = this.zze;
        return zzuyVar == null || zzblVar2.zza(zzuyVar.zza) != -1;
    }
}
