package com.yandex.div.internal;

import com.json.b9;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KAssert.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0003\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086\bø\u0001\u0000J*\u0010\n\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\b2\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086\bø\u0001\u0000J$\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086\bø\u0001\u0000J\t\u0010\r\u001a\u00020\u0004H\u0086\bJ\t\u0010\u000e\u001a\u00020\u0004H\u0086\bJ&\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086\bø\u0001\u0000J0\u0010\u0011\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086\bø\u0001\u0000J&\u0010\u0012\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086\bø\u0001\u0000J0\u0010\u0013\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086\bø\u0001\u0000J*\u0010\u0014\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\b2\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086\bø\u0001\u0000J$\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086\bø\u0001\u0000J\u001a\u0010\u0015\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086\bø\u0001\u0000J&\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, d2 = {"Lcom/yandex/div/internal/KAssert;", "", "()V", "assertEquals", "", "expected", "actual", "message", "Lkotlin/Function0;", "", "assertFalse", "condition", "", "assertMainThread", "assertNotMainThread", "assertNotNull", "nullable", "assertNotSame", "assertNull", "assertSame", "assertTrue", b9.f.e, "cause", "", "assertion_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class KAssert {
    public static final KAssert INSTANCE = new KAssert();

    private KAssert() {
    }

    public final void fail(Function0<String> message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (Assert.isEnabled()) {
            Assert.fail(message.invoke());
        }
    }

    public static /* synthetic */ void fail$default(KAssert kAssert, Throwable th, Function0 message, int i, Object obj) {
        if ((i & 2) != 0) {
            message = new Function0<String>() { // from class: com.yandex.div.internal.KAssert.fail.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "";
                }
            };
        }
        Intrinsics.checkNotNullParameter(message, "message");
        if (Assert.isEnabled()) {
            Assert.fail((String) message.invoke(), th);
        }
    }

    public final void fail(Throwable cause, Function0<String> message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (Assert.isEnabled()) {
            Assert.fail(message.invoke(), cause);
        }
    }

    public static /* synthetic */ void assertTrue$default(KAssert kAssert, boolean z, Function0 message, int i, Object obj) {
        if ((i & 2) != 0) {
            message = new Function0<String>() { // from class: com.yandex.div.internal.KAssert.assertTrue.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "";
                }
            };
        }
        Intrinsics.checkNotNullParameter(message, "message");
        if (!Assert.isEnabled() || z) {
            return;
        }
        Assert.fail((String) message.invoke());
    }

    public final void assertTrue(boolean condition, Function0<String> message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (!Assert.isEnabled() || condition) {
            return;
        }
        Assert.fail(message.invoke());
    }

    public static /* synthetic */ void assertFalse$default(KAssert kAssert, boolean z, Function0 message, int i, Object obj) {
        if ((i & 2) != 0) {
            message = new Function0<String>() { // from class: com.yandex.div.internal.KAssert.assertFalse.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "";
                }
            };
        }
        Intrinsics.checkNotNullParameter(message, "message");
        if (Assert.isEnabled() && z) {
            Assert.fail((String) message.invoke());
        }
    }

    public final void assertFalse(boolean condition, Function0<String> message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (Assert.isEnabled() && condition) {
            Assert.fail(message.invoke());
        }
    }

    public static /* synthetic */ void assertTrue$default(KAssert kAssert, Function0 condition, Function0 message, int i, Object obj) {
        if ((i & 2) != 0) {
            message = new Function0<String>() { // from class: com.yandex.div.internal.KAssert.assertTrue.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "";
                }
            };
        }
        Intrinsics.checkNotNullParameter(condition, "condition");
        Intrinsics.checkNotNullParameter(message, "message");
        if (!Assert.isEnabled() || ((Boolean) condition.invoke()).booleanValue()) {
            return;
        }
        Assert.fail((String) message.invoke());
    }

    public final void assertTrue(Function0<Boolean> condition, Function0<String> message) {
        Intrinsics.checkNotNullParameter(condition, "condition");
        Intrinsics.checkNotNullParameter(message, "message");
        if (!Assert.isEnabled() || condition.invoke().booleanValue()) {
            return;
        }
        Assert.fail(message.invoke());
    }

    public static /* synthetic */ void assertFalse$default(KAssert kAssert, Function0 condition, Function0 message, int i, Object obj) {
        if ((i & 2) != 0) {
            message = new Function0<String>() { // from class: com.yandex.div.internal.KAssert.assertFalse.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "";
                }
            };
        }
        Intrinsics.checkNotNullParameter(condition, "condition");
        Intrinsics.checkNotNullParameter(message, "message");
        if (Assert.isEnabled() && ((Boolean) condition.invoke()).booleanValue()) {
            Assert.fail((String) message.invoke());
        }
    }

    public final void assertFalse(Function0<Boolean> condition, Function0<String> message) {
        Intrinsics.checkNotNullParameter(condition, "condition");
        Intrinsics.checkNotNullParameter(message, "message");
        if (Assert.isEnabled() && condition.invoke().booleanValue()) {
            Assert.fail(message.invoke());
        }
    }

    public static /* synthetic */ void assertEquals$default(KAssert kAssert, Object obj, Object obj2, Function0 message, int i, Object obj3) {
        if ((i & 4) != 0) {
            message = new Function0<String>() { // from class: com.yandex.div.internal.KAssert.assertEquals.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "";
                }
            };
        }
        Intrinsics.checkNotNullParameter(message, "message");
        if (Assert.isEnabled()) {
            Assert.assertEquals((String) message.invoke(), obj, obj2);
        }
    }

    public final void assertEquals(Object expected, Object actual, Function0<String> message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (Assert.isEnabled()) {
            Assert.assertEquals(message.invoke(), expected, actual);
        }
    }

    public static /* synthetic */ void assertNotNull$default(KAssert kAssert, Object obj, Function0 message, int i, Object obj2) {
        if ((i & 2) != 0) {
            message = new Function0<String>() { // from class: com.yandex.div.internal.KAssert.assertNotNull.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "";
                }
            };
        }
        Intrinsics.checkNotNullParameter(message, "message");
        if (Assert.isEnabled() && obj == null) {
            Assert.fail((String) message.invoke());
        }
    }

    public final void assertNotNull(Object nullable, Function0<String> message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (Assert.isEnabled() && nullable == null) {
            Assert.fail(message.invoke());
        }
    }

    public static /* synthetic */ void assertNull$default(KAssert kAssert, Object obj, Function0 message, int i, Object obj2) {
        if ((i & 2) != 0) {
            message = new Function0<String>() { // from class: com.yandex.div.internal.KAssert.assertNull.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "";
                }
            };
        }
        Intrinsics.checkNotNullParameter(message, "message");
        if (!Assert.isEnabled() || obj == null) {
            return;
        }
        Assert.fail((String) message.invoke());
    }

    public final void assertNull(Object nullable, Function0<String> message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (!Assert.isEnabled() || nullable == null) {
            return;
        }
        Assert.fail(message.invoke());
    }

    public static /* synthetic */ void assertSame$default(KAssert kAssert, Object obj, Object obj2, Function0 message, int i, Object obj3) {
        if ((i & 4) != 0) {
            message = new Function0<String>() { // from class: com.yandex.div.internal.KAssert.assertSame.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "";
                }
            };
        }
        Intrinsics.checkNotNullParameter(message, "message");
        if (Assert.isEnabled()) {
            Assert.assertSame((String) message.invoke(), obj, obj2);
        }
    }

    public final void assertSame(Object expected, Object actual, Function0<String> message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (Assert.isEnabled()) {
            Assert.assertSame(message.invoke(), expected, actual);
        }
    }

    public static /* synthetic */ void assertNotSame$default(KAssert kAssert, Object obj, Object obj2, Function0 message, int i, Object obj3) {
        if ((i & 4) != 0) {
            message = new Function0<String>() { // from class: com.yandex.div.internal.KAssert.assertNotSame.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "";
                }
            };
        }
        Intrinsics.checkNotNullParameter(message, "message");
        if (Assert.isEnabled()) {
            Assert.assertNotSame((String) message.invoke(), obj, obj2);
        }
    }

    public final void assertNotSame(Object expected, Object actual, Function0<String> message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (Assert.isEnabled()) {
            Assert.assertNotSame(message.invoke(), expected, actual);
        }
    }

    public final void assertMainThread() {
        if (Assert.isEnabled()) {
            Assert.assertMainThread();
        }
    }

    public final void assertNotMainThread() {
        if (Assert.isEnabled()) {
            Assert.assertNotMainThread();
        }
    }
}
