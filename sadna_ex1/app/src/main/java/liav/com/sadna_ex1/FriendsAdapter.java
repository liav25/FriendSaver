package liav.com.sadna_ex1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.ViewHolder> {

    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> numbers = new ArrayList<>();
    private Context context;

    public FriendsAdapter(Context context, ArrayList<String> mNames, ArrayList<String> mNumbers) {
        this.names = mNames;
        this.numbers = mNumbers;
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
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //create view objects
        TextView name;
        TextView number;
        LinearLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //link the view obejcts to the XML
            name = itemView.findViewById(R.id.name);
            number = itemView.findViewById(R.id.number);
            parentLayout = itemView.findViewById(R.id.parent);
        }
    }
}
