package io.bidmachine;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.webkit.WebSettings;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import io.bidmachine.util.DeviceUtils;
import io.bidmachine.util.UiUtils;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserAgentManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001:\u0007\u0017\u0018\u0019\u001a\u001b\u001c\u001dB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0007J\u0017\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\fH\u0000¢\u0006\u0002\b\u0013J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0006H\u0007J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0007J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\fH\u0007J\b\u0010\u0016\u001a\u00020\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lio/bidmachine/UserAgentManager;", "", "()V", "DEFAULT_EXPIRATION_MS", "", "SYSTEM_HTTP_AGENT", "", "SYSTEM_PROPERTY_HTTP_AGENT", "WEB_USER_AGENT_PROCESSED", "Ljava/util/concurrent/atomic/AtomicBoolean;", "WEB_USER_AGENT_UPDATED", "applicationContext", "Landroid/content/Context;", "generatedUserAgent", "webUserAgent", "clear", "", "findWebUserAgent", "context", "findWebUserAgent$bidmachine_android_sdk_d_3_2_1", "getUserAgent", MobileAdsBridgeBase.initializeMethodName, "updateWebViewUserAgent", "ApplovinUserAgentSource", "BidMachineUserAgentSource", "FacebookUserAgentSource", "GeneratedUserAgentSource", "IronSourceUserAgentSource", "SharedPreferenceUserAgentSource", "UserAgentSource", "bidmachine-android-sdk_d_3_2_1"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class UserAgentManager {
    private static final String SYSTEM_HTTP_AGENT;
    private static final String SYSTEM_PROPERTY_HTTP_AGENT = "http.agent";
    private static final AtomicBoolean WEB_USER_AGENT_PROCESSED;
    private static final AtomicBoolean WEB_USER_AGENT_UPDATED;
    private static Context applicationContext;
    private static String generatedUserAgent;
    public static String webUserAgent;
    public static final UserAgentManager INSTANCE = new UserAgentManager();
    private static final long DEFAULT_EXPIRATION_MS = TimeUnit.DAYS.toMillis(14);

    /* JADX INFO: compiled from: UserAgentManager.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\b`\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0004"}, d2 = {"Lio/bidmachine/UserAgentManager$UserAgentSource;", "", "get", "", "bidmachine-android-sdk_d_3_2_1"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface UserAgentSource {
        String get();
    }

    private UserAgentManager() {
    }

    static {
        String property;
        try {
            property = System.getProperty(SYSTEM_PROPERTY_HTTP_AGENT);
        } catch (Throwable unused) {
            property = null;
        }
        SYSTEM_HTTP_AGENT = property;
        WEB_USER_AGENT_PROCESSED = new AtomicBoolean(false);
        WEB_USER_AGENT_UPDATED = new AtomicBoolean(false);
    }

    @JvmStatic
    public static final void initialize(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        UserAgentManager userAgentManager = INSTANCE;
        applicationContext = context.getApplicationContext();
        userAgentManager.findWebUserAgent$bidmachine_android_sdk_d_3_2_1(context);
    }

    @JvmStatic
    public static final String getUserAgent() {
        return getUserAgent(applicationContext);
    }

    @JvmStatic
    public static final String getUserAgent(Context context) {
        if (context == null) {
            context = applicationContext;
        }
        if (webUserAgent == null && context != null) {
            webUserAgent = INSTANCE.findWebUserAgent$bidmachine_android_sdk_d_3_2_1(context);
        }
        String str = webUserAgent;
        if (str != null && str.length() > 0) {
            return webUserAgent;
        }
        if (generatedUserAgent == null && context != null) {
            generatedUserAgent = new GeneratedUserAgentSource(context).get();
        }
        String str2 = generatedUserAgent;
        if (str2 != null && str2.length() > 0) {
            return generatedUserAgent;
        }
        return SYSTEM_HTTP_AGENT;
    }

    public final String findWebUserAgent$bidmachine_android_sdk_d_3_2_1(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!WEB_USER_AGENT_PROCESSED.compareAndSet(false, true)) {
            return webUserAgent;
        }
        String str = new BidMachineUserAgentSource(context, DEFAULT_EXPIRATION_MS).get();
        if (str != null && str.length() > 0) {
            return str;
        }
        String str2 = new ApplovinUserAgentSource(context).get();
        if (str2 != null && str2.length() > 0) {
            return str2;
        }
        String str3 = new IronSourceUserAgentSource(context).get();
        if (str3 != null && str3.length() > 0) {
            return str3;
        }
        String str4 = new FacebookUserAgentSource(context).get();
        if (str4 != null && str4.length() > 0) {
            return str4;
        }
        updateWebViewUserAgent();
        return webUserAgent;
    }

    @JvmStatic
    public static final void updateWebViewUserAgent() {
        Context context;
        if (WEB_USER_AGENT_UPDATED.compareAndSet(false, true) && (context = applicationContext) != null) {
            try {
                new BidMachineUserAgentSource(context, DEFAULT_EXPIRATION_MS).checkAndUpdate();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable unused) {
            }
        }
    }

    @JvmStatic
    public static final void clear() {
        WEB_USER_AGENT_PROCESSED.set(false);
        webUserAgent = null;
        generatedUserAgent = null;
    }

    /* JADX INFO: compiled from: UserAgentManager.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lio/bidmachine/UserAgentManager$SharedPreferenceUserAgentSource;", "Lio/bidmachine/UserAgentManager$UserAgentSource;", "context", "Landroid/content/Context;", "name", "", "field", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "applicationContext", "sharedPreferences", "Landroid/content/SharedPreferences;", "get", "bidmachine-android-sdk_d_3_2_1"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static class SharedPreferenceUserAgentSource implements UserAgentSource {
        private final Context applicationContext;
        private final String field;
        private final String name;
        private SharedPreferences sharedPreferences;

        public SharedPreferenceUserAgentSource(Context context, String name, String field) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(field, "field");
            this.name = name;
            this.field = field;
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            this.applicationContext = applicationContext;
        }

        @Override // io.bidmachine.UserAgentManager.UserAgentSource
        public String get() {
            try {
                SharedPreferenceUserAgentSource sharedPreferenceUserAgentSource = this;
                if (this.sharedPreferences == null) {
                    this.sharedPreferences = this.applicationContext.getSharedPreferences(this.name, 0);
                }
                SharedPreferences sharedPreferences = this.sharedPreferences;
                if (sharedPreferences != null) {
                    return sharedPreferences.getString(this.field, null);
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: UserAgentManager.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\rJ\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lio/bidmachine/UserAgentManager$BidMachineUserAgentSource;", "Lio/bidmachine/UserAgentManager$UserAgentSource;", "Ljava/lang/Runnable;", "context", "Landroid/content/Context;", "expirationMs", "", "(Landroid/content/Context;J)V", "applicationContext", "getExpirationMs", "()J", "calculateExpirationMs", "checkAndUpdate", "", "get", "", "run", "bidmachine-android-sdk_d_3_2_1"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class BidMachineUserAgentSource implements UserAgentSource, Runnable {
        private final Context applicationContext;
        private final long expirationMs;

        public BidMachineUserAgentSource(Context context, long j) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.expirationMs = j;
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            this.applicationContext = applicationContext;
        }

        public final long getExpirationMs() {
            return this.expirationMs;
        }

        @Override // io.bidmachine.UserAgentManager.UserAgentSource
        public String get() {
            return BidMachineSharedPreference.getValidUserAgent(this.applicationContext);
        }

        public final void checkAndUpdate() {
            String str = get();
            if (str == null || str.length() == 0) {
                UiUtils.onUiThread(this);
            }
        }

        public final long calculateExpirationMs() {
            return System.currentTimeMillis() + this.expirationMs;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                BidMachineUserAgentSource bidMachineUserAgentSource = this;
                UserAgentManager userAgentManager = UserAgentManager.INSTANCE;
                String defaultUserAgent = WebSettings.getDefaultUserAgent(this.applicationContext);
                if (defaultUserAgent != null) {
                    Intrinsics.checkNotNullExpressionValue(defaultUserAgent, "getDefaultUserAgent(applicationContext)");
                    BidMachineSharedPreference.setValidUserAgent(this.applicationContext, defaultUserAgent, calculateExpirationMs());
                } else {
                    defaultUserAgent = null;
                }
                UserAgentManager.webUserAgent = defaultUserAgent;
                Unit unit = Unit.INSTANCE;
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: UserAgentManager.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/bidmachine/UserAgentManager$ApplovinUserAgentSource;", "Lio/bidmachine/UserAgentManager$SharedPreferenceUserAgentSource;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bidmachine-android-sdk_d_3_2_1"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ApplovinUserAgentSource extends SharedPreferenceUserAgentSource {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ApplovinUserAgentSource(Context context) {
            super(context, "com.applovin.sdk.shared", "com.applovin.sdk.user_agent");
            Intrinsics.checkNotNullParameter(context, "context");
        }
    }

    /* JADX INFO: compiled from: UserAgentManager.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/bidmachine/UserAgentManager$IronSourceUserAgentSource;", "Lio/bidmachine/UserAgentManager$SharedPreferenceUserAgentSource;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bidmachine-android-sdk_d_3_2_1"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class IronSourceUserAgentSource extends SharedPreferenceUserAgentSource {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IronSourceUserAgentSource(Context context) {
            super(context, "Mediation_Shared_Preferences", "browser_user_agent");
            Intrinsics.checkNotNullParameter(context, "context");
        }
    }

    /* JADX INFO: compiled from: UserAgentManager.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/bidmachine/UserAgentManager$FacebookUserAgentSource;", "Lio/bidmachine/UserAgentManager$SharedPreferenceUserAgentSource;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bidmachine-android-sdk_d_3_2_1"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class FacebookUserAgentSource extends SharedPreferenceUserAgentSource {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FacebookUserAgentSource(Context context) {
            super(context, "com.facebook.ads.internal.ua", "user_agent");
            Intrinsics.checkNotNullParameter(context, "context");
        }
    }

    /* JADX INFO: compiled from: UserAgentManager.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u00060\u000bj\u0002`\fH\u0002J$\u0010\r\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u00060\u000bj\u0002`\fH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lio/bidmachine/UserAgentManager$GeneratedUserAgentSource;", "Lio/bidmachine/UserAgentManager$UserAgentSource;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "applicationContext", "appendChromeToUserAgent", "", "packageManager", "Landroid/content/pm/PackageManager;", "userAgentBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "appendMobileToUserAgent", "create", "", "get", "bidmachine-android-sdk_d_3_2_1"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class GeneratedUserAgentSource implements UserAgentSource {
        private final Context applicationContext;

        public GeneratedUserAgentSource(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            this.applicationContext = applicationContext;
        }

        @Override // io.bidmachine.UserAgentManager.UserAgentSource
        public String get() {
            return create(this.applicationContext);
        }

        private final String create(Context context) {
            try {
                StringBuilder userAgentBuilder = new StringBuilder("Mozilla/5.0").append(" (Linux; Android ").append(DeviceUtils.getOsVersion()).append("; ").append(DeviceUtils.getModel()).append(" Build/").append(DeviceUtils.getBuildId()).append("; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0");
                PackageManager packageManager = context.getPackageManager();
                Intrinsics.checkNotNullExpressionValue(packageManager, "packageManager");
                Intrinsics.checkNotNullExpressionValue(userAgentBuilder, "userAgentBuilder");
                appendChromeToUserAgent(packageManager, userAgentBuilder);
                appendMobileToUserAgent(context, packageManager, userAgentBuilder);
                String string = userAgentBuilder.toString();
                Intrinsics.checkNotNullExpressionValue(string, "userAgentBuilder.toString()");
                return string;
            } catch (Throwable unused) {
                return "";
            }
        }

        private final void appendChromeToUserAgent(PackageManager packageManager, StringBuilder userAgentBuilder) {
            String[] strArr = {"com.android.chrome", "com.google.android.webview", "com.android.webview"};
            for (int i = 0; i < 3; i++) {
                try {
                    GeneratedUserAgentSource generatedUserAgentSource = this;
                    userAgentBuilder.append(" Chrome/").append(packageManager.getPackageInfo(strArr[i], 0).versionName);
                    return;
                } catch (Throwable unused) {
                }
            }
        }

        private final void appendMobileToUserAgent(Context context, PackageManager packageManager, StringBuilder userAgentBuilder) {
            String string;
            try {
                GeneratedUserAgentSource generatedUserAgentSource = this;
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
                StringBuilder sbAppend = userAgentBuilder.append(" Mobile").append(" ");
                if (applicationInfo.labelRes == 0) {
                    string = applicationInfo.nonLocalizedLabel.toString();
                } else {
                    string = context.getString(applicationInfo.labelRes);
                    Intrinsics.checkNotNullExpressionValue(string, "{\n                      …                        }");
                }
                sbAppend.append(string).append(RemoteSettings.FORWARD_SLASH_STRING).append(packageInfo.versionName);
            } catch (Throwable unused) {
            }
        }
    }
}
