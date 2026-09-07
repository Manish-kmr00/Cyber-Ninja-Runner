package com.bytedance.sdk.openadsdk.api.reward;

/* JADX INFO: loaded from: classes4.dex */
public class PAGRewardItem {
    private final String Og;
    private final int pA;

    public PAGRewardItem(int i, String str) {
        this.pA = i;
        this.Og = str;
    }

    public int getRewardAmount() {
        return this.pA;
    }

    public String getRewardName() {
        return this.Og;
    }
}
