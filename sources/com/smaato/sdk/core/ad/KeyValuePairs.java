package com.smaato.sdk.core.ad;

import android.util.Log;
import com.smaato.sdk.core.util.Joiner;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.TextUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes12.dex */
public final class KeyValuePairs implements Cloneable {
    private static final String LOG_TAG = "KeyValuePairs";
    private final Map keyValuePairsMap = Collections.synchronizedMap(new LinkedHashMap(7));

    public void addTargetingValue(String str, String str2) {
        if (isKeyAndValueValid(str, str2)) {
            Set set = (Set) this.keyValuePairsMap.get(str);
            if (set == null) {
                setNewValues(str, str2);
            } else if (set.size() >= 7) {
                Log.e(LOG_TAG, String.format("%s values limit has been reached.", str));
            } else {
                if (set.add(str2)) {
                    return;
                }
                Log.e(LOG_TAG, String.format("%s value is already presents for the %s key.", str2, str));
            }
        }
    }

    public void setTargetingValue(String str, String str2) {
        if (isKeyAndValueValid(str, str2)) {
            setNewValues(str, str2);
        }
    }

    public void setTargetingValues(String str, String... strArr) {
        if (isKeyAndValueValid(str, strArr)) {
            setNewValues(str, strArr);
        }
    }

    public void removeAllKeyValuePairs() {
        this.keyValuePairsMap.clear();
    }

    public void removeKeyValuePair(String str) {
        this.keyValuePairsMap.remove(str);
    }

    private void setNewValues(String str, String... strArr) {
        Objects.requireNonNull(strArr);
        int length = 7;
        LinkedHashSet linkedHashSet = new LinkedHashSet(7);
        if (strArr.length > 7) {
            String[] strArr2 = new String[strArr.length - 7];
            System.arraycopy(strArr, 7, strArr2, 0, strArr.length - 7);
            Log.e(LOG_TAG, String.format("Amount of adding values (%s) exceeds maximal capacity (%s);\nSkipped values: %s", Integer.valueOf(strArr.length), 7, Joiner.join(", ", strArr2)));
        } else {
            length = strArr.length;
        }
        linkedHashSet.addAll(Arrays.asList(strArr).subList(0, length));
        this.keyValuePairsMap.put(str, Collections.synchronizedSet(linkedHashSet));
    }

    public Map<String, Set<String>> getAllKeyValuePairs() {
        Set<Map.Entry> setEntrySet = this.keyValuePairsMap.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(setEntrySet.size());
        for (Map.Entry entry : setEntrySet) {
            linkedHashMap.put((String) entry.getKey(), new LinkedHashSet((Collection) entry.getValue()));
        }
        return linkedHashMap;
    }

    private boolean isKeyAndValueValid(String str, String... strArr) {
        if (TextUtils.isEmpty(str)) {
            Log.e(LOG_TAG, "key can not be null or empty.");
            return false;
        }
        if (strArr == null || strArr.length == 0) {
            Log.e(LOG_TAG, "values can not be null or empty.");
            return false;
        }
        for (String str2 : strArr) {
            if (TextUtils.isEmpty(str2)) {
                Log.e(LOG_TAG, "value can not be null or empty.");
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public KeyValuePairs m5509clone() {
        KeyValuePairs keyValuePairs = new KeyValuePairs();
        synchronized (this.keyValuePairsMap) {
            for (Map.Entry entry : this.keyValuePairsMap.entrySet()) {
                Set set = (Set) entry.getValue();
                keyValuePairs.setNewValues((String) entry.getKey(), (String[]) set.toArray(new String[set.size()]));
            }
        }
        return keyValuePairs;
    }
}
