package cn.olair.view;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;

import cn.olair.view.floor.one.Small;

/**
 * 封装Matrix的计算过程(线缩放再平移).
 * <p>
 * Created by ws on 2018/3/12.
 */

public class TransformationMatrix {

    private RectF displayRect = new RectF();
    private RectF contentRect = new RectF();

    private Matrix mMatrix = new Matrix();

    private Small smallStatus = new Small();

    TransformationMatrix(float left, float top, float right, float bottom, float startX, float startY) {
        displayRect.set(left, top, right, bottom);
        contentRect.set(startX, startY, startX, startY);
    }

    public void resetDisplay(float left, float top, float right, float bottom) {
        displayRect.set(left, top, right, bottom);
    }

    public void resetContent(float left, float top, float right, float bottom) {
        contentRect.set(left, top, right, bottom);
    }

    public void addPoint(PointF point) {
        contentRect.union(point.x, point.y);
    }

    public Matrix getMatrix() {
        calculate();
        return mMatrix;
    }

    public boolean equalsDisplay(float left, float top, float right, float bottom) {
        return displayRect.left == left && displayRect.top == top &&
                displayRect.right == right && displayRect.bottom == bottom;
    }

    private void calculate() {
        mMatrix.reset();
        if (smallStatus.checkStatus(displayRect, contentRect)) {
            smallStatus.calculate(displayRect, contentRect, mMatrix);
        }
    }

}
