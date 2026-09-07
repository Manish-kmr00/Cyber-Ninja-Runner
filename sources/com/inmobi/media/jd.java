package com.inmobi.media;

import android.content.Context;
import coil.disk.DiskLruCache;
import com.inmobi.commons.core.configs.AdConfig;
import io.ktor.http.ContentDisposition;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class jd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C3536r3 f3350a;
    public final id b;

    public jd(final Context context, final AdConfig.WebAssetCacheConfig webAssetCacheConfig) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(webAssetCacheConfig, "webAssetCacheConfig");
        this.b = new id();
        C3517pb.a(new Runnable() { // from class: com.inmobi.media.jd$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                jd.a(webAssetCacheConfig, this, context);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0043 A[Catch: Exception -> 0x004e, TRY_LEAVE, TryCatch #0 {Exception -> 0x004e, blocks: (B:5:0x0011, B:6:0x0017, B:8:0x0025, B:10:0x003b, B:13:0x0043), top: B:22:0x0011 }] */
    public final InputStream a(String url, L4 l4) {
        C3523q3 c3523q3B;
        Intrinsics.checkNotNullParameter(url, "url");
        C3536r3 c3536r3 = this.f3350a;
        if (c3536r3 == null) {
            if (l4 != null) {
                ((M4) l4).a("WebAssetLRUCacheHelper", "Disk Cache Failed to Initialize. Failed readFromCache: ".concat(url));
            }
            return null;
        }
        if (c3536r3 == null) {
            try {
                Intrinsics.throwUninitializedPropertyAccessException("diskLruCache");
                c3536r3 = null;
                c3523q3B = c3536r3.b(String.valueOf(url.hashCode()));
                if (c3523q3B == null && Intrinsics.areEqual(url, Dc.a(new InputStreamReader(c3523q3B.f3403a[0], Dc.b)))) {
                    return c3523q3B.f3403a[1];
                }
                if (l4 != null) {
                    ((M4) l4).a("WebAssetLRUCacheHelper", "did not find any valid cache entry for ".concat(url));
                }
            } catch (Exception e) {
                if (l4 != null) {
                    ((M4) l4).a("WebAssetLRUCacheHelper", "Failed to read from cache with: " + e.getMessage() + " for " + url);
                }
            }
        } else {
            c3523q3B = c3536r3.b(String.valueOf(url.hashCode()));
            if (c3523q3B == null) {
            }
            if (l4 != null) {
                ((M4) l4).a("WebAssetLRUCacheHelper", "did not find any valid cache entry for ".concat(url));
            }
        }
        return null;
    }

    public static final void a(AdConfig.WebAssetCacheConfig webAssetCacheConfig, jd this$0, Context context) {
        Intrinsics.checkNotNullParameter(webAssetCacheConfig, "$webAssetCacheConfig");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        try {
            long jE = C3435k3.f3355a.e();
            if (jE < webAssetCacheConfig.getMinAvailableDiskSpace()) {
                this$0.getClass();
                a(context, jE);
                ConcurrentHashMap concurrentHashMap = K5.b;
                J5.a(context, "web_asset_file_key").a("cache_enabled", false);
            } else {
                this$0.a(context, webAssetCacheConfig, jE);
                ConcurrentHashMap concurrentHashMap2 = K5.b;
                J5.a(context, "web_asset_file_key").a("cache_enabled", true);
            }
        } catch (Exception e) {
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
        }
    }

    public final void a(Context context, AdConfig.WebAssetCacheConfig webAssetCacheConfig, long j) throws IOException {
        File file = new File(context.getFilesDir(), "inmobiwebassetcache");
        Intrinsics.checkNotNullParameter(webAssetCacheConfig, "webAssetCacheConfig");
        long jMin = ((long) (j == -1 ? 0 : Math.min(webAssetCacheConfig.getCacheSize(), (int) ((j * ((long) webAssetCacheConfig.getCacheSizeToDiskSpaceMaxPercent())) / ((long) 100))))) * 1024 * ((long) 1024);
        id idVar = this.b;
        Pattern pattern = C3536r3.p;
        if (jMin > 0) {
            File file2 = new File(file, DiskLruCache.JOURNAL_FILE_BACKUP);
            if (file2.exists()) {
                File file3 = new File(file, DiskLruCache.JOURNAL_FILE);
                if (file3.exists()) {
                    file2.delete();
                } else if (!file2.renameTo(file3)) {
                    throw new IOException();
                }
            }
            C3536r3 c3536r3 = new C3536r3(file, jMin, idVar);
            if (c3536r3.b.exists()) {
                try {
                    c3536r3.c();
                    c3536r3.b();
                    c3536r3.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(c3536r3.b, true), Dc.f3051a));
                } catch (IOException e) {
                    System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                    c3536r3.close();
                    Dc.a(c3536r3.f3414a);
                    file.mkdirs();
                    c3536r3 = new C3536r3(file, jMin, idVar);
                    c3536r3.d();
                }
            } else {
                file.mkdirs();
                c3536r3 = new C3536r3(file, jMin, idVar);
                c3536r3.d();
            }
            Intrinsics.checkNotNullExpressionValue(c3536r3, "open(...)");
            this.f3350a = c3536r3;
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public static void a(Context context, long j) {
        Pair pair = TuplesKt.to(ContentDisposition.Parameters.Size, Long.valueOf(j));
        ConcurrentHashMap concurrentHashMap = K5.b;
        K5 k5A = J5.a(context, "web_asset_file_key");
        Intrinsics.checkNotNullParameter("cache_enabled", "key");
        Map mapMutableMapOf = MapsKt.mutableMapOf(pair, TuplesKt.to("state", Boolean.valueOf(k5A.f3112a.getBoolean("cache_enabled", false))));
        Ob ob = Ob.f3160a;
        Ob.b("LowAvailableSpaceForCache", mapMutableMapOf, Sb.SDK);
    }
}
