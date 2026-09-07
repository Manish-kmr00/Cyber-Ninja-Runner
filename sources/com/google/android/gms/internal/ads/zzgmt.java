package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgmt {
    private final Map zza = new HashMap();

    public final zzgmt zza(zzgvs zzgvsVar, Object obj) throws GeneralSecurityException {
        List list;
        if (zzgvsVar.zza() != 0 && zzgvsVar.zza() != 5) {
            throw new GeneralSecurityException("PrefixMap only supports 0 and 5 byte prefixes");
        }
        Map map = this.zza;
        if (map.containsKey(zzgvsVar)) {
            list = (List) map.get(zzgvsVar);
        } else {
            ArrayList arrayList = new ArrayList();
            map.put(zzgvsVar, arrayList);
            list = arrayList;
        }
        list.add(obj);
        return this;
    }

    public final zzgmw zzb() {
        return new zzgmw(this.zza, null);
    }
}
