package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzbzf extends ScheduledThreadPoolExecutor {
    zzbzf(int i, ThreadFactory threadFactory) {
        super(3, threadFactory);
    }
}
