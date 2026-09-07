package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzazs implements Comparator {
    public zzazs(zzazt zzaztVar) {
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzazh zzazhVar = (zzazh) obj;
        zzazh zzazhVar2 = (zzazh) obj2;
        if (zzazhVar.zzd() < zzazhVar2.zzd()) {
            return -1;
        }
        if (zzazhVar.zzd() <= zzazhVar2.zzd()) {
            if (zzazhVar.zzb() < zzazhVar2.zzb()) {
                return -1;
            }
            if (zzazhVar.zzb() <= zzazhVar2.zzb()) {
                float fZza = (zzazhVar.zza() - zzazhVar.zzd()) * (zzazhVar.zzc() - zzazhVar.zzb());
                float fZza2 = (zzazhVar2.zza() - zzazhVar2.zzd()) * (zzazhVar2.zzc() - zzazhVar2.zzb());
                if (fZza > fZza2) {
                    return -1;
                }
                if (fZza >= fZza2) {
                    return 0;
                }
            }
        }
        return 1;
    }
}
