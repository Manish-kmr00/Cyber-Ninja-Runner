package io.bidmachine.core;

import android.util.Base64;
import com.explorestack.protobuf.AbstractMessage;
import com.google.common.net.HttpHeaders;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.safedk.android.internal.partials.BidMachineNetworkBridge;
import com.unity3d.ads.gatewayclient.CommonGatewayClient;
import io.bidmachine.util.taskmanager.TaskManager;
import io.bidmachine.util.taskmanager.coroutine.NetworkTaskManager;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NetworkRequest<RequestDataType, RequestResultType, ErrorResultType> {
    private static final TaskManager TASK_MANAGER = new NetworkTaskManager();
    private Callback<RequestResultType, ErrorResultType> callback;
    private CancelCallback cancelCallback;
    private ArrayList<RequestDataEncoder<RequestDataType, RequestResultType, ErrorResultType>> contentEncoders;
    private URLConnection currentConnection;
    private State currentState = State.Idle;
    private RequestDataBinder<RequestDataType, RequestResultType, ErrorResultType> dataBinder;
    private ArrayList<RequestDataEncoder<RequestDataType, RequestResultType, ErrorResultType>> dataEncoders;
    private ErrorResultType errorResult;
    private final Method method;
    private final String path;
    private final RequestDataType requestData;
    private RequestResultType requestResult;

    public interface Callback<RequestResultType, ErrorResultType> {
        void onFail(ErrorResultType errorresulttype);

        void onSuccess(RequestResultType requestresulttype);
    }

    public interface CancelCallback {
        void onCanceled();
    }

    public static abstract class RequestDataBinder<RequestDataType, RequestResultType, ErrorResultType> {
        protected ErrorResultType createFailResult(NetworkRequest<RequestDataType, RequestResultType, ErrorResultType> networkRequest, URLConnection uRLConnection, byte[] bArr) throws Exception {
            return null;
        }

        protected abstract RequestResultType createSuccessResult(NetworkRequest<RequestDataType, RequestResultType, ErrorResultType> networkRequest, URLConnection uRLConnection, byte[] bArr) throws Exception;

        protected abstract byte[] obtainData(NetworkRequest<RequestDataType, RequestResultType, ErrorResultType> networkRequest, URLConnection uRLConnection, RequestDataType requestdatatype) throws Exception;

        protected abstract void prepareHeaders(NetworkRequest<RequestDataType, RequestResultType, ErrorResultType> networkRequest, URLConnection uRLConnection);

        protected void prepareRequest(NetworkRequest<RequestDataType, RequestResultType, ErrorResultType> networkRequest, URLConnection uRLConnection) {
        }
    }

    public static abstract class RequestDataEncoder<RequestDataType, RequestResultType, ErrorResultType> {
        protected abstract byte[] decode(NetworkRequest<RequestDataType, RequestResultType, ErrorResultType> networkRequest, URLConnection uRLConnection, byte[] bArr) throws Exception;

        protected abstract byte[] encode(NetworkRequest<RequestDataType, RequestResultType, ErrorResultType> networkRequest, URLConnection uRLConnection, byte[] bArr) throws Exception;

        protected void prepareHeaders(NetworkRequest<RequestDataType, RequestResultType, ErrorResultType> networkRequest, URLConnection uRLConnection) {
        }
    }

    public enum State {
        Idle,
        Running,
        Success,
        Fail,
        Canceled
    }

    protected abstract ErrorResultType obtainError(URLConnection uRLConnection, int i);

    protected abstract ErrorResultType obtainError(URLConnection uRLConnection, Throwable th);

    public enum Method {
        Get("GET"),
        Post("POST");

        private final String methodString;

        Method(String str) {
            this.methodString = str;
        }

        public void apply(URLConnection uRLConnection) throws ProtocolException {
            if (uRLConnection instanceof HttpURLConnection) {
                ((HttpURLConnection) uRLConnection).setRequestMethod(this.methodString);
            }
        }
    }

    public NetworkRequest(Method method, String str, RequestDataType requestdatatype) {
        this.method = method;
        this.path = str;
        this.requestData = requestdatatype;
    }

    public void setDataBinder(RequestDataBinder<RequestDataType, RequestResultType, ErrorResultType> requestDataBinder) {
        this.dataBinder = requestDataBinder;
    }

    public void addDataEncoder(RequestDataEncoder<RequestDataType, RequestResultType, ErrorResultType> requestDataEncoder) {
        if (this.dataEncoders == null) {
            this.dataEncoders = new ArrayList<>();
        }
        this.dataEncoders.add(requestDataEncoder);
    }

    public void addContentEncoder(RequestDataEncoder<RequestDataType, RequestResultType, ErrorResultType> requestDataEncoder) {
        if (this.contentEncoders == null) {
            this.contentEncoders = new ArrayList<>();
        }
        this.contentEncoders.add(requestDataEncoder);
    }

    public void setCallback(Callback<RequestResultType, ErrorResultType> callback) {
        this.callback = callback;
    }

    public void setCancelCallback(CancelCallback cancelCallback) {
        this.cancelCallback = cancelCallback;
    }

    public Method getMethod() {
        return this.method;
    }

    public String getPath() {
        return this.path;
    }

    public void request() {
        request(TASK_MANAGER);
    }

    public void request(TaskManager taskManager) {
        try {
            taskManager.execute(new NetworkRequestRunner());
        } catch (Throwable th) {
            Logger.w(th);
            Callback<RequestResultType, ErrorResultType> callback = this.callback;
            if (callback != null) {
                callback.onFail(obtainError((URLConnection) null, th));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:84:0x0145  */
    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "Object.hashCode()" because "this.second" is null
    	at jadx.core.utils.Pair.hashCode(Pair.java:35)
    	at java.base/java.util.HashMap.hash(Unknown Source)
    	at java.base/java.util.HashMap.getNode(Unknown Source)
    	at java.base/java.util.HashMap.containsKey(Unknown Source)
    	at jadx.core.dex.visitors.finaly.traverser.state.TraverserGlobalCommonState.hasBlocksBeenCached(TraverserGlobalCommonState.java:35)
    	at jadx.core.dex.visitors.finaly.traverser.handlers.MergePathActivePathTraverserHandler.handle(MergePathActivePathTraverserHandler.java:174)
    	at jadx.core.dex.visitors.finaly.traverser.handlers.AbstractActivePathTraverserHandler.process(AbstractActivePathTraverserHandler.java:19)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.processHandlerImplementations(TraverserController.java:43)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.advance(TraverserController.java:156)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.process(TraverserController.java:79)
    	at jadx.core.dex.visitors.finaly.traverser.handlers.MergePathActivePathTraverserHandler.handle(MergePathActivePathTraverserHandler.java:158)
    	at jadx.core.dex.visitors.finaly.traverser.handlers.AbstractActivePathTraverserHandler.process(AbstractActivePathTraverserHandler.java:19)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.processHandlerImplementations(TraverserController.java:43)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.advance(TraverserController.java:156)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.process(TraverserController.java:79)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(MarkFinallyVisitor.java:404)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(MarkFinallyVisitor.java:284)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:135)
     */
    public void process() {
        URLConnection uRLConnection;
        State state;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStreamUrlConnectionGetInputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        RequestDataBinder<RequestDataType, RequestResultType, ErrorResultType> requestDataBinder;
        BufferedOutputStream bufferedOutputStream;
        this.currentState = State.Running;
        try {
            URLConnection uRLConnectionOpenConnection = (this.path != null ? new URL(getBaseUrl() + RemoteSettings.FORWARD_SLASH_STRING + this.path) : new URL(getBaseUrl())).openConnection();
            try {
                this.currentConnection = uRLConnectionOpenConnection;
                this.method.apply(uRLConnectionOpenConnection);
                prepareRequestParams(uRLConnectionOpenConnection);
                byte[] bArrObtainRequestData = obtainRequestData(uRLConnectionOpenConnection);
                if (bArrObtainRequestData != null) {
                    byte[] bArrEncodeRequestData = encodeRequestData(uRLConnectionOpenConnection, bArrObtainRequestData);
                    uRLConnectionOpenConnection.setDoOutput(true);
                    try {
                        bufferedOutputStream = new BufferedOutputStream(BidMachineNetworkBridge.urlConnectionGetOutputStream(uRLConnectionOpenConnection));
                        try {
                            bufferedOutputStream.write(bArrEncodeRequestData);
                            Utils.flush(bufferedOutputStream);
                            Utils.close(bufferedOutputStream);
                        } catch (Throwable th) {
                            th = th;
                            Utils.flush(bufferedOutputStream);
                            Utils.close(bufferedOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedOutputStream = null;
                    }
                }
                try {
                    int iObtainResponseCode = obtainResponseCode(uRLConnectionOpenConnection);
                    if (isCanceled()) {
                        Utils.flush(null);
                        Utils.close(null);
                        Utils.close(null);
                        if (uRLConnectionOpenConnection instanceof HttpURLConnection) {
                            BidMachineNetworkBridge.httpUrlConnectionDisconnect((HttpURLConnection) uRLConnectionOpenConnection);
                        }
                        this.currentConnection = null;
                        if (isCanceled()) {
                            return;
                        }
                        this.currentState = this.errorResult == null ? State.Success : State.Fail;
                        return;
                    }
                    if (iObtainResponseCode != 200) {
                        this.errorResult = obtainError(uRLConnectionOpenConnection, iObtainResponseCode);
                        inputStreamUrlConnectionGetInputStream = null;
                        byteArrayOutputStream2 = null;
                    } else {
                        inputStreamUrlConnectionGetInputStream = BidMachineNetworkBridge.urlConnectionGetInputStream(uRLConnectionOpenConnection);
                        try {
                            byteArrayOutputStream2 = new ByteArrayOutputStream();
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int i = inputStreamUrlConnectionGetInputStream.read(bArr);
                                    if (i == -1) {
                                        break;
                                    } else {
                                        byteArrayOutputStream2.write(bArr, 0, i);
                                    }
                                }
                                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                                if (byteArray != null) {
                                    byteArray = decodeResponseData(uRLConnectionOpenConnection, byteArray);
                                }
                                if (byteArray != null && byteArray.length > 0 && (requestDataBinder = this.dataBinder) != null) {
                                    RequestResultType requestresulttypeCreateSuccessResult = requestDataBinder.createSuccessResult(this, uRLConnectionOpenConnection, byteArray);
                                    this.requestResult = requestresulttypeCreateSuccessResult;
                                    if (requestresulttypeCreateSuccessResult == null) {
                                        this.errorResult = this.dataBinder.createFailResult(this, uRLConnectionOpenConnection, byteArray);
                                    }
                                }
                            } catch (Throwable th3) {
                                inputStream = inputStreamUrlConnectionGetInputStream;
                                th = th3;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                Utils.flush(byteArrayOutputStream);
                                Utils.close(byteArrayOutputStream);
                                Utils.close(inputStream);
                                throw th;
                            }
                        } catch (Throwable th4) {
                            byteArrayOutputStream = null;
                            inputStream = inputStreamUrlConnectionGetInputStream;
                            th = th4;
                        }
                    }
                    Utils.flush(byteArrayOutputStream2);
                    Utils.close(byteArrayOutputStream2);
                    Utils.close(inputStreamUrlConnectionGetInputStream);
                    if (uRLConnectionOpenConnection instanceof HttpURLConnection) {
                        BidMachineNetworkBridge.httpUrlConnectionDisconnect((HttpURLConnection) uRLConnectionOpenConnection);
                    }
                    this.currentConnection = null;
                    if (isCanceled()) {
                        return;
                    }
                    if (this.errorResult == null) {
                        state = State.Success;
                    } else {
                        state = State.Fail;
                    }
                    this.currentState = state;
                } catch (Throwable th5) {
                    th = th5;
                    inputStream = null;
                    byteArrayOutputStream = null;
                }
            } catch (Throwable th6) {
                uRLConnection = uRLConnectionOpenConnection;
                th = th6;
                try {
                    Logger.w(th);
                    this.errorResult = obtainError(uRLConnection, th);
                    if (uRLConnection instanceof HttpURLConnection) {
                        BidMachineNetworkBridge.httpUrlConnectionDisconnect((HttpURLConnection) uRLConnection);
                    }
                    this.currentConnection = null;
                    if (isCanceled()) {
                        return;
                    }
                    if (this.errorResult == null) {
                        state = State.Success;
                    }
                    this.currentState = state;
                } catch (Throwable th7) {
                    if (uRLConnection instanceof HttpURLConnection) {
                        BidMachineNetworkBridge.httpUrlConnectionDisconnect((HttpURLConnection) uRLConnection);
                    }
                    this.currentConnection = null;
                    if (!isCanceled()) {
                        this.currentState = this.errorResult == null ? State.Success : State.Fail;
                    }
                    throw th7;
                }
            }
        } catch (Throwable th8) {
            th = th8;
            uRLConnection = null;
        }
    }

    protected void prepareRequestParams(URLConnection uRLConnection) {
        uRLConnection.setConnectTimeout(40000);
        uRLConnection.setReadTimeout(40000);
    }

    protected byte[] obtainRequestData(URLConnection uRLConnection) throws Exception {
        RequestDataBinder<RequestDataType, RequestResultType, ErrorResultType> requestDataBinder = this.dataBinder;
        if (requestDataBinder == null) {
            return null;
        }
        requestDataBinder.prepareRequest(this, uRLConnection);
        this.dataBinder.prepareHeaders(this, uRLConnection);
        return this.dataBinder.obtainData(this, uRLConnection, this.requestData);
    }

    protected byte[] encodeRequestData(URLConnection uRLConnection, byte[] bArr) throws Exception {
        ArrayList<RequestDataEncoder<RequestDataType, RequestResultType, ErrorResultType>> arrayList = this.dataEncoders;
        if (arrayList != null) {
            for (RequestDataEncoder<RequestDataType, RequestResultType, ErrorResultType> requestDataEncoder : arrayList) {
                requestDataEncoder.prepareHeaders(this, uRLConnection);
                bArr = requestDataEncoder.encode(this, uRLConnection, bArr);
            }
        }
        ArrayList<RequestDataEncoder<RequestDataType, RequestResultType, ErrorResultType>> arrayList2 = this.contentEncoders;
        if (arrayList2 != null) {
            for (RequestDataEncoder<RequestDataType, RequestResultType, ErrorResultType> requestDataEncoder2 : arrayList2) {
                requestDataEncoder2.prepareHeaders(this, uRLConnection);
                bArr = requestDataEncoder2.encode(this, uRLConnection, bArr);
            }
        }
        return bArr;
    }

    protected byte[] decodeResponseData(URLConnection uRLConnection, byte[] bArr) throws Exception {
        ArrayList<RequestDataEncoder<RequestDataType, RequestResultType, ErrorResultType>> arrayList = this.contentEncoders;
        if (arrayList != null) {
            Iterator<RequestDataEncoder<RequestDataType, RequestResultType, ErrorResultType>> it = arrayList.iterator();
            while (it.hasNext()) {
                bArr = it.next().decode(this, uRLConnection, bArr);
            }
        }
        ArrayList<RequestDataEncoder<RequestDataType, RequestResultType, ErrorResultType>> arrayList2 = this.dataEncoders;
        if (arrayList2 != null) {
            Iterator<RequestDataEncoder<RequestDataType, RequestResultType, ErrorResultType>> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                bArr = it2.next().decode(this, uRLConnection, bArr);
            }
        }
        return bArr;
    }

    private int obtainResponseCode(URLConnection uRLConnection) throws IOException {
        if (uRLConnection instanceof HttpURLConnection) {
            return BidMachineNetworkBridge.httpUrlConnectionGetResponseCode((HttpURLConnection) uRLConnection);
        }
        return -1;
    }

    private InputStream obtainErrorStream(URLConnection uRLConnection) {
        if (uRLConnection instanceof HttpURLConnection) {
            return ((HttpURLConnection) uRLConnection).getErrorStream();
        }
        return null;
    }

    protected String getBaseUrl() throws Exception {
        return "TODO: implement url";
    }

    public void cancel() {
        this.currentState = State.Canceled;
        CancelCallback cancelCallback = this.cancelCallback;
        if (cancelCallback != null) {
            cancelCallback.onCanceled();
        }
    }

    public boolean isCanceled() {
        return this.currentState == State.Canceled;
    }

    static abstract class ProtobufDataBinder<RequestDataType extends AbstractMessage, RequestResultType, ErrorResultType> extends RequestDataBinder<RequestDataType, RequestResultType, ErrorResultType> {
        ProtobufDataBinder() {
        }

        @Override // io.bidmachine.core.NetworkRequest.RequestDataBinder
        protected /* bridge */ /* synthetic */ byte[] obtainData(NetworkRequest networkRequest, URLConnection uRLConnection, Object obj) throws Exception {
            return obtainData((NetworkRequest<AbstractMessage, RequestResultType, ErrorResultType>) networkRequest, uRLConnection, (AbstractMessage) obj);
        }

        @Override // io.bidmachine.core.NetworkRequest.RequestDataBinder
        protected void prepareHeaders(NetworkRequest<RequestDataType, RequestResultType, ErrorResultType> networkRequest, URLConnection uRLConnection) {
            uRLConnection.setRequestProperty("Content-Type", CommonGatewayClient.HEADER_PROTOBUF);
        }

        protected byte[] obtainData(NetworkRequest<RequestDataType, RequestResultType, ErrorResultType> networkRequest, URLConnection uRLConnection, RequestDataType requestdatatype) {
            if (requestdatatype != null) {
                return requestdatatype.toByteArray();
            }
            return null;
        }
    }

    static abstract class JsonDataBinder<RequestResultType, ErrorResultType> extends RequestDataBinder<JSONObject, RequestResultType, ErrorResultType> {
        JsonDataBinder() {
        }

        @Override // io.bidmachine.core.NetworkRequest.RequestDataBinder
        protected void prepareHeaders(NetworkRequest<JSONObject, RequestResultType, ErrorResultType> networkRequest, URLConnection uRLConnection) {
            uRLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.bidmachine.core.NetworkRequest.RequestDataBinder
        public byte[] obtainData(NetworkRequest<JSONObject, RequestResultType, ErrorResultType> networkRequest, URLConnection uRLConnection, JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                return jSONObject.toString().getBytes("UTF-8");
            }
            return null;
        }
    }

    public static class SimpleJsonObjectDataBinder<ErrorResultType> extends JsonDataBinder<JSONObject, ErrorResultType> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.bidmachine.core.NetworkRequest.RequestDataBinder
        public JSONObject createSuccessResult(NetworkRequest<JSONObject, JSONObject, ErrorResultType> networkRequest, URLConnection uRLConnection, byte[] bArr) throws Exception {
            return new JSONObject(new String(bArr));
        }
    }

    public static class SimpleJsonArrayDataBinder<ErrorResultType> extends JsonDataBinder<JSONArray, ErrorResultType> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.bidmachine.core.NetworkRequest.RequestDataBinder
        public JSONArray createSuccessResult(NetworkRequest<JSONObject, JSONArray, ErrorResultType> networkRequest, URLConnection uRLConnection, byte[] bArr) throws Exception {
            return new JSONArray(new String(bArr));
        }
    }

    public static class Base64RequestDataEncoder extends RequestDataEncoder {
        @Override // io.bidmachine.core.NetworkRequest.RequestDataEncoder
        protected byte[] encode(NetworkRequest networkRequest, URLConnection uRLConnection, byte[] bArr) {
            return Base64.encode(bArr, 0);
        }

        @Override // io.bidmachine.core.NetworkRequest.RequestDataEncoder
        protected byte[] decode(NetworkRequest networkRequest, URLConnection uRLConnection, byte[] bArr) {
            return Base64.decode(bArr, 0);
        }
    }

    public static class GZIPRequestDataEncoder<RequestDataType, RequestResultType, ErrorResultType> extends RequestDataEncoder<RequestDataType, RequestResultType, ErrorResultType> {
        @Override // io.bidmachine.core.NetworkRequest.RequestDataEncoder
        protected void prepareHeaders(NetworkRequest<RequestDataType, RequestResultType, ErrorResultType> networkRequest, URLConnection uRLConnection) {
            uRLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "gzip");
            uRLConnection.setRequestProperty("Content-Encoding", "gzip");
        }

        @Override // io.bidmachine.core.NetworkRequest.RequestDataEncoder
        protected byte[] encode(NetworkRequest<RequestDataType, RequestResultType, ErrorResultType> networkRequest, URLConnection uRLConnection, byte[] bArr) throws Exception {
            GZIPOutputStream gZIPOutputStream;
            ByteArrayOutputStream byteArrayOutputStream = null;
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream2);
                    try {
                        gZIPOutputStream.write(bArr);
                        Utils.close(gZIPOutputStream);
                        byte[] byteArray = byteArrayOutputStream2.toByteArray();
                        Utils.flush(byteArrayOutputStream2);
                        Utils.close(byteArrayOutputStream2);
                        Utils.flush(null);
                        Utils.close(null);
                        return byteArray;
                    } catch (Throwable th) {
                        th = th;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        Utils.flush(byteArrayOutputStream);
                        Utils.close(byteArrayOutputStream);
                        Utils.flush(gZIPOutputStream);
                        Utils.close(gZIPOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    gZIPOutputStream = null;
                }
            } catch (Throwable th3) {
                th = th3;
                gZIPOutputStream = null;
            }
        }

        @Override // io.bidmachine.core.NetworkRequest.RequestDataEncoder
        protected byte[] decode(NetworkRequest<RequestDataType, RequestResultType, ErrorResultType> networkRequest, URLConnection uRLConnection, byte[] bArr) throws Exception {
            GZIPInputStream gZIPInputStream;
            ByteArrayInputStream byteArrayInputStream;
            Throwable th;
            ByteArrayOutputStream byteArrayOutputStream;
            if (!"gzip".equals(uRLConnection.getContentEncoding())) {
                return bArr;
            }
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byteArrayInputStream = new ByteArrayInputStream(bArr);
                    try {
                        gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                        try {
                            byte[] bArr2 = new byte[1024];
                            while (true) {
                                int i = gZIPInputStream.read(bArr2);
                                if (i != -1) {
                                    byteArrayOutputStream.write(bArr2, 0, i);
                                } else {
                                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                                    Utils.flush(byteArrayOutputStream);
                                    Utils.close(byteArrayOutputStream);
                                    Utils.close(byteArrayInputStream);
                                    Utils.close(gZIPInputStream);
                                    return byteArray;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            Utils.flush(byteArrayOutputStream);
                            Utils.close(byteArrayOutputStream);
                            Utils.close(byteArrayInputStream);
                            Utils.close(gZIPInputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        gZIPInputStream = null;
                        th = th3;
                    }
                } catch (Throwable th4) {
                    byteArrayInputStream = null;
                    th = th4;
                    gZIPInputStream = null;
                }
            } catch (Throwable th5) {
                gZIPInputStream = null;
                byteArrayInputStream = null;
                th = th5;
                byteArrayOutputStream = null;
            }
        }
    }

    private final class NetworkRequestRunner implements Runnable {
        private NetworkRequestRunner() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            NetworkRequest.this.process();
            if (NetworkRequest.this.callback == null || NetworkRequest.this.isCanceled()) {
                return;
            }
            if (NetworkRequest.this.currentState == State.Success) {
                NetworkRequest.this.callback.onSuccess(NetworkRequest.this.requestResult);
            } else {
                NetworkRequest.this.callback.onFail(NetworkRequest.this.errorResult);
            }
        }
    }
}
