package io.bidmachine.media3.exoplayer;

/* JADX INFO: loaded from: classes12.dex */
public interface RendererCapabilitiesList {

    public interface Factory {
        RendererCapabilitiesList createRendererCapabilitiesList();
    }

    RendererCapabilities[] getRendererCapabilities();

    void release();

    int size();
}
