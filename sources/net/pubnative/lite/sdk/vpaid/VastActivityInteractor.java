package net.pubnative.lite.sdk.vpaid;

/* JADX INFO: loaded from: classes3.dex */
public class VastActivityInteractor {
    private static boolean activityVisible;
    private static VastActivityInteractor instance;
    private boolean isDependentOnActivityLifecycle = false;

    private VastActivityInteractor() {
        activityVisible = true;
    }

    public static VastActivityInteractor getInstance() {
        if (instance == null) {
            instance = new VastActivityInteractor();
        }
        return instance;
    }

    public void activityResumed() {
        activityVisible = true;
    }

    public void activityStarted() {
        activityVisible = true;
        this.isDependentOnActivityLifecycle = true;
    }

    public void activityPaused() {
        activityVisible = false;
    }

    public boolean isActivityVisible() {
        return activityVisible;
    }

    public boolean isDependentOnActivityLifecycle() {
        return this.isDependentOnActivityLifecycle;
    }

    public void activityDestroyed() {
        activityVisible = false;
        this.isDependentOnActivityLifecycle = false;
    }
}
