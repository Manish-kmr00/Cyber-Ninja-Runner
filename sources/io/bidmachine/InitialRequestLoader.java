package io.bidmachine;

import android.content.Context;
import io.bidmachine.protobuf.InitResponse;
import io.bidmachine.utils.BMError;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
final class InitialRequestLoader {
    private final Context context;
    private final Listener listener;
    InitialRequest request;
    InitialRequest.Listener requestListener;
    private final Object requestLock;
    private final String sellerId;
    final SessionManager.Observer sessionObserver;

    interface Listener {
        void onLoadFromRemoteFailed(InitResponseData initResponseData);

        void onLoadFromRemoteSuccess(InitResponseData initResponseData);

        void onLoadFromStoreSuccess(InitResponseData initResponseData);
    }

    InitialRequestLoader(Context context, String str, Listener listener) {
        SessionObserver sessionObserver = new SessionObserver();
        this.sessionObserver = sessionObserver;
        this.request = null;
        this.requestLock = new Object();
        SessionManager sessionManager = SessionManager.get();
        this.context = context;
        this.sellerId = str;
        this.listener = listener;
        this.requestListener = new InitialRequestListener(sessionManager.getSessionId());
        sessionManager.addObserver(sessionObserver);
    }

    void loadStored() {
        final Listener listener = this.listener;
        Objects.requireNonNull(listener);
        loadStored(new Executable() { // from class: io.bidmachine.InitialRequestLoader$$ExternalSyntheticLambda0
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                listener.onLoadFromStoreSuccess((InitialRequestLoader.InitResponseData) obj);
            }
        });
    }

    void loadStored(Executable<InitResponseData> executable) {
        InitResponse initResponse = BidMachineSharedPreference.getInitResponse(this.context);
        String initResponseSessionId = BidMachineSharedPreference.getInitResponseSessionId(this.context);
        if (initResponse != null) {
            executable.execute(new InitResponseData(initResponse, initResponseSessionId));
        }
    }

    void loadRemote() {
        synchronized (this.requestLock) {
            destroyRequest();
            InitialRequest initialRequestCreateRequest = createRequest();
            this.request = initialRequestCreateRequest;
            initialRequestCreateRequest.setListener(this.requestListener);
            this.request.request();
        }
    }

    InitialRequest createRequest() {
        return new InitialRequest(this.context, this.sellerId, UrlProvider.getInitUrlQueue());
    }

    void destroyRequest() {
        synchronized (this.requestLock) {
            InitialRequest initialRequest = this.request;
            if (initialRequest == null) {
                return;
            }
            initialRequest.destroy();
            this.request = null;
        }
    }

    static class InitResponseData {
        private final InitResponse response;
        private final String sessionId;

        public InitResponseData(InitResponse initResponse, String str) {
            this.response = initResponse;
            this.sessionId = str;
        }

        public InitResponse getResponse() {
            return this.response;
        }

        public String getSessionId() {
            return this.sessionId;
        }
    }

    private class SessionObserver implements SessionManager.Observer {
        private SessionObserver() {
        }

        @Override // io.bidmachine.SessionManager.Observer
        public void onSessionEvent(SessionManager.Status status) {
            if (status != SessionManager.Status.START) {
                return;
            }
            InitialRequestLoader.this.loadRemote();
        }
    }

    private class InitialRequestListener implements InitialRequest.Listener {
        private final String sessionId;

        public InitialRequestListener(String str) {
            this.sessionId = str;
        }

        @Override // io.bidmachine.core.NetworkRequest.Callback
        public void onSuccess(InitResponse initResponse) {
            InitialRequestLoader.this.destroyRequest();
            if (initResponse == null) {
                return;
            }
            BidMachineSharedPreference.storeInitResponse(InitialRequestLoader.this.context, initResponse, this.sessionId);
            InitialRequestLoader.this.listener.onLoadFromRemoteSuccess(new InitResponseData(initResponse, this.sessionId));
        }

        @Override // io.bidmachine.core.NetworkRequest.Callback
        public void onFail(BMError bMError) {
            InitialRequestLoader initialRequestLoader = InitialRequestLoader.this;
            final Listener listener = initialRequestLoader.listener;
            Objects.requireNonNull(listener);
            initialRequestLoader.loadStored(new Executable() { // from class: io.bidmachine.InitialRequestLoader$InitialRequestListener$$ExternalSyntheticLambda0
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    listener.onLoadFromRemoteFailed((InitialRequestLoader.InitResponseData) obj);
                }
            });
        }
    }
}
