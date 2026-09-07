package com.pubmatic.sdk.video.vastparser;

import android.os.Handler;
import android.os.Looper;
import com.pubmatic.sdk.common.POBError;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.network.POBHttpRequest;
import com.pubmatic.sdk.common.network.POBNetworkHandler;
import com.pubmatic.sdk.common.taskhandler.POBTaskHandler;
import com.pubmatic.sdk.video.POBVastError;
import com.pubmatic.sdk.video.POBVideoLogConstants;
import com.pubmatic.sdk.video.vastmodels.POBVast;
import com.pubmatic.sdk.video.vastmodels.POBVastAd;
import com.pubmatic.sdk.video.xmlserialiser.POBXMLParser;
import com.smaato.sdk.core.dns.DnsName;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class POBVastParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final POBVastParserListener f7875a;
    private final int b;
    private final POBNetworkHandler d;
    private int e = 5000;
    private final Handler c = new Handler(Looper.getMainLooper());

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7876a;

        a(String str) {
            this.f7876a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            POBVastParser pOBVastParser = POBVastParser.this;
            pOBVastParser.a(this.f7876a, pOBVastParser.b, (POBVastAd) null);
        }
    }

    class b implements POBNetworkHandler.POBNetworkListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ POBVast f7877a;
        final /* synthetic */ int b;

        b(POBVast pOBVast, int i) {
            this.f7877a = pOBVast;
            this.b = i;
        }

        @Override // com.pubmatic.sdk.common.network.POBNetworkHandler.POBNetworkListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            if (str == null || this.f7877a.getAds() == null) {
                POBLog.debug("POBVastParser", "Network response is null", new Object[0]);
                POBVastParser.this.a(this.f7877a, 303, POBVideoLogConstants.MSG_NO_VAST_RESPONSE);
            } else if (POBVastParser.this.a(str, this.b - 1, this.f7877a.getAds().get(0)) == null) {
                POBVastParser.this.a(this.f7877a, 100, POBVideoLogConstants.MSG_XML_PARSING_ERROR);
            }
        }

        @Override // com.pubmatic.sdk.common.network.POBNetworkHandler.POBNetworkListener
        public void onFailure(POBError pOBError) {
            POBVastParser pOBVastParser = POBVastParser.this;
            pOBVastParser.a(this.f7877a, pOBVastParser.a(pOBError), pOBError.getErrorMessage());
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ POBVast f7878a;
        final /* synthetic */ int b;
        final /* synthetic */ String c;

        c(POBVast pOBVast, int i, String str) {
            this.f7878a = pOBVast;
            this.b = i;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (POBVastParser.this.f7875a != null) {
                POBVastParser.this.f7875a.onFailure(this.f7878a, new POBVastError(this.b, this.c));
            }
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ POBVast f7879a;

        d(POBVast pOBVast) {
            this.f7879a = pOBVast;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (POBVastParser.this.f7875a != null) {
                POBVastParser.this.f7875a.onSuccess(this.f7879a);
            }
        }
    }

    public POBVastParser(POBNetworkHandler pOBNetworkHandler, int i, POBVastParserListener pOBVastParserListener) {
        this.d = pOBNetworkHandler;
        this.f7875a = pOBVastParserListener;
        this.b = i;
    }

    public void parse(String str) {
        POBTaskHandler.getInstance().runOnBackgroundThread(new a(str));
    }

    public void setWrapperTimeout(int i) {
        this.e = i;
    }

    private boolean b(POBVast pOBVast) {
        return (pOBVast == null || pOBVast.getAds() == null || pOBVast.getAds().isEmpty() || pOBVast.getAds().get(0).getAdType() != POBVastAd.POBVastAdType.INLINE) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public POBVast a(String str, int i, POBVastAd pOBVastAd) {
        POBVast pOBVast = (POBVast) POBXMLParser.parse(str, POBVast.class);
        if (pOBVast != null) {
            if (pOBVast.getAds() != null && !pOBVast.getAds().isEmpty()) {
                pOBVast.getAds().get(0).setWrapper(pOBVastAd);
            }
            if (pOBVast.getVersion() != null && !a(pOBVast.getVersion())) {
                a(pOBVast, 102, POBVideoLogConstants.MSG_UNSUPPORTED_VAST_VERSION);
                return pOBVast;
            }
            if (b(pOBVast)) {
                a(pOBVast);
            } else if (i == 0) {
                a(pOBVast, 302, POBVideoLogConstants.MSG_WRAPPER_THRESHOLD);
            } else {
                List<POBVastAd> ads = pOBVast.getAds();
                if (ads != null && !ads.isEmpty() && ads.get(0).getAdType() != POBVastAd.POBVastAdType.NO_ADS) {
                    String vASTAdTagURI = ads.get(0).getVASTAdTagURI();
                    if (vASTAdTagURI != null && !vASTAdTagURI.isEmpty()) {
                        POBHttpRequest pOBHttpRequest = new POBHttpRequest();
                        pOBHttpRequest.setUrl(vASTAdTagURI);
                        pOBHttpRequest.setRequestTag("POBVastParser");
                        pOBHttpRequest.setTimeout(this.e);
                        this.d.sendRequest(pOBHttpRequest, new b(pOBVast, i));
                    } else {
                        a(pOBVast, 101, POBVideoLogConstants.MSG_SCHEMA_VALIDATION_ERROR);
                    }
                } else {
                    a(pOBVast, 303, POBVideoLogConstants.MSG_NO_VAST_RESPONSE);
                }
            }
        } else if (i == this.b) {
            a((POBVast) null, 100, POBVideoLogConstants.MSG_XML_PARSING_ERROR);
        }
        return pOBVast;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(POBVast pOBVast, int i, String str) {
        this.c.post(new c(pOBVast, i, str));
    }

    private void a(POBVast pOBVast) {
        this.c.post(new d(pOBVast));
    }

    private boolean a(String str) {
        if (str == null) {
            return false;
        }
        try {
            return Integer.parseInt(str.split(DnsName.ESCAPED_DOT)[0]) >= 2;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(POBError pOBError) {
        return (pOBError == null || pOBError.getErrorCode() != 1005) ? 300 : 301;
    }
}
