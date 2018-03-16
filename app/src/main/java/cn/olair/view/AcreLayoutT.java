package cn.olair.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
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
    private TransformationMatrix transformation = new TransformationMatrix(0, 0, 0, 0, 0, 0);

    public AcreLayoutT(Context context) {
        super(context, null, 0);
    }

    public AcreLayoutT(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AcreLayoutT(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialization(context, attrs, defStyleAttr, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public AcreLayoutT(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int
            defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initialization(context, attrs, defStyleAttr, defStyleRes);
    }

    private void initialization(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int
            defStyleRes) {
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
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

        // 处理transformation
        if (!transformation.equalsDisplay(0, 0, getMeasuredWidth(), getMeasuredHeight())) {
            transformation.resetDisplay(0, 0, getMeasuredWidth(), getMeasuredHeight());
        }

        // 处理孩子节点
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

    public void start(float x, float y) {
        PointF point = new PointF(x, y);
        mPoints.add(point);
        addView(new AcreNodeView(getContext()));
        transformation.addPoint(point);
        transformation.resetContent(x, y, x, y);
    }


}
