package com.example.kitt.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kitt.R;
import com.example.kitt.datasource.RevistasRemote;
import com.example.kitt.model.Noticias;
import com.example.kitt.presentation.RevistasPresenter;
import com.xwray.groupie.GroupAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CarFragmentActivity#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CarFragmentActivity extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ProgressBar progressBar;
    private GroupAdapter adapter = new GroupAdapter();
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CarFragmentActivity() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment page1.
     */
    // TODO: Rename and change types and number of parameters
    public static CarFragmentActivity newInstance(String param1, String param2) {
        CarFragmentActivity fragment = new CarFragmentActivity();
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
        View viewMain = inflater.inflate(R.layout.fragment_car, container, false);
        LinearLayout linearLayout = viewMain.findViewById(R.id.catalogoCar);
        RevistasRemote revistasRemote = new RevistasRemote();
        new RevistasPresenter(revistasRemote, this).requestAllRevistasCarros();
        RecyclerView recyclerView = viewMain.findViewById(R.id.recyclerViewNoticiasCar);
        LinearLayoutManager linearLayoutR = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutR);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull @NotNull RecyclerView rv, @NonNull @NotNull MotionEvent e) {
                if (e.getAction() == MotionEvent.ACTION_MOVE) {
                    recyclerView.getParent().requestDisallowInterceptTouchEvent(true);

                }


                return false;
            }

            @Override
            public void onTouchEvent(@NonNull @NotNull RecyclerView rv, @NonNull @NotNull MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                ImageView imageView1 = viewMain.findViewById(R.id.arrowRigth);
                int lastItemScroll = linearLayoutR.findLastCompletelyVisibleItemPosition();
                int lastItemList = linearLayoutR.getItemCount();
                if (lastItemScroll == (lastItemList - 1)) {

                    imageView1.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_baseline_keyboard_arrow_left_24, null));
                } else {
                    imageView1.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_baseline_chevron_right_24, null));

                }


            }
        });
        adapter.setOnItemClickListener((item, view) -> {

            Intent intent = new Intent(getActivity(), NoticiasActivity.class);
            intent.putExtra(NoticiasActivity.URL, ((Noticias) item).getUrl());
            startActivity(intent);


        });


        linearLayout.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), MarcasActivity.class);
            intent.putExtra(MarcasActivity.value, "1");
            startActivity(intent);
        });


        return viewMain;
    }

    public void showRevistas(List<Noticias> list) {

        adapter.addAll(list);
        adapter.notifyDataSetChanged();
    }

    public void showError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void hideProgressBar() {
        progressBar = getView().findViewById(R.id.progress_bar_carf);
        progressBar.setVisibility(View.GONE);
    }
}