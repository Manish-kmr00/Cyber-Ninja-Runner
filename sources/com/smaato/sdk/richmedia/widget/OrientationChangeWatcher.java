package com.smaato.sdk.richmedia.widget;

import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.Whatever;
import com.smaato.sdk.core.util.collections.Iterables;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.core.util.notifier.ChangeNotifier;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes6.dex */
public final class OrientationChangeWatcher {
    private final Set listeners = Collections.newSetFromMap(new WeakHashMap());
    private final OrientationBroadcastReceiver orientationBroadcastReceiver;

    public interface Listener {
        void onOrientationChange();
    }

    public OrientationChangeWatcher(OrientationBroadcastReceiver orientationBroadcastReceiver) {
        this.orientationBroadcastReceiver = (OrientationBroadcastReceiver) Objects.requireNonNull(orientationBroadcastReceiver);
        orientationBroadcastReceiver.getOrientationChangeSender().addListener(new ChangeNotifier.Listener() { // from class: com.smaato.sdk.richmedia.widget.OrientationChangeWatcher$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.notifier.ChangeNotifier.Listener
            public final void onNextValue(Object obj) {
                this.f$0.m5688x56d48556((Whatever) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$new$0$com-smaato-sdk-richmedia-widget-OrientationChangeWatcher, reason: not valid java name */
    /* synthetic */ void m5688x56d48556(Whatever whatever) {
        notifyListeners();
    }

    public synchronized void addListener(Listener listener) {
        Objects.requireNonNull(listener);
        this.listeners.add(listener);
        if (!this.listeners.isEmpty() && !this.orientationBroadcastReceiver.isRegistered()) {
            this.orientationBroadcastReceiver.register();
        }
    }

    public synchronized void removeListener(Listener listener) {
        this.listeners.remove(listener);
        if (this.listeners.isEmpty() && this.orientationBroadcastReceiver.isRegistered()) {
            this.orientationBroadcastReceiver.unregister();
        }
    }

    private synchronized void notifyListeners() {
        Iterables.forEach(new HashSet(this.listeners), new Consumer() { // from class: com.smaato.sdk.richmedia.widget.OrientationChangeWatcher$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((OrientationChangeWatcher.Listener) obj).onOrientationChange();
            }
        });
    }
}
