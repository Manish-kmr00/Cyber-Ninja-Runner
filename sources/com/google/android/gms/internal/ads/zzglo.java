package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzglo {
    private HashMap zza = new HashMap();

    public final zzglq zza() {
        if (this.zza == null) {
            throw new IllegalStateException("cannot call build() twice");
        }
        zzglq zzglqVar = new zzglq(Collections.unmodifiableMap(this.zza), null);
        this.zza = null;
        return zzglqVar;
    }
}
