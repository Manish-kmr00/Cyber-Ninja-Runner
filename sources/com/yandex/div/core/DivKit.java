package com.yandex.div.core;

import android.content.Context;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.json.m5;
import com.safedk.android.utils.j;
import com.yandex.android.beacon.SendBeaconManager;
import com.yandex.div.BuildConfig;
import com.yandex.div.core.dagger.DivKitComponent;
import com.yandex.div.core.dagger.Yatagan$DivKitComponent;
import com.yandex.div.evaluable.function.GeneratedBuiltinFunctionProvider;
import com.yandex.div.histogram.DivParsingHistogramReporter;
import com.yandex.div.histogram.reporter.HistogramReporterDelegate;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.Log;
import com.yandex.div.logging.Severity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivKit.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/yandex/div/core/DivKit;", "", "context", "Landroid/content/Context;", j.c, "Lcom/yandex/div/core/DivKitConfiguration;", "(Landroid/content/Context;Lcom/yandex/div/core/DivKitConfiguration;)V", "component", "Lcom/yandex/div/core/dagger/DivKitComponent;", "getComponent$div_release", "()Lcom/yandex/div/core/dagger/DivKitComponent;", "histogramReporterDelegate", "Lcom/yandex/div/histogram/reporter/HistogramReporterDelegate;", "getHistogramReporterDelegate", "()Lcom/yandex/div/histogram/reporter/HistogramReporterDelegate;", "parsingHistogramReporter", "Lcom/yandex/div/histogram/DivParsingHistogramReporter;", "getParsingHistogramReporter", "()Lcom/yandex/div/histogram/DivParsingHistogramReporter;", "sendBeaconManager", "Lcom/yandex/android/beacon/SendBeaconManager;", "getSendBeaconManager", "()Lcom/yandex/android/beacon/SendBeaconManager;", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivKit {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final DivKitConfiguration DEFAULT_CONFIGURATION = new DivKitConfiguration.Builder().build();
    private static DivKitConfiguration configuration;
    private static volatile DivKit instance;
    private final DivKitComponent component;

    public /* synthetic */ DivKit(Context context, DivKitConfiguration divKitConfiguration, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, divKitConfiguration);
    }

    @JvmStatic
    public static final void configure(DivKitConfiguration divKitConfiguration) {
        INSTANCE.configure(divKitConfiguration);
    }

    @JvmStatic
    public static final void enableAssertions(boolean z) {
        INSTANCE.enableAssertions(z);
    }

    @JvmStatic
    public static final void enableLogging(boolean z) {
        INSTANCE.enableLogging(z);
    }

    @JvmStatic
    public static final DivKit getInstance(Context context) {
        return INSTANCE.getInstance(context);
    }

    @JvmStatic
    public static final Severity getLoggingSeverity() {
        return INSTANCE.getLoggingSeverity();
    }

    public static final String getVersionName() {
        return INSTANCE.getVersionName();
    }

    @JvmStatic
    public static final boolean isAssertionsEnabled() {
        return INSTANCE.isAssertionsEnabled();
    }

    @JvmStatic
    public static final boolean isLoggingEnabled() {
        return INSTANCE.isLoggingEnabled();
    }

    @JvmStatic
    public static final void setLoggingSeverity(Severity severity) {
        INSTANCE.setLoggingSeverity(severity);
    }

    @JvmStatic
    public static final void warmUpStatics() {
        INSTANCE.warmUpStatics();
    }

    private DivKit(Context context, DivKitConfiguration divKitConfiguration) {
        DivKitComponent.Builder builder = Yatagan$DivKitComponent.builder();
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.component = builder.applicationContext(applicationContext).configuration(divKitConfiguration).build();
    }

    /* JADX INFO: renamed from: getComponent$div_release, reason: from getter */
    public final DivKitComponent getComponent() {
        return this.component;
    }

    public final SendBeaconManager getSendBeaconManager() {
        return this.component.getSendBeaconManager();
    }

    public final DivParsingHistogramReporter getParsingHistogramReporter() {
        return this.component.getParsingHistogramReporter();
    }

    public final HistogramReporterDelegate getHistogramReporterDelegate() {
        return this.component.getHistogramReporterDelegate();
    }

    /* JADX INFO: compiled from: DivKit.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\b\u0010\u0016\u001a\u00020\u0017H\u0007J\b\u0010\u0018\u001a\u00020\u0011H\u0007J\b\u0010\u0019\u001a\u00020\u0011H\u0007J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0017H\u0007J\b\u0010\u001c\u001a\u00020\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/yandex/div/core/DivKit$Companion;", "", "()V", "DEFAULT_CONFIGURATION", "Lcom/yandex/div/core/DivKitConfiguration;", j.c, m5.p, "Lcom/yandex/div/core/DivKit;", "versionName", "", "getVersionName$annotations", "getVersionName", "()Ljava/lang/String;", "configure", "", "enableAssertions", "enabled", "", "enableLogging", "getInstance", "context", "Landroid/content/Context;", "getLoggingSeverity", "Lcom/yandex/div/logging/Severity;", "isAssertionsEnabled", "isLoggingEnabled", "setLoggingSeverity", SDKConstants.PARAM_DEBUG_MESSAGE_SEVERITY, "warmUpStatics", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getVersionName$annotations() {
        }

        private Companion() {
        }

        @JvmStatic
        public final void configure(DivKitConfiguration configuration) {
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            synchronized (this) {
                if (DivKit.configuration == null) {
                    DivKit.configuration = configuration;
                } else {
                    Assert.fail("DivKit already configured");
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        @JvmStatic
        public final DivKit getInstance(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            DivKit divKit = DivKit.instance;
            if (divKit != null) {
                return divKit;
            }
            synchronized (this) {
                DivKit divKit2 = DivKit.instance;
                if (divKit2 != null) {
                    return divKit2;
                }
                DivKitConfiguration divKitConfiguration = DivKit.configuration;
                if (divKitConfiguration == null) {
                    divKitConfiguration = DivKit.DEFAULT_CONFIGURATION;
                }
                DivKit divKit3 = new DivKit(context, divKitConfiguration, null);
                Companion companion = DivKit.INSTANCE;
                DivKit.instance = divKit3;
                return divKit3;
            }
        }

        public final String getVersionName() {
            return BuildConfig.VERSION_NAME;
        }

        @JvmStatic
        public final void warmUpStatics() {
            GeneratedBuiltinFunctionProvider.INSTANCE.warmUp();
        }

        @JvmStatic
        public final boolean isLoggingEnabled() {
            return Log.isEnabled();
        }

        @JvmStatic
        public final void enableLogging(boolean enabled) {
            Log.setEnabled(Boolean.valueOf(enabled));
        }

        @JvmStatic
        public final Severity getLoggingSeverity() {
            Severity severity = Log.getSeverity();
            Intrinsics.checkNotNullExpressionValue(severity, "getSeverity()");
            return severity;
        }

        @JvmStatic
        public final void setLoggingSeverity(Severity severity) {
            Intrinsics.checkNotNullParameter(severity, "severity");
            Log.setSeverity(severity);
        }

        @JvmStatic
        public final boolean isAssertionsEnabled() {
            return Assert.isEnabled();
        }

        @JvmStatic
        public final void enableAssertions(boolean enabled) {
            Assert.setEnabled(enabled);
        }
    }
}
