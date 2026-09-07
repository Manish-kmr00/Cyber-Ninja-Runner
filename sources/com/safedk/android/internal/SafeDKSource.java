package com.safedk.android.internal;

import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.internal.partials.NetworkBridge;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.annotations.SDKDependancy;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import okio.Timeout;

/* JADX INFO: loaded from: classes10.dex */
@SDKDependancy(packageName = "okio")
public class SafeDKSource implements Source {
    private static final String TAG = "SafeDKSource";
    private int bodyId;
    private final Source delegate;

    public static BufferedSource create(BufferedSource delegate, int bodyId) {
        return Okio.buffer(new SafeDKSource(delegate, bodyId));
    }

    private SafeDKSource(BufferedSource delegate, int bodyId) {
        this.delegate = delegate;
        this.bodyId = bodyId;
    }

    @Override // okio.Source
    public long read(Buffer sink, long byteCount) throws IOException {
        try {
            long jForwardingSource_read = ForwardingSource_read(sink, byteCount);
            Logger.v(TAG, "retrofit read " + byteCount + " actual " + jForwardingSource_read);
            if (jForwardingSource_read > 0) {
                NetworkBridge.RequestInfo requestInfo = NetworkBridge.d.get(Integer.valueOf(this.bodyId));
                if (requestInfo != null) {
                    byte[] byteArray = sink.snapshot().toByteArray();
                    Logger.v(TAG, "retrofit read updating buffer" + byteArray);
                    requestInfo.a(byteArray, jForwardingSource_read);
                } else {
                    Logger.v(TAG, "retrofit read cant find bodyId " + this.bodyId);
                }
            }
            return jForwardingSource_read;
        } catch (IOException e) {
            Logger.e(TAG, "retrofit SafeDKSource :" + e.getMessage());
            throw e;
        }
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ForwardingSource_close();
        NetworkBridge.RequestInfo requestInfoRemove = NetworkBridge.d.remove(Integer.valueOf(this.bodyId));
        Logger.v(TAG, "retrofit closing. close reqInfo = " + requestInfoRemove);
        if (requestInfoRemove != null && requestInfoRemove.d()) {
            Logger.v(TAG, "retrofit closing. package: " + requestInfoRemove.a() + ", url: " + requestInfoRemove.b());
            CreativeInfoManager.a(requestInfoRemove.a(), requestInfoRemove.b(), requestInfoRemove.c(), (Map<String, List<String>>) null);
        }
    }

    public final Source delegate() {
        return this.delegate;
    }

    public long ForwardingSource_read(Buffer sink, long byteCount) throws IOException {
        return this.delegate.read(sink, byteCount);
    }

    @Override // okio.Source
    /* JADX INFO: renamed from: timeout */
    public Timeout getTimeout() {
        return this.delegate.getTimeout();
    }

    public void ForwardingSource_close() throws IOException {
        this.delegate.close();
    }
}
