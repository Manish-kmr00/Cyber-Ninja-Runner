package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdrh implements zzffu {
    private final zzdqy zzb;
    private final Clock zzc;
    private final Map zza = new HashMap();
    private final Map zzd = new HashMap();

    public zzdrh(zzdqy zzdqyVar, Set set, Clock clock) {
        this.zzb = zzdqyVar;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzdrg zzdrgVar = (zzdrg) it.next();
            this.zzd.put(zzdrgVar.zzc, zzdrgVar);
        }
        this.zzc = clock;
    }

    private final void zze(zzffn zzffnVar, boolean z) {
        zzdrg zzdrgVar = (zzdrg) this.zzd.get(zzffnVar);
        if (zzdrgVar == null) {
            return;
        }
        String str = true != z ? "f." : "s.";
        Map map = this.zza;
        zzffn zzffnVar2 = zzdrgVar.zzb;
        if (map.containsKey(zzffnVar2)) {
            long jElapsedRealtime = this.zzc.elapsedRealtime() - ((Long) map.get(zzffnVar2)).longValue();
            this.zzb.zzb().put("label.".concat(zzdrgVar.zza), str + jElapsedRealtime);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzffu
    public final void zzd(zzffn zzffnVar, String str) {
        Map map = this.zza;
        if (map.containsKey(zzffnVar)) {
            long jElapsedRealtime = this.zzc.elapsedRealtime() - ((Long) map.get(zzffnVar)).longValue();
            zzdqy zzdqyVar = this.zzb;
            String strValueOf = String.valueOf(str);
            zzdqyVar.zzb().put("task.".concat(strValueOf), "s.".concat(String.valueOf(Long.toString(jElapsedRealtime))));
        }
        if (this.zzd.containsKey(zzffnVar)) {
            zze(zzffnVar, true);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzffu
    public final void zzdA(zzffn zzffnVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzffu
    public final void zzdB(zzffn zzffnVar, String str, Throwable th) {
        Map map = this.zza;
        if (map.containsKey(zzffnVar)) {
            long jElapsedRealtime = this.zzc.elapsedRealtime() - ((Long) map.get(zzffnVar)).longValue();
            zzdqy zzdqyVar = this.zzb;
            String strValueOf = String.valueOf(str);
            zzdqyVar.zzb().put("task.".concat(strValueOf), "f.".concat(String.valueOf(Long.toString(jElapsedRealtime))));
        }
        if (this.zzd.containsKey(zzffnVar)) {
            zze(zzffnVar, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzffu
    public final void zzdC(zzffn zzffnVar, String str) {
        this.zza.put(zzffnVar, Long.valueOf(this.zzc.elapsedRealtime()));
    }
}
