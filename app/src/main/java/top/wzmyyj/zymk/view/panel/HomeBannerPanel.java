package top.wzmyyj.zymk.view.panel;

import android.content.Context;

import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import top.wzmyyj.zymk.app.bean.BoBean;
import top.wzmyyj.zymk.presenter.HomePresenter;
import top.wzmyyj.zymk.view.panel.base.BaseBannerPanel;


/**
 * Created by yyj on 2018/09/19. email: 2209011667@qq.com
 */

public class HomeBannerPanel extends BaseBannerPanel<HomePresenter> {

    public HomeBannerPanel(Context context, HomePresenter homePresenter) {
        super(context, homePresenter);
    }

    @Override
    public Object f(int w, Object... objects) {
        if (w == -1) return null;
        List<BoBean> bos = (List<BoBean>) objects[0];
        setBanner(bos);
        return super.f(w, objects);
    }

    public void setBanner(final List<BoBean> bos) {
        if (bos == null || bos.size() == 0) return;
        List<String> imgs = new ArrayList<>();
        List<String> strs = new ArrayList<>();

        for (int i = 0; i < bos.size(); i++) {
            BoBean bo = bos.get(i);
            imgs.add(bo.getData_src());
            strs.add(bo.getTitle());
        }
        mBanner.update(imgs, strs);

        mBanner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                mPresenter.goDetails(bos.get(position).getHref());
            }
        });
    }
}