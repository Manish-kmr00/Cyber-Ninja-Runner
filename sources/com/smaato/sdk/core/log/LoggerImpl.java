package com.smaato.sdk.core.log;

import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.smaato.sdk.core.dns.DnsName;
import com.smaato.sdk.core.util.Objects;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: loaded from: classes4.dex */
final class LoggerImpl implements Logger {
    private static final Pattern ANONYMOUS_CLASS_PATTERN;
    private static final String FALLBACK_TAG;
    private static final Map LOG_DOMAIN_TO_PACKAGE_NAME_MAP;
    private final Environment environment;
    private final List logWriters = new ArrayList();
    private final ThreadLocal explicitlySetTag = new ThreadLocal();

    enum Environment {
        DEBUG,
        RELEASE
    }

    static {
        HashMap map = new HashMap();
        LOG_DOMAIN_TO_PACKAGE_NAME_MAP = map;
        FALLBACK_TAG = LoggerImpl.class.getName();
        ANONYMOUS_CLASS_PATTERN = Pattern.compile("(\\$\\d+)+$");
        map.put(LogDomain.CORE, "core");
        map.put(LogDomain.AD, Reporting.Key.CLICK_SOURCE_TYPE_AD);
        map.put(LogDomain.API, "api");
        map.put(LogDomain.NETWORK, "network");
        map.put(LogDomain.LOGGER, CreativeInfo.f);
        map.put(LogDomain.WIDGET, "widget");
        map.put(LogDomain.BROWSER, "browser");
        map.put(LogDomain.APP_CONFIG_CHECK, "appconfigcheck");
        map.put(LogDomain.DATA_COLLECTOR, "datacollector");
        map.put(LogDomain.VAST, "vast");
        map.put(LogDomain.INTERSTITIAL, "interstitial");
        map.put(LogDomain.RICH_MEDIA, "richmedia");
        map.put(LogDomain.MRAID, "mraid");
        map.put(LogDomain.UNIFIED_BIDDING, "ub");
        map.put(LogDomain.CMP, "cmp");
        map.put(LogDomain.NATIVE, "nativead");
        map.put(LogDomain.ADMOB, "admob");
        map.put(LogDomain.VIDEO, "video");
        map.put(LogDomain.REWARDED, "rewarded");
        map.put(LogDomain.INAPP_BIDDING, "iahb");
    }

    LoggerImpl(Environment environment) {
        this.environment = (Environment) Objects.requireNonNull(environment, "Parameter environment cannot be null for LoggerImpl::new");
    }

    void addLogWriter(LogWriter logWriter) {
        Objects.requireNonNull(logWriter);
        this.logWriters.add(logWriter);
    }

    List<LogWriter> getLogWriters() {
        return this.logWriters;
    }

    @Override // com.smaato.sdk.core.log.Logger
    public void log(LogLevel logLevel, LogDomain logDomain, String str, Object... objArr) {
        handleLog(logLevel, logDomain, null, str, objArr);
    }

    @Override // com.smaato.sdk.core.log.Logger
    public void log(LogLevel logLevel, LogDomain logDomain, Throwable th, String str, Object... objArr) {
        handleLog(logLevel, logDomain, th, str, objArr);
    }

    @Override // com.smaato.sdk.core.log.Logger
    public void debug(LogDomain logDomain, String str, Object... objArr) {
        handleLog(LogLevel.DEBUG, logDomain, null, str, objArr);
    }

    @Override // com.smaato.sdk.core.log.Logger
    public void debug(LogDomain logDomain, Throwable th, String str, Object... objArr) {
        handleLog(LogLevel.DEBUG, logDomain, th, str, objArr);
    }

    @Override // com.smaato.sdk.core.log.Logger
    public void info(LogDomain logDomain, String str, Object... objArr) {
        handleLog(LogLevel.INFO, logDomain, null, str, objArr);
    }

    @Override // com.smaato.sdk.core.log.Logger
    public void info(LogDomain logDomain, Throwable th, String str, Object... objArr) {
        handleLog(LogLevel.INFO, logDomain, th, str, objArr);
    }

    @Override // com.smaato.sdk.core.log.Logger
    public void warning(LogDomain logDomain, String str, Object... objArr) {
        handleLog(LogLevel.WARNING, logDomain, null, str, objArr);
    }

    @Override // com.smaato.sdk.core.log.Logger
    public void warning(LogDomain logDomain, Throwable th, String str, Object... objArr) {
        handleLog(LogLevel.WARNING, logDomain, th, str, objArr);
    }

    @Override // com.smaato.sdk.core.log.Logger
    public void error(LogDomain logDomain, String str, Object... objArr) {
        handleLog(LogLevel.ERROR, logDomain, null, str, objArr);
    }

    @Override // com.smaato.sdk.core.log.Logger
    public void error(LogDomain logDomain, Throwable th, String str, Object... objArr) {
        handleLog(LogLevel.ERROR, logDomain, th, str, objArr);
    }

