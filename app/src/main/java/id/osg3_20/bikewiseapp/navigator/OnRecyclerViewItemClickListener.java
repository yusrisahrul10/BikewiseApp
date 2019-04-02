package id.osg3_20.bikewiseapp.navigator;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Saepul Lukman on 2/4/19.
 */

public interface OnRecyclerViewItemClickListener {
    void onViewItemClick(RecyclerView.Adapter adapter, int position, View view);
}
