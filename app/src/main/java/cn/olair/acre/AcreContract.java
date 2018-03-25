package cn.olair.acre;

import android.graphics.PointF;

import java.util.List;

import cn.olair.BasePresenter;
import cn.olair.BaseView;

/**
 * This specifies the contract between the view and the presenter.
 */

public interface AcreContract {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        void showAcre(List<PointF> points);

        void showCreateAcre();

        void showSuccessfullySaveMessage();

        boolean isActive();

        boolean showNoAcre();
    }


    interface Presenter extends BasePresenter {

        void loadAcre(boolean forceUpdate);

        void createAcre();

        void save(List<PointF> points);

    }

}

