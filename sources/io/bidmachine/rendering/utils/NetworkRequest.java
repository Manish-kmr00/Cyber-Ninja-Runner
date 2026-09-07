package io.bidmachine.rendering.utils;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.safedk.android.internal.partials.BidMachineFilesBridge;
import com.safedk.android.internal.partials.BidMachineNetworkBridge;
import io.bidmachine.rendering.model.Error;
import io.bidmachine.rendering.utils.taskmanager.CancelableTask;
import io.bidmachine.util.taskmanager.TaskManager;
import io.bidmachine.util.taskmanager.coroutine.NetworkTaskManager;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkRequest<ResponseType> {
    private static final TaskManager m = new NetworkTaskManager();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12429a;
    private final Method b;
    private final Map c;
    private final Map d;
    private final Integer e;
    private final Integer f;
    private final UrlConnectionProcessor g;
    private final DataRetriever h;
    private final ResponseProcessor i;
    private final Listener j;
    private TaskManager k;
    private CancelableTask l;

    public static class Builder<ResponseType> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f12430a;
        private final Method b;
        private final Map c = new HashMap();
        private final Map d = new HashMap();
        private Integer e;
        private Integer f;
        private UrlConnectionProcessor g;
        private DataRetriever h;
        private ResponseProcessor i;
        private Listener j;

        public Builder(String url, Method method) {
            this.f12430a = url;
            this.b = method;
        }

        public Builder<ResponseType> addHeader(String key, String value) {
            this.c.put(key, value);
            return this;
        }

        public Builder<ResponseType> addQueryParameter(String key, String value) {
            this.d.put(key, value);
            return this;
        }

        public NetworkRequest<ResponseType> build() {
            return new NetworkRequest<>(this.f12430a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
        }

        public NetworkRequest<ResponseType> send() {
            NetworkRequest<ResponseType> networkRequestBuild = build();
            networkRequestBuild.send();
            return networkRequestBuild;
        }

        public Builder<ResponseType> setConnectTimeout(Integer connectTimeout) {
            this.e = connectTimeout;
            return this;
        }

        public Builder<ResponseType> setHeaders(Map<String, String> headers) {
            Utils.set(this.c, headers);
            return this;
        }

        public Builder<ResponseType> setListener(Listener<ResponseType> listener) {
            this.j = listener;
            return this;
        }

        public Builder<ResponseType> setQueryParameters(Map<String, String> parameters) {
            Utils.set(this.d, parameters);
            return this;
        }

        public Builder<ResponseType> setReadTimeout(Integer readTimeout) {
            this.f = readTimeout;
            return this;
        }

        public Builder<ResponseType> setRequestDataRetriever(DataRetriever requestDataRetriever) {
            this.h = requestDataRetriever;
            return this;
        }

        public Builder<ResponseType> setResponseTransformer(ResponseProcessor<ResponseType> responseProcessor) {
            this.i = responseProcessor;
            return this;
        }

        public Builder<ResponseType> setUrlConnectionProcessor(UrlConnectionProcessor urlConnectionProcessor) {
            this.g = urlConnectionProcessor;
            return this;
        }

        public Builder<ResponseType> setUserAgent(String userAgent) {
            if (!TextUtils.isEmpty(userAgent)) {
                addHeader("User-Agent", userAgent);
            }
            return this;
        }
    }

    public static abstract class ByteArrayProcessor<T> implements ResponseProcessor<T>, ResponseTransformer<byte[], T> {
        @Override // io.bidmachine.rendering.utils.NetworkRequest.ResponseProcessor
        public T process(URLConnection urlConnection) throws Throwable {
            ByteArrayOutputStream byteArrayOutputStream;
            InputStream inputStream = null;
            try {
                InputStream inputStreamUrlConnectionGetInputStream = BidMachineNetworkBridge.urlConnectionGetInputStream(urlConnection);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        Utils.write(inputStreamUrlConnectionGetInputStream, byteArrayOutputStream);
                        T tTransform = transform(byteArrayOutputStream.toByteArray());
                        io.bidmachine.util.Utils.flushSafely(byteArrayOutputStream);
                        io.bidmachine.util.Utils.closeSafely(byteArrayOutputStream);
                        io.bidmachine.util.Utils.closeSafely(inputStreamUrlConnectionGetInputStream);
                        return tTransform;
                    } catch (Throwable th) {
                        inputStream = inputStreamUrlConnectionGetInputStream;
                        th = th;
                        io.bidmachine.util.Utils.flushSafely(byteArrayOutputStream);
                        io.bidmachine.util.Utils.closeSafely(byteArrayOutputStream);
                        io.bidmachine.util.Utils.closeSafely(inputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    inputStream = inputStreamUrlConnectionGetInputStream;
                    th = th2;
                    byteArrayOutputStream = null;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
            }
        }
    }

    public interface DataRetriever {
        byte[] retrieve();
    }

    public static abstract class FileOutputStreamProcessor<T> implements ResponseProcessor<T>, ResponseTransformer<File, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f12431a;
        private final File b;

        public FileOutputStreamProcessor(Context context, File file) {
            this.f12431a = context.getApplicationContext();
            this.b = file;
        }

        @Override // io.bidmachine.rendering.utils.NetworkRequest.ResponseProcessor
        public T process(URLConnection urlConnection) throws Throwable {
            FileOutputStream fileOutputStreamFileOutputStreamCtor;
            File externalDir = io.bidmachine.util.file.FileUtils.getExternalDir(this.f12431a);
            if (externalDir == null) {
                throw new IllegalStateException("Can't get external dir");
            }
            File fileCreateTempFile = io.bidmachine.util.file.FileUtils.createTempFile(externalDir);
            long contentLength = urlConnection.getContentLength();
            InputStream inputStream = null;
            try {
                InputStream inputStreamUrlConnectionGetInputStream = BidMachineNetworkBridge.urlConnectionGetInputStream(urlConnection);
                try {
                    fileOutputStreamFileOutputStreamCtor = BidMachineFilesBridge.fileOutputStreamCtor(fileCreateTempFile);
                    try {
                        long jWrite = Utils.write(inputStreamUrlConnectionGetInputStream, fileOutputStreamFileOutputStreamCtor);
                        io.bidmachine.util.Utils.flushSafely(fileOutputStreamFileOutputStreamCtor);
                        io.bidmachine.util.Utils.closeSafely(fileOutputStreamFileOutputStreamCtor);
                        io.bidmachine.util.Utils.closeSafely(inputStreamUrlConnectionGetInputStream);
                        if (contentLength != jWrite) {
                            io.bidmachine.util.file.FileUtils.deleteFile(fileCreateTempFile);
                            throw new IllegalStateException("The downloaded file size does not match the stated size");
                        }
                        if (!io.bidmachine.util.file.FileUtils.renameToSafely(fileCreateTempFile, this.b)) {
                            io.bidmachine.util.file.FileUtils.deleteFile(fileCreateTempFile);
                            if (io.bidmachine.util.file.FileUtils.isNullOrEmpty(this.b)) {
                                throw new IllegalStateException("Can't rename temp file");
                            }
                        }
                        return transform(this.b);
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStreamUrlConnectionGetInputStream;
                        io.bidmachine.util.Utils.flushSafely(fileOutputStreamFileOutputStreamCtor);
                        io.bidmachine.util.Utils.closeSafely(fileOutputStreamFileOutputStreamCtor);
                        io.bidmachine.util.Utils.closeSafely(inputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStreamFileOutputStreamCtor = null;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStreamFileOutputStreamCtor = null;
            }
        }
    }

    public interface Listener<ResponseType> {
        void onError(Error error);

        void onSuccess(ResponseType response);
    }

    public enum Method {
        Get("GET"),
        Post("POST");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f12432a;

        Method(String networkName) {
            this.f12432a = networkName;
        }

        public String getNetworkName() {
            return this.f12432a;
        }
    }

    public interface ResponseProcessor<ResponseType> {
        ResponseType process(URLConnection urlConnection);
    }

    public interface ResponseTransformer<From, To> {
        To transform(From from);
    }

    public interface UrlConnectionProcessor {
        void process(URLConnection urlConnection);
    }

    private class b extends CancelableTask {
        private b() {
        }

        @Override // io.bidmachine.rendering.utils.taskmanager.CancelableTask
        public void runTask() {
            NetworkRequest.this.b();
        }
    }

    public NetworkRequest(String url, Method method, Map<String, String> headers, Map<String, String> queryParameters, Integer connectTimeout, Integer readTimeout, UrlConnectionProcessor urlConnectionProcessor, DataRetriever requestDataRetriever, ResponseProcessor<ResponseType> responseProcessor, Listener<ResponseType> listener) {
        this.f12429a = url;
        this.b = method;
        this.e = connectTimeout;
        this.f = readTimeout;
        this.i = responseProcessor;
        this.c = headers;
        this.d = queryParameters;
        this.g = urlConnectionProcessor;
        this.h = requestDataRetriever;
        this.j = listener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnectionA = a(a(this.f12429a, this.d));
            try {
                int iHttpUrlConnectionGetResponseCode = BidMachineNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnectionA);
                if (iHttpUrlConnectionGetResponseCode == 200) {
                    ResponseProcessor responseProcessor = this.i;
                    if (responseProcessor == null) {
                        a((Object) null);
                        io.bidmachine.util.Utils.disconnectSafely(httpURLConnectionA);
                        return;
                    } else {
                        try {
                            a(responseProcessor.process(httpURLConnectionA));
                        } catch (Throwable th) {
                            a(Error.create(th));
                        }
                    }
                } else if (iHttpUrlConnectionGetResponseCode == 204) {
                    a((Object) null);
                } else {
                    a(new Error("Server response code - " + iHttpUrlConnectionGetResponseCode + " " + httpURLConnectionA.getResponseMessage()));
                }
                io.bidmachine.util.Utils.disconnectSafely(httpURLConnectionA);
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = httpURLConnectionA;
                try {
                    a(Error.create(th));
                } finally {
                    io.bidmachine.util.Utils.disconnectSafely(httpURLConnection);
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public void cancel() {
        TaskManager taskManager = this.k;
        CancelableTask cancelableTask = this.l;
        if (taskManager != null && cancelableTask != null) {
            taskManager.cancel(cancelableTask);
        }
        a();
    }

    public void send() {
        send(m);
    }

    private String a(String str, Map map) {
        if (map.isEmpty()) {
            return str;
        }
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        for (Map.Entry entry : map.entrySet()) {
            builderBuildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        return builderBuildUpon.build().toString();
    }

    public void send(TaskManager taskManager) {
        cancel();
        this.k = taskManager;
        b bVar = new b();
        this.l = bVar;
        taskManager.execute(bVar);
    }

    private void a() {
        this.k = null;
        this.l = null;
    }

    private void a(Error error) {
        Listener listener = this.j;
        if (listener != null) {
            listener.onError(error);
        }
    }

    private void a(Object obj) {
        Listener listener = this.j;
        if (listener != null) {
            listener.onSuccess(obj);
        }
    }

    private HttpURLConnection a(String str) throws Throwable {
        byte[] bArrRetrieve;
        URL url = new URL(str);
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
            try {
                httpURLConnection2.setInstanceFollowRedirects(false);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setRequestMethod(this.b.getNetworkName());
                for (Map.Entry entry : this.c.entrySet()) {
                    httpURLConnection2.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                UrlConnectionProcessor urlConnectionProcessor = this.g;
                if (urlConnectionProcessor != null) {
                    urlConnectionProcessor.process(httpURLConnection2);
                }
                Integer num = this.e;
                if (num != null && num.intValue() >= 0) {
                    httpURLConnection2.setConnectTimeout(this.e.intValue());
                }
                Integer num2 = this.f;
                if (num2 != null && num2.intValue() >= 0) {
                    httpURLConnection2.setReadTimeout(this.f.intValue());
                }
                DataRetriever dataRetriever = this.h;
                if (dataRetriever != null && (bArrRetrieve = dataRetriever.retrieve()) != null) {
                    a(httpURLConnection2, bArrRetrieve);
                }
                switch (BidMachineNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnection2)) {
                    case 301:
                    case 302:
                    case 303:
                    case 305:
                    case 307:
                    case 308:
                        String headerField = httpURLConnection2.getHeaderField("Location");
                        if (!TextUtils.isEmpty(headerField) && io.bidmachine.util.Utils.isHttpUrl(headerField)) {
                            io.bidmachine.util.Utils.disconnectSafely(httpURLConnection2);
                            return a(headerField);
                        }
                        return httpURLConnection2;
                    case 304:
                    case 306:
                    default:
                        return httpURLConnection2;
                }
            } catch (Throwable th) {
                th = th;
                httpURLConnection = httpURLConnection2;
                io.bidmachine.util.Utils.disconnectSafely(httpURLConnection);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void a(URLConnection uRLConnection, byte[] bArr) throws Throwable {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(BidMachineNetworkBridge.urlConnectionGetOutputStream(uRLConnection));
            try {
                bufferedOutputStream2.write(bArr);
                io.bidmachine.iab.utils.Utils.flush(bufferedOutputStream2);
                io.bidmachine.iab.utils.Utils.close(bufferedOutputStream2);
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream = bufferedOutputStream2;
                io.bidmachine.iab.utils.Utils.flush(bufferedOutputStream);
                io.bidmachine.iab.utils.Utils.close(bufferedOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
