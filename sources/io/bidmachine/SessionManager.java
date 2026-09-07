package io.bidmachine;

import android.content.Context;
import io.bidmachine.core.Logger;
import io.bidmachine.core.TimeManager;
import io.bidmachine.core.Utils;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes8.dex */
public class SessionManager {
    public static final String SESSION_ID_EMPTY = "";
    private static final String TAG = "SessionManager";
    private static volatile SessionManager instance;
    private volatile Context applicationContext;
    private long pauseTime;
    private long resumeTime;
    private long sessionDuration;
    private long sessionResetAfterSec;
    private final EnumMap<AdsType, SessionAdParams> sessionAdParamsMap = new EnumMap<>(AdsType.class);
    private String sessionId = "";
    private final CopyOnWriteArraySet<Observer> observers = new CopyOnWriteArraySet<>();

    interface Observer {
        void onSessionEvent(Status status);
    }

    enum Status {
        START,
        RESUME,
        PAUSE
    }

    static SessionManager get() {
        SessionManager sessionManager = instance;
        if (sessionManager == null) {
            synchronized (SessionManager.class) {
                sessionManager = instance;
                if (sessionManager == null) {
                    sessionManager = new SessionManager();
                    instance = sessionManager;
                }
            }
        }
        return sessionManager;
    }

    private SessionManager() {
        startNewSession();
    }

    synchronized void attachContext(Context context) {
        boolean z = this.applicationContext == null;
        this.applicationContext = context.getApplicationContext();
        if (z) {
            onContextAttached();
        }
    }

    private void onContextAttached() {
        incrementSessionCounter();
    }

    void startNewSession() {
        this.sessionId = UUID.randomUUID().toString();
        this.sessionDuration = 0L;
        this.pauseTime = 0L;
        this.resumeTime = 0L;
        for (AdsType adsType : AdsType.values()) {
            getSessionAdParams(adsType).clear();
        }
        notifyObservers(Status.START);
        incrementSessionCounter();
        Logger.d(TAG, "New session started");
    }

    private void incrementSessionCounter() {
        Utils.ifNotNull(this.applicationContext, new Executable() { // from class: io.bidmachine.SessionManager$$ExternalSyntheticLambda1
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                Utils.onBackgroundThread(new Runnable() { // from class: io.bidmachine.SessionManager$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        BidMachineSharedPreference.incrementSessionCount(context);
                    }
                });
            }
        });
    }

    int getSessionCount() {
        Context context = this.applicationContext;
        if (context == null) {
            Logger.w(TAG, "Context not attached");
            return 0;
        }
        return BidMachineSharedPreference.getSessionCount(context);
    }

    String getSessionId() {
        return this.sessionId;
    }

    void setSessionResetAfter(long j) {
        this.sessionResetAfterSec = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code duplicated, block: B:9:0x001f  */
    public void resume() {
        long jCurrentTimeMillis = TimeManager.currentTimeMillis();
        long j = this.sessionResetAfterSec;
        if (j > 0) {
            long j2 = this.pauseTime;
            if (j2 > 0 && jCurrentTimeMillis - j2 >= j * 1000) {
                startNewSession();
            } else {
                notifyObservers(Status.RESUME);
                Logger.d(TAG, "Session resumed");
            }
        } else {
            notifyObservers(Status.RESUME);
            Logger.d(TAG, "Session resumed");
        }
        this.resumeTime = jCurrentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pause() {
        if (this.resumeTime == 0) {
            return;
        }
        long jCurrentTimeMillis = TimeManager.currentTimeMillis();
        this.pauseTime = jCurrentTimeMillis;
        this.sessionDuration += jCurrentTimeMillis - this.resumeTime;
        notifyObservers(Status.PAUSE);
        Logger.d(TAG, "Session paused");
    }

    int getSessionDuration() {
        if (this.resumeTime == 0) {
            return 0;
        }
        return (int) ((this.sessionDuration + (TimeManager.currentTimeMillis() - this.resumeTime)) / 1000);
    }

    synchronized SessionAdParams getSessionAdParams(AdsType adsType) {
        SessionAdParams sessionAdParams;
        sessionAdParams = this.sessionAdParamsMap.get(adsType);
        if (sessionAdParams == null) {
            sessionAdParams = new SessionAdParams();
            this.sessionAdParamsMap.put(adsType, sessionAdParams);
        }
        return sessionAdParams;
    }

    void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    private void notifyObservers(Status status) {
        Iterator<Observer> it = this.observers.iterator();
        while (it.hasNext()) {
            it.next().onSessionEvent(status);
        }
    }
}
