package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.google.common.util.concurrent.ListenableFuture;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzely implements zzesv {
    private final Context zza;
    private final zzgcd zzb;

    zzely(zzgcd zzgcdVar, Context context) {
        this.zzb = zzgcdVar;
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final int zza() {
        return 61;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final ListenableFuture zzb() {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzmT)).booleanValue()) {
            return zzgbs.zzh(new zzelz(null, false));
        }
        final ContentResolver contentResolver = this.zza.getContentResolver();
        return contentResolver == null ? zzgbs.zzh(new zzelz(null, false)) : this.zzb.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzelx
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ContentResolver contentResolver2 = contentResolver;
                return new zzelz(Settings.Secure.getString(contentResolver2, "advertising_id"), Settings.Secure.getInt(contentResolver2, CommonUrlParts.LIMIT_AD_TRACKING, 0) == 1);
            }
        });
    }
}
