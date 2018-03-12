package cn.olair.view;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;

/**
 * 封装Matrix的计算过程.
 *
 * Created by ws on 2018/3/12.
 */

public class TransformationMatrix {

    private RectF displayRect = new RectF();
    private RectF contentRect = new RectF();
    private RectF cacheRect = new RectF();

    Matrix mMatrix = new Matrix();

    TransformationMatrix(int maxWidth, int maxHeight) {
        displayRect.set(0, 0, maxWidth, maxHeight);
    }

    public void addPoint(PointF point) {
        contentRect.union(point.x, point.y);
    }

    public void calculate() {

        float displayWidth = displayRect.width();
        float displayHeight = displayRect.height();

        float contentWidth = contentRect.width();
        float contentHeight = contentRect.height();

        float widthRatio = displayWidth/contentWidth;
        float heightRatio = displayHeight / contentHeight;

        float currentRatio = widthRatio < heightRatio ? widthRatio : heightRatio;

        // ? 是否需要等于1
        if (currentRatio >= 1 && !displayRect.contains(contentRect)) {
            // 需要进行平移操作
            cacheRect.setIntersect(displayRect, contentRect);
            // 开始比较


        } else {
            // 涉及缩放以及平移
        }

    }

}
