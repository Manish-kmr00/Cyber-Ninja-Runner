package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzawo extends zzaxo {
    private static final zzaxp zzh = new zzaxp();
    private final Context zzi;

    public zzawo(zzawb zzawbVar, String str, String str2, zzarz zzarzVar, int i, int i2, Context context) {
        super(zzawbVar, "xk+cC76rWJdSYf+hRQiAzQoNCf+H79UmYEblYPD4lvbXwBM+eG3Fjmce/aN8ufoO", "ZEsSNRGfbw0bqbaxAG92NStcWABOsDFkwqfauk+C3EM=", zzarzVar, i, 29);
        this.zzi = context;
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zzd.zzn(ExifInterface.LONGITUDE_EAST);
        Context context = this.zzi;
        AtomicReference atomicReferenceZza = zzh.zza(context.getPackageName());
        if (atomicReferenceZza.get() == null) {
            synchronized (atomicReferenceZza) {
                if (atomicReferenceZza.get() == null) {
                    atomicReferenceZza.set((String) this.zze.invoke(null, context));
                }
            }
        }
        String str = (String) atomicReferenceZza.get();
        zzarz zzarzVar = this.zzd;
        synchronized (zzarzVar) {
            zzarzVar.zzn(zzatp.zza(str.getBytes(), true));
        }
    }
}
