package com.smaato.sdk.core.util.notifier;

import com.smaato.sdk.core.util.Objects;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes12.dex */
class StandardChangeSender<T> implements ChangeSender<T> {
    private volatile Object value;
    final Object lock = new Object();
    private final Set listeners = Collections.newSetFromMap(new WeakHashMap());

    StandardChangeSender(T t) {
        this.value = t;
    }

    @Override // com.smaato.sdk.core.util.notifier.ChangeSender
    public void newValue(T t) {
        Objects.requireNonNull(t);
        synchronized (this.lock) {
            this.value = t;
            notifyListeners();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.smaato.sdk.core.util.notifier.ChangeNotifier
    public void addListener(ChangeNotifier.Listener<T> listener) {
        Objects.requireNonNull(listener, "Parameter listener cannot be null for StandardChangeSender::addListener");
        synchronized (this.lock) {
            if (!this.listeners.contains(listener)) {
                this.listeners.add(listener);
                listener.onNextValue(this.value);
            }
        }
    }

    @Override // com.smaato.sdk.core.util.notifier.ChangeNotifier
    public void removeListener(ChangeNotifier.Listener<T> listener) {
        synchronized (this.lock) {
            this.listeners.remove(listener);
        }
    }

    @Override // com.smaato.sdk.core.util.notifier.ChangeSender
    public T getValue() {
        T t;
        synchronized (this.lock) {
            t = (T) this.value;
        }
        return t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void notifyListeners() {
        Iterator it = new HashSet(this.listeners).iterator();
        while (it.hasNext()) {
            ((ChangeNotifier.Listener) it.next()).onNextValue(this.value);
        }
    }
}
