package dontknow.finhacks.com.shoppersproject;

import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageButton;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class CategoryGrid extends AppCompatActivity {
    ImageButton clothingButton;
    ImageButton electronicsButton;
    ImageButton gamesButton;
    ImageButton restaurantsButton;
    ImageButton homeButton;
    ImageButton CosmeticButton;
    boolean[] selected; // get from user

    //Change colors here for when button pressed
    public static final int COLOR_SELECTED = Color.GREEN;
    public static final int COLOR_UNSELECTED = Color.GRAY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_grid);
        clothingButton = (ImageButton) findViewById(R.id.clothingButton);
        electronicsButton = (ImageButton)findViewById(R.id.electronicsButton);
        gamesButton = (ImageButton)findViewById(R.id.gamesButton);
        restaurantsButton = (ImageButton)findViewById(R.id.restaurantButton);
        homeButton = (ImageButton)findViewById(R.id.homeButton);
        CosmeticButton = (ImageButton)findViewById(R.id.cosmesticsButton);
        ImageButton[] buttons = {clothingButton ,electronicsButton, gamesButton, restaurantsButton, homeButton, CosmeticButton};

        // TODO: get user pref
        selected = new boolean[6];
        for (int i =0; i<6; i++){
            selected[i] = false;
        }

        //Edit onClick function to program logic for button being pressed
        for (int i = 0; i < 6; i++){
            final ImageButton b = buttons[i];

            final int j = i;
            boolean isSelected = selected[i];
            if (isSelected){
                b.setBackgroundColor(COLOR_SELECTED);
            } else {
                b.setBackgroundColor(COLOR_UNSELECTED);
            }
            b.setOnClickListener((new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
//                    Toast.makeText(getApplicationContext(), "You Clicked Clothing", Toast.LENGTH_LONG).show();
                    if (selected[j])
                    {
                        //Change color after pressed when not previously selected
                        b.setBackgroundColor(COLOR_UNSELECTED);
                        selected[j] = false;
                    }
                    else
                    {
                        b.setBackgroundColor(COLOR_SELECTED);
                        selected[j] = true;
                    }
                }
            }));
        }


    }
}
