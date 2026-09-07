package com.smaato.sdk.core.util.notifier;

import android.os.Handler;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.fi.Consumer;

/* JADX INFO: loaded from: classes10.dex */
class DebounceChangeSender<D> extends StandardChangeSender<D> {
    private final Consumer actionCleaner;
    private final long delay;
    private final Handler handler;
    private Runnable lastAction;

    DebounceChangeSender(D d, final Handler handler, long j) {
        super(d);
        this.handler = (Handler) Objects.requireNonNull(handler);
        this.delay = j;
        this.actionCleaner = new Consumer() { // from class: com.smaato.sdk.core.util.notifier.DebounceChangeSender$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5576x8a1199ce(handler, (Runnable) obj);
            }
        };
    }

    /* JADX INFO: renamed from: lambda$new$0$com-smaato-sdk-core-util-notifier-DebounceChangeSender, reason: not valid java name */
    /* synthetic */ void m5576x8a1199ce(Handler handler, Runnable runnable) {
        handler.removeCallbacks(runnable);
        this.lastAction = null;
    }

    @Override // com.smaato.sdk.core.util.notifier.StandardChangeSender, com.smaato.sdk.core.util.notifier.ChangeSender
    public void newValue(final D d) {
        synchronized (this.lock) {
            Objects.onNotNull(this.lastAction, this.actionCleaner);
            Runnable runnable = new Runnable() { // from class: com.smaato.sdk.core.util.notifier.DebounceChangeSender$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5577x8dfb6a62(d);
                }
            };
            this.lastAction = runnable;
            this.handler.postDelayed(runnable, this.delay);
        }
    }

    /* JADX INFO: renamed from: lambda$newValue$1$com-smaato-sdk-core-util-notifier-DebounceChangeSender, reason: not valid java name */
    /* synthetic */ void m5577x8dfb6a62(Object obj) {
        super.newValue(obj);
    }
}
