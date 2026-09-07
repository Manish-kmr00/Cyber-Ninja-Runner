package com.inmobi.media;

import android.database.sqlite.SQLiteException;
import android.util.Log;
import com.inmobi.adquality.models.AdQualityResult;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.da, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3344da implements InterfaceC3291a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AdQualityResult f3295a;

    public C3344da(AdQualityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.f3295a = result;
    }

    @Override // com.inmobi.media.InterfaceC3291a0
    public final Object a() {
        boolean z;
        try {
            ScheduledExecutorService scheduledExecutorService = P.f3162a;
            ((Q) AbstractC3415ib.f3341a.getValue()).a(this.f3295a);
            z = true;
        } catch (SQLiteException e) {
            Intrinsics.checkNotNullParameter("QueueProcess", "tag");
            Intrinsics.checkNotNullParameter("failed to queue the result", "message");
            Log.e("QueueProcess", "failed to queue the result", e);
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
