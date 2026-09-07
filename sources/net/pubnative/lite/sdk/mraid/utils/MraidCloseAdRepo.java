package net.pubnative.lite.sdk.mraid.utils;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class MraidCloseAdRepo {
    private static MraidCloseAdRepo instance;
    private boolean isAdSticky = false;
    private final List<ICloseAdObserver> observerList = new ArrayList();

    public interface ICloseAdObserver {
        void onCloseExpandedAd();
    }

    private MraidCloseAdRepo() {
    }

    public static MraidCloseAdRepo getInstance() {
        if (instance == null) {
            instance = new MraidCloseAdRepo();
        }
        return instance;
    }

    public void registerExpandedAdCloseObserver(ICloseAdObserver iCloseAdObserver) {
        if (!this.isAdSticky || this.observerList.contains(iCloseAdObserver)) {
            return;
        }
        this.observerList.add(iCloseAdObserver);
    }

    public void unregisterExpandedAdCloseObserver(ICloseAdObserver iCloseAdObserver) {
        if (this.isAdSticky) {
            this.observerList.remove(iCloseAdObserver);
        }
    }

    public void notifyTabChanged() {
        notifyObservers();
    }

    public void notifyObservers() {
        if (this.isAdSticky) {
            for (ICloseAdObserver iCloseAdObserver : this.observerList) {
                if (iCloseAdObserver != null) {
                    iCloseAdObserver.onCloseExpandedAd();
                }
            }
            if (this.observerList.isEmpty()) {
                return;
            }
            this.observerList.clear();
            this.isAdSticky = false;
        }
    }

    public void setIsAdSticky(boolean z) {
        this.isAdSticky = z;
    }

    public boolean isStickyAd() {
        return this.isAdSticky;
    }
}
