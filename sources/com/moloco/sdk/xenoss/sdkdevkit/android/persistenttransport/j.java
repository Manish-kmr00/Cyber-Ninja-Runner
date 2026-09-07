package com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport;

import androidx.exifinterface.media.ExifInterface;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import com.moloco.sdk.internal.MolocoLogger;
import io.ktor.http.ContentType;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class j implements i {
    public static final a c = new a(null);
    public static final String d = "PersistentHttpRequest";
    public final l b;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    public j(l worker) {
        Intrinsics.checkNotNullParameter(worker, "worker");
        this.b = worker;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.d
    public void a(String url) {
        Data dataA;
        Intrinsics.checkNotNullParameter(url, "url");
        if (e.a(url) && (dataA = k.a(url)) != null) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, d, "Enqueuing request to " + url, null, false, 12, null);
            this.b.a(new OneTimeWorkRequest.Builder(UrlGetRequestWorker.class).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).setBackoffCriteria(BackoffPolicy.LINEAR, 10000L, TimeUnit.MILLISECONDS).setInputData(dataA).build());
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.d
    public void a(String url, byte[] body, ContentType contentType) throws Throwable {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        if (e.a(url)) {
            try {
                Pair[] pairArr = {TuplesKt.to("url", url), TuplesKt.to("body", body), TuplesKt.to("contentType", contentType.toString())};
                Data.Builder builder = new Data.Builder();
                for (int i = 0; i < 3; i++) {
                    Pair pair = pairArr[i];
                    builder.put((String) pair.getFirst(), pair.getSecond());
                }
                Data dataBuild = builder.build();
                Intrinsics.checkNotNullExpressionValue(dataBuild, "dataBuilder.build()");
                MolocoLogger.info$default(MolocoLogger.INSTANCE, d, "Enqueuing request to " + url, null, false, 12, null);
                this.b.a(new OneTimeWorkRequest.Builder(UrlPostRequestWorker.class).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).setBackoffCriteria(BackoffPolicy.LINEAR, 10000L, TimeUnit.MILLISECONDS).setInputData(dataBuild).build());
            } catch (Exception e) {
                MolocoLogger.error$default(MolocoLogger.INSTANCE, d, "Failed to enqueue persistent request for url: " + url, e, false, 8, null);
            }
        }
    }

    public final /* synthetic */ <W extends ListenableWorker> OneTimeWorkRequest a(Data data) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.LONGITUDE_WEST);
        return new OneTimeWorkRequest.Builder(ListenableWorker.class).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).setBackoffCriteria(BackoffPolicy.LINEAR, 10000L, TimeUnit.MILLISECONDS).setInputData(data).build();
    }
}
