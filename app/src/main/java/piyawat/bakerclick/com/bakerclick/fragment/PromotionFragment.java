package piyawat.bakerclick.com.bakerclick.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import piyawat.bakerclick.com.bakerclick.R;
import piyawat.bakerclick.com.bakerclick.utility.MyConstance;
import piyawat.bakerclick.com.bakerclick.utility.PromotionAdapter;

/**
 * Created by masterung on 2/2/2018 AD.
 */

public class PromotionFragment extends Fragment{

    //    Explicit
    private int[] imageInts;
    private String[] promotionStrings;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Get Value From MyConstance
        getValueFromMyConstance();

//        Get Value From Firebase
        getValueFromFirebase();

//        Create RecycleView
        createRecycleView();


    }   // Main Method

    private void getValueFromFirebase() {

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference().child("Promotion");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                int[] countInts = new int[]{0};
                List list = new ArrayList();

            }   // onDataChange

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });







    }   // getValueFromFirebase


    private void createRecycleView() {

        RecyclerView recyclerView = getView().findViewById(R.id.recycleViewPromotion);
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        ArrayList<String> stringArrayList = new ArrayList<>();

//       Get Array
        for (int i=0; i<imageInts.length; i+=1) {
            integerArrayList.add(imageInts[i]);
            stringArrayList.add(promotionStrings[i]);
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
        promotionStrings = myConstance.getPromotionStrings();
    }   // getValueFromMyConstance

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_promotion, container, false);
        return view;
    }
}   // Main Class
