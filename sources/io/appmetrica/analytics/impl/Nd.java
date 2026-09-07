package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.BuildConfig;
import io.appmetrica.analytics.coreutils.internal.executors.BlockingExecutor;
import io.appmetrica.analytics.coreutils.internal.network.UserAgent;
import io.appmetrica.analytics.networktasks.internal.AESRSARequestBodyEncrypter;
import io.appmetrica.analytics.networktasks.internal.AllHostsExponentialBackoffPolicy;
import io.appmetrica.analytics.networktasks.internal.DefaultResponseValidityChecker;
import io.appmetrica.analytics.networktasks.internal.ExponentialBackoffDataHolder;
import io.appmetrica.analytics.networktasks.internal.FullUrlFormer;
import io.appmetrica.analytics.networktasks.internal.NetworkTask;
import io.appmetrica.analytics.networktasks.internal.RequestDataHolder;
import io.appmetrica.analytics.networktasks.internal.ResponseDataHolder;
import java.util.LinkedHashMap;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class Nd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Nd f11267a = new Nd();
    public static final LinkedHashMap b = new LinkedHashMap();
    public static final String c = UserAgent.getFor(BuildConfig.LIBRARY_PACKAGE_NAME, "7.7.2", "50130239");

    public final synchronized ExponentialBackoffDataHolder a(Ld ld) {
        Object exponentialBackoffDataHolder;
        LinkedHashMap linkedHashMap = b;
        exponentialBackoffDataHolder = linkedHashMap.get(ld);
        if (exponentialBackoffDataHolder == null) {
            exponentialBackoffDataHolder = new ExponentialBackoffDataHolder(new Da(C4486ua.E.x(), ld), ld.name());
            linkedHashMap.put(ld, exponentialBackoffDataHolder);
        }
        return (ExponentialBackoffDataHolder) exponentialBackoffDataHolder;
    }

    public static final NetworkTask a(C4282m5 c4282m5) {
        AESRSARequestBodyEncrypter aESRSARequestBodyEncrypter = new AESRSARequestBodyEncrypter();
        Rg rg = new Rg(aESRSARequestBodyEncrypter);
        Db db = new Db(c4282m5);
        return new NetworkTask(new BlockingExecutor(), new E9(c4282m5.f11664a), new AllHostsExponentialBackoffPolicy(f11267a.a(Ld.REPORT)), new C4294mh(c4282m5, rg, db, new FullUrlFormer(rg, db), new RequestDataHolder(), new ResponseDataHolder(new DefaultResponseValidityChecker()), c4282m5.h(), c4282m5.o(), c4282m5.t(), aESRSARequestBodyEncrypter), CollectionsKt.listOf(new Hn()), c);
    }
}
