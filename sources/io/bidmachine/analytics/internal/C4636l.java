package io.bidmachine.analytics.internal;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: io.bidmachine.analytics.internal.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C4636l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f12110a = LazyKt.lazy(a.f12111a);
    private final Lazy b = LazyKt.lazy(b.f12112a);

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.l$a */
    static final class a extends Lambda implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f12111a = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final J invoke() {
            return new J(0, 1, null);
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.l$b */
    static final class b extends Lambda implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f12112a = new b();

        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e0 invoke() {
            return new e0();
        }
    }

    public final J a() {
        return (J) this.f12110a.getValue();
    }

    public final e0 b() {
        return (e0) this.b.getValue();
    }
}
