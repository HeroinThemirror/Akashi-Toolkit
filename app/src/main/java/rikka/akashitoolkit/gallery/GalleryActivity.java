package rikka.akashitoolkit.gallery;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import rikka.akashitoolkit.R;
import rikka.akashitoolkit.support.StaticData;
import rikka.akashitoolkit.utils.Utils;

public class GalleryActivity extends AppCompatActivity {

    public static final String EXTRA_URL = "EXTRA_URL";
    public static final String EXTRA_NAME = "EXTRA_NAME";
    public static final String EXTRA_TITLE = "EXTRA_TITLE";

    public static void start(Context context, List<String> url, String title) {
        Intent intent = new Intent(context, GalleryActivity.class);
        intent.putStringArrayListExtra(EXTRA_URL, (ArrayList<String>) url);
        intent.putExtra(EXTRA_TITLE, title);
        context.startActivity(intent);
    }

    public static void start(Context context, List<String> url, List<String> name, String title) {
        Intent intent = new Intent(context, GalleryActivity.class);
        intent.putStringArrayListExtra(EXTRA_URL, (ArrayList<String>) url);
        intent.putStringArrayListExtra(EXTRA_NAME, (ArrayList<String>) name);
        intent.putExtra(EXTRA_TITLE, title);
        context.startActivity(intent);
    }

    private int mItemSize;
    private int mSpanCount;
    private List<String> mUrls;
    private List<String> mNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getIntent().getStringExtra(EXTRA_TITLE));

        mItemSize = -1;

        boolean horizontal = getResources().getBoolean(R.bool.is_horizontal);
        boolean tablet = StaticData.instance(this).isTablet;

        mSpanCount = horizontal ? (tablet ? 5 : 3) : 2;

        mUrls = getIntent().getStringArrayListExtra(EXTRA_URL);
        mNames = getIntent().getStringArrayListExtra(EXTRA_NAME);

        final GalleryAdapter adapter = new GalleryAdapter(R.layout.item_gallery_image) {
            @Override
            public void onItemClicked(View v, List<String> data, int position) {
                ImagesActivity.start(v.getContext(), data, position, null);
            }

            @Override
            public void onBindViewHolder(ViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                holder.mImageView.setLayoutParams(new FrameLayout.LayoutParams(mItemSize, mItemSize));
                holder.mTitle.setLayoutParams(new FrameLayout.LayoutParams(mItemSize, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.BOTTOM));
            }
        };

        adapter.setItemBackgroundColor(ContextCompat.getColor(this, R.color.windowBackground));

        GridLayoutManager layoutManager = new GridLayoutManager(this, mSpanCount);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.content_container);
        recyclerView.setBackgroundColor(ContextCompat.getColor(this, R.color.cardBackground));

        recyclerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                mItemSize = (v.getWidth() - Utils.dpToPx(1) * (mSpanCount - 1)) / mSpanCount;
                adapter.setNames(mNames);
                adapter.setUrls(mUrls);
                adapter.notifyDataSetChanged();

                v.removeOnLayoutChangeListener(this);
            }
        });

        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                int position = parent.getChildAdapterPosition(view) + 1;

                outRect.set(0, Utils.dpToPx(1), Utils.dpToPx(1), 0);

                if (position % mSpanCount == 0) {
                    outRect.right = 0;
                }

                if (position <= mSpanCount) {
                    outRect.top = 0;
                }
            }
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();

                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
