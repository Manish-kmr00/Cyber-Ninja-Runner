package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzfx implements zzge {
    private final boolean zza;
    private final ArrayList zzb = new ArrayList(1);
    private int zzc;
    private zzgj zzd;

    protected zzfx(boolean z) {
        this.zza = z;
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public /* synthetic */ Map zze() {
        return Collections.emptyMap();
    }

    protected final void zzg(int i) {
        zzgj zzgjVar = this.zzd;
        int i2 = zzeu.zza;
        for (int i3 = 0; i3 < this.zzc; i3++) {
            ((zzhe) this.zzb.get(i3)).zza(this, zzgjVar, this.zza, i);
        }
    }

    protected final void zzh() {
        zzgj zzgjVar = this.zzd;
        int i = zzeu.zza;
        for (int i2 = 0; i2 < this.zzc; i2++) {
            ((zzhe) this.zzb.get(i2)).zzb(this, zzgjVar, this.zza);
        }
        this.zzd = null;
    }

    protected final void zzi(zzgj zzgjVar) {
        for (int i = 0; i < this.zzc; i++) {
            ((zzhe) this.zzb.get(i)).zzc(this, zzgjVar, this.zza);
        }
    }

    protected final void zzj(zzgj zzgjVar) {
        this.zzd = zzgjVar;
        for (int i = 0; i < this.zzc; i++) {
            ((zzhe) this.zzb.get(i)).zzd(this, zzgjVar, this.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void zzf(zzhe zzheVar) {
        zzheVar.getClass();
        ArrayList arrayList = this.zzb;
        if (arrayList.contains(zzheVar)) {
            return;
        }
        arrayList.add(zzheVar);
        this.zzc++;
    }
}
