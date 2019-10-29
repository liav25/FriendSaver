package liav.com.sadna_ex1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FriendsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context context;
    String[] items;
    public FriendsAdapter(Context mContext, String[] mItems){
        this.context = mContext;
        this.items = mItems;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.friend_row, parent, false);
        Item item = new Item(row);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return items.length;
    }
}