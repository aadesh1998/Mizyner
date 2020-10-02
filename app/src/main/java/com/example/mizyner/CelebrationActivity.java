package com.example.mizyner;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.ar.core.Anchor;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.mizyner.MainActivity.selectedMain;

public class CelebrationActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.carpet)
    ImageView carpet;
    @BindView(R.id.balloon)
    ImageView balloon;
    @BindView(R.id.christmas)
    ImageView christmas;
    @BindView(R.id.sofa)
    ImageView sofa;
    @BindView(R.id.plant1)
    ImageView plant1;
    @BindView(R.id.plant2)
    ImageView plant2;
    @BindView(R.id.saveButton)
    TextView saveButton;
    View arrayView[];
   // public static ArrayList<String> selectedMain = new ArrayList<>();

    int selected = 1;
    private ModelRenderable carpetRenderable,
            balloonRenderable,
            christmasRenderable,
            sofaRenderable,
            plant1Renderable,
            plant2Renderable;

    private ArFragment arFragment;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celebration);
        ButterKnife.bind(this);
        arFragment= (ArFragment) getSupportFragmentManager().findFragmentById(R.id.arFragment);
        arrayView = new View[]{
                carpet,balloon,christmas, sofa, plant1, plant2
        };


        setupModel();
        setClickListener();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(selectedMain.size() == 0){

                    Toast.makeText(CelebrationActivity.this, "Please select atleast one", Toast.LENGTH_SHORT).show();
                }else{
                    startActivity(new Intent(getApplicationContext(),SelectedItemActivity.class));
                }


            }
        });

        arFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {
           // Anchor anchor=hitResult.createAnchor();
            Anchor anchor = hitResult.createAnchor();
            AnchorNode anchorNode = new AnchorNode(anchor);
            anchorNode.setParent(arFragment.getArSceneView().getScene());
            createModel(anchorNode,selected);

        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void createModel(AnchorNode anchorNode, int selected) {
        if (selected==1){
            TransformableNode carpet = new TransformableNode(arFragment.getTransformationSystem());
            carpet.setParent(anchorNode);
            carpet.setRenderable(carpetRenderable);
            carpet.select();

            addName(anchorNode, carpet, "Carpet");
        }
        if (selected==2){
            TransformableNode balloon = new TransformableNode(arFragment.getTransformationSystem());
            balloon.setParent(anchorNode);
            balloon.setRenderable(balloonRenderable);
            balloon.select();

            addName(anchorNode, balloon, "Balloon");
        }
        if (selected==3){
            TransformableNode christmas = new TransformableNode(arFragment.getTransformationSystem());
            christmas.setParent(anchorNode);
            christmas.setRenderable(christmasRenderable);
            christmas.select();

            addName(anchorNode, christmas, "Christmas");
        }

        if (selected==4){
            TransformableNode carpet = new TransformableNode(arFragment.getTransformationSystem());
            carpet.setParent(anchorNode);
            carpet.setRenderable(sofaRenderable);
            carpet.select();

            addName(anchorNode, carpet, "Sofa");
        }
        if (selected==5){
            TransformableNode carpet = new TransformableNode(arFragment.getTransformationSystem());
            carpet.setParent(anchorNode);
            carpet.setRenderable(plant1Renderable);
            carpet.select();

            addName(anchorNode, carpet, "Plant 1");
        }
        if (selected==6){
            TransformableNode carpet = new TransformableNode(arFragment.getTransformationSystem());
            carpet.setParent(anchorNode);
            carpet.setRenderable(plant2Renderable);
            carpet.select();

            addName(anchorNode, carpet, "Plant 2");
        }

    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    private void addName(AnchorNode anchorNode, TransformableNode model, String name){

        ViewRenderable.builder()
                .setView(this,R.layout.name_object)
                .build()
                .thenAccept(viewRenderable -> {

                    TransformableNode nameView = new TransformableNode(arFragment.getTransformationSystem());
                    nameView.setLocalPosition(new Vector3(0f,model.getLocalPosition().y+0.5f,0));
                    nameView.setParent(anchorNode);
                    nameView.setRenderable(viewRenderable);
                    nameView.select();

                    TextView txt_name = (TextView)viewRenderable.getView();
                    txt_name.setText(name);

                    txt_name.setOnClickListener(view -> anchorNode.setParent(null));
                });




    }


    private void setClickListener() {
        for (int i=0; i<arrayView.length;i++)
            arrayView[i].setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view.getId()== R.id.carpet){
            selected = 1;
            selectedMain.add("carpet");
            setBackground(view.getId());
        } else if (view.getId()== R.id.balloon){
            selected = 2;
            selectedMain.add("balloon");
            setBackground(view.getId());
        }
        else if (view.getId()== R.id.christmas){
            selected = 3;
            selectedMain.add("christmas");
            setBackground(view.getId());
        }
        else if (view.getId()== R.id.sofa){
            selected = 4;
            selectedMain.add("sofa");

            setBackground(view.getId());
        }
        else if (view.getId()== R.id.plant1){
            selected = 5;
            selectedMain.add("plant1");

            setBackground(view.getId());
        }
        else if (view.getId()== R.id.plant2){
            selected = 6;
            selectedMain.add("plant2");

            setBackground(view.getId());
        }
    }

    private void setBackground(int id) {
        for (int i=0; i<arrayView.length;i++){
            if (arrayView[i].getId()==id)
                arrayView[i].setBackgroundColor(0xFF00FF00);
            else
                arrayView[i].setBackgroundColor(0x80333639);
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setupModel() {

        ModelRenderable.builder()
                .setSource(this, R.raw.carpet)
                .build().thenAccept(renderable -> carpetRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load Carpet Model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.balloon)
                .build().thenAccept(renderable -> balloonRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load balloon Model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );


        ModelRenderable.builder()
                .setSource(this, R.raw.christmas_tree)
                .build().thenAccept(renderable -> christmasRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load christmas Model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.sofa2)
                .build().thenAccept(renderable -> sofaRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load Sofa Model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this, R.raw.plant1)
                .build().thenAccept(renderable -> plant1Renderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load Plant1 Model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this, R.raw.plant2)
                .build().thenAccept(renderable -> plant2Renderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load Plant2 Model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(CelebrationActivity.this, HomeActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        finish();
    }


}
