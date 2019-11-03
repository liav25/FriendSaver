package liav.com.sadna_ex1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.ViewHolder> {

    //source lists for recycler view
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> numbers = new ArrayList<>();
    public ArrayList<String> abillities = new ArrayList<>();
    public ArrayList<Bitmap> images = new ArrayList<>();
    private Context context;

    public FriendsAdapter(Context context, ArrayList<String> mNames, ArrayList<String> mNumbers, ArrayList<String> mAbillity,
                          ArrayList<Bitmap> mImages) {
        this.names = mNames;
        this.numbers = mNumbers;
        this.abillities = mAbillity;
        this.images = mImages;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.friend_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(names.get(position));
        holder.number.setText(numbers.get(position));
        holder.abillityText.setText(abillities.get(position));
        holder.profilePic.setImageBitmap(images.get(position));
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //create view objects
        TextView name;
        TextView number;
        TextView abillityText;
        ImageView profilePic;

        LinearLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //link the view obejcts to the XML
            name = itemView.findViewById(R.id.friend_name);
            number = itemView.findViewById(R.id.friend_phone);
            abillityText = itemView.findViewById(R.id.abillity_text);
            profilePic = itemView.findViewById(R.id.card_image);
        }
    }
}
