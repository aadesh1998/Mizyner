package com.example.mizyner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.mizyner.MainActivity.selectedMain;

public class SelectedItemActivity extends AppCompatActivity {

    @BindView(R.id.backImage)
    ImageView backImage;
    @BindView(R.id.carpetRl)
    RelativeLayout carpetRl;
    @BindView(R.id.carpetName)
    TextView carpetName;
    @BindView(R.id.carpetBuy)
    TextView carpetBuy;
    @BindView(R.id.couchTable)
    RelativeLayout couchTable;
    @BindView(R.id.couchTableName)
    TextView couchTableName;
    @BindView(R.id.couchTableBuy)
    TextView couchTableBuy;
    @BindView(R.id.sofa)
    RelativeLayout sofa;
    @BindView(R.id.sofaName)
    TextView sofaName;
    @BindView(R.id.sofaBuy)
    TextView sofaBuy;
    @BindView(R.id.plant1)
    RelativeLayout plant1;
    @BindView(R.id.plant1Name)
    TextView plant1Name;
    @BindView(R.id.plant1Buy)
    TextView plant1Buy;
    @BindView(R.id.plant2)
    RelativeLayout plant2;
    @BindView(R.id.plant2Name)
    TextView plant2Name;
    @BindView(R.id.plant2Buy)
    TextView plant2Buy;
    @BindView(R.id.lamp)
    RelativeLayout lamp;
    @BindView(R.id.lampName)
    TextView lampName;
    @BindView(R.id.lampBuy)
    TextView lampBuy;
    @BindView(R.id.switches)
    RelativeLayout switches;
    @BindView(R.id.switchesName)
    TextView switchesName;
    @BindView(R.id.switchesBuy)
    TextView switchesBuy;
    @BindView(R.id.windowcurtain)
    RelativeLayout windowcurtain;
    @BindView(R.id.windowcurtainName)
    TextView windowcurtainName;
    @BindView(R.id.windowcurtainBuy)
    TextView windowcurtainBuy;
    @BindView(R.id.tv)
    RelativeLayout tv;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvBuy)
    TextView tvBuy;
    @BindView(R.id.balloon)
    RelativeLayout balloon;
    @BindView(R.id.balloonName)
    TextView balloonName;
    @BindView(R.id.balloonBuy)
    TextView balloonBuy;
    @BindView(R.id.christmas)
    RelativeLayout christmas;
    @BindView(R.id.christmasName)
    TextView christmasName;
    @BindView(R.id.christmasBuy)
    TextView christmasBuy;
    @BindView(R.id.chair)
    RelativeLayout chair;
    @BindView(R.id.chairName)
    TextView chairName;
    @BindView(R.id.chairBuy)
    TextView chairBuy;
    @BindView(R.id.laptop)
    RelativeLayout laptop;
    @BindView(R.id.laptopName)
    TextView laptopName;
    @BindView(R.id.laptopBuy)
    TextView laptopBuy;
    @BindView(R.id.desk)
    RelativeLayout desk;
    @BindView(R.id.deskName)
    TextView deskName;
    @BindView(R.id.deskBuy)
    TextView deskBuy;

  //    balloon,christmas
    //  chair,laptop,desk

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_item);
        ButterKnife.bind(this);

        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        for(int i=0;i<selectedMain.size();i++){
            Log.d("selected item", "onCreate: "+selectedMain.get(i));
            if(selectedMain.get(i).equals("carpet")){
                carpetRl.setVisibility(View.VISIBLE);
                carpetName.setText("carpet");
                carpetBuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String url = "https://www.flipkart.com/search?q=carpet&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off";
                        try {
                            Intent i = new Intent("android.intent.action.MAIN");
                            i.setComponent(ComponentName.unflattenFromString("com.android.chrome/com.android.chrome.Main"));
                            i.addCategory("android.intent.category.LAUNCHER");
                            i.setData(Uri.parse(url));
                            startActivity(i);
                        }
                        catch(ActivityNotFoundException e) {
                            // Chrome is not installed
                            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(i);
                        }
                        carpetRl.setVisibility(View.GONE);
                    }
                });
            }else if(selectedMain.get(i).equals("couchTable")){
                couchTable.setVisibility(View.VISIBLE);
                couchTableName.setText("couch table");
                couchTableBuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String url = "https://www.flipkart.com/search?q=couch%20table&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off";
                        try {
                            Intent i = new Intent("android.intent.action.MAIN");
                            i.setComponent(ComponentName.unflattenFromString("com.android.chrome/com.android.chrome.Main"));
                            i.addCategory("android.intent.category.LAUNCHER");
                            i.setData(Uri.parse(url));
                            startActivity(i);
                        }
                        catch(ActivityNotFoundException e) {
                            // Chrome is not installed
                            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(i);
                        }
                        couchTable.setVisibility(View.GONE);
                    }
                });
            }else if(selectedMain.get(i).equals("sofa")){
                sofa.setVisibility(View.VISIBLE);
                sofaName.setText("sofa");
                sofaBuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String url = "https://www.flipkart.com/search?q=sofa&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off";
                        try {
                            Intent i = new Intent("android.intent.action.MAIN");
                            i.setComponent(ComponentName.unflattenFromString("com.android.chrome/com.android.chrome.Main"));
                            i.addCategory("android.intent.category.LAUNCHER");
                            i.setData(Uri.parse(url));
                            startActivity(i);
                        }
                        catch(ActivityNotFoundException e) {
                            // Chrome is not installed
                            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(i);
                        }
                        sofa.setVisibility(View.GONE
                        );
                    }
                });
            }else if(selectedMain.get(i).equals("plant1")){
                plant1.setVisibility(View.VISIBLE);
                plant1Name.setText("plant1");
                plant1Buy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String url = "https://www.flipkart.com/search?q=plant%20&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off";
                        try {
                            Intent i = new Intent("android.intent.action.MAIN");
                            i.setComponent(ComponentName.unflattenFromString("com.android.chrome/com.android.chrome.Main"));
                            i.addCategory("android.intent.category.LAUNCHER");
                            i.setData(Uri.parse(url));
                            startActivity(i);
                        }
                        catch(ActivityNotFoundException e) {
                            // Chrome is not installed
                            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(i);
                        }
                        plant1.setVisibility(View.GONE);
                    }
                });
            }else if(selectedMain.get(i).equals("plant2")){
                plant2.setVisibility(View.VISIBLE);
                plant2Name.setText("plant2");
                plant2Buy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String url = "https://www.flipkart.com/search?q=plant%20&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off";
                        try {
                            Intent i = new Intent("android.intent.action.MAIN");
                            i.setComponent(ComponentName.unflattenFromString("com.android.chrome/com.android.chrome.Main"));
                            i.addCategory("android.intent.category.LAUNCHER");
                            i.setData(Uri.parse(url));
                            startActivity(i);
                        }
                        catch(ActivityNotFoundException e) {
                            // Chrome is not installed
                            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(i);
                        }
                        plant2.setVisibility(View.GONE);
                    }
                });
            }else if(selectedMain.get(i).equals("lamp")){
                lamp.setVisibility(View.VISIBLE);
                lampName.setText("lamp");
                lampBuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String url = "https://www.flipkart.com/search?q=lamp&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off";
                        try {
                            Intent i = new Intent("android.intent.action.MAIN");
                            i.setComponent(ComponentName.unflattenFromString("com.android.chrome/com.android.chrome.Main"));
                            i.addCategory("android.intent.category.LAUNCHER");
                            i.setData(Uri.parse(url));
                            startActivity(i);
                        }
                        catch(ActivityNotFoundException e) {
                            // Chrome is not installed
                            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(i);
                        }
                        lamp.setVisibility(View.GONE);
                    }
                });
            }else if(selectedMain.get(i).equals("switches")){
                switches.setVisibility(View.VISIBLE);
                switchesName.setText("switches");
                switchesBuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String url = "https://www.flipkart.com/search?q=switch&sid=b8s%2Cprq%2Cwcx&as=on&as-show=on&otracker=AS_QueryStore_HistoryAutoSuggest_0_6_na_na_na&otracker1=AS_QueryStore_HistoryAutoSuggest_0_6_na_na_na&as-pos=0&as-type=HISTORY&suggestionId=switch%7Cin+Electrical+Switches&requestId=3854f80a-539a-4daf-aff3-720a6408f49c&as-searchtext=switch";
                        try {
                            Intent i = new Intent("android.intent.action.MAIN");
                            i.setComponent(ComponentName.unflattenFromString("com.android.chrome/com.android.chrome.Main"));
                            i.addCategory("android.intent.category.LAUNCHER");
                            i.setData(Uri.parse(url));
                            startActivity(i);
                        }
                        catch(ActivityNotFoundException e) {
                            // Chrome is not installed
                            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(i);
                        }
                        switches.setVisibility(View.GONE);
                    }
                });
            }else if(selectedMain.get(i).equals("windowcurtain")){
                windowcurtain.setVisibility(View.VISIBLE);
                windowcurtainName.setText("windowcurtain");
                windowcurtainBuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String url = "https://www.flipkart.com/search?q=window+curtains&sid=jra%2Csl5%2C2va&as=on&as-show=on&otracker=AS_QueryStore_OrganicAutoSuggest_0_7_na_na_pr&otracker1=AS_QueryStore_OrganicAutoSuggest_0_7_na_na_pr&as-pos=0&as-type=RECENT&suggestionId=window+curtains%7Cin+Curtains&requestId=da63e601-8853-4074-b5c5-67795584061c&as-backfill=on";
                        try {
                            Intent i = new Intent("android.intent.action.MAIN");
                            i.setComponent(ComponentName.unflattenFromString("com.android.chrome/com.android.chrome.Main"));
                            i.addCategory("android.intent.category.LAUNCHER");
                            i.setData(Uri.parse(url));
                            startActivity(i);
                        }
                        catch(ActivityNotFoundException e) {
                            // Chrome is not installed
                            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(i);
                        }
                        windowcurtain.setVisibility(View.GONE);
                    }
                });
            }else if(selectedMain.get(i).equals("tv")){
                tv.setVisibility(View.VISIBLE);
                tvName.setText("tv");
                tvBuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String url = "https://www.flipkart.com/search?q=tv&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off";
                        try {
                            Intent i = new Intent("android.intent.action.MAIN");
                            i.setComponent(ComponentName.unflattenFromString("com.android.chrome/com.android.chrome.Main"));
                            i.addCategory("android.intent.category.LAUNCHER");
                            i.setData(Uri.parse(url));
                            startActivity(i);
                        }
                        catch(ActivityNotFoundException e) {
                            // Chrome is not installed
                            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(i);
                        }
                        tv.setVisibility(View.GONE);
                    }
                });
            }else if(selectedMain.get(i).equals("balloon")){
                balloon.setVisibility(View.VISIBLE);
                balloonName.setText("balloon");
                balloonBuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String url = "https://www.flipkart.com/search?q=balloon&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off";
                        try {
                            Intent i = new Intent("android.intent.action.MAIN");
                            i.setComponent(ComponentName.unflattenFromString("com.android.chrome/com.android.chrome.Main"));
                            i.addCategory("android.intent.category.LAUNCHER");
                            i.setData(Uri.parse(url));
                            startActivity(i);
                        }
                        catch(ActivityNotFoundException e) {
                            // Chrome is not installed
                            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(i);
                        }
                        balloon.setVisibility(View.GONE);
                    }
                });
            }else if(selectedMain.get(i).equals("christmas")){
                christmas.setVisibility(View.VISIBLE);
                christmasName.setText("christmas");
                christmasBuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String url = "https://www.flipkart.com/search?q=christmas+tree&sid=bro%2Ctez%2C8td&as=on&as-show=on&otracker=AS_QueryStore_OrganicAutoSuggest_0_3_na_na_pr&otracker1=AS_QueryStore_OrganicAutoSuggest_0_3_na_na_pr&as-pos=0&as-type=RECENT&suggestionId=christmas+tree%7Cin+Artificial+Christmas+Tree&requestId=2ce16ff5-ef8b-4424-b877-69124fcb385b&as-backfill=on";
                        try {
                            Intent i = new Intent("android.intent.action.MAIN");
                            i.setComponent(ComponentName.unflattenFromString("com.android.chrome/com.android.chrome.Main"));
                            i.addCategory("android.intent.category.LAUNCHER");
                            i.setData(Uri.parse(url));
                            startActivity(i);
                        }
                        catch(ActivityNotFoundException e) {
                            // Chrome is not installed
                            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(i);
                        }
                        christmas.setVisibility(View.GONE);
                    }
                });
            }else if(selectedMain.get(i).equals("chair")){
                chair.setVisibility(View.VISIBLE);
                chairName.setText("chair");
                chairBuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String url = "https://www.flipkart.com/search?q=office%20chair&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off";
                        try {
                            Intent i = new Intent("android.intent.action.MAIN");
                            i.setComponent(ComponentName.unflattenFromString("com.android.chrome/com.android.chrome.Main"));
                            i.addCategory("android.intent.category.LAUNCHER");
                            i.setData(Uri.parse(url));
                            startActivity(i);
                        }
                        catch(ActivityNotFoundException e) {
                            // Chrome is not installed
                            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(i);
                        }
                        chair.setVisibility(View.GONE);
                    }
                });
            }else if(selectedMain.get(i).equals("laptop")){
                laptop.setVisibility(View.VISIBLE);
                laptopName.setText("laptop");
                laptopBuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String url = "https://www.flipkart.com/search?q=laptops&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off";
                        try {
                            Intent i = new Intent("android.intent.action.MAIN");
                            i.setComponent(ComponentName.unflattenFromString("com.android.chrome/com.android.chrome.Main"));
                            i.addCategory("android.intent.category.LAUNCHER");
                            i.setData(Uri.parse(url));
                            startActivity(i);
                        }
                        catch(ActivityNotFoundException e) {
                            // Chrome is not installed
                            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(i);
                        }
                        laptop.setVisibility(View.GONE);
                    }
                });
            }else if(selectedMain.get(i).equals("desk")){
                desk.setVisibility(View.VISIBLE);
                deskName.setText("desk");
                deskBuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String url = "https://www.flipkart.com/search?q=office%20desks&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off";
                        try {
                            Intent i = new Intent("android.intent.action.MAIN");
                            i.setComponent(ComponentName.unflattenFromString("com.android.chrome/com.android.chrome.Main"));
                            i.addCategory("android.intent.category.LAUNCHER");
                            i.setData(Uri.parse(url));
                            startActivity(i);
                        }
                        catch(ActivityNotFoundException e) {
                            // Chrome is not installed
                            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(i);
                        }
                        desk.setVisibility(View.GONE);
                    }
                });
            }


        }
    }
}
