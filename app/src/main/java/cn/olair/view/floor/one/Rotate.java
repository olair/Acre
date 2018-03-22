package cn.olair.view.floor.one;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;

/**
 * Created by ws on 2018/3/16.
 */

public class Rotate {

    public void checkStatus(PointF startPoint, PointF endPoint, Matrix matrix) {

    }

    private class ToLeft{

        boolean checkStatus(PointF startPoint, PointF endPoint) {
            return endPoint.x <= startPoint.x;
        }

        public void convert(RectF contentRect, Matrix matrix) {
            matrix.postRotate(90, contentRect.centerX(), contentRect.centerY());
        }

        public void calculate(RectF contentRect, Matrix matrix, PointF startPoint, PointF
                endPoint) {
        }

    }

}
