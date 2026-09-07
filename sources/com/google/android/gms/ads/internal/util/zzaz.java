package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.internal.ads.zzapf;
import com.google.android.gms.internal.ads.zzapj;
import com.google.android.gms.internal.ads.zzapm;
import com.google.android.gms.internal.ads.zzaps;
import com.google.android.gms.internal.ads.zzapx;
import com.google.android.gms.internal.ads.zzapy;
import com.google.android.gms.internal.ads.zzaqf;
import com.google.android.gms.internal.ads.zzaqk;
import com.google.android.gms.internal.ads.zzbci;
import com.google.android.gms.internal.ads.zzblg;
import com.google.android.gms.internal.ads.zzfpb;
import com.google.android.gms.internal.ads.zzfpc;
import java.io.File;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzaz extends zzapy {
    private final Context zzb;

    private zzaz(Context context, zzapx zzapxVar) {
        super(zzapxVar);
        this.zzb = context;
    }

    public static zzapm zzb(Context context) {
        zzapm zzapmVar = new zzapm(new zzaqf(new File(zzfpc.zza(zzfpb.zza(), context.getCacheDir(), "admob_volley")), 20971520), new zzaz(context, new zzaqk(null, null)), 4);
        zzapmVar.zzd();
        return zzapmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzapy, com.google.android.gms.internal.ads.zzapc
    public final zzapf zza(zzapj zzapjVar) throws zzaps {
        if (zzapjVar.zza() == 0) {
            if (Pattern.matches((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzeE), zzapjVar.zzk())) {
                Context context = this.zzb;
                com.google.android.gms.ads.internal.client.zzbb.zzb();
                if (com.google.android.gms.ads.internal.util.client.zzf.zzt(context, 13400000)) {
                    zzapf zzapfVarZza = new zzblg(context).zza(zzapjVar);
                    if (zzapfVarZza != null) {
                        zze.zza("Got gmscore asset response: ".concat(String.valueOf(zzapjVar.zzk())));
                        return zzapfVarZza;
                    }
                    zze.zza("Failed to get gmscore asset response: ".concat(String.valueOf(zzapjVar.zzk())));
                }
            }
        }
        return super.zza(zzapjVar);
    }
}
