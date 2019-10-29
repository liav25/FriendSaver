package liav.com.sadna_ex1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextClock;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Initialize TextViews of the Activity
    private TextView titleWelcome;
    private TextView introText;
    //Initialize RecyclerView
    private RecyclerView friends;
    //Initialize add friend button
    private Button addFriend;

    //initialize the recyclerview adapter
    FriendsAdapter friendsAdapter;

    //initialize layour manager
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connect the XML's views to relative objects
        titleWelcome = (TextView)findViewById(R.id.title_welcome);
        introText = (TextView)findViewById(R.id.intro_text);
        friends = (RecyclerView)findViewById(R.id.friends_rec_view);
        addFriend = (Button)findViewById(R.id.be_friend_button);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        friends.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        friends.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        friendsAdapter = new FriendsAdapter(myDataset);
        friends.setAdapter(friendsAdapter);


        addFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddFriendDialog addFriendDialog = new AddFriendDialog();
                addFriendDialog.show(getSupportFragmentManager(), "add friend");
            }
        });
    }
}
