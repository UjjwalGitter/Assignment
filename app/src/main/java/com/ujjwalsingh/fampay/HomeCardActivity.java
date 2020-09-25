package com.ujjwalsingh.fampay;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.media.Image;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.gson.Gson;
import com.ujjwalsingh.fampay.model.BgGradient;
import com.ujjwalsingh.fampay.model.BgImage;
import com.ujjwalsingh.fampay.model.BigCard;
import com.ujjwalsingh.fampay.model.Button_CTA;
import com.ujjwalsingh.fampay.model.Card;
import com.ujjwalsingh.fampay.model.Entity;
import com.ujjwalsingh.fampay.model.FormattedDescription;
import com.ujjwalsingh.fampay.model.FormattedTitle;
import com.ujjwalsingh.fampay.model.Icon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class HomeCardActivity extends AppCompatActivity {
    static String API = "http://www.mocky.io/v2/5ed79368320000a0cc27498b";
    SwipeRefreshLayout swipeRefreshLayout;

    Button action_button;
    Button action1_HC4;
    Button action2_HC4;

    TextView big_display;
    TextView with_action;
    TextView card_description_HC3;
    TextView card_description_HC6;
    TextView user_name_HC4;
    TextView card_name_HC4;
    TextView small_card_description_HC1;
    TextView small_card_description_HC1b;
    TextView user_name_HC1;
    TextView user_name_HC1b;

    ImageView contact_icon_HC6;
    ImageView image_card_HC5;
    ImageView user_photo_HC4;
    ImageView user_photo_HC1;
    ImageView user_photo_HC1b;


    RelativeLayout maskHC3;
    RelativeLayout maskHC6;
    RelativeLayout center_card_HC4;
    RelativeLayout scrollable_card_HC1;
    RelativeLayout scrollable_card_HC1b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_card_activity);

        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);

        big_display = findViewById(R.id.big_display);
        with_action = findViewById(R.id.with_action);
        contact_icon_HC6 = findViewById(R.id.contact_icon);
        card_description_HC3 = findViewById(R.id.card_description);
        card_description_HC6 = findViewById(R.id.small_card_description);

        small_card_description_HC1 = findViewById(R.id.small_card_description_HC1);
        small_card_description_HC1b = findViewById(R.id.small_card_description_HC1b);
        user_name_HC1 = findViewById(R.id.user_name_HC1);
        user_name_HC1b = findViewById(R.id.user_name_HC1b);


        image_card_HC5 = findViewById(R.id.image_card_HC5);
        user_name_HC4 = findViewById(R.id.user_name_HC4);
        card_name_HC4 = findViewById(R.id.card_name_HC4);
        image_card_HC5 = findViewById(R.id.image_card_HC5);

        user_name_HC4 = findViewById(R.id.user_name_HC4);
        user_photo_HC4 = findViewById(R.id.user_photo_HC4);
        user_photo_HC1 = findViewById(R.id.user_photo_HC1);
        user_photo_HC1b = findViewById(R.id.user_photo_HC1b);


        action1_HC4 = findViewById(R.id.action1_HC4);
        action2_HC4 = findViewById(R.id.action2_HC4);
        action_button = findViewById(R.id.action_button);

        maskHC3 = findViewById(R.id.mask);
        maskHC6 = findViewById(R.id.small_background);
        center_card_HC4 = findViewById(R.id.center_cardview_HC4);
        scrollable_card_HC1 = findViewById(R.id.scrollable_card_HC1);
        scrollable_card_HC1b = findViewById(R.id.scrollable_card_HC1b);

        asyncTask fetchData = new asyncTask();
        fetchData.execute();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                asyncTask fetchData = new asyncTask();
                fetchData.execute();
                swipeRefreshLayout.setRefreshing(false);
            }
        });


    }

    // Using AsyncTask to retrieve data from the API in JSON format
    class asyncTask extends AsyncTask<Void, Void, Void> {
        public String data = "";
        JSONArray jsArr = new JSONArray();
        String url_action_button = "";
        String url_action1_button = "";
        String url_action2_button = "";

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                URL url = new URL(API);

                //Connection establishment for HTTP request
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while (line != null) {
                    line = bf.readLine();
                    data = data + line;
                }
                // Creating JSONArray from the retrieved data
                jsArr = new JSONArray(data);

            } catch (Exception e) {
            }
            return null;
        }

        @SuppressLint("UseCompatTextViewDrawableApis")
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);


            for (int i = 0; i < jsArr.length(); i++) {
                JSONObject jsonObject = null;
                try {
                    jsonObject = jsArr.getJSONObject(i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                // Converting JSON Object into JAVA OBjects
                BigCard bigCard = new Gson().fromJson(String.valueOf(jsonObject), BigCard.class);

                if (bigCard.getId() == 16) {
                    List<Card> list_card = bigCard.getCards();
                    Card card = list_card.get(0);
                    FormattedTitle formattedTitle = card.getFormattedTitle();
                    List<Entity> list_entity = formattedTitle.getEntities();
                    Entity entity = list_entity.get(0);
                    String text = entity.getText();
                    String color = entity.getColor();
                    big_display.setText(text);
                    big_display.setTextColor(Color.parseColor(color));
                    entity = list_entity.get(1);
                    text = entity.getText();
                    color = entity.getColor();
                    with_action.setText(text);
                    with_action.setTextColor(Color.parseColor(color));
                    FormattedDescription formattedDescription = card.getFormattedDescription();
                    list_entity = formattedDescription.getEntities();
                    entity = list_entity.get(0);
                    card_description_HC3.setTextColor(Color.parseColor(entity.getColor()));
                    card_description_HC3.setText(entity.getText());
                    BgImage bgImage = card.getBgImage();
                    String image_url = bgImage.getImageUrl();

                    // Glide for loading Images from url
                    Glide.with(HomeCardActivity.this)
                            .load(image_url)
                            .into(new CustomTarget<Drawable>() {
                                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                                @Override
                                public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                                    maskHC3.setBackground(resource);
                                }
                                @Override
                                public void onLoadCleared(@Nullable Drawable placeholder) {

                                }
                            });


                    List<Button_CTA> list_button_cta = card.getCta();
                    Button_CTA button_cta = list_button_cta.get(0);
                    url_action_button = button_cta.getUrl();

                    action_button.getBackground().setColorFilter(
                            Color.parseColor(button_cta.getBgColor()),
                            PorterDuff.Mode.SRC_ATOP);
                    action_button.setText(button_cta.getText());
                    action_button.setTextColor(Color.parseColor(button_cta.getTextColor()));

                } else if (bigCard.getId() == 17) {
                    List<Card> list_card = bigCard.getCards();
                    Card card = list_card.get(0);
                    FormattedTitle formattedTitle = card.getFormattedTitle();
                    Log.i("kratos", formattedTitle.getText());
                    card_description_HC6.setText(formattedTitle.getText());
                    Icon icon = card.getIcon();
                    List<Button_CTA> button_ctaList = card.getCta();
                    String icon_url = icon.getImageUrl();
                    Glide.with(getApplicationContext()).load(icon_url)
                            .error(R.drawable.ic_launcher_background)
                            .into(contact_icon_HC6);

                    maskHC6.getBackground().setColorFilter(
                            Color.parseColor(card.getBgColor()),
                            PorterDuff.Mode.SRC_ATOP);
                }

                if (bigCard.getId() == 18) {
                    List<Card> list_card = bigCard.getCards();
                    Card card = list_card.get(0);
                    BgImage bgImage = card.getBgImage();
                    String image_card_url = bgImage.getImageUrl();

                    Glide.with(getApplicationContext()).load(image_card_url)
                            .error(R.drawable.ic_launcher_background)
                            .into(image_card_HC5);
                }
                else if (bigCard.getId() == 20) {

                    List<Card> list_card = bigCard.getCards();
                    Card card = list_card.get(0);
                    FormattedTitle formattedTitle = card.getFormattedTitle();
                    FormattedDescription formattedDescription = card.getFormattedDescription();
                    List<Entity> list_entity = formattedTitle.getEntities();
                    Entity entity = list_entity.get(0);
                    Icon icon = card.getIcon();
                    List<Button_CTA> list_button_cta = card.getCta();

                    Button_CTA button_cta = list_button_cta.get(0);

                    url_action1_button = button_cta.getUrl();

                    action1_HC4.setText(button_cta.getText());
                    action1_HC4.setTextColor(Color.parseColor(button_cta.getTextColor()));

                    action1_HC4.getBackground().setColorFilter(
                            Color.parseColor(button_cta.getBgColor()),
                            PorterDuff.Mode.SRC_ATOP
                    );
                    button_cta = list_button_cta.get(1);

                    url_action2_button = button_cta.getUrl();

                    action2_HC4.setText(button_cta.getText());
                    action2_HC4.setTextColor(Color.parseColor(button_cta.getTextColor()));

                    action2_HC4.getBackground().setColorFilter(
                            Color.parseColor(button_cta.getBgColor()),
                            PorterDuff.Mode.SRC_ATOP
                    );

                    String user_pic_url = icon.getImageUrl();
                    user_name_HC4.setText(entity.getText());
                    card_name_HC4.setText(formattedDescription.getText());

                    Glide.with(getApplicationContext()).load(user_pic_url)
                            .error(R.drawable.ic_launcher_background)
                            .into(user_photo_HC4);
                    int[] colors = new int[2];

                    BgGradient bgGradient = card.getBgGradient();
                    List<String> list_color = bgGradient.getColors();
                    colors[0] = Color.parseColor(list_color.get(0));
                    colors[1] = Color.parseColor(list_color.get(1));

                    GradientDrawable gradientDrawable = new GradientDrawable(
                            GradientDrawable.Orientation.BOTTOM_TOP, //setting a gradient direction
                            colors); //setting the color of gradient
                    gradientDrawable.setCornerRadius(40);
                    center_card_HC4.setBackground(gradientDrawable);

                } else if (bigCard.getId() == 21) {
                    List<Card> list_card = bigCard.getCards();
                    Card card = list_card.get(1);
                    FormattedTitle formattedTitle = card.getFormattedTitle();

                    small_card_description_HC1.setText(formattedTitle.getText());

                    FormattedDescription formattedDescription = card.getFormattedDescription();
                    List<Entity> list_entity = formattedDescription.getEntities();
                    Entity entity = list_entity.get(0);
                    user_name_HC1.setText(entity.getText());
                    user_name_HC1.setTextColor(Color.parseColor(entity.getColor()));

                    scrollable_card_HC1.getBackground().setColorFilter(
                            Color.parseColor(card.getBgColor()),
                            PorterDuff.Mode.SRC_ATOP
                    );

                    Icon icon = card.getIcon();
                    String user_photo_url = icon.getImageUrl();
                    Glide.with(getApplicationContext()).load(user_photo_url)
                            .error(R.drawable.ic_launcher_background)
                            .into(user_photo_HC1);

                } else if (bigCard.getId() == 49) {
                    List<Card> list_card = bigCard.getCards();
                    Card card = list_card.get(1);
                    FormattedTitle formattedTitle = card.getFormattedTitle();
                    FormattedDescription formattedDescription = card.getFormattedDescription();

                    small_card_description_HC1b.setText(formattedTitle.getText());

                    List<Entity> list_entity = formattedDescription.getEntities();
                    Entity entity = list_entity.get(0);
                    user_name_HC1b.setText(entity.getText());
                    user_name_HC1b.setTextColor(Color.parseColor(entity.getColor()));

                    scrollable_card_HC1b.getBackground().setColorFilter(
                            Color.parseColor(card.getBgColor()),
                            PorterDuff.Mode.SRC_ATOP
                    );

                    Icon icon = card.getIcon();
                    String user_photo_url = icon.getImageUrl();
                    Glide.with(getApplicationContext()).load(user_photo_url)
                            .error(R.drawable.ic_launcher_background)
                            .into(user_photo_HC1b);
                }

            }

            //Action Buttons functionality for opening url
            action_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    action_button(url_action_button);
                }
            });

            action1_HC4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setAction1_HC4(url_action1_button);
                }
            });

            action2_HC4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setAction2_HC4(url_action2_button);
                }
            });

        }
    }
    // On Action button pressed method
    final public void action_button(String url) {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    // On Action1 button pressed method
    final public void setAction1_HC4(String url) {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    // On Action2 button pressed method
    final public void setAction2_HC4(String url) {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }


}

