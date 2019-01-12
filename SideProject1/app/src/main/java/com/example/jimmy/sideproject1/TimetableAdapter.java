package com.example.jimmy.sideproject1;

/*
This Class is an overwrite of the built in Base Adapter class.
It is used for displaying each element of the scoreboard with GridView.
 */

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a sub-class of BaseAdapter to be used to display elements of the leader board.
 */
public class TimetableAdapter extends BaseAdapter {
    private List<TextView> timeDisplay;
    private int lColumnWidth, lColumnHeight;

    /**
     * Constructor for initializing the adapter.
     *
     * @param items:        Each element for each cell of the Grid View.
     * @param columnWidth:  The cell width for each column.
     * @param columnHeight: The cell height for each row.
     */
    TimetableAdapter(List<TextView> items, int columnWidth, int columnHeight) {
        timeDisplay = items;
        lColumnWidth = columnWidth;
        lColumnHeight = columnHeight;
    }

    /**
     * Gets the total number of cells in the Grid View.
     *
     * @return int: The total cells in Grid View.
     */
    @Override
    public int getCount() {
        return timeDisplay.size();
    }

    /**
     * Returns the TextView item at the specified position.
     *
     * @param position: The position of the desired item.
     * @return TextView: The TextView item to return.
     */
    @Override
    public TextView getItem(int position) {
        return timeDisplay.get(position);
    }

    /**
     * Returns the id for the specified position.
     *
     * @param position: The specified position for the given id.
     * @return int: The desired ID.
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * Returns the desired GridView layout at the specific position.
     *
     * @param position:    The given position.
     * @param convertView: Which type of view inputted.
     * @param parent:      The superclass of the view inputted.
     * @return TextView: The desired TextView at the position.
     */
    @Override
    public TextView getView(int position, View convertView, ViewGroup parent) {

        TextView scoreItem;

        if (convertView == null) {
            scoreItem = timeDisplay.get(position);
        } else {
            scoreItem = (TextView) convertView;
        }

        android.widget.AbsListView.LayoutParams params =
                new android.widget.AbsListView.LayoutParams(lColumnWidth, lColumnHeight);
        scoreItem.setLayoutParams(params);
        return scoreItem;
    }
}
