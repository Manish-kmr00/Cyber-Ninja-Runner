package com.yandex.yatagan.internal;

import com.yandex.yatagan.ThreadAsserter;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: compiled from: ThreadAssertions.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/yandex/yatagan/internal/ThreadAssertions;", "", "()V", "asserter", "Lcom/yandex/yatagan/ThreadAsserter;", "assertThreadAccess", "", "setAsserter", "public"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ThreadAssertions {
    public static final ThreadAssertions INSTANCE = new ThreadAssertions();
    private static volatile ThreadAsserter asserter;

    private ThreadAssertions() {
    }

    @JvmStatic
    public static final void setAsserter(ThreadAsserter asserter2) {
        asserter = asserter2;
    }

    @JvmStatic
    public static final void assertThreadAccess() {
        ThreadAsserter threadAsserter = asserter;
        if (threadAsserter != null) {
            threadAsserter.assertThreadAccess();
        }
    }
}
