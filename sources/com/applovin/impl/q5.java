package com.applovin.impl;

import android.net.Uri;
import android.text.TextUtils;
import com.smaato.sdk.core.dns.DnsName;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class q5 extends g5 {
    private final b g;
    private final String h;
    private String i;

    public interface b {
        void a(b0.b bVar, String str);

        void a(String str, String str2);
    }

    public q5(com.applovin.impl.sdk.k kVar, String str, b bVar) {
        super("TaskFetchAppAdsContent", kVar);
        this.h = str;
        this.g = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList = new ArrayList(Arrays.asList(Uri.parse(this.h).getAuthority().split(DnsName.ESCAPED_DOT)));
        if (arrayList.size() > 0) {
            String str = (String) arrayList.get(0);
            if ("www".equals(str) || "m".equals(str)) {
                arrayList.remove(0);
            }
        }
        String strJoin = TextUtils.join(".", arrayList);
        Uri uriBuild = new Uri.Builder().scheme("https").authority(strJoin).appendPath("app-ads.txt").build();
        com.applovin.impl.sdk.network.a aVarA = com.applovin.impl.sdk.network.a.a(this.f424a).c("GET").b(uriBuild.toString()).a(new Uri.Builder().scheme("http").authority(strJoin).appendPath("app-ads.txt").build().toString()).a((Object) "").a(false).a();
        this.i = uriBuild.toString();
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Looking up app-ads.txt at " + this.i);
        }
        this.f424a.r0().a(new a(aVarA, this.f424a));
    }

    class a extends j6 {
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.k kVar) {
            super(aVar, kVar);
        }

        @Override // com.applovin.impl.j6, com.applovin.impl.q0.e
        public void a(String str, String str2, int i) {
            if (TextUtils.isEmpty(str2)) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.b(this.b, "No app-ads.txt found");
                }
                q5.this.g.a(b0.b.APPADSTXT_NOT_FOUND, q5.this.i);
            } else {
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.a(this.b, "Found app-ads.txt");
                }
                q5.this.g.a(str2, q5.this.i);
            }
        }

        @Override // com.applovin.impl.j6, com.applovin.impl.q0.e
        public void a(String str, int i, String str2, String str3) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Unable to fetch app-ads.txt due to: " + str2 + ", and received error code: " + i);
            }
            q5.this.g.a(b0.b.APPADSTXT_NOT_FOUND, q5.this.i);
        }
    }
}
