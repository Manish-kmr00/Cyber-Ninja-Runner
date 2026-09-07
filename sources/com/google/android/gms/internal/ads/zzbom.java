package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzbom implements zzgaz {
    private final String zza = "google.afma.activeView.handleUpdate";
    private final ListenableFuture zzb;

    zzbom(ListenableFuture listenableFuture, String str, zzbnt zzbntVar, zzbns zzbnsVar) {
        this.zzb = listenableFuture;
    }

    public static /* synthetic */ ListenableFuture zzb(zzbom zzbomVar, Object obj, zzbnn zzbnnVar) throws JSONException {
        zzbzp zzbzpVar = new zzbzp();
        com.google.android.gms.ads.internal.zzv.zzq();
        String string = UUID.randomUUID().toString();
        zzbji.zzo.zzc(string, new zzbol(zzbomVar, zzbzpVar));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", string);
        jSONObject.put("args", (JSONObject) obj);
        zzbnnVar.zzp(zzbomVar.zza, jSONObject);
        return zzbzpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgaz
    public final ListenableFuture zza(Object obj) throws Exception {
        return zzc(obj);
    }

    public final ListenableFuture zzc(final Object obj) {
        return zzgbs.zzn(this.zzb, new zzgaz() { // from class: com.google.android.gms.internal.ads.zzbok
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj2) {
                return zzbom.zzb(this.zza, obj, (zzbnn) obj2);
            }
        }, zzbzk.zzg);
    }
}
