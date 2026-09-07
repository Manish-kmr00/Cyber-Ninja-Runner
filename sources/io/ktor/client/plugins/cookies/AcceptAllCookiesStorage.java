package io.ktor.client.plugins.cookies;

import com.json.mediationsdk.utils.IronSourceConstants;
import io.ktor.http.Cookie;
import io.ktor.http.Url;
import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.GMTDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: AcceptAllCookiesStorage.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0018\u00002\u00020\u0019B\u0007¢\u0006\u0004\b\u0001\u0010\u0002J#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0096@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u0002J!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f2\u0006\u0010\u0004\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lio/ktor/client/plugins/cookies/AcceptAllCookiesStorage;", "<init>", "()V", "Lio/ktor/http/Url;", IronSourceConstants.REQUEST_URL, "Lio/ktor/http/Cookie;", "cookie", "", "addCookie", "(Lio/ktor/http/Url;Lio/ktor/http/Cookie;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "timestamp", "cleanup", "(J)V", "close", "", "get", "(Lio/ktor/http/Url;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "container", "Ljava/util/List;", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "ktor-client-core", "Lio/ktor/client/plugins/cookies/CookiesStorage;"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AcceptAllCookiesStorage implements CookiesStorage {
    private final List<Cookie> container = new ArrayList();
    private volatile /* synthetic */ long oldestCookie = 0;
    private final Mutex mutex = MutexKt.Mutex$default(false, 1, null);

    /* JADX INFO: renamed from: io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$addCookie$1, reason: invalid class name */
    /* JADX INFO: compiled from: AcceptAllCookiesStorage.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cookies.AcceptAllCookiesStorage", f = "AcceptAllCookiesStorage.kt", i = {0, 0, 0, 0}, l = {66}, m = "addCookie", n = {"this", IronSourceConstants.REQUEST_URL, "cookie", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AcceptAllCookiesStorage.this.addCookie(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$get$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AcceptAllCookiesStorage.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cookies.AcceptAllCookiesStorage", f = "AcceptAllCookiesStorage.kt", i = {0, 0, 0}, l = {66}, m = "get", n = {"this", IronSourceConstants.REQUEST_URL, "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2"})
    static final class C46671 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C46671(Continuation<? super C46671> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AcceptAllCookiesStorage.this.get(null, this);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // io.ktor.client.plugins.cookies.CookiesStorage
    public Object get(Url url, Continuation<? super List<Cookie>> continuation) throws Throwable {
        C46671 c46671;
        AcceptAllCookiesStorage acceptAllCookiesStorage;
        Url url2;
        Mutex mutex;
        if (continuation instanceof C46671) {
            c46671 = (C46671) continuation;
            if ((c46671.label & Integer.MIN_VALUE) != 0) {
                c46671.label -= Integer.MIN_VALUE;
            } else {
                c46671 = new C46671(continuation);
            }
        } else {
            c46671 = new C46671(continuation);
        }
        Object obj = c46671.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c46671.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex mutex2 = this.mutex;
            c46671.L$0 = this;
            c46671.L$1 = url;
            c46671.L$2 = mutex2;
            c46671.label = 1;
            if (mutex2.lock(null, c46671) == coroutine_suspended) {
                return coroutine_suspended;
            }
            acceptAllCookiesStorage = this;
            url2 = url;
            mutex = mutex2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutex = (Mutex) c46671.L$2;
            url2 = (Url) c46671.L$1;
            acceptAllCookiesStorage = (AcceptAllCookiesStorage) c46671.L$0;
            ResultKt.throwOnFailure(obj);
        }
        try {
            long timeMillis = DateJvmKt.getTimeMillis();
            if (timeMillis >= acceptAllCookiesStorage.oldestCookie) {
                acceptAllCookiesStorage.cleanup(timeMillis);
            }
            List<Cookie> list = acceptAllCookiesStorage.container;
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list) {
                if (CookiesStorageKt.matches((Cookie) obj2, url2)) {
                    arrayList.add(obj2);
                }
            }
            return arrayList;
        } finally {
            mutex.unlock(null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // io.ktor.client.plugins.cookies.CookiesStorage
    public Object addCookie(final Url url, final Cookie cookie, Continuation<? super Unit> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Mutex mutex;
        AcceptAllCookiesStorage acceptAllCookiesStorage;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutex = this.mutex;
            anonymousClass1.L$0 = this;
            anonymousClass1.L$1 = url;
            anonymousClass1.L$2 = cookie;
            anonymousClass1.L$3 = mutex;
            anonymousClass1.label = 1;
            if (mutex.lock(null, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            acceptAllCookiesStorage = this;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Mutex mutex2 = (Mutex) anonymousClass1.L$3;
            cookie = (Cookie) anonymousClass1.L$2;
            Url url2 = (Url) anonymousClass1.L$1;
            acceptAllCookiesStorage = (AcceptAllCookiesStorage) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex2;
            url = url2;
        }
        try {
            if (!StringsKt.isBlank(cookie.getName())) {
                CollectionsKt.removeAll((List) acceptAllCookiesStorage.container, (Function1) new Function1<Cookie, Boolean>() { // from class: io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$addCookie$2$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(Cookie it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return Boolean.valueOf(Intrinsics.areEqual(it.getName(), cookie.getName()) && CookiesStorageKt.matches(it, url));
                    }
                });
                acceptAllCookiesStorage.container.add(CookiesStorageKt.fillDefaults(cookie, url));
                GMTDate expires = cookie.getExpires();
                if (expires != null) {
                    long timestamp = expires.getTimestamp();
                    if (acceptAllCookiesStorage.oldestCookie > timestamp) {
                        acceptAllCookiesStorage.oldestCookie = timestamp;
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
            return Unit.INSTANCE;
        } finally {
            mutex.unlock(null);
        }
    }

    private final void cleanup(final long timestamp) {
        CollectionsKt.removeAll((List) this.container, (Function1) new Function1<Cookie, Boolean>() { // from class: io.ktor.client.plugins.cookies.AcceptAllCookiesStorage.cleanup.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Cookie cookie) {
                Intrinsics.checkNotNullParameter(cookie, "cookie");
                GMTDate expires = cookie.getExpires();
                if (expires != null) {
                    return Boolean.valueOf(expires.getTimestamp() < timestamp);
                }
                return false;
            }
        });
        Iterator<T> it = this.container.iterator();
        long jMin = Long.MAX_VALUE;
        while (it.hasNext()) {
            GMTDate expires = ((Cookie) it.next()).getExpires();
            if (expires != null) {
                jMin = Math.min(jMin, expires.getTimestamp());
            }
        }
        this.oldestCookie = jMin;
    }
}
