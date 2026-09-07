package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import com.json.ug;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes14.dex */
public final class zzdlo {
    private final Executor zza;
    private final zzcne zzb;
    private final zzdcw zzc;
    private final zzclx zzd;

    zzdlo(Executor executor, zzcne zzcneVar, zzdcw zzdcwVar, zzclx zzclxVar) {
        this.zza = executor;
        this.zzc = zzdcwVar;
        this.zzb = zzcneVar;
        this.zzd = zzclxVar;
    }

    public final void zzc(final zzcel zzcelVar) {
        if (zzcelVar == null) {
            return;
        }
        zzdcw zzdcwVar = this.zzc;
        zzdcwVar.zza(zzcelVar.zzF());
        zzayh zzayhVar = new zzayh() { // from class: com.google.android.gms.internal.ads.zzdlk
            @Override // com.google.android.gms.internal.ads.zzayh
            public final void zzdn(zzayg zzaygVar) {
                zzcgd zzcgdVarZzN = zzcelVar.zzN();
                Rect rect = zzaygVar.zzd;
                zzcgdVarZzN.zzr(rect.left, rect.top, false);
            }
        };
        Executor executor = this.zza;
        zzdcwVar.zzo(zzayhVar, executor);
        zzdcwVar.zzo(new zzayh() { // from class: com.google.android.gms.internal.ads.zzdll
            @Override // com.google.android.gms.internal.ads.zzayh
            public final void zzdn(zzayg zzaygVar) {
                HashMap map = new HashMap();
                map.put(ug.k, true != zzaygVar.zzj ? "0" : "1");
                zzcelVar.zzd("onAdVisibilityChanged", map);
            }
        }, executor);
        zzcne zzcneVar = this.zzb;
        zzdcwVar.zzo(zzcneVar, executor);
        zzcneVar.zzf(zzcelVar);
        zzcgd zzcgdVarZzN = zzcelVar.zzN();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzkk)).booleanValue() && zzcgdVarZzN != null) {
            zzclx zzclxVar = this.zzd;
            zzcgdVarZzN.zzL(zzclxVar);
            zzcgdVarZzN.zzM(zzclxVar, null, null);
        }
        zzcelVar.zzag("/trackActiveViewUnit", new zzbjj() { // from class: com.google.android.gms.internal.ads.zzdlm
            @Override // com.google.android.gms.internal.ads.zzbjj
            public final void zza(Object obj, Map map) {
                this.zza.zzb.zzd();
            }
        });
        zzcelVar.zzag("/untrackActiveViewUnit", new zzbjj() { // from class: com.google.android.gms.internal.ads.zzdln
            @Override // com.google.android.gms.internal.ads.zzbjj
            public final void zza(Object obj, Map map) {
                this.zza.zzb.zzb();
            }
        });
    }
}
