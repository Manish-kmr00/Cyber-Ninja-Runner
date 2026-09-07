package com.smaato.sdk.core.lifecycle;

import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.smaato.sdk.core.util.fi.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public class AndroidXLifecycle extends Lifecycle implements LifecycleEventObserver {
    public AndroidXLifecycle(LifecycleOwner lifecycleOwner) {
        lifecycleOwner.getLifecycle().addObserver(this);
    }

    /* JADX INFO: renamed from: com.smaato.sdk.core.lifecycle.AndroidXLifecycle$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$Event;

        static {
            int[] iArr = new int[androidx.lifecycle.Lifecycle.Event.values().length];
            $SwitchMap$androidx$lifecycle$Lifecycle$Event = iArr;
            try {
                iArr[androidx.lifecycle.Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[androidx.lifecycle.Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[androidx.lifecycle.Lifecycle.Event.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[androidx.lifecycle.Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[androidx.lifecycle.Lifecycle.Event.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[androidx.lifecycle.Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[androidx.lifecycle.Lifecycle.Event.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner lifecycleOwner, androidx.lifecycle.Lifecycle.Event event) {
        switch (AnonymousClass1.$SwitchMap$androidx$lifecycle$Lifecycle$Event[event.ordinal()]) {
            case 1:
                notifyObservers(new Consumer() { // from class: com.smaato.sdk.core.lifecycle.AndroidXLifecycle$$ExternalSyntheticLambda5
                    @Override // com.smaato.sdk.core.util.fi.Consumer
                    public final void accept(Object obj) {
                        this.f$0.m5532xa1c9cd76((Lifecycle.Observer) obj);
                    }
                });
                break;
            case 2:
                notifyObservers(new Consumer() { // from class: com.smaato.sdk.core.lifecycle.AndroidXLifecycle$$ExternalSyntheticLambda4
                    @Override // com.smaato.sdk.core.util.fi.Consumer
                    public final void accept(Object obj) {
                        this.f$0.m5533xa1536777((Lifecycle.Observer) obj);
                    }
                });
                break;
            case 3:
                notifyObservers(new Consumer() { // from class: com.smaato.sdk.core.lifecycle.AndroidXLifecycle$$ExternalSyntheticLambda3
                    @Override // com.smaato.sdk.core.util.fi.Consumer
                    public final void accept(Object obj) {
                        this.f$0.m5534xa0dd0178((Lifecycle.Observer) obj);
                    }
                });
                break;
            case 4:
                notifyObservers(new Consumer() { // from class: com.smaato.sdk.core.lifecycle.AndroidXLifecycle$$ExternalSyntheticLambda2
                    @Override // com.smaato.sdk.core.util.fi.Consumer
                    public final void accept(Object obj) {
                        this.f$0.m5535xa0669b79((Lifecycle.Observer) obj);
                    }
                });
                break;
            case 5:
                notifyObservers(new Consumer() { // from class: com.smaato.sdk.core.lifecycle.AndroidXLifecycle$$ExternalSyntheticLambda1
                    @Override // com.smaato.sdk.core.util.fi.Consumer
                    public final void accept(Object obj) {
                        this.f$0.m5536x9ff0357a((Lifecycle.Observer) obj);
                    }
                });
                break;
            case 6:
                notifyObservers(new Consumer() { // from class: com.smaato.sdk.core.lifecycle.AndroidXLifecycle$$ExternalSyntheticLambda0
                    @Override // com.smaato.sdk.core.util.fi.Consumer
                    public final void accept(Object obj) {
                        this.f$0.m5537x9f79cf7b((Lifecycle.Observer) obj);
                    }
                });
                break;
        }
    }

    /* JADX INFO: renamed from: lambda$onStateChanged$0$com-smaato-sdk-core-lifecycle-AndroidXLifecycle, reason: not valid java name */
    /* synthetic */ void m5532xa1c9cd76(Lifecycle.Observer observer) {
        observer.onCreate(this);
    }

    /* JADX INFO: renamed from: lambda$onStateChanged$1$com-smaato-sdk-core-lifecycle-AndroidXLifecycle, reason: not valid java name */
    /* synthetic */ void m5533xa1536777(Lifecycle.Observer observer) {
        observer.onStart(this);
    }

    /* JADX INFO: renamed from: lambda$onStateChanged$2$com-smaato-sdk-core-lifecycle-AndroidXLifecycle, reason: not valid java name */
    /* synthetic */ void m5534xa0dd0178(Lifecycle.Observer observer) {
        observer.onResume(this);
    }

    /* JADX INFO: renamed from: lambda$onStateChanged$3$com-smaato-sdk-core-lifecycle-AndroidXLifecycle, reason: not valid java name */
    /* synthetic */ void m5535xa0669b79(Lifecycle.Observer observer) {
        observer.onPause(this);
    }

    /* JADX INFO: renamed from: lambda$onStateChanged$4$com-smaato-sdk-core-lifecycle-AndroidXLifecycle, reason: not valid java name */
    /* synthetic */ void m5536x9ff0357a(Lifecycle.Observer observer) {
        observer.onStop(this);
    }

    /* JADX INFO: renamed from: lambda$onStateChanged$5$com-smaato-sdk-core-lifecycle-AndroidXLifecycle, reason: not valid java name */
    /* synthetic */ void m5537x9f79cf7b(Lifecycle.Observer observer) {
        observer.onDestroy(this);
    }
}
