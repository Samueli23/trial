package com.myApp.baraonlineordering;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.myApp.baraonlineordering.adapter.CategoryAdapter;
import com.myApp.baraonlineordering.adapter.DiscountedProductAdapter;
import com.myApp.baraonlineordering.adapter.RecentlyViewedAdapter;
import com.myApp.baraonlineordering.model.Category;
import com.myApp.baraonlineordering.model.DiscountedProducts;
import com.myApp.baraonlineordering.model.RecentlyViewed;

import static com.myApp.baraonlineordering.R.drawable.*;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {


    RecyclerView discountRecyclerView, categoryRecyclerView, recentlyViewedRecycler;
    DiscountedProductAdapter discountedProductAdapter;
    List<DiscountedProducts> discountedProductsList;

    CategoryAdapter categoryAdapter;
    List<Category> categoryList;

    RecentlyViewedAdapter recentlyViewedAdapter;
    List<RecentlyViewed> recentlyViewedList;

    TextView allCategory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        discountRecyclerView = findViewById(R.id.discountedRecycler);
        categoryRecyclerView = findViewById(R.id.categoryRecycler);
        allCategory = findViewById(R.id.allCategoryImage);
        recentlyViewedRecycler = findViewById(R.id.recently_item);


        allCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AllCategory.class);
                startActivity(i);
            }
        });


        discountedProductsList = new ArrayList<>();
        discountedProductsList.add(new DiscountedProducts(1, R.drawable.fish2));
        discountedProductsList.add(new DiscountedProducts(2, R.drawable.cake));
        discountedProductsList.add(new DiscountedProducts(3, R.drawable.fruits));
        discountedProductsList.add(new DiscountedProducts(4, R.drawable.sugar));
        discountedProductsList.add(new DiscountedProducts(5, R.drawable.meat));
        discountedProductsList.add(new DiscountedProducts(6, R.drawable.potatoes1));


        categoryList = new ArrayList<>();
        categoryList.add(new Category(1, ic_home_fruits));
        categoryList.add(new Category(2, ic_home_fish));
        categoryList.add(new Category(3, ic_home_meats));
        categoryList.add(new Category(4, ic_home_veggies));
        categoryList.add(new Category(5, ic_home_fruits));
        categoryList.add(new Category(6, ic_home_fish));
        categoryList.add(new Category(7, ic_home_meats));
        categoryList.add(new Category(8, ic_home_veggies));


       recentlyViewedList = new ArrayList<>();
       recentlyViewedList.add(new RecentlyViewed("BaraBread", "BaraBread is of high quality.", "Ksh 110", "1", "g", bread1,R.drawable.bread));
       recentlyViewedList.add(new RecentlyViewed("Milk", "Freshly packed.", "Ksh 60", "1", "l", R.drawable.milk1, R.drawable.milk2));
       recentlyViewedList.add(new RecentlyViewed("Tea", "Fresh from factory.", "Ksh 50", "1", "Satchets", R.drawable.tea1, R.drawable.tea2));
       recentlyViewedList.add(new RecentlyViewed("Beans", "Of good condition.", "Ksh 78", "1", "kg", R.drawable.beans, R.drawable.beans1));

        setDiscountedRecycler(discountedProductsList);
        setCategoryRecycler(categoryList);
       setRecentlyViewedRecycler(recentlyViewedList);

    }

    private void setDiscountedRecycler(List<DiscountedProducts> dataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        discountRecyclerView.setLayoutManager(layoutManager);
        discountedProductAdapter = new DiscountedProductAdapter(this,dataList);
        discountRecyclerView.setAdapter(discountedProductAdapter);
    }


    private void setCategoryRecycler(List<Category> categoryDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this,categoryDataList);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }

    private void setRecentlyViewedRecycler(List<RecentlyViewed> recentlyViewedDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recentlyViewedRecycler.setLayoutManager(layoutManager);
        recentlyViewedAdapter = new RecentlyViewedAdapter(this,recentlyViewedDataList);
        recentlyViewedRecycler.setAdapter(recentlyViewedAdapter);
    }

}
