package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzrt {
    public final int zza;
    public final zzuy zzb;
    private final CopyOnWriteArrayList zzc;

    public zzrt() {
        this(new CopyOnWriteArrayList(), 0, null);
    }

    private zzrt(CopyOnWriteArrayList copyOnWriteArrayList, int i, zzuy zzuyVar) {
        this.zzc = copyOnWriteArrayList;
        this.zza = 0;
        this.zzb = zzuyVar;
    }

    public final zzrt zza(int i, zzuy zzuyVar) {
        return new zzrt(this.zzc, 0, zzuyVar);
    }

    public final void zzb(Handler handler, zzru zzruVar) {
        this.zzc.add(new zzrs(handler, zzruVar));
    }

    public final void zzc(zzru zzruVar) {
        CopyOnWriteArrayList<zzrs> copyOnWriteArrayList = this.zzc;
        for (zzrs zzrsVar : copyOnWriteArrayList) {
            if (zzrsVar.zza == zzruVar) {
                copyOnWriteArrayList.remove(zzrsVar);
            }
        }
    }
}
