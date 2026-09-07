package com.yandex.div.state;

/* JADX INFO: loaded from: classes8.dex */
public interface DivStateCache {
    void clear();

    String getRootState(String str);

    String getState(String str, String str2);

    void putRootState(String str, String str2);

    void putState(String str, String str2, String str3);

    void resetCard(String str);
}
