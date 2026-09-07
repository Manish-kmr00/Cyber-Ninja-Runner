package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
@ParametersAreNonnullByDefault
public final class zzboe implements zzbnq {
    private final zzbns zza;
    private final zzbnt zzb;
    private final zzbnm zzc;
    private final String zzd;

    zzboe(zzbnm zzbnmVar, String str, zzbnt zzbntVar, zzbns zzbnsVar) {
        this.zzc = zzbnmVar;
        this.zzd = str;
        this.zzb = zzbntVar;
        this.zza = zzbnsVar;
    }

    static /* bridge */ /* synthetic */ void zzd(zzboe zzboeVar, zzbng zzbngVar, zzbnn zzbnnVar, Object obj, zzbzp zzbzpVar) {
        try {
            com.google.android.gms.ads.internal.zzv.zzq();
            String string = UUID.randomUUID().toString();
            zzbji.zzo.zzc(string, new zzbod(zzboeVar, zzbngVar, zzbzpVar));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", string);
            jSONObject.put("args", zzboeVar.zzb.zzb(obj));
            zzbnnVar.zzp(zzboeVar.zzd, jSONObject);
        } catch (Exception e) {
            try {
                zzbzpVar.zzd(e);
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to invokeJavascript", e);
            } finally {
                zzbngVar.zzb();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgaz
    public final ListenableFuture zza(Object obj) throws Exception {
        return zzb(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzbnq
    public final ListenableFuture zzb(Object obj) {
        zzbzp zzbzpVar = new zzbzp();
        zzbng zzbngVarZzb = this.zzc.zzb(null);
        com.google.android.gms.ads.internal.util.zze.zza("callJs > getEngine: Promise created");
        zzbngVarZzb.zzj(new zzbob(this, zzbngVarZzb, obj, zzbzpVar), new zzboc(this, zzbzpVar, zzbngVarZzb));
        return zzbzpVar;
    }
}
