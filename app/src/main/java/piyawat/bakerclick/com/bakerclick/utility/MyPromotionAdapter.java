package piyawat.bakerclick.com.bakerclick.utility;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import piyawat.bakerclick.com.bakerclick.R;

public class MyPromotionAdapter extends RecyclerView.Adapter<MyPromotionAdapter.ViewHolder>{

//    Explicit
    private Context context;
    private List<String> titleStringList, urlPhotoStringList;
    private LayoutInflater layoutInflater;

    public MyPromotionAdapter(Context context,
                              List<String> titleStringList,
                              List<String> urlPhotoStringList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.titleStringList = titleStringList;
        this.urlPhotoStringList = urlPhotoStringList;
    }   // Constructor

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.layout_promotion, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        String titleString = titleStringList.get(position);
        String urlPhotoString = urlPhotoStringList.get(position);

//        Setup Title
        holder.textView.setText(titleString);

//        Setup Photo
        Picasso.get().load(urlPhotoString).into(holder.imageView);



    }

    @Override
    public int getItemCount() {
        return titleStringList.size();
    }

    //    Create Class
    public class ViewHolder extends RecyclerView.ViewHolder
    {

        public ImageView imageView;
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageViewPromotion);
            textView = itemView.findViewById(R.id.textViewPromotion);

        }
    }   // ViewHolder Class

}   // Main Class
