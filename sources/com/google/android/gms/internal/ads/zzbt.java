package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbt {
    public static final zzbt zza = new zzbt(zzfww.zzn());
    private final zzfww zzb;

    static {
        int i = zzeu.zza;
        Integer.toString(0, 36);
    }

    public zzbt(List list) {
        this.zzb = zzfww.zzl(list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.zzb.equals(((zzbt) obj).zzb);
    }

    public final int hashCode() {
        return this.zzb.hashCode();
    }

    public final zzfww zza() {
        return this.zzb;
    }

    public final boolean zzb(int i) {
        int i2 = 0;
        while (true) {
            zzfww zzfwwVar = this.zzb;
            if (i2 >= zzfwwVar.size()) {
                return false;
            }
            zzbs zzbsVar = (zzbs) zzfwwVar.get(i2);
            if (zzbsVar.zzc() && zzbsVar.zza() == i) {
                return true;
            }
            i2++;
        }
    }
}
