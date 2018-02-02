package piyawat.bakerclick.com.bakerclick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import piyawat.bakerclick.com.bakerclick.fragment.CategoryFragment;
import piyawat.bakerclick.com.bakerclick.fragment.PromotionFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Add Fragment on Activity
        addFragmentOnActivity(savedInstanceState);

    }   // Main Method

    private void addFragmentOnActivity(Bundle savedInstanceState) {
        if (savedInstanceState == null) {

//            For Promotion
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentPromotionFragment, new PromotionFragment())
                    .commit();

//            For Category
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentCategoryFragment, new CategoryFragment())
                    .commit();


        }
    }

}   // Main Class
