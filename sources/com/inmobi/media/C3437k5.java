package com.inmobi.media;

import com.applovin.impl.sdk.utils.JsonUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.inmobi.media.k5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3437k5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3357a;

    public C3437k5(long j) {
        this.f3357a = j;
    }

    public final void a(final String message, final String exitData, final int i, final long j) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(exitData, "exitData");
        ScheduledExecutorService scheduledExecutorService = AbstractC3554s6.f3426a;
        Runnable runnable = new Runnable() { // from class: com.inmobi.media.k5$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                C3437k5.a(this.f$0, j, message, i, exitData);
            }
        };
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        AbstractC3554s6.f3426a.submit(runnable);
    }

    public static final void a(C3437k5 c3437k5, long j, String message, int i, String exitData) throws JSONException {
        Object objM7904constructorimpl;
        Object objM7904constructorimpl2;
        C3437k5 this$0 = c3437k5;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(message, "$message");
        Intrinsics.checkNotNullParameter(exitData, "$exitData");
        ArrayList arrayList = new ArrayList();
        CopyOnWriteArrayList copyOnWriteArrayList = P4.f3165a;
        ArrayList arrayList2 = new ArrayList();
        C3409i5 c3409i5 = new C3409i5();
        ArrayList arrayList3 = new ArrayList();
        C3382g6 c3382g6D = AbstractC3415ib.d();
        ArrayList arrayListA = D1.a(c3382g6D, "hasLoggerFinished=0", null, null, null, null, Integer.valueOf(D1.a((D1) c3382g6D)), 30);
        C3395h5 action = new C3395h5(c3409i5, arrayList3);
        Intrinsics.checkNotNullParameter(arrayListA, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        Iterator it = CollectionsKt.filterNotNull(arrayListA).iterator();
        while (it.hasNext()) {
            action.invoke(it.next());
        }
        N4 action2 = new N4(arrayList2);
        Intrinsics.checkNotNullParameter(arrayList3, "<this>");
        Intrinsics.checkNotNullParameter(action2, "action");
        Iterator it2 = CollectionsKt.filterNotNull(arrayList3).iterator();
        while (it2.hasNext()) {
            action2.invoke(it2.next());
        }
        arrayList.addAll(arrayList2);
        Iterator it3 = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
        while (it3.hasNext()) {
            Object next = it3.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            C3483n5 c3483n5 = (C3483n5) next;
            c3437k5.getClass();
            long j2 = c3483n5.f3381a.c.b;
            if (j >= j2 && j - j2 <= this$0.f3357a) {
                String message2 = "Message - " + message + ", Reason - " + i + ", Timestamp - " + j + ", Data - " + exitData;
                Intrinsics.checkNotNullParameter("IncompleteLogFinalizer", "tag");
                Intrinsics.checkNotNullParameter(message2, "message");
                try {
                    JSONArray jSONArray = c3483n5.f3381a.b;
                    EnumC3396h6 logLevel = EnumC3396h6.ERROR;
                    SimpleDateFormat simpleDateFormat = AbstractC3438k6.f3358a;
                    Intrinsics.checkNotNullParameter(logLevel, "logLevel");
                    Intrinsics.checkNotNullParameter("IncompleteLogFinalizer", "tag");
                    Intrinsics.checkNotNullParameter(message2, "message");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("scope", "ERROR");
                    jSONObject.put("timestamp", AbstractC3438k6.f3358a.format(new Date()));
                    jSONObject.put("tag", "IncompleteLogFinalizer");
                    jSONObject.put("data", message2);
                    jSONArray.put(jSONObject);
                } catch (Exception unused) {
                }
                String value = String.valueOf(i);
                Intrinsics.checkNotNullParameter("IncompleteLogFinalizer", "tag");
                Intrinsics.checkNotNullParameter("exitReason", "key");
                Intrinsics.checkNotNullParameter(value, "value");
                try {
                    c3483n5.f3381a.f3345a.put("exitReason", value);
                } catch (Exception unused2) {
                }
                Intrinsics.checkNotNullParameter("IncompleteLogFinalizer", "tag");
                try {
                    Result.Companion companion = Result.INSTANCE;
                    JSONObject jSONObject2 = c3483n5.f3381a.f3345a;
                    Intrinsics.checkNotNullParameter(jSONObject2, "<this>");
                    if (!Intrinsics.areEqual(jSONObject2.toString(), JsonUtils.EMPTY_JSON) && !AbstractC3420j2.a(c3483n5.f3381a.b)) {
                        ScheduledExecutorService scheduledExecutorService = AbstractC3554s6.f3426a;
                        AbstractC3539r6.a(new C3467m5(c3483n5));
                    }
                    objM7904constructorimpl = Result.m7904constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
                }
                Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
                if (thM7907exceptionOrNullimpl != null) {
                    try {
                        Result.Companion companion3 = Result.INSTANCE;
                        P1 event = new P1(thM7907exceptionOrNullimpl);
                        C3339d5 c3339d5 = C3339d5.f3292a;
                        Intrinsics.checkNotNullParameter(event, "event");
                        C3339d5.c.a(event);
                        try {
                            ScheduledExecutorService scheduledExecutorService2 = AbstractC3554s6.f3426a;
                            objM7904constructorimpl2 = Result.m7904constructorimpl(Result.m7903boximpl(AbstractC3539r6.a(new C3453l5(c3483n5))));
                        } catch (Throwable th2) {
                            Result.Companion companion4 = Result.INSTANCE;
                            objM7904constructorimpl2 = Result.m7904constructorimpl(ResultKt.createFailure(th2));
                        }
                        Throwable thM7907exceptionOrNullimpl2 = Result.m7907exceptionOrNullimpl(objM7904constructorimpl2);
                        if (thM7907exceptionOrNullimpl2 != null) {
                            try {
                                Result.Companion companion5 = Result.INSTANCE;
                                P1 event2 = new P1(thM7907exceptionOrNullimpl2);
                                C3339d5 c3339d6 = C3339d5.f3292a;
                                Intrinsics.checkNotNullParameter(event2, "event");
                                C3339d5.c.a(event2);
                                objM7904constructorimpl2 = Result.m7904constructorimpl(Unit.INSTANCE);
                            } catch (Throwable th3) {
                                Result.Companion companion6 = Result.INSTANCE;
                                objM7904constructorimpl2 = Result.m7904constructorimpl(ResultKt.createFailure(th3));
                            }
                        }
                        Result.m7904constructorimpl(Result.m7903boximpl(objM7904constructorimpl2));
                    } catch (Throwable th4) {
                        Result.Companion companion7 = Result.INSTANCE;
                        Result.m7904constructorimpl(ResultKt.createFailure(th4));
                    }
                }
            }
            this$0 = c3437k5;
        }
    }
}
