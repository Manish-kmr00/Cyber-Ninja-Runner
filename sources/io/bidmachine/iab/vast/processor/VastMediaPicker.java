package io.bidmachine.iab.vast.processor;

import android.util.Pair;
import io.bidmachine.iab.vast.tags.MediaFileTag;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public abstract class VastMediaPicker<T extends MediaFileTag> implements Serializable {
    abstract Pair pickVideo(List list);
}
