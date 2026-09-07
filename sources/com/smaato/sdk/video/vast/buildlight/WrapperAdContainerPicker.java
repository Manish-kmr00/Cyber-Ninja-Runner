package com.smaato.sdk.video.vast.buildlight;

import com.smaato.sdk.video.vast.model.Ad;
import com.smaato.sdk.video.vast.model.Wrapper;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class WrapperAdContainerPicker {
    AdContainer<Wrapper> pickWrapperContainer(List<Ad> list) {
        if (list.size() == 1) {
            Ad ad = list.get(0);
            Wrapper wrapper = ad.wrapper;
            if (wrapper != null) {
                return new AdContainer<>(ad, wrapper);
            }
            return null;
        }
        for (Ad ad2 : list) {
            Wrapper wrapper2 = ad2.wrapper;
            if (wrapper2 != null && ad2.sequence == null) {
                return new AdContainer<>(ad2, wrapper2);
            }
        }
        return null;
    }
}
