package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.internal.ads.zzaor;
import com.google.android.gms.internal.ads.zzapm;
import com.google.android.gms.internal.ads.zzaqq;
import com.google.android.gms.internal.ads.zzbci;
import com.google.android.gms.internal.ads.zzbzp;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
@ParametersAreNonnullByDefault
public final class zzbo {
    private static zzapm zza;
    private static final Object zzb = new Object();

    /* JADX WARN: Code duplicated, block: B:14:0x0034 A[Catch: all -> 0x0040, TryCatch #0 {, blocks: (B:7:0x0010, B:9:0x0014, B:11:0x001d, B:13:0x002f, B:15:0x003c, B:14:0x0034, B:16:0x003e), top: B:21:0x0010 }] */
    public zzbo(Context context) {
        zzapm zzapmVarZza;
        context = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        synchronized (zzb) {
            if (zza == null) {
                zzbci.zza(context);
                if (ClientLibraryUtils.isPackageSide()) {
                    zzapmVarZza = zzaqq.zza(context, null);
                } else {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzeD)).booleanValue()) {
                        zzapmVarZza = zzaz.zzb(context);
                    } else {
                        zzapmVarZza = zzaqq.zza(context, null);
                    }
                }
                zza = zzapmVarZza;
            }
        }
    }

    public final ListenableFuture zza(String str) {
        zzbzp zzbzpVar = new zzbzp();
        zza.zza(new zzbm(str, null, zzbzpVar));
        return zzbzpVar;
    }

    public final ListenableFuture zzb(int i, String str, Map map, byte[] bArr) {
        zzbk zzbkVar = new zzbk(null);
        zzbi zzbiVar = new zzbi(this, str, zzbkVar);
        com.google.android.gms.ads.internal.util.client.zzl zzlVar = new com.google.android.gms.ads.internal.util.client.zzl(null);
        zzbj zzbjVar = new zzbj(this, i, str, zzbkVar, zzbiVar, bArr, map, zzlVar);
        if (com.google.android.gms.ads.internal.util.client.zzl.zzk()) {
            try {
                zzlVar.zzd(str, "GET", zzbjVar.zzl(), zzbjVar.zzx());
            } catch (zzaor e) {
                String message = e.getMessage();
                int i2 = zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj(message);
            }
        }
        zza.zza(zzbjVar);
        return zzbkVar;
    }
}
