package com.example.thenkaapaan;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        View view= inflater.inflate(R.layout.fragment_crop_protection, container, false);
        CardView diseaseCard = view.findViewById(R.id.crop_protection_disease_card);

        CardView pestCard = view.findViewById(R.id.crop_protection_pest_card);
        DiseaseFragment diseaseFragment = new DiseaseFragment();
        PestFragment pestFragment = new PestFragment();
        replaceFragment(diseaseCard, new DiseaseFragment());
        replaceFragment(pestCard, new PestFragment());


        return view;
    }
    public void replaceFragment(CardView card, Object fragmentClass) {

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, (Fragment) fragmentClass)
                        .addToBackStack(null)
                        .commit();
            }
        });

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