package com.moringaschool.news.util;

public interface ItemTouchHelperClass {
    boolean onItemMove(int fromPosition, int toPosition);
    void onItemDismiss(int position);
}
