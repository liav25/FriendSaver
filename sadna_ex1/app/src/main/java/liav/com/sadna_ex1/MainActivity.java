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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Initialize TextViews of the Activity
    private TextView titleWelcome;
    private TextView introText;
    //Initialize add friend button
    private Button addFriend;
    //friends lists
    public static ArrayList<String> names = new ArrayList<>();
    public static ArrayList<String> numbers = new ArrayList<>();

    public static FriendsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connect the XML's views to relative objects
        titleWelcome = (TextView)findViewById(R.id.title_welcome);
        introText = (TextView)findViewById(R.id.intro_text);
        addFriend = (Button)findViewById(R.id.be_friend_button);

        // initialize friends list
        initFriendsList();


        addFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddFriendDialog addFriendDialog = new AddFriendDialog();
                addFriendDialog.show(getSupportFragmentManager(), "add friend");
            }
        });

        names.add("Yoni");
        numbers.add("0523456789");
    }

    private void initFriendsList(){
        RecyclerView friends = findViewById(R.id.friends_rec_view);
        adapter = new FriendsAdapter(this, names, numbers);
        friends.setAdapter(adapter);
        friends.setLayoutManager(new LinearLayoutManager(this));
    }


}
