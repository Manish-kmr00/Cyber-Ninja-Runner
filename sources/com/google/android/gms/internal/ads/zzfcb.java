package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfcb {
    private final zzfau zza;
    private final zzfax zzb;
    private final zzfio zzc;
    private final zzfig zzd;
    private final zzfgn zze;
    private final zzclx zzf;

    public zzfcb(zzfio zzfioVar, zzfig zzfigVar, zzfau zzfauVar, zzfax zzfaxVar, zzclx zzclxVar, zzfgn zzfgnVar) {
        this.zza = zzfauVar;
        this.zzb = zzfaxVar;
        this.zzc = zzfioVar;
        this.zzd = zzfigVar;
        this.zzf = zzclxVar;
        this.zze = zzfgnVar;
    }

    public final void zza(List list, zzcxm zzcxmVar) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzb((String) it.next(), 2, zzcxmVar);
        }
    }

    public final void zzb(String str, int i, zzcxm zzcxmVar) {
        zzfau zzfauVar = this.zza;
        if (zzfauVar.zzai) {
            this.zzd.zza(str, this.zzb.zzb, i);
            return;
        }
        this.zzc.zzd(str, zzfauVar.zzax, this.zze, zzcxmVar);
    }

    public final void zzc(List list, int i) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            zzgbs.zzr((((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzkf)).booleanValue() && zzclx.zzj(str)) ? this.zzf.zze(str, com.google.android.gms.ads.internal.client.zzbb.zze()) : zzgbs.zzh(str), new zzfca(this, i), zzbzk.zza);
        }
    }
}
