package com.example.thenkaapaan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final LinearLayout homeLayout = findViewById(R.id.home_layout);
        final LinearLayout cropProtectionLayout = findViewById(R.id.crop_protection_layout);
        final LinearLayout droneViewLayout= findViewById(R.id.drone_view_layout);


        final ImageView homeImage = findViewById(R.id.home_image);
        final ImageView cropProtectionImage = findViewById(R.id.crop_protection_image);
        final ImageView droneViewImage = findViewById(R.id.drone_view_image);


        final TextView homeText = findViewById(R.id.home_text);
        final TextView cropProtectionText = findViewById(R.id.crop_protection_text);
        final TextView droneViewText = findViewById(R.id.drone_view_text);

        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragment_container , HomeFragment.class , null)
                .commit();

        animateBottomNav(homeLayout, cropProtectionLayout , droneViewLayout , homeText, cropProtectionText, droneViewText, homeImage, cropProtectionImage, droneViewImage, R.drawable.home_icon, R.drawable.crop_protection_icon,R.drawable.drone_view_icon, HomeFragment.class);
        animateBottomNav(cropProtectionLayout, homeLayout , droneViewLayout , cropProtectionText, homeText, droneViewText, cropProtectionImage, homeImage, droneViewImage, R.drawable.crop_protection_icon,R.drawable.home_icon,R.drawable.drone_view_icon, CropProtectionFragment.class);
        animateBottomNav(droneViewLayout, cropProtectionLayout , homeLayout ,droneViewText, cropProtectionText, homeText,  droneViewImage,homeImage, cropProtectionImage, R.drawable.drone_view_icon, R.drawable.home_icon,R.drawable.crop_protection_icon, PestFragment.class);

    }




    private void animateBottomNav(LinearLayout layout, LinearLayout prevLayout, LinearLayout prevLayout2, TextView textView, TextView prevTextView , TextView prevTextView2, ImageView imageView, ImageView prevImageView, ImageView prevImageView2, int icon, int prevIcon, int prevIcon2, Class<? extends Fragment> fragmentClass) {
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)

                                    .replace(R.id.fragment_container , fragmentClass , null)
                                            .commit();

                    prevTextView2.setVisibility(View.GONE);
                    prevTextView.setVisibility(View.GONE);

                    prevImageView2.setImageResource(prevIcon2);
                    prevImageView.setImageResource(prevIcon);

                    prevLayout2.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    prevLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    textView.setVisibility(View.VISIBLE);
                    imageView.setImageResource(icon);
                    layout.setBackgroundResource(R.drawable.round_back_home_100);

                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f , 1.0f, 1f, 1f, Animation.RELATIVE_TO_SELF, 0.0F,Animation.RELATIVE_TO_SELF, 0.0F);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    layout.startAnimation(scaleAnimation);



            }
        });
    }
}