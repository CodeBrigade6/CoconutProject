package com.example.thengappan;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewParentCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class CropProtectionFragment extends Fragment {


//    private ViewPager2 viewPager2;
//    private Handler sliderHandler = new Handler();
//    RecyclerView recyclerView;
//
//
//    TODO: Rename parameter arguments, choose names that match
//    the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//    private Inflater inflater;
//
//    public CropProtectionFragment() {
//        // Required empty public constructor
//    }


    // TODO: Rename and change types and number of parameters
//    public static CropProtectionFragment newInstance(String param1, String param2) {
//        CropProtectionFragment fragment = new CropProtectionFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_crop_protection, container, false);

    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        ViewPager2 viewPager2 = view.findViewById(R.id.viewPagerImageSlider);

//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }

//    }


}