package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgnf {
    private final Class zza;
    private List zzb = new ArrayList();
    private zzglg zzc;

    /* synthetic */ zzgnf(Class cls, zzgni zzgniVar) {
        this.zza = cls;
    }

    private final zzgnf zzd(zzgdh zzgdhVar, zzgsz zzgszVar, boolean z) throws GeneralSecurityException {
        if (this.zzb == null) {
            throw new IllegalStateException("addEntry cannot be called after build");
        }
        if (zzgszVar.zzk() != 3) {
            throw new GeneralSecurityException("only ENABLED key is allowed");
        }
        zzgng zzgngVar = new zzgng(zzgdj.zza, zzgszVar.zza(), zzgdhVar, z, null);
        this.zzb.add(zzgngVar);
        if (z) {
            if (this.zzc != null) {
                throw new IllegalStateException("you cannot set two primary primitives");
            }
            this.zzc = zzgngVar;
        }
        return this;
    }

    public final zzgnf zza(zzgdh zzgdhVar, zzgsz zzgszVar) throws GeneralSecurityException {
        zzd(zzgdhVar, zzgszVar, false);
        return this;
    }

    public final zzgnf zzb(zzgdh zzgdhVar, zzgsz zzgszVar) throws GeneralSecurityException {
        zzd(zzgdhVar, zzgszVar, true);
        return this;
    }

    public final zzgnj zzc() throws GeneralSecurityException {
        List list = this.zzb;
        if (list == null) {
            throw new IllegalStateException("build cannot be called twice");
        }
        zzgnj zzgnjVar = new zzgnj(new zzgnh(list, this.zzc), this.zza, null);
        this.zzb = null;
        return zzgnjVar;
    }
}
