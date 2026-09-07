package com.yandex.div.core.player;

import com.yandex.div2.DivVideoScale;
import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivVideoAttachable.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/player/DivVideoAttachable;", "", "attach", "", "player", "Lcom/yandex/div/core/player/DivPlayer;", "detach", "getAttachedPlayer", "setScale", "videoScale", "Lcom/yandex/div2/DivVideoScale;", "setVisibleOnScreen", VastAttributes.VISIBLE, "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface DivVideoAttachable {
    default void attach(DivPlayer player) {
        Intrinsics.checkNotNullParameter(player, "player");
    }

    default void detach() {
    }

    default DivPlayer getAttachedPlayer() {
        return null;
    }

    default void setScale(DivVideoScale videoScale) {
        Intrinsics.checkNotNullParameter(videoScale, "videoScale");
    }

    default void setVisibleOnScreen(boolean visible) {
    }
}
