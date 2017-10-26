package com.sifu.tabviaviewpagerandfragment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sifu.tabviaviewpagerandfragment.R;

/**
 * Created by android on 17-10-25.
 */

public class PersonCenterFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_person_center, container, false);
    }
}
