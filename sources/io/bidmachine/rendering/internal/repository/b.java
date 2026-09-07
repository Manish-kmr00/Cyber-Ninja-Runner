package io.bidmachine.rendering.internal.repository;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import io.bidmachine.rendering.model.Error;
import io.bidmachine.rendering.model.MediaSource;
import io.bidmachine.rendering.utils.FileUtils;
import io.bidmachine.rendering.utils.ImageUtils;
import io.bidmachine.rendering.utils.NetworkRequest;
import java.io.File;

/* JADX INFO: loaded from: classes7.dex */
public class b implements io.bidmachine.rendering.internal.repository.a {

    class a extends d {
        a(io.bidmachine.rendering.internal.repository.c cVar) {
            super(cVar, null);
        }

        @Override // io.bidmachine.rendering.internal.repository.b.d
        Error a() {
            return new Error("Bitmap is null");
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.rendering.internal.repository.b$b, reason: collision with other inner class name */
    class C0791b extends d {
        C0791b(io.bidmachine.rendering.internal.repository.c cVar) {
            super(cVar, null);
        }

        @Override // io.bidmachine.rendering.internal.repository.b.d
        Error a() {
            return new Error("Uri is null");
        }
    }

    private static class c extends NetworkRequest.FileOutputStreamProcessor {
        private final BitmapFactory.Options c;

        private c(Context context, File file, BitmapFactory.Options bitmapFactoryOptions) {
            super(context, file);
            this.c = bitmapFactoryOptions;
        }

        @Override // io.bidmachine.rendering.utils.NetworkRequest.ResponseTransformer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap transform(File file) {
            return ImageUtils.toBitmap(file, this.c);
        }

        /* synthetic */ c(Context context, File file, BitmapFactory.Options options, a aVar) {
            this(context, file, options);
        }
    }

    private static abstract class d implements NetworkRequest.Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final io.bidmachine.rendering.internal.repository.c f12370a;

        private d(io.bidmachine.rendering.internal.repository.c resultCallback) {
            this.f12370a = resultCallback;
        }

        abstract Error a();

        @Override // io.bidmachine.rendering.utils.NetworkRequest.Listener
        public void onError(Error error) {
            this.f12370a.onError(error);
        }

        @Override // io.bidmachine.rendering.utils.NetworkRequest.Listener
        public void onSuccess(Object obj) {
            if (obj != null) {
                this.f12370a.onSuccess(obj);
            } else {
                onError(a());
            }
        }

        /* synthetic */ d(io.bidmachine.rendering.internal.repository.c cVar, a aVar) {
            this(cVar);
        }
    }

    private static class e extends NetworkRequest.FileOutputStreamProcessor {
        private e(Context context, File file) {
            super(context, file);
        }

        @Override // io.bidmachine.rendering.utils.NetworkRequest.ResponseTransformer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Uri transform(File file) {
            return FileUtils.toUri(file);
        }

        /* synthetic */ e(Context context, File file, a aVar) {
            this(context, file);
        }
    }

    @Override // io.bidmachine.rendering.internal.repository.a
    public void a(Context context, MediaSource mediaSource, io.bidmachine.rendering.internal.repository.c cVar) {
        String url = mediaSource.getUrl();
        if (mediaSource.getDeliveryType() == MediaSource.DeliveryType.STREAM) {
            a(url, cVar);
        } else {
            a(context, url, cVar);
        }
    }

    @Override // io.bidmachine.rendering.internal.repository.a
    public void b(Context context, MediaSource mediaSource, io.bidmachine.rendering.internal.repository.c cVar) {
        String url = mediaSource.getUrl();
        Context applicationContext = context.getApplicationContext();
        File fileByUrl = FileUtils.getFileByUrl(applicationContext, url);
        if (fileByUrl == null) {
            cVar.onError(new Error("Can't create file for image by url - " + url));
            return;
        }
        BitmapFactory.Options optionsCreateDefaultBitmapFactoryOptions = ImageUtils.createDefaultBitmapFactoryOptions();
        optionsCreateDefaultBitmapFactoryOptions.inJustDecodeBounds = false;
        Bitmap imageByFile = ImageUtils.getImageByFile(fileByUrl, optionsCreateDefaultBitmapFactoryOptions);
        if (imageByFile != null) {
            cVar.onSuccess(imageByFile);
        } else {
            new NetworkRequest.Builder(url, NetworkRequest.Method.Get).setResponseTransformer(new c(applicationContext, fileByUrl, optionsCreateDefaultBitmapFactoryOptions, null)).setListener(new a(cVar)).send();
        }
    }

    private void a(Context context, String str, io.bidmachine.rendering.internal.repository.c cVar) {
        Uri uri;
        Context applicationContext = context.getApplicationContext();
        File fileByUrl = FileUtils.getFileByUrl(applicationContext, str);
        if (fileByUrl == null) {
            cVar.onError(new Error("Can't create file for video by url - " + str));
        } else if (FileUtils.isEmpty(fileByUrl) || (uri = FileUtils.toUri(fileByUrl)) == null) {
            new NetworkRequest.Builder(str, NetworkRequest.Method.Get).setResponseTransformer(new e(applicationContext, fileByUrl, null)).setListener(new C0791b(cVar)).send();
        } else {
            cVar.onSuccess(uri);
        }
    }

    private void a(String str, io.bidmachine.rendering.internal.repository.c cVar) {
        try {
            cVar.onSuccess(Uri.parse(str));
        } catch (Throwable unused) {
            cVar.onError(new Error("Can't parse video stream url - " + str));
        }
    }
}
