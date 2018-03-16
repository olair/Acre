package cn.olair.view;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import cn.olair.view.floor.IStatus;
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

    TransformationMatrix(int maxWidth, int maxHeight) {
        displayRect.set(0, 0, maxWidth, maxHeight);
        contentRect.set(maxWidth / 2, maxHeight / 2, maxWidth / 2, maxHeight / 2);
    }

    void addPoint(PointF point) {
        contentRect.union(point.x, point.y);
        calculate();
    }

    public void calculate() {
        if (smallStatus.checkStatus(displayRect, contentRect)) {
            smallStatus.calculate(displayRect, contentRect, mMatrix);
        }
    }

    public Matrix getMatrix() {
        return mMatrix;
    }

    void reset() {
        mMatrix.reset();
    }

}
