package com.google.android.gms.internal.ads;

import com.json.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class zzagb implements zzau {
    public final String zza;
    public final String zzb;

    public zzagb(String str, String str2) {
        this.zza = zzftc.zzb(str);
        this.zzb = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzagb zzagbVar = (zzagb) obj;
            if (this.zza.equals(zzagbVar.zza) && this.zzb.equals(zzagbVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zza.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + this.zzb.hashCode();
    }

    public final String toString() {
        return "VC: " + this.zza + "=" + this.zzb;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:35:0x0071  */
    @Override // com.google.android.gms.internal.ads.zzau
    public final void zza(zzar zzarVar) {
        switch (this.zza) {
            case "TITLE":
                zzarVar.zzr(this.zzb);
                break;
            case "ARTIST":
                zzarVar.zze(this.zzb);
                break;
            case "ALBUM":
                zzarVar.zzd(this.zzb);
                break;
            case "ALBUMARTIST":
                zzarVar.zzc(this.zzb);
                break;
            case "TRACKNUMBER":
                Integer numZzg = zzfzz.zzg(this.zzb, 10);
                if (numZzg != null) {
                    zzarVar.zzu(numZzg);
                    break;
                }
                break;
            case "TOTALTRACKS":
                Integer numZzg2 = zzfzz.zzg(this.zzb, 10);
                if (numZzg2 != null) {
                    zzarVar.zzt(numZzg2);
                    break;
                }
                break;
            case "DISCNUMBER":
                Integer numZzg3 = zzfzz.zzg(this.zzb, 10);
                if (numZzg3 != null) {
                    zzarVar.zzi(numZzg3);
                    break;
                }
                break;
            case "TOTALDISCS":
                Integer numZzg4 = zzfzz.zzg(this.zzb, 10);
                if (numZzg4 != null) {
                    zzarVar.zzs(numZzg4);
                    break;
                }
                break;
            case "GENRE":
                zzarVar.zzj(this.zzb);
                break;
            case "DESCRIPTION":
                zzarVar.zzh(this.zzb);
                break;
        }
    }
}
