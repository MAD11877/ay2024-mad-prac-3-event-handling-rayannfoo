package sg.edu.np.mad.madpractical3;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;
import android.content.Intent;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private boolean followed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // initialise user
        User user = new User("MAD", "MAD Developer", 1, false);

        // Get the TextViews and button from the layout
        TextView tvName = findViewById(R.id.tvName);
        TextView tvDescription = findViewById(R.id.tvDescription);
        Button btnFollow = findViewById(R.id.Button1);

        // Set the TextViews with the user's name and description
        tvName.setText(user.name);
        tvDescription.setText(user.description);

        Random random = new Random();

        // Generate a random number within the range of 6 digits
        long max = 999999L; // 10^10 - 1
        long number = random.nextLong() % (max + 1);

        tvName.setText(user.name + " " + number);
        btnFollow.setText("Follow");


        btnFollow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.i(TAG, "follow button pressed");

                // Toggle text and update followed variable
                if (followed) {
                    btnFollow.setText("Follow");
                    Toast.makeText(MainActivity.this, "Unfollowed", Toast.LENGTH_SHORT).show();
                } else {
                    btnFollow.setText("Unfollow");
                    Toast.makeText(MainActivity.this, "Followed", Toast.LENGTH_SHORT).show();
                }
                followed = !followed;
            }
        });

        Button button2 = findViewById(R.id.Button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to launch the MessageGroup activity
                Intent intent = new Intent(MainActivity.this, MessageGroup.class);

                // Start the MessageGroup activity
                startActivity(intent);
            }
        });
    }
}