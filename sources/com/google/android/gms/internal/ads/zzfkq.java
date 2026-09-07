package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfkq extends zzfkt {
    private static final zzfkq zzb = new zzfkq();

    private zzfkq() {
    }

    public static zzfkq zza() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfkt
    public final void zzb(boolean z) {
        Iterator it = zzfkr.zza().zzc().iterator();
        while (it.hasNext()) {
            ((zzfjz) it.next()).zzg().zzk(z);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfkt
    public final boolean zzc() {
        Iterator it = zzfkr.zza().zzb().iterator();
        while (it.hasNext()) {
            View viewZzf = ((zzfjz) it.next()).zzf();
            if (viewZzf != null && viewZzf.hasWindowFocus()) {
                return true;
            }
        }
        return false;
    }
}
