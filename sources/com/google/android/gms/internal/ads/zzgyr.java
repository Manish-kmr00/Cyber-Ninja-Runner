package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public class zzgyr {
    protected volatile zzgzg zza;
    private volatile zzgwn zzb;
    private volatile boolean zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgyr)) {
            return false;
        }
        zzgyr zzgyrVar = (zzgyr) obj;
        zzgzg zzgzgVar = this.zza;
        zzgzg zzgzgVar2 = zzgyrVar.zza;
        if (zzgzgVar == null && zzgzgVar2 == null) {
            return zzb().equals(zzgyrVar.zzb());
        }
        if (zzgzgVar != null && zzgzgVar2 != null) {
            return zzgzgVar.equals(zzgzgVar2);
        }
        if (zzgzgVar != null) {
            zzgyrVar.zzd(zzgzgVar.zzbt());
            return zzgzgVar.equals(zzgyrVar.zza);
        }
        zzd(zzgzgVar2.zzbt());
        return this.zza.equals(zzgzgVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzb != null) {
            return ((zzgwk) this.zzb).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzaY();
        }
        return 0;
    }

    public final zzgwn zzb() {
        if (this.zzb != null) {
            return this.zzb;
        }
        synchronized (this) {
            if (this.zzb != null) {
                return this.zzb;
            }
            if (this.zza == null) {
                this.zzb = zzgwn.zzb;
            } else {
                this.zzb = this.zza.zzaN();
            }
            return this.zzb;
        }
    }

    public final zzgzg zzc(zzgzg zzgzgVar) {
        zzgzg zzgzgVar2 = this.zza;
        this.zzb = null;
        this.zza = zzgzgVar;
        return zzgzgVar2;
    }

    protected final void zzd(zzgzg zzgzgVar) {
        if (this.zza != null) {
            return;
        }
        synchronized (this) {
            if (this.zza != null) {
                return;
            }
            try {
                this.zza = zzgzgVar;
                this.zzb = zzgwn.zzb;
            } catch (zzgyk unused) {
                this.zzc = true;
                this.zza = zzgzgVar;
                this.zzb = zzgwn.zzb;
            }
        }
    }
}
