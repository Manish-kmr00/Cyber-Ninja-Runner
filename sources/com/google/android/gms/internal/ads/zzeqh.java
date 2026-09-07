package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.ViewGroup;
import android.view.Window;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzeqh implements zzesv {
    private final zzgcd zza;
    private final ViewGroup zzb;
    private final Context zzc;
    private final Set zzd;

    public zzeqh(zzgcd zzgcdVar, ViewGroup viewGroup, Context context, Set set) {
        this.zza = zzgcdVar;
        this.zzd = set;
        this.zzb = viewGroup;
        this.zzc = context;
    }

    public static /* synthetic */ zzeqi zzc(zzeqh zzeqhVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfT)).booleanValue() && zzeqhVar.zzb != null && zzeqhVar.zzd.contains("banner")) {
            return new zzeqi(Boolean.valueOf(zzeqhVar.zzb.isHardwareAccelerated()));
        }
        Boolean boolValueOf = null;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfU)).booleanValue() && zzeqhVar.zzd.contains("native")) {
            Context context = zzeqhVar.zzc;
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                Window window = activity.getWindow();
                boolean z = true;
                if (window == null || (window.getAttributes().flags & 16777216) == 0) {
                    try {
                        if ((activity.getPackageManager().getActivityInfo(activity.getComponentName(), 0).flags & 512) == 0) {
                            z = false;
                        }
                        boolValueOf = Boolean.valueOf(z);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                } else {
                    boolValueOf = true;
                }
                return new zzeqi(boolValueOf);
            }
        }
        return new zzeqi(null);
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final int zza() {
        return 22;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeqg
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzeqh.zzc(this.zza);
            }
        });
    }
}
