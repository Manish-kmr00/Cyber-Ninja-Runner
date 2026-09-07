package com.smaato.sdk.video.vast.buildlight.compare;

import com.smaato.sdk.video.vast.buildlight.VastConfigurationSettings;
import com.smaato.sdk.video.vast.model.Sized;
import java.util.Comparator;

/* JADX INFO: loaded from: classes14.dex */
public class SizeComparator<T extends Sized> implements Comparator<T> {
    private final VastConfigurationSettings configurationSettings;

    public SizeComparator(VastConfigurationSettings vastConfigurationSettings) {
        this.configurationSettings = vastConfigurationSettings;
    }

    @Override // java.util.Comparator
    public int compare(T t, T t2) {
        if (t == null && t2 != null) {
            return 1;
        }
        if (t2 == null && t != null) {
            return -1;
        }
        if (t2 == null) {
            return 0;
        }
        return Float.compare(Math.abs(this.configurationSettings.displayWidth - (t.getWidth() == null ? 0.0f : t.getWidth().floatValue())) + Math.abs(this.configurationSettings.displayHeight - (t.getHeight() == null ? 0.0f : t.getHeight().floatValue())), Math.abs(this.configurationSettings.displayWidth - (t2.getWidth() == null ? 0.0f : t2.getWidth().floatValue())) + Math.abs(this.configurationSettings.displayHeight - (t2.getHeight() != null ? t2.getHeight().floatValue() : 0.0f)));
    }
}
