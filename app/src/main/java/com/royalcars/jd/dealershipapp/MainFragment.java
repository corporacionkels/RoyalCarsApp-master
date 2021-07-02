package com.royalcars.jd.dealershipapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    Integer numero = 0;

    ImageView imageView , imageView1 , imageView2 , card_view_image , card_view_image1 , card_view_image2 , card_view_image3 , card_view_image4;

    ImageView card_view_image5, card_view_image6 , card_view_image7 , card_view_image8 , card_view_image9;

    TextView textView , textView1 , textView2 , textView3 , textView4 , textView5, textView6 , textView7, textView8 , price_car ,text_car;

    TextView text_detail_car , price_car1,price_car2,price_car3,price_car4 , text_car1,text_car2,text_car3,text_car4;

    TextView price_car5, price_car6 , price_car7 , price_car8 , price_car9 , text_car5 , text_car6 , text_car7 , text_car8 , text_car9;


    TextView text_detail_car1, text_detail_car2, text_detail_car3,text_detail_car4 , text_detail_car5 ,text_detail_car6 ,text_detail_car7 , text_detail_car8 , text_detail_car9;

    TextView ui1,ui2,ui3;

    TextView id1 , id2 , id3 , id4 , id5 , id6 , id7;

    TextView btnprice , btnprice1 , btnprice2 , btnprice3 , btnprice4 , btnprice5;

    CardView car_one , car_two , car_tree , car_four, car_five , car_six , car_seven , car_eight , car_nine;

    TextView btndetail , btndetail1 , btndetail2;

    LinearLayout Frame1 , Frame2 ;

    FragmentManager fm;

    DatabaseReference mRequest;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    private OnFragmentInteractionListener mListener;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
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

        //Toast.makeText(getActivity(), "Formulario Creado", Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

       // Toast.makeText(getActivity(), "Vista Creada", Toast.LENGTH_SHORT).show();

        car_one= view.findViewById(R.id.cardview);
        car_two= view.findViewById(R.id.cardview1);
        car_tree= view.findViewById(R.id.cardview2);
        car_four= view.findViewById(R.id.cardview3);
        car_five= view.findViewById(R.id.cardview4);
       // car_five= view.findViewById(R.id.cardview5);
        car_six= view.findViewById(R.id.cardview5);
        car_seven= view.findViewById(R.id.cardview6);
        car_eight= view.findViewById(R.id.cardview7);
        car_nine= view.findViewById(R.id.cardview8);

        imageView= view.findViewById(R.id.imageview);

        imageView1= view.findViewById(R.id.imageview1);

        imageView2= view.findViewById(R.id.imageview3);

        btndetail= view.findViewById(R.id.btndetail);
        btndetail1= view.findViewById(R.id.btndetail1);
        btndetail2 =  view.findViewById(R.id.btndetai2);
        Frame1 =  view.findViewById(R.id.LinearLayout1);
        Frame2 =  view.findViewById(R.id.LinearLayout2);

        // control imagen  vehiculos

        card_view_image= view.findViewById(R.id.cardview_car);
        card_view_image1= view.findViewById(R.id.cardview_car1);
        card_view_image2= view.findViewById(R.id.cardview_car2);
        card_view_image3= view.findViewById(R.id.cardview_car3);
        card_view_image4= view.findViewById(R.id.cardview_car4);
        card_view_image5= view.findViewById(R.id.cardview_car5);
        card_view_image6= view.findViewById(R.id.cardview_car6);
        card_view_image7= view.findViewById(R.id.cardview_car7);
        card_view_image8= view.findViewById(R.id.cardview_car8);
        card_view_image9= view.findViewById(R.id.cardview_car9);

        // Control precio carros

        price_car = view.findViewById(R.id.price_car);
        price_car1 = view.findViewById(R.id.price_car1);
        price_car2 = view.findViewById(R.id.price_car2);
        price_car3 = view.findViewById(R.id.price_car3);
        price_car4 = view.findViewById(R.id.price_car4);
        price_car5 = view.findViewById(R.id.price_car5);
        price_car6 = view.findViewById(R.id.price_car6);
        price_car7 = view.findViewById(R.id.price_car7);
        price_car8 = view.findViewById(R.id.price_car8);
        price_car9 = view.findViewById(R.id.price_car9);

        //

        // Control titulo vehiculo

        text_car= view.findViewById(R.id.text_car);
        text_car1= view.findViewById(R.id.text_car1);
        text_car2= view.findViewById(R.id.text_car2);
        text_car3= view.findViewById(R.id.text_car3);
        text_car4= view.findViewById(R.id.text_car4);
        text_car5= view.findViewById(R.id.text_car5);
        text_car6= view.findViewById(R.id.text_car6);
        text_car7= view.findViewById(R.id.text_car7);
        text_car8= view.findViewById(R.id.text_car8);
        text_car9= view.findViewById(R.id.text_car9);

        //

        // Control detalles

        text_detail_car= view.findViewById(R.id.text_detail_car);
        text_detail_car1= view.findViewById(R.id.text_detail_car1);
        text_detail_car2= view.findViewById(R.id.text_detail_car2);
        text_detail_car3= view.findViewById(R.id.text_detail_car3);
        text_detail_car4= view.findViewById(R.id.text_detail_car4);
        text_detail_car5= view.findViewById(R.id.text_detail_car5);
        text_detail_car6= view.findViewById(R.id.text_detail_car6);
        text_detail_car7= view.findViewById(R.id.text_detail_car7);
        text_detail_car8= view.findViewById(R.id.text_detail_car8);
        text_detail_car9= view.findViewById(R.id.text_detail_car9);

        //

        textView = view.findViewById(R.id.textView);

        textView1 = view.findViewById(R.id.textView11);
        textView2 = view.findViewById(R.id.textView12);

        textView3 = view.findViewById(R.id.textView23);
        textView4 = view.findViewById(R.id.textView22);
        textView5 = view.findViewById(R.id.textView21);


        textView6 = view.findViewById(R.id.textView31);
        textView7 = view.findViewById(R.id.textView32);
        textView8 = view.findViewById(R.id.textView33);

        //Indicadores

        ui1= view.findViewById(R.id.ui1);
        ui2= view.findViewById(R.id.ui2);
        ui3= view.findViewById(R.id.ui3);


        id1= view.findViewById(R.id.car_id);
        id2= view.findViewById(R.id.car_id2);
        id3= view.findViewById(R.id.car_id3);
        id4= view.findViewById(R.id.car_id4);
        id5= view.findViewById(R.id.car_id5);
        id6= view.findViewById(R.id.car_id6);
        id7= view.findViewById(R.id.car_id7);

        // Botones

        btnprice= view.findViewById(R.id.price_car);
        btnprice1= view.findViewById(R.id.price_car1);
        btnprice2= view.findViewById(R.id.price_car2);
        btnprice3= view.findViewById(R.id.price_car3);
        btnprice4= view.findViewById(R.id.price_car4);
        btnprice5= view.findViewById(R.id.price_car5);

        RequestOptions requestOptions=new RequestOptions();
        requestOptions.placeholder(R.drawable.bmw_car_img);
        requestOptions.error(R.drawable.bmw_car_img);


       btndetail.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Bundle datosAEnviar = new Bundle();
