package com.smaato.sdk.core.lifecycle;

import com.smaato.sdk.core.util.fi.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Lifecycle {
    protected final List<Observer> observerList = new ArrayList();

    public interface Observer {
        default void onCreate(Lifecycle lifecycle) {
        }

        default void onDestroy(Lifecycle lifecycle) {
        }

        default void onPause(Lifecycle lifecycle) {
        }

        default void onResume(Lifecycle lifecycle) {
        }

        default void onStart(Lifecycle lifecycle) {
        }

        default void onStop(Lifecycle lifecycle) {
        }
    }

    public void addObserver(Observer observer) {
        this.observerList.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.observerList.remove(observer);
    }

    protected void notifyObservers(Consumer<Observer> consumer) {
        Iterator<Observer> it = this.observerList.iterator();
        while (it.hasNext()) {
            consumer.accept(it.next());
        }
    }
}
