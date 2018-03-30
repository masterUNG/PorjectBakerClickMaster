package piyawat.bakerclick.com.bakerclick.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import piyawat.bakerclick.com.bakerclick.R;
import piyawat.bakerclick.com.bakerclick.utility.MyConstance;
import piyawat.bakerclick.com.bakerclick.utility.PromotionAdapter;

/**
 * Created by masterung on 2/2/2018 AD.
 */

public class CategoryFragment extends Fragment{

    //    Explicit
    private int[] imageInts;
    private String[] categoryStrings;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getValueFromMyConstance();

        createRecycleView();


    }   // Main Class

    private void createRecycleView() {

        RecyclerView recyclerView = getView().findViewById(R.id.recycleViewCategory);
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        ArrayList<String> stringArrayList = new ArrayList<>();

//       Get Array
        for (int i=0; i<imageInts.length; i+=1) {
            integerArrayList.add(imageInts[i]);
            stringArrayList.add(categoryStrings[i]);
        }   // for

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        PromotionAdapter promotionAdapter = new PromotionAdapter(getActivity(),
                integerArrayList, stringArrayList);
        recyclerView.setAdapter(promotionAdapter);





    }   // createRecycleView

    private void getValueFromMyConstance() {
        MyConstance myConstance = new MyConstance();
        imageInts = myConstance.getInts();
        categoryStrings = myConstance.getPromotionStrings();
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        return view;
    }
}   // Main Class
