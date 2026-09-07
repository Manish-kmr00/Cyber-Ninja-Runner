package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgba extends zzgbc {
    zzgba(zzfwr zzfwrVar, boolean z) {
        super(zzfwrVar, z);
        zzH();
    }

    @Override // com.google.android.gms.internal.ads.zzgbc
    public final /* bridge */ /* synthetic */ Object zzQ(List list) {
        ArrayList arrayListZza = zzfxm.zza(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzgbb zzgbbVar = (zzgbb) it.next();
            arrayListZza.add(zzgbbVar != null ? zzgbbVar.zza : null);
        }
        return Collections.unmodifiableList(arrayListZza);
    }
}
