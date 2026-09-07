package com.yandex.div.internal.viewpool;

import android.view.View;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.Scopes;
import com.json.b9;
import com.yandex.div.core.timer.TimerController;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.util.UtilsKt;
import com.yandex.div.internal.viewpool.optimization.PerformanceDependentSession;
import com.yandex.div.internal.viewpool.optimization.PerformanceDependentSessionProfiler;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AdvanceViewPool.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0017J\u001f\u0010\u0013\u001a\u0002H\u0014\"\b\b\u0000\u0010\u0014*\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000bH\u0017¢\u0006\u0002\u0010\u0015J0\u0010\u0016\u001a\u00020\u000f\"\b\b\u0000\u0010\u0014*\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00182\u0006\u0010\u0019\u001a\u00020\u0012H\u0017J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0017R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\r0\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/yandex/div/internal/viewpool/AdvanceViewPool;", "Lcom/yandex/div/internal/viewpool/ViewPool;", "profiler", "Lcom/yandex/div/internal/viewpool/ViewPoolProfiler;", "sessionProfiler", "Lcom/yandex/div/internal/viewpool/optimization/PerformanceDependentSessionProfiler;", "viewCreator", "Lcom/yandex/div/internal/viewpool/ViewCreator;", "(Lcom/yandex/div/internal/viewpool/ViewPoolProfiler;Lcom/yandex/div/internal/viewpool/optimization/PerformanceDependentSessionProfiler;Lcom/yandex/div/internal/viewpool/ViewCreator;)V", "viewFactories", "", "", "Lcom/yandex/div/internal/viewpool/AdvanceViewPool$Channel;", "Landroid/view/View;", "changeCapacity", "", "tag", "newCapacity", "", "obtain", "T", "(Ljava/lang/String;)Landroid/view/View;", "register", "factory", "Lcom/yandex/div/internal/viewpool/ViewFactory;", "capacity", "unregister", "Channel", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AdvanceViewPool implements ViewPool {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ViewPoolProfiler profiler;
    private final PerformanceDependentSessionProfiler sessionProfiler;
    private final ViewCreator viewCreator;
    private final Map<String, Channel<? extends View>> viewFactories;

    public AdvanceViewPool(ViewPoolProfiler viewPoolProfiler, PerformanceDependentSessionProfiler sessionProfiler, ViewCreator viewCreator) {
        Intrinsics.checkNotNullParameter(sessionProfiler, "sessionProfiler");
        Intrinsics.checkNotNullParameter(viewCreator, "viewCreator");
        this.profiler = viewPoolProfiler;
        this.sessionProfiler = sessionProfiler;
        this.viewCreator = viewCreator;
        this.viewFactories = new ArrayMap();
    }

    @Override // com.yandex.div.internal.viewpool.ViewPool
    public <T extends View> void register(String tag, ViewFactory<T> factory, int capacity) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(factory, "factory");
        synchronized (this.viewFactories) {
            if (this.viewFactories.containsKey(tag)) {
                Assert.fail("Factory is already registered");
            } else {
                this.viewFactories.put(tag, new Channel<>(tag, this.profiler, this.sessionProfiler, factory, this.viewCreator, capacity));
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // com.yandex.div.internal.viewpool.ViewPool
    public void unregister(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        synchronized (this.viewFactories) {
            if (!this.viewFactories.containsKey(tag)) {
                Assert.fail("Factory is not registered");
            } else {
                ((Channel) UtilsKt.removeOrThrow$default(this.viewFactories, tag, null, 2, null)).stop();
            }
        }
    }

    @Override // com.yandex.div.internal.viewpool.ViewPool
    public <T extends View> T obtain(String tag) {
        Channel channel;
        Intrinsics.checkNotNullParameter(tag, "tag");
        synchronized (this.viewFactories) {
            channel = (Channel) UtilsKt.getOrThrow(this.viewFactories, tag, "Factory is not registered");
        }
        T t = (T) channel.createView();
        Intrinsics.checkNotNull(t, "null cannot be cast to non-null type T of com.yandex.div.internal.viewpool.AdvanceViewPool.obtain");
        return t;
    }

    @Override // com.yandex.div.internal.viewpool.ViewPool
    public void changeCapacity(String tag, int newCapacity) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        synchronized (this.viewFactories) {
            Object orThrow = UtilsKt.getOrThrow(this.viewFactories, tag, "Factory is not registered");
            ((Channel) orThrow).setCapacity(newCapacity);
        }
    }

    /* JADX INFO: compiled from: AdvanceViewPool.kt */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u0000 )*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001)B=\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\b\u0010!\u001a\u00020\"H\u0007J\r\u0010#\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010$J\r\u0010%\u001a\u00028\u0000H\u0007¢\u0006\u0002\u0010$J\r\u0010&\u001a\u00028\u0000H\u0003¢\u0006\u0002\u0010$J\b\u0010'\u001a\u00020\"H\u0002J\u0006\u0010(\u001a\u00020\"R\u001a\u0010\u0010\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/yandex/div/internal/viewpool/AdvanceViewPool$Channel;", "T", "Landroid/view/View;", "Lcom/yandex/div/internal/viewpool/ViewFactory;", "viewName", "", "profiler", "Lcom/yandex/div/internal/viewpool/ViewPoolProfiler;", "sessionProfiler", "Lcom/yandex/div/internal/viewpool/optimization/PerformanceDependentSessionProfiler;", "viewFactory", "viewCreator", "Lcom/yandex/div/internal/viewpool/ViewCreator;", "initCapacity", "", "(Ljava/lang/String;Lcom/yandex/div/internal/viewpool/ViewPoolProfiler;Lcom/yandex/div/internal/viewpool/optimization/PerformanceDependentSessionProfiler;Lcom/yandex/div/internal/viewpool/ViewFactory;Lcom/yandex/div/internal/viewpool/ViewCreator;I)V", "capacity", "getCapacity", "()I", "setCapacity", "(I)V", "notEmpty", "", "getNotEmpty", "()Z", "realQueueSize", "Ljava/util/concurrent/atomic/AtomicInteger;", b9.h.h0, "Ljava/util/concurrent/atomic/AtomicBoolean;", "getViewName", "()Ljava/lang/String;", "viewQueue", "Ljava/util/concurrent/BlockingQueue;", "createAndEnqueueView", "", "createView", "()Landroid/view/View;", "extractView", "extractViewBlocked", "requestViewCreation", TimerController.STOP_COMMAND, "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Channel<T extends View> implements ViewFactory<T> {
        private static final long MAX_WAITING_TIME = 16;
        private volatile int capacity;
        private final boolean notEmpty;
        private final ViewPoolProfiler profiler;
        private AtomicInteger realQueueSize;
        private final PerformanceDependentSessionProfiler sessionProfiler;
        private final AtomicBoolean stopped;
        private final ViewCreator viewCreator;
        private final ViewFactory<T> viewFactory;
        private final String viewName;
        private final BlockingQueue<T> viewQueue;

        public Channel(String viewName, ViewPoolProfiler viewPoolProfiler, PerformanceDependentSessionProfiler sessionProfiler, ViewFactory<T> viewFactory, ViewCreator viewCreator, int i) {
            Intrinsics.checkNotNullParameter(viewName, "viewName");
            Intrinsics.checkNotNullParameter(sessionProfiler, "sessionProfiler");
            Intrinsics.checkNotNullParameter(viewFactory, "viewFactory");
            Intrinsics.checkNotNullParameter(viewCreator, "viewCreator");
            this.viewName = viewName;
            this.profiler = viewPoolProfiler;
            this.sessionProfiler = sessionProfiler;
            this.viewFactory = viewFactory;
            this.viewCreator = viewCreator;
            LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
            this.viewQueue = linkedBlockingQueue;
            this.realQueueSize = new AtomicInteger(i);
            this.stopped = new AtomicBoolean(false);
            this.notEmpty = !linkedBlockingQueue.isEmpty();
            this.capacity = i;
            for (int i2 = 0; i2 < i; i2++) {
                this.viewCreator.request$div_release(this, 0);
            }
        }

        public final String getViewName() {
            return this.viewName;
        }

        @Override // com.yandex.div.internal.viewpool.ViewFactory
        public T createView() {
            return (T) extractView();
        }

        public final boolean getNotEmpty() {
            return this.notEmpty;
        }

        public final int getCapacity() {
            return this.capacity;
        }

        public final void setCapacity(int i) {
            this.capacity = i;
        }

        public final T extractView() {
            Companion companion = AdvanceViewPool.INSTANCE;
            long jNanoTime = System.nanoTime();
            Object objPoll = this.viewQueue.poll();
            long jNanoTime2 = System.nanoTime() - jNanoTime;
            if (objPoll == null) {
                Companion companion2 = AdvanceViewPool.INSTANCE;
                long jNanoTime3 = System.nanoTime();
                objPoll = extractViewBlocked();
                long jNanoTime4 = System.nanoTime() - jNanoTime3;
                ViewPoolProfiler viewPoolProfiler = this.profiler;
                if (viewPoolProfiler != null) {
                    viewPoolProfiler.onViewObtainedWithBlock$div_release(this.viewName, jNanoTime4);
                }
                PerformanceDependentSessionProfiler performanceDependentSessionProfiler = this.sessionProfiler;
                String str = this.viewName;
                int size = this.viewQueue.size();
                PerformanceDependentSession performanceDependentSession = performanceDependentSessionProfiler.session;
                if (performanceDependentSession != null) {
                    performanceDependentSession.viewObtained$div_release(str, jNanoTime4, size, true);
                }
            } else {
                this.realQueueSize.decrementAndGet();
                ViewPoolProfiler viewPoolProfiler2 = this.profiler;
                if (viewPoolProfiler2 != null) {
                    viewPoolProfiler2.onViewObtainedWithoutBlock$div_release(jNanoTime2);
                }
                PerformanceDependentSessionProfiler performanceDependentSessionProfiler2 = this.sessionProfiler;
                String str2 = this.viewName;
                int size2 = this.viewQueue.size();
                PerformanceDependentSession performanceDependentSession2 = performanceDependentSessionProfiler2.session;
                if (performanceDependentSession2 != null) {
                    performanceDependentSession2.viewObtained$div_release(str2, jNanoTime2, size2, false);
                }
            }
            requestViewCreation();
            Intrinsics.checkNotNull(objPoll);
            return (T) objPoll;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final T extractViewBlocked() {
            try {
                this.viewCreator.promote$div_release(this);
                T tPoll = this.viewQueue.poll(16L, TimeUnit.MILLISECONDS);
                if (tPoll != null) {
                    this.realQueueSize.decrementAndGet();
                } else {
                    tPoll = (T) this.viewFactory.createView();
                }
                return tPoll;
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return (T) this.viewFactory.createView();
            }
        }

        private final void requestViewCreation() {
            if (this.capacity <= this.realQueueSize.get()) {
                return;
            }
            Companion companion = AdvanceViewPool.INSTANCE;
            long jNanoTime = System.nanoTime();
            this.viewCreator.request$div_release(this, this.viewQueue.size());
            this.realQueueSize.incrementAndGet();
            long jNanoTime2 = System.nanoTime() - jNanoTime;
            ViewPoolProfiler viewPoolProfiler = this.profiler;
            if (viewPoolProfiler != null) {
                viewPoolProfiler.onViewRequested$div_release(jNanoTime2);
            }
        }

        public final void createAndEnqueueView() {
            if (this.stopped.get()) {
                return;
            }
            try {
                this.viewQueue.offer((T) this.viewFactory.createView());
            } catch (Exception unused) {
            }
        }

        public final void stop() {
            this.stopped.set(true);
            this.viewQueue.clear();
        }
    }

    /* JADX INFO: compiled from: AdvanceViewPool.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u00020\u00042\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0082\b¨\u0006\b"}, d2 = {"Lcom/yandex/div/internal/viewpool/AdvanceViewPool$Companion;", "", "()V", Scopes.PROFILE, "", "section", "Lkotlin/Function0;", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final long profile(Function0<Unit> section) {
            long jNanoTime = System.nanoTime();
            section.invoke();
            return System.nanoTime() - jNanoTime;
        }
    }
}
