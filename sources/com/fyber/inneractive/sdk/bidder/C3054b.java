package com.fyber.inneractive.sdk.bidder;

import android.adservices.topics.EncryptedTopic;
import android.adservices.topics.Topic;
import android.app.NotificationManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.fyber.inneractive.sdk.config.AbstractC3081k;
import com.fyber.inneractive.sdk.config.AbstractC3090u;
import com.fyber.inneractive.sdk.config.C3077g;
import com.fyber.inneractive.sdk.config.C3091v;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.X;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveUserConfig;
import com.fyber.inneractive.sdk.protobuf.AbstractC3169a0;
import com.fyber.inneractive.sdk.protobuf.AbstractC3221s;
import com.fyber.inneractive.sdk.protobuf.C3216q;
import com.fyber.inneractive.sdk.protobuf.InterfaceC3210o;
import com.fyber.inneractive.sdk.protobuf.Z;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.a0;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import net.pubnative.lite.sdk.models.Protocol;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.bidder.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3054b implements InterfaceC3057e, X, com.fyber.inneractive.sdk.config.cellular.h {
    public static final C3054b h = new C3054b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C3063k f1628a;
    public final com.fyber.inneractive.sdk.serverapi.c b;
    public final C3056d c;
    public C3058f d;
    public final AtomicReference e = new AtomicReference(null);
    public final AtomicBoolean f = new AtomicBoolean(false);
    public final Object g = new Object();

    public C3054b() {
        com.fyber.inneractive.sdk.config.cellular.a aVar;
        com.fyber.inneractive.sdk.serverapi.c cVar = new com.fyber.inneractive.sdk.serverapi.c(com.fyber.inneractive.sdk.config.global.r.a());
        this.b = cVar;
        C3056d c3056d = new C3056d(cVar);
        this.c = c3056d;
        this.f1628a = TokenParametersOuterClass$TokenParameters.newBuilder();
        IAConfigManager iAConfigManager = IAConfigManager.O;
        iAConfigManager.x.d = this;
        if (iAConfigManager.u.b.a(true, "bidding_token_wait_for_ua")) {
            iAConfigManager.y.e();
            c3056d.b = iAConfigManager.y.a();
        }
        if (!InneractiveAdManager.isCurrentUserAChild() && (aVar = iAConfigManager.N) != null) {
            try {
                aVar.c.add(this);
            } catch (Throwable th) {
                IAlog.a("failed to add network observer", th, new Object[0]);
            }
        }
        C3058f c3058f = new C3058f(this);
        this.d = c3058f;
        c3058f.a();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final byte[] a() {
        JSONArray jSONArrayA;
        L l;
        byte b;
        byte b2;
        S s;
        L l2;
        String str;
        C3063k c3063k = this.f1628a;
        c3063k.b = (AbstractC3169a0) c3063k.b.dynamicMethod(Z.NEW_MUTABLE_INSTANCE);
        C3063k c3063k2 = this.f1628a;
        this.c.getClass();
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringA = AbstractC3060h.a(POBNativeConstants.NATIVE_DEFAULT_VERSION);
        c3063k2.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k2.b).setVersion(nullableStringA);
        if (this.e.get() != null) {
            this.c.a();
        }
        C3063k c3063k3 = this.f1628a;
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringA2 = AbstractC3060h.a(this.c.b);
        c3063k3.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k3.b).setUserAgent(nullableStringA2);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringA3 = AbstractC3060h.a(this.c.c);
        c3063k3.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k3.b).setSdkVersion(nullableStringA3);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringA4 = AbstractC3060h.a(this.c.d);
        c3063k3.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k3.b).setBundleID(nullableStringA4);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringA5 = AbstractC3060h.a(this.c.e);
        c3063k3.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k3.b).setDeviceModel(nullableStringA5);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringA6 = AbstractC3060h.a(this.c.f);
        c3063k3.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k3.b).setAppVersion(nullableStringA6);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringA7 = AbstractC3060h.a("Android");
        c3063k3.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k3.b).setDeviceOS(nullableStringA7);
        TokenParametersOuterClass$TokenParameters.NullableUInt32 nullableUInt32A = AbstractC3060h.a(Build.VERSION.SDK_INT);
        c3063k3.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k3.b).setDeviceApi(nullableUInt32A);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringA8 = AbstractC3060h.a(Build.VERSION.RELEASE);
        c3063k3.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k3.b).setOsVersion(nullableStringA8);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringA9 = AbstractC3060h.a(this.c.g);
        c3063k3.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k3.b).setDeviceLanguage(nullableStringA9);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringA10 = AbstractC3060h.a(this.c.h);
        c3063k3.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k3.b).setCountryCode(nullableStringA10);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringA11 = AbstractC3060h.a(this.c.i);
        c3063k3.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k3.b).setCarrierName(nullableStringA11);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringA12 = AbstractC3060h.a(this.c.j);
        c3063k3.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k3.b).setMobileCountryCode(nullableStringA12);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringA13 = AbstractC3060h.a(this.c.k);
        c3063k3.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k3.b).setMobileNetworkCode(nullableStringA13);
        Long l3 = this.c.l;
        x xVarNewBuilder = TokenParametersOuterClass$TokenParameters.NullableSInt32.newBuilder();
        if (l3 != null) {
            int iIntValue = l3.intValue();
            xVarNewBuilder.c();
            ((TokenParametersOuterClass$TokenParameters.NullableSInt32) xVarNewBuilder.b).setData(iIntValue);
        }
        TokenParametersOuterClass$TokenParameters.NullableSInt32 nullableSInt32 = (TokenParametersOuterClass$TokenParameters.NullableSInt32) xVarNewBuilder.a();
        c3063k3.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k3.b).setOffsetFromGMT(nullableSInt32);
        IAConfigManager iAConfigManager = IAConfigManager.O;
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringA14 = AbstractC3060h.a(iAConfigManager.D.g);
        c3063k3.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k3.b).setUserID(nullableStringA14);
        TokenParametersOuterClass$TokenParameters.NullableUInt32 nullableUInt32A2 = AbstractC3060h.a(this.c.m);
        c3063k3.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k3.b).setDeviceWidth(nullableUInt32A2);
        TokenParametersOuterClass$TokenParameters.NullableUInt32 nullableUInt32A3 = AbstractC3060h.a(this.c.n);
        c3063k3.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k3.b).setDeviceHeight(nullableUInt32A3);
        EnumC3069q enumC3069q = this.c.o;
        c3063k3.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k3.b).setFrameworkName(enumC3069q);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringA15 = AbstractC3060h.a(this.c.p);
        c3063k3.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k3.b).setInputLanguages(nullableStringA15);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringA16 = AbstractC3060h.a(this.c.H);
        c3063k3.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k3.b).setMediationType(nullableStringA16);
        this.c.getClass();
        com.fyber.inneractive.sdk.ignite.l lVar = iAConfigManager.E.p;
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringA17 = AbstractC3060h.a(lVar != null ? lVar.getOdt() : "");
        c3063k3.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k3.b).setOdt(nullableStringA17);
        Integer numA = com.fyber.inneractive.sdk.serverapi.b.a();
        z zVarNewBuilder = TokenParametersOuterClass$TokenParameters.NullableUInt32.newBuilder();
        if (numA != null) {
            int iIntValue2 = numA.intValue();
            zVarNewBuilder.c();
            ((TokenParametersOuterClass$TokenParameters.NullableUInt32) zVarNewBuilder.b).setData(iIntValue2);
        }
        TokenParametersOuterClass$TokenParameters.NullableUInt32 nullableUInt32 = (TokenParametersOuterClass$TokenParameters.NullableUInt32) zVarNewBuilder.a();
        c3063k3.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k3.b).setAdServicesVersion(nullableUInt32);
        C3077g c3077g = iAConfigManager.D;
        if (c3077g != null) {
            C3063k c3063k4 = this.f1628a;
            if (c3077g.d == null) {
                c3077g.e = c3077g.h();
            }
            if (AbstractC3251o.f2370a == null) {
                str = null;
            } else {
                str = c3077g.d;
                if (str == null) {
                    str = c3077g.e;
                }
            }
            TokenParametersOuterClass$TokenParameters.NullableString nullableStringA18 = AbstractC3060h.a(str);
            c3063k4.c();
            ((TokenParametersOuterClass$TokenParameters) c3063k4.b).setGdprString(nullableStringA18);
            TokenParametersOuterClass$TokenParameters.NullableBool nullableBoolA = AbstractC3060h.a(c3077g.d());
            c3063k4.c();
            ((TokenParametersOuterClass$TokenParameters) c3063k4.b).setGdprConsent(nullableBoolA);
            TokenParametersOuterClass$TokenParameters.NullableString nullableStringA19 = AbstractC3060h.a(AbstractC3251o.f2370a == null ? null : c3077g.h);
            c3063k4.c();
            ((TokenParametersOuterClass$TokenParameters) c3063k4.b).setCcpaString(nullableStringA19);
            TokenParametersOuterClass$TokenParameters.NullableBool nullableBoolA2 = AbstractC3060h.a(AbstractC3251o.f2370a == null ? null : c3077g.i);
            c3063k4.c();
            ((TokenParametersOuterClass$TokenParameters) c3063k4.b).setLgpdConsent(nullableBoolA2);
            Boolean bool = c3077g.j;
            if (bool != null && bool.booleanValue()) {
                C3063k c3063k5 = this.f1628a;
                TokenParametersOuterClass$TokenParameters.NullableBool nullableBoolA3 = AbstractC3060h.a(bool);
                c3063k5.c();
                ((TokenParametersOuterClass$TokenParameters) c3063k5.b).setCoppaApplies(nullableBoolA3);
            }
        }
        char c = 0;
        if (!InneractiveAdManager.isCurrentUserAChild()) {
            C3063k c3063k6 = this.f1628a;
            C3091v c3091v = AbstractC3090u.f1727a.b;
            boolean z = c3091v != null ? c3091v.b : false;
            c3063k6.c();
            ((TokenParametersOuterClass$TokenParameters) c3063k6.b).setDnt(z);
            this.b.getClass();
            TokenParametersOuterClass$TokenParameters.NullableString nullableStringA20 = AbstractC3060h.a(iAConfigManager.r);
            c3063k6.c();
            ((TokenParametersOuterClass$TokenParameters) c3063k6.b).setAppSetId(nullableStringA20);
        }
        C3063k c3063k7 = this.f1628a;
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringA21 = AbstractC3060h.a(this.c.q);
        c3063k7.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k7.b).setNetwork(nullableStringA21);
        D d = this.c.r;
        c3063k7.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k7.b).setSecureContent(d);
        TokenParametersOuterClass$TokenParameters.NullableBool nullableBoolA4 = AbstractC3060h.a(this.c.B);
        c3063k7.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k7.b).setBatteryCharging(nullableBoolA4);
        TokenParametersOuterClass$TokenParameters.NullableBool nullableBoolA5 = AbstractC3060h.a(this.c.s);
        c3063k7.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k7.b).setHeadsetPlugged(nullableBoolA5);
        TokenParametersOuterClass$TokenParameters.NullableBool nullableBoolA6 = AbstractC3060h.a(this.c.t);
        c3063k7.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k7.b).setBluetoothPlugged(nullableBoolA6);
        TokenParametersOuterClass$TokenParameters.NullableBool nullableBoolA7 = AbstractC3060h.a(this.c.u);
        c3063k7.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k7.b).setLowPowerMode(nullableBoolA7);
        boolean z2 = this.c.v;
        c3063k7.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k7.b).setDarkMode(z2);
        TokenParametersOuterClass$TokenParameters.NullableBool nullableBoolA8 = AbstractC3060h.a(this.c.w);
        c3063k7.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k7.b).setAirplaneMode(nullableBoolA8);
        TokenParametersOuterClass$TokenParameters.NullableBool nullableBoolA9 = AbstractC3060h.a(this.c.x);
        c3063k7.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k7.b).setDndMode(nullableBoolA9);
        TokenParametersOuterClass$TokenParameters.NullableBool nullableBoolA10 = AbstractC3060h.a(this.c.y);
        c3063k7.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k7.b).setIsRingMuted(nullableBoolA10);
        TokenParametersOuterClass$TokenParameters.NullableUInt32 nullableUInt32A4 = AbstractC3060h.a(this.c.z);
        c3063k7.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k7.b).setSessionDuration(nullableUInt32A4);
        String str2 = this.c.C;
        z zVarNewBuilder2 = TokenParametersOuterClass$TokenParameters.NullableUInt32.newBuilder();
        if (!TextUtils.isEmpty(str2)) {
            int i = Integer.parseInt(str2);
            zVarNewBuilder2.c();
            ((TokenParametersOuterClass$TokenParameters.NullableUInt32) zVarNewBuilder2.b).setData(i);
        }
        TokenParametersOuterClass$TokenParameters.NullableUInt32 nullableUInt33 = (TokenParametersOuterClass$TokenParameters.NullableUInt32) zVarNewBuilder2.a();
        c3063k7.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k7.b).setBatteryLevel(nullableUInt33);
        TokenParametersOuterClass$TokenParameters.NullableBool nullableBoolA11 = AbstractC3060h.a(Boolean.valueOf(TextUtils.equals(iAConfigManager.x.a(UnitDisplayType.INTERSTITIAL, "LAST_VAST_SKIPED"), "1")));
        c3063k7.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k7.b).setPriorSkip(nullableBoolA11);
        TokenParametersOuterClass$TokenParameters.NullableUInt32 nullableUInt32A5 = AbstractC3060h.a(this.c.D);
        c3063k7.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k7.b).setUserAge(nullableUInt32A5);
        InneractiveUserConfig.Gender gender = this.c.E;
        N n = gender == InneractiveUserConfig.Gender.FEMALE ? N.FEMALE : gender == InneractiveUserConfig.Gender.MALE ? N.MALE : N.UNKNOWN;
        c3063k7.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k7.b).setUserGender(n);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringA22 = AbstractC3060h.a(this.c.G);
        c3063k7.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k7.b).setZipCode(nullableStringA22);
        boolean z3 = this.c.F;
        c3063k7.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k7.b).setMuteAudio(z3);
        TokenParametersOuterClass$TokenParameters.NullableBool nullableBoolA12 = AbstractC3060h.a(this.c.L);
        c3063k7.c();
        ((TokenParametersOuterClass$TokenParameters) c3063k7.b).setMediaMuted(nullableBoolA12);
        C3091v c3091v2 = AbstractC3090u.f1727a.b;
        if (c3091v2 != null ? c3091v2.c : false) {
            C3063k c3063k8 = this.f1628a;
            TokenParametersOuterClass$TokenParameters.NullableString nullableStringA23 = AbstractC3060h.a(this.c.A);
            c3063k8.c();
            ((TokenParametersOuterClass$TokenParameters) c3063k8.b).setAmazonId(nullableStringA23);
        } else {
            C3063k c3063k9 = this.f1628a;
            TokenParametersOuterClass$TokenParameters.NullableString nullableStringA24 = AbstractC3060h.a(this.c.A);
            c3063k9.c();
            ((TokenParametersOuterClass$TokenParameters) c3063k9.b).setAaid(nullableStringA24);
        }
        UnitDisplayType[] unitDisplayTypeArrValues = UnitDisplayType.values();
        int length = unitDisplayTypeArrValues.length;
        int i2 = 0;
        while (true) {
            byte b3 = 1;
            if (i2 >= length) {
                com.fyber.inneractive.sdk.serverapi.c cVar = this.b;
                cVar.getClass();
                com.fyber.inneractive.sdk.config.global.r rVarA = com.fyber.inneractive.sdk.config.global.r.a();
                cVar.f2325a = rVarA;
                rVarA.a(false, "");
                com.fyber.inneractive.sdk.config.global.r rVar = this.b.f2325a;
                if (rVar != null) {
                    jSONArrayA = com.fyber.inneractive.sdk.config.global.g.a(rVar.b, true);
                    IAlog.a("%s: active experiments json set = %s", "SupportedFeaturesProvider", jSONArrayA);
                } else {
                    jSONArrayA = null;
                }
                if (jSONArrayA != null) {
                    for (int i3 = 0; i3 < jSONArrayA.length(); i3++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayA.optJSONObject(i3);
                        if (jSONObjectOptJSONObject != null) {
                            C3066n c3066nNewBuilder = TokenParametersOuterClass$TokenParameters.Experiment.newBuilder();
                            String strOptString = jSONObjectOptJSONObject.optString("id");
                            c3066nNewBuilder.c();
                            ((TokenParametersOuterClass$TokenParameters.Experiment) c3066nNewBuilder.b).setIdentifier(strOptString);
                            String strOptString2 = jSONObjectOptJSONObject.optString("v");
                            c3066nNewBuilder.c();
                            ((TokenParametersOuterClass$TokenParameters.Experiment) c3066nNewBuilder.b).setVariant(strOptString2);
                            C3063k c3063k10 = this.f1628a;
                            TokenParametersOuterClass$TokenParameters.Experiment experiment = (TokenParametersOuterClass$TokenParameters.Experiment) c3066nNewBuilder.a();
                            c3063k10.c();
                            ((TokenParametersOuterClass$TokenParameters) c3063k10.b).addAbExperiments(experiment);
                        }
                    }
                }
                C3063k c3063k11 = this.f1628a;
                int i4 = AbstractC3081k.f1710a;
                String property = System.getProperty("ia.testEnvironmentConfiguration.number");
                z zVarNewBuilder3 = TokenParametersOuterClass$TokenParameters.NullableUInt32.newBuilder();
                if (!TextUtils.isEmpty(property)) {
                    int i5 = Integer.parseInt(property);
                    zVarNewBuilder3.c();
                    ((TokenParametersOuterClass$TokenParameters.NullableUInt32) zVarNewBuilder3.b).setData(i5);
                }
                TokenParametersOuterClass$TokenParameters.NullableUInt32 nullableUInt34 = (TokenParametersOuterClass$TokenParameters.NullableUInt32) zVarNewBuilder3.a();
                c3063k11.c();
                ((TokenParametersOuterClass$TokenParameters) c3063k11.b).setPortal(nullableUInt34);
                C3063k c3063k12 = this.f1628a;
                TokenParametersOuterClass$TokenParameters.NullableString nullableStringA25 = AbstractC3060h.a(System.getProperty("ia.testEnvironmentConfiguration.response"));
                c3063k12.c();
                ((TokenParametersOuterClass$TokenParameters) c3063k12.b).setMockResponseId(nullableStringA25);
                C3063k c3063k13 = this.f1628a;
                TokenParametersOuterClass$TokenParameters.NullableString nullableStringA26 = AbstractC3060h.a(this.c.I);
                c3063k13.c();
                ((TokenParametersOuterClass$TokenParameters) c3063k13.b).setIgniteVersion(nullableStringA26);
                C3063k c3063k14 = this.f1628a;
                TokenParametersOuterClass$TokenParameters.NullableString nullableStringA27 = AbstractC3060h.a(this.c.J);
                c3063k14.c();
                ((TokenParametersOuterClass$TokenParameters) c3063k14.b).setIgnitePackageName(nullableStringA27);
                if (this.c.K) {
                    C3063k c3063k15 = this.f1628a;
                    TokenParametersOuterClass$TokenParameters.NullableBool nullableBoolA13 = AbstractC3060h.a(Boolean.TRUE);
                    c3063k15.c();
                    ((TokenParametersOuterClass$TokenParameters) c3063k15.b).setChildMode(nullableBoolA13);
                }
                ArrayList<EncryptedTopic> arrayList = this.c.M;
                if (IAConfigManager.c() && arrayList != null && !arrayList.isEmpty()) {
                    for (EncryptedTopic encryptedTopic : arrayList) {
                        C3064l c3064lNewBuilder = TokenParametersOuterClass$TokenParameters.EncryptedTopic.newBuilder();
                        byte[] encryptedTopic2 = encryptedTopic.getEncryptedTopic();
                        C3216q c3216q = AbstractC3221s.b;
                        int length2 = encryptedTopic2.length;
                        AbstractC3221s.a(0, length2, encryptedTopic2.length);
                        InterfaceC3210o interfaceC3210o = AbstractC3221s.c;
                        C3216q c3216q2 = new C3216q(interfaceC3210o.a(encryptedTopic2, 0, length2));
                        c3064lNewBuilder.c();
                        ((TokenParametersOuterClass$TokenParameters.EncryptedTopic) c3064lNewBuilder.b).setEncryptedTopic(c3216q2);
                        String keyIdentifier = encryptedTopic.getKeyIdentifier();
                        c3064lNewBuilder.c();
                        ((TokenParametersOuterClass$TokenParameters.EncryptedTopic) c3064lNewBuilder.b).setKeyIdentifier(keyIdentifier);
                        byte[] encapsulatedKey = encryptedTopic.getEncapsulatedKey();
                        int length3 = encapsulatedKey.length;
                        AbstractC3221s.a(0, length3, encapsulatedKey.length);
                        C3216q c3216q3 = new C3216q(interfaceC3210o.a(encapsulatedKey, 0, length3));
                        c3064lNewBuilder.c();
                        ((TokenParametersOuterClass$TokenParameters.EncryptedTopic) c3064lNewBuilder.b).setEncapsulatedKey(c3216q3);
                        TokenParametersOuterClass$TokenParameters.EncryptedTopic encryptedTopic3 = (TokenParametersOuterClass$TokenParameters.EncryptedTopic) c3064lNewBuilder.a();
                        C3063k c3063k16 = this.f1628a;
                        c3063k16.c();
                        ((TokenParametersOuterClass$TokenParameters) c3063k16.b).addEncryptedTopics(encryptedTopic3);
                    }
                }
                ArrayList<Topic> arrayList2 = this.c.N;
                if (arrayList2 != null && !arrayList2.isEmpty()) {
                    for (Topic topic : arrayList2) {
                        G gNewBuilder = TokenParametersOuterClass$TokenParameters.Topic.newBuilder();
                        int topicId = topic.getTopicId();
                        gNewBuilder.c();
                        ((TokenParametersOuterClass$TokenParameters.Topic) gNewBuilder.b).setTopicId(topicId);
                        long modelVersion = topic.getModelVersion();
                        gNewBuilder.c();
                        ((TokenParametersOuterClass$TokenParameters.Topic) gNewBuilder.b).setModelVersion(modelVersion);
                        long taxonomyVersion = topic.getTaxonomyVersion();
                        gNewBuilder.c();
                        ((TokenParametersOuterClass$TokenParameters.Topic) gNewBuilder.b).setTaxonomyVersion(taxonomyVersion);
                        TokenParametersOuterClass$TokenParameters.Topic topic2 = (TokenParametersOuterClass$TokenParameters.Topic) gNewBuilder.a();
                        C3063k c3063k17 = this.f1628a;
                        c3063k17.c();
                        ((TokenParametersOuterClass$TokenParameters) c3063k17.b).addTopics(topic2);
                    }
                }
                return ((TokenParametersOuterClass$TokenParameters) this.f1628a.a()).toByteArray();
            }
            UnitDisplayType unitDisplayType = unitDisplayTypeArrValues[i2];
            if (!unitDisplayType.isDeprecated()) {
                int[] iArr = AbstractC3059g.f1632a;
                int i6 = iArr[unitDisplayType.ordinal()];
                if (i6 == 1) {
                    l = L.BANNER;
                } else if (i6 == 2) {
                    l = L.INTERSTITIAL;
                } else if (i6 != 3) {
                    l = i6 != 4 ? L.UNITDISPLAYTYPEUNKNOWN : L.MRECT;
                } else {
                    l = L.REWARDED;
                }
                com.fyber.inneractive.sdk.serverapi.a aVar = com.fyber.inneractive.sdk.serverapi.b.f2324a;
                IAConfigManager iAConfigManager2 = IAConfigManager.O;
                String strA = iAConfigManager2.x.a(unitDisplayType, "LAST_DOMAIN_SHOWED");
                if (!TextUtils.isEmpty(strA) && strA.contains(StringUtils.COMMA)) {
                    strA = strA.split(StringUtils.COMMA)[c];
                }
                if (!TextUtils.isEmpty(strA)) {
                    C3063k c3063k18 = this.f1628a;
                    r rVarNewBuilder = TokenParametersOuterClass$TokenParameters.LastAdomain.newBuilder();
                    rVarNewBuilder.c();
                    ((TokenParametersOuterClass$TokenParameters.LastAdomain) rVarNewBuilder.b).setAdomain(strA);
                    rVarNewBuilder.c();
                    ((TokenParametersOuterClass$TokenParameters.LastAdomain) rVarNewBuilder.b).setType(l);
                    TokenParametersOuterClass$TokenParameters.LastAdomain lastAdomain = (TokenParametersOuterClass$TokenParameters.LastAdomain) rVarNewBuilder.a();
                    c3063k18.c();
                    ((TokenParametersOuterClass$TokenParameters) c3063k18.b).addLastAdomains(lastAdomain);
                }
                String strA2 = iAConfigManager2.x.a(unitDisplayType, "LAST_APP_BUNDLE_ID");
                if (!TextUtils.isEmpty(strA2)) {
                    C3063k c3063k19 = this.f1628a;
                    t tVarNewBuilder = TokenParametersOuterClass$TokenParameters.LastAdvertisedBundle.newBuilder();
                    tVarNewBuilder.c();
                    ((TokenParametersOuterClass$TokenParameters.LastAdvertisedBundle) tVarNewBuilder.b).setLastBundle(strA2);
                    tVarNewBuilder.c();
                    ((TokenParametersOuterClass$TokenParameters.LastAdvertisedBundle) tVarNewBuilder.b).setType(l);
                    TokenParametersOuterClass$TokenParameters.LastAdvertisedBundle lastAdvertisedBundle = (TokenParametersOuterClass$TokenParameters.LastAdvertisedBundle) tVarNewBuilder.a();
                    c3063k19.c();
                    ((TokenParametersOuterClass$TokenParameters) c3063k19.b).addLastAdvertisedBundles(lastAdvertisedBundle);
                }
                if (TextUtils.equals(iAConfigManager2.x.a(unitDisplayType, "LAST_CLICKED"), "1")) {
                    C3063k c3063k20 = this.f1628a;
                    int i7 = iArr[unitDisplayType.ordinal()];
                    if (i7 == 1) {
                        b = 3;
                        b2 = 4;
                        l2 = L.BANNER;
                    } else if (i7 != 2) {
                        b = 3;
                        if (i7 != 3) {
                            b2 = 4;
                            l2 = i7 != 4 ? L.UNITDISPLAYTYPEUNKNOWN : L.MRECT;
                        } else {
                            b2 = 4;
                            l2 = L.REWARDED;
                        }
                    } else {
                        b = 3;
                        b2 = 4;
                        l2 = L.INTERSTITIAL;
                    }
                    c3063k20.c();
                    ((TokenParametersOuterClass$TokenParameters) c3063k20.b).addPriorClicks(l2);
                } else {
                    b = 3;
                    b2 = 4;
                }
                a("display", unitDisplayType, l);
                if (unitDisplayType.isFullscreenUnit()) {
                    a("video", unitDisplayType, l);
                    String strA3 = iAConfigManager2.x.a(unitDisplayType, "LAST_VAST_CLICKED_TYPE");
                    if (!TextUtils.isEmpty(strA3)) {
                        C3063k c3063k21 = this.f1628a;
                        A aNewBuilder = TokenParametersOuterClass$TokenParameters.PriorVideoClickType.newBuilder();
                        strA3.getClass();
                        strA3.hashCode();
                        switch (strA3.hashCode()) {
                            case 49:
                                b3 = strA3.equals("1") ? (byte) 0 : (byte) -1;
                                break;
                            case 50:
                                if (!strA3.equals("2")) {
                                    b3 = -1;
                                }
                                break;
                            case 51:
                                b3 = strA3.equals("3") ? (byte) 2 : (byte) -1;
                                break;
                            case 52:
                                b3 = strA3.equals(Protocol.VAST_1_0_WRAPPER) ? b : (byte) -1;
                                break;
                            case 53:
                                b3 = strA3.equals("5") ? b2 : (byte) -1;
                                break;
                            default:
                                b3 = -1;
                                break;
                        }
                        switch (b3) {
                            case 0:
                                s = S.CTABUTTON;
                                break;
                            case 1:
                                s = S.COMPANION;
                                break;
                            case 2:
                                s = S.VIDEOVIEW;
                                break;
                            case 3:
                                s = S.APPINFO;
                                break;
                            case 4:
                                s = S.STOREPROMO;
                                break;
                            default:
                                s = S.NOCLICK;
                                break;
                        }
                        aNewBuilder.c();
                        ((TokenParametersOuterClass$TokenParameters.PriorVideoClickType) aNewBuilder.b).setClickType(s);
                        aNewBuilder.c();
                        ((TokenParametersOuterClass$TokenParameters.PriorVideoClickType) aNewBuilder.b).setType(l);
                        TokenParametersOuterClass$TokenParameters.PriorVideoClickType priorVideoClickType = (TokenParametersOuterClass$TokenParameters.PriorVideoClickType) aNewBuilder.a();
                        c3063k21.c();
                        ((TokenParametersOuterClass$TokenParameters) c3063k21.b).addPriorClickTypes(priorVideoClickType);
                    }
                }
            }
            i2++;
            c = 0;
        }
    }

    public final void b() {
        if (this.f.compareAndSet(false, true)) {
            try {
                this.e.set(Base64.encodeToString(a(), 2));
            } catch (Throwable th) {
                IAlog.b("Failed to generate token with error: %s", th.getMessage());
            }
            this.f.set(false);
        }
    }

    public final void c() {
        int currentInterruptionFilter = ((NotificationManager) AbstractC3251o.f2370a.getSystemService("notification")).getCurrentInterruptionFilter();
        boolean z = currentInterruptionFilter >= 2 && currentInterruptionFilter <= 4;
        Boolean bool = this.c.x;
        if (bool == null || bool.booleanValue() != z) {
            this.c.x = Boolean.valueOf(z);
            d();
        }
    }

    public final void d() {
        com.fyber.inneractive.sdk.util.r.f2374a.execute(new RunnableC3053a(this));
    }

    @Override // com.fyber.inneractive.sdk.config.cellular.h
    public final void a(a0 a0Var) {
        if (TextUtils.equals(this.c.q, a0Var.b())) {
            return;
        }
        this.c.q = a0Var.b();
        d();
    }

    public final void a(String str, UnitDisplayType unitDisplayType, L l) {
        ArrayList<com.fyber.inneractive.sdk.cache.session.g> arrayList;
        int i;
        J j;
        IAConfigManager iAConfigManager = IAConfigManager.O;
        com.fyber.inneractive.sdk.cache.session.e eVar = iAConfigManager.x.f1684a;
        if (eVar != null) {
            com.fyber.inneractive.sdk.cache.session.k kVar = (com.fyber.inneractive.sdk.cache.session.k) eVar.b.get(com.fyber.inneractive.sdk.cache.session.enums.c.a(unitDisplayType.value(), str));
            TokenParametersOuterClass$TokenParameters.UserSession userSession = null;
            if (kVar != null) {
                ArrayList arrayList2 = new ArrayList(kVar);
                Collections.sort(arrayList2, new com.fyber.inneractive.sdk.cache.session.j());
                arrayList = new ArrayList(arrayList2);
            } else {
                arrayList = null;
            }
            try {
                i = Integer.parseInt(iAConfigManager.u.b.a("number_of_sessions", Integer.toString(5)));
            } catch (Throwable unused) {
                i = 5;
            }
            int i2 = i >= 0 ? i : 5;
            if (i2 > 0 && arrayList != null && arrayList.size() >= i2) {
                if (str.equals("video")) {
                    j = J.VIDEO;
                } else if (!str.equals("display")) {
                    j = J.UNITCONTENTTYPEUNKNOWN;
                } else {
                    j = J.DISPLAY;
                }
                O oNewBuilder = TokenParametersOuterClass$TokenParameters.UserSession.newBuilder();
                oNewBuilder.c();
                ((TokenParametersOuterClass$TokenParameters.UserSession) oNewBuilder.b).setSubType(j);
                int i3 = 0;
                for (com.fyber.inneractive.sdk.cache.session.g gVar : arrayList) {
                    E eNewBuilder = TokenParametersOuterClass$TokenParameters.SessionData.newBuilder();
                    int i4 = gVar.b;
                    eNewBuilder.c();
                    ((TokenParametersOuterClass$TokenParameters.SessionData) eNewBuilder.b).setClicks(i4);
                    int i5 = gVar.f1650a;
                    eNewBuilder.c();
                    ((TokenParametersOuterClass$TokenParameters.SessionData) eNewBuilder.b).setImpressions(i5);
                    if (str.equals("video") || l.equals(L.REWARDED)) {
                        int i6 = gVar.c;
                        eNewBuilder.c();
                        ((TokenParametersOuterClass$TokenParameters.SessionData) eNewBuilder.b).setCompletions(i6);
                    }
                    TokenParametersOuterClass$TokenParameters.SessionData sessionData = (TokenParametersOuterClass$TokenParameters.SessionData) eNewBuilder.a();
                    oNewBuilder.c();
                    ((TokenParametersOuterClass$TokenParameters.UserSession) oNewBuilder.b).addSessionDataItems(sessionData);
                    i3++;
                    if (i3 >= i2) {
                        break;
                    }
                }
                oNewBuilder.c();
                ((TokenParametersOuterClass$TokenParameters.UserSession) oNewBuilder.b).setType(l);
                userSession = (TokenParametersOuterClass$TokenParameters.UserSession) oNewBuilder.a();
            }
            if (userSession == null || userSession.getSessionDataItemsList().size() <= 0) {
                return;
            }
            C3063k c3063k = this.f1628a;
            c3063k.c();
            ((TokenParametersOuterClass$TokenParameters) c3063k.b).addUserSessions(userSession);
        }
    }
}
