package com.yandex.android.util;

import androidx.collection.ArrayMap;
import com.yandex.div.internal.Assert;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Serialization.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004*\u0004\u0018\u00010\u0005H\u0000\u001a\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"MAP_KEY_VALUE_DELIMITER", "", "MAP_KEY_VALUE_PAIR_DELIMITER", "deserializeMap", "", "", "serialize", "beacon_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class SerializationUtils {
    private static final char MAP_KEY_VALUE_DELIMITER = '\t';
    private static final char MAP_KEY_VALUE_PAIR_DELIMITER = 0;

    public static final String serialize(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        if (map.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            sb.append(key).append(MAP_KEY_VALUE_DELIMITER).append(entry.getValue()).append((char) 0);
        }
        return sb.toString();
    }

    public static final Map<String, String> deserializeMap(String str) {
        if (str == null) {
            return MapsKt.emptyMap();
        }
        List listSplit$default = StringsKt.split$default((CharSequence) str, new char[]{0}, false, 0, 6, (Object) null);
        if (listSplit$default.isEmpty()) {
            Assert.fail("Incorrect serialization: empty map should be serialized into null value!");
            return MapsKt.emptyMap();
        }
        ArrayMap arrayMap = new ArrayMap(listSplit$default.size());
        int size = listSplit$default.size();
        for (int i = 0; i < size; i++) {
            List listSplit$default2 = StringsKt.split$default((CharSequence) listSplit$default.get(i), new char[]{MAP_KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null);
            if (listSplit$default2.size() == 1) {
                arrayMap.put(listSplit$default2.get(0), "");
            } else {
                arrayMap.put(listSplit$default2.get(0), listSplit$default2.get(1));
            }
        }
        return arrayMap;
    }
}
