package com.bytedance.sdk.component.omh.KZx;

/* JADX INFO: loaded from: classes9.dex */
public abstract class Og implements Comparable<Og>, Runnable {
    private long JG;
    private Runnable KZx;
    private long ML;
    private String Og;
    private long ZZv;
    private int pA;

    public Og(String str) {
        this.pA = 5;
        this.Og = str;
    }

    public Og(int i, String str) {
        this.pA = i;
        this.Og = str;
    }

    public Og(String str, Runnable runnable) {
        this.pA = 5;
        this.Og = str;
        this.KZx = runnable;
    }

    public void pA(int i) {
        this.pA = i;
    }

    public int pA() {
        return this.pA;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
    public int compareTo(Og og) {
        if (pA() < og.pA()) {
            return 1;
        }
        return pA() >= og.pA() ? -1 : 0;
    }

    public String Og() {
        return this.Og;
    }

    public long KZx() {
        return this.ZZv;
    }

    public void pA(long j) {
        this.ZZv = j;
    }

    public long ZZv() {
        return this.ML;
    }

    public void Og(long j) {
        this.ML = j;
    }

    public long ML() {
        return this.JG;
    }

    public void KZx(long j) {
        this.JG = j;
    }

    public long JG() {
        return this.ML - this.ZZv;
    }

    public long SD() {
        return this.JG - this.ML;
    }

    public Runnable omh() {
        return this.KZx;
    }
}
