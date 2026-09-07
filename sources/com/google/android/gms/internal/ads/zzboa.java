package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
@ParametersAreNonnullByDefault
public final class zzboa {
    static final com.google.android.gms.ads.internal.util.zzbd zza = new zzbny();
    static final com.google.android.gms.ads.internal.util.zzbd zzb = new zzbnz();
    private final zzbnm zzc;

    public zzboa(Context context, VersionInfoParcel versionInfoParcel, String str, @Nullable zzfgq zzfgqVar) {
        this.zzc = new zzbnm(context, versionInfoParcel, str, zza, zzb, zzfgqVar);
    }

    public final zzbnq zza(String str, zzbnt zzbntVar, zzbns zzbnsVar) {
        return new zzboe(this.zzc, str, zzbntVar, zzbnsVar);
    }

    public final zzboj zzb() {
        return new zzboj(this.zzc);
    }
}
