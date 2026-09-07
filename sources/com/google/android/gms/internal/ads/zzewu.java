package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzewu extends zzewc {
    public zzewu(Context context, Executor executor, zzcgl zzcglVar, zzeyl zzeylVar, zzews zzewsVar, zzfbn zzfbnVar, VersionInfoParcel versionInfoParcel) {
        super(context, executor, zzcglVar, zzeylVar, zzewsVar, zzfbnVar, versionInfoParcel);
    }

    @Override // com.google.android.gms.internal.ads.zzewc
    protected final /* bridge */ /* synthetic */ zzcuh zze(zzcnw zzcnwVar, zzcul zzculVar, zzdaw zzdawVar) {
        zzcnm zzcnmVarZzc = this.zza.zzc();
        zzcnmVarZzc.zzd(zzculVar);
        zzcnmVarZzc.zzc(zzdawVar);
        return zzcnmVarZzc;
    }
}
