package com.smaato.sdk.core.lifecycle;

import android.view.View;
import com.smaato.sdk.core.util.fi.Consumer;

/* JADX INFO: loaded from: classes13.dex */
public class ViewLifecycle extends Lifecycle implements View.OnAttachStateChangeListener {
    public ViewLifecycle(View view) {
        view.addOnAttachStateChangeListener(this);
    }

    /* JADX INFO: renamed from: lambda$onViewAttachedToWindow$0$com-smaato-sdk-core-lifecycle-ViewLifecycle, reason: not valid java name */
    /* synthetic */ void m5547x7fe51acb(Lifecycle.Observer observer) {
        observer.onResume(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        notifyObservers(new Consumer() { // from class: com.smaato.sdk.core.lifecycle.ViewLifecycle$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5547x7fe51acb((Lifecycle.Observer) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onViewDetachedFromWindow$1$com-smaato-sdk-core-lifecycle-ViewLifecycle, reason: not valid java name */
    /* synthetic */ void m5548xe0556b89(Lifecycle.Observer observer) {
        observer.onDestroy(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        notifyObservers(new Consumer() { // from class: com.smaato.sdk.core.lifecycle.ViewLifecycle$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5548xe0556b89((Lifecycle.Observer) obj);
            }
        });
    }
}
