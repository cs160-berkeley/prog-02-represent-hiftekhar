package com.example.hudaiftekhar.represent;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.wearable.view.CardFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ClickFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ClickFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClickFragment extends CardFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";
    private static final String ARG_PARAM4 = "param4";
    private static final String ARG_PARAM5 = "param5";

    private static final String ARG_PARAM6 = "param6";
    private static final String ARG_PARAM7 = "param7";
    private static final String ARG_PARAM8 = "param8";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String mParam3;
    private String mParam4;
    private String mParam5;
    private String mParam6;
    private String mParam7;
    private String mParam8;


    private OnFragmentInteractionListener mListener;

    public ClickFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ClickFragment.
     */
    // TODO: Rename and change types and number of parameters

    public static ClickFragment newInstance(String param1, String param2, String param3, String param4, String param5, String param6, String param7, String param8) {
        ClickFragment fragment = new ClickFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, param3);
        args.putString(ARG_PARAM4, param4);
        args.putString(ARG_PARAM5, param5);
        args.putString(ARG_PARAM6, param6);
        args.putString(ARG_PARAM7, param7);
        args.putString(ARG_PARAM8, param8);

        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getString(ARG_PARAM3);
            mParam4 = getArguments().getString(ARG_PARAM4);
            mParam5 = getArguments().getString(ARG_PARAM5);
            mParam6 = getArguments().getString(ARG_PARAM6);
            mParam7 = getArguments().getString(ARG_PARAM7);
            mParam8 = getArguments().getString(ARG_PARAM8);
        }
    }


    @Override
    public View onCreateContentView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View here = inflater.inflate(R.layout.fragment_click, container, false);
        final ViewGroup container1 = container;

        TextView hi = (TextView) here.findViewById(R.id.textView2);
        hi.setText(mParam1);
        TextView hi3 = (TextView) here.findViewById(R.id.textView3);
        hi.setText(mParam2);
        TextView hi4 = (TextView) here.findViewById(R.id.textView4);
        hi4.setText(mParam3);
        TextView hi5 = (TextView) here.findViewById(R.id.textView5);
        hi5.setText(mParam4);
        TextView hi6 = (TextView) here.findViewById(R.id.textView6);
        hi6.setText(mParam5);

        System.out.println("These are the parameters");
        System.out.println(mParam1 + " one ");
        System.out.println(mParam2 + " two ");
        System.out.println(mParam3 + " three ");
        System.out.println(mParam4 + " four ");
        System.out.println(mParam5 + " five ");
        System.out.println("****************");
        


         here.setOnClickListener(new View.OnClickListener() {
            // try to send message
            @Override
            public void onClick(View v) {
                Intent sendIntent8 = new Intent(getActivity(), WatchToPhoneService.class);
                sendIntent8.putExtra("LOC_NAME2", mParam2 + "\t" + mParam3 + "\t" + mParam6 + "\t" + mParam7 + "\t" + mParam8);
                getActivity().startService(sendIntent8);
            }
        });

        return here;
    }




    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
