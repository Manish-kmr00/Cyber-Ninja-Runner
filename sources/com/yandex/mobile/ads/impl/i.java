package com.yandex.mobile.ads.impl;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes9.dex */
public abstract class i<V> extends np0 implements Future {
    private static final boolean e;
    private static final Logger f;
    private static final a g;
    private static final Object h;

    @CheckForNull
    private volatile Object b;

    @CheckForNull
    private volatile d c;

    @CheckForNull
    private volatile C0748i d;

    static abstract class h<V> extends i<V> implements Future {
        @Override // com.yandex.mobile.ads.impl.i, java.util.concurrent.Future
        public final boolean isCancelled() {
            return ((i) this).b instanceof b;
        }

        h() {
        }

        @Override // com.yandex.mobile.ads.impl.i, java.util.concurrent.Future
        public V get() throws ExecutionException, InterruptedException {
            return (V) super.get();
        }

        @Override // com.yandex.mobile.ads.impl.i, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }

        @Override // com.yandex.mobile.ads.impl.i, java.util.concurrent.Future
        public final boolean cancel(boolean z) {
            return super.cancel(z);
        }

        @Override // com.yandex.mobile.ads.impl.i, java.util.concurrent.Future
        public final V get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
            return (V) super.get(j, timeUnit);
        }
    }

    static {
        boolean z;
        a gVar;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        e = z;
        f = Logger.getLogger(i.class.getName());
        Throwable th = null;
        byte b2 = 0;
        try {
            gVar = new e(AtomicReferenceFieldUpdater.newUpdater(C0748i.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(C0748i.class, C0748i.class, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B), AtomicReferenceFieldUpdater.newUpdater(i.class, C0748i.class, "d"), AtomicReferenceFieldUpdater.newUpdater(i.class, d.class, ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM), AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B));
        } catch (Throwable th2) {
            gVar = new g();
            th = th2;
        }
        g = gVar;
        if (th != null) {
            f.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        h = new Object();
    }

    private void a(StringBuilder sb) {
        V v;
        boolean z = false;
        while (true) {
            try {
                try {
                    v = get();
                    break;
                } catch (CancellationException unused) {
                    sb.append("CANCELLED");
                    return;
                } catch (RuntimeException e2) {
                    sb.append("UNKNOWN, cause=[").append(e2.getClass()).append(" thrown from get()]");
                    return;
                } catch (ExecutionException e3) {
                    sb.append("FAILURE, cause=[").append(e3.getCause()).append(com.ironsource.b9.i.e);
                    return;
                }
            } catch (InterruptedException unused2) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        sb.append("SUCCESS, result=[");
        a(sb, v);
        sb.append(com.ironsource.b9.i.e);
    }

    protected boolean b(V v) {
        if (!g.a((i<?>) this, (Object) null, (Object) v)) {
            return false;
        }
        a((i<?>) this);
        return true;
    }

    /* JADX INFO: renamed from: com.yandex.mobile.ads.impl.i$i, reason: collision with other inner class name */
    private static final class C0748i {
        static final C0748i c = new C0748i(0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        volatile Thread f9155a;

        @CheckForNull
        volatile C0748i b;

        C0748i() {
            i.g.a(this, Thread.currentThread());
        }

        C0748i(int i) {
        }
    }

    private static final class d {
        static final d b = new d();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        d f9153a;

        d() {
        }
    }

    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Throwable f9152a;

        final class a extends Throwable {
            @Override // java.lang.Throwable
            public final synchronized Throwable fillInStackTrace() {
                return this;
            }

            a() {
                super("Failure occurred while trying to finish a future.");
            }
        }

        static {
            new c(new a());
        }

        c(Throwable th) {
            this.f9152a = (Throwable) rj1.a(th);
        }
    }

    private static final class b {

        @CheckForNull
        static final b b;

        @CheckForNull
        static final b c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        final Throwable f9151a;

        static {
            if (i.e) {
                c = null;
                b = null;
            } else {
                c = new b(false, null);
                b = new b(true, null);
            }
        }

        b(boolean z, @CheckForNull Throwable th) {
            this.f9151a = th;
        }
    }

    private static final class f<V> implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    protected i() {
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j);
        if (!Thread.interrupted()) {
            Object obj = this.b;
            if ((obj != null) & (!(obj instanceof f))) {
                return (V) a(obj);
            }
            long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                C0748i c0748i = this.d;
                if (c0748i != C0748i.c) {
                    C0748i c0748i2 = new C0748i();
                    while (true) {
                        a aVar = g;
                        aVar.a(c0748i2, c0748i);
                        if (aVar.a((i<?>) this, c0748i, c0748i2)) {
                            do {
                                LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.b;
                                    if ((obj2 != null) & (!(obj2 instanceof f))) {
                                        return (V) a(obj2);
                                    }
                                    nanos = jNanoTime - System.nanoTime();
                                } else {
                                    a(c0748i2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            a(c0748i2);
                            break;
                        }
                        c0748i = this.d;
                        if (c0748i == C0748i.c) {
                        }
                    }
                }
                return (V) a(Objects.requireNonNull(this.b));
            }
            while (nanos > 0) {
                Object obj3 = this.b;
                if ((obj3 != null) & (!(obj3 instanceof f))) {
                    return (V) a(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = jNanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String string = toString();
            String string2 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = string2.toLowerCase(locale);
            String str = "Waited " + j + " " + timeUnit.toString().toLowerCase(locale);
            if (nanos + 1000 < 0) {
                String str2 = str + " (plus ";
                long j2 = -nanos;
                long jConvert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
                long nanos2 = j2 - timeUnit.toNanos(jConvert);
                boolean z = jConvert == 0 || nanos2 > 1000;
                if (jConvert > 0) {
                    String str3 = str2 + jConvert + " " + lowerCase;
                    if (z) {
                        str3 = str3 + StringUtils.COMMA;
                    }
                    str2 = str3 + " ";
                }
                if (z) {
                    str2 = str2 + nanos2 + " nanoseconds ";
                }
                str = str2 + "delay)";
            }
            if (isDone()) {
                throw new TimeoutException(str + " but future completed as timeout expired");
            }
            throw new TimeoutException(str + " for " + string);
        }
        throw new InterruptedException();
    }

    @Override // java.util.concurrent.Future
    public V get() throws ExecutionException, InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.b;
            if ((obj2 != null) & (!(obj2 instanceof f))) {
                return (V) a(obj2);
            }
            C0748i c0748i = this.d;
            if (c0748i != C0748i.c) {
                C0748i c0748i2 = new C0748i();
                do {
                    a aVar = g;
                    aVar.a(c0748i2, c0748i);
                    if (aVar.a((i<?>) this, c0748i, c0748i2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.b;
                            } else {
                                a(c0748i2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof f))));
                        return (V) a(obj);
                    }
                    c0748i = this.d;
                } while (c0748i != C0748i.c);
            }
            return (V) a(Objects.requireNonNull(this.b));
        }
        throw new InterruptedException();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        Object obj = this.b;
        return (!(obj instanceof f)) & (obj != null);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.b instanceof b;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        b bVar;
        Object objRequireNonNull;
        Object obj = this.b;
        if ((obj == null) | (obj instanceof f)) {
            if (e) {
                objRequireNonNull = new b(z, new CancellationException("Future.cancel() was called."));
            } else {
                if (z) {
                    bVar = b.b;
                } else {
                    bVar = b.c;
                }
                objRequireNonNull = Objects.requireNonNull(bVar);
            }
            while (!g.a((i<?>) this, obj, objRequireNonNull)) {
                obj = this.b;
                if (!(obj instanceof f)) {
                }
            }
            a((i<?>) this);
            if (!(obj instanceof f)) {
                return true;
            }
            ((f) obj).getClass();
            throw null;
        }
        return false;
    }

    public final String toString() {
        String strA;
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@').append(Integer.toHexString(System.identityHashCode(this))).append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            int length = sb.length();
            sb.append("PENDING");
            Object obj = this.b;
            if (obj instanceof f) {
                sb.append(", setFuture=[");
                ((f) obj).getClass();
                try {
                    sb.append((Object) null);
                } catch (RuntimeException | StackOverflowError e2) {
                    sb.append("Exception thrown from implementation: ").append(e2.getClass());
                }
                sb.append(com.ironsource.b9.i.e);
            } else {
                try {
                    strA = b32.a(a());
                } catch (RuntimeException | StackOverflowError e3) {
                    strA = "Exception thrown from implementation: " + e3.getClass();
                }
                if (strA != null) {
                    sb.append(", info=[").append(strA).append(com.ironsource.b9.i.e);
                }
            }
            if (isDone()) {
                sb.delete(length, sb.length());
                a(sb);
            }
        }
        return sb.append(com.ironsource.b9.i.e).toString();
    }

    private void a(StringBuilder sb, @CheckForNull Object obj) {
        if (obj == null) {
            sb.append("null");
        } else if (obj == this) {
            sb.append("this future");
        } else {
            sb.append(obj.getClass().getName()).append("@").append(Integer.toHexString(System.identityHashCode(obj)));
        }
    }

    private static void a(i<?> iVar) {
        C0748i c0748i;
        d dVar;
        do {
            c0748i = ((i) iVar).d;
        } while (!g.a(iVar, c0748i, C0748i.c));
        while (c0748i != null) {
            Thread thread = c0748i.f9155a;
            if (thread != null) {
                c0748i.f9155a = null;
                LockSupport.unpark(thread);
            }
            c0748i = c0748i.b;
        }
        do {
            dVar = ((i) iVar).c;
        } while (!g.a(iVar, dVar, d.b));
        d dVar2 = null;
        while (dVar != null) {
            d dVar3 = dVar.f9153a;
            dVar.f9153a = dVar2;
            dVar2 = dVar;
            dVar = dVar3;
        }
        if (dVar2 != null) {
            throw null;
        }
    }

    private static Object a(Object obj) throws ExecutionException {
        if (!(obj instanceof b)) {
            if (!(obj instanceof c)) {
                if (obj == h) {
                    return null;
                }
                return obj;
            }
            throw new ExecutionException(((c) obj).f9152a);
        }
        Throwable th = ((b) obj).f9151a;
        CancellationException cancellationException = new CancellationException("Task was cancelled.");
        cancellationException.initCause(th);
        throw cancellationException;
    }

    private static abstract class a {
        abstract void a(C0748i c0748i, @CheckForNull C0748i c0748i2);

        abstract void a(C0748i c0748i, Thread thread);

        abstract boolean a(i<?> iVar, @CheckForNull d dVar, d dVar2);

        abstract boolean a(i<?> iVar, @CheckForNull C0748i c0748i, @CheckForNull C0748i c0748i2);

        abstract boolean a(i<?> iVar, @CheckForNull Object obj, Object obj2);

        private a() {
        }
    }

    private static final class e extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<C0748i, Thread> f9154a;
        final AtomicReferenceFieldUpdater<C0748i, C0748i> b;
        final AtomicReferenceFieldUpdater<i, C0748i> c;
        final AtomicReferenceFieldUpdater<i, d> d;
        final AtomicReferenceFieldUpdater<i, Object> e;

        e(AtomicReferenceFieldUpdater<C0748i, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<C0748i, C0748i> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<i, C0748i> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<i, d> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<i, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f9154a = atomicReferenceFieldUpdater;
            this.b = atomicReferenceFieldUpdater2;
            this.c = atomicReferenceFieldUpdater3;
            this.d = atomicReferenceFieldUpdater4;
            this.e = atomicReferenceFieldUpdater5;
        }

        @Override // com.yandex.mobile.ads.impl.i.a
        final boolean a(i<?> iVar, @CheckForNull d dVar, d dVar2) {
            return AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(this.d, iVar, dVar, dVar2);
        }

        @Override // com.yandex.mobile.ads.impl.i.a
        final boolean a(i<?> iVar, @CheckForNull Object obj, Object obj2) {
            return AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(this.e, iVar, obj, obj2);
        }

        @Override // com.yandex.mobile.ads.impl.i.a
        final boolean a(i<?> iVar, @CheckForNull C0748i c0748i, @CheckForNull C0748i c0748i2) {
            return AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(this.c, iVar, c0748i, c0748i2);
        }

        @Override // com.yandex.mobile.ads.impl.i.a
        final void a(C0748i c0748i, @CheckForNull C0748i c0748i2) {
            this.b.lazySet(c0748i, c0748i2);
        }

        @Override // com.yandex.mobile.ads.impl.i.a
        final void a(C0748i c0748i, Thread thread) {
            this.f9154a.lazySet(c0748i, thread);
        }
    }

    private static final class g extends a {
        private g() {
            super();
        }

        @Override // com.yandex.mobile.ads.impl.i.a
        final boolean a(i<?> iVar, @CheckForNull d dVar, d dVar2) {
            synchronized (iVar) {
                if (((i) iVar).c != dVar) {
                    return false;
                }
                ((i) iVar).c = dVar2;
                return true;
            }
        }

        @Override // com.yandex.mobile.ads.impl.i.a
        final boolean a(i<?> iVar, @CheckForNull Object obj, Object obj2) {
            synchronized (iVar) {
                if (((i) iVar).b != obj) {
                    return false;
                }
                ((i) iVar).b = obj2;
                return true;
            }
        }

        @Override // com.yandex.mobile.ads.impl.i.a
        final boolean a(i<?> iVar, @CheckForNull C0748i c0748i, @CheckForNull C0748i c0748i2) {
            synchronized (iVar) {
                if (((i) iVar).d != c0748i) {
                    return false;
                }
                ((i) iVar).d = c0748i2;
                return true;
            }
        }

        @Override // com.yandex.mobile.ads.impl.i.a
        final void a(C0748i c0748i, @CheckForNull C0748i c0748i2) {
            c0748i.b = c0748i2;
        }

        @Override // com.yandex.mobile.ads.impl.i.a
        final void a(C0748i c0748i, Thread thread) {
            c0748i.f9155a = thread;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckForNull
    protected final String a() {
        if (this instanceof ScheduledFuture) {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        }
        return null;
    }

    private void a(C0748i c0748i) {
        c0748i.f9155a = null;
        while (true) {
            C0748i c0748i2 = this.d;
            if (c0748i2 == C0748i.c) {
                return;
            }
            C0748i c0748i3 = null;
            while (c0748i2 != null) {
                C0748i c0748i4 = c0748i2.b;
                if (c0748i2.f9155a != null) {
                    c0748i3 = c0748i2;
                } else if (c0748i3 != null) {
                    c0748i3.b = c0748i4;
                    if (c0748i3.f9155a == null) {
                    }
                } else if (!g.a((i<?>) this, c0748i2, c0748i4)) {
                }
                c0748i2 = c0748i4;
            }
            return;
        }
    }

    protected boolean a(Throwable th) {
        if (!g.a((i<?>) this, (Object) null, (Object) new c(th))) {
            return false;
        }
        a((i<?>) this);
        return true;
    }
}
