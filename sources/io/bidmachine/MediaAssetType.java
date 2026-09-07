package io.bidmachine;

import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public enum MediaAssetType {
    Icon,
    Image,
    Video,
    All;

    public static boolean isAll(List<MediaAssetType> list) {
        return list.contains(All) || (list.contains(Icon) && list.contains(Image) && list.contains(Video));
    }
}
