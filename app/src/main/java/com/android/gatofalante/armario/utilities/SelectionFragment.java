package com.android.gatofalante.armario.utilities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.android.gatofalante.armario.R;
import com.android.gatofalante.armario.adapters.SelectionAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gatofalante on 1/16/18.
 */

public class SelectionFragment extends Fragment {

    // DONE (3) Create final Strings to store state information about the list of images and list index
    public static final String IMAGE_ID_LIST = "image_ids";
    public static final String LIST_INDEX = "list_index";
    public static final String CATEGORY = "selection_category";


    // Variables to store a list of image resources and the index of the image that this fragment displays
    private List<Integer> mImageIds;
    private int mListIndex;
    private String selectionCategory;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the fragment
     */

    public SelectionFragment() {}


    /**
     * Inflates the fragment layout file and sets the correct resource for the image to display
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        selectionCategory=this.getArguments().getString("category");

        if(savedInstanceState !=null) {

            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
            selectionCategory = savedInstanceState.getString(CATEGORY);
        }


        // Inflate the selection fragment layout
        View rootView = inflater.inflate(R.layout.selection_fragment, container, false);

        // Get a reference to the ImageView in the fragment layout
        final GridView gv = (GridView) rootView.findViewById(R.id.gridview);
        gv.setAdapter(new SelectionAdapter(this.getActivity(), selectionCategory));

        // Return the rootView
        return rootView;
    }

    // Setter methods for keeping track of the list images this fragment can display and which image
    // in the list is currently being displayed

    public void setImageIds(List<Integer> imageIds) {
        mImageIds = imageIds;
    }

    public void setListIndex(int index) {
        mListIndex = index;
    }

    // DONE (4) Override onSaveInstanceState and save the current state of this fragment
    @Override
    public void onSaveInstanceState(Bundle currentState) {
        currentState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>)mImageIds);
        currentState.putInt(LIST_INDEX, mListIndex);
        currentState.putString(CATEGORY, selectionCategory);
    }
}
