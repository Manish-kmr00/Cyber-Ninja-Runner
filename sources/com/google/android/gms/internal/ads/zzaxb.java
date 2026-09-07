package com.google.android.gms.internal.ads;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaxb extends zzaxo {
    private static volatile String zzh;
    private static final Object zzi = new Object();

    public zzaxb(zzawb zzawbVar, String str, String str2, zzarz zzarzVar, int i, int i2) {
        super(zzawbVar, "6gGfGGcmx1E9KiSWvrEfwVv6XPnvjiNvbpksNPDa7IjVt7AgYM1vgnt6WUCH3zMa", "LIwJJPdWSBNAREBH7yVN3RT/pyZ0gZIKN23H3vO2NIc=", zzarzVar, i, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zzd.zzz(ExifInterface.LONGITUDE_EAST);
        if (zzh == null) {
            synchronized (zzi) {
                if (zzh == null) {
                    zzh = (String) this.zze.invoke(null, new Object[0]);
                }
            }
        }
        zzarz zzarzVar = this.zzd;
        synchronized (zzarzVar) {
            zzarzVar.zzz(zzh);
        }
    }
}
