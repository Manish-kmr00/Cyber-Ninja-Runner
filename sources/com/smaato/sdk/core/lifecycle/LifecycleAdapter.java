package com.smaato.sdk.core.lifecycle;

import com.smaato.sdk.core.util.fi.Consumer;

/* JADX INFO: loaded from: classes12.dex */
public class LifecycleAdapter extends Lifecycle {
    private final Object owner;

    public LifecycleAdapter(Object obj) {
        this.owner = obj;
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$com-smaato-sdk-core-lifecycle-LifecycleAdapter, reason: not valid java name */
    /* synthetic */ void m5538lambda$onCreate$0$comsmaatosdkcorelifecycleLifecycleAdapter(Lifecycle.Observer observer) {
        observer.onCreate(this);
    }

    public void onCreate() {
        notifyObservers(new Consumer() { // from class: com.smaato.sdk.core.lifecycle.LifecycleAdapter$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5538lambda$onCreate$0$comsmaatosdkcorelifecycleLifecycleAdapter((Lifecycle.Observer) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onStart$1$com-smaato-sdk-core-lifecycle-LifecycleAdapter, reason: not valid java name */
    /* synthetic */ void m5542lambda$onStart$1$comsmaatosdkcorelifecycleLifecycleAdapter(Lifecycle.Observer observer) {
        observer.onStart(this);
    }

    public void onStart() {
        notifyObservers(new Consumer() { // from class: com.smaato.sdk.core.lifecycle.LifecycleAdapter$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5542lambda$onStart$1$comsmaatosdkcorelifecycleLifecycleAdapter((Lifecycle.Observer) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onResume$2$com-smaato-sdk-core-lifecycle-LifecycleAdapter, reason: not valid java name */
    /* synthetic */ void m5541lambda$onResume$2$comsmaatosdkcorelifecycleLifecycleAdapter(Lifecycle.Observer observer) {
        observer.onResume(this);
    }

    public void onResume() {
        notifyObservers(new Consumer() { // from class: com.smaato.sdk.core.lifecycle.LifecycleAdapter$$ExternalSyntheticLambda5
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5541lambda$onResume$2$comsmaatosdkcorelifecycleLifecycleAdapter((Lifecycle.Observer) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onPause$3$com-smaato-sdk-core-lifecycle-LifecycleAdapter, reason: not valid java name */
    /* synthetic */ void m5540lambda$onPause$3$comsmaatosdkcorelifecycleLifecycleAdapter(Lifecycle.Observer observer) {
        observer.onPause(this);
    }

    public void onPause() {
        notifyObservers(new Consumer() { // from class: com.smaato.sdk.core.lifecycle.LifecycleAdapter$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5540lambda$onPause$3$comsmaatosdkcorelifecycleLifecycleAdapter((Lifecycle.Observer) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onStop$4$com-smaato-sdk-core-lifecycle-LifecycleAdapter, reason: not valid java name */
    /* synthetic */ void m5543lambda$onStop$4$comsmaatosdkcorelifecycleLifecycleAdapter(Lifecycle.Observer observer) {
        observer.onStop(this);
    }

    public void onStop() {
        notifyObservers(new Consumer() { // from class: com.smaato.sdk.core.lifecycle.LifecycleAdapter$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5543lambda$onStop$4$comsmaatosdkcorelifecycleLifecycleAdapter((Lifecycle.Observer) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onDestroy$5$com-smaato-sdk-core-lifecycle-LifecycleAdapter, reason: not valid java name */
    /* synthetic */ void m5539xa1e157ac(Lifecycle.Observer observer) {
        observer.onDestroy(this);
    }

    public void onDestroy() {
        notifyObservers(new Consumer() { // from class: com.smaato.sdk.core.lifecycle.LifecycleAdapter$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5539xa1e157ac((Lifecycle.Observer) obj);
            }
        });
    }
}
