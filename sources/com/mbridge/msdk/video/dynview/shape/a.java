package com.mbridge.msdk.video.dynview.shape;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;

/* JADX INFO: compiled from: BackgroundDrawable.java */
/* JADX INFO: loaded from: classes7.dex */
public class a extends ShapeDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5744a;
    private float b;
    private float c;
    private int d;
    private int e;
    private Bitmap f;
    private Bitmap g;
    private boolean h;
    private Paint i;
    private Matrix j;

    /* JADX INFO: compiled from: BackgroundDrawable.java */
    public static class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private RectShape f5745a;
        private Bitmap b;
        private Bitmap c;
        private boolean d;
        private int e;
        private int f;
        private int g;
        private float h;
        private float i;

        private b() {
            this.f = 100;
            this.g = 10;
            this.f5745a = new RectShape();
        }

        @Override // com.mbridge.msdk.video.dynview.shape.a.c
        public c a(Bitmap bitmap) {
            this.c = bitmap;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.shape.a.c
        public c b(Bitmap bitmap) {
            this.b = bitmap;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.shape.a.c
        public c a(boolean z) {
            this.d = z;
            return this;
        }

        public c b(float f) {
            this.h = f;
            return this;
        }

        public c a(int i) {
            this.e = i;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.shape.a.c
        public c a(float f) {
            this.i = f;
            return this;
        }

        public a a() {
            return new a(this);
        }
    }

    /* JADX INFO: compiled from: BackgroundDrawable.java */
    public interface c {
        c a(float f);

        c a(Bitmap bitmap);

        c a(boolean z);

        c b(Bitmap bitmap);
    }

    private void a(Canvas canvas) {
        float f = this.b / 2.0f;
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.lineTo(0.0f, this.c);
        path.lineTo((f - this.d) - this.e, this.c);
        path.lineTo((this.d + f) - this.e, 0.0f);
        if (this.h) {
            try {
                a(canvas, path);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Bitmap bitmap = this.f;
            if (bitmap != null && !bitmap.isRecycled()) {
                try {
                    a(canvas, path, this.f);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        Path path2 = new Path();
        path2.moveTo(this.d + f + this.e, 0.0f);
        path2.lineTo(this.b, 0.0f);
        path2.lineTo(this.b, this.c);
        path2.lineTo((f - this.d) + this.e, this.c);
        if (this.h) {
            try {
                a(canvas, path2);
                return;
            } catch (Exception e3) {
                e3.printStackTrace();
                return;
            }
        }
        Bitmap bitmap2 = this.g;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            return;
        }
        try {
            a(canvas, path2, this.g);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void b(Canvas canvas) {
        float f = this.c / 2.0f;
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.lineTo(0.0f, (this.d + f) - this.e);
        path.lineTo(this.b, (f - this.d) - this.e);
        path.lineTo(this.b, 0.0f);
        if (this.h) {
            try {
                a(canvas, path);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Bitmap bitmap = this.f;
            if (bitmap != null && !bitmap.isRecycled()) {
                try {
                    a(canvas, path, this.f);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        Path path2 = new Path();
        path2.moveTo(0.0f, this.d + f + this.e);
        path2.lineTo(0.0f, this.c);
        path2.lineTo(this.b, this.c);
        path2.lineTo(this.b, (f - this.d) + this.e);
        if (this.h) {
            try {
                a(canvas, path2);
                return;
            } catch (Exception e3) {
                e3.printStackTrace();
                return;
            }
        }
        Bitmap bitmap2 = this.g;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            return;
        }
        try {
            a(canvas, path2, this.g);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f5744a == 1) {
            b(canvas);
        } else {
            a(canvas);
        }
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private a(b bVar) {
        super(bVar.f5745a);
        this.h = false;
        this.f = bVar.b;
        this.g = bVar.c;
        this.h = bVar.d;
        this.f5744a = bVar.e;
        this.d = bVar.f;
        this.e = bVar.g;
        this.b = bVar.h;
        this.c = bVar.i;
        Paint paint = new Paint();
        this.i = paint;
        paint.setStyle(Paint.Style.FILL);
        this.i.setAntiAlias(true);
        this.j = new Matrix();
    }

    private void a(Canvas canvas, Path path, Bitmap bitmap) {
        if (canvas == null || path == null || bitmap == null || bitmap.isRecycled()) {
            return;
        }
        if (bitmap.getWidth() != 0 && bitmap.getHeight() != 0) {
            float fMax = Math.max(this.b / bitmap.getWidth(), this.c / bitmap.getHeight());
            if (this.j == null) {
                this.j = new Matrix();
            }
            this.j.reset();
            this.j.preScale(fMax, fMax);
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        bitmapShader.setLocalMatrix(this.j);
        this.i.setShader(bitmapShader);
        canvas.drawPath(path, this.i);
    }

    private void a(Canvas canvas, Path path) {
        this.i.setColor(Color.parseColor("#40EAEAEA"));
        canvas.drawPath(path, this.i);
    }

    public static b a() {
        return new b();
    }
}
