package piyawat.bakerclick.com.bakerclick.utility;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import piyawat.bakerclick.com.bakerclick.R;

/**
 * Created by masterung on 12/2/2018 AD.
 */

public class PromotionAdapter extends RecyclerView.Adapter<PromotionAdapter.ViewHolder>{

    private Context context;
    private List<Integer> integerList = Collections.emptyList();
    private List<String> stringList = Collections.emptyList();
    private LayoutInflater layoutInflater;

    public PromotionAdapter(Context context,
                            List<Integer> integerList,
                            List<String> stringList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.integerList = integerList;
        this.stringList = stringList;
    }

    @Override
    public PromotionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.layout_promotion, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PromotionAdapter.ViewHolder holder, int position) {



    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewPromotion);
            textView = itemView.findViewById(R.id.textViewTitle);
        }
    }   // ViewHolder Class

}   // Main Class
