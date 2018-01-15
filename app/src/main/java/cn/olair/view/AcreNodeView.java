package cn.olair.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import cn.olair.acre.R;

/**
 * 节点View
 *
 * Created by olair on 18.1.13.
 */

public class AcreNodeView extends View {

    private static final String TAG = "AcreNodeView";
    // 用于绘制的画笔
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public AcreNodeView(Context context) {
        this(context, null);
    }

    public AcreNodeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AcreNodeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public AcreNodeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(50, 50);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int radius = (width > height ? height : width) / 2;
        mPaint.setColor(Color.RED);
        int canvasWidth = canvas.getWidth();
        int canvasHeight = canvas.getHeight();
        canvas.drawCircle(canvasWidth / 2, canvasHeight / 2, radius, mPaint);
    }
}
