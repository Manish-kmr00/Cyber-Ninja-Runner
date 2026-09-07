package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfdq {
    private final HashMap zza = new HashMap();

    public final zzfdp zza(zzfdg zzfdgVar, Context context, zzfcy zzfcyVar, zzfdw zzfdwVar) {
        HashMap map = this.zza;
        zzfdp zzfdpVar = (zzfdp) map.get(zzfdgVar);
        if (zzfdpVar != null) {
            return zzfdpVar;
        }
        zzfdd zzfddVar = new zzfdd(zzfdj.zza(zzfdgVar, context));
        zzfdp zzfdpVar2 = new zzfdp(zzfddVar, new zzfdy(zzfddVar, zzfcyVar, zzfdwVar));
        map.put(zzfdgVar, zzfdpVar2);
        return zzfdpVar2;
    }
}
