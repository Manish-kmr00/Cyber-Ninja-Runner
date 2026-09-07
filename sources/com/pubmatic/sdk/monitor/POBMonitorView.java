package com.pubmatic.sdk.monitor;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.pubmatic.sdk.common.utility.POBUtils;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes9.dex */
public class POBMonitorView extends RelativeLayout implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    float f7670a;
    float b;
    float c;
    float d;
    Point e;
    private ViewGroup f;
    private b g;
    RelativeLayout h;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            POBMonitorView.this.f.removeView(POBMonitorView.this);
            if (POBMonitorView.this.g != null) {
                POBMonitorView.this.g.a();
            }
        }
    }

    interface b {
        void a();

        void b();
    }

    public POBMonitorView(Activity activity, Point point) {
        super(activity);
        this.e = point;
        this.f = (ViewGroup) activity.findViewById(android.R.id.content);
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.F, this, me);
        return super.dispatchTouchEvent(me);
    }

    public Point getTouchPointLocation() {
        Point point = new Point();
        point.set((int) this.h.getX(), (int) this.h.getY());
        return point;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        b bVar;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.c = view.getX();
            this.d = view.getY();
            this.f7670a = this.c - motionEvent.getRawX();
            this.b = this.d - motionEvent.getRawY();
        } else if (actionMasked == 1) {
            float x = view.getX();
            float y = view.getY();
            if (Math.abs(x - this.c) <= 20.0f && Math.abs(y - this.d) <= 20.0f && (bVar = this.g) != null) {
                bVar.b();
            }
        } else {
            if (actionMasked != 2) {
                return false;
            }
            view.setY(motionEvent.getRawY() + this.b);
            view.setX(motionEvent.getRawX() + this.f7670a);
        }
        return true;
    }

    public void setListener(b bVar) {
        this.g = bVar;
    }

    private void a() {
        RelativeLayout relativeLayout = (RelativeLayout) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.pob_monitor_view, (ViewGroup) null);
        this.h = relativeLayout;
        Button button = (Button) relativeLayout.findViewById(R.id.pob_monitor_floating_btn);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(POBUtils.convertDpToPixel(16));
        gradientDrawable.setColor(getResources().getColor(R.color.pob_monitor_background));
        button.setBackground(gradientDrawable);
        Button button2 = (Button) this.h.findViewById(R.id.pob_monitor_close_btn);
        button2.setOnClickListener(new a());
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(1);
        gradientDrawable2.setColor(getResources().getColor(R.color.pob_monitor_close_background));
        button2.setBackground(gradientDrawable2);
        this.h.setX(this.e.x);
        this.h.setY(this.e.y);
        this.h.setOnTouchListener(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        Point point = this.e;
        if (point.x == 0 && point.y == 0) {
            layoutParams.addRule(12);
            layoutParams.addRule(11);
            layoutParams.rightMargin = POBUtils.convertDpToPixel(80);
            layoutParams.bottomMargin = POBUtils.convertDpToPixel(100);
        }
        addView(this.h, layoutParams);
        this.f.addView(this, 0, new RelativeLayout.LayoutParams(-1, -1));
    }
}
