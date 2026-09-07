package com.google.android.gms.ads.nonagon.util.logging.csi;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.ads.zzhey;
import com.google.android.gms.internal.ads.zzhfh;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class CsiParamDefaults_Factory implements zzhey<CsiParamDefaults> {
    private final zzhfh zza;
    private final zzhfh zzb;

    public CsiParamDefaults_Factory(zzhfh<Context> zzhfhVar, zzhfh<VersionInfoParcel> zzhfhVar2) {
        this.zza = zzhfhVar;
        this.zzb = zzhfhVar2;
    }

    public static CsiParamDefaults_Factory create(zzhfh<Context> zzhfhVar, zzhfh<VersionInfoParcel> zzhfhVar2) {
        return new CsiParamDefaults_Factory(zzhfhVar, zzhfhVar2);
    }

    public static CsiParamDefaults newInstance(Context context, VersionInfoParcel versionInfoParcel) {
        return new CsiParamDefaults(context, versionInfoParcel);
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public CsiParamDefaults zzb() {
        return newInstance((Context) this.zza.zzb(), (VersionInfoParcel) this.zzb.zzb());
    }
}