// Aquí pon todos los datos que quieras en formato clave, valor
                datosAEnviar.putLong("id", 123L);

// Y puedes pasarle más datos..
                datosAEnviar.putInt("edad", 21);
                datosAEnviar.putString("nombre",ui1.getText().toString());

                //
                //android.app.Fragment nuevoFragmento = new GridFragment();
                //nuevoFragmento.setArguments(datosAEnviar);
                //android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
                //transaction.replace(R.id.main_content, nuevoFragmento);
                //transaction.addToBackStack(null);
                //

                // Crea el nuevo fragmento y la transacción.
                Fragment nuevoFragmento = new ViewInvFragment();
                nuevoFragmento.setArguments(datosAEnviar);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.content, nuevoFragmento);
                transaction.addToBackStack(null);

                // Commit a la transacción
                transaction.commit();

            }
        });

        btndetail1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Bundle datosAEnviar = new Bundle();
// Aquí pon todos los datos que quieras en formato clave, valor
                datosAEnviar.putLong("id", 123L);

// Y puedes pasarle más datos..
                datosAEnviar.putInt("edad", 21);
                datosAEnviar.putString("nombre",ui2.getText().toString());

                //
                //android.app.Fragment nuevoFragmento = new GridFragment();
                //nuevoFragmento.setArguments(datosAEnviar);
                //android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
                //transaction.replace(R.id.main_content, nuevoFragmento);
                //transaction.addToBackStack(null);
                //

                // Crea el nuevo fragmento y la transacción.
                Fragment nuevoFragmento = new ViewInvFragment();
                nuevoFragmento.setArguments(datosAEnviar);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.content, nuevoFragmento);
                transaction.addToBackStack(null);

                // Commit a la transacción
                transaction.commit();

            }
        });

        btndetail2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Bundle datosAEnviar = new Bundle();
