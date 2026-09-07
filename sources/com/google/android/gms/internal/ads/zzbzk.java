package com.google.android.gms.internal.ads;

import androidx.webkit.Profile;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.util.ClientLibraryUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzbzk {
    public static final zzgcd zza;
    public static final zzgcd zzb;
    public static final zzgcd zzc;
    public static final ScheduledExecutorService zzd;
    public static final zzgce zze;
    public static final zzgcd zzf;
    public static final zzgcd zzg;

    /* JADX WARN: Code duplicated, block: B:14:0x009b  */
    static {
        ExecutorService threadPoolExecutor;
        ExecutorService executorServiceZzc;
        ExecutorService executorServiceZzb;
        if (ClientLibraryUtils.isPackageSide()) {
            zzfqe.zza();
            threadPoolExecutor = Executors.unconfigurableExecutorService(Executors.newCachedThreadPool(new zzbzg(Profile.DEFAULT_PROFILE_NAME)));
        } else {
            if (com.google.android.gms.ads.internal.client.zzbd.zzc().zzc(zzbci.zzlr) != null) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzc(zzbci.zzlr)).booleanValue()) {
                    if (com.google.android.gms.ads.internal.client.zzbd.zzc().zzc(zzbci.zzls) != null) {
                        if (com.google.android.gms.ads.internal.client.zzbd.zzc().zzc(zzbci.zzlt) != null) {
                            ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzc(zzbci.zzls)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzc(zzbci.zzls)).intValue(), 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzbzg(Profile.DEFAULT_PROFILE_NAME));
                            threadPoolExecutor2.allowCoreThreadTimeOut(((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzc(zzbci.zzlt)).booleanValue());
                            threadPoolExecutor = threadPoolExecutor2;
                        } else {
                            threadPoolExecutor = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10L, TimeUnit.SECONDS, new SynchronousQueue(), new zzbzg(Profile.DEFAULT_PROFILE_NAME));
                        }
                    } else {
                        threadPoolExecutor = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10L, TimeUnit.SECONDS, new SynchronousQueue(), new zzbzg(Profile.DEFAULT_PROFILE_NAME));
                    }
                } else {
                    threadPoolExecutor = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10L, TimeUnit.SECONDS, new SynchronousQueue(), new zzbzg(Profile.DEFAULT_PROFILE_NAME));
                }
            } else {
                threadPoolExecutor = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10L, TimeUnit.SECONDS, new SynchronousQueue(), new zzbzg(Profile.DEFAULT_PROFILE_NAME));
            }
        }
        zzbzj zzbzjVar = null;
        zza = new zzbzi(threadPoolExecutor, zzbzjVar);
        if (ClientLibraryUtils.isPackageSide()) {
            executorServiceZzc = zzfqe.zza().zzc(5, new zzbzg("Loader"), 1);
        } else {
            ThreadPoolExecutor threadPoolExecutor3 = new ThreadPoolExecutor(5, 5, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzbzg("Loader"));
            threadPoolExecutor3.allowCoreThreadTimeOut(true);
            executorServiceZzc = threadPoolExecutor3;
        }
        zzb = new zzbzi(executorServiceZzc, zzbzjVar);
        if (ClientLibraryUtils.isPackageSide()) {
            executorServiceZzb = zzfqe.zza().zzb(new zzbzg("Activeview"), 1);
        } else {
            ThreadPoolExecutor threadPoolExecutor4 = new ThreadPoolExecutor(1, 1, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzbzg("Activeview"));
            threadPoolExecutor4.allowCoreThreadTimeOut(true);
            executorServiceZzb = threadPoolExecutor4;
        }
        zzc = new zzbzi(executorServiceZzb, zzbzjVar);
        zzbzf zzbzfVar = new zzbzf(3, new zzbzg(AppEventsConstants.EVENT_NAME_SCHEDULE));
        zzd = zzbzfVar;
        zze = zzgck.zzb(zzbzfVar);
        zzf = new zzbzi(new zzbzh(), zzbzjVar);
        zzg = new zzbzi(zzgck.zzc(), zzbzjVar);
    }
}
