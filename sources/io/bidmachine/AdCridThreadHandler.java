package io.bidmachine;

import io.bidmachine.core.Logger;
import io.bidmachine.utils.Tag;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AdCridThreadHandler.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lio/bidmachine/AdCridThreadHandler;", "", "crid", "", "(Ljava/lang/String;)V", "name", "runnable", "Ljava/lang/Runnable;", "tag", "Lio/bidmachine/utils/Tag;", "thread", "Ljava/lang/Thread;", "destroy", "", "bidmachine-android-sdk_d_3_2_1"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AdCridThreadHandler {
    private final String name;
    private final Runnable runnable;
    private final Tag tag;
    private Thread thread;

    public AdCridThreadHandler(String crid) {
        Intrinsics.checkNotNullParameter(crid, "crid");
        this.tag = new Tag("AdCridThreadManager");
        String str = "io.bidmachine.crid." + crid;
        this.name = str;
        Runnable runnable = new Runnable() { // from class: io.bidmachine.AdCridThreadHandler$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AdCridThreadHandler.runnable$lambda$0(this.f$0);
            }
        };
        this.runnable = runnable;
        Thread thread = new Thread(runnable, str);
        thread.start();
        this.thread = thread;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runnable$lambda$0(AdCridThreadHandler this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Thread threadCurrentThread = Thread.currentThread();
        try {
            Logger.d(this$0.tag, this$0.name + " started");
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException unused) {
            threadCurrentThread.interrupt();
        }
    }

    public final void destroy() {
        Thread thread = this.thread;
        if (thread != null) {
            thread.interrupt();
        }
        this.thread = null;
        Logger.d(this.tag, this.name + " stopped");
    }
}
