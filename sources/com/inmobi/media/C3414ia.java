package com.inmobi.media;

import android.content.Context;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.inmobi.media.ia, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3414ia {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3340a;
    public final long b;
    public final int c;
    public boolean d;
    public final C3424j6 e;
    public final C3443kb f;
    public final List g;
    public final ConcurrentHashMap h;
    public final AtomicBoolean i;
    public String j;
    public final AtomicInteger k;

    public C3414ia(Context context, double d, EnumC3396h6 logLevel, long j, int i, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        this.f3340a = context;
        this.b = j;
        this.c = i;
        this.d = z;
        this.e = new C3424j6(logLevel);
        this.f = new C3443kb(d);
        this.g = Collections.synchronizedList(new ArrayList());
        this.h = new ConcurrentHashMap();
        this.i = new AtomicBoolean(false);
        this.j = "";
        this.k = new AtomicInteger(0);
    }

    public final void a(final EnumC3396h6 logLevel, String tag, String message) throws JSONException {
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        if (this.i.get()) {
            return;
        }
        SimpleDateFormat simpleDateFormat = AbstractC3438k6.f3358a;
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        final JSONObject jSONObject = new JSONObject();
        jSONObject.put("scope", logLevel.name());
        jSONObject.put("timestamp", AbstractC3438k6.f3358a.format(new Date()));
        jSONObject.put("tag", tag);
        jSONObject.put("data", message);
        ScheduledExecutorService scheduledExecutorService = AbstractC3554s6.f3426a;
        Runnable runnable = new Runnable() { // from class: com.inmobi.media.ia$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                C3414ia.a(this.f$0, logLevel, jSONObject);
            }
        };
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        AbstractC3554s6.f3426a.submit(runnable);
    }

    public final void b() {
        Objects.toString(this.i);
        if ((this.d || this.f.a()) && !this.i.getAndSet(true)) {
            ScheduledExecutorService scheduledExecutorService = AbstractC3554s6.f3426a;
            Runnable runnable = new Runnable() { // from class: com.inmobi.media.ia$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C3414ia.b(this.f$0);
                }
            };
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            AbstractC3554s6.f3426a.submit(runnable);
        }
    }

    public final String c() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        synchronized (this.h) {
            for (Map.Entry entry : this.h.entrySet()) {
                jSONObject2.put((String) entry.getKey(), entry.getValue());
            }
            Unit unit = Unit.INSTANCE;
        }
        jSONObject.put("vitals", jSONObject2);
        jSONObject.put(CreativeInfo.f, d());
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final JSONArray d() {
        JSONArray jSONArray = new JSONArray();
        List logData = this.g;
        Intrinsics.checkNotNullExpressionValue(logData, "logData");
        synchronized (logData) {
            List logData2 = this.g;
            Intrinsics.checkNotNullExpressionValue(logData2, "logData");
            Iterator it = logData2.iterator();
            while (it.hasNext()) {
                jSONArray.put((JSONObject) it.next());
            }
            Unit unit = Unit.INSTANCE;
        }
        return jSONArray;
    }

    public static final void b(C3414ia this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Objects.toString(this$0.i);
        ScheduledExecutorService scheduledExecutorService = AbstractC3554s6.f3426a;
        if (Result.m7907exceptionOrNullimpl(AbstractC3539r6.a(new C3400ha(this$0, true))) != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Result.m7904constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
        }
    }

    public static final void a(C3414ia this$0, EnumC3396h6 eventLogLevel, JSONObject data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(eventLogLevel, "$logLevel");
        Intrinsics.checkNotNullParameter(data, "$data");
        try {
            C3424j6 c3424j6 = this$0.e;
            c3424j6.getClass();
            Intrinsics.checkNotNullParameter(eventLogLevel, "eventLogLevel");
            int iOrdinal = c3424j6.f3346a.ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal != 1) {
                    if (iOrdinal != 2) {
                        if (iOrdinal != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        if (eventLogLevel != EnumC3396h6.STATE) {
                            return;
                        }
                    } else if (eventLogLevel != EnumC3396h6.ERROR && eventLogLevel != EnumC3396h6.STATE) {
                        return;
                    }
                } else if (eventLogLevel != EnumC3396h6.DEBUG && eventLogLevel != EnumC3396h6.ERROR && eventLogLevel != EnumC3396h6.STATE) {
                    return;
                }
            }
            this$0.g.add(data);
        } catch (Exception e) {
            this$0.getClass();
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
        }
    }

    public final void a() {
        Objects.toString(this.i);
        if ((this.d || this.f.a()) && !this.i.get()) {
            ScheduledExecutorService scheduledExecutorService = AbstractC3554s6.f3426a;
            Runnable runnable = new Runnable() { // from class: com.inmobi.media.ia$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    C3414ia.a(this.f$0);
                }
            };
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            AbstractC3554s6.f3426a.submit(runnable);
        }
    }

    public static final void a(C3414ia this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.k.getAndIncrement();
        Objects.toString(this$0.i);
        ScheduledExecutorService scheduledExecutorService = AbstractC3554s6.f3426a;
        if (Result.m7907exceptionOrNullimpl(AbstractC3539r6.a(new C3400ha(this$0, false))) != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Result.m7904constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
        }
    }
}
