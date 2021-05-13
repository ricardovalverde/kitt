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
import com.example.kitt.datasource.NewsRemote;
import com.example.kitt.model.NewsItem;
import com.example.kitt.presentation.NewsPresenter;
import com.xwray.groupie.GroupAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class FragmentCarActivity extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private final GroupAdapter adapter = new GroupAdapter();
    ProgressBar progressBar;
    private String mParam1;
    private String mParam2;

    public FragmentCarActivity() {
        // Required empty public constructor
    }

    public static FragmentCarActivity newInstance(String param1, String param2) {
        FragmentCarActivity fragment = new FragmentCarActivity();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View viewMain = inflater.inflate(R.layout.fragment_car, container, false);


        configurationRecyclerView(viewMain);
        callRevistasRemote();
        adapterClick();
        catalogoClick(viewMain);


        return viewMain;
    }

    public void showRevistas(List<NewsItem> list) {

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

    private void configurationRecyclerView(View viewMain) {


        LinearLayoutManager linearLayoutRecycler = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        RecyclerView recyclerView = viewMain.findViewById(R.id.recyclerViewNoticiasCar);
        recyclerView.setLayoutManager(linearLayoutRecycler);
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
                int lastItemScroll = linearLayoutRecycler.findLastCompletelyVisibleItemPosition();
                int lastItemList = linearLayoutRecycler.getItemCount();
                if (lastItemScroll == (lastItemList - 1)) {

                    imageView1.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_baseline_keyboard_arrow_left_24, null));

                } else {

                    imageView1.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_baseline_chevron_right_24, null));

                }


            }
        });
    }

    private void callRevistasRemote() {

        NewsRemote revistasRemote = new NewsRemote();
        new NewsPresenter(revistasRemote, this).requestAllRevistasCarros();


    }

    private void adapterClick() {

        adapter.setOnItemClickListener((item, view) -> {

            Intent intent = new Intent(getActivity(), NewsActivity.class);
            intent.putExtra(NewsActivity.URL, ((NewsItem) item).getUrl());
            startActivity(intent);


        });


    }

    private void catalogoClick(View viewMain) {

        LinearLayout catalogoLayout = viewMain.findViewById(R.id.catalogoCar);
        catalogoLayout.setOnClickListener(v -> {

            Intent intent = new Intent(getActivity(), BrandsActivity.class);
            intent.putExtra(BrandsActivity.value, "1");
            startActivity(intent);

        });


    }


}