package com.example.thengappan;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PestFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PestFragment extends Fragment {
    RecyclerView recyclerView;
    CardView rhino_card;
    CardView slug_card;
    CardView red_card;
    CardView mite_card;
    CardView white_card;
    CardView worm_card;
    CardView bugs_card;
    CardView skipper_card;

    

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PestFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PestFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PestFragment newInstance(String param1, String param2) {
        PestFragment fragment = new PestFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_pest,container, false);

        GridLayout gridLayout= view.findViewById(R.id.pests_grid);
        rhino_card = view.findViewById(R.id.rhino_card);
        slug_card = view.findViewById(R.id.slug_card);
        red_card= view.findViewById(R.id.red_card);
        mite_card=view.findViewById(R.id.mite_card);
        white_card= view.findViewById(R.id.white_card);
        rhino_card.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // Create a new instance of the fragment you want to open

                RhinoFragment rhinoFragment = RhinoFragment.newInstance();

                // Replace the current fragment with the new one
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, rhinoFragment)
                        .addToBackStack(null)
                        .commit();


            }

        });
        slug_card.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // Create a new instance of the fragment you want to open

                SlugFragment slugFragment = SlugFragment.newInstance();

                // Replace the current fragment with the new one
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, slugFragment)
                        .addToBackStack(null)
                        .commit();


            }

        });
        red_card.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // Create a new instance of the fragment you want to open

                RedFragment redFragment = RedFragment.newInstance();

                // Replace the current fragment with the new one
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, redFragment)
                        .addToBackStack(null)
                        .commit();


            }

        });
        mite_card.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // Create a new instance of the fragment you want to open

                MiteFragment miteFragment = MiteFragment.newInstance();

                // Replace the current fragment with the new one
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, miteFragment)
                        .addToBackStack(null)
                        .commit();


            }

        });
        white_card.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // Create a new instance of the fragment you want to open

                WhiteFragment whiteFragment = WhiteFragment.newInstance();

                // Replace the current fragment with the new one
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, whiteFragment)
                        .addToBackStack(null)
                        .commit();


            }

        });




        // Inflate the layout for this fragment
        return view;
    }


}