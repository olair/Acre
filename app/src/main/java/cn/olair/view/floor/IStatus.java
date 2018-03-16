package cn.olair.view.floor;

import android.graphics.Matrix;
import android.graphics.RectF;

/**
 * 状态接口.
 * 用于判断状态，该实现仅作为工具使用，一般不对对象进行保存，不设置构造函数.
 * <p>
 * Created by ws on 2018/3/16.
 */

public interface IStatus {

    /**
     * @param displayRect 显示区域
     * @param contentRect 内容区域
     * @return 是否处于该状态
     */
    boolean checkStatus(RectF displayRect, RectF contentRect);

    /**
     * @param displayRect 显示区域
     * @param contentRect 内容区域
     * @param matrix      用于变换的变换矩阵
     */
    void convert(RectF displayRect, RectF contentRect, Matrix matrix);

    /**
     * @param displayRect 显示区域
     * @param contentRect 内容区域
     * @param matrix      用于变换的变换矩阵
     */
    void calculate(RectF displayRect, RectF contentRect, Matrix matrix);

}
