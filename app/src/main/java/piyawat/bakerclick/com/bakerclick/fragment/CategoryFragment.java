package piyawat.bakerclick.com.bakerclick.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import piyawat.bakerclick.com.bakerclick.R;

/**
 * Created by masterung on 2/2/2018 AD.
 */

public class CategoryFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        return view;
    }
}   // Main Class
