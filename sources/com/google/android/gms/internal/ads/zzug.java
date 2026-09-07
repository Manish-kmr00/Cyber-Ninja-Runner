package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public abstract class zzug extends zztx {
    private final HashMap zza = new HashMap();
    private Handler zzb;
    private zzhe zzc;

    protected zzug() {
    }

    protected abstract void zzA(Object obj, zzva zzvaVar, zzbl zzblVar);

    protected final void zzB(final Object obj, zzva zzvaVar) {
        HashMap map = this.zza;
        zzdc.zzd(!map.containsKey(obj));
        zzuz zzuzVar = new zzuz() { // from class: com.google.android.gms.internal.ads.zzud
            @Override // com.google.android.gms.internal.ads.zzuz
            public final void zza(zzva zzvaVar2, zzbl zzblVar) {
                this.zza.zzA(obj, zzvaVar2, zzblVar);
            }
        };
        zzue zzueVar = new zzue(this, obj);
        map.put(obj, new zzuf(zzvaVar, zzuzVar, zzueVar));
        Handler handler = this.zzb;
        handler.getClass();
        zzvaVar.zzh(handler, zzueVar);
        Handler handler2 = this.zzb;
        handler2.getClass();
        zzvaVar.zzg(handler2, zzueVar);
        zzvaVar.zzm(zzuzVar, this.zzc, zzb());
        if (zzu()) {
            return;
        }
        zzvaVar.zzi(zzuzVar);
    }

    @Override // com.google.android.gms.internal.ads.zztx
    protected final void zzj() {
        for (zzuf zzufVar : this.zza.values()) {
            zzufVar.zza.zzi(zzufVar.zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zztx
    protected final void zzl() {
        for (zzuf zzufVar : this.zza.values()) {
            zzufVar.zza.zzk(zzufVar.zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zztx
    protected void zzn(zzhe zzheVar) {
        this.zzc = zzheVar;
        this.zzb = zzeu.zzy(null);
    }

    @Override // com.google.android.gms.internal.ads.zztx
    protected void zzq() {
        HashMap map = this.zza;
        for (zzuf zzufVar : map.values()) {
            zzva zzvaVar = zzufVar.zza;
            zzvaVar.zzp(zzufVar.zzb);
            zzue zzueVar = zzufVar.zzc;
            zzvaVar.zzs(zzueVar);
            zzvaVar.zzr(zzueVar);
        }
        map.clear();
    }

    protected int zzw(Object obj, int i) {
        return 0;
    }

    protected long zzx(Object obj, long j, zzuy zzuyVar) {
        return j;
    }

    protected zzuy zzy(Object obj, zzuy zzuyVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzva
    public void zzz() throws IOException {
        Iterator it = this.zza.values().iterator();
        while (it.hasNext()) {
            ((zzuf) it.next()).zza.zzz();
        }
    }
}
