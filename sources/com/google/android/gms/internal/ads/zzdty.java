package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdty {
    private final zzdti zza;
    private final zzdor zzb;
    private final Object zzc = new Object();
    private final List zzd = new ArrayList();
    private boolean zze;

    zzdty(zzdti zzdtiVar, zzdor zzdorVar) {
        this.zza = zzdtiVar;
        this.zzb = zzdorVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzd(List list) {
        zzdoq zzdoqVarZza;
        zzdoq zzdoqVarZza2;
        zzbrm zzbrmVar;
        synchronized (this.zzc) {
            if (this.zze) {
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzblh zzblhVar = (zzblh) it.next();
                String string = (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzju)).booleanValue() || (zzdoqVarZza2 = this.zzb.zza(zzblhVar.zza)) == null || (zzbrmVar = zzdoqVarZza2.zzc) == null) ? "" : zzbrmVar.toString();
                String str = string;
                boolean z = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzjv)).booleanValue() && (zzdoqVarZza = this.zzb.zza(zzblhVar.zza)) != null && zzdoqVarZza.zzd;
                List list2 = this.zzd;
                String str2 = zzblhVar.zza;
                list2.add(new zzdtx(str2, str, this.zzb.zzb(str2), zzblhVar.zzb ? 1 : 0, zzblhVar.zzd, zzblhVar.zzc, z));
            }
            this.zze = true;
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002d A[Catch: all -> 0x003d, LOOP:0: B:13:0x0027->B:15:0x002d, LOOP_END, TryCatch #0 {, blocks: (B:4:0x0008, B:6:0x000c, B:8:0x0014, B:9:0x001c, B:10:0x001f, B:12:0x0021, B:13:0x0027, B:15:0x002d, B:16:0x003b), top: B:21:0x0008 }] */
    public final JSONArray zza() throws JSONException {
        Iterator it;
        JSONArray jSONArray = new JSONArray();
        synchronized (this.zzc) {
            if (this.zze) {
                it = this.zzd.iterator();
                while (it.hasNext()) {
                    jSONArray.put(((zzdtx) it.next()).zza());
                }
            } else {
                zzdti zzdtiVar = this.zza;
                if (zzdtiVar.zzt()) {
                    zzd(zzdtiVar.zzg());
                    it = this.zzd.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(((zzdtx) it.next()).zza());
                    }
                } else {
                    zzc();
                }
            }
        }
        return jSONArray;
    }

    public final void zzc() {
        this.zza.zzs(new zzdtw(this));
    }
}
