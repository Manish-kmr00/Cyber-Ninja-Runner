package com.smaato.sdk.richmedia.mraid.dataprovider;

import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.collections.Iterables;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.core.util.notifier.ChangeNotifier;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes13.dex */
public class AudioVolumeObserver {
    private final AudioVolumeContentObserver audioVolumeContentObserver;
    private final Set listeners = Collections.newSetFromMap(new WeakHashMap());
    private final int maxVolume;

    public interface Listener {
        void onVolumeChange(int i, int i2);
    }

    public AudioVolumeObserver(AudioVolumeContentObserver audioVolumeContentObserver, int i) {
        this.audioVolumeContentObserver = (AudioVolumeContentObserver) Objects.requireNonNull(audioVolumeContentObserver);
        audioVolumeContentObserver.getChangeSender().addListener(new ChangeNotifier.Listener() { // from class: com.smaato.sdk.richmedia.mraid.dataprovider.AudioVolumeObserver$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.notifier.ChangeNotifier.Listener
            public final void onNextValue(Object obj) {
                this.f$0.notifyListeners(((Integer) obj).intValue());
            }
        });
        this.maxVolume = i;
    }

    public synchronized void register(Listener listener) {
        Objects.requireNonNull(listener);
        this.listeners.add(listener);
        if (!this.listeners.isEmpty() && !this.audioVolumeContentObserver.isRegistered()) {
            this.audioVolumeContentObserver.register();
        }
    }

    public synchronized void unregister(Listener listener) {
        this.listeners.remove(listener);
        if (this.listeners.isEmpty() && this.audioVolumeContentObserver.isRegistered()) {
            this.audioVolumeContentObserver.unregister();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifyListeners(final int i) {
        Iterables.forEach(new HashSet(this.listeners), new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.dataprovider.AudioVolumeObserver$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5664xb772c02f(i, (AudioVolumeObserver.Listener) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$notifyListeners$0$com-smaato-sdk-richmedia-mraid-dataprovider-AudioVolumeObserver, reason: not valid java name */
    /* synthetic */ void m5664xb772c02f(int i, Listener listener) {
        listener.onVolumeChange(i, this.maxVolume);
    }
}
