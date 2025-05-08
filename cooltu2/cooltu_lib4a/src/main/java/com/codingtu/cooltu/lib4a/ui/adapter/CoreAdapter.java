package com.codingtu.cooltu.lib4a.ui.adapter;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.codingtu.cooltu.lib4a.R;
import com.codingtu.cooltu.lib4a.ui.adapter.viewholder.CoreAdapterVH;

public abstract class CoreAdapter<VH extends CoreAdapterVH> extends RecyclerView.Adapter<VH> {

    protected View.OnClickListener onClick;
    protected View.OnLongClickListener onLongClick;

    public void setOnClick(View.OnClickListener onClick) {
        this.onClick = onClick;
    }

    public void setOnLongClick(View.OnLongClickListener onLongClick) {
        this.onLongClick = onLongClick;
    }

    protected void setClick(View view) {
        if (view != null && onClick != null)
            view.setOnClickListener(onClick);
    }

    protected void setLongClick(View view) {
        if (view != null && onLongClick != null)
            view.setOnLongClickListener(onLongClick);
    }

    protected void setClick(View view, Object... objs) {
        if (view != null && onClick != null && objs != null) {
            int len = objs.length > 10 ? 10 : objs.length;
            switch (len) {
                case 10:
                    view.setTag(R.id.tag_9, objs[9]);
                case 9:
                    view.setTag(R.id.tag_8, objs[8]);
                case 8:
                    view.setTag(R.id.tag_7, objs[7]);
                case 7:
                    view.setTag(R.id.tag_6, objs[6]);
                case 6:
                    view.setTag(R.id.tag_5, objs[5]);
                case 5:
                    view.setTag(R.id.tag_4, objs[4]);
                case 4:
                    view.setTag(R.id.tag_3, objs[3]);
                case 3:
                    view.setTag(R.id.tag_2, objs[2]);
                case 2:
                    view.setTag(R.id.tag_1, objs[1]);
                case 1:
                    view.setTag(R.id.tag_0, objs[0]);
                    break;

            }
            view.setOnClickListener(onClick);
        }
    }

    protected void setLongClick(View view, Object... objs) {
        if (view != null && onLongClick != null && objs != null) {
            int len = objs.length > 10 ? 10 : objs.length;
            switch (len) {
                case 10:
                    view.setTag(R.id.tag_9, objs[9]);
                case 9:
                    view.setTag(R.id.tag_8, objs[8]);
                case 8:
                    view.setTag(R.id.tag_7, objs[7]);
                case 7:
                    view.setTag(R.id.tag_6, objs[6]);
                case 6:
                    view.setTag(R.id.tag_5, objs[5]);
                case 5:
                    view.setTag(R.id.tag_4, objs[4]);
                case 4:
                    view.setTag(R.id.tag_3, objs[3]);
                case 3:
                    view.setTag(R.id.tag_2, objs[2]);
                case 2:
                    view.setTag(R.id.tag_1, objs[1]);
                case 1:
                    view.setTag(R.id.tag_0, objs[0]);
                    break;

            }
            view.setOnLongClickListener(onLongClick);
        }
    }

    protected void deleteClick(View view) {
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    protected void deleteLongClick(View view) {
        if (view != null) {
            view.setOnLongClickListener(null);
        }
    }

    /***************************************
     *
     *  判断最后一项
     *
     ***************************************/

    public boolean isLastPosition(int position) {
        return position == (getItemCount() - 1);
    }
}
