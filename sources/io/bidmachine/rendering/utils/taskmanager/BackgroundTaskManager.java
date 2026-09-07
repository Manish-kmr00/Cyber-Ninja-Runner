package io.bidmachine.rendering.utils.taskmanager;

import io.bidmachine.rendering.internal.m;
import io.bidmachine.rendering.utils.concurrent.ExecutorConfigurator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes10.dex */
public class BackgroundTaskManager extends BaseTaskManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ScheduledThreadPoolExecutor f12440a;
    private final Map b;

    private class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Runnable f12441a;

        public a(Runnable runnable) {
            this.f12441a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                BackgroundTaskManager.this.a(this.f12441a);
                this.f12441a.run();
            } catch (Exception e) {
                m.b(e);
            }
        }
    }

    public BackgroundTaskManager() {
        ExecutorConfigurator executorConfigurator = new ExecutorConfigurator();
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(executorConfigurator.getCorePoolSize());
        this.f12440a = scheduledThreadPoolExecutor;
        scheduledThreadPoolExecutor.setMaximumPoolSize(executorConfigurator.getMaximumPoolSize());
        scheduledThreadPoolExecutor.setKeepAliveTime(60L, TimeUnit.SECONDS);
        this.b = new ConcurrentHashMap();
    }

    @Override // io.bidmachine.rendering.utils.taskmanager.BaseTaskManager, io.bidmachine.rendering.utils.taskmanager.TaskManager
    public void cancel(Runnable task) {
        super.cancel(task);
        try {
            Future futureA = a(task);
            if (futureA == null) {
                return;
            }
            futureA.cancel(false);
        } catch (Throwable unused) {
        }
    }

    @Override // io.bidmachine.rendering.utils.taskmanager.BaseTaskManager, io.bidmachine.rendering.utils.taskmanager.TaskManager
    public void execute(Runnable task) {
        super.execute(task);
        try {
            this.f12440a.execute(task);
        } catch (Throwable unused) {
        }
    }

    @Override // io.bidmachine.rendering.utils.taskmanager.BaseTaskManager, io.bidmachine.rendering.utils.taskmanager.TaskManager
    public void schedule(Runnable task, long delay, TimeUnit timeUnit) {
        super.schedule(task, delay, timeUnit);
        try {
            this.b.put(task, this.f12440a.schedule(new a(task), delay, timeUnit));
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Future a(Runnable runnable) {
        try {
            return (Future) this.b.remove(runnable);
        } catch (Throwable unused) {
            return null;
        }
    }
}
