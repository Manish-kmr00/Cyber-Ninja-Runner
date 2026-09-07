package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public abstract class zzbxx {
    static zzbxx zzi;

    public static synchronized zzbxx zzb(Context context) {
        zzbxx zzbxxVar = zzi;
        if (zzbxxVar != null) {
            return zzbxxVar;
        }
        Context applicationContext = context.getApplicationContext();
        zzbci.zza(applicationContext);
        com.google.android.gms.ads.internal.util.zzg zzgVarZzi = com.google.android.gms.ads.internal.zzv.zzp().zzi();
        zzgVarZzi.zzp(applicationContext);
        zzbxp zzbxpVar = new zzbxp(null);
        zzbxpVar.zzb(applicationContext);
        zzbxpVar.zzc(com.google.android.gms.ads.internal.zzv.zzC());
        zzbxpVar.zza(zzgVarZzi);
        zzbxpVar.zzd(com.google.android.gms.ads.internal.zzv.zzo());
        zzbxx zzbxxVarZze = zzbxpVar.zze();
        zzi = zzbxxVarZze;
        ((zzbxj) ((zzbxq) zzbxxVarZze).zzc.zzb()).zza();
        zzbyb zzbybVar = (zzbyb) ((zzbxq) zzi).zzh.zzb();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzaI)).booleanValue()) {
            com.google.android.gms.ads.internal.zzv.zzq();
            Map mapZzw = com.google.android.gms.ads.internal.util.zzs.zzw((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzaJ));
            Iterator it = mapZzw.keySet().iterator();
            while (it.hasNext()) {
                zzbybVar.zzc((String) it.next());
            }
            zzbybVar.zzd(new zzbxz(zzbybVar, mapZzw));
        }
        return zzi;
    }

    abstract zzbxn zza();
}
