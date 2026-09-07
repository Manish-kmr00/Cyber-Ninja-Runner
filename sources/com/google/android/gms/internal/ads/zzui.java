package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzui implements zzwu {
    private final zzfww zza;
    private long zzb;

    public zzui(List list, List list2) {
        int i = zzfww.zzd;
        zzfwt zzfwtVar = new zzfwt();
        zzdc.zzd(list.size() == list2.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzfwtVar.zzf(new zzuh((zzwu) list.get(i2), (List) list2.get(i2)));
        }
        this.zza = zzfwtVar.zzi();
        this.zzb = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final long zzb() {
        int i = 0;
        long jMin = Long.MAX_VALUE;
        long jMin2 = Long.MAX_VALUE;
        while (true) {
            zzfww zzfwwVar = this.zza;
            if (i >= zzfwwVar.size()) {
                break;
            }
            zzuh zzuhVar = (zzuh) zzfwwVar.get(i);
            long jZzb = zzuhVar.zzb();
            if ((zzuhVar.zza().contains(1) || zzuhVar.zza().contains(2) || zzuhVar.zza().contains(4)) && jZzb != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jZzb);
            }
            if (jZzb != Long.MIN_VALUE) {
                jMin2 = Math.min(jMin2, jZzb);
            }
            i++;
        }
        if (jMin != Long.MAX_VALUE) {
            this.zzb = jMin;
            return jMin;
        }
        if (jMin2 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        long j = this.zzb;
        return j != -9223372036854775807L ? j : jMin2;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final long zzc() {
        int i = 0;
        long jMin = Long.MAX_VALUE;
        while (true) {
            zzfww zzfwwVar = this.zza;
            if (i >= zzfwwVar.size()) {
                break;
            }
            long jZzc = ((zzuh) zzfwwVar.get(i)).zzc();
            if (jZzc != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jZzc);
            }
            i++;
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zzm(long j) {
        int i = 0;
        while (true) {
            zzfww zzfwwVar = this.zza;
            if (i >= zzfwwVar.size()) {
                return;
            }
            ((zzuh) zzfwwVar.get(i)).zzm(j);
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final boolean zzo(zzku zzkuVar) {
        boolean zZzo;
        boolean z = false;
        do {
            long jZzc = zzc();
            if (jZzc == Long.MIN_VALUE) {
                break;
            }
            int i = 0;
            zZzo = false;
            while (true) {
                zzfww zzfwwVar = this.zza;
                if (i >= zzfwwVar.size()) {
                    break;
                }
                long jZzc2 = ((zzuh) zzfwwVar.get(i)).zzc();
                boolean z2 = jZzc2 != Long.MIN_VALUE && jZzc2 <= zzkuVar.zza;
                if (jZzc2 == jZzc || z2) {
                    zZzo |= ((zzuh) zzfwwVar.get(i)).zzo(zzkuVar);
                }
                i++;
            }
            z |= zZzo;
        } while (zZzo);
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final boolean zzp() {
        int i = 0;
        while (true) {
            zzfww zzfwwVar = this.zza;
            if (i >= zzfwwVar.size()) {
                return false;
            }
            if (((zzuh) zzfwwVar.get(i)).zzp()) {
                return true;
            }
            i++;
        }
    }
}
