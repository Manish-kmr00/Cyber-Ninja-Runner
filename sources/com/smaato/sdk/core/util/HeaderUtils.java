package com.smaato.sdk.core.util;

import com.google.common.net.HttpHeaders;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public final class HeaderUtils {
    public List<String> extractHeaderValueList(Map<String, List<String>> map, String str) {
        Objects.requireNonNull(map);
        Objects.requireNonNull(str);
        return map.get(str);
    }

    public String extractHeaderMultiValue(Map<String, List<String>> map, String str) {
        Objects.requireNonNull(map);
        Objects.requireNonNull(str);
        List<String> list = map.get(str);
        if (list != null) {
            return Joiner.join("", list);
        }
        return null;
    }

    public String extractHeaderSingleValue(Map<String, List<String>> map, String str) {
        Objects.requireNonNull(map);
        Objects.requireNonNull(str);
        List<String> list = map.get(str);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public boolean isChunkedTransferEncoding(Map<String, List<String>> map) {
        List<String> list;
        Objects.requireNonNull(map);
        for (String str : map.keySet()) {
            if (HttpHeaders.TRANSFER_ENCODING.equalsIgnoreCase(str) && (list = map.get(str)) != null) {
                java.util.Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    if ("chunked".equalsIgnoreCase(it.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
