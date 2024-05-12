package com.example.thenkaapaan;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DiseaseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DiseaseFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DiseaseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DiseaseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DiseaseFragment newInstance(String param1, String param2) {
        DiseaseFragment fragment = new DiseaseFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_disease, container, false);
        CardView budrotCard = view.findViewById(R.id.budrot_card);
        CardView leafCard = view.findViewById(R.id.leafrot_card);
        CardView leafblightCard = view.findViewById(R.id.leafblight_card);
        CardView phytoplasmaCard = view.findViewById(R.id.phytoplasma_card);
        CardView stembleedingCard = view.findViewById(R.id.stembleeding_card);
        CardView tanjorewiltCard = view.findViewById(R.id.tanjorewilt_card);
        BudrotFragment budrotFragment = new BudrotFragment();
        LeafrotFragment leafrotFragment = new LeafrotFragment();
        LeafblightFragment leafblightFragment = new LeafblightFragment();
        PhytoplasmaFragment phytoplasmaFragment = new PhytoplasmaFragment();
        StembleedingFragment stembleedingFragment = new StembleedingFragment();
        TanjorewiltFragment tanjorewiltFragment = new TanjorewiltFragment();
        replaceFragment(budrotCard, new BudrotFragment());
        replaceFragment(leafCard, new LeafrotFragment());
        replaceFragment(leafblightCard, new LeafblightFragment());
        replaceFragment(phytoplasmaCard, new PhytoplasmaFragment());
        replaceFragment(stembleedingCard, new StembleedingFragment());
        replaceFragment(tanjorewiltCard, new TanjorewiltFragment());
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
}