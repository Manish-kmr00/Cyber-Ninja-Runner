package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzuk {
    private final Map zza = new HashMap();
    private final Map zzb = new HashMap();
    private zzgd zzc;

    public zzuk(zzadh zzadhVar, zzajy zzajyVar) {
    }

    public final void zza(zzgd zzgdVar) {
        if (zzgdVar != this.zzc) {
            this.zzc = zzgdVar;
            this.zza.clear();
            this.zzb.clear();
        }
    }
}
