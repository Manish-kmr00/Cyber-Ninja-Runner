package com.google.android.exoplayer2.transformer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.view.Surface;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.GlUtil;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: classes3.dex */
final class TransformerTranscodingVideoRenderer extends TransformerBaseRenderer {
    private static final String TAG = "TransformerTranscodingVideoRenderer";
    private final Context context;
    private MediaCodecAdapterWrapper decoder;
    private final DecoderInputBuffer decoderInputBuffer;
    private Format decoderInputFormat;
    private Surface decoderSurface;
    private SurfaceTexture decoderSurfaceTexture;
    private int decoderTextureId;
    private final float[] decoderTextureTransformMatrix;
    private GlUtil.Uniform decoderTextureTransformUniform;
    private EGLContext eglContext;
    private EGLDisplay eglDisplay;
    private EGLSurface eglSurface;
    private MediaCodecAdapterWrapper encoder;
    private boolean hasEncoderActualOutputFormat;
    private volatile boolean isDecoderSurfacePopulated;
    private boolean muxerWrapperTrackEnded;
    private boolean waitingForPopulatedDecoderSurface;

    static {
        GlUtil.glAssertionsEnabled = true;
    }

    public TransformerTranscodingVideoRenderer(Context context, MuxerWrapper muxerWrapper, TransformerMediaClock transformerMediaClock, Transformation transformation) {
        super(2, muxerWrapper, transformerMediaClock, transformation);
        this.context = context;
        this.decoderInputBuffer = new DecoderInputBuffer(2);
        this.decoderTextureTransformMatrix = new float[16];
        this.decoderTextureId = -1;
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public String getName() {
        return TAG;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j, long j2) throws ExoPlaybackException, GlUtil.GlException {
        if (this.isRendererStarted && !isEnded() && ensureInputFormatRead()) {
            ensureEncoderConfigured();
            MediaCodecAdapterWrapper mediaCodecAdapterWrapper = this.encoder;
            ensureOpenGlConfigured();
            EGLDisplay eGLDisplay = this.eglDisplay;
            EGLSurface eGLSurface = this.eglSurface;
            GlUtil.Uniform uniform = this.decoderTextureTransformUniform;
            if (ensureDecoderConfigured()) {
                MediaCodecAdapterWrapper mediaCodecAdapterWrapper2 = this.decoder;
                SurfaceTexture surfaceTexture = this.decoderSurfaceTexture;
                while (feedMuxerFromEncoder(mediaCodecAdapterWrapper)) {
                }
                while (feedEncoderFromDecoder(mediaCodecAdapterWrapper2, mediaCodecAdapterWrapper, surfaceTexture, eGLDisplay, eGLSurface, uniform)) {
                }
                while (feedDecoderFromInput(mediaCodecAdapterWrapper2)) {
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.muxerWrapperTrackEnded;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onReset() throws GlUtil.GlException {
        this.decoderInputBuffer.clear();
        this.decoderInputBuffer.data = null;
        GlUtil.destroyEglContext(this.eglDisplay, this.eglContext);
        this.eglDisplay = null;
        this.eglContext = null;
        this.eglSurface = null;
        int i = this.decoderTextureId;
        if (i != -1) {
            GlUtil.deleteTexture(i);
        }
        SurfaceTexture surfaceTexture = this.decoderSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.decoderSurfaceTexture = null;
        }
        Surface surface = this.decoderSurface;
        if (surface != null) {
            surface.release();
            this.decoderSurface = null;
        }
        MediaCodecAdapterWrapper mediaCodecAdapterWrapper = this.decoder;
        if (mediaCodecAdapterWrapper != null) {
            mediaCodecAdapterWrapper.release();
            this.decoder = null;
        }
        this.isDecoderSurfacePopulated = false;
        this.waitingForPopulatedDecoderSurface = false;
        this.decoderTextureTransformUniform = null;
        MediaCodecAdapterWrapper mediaCodecAdapterWrapper2 = this.encoder;
        if (mediaCodecAdapterWrapper2 != null) {
            mediaCodecAdapterWrapper2.release();
            this.encoder = null;
        }
        this.hasEncoderActualOutputFormat = false;
        this.muxerWrapperTrackEnded = false;
    }

    @EnsuresNonNullIf(expression = {"decoderInputFormat"}, result = true)
    private boolean ensureInputFormatRead() {
        if (this.decoderInputFormat != null) {
            return true;
        }
        FormatHolder formatHolder = getFormatHolder();
        if (readSource(formatHolder, this.decoderInputBuffer, 2) != -5) {
            return false;
        }
        this.decoderInputFormat = (Format) Assertions.checkNotNull(formatHolder.format);
        return true;
    }

    @EnsuresNonNull({"encoder"})
    @RequiresNonNull({"decoderInputFormat"})
    private void ensureEncoderConfigured() throws ExoPlaybackException {
        String str;
        if (this.encoder != null) {
            return;
        }
        try {
            Format.Builder height = new Format.Builder().setWidth(this.decoderInputFormat.width).setHeight(this.decoderInputFormat.height);
            if (this.transformation.videoMimeType != null) {
                str = this.transformation.videoMimeType;
            } else {
                str = this.decoderInputFormat.sampleMimeType;
            }
            this.encoder = MediaCodecAdapterWrapper.createForVideoEncoding(height.setSampleMimeType(str).build(), ImmutableMap.of());
        } catch (IOException e) {
            throw createRendererException(e, this.decoderInputFormat, 4001);
        }
    }

    @EnsuresNonNull({"eglDisplay", "eglSurface", "decoderTextureTransformUniform"})
    @RequiresNonNull({"encoder", "decoderInputFormat"})
    private void ensureOpenGlConfigured() throws GlUtil.GlException {
        if (this.eglDisplay == null || this.eglSurface == null || this.decoderTextureTransformUniform == null) {
            MediaCodecAdapterWrapper mediaCodecAdapterWrapper = this.encoder;
            EGLDisplay eGLDisplayCreateEglDisplay = GlUtil.createEglDisplay();
            try {
                EGLContext eGLContextCreateEglContext = GlUtil.createEglContext(eGLDisplayCreateEglDisplay);
                this.eglContext = eGLContextCreateEglContext;
                EGLSurface eglSurface = GlUtil.getEglSurface(eGLDisplayCreateEglDisplay, Assertions.checkNotNull(mediaCodecAdapterWrapper.getInputSurface()));
                GlUtil.focusSurface(eGLDisplayCreateEglDisplay, eGLContextCreateEglContext, eglSurface, this.decoderInputFormat.width, this.decoderInputFormat.height);
                this.decoderTextureId = GlUtil.createExternalTexture();
                try {
                    GlUtil.Program program = new GlUtil.Program(this.context, "shaders/blit_vertex_shader.glsl", "shaders/copy_external_fragment_shader.glsl");
                    program.use();
                    GlUtil.Attribute[] attributes = program.getAttributes();
                    Assertions.checkState(attributes.length == 2, "Expected program to have two vertex attributes.");
                    for (GlUtil.Attribute attribute : attributes) {
                        if (attribute.name.equals("a_position")) {
                            attribute.setBuffer(new float[]{-1.0f, -1.0f, 0.0f, 1.0f, 1.0f, -1.0f, 0.0f, 1.0f, -1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f}, 4);
                        } else if (attribute.name.equals("a_texcoord")) {
                            attribute.setBuffer(new float[]{0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f}, 4);
                        } else {
                            throw new IllegalStateException("Unexpected attribute name.");
                        }
                        attribute.bind();
                    }
                    GlUtil.Uniform[] uniforms = program.getUniforms();
                    Assertions.checkState(uniforms.length == 2, "Expected program to have two uniforms.");
                    for (GlUtil.Uniform uniform : uniforms) {
                        if (uniform.name.equals("tex_sampler")) {
                            uniform.setSamplerTexId(this.decoderTextureId, 0);
                            uniform.bind();
                        } else if (uniform.name.equals("tex_transform")) {
                            this.decoderTextureTransformUniform = uniform;
                        } else {
                            throw new IllegalStateException("Unexpected uniform name.");
                        }
                    }
                    Assertions.checkNotNull(this.decoderTextureTransformUniform);
                    this.eglDisplay = eGLDisplayCreateEglDisplay;
                    this.eglSurface = eglSurface;
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                }
            } catch (GlUtil.UnsupportedEglVersionException e2) {
                throw new IllegalStateException("EGL version is unsupported", e2);
            }
        }
    }

    @EnsuresNonNullIf(expression = {"decoder", "decoderSurfaceTexture"}, result = true)
    @RequiresNonNull({"decoderInputFormat"})
    private boolean ensureDecoderConfigured() throws ExoPlaybackException {
        if (this.decoder != null && this.decoderSurfaceTexture != null) {
            return true;
        }
        Assertions.checkState(this.decoderTextureId != -1);
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.decoderTextureId);
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: com.google.android.exoplayer2.transformer.TransformerTranscodingVideoRenderer$$ExternalSyntheticLambda0
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                this.f$0.m5151x23f04ce(surfaceTexture2);
            }
        });
        Surface surface = new Surface(surfaceTexture);
        this.decoderSurface = surface;
        try {
            this.decoder = MediaCodecAdapterWrapper.createForVideoDecoding(this.decoderInputFormat, surface);
            this.decoderSurfaceTexture = surfaceTexture;
            return true;
        } catch (IOException e) {
            throw createRendererException(e, this.decoderInputFormat, 4001);
        }
    }

