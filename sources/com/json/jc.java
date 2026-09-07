package com.json;

import android.util.Pair;
import com.json.mediationsdk.logger.IronLog;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes10.dex */
public class jc implements Runnable {
    private static final String e = "Content-Type";
    private static final String f = "application/json";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private sf f3809a;
    String b;
    String c;
    ArrayList<zb> d;

    public jc(sf sfVar, String str, String str2, ArrayList<zb> arrayList) {
        this.f3809a = sfVar;
        this.b = str;
        this.c = str2;
        this.d = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        sf.a aVarA;
        sf.a aVar = new sf.a(this.d);
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Pair("Content-Type", "application/json"));
            fq fqVarB = rg.b(this.c, this.b, arrayList);
            aVarA = aVar.a(fqVarB.a()).a(fqVarB.f3701a);
        } catch (Exception e2) {
            o9.d().a(e2);
            IronLog.INTERNAL.error("EventsSender failed to send events - " + e2.getLocalizedMessage());
            aVarA = aVar.a(e2 instanceof go).a(e2);
        }
        sf sfVar = this.f3809a;
        if (sfVar != null) {
            sfVar.a(aVarA);
        }
    }
}
