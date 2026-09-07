package net.pubnative.lite.sdk.vpaid.volume;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.pubnative.lite.sdk.HyBid;
import net.pubnative.lite.sdk.receiver.VolumeChangedActionReceiver;
import net.pubnative.lite.sdk.utils.Logger;

/* JADX INFO: loaded from: classes11.dex */
public class VolumeObserver {
    private static final String TAG = "VolumeObserver";
    private static VolumeObserver instance;
    private final List<IVolumeObserver> observerList = new ArrayList();
    private VolumeChangedActionReceiver receiver;

    private VolumeObserver() {
    }

    public static VolumeObserver getInstance() {
        if (instance == null) {
            instance = new VolumeObserver();
        }
        return instance;
    }

    public void registerVolumeObserver(IVolumeObserver iVolumeObserver, Context context) {
        if (!this.observerList.contains(iVolumeObserver)) {
            this.observerList.add(iVolumeObserver);
        }
        registerMediaButtonReceiver(context);
    }

    public void unregisterVolumeObserver(IVolumeObserver iVolumeObserver, Context context) {
        this.observerList.remove(iVolumeObserver);
        if (this.observerList.isEmpty()) {
            unregisterMediaButtonReceiver(context);
        }
    }

    public void notifyObservers() {
        Iterator<IVolumeObserver> it = this.observerList.iterator();
        while (it.hasNext()) {
            it.next().onSystemVolumeChanged();
        }
    }

    private void registerMediaButtonReceiver(Context context) {
        if (this.receiver == null) {
            this.receiver = new VolumeChangedActionReceiver();
            IntentFilter intentFilter = new IntentFilter("android.intent.action.MEDIA_BUTTON");
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            intentFilter.setPriority(Integer.MAX_VALUE);
            if (Build.VERSION.SDK_INT >= 33) {
                context.registerReceiver(this.receiver, intentFilter, 4);
            } else {
                context.registerReceiver(this.receiver, intentFilter);
            }
        }
    }

    private void unregisterMediaButtonReceiver(Context context) {
        VolumeChangedActionReceiver volumeChangedActionReceiver = this.receiver;
        if (volumeChangedActionReceiver != null) {
            try {
                context.unregisterReceiver(volumeChangedActionReceiver);
                this.receiver = null;
            } catch (RuntimeException e) {
                HyBid.reportException((Exception) e);
                Logger.e(TAG, e.getMessage());
            }
        }
    }
}
