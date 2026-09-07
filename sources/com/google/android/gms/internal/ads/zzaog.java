package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaog implements zzadc {
    private final zzek zza = new zzek(4);
    private final zzaed zzb = new zzaed(-1, -1, "image/webp");

    @Override // com.google.android.gms.internal.ads.zzadc
    public final int zzb(zzadd zzaddVar, zzady zzadyVar) throws IOException {
        return this.zzb.zzb(zzaddVar, zzadyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final /* synthetic */ zzadc zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final /* synthetic */ List zzd() {
        return zzfww.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final void zze(zzadf zzadfVar) {
        this.zzb.zze(zzadfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final void zzf(long j, long j2) {
        this.zzb.zzf(j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final boolean zzi(zzadd zzaddVar) throws IOException {
        zzek zzekVar = this.zza;
        zzekVar.zzI(4);
        zzacr zzacrVar = (zzacr) zzaddVar;
        zzacrVar.zzm(zzekVar.zzN(), 0, 4, false);
        if (zzekVar.zzu() == 1380533830) {
            zzacrVar.zzl(4, false);
            zzekVar.zzI(4);
            zzacrVar.zzm(zzekVar.zzN(), 0, 4, false);
            if (zzekVar.zzu() == 1464156752) {
                return true;
            }
        }
        return false;
    }
}
