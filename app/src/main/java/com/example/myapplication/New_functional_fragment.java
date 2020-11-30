package com.example.myapplication;

import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link New_functional_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class New_functional_fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public New_functional_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment new_functional.
     */
    // TODO: Rename and change types and number of parameters
    public static New_functional_fragment newInstance(String param1, String param2) {
        New_functional_fragment fragment = new New_functional_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    private EditText view_num1;
    private EditText view_num2;
    private TextView view_result;

    @Override
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View view = getView();
        if (view != null) {
            view_num1 = (EditText) view.findViewById(R.id.num1_mult);
            view_num2 = (EditText) view.findViewById(R.id.num2_mult);
            view_result = (TextView) view.findViewById(R.id.result_mult);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_functional, container, false);
    }


    public void onClickMult() {
        String res_str = Operations.mult(view_num1.getText().toString(), view_num2.getText().toString());
        res_str = getString(R.string.value_result)+res_str;
        view_result.setText(res_str);
    }
}