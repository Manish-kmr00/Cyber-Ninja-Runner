package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public interface zzfqb {
    ExecutorService zza(int i);

    ExecutorService zzb(ThreadFactory threadFactory, int i);

    ExecutorService zzc(int i, ThreadFactory threadFactory, int i2);
}
