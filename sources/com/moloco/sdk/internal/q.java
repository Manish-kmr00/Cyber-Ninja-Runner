package com.moloco.sdk.internal;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

/* JADX INFO: loaded from: classes4.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f6291a = LazyKt.lazy(a.f6292a);

    public static final class a extends Lambda implements Function0<Json> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6292a = new a();

        /* JADX INFO: renamed from: com.moloco.sdk.internal.q$a$a, reason: collision with other inner class name */
        public static final class C0556a extends Lambda implements Function1<JsonBuilder, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0556a f6293a = new C0556a();

            public C0556a() {
                super(1);
            }

            public final void a(JsonBuilder Json) {
                Intrinsics.checkNotNullParameter(Json, "$this$Json");
                Json.setLenient(true);
                Json.setIgnoreUnknownKeys(true);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
                a(jsonBuilder);
                return Unit.INSTANCE;
            }
        }

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Json invoke() {
            return JsonKt.Json$default(null, C0556a.f6293a, 1, null);
        }
    }

    public static final Json a() {
        return b();
    }

    public static final Json b() {
        return (Json) f6291a.getValue();
    }
}
