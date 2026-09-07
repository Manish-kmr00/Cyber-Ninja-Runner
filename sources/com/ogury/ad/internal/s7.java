package com.ogury.ad.internal;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class s7 {
    public static final a b = new a();
    public static s7 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f7401a;

    public static final class a {
        public static s7 a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (s7.c == null) {
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                s7.c = new s7(applicationContext);
            }
            s7 s7Var = s7.c;
            Intrinsics.checkNotNull(s7Var);
            return s7Var;
        }
    }

    public s7(Context context) {
        this.f7401a = context.getSharedPreferences("profig", 0);
    }

    public final void a(long j) {
        this.f7401a.edit().putLong("CACHE_LAST_UPDATE_DATE", j).apply();
    }

    public final void b(long j) {
        this.f7401a.edit().putLong("CACHE_MAX_AGE", j).apply();
    }

    public final void c(String md5ProfigRequestBody) {
        Intrinsics.checkNotNullParameter(md5ProfigRequestBody, "md5ProfigRequestBody");
        this.f7401a.edit().putString("md5Profig", md5ProfigRequestBody).apply();
    }

    public final void d(String fullProfigResponse) {
        Intrinsics.checkNotNullParameter(fullProfigResponse, "fullProfigResponse");
        this.f7401a.edit().putString("fullProfigResponseJson", fullProfigResponse).apply();
    }

    public final void a(int i) {
        this.f7401a.edit().putInt("numberOfProfigApiCalls", i).apply();
    }

    public final void b(String md5PrivacyCompliancyData) {
        Intrinsics.checkNotNullParameter(md5PrivacyCompliancyData, "md5PrivacyCompliancyData");
        this.f7401a.edit().putString("md5Profig", md5PrivacyCompliancyData).apply();
    }

    public final void c() {
        Intrinsics.checkNotNullParameter("5.0.1-404010", "appVersion");
        this.f7401a.edit().putString("appVersion", "5.0.1-404010").apply();
    }

    public final void a() {
        this.f7401a.edit().remove("fullProfigResponseJson").apply();
    }

    public final void a(String apiKey) {
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        this.f7401a.edit().putString("api_key", apiKey).apply();
    }

    public final String b() {
        SharedPreferences sharedPref = this.f7401a;
        Intrinsics.checkNotNullExpressionValue(sharedPref, "sharedPref");
        return p8.a(sharedPref, "api_key");
    }
}
