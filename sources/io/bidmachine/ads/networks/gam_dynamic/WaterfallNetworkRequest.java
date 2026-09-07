package io.bidmachine.ads.networks.gam_dynamic;

import com.unity3d.ads.gatewayclient.CommonGatewayClient;
import io.bidmachine.core.NetworkRequest;
import io.bidmachine.protobuf.Waterfall;
import io.bidmachine.utils.BMError;
import java.net.SocketTimeoutException;
import java.net.URLConnection;
import java.net.UnknownHostException;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes6.dex */
public class WaterfallNetworkRequest extends NetworkRequest<Waterfall.Result, Waterfall.Configuration, BMError> {
    private final int timeOut;
    private final String url;

    public interface Callback extends NetworkRequest.Callback<Waterfall.Configuration, BMError>, NetworkRequest.CancelCallback {
    }

    public WaterfallNetworkRequest(String str, Waterfall.Result result, int i) {
        super(NetworkRequest.Method.Post, null, result);
        this.url = str;
        this.timeOut = i;
        setDataBinder(new RequestBinder());
    }

    @Override // io.bidmachine.core.NetworkRequest
    protected String getBaseUrl() throws Exception {
        return this.url;
    }

    @Override // io.bidmachine.core.NetworkRequest
    protected void prepareRequestParams(URLConnection uRLConnection) {
        super.prepareRequestParams(uRLConnection);
        uRLConnection.setConnectTimeout(this.timeOut);
        uRLConnection.setReadTimeout(this.timeOut);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.core.NetworkRequest
    public BMError obtainError(URLConnection uRLConnection, int i) {
        BMError bMErrorInternal;
        if (i >= 200 && i < 300) {
            return BMError.BMServerNoFill;
        }
        if (i >= 400 && i < 500) {
            bMErrorInternal = BMError.Request;
        } else if (i >= 500 && i < 600) {
            bMErrorInternal = BMError.Server;
        } else {
            bMErrorInternal = BMError.internal("Unknown server error");
        }
        return new BMError(bMErrorInternal, i, "Server returned " + i + " code");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.core.NetworkRequest
    public BMError obtainError(URLConnection uRLConnection, Throwable th) {
        if (th instanceof UnknownHostException) {
            return BMError.NoConnection;
        }
        if ((th instanceof SocketTimeoutException) || (th instanceof ConnectTimeoutException)) {
            return BMError.TimeoutError;
        }
        return BMError.throwable("Unknown api request error", th);
    }

    private static class RequestBinder extends NetworkRequest.RequestDataBinder<Waterfall.Result, Waterfall.Configuration, BMError> {
        private RequestBinder() {
        }

        @Override // io.bidmachine.core.NetworkRequest.RequestDataBinder
        protected void prepareHeaders(NetworkRequest<Waterfall.Result, Waterfall.Configuration, BMError> networkRequest, URLConnection uRLConnection) {
            uRLConnection.setRequestProperty("Content-Type", CommonGatewayClient.HEADER_PROTOBUF);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.bidmachine.core.NetworkRequest.RequestDataBinder
        public byte[] obtainData(NetworkRequest<Waterfall.Result, Waterfall.Configuration, BMError> networkRequest, URLConnection uRLConnection, Waterfall.Result result) throws Exception {
            return Waterfall.newBuilder().setRequest(result).build().toByteArray();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.bidmachine.core.NetworkRequest.RequestDataBinder
        public Waterfall.Configuration createSuccessResult(NetworkRequest<Waterfall.Result, Waterfall.Configuration, BMError> networkRequest, URLConnection uRLConnection, byte[] bArr) throws Exception {
            return Waterfall.parseFrom(bArr).getResponse();
        }
    }
}
