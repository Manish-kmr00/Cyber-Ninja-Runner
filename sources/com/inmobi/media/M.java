package com.inmobi.media;

import android.util.Log;
import com.inmobi.adquality.models.AdQualityResult;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
public final class M extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ N f3130a;
    public final /* synthetic */ AdQualityResult b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M(N n, AdQualityResult adQualityResult) {
        super(1);
        this.f3130a = n;
        this.b = adQualityResult;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        C3543ra c3543ra;
        C3543ra c3543ra2;
        P8 p8 = (P8) obj;
        if (I3.d.equals(p8)) {
            Intrinsics.checkNotNullParameter("AdQualityBeaconExecutor", "tag");
            Intrinsics.checkNotNullParameter("no network... skipping cleanup", "message");
            Log.i("AdQualityBeaconExecutor", "no network... skipping cleanup");
        } else {
            Intrinsics.checkNotNullParameter("AdQualityBeaconExecutor", "tag");
            Intrinsics.checkNotNullParameter("beacon hit completed... cleaning up", "message");
            Log.i("AdQualityBeaconExecutor", "beacon hit completed... cleaning up");
            if (p8 == null) {
                WeakReference weakReference = (WeakReference) this.f3130a.d.get(this.b.getBeaconUrl());
                if (weakReference != null && (c3543ra2 = (C3543ra) weakReference.get()) != null) {
                    c3543ra2.f3417a.b("window.mraidview.broadcastEvent('AdReportSuccess')");
                }
            } else {
                WeakReference weakReference2 = (WeakReference) this.f3130a.d.get(this.b.getBeaconUrl());
                if (weakReference2 != null && (c3543ra = (C3543ra) weakReference2.get()) != null) {
                    c3543ra.f3417a.b("window.mraidview.broadcastEvent('AdReportFailed')");
                }
            }
            N n = this.f3130a;
            AdQualityResult result = this.b;
            n.getClass();
            Intrinsics.checkNotNullParameter(result, "result");
            try {
                ScheduledExecutorService scheduledExecutorService = P.f3162a;
                Q q = (Q) AbstractC3415ib.f3341a.getValue();
                q.getClass();
                Intrinsics.checkNotNullParameter(result, "result");
                Log.i("AdQualityDao", "de-queueing");
                q.a("image_location=?", new String[]{result.getImageLocation()});
                if (q.b != null) {
                    Log.i("AdQualityDao", "sending callback - dequeue");
                }
                if (result.getImageLocation().length() == 0) {
                    Intrinsics.checkNotNullParameter("AdQualityBeaconExecutor", "tag");
                    Intrinsics.checkNotNullParameter("no image to clear. clean up done.", "message");
                    Log.i("AdQualityBeaconExecutor", "no image to clear. clean up done.");
                } else {
                    File file = new File(result.getImageLocation());
                    Intrinsics.checkNotNullParameter("AdQualityBeaconExecutor", "tag");
                    Intrinsics.checkNotNullParameter("deleting file", "message");
                    Log.i("AdQualityBeaconExecutor", "deleting file");
                    String message = "delete file result - " + file.delete();
                    Intrinsics.checkNotNullParameter("AdQualityBeaconExecutor", "tag");
                    Intrinsics.checkNotNullParameter(message, "message");
                    Log.i("AdQualityBeaconExecutor", message);
                }
            } catch (Exception e) {
                Intrinsics.checkNotNullParameter("AdQualityBeaconExecutor", "tag");
                Intrinsics.checkNotNullParameter("exception while cleanup", "message");
                Log.e("AdQualityBeaconExecutor", "exception while cleanup", e);
            }
        }
        return Unit.INSTANCE;
    }
}
