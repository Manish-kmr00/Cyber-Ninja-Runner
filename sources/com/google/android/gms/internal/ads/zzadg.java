package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzadg {
    public static int zza(zzadd zzaddVar, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (i3 < i2) {
            int iZzb = zzaddVar.zzb(bArr, i + i3, i2 - i3);
            if (iZzb == -1) {
                break;
            }
            i3 += iZzb;
        }
        return i3;
    }

    @Pure
    public static void zzb(boolean z, String str) throws zzaz {
        if (!z) {
            throw zzaz.zza(str, null);
        }
    }

    public static boolean zzc(zzadd zzaddVar, byte[] bArr, int i, int i2, boolean z) throws IOException {
        try {
            return zzaddVar.zzm(bArr, 0, i2, z);
        } catch (EOFException e) {
            if (z) {
                return false;
            }
            throw e;
        }
    }

    public static boolean zzd(zzadd zzaddVar, byte[] bArr, int i, int i2) throws IOException {
        try {
            zzaddVar.zzi(bArr, i, i2);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean zze(zzadd zzaddVar, int i) throws IOException {
        try {
            zzaddVar.zzk(i);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
