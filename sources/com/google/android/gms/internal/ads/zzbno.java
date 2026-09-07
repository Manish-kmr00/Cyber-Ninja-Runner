package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzbno implements zzbmg, zzbnn {
    private final zzbnn zza;
    private final HashSet zzb = new HashSet();

    public zzbno(zzbnn zzbnnVar) {
        this.zza = zzbnnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbmg, com.google.android.gms.internal.ads.zzbmq
    public final void zza(String str) {
        this.zza.zza(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbmg, com.google.android.gms.internal.ads.zzbmq
    public final /* synthetic */ void zzb(String str, String str2) {
        zzbmf.zzc(this, str, str2);
    }

    public final void zzc() {
        HashSet<AbstractMap.SimpleEntry> hashSet = this.zzb;
        for (AbstractMap.SimpleEntry simpleEntry : hashSet) {
            com.google.android.gms.ads.internal.util.zze.zza("Unregistering eventhandler: ".concat(String.valueOf(((zzbjj) simpleEntry.getValue()).toString())));
            this.zza.zzr((String) simpleEntry.getKey(), (zzbjj) simpleEntry.getValue());
        }
        hashSet.clear();
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final /* synthetic */ void zzd(String str, Map map) {
        zzbmf.zza(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzbmg, com.google.android.gms.internal.ads.zzbme
    public final /* synthetic */ void zze(String str, JSONObject jSONObject) {
        zzbmf.zzb(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbmq
    public final /* synthetic */ void zzp(String str, JSONObject jSONObject) {
        zzbmf.zzd(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbnn
    public final void zzq(String str, zzbjj zzbjjVar) {
        this.zza.zzq(str, zzbjjVar);
        this.zzb.add(new AbstractMap.SimpleEntry(str, zzbjjVar));
    }

    @Override // com.google.android.gms.internal.ads.zzbnn
    public final void zzr(String str, zzbjj zzbjjVar) {
        this.zza.zzr(str, zzbjjVar);
        this.zzb.remove(new AbstractMap.SimpleEntry(str, zzbjjVar));
    }
}
