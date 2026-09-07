package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzbug;
import com.google.android.gms.internal.ads.zzbxi;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
@ParametersAreNonnullByDefault
public final class zzb {
    private final Context zza;
    private boolean zzb;
    private final zzbxi zzc;
    private final zzbug zzd = new zzbug(false, Collections.emptyList());

    public zzb(Context context, zzbxi zzbxiVar, zzbug zzbugVar) {
        this.zza = context;
        this.zzc = zzbxiVar;
    }

    private final boolean zzd() {
        zzbxi zzbxiVar = this.zzc;
        return (zzbxiVar != null && zzbxiVar.zza().zzf) || this.zzd.zza;
    }

    public final void zza() {
        this.zzb = true;
    }

    public final void zzb(String str) {
        List<String> list;
        if (zzd()) {
            if (str == null) {
                str = "";
            }
            zzbxi zzbxiVar = this.zzc;
            if (zzbxiVar != null) {
                zzbxiVar.zze(str, null, 3);
                return;
            }
            zzbug zzbugVar = this.zzd;
            if (!zzbugVar.zza || (list = zzbugVar.zzb) == null) {
                return;
            }
            for (String str2 : list) {
                if (!TextUtils.isEmpty(str2)) {
                    String strReplace = str2.replace("{NAVIGATION_URL}", Uri.encode(str));
                    Context context = this.zza;
                    zzv.zzq();
                    com.google.android.gms.ads.internal.util.zzs.zzM(context, "", strReplace);
                }
            }
        }
    }

    public final boolean zzc() {
        return !zzd() || this.zzb;
    }
}
