package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class FilterWord {
    private boolean KZx;
    private String Og;
    private List<FilterWord> ZZv;
    private String pA;

    public FilterWord(String str, String str2) {
        this.pA = str;
        this.Og = str2;
    }

    public FilterWord() {
    }

    public String getId() {
        return this.pA;
    }

    public void setId(String str) {
        this.pA = str;
    }

    public String getName() {
        return this.Og;
    }

    public void setName(String str) {
        this.Og = str;
    }

    public boolean getIsSelected() {
        return this.KZx;
    }

    public void setIsSelected(boolean z) {
        this.KZx = z;
    }

    public List<FilterWord> getOptions() {
        return this.ZZv;
    }

    public void addOption(FilterWord filterWord) {
        if (filterWord == null) {
            return;
        }
        if (this.ZZv == null) {
            this.ZZv = new ArrayList();
        }
        this.ZZv.add(filterWord);
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.pA) || TextUtils.isEmpty(this.Og)) ? false : true;
    }

    public boolean hasSecondOptions() {
        List<FilterWord> list = this.ZZv;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FilterWord)) {
            return false;
        }
        FilterWord filterWord = (FilterWord) obj;
        return filterWord.getId().equals(getId()) && filterWord.getName().equals(getName());
    }
}
