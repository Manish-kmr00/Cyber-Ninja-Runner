package net.pubnative.lite.sdk.browser;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class BrowserManager {
    private static final String TAG = "BrowserManager";
    private final List<String> mPriorityList = new ArrayList();

    public void addBrowser(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mPriorityList.add(str);
    }

    public List<String> getPackagePriorities() {
        return this.mPriorityList;
    }

    public boolean containsPriorities() {
        return !this.mPriorityList.isEmpty();
    }

    public void cleanPriorities() {
        this.mPriorityList.clear();
    }
}
