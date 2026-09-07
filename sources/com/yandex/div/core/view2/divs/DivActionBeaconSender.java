package com.yandex.div.core.view2.divs;

import android.net.Uri;
import com.yandex.android.beacon.SendBeaconManager;
import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.dagger.ExperimentFlag;
import com.yandex.div.core.experiments.Experiment;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.KAssert;
import com.yandex.div.internal.KLog;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div.logging.Severity;
import com.yandex.div2.DivAction;
import com.yandex.div2.DivSightAction;
import com.yandex.yatagan.Lazy;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivActionBeaconSender.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\b\u0011\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B5\b\u0007\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0001\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0013\u001a\u00020\u0006*\u0004\u0018\u00010\u0014H\u0012J \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u0016*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0012J \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u0016*\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fH\u0012R\u000e\u0010\b\u001a\u00020\u0006X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0092\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivActionBeaconSender;", "", "sendBeaconManagerLazy", "Lcom/yandex/yatagan/Lazy;", "Lcom/yandex/android/beacon/SendBeaconManager;", "isTapBeaconsEnabled", "", "isVisibilityBeaconsEnabled", "isSwipeOutBeaconsEnabled", "(Lcom/yandex/yatagan/Lazy;ZZZ)V", "sendSwipeOutActionBeacon", "", "action", "Lcom/yandex/div2/DivAction;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "sendTapActionBeacon", "sendVisibilityActionBeacon", "Lcom/yandex/div2/DivSightAction;", "isHttpScheme", "", "toHttpHeaders", "", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public class DivActionBeaconSender {
    private static final Companion Companion = new Companion(null);
    private static final String HTTPS_SCHEME = "https";
    private static final String HTTP_HEADER_REFERER = "Referer";
    private static final String HTTP_SCHEME = "http";
    private static final String TAG = "DivActionBeaconSender";
    private final boolean isSwipeOutBeaconsEnabled;
    private final boolean isTapBeaconsEnabled;
    private final boolean isVisibilityBeaconsEnabled;
    private final Lazy<SendBeaconManager> sendBeaconManagerLazy;

    @Inject
    public DivActionBeaconSender(Lazy<SendBeaconManager> sendBeaconManagerLazy, @ExperimentFlag(experiment = Experiment.TAP_BEACONS_ENABLED) boolean z, @ExperimentFlag(experiment = Experiment.VISIBILITY_BEACONS_ENABLED) boolean z2, @ExperimentFlag(experiment = Experiment.SWIPE_OUT_BEACONS_ENABLED) boolean z3) {
        Intrinsics.checkNotNullParameter(sendBeaconManagerLazy, "sendBeaconManagerLazy");
        this.sendBeaconManagerLazy = sendBeaconManagerLazy;
        this.isTapBeaconsEnabled = z;
        this.isVisibilityBeaconsEnabled = z2;
        this.isSwipeOutBeaconsEnabled = z3;
    }

    public void sendTapActionBeacon(DivAction action, ExpressionResolver resolver) {
        Uri uriEvaluate;
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Expression<Uri> expression = action.logUrl;
        if (expression == null || (uriEvaluate = expression.evaluate(resolver)) == null) {
            return;
        }
        if (!isHttpScheme(uriEvaluate.getScheme())) {
            KLog kLog = KLog.INSTANCE;
            if (kLog.isAtLeast(Severity.WARNING)) {
                kLog.print(5, TAG, "Trying to send beacon with unsupported URL '" + uriEvaluate + '\'');
                return;
            }
            return;
        }
        if (this.isTapBeaconsEnabled) {
            SendBeaconManager sendBeaconManager = this.sendBeaconManagerLazy.get();
            if (sendBeaconManager == null) {
                KAssert kAssert = KAssert.INSTANCE;
                if (Assert.isEnabled()) {
                    Assert.fail("SendBeaconManager was not configured");
                    return;
                }
                return;
            }
            sendBeaconManager.addUrl(uriEvaluate, toHttpHeaders(action, resolver), action.payload);
        }
    }

    public void sendVisibilityActionBeacon(DivSightAction action, ExpressionResolver resolver) {
        Uri uriEvaluate;
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Expression<Uri> url = action.getUrl();
        if (url == null || (uriEvaluate = url.evaluate(resolver)) == null) {
            return;
        }
        if (!isHttpScheme(uriEvaluate.getScheme())) {
            KLog kLog = KLog.INSTANCE;
            if (kLog.isAtLeast(Severity.WARNING)) {
                kLog.print(5, TAG, "Trying to send beacon with unsupported URL '" + uriEvaluate + '\'');
                return;
            }
            return;
        }
        if (this.isVisibilityBeaconsEnabled) {
            SendBeaconManager sendBeaconManager = this.sendBeaconManagerLazy.get();
            if (sendBeaconManager == null) {
                KAssert kAssert = KAssert.INSTANCE;
                if (Assert.isEnabled()) {
                    Assert.fail("SendBeaconManager was not configured");
                    return;
                }
                return;
            }
            sendBeaconManager.addUrl(uriEvaluate, toHttpHeaders(action, resolver), action.getPayload());
        }
    }

    public void sendSwipeOutActionBeacon(DivAction action, ExpressionResolver resolver) {
        Uri uriEvaluate;
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Expression<Uri> expression = action.logUrl;
        if (expression == null || (uriEvaluate = expression.evaluate(resolver)) == null) {
            return;
        }
        if (!isHttpScheme(uriEvaluate.getScheme())) {
            KLog kLog = KLog.INSTANCE;
            if (kLog.isAtLeast(Severity.WARNING)) {
                kLog.print(5, TAG, "Trying to send beacon with unsupported URL '" + uriEvaluate + '\'');
                return;
            }
            return;
        }
        if (this.isSwipeOutBeaconsEnabled) {
            SendBeaconManager sendBeaconManager = this.sendBeaconManagerLazy.get();
            if (sendBeaconManager == null) {
                KAssert kAssert = KAssert.INSTANCE;
                if (Assert.isEnabled()) {
                    Assert.fail("SendBeaconManager was not configured");
                    return;
                }
                return;
            }
            sendBeaconManager.addUrl(uriEvaluate, toHttpHeaders(action, resolver), action.payload);
        }
    }

    private Map<String, String> toHttpHeaders(DivAction divAction, ExpressionResolver expressionResolver) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Expression<Uri> expression = divAction.referer;
        if (expression != null) {
            String string = expression.evaluate(expressionResolver).toString();
            Intrinsics.checkNotNullExpressionValue(string, "referer.evaluate(resolver).toString()");
            linkedHashMap.put("Referer", string);
        }
        return linkedHashMap;
    }

    private Map<String, String> toHttpHeaders(DivSightAction divSightAction, ExpressionResolver expressionResolver) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Expression<Uri> referer = divSightAction.getReferer();
        if (referer != null) {
            String string = referer.evaluate(expressionResolver).toString();
            Intrinsics.checkNotNullExpressionValue(string, "referer.evaluate(resolver).toString()");
            linkedHashMap.put("Referer", string);
        }
        return linkedHashMap;
    }

    private boolean isHttpScheme(String str) {
        return Intrinsics.areEqual(str, "http") || Intrinsics.areEqual(str, "https");
    }

    /* JADX INFO: compiled from: DivActionBeaconSender.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivActionBeaconSender$Companion;", "", "()V", "HTTPS_SCHEME", "", "HTTP_HEADER_REFERER", "HTTP_SCHEME", "TAG", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