// Aquí pon todos los datos que quieras en formato clave, valor
                datosAEnviar.putLong("id", 123L);

// Y puedes pasarle más datos..
                datosAEnviar.putInt("edad", 21);
                datosAEnviar.putString("nombre",ui3.getText().toString());

               // Toast.makeText(getActivity(), ui3.getText().toString(), Toast.LENGTH_SHORT).show();

                //
                //android.app.Fragment nuevoFragmento = new GridFragment();
                //nuevoFragmento.setArguments(datosAEnviar);
                //android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
                //transaction.replace(R.id.main_content, nuevoFragmento);
                //transaction.addToBackStack(null);
                //

                // Crea el nuevo fragmento y la transacción.
                Fragment nuevoFragmento = new ViewInvFragment();
                nuevoFragmento.setArguments(datosAEnviar);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.content, nuevoFragmento);
                transaction.addToBackStack(null);

                // Commit a la transacción
                transaction.commit();

            }
        });

        btnprice.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Bundle datosAEnviar = new Bundle();
// Aquí pon todos los datos que quieras en formato clave, valor
                datosAEnviar.putLong("id", 123L);

// Y puedes pasarle más datos..
                datosAEnviar.putInt("edad", 21);
                datosAEnviar.putString("nombre",id1.getText().toString());

               // Toast.makeText(getActivity(), ui3.getText().toString(), Toast.LENGTH_SHORT).show();

                //
                //android.app.Fragment nuevoFragmento = new GridFragment();
                //nuevoFragmento.setArguments(datosAEnviar);
                //android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
                //transaction.replace(R.id.main_content, nuevoFragmento);
                //transaction.addToBackStack(null);
                //

                // Crea el nuevo fragmento y la transacción.
                Fragment nuevoFragmento = new ViewInvFragment();
                nuevoFragmento.setArguments(datosAEnviar);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.content, nuevoFragmento);
                transaction.addToBackStack(null);

                // Commit a la transacción
                transaction.commit();

            }
        });

        btnprice1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Bundle datosAEnviar = new Bundle();
// Aquí pon todos los datos que quieras en formato clave, valor
                datosAEnviar.putLong("id", 123L);

// Y puedes pasarle más datos..
                datosAEnviar.putInt("edad", 21);
                datosAEnviar.putString("nombre",id2.getText().toString());

                //Toast.makeText(getActivity(), ui3.getText().toString(), Toast.LENGTH_SHORT).show();

                //
                //android.app.Fragment nuevoFragmento = new GridFragment();
                //nuevoFragmento.setArguments(datosAEnviar);
                //android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
                //transaction.replace(R.id.main_content, nuevoFragmento);
                //transaction.addToBackStack(null);
                //

                // Crea el nuevo fragmento y la transacción.
                Fragment nuevoFragmento = new ViewInvFragment();
                nuevoFragmento.setArguments(datosAEnviar);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.content, nuevoFragmento);
                transaction.addToBackStack(null);

                // Commit a la transacción
                transaction.commit();

            }
        });

        btnprice2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Bundle datosAEnviar = new Bundle();
// Aquí pon todos los datos que quieras en formato clave, valor
                datosAEnviar.putLong("id", 123L);

