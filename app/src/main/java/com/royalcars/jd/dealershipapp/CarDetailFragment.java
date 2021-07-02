package com.royalcars.jd.dealershipapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CarDetailFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CarDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CarDetailFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private boolean mTwoPane;


    ImageView car_image , car_image1 , car_image2 , car_image3 , car_image4 , car_image5;

    TextView model , model1 , model2 , model3, model4,model5;

    Integer numero = 0;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView list;

    private OnFragmentInteractionListener mListener;

    public CarDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ViewInvFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ViewInvFragment newInstance(String param1, String param2) {
        ViewInvFragment fragment = new ViewInvFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_inv, container, false);

        car_image= view.findViewById(R.id.thumbnail);
        car_image1= view.findViewById(R.id.thumbnail1);
        car_image2= view.findViewById(R.id.thumbnail2);
        car_image3= view.findViewById(R.id.thumbnail3);
        car_image4= view.findViewById(R.id.thumbnail4);
        car_image5= view.findViewById(R.id.thumbnail5);

        model= view.findViewById(R.id.model);
        model1= view.findViewById(R.id.model1);
        model2= view.findViewById(R.id.model2);
        model3= view.findViewById(R.id.model3);
        model4= view.findViewById(R.id.model4);
        model5= view.findViewById(R.id.model5);




        DatabaseReference mRequest = FirebaseDatabase.getInstance().getReference().child("images");


        //  String driverId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        //  Query query = FirebaseDatabase.getInstance().getReference().child("ride_info").orderByChild(idRef).equalTo(driverId);

        mRequest.addChildEventListener(new ChildEventListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                if(!dataSnapshot.exists()){return;}

                numero = numero + 1;

                //   Toast.makeText(getActivity(), dataSnapshot.child("imageUrl").getValue().toString(), Toast.LENGTH_SHORT).show();

                String Imagen = dataSnapshot.child("imageUrl").getValue().toString();

                String precio =  dataSnapshot.child("timestamp").getValue().toString();

                String vehiculo =  dataSnapshot.child("explain").getValue().toString();

                String detalle =  dataSnapshot.child("Detalle").getValue().toString();

                if (numero == 1){

                    Glide.with(getActivity())
                            .load(Imagen)
                            .into(car_image);

                    model.setText(vehiculo);

                }

                if (numero == 2 ){

                    Glide.with(getActivity())
                            .load(Imagen)
                            .into(car_image1);

                    model1.setText(vehiculo);

                }

                if (numero == 3){

                    Glide.with(getActivity())
                            .load(Imagen)
                            .into(car_image2);

                    model2.setText(vehiculo);

                }

                if (numero == 4){


                    Glide.with(getActivity())
                            .load(Imagen)
                            .into(car_image3);

                    model3.setText(vehiculo);

                }

                if (numero == 5){


                    Glide.with(getActivity())
                            .load(Imagen)
                            .into(car_image4);

                    model4.setText(vehiculo);

                }

                if (numero == 6){


                    Glide.with(getActivity())
                            .load(Imagen)
                            .into(car_image5);

                    model5.setText(vehiculo);


                }

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        return view;
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
