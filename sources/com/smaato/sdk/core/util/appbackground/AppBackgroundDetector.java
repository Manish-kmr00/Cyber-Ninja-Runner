package com.smaato.sdk.core.util.appbackground;

import com.smaato.sdk.core.lifecycle.ProcessLifecycleOwner;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.Objects;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes8.dex */
public class AppBackgroundDetector {
    private boolean foreground;
    private final ArrayList listeners = new ArrayList();

    public interface Listener {
        void onAppEnteredInBackground();

        void onAppEnteredInForeground();
    }

    public AppBackgroundDetector(final Logger logger) {
        Objects.requireNonNull(logger, "logger must not be null for AppBackgroundDetector::new");
        ProcessLifecycleOwner.get().setListener(new ProcessLifecycleOwner.Listener() { // from class: com.smaato.sdk.core.util.appbackground.AppBackgroundDetector.1
            @Override // com.smaato.sdk.core.lifecycle.ProcessLifecycleOwner.Listener
            public void onFirstActivityStarted() {
                logger.info(LogDomain.CORE, "app entered foreground", new Object[0]);
                AppBackgroundDetector.this.foreground = true;
                AppBackgroundDetector appBackgroundDetector = AppBackgroundDetector.this;
                appBackgroundDetector.notifyListeners(appBackgroundDetector.foreground);
            }

            @Override // com.smaato.sdk.core.lifecycle.ProcessLifecycleOwner.Listener
            public void onLastActivityStopped() {
                logger.info(LogDomain.CORE, "app entered background", new Object[0]);
                AppBackgroundDetector.this.foreground = false;
                AppBackgroundDetector appBackgroundDetector = AppBackgroundDetector.this;
                appBackgroundDetector.notifyListeners(appBackgroundDetector.foreground);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyListeners(boolean z) {
        Iterator it = new ArrayList(this.listeners).iterator();
        while (it.hasNext()) {
            notifyListener((Listener) it.next(), z);
        }
    }

    public synchronized boolean isAppInBackground() {
        return !this.foreground;
    }

    public synchronized void addListener(Listener listener, boolean z) {
        Objects.requireNonNull(listener, "listener can not be null");
        if (!this.listeners.contains(listener)) {
            this.listeners.add(listener);
            if (z) {
                notifyListener(listener, this.foreground);
            }
        }
    }

    private void notifyListener(Listener listener, boolean z) {
        if (z) {
            listener.onAppEnteredInForeground();
        } else {
            listener.onAppEnteredInBackground();
        }
    }

    public synchronized void deleteListener(Listener listener) {
        this.listeners.remove(listener);
    }
}
