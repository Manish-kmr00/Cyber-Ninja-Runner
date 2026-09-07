package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdcw extends zzdat implements zzayh {
    private final Map zzb;
    private final Context zzc;
    private final zzfau zzd;

    public zzdcw(Context context, Set set, zzfau zzfauVar) {
        super(set);
        this.zzb = new WeakHashMap(1);
        this.zzc = context;
        this.zzd = zzfauVar;
    }

    public final synchronized void zza(View view) {
        Map map = this.zzb;
        zzayi zzayiVar = (zzayi) map.get(view);
        if (zzayiVar == null) {
            zzayi zzayiVar2 = new zzayi(this.zzc, view);
            zzayiVar2.zzd(this);
            map.put(view, zzayiVar2);
            zzayiVar = zzayiVar2;
        }
        if (this.zzd.zzX) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbB)).booleanValue()) {
                zzayiVar.zzg(((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbA)).longValue());
                return;
            }
        }
        zzayiVar.zzf();
    }

    public final synchronized void zzb(View view) {
        Map map = this.zzb;
        if (map.containsKey(view)) {
            ((zzayi) map.get(view)).zze(this);
            map.remove(view);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayh
    public final synchronized void zzdn(final zzayg zzaygVar) {
        zzq(new zzdas() { // from class: com.google.android.gms.internal.ads.zzdcv
            @Override // com.google.android.gms.internal.ads.zzdas
            public final void zza(Object obj) {
                ((zzayh) obj).zzdn(zzaygVar);
            }
        });
    }
}
