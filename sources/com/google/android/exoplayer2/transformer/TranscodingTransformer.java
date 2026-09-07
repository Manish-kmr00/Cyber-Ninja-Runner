package com.google.android.exoplayer2.transformer;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.TracksInfo;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes9.dex */
public final class TranscodingTransformer {
    public static final int PROGRESS_STATE_AVAILABLE = 1;
    public static final int PROGRESS_STATE_NO_TRANSFORMATION = 4;
    public static final int PROGRESS_STATE_UNAVAILABLE = 2;
    public static final int PROGRESS_STATE_WAITING_FOR_AVAILABILITY = 0;
    private final Clock clock;
    private final Context context;
    private Listener listener;
    private final Looper looper;
    private final MediaSourceFactory mediaSourceFactory;
    private final Muxer.Factory muxerFactory;
    private MuxerWrapper muxerWrapper;
    private ExoPlayer player;
    private int progressState;
    private final Transformation transformation;

    public interface Listener {
        default void onTransformationCompleted(MediaItem mediaItem) {
        }

        default void onTransformationError(MediaItem mediaItem, Exception exc) {
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ProgressState {
    }

    public static final class Builder {
        private String audioMimeType;
        private Clock clock;
        private Context context;
        private boolean flattenForSlowMotion;
        private Listener listener;
        private Looper looper;
        private MediaSourceFactory mediaSourceFactory;
        private Muxer.Factory muxerFactory;
        private String outputMimeType;
        private boolean removeAudio;
        private boolean removeVideo;
        private String videoMimeType;

        public Builder() {
            this.muxerFactory = new FrameworkMuxer.Factory();
            this.outputMimeType = "video/mp4";
            this.listener = new Listener(this) { // from class: com.google.android.exoplayer2.transformer.TranscodingTransformer.Builder.1
            };
            this.looper = Util.getCurrentOrMainLooper();
            this.clock = Clock.DEFAULT;
        }

        private Builder(TranscodingTransformer transcodingTransformer) {
            this.context = transcodingTransformer.context;
            this.mediaSourceFactory = transcodingTransformer.mediaSourceFactory;
            this.muxerFactory = transcodingTransformer.muxerFactory;
            this.removeAudio = transcodingTransformer.transformation.removeAudio;
            this.removeVideo = transcodingTransformer.transformation.removeVideo;
            this.flattenForSlowMotion = transcodingTransformer.transformation.flattenForSlowMotion;
            this.outputMimeType = transcodingTransformer.transformation.outputMimeType;
            this.audioMimeType = transcodingTransformer.transformation.audioMimeType;
            this.videoMimeType = transcodingTransformer.transformation.videoMimeType;
            this.listener = transcodingTransformer.listener;
            this.looper = transcodingTransformer.looper;
            this.clock = transcodingTransformer.clock;
        }

        public Builder setContext(Context context) {
            this.context = context.getApplicationContext();
            return this;
        }

        public Builder setMediaSourceFactory(MediaSourceFactory mediaSourceFactory) {
            this.mediaSourceFactory = mediaSourceFactory;
            return this;
        }

        public Builder setRemoveAudio(boolean z) {
            this.removeAudio = z;
            return this;
        }

        public Builder setRemoveVideo(boolean z) {
            this.removeVideo = z;
            return this;
        }

        public Builder setFlattenForSlowMotion(boolean z) {
            this.flattenForSlowMotion = z;
            return this;
        }

        public Builder setOutputMimeType(String str) {
            this.outputMimeType = str;
            return this;
        }

        public Builder setVideoMimeType(String str) {
            this.videoMimeType = str;
            return this;
        }

        public Builder setAudioMimeType(String str) {
            this.audioMimeType = str;
            return this;
        }

        public Builder setListener(Listener listener) {
            this.listener = listener;
            return this;
        }

        public Builder setLooper(Looper looper) {
            this.looper = looper;
            return this;
        }

        Builder setClock(Clock clock) {
            this.clock = clock;
            return this;
        }

        Builder setMuxerFactory(Muxer.Factory factory) {
            this.muxerFactory = factory;
            return this;
        }

        public TranscodingTransformer build() {
            Assertions.checkStateNotNull(this.context);
            if (this.mediaSourceFactory == null) {
                DefaultExtractorsFactory defaultExtractorsFactory = new DefaultExtractorsFactory();
                if (this.flattenForSlowMotion) {
                    defaultExtractorsFactory.setMp4ExtractorFlags(4);
                }
                this.mediaSourceFactory = new DefaultMediaSourceFactory(this.context, defaultExtractorsFactory);
            }
            boolean zSupportsOutputMimeType = this.muxerFactory.supportsOutputMimeType(this.outputMimeType);
            String strValueOf = String.valueOf(this.outputMimeType);
            Assertions.checkState(zSupportsOutputMimeType, strValueOf.length() != 0 ? "Unsupported output MIME type: ".concat(strValueOf) : new String("Unsupported output MIME type: "));
            String str = this.audioMimeType;
            if (str != null) {
                checkSampleMimeType(str);
            }
            String str2 = this.videoMimeType;
            if (str2 != null) {
                checkSampleMimeType(str2);
            }
            return new TranscodingTransformer(this.context, this.mediaSourceFactory, this.muxerFactory, new Transformation(this.removeAudio, this.removeVideo, this.flattenForSlowMotion, this.outputMimeType, this.audioMimeType, this.videoMimeType), this.listener, this.looper, this.clock);
        }

        private void checkSampleMimeType(String str) {
            boolean zSupportsSampleMimeType = this.muxerFactory.supportsSampleMimeType(str, this.outputMimeType);
            String str2 = this.outputMimeType;
            Assertions.checkState(zSupportsSampleMimeType, new StringBuilder(String.valueOf(str).length() + 54 + String.valueOf(str2).length()).append("Unsupported sample MIME type ").append(str).append(" for container MIME type ").append(str2).toString());
        }
    }

    private TranscodingTransformer(Context context, MediaSourceFactory mediaSourceFactory, Muxer.Factory factory, Transformation transformation, Listener listener, Looper looper, Clock clock) {
        Assertions.checkState((transformation.removeAudio && transformation.removeVideo) ? false : true, "Audio and video cannot both be removed.");
        this.context = context;
        this.mediaSourceFactory = mediaSourceFactory;
        this.muxerFactory = factory;
        this.transformation = transformation;
        this.listener = listener;
        this.looper = looper;
        this.clock = clock;
        this.progressState = 4;
    }

    public Builder buildUpon() {
        return new Builder();
    }

    public void setListener(Listener listener) {
        verifyApplicationThread();
        this.listener = listener;
    }

    public void startTransformation(MediaItem mediaItem, String str) throws IOException {
        startTransformation(mediaItem, this.muxerFactory.create(str, this.transformation.outputMimeType));
    }

    public void startTransformation(MediaItem mediaItem, ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        startTransformation(mediaItem, this.muxerFactory.create(parcelFileDescriptor, this.transformation.outputMimeType));
    }

    private void startTransformation(MediaItem mediaItem, Muxer muxer) {
        verifyApplicationThread();
        if (this.player != null) {
            throw new IllegalStateException("There is already a transformation in progress.");
        }
        MuxerWrapper muxerWrapper = new MuxerWrapper(muxer, this.muxerFactory, this.transformation.outputMimeType);
        this.muxerWrapper = muxerWrapper;
        DefaultTrackSelector defaultTrackSelector = new DefaultTrackSelector(this.context);
        defaultTrackSelector.setParameters(new DefaultTrackSelector.ParametersBuilder(this.context).setForceHighestSupportedBitrate(true).build());
        ExoPlayer exoPlayerBuild = new ExoPlayer.Builder(this.context, new TranscodingTransformerRenderersFactory(this.context, muxerWrapper, this.transformation)).setMediaSourceFactory(this.mediaSourceFactory).setTrackSelector(defaultTrackSelector).setLoadControl(new DefaultLoadControl.Builder().setBufferDurationsMs(50000, 50000, 250, 500).build()).setLooper(this.looper).setClock(this.clock).build();
        this.player = exoPlayerBuild;
        exoPlayerBuild.setMediaItem(mediaItem);
        this.player.addListener(new TranscodingTransformerPlayerListener(mediaItem, muxerWrapper));
        this.player.prepare();
        this.progressState = 0;
    }

    public Looper getApplicationLooper() {
        return this.looper;
    }

    public int getProgress(ProgressHolder progressHolder) {
        verifyApplicationThread();
        if (this.progressState == 1) {
            Player player = (Player) Assertions.checkNotNull(this.player);
            progressHolder.progress = Math.min((int) ((player.getCurrentPosition() * 100) / player.getDuration()), 99);
        }
        return this.progressState;
    }

    public void cancel() {
        releaseResources(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseResources(boolean z) {
        verifyApplicationThread();
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            exoPlayer.release();
            this.player = null;
        }
        MuxerWrapper muxerWrapper = this.muxerWrapper;
        if (muxerWrapper != null) {
            muxerWrapper.release(z);
            this.muxerWrapper = null;
        }
        this.progressState = 4;
    }

    private void verifyApplicationThread() {
        if (Looper.myLooper() != this.looper) {
            throw new IllegalStateException("Transcoding Transformer is accessed on the wrong thread.");
        }
    }

    private static final class TranscodingTransformerRenderersFactory implements RenderersFactory {
        private final Context context;
        private final TransformerMediaClock mediaClock = new TransformerMediaClock();
        private final MuxerWrapper muxerWrapper;
        private final Transformation transformation;

        public TranscodingTransformerRenderersFactory(Context context, MuxerWrapper muxerWrapper, Transformation transformation) {
            this.context = context;
            this.muxerWrapper = muxerWrapper;
            this.transformation = transformation;
        }

        @Override // com.google.android.exoplayer2.RenderersFactory
        public Renderer[] createRenderers(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput) {
            char c = 1;
            Renderer[] rendererArr = new Renderer[(this.transformation.removeAudio || this.transformation.removeVideo) ? 1 : 2];
            if (this.transformation.removeAudio) {
                c = 0;
            } else {
                rendererArr[0] = new TransformerAudioRenderer(this.muxerWrapper, this.mediaClock, this.transformation);
            }
            if (!this.transformation.removeVideo) {
                rendererArr[c] = new TransformerTranscodingVideoRenderer(this.context, this.muxerWrapper, this.mediaClock, this.transformation);
            }
            return rendererArr;
        }
    }

    private final class TranscodingTransformerPlayerListener implements Player.Listener {
        private final MediaItem mediaItem;
        private final MuxerWrapper muxerWrapper;

        public TranscodingTransformerPlayerListener(MediaItem mediaItem, MuxerWrapper muxerWrapper) {
            this.mediaItem = mediaItem;
            this.muxerWrapper = muxerWrapper;
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onPlaybackStateChanged(int i) {
            if (i == 4) {
                handleTransformationEnded(null);
            }
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onTimelineChanged(Timeline timeline, int i) {
            if (TranscodingTransformer.this.progressState != 0) {
                return;
            }
            Timeline.Window window = new Timeline.Window();
            timeline.getWindow(0, window);
            if (window.isPlaceholder) {
                return;
            }
            long j = window.durationUs;
            TranscodingTransformer.this.progressState = (j <= 0 || j == -9223372036854775807L) ? 2 : 1;
            ((ExoPlayer) Assertions.checkNotNull(TranscodingTransformer.this.player)).play();
        }

        public void onTracksInfoChanged(TracksInfo tracksInfo) {
            if (this.muxerWrapper.getTrackCount() == 0) {
                handleTransformationEnded(new IllegalStateException("The output does not contain any tracks. Check that at least one of the input sample formats is supported."));
            }
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onPlayerError(PlaybackException playbackException) {
            handleTransformationEnded(playbackException);
        }

        private void handleTransformationEnded(Exception exc) {
            try {
                TranscodingTransformer.this.releaseResources(false);
            } catch (IllegalStateException e) {
                if (exc == null) {
                    exc = e;
                }
            }
            if (exc == null) {
                TranscodingTransformer.this.listener.onTransformationCompleted(this.mediaItem);
            } else {
                TranscodingTransformer.this.listener.onTransformationError(this.mediaItem, exc);
            }
        }
    }
}
