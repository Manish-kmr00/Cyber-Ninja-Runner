package com.smaato.sdk.video.vast.buildlight;

import com.smaato.sdk.video.vast.model.Ad;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class InLineChecker {
    boolean hasInLine(List<Ad> list) {
        if (list.size() == 1) {
            return list.get(0).inLine != null;
        }
        for (Ad ad : list) {
            if (ad.inLine != null && ad.sequence == null) {
                return true;
            }
        }
        return false;
    }
}
