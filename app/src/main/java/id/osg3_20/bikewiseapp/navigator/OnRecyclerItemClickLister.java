package id.osg3_20.bikewiseapp.navigator;

import android.support.v7.widget.RecyclerView;

/**
 * Created by Saepul Lukman on 2/4/19.
 */

public interface OnRecyclerItemClickLister {
    void onItemClick(RecyclerView.Adapter adapter, int position);
}