    @Override // com.smaato.sdk.core.log.Logger
    public void setExplicitOneShotTag(String str) {
        Objects.requireNonNull(str);
        this.explicitlySetTag.set(str);
    }

    private void handleLog(LogLevel logLevel, LogDomain logDomain, Throwable th, String str, Object... objArr) {
        String stackTraceString;
        Objects.requireNonNull(logLevel);
        Objects.requireNonNull(logDomain);
        Objects.requireNonNull(str);
        String sdkTag = getSdkTag();
        String sdkDomainPrefix = getSdkDomainPrefix(logDomain);
        if (this.environment == Environment.DEBUG) {
            sdkDomainPrefix = sdkDomainPrefix + getTag() + ": ";
            runDebugChecks(logDomain);
        }
        Iterator it = this.logWriters.iterator();
        while (it.hasNext()) {
            if (((LogWriter) it.next()).isLoggable(logLevel)) {
                if (str.length() != 0) {
                    if (objArr != null && objArr.length > 0) {
                        str = formatMessage(str, objArr);
                    }
                    stackTraceString = th != null ? str + "\n" + getStackTraceString(th) : str;
                } else if (th == null) {
                    return;
                } else {
                    stackTraceString = getStackTraceString(th);
                }
                writeLog(logLevel, sdkDomainPrefix + stackTraceString, sdkTag);
                return;
            }
        }
    }

    String getSdkDomainPrefix(LogDomain logDomain) {
        return logDomain.name() + ": ";
    }

    private String getSdkTag() {
        return "SmaatoSDK: ";
    }

    private void writeLog(LogLevel logLevel, String str, String str2) {
        for (LogWriter logWriter : this.logWriters) {
            if (logWriter.isLoggable(logLevel)) {
                logWriter.log(logLevel, str2, str);
            }
        }
    }

    private String getTag() {
        String str = (String) this.explicitlySetTag.get();
        if (str != null) {
            this.explicitlySetTag.remove();
            return str;
        }
        StackTraceElement stackTraceElementCreateStackTraceElement = createStackTraceElement();
        if (stackTraceElementCreateStackTraceElement != null) {
            return getTagFromStackTraceElement(stackTraceElementCreateStackTraceElement);
        }
        return FALLBACK_TAG;
    }

    private StackTraceElement createStackTraceElement() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length <= 4) {
            error(LogDomain.LOGGER, new IllegalStateException("Not enough stacktrace elements: might be a proguard issue"), "Synthetic stack trace", new Object[0]);
            return null;
        }
        return stackTrace[4];
    }

    private String getTagFromStackTraceElement(StackTraceElement stackTraceElement) {
        Objects.requireNonNull(stackTraceElement);
        String classNameFromStackTraceElement = getClassNameFromStackTraceElement(stackTraceElement);
        return classNameFromStackTraceElement.substring(classNameFromStackTraceElement.lastIndexOf(46) + 1);
    }

    private String getClassNameFromStackTraceElement(StackTraceElement stackTraceElement) {
        Objects.requireNonNull(stackTraceElement);
        String className = stackTraceElement.getClassName();
        Matcher matcher = ANONYMOUS_CLASS_PATTERN.matcher(className);
        return matcher.find() ? matcher.replaceAll("") : className;
    }

    private String formatMessage(String str, Object[] objArr) {
        Objects.requireNonNull(str);
        return String.format(str, objArr);
    }

    String getStackTraceString(Throwable th) {
        Objects.requireNonNull(th);
        StringWriter stringWriter = new StringWriter(256);
        PrintWriter printWriter = new PrintWriter((Writer) stringWriter, false);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    private void runDebugChecks(LogDomain logDomain) {
        StackTraceElement stackTraceElementCreateStackTraceElement = createStackTraceElement();
        if (stackTraceElementCreateStackTraceElement != null) {
            String classNameFromStackTraceElement = getClassNameFromStackTraceElement(stackTraceElementCreateStackTraceElement);
            checkLogDomainEqualsPackage(logDomain, classNameFromStackTraceElement.substring(0, classNameFromStackTraceElement.lastIndexOf(46)));
        }
    }

    private void checkLogDomainEqualsPackage(LogDomain logDomain, String str) {
        for (String str2 : str.split(DnsName.ESCAPED_DOT)) {
            String str3 = (String) LOG_DOMAIN_TO_PACKAGE_NAME_MAP.get(logDomain);
            if (str3 == null) {
                writeLog(LogLevel.ERROR, getSdkDomainPrefix(LogDomain.LOGGER) + ("Unknown LogDomain (" + logDomain + ") is not found in LOG_DOMAIN_TO_PACKAGE_NAME_MAP"), getSdkTag());
                return;
            } else {
                if (str3.equals(str2)) {
                    return;
                }
            }
        }
        writeLog(LogLevel.ERROR, getSdkDomainPrefix(LogDomain.LOGGER) + ("LogDomain = " + logDomain.name() + " was not found in a caller classpath: " + str + ". Looks like an inappropriate LogDomain is used."), getSdkTag());
    }
}