// Y puedes pasarle más datos..
                datosAEnviar.putInt("edad", 21);
                datosAEnviar.putString("nombre",id3.getText().toString());

                //Toast.makeText(getActivity(), ui3.getText().toString(), Toast.LENGTH_SHORT).show();

                //
                //android.app.Fragment nuevoFragmento = new GridFragment();
                //nuevoFragmento.setArguments(datosAEnviar);
                //android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
                //transaction.replace(R.id.main_content, nuevoFragmento);
                //transaction.addToBackStack(null);
                //

                // Crea el nuevo fragmento y la transacción.
                Fragment nuevoFragmento = new ViewInvFragment();
                nuevoFragmento.setArguments(datosAEnviar);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.content, nuevoFragmento);
                transaction.addToBackStack(null);

                // Commit a la transacción
                transaction.commit();

            }
        });

        btnprice3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Bundle datosAEnviar = new Bundle();
// Aquí pon todos los datos que quieras en formato clave, valor
                datosAEnviar.putLong("id", 123L);

// Y puedes pasarle más datos..
                datosAEnviar.putInt("edad", 21);
                datosAEnviar.putString("nombre",id4.getText().toString());

                //Toast.makeText(getActivity(), ui3.getText().toString(), Toast.LENGTH_SHORT).show();

                //
                //android.app.Fragment nuevoFragmento = new GridFragment();
                //nuevoFragmento.setArguments(datosAEnviar);
                //android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
                //transaction.replace(R.id.main_content, nuevoFragmento);
                //transaction.addToBackStack(null);
                //

                // Crea el nuevo fragmento y la transacción.
                Fragment nuevoFragmento = new ViewInvFragment();
                nuevoFragmento.setArguments(datosAEnviar);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.content, nuevoFragmento);
                transaction.addToBackStack(null);

                // Commit a la transacción
                transaction.commit();

            }
        });

        btnprice4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Bundle datosAEnviar = new Bundle();
// Aquí pon todos los datos que quieras en formato clave, valor
                datosAEnviar.putLong("id", 123L);

// Y puedes pasarle más datos..
                datosAEnviar.putInt("edad", 21);
                datosAEnviar.putString("nombre",id5.getText().toString());

                //Toast.makeText(getActivity(), ui3.getText().toString(), Toast.LENGTH_SHORT).show();

                //
                //android.app.Fragment nuevoFragmento = new GridFragment();
                //nuevoFragmento.setArguments(datosAEnviar);
                //android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
                //transaction.replace(R.id.main_content, nuevoFragmento);
                //transaction.addToBackStack(null);
                //

                // Crea el nuevo fragmento y la transacción.
                Fragment nuevoFragmento = new ViewInvFragment();
                nuevoFragmento.setArguments(datosAEnviar);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.content, nuevoFragmento);
                transaction.addToBackStack(null);

                // Commit a la transacción
                transaction.commit();

            }
        });

        btnprice5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Bundle datosAEnviar = new Bundle();
// Aquí pon todos los datos que quieras en formato clave, valor
                datosAEnviar.putLong("id", 123L);

