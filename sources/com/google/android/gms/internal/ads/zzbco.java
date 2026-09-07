package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
@ParametersAreNonnullByDefault
@Deprecated
public final class zzbco {
    public static final void zza(zzbcn zzbcnVar, zzbcl zzbclVar) {
        if (zzbclVar.zza() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        }
        if (TextUtils.isEmpty(zzbclVar.zzb())) {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
        zzbcnVar.zzd(zzbclVar.zza(), zzbclVar.zzb(), zzbclVar.zzc(), zzbclVar.zzd());
    }
}
