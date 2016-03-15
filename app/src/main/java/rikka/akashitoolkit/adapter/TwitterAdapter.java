package rikka.akashitoolkit.adapter;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import rikka.akashitoolkit.R;

import static rikka.akashitoolkit.support.ApiConstParam.TwitterContentLanguage.JP_AND_ZH;
import static rikka.akashitoolkit.support.ApiConstParam.TwitterContentLanguage.ONLY_JP;
import static rikka.akashitoolkit.support.ApiConstParam.TwitterContentLanguage.ONLY_ZH;

/**
 * Created by Rikka on 2016/3/6.
 */
public class TwitterAdapter extends RecyclerView.Adapter<TwitterAdapter.ViewHolder> {
    private static final String TAG = "TwitterAdapter";

    public static class DataModel {
        public int id;
        public String text;
        public String translated;
        public String date;
        public String modified;

        public int getId() {
            return id;
        }

        public String getText() {
            return text;
        }

        public String getTranslated() {
            return translated;
        }

        public String getDate() {
            return date;
        }

        public String getModified() {
            return modified;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setText(String text) {
            this.text = text;
        }

        public void setTranslated(String translated) {
            this.translated = translated;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public void setModified(String modified) {
            this.modified = modified;
        }
    }

    private List<DataModel> mData;
    private int mMaxItem;
    private int mLanguage;

    public void setLanguage(int language) {
        mLanguage = language;
    }

    public void setMaxItem(int maxItem) {
        mMaxItem = maxItem;
    }

    public List<DataModel> getData() {
        return mData;
    }

    public void setData(List<DataModel> data) {
        mData = data;
        //notifyDataSetChanged();
    }

    public TwitterAdapter() {
        mData = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_twitter, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(holder.mAvatar.getContext())
                .load("http://static.kcwiki.moe/KanColleStaffAvatar.png")
                .crossFade()
                .into(holder.mAvatar);

        holder.mName.setText("「艦これ」開発/運営");

        holder.mTvContent.setText(
                Html.fromHtml(
                        mData.get(position).getText()
                ));
        holder.mTvContent.setMovementMethod(LinkMovementMethod.getInstance());

        String translated = mData.get(position).getTranslated();
        holder.mTvContentTranslated.setText(
                Html.fromHtml(
                        TextUtils.isEmpty(translated) ? holder.mTvContentTranslated.getContext().getString(R.string.no_translated) : translated,
                        new ImageLoader(holder.mImage),
                        null
                ));
        holder.mTvContentTranslated.setMovementMethod(LinkMovementMethod.getInstance());

        switch (mLanguage) {
            case JP_AND_ZH:
                holder.mTvContent.setVisibility(View.VISIBLE);
                holder.mTvContentTranslated.setVisibility(View.VISIBLE);
                break;
            case ONLY_JP:
                holder.mTvContent.setVisibility(View.VISIBLE);
                holder.mTvContentTranslated.setVisibility(View.GONE);
                break;
            case ONLY_ZH:
                holder.mTvContent.setVisibility(View.GONE);
                holder.mTvContentTranslated.setVisibility(View.VISIBLE);
                break;
        }

        holder.mTime.setText(mData.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        int count = mData != null ? mData.size() : 0;
        return count > mMaxItem ? mMaxItem : count;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        protected ImageView mAvatar;
        protected TextView mName;
        protected TextView mTvContent;
        protected TextView mTvContentTranslated;
        protected TextView mTime;
        protected ImageView mImage;

        public ViewHolder(View itemView) {
            super(itemView);

            mAvatar = (ImageView) itemView.findViewById(R.id.image_twitter_avatar);
            mName = (TextView) itemView.findViewById(R.id.text_twitter_name);
            mTvContent = (TextView) itemView.findViewById(R.id.text_twitter_content);
            mTvContentTranslated = (TextView) itemView.findViewById(R.id.text_twitter_content_translated);
            mTime = (TextView) itemView.findViewById(R.id.text_twitter_time);
            mImage = (ImageView) itemView.findViewById(R.id.image_twitter_content);
        }
    }

    protected class ImageLoader implements Html.ImageGetter {
        private ImageView mImageView;

        public ImageLoader(ImageView target) {
            this.mImageView = target;
        }

        @Override
        public Drawable getDrawable(String source) {
            mImageView.setVisibility(View.VISIBLE);

            Glide.with(mImageView.getContext())
                    .load(source)
                    .crossFade()
                    .into(mImageView);

            return new ColorDrawable(0);
        }
    }

    @Override
    public void onViewRecycled(ViewHolder holder) {
        Glide.clear(holder.mAvatar);
        Glide.clear(holder.mImage);
    }

}