    /* JADX INFO: renamed from: lambda$ensureDecoderConfigured$0$com-google-android-exoplayer2-transformer-TransformerTranscodingVideoRenderer, reason: not valid java name */
    /* synthetic */ void m5151x23f04ce(SurfaceTexture surfaceTexture) {
        this.isDecoderSurfacePopulated = true;
    }

    private boolean feedDecoderFromInput(MediaCodecAdapterWrapper mediaCodecAdapterWrapper) {
        if (!mediaCodecAdapterWrapper.maybeDequeueInputBuffer(this.decoderInputBuffer)) {
            return false;
        }
        this.decoderInputBuffer.clear();
        int source = readSource(getFormatHolder(), this.decoderInputBuffer, 0);
        if (source == -5) {
            throw new IllegalStateException("Format changes are not supported.");
        }
        if (source != -4) {
            return false;
        }
        this.mediaClock.updateTimeForTrackType(getTrackType(), this.decoderInputBuffer.timeUs);
        this.decoderInputBuffer.timeUs -= this.streamOffsetUs;
        ((ByteBuffer) Assertions.checkNotNull(this.decoderInputBuffer.data)).flip();
        mediaCodecAdapterWrapper.queueInputBuffer(this.decoderInputBuffer);
        return !this.decoderInputBuffer.isEndOfStream();
    }

