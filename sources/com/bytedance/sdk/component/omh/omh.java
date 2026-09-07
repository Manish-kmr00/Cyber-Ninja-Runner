package com.bytedance.sdk.component.omh;

/* JADX INFO: loaded from: classes11.dex */
public abstract class omh implements Comparable<omh>, Runnable {
    private String Og;
    private int pA;

    public omh(String str, int i) {
        this.pA = 0;
        this.pA = i == 0 ? 5 : i;
        this.Og = str;
    }

    public omh(String str) {
        this.pA = 5;
        this.Og = str;
    }

    public void setPriority(int i) {
        this.pA = i;
    }

    public int getPriority() {
        return this.pA;
    }

    @Override // java.lang.Comparable
    public int compareTo(omh omhVar) {
        if (getPriority() < omhVar.getPriority()) {
            return 1;
        }
        return getPriority() >= omhVar.getPriority() ? -1 : 0;
    }

    public String getName() {
        return this.Og;
    }
}
