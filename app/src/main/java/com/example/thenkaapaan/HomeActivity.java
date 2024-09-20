package com.example.thenkaapaan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Locale;

public class HomeActivity extends AppCompatActivity {

    private View translateButton;

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

        translateButton = findViewById(R.id.traslate_button);
        translateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLanguage("ta"); // Change to Tamil

            }
        });



        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragment_container , HomeFragment.class , null)
                .commit();

        animateBottomNav(homeLayout, cropProtectionLayout , droneViewLayout , homeText, cropProtectionText, droneViewText, homeImage, cropProtectionImage, droneViewImage, R.drawable.home_icon, R.drawable.crop_protection_icon,R.drawable.drone_view_icon, HomeFragment.class);
        animateBottomNav(cropProtectionLayout, homeLayout , droneViewLayout , cropProtectionText, homeText, droneViewText, cropProtectionImage, homeImage, droneViewImage, R.drawable.crop_protection_icon,R.drawable.home_icon,R.drawable.drone_view_icon, CropProtectionFragment.class);
        animateBottomNav(droneViewLayout, cropProtectionLayout , homeLayout ,droneViewText, cropProtectionText, homeText,  droneViewImage,homeImage, cropProtectionImage, R.drawable.drone_view_icon, R.drawable.home_icon,R.drawable.crop_protection_icon, PestFragment.class);

    }

    private void changeLanguage(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());

        //Manually update the text views without recreating the activity
        updateTextViews();
    }
    @SuppressLint("ResourceType")
    private void updateTextViews() {
        TextView homeText = findViewById(R.id.home_text);
        if (homeText != null) {
            homeText.setText(getString(R.string.home));
        } else {
            Log.e("HomeActivity", "TextView with ID home_text is null");
        }
        //TextView homeText = findViewById(R.id.home_text);
        TextView cropProtectionText = findViewById(R.id.crop_protection_text);
        TextView droneViewText = findViewById(R.id.drone_view_text);
    //    TextView takeActionText= findViewById(R.id.take_action);
//        TextView importImageText = findViewById(R.id.demoText);
//        TextView identifiedPestText = findViewById(R.id.classified);
//        TextView clickToText = findViewById(R.id.click_here);
//        TextView budRotHeading1Text= findViewById(R.id.budrot_heading1);
//        TextView budRotParagraph1Text = findViewById(R.id.budrot_paragraph1);
//        TextView budRotHeading2Text = findViewById(R.id.budrot_heading2);
//        TextView budRotParagraph2Text = findViewById(R.id.budrot_paragraph2);
//        TextView budRotHeading3Text= findViewById(R.id.budrot_heading3);
//        TextView bugsHeading1Text = findViewById(R.id.bugs_heading1);
//        TextView wormParagraph1Text = findViewById(R.id.worm_paragraph1);
//        TextView wormHeading2Text = findViewById(R.id.worm_heading2);
//        TextView wormParagraph2Text= findViewById(R.id.worm_paragraph2);
//        TextView wormHeading3Text = findViewById(R.id.worm_heading3);
        TextView shieldingTheScarsText = findViewById(R.id.textView2);
        TextView forAText = findViewById(R.id.textView3);
        TextView greenerWorldText= findViewById(R.id.textView4);
//        TextView coconutDiseasesText = findViewById(R.id.cocoDiseaseText);
//        TextView coconutPestsText = findViewById(R.id.cocoPestsText);
//        TextView nutrientDeficiencyText = findViewById(R.id.cocoNutrientsText);
//        TextView keralaWiltText= findViewById(R.id.keralawilttext);
//        TextView budRotText = findViewById(R.id.budrottext);
//        TextView leafblightText = findViewById(R.id.leafblighttext);
//        TextView leafRotText = findViewById(R.id.leafrottext);
//        TextView stemBleedingText = findViewById(R.id.stembleedingtext);
//        TextView tanjoreWiltText = findViewById(R.id.tanjorewilttext);
        TextView trendingInfectionText = findViewById(R.id.textView12);
        TextView scanWithMobileText = findViewById(R.id.textView15);
        TextView easyScanText = findViewById(R.id.textView14);
        TextView blackStemRotText = findViewById(R.id.trendText1);
        TextView nutshellBorerText = findViewById(R.id.trendText2);
        TextView aiScanText = findViewById(R.id.textView9);
//        TextView leafblightHeading1Text = findViewById(R.id.leafblight_heading1);
//        TextView leafblightParagraph1Text = findViewById(R.id.leafblight_paragraph1);
//        TextView leafblightHeading2Text = findViewById(R.id.leafblight_heading2);
//        TextView leafblightParagraph2Text = findViewById(R.id.leafblight_paragraph2);
//        TextView leafblightHeading3Text = findViewById(R.id.leafblight_heading3);
//        TextView leafrotHeading1Text = findViewById(R.id.leafrot_heading1);
//        TextView leafrotParagraph1Text = findViewById(R.id.leafrot_paragraph1);
//        TextView leafrotHeading2Text = findViewById(R.id.leafrot_heading2);
//        TextView leafrotParagraph2Text = findViewById(R.id.leafrot_paragraph2);
//        TextView leafrotHeading3Text = findViewById(R.id.leafrot_heading3);
//        TextView miteHeading1Text = findViewById(R.id.mite_heading1);
//        TextView miteParagraph1Text = findViewById(R.id.mite_paragraph1);
//        TextView miteHeading2Text = findViewById(R.id.mite_heading2);
//        TextView miteParagraph2Text = findViewById(R.id.mite_paragraph2);
//        TextView miteHeading3Text = findViewById(R.id.mite_heading3);
//        TextView rhinocerosBeetleText = findViewById(R.id.rhinoceros_beetletext);
//        TextView slugCaterpillarText = findViewById(R.id.slug_caterpillartext);
//        TextView redPalmWeevilText = findViewById(R.id.red_palm_weeviltext);
//        TextView eriophyidMiteText = findViewById(R.id.eriophyid_mitetext);
//        TextView whiteGrubText = findViewById(R.id.white_grubtext);
//        TextView blackHeadedWormText = findViewById(R.id.black_headed_wormtext);
//        TextView mealyBugsText = findViewById(R.id.mealy_bugstext);
//        TextView coconutSkipperText = findViewById(R.id.coconut_skippertext);
//        TextView headingKeralaWiltText = findViewById(R.id.phytoplasma_heading1);
//        TextView paragraph1Text = findViewById(R.id.phytoplasma_paragraph1);
//        TextView headingControlMeasuresText = findViewById(R.id.phytoplasma_heading2);
//        TextView paragraph2Text = findViewById(R.id.phytoplasma_paragraph2);
//        TextView headingImagesAndVideosText = findViewById(R.id.phytoplasma_heading3);
//        TextView redHeading1Text = findViewById(R.id.red_heading1);
//        TextView redParagraph1Text = findViewById(R.id.red_paragraph1);
//        TextView redParagraph2Text = findViewById(R.id.red_paragraph2);
//        TextView rhinoHeading1Text = findViewById(R.id.rhino_heading1);
//        TextView rhinoParagraph1Text = findViewById(R.id.rhino_paragraph1);
//        TextView controlMeasuresText = findViewById(R.id.rhino_heading2);
//        TextView rhinoParagraph2Text = findViewById(R.id.rhino_paragraph2);
//        TextView imagesAndVideosText = findViewById(R.id.rhino_heading3);
//        TextView skipperHeading1Text = findViewById(R.id.skipper_heading1);
//        TextView skipperParagraph1Text = findViewById(R.id.skipper_paragraph1);
//        TextView skipperParagraph2Text = findViewById(R.id.skipper_paragraph2);
//        TextView slugHeading1Text = findViewById(R.id.slug_heading1);
//        TextView slugParagraph1Text = findViewById(R.id.slug_paragraph1);
//        TextView slugParagraph2Text = findViewById(R.id.slug_paragraph2);
//        TextView stembleedingHeadingText = findViewById(R.id.stembleeding_heading1);
//        TextView stemBleedingDescriptionText = findViewById(R.id.stembleeding_paragraph1);
//        TextView controlMeasuresDescriptionText = findViewById(R.id.stembleeding_paragraph2);
//        TextView tanjoreWiltHeadingText = findViewById(R.id.tanjorewilt_heading1);
//        TextView tanjoreWiltDescriptionText = findViewById(R.id.tanjorewilt_paragraph1);
//        TextView controlMeasuresDescriptionTanjoreText = findViewById(R.id.tanjorewilt_paragraph2);
//        TextView whiteGrubHeadingText = findViewById(R.id.white_heading1);
//        TextView whiteGrubDescriptionText = findViewById(R.id.white_paragraph1);
//        TextView controlMeasuresDescriptionWhiteText = findViewById(R.id.white_paragraph2);
//        TextView blackHeadedWormHeadingText = findViewById(R.id.black_heading1);
//        @SuppressLint("CutPasteId") TextView wormDescriptionText = findViewById(R.id.worm_paragraph1);
//        @SuppressLint("CutPasteId") TextView controlMeasuresDescriptionBlackText = findViewById(R.id.worm_paragraph2);


        assert homeText != null;
        homeText.setText(getResources().getString(R.string.home));
        cropProtectionText.setText(getResources().getString(R.string.crop_protection));
        droneViewText.setText(getResources().getString(R.string.drone_view));
//        takeActionText.setText(getResources().getString(R.id.take_action));
//        importImageText.setText(getResources().getString(R.string.import_image));
//        identifiedPestText.setText(getResources().getString(R.string.identified_pest));
//        clickToText.setText(getResources().getString(R.string.click_to_know_more));
//        budRotHeading1Text.setText(getResources().getString(R.string.budrot_heading1));
//        budRotParagraph1Text.setText(getResources().getString(R.string.budrot_paragraph1));
//        budRotHeading2Text.setText(getResources().getString(R.string.budrot_heading2));
//        budRotParagraph2Text.setText(getResources().getString(R.string.budrot_paragraph2));
//        budRotHeading3Text.setText(getResources().getString(R.string.budrot_heading3));
//        bugsHeading1Text.setText(getResources().getString(R.string.bugs_heading1));
//        wormParagraph1Text.setText(getResources().getString(R.string.worm_paragraph1));
//        wormHeading2Text.setText(getResources().getString(R.string.worm_heading2));
//        wormParagraph2Text.setText(getResources().getString(R.string.worm_paragraph2));
//        wormHeading3Text.setText(getResources().getString(R.string.worm_heading3));
        shieldingTheScarsText.setText(getResources().getString(R.string.shielding_the_scars));
        forAText.setText(getResources().getString(R.string.for_a));
        greenerWorldText.setText(getResources().getString(R.string.greener_world));
//        coconutDiseasesText.setText(getResources().getString(R.string.coconut_diseases));
//        coconutPestsText.setText(getResources().getString(R.string.coconut_pests));
//        nutrientDeficiencyText.setText(getResources().getString(R.string.nutrient_deficiency));
//        keralaWiltText.setText(getResources().getString(R.string.kerala_wilt));
//        budRotText.setText(getResources().getString(R.string.bud_rot));
//        leafblightText.setText(getResources().getString(R.string.leaf_blight));
//        leafRotText.setText(getResources().getString(R.string.leaf_rot));
//        stemBleedingText.setText(getResources().getString(R.string.stem_bleeding));
//        tanjoreWiltText.setText(getResources().getString(R.string.tanjore_wilt));
        trendingInfectionText.setText(getResources().getString(R.string.trending_infection));
        scanWithMobileText.setText(getResources().getString(R.string.scan_with_mobile));
        easyScanText.setText(getResources().getString(R.string.easy_scan));
        blackStemRotText.setText(getResources().getString(R.string.black_stem_rot));
        nutshellBorerText.setText(getResources().getString(R.string.nutshell_borer));
        aiScanText.setText(getResources().getString(R.string.ai_scan));
//        leafblightHeading1Text.setText(getResources().getString(R.string.leafblight_heading1));
//        leafblightParagraph1Text.setText(getResources().getString(R.string.leafblight_paragraph1));
//        leafblightHeading2Text.setText(getResources().getString(R.string.leafblight_heading2));
//        leafblightParagraph2Text.setText(getResources().getString(R.string.leafblight_paragraph2));
//        leafblightHeading3Text.setText(getResources().getString(R.string.leafblight_heading3));
//        leafrotHeading1Text.setText(getResources().getString(R.string.leafrot_heading1));
//        leafrotParagraph1Text.setText(getResources().getString(R.string.leafrot_paragraph1));
//        leafrotHeading2Text.setText(getResources().getString(R.string.leafrot_heading2));
//        leafrotParagraph2Text.setText(getResources().getString(R.string.leafrot_paragraph2));
//        leafrotHeading3Text.setText(getResources().getString(R.string.leafrot_heading3));
//        miteHeading1Text.setText(getResources().getString(R.string.mite_heading1));
//        miteParagraph1Text.setText(getResources().getString(R.string.mite_paragraph1));
//        miteHeading2Text.setText(getResources().getString(R.string.mite_heading2));
//        miteParagraph2Text.setText(getResources().getString(R.string.mite_paragraph2));
//        miteHeading3Text.setText(getResources().getString(R.string.mite_heading3));
//        rhinocerosBeetleText.setText(getResources().getString(R.string.rhinoceros_beetle));
//        slugCaterpillarText.setText(getResources().getString(R.string.slug_caterpillar));
//        redPalmWeevilText.setText(getResources().getString(R.string.red_palm_weevil));
//        eriophyidMiteText.setText(getResources().getString(R.string.eriophyid_mite));
//        whiteGrubText.setText(getResources().getString(R.string.white_grub));
//        blackHeadedWormText.setText(getResources().getString(R.string.black_headed_worm));
//        mealyBugsText.setText(getResources().getString(R.string.mealy_bugs));
//        coconutSkipperText.setText(getResources().getString(R.string.coconut_skipper));
//        headingKeralaWiltText.setText(getResources().getString(R.string.heading_kerala_wilt));
//        paragraph1Text.setText(getResources().getString(R.string.paragraph_1));
//        headingControlMeasuresText.setText(getResources().getString(R.string.heading_control_measures));
//        paragraph2Text.setText(getResources().getString(R.string.paragraph_2));
//        headingImagesAndVideosText.setText(getResources().getString(R.string.heading_images_and_videos));
//        redHeading1Text.setText(getResources().getString(R.string.red_heading1));
//        redParagraph1Text.setText(getResources().getString(R.string.red_paragraph1));
//        redParagraph2Text.setText(getResources().getString(R.string.red_paragraph2));
//        rhinoHeading1Text.setText(getResources().getString(R.string.rhino_heading1));
//        rhinoParagraph1Text.setText(getResources().getString(R.string.rhino_paragraph1));
//        controlMeasuresText.setText(getResources().getString(R.string.heading_control_measures));
//        rhinoParagraph2Text.setText(getResources().getString(R.string.rhino_paragraph2));
//        imagesAndVideosText.setText(getResources().getString(R.string.heading_images_and_videos));
//        skipperHeading1Text.setText(getResources().getString(R.string.skipper_heading1));
//        skipperParagraph1Text.setText(getResources().getString(R.string.skipper_paragraph1));
//        skipperParagraph2Text.setText(getResources().getString(R.string.skipper_paragraph2));
//        slugHeading1Text.setText(getResources().getString(R.string.slug_heading1));
//        slugParagraph1Text.setText(getResources().getString(R.string.slug_paragraph1));
//        slugParagraph2Text.setText(getResources().getString(R.string.slug_paragraph2));
//        stembleedingHeadingText.setText(getResources().getString(R.string.stembleeding_heading));
//        stemBleedingDescriptionText.setText(getResources().getString(R.string.stem_bleeding_description));
//        controlMeasuresDescriptionText.setText(getResources().getString(R.string.control_measures_description));
//        tanjoreWiltHeadingText.setText(getResources().getString(R.string.tanjore_wilt_heading));
//        tanjoreWiltDescriptionText.setText(getResources().getString(R.string.tanjore_wilt_description));
//        controlMeasuresDescriptionTanjoreText.setText(getResources().getString(R.string.control_measures_description_tanjore));
//        whiteGrubHeadingText.setText(getResources().getString(R.string.white_grub_heading));
//        whiteGrubDescriptionText.setText(getResources().getString(R.string.white_grub_description));
//        controlMeasuresDescriptionWhiteText.setText(getResources().getString(R.string.control_measures_description_white));
//        blackHeadedWormHeadingText.setText(getResources().getString(R.string.black_headed_worm_heading));
//        wormDescriptionText.setText(getResources().getString(R.string.worm_paragraph1));
//        controlMeasuresDescriptionBlackText.setText(getResources().getString(R.string.worm_paragraph2));
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