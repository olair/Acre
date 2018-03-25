package cn.olair.acre;

import android.app.Fragment;
import android.graphics.PointF;

import java.util.List;

/**
 * Created by olair on 18.3.25.
 */

public class AcreFragment extends Fragment implements AcreContract.View {

    private AcreContract.Presenter mPresenter;


    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void setPresenter(AcreContract.Presenter presenter) {
        if (presenter != null)
            mPresenter = presenter;
    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void showAcre(List<PointF> points) {

    }

    @Override
    public void showCreateAcre() {

    }

    @Override
    public void showSuccessfullySaveMessage() {

    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public boolean showNoAcre() {
        return false;
    }
}
