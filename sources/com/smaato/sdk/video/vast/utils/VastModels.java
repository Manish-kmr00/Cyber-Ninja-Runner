package com.smaato.sdk.video.vast.utils;

import com.smaato.sdk.video.vast.exceptions.VastElementMissingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public final class VastModels {
    public static <T> T requireNonNull(T t, String str) throws VastElementMissingException {
        if (t != null) {
            return t;
        }
        throw new VastElementMissingException(str);
    }

    public static <T, C extends Collection<T>> C requireNonEmpty(C c, String str) throws VastElementMissingException {
        if (c == null || c.isEmpty()) {
            throw new VastElementMissingException(str);
        }
        return c;
    }

    public static <T> List<T> toImmutableList(List<T> list) {
        if (list == null || list.isEmpty()) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList(list));
    }
}
