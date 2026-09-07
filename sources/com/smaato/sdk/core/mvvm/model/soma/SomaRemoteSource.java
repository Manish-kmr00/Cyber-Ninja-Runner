package com.smaato.sdk.core.mvvm.model.soma;

import android.net.Uri;
import com.smaato.sdk.core.ad.AdFormat;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.mvvm.model.AdResponse;
import com.smaato.sdk.core.mvvm.model.AdResponseParser;
import com.smaato.sdk.core.network.Call;
import com.smaato.sdk.core.network.HttpClient;
import com.smaato.sdk.core.network.Request;
import com.smaato.sdk.core.network.Response;
import com.smaato.sdk.core.network.SomaException;
import com.smaato.sdk.core.util.HeaderValueUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public abstract class SomaRemoteSource {
    protected static final String KEY_ADSPACE_ID = "adspace";
    protected static final String KEY_AD_FORMAT = "format";
    protected static final String KEY_DIMENSION = "dimension";
    protected static final String KEY_HEIGHT = "height";
    protected static final String KEY_MEDIATION_ADAPTER_VERSION = "mav";
    protected static final String KEY_MEDIATION_NETWORK_NAME = "mnn";
    protected static final String KEY_MEDIATION_NETWORK_SDK_VERSION = "mnsv";
    protected static final String KEY_MEDIATION_VERSION = "mediationversion";
    protected static final String KEY_MRAIDVERSION = "mraidver";
    protected static final String KEY_PLAYABLE_SUPPORTED = "playableSupported";
    protected static final String KEY_PRIVACY_ICON = "privacyIcon";
    protected static final String KEY_VASTVERSION = "vastver";
    protected static final String KEY_VIDEO_TYPE_NAME = "videotype";
    protected static final String KEY_WIDTH = "width";
    protected static final String VALUE_MEDIATION_VERSION = "2";
    protected static final String VALUE_MRAIDVERSION = "3";
    protected static final String VALUE_PLAYABLE_SUPPORTED = "1";
    protected static final String VALUE_PRIVACY_ICON = "1";
    protected static final String VALUE_SPLASH = "splash";
    protected static final String VALUE_VAST_VERSION = "4.1";
    Map<AdFormat, AdResponseParser> adResponseParsers = new HashMap();
    private Call currentCall;
    private final HeaderValueUtils headerValueUtils;
    private final Logger logger;
    private final String somaApiUrl;
    private final HttpClient somaHttpClient;

    public SomaRemoteSource(HttpClient httpClient, String str, HeaderValueUtils headerValueUtils, Logger logger) {
        this.somaHttpClient = httpClient;
        this.somaApiUrl = str;
        this.headerValueUtils = headerValueUtils;
        this.logger = logger;
    }

    public void setAdResponseParsers(Map<AdFormat, AdResponseParser> map) {
        if (map == null) {
            throw new NullPointerException("'adResponseParsers' specified as non-null is null");
        }
        this.adResponseParsers = map;
    }

    public synchronized AdResponse loadAd(SomaAdRequest somaAdRequest) throws IOException {
        try {
            if (somaAdRequest == null) {
                throw new NullPointerException("'somaAdRequest' specified as non-null is null");
            }
        } catch (Throwable th) {
            throw th;
        }
        return getAdResponseFromSoma(buildSomaHttpRequest(somaAdRequest));
    }

    public synchronized AdResponse loadAd(Request request) throws IOException {
        try {
            if (request == null) {
                throw new NullPointerException("'request' specified as non-null is null");
            }
        } catch (Throwable th) {
            throw th;
        }
        return getAdResponseFromSoma(request);
    }

    protected Request buildSomaHttpRequest(SomaAdRequest somaAdRequest) {
        Request request = Request.get(this.somaApiUrl);
        Uri.Builder builderAppendQueryParameter = request.uri().buildUpon().appendQueryParameter(KEY_ADSPACE_ID, somaAdRequest.getAdRequest().getAdSpaceId()).appendQueryParameter("format", this.headerValueUtils.adFormatToApiValue(somaAdRequest.getAdRequest().getAdFormat())).appendQueryParameter(KEY_MEDIATION_VERSION, "2").appendQueryParameter(KEY_MEDIATION_ADAPTER_VERSION, somaAdRequest.getAdRequest().getMediationAdapterVersion()).appendQueryParameter(KEY_MEDIATION_NETWORK_NAME, somaAdRequest.getAdRequest().getMediationNetworkName()).appendQueryParameter(KEY_MEDIATION_NETWORK_SDK_VERSION, somaAdRequest.getAdRequest().getMediationNetworkSdkVersion());
        int i = AnonymousClass1.$SwitchMap$com$smaato$sdk$core$ad$AdFormat[somaAdRequest.getAdRequest().getAdFormat().ordinal()];
        if (i == 1) {
            builderAppendQueryParameter.appendQueryParameter(KEY_VASTVERSION, VALUE_VAST_VERSION);
            builderAppendQueryParameter.appendQueryParameter("privacyIcon", "1");
        } else if (i == 2 || i == 3) {
            builderAppendQueryParameter.appendQueryParameter(KEY_VASTVERSION, VALUE_VAST_VERSION);
            builderAppendQueryParameter.appendQueryParameter("privacyIcon", "1");
            builderAppendQueryParameter.appendQueryParameter(KEY_MRAIDVERSION, "3");
        } else if (i == 4 || i == 5) {
            builderAppendQueryParameter.appendQueryParameter(KEY_MRAIDVERSION, "3");
        }
        return request.buildUpon().uri(builderAppendQueryParameter.build()).build();
    }

    /* JADX INFO: renamed from: com.smaato.sdk.core.mvvm.model.soma.SomaRemoteSource$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$smaato$sdk$core$ad$AdFormat;

        static {
            int[] iArr = new int[AdFormat.values().length];
            $SwitchMap$com$smaato$sdk$core$ad$AdFormat = iArr;
            try {
                iArr[AdFormat.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$smaato$sdk$core$ad$AdFormat[AdFormat.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$smaato$sdk$core$ad$AdFormat[AdFormat.NATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$smaato$sdk$core$ad$AdFormat[AdFormat.DISPLAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$smaato$sdk$core$ad$AdFormat[AdFormat.RICH_MEDIA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private AdResponse getAdResponseFromSoma(Request request) throws IOException {
        cancelCurrentCall();
        Call callNewCall = this.somaHttpClient.newCall(request);
        this.currentCall = callNewCall;
        Response responseExecute = callNewCall.execute();
        try {
            this.currentCall = null;
            AdFormat adFormat = this.headerValueUtils.getAdFormat(responseExecute.headers());
            if (adFormat == null) {
                this.logger.error(LogDomain.CORE, "No adformat received", new Object[0]);
                throw new SomaException(SomaException.Type.BAD_RESPONSE, "No adformat received");
            }
            AdResponseParser adResponseParser = this.adResponseParsers.get(adFormat);
            if (adResponseParser == null) {
                this.logger.error(LogDomain.CORE, "Illegal ad format: " + adFormat, new Object[0]);
                throw new SomaException(SomaException.Type.BAD_RESPONSE, "Illegal ad format: " + adFormat);
            }
            AdResponse somaResponse = adResponseParser.parseSomaResponse(responseExecute);
            responseExecute.close();
            return somaResponse;
        } catch (Throwable th) {
            if (responseExecute != null) {
                try {
                    responseExecute.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private void cancelCurrentCall() {
        Call call = this.currentCall;
        if (call != null) {
            call.cancel();
            this.currentCall = null;
        }
    }
}
