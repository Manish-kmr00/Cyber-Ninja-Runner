package com.smaato.sdk.richmedia.mraid.bridge;

import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.Whatever;
import com.smaato.sdk.core.util.fi.BiConsumer;
import com.smaato.sdk.core.util.fi.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public final class MraidJsMethods {
    public static final String ADD_EVENT_LISTENER = "addEventListener";
    public static final String CLOSE = "close";
    public static final String EXPAND = "expand";
    public static final String OPEN = "open";
    public static final String PLAY_VIDEO = "playVideo";
    public static final String RESIZE = "resize";
    public static final String UNLOAD = "unload";
    public static final String USE_CUSTOM_CLOSE = "useCustomClose";
    private BiConsumer adViolationCallback;
    private Consumer addEventListenerCallback;
    private Consumer closeCallback;
    private Consumer expandCallback;
    private Consumer openCallback;
    private Consumer playVideoCallback;
    private Consumer resizeCallback;
    private Consumer unloadCallback;
    private Consumer useCustomCloseCallback;
    private final MraidCommandHandler addEventListenerHandler = new MraidCommandHandler() { // from class: com.smaato.sdk.richmedia.mraid.bridge.MraidJsMethods$$ExternalSyntheticLambda6
        @Override // com.smaato.sdk.richmedia.mraid.bridge.MraidCommandHandler
        public final void handle(Map map, boolean z) {
            this.f$0.m5652x44fe3fd1(map, z);
        }
    };
    private final MraidCommandHandler openEventListenerHandler = new MraidCommandHandler() { // from class: com.smaato.sdk.richmedia.mraid.bridge.MraidJsMethods$$ExternalSyntheticLambda7
        @Override // com.smaato.sdk.richmedia.mraid.bridge.MraidCommandHandler
        public final void handle(Map map, boolean z) {
            this.f$0.m5656x79353d0f(map, z);
        }
    };
    private final MraidCommandHandler expandEventListenerHandler = new MraidCommandHandler() { // from class: com.smaato.sdk.richmedia.mraid.bridge.MraidJsMethods$$ExternalSyntheticLambda8
        @Override // com.smaato.sdk.richmedia.mraid.bridge.MraidCommandHandler
        public final void handle(Map map, boolean z) {
            this.f$0.m5657xad6c3a4d(map, z);
        }
    };
    private final MraidCommandHandler playVideoEventListenerHandler = new MraidCommandHandler() { // from class: com.smaato.sdk.richmedia.mraid.bridge.MraidJsMethods$$ExternalSyntheticLambda9
        @Override // com.smaato.sdk.richmedia.mraid.bridge.MraidCommandHandler
        public final void handle(Map map, boolean z) {
            this.f$0.m5658xe1a3378b(map, z);
        }
    };
    private final MraidCommandHandler unloadEventListenerHandler = new MraidCommandHandler() { // from class: com.smaato.sdk.richmedia.mraid.bridge.MraidJsMethods$$ExternalSyntheticLambda10
        @Override // com.smaato.sdk.richmedia.mraid.bridge.MraidCommandHandler
        public final void handle(Map map, boolean z) {
            this.f$0.m5659x15da34c9(map, z);
        }
    };
    private final MraidCommandHandler resizeEventListenerHandler = new MraidCommandHandler() { // from class: com.smaato.sdk.richmedia.mraid.bridge.MraidJsMethods$$ExternalSyntheticLambda11
        @Override // com.smaato.sdk.richmedia.mraid.bridge.MraidCommandHandler
        public final void handle(Map map, boolean z) {
            this.f$0.m5653xf2b30460(map, z);
        }
    };
    private final MraidCommandHandler closeEventListenerHandler = new MraidCommandHandler() { // from class: com.smaato.sdk.richmedia.mraid.bridge.MraidJsMethods$$ExternalSyntheticLambda12
        @Override // com.smaato.sdk.richmedia.mraid.bridge.MraidCommandHandler
        public final void handle(Map map, boolean z) {
            this.f$0.m5654xcce82ff(map, z);
        }
    };
    private final MraidCommandHandler useCustomCLoseEventListenerHandler = new MraidCommandHandler() { // from class: com.smaato.sdk.richmedia.mraid.bridge.MraidJsMethods$$ExternalSyntheticLambda1
        @Override // com.smaato.sdk.richmedia.mraid.bridge.MraidCommandHandler
        public final void handle(Map map, boolean z) {
            this.f$0.m5655x26ea019e(map, z);
        }
    };

    /* JADX INFO: renamed from: lambda$new$0$com-smaato-sdk-richmedia-mraid-bridge-MraidJsMethods, reason: not valid java name */
    /* synthetic */ void m5652x44fe3fd1(Map map, boolean z) {
        Consumer consumer = this.addEventListenerCallback;
        if (consumer != null) {
            consumer.accept((String) map.get("event"));
        }
    }

    /* JADX INFO: renamed from: lambda$new$2$com-smaato-sdk-richmedia-mraid-bridge-MraidJsMethods, reason: not valid java name */
    /* synthetic */ void m5656x79353d0f(Map map, boolean z) {
        final String str = (String) map.get("url");
        if (!z) {
            Objects.onNotNull(this.adViolationCallback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.bridge.MraidJsMethods$$ExternalSyntheticLambda3
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((BiConsumer) obj).accept("AUTO_OPEN", str);
                }
            });
            return;
        }
        Consumer consumer = this.openCallback;
        if (consumer != null) {
            consumer.accept(str);
        }
    }

    /* JADX INFO: renamed from: lambda$new$4$com-smaato-sdk-richmedia-mraid-bridge-MraidJsMethods, reason: not valid java name */
    /* synthetic */ void m5657xad6c3a4d(Map map, boolean z) {
        final String str = (String) map.get("url");
        if (!z) {
            Objects.onNotNull(this.adViolationCallback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.bridge.MraidJsMethods$$ExternalSyntheticLambda2
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((BiConsumer) obj).accept("AUTO_EXPAND", str);
                }
            });
            return;
        }
        Consumer consumer = this.expandCallback;
        if (consumer != null) {
            consumer.accept(str);
        }
    }

    /* JADX INFO: renamed from: lambda$new$6$com-smaato-sdk-richmedia-mraid-bridge-MraidJsMethods, reason: not valid java name */
    /* synthetic */ void m5658xe1a3378b(Map map, boolean z) {
        final String str = (String) map.get("uri");
        if (!z) {
            Objects.onNotNull(this.adViolationCallback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.bridge.MraidJsMethods$$ExternalSyntheticLambda4
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((BiConsumer) obj).accept("AUTO_PLAY", str);
                }
            });
            return;
        }
        Consumer consumer = this.playVideoCallback;
        if (consumer != null) {
            consumer.accept((String) map.get("uri"));
        }
    }

    /* JADX INFO: renamed from: lambda$new$8$com-smaato-sdk-richmedia-mraid-bridge-MraidJsMethods, reason: not valid java name */
    /* synthetic */ void m5659x15da34c9(Map map, boolean z) {
        Consumer consumer = this.unloadCallback;
        if (consumer != null) {
            consumer.accept(Whatever.INSTANCE);
        }
        Objects.onNotNull(this.adViolationCallback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.bridge.MraidJsMethods$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((BiConsumer) obj).accept("UNLOAD", null);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$new$10$com-smaato-sdk-richmedia-mraid-bridge-MraidJsMethods, reason: not valid java name */
    /* synthetic */ void m5653xf2b30460(Map map, boolean z) {
        if (!z) {
            Objects.onNotNull(this.adViolationCallback, new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.bridge.MraidJsMethods$$ExternalSyntheticLambda5
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((BiConsumer) obj).accept("AUTO_RESIZE", "");
                }
            });
            return;
        }
        Consumer consumer = this.resizeCallback;
        if (consumer != null) {
            consumer.accept(Whatever.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: lambda$new$11$com-smaato-sdk-richmedia-mraid-bridge-MraidJsMethods, reason: not valid java name */
    /* synthetic */ void m5654xcce82ff(Map map, boolean z) {
        Consumer consumer = this.closeCallback;
        if (consumer != null) {
            consumer.accept(Whatever.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: lambda$new$12$com-smaato-sdk-richmedia-mraid-bridge-MraidJsMethods, reason: not valid java name */
    /* synthetic */ void m5655x26ea019e(Map map, boolean z) {
        if (this.useCustomCloseCallback != null) {
            String str = (String) map.get("shouldUseCustomClose");
            this.useCustomCloseCallback.accept(Boolean.valueOf(str != null && str.toLowerCase().equals("true")));
        }
    }

    public MraidJsMethods(MraidJsBridge mraidJsBridge) {
        subscribeOnEvents((MraidJsBridge) Objects.requireNonNull(mraidJsBridge));
    }

    public void setAddEventListenerCallback(Consumer<String> consumer) {
        this.addEventListenerCallback = consumer;
    }

    public void setOpenCallback(Consumer<String> consumer) {
        this.openCallback = consumer;
    }

    public void setPlayVideoCallback(Consumer<String> consumer) {
        this.playVideoCallback = consumer;
    }

    public void setResizeCallback(Consumer<Whatever> consumer) {
        this.resizeCallback = consumer;
    }

    public void setExpandCallback(Consumer<String> consumer) {
        this.expandCallback = consumer;
    }

    public void setUnloadCallback(Consumer<Whatever> consumer) {
        this.unloadCallback = consumer;
    }

    public void setCloseCallback(Consumer<Whatever> consumer) {
        this.closeCallback = consumer;
    }

    public void setUseCustomCloseCallback(Consumer<Boolean> consumer) {
        this.useCustomCloseCallback = consumer;
    }

    public void setAdViolationCallback(BiConsumer<String, String> biConsumer) {
        this.adViolationCallback = biConsumer;
    }

    private void subscribeOnEvents(MraidJsBridge mraidJsBridge) {
        mraidJsBridge.addCommandHandler(ADD_EVENT_LISTENER, this.addEventListenerHandler);
        mraidJsBridge.addCommandHandler("open", this.openEventListenerHandler);
        mraidJsBridge.addCommandHandler(PLAY_VIDEO, this.playVideoEventListenerHandler);
        mraidJsBridge.addCommandHandler("expand", this.expandEventListenerHandler);
        mraidJsBridge.addCommandHandler(UNLOAD, this.unloadEventListenerHandler);
        mraidJsBridge.addCommandHandler("resize", this.resizeEventListenerHandler);
        mraidJsBridge.addCommandHandler("close", this.closeEventListenerHandler);
        mraidJsBridge.addCommandHandler(USE_CUSTOM_CLOSE, this.useCustomCLoseEventListenerHandler);
    }
}
