package com.moloco.sdk.acm.eventprocessing;

import android.content.Context;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import java.util.concurrent.TimeUnit;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.acm.a f6022a;
    public final Context b;

    public d(com.moloco.sdk.acm.a config, Context context) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(context, "context");
        this.f6022a = config;
        this.b = context;
    }

    @Override // com.moloco.sdk.acm.eventprocessing.c
    public void a() throws Throwable {
        Constraints constraintsBuild = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
        Data dataA = e.a(MapsKt.mapOf(TuplesKt.to("url", this.f6022a.g()), TuplesKt.to(com.moloco.sdk.acm.b.e, this.f6022a.f().get(com.moloco.sdk.acm.b.e)), TuplesKt.to(com.moloco.sdk.acm.b.f, this.f6022a.f().get(com.moloco.sdk.acm.b.f)), TuplesKt.to(com.moloco.sdk.acm.b.g, this.f6022a.f().get(com.moloco.sdk.acm.b.g)), TuplesKt.to(com.moloco.sdk.acm.b.d, this.f6022a.f().get(com.moloco.sdk.acm.b.d)), TuplesKt.to("osv", this.f6022a.f().get("osv")), TuplesKt.to(com.moloco.sdk.acm.b.h, this.f6022a.f().get(com.moloco.sdk.acm.b.h)), TuplesKt.to(com.moloco.sdk.acm.b.b, this.f6022a.f().get(com.moloco.sdk.acm.b.b))));
        if (dataA == null) {
            return;
        }
        WorkManager.getInstance(this.b).enqueue(new OneTimeWorkRequest.Builder(DBRequestWorker.class).setConstraints(constraintsBuild).setInputData(dataA).setBackoffCriteria(BackoffPolicy.EXPONENTIAL, 10000L, TimeUnit.MILLISECONDS).build());
    }
}
