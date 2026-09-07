package com.inmobi.sdk;

import android.content.Context;
import android.location.Location;
import android.os.SystemClock;
import androidx.autofill.HintConstants;
import com.android.billingclient.api.BillingFlowParams;
import com.facebook.AuthenticationTokenClaims;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.SignalsConfig;
import com.inmobi.media.AbstractC3476mc;
import com.inmobi.media.AbstractC3498o6;
import com.inmobi.media.AbstractC3599v9;
import com.inmobi.media.Ac;
import com.inmobi.media.C3339d5;
import com.inmobi.media.C3435k3;
import com.inmobi.media.C3517pb;
import com.inmobi.media.C3532qc;
import com.inmobi.media.C3549s2;
import com.inmobi.media.C3578u2;
import com.inmobi.media.Eb;
import com.inmobi.media.G9;
import com.inmobi.media.I4;
import com.inmobi.media.I9;
import com.inmobi.media.J5;
import com.inmobi.media.K5;
import com.inmobi.media.Lb;
import com.inmobi.media.O5;
import com.inmobi.media.Ob;
import com.inmobi.media.Q6;
import com.inmobi.media.Sb;
import com.inmobi.media.T4;
import com.inmobi.media.U4;
import com.inmobi.media.X3;
import com.inmobi.unifiedId.InMobiUnifiedIdService;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridge;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001:\u0005PQRSTJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ9\u0010\u000e\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001b\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH\u0007¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\"\u0010\u0016J\u0017\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#H\u0007¢\u0006\u0004\b%\u0010&J\u0019\u0010(\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b(\u0010)J\u0019\u0010+\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b+\u0010)J-\u0010/\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010\u00042\b\u0010-\u001a\u0004\u0018\u00010\u00042\b\u0010.\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u001dH\u0007¢\u0006\u0004\b2\u0010 J\u0017\u00105\u001a\u00020\u00062\u0006\u00104\u001a\u000203H\u0007¢\u0006\u0004\b5\u00106J\u0017\u00109\u001a\u00020\u00062\u0006\u00108\u001a\u000207H\u0007¢\u0006\u0004\b9\u0010:J\u0019\u0010<\u001a\u00020\u00062\b\u0010;\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b<\u0010)J\u0019\u0010>\u001a\u00020\u00062\b\u0010=\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b>\u0010)J\u0019\u0010A\u001a\u00020\u00062\b\u0010@\u001a\u0004\u0018\u00010?H\u0007¢\u0006\u0004\bA\u0010BJ\u0011\u0010C\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\bC\u0010\u0018J1\u0010C\u001a\u0004\u0018\u00010\u00042\u0014\u0010E\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010D2\b\u0010F\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\bC\u0010GJ\u0019\u0010I\u001a\u00020\u00062\b\u0010H\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\bI\u0010\u0011J\u000f\u0010J\u001a\u00020\u0013H\u0007¢\u0006\u0004\bJ\u0010KR\u0014\u0010L\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010N\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0006\n\u0004\bN\u0010MR\u0014\u0010O\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0006\n\u0004\bO\u0010M¨\u0006U"}, d2 = {"Lcom/inmobi/sdk/InMobiSdk;", "", "Lcom/inmobi/sdk/SdkInitializationListener;", "sdkInitializationListener", "", "message", "", "a", "(Lcom/inmobi/sdk/SdkInitializationListener;Ljava/lang/String;)V", "Landroid/content/Context;", "context", BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, "Lorg/json/JSONObject;", "consentObject", "init", "(Landroid/content/Context;Ljava/lang/String;Lorg/json/JSONObject;Lcom/inmobi/sdk/SdkInitializationListener;)V", "updateGDPRConsent", "(Lorg/json/JSONObject;)V", "setPartnerGDPRConsent", "", "muted", "setApplicationMuted", "(Z)V", MobileAdsBridge.versionMethodName, "()Ljava/lang/String;", "Lcom/inmobi/sdk/InMobiSdk$LogLevel;", "logLevel", "setLogLevel", "(Lcom/inmobi/sdk/InMobiSdk$LogLevel;)V", "", "age", "setAge", "(I)V", "isAgeRestricted", "setIsAgeRestricted", "Lcom/inmobi/sdk/InMobiSdk$AgeGroup;", "group", "setAgeGroup", "(Lcom/inmobi/sdk/InMobiSdk$AgeGroup;)V", "areaCode", "setAreaCode", "(Ljava/lang/String;)V", HintConstants.AUTOFILL_HINT_POSTAL_CODE, "setPostalCode", POBConstants.KEY_CITY, "state", "country", "setLocationWithCityStateCountry", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "yearOfBirth", "setYearOfBirth", "Lcom/inmobi/sdk/InMobiSdk$Gender;", "gender", "setGender", "(Lcom/inmobi/sdk/InMobiSdk$Gender;)V", "Lcom/inmobi/sdk/InMobiSdk$Education;", "education", "setEducation", "(Lcom/inmobi/sdk/InMobiSdk$Education;)V", POBConstants.KEY_LANGUAGE, "setLanguage", "interests", "setInterests", "Landroid/location/Location;", "location", "setLocation", "(Landroid/location/Location;)V", "getToken", "", "extras", "keywords", "(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;", "jsonObject", "setPublisherProvidedUnifiedId", "isSDKInitialized", "()Z", "IM_GDPR_CONSENT_AVAILABLE", "Ljava/lang/String;", "IM_GDPR_CONSENT_IAB", "IM_GDPR_CONSENT_GDPR_APPLIES", "AgeGroup", "Education", "Gender", "LogLevel", "PublisherSignals", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class InMobiSdk {
    public static final String IM_GDPR_CONSENT_AVAILABLE = "gdpr_consent_available";
    public static final String IM_GDPR_CONSENT_GDPR_APPLIES = "gdpr";
    public static final String IM_GDPR_CONSENT_IAB = "gdpr_consent";
    public static final InMobiSdk INSTANCE = new InMobiSdk();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/inmobi/sdk/InMobiSdk$AgeGroup;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "BELOW_18", "BETWEEN_18_AND_24", "BETWEEN_25_AND_29", "BETWEEN_30_AND_34", "BETWEEN_35_AND_44", "BETWEEN_45_AND_54", "BETWEEN_55_AND_65", "ABOVE_65", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public enum AgeGroup {
        BELOW_18("below18"),
        BETWEEN_18_AND_24("between18and24"),
        BETWEEN_25_AND_29("between25and29"),
        BETWEEN_30_AND_34("between30and34"),
        BETWEEN_35_AND_44("between35and44"),
        BETWEEN_45_AND_54("between45and54"),
        BETWEEN_55_AND_65("between55and65"),
        ABOVE_65("above65");

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        private final String value;

        AgeGroup(String str) {
            this.value = str;
        }

        public static EnumEntries<AgeGroup> getEntries() {
            return $ENTRIES;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/inmobi/sdk/InMobiSdk$Education;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "HIGH_SCHOOL_OR_LESS", "COLLEGE_OR_GRADUATE", "POST_GRADUATE_OR_ABOVE", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public enum Education {
        HIGH_SCHOOL_OR_LESS("highschoolorless"),
        COLLEGE_OR_GRADUATE("collegeorgraduate"),
        POST_GRADUATE_OR_ABOVE("postgraduateorabove");

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        private final String value;

        Education(String str) {
            this.value = str;
        }

        public static EnumEntries<Education> getEntries() {
            return $ENTRIES;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/inmobi/sdk/InMobiSdk$Gender;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "FEMALE", "MALE", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public enum Gender {
        FEMALE(InneractiveMediationDefs.GENDER_FEMALE),
        MALE("m");

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        private final String value;

        Gender(String str) {
            this.value = str;
        }

        public static EnumEntries<Gender> getEntries() {
            return $ENTRIES;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/inmobi/sdk/InMobiSdk$LogLevel;", "", "(Ljava/lang/String;I)V", "NONE", "ERROR", "DEBUG", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public enum LogLevel {
        NONE,
        ERROR,
        DEBUG;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<LogLevel> getEntries() {
            return $ENTRIES;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\u00020\u00052\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/inmobi/sdk/InMobiSdk$PublisherSignals;", "", "", "", "signals", "", "putPublisherSignals", "(Ljava/util/Map;)V", "getPublisherSignals", "()Ljava/util/Map;", "resetPublisherSignals", "()V", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class PublisherSignals {
        public static final PublisherSignals INSTANCE = new PublisherSignals();

        public final Map<String, Object> getPublisherSignals() {
            if (!InMobiSdk.isSDKInitialized()) {
                String strAccess$getTAG$p = InMobiSdk.access$getTAG$p();
                Intrinsics.checkNotNullExpressionValue(strAccess$getTAG$p, "access$getTAG$p(...)");
                AbstractC3498o6.a((byte) 1, strAccess$getTAG$p, "SDK not initialized. Cannot get publisher signals.");
                return null;
            }
            G9 g9 = G9.f3081a;
            g9.getClass();
            try {
                LinkedHashMap linkedHashMap = C3578u2.f3440a;
                Config configA = C3549s2.a("signals", C3517pb.b(), null);
                Intrinsics.checkNotNull(configA, "null cannot be cast to non-null type com.inmobi.commons.core.configs.SignalsConfig");
                SignalsConfig.PublisherConfig publisher = ((SignalsConfig) configA).getPublisher();
                return (publisher.getEnableMCO() || publisher.getEnableAB()) ? g9.a() : MapsKt.emptyMap();
            } catch (Exception e) {
                C3339d5 c3339d5 = C3339d5.f3292a;
                C3339d5.c.a(I4.a(e, "event"));
                AbstractC3498o6.a((byte) 1, "PubSignalsStore", "Publisher signals could not be retrieved.");
                return MapsKt.emptyMap();
            }
        }

        public final void putPublisherSignals(Map<String, ? extends Object> signals) {
            if (!InMobiSdk.isSDKInitialized()) {
                String strAccess$getTAG$p = InMobiSdk.access$getTAG$p();
                Intrinsics.checkNotNullExpressionValue(strAccess$getTAG$p, "access$getTAG$p(...)");
                AbstractC3498o6.a((byte) 1, strAccess$getTAG$p, "SDK not initialized. Cannot set publisher signals.");
                return;
            }
            if (signals != null) {
                G9 g9 = G9.f3081a;
                g9.getClass();
                Intrinsics.checkNotNullParameter(signals, "signals");
                try {
                    LinkedHashMap linkedHashMap = C3578u2.f3440a;
                    Config configA = C3549s2.a("signals", C3517pb.b(), null);
                    Intrinsics.checkNotNull(configA, "null cannot be cast to non-null type com.inmobi.commons.core.configs.SignalsConfig");
                    SignalsConfig.PublisherConfig publisher = ((SignalsConfig) configA).getPublisher();
                    if (publisher.getEnableMCO() || publisher.getEnableAB()) {
                        LinkedHashMap linkedHashMapA = g9.a();
                        Intrinsics.checkNotNullParameter(linkedHashMapA, "<this>");
                        Intrinsics.checkNotNullParameter(signals, "map");
                        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                        linkedHashMap2.putAll(linkedHashMapA);
                        linkedHashMap2.putAll(signals);
                        JSONObject jSONObjectA = G9.a(G9.a(G9.a(linkedHashMap2, publisher)), publisher);
                        if (jSONObjectA != null) {
                            G9.a(jSONObjectA);
                        }
                    } else {
                        AbstractC3498o6.a((byte) 1, "PubSignalsStore", "Publisher signals are disabled from InMobi");
                    }
                } catch (Exception e) {
                    C3339d5 c3339d5 = C3339d5.f3292a;
                    C3339d5.c.a(I4.a(e, "event"));
                    AbstractC3498o6.a((byte) 1, "PubSignalsStore", "Publisher signals could not be saved.");
                }
            }
        }

        public final void resetPublisherSignals() {
            if (InMobiSdk.isSDKInitialized()) {
                G9.f3081a.getClass();
                G9.b();
            } else {
                String strAccess$getTAG$p = InMobiSdk.access$getTAG$p();
                Intrinsics.checkNotNullExpressionValue(strAccess$getTAG$p, "access$getTAG$p(...)");
                AbstractC3498o6.a((byte) 1, strAccess$getTAG$p, "SDK not initialized. Cannot reset publisher signals.");
            }
        }
    }

    public static void a(final Context context, final String str, final JSONObject jSONObject, final SdkInitializationListener sdkInitializationListener) {
        Lb.a(new Runnable() { // from class: com.inmobi.sdk.InMobiSdk$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                InMobiSdk.a(context, sdkInitializationListener, str, jSONObject);
            }
        });
    }

    public static final /* synthetic */ String access$getTAG$p() {
        return "InMobiSdk";
    }

    public static void b(final SdkInitializationListener sdkInitializationListener, final String str) {
        if (sdkInitializationListener != null) {
            Lb.a(new Runnable() { // from class: com.inmobi.sdk.InMobiSdk$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    InMobiSdk.c(sdkInitializationListener, str);
                }
            });
        }
        if (str == null) {
            AbstractC3498o6.a((byte) 2, "InMobiSdk", O5.a("InMobiSdk", "TAG", "InMobi SDK initialized with account id: ").append(C3517pb.b()).toString());
        } else {
            Intrinsics.checkNotNullExpressionValue("InMobiSdk", "TAG");
            AbstractC3498o6.a((byte) 1, "InMobiSdk", str);
        }
    }

    public static final void c(SdkInitializationListener sdkInitializationListener, String str) {
        INSTANCE.a(sdkInitializationListener, str);
    }

    @JvmStatic
    public static final String getToken() {
        return getToken(null, null);
    }

    @JvmStatic
    public static final String getVersion() {
        return "10.8.2";
    }

    @JvmStatic
    public static final void init(Context context, String accountId, JSONObject consentObject, SdkInitializationListener sdkInitializationListener) {
        INSTANCE.getClass();
        a(context, accountId, consentObject, sdkInitializationListener);
    }

    @JvmStatic
    public static final boolean isSDKInitialized() {
        return C3517pb.q();
    }

    @JvmStatic
    public static final void setAge(int age) {
        Context contextD = C3517pb.d();
        if (age != Integer.MIN_VALUE) {
            I9.f3097a = age;
            if (contextD != null) {
                ConcurrentHashMap concurrentHashMap = K5.b;
                J5.a(contextD, "user_info_store").a("user_age", age);
            }
        }
    }

    @JvmStatic
    public static final void setAgeGroup(AgeGroup group) {
        Intrinsics.checkNotNullParameter(group, "group");
        String string = group.toString();
        Locale ENGLISH = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
        String lowerCase = string.toLowerCase(ENGLISH);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        Context contextD = C3517pb.d();
        if (lowerCase != null) {
            I9.c = lowerCase;
            if (contextD != null) {
                ConcurrentHashMap concurrentHashMap = K5.b;
                J5.a(contextD, "user_info_store").a("user_age_group", lowerCase);
            }
        }
    }

    @JvmStatic
    public static final void setApplicationMuted(boolean muted) {
        C3517pb.b(muted);
    }

    @JvmStatic
    public static final void setAreaCode(String areaCode) {
        Context contextD = C3517pb.d();
        I9.d = areaCode;
        if (contextD == null || areaCode == null) {
            return;
        }
        ConcurrentHashMap concurrentHashMap = K5.b;
        J5.a(contextD, "user_info_store").a("user_area_code", areaCode);
    }

    @JvmStatic
    public static final void setEducation(Education education) {
        Intrinsics.checkNotNullParameter(education, "education");
        String string = education.toString();
        Locale ENGLISH = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
        String lowerCase = string.toLowerCase(ENGLISH);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        Context contextD = C3517pb.d();
        if (lowerCase != null) {
            I9.k = lowerCase;
            if (contextD != null) {
                ConcurrentHashMap concurrentHashMap = K5.b;
                J5.a(contextD, "user_info_store").a("user_education", lowerCase);
            }
        }
    }

    @JvmStatic
    public static final void setGender(Gender gender) {
        Intrinsics.checkNotNullParameter(gender, "gender");
        String string = gender.toString();
        Locale ENGLISH = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
        String lowerCase = string.toLowerCase(ENGLISH);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        Context contextD = C3517pb.d();
        if (lowerCase != null) {
            I9.j = lowerCase;
            if (contextD != null) {
                ConcurrentHashMap concurrentHashMap = K5.b;
                J5.a(contextD, "user_info_store").a(AuthenticationTokenClaims.JSON_KEY_USER_GENDER, lowerCase);
            }
        }
    }

    @JvmStatic
    public static final void setInterests(String interests) {
        Context contextD = C3517pb.d();
        if (interests != null) {
            I9.m = interests;
            if (contextD != null) {
                ConcurrentHashMap concurrentHashMap = K5.b;
                J5.a(contextD, "user_info_store").a("user_interest", interests);
            }
        }
    }

    @JvmStatic
    public static final void setIsAgeRestricted(boolean isAgeRestricted) {
        I9.a(isAgeRestricted);
        C3532qc.f3412a.a(isAgeRestricted);
        if (isAgeRestricted) {
            InMobiUnifiedIdService.reset();
            T4.a();
        }
    }

    @JvmStatic
    public static final void setLanguage(String language) {
        Context contextD = C3517pb.d();
        if (language != null) {
            I9.l = language;
            if (contextD != null) {
                ConcurrentHashMap concurrentHashMap = K5.b;
                J5.a(contextD, "user_info_store").a("user_language", language);
            }
        }
    }

    @JvmStatic
    public static final void setLocation(Location location) {
        Context contextD = C3517pb.d();
        if (location != null) {
            I9.n = location;
            if (contextD != null) {
                String string = new StringBuilder().append(location.getLatitude()).append(AbstractJsonLexerKt.COMMA).append(location.getLongitude()).append(AbstractJsonLexerKt.COMMA).append((int) location.getAccuracy()).append(AbstractJsonLexerKt.COMMA).append(location.getTime()).toString();
                ConcurrentHashMap concurrentHashMap = K5.b;
                J5.a(contextD, "user_info_store").a(AuthenticationTokenClaims.JSON_KEY_USER_LOCATION, string);
            }
        }
    }

    @JvmStatic
    public static final void setLocationWithCityStateCountry(String city, String state, String country) {
        Context contextD = C3517pb.d();
        if (city != null) {
            I9.f = city;
            if (contextD != null) {
                ConcurrentHashMap concurrentHashMap = K5.b;
                J5.a(contextD, "user_info_store").a("user_city_code", city);
            }
        }
        Context contextD2 = C3517pb.d();
        if (state != null) {
            I9.g = state;
            if (contextD2 != null) {
                ConcurrentHashMap concurrentHashMap2 = K5.b;
                J5.a(contextD2, "user_info_store").a("user_state_code", state);
            }
        }
        Context contextD3 = C3517pb.d();
        if (country != null) {
            I9.h = country;
            if (contextD3 != null) {
                ConcurrentHashMap concurrentHashMap3 = K5.b;
                J5.a(contextD3, "user_info_store").a("user_country_code", country);
            }
        }
    }

    @JvmStatic
    public static final void setLogLevel(LogLevel logLevel) {
        int i = logLevel == null ? -1 : a.f3498a[logLevel.ordinal()];
        if (i == 1) {
            AbstractC3498o6.a((byte) 0);
            return;
        }
        if (i == 2) {
            AbstractC3498o6.a((byte) 1);
        } else if (i != 3) {
            AbstractC3498o6.a((byte) 2);
        } else {
            AbstractC3498o6.a((byte) 2);
        }
    }

    @JvmStatic
    public static final void setPartnerGDPRConsent(JSONObject consentObject) {
        X3.c(consentObject);
    }

    @JvmStatic
    public static final void setPostalCode(String postalCode) {
        Context contextD = C3517pb.d();
        if (postalCode != null) {
            I9.e = postalCode;
            if (contextD != null) {
                ConcurrentHashMap concurrentHashMap = K5.b;
                J5.a(contextD, "user_info_store").a("user_post_code", postalCode);
            }
        }
    }

    @JvmStatic
    public static final void setPublisherProvidedUnifiedId(JSONObject jsonObject) {
        Intrinsics.checkNotNullExpressionValue("InMobiSdk", "TAG");
        Objects.toString(jsonObject);
        C3517pb.a(new U4(jsonObject));
    }

    @JvmStatic
    public static final void setYearOfBirth(int yearOfBirth) {
        Context contextD = C3517pb.d();
        if (yearOfBirth != Integer.MIN_VALUE) {
            I9.i = yearOfBirth;
            if (contextD != null) {
                ConcurrentHashMap concurrentHashMap = K5.b;
                J5.a(contextD, "user_info_store").a("user_yob", yearOfBirth);
            }
        }
    }

    @JvmStatic
    public static final void updateGDPRConsent(JSONObject consentObject) {
        X3.b(consentObject);
    }

    public static final void a(final Context context, final SdkInitializationListener sdkInitializationListener, String str, JSONObject jSONObject) {
        if (context == null) {
            INSTANCE.getClass();
            b(sdkInitializationListener, SdkInitializationListener.MISSING_CONTEXT);
            return;
        }
        if (str == null) {
            INSTANCE.getClass();
            b(sdkInitializationListener, "Account id cannot be empty. Please provide a valid account id.");
            return;
        }
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        Eb.f3061a.a();
        if (Ac.f3028a.c()) {
            INSTANCE.getClass();
            b(sdkInitializationListener, "SDK could not be initialized; Required dependency could not be found. Please check out documentation and include the required dependency.");
            return;
        }
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                } else {
                    length--;
                }
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        final String strA = Q6.a(length, 1, str, i);
        try {
            X3.b(jSONObject);
            if (strA.length() == 0) {
                INSTANCE.getClass();
                b(sdkInitializationListener, "Account id cannot be empty. Please provide a valid account id.");
                return;
            }
            if (!AbstractC3599v9.a(context, "android.permission.ACCESS_COARSE_LOCATION") && !AbstractC3599v9.a(context, "android.permission.ACCESS_FINE_LOCATION")) {
                Intrinsics.checkNotNullExpressionValue("InMobiSdk", "TAG");
                AbstractC3498o6.a((byte) 1, "InMobiSdk", "Please grant the location permissions (ACCESS_COARSE_LOCATION or ACCESS_FINE_LOCATION, or both) for better ad targeting.");
            }
            if (C3517pb.q()) {
                Intrinsics.checkNotNullExpressionValue("InMobiSdk", "TAG");
                INSTANCE.getClass();
                b(sdkInitializationListener, null);
                return;
            }
            C3517pb c3517pb = C3517pb.f3400a;
            if (c3517pb.i() == 1) {
                Intrinsics.checkNotNullExpressionValue("InMobiSdk", "TAG");
                return;
            }
            if (C3517pb.b(context, strA)) {
                Ac.f3028a.e(context);
                INSTANCE.getClass();
                a();
                C3517pb.a(new Runnable() { // from class: com.inmobi.sdk.InMobiSdk$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        InMobiSdk.a(context, strA, sdkInitializationListener, jElapsedRealtime);
                    }
                });
                return;
            }
            Intrinsics.checkNotNullExpressionValue("InMobiSdk", "TAG");
            c3517pb.s();
            INSTANCE.getClass();
            b(sdkInitializationListener, SdkInitializationListener.MISSING_WEBVIEW_DEPENDENCY);
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue("InMobiSdk", "TAG");
            C3517pb.f3400a.s();
            INSTANCE.getClass();
            b(sdkInitializationListener, "SDK could not be initialized; an unexpected error was encountered.");
        }
    }

    @JvmStatic
    public static final String getToken(Map<String, String> extras, String keywords) {
        return AbstractC3476mc.a(extras, keywords);
    }

    public static final void b() {
        String[] strArr = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_WIFI_STATE", "android.permission.CHANGE_WIFI_STATE"};
        StringBuilder sb = new StringBuilder("Permissions granted to SDK are :\nandroid.permission.INTERNET\nandroid.permission.ACCESS_NETWORK_STATE");
        for (int i = 0; i < 4; i++) {
            String str = strArr[i];
            if (AbstractC3599v9.a(C3517pb.d(), str)) {
                sb.append("\n").append(str);
            }
        }
        Intrinsics.checkNotNullExpressionValue("InMobiSdk", "TAG");
        AbstractC3498o6.a((byte) 2, "InMobiSdk", sb.toString());
    }

    public static final void a(Context context, String str, SdkInitializationListener sdkInitializationListener, long j) {
        try {
            Ac ac = Ac.f3028a;
            ac.a(context);
            C3517pb c3517pb = C3517pb.f3400a;
            c3517pb.a();
            c3517pb.b(str);
            ac.c(context);
            c3517pb.t();
            INSTANCE.getClass();
            b(sdkInitializationListener, null);
            LinkedHashMap linkedHashMapA = a(j);
            Ob ob = Ob.f3160a;
            Ob.b("SdkInitialized", linkedHashMapA, Sb.SDK);
            InMobiUnifiedIdService.push(null);
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue("InMobiSdk", "TAG");
            C3517pb.f3400a.s();
            INSTANCE.getClass();
            b(sdkInitializationListener, "SDK could not be initialized; an unexpected error was encountered.");
        }
    }

    public final void a(SdkInitializationListener sdkInitializationListener, String message) {
        sdkInitializationListener.onInitializationComplete(message == null ? null : new Error(message));
    }

    public static LinkedHashMap a(long j) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - j));
        Intrinsics.checkNotNullExpressionValue("InMobiSdk", "TAG");
        Objects.toString(linkedHashMap.get("latency"));
        linkedHashMap.put("networkType", C3435k3.q());
        linkedHashMap.put("integrationType", "InMobi");
        return linkedHashMap;
    }

    public static void a() {
        C3517pb.a(new Runnable() { // from class: com.inmobi.sdk.InMobiSdk$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                InMobiSdk.b();
            }
        });
    }
}
