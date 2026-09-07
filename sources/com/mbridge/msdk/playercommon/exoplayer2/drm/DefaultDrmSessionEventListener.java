package com.mbridge.msdk.playercommon.exoplayer2.drm;

import android.os.Handler;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public interface DefaultDrmSessionEventListener {

    public static final class EventDispatcher {
        private final CopyOnWriteArrayList<HandlerAndListener> listeners = new CopyOnWriteArrayList<>();

        private static final class HandlerAndListener {
            public final Handler handler;
            public final DefaultDrmSessionEventListener listener;

            public HandlerAndListener(Handler handler, DefaultDrmSessionEventListener defaultDrmSessionEventListener) {
                this.handler = handler;
                this.listener = defaultDrmSessionEventListener;
            }
        }

        public void addListener(Handler handler, DefaultDrmSessionEventListener defaultDrmSessionEventListener) {
            Assertions.checkArgument((handler == null || defaultDrmSessionEventListener == null) ? false : true);
            this.listeners.add(new HandlerAndListener(handler, defaultDrmSessionEventListener));
        }

        public void drmKeysLoaded() {
            for (HandlerAndListener handlerAndListener : this.listeners) {
                final DefaultDrmSessionEventListener defaultDrmSessionEventListener = handlerAndListener.listener;
                handlerAndListener.handler.post(new Runnable() { // from class: com.mbridge.msdk.playercommon.exoplayer2.drm.DefaultDrmSessionEventListener.EventDispatcher.1
                    @Override // java.lang.Runnable
                    public void run() {
                        defaultDrmSessionEventListener.onDrmKeysLoaded();
                    }
                });
            }
        }

        public void drmKeysRemoved() {
            for (HandlerAndListener handlerAndListener : this.listeners) {
                final DefaultDrmSessionEventListener defaultDrmSessionEventListener = handlerAndListener.listener;
                handlerAndListener.handler.post(new Runnable() { // from class: com.mbridge.msdk.playercommon.exoplayer2.drm.DefaultDrmSessionEventListener.EventDispatcher.4
                    @Override // java.lang.Runnable
                    public void run() {
                        defaultDrmSessionEventListener.onDrmKeysRemoved();
                    }
                });
            }
        }

        public void drmKeysRestored() {
            for (HandlerAndListener handlerAndListener : this.listeners) {
                final DefaultDrmSessionEventListener defaultDrmSessionEventListener = handlerAndListener.listener;
                handlerAndListener.handler.post(new Runnable() { // from class: com.mbridge.msdk.playercommon.exoplayer2.drm.DefaultDrmSessionEventListener.EventDispatcher.3
                    @Override // java.lang.Runnable
                    public void run() {
                        defaultDrmSessionEventListener.onDrmKeysRestored();
                    }
                });
            }
        }

        public void drmSessionManagerError(final Exception exc) {
            for (HandlerAndListener handlerAndListener : this.listeners) {
                final DefaultDrmSessionEventListener defaultDrmSessionEventListener = handlerAndListener.listener;
                handlerAndListener.handler.post(new Runnable() { // from class: com.mbridge.msdk.playercommon.exoplayer2.drm.DefaultDrmSessionEventListener.EventDispatcher.2
                    @Override // java.lang.Runnable
                    public void run() {
                        defaultDrmSessionEventListener.onDrmSessionManagerError(exc);
                    }
                });
            }
        }

        public void removeListener(DefaultDrmSessionEventListener defaultDrmSessionEventListener) {
            for (HandlerAndListener handlerAndListener : this.listeners) {
                if (handlerAndListener.listener == defaultDrmSessionEventListener) {
                    this.listeners.remove(handlerAndListener);
                }
            }
        }
    }

    void onDrmKeysLoaded();

    void onDrmKeysRemoved();

    void onDrmKeysRestored();

    void onDrmSessionManagerError(Exception exc);
}
