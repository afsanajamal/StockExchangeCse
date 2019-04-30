package com.example.app.dse_project.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.Toast;

import com.example.app.dse_project.Grid_view.GridViewAdapter;
import com.example.app.dse_project.Grid_view.Gridview_ImageItem;
import com.example.app.dse_project.R;

import java.util.ArrayList;

public class Dashboard_Fragment extends Fragment {

    private GridView gridView;
    private FrameLayout container_body;
    private GridViewAdapter customGridAdapter;
    ArrayList<Gridview_ImageItem> imageItems = new ArrayList<Gridview_ImageItem>();

    Intent i;

    public Dashboard_Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.grid_layout, container, false);


        //Gridview code

        //Set Grid View Item

        Bitmap one = BitmapFactory.decodeResource(this.getResources(), R.drawable.home);
        Bitmap two = BitmapFactory.decodeResource(this.getResources(), R.drawable.rate);
        Bitmap three = BitmapFactory.decodeResource(this.getResources(), R.drawable.watch);
        Bitmap four = BitmapFactory.decodeResource(this.getResources(), R.drawable.search);
        Bitmap five = BitmapFactory.decodeResource(this.getResources(), R.drawable.news);
        Bitmap six = BitmapFactory.decodeResource(this.getResources(), R.drawable.user2);

        imageItems.add(new Gridview_ImageItem(one, "Current Market"));
        imageItems.add(new Gridview_ImageItem(two, "Market Ratting"));
        imageItems.add(new Gridview_ImageItem(three, "Watch List"));
        imageItems.add(new Gridview_ImageItem(four, "Search Compnay"));
        imageItems.add(new Gridview_ImageItem(five, "Market News"));
        imageItems.add(new Gridview_ImageItem(six, "User Setting"));

        gridView = rootView.findViewById(R.id.gridView);
        container_body = rootView.findViewById(R.id.container_body);
//        customGridAdapter = new GridViewAdapter(this, R.layout.row_grid, imageItems);

        customGridAdapter = new GridViewAdapter(getActivity(), R.layout.row_grid, imageItems);


        gridView.setAdapter(customGridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                gridView.setVisibility(View.GONE);
                container_body.setVisibility(View.VISIBLE);
                if (position == 0){
                    Home_Web_update_Fragment home_web_update_fragment = new Home_Web_update_Fragment();
                    changefragment(home_web_update_fragment);
                }else if (position == 1){
                    Update_Fragment update_fragment = new Update_Fragment();
                    changefragment(update_fragment);
                }else if (position == 2){
                    About_Fragment about_fragment = new About_Fragment();
                    changefragment(about_fragment);
                }else if (position == 3){
                    Home_Web_update_Fragment home_web_update_fragment = new Home_Web_update_Fragment();
                    changefragment(home_web_update_fragment);
                }else if (position == 4){
                    Home_Web_update_Fragment home_web_update_fragment = new Home_Web_update_Fragment();
                    changefragment(home_web_update_fragment);
                }else if (position == 5){
                    Toast.makeText(getContext(), "User Settings", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //end Gridview code


        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    private void changefragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container_body, fragment);
        transaction.commit();
    }

}