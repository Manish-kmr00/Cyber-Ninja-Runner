package com.fyber.inneractive.sdk.external;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes12.dex */
public class ImpressionData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Pricing f1749a = new Pricing();
    public Video b;
    public String c;
    public Long d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;

    public static class Pricing {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public double f1750a;
        public String b;

        public String getCurrency() {
            return this.b;
        }

        public double getValue() {
            return this.f1750a;
        }

        public void setValue(double d) {
            this.f1750a = d;
        }

        public String toString() {
            return "Pricing{value=" + this.f1750a + ", currency='" + this.b + "'}";
        }
    }

    public static class Video {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f1751a;
        public long b;

        public Video(boolean z, long j) {
            this.f1751a = z;
            this.b = j;
        }

        public long getDuration() {
            return this.b;
        }

        public boolean isSkippable() {
            return this.f1751a;
        }

        public String toString() {
            return "Video{skippable=" + this.f1751a + ", duration=" + this.b + AbstractJsonLexerKt.END_OBJ;
        }
    }

    public String getAdvertiserDomain() {
        return this.i;
    }

    public String getCampaignId() {
        return this.h;
    }

    public String getCountry() {
        return this.e;
    }

    public String getCreativeId() {
        return this.g;
    }

    public Long getDemandId() {
        return this.d;
    }

    public String getDemandSource() {
        return this.c;
    }

    public String getImpressionId() {
        return this.f;
    }

    public Pricing getPricing() {
        return this.f1749a;
    }

    public Video getVideo() {
        return this.b;
    }

    public void setAdvertiserDomain(String str) {
        this.i = str;
    }

    public void setCampaignId(String str) {
        this.h = str;
    }

    public void setCountry(String str) {
        this.e = str;
    }

    public void setCpmValue(String str) {
        double d;
        try {
            d = Double.parseDouble(str);
        } catch (Exception unused) {
            d = 0.0d;
        }
        this.f1749a.f1750a = d;
    }

    public void setCreativeId(String str) {
        this.g = str;
    }

    public void setCurrency(String str) {
        this.f1749a.b = str;
    }

    public void setDemandId(Long l) {
        this.d = l;
    }

    public void setDemandSource(String str) {
        this.c = str;
    }

    public void setDuration(long j) {
        this.b.b = j;
    }

    public void setImpressionId(String str) {
        this.f = str;
    }

    public void setPricing(Pricing pricing) {
        this.f1749a = pricing;
    }

    public void setVideo(Video video) {
        this.b = video;
    }

    public String toString() {
        return "ImpressionData{pricing=" + this.f1749a + ", video=" + this.b + ", demandSource='" + this.c + "', country='" + this.e + "', impressionId='" + this.f + "', creativeId='" + this.g + "', campaignId='" + this.h + "', advertiserDomain='" + this.i + "'}";
    }
}
