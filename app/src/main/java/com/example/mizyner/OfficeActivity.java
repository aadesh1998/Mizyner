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

public class OfficeActivity extends AppCompatActivity implements View.OnClickListener {
        @BindView(R.id.carpet)
    ImageView carpet;
        @BindView(R.id.chair)
    ImageView chair;
    @BindView(R.id.laptop)
    ImageView laptop;
    @BindView(R.id.desk)
    ImageView desk;
    @BindView(R.id.couchTable)
    ImageView couchTable;
    @BindView(R.id.sofa)
    ImageView sofa;
    @BindView(R.id.plant1)
    ImageView plant1;
    @BindView(R.id.plant2)
    ImageView plant2;
    @BindView(R.id.lamp)
    ImageView lamp;
    @BindView(R.id.switches)
    ImageView switches;
    @BindView(R.id.windowcurtain)
    ImageView windowcurtain;
    @BindView(R.id.tv)
    ImageView tv;
    @BindView(R.id.saveButton)
    TextView saveButton;

    View arrayView[];
    ViewRenderable name_object;
  //  public static ArrayList<String> selectedMain = new ArrayList<>();
    int selected = 1;
        private ArFragment arFragment;
    private ModelRenderable carpetRenderable,
            chairRenderable,
            laptopRenderable,
            deskRenderable,
            couchTableRenderable,
            sofaRenderable,
            plant1Renderable,
            plant2Renderable,
            lampRenderable,
            switchesRenderable,
            curtainrenderable,
            tvRenderable;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_office);
        ButterKnife.bind(this);
        arFragment= (ArFragment) getSupportFragmentManager().findFragmentById(R.id.arFragment);


        setArrayView();

        setClickListener();
        setupModel();


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(selectedMain.size() == 0){

                    Toast.makeText(OfficeActivity.this, "Please select atleast one", Toast.LENGTH_SHORT).show();
                }else{
                    startActivity(new Intent(getApplicationContext(),SelectedItemActivity.class));
                }


            }
        });


        arFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {

            Anchor anchor = hitResult.createAnchor();
            AnchorNode anchorNode = new AnchorNode(anchor);
            anchorNode.setParent(arFragment.getArSceneView().getScene());

            createModel(anchorNode,selected);
        });
    }


    private void setClickListener() {
        for (View view : arrayView) view.setOnClickListener(this);
    }

    private void setArrayView() {
        arrayView = new View[]{
                carpet,chair,laptop,desk, couchTable, sofa, plant1, plant2, lamp, switches, windowcurtain, tv
        };
    }

    @Override
    public void onClick(View view) {

        if (view.getId()== R.id.carpet){
            selected = 1;
            selectedMain.add("carpet");
            setBackground(view.getId());
        } else if (view.getId()== R.id.chair){
            selected = 2;
            selectedMain.add("chair");
            setBackground(view.getId());
        }
        else if (view.getId()== R.id.laptop){
            selected = 3;
            selectedMain.add("laptop");
            setBackground(view.getId());
        }
        else if (view.getId()== R.id.desk){
            selected = 4;
            selectedMain.add("desk");
            setBackground(view.getId());
        }
        else if (view.getId()== R.id.couchTable){
            selected = 5;
            selectedMain.add("couchTable");
            setBackground(view.getId());
        }
        else if (view.getId()== R.id.sofa){
            selected = 6;
            selectedMain.add("sofa");
            setBackground(view.getId());
        }
        else if (view.getId()== R.id.plant1){
            selected = 7;
            selectedMain.add("plant1");
            setBackground(view.getId());
        }
        else if (view.getId()== R.id.plant2){
            selected = 8;
            selectedMain.add("plant2");
            setBackground(view.getId());
        }
        else if (view.getId()== R.id.lamp){
            selected = 9;
            selectedMain.add("lamp");
            setBackground(view.getId());
        }
        else if (view.getId()== R.id.switches){
            selected = 10;
            selectedMain.add("switches");
            setBackground(view.getId());
        }
        else if (view.getId()== R.id.windowcurtain){
            selected = 11;
            selectedMain.add("windowcurtain");
            setBackground(view.getId());
        }
        else if (view.getId()== R.id.tv){
            selected = 12;
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
                .setSource(this, R.raw.office_chair)
                .build().thenAccept(renderable -> chairRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load chair Model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.laptop)
                .build().thenAccept(renderable -> laptopRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load laptop Model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.desk)
                .build().thenAccept(renderable -> deskRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load desk Model", Toast.LENGTH_SHORT).show();
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
            TransformableNode chair = new TransformableNode(arFragment.getTransformationSystem());
            chair.setParent(anchorNode);
            chair.setRenderable(chairRenderable);
            chair.select();

            addName(anchorNode, chair, "Chair");
        }
        if (selected==3){
            TransformableNode laptop = new TransformableNode(arFragment.getTransformationSystem());
            laptop.setParent(anchorNode);
            laptop.setRenderable(laptopRenderable);
            laptop.select();

            addName(anchorNode, laptop, "Laptop");
        }

        if (selected==4){
            TransformableNode desk = new TransformableNode(arFragment.getTransformationSystem());
            desk.setParent(anchorNode);
            desk.setRenderable(couchTableRenderable);
            desk.select();

            addName(anchorNode, desk, "Desk");
        }
        if (selected==5){
            TransformableNode carpet = new TransformableNode(arFragment.getTransformationSystem());
            carpet.setParent(anchorNode);
            carpet.setRenderable(couchTableRenderable);
            carpet.select();

            addName(anchorNode, carpet, "Table");
        }
        if (selected==6){
            TransformableNode carpet = new TransformableNode(arFragment.getTransformationSystem());
            carpet.setParent(anchorNode);
            carpet.setRenderable(sofaRenderable);
            carpet.select();

            addName(anchorNode, carpet, "Sofa");
        }
        if (selected==7){
            TransformableNode carpet = new TransformableNode(arFragment.getTransformationSystem());
            carpet.setParent(anchorNode);
            carpet.setRenderable(plant1Renderable);
            carpet.select();

            addName(anchorNode, carpet, "Plant 1");
        }
        if (selected==8){
            TransformableNode carpet = new TransformableNode(arFragment.getTransformationSystem());
            carpet.setParent(anchorNode);
            carpet.setRenderable(plant2Renderable);
            carpet.select();

            addName(anchorNode, carpet, "Plant 2");
        }
        if (selected==9){
            TransformableNode carpet = new TransformableNode(arFragment.getTransformationSystem());
            carpet.setParent(anchorNode);
            carpet.setRenderable(lampRenderable);
            carpet.select();

            addName(anchorNode, carpet, "Lamp");
        }
        if (selected==10){
            TransformableNode carpet = new TransformableNode(arFragment.getTransformationSystem());
            carpet.setParent(anchorNode);
            carpet.setRenderable(switchesRenderable);
            carpet.select();

            addName(anchorNode, carpet, "Switches");
        }
        if (selected==11){
            TransformableNode carpet = new TransformableNode(arFragment.getTransformationSystem());
            carpet.setParent(anchorNode);
            carpet.setRenderable(curtainrenderable);
            carpet.select();

            addName(anchorNode, carpet, "Curtains");
        }
        if (selected==12){
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


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(OfficeActivity.this, HomeActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        finish();
    }


}
