package com.example.mizyner;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ArFragment arFragment;
    private ModelRenderable carpetRenderable,
                            couchTableRenderable,
                            sofaRenderable,
                            plant1Renderable,
                            plant2Renderable,
                            lampRenderable,
                            switchesRenderable,
                            curtainrenderable,
                            tvRenderable;
    ImageView carpet, couchTable, sofa, plant1, plant2, lamp, switches, windowcurtain, tv;
    View arrayView[];
    ViewRenderable name_object;
    int selected = 1;
  public static ArrayList<String> selectedMain = new ArrayList<>();
    TextView saveButton;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arFragment= (ArFragment) getSupportFragmentManager().findFragmentById(R.id.arFragment);
        saveButton = findViewById(R.id.saveButton);
        carpet = (ImageView)findViewById(R.id.carpet);
        couchTable = (ImageView)findViewById(R.id.couchTable);
        sofa = (ImageView)findViewById(R.id.sofa);
        plant1 = (ImageView)findViewById(R.id.plant1);
        plant2 = (ImageView)findViewById(R.id.plant2);
        lamp = (ImageView)findViewById(R.id.lamp);
        switches = (ImageView)findViewById(R.id.switches);
        windowcurtain = (ImageView)findViewById(R.id.windowcurtain);
        tv = (ImageView)findViewById(R.id.tv);

        setArrayView();

        setClickListener();
        setupModel();

        arFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {

                Anchor anchor = hitResult.createAnchor();
                AnchorNode anchorNode = new AnchorNode(anchor);
                anchorNode.setParent(arFragment.getArSceneView().getScene());

                createModel(anchorNode,selected);

        });


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(selectedMain.size() == 0){

                    Toast.makeText(MainActivity.this, "Please select atleast one", Toast.LENGTH_SHORT).show();
                }else{
                    startActivity(new Intent(getApplicationContext(),SelectedItemActivity.class));
                }


            }
        });
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
                .setSource(this, R.raw.couchtable)
                .build().thenAccept(renderable -> couchTableRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load Couch Model", Toast.LENGTH_SHORT).show();
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
        ModelRenderable.builder()
                .setSource(this, R.raw.lamp)
                .build().thenAccept(renderable -> lampRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load Lamp Model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this, R.raw.double_switch_whites)
                .build().thenAccept(renderable -> switchesRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load Switch Model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this, R.raw.curtain)
                .build().thenAccept(renderable -> curtainrenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load Curtain Model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this, R.raw.wall_flat_tv)
                .build().thenAccept(renderable -> tvRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load TV Model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
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
            TransformableNode carpet = new TransformableNode(arFragment.getTransformationSystem());
            carpet.setParent(anchorNode);
            carpet.setRenderable(couchTableRenderable);
            carpet.select();

            addName(anchorNode, carpet, "Table");
        }
        if (selected==3){
            TransformableNode carpet = new TransformableNode(arFragment.getTransformationSystem());
            carpet.setParent(anchorNode);
            carpet.setRenderable(sofaRenderable);
            carpet.select();

            addName(anchorNode, carpet, "Sofa");
        }
        if (selected==4){
            TransformableNode carpet = new TransformableNode(arFragment.getTransformationSystem());
            carpet.setParent(anchorNode);
            carpet.setRenderable(plant1Renderable);
            carpet.select();

            addName(anchorNode, carpet, "Plant 1");
        }
        if (selected==5){
            TransformableNode carpet = new TransformableNode(arFragment.getTransformationSystem());
            carpet.setParent(anchorNode);
            carpet.setRenderable(plant2Renderable);
            carpet.select();

            addName(anchorNode, carpet, "Plant 2");
        }
        if (selected==6){
            TransformableNode carpet = new TransformableNode(arFragment.getTransformationSystem());
            carpet.setParent(anchorNode);
            carpet.setRenderable(lampRenderable);
            carpet.select();

            addName(anchorNode, carpet, "Lamp");
        }
        if (selected==7){
            TransformableNode carpet = new TransformableNode(arFragment.getTransformationSystem());
            carpet.setParent(anchorNode);
            carpet.setRenderable(switchesRenderable);
            carpet.select();

            addName(anchorNode, carpet, "Switches");
        }
        if (selected==8){
            TransformableNode carpet = new TransformableNode(arFragment.getTransformationSystem());
            carpet.setParent(anchorNode);
            carpet.setRenderable(curtainrenderable);
            carpet.select();

            addName(anchorNode, carpet, "Curtains");
        }
        if (selected==9){
            TransformableNode carpet = new TransformableNode(arFragment.getTransformationSystem());
            carpet.setParent(anchorNode);
            carpet.setRenderable(tvRenderable);
            carpet.select();

            addName(anchorNode, carpet, "TV");
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

    private void setArrayView() {
        arrayView = new View[]{
                carpet, couchTable, sofa, plant1, plant2, lamp, switches, windowcurtain, tv
        };
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(MainActivity.this, HomeActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        finish();
    }

    @Override
    public void onClick(View view) {

        if (view.getId()==R.id.carpet){
            selected = 1;
            selectedMain.add("carpet");
            setBackground(view.getId());
        }
        else if (view.getId()==R.id.couchTable){
            selected = 2;
            selectedMain.add("couchTable");
            setBackground(view.getId());
        }
        else if (view.getId()==R.id.sofa){
            selected = 3;
            selectedMain.add("sofa");
            setBackground(view.getId());
        }
        else if (view.getId()==R.id.plant1){
            selected = 4;
            selectedMain.add("plant1");
            setBackground(view.getId());
        }
        else if (view.getId()==R.id.plant2){
            selected = 5;
            selectedMain.add("plant2");
            setBackground(view.getId());
        }
        else if (view.getId()==R.id.lamp){
            selected = 6;
            selectedMain.add("lamp");
            setBackground(view.getId());
        }
        else if (view.getId()==R.id.switches){
            selected = 7;
            selectedMain.add("switches");
            setBackground(view.getId());
        }
        else if (view.getId()==R.id.windowcurtain){
            selected = 8;
            selectedMain.add("windowcurtain");
            setBackground(view.getId());
        }
        else if (view.getId()==R.id.tv){
            selected = 9;
            selectedMain.add("tv");
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
}
