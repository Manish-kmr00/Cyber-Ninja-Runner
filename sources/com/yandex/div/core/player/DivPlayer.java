package com.yandex.div.core.player;

import com.amazon.device.ads.DTBMetricsConfiguration;
import com.json.b9;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivPlayer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001e\u0010\u0010\u001a\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/player/DivPlayer;", "", "addObserver", "", "observer", "Lcom/yandex/div/core/player/DivPlayer$Observer;", "pause", "play", "release", "removeObserver", "seek", "toMs", "", "setMuted", "muted", "", "setSource", "sourceVariants", "", "Lcom/yandex/div/core/player/DivVideoSource;", DTBMetricsConfiguration.CONFIG_DIR, "Lcom/yandex/div/core/player/DivPlayerPlaybackConfig;", "Companion", "Observer", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface DivPlayer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final float VOLUME_FULL = 1.0f;
    public static final float VOLUME_MUTED = 0.0f;

    /* JADX INFO: compiled from: DivPlayer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/player/DivPlayer$Observer;", "", "onBuffering", "", "onCurrentTimeChange", "timeMs", "", "onEnd", "onFatal", b9.h.t0, "onPlay", "onReady", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface Observer {
        default void onBuffering() {
        }

        default void onCurrentTimeChange(long timeMs) {
        }

        default void onEnd() {
        }

        default void onFatal() {
        }

        default void onPause() {
        }

        default void onPlay() {
        }

        default void onReady() {
        }
    }

    default void addObserver(Observer observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
    }

    default void pause() {
    }

    default void play() {
    }

    default void release() {
    }

    default void removeObserver(Observer observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
    }

    default void seek(long toMs) {
    }

    default void setMuted(boolean muted) {
    }

    default void setSource(List<DivVideoSource> sourceVariants, DivPlayerPlaybackConfig config) {
        Intrinsics.checkNotNullParameter(sourceVariants, "sourceVariants");
        Intrinsics.checkNotNullParameter(config, "config");
    }

    /* JADX INFO: compiled from: DivPlayer.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/yandex/div/core/player/DivPlayer$Companion;", "", "()V", "VOLUME_FULL", "", "VOLUME_MUTED", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final float VOLUME_FULL = 1.0f;
        public static final float VOLUME_MUTED = 0.0f;

        private Companion() {
        }
    }
}