// Y puedes pasarle más datos..
                datosAEnviar.putInt("edad", 21);
                datosAEnviar.putString("nombre",id6.getText().toString());

                //Toast.makeText(getActivity(), ui3.getText().toString(), Toast.LENGTH_SHORT).show();

                //
                //android.app.Fragment nuevoFragmento = new GridFragment();
                //nuevoFragmento.setArguments(datosAEnviar);
                //android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
                //transaction.replace(R.id.main_content, nuevoFragmento);
                //transaction.addToBackStack(null);
                //

                // Crea el nuevo fragmento y la transacción.
                Fragment nuevoFragmento = new ViewInvFragment();
                nuevoFragmento.setArguments(datosAEnviar);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.content, nuevoFragmento);
                transaction.addToBackStack(null);

                // Commit a la transacción
                transaction.commit();

            }
        });

        mRequest = FirebaseDatabase.getInstance().getReference().child("images");


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

                String ui =  dataSnapshot.getKey();

                if (numero == 1){

                Frame1.setVisibility(View.VISIBLE);
                Frame2.setVisibility(View.VISIBLE);

                Glide.with(getActivity())
                        .load(Imagen)
                        .into(imageView);

                textView.setText("$ "+precio);
                textView1.setText(vehiculo);
                textView2.setText(detalle);

                car_one.setVisibility(View.VISIBLE);

                    Glide.with(getActivity())
                            .load(Imagen)
                            .into(card_view_image);

                price_car.setText("$ "+precio);
                text_car.setText(vehiculo);
                text_detail_car.setText(detalle);

                ui1.setText(ui);
                id1.setText(ui);


                }

                if (numero == 2 ){

                    Glide.with(getActivity())
                            .load(Imagen)
                            .into(imageView1);

                    textView5.setText("$ "+precio);
                    textView3.setText(vehiculo);
                    textView4.setText(detalle);

                    car_two.setVisibility(View.VISIBLE);

                    Glide.with(getActivity())
                            .load(Imagen)
                            .into(card_view_image1);

                    price_car1.setText("$ "+precio);
                    text_car1.setText(vehiculo);
                    text_detail_car1.setText(detalle);

                    ui2.setText(ui);
                    id2.setText(ui);

                }

                if (numero == 3){

                    Glide.with(getActivity())
                            .load(Imagen)
                            .into(imageView2);

                    textView6.setText("$ "+precio);
                    textView8.setText(vehiculo);
                    textView7.setText(detalle);

                    car_tree.setVisibility(View.VISIBLE);

                    Glide.with(getActivity())
                            .load(Imagen)
                            .into(card_view_image2);

                    price_car2.setText("$ "+precio);
                    text_car2.setText(vehiculo);
                    text_detail_car2.setText(detalle);

                    ui3.setText(ui);

                    id3.setText(ui);

                }

                if (numero == 4){

                    car_four.setVisibility(View.VISIBLE);

                    Glide.with(getActivity())
                            .load(Imagen)
                            .into(card_view_image3);

                    price_car3.setText("$ "+precio);
                    text_car3.setText(vehiculo);
                    text_detail_car3.setText(detalle);

                    id4.setText(ui);

                }

                if (numero == 5){

                    car_five.setVisibility(View.VISIBLE);

                    Glide.with(getActivity())
                            .load(Imagen)
                            .into(card_view_image4);

                    price_car4.setText("$ "+precio);
                    text_car4.setText(vehiculo);
                    text_detail_car4.setText(detalle);

                    id5.setText(ui);

                }

                if (numero == 6){

                    car_six.setVisibility(View.VISIBLE);

                    Glide.with(getActivity())
                            .load(Imagen)
                            .into(card_view_image5);

                    price_car5.setText("$ "+precio);
                    text_car5.setText(vehiculo);
                    text_detail_car5.setText(detalle);

                    id6.setText(ui);

                }

                if (numero == 7){

                    car_seven.setVisibility(View.VISIBLE);

                    Glide.with(getActivity())
                            .load(Imagen)
                            .into(card_view_image6);

                    price_car6.setText("$ "+precio);
                    text_car6.setText(vehiculo);
                    text_detail_car6.setText(detalle);

                    id7.setText(ui);

                }

                if (numero == 8){

                    car_eight.setVisibility(View.VISIBLE);

                    Glide.with(getActivity())
                            .load(Imagen)
                            .into(card_view_image7);

                    price_car7.setText("$ "+precio);
                    text_car7.setText(vehiculo);
                    text_detail_car7.setText(detalle);


                }

                if (numero == 9){

                    car_nine.setVisibility(View.VISIBLE);

                    Glide.with(getActivity())
                            .load(Imagen)
                            .into(card_view_image8);

                    price_car8.setText("$ "+precio);
                    text_car8.setText(vehiculo);
                    text_detail_car8.setText(detalle);

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

     //  Picasso.with(getContext()).load("https://firebasestorage.googleapis.com/v0/b/royalcars-bf1a4.appspot.com/o/images%2FPolish_20210601_073203060.jpg?alt=media&token=3689c894-6560-4916-8e83-777fb05266fd")
     //           .into(imageView);

        //Picasso.with(getContext())
        //        .load("https://firebasestorage.googleapis.com/v0/b/royalcars-bf1a4.appspot.com/o/images%2FPolish_20210601_073203060.jpg?alt=media&token=3689c894-6560-4916-8e83-777fb05266fd")
        //        .into(imageView);


       // Glide.with(getActivity())
       //         .load("https://firebasestorage.googleapis.com/v0/b/royalcars-bf1a4.appspot.com/o/images%2FIMG_20210602_165001.jpg?alt=media&token=1f42d4cc-cec5-4d6d-88a7-6f52a03d94e0")
       //         .into(imageView);

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
