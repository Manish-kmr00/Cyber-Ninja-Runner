package com.json.mediationsdk;

import com.json.am;
import com.json.m5;
import com.json.mediationsdk.adunit.adapter.utility.AdInfo;
import com.json.mediationsdk.impressionData.ImpressionData;
import com.json.mediationsdk.impressionData.ImpressionDataListener;
import com.json.mediationsdk.logger.IronLog;
import com.json.s;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashSet<ImpressionDataListener> f3990a;
    protected s b;
    protected IronSourceSegment c;
    protected AdInfo d;

    public m(HashSet<ImpressionDataListener> hashSet, IronSourceSegment ironSourceSegment) {
        new HashSet();
        this.f3990a = hashSet;
        this.b = new s();
        this.c = ironSourceSegment;
    }

    protected void a(m5 m5Var, String str) {
        HashSet<ImpressionDataListener> hashSet;
        if (m5Var == null) {
            IronLog.INTERNAL.verbose("no auctionResponseItem or listener");
            return;
        }
        ImpressionData impressionDataA = m5Var.a(str);
        if (impressionDataA != null) {
            synchronized (this) {
                hashSet = (HashSet) this.f3990a.clone();
            }
            for (ImpressionDataListener impressionDataListener : hashSet) {
                IronLog.CALLBACK.info("onImpressionSuccess " + impressionDataListener.getClass().getSimpleName() + ": " + impressionDataA);
                impressionDataListener.onImpressionSuccess(impressionDataA);
            }
        }
    }

    protected void a(IronSource.AD_UNIT ad_unit) {
        this.b.a(ad_unit, false);
    }

    public void a(IronSourceSegment ironSourceSegment) {
        this.c = ironSourceSegment;
    }

    public void a(ImpressionData impressionData, am amVar) {
        if (impressionData != null) {
            this.d = new AdInfo(impressionData, amVar);
        }
    }

    public void a(ImpressionDataListener impressionDataListener) {
        synchronized (this) {
            this.f3990a.remove(impressionDataListener);
        }
    }

    protected void a(JSONObject jSONObject, IronSource.AD_UNIT ad_unit) {
        this.b.a(ad_unit, jSONObject != null ? jSONObject.optBoolean(d.f, false) : false);
    }

    public void b(ImpressionDataListener impressionDataListener) {
        synchronized (this) {
            this.f3990a.add(impressionDataListener);
        }
    }

    public void c() {
        synchronized (this) {
            this.f3990a.clear();
        }
    }

    protected String e() {
        return "fallback_" + System.currentTimeMillis();
    }

    public void f() {
        this.d = null;
    }
}
