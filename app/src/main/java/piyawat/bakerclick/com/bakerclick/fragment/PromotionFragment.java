package piyawat.bakerclick.com.bakerclick.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import piyawat.bakerclick.com.bakerclick.utility.MyPromotionAdapter;
import piyawat.bakerclick.com.bakerclick.utility.PromotionAdapter;
import piyawat.bakerclick.com.bakerclick.utility.PromotionModel;

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

    }   // Main Method

    private void getValueFromFirebase() {

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference().child("Promotion");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                int[] countInts = new int[]{0};
                int amountOfChild = (int) dataSnapshot.getChildrenCount(); // Amount of Child
                Log.d("6AprilV1", "amountOfChild ==> " + amountOfChild);

                String[] nameStrings = new String[amountOfChild];
                String[] urlStrings = new String[amountOfChild];

                List list = new ArrayList();

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                    PromotionModel promotionModel = dataSnapshot1.getValue(PromotionModel.class);
                    list.add(promotionModel);

                    nameStrings[countInts[0]] = promotionModel.getNameString();
                    urlStrings[countInts[0]] = promotionModel.getUrlString();

                    Log.d("6AprilV1", "nameString[" + countInts[0] + "] ==> " + nameStrings[countInts[0]]);

                    countInts[0] += 1;
                }   // for

                createRecycleView(nameStrings, urlStrings);

            }   // onDataChange

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }   // getValueFromFirebase


    private void createRecycleView(String[] nameStrings, String[] urlStrings) {

        RecyclerView recyclerView = getView().findViewById(R.id.recycleViewPromotion);



//        Title
        ArrayList<String> stringArrayList = new ArrayList<>();

//        Image
        ArrayList<String> imageStringArrayList1 = new ArrayList<>();


//       Get Array
        for (int i=0; i<nameStrings.length; i+=1) {


            stringArrayList.add(nameStrings[i]);
            imageStringArrayList1.add(urlStrings[i]);

        }   // for

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        MyPromotionAdapter myPromotionAdapter = new MyPromotionAdapter(getActivity(),
                stringArrayList, imageStringArrayList1);



        recyclerView.setAdapter(myPromotionAdapter);





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