    private boolean feedEncoderFromDecoder(MediaCodecAdapterWrapper mediaCodecAdapterWrapper, MediaCodecAdapterWrapper mediaCodecAdapterWrapper2, SurfaceTexture surfaceTexture, EGLDisplay eGLDisplay, EGLSurface eGLSurface, GlUtil.Uniform uniform) {
        if (mediaCodecAdapterWrapper.isEnded()) {
            return false;
        }
        if (!this.isDecoderSurfacePopulated) {
            if (!this.waitingForPopulatedDecoderSurface) {
                if (mediaCodecAdapterWrapper.getOutputBufferInfo() != null) {
                    mediaCodecAdapterWrapper.releaseOutputBuffer(true);
                    this.waitingForPopulatedDecoderSurface = true;
                }
                if (mediaCodecAdapterWrapper.isEnded()) {
                    mediaCodecAdapterWrapper2.signalEndOfInputStream();
                }
            }
            return false;
        }
        this.waitingForPopulatedDecoderSurface = false;
        surfaceTexture.updateTexImage();
        surfaceTexture.getTransformMatrix(this.decoderTextureTransformMatrix);
        uniform.setFloats(this.decoderTextureTransformMatrix);
        uniform.bind();
        GLES20.glDrawArrays(5, 0, 4);
        EGLExt.eglPresentationTimeANDROID(eGLDisplay, eGLSurface, surfaceTexture.getTimestamp());
        EGL14.eglSwapBuffers(eGLDisplay, eGLSurface);
        this.isDecoderSurfacePopulated = false;
        return true;
    }

    private boolean feedMuxerFromEncoder(MediaCodecAdapterWrapper mediaCodecAdapterWrapper) {
        if (!this.hasEncoderActualOutputFormat) {
            Format outputFormat = mediaCodecAdapterWrapper.getOutputFormat();
            if (outputFormat == null) {
                return false;
            }
            this.hasEncoderActualOutputFormat = true;
            this.muxerWrapper.addTrackFormat(outputFormat);
        }
        if (mediaCodecAdapterWrapper.isEnded()) {
            this.muxerWrapper.endTrack(getTrackType());
            this.muxerWrapperTrackEnded = true;
            return false;
        }
        ByteBuffer outputBuffer = mediaCodecAdapterWrapper.getOutputBuffer();
        if (outputBuffer == null) {
            return false;
        }
        MediaCodec.BufferInfo bufferInfo = (MediaCodec.BufferInfo) Assertions.checkNotNull(mediaCodecAdapterWrapper.getOutputBufferInfo());
        if (!this.muxerWrapper.writeSample(getTrackType(), outputBuffer, (bufferInfo.flags & 1) > 0, bufferInfo.presentationTimeUs)) {
            return false;
        }
        mediaCodecAdapterWrapper.releaseOutputBuffer();
        return true;
    }
}
