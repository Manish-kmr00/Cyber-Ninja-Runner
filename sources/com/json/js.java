package com.json;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.json.mediationsdk.IronSourceSegment;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.logger.IronSourceLogger;
import com.json.mediationsdk.logger.IronSourceLoggerManager;
import com.json.mediationsdk.p;
import com.json.mediationsdk.server.HttpFunctions;
import com.json.mediationsdk.server.ServerURL;
import com.json.mediationsdk.utils.ErrorBuilder;
import com.json.mediationsdk.utils.IronSourceAES;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\n\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bH\u0002J&\u0010\n\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011¨\u0006\u0016"}, d2 = {"Lcom/ironsource/js;", "", "Landroid/content/Context;", "context", "Lcom/ironsource/bs;", "tools", "Lcom/ironsource/rr;", "request", "Lcom/ironsource/wr;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "a", "", "encryptedResponse", "", "hasCompression", "reason", "Lcom/ironsource/mr;", "Lcom/ironsource/qr;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class js {
    private final mr a(String reason) {
        return reason != null ? new mr(2110, reason) : new mr(mr.d, "noServerResponse");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final wr a(Context context, bs tools, rr request) {
        try {
            String strA = tools.a(context);
            if (TextUtils.isEmpty(strA)) {
                strA = tools.b(context);
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "using custom identifier", 1);
            }
            String str = strA;
            IronSourceSegment ironSourceSegmentD = tools.d();
            ArrayList<Pair<String, String>> segmentData = ironSourceSegmentD != null ? ironSourceSegmentD.getSegmentData() : null;
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            String strSendPostRequest = HttpFunctions.sendPostRequest(ServerURL.buildInitURL(context, request.d(), request.f(), str, null, true, segmentData, false), qi.a().toString(), new p.c() { // from class: com.ironsource.js$$ExternalSyntheticLambda0
                @Override // com.ironsource.mediationsdk.p.c
                public final void a(String str2) {
                    js.a(objectRef, str2);
                }
            });
            if (strSendPostRequest == null) {
                IronLog.INTERNAL.warning("serverResponseString is null");
                return new wr(a((String) objectRef.element));
            }
            if (tools.e()) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose("encrypt");
                JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit(strSendPostRequest);
                String encryptedResponse = jSONObjectJsonObjectInit.optString("response");
                if (TextUtils.isEmpty(encryptedResponse)) {
                    ironLog.warning("encryptedResponse is empty - return null");
                    return new wr(new mr(2100, pr.FALSE_AVAILABILITY_REASON_NO_RESPONSE_KEY));
                }
                boolean zOptBoolean = jSONObjectJsonObjectInit.optBoolean("compression", false);
                Intrinsics.checkNotNullExpressionValue(encryptedResponse, "encryptedResponse");
                strSendPostRequest = a(encryptedResponse, zOptBoolean);
                if (TextUtils.isEmpty(strSendPostRequest)) {
                    ironLog.warning("encoded response invalid - return null");
                    tools.f();
                    return new wr(new mr(mr.f, pr.FALSE_AVAILABILITY_REASON_DECRYPTION_FAILED));
                }
            }
            ls lsVar = new ls(context, request.d(), request.f(), strSendPostRequest);
            lsVar.a(ls.a.SERVER);
            if (lsVar.p()) {
                return new wr(new sr(lsVar));
            }
            IronLog.INTERNAL.warning("response invalid - return null");
            return new wr(new mr(mr.e, "serverResponseIsNotValid"));
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.warning("exception = " + e);
            return new wr(e instanceof JSONException ? new mr(mr.e, "serverResponseIsNotValid") : new mr(510, "internal error"));
        }
    }

    private final String a(String encryptedResponse, boolean hasCompression) {
        String strDecryptAndDecompress = hasCompression ? IronSourceAES.decryptAndDecompress(mb.b().c(), encryptedResponse) : IronSourceAES.decode(mb.b().c(), encryptedResponse);
        Intrinsics.checkNotNullExpressionValue(strDecryptAndDecompress, "{\n      IronSourceAES.de… encryptedResponse)\n    }");
        return strDecryptAndDecompress;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(Ref.ObjectRef reason, String errorMessage) {
        Intrinsics.checkNotNullParameter(reason, "$reason");
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        reason.element = errorMessage;
    }

    private final wr b(Context context, bs tools, rr request) {
        wr wrVarA = a(context, tools, request);
        if (wrVarA.c()) {
            return wrVarA;
        }
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "Null or invalid response. Trying to get cached response", 0);
        ls lsVarA = tools.a(context, request.d());
        if (lsVarA == null) {
            return wrVarA;
        }
        wr wrVar = new wr(new sr(lsVarA));
        IronSourceLoggerManager.getLogger().log(ironSourceTag, ErrorBuilder.buildUsingCachedConfigurationError(request.d(), request.f()) + ": " + wrVar.getSdkInitResponse(), 1);
        tools.g();
        return wrVar;
    }

    public final void a(Context context, rr request, bs tools, qr listener) {
        mr error;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(tools, "tools");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String strF = request.f();
        if (strF == null) {
            strF = "";
        }
        tools.a("userId", strF);
        tools.a("appKey", request.d());
        tools.getGlobalDataWriter().i(request.f());
        tools.a();
        wr wrVarB = b(context, tools, request);
        if (wrVarB.getSdkInitResponse() != null) {
            kr krVar = new kr(wrVarB.getSdkInitResponse());
            if (wrVarB.c()) {
                listener.a(krVar);
                return;
            }
            error = new mr(mr.e, "serverResponseIsNotValid");
        } else {
            error = wrVarB.getError();
            if (error == null) {
                error = new mr(510, "unknown error");
            }
        }
        listener.a(error);
    }
}
