package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
final class zzcua implements zzcwq, zzcvx {
    private final zzfau zza;

    public zzcua(Context context, zzfau zzfauVar, zzbtd zzbtdVar) {
        this.zza = zzfauVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcvx
    public final void zzdh(Context context) {
    }

    @Override // com.google.android.gms.internal.ads.zzcvx
    public final void zzdj(Context context) {
    }

    @Override // com.google.android.gms.internal.ads.zzcvx
    public final void zzdk(Context context) {
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zzt() {
        zzbte zzbteVar = this.zza.zzad;
        if (zzbteVar == null || !zzbteVar.zza) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        String str = zzbteVar.zzb;
        if (str.isEmpty()) {
            return;
        }
        arrayList.add(str);
    }
}
