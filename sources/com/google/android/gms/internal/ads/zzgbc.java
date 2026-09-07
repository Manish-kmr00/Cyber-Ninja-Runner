package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
abstract class zzgbc extends zzgas {
    private List zzb;

    zzgbc(zzfwr zzfwrVar, boolean z) {
        super(zzfwrVar, z, true);
        List listEmptyList = zzfwrVar.isEmpty() ? Collections.emptyList() : zzfxm.zza(zzfwrVar.size());
        for (int i = 0; i < zzfwrVar.size(); i++) {
            listEmptyList.add(null);
        }
        this.zzb = listEmptyList;
    }

    @Override // com.google.android.gms.internal.ads.zzgas
    final void zzF(int i, Object obj) {
        List list = this.zzb;
        if (list != null) {
            list.set(i, new zzgbb(obj));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgas
    final void zzG() {
        List list = this.zzb;
        if (list != null) {
            zzc(zzQ(list));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgas
    final void zzI(int i) {
        super.zzI(i);
        this.zzb = null;
    }

    abstract Object zzQ(List list);
}
