package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzesj implements zzesv {
    private final zzgcd zza;
    private final Context zzb;
    private final VersionInfoParcel zzc;
    private final String zzd;

    zzesj(zzgcd zzgcdVar, Context context, VersionInfoParcel versionInfoParcel, String str) {
        this.zza = zzgcdVar;
        this.zzb = context;
        this.zzc = versionInfoParcel;
        this.zzd = str;
    }

    public static /* synthetic */ zzesk zzc(zzesj zzesjVar) {
        Context context = zzesjVar.zzb;
        boolean zIsCallerInstantApp = Wrappers.packageManager(context).isCallerInstantApp();
        com.google.android.gms.ads.internal.zzv.zzq();
        boolean zZzF = com.google.android.gms.ads.internal.util.zzs.zzF(context);
        String str = zzesjVar.zzc.afmaVersion;
        com.google.android.gms.ads.internal.zzv.zzq();
        boolean zZzG = com.google.android.gms.ads.internal.util.zzs.zzG();
        com.google.android.gms.ads.internal.zzv.zzq();
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return new zzesk(zIsCallerInstantApp, zZzF, str, zZzG, applicationInfo == null ? 0 : applicationInfo.targetSdkVersion, DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID), DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID), zzesjVar.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final int zza() {
        return 35;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzesi
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzesj.zzc(this.zza);
            }
        });
    }
}
