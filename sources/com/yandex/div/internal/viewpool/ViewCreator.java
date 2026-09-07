package com.yandex.div.internal.viewpool;

import android.os.Process;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import com.yandex.div.histogram.CpuUsageHistogramReporter;
import com.yandex.div.histogram.util.Cancelable;
import com.yandex.div.internal.util.UtilsKt;
import java.util.Iterator;
import java.util.PriorityQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: ViewCreator.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0003\u0010\u0011\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0000¢\u0006\u0002\b\u000bJ!\u0010\f\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u000fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/yandex/div/internal/viewpool/ViewCreator;", "", "cpuUsageHistogramReporter", "Lcom/yandex/div/histogram/CpuUsageHistogramReporter;", "(Lcom/yandex/div/histogram/CpuUsageHistogramReporter;)V", "creatorThread", "Lcom/yandex/div/internal/viewpool/ViewCreator$ViewCreatorThread;", "promote", "", "channel", "Lcom/yandex/div/internal/viewpool/AdvanceViewPool$Channel;", "promote$div_release", "request", HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, "", "request$div_release", "Companion", "CreateViewTask", "ViewCreatorThread", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ViewCreator {
    private static final String CPU_USAGE_HISTOGRAM_NAME = "Div.ViewPool.CPU";
    private static final Companion Companion = new Companion(null);
    private static final int TASK_HIGHEST_PRIORITY = -1;
    private static final int TASK_QUEUE_INITIAL_CAPACITY = 32;
    private static final int THREAD_DEFAULT_PRIORITY = 5;
    private static final int THREAD_LOW_PRIORITY = 3;
    private final ViewCreatorThread creatorThread;

    public ViewCreator(CpuUsageHistogramReporter cpuUsageHistogramReporter) {
        Intrinsics.checkNotNullParameter(cpuUsageHistogramReporter, "cpuUsageHistogramReporter");
        ViewCreatorThread viewCreatorThread = new ViewCreatorThread("ViewPoolThread", cpuUsageHistogramReporter);
        this.creatorThread = viewCreatorThread;
        viewCreatorThread.start();
    }

    public final void request$div_release(AdvanceViewPool.Channel<?> channel, int priority) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.creatorThread.getTaskQueue().offer(new CreateViewTask(channel, priority));
    }

    public final void promote$div_release(AdvanceViewPool.Channel<?> channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        if (Intrinsics.areEqual(channel.getViewName(), this.creatorThread.getCurrentViewName()) || channel.getNotEmpty()) {
            return;
        }
        BatchBlockingQueue<CreateViewTask> taskQueue = this.creatorThread.getTaskQueue();
        ((BatchBlockingQueue) taskQueue).lock.lock();
        try {
            if (!Intrinsics.areEqual(channel.getViewName(), this.creatorThread.getCurrentViewName()) && !channel.getNotEmpty()) {
                taskQueue = this.creatorThread.getTaskQueue();
                ((BatchBlockingQueue) taskQueue).lock.lock();
                try {
                    Iterator it = ((BatchBlockingQueue) taskQueue).queue.iterator();
                    while (it.hasNext()) {
                        if (Intrinsics.areEqual(((CreateViewTask) it.next()).getViewName(), channel.getViewName())) {
                            it.remove();
                            break;
                        }
                    }
                    ((BatchBlockingQueue) taskQueue).lock.unlock();
                    this.creatorThread.getTaskQueue().offer(new CreateViewTask(channel, -1));
                    Unit unit = Unit.INSTANCE;
                    return;
                } finally {
                    ((BatchBlockingQueue) taskQueue).lock.unlock();
                }
            }
            ((BatchBlockingQueue) taskQueue).lock.unlock();
        } catch (Throwable th) {
            ((BatchBlockingQueue) taskQueue).lock.unlock();
            throw th;
        }
    }

    /* JADX INFO: compiled from: ViewCreator.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001f\u0010\u000b\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/yandex/div/internal/viewpool/ViewCreator$ViewCreatorThread;", "Ljava/lang/Thread;", "name", "", "cpuUsageHistogramReporter", "Lcom/yandex/div/histogram/CpuUsageHistogramReporter;", "(Ljava/lang/String;Lcom/yandex/div/histogram/CpuUsageHistogramReporter;)V", "<set-?>", "currentViewName", "getCurrentViewName", "()Ljava/lang/String;", "taskQueue", "Lcom/yandex/div/internal/viewpool/BatchBlockingQueue;", "Lcom/yandex/div/internal/viewpool/ViewCreator$CreateViewTask;", "kotlin.jvm.PlatformType", "getTaskQueue", "()Lcom/yandex/div/internal/viewpool/BatchBlockingQueue;", "createView", "", "run", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class ViewCreatorThread extends Thread {
        private final CpuUsageHistogramReporter cpuUsageHistogramReporter;
        private volatile String currentViewName;
        private final BatchBlockingQueue<CreateViewTask> taskQueue;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewCreatorThread(String name, CpuUsageHistogramReporter cpuUsageHistogramReporter) {
            super(name);
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(cpuUsageHistogramReporter, "cpuUsageHistogramReporter");
            this.cpuUsageHistogramReporter = cpuUsageHistogramReporter;
            this.taskQueue = new BatchBlockingQueue<>(new PriorityQueue(32));
            setPriority(5);
        }

        public final BatchBlockingQueue<CreateViewTask> getTaskQueue() {
            return this.taskQueue;
        }

        public final String getCurrentViewName() {
            return this.currentViewName;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Cancelable cancelableStartReporting = this.cpuUsageHistogramReporter.startReporting(ViewCreator.CPU_USAGE_HISTOGRAM_NAME, Process.myTid());
            while (true) {
                try {
                    try {
                        createView();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        cancelableStartReporting.cancel();
                        return;
                    }
                } catch (Throwable th) {
                    cancelableStartReporting.cancel();
                    throw th;
                }
            }
        }

        private final void createView() throws InterruptedException {
            CreateViewTask createViewTaskPoll = this.taskQueue.poll();
            if (createViewTaskPoll == null) {
                try {
                    setPriority(3);
                    createViewTaskPoll = this.taskQueue.take();
                    setPriority(5);
                    Intrinsics.checkNotNullExpressionValue(createViewTaskPoll, "run {\n                //…          }\n            }");
                } catch (Throwable th) {
                    setPriority(5);
                    throw th;
                }
            }
            this.currentViewName = createViewTaskPoll.getViewName();
            createViewTaskPoll.run();
            this.currentViewName = null;
        }
    }

    /* JADX INFO: compiled from: ViewCreator.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0019\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R!\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/yandex/div/internal/viewpool/ViewCreator$CreateViewTask;", "Ljava/lang/Runnable;", "", "channel", "Lcom/yandex/div/internal/viewpool/AdvanceViewPool$Channel;", HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, "", "(Lcom/yandex/div/internal/viewpool/AdvanceViewPool$Channel;I)V", "channelRef", "getChannelRef", "()Lcom/yandex/div/internal/viewpool/AdvanceViewPool$Channel;", "channelRef$delegate", "Lkotlin/properties/ReadWriteProperty;", "viewName", "", "getViewName", "()Ljava/lang/String;", "compareTo", "other", "equals", "", "", "hashCode", "run", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class CreateViewTask implements Runnable, Comparable<CreateViewTask> {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(CreateViewTask.class, "channelRef", "getChannelRef()Lcom/yandex/div/internal/viewpool/AdvanceViewPool$Channel;", 0))};

        /* JADX INFO: renamed from: channelRef$delegate, reason: from kotlin metadata */
        private final ReadWriteProperty channelRef;
        private final int priority;
        private final String viewName;

        public CreateViewTask(AdvanceViewPool.Channel<?> channel, int i) {
            Intrinsics.checkNotNullParameter(channel, "channel");
            this.priority = i;
            this.viewName = channel.getViewName();
            this.channelRef = UtilsKt.weak(channel);
        }

        public final String getViewName() {
            return this.viewName;
        }

        private final AdvanceViewPool.Channel<?> getChannelRef() {
            return (AdvanceViewPool.Channel) this.channelRef.getValue(this, $$delegatedProperties[0]);
        }

        @Override // java.lang.Runnable
        public void run() {
            AdvanceViewPool.Channel<?> channelRef = getChannelRef();
            if (channelRef != null) {
                channelRef.createAndEnqueueView();
            }
        }

        @Override // java.lang.Comparable
        public int compareTo(CreateViewTask other) {
            Intrinsics.checkNotNullParameter(other, "other");
            int i = this.priority - other.priority;
            return i != 0 ? i : !Intrinsics.areEqual(this.viewName, other.viewName) ? 1 : 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.yandex.div.internal.viewpool.ViewCreator.CreateViewTask");
            CreateViewTask createViewTask = (CreateViewTask) other;
            return Intrinsics.areEqual(this.viewName, createViewTask.viewName) && this.priority == createViewTask.priority;
        }

        public int hashCode() {
            return ((6913 + this.priority) * 31) + this.viewName.hashCode();
        }
    }

    /* JADX INFO: compiled from: ViewCreator.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/yandex/div/internal/viewpool/ViewCreator$Companion;", "", "()V", "CPU_USAGE_HISTOGRAM_NAME", "", "TASK_HIGHEST_PRIORITY", "", "TASK_QUEUE_INITIAL_CAPACITY", "THREAD_DEFAULT_PRIORITY", "THREAD_LOW_PRIORITY", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
