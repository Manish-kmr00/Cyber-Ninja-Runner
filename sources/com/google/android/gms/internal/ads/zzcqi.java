package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcqi implements zzcqj {
    private final Map zza;

    zzcqi(Map map) {
        this.zza = map;
    }

    @Override // com.google.android.gms.internal.ads.zzcqj
    public final zzecf zza(int i, String str) {
        return (zzecf) this.zza.get(str);
    }
}
