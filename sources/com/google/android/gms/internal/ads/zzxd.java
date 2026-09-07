package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzxd {
    public static final zzxd zza = new zzxd(new zzbm[0]);
    public final int zzb;
    private final zzfww zzc;
    private int zzd;

    static {
        int i = zzeu.zza;
        Integer.toString(0, 36);
    }

    public zzxd(zzbm... zzbmVarArr) {
        this.zzc = zzfww.zzm(zzbmVarArr);
        this.zzb = zzbmVarArr.length;
        int i = 0;
        while (i < this.zzc.size()) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.zzc.size(); i3++) {
                if (((zzbm) this.zzc.get(i)).equals(this.zzc.get(i3))) {
                    zzdx.zzd("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i = i2;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzxd zzxdVar = (zzxd) obj;
            if (this.zzb == zzxdVar.zzb && this.zzc.equals(zzxdVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzd;
        if (i != 0) {
            return i;
        }
        int iHashCode = this.zzc.hashCode();
        this.zzd = iHashCode;
        return iHashCode;
    }

    public final String toString() {
        return this.zzc.toString();
    }

    public final int zza(zzbm zzbmVar) {
        int iIndexOf = this.zzc.indexOf(zzbmVar);
        if (iIndexOf >= 0) {
            return iIndexOf;
        }
        return -1;
    }

    public final zzbm zzb(int i) {
        return (zzbm) this.zzc.get(i);
    }

    public final zzfww zzc() {
        return zzfww.zzl(zzfxm.zzb(this.zzc, new zzftl() { // from class: com.google.android.gms.internal.ads.zzxc
            @Override // com.google.android.gms.internal.ads.zzftl
            public final Object apply(Object obj) {
                zzxd zzxdVar = zzxd.zza;
                return Integer.valueOf(((zzbm) obj).zzc);
            }
        }));
    }
}
