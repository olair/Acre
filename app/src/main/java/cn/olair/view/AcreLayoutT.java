package cn.olair.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于展示土地形状的View.
 * <p>
 * Created by olair on 18.1.1.
 */

public class AcreLayoutT extends ViewGroup {


    // 用于记录点数据的List
    private List<PointF> mPoints = new ArrayList<>();

    // 用于内容控制
    private TransformationMatrix transformation;

    // 开始缩放的边界
    private int mMaxWidth = 0;
    private int mMaxHeight = 0;

    // 定义其实点
    private int mStartX, mStartY;


    public AcreLayoutT(Context context) {
        super(context, null, 0);
    }

    public AcreLayoutT(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AcreLayoutT(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public AcreLayoutT(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int
            defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void initialization(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int
            defStyleRes) {
    }

    private void initializationField(int maxWidth, int maxHeight) {
        if (mMaxWidth != maxWidth || mMaxHeight != maxHeight) {
            mMaxWidth = maxWidth;
            mMaxHeight = maxHeight;

            mStartX = mMaxWidth / 2;
            mStartY = mMaxHeight / 2;

            mPoints.add(new PointF(mStartX, mStartY));
            transformation = new TransformationMatrix(mMaxWidth, mMaxHeight);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        initializationField(getMeasuredWidth(), getMeasuredHeight());

        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        canvas.setMatrix(transformation.getMatrix());
        super.dispatchDraw(canvas);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();
            PointF childPoint = mPoints.get(i);
            setChildFrame(child, (int) childPoint.x - childWidth / 2, (int) childPoint.y -
                    childHeight / 2, childWidth, childHeight);
        }
    }

    private void setChildFrame(View child, int left, int top, int width, int height) {
        child.layout(left, top, left + width, top + height);
    }

    public void moveTo(float x, float y) {

        transformation.reset();

        PointF targetPoint = new PointF(x, y);
        mPoints.add(targetPoint);
        addView(new AcreNodeView(getContext()));

        // 开始相关变换
        transformation.addPoint(targetPoint);

        invalidate();
    }

    public void move(float width, float height) {
        PointF end = mPoints.get(mPoints.size() - 1);
        moveTo(end.x + width, end.y + height);
    }


}
