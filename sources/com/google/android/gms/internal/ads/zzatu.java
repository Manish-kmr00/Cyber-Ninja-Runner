package com.google.android.gms.internal.ads;

import com.mbridge.msdk.foundation.tools.SameMD5;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes5.dex */
final class zzatu implements Runnable {
    private zzatu() {
        throw null;
    }

    /* synthetic */ zzatu(zzatv zzatvVar) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        CountDownLatch countDownLatch;
        try {
            zzatw.zzd = MessageDigest.getInstance(SameMD5.TAG);
            countDownLatch = zzatw.zzb;
        } catch (NoSuchAlgorithmException unused) {
            countDownLatch = zzatw.zzb;
        } catch (Throwable th) {
            zzatw.zzb.countDown();
            throw th;
        }
        countDownLatch.countDown();
    }
}
