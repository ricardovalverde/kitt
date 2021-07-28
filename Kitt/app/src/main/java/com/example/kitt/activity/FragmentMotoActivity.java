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


public class FragmentMotoActivity extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private GroupAdapter adapter = new GroupAdapter();

    private ProgressBar progressBar;
    private String mParam1;
    private String mParam2;

    public FragmentMotoActivity() {
        // Required empty public constructor
    }

    public static FragmentMotoActivity newInstance(String param1, String param2) {
        FragmentMotoActivity fragment = new FragmentMotoActivity();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View viewMain = inflater.inflate(R.layout.fragment_motos, container, false);

        configurationRecyclerView(viewMain);
        callRevistasRemote();
        catalogoClick(viewMain);
        adapterClick();

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
        progressBar = getView().findViewById(R.id.progress_bar_motof);
        progressBar.setVisibility(View.GONE);
    }

    private void configurationRecyclerView(View viewMain) {

        LinearLayoutManager linearLayoutRecyclerView = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        RecyclerView recyclerView = viewMain.findViewById(R.id.recyclerViewNoticiasMoto);
        recyclerView.setLayoutManager(linearLayoutRecyclerView);
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
                int lastItemScroll = linearLayoutRecyclerView.findLastCompletelyVisibleItemPosition();
                int lastItemList = linearLayoutRecyclerView.getItemCount();
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
        new NewsPresenter(revistasRemote, this).requestAllRevistasMotos();
    }

    private void catalogoClick(View viewMain) {

        LinearLayout linearLayout = viewMain.findViewById(R.id.catalogoMoto);
        linearLayout.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), BrandsActivity.class);
            intent.putExtra(BrandsActivity.value, "2");
            startActivity(intent);
        });
    }

    private void adapterClick() {
        adapter.setOnItemClickListener((item, view) -> {

            Intent intent = new Intent(getActivity(), NewsActivity.class);
            intent.putExtra(NewsActivity.URL, ((NewsItem) item).getUrl());
            startActivity(intent);
        });
    }
}