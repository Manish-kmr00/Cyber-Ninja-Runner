package com.mbridge.msdk.click.retry;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashSet;

/* JADX INFO: compiled from: RetryUrlRecordData.java */
/* JADX INFO: loaded from: classes11.dex */
public class b {
    public static int k = 0;
    public static int l = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f4755a;
    private int b;
    private final HashSet<String> c = new HashSet<>();
    private final long d = System.currentTimeMillis();
    private CampaignEx e;
    private String f;
    private int g;
    private boolean h;
    private boolean i;
    private int j;

    public b(String str, String str2) {
        this.f4755a = str;
        a(str2);
    }

    public void a(boolean z) {
        this.h = z;
    }

    public void b(boolean z) {
        this.i = z;
    }

    public long c() {
        return this.d;
    }

    public int d() {
        return this.j;
    }

    public int e() {
        return this.b;
    }

    public String f() {
        return this.f;
    }

    public String g() {
        return this.f4755a;
    }

    public int h() {
        return this.g;
    }

    public boolean i() {
        return this.h;
    }

    public boolean j() {
        return this.i;
    }

    public void a(int i) {
        this.j = i;
    }

    public void b(int i) {
        this.g = i;
    }

    public CampaignEx a() {
        return this.e;
    }

    public void b(String str) {
        this.f = str;
    }

    public void a(CampaignEx campaignEx) {
        this.e = campaignEx;
    }

    public HashSet<String> b() {
        return this.c;
    }

    public void a(String str) {
        this.b++;
        this.c.add(str);
    }
}
