package com.smaato.sdk.video.vast.buildlight;

import com.smaato.sdk.video.vast.model.Ad;
import com.smaato.sdk.video.vast.model.InLine;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public class InLineAdContainerPicker {
    AdContainer<InLine> pickInLineContainer(List<Ad> list) {
        if (list.size() == 1) {
            Ad ad = list.get(0);
            InLine inLine = ad.inLine;
            if (inLine != null) {
                return new AdContainer<>(ad, inLine);
            }
            return null;
        }
        for (Ad ad2 : list) {
            InLine inLine2 = ad2.inLine;
            if (inLine2 != null && ad2.sequence == null) {
                return new AdContainer<>(ad2, inLine2);
            }
        }
        return null;
    }
}
