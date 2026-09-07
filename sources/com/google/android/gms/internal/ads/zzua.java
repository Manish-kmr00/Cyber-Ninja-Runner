package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzua implements zzvt {
    private final zzadh zza;
    private zzadc zzb;
    private zzadd zzc;

    public zzua(zzadh zzadhVar) {
        this.zza = zzadhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final int zza(zzady zzadyVar) throws IOException {
        zzadc zzadcVar = this.zzb;
        zzadcVar.getClass();
        zzadd zzaddVar = this.zzc;
        zzaddVar.getClass();
        return zzadcVar.zzb(zzaddVar, zzadyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final long zzb() {
        zzadd zzaddVar = this.zzc;
        if (zzaddVar != null) {
            return zzaddVar.zzf();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final void zzc() {
        zzadc zzadcVar = this.zzb;
        if (zzadcVar != null && (zzadcVar instanceof zzahl)) {
            ((zzahl) zzadcVar).zza();
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x007c  */
    @Override // com.google.android.gms.internal.ads.zzvt
    public final void zzd(zzl zzlVar, Uri uri, Map map, long j, long j2, zzadf zzadfVar) throws IOException {
        zzacr zzacrVar = new zzacr(zzlVar, j, j2);
        this.zzc = zzacrVar;
        if (this.zzb != null) {
            return;
        }
        zzadc[] zzadcVarArrZza = this.zza.zza(uri, map);
        int length = zzadcVarArrZza.length;
        zzfwt zzfwtVarZzi = zzfww.zzi(length);
        if (length == 1) {
            this.zzb = zzadcVarArrZza[0];
        } else {
            for (int i = 0; i < length; i++) {
                zzadc zzadcVar = zzadcVarArrZza[i];
                try {
                    if (zzadcVar.zzi(zzacrVar)) {
                        this.zzb = zzadcVar;
                        zzdc.zzf(zzadcVar != null || zzacrVar.zzf() == j);
                        zzacrVar.zzj();
                        break;
                    } else {
                        zzfwtVarZzi.zzh(zzadcVar.zzd());
                        boolean z = this.zzb != null || zzacrVar.zzf() == j;
                        zzdc.zzf(z);
                        zzacrVar.zzj();
                    }
                } catch (EOFException unused) {
                    if (this.zzb != null || zzacrVar.zzf() == j) {
                    }
                } catch (Throwable th) {
                    zzdc.zzf(this.zzb != null || zzacrVar.zzf() == j);
                    zzacrVar.zzj();
                    throw th;
                }
                zzdc.zzf(z);
                zzacrVar.zzj();
            }
            if (this.zzb == null) {
                Iterator it = zzfxm.zzb(zzfww.zzm(zzadcVarArrZza), new zzftl() { // from class: com.google.android.gms.internal.ads.zztz
                    @Override // com.google.android.gms.internal.ads.zzftl
                    public final Object apply(Object obj) {
                        zzadc zzadcVar2 = (zzadc) obj;
                        zzadcVar2.zzc();
                        return zzadcVar2.getClass().getSimpleName();
                    }
                }).iterator();
                StringBuilder sb = new StringBuilder();
                zzfto.zzc(sb, it, ", ");
                throw new zzxe("None of the available extractors (" + sb.toString() + ") could read the stream.", uri, zzfwtVarZzi.zzi());
            }
        }
        this.zzb.zze(zzadfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final void zze() {
        if (this.zzb != null) {
            this.zzb = null;
        }
        this.zzc = null;
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final void zzf(long j, long j2) {
        zzadc zzadcVar = this.zzb;
        zzadcVar.getClass();
        zzadcVar.zzf(j, j2);
    }
}
