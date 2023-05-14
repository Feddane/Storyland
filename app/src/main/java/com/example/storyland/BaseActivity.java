package com.example.storyland;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

//BaseActivity: est une classe java qui permet a l'application mobile de s'adapter a differents appareils et taille d'ecran "Responsive"
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView1 = findViewById(R.id.textview1);
        TextView textView2 = findViewById(R.id.textView2);
        Button button = findViewById(R.id.myButton);

        // Trouver les views dans les autres layout files
        View otherView1 = getLayoutInflater().inflate(R.layout.activity_story, null);
        View otherView2 = getLayoutInflater().inflate(R.layout.activity_stories, null);
        View otherView3 = getLayoutInflater().inflate(R.layout.activity_scene, null);
        View otherView4 = getLayoutInflater().inflate(R.layout.activity_scenes, null);
        View otherView5 = getLayoutInflater().inflate(R.layout.activity_favorite_stories, null);

        // Ajouter  les views au main layout
        ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout);
        constraintLayout.addView(otherView1);
        constraintLayout.addView(otherView2);
        constraintLayout.addView(otherView3);
        constraintLayout.addView(otherView4);
        constraintLayout.addView(otherView5);

        TextView textView3 = otherView1.findViewById(R.id.storyTitle);
        TextView textView4 = otherView1.findViewById(R.id.author);
        ImageView storyImage = otherView1.findViewById(R.id.storyImg);
        Button addButton = otherView1.findViewById(R.id.add_buttton);
        Button removeButton = otherView1.findViewById(R.id.remove_button);
        RecyclerView recyclerView = otherView2.findViewById(R.id.recyclerview);
        ImageView sceneImage = otherView3.findViewById(R.id.sceneImg);
        TextView sceneText = otherView3.findViewById(R.id.sceneText);
        ViewPager viewPager = otherView4.findViewById(R.id.viewpager);
        TextView textview_scenes_count = otherView4.findViewById(R.id.textview_scenes_count);
        TextView textviewListen = otherView4.findViewById(R.id.textview);
        TextView player_position = otherView4.findViewById(R.id.player_position);
        SeekBar seek_bar = otherView4.findViewById(R.id.seek_bar);
        TextView player_duration = otherView4.findViewById(R.id.player_duration);
        ImageView bt_rew = otherView4.findViewById(R.id.bt_rew);
        ImageView bt_play = otherView4.findViewById(R.id.bt_play);
        ImageView bt_pause = otherView4.findViewById(R.id.bt_pause);
        ImageView bt_ff = otherView4.findViewById(R.id.bt_ff);
        TextView emptyFavoritesText = otherView5.findViewById(R.id.emptyFavoritesText);


        // Obtenir la largeur de l'écran
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;

        if (screenWidth > 600) {
            // Définir Margins pour les appareils plus grands
            ViewGroup.MarginLayoutParams params1 = (ViewGroup.MarginLayoutParams) textView1.getLayoutParams();
            params1.setMargins(32, 32, 32, 32);
            textView1.setLayoutParams(params1);

            ViewGroup.MarginLayoutParams params2 = (ViewGroup.MarginLayoutParams) textView2.getLayoutParams();
            params2.setMargins(32, 32, 32, 32);
            textView1.setLayoutParams(params2);

            ViewGroup.MarginLayoutParams params3 = (ViewGroup.MarginLayoutParams) button.getLayoutParams();
            params3.setMargins(32, 32, 32, 32);
            textView1.setLayoutParams(params3);

            ViewGroup.MarginLayoutParams params4 = (ViewGroup.MarginLayoutParams) textView3.getLayoutParams();
            params4.setMargins(32, 32, 32, 32);
            textView1.setLayoutParams(params4);

            ViewGroup.MarginLayoutParams params5 = (ViewGroup.MarginLayoutParams) textView4.getLayoutParams();
            params5.setMargins(32, 32, 32, 32);
            textView1.setLayoutParams(params5);

            ViewGroup.MarginLayoutParams params6 = (ViewGroup.MarginLayoutParams) storyImage.getLayoutParams();
            params6.setMargins(32, 32, 32, 32);
            textView1.setLayoutParams(params6);

            ViewGroup.MarginLayoutParams params7 = (ViewGroup.MarginLayoutParams) recyclerView.getLayoutParams();
            params7.setMargins(32, 32, 32, 32);
            recyclerView.setLayoutParams(params7);

            ViewGroup.MarginLayoutParams params8 = (ViewGroup.MarginLayoutParams) addButton.getLayoutParams();
            params8.setMargins(32, 32, 32, 32);
            addButton.setLayoutParams(params8);

            ViewGroup.MarginLayoutParams params9 = (ViewGroup.MarginLayoutParams) removeButton.getLayoutParams();
            params9.setMargins(32, 32, 32, 32);
            removeButton.setLayoutParams(params9);

            ViewGroup.MarginLayoutParams params10 = (ViewGroup.MarginLayoutParams) sceneImage.getLayoutParams();
            params10.setMargins(32, 32, 32, 32);
            sceneImage.setLayoutParams(params10);

            ViewGroup.MarginLayoutParams params11 = (ViewGroup.MarginLayoutParams) sceneText.getLayoutParams();
            params11.setMargins(32, 32, 32, 32);
            sceneText.setLayoutParams(params11);

            ViewGroup.MarginLayoutParams params12 = (ViewGroup.MarginLayoutParams) emptyFavoritesText.getLayoutParams();
            params12.setMargins(32, 32, 32, 32);
            emptyFavoritesText.setLayoutParams(params12);

            ViewGroup.MarginLayoutParams params13 = (ViewGroup.MarginLayoutParams) viewPager.getLayoutParams();
            params13.setMargins(32, 32, 32, 32);
            viewPager.setLayoutParams(params13);

            ViewGroup.MarginLayoutParams params14 = (ViewGroup.MarginLayoutParams) textview_scenes_count.getLayoutParams();
            params14.setMargins(32, 32, 32, 32);
            textview_scenes_count.setLayoutParams(params14);

            ViewGroup.MarginLayoutParams params15 = (ViewGroup.MarginLayoutParams) textviewListen.getLayoutParams();
            params15.setMargins(32, 32, 32, 32);
            textviewListen.setLayoutParams(params15);

            ViewGroup.MarginLayoutParams params16 = (ViewGroup.MarginLayoutParams) player_position.getLayoutParams();
            params16.setMargins(32, 32, 32, 32);
            player_position.setLayoutParams(params16);

            ViewGroup.MarginLayoutParams params17 = (ViewGroup.MarginLayoutParams) player_duration.getLayoutParams();
            params17.setMargins(32, 32, 32, 32);
            player_duration.setLayoutParams(params17);

            ViewGroup.MarginLayoutParams params18 = (ViewGroup.MarginLayoutParams) seek_bar.getLayoutParams();
            params18.setMargins(32, 32, 32, 32);
            seek_bar.setLayoutParams(params18);

            ViewGroup.MarginLayoutParams params19 = (ViewGroup.MarginLayoutParams) bt_rew.getLayoutParams();
            params19.setMargins(32, 32, 32, 32);
            bt_rew.setLayoutParams(params19);

            ViewGroup.MarginLayoutParams params20 = (ViewGroup.MarginLayoutParams) bt_play.getLayoutParams();
            params20.setMargins(32, 32, 32, 32);
            bt_play.setLayoutParams(params20);

            ViewGroup.MarginLayoutParams params21 = (ViewGroup.MarginLayoutParams) bt_pause.getLayoutParams();
            params21.setMargins(32, 32, 32, 32);
            bt_pause.setLayoutParams(params21);

            ViewGroup.MarginLayoutParams params22 = (ViewGroup.MarginLayoutParams) bt_ff.getLayoutParams();
            params22.setMargins(32, 32, 32, 32);
            bt_ff.setLayoutParams(params22);



        } else {
            // Définir Margins pour les petits appareils
            ViewGroup.MarginLayoutParams params1 = (ViewGroup.MarginLayoutParams) textView1.getLayoutParams();
            params1.setMargins(16, 16, 16, 16);
            textView1.setLayoutParams(params1);

            ViewGroup.MarginLayoutParams params2 = (ViewGroup.MarginLayoutParams) textView2.getLayoutParams();
            params2.setMargins(16, 16, 16, 16);
            textView1.setLayoutParams(params2);

            ViewGroup.MarginLayoutParams params3 = (ViewGroup.MarginLayoutParams) button.getLayoutParams();
            params3.setMargins(16, 16, 16, 16);
            textView1.setLayoutParams(params3);

            ViewGroup.MarginLayoutParams params4 = (ViewGroup.MarginLayoutParams) textView3.getLayoutParams();
            params4.setMargins(16, 16, 16, 16);
            textView1.setLayoutParams(params4);

            ViewGroup.MarginLayoutParams params5 = (ViewGroup.MarginLayoutParams) textView4.getLayoutParams();
            params5.setMargins(16, 16, 16, 16);
            textView1.setLayoutParams(params5);

            ViewGroup.MarginLayoutParams params6 = (ViewGroup.MarginLayoutParams) storyImage.getLayoutParams();
            params6.setMargins(16, 16, 16, 16);
            textView1.setLayoutParams(params6);

            ViewGroup.MarginLayoutParams params7 = (ViewGroup.MarginLayoutParams) recyclerView.getLayoutParams();
            params7.setMargins(16, 16, 16, 16);
            textView4.setLayoutParams(params7);

            ViewGroup.MarginLayoutParams params8 = (ViewGroup.MarginLayoutParams) addButton.getLayoutParams();
            params8.setMargins(16, 16, 16, 16);
            addButton.setLayoutParams(params8);

            ViewGroup.MarginLayoutParams params9 = (ViewGroup.MarginLayoutParams) removeButton.getLayoutParams();
            params9.setMargins(16, 16, 16, 16);
            removeButton.setLayoutParams(params9);

            ViewGroup.MarginLayoutParams params10 = (ViewGroup.MarginLayoutParams) sceneImage.getLayoutParams();
            params10.setMargins(16, 16, 16, 16);
            sceneImage.setLayoutParams(params10);

            ViewGroup.MarginLayoutParams params11 = (ViewGroup.MarginLayoutParams) sceneText.getLayoutParams();
            params11.setMargins(16, 16, 16, 16);
            sceneText.setLayoutParams(params11);

            ViewGroup.MarginLayoutParams params12 = (ViewGroup.MarginLayoutParams) emptyFavoritesText.getLayoutParams();
            params12.setMargins(16, 16, 16, 16);
            emptyFavoritesText.setLayoutParams(params12);

            ViewGroup.MarginLayoutParams params13 = (ViewGroup.MarginLayoutParams) viewPager.getLayoutParams();
            params13.setMargins(16, 16, 16, 16);
            viewPager.setLayoutParams(params13);

            ViewGroup.MarginLayoutParams params14 = (ViewGroup.MarginLayoutParams) textview_scenes_count.getLayoutParams();
            params14.setMargins(16, 16, 16, 16);
            textview_scenes_count.setLayoutParams(params14);

            ViewGroup.MarginLayoutParams params15 = (ViewGroup.MarginLayoutParams) textviewListen.getLayoutParams();
            params15.setMargins(16, 16, 16, 16);
            textviewListen.setLayoutParams(params15);

            ViewGroup.MarginLayoutParams params16 = (ViewGroup.MarginLayoutParams) player_position.getLayoutParams();
            params16.setMargins(16, 16, 16, 16);
            player_position.setLayoutParams(params16);

            ViewGroup.MarginLayoutParams params17 = (ViewGroup.MarginLayoutParams) player_duration.getLayoutParams();
            params17.setMargins(16, 16, 16, 16);
            player_duration.setLayoutParams(params17);

            ViewGroup.MarginLayoutParams params18 = (ViewGroup.MarginLayoutParams) seek_bar.getLayoutParams();
            params18.setMargins(16, 16, 16, 16);
            seek_bar.setLayoutParams(params18);

            ViewGroup.MarginLayoutParams params19 = (ViewGroup.MarginLayoutParams) bt_rew.getLayoutParams();
            params19.setMargins(16, 16, 16, 16);
            bt_rew.setLayoutParams(params19);

            ViewGroup.MarginLayoutParams params20 = (ViewGroup.MarginLayoutParams) bt_play.getLayoutParams();
            params20.setMargins(16, 16, 16, 16);
            bt_play.setLayoutParams(params20);

            ViewGroup.MarginLayoutParams params21 = (ViewGroup.MarginLayoutParams) bt_pause.getLayoutParams();
            params21.setMargins(16, 16, 16, 16);
            bt_pause.setLayoutParams(params21);

            ViewGroup.MarginLayoutParams params22 = (ViewGroup.MarginLayoutParams) bt_ff.getLayoutParams();
            params22.setMargins(16, 16, 16, 16);
            bt_ff.setLayoutParams(params22);

        }
    }
}
